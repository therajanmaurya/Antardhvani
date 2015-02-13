package antardhvani.du.ac.in.About;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import antardhvani.du.ac.in.antardhvani.R;

/**
 * Created by rajanmaurya on 13/2/15.
 */
public class About extends Fragment {

    TextView of, ch,ch2, sa,sa2, gs,gs2, team, dapsr, ra, ra2, dk,dk2, pa1pal, pa1pal2, ak, ak2, sagar,sagar2, mail;

    public static About getInstance(int position) {
        About myFragment = new About();
        Bundle args = new Bundle();
        args.putInt("position", position);
        myFragment.setArguments(args);
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.about, container, false);


        of = (TextView) layout.findViewById(R.id.official);
        ch = (TextView) layout.findViewById(R.id.ch);
        ch2 = (TextView) layout.findViewById(R.id.ch2);
        sa = (TextView) layout.findViewById(R.id.sa);
        sa2 = (TextView) layout.findViewById(R.id.sa2);
        gs = (TextView) layout.findViewById(R.id.gs);
        gs2 = (TextView) layout.findViewById(R.id.gs2);
        team = (TextView) layout.findViewById(R.id.team);
        dapsr = (TextView) layout.findViewById(R.id.dapsr);
        ra = (TextView) layout.findViewById(R.id.rajan);
        ra2 = (TextView) layout.findViewById(R.id.rajan2);
        dk = (TextView) layout.findViewById(R.id.dk);
        dk2 = (TextView) layout.findViewById(R.id.dk2);
        pa1pal = (TextView) layout.findViewById(R.id.pa1pal);
        pa1pal2 = (TextView) layout.findViewById(R.id.pa1pal2);
        ak = (TextView) layout.findViewById(R.id.ak);
        ak2 = (TextView) layout.findViewById(R.id.ak2);
        sagar = (TextView) layout.findViewById(R.id.sagar);
        sagar2 = (TextView) layout.findViewById(R.id.sagar2);
        mail = (TextView) layout.findViewById(R.id.mail);


        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Sofia-Regular.otf");
        Typeface font2 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/anu.ttf");
        Typeface font3 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/3Dumb.ttf");
        Typeface font4 = Typeface.createFromAsset(getActivity().getAssets(), "fonts/D Day Stencil.ttf");

        of.setTypeface(font3);
        team.setTypeface(font3);

        ch.setTypeface(font2);
        ch2.setTypeface(font);

        sa.setTypeface(font2);
        sa2.setTypeface(font);

        gs.setTypeface(font2);
        gs2.setTypeface(font);

        ra.setTypeface(font2);
        ra2.setTypeface(font);

        dk.setTypeface(font2);
        dk2.setTypeface(font);

        pa1pal.setTypeface(font2);
        pa1pal2.setTypeface(font);

        ak.setTypeface(font2);
        ak2.setTypeface(font);

        sagar.setTypeface(font2);
        sagar2.setTypeface(font);

        mail.setTypeface(font3);






        return layout;

    }


}