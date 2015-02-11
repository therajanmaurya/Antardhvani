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

        String group_names[] = {"Special Plaza \n (Undergraduate research of Colleges)","International Plaza \nForeign Students Showcase their countries","University-Industry Interface","Sports Plaza","EOC Corner","Govt. of India Institutions","Skill Development Pavilion \n (NSDC,New Delhi)"
                ,"Gandhi Darshan","DU Heritage Walks And Archive Tour" , "DUWA-Delhi University Women's Association Stall","Teachers Training and Academic Orientation-CPDHE","Computerized Shooting Range-DUSC"};

        String country_names[] = { "This special area gathers various new initiatives at the University which have introduced a\n" +
                "project dimension to knowledge creation.\n" +
                "i. Recently 25 1 Innovation Projects in Colleges were awarded grants in 2013 and most\n" +
                "of them are enthusiastic about the start up. 1 13 Projects were successfully completed\n" +
                "in the previous round and are ready to show their ﬁndings\n" +
                "(contact Dr. Deepika Bhaskar /Innovation Desk; innovationsdu@gmail.com).\n" +
                " The Cluster Innovation Centre curriculum promotes projects and new thinking.\n" +
                "Offering three specially designed degree programmes this ﬂagship unit has opened\n" +
                "new horizons in the Humanities and the sciences (contact Dr. Sukrita Paul Kumar\n" +
                "(sukrita.paulkumar@gmail.com), Dr. Pankaj Tyagi (pankajtyagicicdu@gmail.com)\n" +
                "& Dr. Shobha Bagai_(shobhabagai@gmail.com)\n" +
                " The Institute of Life Long Learning has been creative in developing innovative\n" +
                "teaching material through the full time work of its Fellows. By now the dedicated\n" +
                "ILLL website carries several hundred lessons using that range over lectures, e-labs,\n" +
                "videos, theatre, panel discussions, ﬁlms and more. (Contact Dr. Amrit Kaur Basra;\n" +
                "amritdcac@gmail. com). Coordinator: Dr. DeepikaBhaskar.( )", "More than 1500 international students ﬁom about 65 diiferent countries are currently\n" +
                "enrolled in courses at the University of Delhi. The International Plaza will introduce the\n" +
                "culture and traditions of more than 20 countries from where they come, such as“\n" +
                "£l__t'g,lianistan, Armenia, China, Cambodia, Ethiopia, Eritrea, Japan, Indonesia, Iran,\n" +
                "Mauritius, Mongolia, Nepal, Nigeria, Russia, Sri Lanka, South Korea, Thailand, and Tibet.\n" +
                "There will be performances by several countries. Also:\n" +
                "Country Stalls: An Exhibition of souvenirs, art objects, culture and many more things.\n" +
                "Customs & traditions: to provide a platform for dialogue between various cultures.\n" +
                "A panorama of traditional dresses and their cultural signiﬁcance.\n" +
                "Fun Games, Music, Dance & Food:\n" +
                "Coordinators: Dr. Veena Mishra (dydean t'@du.ac.in);\n" +
                "Dr.Girish Munjal (girishmun|al2012@gmail.com)", "Entrepreneurship Plaza\n" +
                "This special interactive area will bring entrepreneurship leaders and students to a talking\n" +
                "space for exchange of information on Business Incubation guidance on opportunities,\n" +
                "schemes of the government, internship and training. It will show the steps taken at Delhi\n" +
                "Universitythrough its Technology Business Incubator (TBI), ANDC’s Entrepreneurship\n" +
                "Cell, CIC’s tie ups with PhD Chamber of Commerce and other such initiatives. The\n" +
                "objective is to inspire students to be job creators, not always job seekers.\n" +
                "Coordinator: Prof. JM Khurana, Dean Students Welfare (|'mkhurana1@1ahoo.eo.in)", "Adventure Sports: An Introduction to Mountaineering.\n" +
                "Linked to the NCC programme at DU, focus on mountaineering will bring attention to\n" +
                "ﬁtness and training. A climbing wall is to be installed at Antardhvani for demonstration\n" +
                "and instruction. Alongside, information on adventure sports will be available through\n" +
                "pamphlets, ﬁlms, photos, videos and ﬁlms. Coordinated by DU students who have\n" +
                "outstanding achievements in mountaineering, the stall will encourage interaction to\n" +
                "understand the physical and psychological advantages of such sports.\n" +
                "Coordinator: NCC in charge Lt Parminder Sehgal  ,\n" +
                "Student Akash Jindal (akash Q dal7Q1ahoo.eom)",
                "Equal Opportunity Cell\n" +
                        "The participation of students in co-curricular and extra co- curricular activities at any stage\n" +
                        "of their education helps them to foster their personality and self-conﬁdence. The Equal\n" +
                        "Oppoﬂunity Cell encourages students with disabilities pursuing various courses to\n" +
                        "showcase their abilities in various activities such as Solo & Group Song and Dance,\n" +
                        "Instrumental Performance, Poetry Recitation and Plays etc. which ensure their inclusion in\n" +
                        "“Antardhvani” The EOC will also put up a stall to display its activities with a view to\n" +
                        "sensitize and create awareness about the potential of students with disabilities. The EOC\n" +
                        "launched study tours abroadunder the Excellence in Education scheme and students visited\n" +
                        "London, Edinburgh and South Korea during the year. Special attraction is a stall\n" +
                        "demonstrating efﬁcient assistive devices for visually impaired youth.\n" +
                        "Coordinators: Prof. _Usha Rao.Dr. Bipin Tiwary (lggp inkumartiwari@rediﬂ'mail.com),\n" +
                        "Dr. Anil Aneja (osd@eoc.du.ac.in)", "Govt of India Institutions\n" +
                "Will present their material at Antardhvani: Gandhi Bhawan. National Book Trust, Indira\n" +
                "Gandhi National Centre for the Arts, Khadi Gramodvog. Sahitya Akademi.\n" +
                "In addition, stalls for horticultural goods and some handicrafts are presented through the\n" +
                "Garden Committee and NSS.\n" +
                "Coordinator: Dr. Nisha Tyagi, (drnisha§1agi@hotmaiI.com)\n" +
                "Dr. Aarati Saxena (aaratisaxena@gmail.com)", "No Data Available", "No Data Available", "Heritage Walk & Delhi University Archive Tour\n" +
                "The Heritage Walk beckons visitors to experience the history of the University of Delhi\n" +
                "through the Archive located in three ﬂoors of the Viceregal Lodge. While the building as a\n" +
                "whole is an Archive, visits at speciﬁed halting points gives an opportunity to understand the\n" +
                "past and present through written records, artefacts and visual representation There are rare\n" +
                "photographs of the Uprising of 1857, a narrative of Delhi University’s inception and\n" +
                "growth, anda moving view of Shaheed Bhagat Singh’s jail cell. The extended tour can take\n" +
                "visitors to sites located on the Northern Ridge where rebels and the British soldiers had\n" +
                "fought for the retention of Shahaj ahanabad Guided tours, starting from the back gate of the\n" +
                "Viceregal Lodge canbe booked at Antardhvani. Tour Timings are 1 1 am to lpm and from 3\n" +
                "pm to 4.30 pm.\n" +
                "Coordinator: Dr. Amrit Kaur Basra (amritdcac@gmail.com)",
                "Delhi University Women's Association (DUWA)\n" +
                        "(DUWA)wi1l have its food stall with cakes and cookies, Indian cuisine and snacks. DUWA\n" +
                        "is a historic institution at the University ofDe1hi, having been established by pr; Durgabai\n" +
                        "Deshmukh and being registered in 1964.\n" +
                        "Coordinator: to be appointed by President, DUWA", "Teacher training and Academic Orientation:\n" +
                "The Centre for Professional Development in Higher Education (CPDI-IE) takes the lead\n" +
                "role in teacher training and evolving new pedagogical practice. With the introduction of the\n" +
                "four year undergraduate programme, CPDHE launched a major cycle in training teachers in\n" +
                "the interactive pedagogy of the ‘ﬂipped’ classroom. The learning is from student\n" +
                "presentations andprojects, with the teacher being a guide and mentor. To date more than\n" +
                "1500 teachers have participated in the orientation courses for the Foundation Courses.\n" +
                "Coordinator: Qg._ Vijaya Laxmi Singh; (ddvijayaIaxmisingh@gmail.com)", "No Data Available", "Costa Rica", "Uruguay",
                "Italy", "England", "France", "Switzerland", "Ecuador",
                "Honduras", "Agrentina", "Nigeria", "Bosnia and Herzegovina",
                "Iran", "Germany", "United States", "Portugal", "Ghana" };


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


