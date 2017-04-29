package com.androidtutorialshub.loginregister.adapters;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidtutorialshub.loginregister.R;
import com.androidtutorialshub.loginregister.model.Member;

import java.util.List;

/**
 * Created by lalit on 10/10/2016.
 */

public class MembersRecyclerAdapter extends RecyclerView.Adapter<MembersRecyclerAdapter.MemberViewHolder> {

    private List<Member> listMembers;

    public MembersRecyclerAdapter(List<Member> listMembers) {
        this.listMembers = listMembers;
    }

    @Override
    public MemberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflating recycler item view
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_member_recycler, parent, false);
        Log.v(MembersRecyclerAdapter.class.getSimpleName(),""+listMembers.size());
        return new MemberViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MemberViewHolder holder, int position) {
        holder.textViewName.setText(listMembers.get(position).getName());
        holder.textViewEmail.setText(listMembers.get(position).getEmail());
        holder.textViewMemID.setText(Integer.toString((listMembers.get(position).getMemId())));
        holder.textViewAccessLevel.setText(listMembers.get(position).getAccessLevel());
        holder.textViewPhone.setText(listMembers.get(position).getPhoneNo());
        holder.textViewDept.setText(listMembers.get(position).getDept());
    }

    @Override
    public int getItemCount() {
        Log.v(MembersRecyclerAdapter.class.getSimpleName(),""+listMembers.size());
        return listMembers.size();
    }


    /**
     * ViewHolder class
     */
    public class MemberViewHolder extends RecyclerView.ViewHolder {

        public AppCompatTextView textViewMemID;
        public AppCompatTextView textViewName;
        public AppCompatTextView textViewEmail;
        public AppCompatTextView textViewPhone;
        public AppCompatTextView textViewAccessLevel;
        public AppCompatTextView textViewDept;




        public MemberViewHolder(View view) {
            super(view);
            Log.v(MembersRecyclerAdapter.class.getSimpleName(),""+listMembers.size());
            textViewMemID= (AppCompatTextView) view.findViewById(R.id.textViewMemID2);
            Log.d("bsh","memiD");
            textViewName = (AppCompatTextView) view.findViewById(R.id.textViewName2);
            Log.d("bsh","name");
            textViewEmail = (AppCompatTextView) view.findViewById(R.id.textViewEmail2);
            Log.d("bsh","email");
            textViewPhone = (AppCompatTextView) view.findViewById(R.id.textViewMobile2);
            Log.d("bsh","mobile");
            textViewAccessLevel = (AppCompatTextView) view.findViewById(R.id.textViewAccessLevel2);
            Log.d("bsh","access_level");
            textViewDept = (AppCompatTextView) view.findViewById(R.id.textViewDept2);
            Log.d("bsh","dept");
        }
    }


}
