package antardhvani.du.ac.in.Adapter;


import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import antardhvani.du.ac.in.antardhvani.R;


@SuppressLint("ResourceAsColor")
public class Googlecard_Adapter extends ArrayAdapter<Integer> {


    public Context mContext;

    ArrayList<String> Ldesc = new ArrayList<String>();


    public Googlecard_Adapter(Context context, int in, ArrayList<String> contactList2) {
        super(context, in);
        mContext = context;
        Ldesc = contactList2;

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
        return Ldesc.size();
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
            view.setTag(viewHolder);


        } else {
            viewHolder = (ViewHolder) view.getTag();
        }


        viewHolder.textView.setText(Ldesc.get(position));

        return view;
    }

    @SuppressWarnings({})
    private static class ViewHolder {
        TextView textView;
        TextView imageView;
    }


}