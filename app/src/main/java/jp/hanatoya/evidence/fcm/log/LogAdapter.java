package jp.hanatoya.evidence.fcm.log;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.hanatoya.evidence.fcm.R;
import jp.hanatoya.evidence.fcm.repo.Notice;
import jp.hanatoya.evidence.fcm.util.MyStringUtils;


public class LogAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    private ArrayList<Notice> notices = new ArrayList<>();
    @NonNull private Context context;
    @NonNull private LogFragment.LogListener listener;


    public LogAdapter(Context context, LogFragment.LogListener listener) {
        this.context = context;
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_log, parent, false);
        return new NoticeViewHolder(convertView);    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof NoticeViewHolder){
            NoticeViewHolder h = (NoticeViewHolder)holder;
            Notice n = notices.get(position);
            h.message.setText(n.getMessage());
            h.date.setText(MyStringUtils.getDate(n.getTs()));
        }
    }

    @Override
    public int getItemCount() {
        return notices.size();
    }


    static class NoticeViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.message) TextView message;
        @BindView(R.id.date) TextView date;
        @BindView(R.id.root) LinearLayout root;

        public NoticeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void swap(List<Notice> notices){
        this.notices.clear();
        this.notices.addAll(notices);
        notifyDataSetChanged();

    }
}
