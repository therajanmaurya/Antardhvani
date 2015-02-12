package antardhvani.du.ac.in.antardhvani;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by lusifer on 13/1/15.
 */
public class ScreenSlidePageFragment extends Fragment {
    public static final String ARG_PAGE = "page";
    private int mPageNumber;

    public static ScreenSlidePageFragment create(int pageNumber) {
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
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
                new_image = getResources().getDrawable(R.drawable.slider_1_bg);
                break;
            case 1:
                new_image = getResources().getDrawable(R.drawable.slider_2_bg);
                break;
            case 2:
                new_image = getResources().getDrawable(R.drawable.slider_3_bg);
                break;
            default:
                new_image = getResources().getDrawable(R.drawable.slider_1_bg);
                break;
        }

        image.setBackgroundDrawable(new_image);


        return rootView;
    }

    public int getPageNumber() {
        return mPageNumber;
    }

}