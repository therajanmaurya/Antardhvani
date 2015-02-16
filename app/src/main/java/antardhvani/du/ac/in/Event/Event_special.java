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
        String group_names[] = getResources().getStringArray(R.array.specialHeads);
        String country_names[] = getResources().getStringArray(R.array.special);
        /*String group_names[] = {"University of Delhi\nMeeting the challenges of India\n(Showcasing good practices)", "Food Courts", "DU Souvenir shop\nHaathi mera saathi", "Adventure sports\nAn introduction to mountaineering", "Gyanodaya Express\nDU's colleges on wheels", "Community Radio Stall", "Fiendly Kabaddi and Kho Kho match"
                , "NSS\n National Service Scheme", "NCC Parade", "Institute of Life Long Learning", "CIC\nCluster Innovation Centre"};

        String country_names[] = {"No data available",

                "Food Courts at Antardhvani will be positioned at THREE locations. It is proposed that one " +
                        "multi cuisine outlet with a seating area will be serviced by Indian Railway Catering and " +
                        "Tourism Corporation (IRCTC) who are the caterers for Delhi University’s regular cafeteria." +
                        "It ofl'ers a simple snack to a full meal, and will be presenting a large variety over the festival " +
                        "days: Indian popular food, regional meals, Italian pizza and pasta, Chinese items," +
                        "sandwiches and burgers and much more.. A Second court will specialize in Dilli Ka Khana " +
                        "Delhi’s famed street food, and a third venue will offer Indian quick foods, meals on a " +
                        "platter. Tea, coffee and beverages are available at all food courts and all items will be " +
                        "moderately priced. " +
                        "\n" +
                        "\nCoordinators: Prof. Mridula Gupta (mridula_du@yahoo.com)" +
                        "\n              Lt.Parminder Sehgal(parmindersehgal@gmail.com)"


                , "The elephant in DU’s logo will join the festivities and greet Antardhvani visitors. " +
                "Caparisoned to catch the mood, he will be ready to give rides and a grand salute. " +
                "Antardhvani mascot Haathi will be found in the souvenir stall. Specially designed items, " +
                "andDU brandedgoods will be displayedand sold at this stall. Look out for Antardhvani " +
                "mascot elephant. Tee shirts and caps, mugs with photos, stationary, table clocks and other " +
                "items, all with the famous logo of the DU elephant. These introductory items are " +
                "moderately priced to encourage popular use. " +
                "\n" +
                "\nCoordinator: University Information Centre"


                , "Linked to the NCC programme at DU, focus on mountaineering will bring attention to " +
                "fitness and training. A climbing wall is to be installed at Antardhvani for demonstration " +
                "and instruction. Alongside, information on adventure sports will be available through " +
                "pamphlets, films, photos, videos and films. Coordinated by DU students who have " +
                "outstanding achievements in mountaineering, the stall will encourage interaction to " +
                "understand the physical and psychological advantages of such sports. " +
                "\n" +
                "\nCoordinator: NCC in charge Lt Parminder Sehgal(parmindersehgal@gmail.com) , " +
                "\n             Student Akash Jindal (akash_jindal@yahoo.com)"


                , "No data available"

                , "Do you want to be on Air? Don't worry, DUCR 90.4 MHz will make you audible to everyone at Antardhwani-2015. The center of attraction will be ' R.J. Hunt ' and ' DUCR IDOL-2015 '. Hey, there is an anchor inside you!!!\n\n     Listen your voice. Be loud, be aloud and be audible. DUCR IDOL-2015 will provide you opportunity to record your Dialogues/song/poetry in your own voice. Get a chance to visit to Delhi University Community Radio. Prepare, Participate and Present you will be dully rewarded. For more information visit http://ducr.du.ac.in/"+
                "\n\nCoordinator: R.K. Singh(9891138542,ducr90.4@gmail.com) "+
                "\n Contact us 011-27662334,27662336"
                , "Organized by the Sports Council, this is a 10 X 10 over match, a fiiendly encounter slated " +
                "to bring to the field the hidden talent among administrators, teachers and nonteaching staffi " +
                "The team led by the Vice Chancellor, will play the Principals’ team. Food and sofl drinks " +
                "will be available in plenty, so will good cheer and encouragement from the stands. Look " +
                "out for the stars, the men and women of the match! Special prizes. " +
                "\n" +
                "\nCoordinator: Registrar’s office"


                , "NSS of the Govt. of India started in 1969. Its motto is \"Not Me, Not You but We”. NSS will " +
                "present its current activities and awareness raising programme at Antardhvani. " +
                "\n" +
                "\nCoordinator: Dr. Aarati Saxena, (aaratisaxena@gmail.com)"


                , "NCC is a Tri-Services Organisation comprising the Army, Navy and Air Force, engaged in " +
                "grooming the youth as ‘The Leaders of Tomorrow‘. After independence the present day " +
                "NCC, under the Ministry of Defence, came into existence on 16 April 1948. The NCC at " +
                "the University of Delhi has contingents in several colleges, and has regular training for " +
                "students. Antardhvani begins with a NCC parade which gives its Salute to the Chief Guest " +
                "and marches through the stadium area of the campus. Students also display skills in combat, " +
                "first aid, disaster management, firefighting and other forms of civic assistance. NCC and " +
                "College volunteers will be ensuring law and order at Antardhvani. " +
                "Coordinator: Lt. Panninder Sehgal (parmindersehgal3@gail.com)"


                , "The Institute of Life Long Learning has been creative in developing innovative " +
                "teaching material through the full time work of its Fellows. By now the dedicated " +
                "ILLL website carries several hundred lessons using that range over lectures, e-labs, " +
                "videos, theatre, panel discussions, films and more. (Contact Dr. Amrit Kaur Basra; " +
                "amritdcac@gmail. com). \n\nCoordinator: Dr. DeepikaBhaskar.(biodeepika@gmail.com )"

                , "No Data Available"};

*/
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


