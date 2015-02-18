package antardhvani.du.ac.in.Adapter;

/**
 * Created by lusifer on 18/2/15.
 */

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import antardhvani.du.ac.in.antardhvani.R;


public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    private ArrayList<String> Title,Subtitle;
    private Context context;
    private LayoutInflater mInflater;

    public CardAdapter( Context context, ArrayList<String> couponList,ArrayList<String> subTitle) {
        this.Title = couponList;
        this.Subtitle=subTitle;
        this.context = context;
        mInflater = LayoutInflater.from(context);
    }



    // Create new views (invoked by the layout manager)
    @Override
    public CardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        // create a new view
        CardView view = (CardView) LayoutInflater.from(context)
                .inflate(R.layout.view_card, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

            String ne = Title.get(Title.size()-position-1);
            holder.title.setText(ne);
            String ne1=Subtitle.get(Subtitle.size()-position-1);
//            String[] x=ne1.split("#");
//            String ne2="";
//            for(int i=0;i<x.length;i++){
//                ne2+=x[i]+"\n";
//            }
            holder.subtitle.setText(ne1);


    }

    @Override
    public int getItemCount() {
        return Title.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView title;
        public TextView subtitle;

        public CardView root;

        public ViewHolder(CardView view) {
            super(view);
            root = view;
            title = (TextView) view.findViewById(R.id.tvTitle);
            subtitle = (TextView) view.findViewById(R.id.tvSubTitle);

        }
    }

}
