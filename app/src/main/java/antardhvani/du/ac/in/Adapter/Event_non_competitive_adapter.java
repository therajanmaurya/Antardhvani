package antardhvani.du.ac.in.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import antardhvani.du.ac.in.antardhvani.R;

/**
 * Created by rajanmaurya on 10/2/15.
 */
public class Event_non_competitive_adapter extends BaseExpandableListAdapter {
    private Context context;

    static String[] non_com;
    static String[][] non_com1;
    protected LayoutInflater inflater = null;
    //static int[] image = {R.drawable.sample_0,R.drawable.sample_1,R.drawable.sample_2,R.drawable.sample_3};
    static String []parentlist = {"Products","ViewPDF","TODO List","Contacts"};
    static String [][]childlist = {{"Products lists \n 1. Books \n 2. Copy \n 3.Table", "Books","Copy"},{"ViewPDF list \n 1.Adobe Reader \n 2. PDF Reader \n 3.All PDF"},{"TODO list"},{"Contacts list"}};
    public Event_non_competitive_adapter(Context context) {
        // TODO Auto-generated constructor stub
        this.context = context;

    }

    public Event_non_competitive_adapter(Context context, String[] non_competitive, String[][] non_competitive1) {
        this.context = context;
        non_com = non_competitive;
        non_com1 = non_competitive1;
    }

    @Override
    public int getGroupCount() {
        // TODO Auto-generated method stub
        return non_com.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        // TODO Auto-generated method stub
        return non_com1[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        // TODO Auto-generated method stub
        return groupPosition;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        // TODO Auto-generated method stub

        return 0;
    }

    @Override
    public long getGroupId(int groupPosition) {
        // TODO Auto-generated method stub
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        // TODO Auto-generated method stub
        return false;
    }



    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.googlecardadapter, null);
            TextView tv = (TextView) convertView.findViewById(R.id.activity_googlecards_card_textview);
            tv.setText(non_com[groupPosition]);
        }
         ;

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.expand, null);
        }

        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.activity_googlecards_card_imageview);
        txtListChild.setText(non_com1[groupPosition][childPosition]);


        return convertView;

    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        // TODO Auto-generated method stub
        return true ;
    }

}