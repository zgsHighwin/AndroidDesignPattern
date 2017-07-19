package com.zgs.base;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zgs.R;
import com.zgs.commoninterface.OnItemClickListener;

import java.util.List;

/**
 * Created by zgsHighwin on 2017/7/11 0011.
 * <p>
 * Email zgshighwin@gmail.com
 * <p>
 * Description:
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ListHolder> {

    private List<BaseRecyclerItemBean> mList;

    public RecyclerAdapter(List<BaseRecyclerItemBean> list) {
        this.mList = list;

    }

    public List<BaseRecyclerItemBean> getList() {
        return mList;
    }

    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_base_recycler_card, parent, false);
        return new ListHolder(view);
    }

    @Override
    public void onBindViewHolder(ListHolder holder, int position) {
        holder.tv.setText(mList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public class ListHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv;

        public ListHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);
            tv.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(v, getAdapterPosition());
            }
        }
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

}
