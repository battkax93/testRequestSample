package sunny.testrequestsample.fragment.firstfragmet;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.ArrayList;

import sunny.testrequestsample.R;
import sunny.testrequestsample.data.model.Item;

public class FirstFragment extends Fragment implements contractFirstFragment.mainView {

    xAdapter xAdapter;
    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefreshLayout;
    FloatingActionButton fbButton;
    ProgressBar pBar;
    contractFirstFragment.presenter presenter;
    Boolean isrefreshing = false;


    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View firstfragment = inflater.inflate(R.layout.fragment_first, container, false);
        init(firstfragment, this);
        initRV();

        return firstfragment;
    }

    private void init(View view, final Fragment frag) {
        recyclerView = view.findViewById(R.id.rv_answers);
        pBar = view.findViewById(R.id.progressBar);
        swipeRefreshLayout = view.findViewById(R.id.swiperefresh);
        fbButton = view.findViewById(R.id.fab_button);

        presenter = new presentFirstFragment(this);
        xAdapter = new xAdapter(getContext(), new ArrayList<Item>(0));

        fbButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProgress();
                presenter.onRefresh(getContext(),xAdapter,"desc","activity","stackoverflow");
            }
        });
    }

    private void initRV(){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(xAdapter);
        recyclerView.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
    }

    @Override
    public void showProgress() {
        pBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        pBar.setVisibility(View.GONE);
    }
}
