package antardhvani.du.ac.in.Event;

/**
 * Created by rajanmaurya on 11/2/15.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;

import antardhvani.du.ac.in.Adapter.Child;
import antardhvani.du.ac.in.Adapter.Event_special_adapter;
import antardhvani.du.ac.in.Adapter.Group;
import antardhvani.du.ac.in.antardhvani.R;

public class Event_special extends Fragment {
    private Event_special_adapter ExpAdapter;
    private ArrayList<Group> ExpListItems;
    private ExpandableListView ExpandList;

    public static Event_special getInstance(int position) {
        Event_special myFragment = new Event_special();
        Bundle args = new Bundle();
        args.putInt("position", position);
        myFragment.setArguments(args);
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.expentable, container, false);

        ExpandList = (ExpandableListView) layout.findViewById(R.id.activity_googlecards_listview);
        ExpListItems = SetStandardGroups();
        ExpAdapter = new Event_special_adapter(getActivity(), ExpListItems);
        ExpandList.setAdapter(ExpAdapter);

        return layout;

    }


    public ArrayList<Group> SetStandardGroups() {

        String group_names[] = {"University of Delhi \n Meeting the challenges of India (Showcasing good practices)", "Food Courts", "DU Souvenir shop \n Haathi mera saathi", "Adventure sports \n An introduction to mountaineering", "Gyanodaya Express \n DU's colleges on wheels", "Community Radio Stall", "Fiendly Kabaddi and Kho Kho match"
                , "NSS \n National Service Scheme", "NCC Parade", "Institute of Life Long Learning", "CIC \n Cluster Innovation Centre"};

        String country_names[] = {"No data available",

                "Food Courts at Antardhvani will be positioned at THREE locations. It is proposed that one\n" +
                        "multi cuisine outlet with a seating area will be serviced by Indian Railway Catering and\n" +
                        "Tourism Corporation (IRCTC) who are the caterers for Delhi University’s regular cafeteria.\n" +
                        "It ofl'ers a simple snack to a full meal, and will be presenting a large variety over the festival\n" +
                        "days: Indian popular food, regional meals, Italian pizza and pasta, Chinese items,\n" +
                        "sandwiches and burgers and much more.. A Second court will specialize in Dilli Ka Khana\n" +
                        "Delhi’s famed street food, and a third venue will offer Indian quick foods, meals on a\n" +
                        "platter. Tea, coffee and beverages are available at all food courts and all items will be\n" +
                        "moderately priced.\n" +
                        "Coordinators: Prof. Mridula Gupta (mridula du@yahoo.com)"


                , "The elephant in DU’s logo will join the festivities and greet Antardhvani visitors.\n" +
                "Caparisoned to catch the mood, he will be ready to give rides and a grand salute.\n" +
                "Antardhvani mascot Haathi will be found in the souvenir stall. Specially designed items,\n" +
                "andDU brandedgoods will be displayedand sold at this stall. Look out for Antardhvani\n" +
                "mascot elephant. Tee shirts and caps, mugs with photos, stationary, table clocks and other\n" +
                "items, all with the famous logo of the DU elephant. These introductory items are\n" +
                "moderately priced to encourage popular use.\n" +
                "Coordinator: University Information Centre"


                , "Linked to the NCC programme at DU, focus on mountaineering will bring attention to\n" +
                "fitness and training. A climbing wall is to be installed at Antardhvani for demonstration\n" +
                "and instruction. Alongside, information on adventure sports will be available through\n" +
                "pamphlets, films, photos, videos and films. Coordinated by DU students who have\n" +
                "outstanding achievements in mountaineering, the stall will encourage interaction to\n" +
                "understand the physical and psychological advantages of such sports.\n" +
                "Coordinator: NCC in charge Lt Parminder Sehgal ,\n" +
                "Student Akash Jindal (akash Q dal7Q1ahoo.eom)"


                , "No data available"

                , "No data available"
                , "Organized by the Sports Council, this is a 10 X 10 over match, a fiiendly encounter slated\n" +
                "to bring to the field the hidden talent among administrators, teachers and nonteaching staffi\n" +
                "The team led by the Vice Chancellor, will play the Principals’ team. Food and sofl drinks\n" +
                "will be available in plenty, so will good cheer and encouragement from the stands. Look\n" +
                "out for the stars, the men and women of the match! Special prizes.\n" +
                "Coordinator: Registrar’s office"


                , "NSS of the Govt. of India started in 1969. Its motto is \"Not Me, Not You but We”. NSS will\n" +
                "present its current activities and awareness raising programme at Antardhvani.\n" +
                "Coordinator: Dr. Aaratl Saxena, (aaratisaxena@gEll.oom)"


                , "NCC is a Tri-Services Organisation comprising the Army, Navy and Air Force, engaged in\n" +
                "grooming the youth as ‘The Leaders of Tomorrow‘. After independence the present day\n" +
                "NCC, under the Ministry of Defence, came into existence on 16 April 1948. The NCC at\n" +
                "the University of Delhi has contingents in several colleges, and has regular training for\n" +
                "students. Antardhvani begins with a NCC parade which gives its Salute to the Chief Guest\n" +
                "and marches through the stadium area of the campus. Students also display skills in combat,\n" +
                "first aid, disaster management, firefighting and other forms of civic assistance. NCC and\n" +
                "College volunteers will be ensuring law and order at Antardhvani.\n" +
                "Coordinator: Lt. Panninder Sehgal (Erminde§hgg3@gail.com)"


                , "The Institute of Life Long Learning has been creative in developing innovative\n" +
                "teaching material through the full time work of its Fellows. By now the dedicated\n" +
                "ILLL website carries several hundred lessons using that range over lectures, e-labs,\n" +
                "videos, theatre, panel discussions, films and more. (Contact Dr. Amrit Kaur Basra;\n" +
                "amritdcac@gmail. com). Coordinator: Dr. DeepikaBhaskar.( )"

                , "No Data Available"};


        ArrayList<Group> list = new ArrayList<Group>();

        ArrayList<Child> ch_list;

        int size = 1;
        int j = 0;

        for (String group_name : group_names) {
            Group gru = new Group();
            gru.setName(group_name);

            ch_list = new ArrayList<Child>();
            for (; j < size; j++) {
                Child ch = new Child();
                ch.setName(country_names[j]);
                ch_list.add(ch);
            }
            gru.setItems(ch_list);
            list.add(gru);

            size = size + 1;
        }

        return list;
    }

}


