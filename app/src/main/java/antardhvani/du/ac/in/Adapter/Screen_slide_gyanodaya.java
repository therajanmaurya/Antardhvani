package antardhvani.du.ac.in.Adapter;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import antardhvani.du.ac.in.antardhvani.R;

/**
 * Created by rajanmaurya on 16/2/15.
 */
public class Screen_slide_gyanodaya extends Fragment {
    public static final String ARG_PAGE = "page";
    private int mPageNumber;

    public static Screen_slide_gyanodaya create(int pageNumber) {
        Screen_slide_gyanodaya fragment = new Screen_slide_gyanodaya();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPageNumber = getArguments().getInt(ARG_PAGE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_screen_slide_page, container, false);
        Drawable new_image;
        ImageView image = (ImageView) rootView.findViewById(R.id.imageView3);
        switch (mPageNumber) {
            case 0:
                new_image = getResources().getDrawable(R.drawable.gyanodaya1);
                break;
            case 1:
                new_image = getResources().getDrawable(R.drawable.gyanodaya2);
                break;
            case 2:
                new_image = getResources().getDrawable(R.drawable.gyanodaya3);
                break;
            case 3:
                new_image = getResources().getDrawable(R.drawable.gyanodaya4);
                break;
            case 4:
                new_image = getResources().getDrawable(R.drawable.gyanodaya5);
                break;
            default:
                new_image = getResources().getDrawable(R.drawable.gyanodaya1);
                break;
        }

        image.setBackgroundDrawable(new_image);


        return rootView;
    }

    public int getPageNumber() {
        return mPageNumber;
    }

}