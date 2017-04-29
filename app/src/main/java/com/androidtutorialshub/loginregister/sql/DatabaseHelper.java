package com.androidtutorialshub.loginregister.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.design.widget.Snackbar;
import android.util.Log;

import com.androidtutorialshub.loginregister.model.Attendance;
import com.androidtutorialshub.loginregister.model.Event;
import com.androidtutorialshub.loginregister.model.Member;
import com.androidtutorialshub.loginregister.model.NonMember;
import com.androidtutorialshub.loginregister.model.Registration;
import com.androidtutorialshub.loginregister.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lalit on 9/12/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "IECSE_CENTRAL_DATABASE.db";

    // User table name
    private static final String TABLE_USER = "user";
    private static final String TABLE_EVENT = "event";
    private static final String TABLE_MEMBER = "member";
    private static final String TABLE_ATTENDANCE = "attendance";
    private static final String TABLE_NON_MEMBER = "non_member";
    private static final String TABLE_REGISTRATION = "registration";

    // User Table Columns names
    private static final String COLUMN_USER_ID = "member_id";
    private static final String COLUMN_USER_NAME = "user_name";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_USER_PASSWORD = "user_password";
    private static final String COLUMN_REG_NO="registration_number";
    private static final String COLUMN_PHONE_NO="phone_number";


    private static final String COLUMN_MEM_ID = "memID";
    private static final String COLUMN_MEM_NAME = "name";
    private static final String COLUMN_MEM_EMAIL = "email";
    private static final String COLUMN_MEM_PHONE = "mobile";
    private static final String COLUMN_MEM_DEPT = "dept";
    private static final String COLUMN_MEM_AL="access_level";

    private static final String COLUMN_E_ID = "eventID";
    private static final String COLUMN_E_NAME = "name";
    private static final String COLUMN_E_VENUE = "venue";
    private static final String COLUMN_E_TYPE = "type";


    private static final String COLUMN_NM_ID = "NMID";

    // create table sql query
    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "( "
            + COLUMN_USER_ID + " INT PRIMARY KEY, " + COLUMN_USER_NAME + " TEXT, "
            + COLUMN_USER_EMAIL + " TEXT, " + COLUMN_USER_PASSWORD + " TEXT, "  + COLUMN_REG_NO + " TEXT, "
            + COLUMN_PHONE_NO + " TEXT" + ");";

    private String CREATE_MEMBER_TABLE="CREATE TABLE " + TABLE_MEMBER + "(" +
            COLUMN_MEM_ID + " INT PRIMARY KEY, " + COLUMN_MEM_NAME + " TEXT, "
            + COLUMN_MEM_EMAIL + " TEXT, " + COLUMN_MEM_PHONE + " TEXT, "  + COLUMN_MEM_DEPT + " TEXT, "
            + COLUMN_MEM_AL + " TEXT check("+ COLUMN_MEM_AL + " in ('0','1','2','3')));";

    private String CREATE_NON_MEMBER_TABLE="CREATE TABLE " + TABLE_NON_MEMBER + "(" +
            COLUMN_NM_ID + " INT PRIMARY KEY, " + COLUMN_MEM_NAME + " TEXT, "
            + COLUMN_MEM_EMAIL + " TEXT, " + COLUMN_MEM_PHONE + " TEXT "  + ");";



    private String CREATE_EVENT_TABLE="CREATE TABLE " + TABLE_EVENT + "(" +
            COLUMN_E_ID + " INT PRIMARY KEY, " + COLUMN_E_NAME + " TEXT, "
            + COLUMN_E_VENUE + " TEXT, " + COLUMN_E_TYPE + " TEXT check("+ COLUMN_E_TYPE+ " in ('Dev','Web','Tech','Design','Others')));";

    private String CREATE_ATTENDANCE_TABLE="CREATE TABLE " + TABLE_ATTENDANCE + "(" +
            COLUMN_MEM_ID + " INT ," + COLUMN_NM_ID + " INT, "
            + COLUMN_E_ID + " INT, " + "primary key(memID,eventID,nmID),"+
    "foreign key(eventID) references event(eventID),"+
            "foreign key(NMID) references non_member(NMID),"+
    "foreign key(memID) references member(memID)" + ");";

    private String CREATE_REGISTRATION_TABLE="CREATE TABLE " + TABLE_REGISTRATION + "(" +
            COLUMN_MEM_ID + " INT ," + COLUMN_NM_ID + " INT, "
            + COLUMN_E_ID + " INT, " + "primary key(memID,eventID,nmID),"+
            "foreign key(eventID) references event(eventID),"+
            "foreign key(NMID) references non_member(NMID),"+
            "foreign key(memID) references member(memID)" + ");";





    // drop table sql query
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER+";";
    private String DROP_MEMBER_TABLE = "DROP TABLE IF EXISTS " + TABLE_MEMBER+";";
    private String DROP_NON_MEMBER_TABLE = "DROP TABLE IF EXISTS " + TABLE_NON_MEMBER+";";
    private String DROP_EVENT_TABLE = "DROP TABLE IF EXISTS " + TABLE_EVENT+";";
    private String DROP_ATTENDANCE_TABLE = "DROP TABLE IF EXISTS " + TABLE_ATTENDANCE+";";
    private String DROP_REGISTRATION_TABLE = "DROP TABLE IF EXISTS " + TABLE_REGISTRATION+";";

    /**
     * Constructor
     *
     * @param context
     */
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_MEMBER_TABLE);
        db.execSQL(CREATE_NON_MEMBER_TABLE);
        db.execSQL(CREATE_EVENT_TABLE);
        db.execSQL(CREATE_ATTENDANCE_TABLE);
        db.execSQL(CREATE_REGISTRATION_TABLE);




        Log.d(" ","Before atten");
        db.execSQL("INSERT INTO attendance VALUES (1,0,34);");
        db.execSQL("INSERT INTO attendance VALUES (1,67,0);");
        db.execSQL("INSERT INTO attendance VALUES (1,19,0);");
        db.execSQL("INSERT INTO attendance VALUES (2,3,0);");
        db.execSQL("INSERT INTO attendance VALUES (2,2,0);");
        db.execSQL("INSERT INTO attendance VALUES (2,0,42);");
        db.execSQL("INSERT INTO attendance VALUES (2,76,0);");
        db.execSQL("INSERT INTO attendance VALUES (2,0,55);");
        db.execSQL("INSERT INTO attendance VALUES (3,102,0);");
        db.execSQL("INSERT INTO attendance VALUES (3,6,0);");
        db.execSQL("INSERT INTO attendance VALUES (3,0,55);");
        db.execSQL("INSERT INTO attendance VALUES (4,23,0);");
        db.execSQL("INSERT INTO attendance VALUES (4,0,24);");
        db.execSQL("INSERT INTO attendance VALUES (4,14,0);");
        db.execSQL("INSERT INTO attendance VALUES (5,72,0);");
        db.execSQL("INSERT INTO attendance VALUES (5,35,0);");
        Log.d(" ","Before non_mem");

        db.execSQL("insert into non_member VALUES (0, 'Member','loremipsumdolor@gmail.com','999999999');");
        db.execSQL("insert into non_member VALUES (1, 'Saptarshi Dutta', 'duttasaptarshi28@gmail.com', '7022885964');");
        db.execSQL("insert into non_member VALUES (2, 'MJ Balaji', 'mjbalaji17@gmail.com', '8682075345');");
        db.execSQL("insert into non_member VALUES (3, 'Hriday Chhabria', 'hridaykchhabria@gmail.com', '9833314293');");
        db.execSQL("insert into non_member VALUES (4, 'Swati Kanwal', 'kanwalswati97@gmail.com', '7838682122');");
        db.execSQL("insert into non_member VALUES (5, 'Gokul Vuppumalla', 'loremipsum@gmail.com', '9008501419');");
        db.execSQL("insert into non_member VALUES (6, 'Dheeraj Reddy', 'dheeraj98reddy@gmail.com', '7406998269');");
        db.execSQL("insert into non_member VALUES (7, 'Vedant Lodha', 'vedant.lodha@hotmail.com', '8084982582');");
        db.execSQL("insert into non_member VALUES (8, 'Ananya Gupta', 'ananyagupta6@gmail.com', '9632021177');");
        db.execSQL("insert into non_member VALUES (9, 'P Sai Mandeep', 'kps.deepu6@gmail.com', '8296374549');");
        db.execSQL("insert into non_member VALUES (10, 'Ravi Teja', 'ravi_teja9991516@yahoo.com', '9483513542');");
        db.execSQL("insert into non_member VALUES (11, 'Supreeth Muduchetty', 'supreeth.mudduchetty@gmail.com', '8971673209');");
        db.execSQL("insert into non_member VALUES (12, 'Kavish Hukmani', 'khukmani@gmail.com', '9923095547');");
        db.execSQL("insert into non_member VALUES (13, 'Shashwat Kumar', 'gonecase22.rk@gmail.com', '9071602985');");
        db.execSQL("insert into non_member VALUES (14, 'Snehashish Sourav', 'souravreddyhi@gmail.com', '9448003243');");
        db.execSQL("insert into non_member VALUES (15, 'Divyansh Gupta', 'divyanshguptabjr12@gmail.com', '8123244545');");
        db.execSQL("insert into non_member VALUES (16, 'Naman Jain', 'namanjain10555@gmail.com', '8197160107');");
        db.execSQL("insert into non_member VALUES (17, 'Japnit Singh', 'realjswalia@gmail.com', '7899046812');");
        db.execSQL("insert into non_member VALUES (18, 'Vidit Jain', 'vidjain.heritage@gmail.com', '9742251638');");
        db.execSQL("insert into non_member VALUES (19, 'Aditya Sharma', 'asamadhia@gmail.com', '7022884515');");
        db.execSQL("insert into non_member VALUES (20, 'Banveen Singh', 'banveensingh@gmail.com', '7899046192');");
        db.execSQL("insert into non_member VALUES (21, 'Shravya Shetty', 'shravyajshetty67@gmail.com', '9448405303');");
        db.execSQL("insert into non_member VALUES (22, 'Abhimanyu Agarwal', 'abhimanyu601@icloud.com', '8130873091');");
        db.execSQL("insert into non_member VALUES (23, 'Agam Dogra', 'agamdogra1@gmail.com', '7022037352');");
        db.execSQL("insert into non_member VALUES (24, 'Abhigyan Gogoi', 'abhigyan380@gmail.com', '8876857761');");
        db.execSQL("insert into non_member VALUES (25, 'Idris M', 'droid.iddu@gmail.com', '8124578610');");
        db.execSQL("insert into non_member VALUES (26, 'Tarun Rath', 'loremipsum@gmail.com', '9920137477');");
        db.execSQL("insert into non_member VALUES (27, 'iva surana', 'loremipsum@gmail.com', '8287712121');");
        db.execSQL("insert into non_member VALUES (28, 'shambhavi sarin', 'loremipsum@gmail.com', '7600856436');");
        db.execSQL("insert into non_member VALUES (29, 'shashank shekhar', 'loremipsum@gmail.com', '7026751347');");
        db.execSQL("insert into non_member VALUES (30, 'raghvendra singh', 'loremipsum@gmail.com', '9460290979');");
        db.execSQL("insert into non_member VALUES (31, 'sai harsha', 'loremipsum@gmail.com', '8106482507');");
        db.execSQL("insert into non_member VALUES (32, 'N sumanth', 'loremipsum@gmail.com', '7022886789');");
        db.execSQL("insert into non_member VALUES (33, 'Harsh verma', 'loremipsum@gmail.com', '9763721852');");
        db.execSQL("insert into non_member VALUES (34, 'vamsi krishna', 'loremipsum@gmail.com', '9494154343');");
        db.execSQL("insert into non_member VALUES (35, 'M komal', 'loremipsum@gmail.com', '8500585798');");
        db.execSQL("insert into non_member VALUES (36, 'Swadha ', 'loremipsum@gmail.com', '9936890649');");
        db.execSQL("insert into non_member VALUES (37, 'mahima rao', 'loremipsum@gmail.com', '9148939292');");
        db.execSQL("insert into non_member VALUES (38, 'atul kr panday', 'loremipsum@gmail.com', '8296540102');");
        db.execSQL("insert into non_member VALUES (39, 'Vyshva manas', 'loremipsum@gmail.com', '8106255390');");
        db.execSQL("insert into non_member VALUES (40, 'pashchima ', 'loremipsum@gmail.com', '9167758106');");
        db.execSQL("insert into non_member VALUES (41, 'pranav', 'loremipsum@gmail.com', '8454048232');");
        db.execSQL("insert into non_member VALUES (42, 'richa elangovan', 'loremipsum@gmail.com', '7338110619');");
        db.execSQL("insert into non_member VALUES (43, 'pranav dvgl', 'loremipsum@gmail.com', '9346339850');");
        db.execSQL("insert into non_member VALUES (44, 'mucherla kareeti', 'loremipsum@gmail.com', '9494050139');");
        db.execSQL("insert into non_member VALUES (45, 'G sai krishan', 'loremipsum@gmail.com', '7022885934');");
        db.execSQL("insert into non_member VALUES (46, 'divij agarwal', 'loremipsum@gmail.com', '9769928298');");
        db.execSQL("insert into non_member VALUES (47, 'angad singh', 'loremipsum@gmail.com', '9730070707');");
        db.execSQL("insert into non_member VALUES (48, 'amrit goiyal', 'loremipsum@gmail.com', '9880686775');");
        db.execSQL("insert into non_member VALUES (49, 'navneet sajith', 'loremipsum@gmail.com', '9902933039');");
        db.execSQL("insert into non_member VALUES (50, 'aniruddha paranjape', 'loremipsum@gmail.com', '9686056200');");
        db.execSQL("insert into non_member VALUES (51, 'chantal D', 'loremipsum@gmail.com', '9742287188');");
        db.execSQL("insert into non_member VALUES (52, 'sarthak mittal ', 'loremipsum@gmail.com', '9810768410');");
        db.execSQL("insert into non_member VALUES (53, 'darshini p', 'loremipsum@gmail.com', '8179421275');");
        db.execSQL("insert into non_member VALUES (54, 's r n rayudu', 'loremipsum@gmail.com', '9573593123');");
        db.execSQL("insert into non_member VALUES (55, 'pawan vasanth', 'loremipsum@gmail.com', '9490897947');");
        db.execSQL("insert into non_member VALUES (56, 'soham paul', 'loremipsum@gmail.com', '8296538801');");
        db.execSQL("insert into non_member VALUES (57, 'athul dinesh', 'loremipsum@gmail.com', '7795910215');");
        db.execSQL("insert into non_member VALUES (58, 'gaurangi gupta', 'loremipsum@gmail.com', '8296374522');");
        db.execSQL("insert into non_member VALUES (59, 'ritika nandi ', 'loremipsum@gmail.com', '9958179858');");
        db.execSQL("insert into non_member VALUES (60, 'Zoya junaid', 'loremipsum@gmail.com', '7348902598');");
        db.execSQL("insert into non_member VALUES (61, 'Sahil garg', 'loremipsum@gmail.com', '8792062027');");
        db.execSQL("insert into non_member VALUES (62, 'aditya kumar ', 'loremipsum@gmail.com', '8296539410');");
        db.execSQL("insert into non_member VALUES (63, 'sasnika ', 'loremipsum@gmail.com', '9087758012');");
        db.execSQL("insert into non_member VALUES (64, 'aditya av', 'loremipsum@gmail.com', '9441534599');");
        db.execSQL("insert into non_member VALUES (65, 'harkaram singh', 'loremipsum@gmail.com', '7340916522');");
        db.execSQL("insert into non_member VALUES (66, 'somansh reddy', 'loremipsum@gmail.com', '9959525552');");
        db.execSQL("insert into non_member VALUES (67, 'abhay kumar', 'loremipsum@gmail.com', '9521871926');");
        db.execSQL("insert into non_member VALUES (68, 'pranjal sinha', 'loremipsum@gmail.com', '9676540170');");
        db.execSQL("insert into non_member VALUES (69, 'kartik shah', 'loremipsum@gmail.com', '8819000062');");
        db.execSQL("insert into non_member VALUES (70, 'shubhang yadav', 'loremipsum@gmail.com', '8296539901');");
        db.execSQL("insert into non_member VALUES (71, 'abhishek shukla', 'loremipsum@gmail.com', '9920980072');");
        db.execSQL("insert into non_member VALUES (72, 'swetha sairam', 'loremipsum@gmail.com', '9663962608');");
        db.execSQL("insert into non_member VALUES (73, 'raghav shrivastav', 'loremipsum@gmail.com', '8296540114');");
        db.execSQL("insert into non_member VALUES (74, 'suwigya gutgutia', 'loremipsum@gmail.com', '8986667171');");
        db.execSQL("insert into non_member VALUES (75, 'asmita samanta', 'loremipsum@gmail.com', '8296539854');");
        db.execSQL("insert into non_member VALUES (76, 'darini hariharan', 'loremipsum@gmail.com', '9487090777');");
        db.execSQL("insert into non_member VALUES (77, 'dhruva agrawal', 'loremipsum@gmail.com', '9819157676');");
        db.execSQL("insert into non_member VALUES (78, 'anurag roy', 'loremipsum@gmail.com', '9004033039');");
        db.execSQL("insert into non_member VALUES (79, 'amit prabhu', 'loremipsum@gmail.com', '9513391410');");
        db.execSQL("insert into non_member VALUES (80, 'ishita jalan', 'loremipsum@gmail.com', '9414046691');");
        db.execSQL("insert into non_member VALUES (81, 'vansh sodhi', 'loremipsum@gmail.com', '9412705521');");
        db.execSQL("insert into non_member VALUES (82, 'anitej palakoditi', 'loremipsum@gmail.com', '9769012760');");
        db.execSQL("insert into non_member VALUES (83, 'agrim gupta', 'loremipsum@gmail.com', '7838088314');");
        db.execSQL("insert into non_member VALUES (84, 'anirudh pandey', 'loremipsum@gmail.com', '9451313833');");
        db.execSQL("insert into non_member VALUES (85, 'ayush dwivedi', 'loremipsum@gmail.com', '9479690105');");
        db.execSQL("insert into non_member VALUES (86, 'rudraksh haran', 'loremipsum@gmail.com', '7567869400');");
        db.execSQL("insert into non_member VALUES (87, 'druti singh', 'loremipsum@gmail.com', '7080917413');");
        db.execSQL("insert into non_member VALUES (88, 'khyati ', 'loremipsum@gmail.com', '9988261592');");
        db.execSQL("insert into non_member VALUES (89, 'naman diwan', 'loremipsum@gmail.com', '8296374693');");
        db.execSQL("insert into non_member VALUES (90, 'vanshika kumar', 'loremipsum@gmail.com', '7022884534');");
        db.execSQL("insert into non_member VALUES (91, 'mirnasree k', 'loremipsum@gmail.com', '7899861027');");
        db.execSQL("insert into non_member VALUES (92, 'ritika kole', 'loremipsum@gmail.com', '8123717122');");
        db.execSQL("insert into non_member VALUES (93, 'ayushi jha', 'loremipsum@gmail.com', '9819846206');");
        db.execSQL("insert into non_member VALUES (94, 'ojasvi agarwal', 'loremipsum@gmail.com', '9828467257');");
        db.execSQL("insert into non_member VALUES (95, 'lipika garg', 'loremipsum@gmail.com', '9818818167');");
        db.execSQL("insert into non_member VALUES (96, 'dheeraj acharya', 'loremipsum@gmail.com', '8722403035');");
        db.execSQL("insert into non_member VALUES (97, 'vipul sureka', 'loremipsum@gmail.com', '9035502003');");
        db.execSQL("insert into non_member VALUES (98, 'guru prasad', 'loremipsum@gmail.com', '7022884935');");
        db.execSQL("insert into non_member VALUES (99, 'parv kapoor', 'loremipsum@gmail.com', '9001227998');");
        db.execSQL("insert into non_member VALUES (100, 'divya manjuna', 'loremipsum@gmail.com', '9049000585');");
        db.execSQL("insert into non_member VALUES (101, 'harneet kanuja', 'loremipsum@gmail.com', '7353021100');");
        db.execSQL("insert into non_member VALUES (102, 'shantanu das', 'loremipsum@gmail.com', '7229027462');");
       /* db.execSQL("insert into non_member VALUES (103, 'rishiraj sinha', 'loremipsum@gmail.com', '8472062695');");
        db.execSQL("insert into non_member VALUES (104, 'prateek kh', 'loremipsum@gmail.com', '9686646640');");
        db.execSQL("insert into non_member VALUES (105, 'arun ravi', 'loremipsum@gmail.com', '9886715144');");
        db.execSQL("insert into non_member VALUES (106, 'aditya sharma', 'loremipsum@gmail.com', '9818897625');");
        db.execSQL("insert into non_member VALUES (107, 'hardik singh', 'loremipsum@gmail.com', '9619056668');");
        db.execSQL("insert into non_member VALUES (108, 'sannidhi p kumar', 'loremipsum@gmail.com', '9483693876');");
        db.execSQL("insert into non_member VALUES (109, 'shubham anand', 'loremipsum@gmail.com', '8123600755');");
        db.execSQL("insert into non_member VALUES (110, 'harshit shroff', 'loremipsum@gmail.com', '9883323481');");
        db.execSQL("insert into non_member VALUES (111, 'shivam varshney', 'loremipsum@gmail.com', '7296899321');");
        db.execSQL("insert into non_member VALUES (112, 'shridul sethi', 'loremipsum@gmail.com', '9899007475');");
        db.execSQL("insert into non_member VALUES (113, 'vishnu kolal', 'loremipsum@gmail.com', '8951622076');");
        db.execSQL("insert into non_member VALUES (114, 'tushar kshatriya', 'loremipsum@gmail.com', '7405469901');");
        db.execSQL("insert into non_member VALUES (115, 'shikhar shrivastav', 'loremipsum@gmail.com', '8296539327');");
        db.execSQL("insert into non_member VALUES (116, 'anshuman rao', 'loremipsum@gmail.com', '9148498792');");
        db.execSQL("insert into non_member VALUES (117, 'tushar raj pradhan', 'loremipsum@gmail.com', '9593668269');");
        db.execSQL("insert into non_member VALUES (118, 'eeshan upadhyay', 'loremipsum@gmail.com', '8123617070');");
        db.execSQL("insert into non_member VALUES (119, 'shreyansh pandey', 'loremipsum@gmail.com', '8296540020');");
        db.execSQL("insert into non_member VALUES (120, 'aditya gupta', 'loremipsum@gmail.com', '9781249906');");
        db.execSQL("insert into non_member VALUES (121, 'nikita saraogi', 'loremipsum@gmail.com', '9051038680');");
        db.execSQL("insert into non_member VALUES (122, 'siddhant jain', 'loremipsum@gmail.com', '9810087142');");
        db.execSQL("insert into non_member VALUES (123, 'sahil nagpai', 'loremipsum@gmail.com', '9999021391');");
        db.execSQL("insert into non_member VALUES (124, 'mohammed afzal', 'loremipsum@gmail.com', '7093658613');");
        db.execSQL("insert into non_member VALUES (125, 'phanidatta reddy', 'loremipsum@gmail.com', '8123242200');");
        db.execSQL("insert into non_member VALUES (126, 'Saransh Goel', 'loremipsum@gmail.com', '7406098807');");
        db.execSQL("insert into non_member VALUES (127, 'Mayank Gupta', 'loremipsum@gmail.com', '9910180224');");
        db.execSQL("insert into non_member VALUES (128, 'gauri kumar', 'loremipsum@gmail.com', '8348332103');");
        db.execSQL("insert into non_member VALUES (129, 'rachita dash', 'loremipsum@gmail.com', '9820842635');");
        db.execSQL("insert into non_member VALUES (130, 'Mrinali Shetty', 'loremipsum@gmail.com', '8296320646');");
        db.execSQL("insert into non_member VALUES (131, 'Jenit Jain', 'loremipsum@gmail.com', '9071597467');");
        db.execSQL("insert into non_member VALUES (132, 'Kushal Shukla', 'loremipsum@gmail.com', '9918512676');");
        db.execSQL("insert into non_member VALUES (133, 'Roshan Kumar', 'loremipsum@gmail.com', '9031502932');");
        db.execSQL("insert into non_member VALUES (134, 'Varun Tiwari', 'loremipsum@gmail.com', '9818408369');");
        db.execSQL("insert into non_member VALUES (135, 'Pranav Mahajan', 'loremipsum@gmail.com', '9501306647');");
        db.execSQL("insert into non_member VALUES (136, 'Dipankar', 'loremipsum@gmail.com', '9534193905');");
        db.execSQL("insert into non_member VALUES (137, 'Aditya Vikram Saraf', 'loremipsum@gmail.com', '7388738822');");
        db.execSQL("insert into non_member VALUES (138, 'Saksham Banga', 'loremipsum@gmail.com', '8826800660');");
        db.execSQL("insert into non_member VALUES (139, 'Ankit Kumar', 'loremipsum@gmail.com', '8296538852');");
        db.execSQL("insert into non_member VALUES (140, 'Deepak garasangi', 'loremipsum@gmail.com', '9167304808');");
        db.execSQL("insert into non_member VALUES (141, 'Divya Hebbar', 'loremipsum@gmail.com', '8088911234');");
        db.execSQL("insert into non_member VALUES (142, 'Ashwini Kumar', 'loremipsum@gmail.com', '8002822133');");
        db.execSQL("insert into non_member VALUES (143, 'Aditya Sharma', 'loremipsum@gmail.com', '9321264600');");
        db.execSQL("insert into non_member VALUES (144, 'Shantanu Aapoor', 'loremipsum@gmail.com', '7877630652');");
        db.execSQL("insert into non_member VALUES (145, 'Clarin D''Souza', 'loremipsum@gmail.com', '9741129828');");
        db.execSQL("insert into non_member VALUES (146, 'Rohit Das', 'loremipsum@gmail.com', '9895393476');");
        db.execSQL("insert into non_member VALUES (147, 'Ujjwal Asthana', 'loremipsum@gmail.com', '9538018452');");
        db.execSQL("insert into non_member VALUES (148, 'Bikramjeet Singh', 'loremipsum@gmail.com', '9811192575');");
        db.execSQL("insert into non_member VALUES (149, 'Mukund Ajmera', 'loremipsum@gmail.com', '9782218782');");
        db.execSQL("insert into non_member VALUES (150, 'Judith kaushik', 'loremipsum@gmail.com', '9742654357');");
        db.execSQL("insert into non_member VALUES (151, 'Archit Verma', 'loremipsum@gmail.com', '7506945475');");
        db.execSQL("insert into non_member VALUES (152, 'yasasvi Ydav', 'loremipsum@gmail.com', '7022885280');");
        db.execSQL("insert into non_member VALUES (153, 'Venkatarajasimha Reddy', 'loremipsum@gmail.com', '8296540254');");
        db.execSQL("insert into non_member VALUES (154, 'Prateek Jha', 'loremipsum@gmail.com', '8296539044');");
        db.execSQL("insert into non_member VALUES (155, 'Abhishek Kumar', 'loremipsum@gmail.com', '9199555551');");
        db.execSQL("insert into non_member VALUES (156, 'Akshitha M S', 'loremipsum@gmail.com', '7338240346');");
        db.execSQL("insert into non_member VALUES (157, 'Nidhi Shetty', 'loremipsum@gmail.com', '8971194350');");
        db.execSQL("insert into non_member VALUES (158, 'Ajay  Raghavan', 'loremipsum@gmail.com', '7022884883it');");
        db.execSQL("insert into non_member VALUES (159, 'Harish Cherupally', 'loremipsum@gmail.com', '8296538625');");
        db.execSQL("insert into non_member VALUES (160, 'Swapnil Sagar', 'loremipsum@gmail.com', '9423000808');");
        db.execSQL("insert into non_member VALUES (161, 'Rohith Reddy', 'loremipsum@gmail.com', '9866147599');");
        db.execSQL("insert into non_member VALUES (162, 'Shaun Jose', 'loremipsum@gmail.com', '8157036339');");
        db.execSQL("insert into non_member VALUES (163, 'Akash Sahu', 'loremipsum@gmail.com', '7022879304');");
        db.execSQL("insert into non_member VALUES (164, 'Himanshu Kumar', 'loremipsum@gmail.com', '8123260066');");
        db.execSQL("insert into non_member VALUES (165, 'N Vasanth Kumar', 'loremipsum@gmail.com', '8660203595');");
        db.execSQL("insert into non_member VALUES (166, 'Suraj Marthy', 'loremipsum@gmail.com', '8885994995');");
        db.execSQL("insert into non_member VALUES (167, 'Sai Kiran ', 'loremipsum@gmail.com', '8296539685');");
        db.execSQL("insert into non_member VALUES (168, 'Allu Praveen', 'loremipsum@gmail.com', '9177739898');");
        db.execSQL("insert into non_member VALUES (169, 'Sudharshan Mane', 'loremipsum@gmail.com', '7709082402');");
        db.execSQL("insert into non_member VALUES (170, 'N Avinash', 'loremipsum@gmail.com', '8296539636');");
        db.execSQL("insert into non_member VALUES (171, 'Rishabh Agarwal', 'loremipsum@gmail.com', '9804345160');");
        db.execSQL("insert into non_member VALUES (172, 'Saurabh Pareek', 'loremipsum@gmail.com', '9409374110');");
        db.execSQL("insert into non_member VALUES (173, 'Neil Par', 'loremipsum@gmail.com', '8971963001');");
        db.execSQL("insert into non_member VALUES (174, 'Rajit Roy', 'loremipsum@gmail.com', '7022884525');");
        db.execSQL("insert into non_member VALUES (175, 'Manas Mishra', 'loremipsum@gmail.com', '8123572233');");
        db.execSQL("insert into non_member VALUES (176, 'Abhishek Anand', 'loremipsum@gmail.com', '9513391459');");
        db.execSQL("insert into non_member VALUES (177, 'Piyush Jha', 'loremipsum@gmail.com', '8296539805');");
        db.execSQL("insert into non_member VALUES (178, 'Rajat Kumar', 'loremipsum@gmail.com', '9334554553');");
        db.execSQL("insert into non_member VALUES (179, 'Rohit Raman', 'loremipsum@gmail.com', '9944391966');");
        db.execSQL("insert into non_member VALUES (180, 'Sandesh Hebbar', 'loremipsum@gmail.com', '8088669667');");
        db.execSQL("insert into non_member VALUES (181, 'Vasudev Rateria', 'loremipsum@gmail.com', '9051259789');");
        db.execSQL("insert into non_member VALUES (182, 'Akash Bhargav', 'loremipsum@gmail.com', '9811098958');");
        db.execSQL("insert into non_member VALUES (183, 'Shrey Gupta', 'loremipsum@gmail.com', '8050020688');");
        db.execSQL("insert into non_member VALUES (184, 'Kripesh Kumar', 'loremipsum@gmail.com', '9995793452');");
        db.execSQL("insert into non_member VALUES (185, 'Sanjeev Nayak', 'loremipsum@gmail.com', '7738300730');");
        db.execSQL("insert into non_member VALUES (186, 'shubham anand', 'loremipsum@gmail.com', '7022885917');");
        db.execSQL("insert into non_member VALUES (187, 'Pranjal Namdeo', 'loremipsum@gmail.com', '7022884847');");
        db.execSQL("insert into non_member VALUES (188, 'Harihara', 'loremipsum@gmail.com', '9952443748');");
        db.execSQL("insert into non_member VALUES (189, 'Charan Reddy', 'loremipsum@gmail.com', '9618584877');");
        db.execSQL("insert into non_member VALUES (190, 'Gautam Singh', 'loremipsum@gmail.com', '9573723659');");
        db.execSQL("insert into non_member VALUES (191, 'Rohit Sarkar', 'loremipsum@gmail.com', '8296538324');");
        db.execSQL("insert into non_member VALUES (192, 'Sahil Vora', 'loremipsum@gmail.com', '9905402300');");
        db.execSQL("insert into non_member VALUES (193, 'Praneeth Madey', 'loremipsum@gmail.com', '7795885137');");
        db.execSQL("insert into non_member VALUES (194, 'Anvita Goyal', 'loremipsum@gmail.com', '702288110');");
        db.execSQL("insert into non_member VALUES (195, 'T Harshavardhan Reddy', 'loremipsum@gmail.com', '9949759090');");
        db.execSQL("insert into non_member VALUES (196, 'Sahil ', 'loremipsum@gmail.com', '8123603399');");
        db.execSQL("insert into non_member VALUES (197, 'Ajay Das', 'loremipsum@gmail.com', '8296374434');");
        db.execSQL("insert into non_member VALUES (198, 'Vivek V', 'loremipsum@gmail.com', '8281239525');");
        db.execSQL("insert into non_member VALUES (199, 'Harsht Raghuvamsho', 'rharhsit98@gmail.com', '9969817450');");
        db.execSQL("insert into non_member VALUES (200, 'Varun Date', 'varun.date@yahoo.in', '7022884958');");
        db.execSQL("insert into non_member VALUES (201, 'Aaryan Bhandari', 'bhandariaaryan16@gmail.com', '8296540127');");
        db.execSQL("insert into non_member VALUES (202, 'Abhinav Mittra', 'abhinavmittra@rediffmail.com', '9560171989');");
        db.execSQL("insert into non_member VALUES (203, 'Shubham Kumar Sinha', 'shubhfp@gmail.com', '7829503254');");
        db.execSQL("insert into non_member VALUES (204, 'Tirth Patel', 'pt001.mit@gmail.com', '7016227470');");
        db.execSQL("insert into non_member VALUES (205, 'Arushi Sinha', 'arushilmgc@gmail.com', '9793084059');");
        db.execSQL("insert into non_member VALUES (206, 'Vedant Gadia', 'vedantgadia@gmail.com', '9619515597');");
        db.execSQL("insert into non_member VALUES (207, 'Mohit Gupta', '0505mohit@gmail.com', '8123304949');");
        db.execSQL("insert into non_member VALUES (208, 'Aadith Kumar', 'aadith.j@gmail.com', '9843311994');");
        db.execSQL("insert into non_member VALUES (209, 'Medha Sawhney', 'medhasawhney@yahoo.co.in', '9984298243');");
        db.execSQL("insert into non_member VALUES (210, 'Krishna Birla', 'meshowstopper@gmail.com', '8674916754');");
        db.execSQL("insert into non_member VALUES (211, 'Mayuresh Wagh', 'mayureshwagh6@gmail.com', '7720039980');");
        db.execSQL("insert into non_member VALUES (212, 'Ashwin T', 'aswinthiagu@gmail.com', '9650021140');");
        db.execSQL("insert into non_member VALUES (213, 'Sushant Tiwari', 'tiwarisushant98@gmail.com', '9424312410');");
        db.execSQL("insert into non_member VALUES (214, 'Prateek Arora', 'arora_prateek@hotmail.com', '735418661');");
        db.execSQL("insert into non_member VALUES (215, 'Vaibhav Mittal', 'perfectvaibhavmittal@gmail.com', '9012349000');");
        db.execSQL("insert into non_member VALUES (216, 'Raunaq Ray', 'raunaqray@gmail.com', '8296374535');");
        db.execSQL("insert into non_member VALUES (217, 'Sushant Prabhu ', 'sushantprabhu120398@gmail.com', '8452918115');");
        db.execSQL("insert into non_member VALUES (218, 'Aditya Visvanathan', 'addyvisvanathan@gamil.com', '9987893483');");
        db.execSQL("insert into non_member VALUES (219, 'Vibhor Bansal', 'vibhorbansal@hotmail.com', '9833606346');");
        db.execSQL("insert into non_member VALUES (220, 'Sidhant Tibrewal', 'sudhantt2310@gmail.com', '7727928811');");
        db.execSQL("insert into non_member VALUES (221, 'Debmalya Sarkar', 'debmalya97@gmai.com', '9871126964');");
        db.execSQL("insert into non_member VALUES (222, 'Shubham Rayar', 'shubham.rayar@gmail.com', '9561396473');");
        db.execSQL("insert into non_member VALUES (223, 'Rajat Dwivedi', 'rajard100@gmail.com', '8296539852');");
        db.execSQL("insert into non_member VALUES (224, 'Nitesh Goyal', 'ngoyal111@gmail.com', '9740788650');");
        db.execSQL("insert into non_member VALUES (225, 'Akhil Vanukuri', 'akhil.vanukuri@gmail.com', '9573259861');");
        db.execSQL("insert into non_member VALUES (226, 'Hazlin D''Souza', 'hezlindsouza47@gmail.com', '8197120006');");
        db.execSQL("insert into non_member VALUES (227, 'Brajesh Maharajan', 'baje003@gamil.com', '7389695059');");
        db.execSQL("insert into non_member VALUES (228, 'Vrinda Ojha', 'vrinda.ojha@gmail.com', '8296539081');");
        db.execSQL("insert into non_member VALUES (229, 'Vaibhav Aggarwal', 'vaibhav.aggarwal98@gmail.com', '9958573996');");
        db.execSQL("insert into non_member VALUES (230, 'Ishaan Tehlan', 'ishaantehlan@ymail.com', '9992711477');");
        db.execSQL("insert into non_member VALUES (231, 'Arnav Gupta', 'arnavgupta73@yahoo.in', '8296538827');");
        db.execSQL("insert into non_member VALUES (232, 'Sanyam Juneja', 'sayamjuneja007@gmail.com', '8296540018');");
        db.execSQL("insert into non_member VALUES (233, 'Pushkar Raj Singh', 'prs.pokemon@gmail.com', '8296539047');");
        db.execSQL("insert into non_member VALUES (234, 'Attulya Singh', 'attulyasingh@gmail.com', '8826943907');");
        db.execSQL("insert into non_member VALUES (235, 'Somiya Singh Chhillar ', 'somiyachhillar@gmail.com', '8296540223');");
        db.execSQL("insert into non_member VALUES (236, 'Ishaan Narain ', 'ishaannarain1@gmail.com', '8296540228');");
        db.execSQL("insert into non_member VALUES (237, 'Amith Nair', 'amithnair.anair@gmail.com', '9765464203');");
        db.execSQL("insert into non_member VALUES (238, 'Shivaji Reddy', 'shivajireddy.d@gmail.com', '8296538908');");
        db.execSQL("insert into non_member VALUES (239, 'Rohan Tejaswi', 'rohantejaswi81@gmail.com', '9008559670');");
        db.execSQL("insert into non_member VALUES (240, 'Nandan Pai', 'nandan.pai98@gmail.com', '9482366304');");
        db.execSQL("insert into non_member VALUES (241, 'T Srilekha', 'srilekha014@gmail.com', '8884827374');");
        db.execSQL("insert into non_member VALUES (242, 'Shriya Dikshith', 'shriya5dxt@gmail.com', '7996977920');");
        db.execSQL("insert into non_member VALUES (243, 'Tarun Subramanian', 'tarunsubra98@gmail.com', '9551128822');");
        db.execSQL("insert into non_member VALUES (244, 'Preetham Raj Ramraj', 'preetham19.raj@gmail.com', '9823178542');");
        db.execSQL("insert into non_member VALUES (245, 'Sahaj Jain', 'jainsahaj583@gmail.com', '7415533770');");
        db.execSQL("insert into non_member VALUES (246, 'Srajan Gupta', 'srajan.gupta01@gmail.com', '7899743091');");
        db.execSQL("insert into non_member VALUES (247, 'sarthak agrawal', 'sarthakagrawalg31@gmail.com', '7822031270');");
        db.execSQL("insert into non_member VALUES (248, 'Gautam ', 'gautambhaskar505@gmail.com', '9620807280');");
        db.execSQL("insert into non_member VALUES (249, 'Sanora Gonsalves', 'sanora.gonsalves@gmail.com', '9663103704');");
        db.execSQL("insert into non_member VALUES (250, 'Neel Dani', 'neeldani98@gmail.com', '9664524526');");
        db.execSQL("insert into non_member VALUES (251, 'Abhishek Mishra', 'abhicancer.mishra@gmail.com', '8105784818');");
        db.execSQL("insert into non_member VALUES (252, 'Poorvi Goyal', 'poorvigoyal99@gmailcom', '9611642368');");
        db.execSQL("insert into non_member VALUES (253, 'Arjun Chauhan', 'arjunchau@gmail.com', '8239616262');");
        db.execSQL("insert into non_member VALUES (254, 'Chirag Varshney', 'chiragv196@gmail.com', '9971883895');");
        db.execSQL("insert into non_member VALUES (255, 'Pranav Sekhar', 'pranavsekhar10@gmail.com', '9493526790');");
        db.execSQL("insert into non_member VALUES (256, 'Daksha Ladia', 'ddladia58@hotmail.com', '9874252690');");
        db.execSQL("insert into non_member VALUES (257, 'Sanskriti', 'sanskritisangal@gmail.com', '789028288');");
        db.execSQL("insert into non_member VALUES (258, 'Sanket Srivastava', 'sanketsrivastava1504@gmail.com', '9109711883');");
*/
        Log.d(" ","3");

        db.execSQL("INSERT INTO member VALUES (103, 'Saptarshi Dutta', 'duttasaptarshi28@gmail.com', '7022885964', 'Tech', '1');");
        db.execSQL("INSERT INTO member VALUES (104, 'MJ Balaji', 'mjbalaji17@gmail.com', '8682075345', 'Dev', '1');");
        db.execSQL("INSERT INTO member VALUES (105, 'Hriday Chhabria', 'hridaykchhabria@gmail.com', '9833314293', 'Others', '1');");
        db.execSQL("INSERT INTO member VALUES (106, 'Swati Kanwal', 'kanwalswati97@gmail.com', '7838682122', 'Tech', '1');");
        db.execSQL("INSERT INTO member VALUES (107, 'Gokul Vuppumalla', 'loremipsum@gmail.com', '9008501419', 'Dev', '1');");
        db.execSQL("INSERT INTO member VALUES (108, 'Dheeraj Reddy', 'dheeraj98reddy@gmail.com', '7406998269', 'Web', '1');");
        db.execSQL("INSERT INTO member VALUES (109, 'Vedant Lodha', 'vedant.lodha@hotmail.com', '8084982582', 'Tech', '1');");
        db.execSQL("INSERT INTO member VALUES (110, 'Ananya Gupta', 'ananyagupta6@gmail.com', '9632021177', 'Design', '1');");
        db.execSQL("INSERT INTO member VALUES (111, 'P Sai Mandeep', 'kps.deepu6@gmail.com', '8296374549', 'Tech', '1');");
        db.execSQL("INSERT INTO member VALUES (112, 'Ravi Teja', 'ravi_teja9991516@yahoo.com', '9483513542', 'Dev', '1');");
        db.execSQL("INSERT INTO member VALUES (113, 'Supreeth Muduchetty', 'supreeth.mudduchetty@gmail.com', '8971673209', 'Others', '1');");
        db.execSQL("INSERT INTO member VALUES (114, 'Kavish Hukmani', 'khukmani@gmail.com', '9923095547', 'Tech', '1');");
        db.execSQL("INSERT INTO member VALUES (115, 'Shashwat Kumar', 'gonecase22.rk@gmail.com', '9071602985', 'Design', '1');");
        db.execSQL("INSERT INTO member VALUES (116, 'Snehashish Sourav', 'souravreddyhi@gmail.com', '9448003243', 'Others', '1');");
        db.execSQL("INSERT INTO member VALUES (117, 'Divyansh Gupta', 'divyanshguptabjr12@gmail.com', '8123244545', 'Tech', '1');");
        db.execSQL("INSERT INTO member VALUES (118, 'Naman Jain', 'namanjain10555@gmail.com', '8197160107', 'Tech', '1');");
        db.execSQL("INSERT INTO member VALUES (119, 'Japnit Singh', 'realjswalia@gmail.com', '7899046812', 'Web', '1');");
        db.execSQL("INSERT INTO member VALUES (120, 'Vidit Jain', 'vidjain.heritage@gmail.com', '9742251638', 'Others', '1');");
        db.execSQL("INSERT INTO member VALUES (121, 'Aditya Sharma', 'asamadhia@gmail.com', '7022884515', 'Tech', '1');");
        db.execSQL("INSERT INTO member VALUES (122, 'Banveen Singh', 'banveensingh@gmail.com', '7899046192', 'Web', '1');");
        db.execSQL("INSERT INTO member VALUES (123, 'Shravya Shetty', 'shravyajshetty67@gmail.com', '9448405303', 'Others', '1');");
        db.execSQL("INSERT INTO member VALUES (124, 'Abhimanyu Agarwal', 'abhimanyu601@icloud.com', '8130873091', 'Design', '1');");
        db.execSQL("INSERT INTO member VALUES (125, 'Agam Dogra', 'agamdogra1@gmail.com', '7022037352', 'Dev', '1');");
        db.execSQL("INSERT INTO member VALUES (126, 'Abhigyan Gogoi', 'abhigyan380@gmail.com', '8876857761', 'Tech', '1');");
        db.execSQL("INSERT INTO member VALUES (127, 'Idris M', 'droid.iddu@gmail.com', '8124578610', 'Web', '1');");
        db.execSQL("INSERT INTO member VALUES (128, 'Tarun Rath', 'loremipsum@gmail.com', '9920137477', 'Tech', '1');");
        db.execSQL("INSERT INTO member VALUES (129, 'iva surana', 'loremipsum@gmail.com', '8287712121', 'Others', '1');");
        db.execSQL("INSERT INTO member VALUES (130, 'shambhavi sarin', 'loremipsum@gmail.com', '7600856436', 'Web', '1');");
        db.execSQL("INSERT INTO member VALUES (131, 'shashank shekhar', 'loremipsum@gmail.com', '7026751347', 'Others', '1');");
        db.execSQL("INSERT INTO member VALUES (132, 'raghvendra singh', 'loremipsum@gmail.com', '9460290979', 'Dev', '1');");
        db.execSQL("INSERT INTO member VALUES (133, 'sai harsha', 'loremipsum@gmail.com', '8106482507', 'Tech', '1');");
        db.execSQL("INSERT INTO member VALUES (134, 'N sumanth', 'loremipsum@gmail.com', '7022886789', 'Web', '1');");
        db.execSQL("INSERT INTO member VALUES (135, 'Harsh verma', 'loremipsum@gmail.com', '9763721852', 'Tech', '1');");
        db.execSQL("INSERT INTO member VALUES (136, 'vamsi krishna', 'loremipsum@gmail.com', '9494154343', 'Design', '1');");
        db.execSQL("INSERT INTO member VALUES (137, 'M komal', 'loremipsum@gmail.com', '8500585798', 'Others', '1');");
        db.execSQL("INSERT INTO member VALUES (138, 'Swadha ', 'loremipsum@gmail.com', '9936890649', 'Others', '1');");
        db.execSQL("INSERT INTO member VALUES (139, 'mahima rao', 'loremipsum@gmail.com', '9148939292', 'Tech', '1');");
  /*      db.execSQL("INSERT INTO member VALUES (140, 'atul kr panday', 'loremipsum@gmail.com', '8296540102', 'Design', '1');");
        db.execSQL("INSERT INTO member VALUES (141, 'Vyshva manas', 'loremipsum@gmail.com', '8106255390', 'Tech', '1');");
        db.execSQL("INSERT INTO member VALUES (142, 'pashchima ', 'loremipsum@gmail.com', '9167758106', 'Dev', '1');");
        db.execSQL("INSERT INTO member VALUES (143, 'pranav', 'loremipsum@gmail.com', '8454048232', 'Tech', '1');");
        db.execSQL("INSERT INTO member VALUES (144, 'richa elangovan', 'loremipsum@gmail.com', '7338110619', 'Tech', '1');");
        db.execSQL("INSERT INTO member VALUES (145, 'pranav dvgl', 'loremipsum@gmail.com', '9346339850', 'Design', '1');");
        db.execSQL("INSERT INTO member VALUES (146, 'mucherla kareeti', 'loremipsum@gmail.com', '9494050139', 'Dev', '1');");
        db.execSQL("INSERT INTO member VALUES (147, 'G sai krishan', 'loremipsum@gmail.com', '7022885934', 'Web', '1');");
        db.execSQL("INSERT INTO member VALUES (148, 'divij agarwal', 'loremipsum@gmail.com', '9769928298', 'Design', '1');");
        db.execSQL("INSERT INTO member VALUES (149, 'angad singh', 'loremipsum@gmail.com', '9730070707', 'Web', '1');");
        db.execSQL("INSERT INTO member VALUES (150, 'amrit goiyal', 'loremipsum@gmail.com', '9880686775', 'Web', '1');");
        db.execSQL("INSERT INTO member VALUES (151, 'navneet sajith', 'loremipsum@gmail.com', '9902933039', 'Dev', '1');");
        db.execSQL("INSERT INTO member VALUES (152, 'aniruddha paranjape', 'loremipsum@gmail.com', '9686056200', 'Design', '1');");
        db.execSQL("INSERT INTO member VALUES (153, 'chantal D', 'loremipsum@gmail.com', '9742287188', 'Tech', '1');");
        db.execSQL("INSERT INTO member VALUES (154, 'sarthak mittal ', 'loremipsum@gmail.com', '9810768410', 'Web', '1');");
        db.execSQL("INSERT INTO member VALUES (155, 'darshini p', 'loremipsum@gmail.com', '8179421275', 'Others', '1');");
        db.execSQL("INSERT INTO member VALUES (156, 's r n rayudu', 'loremipsum@gmail.com', '9573593123', 'Dev', '1');");
        db.execSQL("INSERT INTO member VALUES (157, 'pawan vasanth', 'loremipsum@gmail.com', '9490897947', 'Tech', '1');");
        db.execSQL("INSERT INTO member VALUES (158, 'soham paul', 'loremipsum@gmail.com', '8296538801', 'Others', '1');");
        db.execSQL("INSERT INTO member VALUES (159, 'athul dinesh', 'loremipsum@gmail.com', '7795910215', 'Design', '1');");
        db.execSQL("INSERT INTO member VALUES (160, 'gaurangi gupta', 'loremipsum@gmail.com', '8296374522', 'Tech', '1');");
        db.execSQL("INSERT INTO member VALUES (161, 'ritika nandi ', 'loremipsum@gmail.com', '9958179858', 'Others', '1');");
        db.execSQL("INSERT INTO member VALUES (162, 'Zoya junaid', 'loremipsum@gmail.com', '7348902598', 'Design', '1');");
        db.execSQL("INSERT INTO member VALUES (163, 'Sahil garg', 'loremipsum@gmail.com', '8792062027', 'Tech', '1');");
        db.execSQL("INSERT INTO member VALUES (164, 'aditya kumar ', 'loremipsum@gmail.com', '8296539410', 'Dev', '1');");
        db.execSQL("INSERT INTO member VALUES (165, 'sasnika ', 'loremipsum@gmail.com', '9087758012', 'Others', '1');");
        db.execSQL("INSERT INTO member VALUES (166, 'aditya av', 'loremipsum@gmail.com', '9441534599', 'Tech', '1');");
        db.execSQL("INSERT INTO member VALUES (167, 'harkaram singh', 'loremipsum@gmail.com', '7340916522', 'Dev', '1');");
        db.execSQL("INSERT INTO member VALUES (168, 'somansh reddy', 'loremipsum@gmail.com', '9959525552', 'Others', '1');");
        db.execSQL("INSERT INTO member VALUES (169, 'abhay kumar', 'loremipsum@gmail.com', '9521871926', 'Tech', '1');");
        db.execSQL("INSERT INTO member VALUES (170, 'pranjal sinha', 'loremipsum@gmail.com', '9676540170', 'Web', '1');");
        db.execSQL("INSERT INTO member VALUES (171, 'kartik shah', 'loremipsum@gmail.com', '8819000062', 'Design', '1');");
        db.execSQL("INSERT INTO member VALUES (172, 'shubhang yadav', 'loremipsum@gmail.com', '8296539901', 'Tech', '1');");
        db.execSQL("INSERT INTO member VALUES (173, 'abhishek shukla', 'loremipsum@gmail.com', '9920980072', 'Dev', '1');");
        db.execSQL("INSERT INTO member VALUES (174, 'swetha sairam', 'loremipsum@gmail.com', '9663962608', 'Others', '1');");
        db.execSQL("INSERT INTO member VALUES (175, 'raghav shrivastav', 'loremipsum@gmail.com', '8296540114', 'Tech', '1');");
        db.execSQL("INSERT INTO member VALUES (176, 'suwigya gutgutia', 'loremipsum@gmail.com', '8986667171', 'Design', '1');");
        db.execSQL("INSERT INTO member VALUES (177, 'asmita samanta', 'loremipsum@gmail.com', '8296539854', 'Design', '1');");
        db.execSQL("INSERT INTO member VALUES (178, 'darini hariharan', 'loremipsum@gmail.com', '9487090777', 'Tech', '1');");
        db.execSQL("INSERT INTO member VALUES (179, 'dhruva agrawal', 'loremipsum@gmail.com', '9819157676', 'Dev', '1');");
        db.execSQL("INSERT INTO member VALUES (180, 'anurag roy', 'loremipsum@gmail.com', '9004033039', 'Design', '1');");
        db.execSQL("INSERT INTO member VALUES (181, 'amit prabhu', 'loremipsum@gmail.com', '9513391410', 'Tech', '1');");
        db.execSQL("INSERT INTO member VALUES (182, 'ishita jalan', 'loremipsum@gmail.com', '9414046691', 'Dev', '1');");
        db.execSQL("INSERT INTO member VALUES (183, 'vansh sodhi', 'loremipsum@gmail.com', '9412705521', 'Others', '1');");
        db.execSQL("INSERT INTO member VALUES (184, 'anitej palakoditi', 'loremipsum@gmail.com', '9769012760', 'Tech', '1');");
        db.execSQL("INSERT INTO member VALUES (185, 'agrim gupta', 'loremipsum@gmail.com', '7838088314', 'Dev', '1');");
        db.execSQL("INSERT INTO member VALUES (186, 'anirudh pandey', 'loremipsum@gmail.com', '9451313833', 'Web', '1');");
        db.execSQL("INSERT INTO member VALUES (187, 'ayush dwivedi', 'loremipsum@gmail.com', '9479690105', 'Tech', '1');");
        db.execSQL("INSERT INTO member VALUES (188, 'rudraksh haran', 'loremipsum@gmail.com', '7567869400', 'Design', '1');");
        db.execSQL("INSERT INTO member VALUES (189, 'druti singh', 'loremipsum@gmail.com', '7080917413', 'Tech', '1');");
        db.execSQL("INSERT INTO member VALUES (190, 'khyati ', 'loremipsum@gmail.com', '9988261592', 'Dev', '1');");
        db.execSQL("INSERT INTO member VALUES (191, 'naman diwan', 'loremipsum@gmail.com', '8296374693', 'Others', '1');");
        db.execSQL("INSERT INTO member VALUES (192, 'vanshika kumar', 'loremipsum@gmail.com', '7022884534', 'Tech', '1');");
        db.execSQL("INSERT INTO member VALUES (193, 'mirnasree k', 'loremipsum@gmail.com', '7899861027', 'Design', '1');");
        db.execSQL("INSERT INTO member VALUES (194, 'ritika kole', 'loremipsum@gmail.com', '8123717122', 'Others', '1');");
        db.execSQL("INSERT INTO member VALUES (195, 'ayushi jha', 'loremipsum@gmail.com', '9819846206', 'Tech', '1');");
        db.execSQL("INSERT INTO member VALUES (196, 'ojasvi agarwal', 'loremipsum@gmail.com', '9828467257', 'Tech', '1');");
        db.execSQL("INSERT INTO member VALUES (197, 'lipika garg', 'loremipsum@gmail.com', '9818818167', 'Web', '1');");
        db.execSQL("INSERT INTO member VALUES (198, 'dheeraj acharya', 'loremipsum@gmail.com', '8722403035', 'Others', '1');");
        db.execSQL("INSERT INTO member VALUES (199, 'vipul sureka', 'loremipsum@gmail.com', '9035502003', 'Tech', '1');");
        db.execSQL("INSERT INTO member VALUES (200, 'guru prasad', 'loremipsum@gmail.com', '7022884935', 'Web', '1');");
        db.execSQL("INSERT INTO member VALUES (201, 'parv kapoor', 'loremipsum@gmail.com', '9001227998', 'Others', '1');");
        db.execSQL("INSERT INTO member VALUES (202, 'divya manjuna', 'loremipsum@gmail.com', '9049000585', 'Design', '1');");
        db.execSQL("INSERT INTO member VALUES (203, 'harneet kanuja', 'loremipsum@gmail.com', '7353021100', 'Dev', '1');");
        db.execSQL("INSERT INTO member VALUES (204, 'shantanu das', 'loremipsum@gmail.com', '7229027462', 'Tech', '1');");

*/
        Log.d(" ","4");
        db.execSQL("INSERT INTO member VALUES ( 205, 'Aditya Sai', 'adityasai24@gmail.com', '9108768254', 'Tech','2');");
        db.execSQL("INSERT INTO member VALUES ( 206, 'Akash sharma', 'akash1502@gmail.com', '7760707354', 'Dev','2');");
        db.execSQL("INSERT INTO member VALUES ( 207, 'Snigdha Shekhar', 's.shekar0564@gmail.com', '9008139427', 'Others','2');");
        db.execSQL("INSERT INTO member VALUES ( 208, 'Rohit Girdhar ', 'rohitgird12@gmail.com', '9868320971', 'Tech','2');");
        db.execSQL("INSERT INTO member VALUES ( 209, 'Mayank Raj', 'rmayank331@gmail.com', '8880097376', 'Dev','2');");
        db.execSQL("INSERT INTO member VALUES ( 210, 'Shikha Verma', 'shikhav97@gmail.com', '9008214706', 'Web','2');");
        db.execSQL("INSERT INTO member VALUES ( 211, 'Abhishree Shetty', 'abhishreeshetty48@gmail.com', '8762264117', 'Tech','2');");
        db.execSQL("INSERT INTO member VALUES ( 212, 'Ayushi Shrivastava', 'ayushi.0101@gmail.com', '7073268875', 'Design','2');");
        db.execSQL("INSERT INTO member VALUES ( 213, 'moinak mukherjee', 'monik2701@gmail.com', '9591968566', 'Tech','2');");
        db.execSQL("INSERT INTO member VALUES ( 214, 'Akshay Agarwal', 'akshay4241@gmail.com', '8285457388', 'Dev','2');");
        db.execSQL("INSERT INTO member VALUES ( 215, 'Mayank Taneja', 'mayank.taneja09@gmail.com', '8377881476', 'Others','2');");
        db.execSQL("INSERT INTO member VALUES ( 216, 'Achlendra Singh', 'achlendra.ausum@gmail.com', '9164616053', 'Tech','2');");
        db.execSQL("INSERT INTO member VALUES ( 217, 'Umang Raj', 'um281296@yahoo.in', '7739606239', 'Design','2');");
        db.execSQL("INSERT INTO member VALUES ( 218, 'Abhishek Thanki', 'razr911@gmail.com', '9538388911', 'Others','2');");
        db.execSQL("INSERT INTO member VALUES ( 219, 'Thrishul MS', 'thrishul.m.s007@gmail.com', '9481074729', 'Tech','2');");
        db.execSQL("INSERT INTO member VALUES ( 220, 'Udaya Kumar', 'udayakumar97@gmail.com', '9980367385', 'Tech','2');");
        db.execSQL("INSERT INTO member VALUES ( 221, 'Tushar Shahi', 'shahitushar50@gmail.com', '7760877468', 'Web','2');");
        db.execSQL("INSERT INTO member VALUES ( 222, 'Daksh Taneja', 'daksh18121996@gmail.com', '9811029377', 'Others','2');");
  /*      db.execSQL("INSERT INTO member VALUES ( 223, 'Anshul Jain', 'aj2197@gmail.com', '9833528662', 'Tech','2');");
        db.execSQL("INSERT INTO member VALUES ( 224, 'Ankith parphu', 'prabhu.ankith@gmail.com', '9945401998', 'Web','2');");
        db.execSQL("INSERT INTO member VALUES ( 225, 'Sahan shams', 'shams@gmail.com', '9901631898', 'Others','2');");
        db.execSQL("INSERT INTO member VALUES ( 226, 'Anshul Mankani', 'mankanianshul@gmail.com', '9535020186', 'Design','2');");
        db.execSQL("INSERT INTO member VALUES ( 227, 'Kartikui Agarwal', 'kartikui04.05@gmail.com', '7800054554', 'Dev','2');");
        db.execSQL("INSERT INTO member VALUES ( 228, 'Bamshik Shetty', 'bamshikdshetty@gmail.com', '9448952926', 'Tech','2');");
        db.execSQL("INSERT INTO member VALUES ( 229, 'Ronald Das', 'ronald1das@gmail.com', '8290668260', 'Web','2');");
        db.execSQL("INSERT INTO member VALUES ( 230, 'Abhishek Mitra', 'aphishek.mitra.a1@gmail.com', '8951591046', 'Tech','2');");
        db.execSQL("INSERT INTO member VALUES ( 231, 'Vipul Johri', 'vipuljohrimit@gmail.com', '9591970284', 'Others','2');");
        db.execSQL("INSERT INTO member VALUES ( 232, 'ruik Kamiliya', 'ruickkamiliya@gmail.com', '9830801060', 'Web','2');");
        db.execSQL("INSERT INTO member VALUES ( 233, 'Rishabh Gupta', 'rishabhgupta26081996@yahoo.com', '8961682172', 'Others','2');");
        db.execSQL("INSERT INTO member VALUES ( 234, 'Aman Singh', 'singh96aman@gmail.com', '7388224982', 'Dev','2');");
        db.execSQL("INSERT INTO member VALUES ( 235, 'Utkarsh Tripathi', 'tri.utkarsh7596@gmail.com', '7607268279', 'Tech','2');");
        db.execSQL("INSERT INTO member VALUES ( 236, 'Anand Ranjan', 'ranjananand00825@gmail.com', '7091318745', 'Web','2');");
        db.execSQL("INSERT INTO member VALUES ( 237, 'Omkar Pradhan', 'omkar.k.pradhan@gmail.com', '9757438946', 'Tech','2');");
        db.execSQL("INSERT INTO member VALUES ( 238, 'Paridhi Sirohi', 'paridhisirohi@gmail.com', '8500532259', 'Design','2');");
        db.execSQL("INSERT INTO member VALUES ( 239, 'Ujjwak vivek', 'nightfireuk007@gmail.com', '7760645890', 'Others','2');");
        db.execSQL("INSERT INTO member VALUES ( 240, 'Shaurya Veersingh', 'shauryaveer97@yahoo.in', '8397904458', 'Others','2');");
        db.execSQL("INSERT INTO member VALUES ( 241, 'Deepti Narayan', 'deeptinarayan1@gmail.com', '9591968288', 'Tech','2');");
        db.execSQL("INSERT INTO member VALUES ( 242, 'Sidharth sahoo', 'sidharthfriend4u@gmail.com', '9008122674', 'Design','2');");
        db.execSQL("INSERT INTO member VALUES ( 243, 'Davamrit Mohanty', 'devamrit53@gmail.com', '7738385067', 'Tech','2');");
        db.execSQL("INSERT INTO member VALUES ( 244, 'Apoorv Pareek', 'apoorvasweetboy@gmail.com', '9772201588', 'Dev','2');");
        db.execSQL("INSERT INTO member VALUES ( 245, 'Akshaj Verma', 'akshajverma7@gmail.com', '9591971854', 'Tech','2');");
        db.execSQL("INSERT INTO member VALUES ( 246, 'Anvesha saxena', 'isha09skt@gmail.com', '7760876545', 'Tech','2');");
        db.execSQL("INSERT INTO member VALUES ( 247, 'Rohan Deshmukh', 'deshmukh.rohan06@gmail.com', '9618605508', 'Design','2');");
        db.execSQL("INSERT INTO member VALUES ( 248, 'Abhishek Vora', 'abhivora8@gmail.com', '7760919887', 'Dev','2');");
        db.execSQL("INSERT INTO member VALUES ( 249, 'Suyash Singh', 'suyash6@gmail.com', '7760680293', 'Web','2');");
        db.execSQL("INSERT INTO member VALUES ( 250, 'Praggwal Rai', 'praggwalrai.11@gmail.com', '8548063440', 'Design','2');");
        db.execSQL("INSERT INTO member VALUES ( 251, 'Aditi Krishna', 'aditisingh71@gmail.com', '9901691136', 'Web','2');");
        db.execSQL("INSERT INTO member VALUES ( 252, 'Akshat Garg', 'gargakshat98@gmail.com', '8976475260', 'Web','2');");
        db.execSQL("INSERT INTO member VALUES ( 253, 'Deigant Yadava', 'deigant1998@gmail.com', '7760916750', 'Dev','2');");
        db.execSQL("INSERT INTO member VALUES ( 254, 'Arunesh Kumar', 'arunesh.indianrockz@gmail.com', '7760710312', 'Design','2');");
        db.execSQL("INSERT INTO member VALUES ( 255, 'Ankit Gohel', 'ankitgohel1996@gmail.com', '9108768420', 'Tech','2');");
*/
        Log.d("","54");

        db.execSQL("INSERT INTO member VALUES ( 256, 'Kaivan Shah', 'kaivanshah97@gmail.com', '9769225951', 'Others', '3');");
        db.execSQL("INSERT INTO member VALUES ( 257,'Helik Thacker', 'thackerhelik@gmail.com', '8082365098', 'Tech', '3');");
        db.execSQL("INSERT INTO member VALUES ( 258,'Owais Khan', 'Okhan141@gmail.com', '9591804611', 'Dev', '3');");
        db.execSQL("INSERT INTO member VALUES ( 259,'Gauri Varma', 'vgauri1797@gmail.com', '8527901505', 'Others', '3');");
        db.execSQL("INSERT INTO member VALUES ( 260,'Vishtasp Meherhomji', 'vishtasp.sm@gmail.com', '9870188858', 'Tech', '3');");
        db.execSQL("INSERT INTO member VALUES ( 261,'Eshan Trivedi', 'eshanntrivedi@gmail.com', '9654169957', 'Web', '3');");
        db.execSQL("INSERT INTO member VALUES ( 262,'Padmanabh Gupta', 'padmanabh14@gmail.com', '9650718542', 'Design', '3');");
        db.execSQL("INSERT INTO member VALUES ( 263,'Ayushman Dey', 'ayushman.dey97@gmail.com', '9871418609', 'Tech', '3');");
        db.execSQL("INSERT INTO member VALUES ( 264,'Bikram Jeet Singh', 'robby15singh@gmail.com', '8050296236', 'Dev', '3');");
        db.execSQL("INSERT INTO member VALUES ( 265,'Meghana Dharmapuri', 'meghanadharmapuri@gmail.com', '8195881777', 'Others', '3');");
        db.execSQL("INSERT INTO member VALUES ( 266,'Anjana Harinaran', 'anjana.harinnan@gmail.com', '7259400331', 'Tech', '3');");
        db.execSQL("INSERT INTO member VALUES ( 267,'Sai Aravind', 'aravind.krishnan.mit@gmail.com', '8050297127', 'Design', '3');");
        db.execSQL("INSERT INTO member VALUES ( 268,'Sarthak Kukreja', 'kukreja_sarthak@yahoo.com', '7760916421', 'Design', '3');");
        db.execSQL("INSERT INTO member VALUES ( 269,'Nadella Sai Kalyan', 'saikalyan384@gmail.com', '9908410766', 'Tech', '3');");
        db.execSQL("INSERT INTO member VALUES ( 270,'Disha Roy', 'disha.roy1997@gmail.com', '7760916870', 'Dev', '3');");
        db.execSQL("INSERT INTO member VALUES ( 271,'Sidharth Menon', 'sidharthmenon@icloud.com', '7259492226', 'Design', '3');");
        db.execSQL("INSERT INTO member VALUES ( 272,'Saumya Bahukhandi', 'saumyabahu@gmail.com', '9643483654', 'Others', '3');");
        db.execSQL("INSERT INTO member VALUES ( 273,'Amit Vyas', '23amitvyas@gmail.com', '8861375764', 'Others', '3');");

        Log.d(" ","7");

        db.execSQL("INSERT INTO member VALUES (0, 'Non-Member', 'null-email@nomail.com', '00000000','Others','0');");
        db.execSQL("INSERT INTO member VALUES (1, 'Saptarshi Dutta', 'duttasaptarshi28@gmail.com', '7022885964', 'Tech', '0');");
        db.execSQL("INSERT INTO member VALUES (2, 'MJ Balaji', 'mjbalaji17@gmail.com', '8682075345', 'Dev', '0');");
        db.execSQL("INSERT INTO member VALUES (3, 'Hriday Chhabria', 'hridaykchhabria@gmail.com', '9833314293', 'Others', '0');");
        db.execSQL("INSERT INTO member VALUES (4, 'Swati Kanwal', 'kanwalswati97@gmail.com', '7838682122', 'Tech', '0');");
        db.execSQL("INSERT INTO member VALUES (5, 'Gokul Vuppumalla', 'loremipsum@gmail.com', '9008501419', 'Dev', '0');");
        db.execSQL("INSERT INTO member VALUES (6, 'Dheeraj Reddy', 'dheeraj98reddy@gmail.com', '7406998269', 'Web', '0');");
        db.execSQL("INSERT INTO member VALUES (7, 'Vedant Lodha', 'vedant.lodha@hotmail.com', '8084982582', 'Tech', '0');");
        db.execSQL("INSERT INTO member VALUES (8, 'Ananya Gupta', 'ananyagupta6@gmail.com', '9632021177', 'Design', '0');");
        db.execSQL("INSERT INTO member VALUES (9, 'P Sai Mandeep', 'kps.deepu6@gmail.com', '8296374549', 'Tech', '0');");
        db.execSQL("INSERT INTO member VALUES (10, 'Ravi Teja', 'ravi_teja9991516@yahoo.com', '9483513542', 'Dev', '0');");
        db.execSQL("INSERT INTO member VALUES (11, 'Supreeth Muduchetty', 'supreeth.mudduchetty@gmail.com', '8971673209', 'Others', '0');");
        db.execSQL("INSERT INTO member VALUES (12, 'Kavish Hukmani', 'khukmani@gmail.com', '9923095547', 'Tech', '0');");
        db.execSQL("INSERT INTO member VALUES (13, 'Shashwat Kumar', 'gonecase22.rk@gmail.com', '9071602985', 'Design', '0');");
        db.execSQL("INSERT INTO member VALUES (14, 'Snehashish Sourav', 'souravreddyhi@gmail.com', '9448003243', 'Others', '0');");
        db.execSQL("INSERT INTO member VALUES (15, 'Divyansh Gupta', 'divyanshguptabjr12@gmail.com', '8123244545', 'Tech', '0');");
        db.execSQL("INSERT INTO member VALUES (16, 'Naman Jain', 'namanjain10555@gmail.com', '8197160107', 'Tech', '0');");
        db.execSQL("INSERT INTO member VALUES (17, 'Japnit Singh', 'realjswalia@gmail.com', '7899046812', 'Web', '0');");
        db.execSQL("INSERT INTO member VALUES (18, 'Vidit Jain', 'vidjain.heritage@gmail.com', '9742251638', 'Others', '0');");
        db.execSQL("INSERT INTO member VALUES (19, 'Aditya Sharma', 'asamadhia@gmail.com', '7022884515', 'Tech', '0');");
        db.execSQL("INSERT INTO member VALUES (20, 'Banveen Singh', 'banveensingh@gmail.com', '7899046192', 'Web', '0');");
        db.execSQL("INSERT INTO member VALUES (21, 'Shravya Shetty', 'shravyajshetty67@gmail.com', '9448405303', 'Others', '0');");
        db.execSQL("INSERT INTO member VALUES (22, 'Abhimanyu Agarwal', 'abhimanyu601@icloud.com', '8130873091', 'Design', '0');");
        db.execSQL("INSERT INTO member VALUES (23, 'Agam Dogra', 'agamdogra1@gmail.com', '7022037352', 'Dev', '0');");
        db.execSQL("INSERT INTO member VALUES (24, 'Abhigyan Gogoi', 'abhigyan380@gmail.com', '8876857761', 'Tech', '0');");
        db.execSQL("INSERT INTO member VALUES (25, 'Idris M', 'droid.iddu@gmail.com', '8124578610', 'Web', '0');");
        db.execSQL("INSERT INTO member VALUES (26, 'Tarun Rath', 'loremipsum@gmail.com', '9920137477', 'Tech', '0');");
        db.execSQL("INSERT INTO member VALUES (27, 'iva surana', 'loremipsum@gmail.com', '8287712121', 'Others', '0');");
        db.execSQL("INSERT INTO member VALUES (28, 'shambhavi sarin', 'loremipsum@gmail.com', '7600856436', 'Web', '0');");
        db.execSQL("INSERT INTO member VALUES (29, 'shashank shekhar', 'loremipsum@gmail.com', '7026751347', 'Others', '0');");
        db.execSQL("INSERT INTO member VALUES (30, 'raghvendra singh', 'loremipsum@gmail.com', '9460290979', 'Dev', '0');");
        db.execSQL("INSERT INTO member VALUES (31, 'sai harsha', 'loremipsum@gmail.com', '8106482507', 'Tech', '0');");
        db.execSQL("INSERT INTO member VALUES (32, 'N sumanth', 'loremipsum@gmail.com', '7022886789', 'Web', '0');");
        db.execSQL("INSERT INTO member VALUES (33, 'Harsh verma', 'loremipsum@gmail.com', '9763721852', 'Tech', '0');");
        db.execSQL("INSERT INTO member VALUES (34, 'vamsi krishna', 'loremipsum@gmail.com', '9494154343', 'Design', '0');");
        db.execSQL("INSERT INTO member VALUES (35, 'M komal', 'loremipsum@gmail.com', '8500585798', 'Others', '0');");
        db.execSQL("INSERT INTO member VALUES (36, 'Swadha ', 'loremipsum@gmail.com', '9936890649', 'Others', '0');");
        db.execSQL("INSERT INTO member VALUES (37, 'mahima rao', 'loremipsum@gmail.com', '9148939292', 'Tech', '0');");
        db.execSQL("INSERT INTO member VALUES (38, 'atul kr panday', 'loremipsum@gmail.com', '8296540102', 'Design', '0');");
        db.execSQL("INSERT INTO member VALUES (39, 'Vyshva manas', 'loremipsum@gmail.com', '8106255390', 'Tech', '0');");
        db.execSQL("INSERT INTO member VALUES (40, 'pashchima ', 'loremipsum@gmail.com', '9167758106', 'Dev', '0');");
        db.execSQL("INSERT INTO member VALUES (41, 'pranav', 'loremipsum@gmail.com', '8454048232', 'Tech', '0');");
        db.execSQL("INSERT INTO member VALUES (42, 'richa elangovan', 'loremipsum@gmail.com', '7338110619', 'Tech', '0');");
        db.execSQL("INSERT INTO member VALUES (43, 'pranav dvgl', 'loremipsum@gmail.com', '9346339850', 'Design', '0');");
        db.execSQL("INSERT INTO member VALUES (44, 'mucherla kareeti', 'loremipsum@gmail.com', '9494050139', 'Dev', '0');");
        db.execSQL("INSERT INTO member VALUES (45, 'G sai krishan', 'loremipsum@gmail.com', '7022885934', 'Web', '0');");
        db.execSQL("INSERT INTO member VALUES (46, 'divij agarwal', 'loremipsum@gmail.com', '9769928298', 'Design', '0');");
        db.execSQL("INSERT INTO member VALUES (47, 'angad singh', 'loremipsum@gmail.com', '9730070707', 'Web', '0');");
        db.execSQL("INSERT INTO member VALUES (48, 'amrit goiyal', 'loremipsum@gmail.com', '9880686775', 'Web', '0');");
        db.execSQL("INSERT INTO member VALUES (49, 'navneet sajith', 'loremipsum@gmail.com', '9902933039', 'Dev', '0');");
        db.execSQL("INSERT INTO member VALUES (50, 'aniruddha paranjape', 'loremipsum@gmail.com', '9686056200', 'Design', '0');");
        db.execSQL("INSERT INTO member VALUES (51, 'chantal D', 'loremipsum@gmail.com', '9742287188', 'Tech', '0');");
        db.execSQL("INSERT INTO member VALUES (52, 'sarthak mittal ', 'loremipsum@gmail.com', '9810768410', 'Web', '0');");
        db.execSQL("INSERT INTO member VALUES (53, 'darshini p', 'loremipsum@gmail.com', '8179421275', 'Others', '0');");
        db.execSQL("INSERT INTO member VALUES (54, 's r n rayudu', 'loremipsum@gmail.com', '9573593123', 'Dev', '0');");
        db.execSQL("INSERT INTO member VALUES (55, 'pawan vasanth', 'loremipsum@gmail.com', '9490897947', 'Tech', '0');");
/*        db.execSQL("INSERT INTO member VALUES (56, 'soham paul', 'loremipsum@gmail.com', '8296538801', 'Others', '0');");
        db.execSQL("INSERT INTO member VALUES (57, 'athul dinesh', 'loremipsum@gmail.com', '7795910215', 'Design', '0');");
        db.execSQL("INSERT INTO member VALUES (58, 'gaurangi gupta', 'loremipsum@gmail.com', '8296374522', 'Tech', '0');");
        db.execSQL("INSERT INTO member VALUES (59, 'ritika nandi ', 'loremipsum@gmail.com', '9958179858', 'Others', '0');");
        db.execSQL("INSERT INTO member VALUES (60, 'Zoya junaid', 'loremipsum@gmail.com', '7348902598', 'Design', '0');");
        db.execSQL("INSERT INTO member VALUES (61, 'Sahil garg', 'loremipsum@gmail.com', '8792062027', 'Tech', '0');");
        db.execSQL("INSERT INTO member VALUES (62, 'aditya kumar ', 'loremipsum@gmail.com', '8296539410', 'Dev', '0');");
        db.execSQL("INSERT INTO member VALUES (63, 'sasnika ', 'loremipsum@gmail.com', '9087758012', 'Others', '0');");
        db.execSQL("INSERT INTO member VALUES (64, 'aditya av', 'loremipsum@gmail.com', '9441534599', 'Tech', '0');");
        db.execSQL("INSERT INTO member VALUES (65, 'harkaram singh', 'loremipsum@gmail.com', '7340916522', 'Dev', '0');");
        db.execSQL("INSERT INTO member VALUES (66, 'somansh reddy', 'loremipsum@gmail.com', '9959525552', 'Others', '0');");
        db.execSQL("INSERT INTO member VALUES (67, 'abhay kumar', 'loremipsum@gmail.com', '9521871926', 'Tech', '0');");
        db.execSQL("INSERT INTO member VALUES (68, 'pranjal sinha', 'loremipsum@gmail.com', '9676540170', 'Web', '0');");
        db.execSQL("INSERT INTO member VALUES (69, 'kartik shah', 'loremipsum@gmail.com', '8819000062', 'Design', '0');");
        db.execSQL("INSERT INTO member VALUES (70, 'shubhang yadav', 'loremipsum@gmail.com', '8296539901', 'Tech', '0');");
        db.execSQL("INSERT INTO member VALUES (71, 'abhishek shukla', 'loremipsum@gmail.com', '9920980072', 'Dev', '0');");
        db.execSQL("INSERT INTO member VALUES (72, 'swetha sairam', 'loremipsum@gmail.com', '9663962608', 'Others', '0');");
        db.execSQL("INSERT INTO member VALUES (73, 'raghav shrivastav', 'loremipsum@gmail.com', '8296540114', 'Tech', '0');");
        db.execSQL("INSERT INTO member VALUES (74, 'suwigya gutgutia', 'loremipsum@gmail.com', '8986667171', 'Design', '0');");
        db.execSQL("INSERT INTO member VALUES (75, 'asmita samanta', 'loremipsum@gmail.com', '8296539854', 'Design', '0');");
        db.execSQL("INSERT INTO member VALUES (76, 'darini hariharan', 'loremipsum@gmail.com', '9487090777', 'Tech', '0');");
        db.execSQL("INSERT INTO member VALUES (77, 'dhruva agrawal', 'loremipsum@gmail.com', '9819157676', 'Dev', '0');");
        db.execSQL("INSERT INTO member VALUES (78, 'anurag roy', 'loremipsum@gmail.com', '9004033039', 'Design', '0');");
        db.execSQL("INSERT INTO member VALUES (79, 'amit prabhu', 'loremipsum@gmail.com', '9513391410', 'Tech', '0');");
        db.execSQL("INSERT INTO member VALUES (80, 'ishita jalan', 'loremipsum@gmail.com', '9414046691', 'Dev', '0');");
        db.execSQL("INSERT INTO member VALUES (81, 'vansh sodhi', 'loremipsum@gmail.com', '9412705521', 'Others', '0');");
        db.execSQL("INSERT INTO member VALUES (82, 'anitej palakoditi', 'loremipsum@gmail.com', '9769012760', 'Tech', '0');");
        db.execSQL("INSERT INTO member VALUES (83, 'agrim gupta', 'loremipsum@gmail.com', '7838088314', 'Dev', '0');");
        db.execSQL("INSERT INTO member VALUES (84, 'anirudh pandey', 'loremipsum@gmail.com', '9451313833', 'Web', '0');");
        db.execSQL("INSERT INTO member VALUES (85, 'ayush dwivedi', 'loremipsum@gmail.com', '9479690105', 'Tech', '0');");
        db.execSQL("INSERT INTO member VALUES (86, 'rudraksh haran', 'loremipsum@gmail.com', '7567869400', 'Design', '0');");
        db.execSQL("INSERT INTO member VALUES (87, 'druti singh', 'loremipsum@gmail.com', '7080917413', 'Tech', '0');");
        db.execSQL("INSERT INTO member VALUES (88, 'khyati ', 'loremipsum@gmail.com', '9988261592', 'Dev', '0');");
        db.execSQL("INSERT INTO member VALUES (89, 'naman diwan', 'loremipsum@gmail.com', '8296374693', 'Others', '0');");
        db.execSQL("INSERT INTO member VALUES (90, 'vanshika kumar', 'loremipsum@gmail.com', '7022884534', 'Tech', '0');");
        db.execSQL("INSERT INTO member VALUES (91, 'mirnasree k', 'loremipsum@gmail.com', '7899861027', 'Design', '0');");
        db.execSQL("INSERT INTO member VALUES (92, 'ritika kole', 'loremipsum@gmail.com', '8123717122', 'Others', '0');");
        db.execSQL("INSERT INTO member VALUES (93, 'ayushi jha', 'loremipsum@gmail.com', '9819846206', 'Tech', '0');");
        db.execSQL("INSERT INTO member VALUES (94, 'ojasvi agarwal', 'loremipsum@gmail.com', '9828467257', 'Tech', '0');");
        db.execSQL("INSERT INTO member VALUES (95, 'lipika garg', 'loremipsum@gmail.com', '9818818167', 'Web', '0');");
        db.execSQL("INSERT INTO member VALUES (96, 'dheeraj acharya', 'loremipsum@gmail.com', '8722403035', 'Others', '0');");
        db.execSQL("INSERT INTO member VALUES (97, 'vipul sureka', 'loremipsum@gmail.com', '9035502003', 'Tech', '0');");
        db.execSQL("INSERT INTO member VALUES (98, 'guru prasad', 'loremipsum@gmail.com', '7022884935', 'Web', '0');");
        db.execSQL("INSERT INTO member VALUES (99, 'parv kapoor', 'loremipsum@gmail.com', '9001227998', 'Others', '0');");
        db.execSQL("INSERT INTO member VALUES (100, 'divya manjuna', 'loremipsum@gmail.com', '9049000585', 'Design', '0');");
  */      db.execSQL("INSERT INTO member VALUES (101, 'harneet kanuja', 'loremipsum@gmail.com', '7353021100', 'Dev', '0');");
        db.execSQL("INSERT INTO member VALUES (102, 'shantanu das', 'loremipsum@gmail.com', '7229027462', 'Tech', '0');");

        Log.d("","8");

        db.execSQL("INSERT INTO event VALUES ('1','Codemeets','AB5','Tech');");
        db.execSQL("INSERT INTO event VALUES ('2','Kaiser','AB5','Tech');");
        db.execSQL("INSERT INTO event VALUES ('3','PixelWeek','NLH','Design');");
        db.execSQL("INSERT INTO event VALUES ('4','GDG CloudNext','NLH','Dev');");
        db.execSQL("INSERT INTO event VALUES ('5','Webmeets','AB5','Web');");



        Log.d(" ","AFter all inserts");


        db.execSQL("INSERT INTO registration VALUES (1,0,2);");
        db.execSQL("INSERT INTO registration VALUES (1,125,0);");
        db.execSQL("INSERT INTO registration VALUES (1,0,45);");
        db.execSQL("INSERT INTO registration VALUES (1,0,34);");
        db.execSQL("INSERT INTO registration VALUES (1,67,0);");
        db.execSQL("INSERT INTO registration VALUES (1,19,0);");
        db.execSQL("INSERT INTO registration VALUES (2,3,0);");
        db.execSQL("INSERT INTO registration VALUES (2,2,0);");
        db.execSQL("INSERT INTO registration VALUES (2,0,54);");
        db.execSQL("INSERT INTO registration VALUES (2,21,0);");
        db.execSQL("INSERT INTO registration VALUES (2,10,0);");
        db.execSQL("INSERT INTO registration VALUES (2,0,42);");
        db.execSQL("INSERT INTO registration VALUES (2,76,0);");
        db.execSQL("INSERT INTO registration VALUES (2,0,55);");
        db.execSQL("INSERT INTO registration VALUES (2,102,0);");
        db.execSQL("INSERT INTO registration VALUES (3,91,0);");
        db.execSQL("INSERT INTO registration VALUES (3,34,0);");
        db.execSQL("INSERT INTO registration VALUES (3,0,76);");
        db.execSQL("INSERT INTO registration VALUES (3,102,0);");
        db.execSQL("INSERT INTO registration VALUES (3,6,0);");
        db.execSQL("INSERT INTO registration VALUES (3,0,55);");
        db.execSQL("INSERT INTO registration VALUES (4,0,35);");
        db.execSQL("INSERT INTO registration VALUES (4,11,0);");
        db.execSQL("INSERT INTO registration VALUES (4,23,0);");
        db.execSQL("INSERT INTO registration VALUES (4,0,24);");
        db.execSQL("INSERT INTO registration VALUES (4,14,0);");
        db.execSQL("INSERT INTO registration VALUES (5,0,52);");
        db.execSQL("INSERT INTO registration VALUES (5,91,0);");
        db.execSQL("INSERT INTO registration VALUES (5,0,19);");
        db.execSQL("INSERT INTO registration VALUES (5,72,0);");
        db.execSQL("INSERT INTO registration VALUES (5,35,0);");






    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop User Table if exist
        db.execSQL(DROP_USER_TABLE);


        // Create tables again
        onCreate(db);

    }

    /**
     * This method is to create user record
     *
     * @param user
     */
    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_ID, user.getMemId());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());
        values.put(COLUMN_REG_NO, user.getRegNo());
        values.put(COLUMN_PHONE_NO, user.getPhoneNo());

        // Inserting Row
        db.insert(TABLE_USER, null, values);
        db.close();
    }

    /**
     * This method is to fetch all user and return the list of user records
     *
     * @return list
     */
    public List<User> getAllUser() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID,
                COLUMN_USER_EMAIL,
                COLUMN_USER_NAME,
                COLUMN_USER_PASSWORD,
                COLUMN_REG_NO,
                COLUMN_PHONE_NO

        };
        // sorting orders
        String sortOrder =
                COLUMN_USER_NAME + " ASC";
        List<User> userList = new ArrayList<User>();

        SQLiteDatabase db = this.getReadableDatabase();

        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setMemId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USER_ID))));
                user.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_USER_EMAIL)));
                user.setName(cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME)));
                user.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD)));
                user.setRegNo(cursor.getInt(cursor.getColumnIndex(COLUMN_REG_NO)));
                user.setPhoneNo(cursor.getInt(cursor.getColumnIndex(COLUMN_PHONE_NO)));
                // Adding user record to list
                userList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return userList;
    }

    /**
     * This method to update user record
     *
     * @param user
     */
    public void updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_ID, user.getMemId());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());
        values.put(COLUMN_REG_NO, user.getRegNo());
        values.put(COLUMN_PHONE_NO, user.getPhoneNo());

        // updating row
        db.update(TABLE_USER, values, COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(user.getMemId())});
        db.close();
    }

    /**
     * This method is to delete user record
     *
     * @param user
     */
    public void deleteUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_USER, COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(user.getMemId())});
        db.close();
    }

    /**
     * This method to check user exist or not
     *
     * @param memid
     * @return true/false
     */
    public boolean checkUser(String memid) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection = COLUMN_USER_ID + " = ?";

        // selection argument
        String[] selectionArgs = {memid};

        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_id = '26573';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }

        return false;
    }

    /**
     * This method to check user exist or not
     *
     * @param memid
     * @param password
     * @return true/false
     */
    public boolean checkUser(String memid, String password) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = COLUMN_USER_ID + " = ?" + " AND " + COLUMN_USER_PASSWORD + " = ?";

        // selection arguments
        String[] selectionArgs = {memid, password};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;
    }

    public List<Member> getAllMember() {
        // array of columns to fetch

        Log.d("Blah","asdfhfs");
        String[] columns = {
                "memID",
                "name",
                "email",
                "mobile",
                "dept",
                "access_level"

        };
        // sorting orders
        String sortOrder =
                "memID" + " ASC";
        List<Member> memberList = new ArrayList<Member>();

        SQLiteDatabase db = this.getReadableDatabase();

        Log.d("Blah","asdfhfsgetDbms");

        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query("member", //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order
        Log.d("Blah","asdfhfscursor");

        // Traversing through all rows and adding to list
        if (cursor.moveToFirst())
            {
                Log.d("Blah","inside if");
            do {
                Log.d("Blah","inside do");
                Member member = new Member();
                member.setEmail(cursor.getString(cursor.getColumnIndex("email")));
                Log.d("Blah","Emailcheck");
                member.setMemId(Integer.parseInt(cursor.getString(cursor.getColumnIndex("memID"))));
                Log.d("Blah","Memidcheck");
                member.setName(cursor.getString(cursor.getColumnIndex("name")));
                member.setAccessLevel(cursor.getString(cursor.getColumnIndex("access_level")));
                member.setDept(cursor.getString(cursor.getColumnIndex("dept")));
                member.setPhoneNo(cursor.getString(cursor.getColumnIndex("mobile")));
                // Adding user record to list
                Log.d("Blah","Before Add");
                memberList.add(member);
                Log.d("Blah","Adding here");
            } while (cursor.moveToNext());
        }

        Log.d("Blah","asdfhfscursorclose");
        cursor.close();
        db.close();

        // return user list
        return memberList;
    }

    public List<Member> getFinderMembers(String s1,String s2) {
        // array of columns to fetch

        Log.d("Blah","asdfhfs");
        String[] columns = {
                "memID",
                "name",
                "email",
                "mobile",
                "dept",
                "access_level"

        };
        // sorting orders
        String sortOrder =
                "memID" + " ASC";
        List<Member> memberList = new ArrayList<Member>();

        SQLiteDatabase db = this.getReadableDatabase();

        Log.d("Blah","asdfhfsgetDbms");

        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */

        String temp[] = new String[]{s1,s2};
        Log.d(temp[0],temp[1]);
        Cursor cursor=db.rawQuery("SELECT * FROM member WHERE access_level IN ("+s1+") AND dept IN ("+s2+");",null);

        // Traversing through all rows and adding to list
        if (cursor.moveToFirst())
        {
            Log.d("Blah","inside if");
            do {
                Log.d("Blah","inside do");
                Member member = new Member();
                member.setEmail(cursor.getString(cursor.getColumnIndex("email")));
                Log.d("Blah","Emailcheck");
                member.setMemId(Integer.parseInt(cursor.getString(cursor.getColumnIndex("memID"))));
                Log.d("Blah","Memidcheck");
                member.setName(cursor.getString(cursor.getColumnIndex("name")));
                member.setAccessLevel(cursor.getString(cursor.getColumnIndex("access_level")));
                member.setDept(cursor.getString(cursor.getColumnIndex("dept")));
                member.setPhoneNo(cursor.getString(cursor.getColumnIndex("mobile")));
                // Adding user record to list
                Log.d("Blah","Before Add");
                memberList.add(member);
                Log.d("Blah","Adding here");
            } while (cursor.moveToNext());
        }

        Log.d("Blah","asdfhfscursorclose");
        cursor.close();
        db.close();

        // return user list
        return memberList;
    }
/*
    public void triggerRegistration(int MID,int NID,int EID)
    {
        String s1=Integer.toString(EID);
        String s2=Integer.toString(MID);
        String s3=Integer.toString(NID);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM attendance WHERE EID=? AND MID=? AND EID=?;",new String[]{s1,s2,s3});
        if (cursor.getCount()==0)
        {
            db.execSQL("INSERT INTO registration VALUES ("+s1+","+s2+","+s3+");");
        }
    }*/


    public List<Member> getByMemID(String s) {
        // array of columns to fetch

        Log.d("Blah","asdfhfs");
        String[] columns = {
                "memID",
                "name",
                "email",
                "mobile",
                "dept",
                "access_level"

        };
        // sorting orders
        String sortOrder =
                "memID" + " ASC";
        List<Member> memberList = new ArrayList<Member>();

        SQLiteDatabase db = this.getReadableDatabase();

        Log.d("Blah","asdfhfsgetDbms");

        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */

        Cursor cursor=db.rawQuery("SELECT * FROM member WHERE memID="+s+";",null);

        // Traversing through all rows and adding to list
        if (cursor.moveToFirst())
        {
            Log.d("Blah","inside if");
            do {
                Log.d("Blah","inside do");
                Member member = new Member();
                member.setEmail(cursor.getString(cursor.getColumnIndex("email")));
                Log.d("Blah","Emailcheck");
                member.setMemId(Integer.parseInt(cursor.getString(cursor.getColumnIndex("memID"))));
                Log.d("Blah","Memidcheck");
                member.setName(cursor.getString(cursor.getColumnIndex("name")));
                member.setAccessLevel(cursor.getString(cursor.getColumnIndex("access_level")));
                member.setDept(cursor.getString(cursor.getColumnIndex("dept")));
                member.setPhoneNo(cursor.getString(cursor.getColumnIndex("mobile")));
                // Adding user record to list
                Log.d("Blah","Before Add");
                memberList.add(member);
                Log.d("Blah","Adding here");
            } while (cursor.moveToNext());
        }

        Log.d("Blah","asdfhfscursorclose");
        cursor.close();
        db.close();

        // return user list
        return memberList;
    }


    public List<NonMember> getAllNonMember() {
        Log.d(" ","enter cursor");
        // array of columns to fetch
        String[] columns = {
                "NMID",
                "name",
                "email",
                "mobile"

        };
        // sorting orders
        String sortOrder =
                "NMID" + " ASC";
        List<NonMember> nonMemberList = new ArrayList<NonMember>();

        SQLiteDatabase db = this.getReadableDatabase();

        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query("non_member", //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        Log.d(" ","before cursor");
        if (cursor.moveToFirst()) {
            Log.d("Enter","in if");
            do {
                Log.d("Enter","in do");
                NonMember nonMember = new NonMember();
                Log.d("Enter","nm cfeate");
                nonMember.setNMId(Integer.parseInt(cursor.getString(cursor.getColumnIndex("NMID"))));
                Log.d("Enter","nmId");
                nonMember.setEmail(cursor.getString(cursor.getColumnIndex("email")));
                Log.d("Enter","email");

                nonMember.setName(cursor.getString(cursor.getColumnIndex("name")));
                Log.d("Enter","name");
                nonMember.setPhoneNo(cursor.getString(cursor.getColumnIndex("mobile")));
                Log.d("Enter","mob");
                // Adding user record to list
                nonMemberList.add(nonMember);
            } while (cursor.moveToNext());
        }
        Log.d(" ","after cursor");
        cursor.close();
        db.close();

        // return user list
        return nonMemberList;
    }

    public List<Event> getAllEvent() {
        // array of columns to fetch
        String[] columns = {
                "eventID",
                "name",
                "venue",
                "type"

        };
        // sorting orders
        String sortOrder =
                "type" + " ASC";
        List<Event> eventList = new ArrayList<Event>();

        SQLiteDatabase db = this.getReadableDatabase();

        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query("event", //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Event event = new Event();
                event.setEventID(cursor.getInt(cursor.getColumnIndex("eventID")));
                event.setName(cursor.getString(cursor.getColumnIndex("name")));
                event.setVenue(cursor.getString(cursor.getColumnIndex("venue")));
                event.setType(cursor.getString(cursor.getColumnIndex("type")));
                // Adding user record to list
                eventList.add(event);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return eventList;
    }


    public List<Attendance> getAllAttendance() {
        // array of columns to fetch
        String[] columns = {
                "memID",
                "NMID",
                "eventID"

        };
        // sorting orders
        String sortOrder =
                "eventID" + " ASC";
        List<Attendance> attendanceList = new ArrayList<Attendance>();

        SQLiteDatabase db = this.getReadableDatabase();

        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query("attendance", //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Attendance attendance = new Attendance();
                attendance.setMemID(Integer.parseInt(cursor.getString(cursor.getColumnIndex("memID"))));
                attendance.setNmID(Integer.parseInt(cursor.getString(cursor.getColumnIndex("NMID"))));
                attendance.setEventID(Integer.parseInt(cursor.getString(cursor.getColumnIndex("eventID"))));
                attendanceList.add(attendance);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return attendanceList;
    }

    public List<Registration> getAllRegistration() {
        // array of columns to fetch
        String[] columns = {
                "memID",
                "NMID",
                "eventID"

        };
        // sorting orders
        String sortOrder =
                "eventID" + " ASC";
        List<Registration> registrationList = new ArrayList<Registration>();

        SQLiteDatabase db = this.getReadableDatabase();

        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query("registration", //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Registration registration = new Registration();
                registration.setMemID(Integer.parseInt(cursor.getString(cursor.getColumnIndex("memID"))));
                registration.setNmID(Integer.parseInt(cursor.getString(cursor.getColumnIndex("NMID"))));
                registration.setEventID(Integer.parseInt(cursor.getString(cursor.getColumnIndex("eventID"))));
                registrationList.add(registration);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return registrationList;
    }


}
