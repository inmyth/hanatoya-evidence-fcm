package jp.hanatoya.evidence.fcm.log;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.hanatoya.evidence.fcm.R;
import jp.hanatoya.evidence.fcm.login.LoginContract;
import jp.hanatoya.evidence.fcm.repo.Notice;

public class LogFragment extends Fragment implements LogContract.View{


    private LogPresenter presenter;
    private LogAdapter adapter;

    @BindView(android.R.id.list) RecyclerView list;


    public static LogFragment newInstance() {
        Bundle args = new Bundle();
        LogFragment fragment = new LogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new LogAdapter(getActivity(), new LogListener() {
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_log, container, false);
        ButterKnife.bind(this, view);
        list.setLayoutManager(new LinearLayoutManager(getActivity()));
        list.setAdapter(adapter);
        list.addItemDecoration(new HorizontalDividerItemDecoration.Builder(getActivity()).build());
        presenter.refreshList();
        return view;
    }

    @Override
    public void setPresenter(LogContract.Presenter presenter) {
        this.presenter = (LogPresenter)presenter;
    }

    @Override
    public void refreshList(List<Notice> noticeList) {
        adapter.swap(noticeList);
    }


    interface LogListener {



    }
}
