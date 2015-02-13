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
import antardhvani.du.ac.in.Adapter.Event_competitive_adapter;
import antardhvani.du.ac.in.Adapter.Group;
import antardhvani.du.ac.in.antardhvani.R;

public class Event_competitive extends Fragment {
    private Event_competitive_adapter ExpAdapter;
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
        ExpAdapter = new Event_competitive_adapter(getActivity(), ExpListItems);
        ExpandList.setAdapter(ExpAdapter);

        return layout;

    }


    public ArrayList<Group> SetStandardGroups() {

        String group_names[] = {"Rock Band   ","Quiz Time Prashnotri","Choreography","Creative Writing & Translation","Photography Competition","Folk Dance","Music-Vocal  Solo"
                ,"Instrumental Music   Solo","Group Songs" , "Short Film- Life in DU","Rangoli","Classical Dance", "Street Play", "Debate-Vaad Vivad"};

        String country_names[] = {"The Rock Band has its vital links with several forms of popular music and developed from " +
                "the 1960s to become an immensely attractive genre using primarily the guitar, drums and a " +
                "vocalist. Indian rock bands since the 70s have integrated components from western as well " +
                "as local traditions, and created fusions that are powerful, evocative and vibrant. The " +
                "advantage of this form of music is that it appeals directly to the viewers and invites their " +
                "participation in moments of expressions. The portable nature of the band and its adaptability " +
                "to the environment has a contemporary thrust and the lyrics, often composed by the " +
                "performers, carry themes that are reflective of modern angst. " +
                "Delhi University groups will be presenting their talent at Antardhvani using minimal " +
                "facilities so as to bring out their musical creativity to the utmost. " +
                "Coordinator: Dr. Suchitra Gupta (culturecouncil_du@rediffmail.com)"

                ,"Quiz is a most enjoyable activity that is based on a basic instinct for demonstrating " +
                "competitive intelligence. A test of knowledge, memory, response time and smartness, a " +
                "Quiz engages full attention from the competitor as well as the viewer. Antardhvani quiz " +
                "teams from colleges and departments will be asked questions on primarily four areas: " +
                "Literature and culture, sports and science. The Quiz Master is a well-known media person " +
                "with several years in show time. " +
                "Co-ordinators:Dr. Prem Kumari Srivastava (premksri@gmail.com) " +
                "Dr Shikha Gupta (shikhapgupta@gmail.com)"


                ,"Choreography in Delhi University has evolved quite rapidly in recent times. It represents " +
                "unparalleled passion for dance and a strong commitment towards team work. There is " +
                "synchronisation and understanding that members have for each other and it helps the teams " +
                "to reach the heights of success. The only absolute rule in choreography is that it should " +
                "impose order upon dance beyond the level of pure improvisation. It uses the three " +
                "dimensions of space and also the potential of human body. The choreography competition " +
                "will explore relevant social theme. " +
                "Coordinator: Dr. Suchitra Gupta (culturecouncil_du@rediffmail.com)"


                ,"Take a few moments off from the din around and you will have ears for ‘antardhvani’, " +
                "sounds that emerge from deep within …urges that find their way to poetry, to creative " +
                "churnings that connect the inside with the outside! " +
                "All are invited to send " +
                "i. Poetry: Original poetry in Hindi and/or English: Only one entry, up to 15 lines, from " +
                "each person for each language, with a self-certification of originality. " +
                "ii. Poetry and translation: Hindi and/or English. Entries must be received by 9 February " +
                "2015 at the Antardhvani secretariat or by email. The translation must be submitted " +
                "along with the original. Only one poem per person, the first 15 lines will be judged " +
                "for the competition. " +
                "Advisor: Dr. Sukrita Paul Kumar. " +
                "Entries to be submitted to Dr. Saleem Mir (msaleemir@gmail.com), 9818995351"


                ,"The exhibition at Antardhvani will have depictions of “Life in Delhi University”. " +
                "Photography Exhibits are ways to bring out talent and desires of artists in front of viewers. " +
                "These exhibitions are organized to showcase creative works of new as well as experienced " +
                "photographers who express their emotion towards the subject of their attention. This art " +
                "requires a lot of foresight to capture special moments, perspectives and beliefs. The " +
                "participating students will not only be able to display their work in this exhibition but will " +
                "also get recognition for their creativity. In this large and diverse institution the experience " +
                "of college and campus life would vary immensely. The attempt is to capture the diversity " +
                "through images. The short listed entries will be displayed prominently at the gallery. " +
                "Coordinator: Dr. G.S.Tuteja (gstuteja@gmail.com) "


                ,"Woven in rhythm, music and movements, folk dances are reflections of culture, traditions " +
                "and community practices. They are a fervent and ecstatic celebration of life. Countries of " +
                "the world have numerous folk dance forms – wonderfully expressed through traditional " +
                "attires, vibrant music and choreography, unique make-up and collective configurations. " +
                "Folk dances are developed by local communities of villages or tribes based on their own " +
                "regional customs and traditions. India, particularly, has a variety of folk dances, each with " +
                "its unique specialty and grace. " +
                "This event at Antardhvani aims at showing folk dances of different cultures for the audience " +
                "to witness the colorful costumes and vivacious dances, inimitable tradition and distinctive " +
                "heritage. The aim is to make the younger generation aware of the rainbow hues of our " +
                "culture and enable appreciation of various folk dance forms, and provide insight into the " +
                "basic philosophies of existence – joy of togetherness and collaboration. " +
                "Coordinator: Dr. Suchitra Gupta (culturecouncil_du@rediffmail.com) "


                ,"The solo singer has a long tradition in India and the repertoire ranges from the classical to " +
                "the popular. Although the parameters may be different in each genre there is a quality of " +
                "voice and expression that may be possible to evaluate across the genres. Built on years of " +
                "training and honed by regular practice, the singer’s voice is the vital mode for conveying " +
                "emotion, lyric, skill and finesse. At Antardhvani the jury will keep in mind the enormous " +
                "range that a vocal solo competition may bring. The composition may be from classical " +
                "sources or from a film or private album and may be presented inany official Indian " +
                "language. Fusion music is also allowed. The judgment will be made on the basis of voice " +
                "quality, song selection,rhythm, and melody. " +
                "Coordinator: Dr. Suchitra Gupta (culturecouncil_du@rediffmail.com) "


                ,"The tradition of Instrumental solo is a venerable one and celebrated in ancient texts and " +
                "epics of India. Though the sitar, veena, violin and sarod have been most popular, in recent " +
                "times the classical repertoire includes many instruments some of which had fallen into oblivion. The santoor and the flute for instance saw a revival in the hands of grand masters. " +
                "The competition at Antardhvani encourages our students to present the fruit of their training " +
                "in instrumental music, emphasising their creativity, artistry and skill. No pre-recorded " +
                "music or sample sound is allowed as accompaniment. " +
                "Coordinator: Dr. Suchitra Gupta (culturecouncil_du@rediffmail.com)"


                ,"The vigour of group songs carries an extraordinary energy. All communities in India build a " +
                "rich collection of traditional group songs that are shared at festive occasions and invoke the " +
                "participation of the social circle of family and friends. Often linked to seasons and to ritual " +
                "ceremonies, the songs mark a calendar that records the passage of time and the link with " +
                "nature. Folk songs in groups have evolved into modern versions in which the patriotic genre " +
                "took root during the national movement. In contemporary times, there is a revival of " +
                "interest in the folk traditions and the circumstances that make the group songs adaptable to " +
                "social change. In the competition at Antardhvani, the size of the choir team has been " +
                "limited. Accompanying instruments are also limited to Harmonium, Keyboard, Tabla, " +
                "Percussion etc. The judgment will be made on the basis of voice quality, song " +
                "selection, rhythm, and melody. " +
                "Coordinator: Dr. Suchitra Gupta (culturecouncil_du@rediffmail.com)"


                ,"Short films are not short because of small budgets or lesser known actors. They are brief " +
                "because everyone likes short and smart presentations these days. We live in a society with " +
                "fast food, fast email, fast trains, instant messages and e-shopping. Why not films in a similar mode! These 3-5 minute films offer entertainment served with information, " +
                "knowledge and wisdom. Film makers have to just bring the magic of their creativity " +
                "through their favorite device that is the mobile phone. It needs a special talent to capture " +
                "something unique in the university on that mobile and create a narrative. This challenge and " +
                "opportunity can bring out the potential to be a film director or a film producer. " +
                "Coordinator: Dr. G.S.Tuteja (gstuteja@gmail.com)"


                ,"Welcome to the world of colours by participating in a Rangoli competition. It is an integral " +
                "part of Indian culture and folk art of India. Decorative designs in the form of Rangoli are " +
                "made during different Hindu festivals and other auspicious occasions. Layouts are typically " +
                "created using a variety of material including coloured rice, coloured dry flour, dry sand, " +
                "dals, spices and even flower petals. Rangoli is called by different names in Indian states: " +
                "Kolam in Tamil Nadu, Mandana is Rajasthan, Chowkpurna in Northern India, Alpana in " +
                "West Bengal, Aripana in Bihar and Chowkpujan in Uttar Pradesh etc. Though Rangoli is " +
                "usually prepared for the purpose of decoration, it is also thought to bring good luck. Rangoli " +
                "reflects traditions and practices that are unique to a geographical area or a community. " +
                "College teams will present the variety that resides in the University of Delhi. " +
                "Coordinator: Dr. Amrita Bajaj (amrita.dse@gmail.com)"


                ,"Originating in the treatise on Natya Shastra by Bharat, the classical dance in India offers a " +
                "rich and varied repertoire which has evolved in contemporary times to experiment with " +
                "themes while retaining the discipline of the rules of performance. Eight classical dance " +
                "forms are generally recognised of which Kathak, Bharatanatyam and Odissi remain highly popular. Classical dance requires rigorous training from a young age and the best " +
                "performers are also adept musicians and choreographers. Antardhvani offers university " +
                "students an opportunity to present their talent in dance. The totality of expression through " +
                "tal, story/bhav, rhythm, costume, music will be considered by the jury. " +
                "Coordinator: Dr. Suchitra Gupta (culturecouncil_du@rediffmail.com) ",


                "Street Theatre is a popular activity in the University. It aims at sensitizing masses to social " +
                        "issues, enrolling them in the process of social change and promoting deeper understanding. " +
                        "It does not necessarily provide answers to the issues raised but tries to analyse the problems. " +
                        "Using humour it gives a satirical view on current issues. Street Theatre entails minimalist " +
                        "techniques. A character is established with a small but significant item of property such as a " +
                        "stick to portray a policeman, which can even be used as a shehnai, a chair to portray the " +
                        "study room or a group of students to represent society. The actor achieves success with " +
                        "his/her voice, body language and eye-to-eye contact with the viewer. Street Theatre " +
                        "combines music, song and dance with dialogues. " +
                        "Street Theatre is people-friendly. The dynamic and mobile nature of street theatre, makes it " +
                        "possible to go to people where a stage is not accessible, such as on streets and at markets, " +
                        "slums, villages, schools, office complexes, parks and residential areas. It is a free show for " +
                        "everyone, be it a shopkeeper, an officer, a housewife or a student; therefore, it never has a " +
                        "repeat audience. With participants sitting at the same level as the audience, it shuns " +
                        "hierarchy. The unpolished performance gives it the power to reach people. Street Theatre " +
                        "helps not only actors to evolve but also the audience to understand its social context. " +
                        "Coordinator: Shri. Munna K. Pandey (makpandeydu@gmail.com) " +
                        " Mr. Amitesh Kumar (amitesh0@gmail.com) "


                ,"The topic to be announced a few days before Antardhvani will take debaters into several " +
                "aspects of contemporary challenges. Debating is the art of articulating your case and " +
                "establishing your claim. It is a method of interactive and representational argument. " +
                "Antardhvani recognizes the importance of debating as a students’ activity, and as an " +
                "important component of holistic education. Debating enhances logical reasoning and " +
                "creative thinking. It helps one become a careful listener to both points of view. Debating " +
                "inculcates in students, the ability to critically analyse a problem and propose workable " +
                "solutions. The quality and depth of a debate improves with knowledge and skill of its " +
                "participants as debaters. Antardhvani is creating an opportunity for students across colleges " +
                "and departments to participate in its debating competition. " +
                "Coordinator: Dr. Amrita Bajaj (amrita.dse@gmail.com), 9811351872 " +
                " Dr. Rakesh Kumar Parashar (rakeshkp@email.com), 9810348999 "
        };



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


