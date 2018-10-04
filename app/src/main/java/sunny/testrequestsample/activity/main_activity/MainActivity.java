package sunny.testrequestsample.activity.main_activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import sunny.testrequestsample.R;
import sunny.testrequestsample.ViewPagerAdapter;
import sunny.testrequestsample.fragment.firstfragmet.FirstFragment;
import sunny.testrequestsample.fragment.secondfragment.SecondFragment;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    FirstFragment firstFragment;
    SecondFragment secondFragment;

    String[] tabTittle = {"FIRST","SECOND"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);

        setupViewPager();
        tabLayout.setupWithViewPager(viewPager);
        trySetTab(viewPager);

    }

    private void setupViewPager(){
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();
        adapter.addFragment(firstFragment,"tes 1");
        adapter.addFragment(secondFragment, "tes 2");
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(adapter);
    }

    private View prepareTabView(int position){
        View view = getLayoutInflater().inflate(R.layout.custom_tab,null);
        TextView tvTitle = view.findViewById(R.id.tv_title);
        tvTitle.setText(tabTittle[position]);
        return view;
    }

    private void setupTabIcon(){
        for(int i = 0; i < tabTittle.length; i++){
            tabLayout.getTabAt(i).setCustomView(prepareTabView(i));
        }
    }

    private void trySetTab(final ViewPager vp){
        try{
            setupTabIcon();
        } catch (Exception e){
            e.printStackTrace();
        }

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                vp.setCurrentItem(position,false);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
