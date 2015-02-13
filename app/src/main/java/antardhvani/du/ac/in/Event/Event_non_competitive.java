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
import antardhvani.du.ac.in.Adapter.Event_non_competitive_adapter;
import antardhvani.du.ac.in.Adapter.Group;
import antardhvani.du.ac.in.antardhvani.R;

/**
 * Created by rajanmaurya on 11/2/15.
 */

/**
 * Created by Windows on 23-01-2015.
 */
public class Event_non_competitive extends Fragment {
    private Event_non_competitive_adapter ExpAdapter;
    private ArrayList<Group> ExpListItems;
    private ExpandableListView ExpandList;

    public static Event_competitive getInstance(int position) {
        Event_competitive myFragment = new Event_competitive();
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
        ExpAdapter = new Event_non_competitive_adapter(getActivity(), ExpListItems);
        ExpandList.setAdapter(ExpAdapter);

        return layout;

    }


    public ArrayList<Group> SetStandardGroups() {

        String group_names[] = {"Innovation Plaza   (Undergraduate research of Colleges)","International Plaza  Foreign Students Showcase their countries","University-Industry Interface","Sports Plaza","EOC Corner","Govt. of India Institutions","Skill Development Pavilion   (NSDC,New Delhi)"
                ,"Gandhi Darshan","DU Heritage Walks And Archive Tour" , "DUWA-Delhi University Women's Association Stall","Teachers Training and Academic Orientation-CPDHE","Computerized Shooting Range-DUSC"};

        String country_names[] = { "This special area gathers various new initiatives at the University which have introduced a  project dimension to knowledge creation i. Recently 25 1 Innovation Projects in Colleges were awarded grants in 2013 and most of them are enthusiastic about the start up. 1 13 Projects were successfully completed in the previous round and are ready to show their ﬁndings (contact Dr. Deepika Bhaskar /Innovation Desk; innovationsdu@gmail.com)  The Cluster Innovation Centre curriculum promotes projects and new thinking. Offering three specially designed degree programmes this ﬂagship unit has opened new horizons in the Humanities and the sciences (contact Dr. Sukrita Paul Kumar (sukrita.paulkumar@gmail.com), Dr. Pankaj Tyagi (pankajtyagicicdu@gmail.com) & Dr. Shobha Bagai_(shobhabagai@gmail.com) The Institute of Life Long Learning has been creative in developing innovative teaching material through the full time work of its Fellows. By now the dedicated ILLL website carries several hundred lessons using that range over lectures, e-labs, videos, theatre, panel discussions, ﬁlms and more. (Contact Dr. Amrit Kaur Basra; amritdcac@gmail. com). Coordinator: Dr. DeepikaBhaskar.( )",
                "More than 1500 international students ﬁom about 65 diiferent countries are currently " +
                "enrolled in courses at the University of Delhi. The International Plaza will introduce the " +
                "culture and traditions of more than 20 countries from where they come, such as“ " +
                "£l__t'g,lianistan, Armenia, China, Cambodia, Ethiopia, Eritrea, Japan, Indonesia, Iran, " +
                "Mauritius, Mongolia, Nepal, Nigeria, Russia, Sri Lanka, South Korea, Thailand, and Tibet. " +
                "There will be performances by several countries. Also: " +
                "Country Stalls: An Exhibition of souvenirs, art objects, culture and many more things. " +
                "Customs & traditions: to provide a platform for dialogue between various cultures. " +
                "A panorama of traditional dresses and their cultural signiﬁcance. " +
                "Fun Games, Music, Dance & Food: " +
                "Coordinators: Dr. Veena Mishra (dydean t'@du.ac.in); " +
                "Dr.Girish Munjal (girishmun|al2012@gmail.com)", "Entrepreneurship Plaza " +
                "This special interactive area will bring entrepreneurship leaders and students to a talking " +
                "space for exchange of information on Business Incubation guidance on opportunities, " +
                "schemes of the government, internship and training. It will show the steps taken at Delhi " +
                "Universitythrough its Technology Business Incubator (TBI), ANDC’s Entrepreneurship " +
                "Cell, CIC’s tie ups with PhD Chamber of Commerce and other such initiatives. The " +
                "objective is to inspire students to be job creators, not always job seekers. " +
                "Coordinator: Prof. JM Khurana, Dean Students Welfare (|'mkhurana1@1ahoo.eo.in)", "Adventure Sports: An Introduction to Mountaineering. " +
                "Linked to the NCC programme at DU, focus on mountaineering will bring attention to " +
                "ﬁtness and training. A climbing wall is to be installed at Antardhvani for demonstration " +
                "and instruction. Alongside, information on adventure sports will be available through " +
                "pamphlets, ﬁlms, photos, videos and ﬁlms. Coordinated by DU students who have " +
                "outstanding achievements in mountaineering, the stall will encourage interaction to " +
                "understand the physical and psychological advantages of such sports. " +
                "Coordinator: NCC in charge Lt Parminder Sehgal  , " +
                "Student Akash Jindal (akash Q dal7Q1ahoo.eom)",
                "Equal Opportunity Cell " +
                        "The participation of students in co-curricular and extra co- curricular activities at any stage " +
                        "of their education helps them to foster their personality and self-conﬁdence. The Equal " +
                        "Oppoﬂunity Cell encourages students with disabilities pursuing various courses to " +
                        "showcase their abilities in various activities such as Solo & Group Song and Dance, " +
                        "Instrumental Performance, Poetry Recitation and Plays etc. which ensure their inclusion in " +
                        "“Antardhvani” The EOC will also put up a stall to display its activities with a view to " +
                        "sensitize and create awareness about the potential of students with disabilities. The EOC " +
                        "launched study tours abroadunder the Excellence in Education scheme and students visited " +
                        "London, Edinburgh and South Korea during the year. Special attraction is a stall " +
                        "demonstrating efﬁcient assistive devices for visually impaired youth. " +
                        "Coordinators: Prof. _Usha Rao.Dr. Bipin Tiwary (lggp inkumartiwari@rediﬂ'mail.com), " +
                        "Dr. Anil Aneja (osd@eoc.du.ac.in)", "Govt of India Institutions " +
                "Will present their material at Antardhvani: Gandhi Bhawan. National Book Trust, Indira " +
                "Gandhi National Centre for the Arts, Khadi Gramodvog. Sahitya Akademi. " +
                "In addition, stalls for horticultural goods and some handicrafts are presented through the " +
                "Garden Committee and NSS. " +
                "Coordinator: Dr. Nisha Tyagi, (drnisha§1agi@hotmaiI.com) " +
                "Dr. Aarati Saxena (aaratisaxena@gmail.com)", "No Data Available", "No Data Available", "Heritage Walk & Delhi University Archive Tour " +
                "The Heritage Walk beckons visitors to experience the history of the University of Delhi " +
                "through the Archive located in three ﬂoors of the Viceregal Lodge. While the building as a " +
                "whole is an Archive, visits at speciﬁed halting points gives an opportunity to understand the " +
                "past and present through written records, artefacts and visual representation There are rare " +
                "photographs of the Uprising of 1857, a narrative of Delhi University’s inception and " +
                "growth, anda moving view of Shaheed Bhagat Singh’s jail cell. The extended tour can take " +
                "visitors to sites located on the Northern Ridge where rebels and the British soldiers had " +
                "fought for the retention of Shahaj ahanabad Guided tours, starting from the back gate of the " +
                "Viceregal Lodge canbe booked at Antardhvani. Tour Timings are 1 1 am to lpm and from 3 " +
                "pm to 4.30 pm. " +
                "Coordinator: Dr. Amrit Kaur Basra (amritdcac@gmail.com)",
                "Delhi University Women's Association (DUWA) " +
                        "(DUWA)wi1l have its food stall with cakes and cookies, Indian cuisine and snacks. DUWA " +
                        "is a historic institution at the University ofDe1hi, having been established by pr; Durgabai " +
                        "Deshmukh and being registered in 1964. " +
                        "Coordinator: to be appointed by President, DUWA", "Teacher training and Academic Orientation: " +
                "The Centre for Professional Development in Higher Education (CPDI-IE) takes the lead " +
                "role in teacher training and evolving new pedagogical practice. With the introduction of the " +
                "four year undergraduate programme, CPDHE launched a major cycle in training teachers in " +
                "the interactive pedagogy of the ‘ﬂipped’ classroom. The learning is from student " +
                "presentations andprojects, with the teacher being a guide and mentor. To date more than " +
                "1500 teachers have participated in the orientation courses for the Foundation Courses. " +
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


