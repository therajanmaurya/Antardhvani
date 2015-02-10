package antardhvani.du.ac.in.Adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import antardhvani.du.ac.in.Event.Event_non_competitive;
import antardhvani.du.ac.in.antardhvani.R;


@SuppressLint("ResourceAsColor")
public class Googlecard_Adapter extends ArrayAdapter<Integer> {


    public Context mContext , context;

    String [] list = null;
    String [] list1 = null;




    public Googlecard_Adapter(Context context, int resource, String[] eventHead, String[] non_competitive1) {
        super(context, resource );
        mContext = context;
        list = eventHead;
        list1 = non_competitive1;

    }




    @Override
    public Integer getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }


    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.length ;
    }

    @Override
    public View getView(final int position, final View convertView,
                        final ViewGroup parent) {
        final ViewHolder viewHolder;

        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(
                    R.layout.googlecardadapter, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.textView = (TextView) view
                    .findViewById(R.id.activity_googlecards_card_textview);
            viewHolder.textview1 = (TextView) view
                    .findViewById(R.id.activity_googlecards_card_imageview);
            view.setTag(viewHolder);


        } else {
            viewHolder = (ViewHolder) view.getTag();
        }


        viewHolder.textView.setText(list[position]);

        viewHolder.textview1.setVisibility(View.GONE);



        return view;
    }

    @SuppressWarnings({})
    private static class ViewHolder {
        TextView textView ,textview1;
        TextView imageView;
    }


}