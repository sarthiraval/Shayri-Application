package com.example.shayri;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.navigation.NavigationView;

public class Ishq extends AppCompatActivity {
    NavigationView navigationView;

    TextView shayaricount;

    ViewPager viewpager;
    MyAdapter ma;

    ImageButton previous;
    ImageButton next;
    ImageButton whatsapp;
    ImageButton copy;

    private AdView mAdView;
    @SuppressLint("DefaultLocale")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ishq);

        ActionBar ab=getSupportActionBar();
        ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#C19A6B")));


        navigationView =  findViewById(R.id.nav1);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        Intent home= new Intent(getBaseContext(),MainActivity.class);
                        startActivity(home);
                        break;
                    case R.id.nav_dev:
                        Intent dev= new Intent(getBaseContext(),About.class);
                        startActivity(dev);
                        break;

                    case R.id.nav_exit:
                        finishAffinity();
                        System.exit(0);
                        break;
                }
                return false;
            }
        });
        final String[] Ishq =
                {"Agar ishq gunah hai to gunahagar hai khuda,\n" +
                        "Jisane banaya dil kisi par aane ke liye","Agar ho jaye ishk,\n" +
                        "To hamse saajha kar lena.\n" +
                        "Kuchh ham rakh lenge,\n" +
                        "Kuchh tum rakh lena.","Tere honthon ki lali aaj mujhe behka rahi hain,\n" +
                        "Tere badan ki khushboo mujhe mehka rahi hain.\n" +
                        "Teri jaan tujhe valentine’s day mubaarak ho,\n" +
                        "Aaja kareeb tujhe chhoone ki bechaini badh rahi hai.","Wo Kehne Lagi…\n" +
                        "NaQab Me Bhi Pehchan Lete Ho Hazaron K Beech Mai,\n" +
                        "Mene Muskura K Kaha,\n" +
                        "Teri Ankhon Se To Shuru Hua Tha ISHQ,\n" +
                        "Hazaaron k Beech Mein.","Zamane Ki Har Jannat Tere Naam Kar Dunga,\n" +
                        "Yeh Asmaan Yeh Jameen  Tere Naam Kar Dunga,\n" +
                        "Mujhse Kehna Bhi Nahi Padega Tujhe,\n" +
                        "Aur Mere Hisse Ki Har Khushi Tere Naam Kar Dunga.","Tumhein dekhakar main khud ko bhool jaata hoon,\n" +
                        "Tanhaee mein aksar gazal gunagunaata hoon,\n" +
                        "Ishq ho gaya hai ya koi aur bala hai,\n" +
                        "Be-wajah yun har ghadi ab muskuraata hoon.","Koi teri aashiqi ko tarase,\n" +
                        "Toh koi teri dosti ko,\n" +
                        "Aur koi teri maujudgi ko tarse,\n" +
                        "Ban ja sabki rehnuman tu,\n" +
                        "Sab per tera karam barse.","Sawal Kuch Bhi Ho,\n" +
                        "\n" +
                        "Jawab Tum Hi Ho\n" +
                        "\n" +
                        "Rasta Koi Bhi Ho,\n" +
                        "\n" +
                        "Manzil Tum Hi Ho\n" +
                        "\n" +
                        "Dukh Kitna Hi Ho,\n" +
                        "\n" +
                        "Khushi Tum Hi Ho\n" +
                        "\n" +
                        "Arman Kitne Bhi Ho,\n" +
                        "\n" +
                        "Aarzoo Tum Hi Ho\n" +
                        "\n" +
                        "Gussa Kitna Bhi Ho,\n" +
                        "\n" +
                        "Pyar Tum Hi Ho\n" +
                        "\n" +
                        "Khawab Koi Bhi Ho,\n" +
                        "\n" +
                        "Us Mein Tum Hi Ho,\n" +
                        "\n" +
                        "kyunki TUM HI HO…!!!\n" +
                        "\n" +
                        "Ab tum hi ho\n" +
                        "\n" +
                        "meri ashiqi ab tum hi ho:!♥","Maine apni har ek saans tumhari gulaam kar rakhi hai,\n" +
                        "Logon mai ye zindagi badnaam kar rakhi hai,\n" +
                        "Ab ye aaina bhi kya kaam ka mere,\n" +
                        "Maine to apni parchayi bhi tumhare naam kar rakhi hai.","Chale bhi aao ki hum tumse pyar karte hain,\n" +
                        "Ye wo gunah hai jo hum baar-baar karte hain,\n" +
                        "Log maut tak hi dildaar ki raah takte hain,\n" +
                        "Hum hai ki kabar mai bhi tera intezaar karte hain.","Chehre me tere sirf mera hi noor hoga,\n" +
                        "Uske baad phir tu na kabhi mujhse door hoga,\n" +
                        "Jara soch ke dekh kya khushi milegi,\n" +
                        "Jis pal teri maang main mere naam ka sindoor hoga.","Chupa loon is tarah tujhe apni baahon me,\n" +
                        "Ki hawa bhi guzarne ki izaajat maange,\n" +
                        "Ho jau itna madhosh tere pyaar me,\n" +
                        "Ki hosh bhi aane ki izaajat mange.","Bhar aayi meri aankhen jab uska naam aaya,\n" +
                        "Ishq nakam sahi phir bhi bahut kaam aaya,\n" +
                        "Humne mohabbat mai aisi bhi guzari raatein,\n" +
                        "Jab tak aansu na bahe dil ko na aaram aya.","Tujhe chahte hain Be-Intehan,\n" +
                        "Par chahna nahi aata.\n" +
                        ".\n" +
                        "Ye kaisi mohobbat hai,\n" +
                        "Ki hume kehna nahi aata.\n" +
                        ".\n" +
                        "Zindagi main aa jao hamari zindagi ban kar,\n" +
                        "Ke tere bin humain zinda rehna nahi aata.\n" +
                        ".\n" +
                        "Har pal bas tujhe hi dua’on main mangte hain,\n" +
                        "Kya kare ke tumhare siwa kuch mangna nahi aata.","Kabhi tum mujhe kareeb se aa kar dekhna,\n" +
                        "Aise nahi jara aur paas aa kar dekhna,\n" +
                        "Main tum se kitna pyaar karta hoon,\n" +
                        "Mujhe kabhi seene se laga kar dekhna.♡",
                        "Humdum To Sath Sath Chalte Hain,\n" +
                                "Raaste To Bewafa Badalte Hain,Tera Chehra\n" +
                                "Hai Jab Se Aankhon Mein,\n" +
                                "Meri Aankhon Se Log Jalte Hain.","Khushboo Bankar Teri Saanso Mein Sama Jayenge,\n" +
                        "Sukun Bankar Tere Dil Mein Utar Jayenge,\n" +
                        "Mehsus Karne Ki Koshish To Kijiye,\n" +
                        "Dur Rahte Hue Bhi Pass Najar Aayenge.","Tera Intezaar Mujhe Har Pal Rehta Hai,\n" +
                        "Har Lamha Mujhe Tera Ehsaas Rehta Hai,\n" +
                        "Tujh Bin Dhadkane Rukk Si Jaati Hai,\n" +
                        "Ki Tu Mere Dil Me Meri Dhadkan Banke Rehta Hai.","Apne Aasman Se Meri Zameen Dekh Lo,\n" +
                        "Tum Khwab Aaj Koyi Haseen Dekh Lo,\n" +
                        "Agar Aazmana Hain Aitbar Ko Mere To,\n" +
                        "Ek Juth Tum Bolo Or Mera Yakeen Dekh Lo.","Udaas Hoon Par Tujhse Naaraz Nahi\n" +
                        "Tere Dil Mein Hoon Par Tere Pass Nahi\n" +
                        "Jhoot Kahun To Sab Kuch Hai Mere Pass\n" +
                        "Aur Sach Kahun To Ek Tere Siwa Kuch Bhi Khaas Nahi.","Nazare Mile to Pyar ho Jata Hai,\n" +
                        "Palke Uthe to Izhaar Ho Jata Hai,\n" +
                        "Na Jane Kya Kashish Hai Chahat Me,\n" +
                        "Kei Koyi Anjaan Bhi Hamari\n" +
                        "Zindagi Ka Haqdaar Ho Jata Hai.","Yaadon Me Humari Aap Bhi Khoye Honge,\n" +
                        "Khuli Aankho Se Kbhi Aap Bhi Soye Honge,\n" +
                        "Mana Hasna Hain Adaa Gam Chhupane Ki,\n" +
                        "Par Haste Haste Kabhi Aap Bhi Roye Honge.","आज मुझे ये बताने की इजाज़त दे दो,\n" +
                        "आज मुझे ये शाम सजाने की इजाज़त दे दो,\n" +
                        "अपने इश्क़ मे मुझे क़ैद कर लो,\n" +
                        "आज जान तुम पर लूटाने की इजाज़त दे दो.","Is Benaam Se Rishte Ko Nibha Jao\n" +
                        "Kisi Din, Jo Mil Jaye Fursat To\n" +
                        "Paas Aao Kisi Din, Milta Hai Sabhi\n" +
                        "Ko Sab Kuch Ye Suna Hai, Mujhe\n" +
                        "To Faqat Tum Hi Mil Jao Kisi Din.","Kuch Sochu To Apka Khayal Aa Jata He,\n" +
                        "Kuch Bolu To Apka Naam Aa Jata He,\n" +
                        "Kab Tak Chupau Dil Ki Baat,\n" +
                        "Apki Har Ada Par Humko Pyar Aa Jata He.","Hum Mohabbat Ki Kabhi Numaish Nahi Karte,\n" +
                        "Hum Lafzon Ki Bhi Pamaish Nahi Karte,\n" +
                        "Jise Chahte Hai Ham Toot Ke Chahte Hai,\n" +
                        "Badle Mein Pyar Ki Khawaish Tak Nahi Karte","Khubsurat Sa Ek Pal Kissa Banjata Hai,\n" +
                        "Jane Kab Kaun Zindagi Ka Hissa Banjata Hai,\n" +
                        "Kuchh Log Zindagi Mein Milte Hai Aise,\n" +
                        "Jinse Kabhi Na Tutnewala Rishta Banjata Hai.","Rasto Mein Pathron Ki Kami Nahi Hoti,\n" +
                        "Dil Mein Khwabo Ki Kami Nahi Hoti,\n" +
                        "Hum Chahte Hai Unko Apna Banana,\n" +
                        "Par Unke Paas Apno Ki Kami Nahi Hoti.","\"Jab khamosh aankho se baat hoti hai.\\n\" +\n" +
                        "            \"Aise hi mohabbat ki shurwat hoti hai.\\n\" +\n" +
                        "            \"Tumhare hi khyalo mein khoye rehte hai.\\n\" +\n" +
                        "            \"Pata nahi kab din kab raat hoti hai ?\",\"Tere libas se mohabbat ki hai,\\n\" +\n" +
                        "            \"tere ehsas se mohabbat ki hai,\\n\" +\n" +
                        "            \"tu mere paas nahi fir bhi,\\n\" +\n" +
                        "            \"maine teri yaad se mohabbat ki hai,\\n\" +\n" +
                        "            \"kabhi tune bhi mujhe yaad kiya hoga,\\n\" +\n" +
                        "            \"maine un lamho se mohabbat ki hai,\\n\" +\n" +
                        "            \"jinme ho sirf teri aur meri baatein,\\n\" +\n" +
                        "            \"maine un alfaaz se mohabbat ki hai,\\n\" +\n" +
                        "            \"jo mahkate ho teri mohabbat se,\\n\" +\n" +
                        "            \"maine un jazbat se mohabbat ki hai,\\n\" +\n" +
                        "            \"aaoge kab wapis meri jaan,\\n\" +\n" +
                        "            \"maine tere intezaar se mohabbat ki hai!\",\"Ham juda hue the phir milane ke liye,\\n\" +\n" +
                        "            \"zindagi ki raahon mein sang chalane ke liye,\\n\" +\n" +
                        "            \"tere pyaar ki kashish dil mein basi hai kuchh is qadar,\\n\" +\n" +
                        "            \"dua hai tera sath mile zara sambhalane ke liye\",\"Hasrat hai sirf tumhe pane ki,\\n\" +\n" +
                        "            \"aur koi khawahish nahi is dewane ki,\\n\" +\n" +
                        "            \"shikwa mujhe tumse nahi khuda se hai,\\n\" +\n" +
                        "            \"kya zarurat thi tumhe itna khubsurat banane ki?\",\"Jab jab yaad karogi apani tanhaiyo ko,\\n\" +\n" +
                        "            \"ek jalata charaag sa nazar aauga main\\n\" +\n" +
                        "            \"raah se rahaguzar ban ke bhi gujar jaogi,\\n\" +\n" +
                        "            \"ek mil ka patthar sa khada nazar aauga main..\",\"Muskurate palko pe sanam chale aate hein,\\n\" +\n" +
                        "            \"Aap kya jaano kahan se hamare ghum aate hain,\\n\" +\n" +
                        "            \"Aaj bhi us mod par khade hain,\\n\" +\n" +
                        "            \"Jaha kisi ne kaha tha ke theron hum abhi aate hain.\",\"Dil ka dard ek raaz banke reh gaya,\\n\" +\n" +
                        "            \"Mera bharosa mazak banke reh gaya,\\n\" +\n" +
                        "            \"Dilo ke saudagar se dillagi kar bethe,\\n\" +\n" +
                        "            \"Shayad is liye mera pyaar mazak ban ke reh gaya.\"",
                        "Teri aankhon se pyar karu,\n" +
                                "Teri baaton se pyar karu..\n" +
                                "\n" +
                                "Teri mohabbat me doob,\n" +
                                "Tujh pyar mein subha shaam karu.\n" +
                                "\n" +
                                "Tum rahe na pao humare bina,\n" +
                                "Is trha toot kar tujh mein pyar karu.","De do apna hath hatho mein hamare,\n" +
                        "Rahna hai dil ko sath tumhare,\n" +
                        "Yu hi nhi rahte khoye hue ham\n" +
                        "Hame aate hai har pal khyal tumhare.","Batani hai tumhe aaj chahat hamari,\n" +
                        "Jatani hai tumhe dil ki khwahish hamari,\n" +
                        "Or kuch nhi hai dil mein hamare\n" +
                        "Bas hai tasveer tumhari.","Meri Zindagi ki manzil ban gaye ho tum,\n" +
                        "Mere hothon ki khushi ban gaye ho tum,\n" +
                        "Jeene ke liye ab bas jarurt hai tumhari\n" +
                        "Kyoki mere Mohabbat meri jaan ban gaye ho tum.","Chahat hai…Pyar jee bhar ke karne do,\n" +
                        "Apni mohabbat ka izhaar jee bhar kar karne do,\n" +
                        "Utha ke dekho nazarin hamari taraf\n" +
                        "Thoda hame tumhara deedar karne do.","Kara hai tujh se pyar,\n" +
                        "Bas teri mohabbat ke liye bekarar hai hum,\n" +
                        "Ager lagta hai tumhe mohabbat hai gunha\n" +
                        "To ha gunehgaar hai hum.","Jee bhar ke deedar karne do jara,\n" +
                        "Kar ke mehsus pyar ka izhar karne do jara,\n" +
                        "Kitni chahat hai dil mein hamare\n" +
                        "Aaj hame aitbaar karne do jara.","Dil mein basa ke rakhenge tum ko,\n" +
                        "Apne seene se laga ke rakhenge tum ko,\n" +
                        "Tum qubool kar ke to dekho mohabbat hamari\n" +
                        "Jaan se jada apna bana ke rakhenge tumko.","Har pal khayaal bas aata hai tumhara,\n" +
                        "Dekh ke tumhe dil diwana ho jata hai hamara,\n" +
                        "Kuch itna asar hai mohabbat ka teri mujh per\n" +
                        "Ki baato baato mein hothon pe naam aa jata hai tumhara.","Ajnbi rhena pr kisi ka intejar mt krna\n" +
                        "kisi k pyar k liye khud ko bekrar mt krna\n" +
                        "acha sathi mil jaye to hath tham lena\n" +
                        "pr dikhave k liye kisise pyar mt krna\n" +
                        "\n","Tujhe paane ki Chahat baar baar karta hu\n" +
                        "Pyar se bhi zayada tujhe Pyar karta hu\n" +
                        "Sach kahta hu, Tujhe Pyar Main had se Jada karta hu\n" +
                        "\n","Anjaan ek saathi ka iss dil ko intejar hain,\n" +
                        "Pyasa hain ye aankhen aur dil bekarar hain,\n" +
                        "Unke saath mil jaye to har raah aasan ho jayegi\n" +
                        "Shayad issi anokhey ehsaas ka naam pyaar hai.","Jb kisi k sapne kisi k arman ban jaye\n" +
                        "Jb kisi ki hasi kisi ki muskan ban jaye\n" +
                        "Pyar kehtey hain ussey\n" +
                        "Jb kisi ki saanse kisi ki jaan ban jaye.","Kbhi alfaaz bhul jau kabhi khayal bhul jaau\n" +
                        "Tujhe es kadar chahu k apni saans bhul jau\n" +
                        "Uth kar tere paas se jo main chal doon,\n" +
                        "Toh jaate huye khud ko tere paas bhul jaau","Saath agar doge toh muskrayenge zarur,\n" +
                        "Pyar agar dil se karoge to nibhayenge zarur\n" +
                        "Raah me kitne bhi kante kyu na ho,\n" +
                        "Awaz agar dil se doge to aayenge zarur.","Do baatein unse ki to dil ka dard kho gaya,\n" +
                        "Logo ne hmse pucha aaj tumhe kya ho gya\n" +
                        "Hum bekrar aankho se sirf has paaye\n" +
                        "Ye bhi na keh paye ki hume pyar ho gaya.","Ye wo gunah hai jo hum baar-baar karte hain,\n" +
                        "Log maut tak hi dildaar ki raah takte hain,\n" +
                        "Hum hai ki kabar mai bhi tera intezaar karte hain.","Chehre me tere sirf mera hi noor hoga,\n" +
                        "Uske baad phir tu na kabhi mujhse door hoga,\n" +
                        "Jara soch ke dekh kya khushi milegi,\n" +
                        "Jis pal teri maang main mere naam ka sindoor hoga.","Chupa loon is tarah tujhe apni baahon me,\n" +
                        "Ki hawa bhi guzarne ki izaajat maange,\n" +
                        "Ho jau itna madhosh tere pyaar me,\n" +
                        "Ki hosh bhi aane ki izaajat mange.","Bhar aayi meri aankhen jab uska naam aaya,\n" +
                        "Ishq nakam sahi phir bhi bahut kaam aaya,\n" +
                        "Humne mohabbat mai aisi bhi guzari raatein,\n" +
                        "Jab tak aansu na bahe dil ko na aaram aya.","Tujhe chahte hain Be-Intehan,\n" +
                        "Par chahna nahi aata.\n" +
                        ".\n" +
                        "Ye kaisi mohobbat hai,\n" +
                        "Ki hume kehna nahi aata.\n" +
                        ".\n" +
                        "Zindagi main aa jao hamari zindagi ban kar,\n" +
                        "Ke tere bin humain zinda rehna nahi aata.\n" +
                        ".\n" +
                        "Har pal bas tujhe hi dua’on main mangte hain,\n" +
                        "Kya kare ke tumhare siwa kuch mangna nahi aata.","Kabhi tum mujhe kareeb se aa kar dekhna,\n" +
                        "Aise nahi jara aur paas aa kar dekhna,\n" +
                        "Main tum se kitna pyaar karta hoon,\n" +
                        "Mujhe kabhi seene se laga kar dekhna.♡","Jab khamosh aankho se baat hoti hai.\n" +
                        "Aise hi mohabbat ki shurwat hoti hai.\n" +
                        "Tumhare hi khyalo mein khoye rehte hai.\n" +
                        "Pata nahi kab din kab raat hoti hai ?","Tere libas se mohabbat ki hai,\n" +
                        "tere ehsas se mohabbat ki hai,\n" +
                        "tu mere paas nahi fir bhi,\n" +
                        "maine teri yaad se mohabbat ki hai,\n" +
                        "kabhi tune bhi mujhe yaad kiya hoga,\n" +
                        "maine un lamho se mohabbat ki hai,\n" +
                        "jinme ho sirf teri aur meri baatein,\n" +
                        "maine un alfaaz se mohabbat ki hai,\n" +
                        "jo mahkate ho teri mohabbat se,\n" +
                        "maine un jazbat se mohabbat ki hai,\n" +
                        "aaoge kab wapis meri jaan,\n" +
                        "maine tere intezaar se mohabbat ki hai!","Ham juda hue the phir milane ke liye,\n" +
                        "zindagi ki raahon mein sang chalane ke liye,\n" +
                        "tere pyaar ki kashish dil mein basi hai kuchh is qadar,\n" +
                        "dua hai tera sath mile zara sambhalane ke liye","Hasrat hai sirf tumhe pane ki,\n" +
                        "aur koi khawahish nahi is dewane ki,\n" +
                        "shikwa mujhe tumse nahi khuda se hai,\n" +
                        "kya zarurat thi tumhe itna khubsurat banane ki?","Jab jab yaad karogi apani tanhaiyo ko,\n" +
                        "ek jalata charaag sa nazar aauga main\n" +
                        "raah se rahaguzar ban ke bhi gujar jaogi,\n" +
                        "ek mil ka patthar sa khada nazar aauga main..","Muskurate palko pe sanam chale aate hein,\n" +
                        "Aap kya jaano kahan se hamare ghum aate hain,\n" +
                        "Aaj bhi us mod par khade hain,\n" +
                        "Jaha kisi ne kaha tha ke theron hum abhi aate hain.","Dil ka dard ek raaz banke reh gaya,\n" +
                        "Mera bharosa mazak banke reh gaya,\n" +
                        "Dilo ke saudagar se dillagi kar bethe,\n" +
                        "Shayad is liye mera pyaar mazak ban ke reh gaya.",
                        "Kisi Ke Pyaar Ko Pa Lena Hi Mohabbat Nahi Hoti \n" +
                                "Kisi Ke Door Rahane Par Usako Pal Pal Yaad Karana Bhi Mohabbat Hoti Hai ","Bas Rishta Hi To Toota Hai Mohabbat To Aaj Bhi Hame Unase Hi Hai ","Jahar Se Adhik Khataranaak Hain Yah Pyaar \n" +
                        "Jo Bhi Chakh Le Mar Mar Ke Jeeta Hen","Mohabbat Kaisi Bhi Ho Kasam Se\n" +
                        "Sajada Karana Sikha Deti Hai","Pyaar Mohabbat Aashiqi.Ye Bas Alphaaj The.\n" +
                        "Magar.Jab Tum Mile Tab In Alphaajo Ko Maayane Mile","Na Jaane Muhabbat Mein Kitane Aphasaane Ban Jaate Hai\n" +
                        "Shamaan Jisako Bhee Jalaati Hai Vo Paravaane Ban Jaate Hai\n" +
                        "Kuchh Haasil Karana Hee Ishk Ki Manjil Nahee Hotee\n" +
                        "Kisi Ko Khokar Bhi Kuchh Log Divaane Ban Jaate Hai","Mohabbat Ki Aajamaish De De Kar Thak Gaya Hoon Ai Khuda.\n" +
                        "Kismat Men Koy Aisa Likh De.Jo Maut Tak Wafa Kare.","Vado Se Bandhi Janzeer Thi Jo Tod Di Mainne\n" +
                        "Ab Se Jaldi Soya Karenge , Mohabbat Chhod Di Mainne","Wo Jis Din Karega Yaad Meri Mohabbat Ko\n" +
                        "Royega Bahut Khud Ko Bewfa Kah Kar","Utar Jaate Hai Dil Me Kuchh Log Es Kadar\n" +
                        "Unako Nikaalo To Jaan Nikal Jaati Hai","Pyaar ek Ehsaas hai,\n" +
                        "Jo dil ke bada paas hai.\n" +
                        "Saaree duniya lagatee hai begaanee,\n" +
                        "Wahee lagata hai pyaara jisaka dil me vaas hai..","Suno..Waise to “tum” meree “pehlee” pasand ho..\n" +
                        "Magar maine “chahaa” hai tumhe apnee “aakharee” mohabbat kee tarah..","Meri fikr mein khud ko bhool jaati ho\n" +
                        "Aur bekhabar ho mujh ko ye jatati ho.\n" +
                        "\n" +
                        "Hone lagti ho jis pal door mujhse\n" +
                        "Kasam se us pal bahut yaad aati ho.\n" +
                        "\n" +
                        "Chaahatee ho kitna, poochhoo jab kabhee to\n" +
                        "Aankhon hee aankhon mein sab kuchh batati ho.\n" +
                        "\n" +
                        "Mohabbat mein meree khud ko bhulae baithee ho\n" +
                        "Aur dil mein apane jazbaat chhupaati ho.","Saath tera jo mila to dil mein sukoon sa lagane laga,\n" +
                        "Tera na chhodenge saath kabhee har pal khwaab sajane laga.\n" +
                        "\n" +
                        "Nahin pata tha zindagee kya hotee hain tujhase milane se pahale,\n" +
                        "Tum aaye zindagee mein mere to soye aramaan machalane laga.\n" +
                        "\n" +
                        "Tum hee se to judee hain ab har khushiya meree jaaneman,\n" +
                        "Tumhaaree chuan se mera har lamha ab mahakane laga.\n" +
                        "\n" +
                        "Pata na chala kab kaun see dor teree or khinch laayee,\n" +
                        "Tera saath paakar mera har lamha khoobasoorat banane laga.","Muskura jaata hoon aksar gusse mein bhee tera naam sun kar,\n" +
                        "Tere naam se itnee mohabbat hai to soch tujhse kitnee hogee…","“Hamein kahan maaloom tha ki ishq hota kya hai..!\n" +
                        "Bas, ek tum mile aur zindagee…muhabbat ban gaee!.!”","Aisa nahin hai ki din nahin dhalata…..ya raat nahin hotee,\n" +
                        "Sab adhoora sa lagata hai….jab tumase baat nahin hotee…!!","Jab unhone sine se lagaya to esa laga,\n" +
                        "Jaise jamee ko aasma mil gya,\n" +
                        "Yu to band thi najare hamari,\n" +
                        "Lekin band aankho se bhi jannat ka najara dikh gya,\n" +
                        "Sochta rha me ki kat jaye baki jindagi isi tarah,\n" +
                        "Or band najro se asko ka najrana nikal gya,\n" +
                        "Kya btau yaro kesa ehesas tha wo,\n" +
                        "Jaise mar ke jeene ka ehsas mil gya","Meri subah hoti hai tere naam se,\n" +
                        "Har pal mehakta hai teri yaadon se,\n" +
                        "Raat guzar jaati hai teri tasveer se,\n" +
                        "Ab baaki zindagi guzare tumhari baahon mein.\n" +
                        "Love you, sweet heart.","Soch Kar Rakhna Hamari Saltanat Main Kadam,\n" +
                        "Hamari ”Mohabbat” Ki Qaid Mein Zamanat Nahi Hoti.","Jazbaat Mere Kahin Kuch Khoye Huye Se Hain,\n" +
                        "Kahun Kaise Wo Tumse Thoda Sharmaye Huye Se Hain,\n" +
                        "Par Aaj Na Rok Sakunga Jazbato Ko Main Apne,\n" +
                        "Karte Hain Pyar Hum Tumhi Se Par Ghabraye Se Huye Hai.","Chhod Do Tanhai Mein Mujhko Yaaron,\n" +
                        "Saath Mere Rehkar Kya Paaoge,\n" +
                        "Agar Ho Gayi Aapko Bhi Mohabbat Kabhi,\n" +
                        "Meri Tarah Tum Bhi Pachtaoge.","Kasoor na unka hai na hamara,\n" +
                        "Hum dono bas rishto ki rasmein hi nibhate rahe,\n" +
                        "Dosti ka ehsaas wo jatate rahe,\n" +
                        "Aur hum is mohabbat ko bas dil main hi chipate rahe.","Kyun Koi Chah Kar Mohabbat Nibha Nahi Pata,\n" +
                        "Kyun Koi Chah Kar Rishta Bana Nahi Pata,\n" +
                        "Kyun Leti Hai Zindagi Aisi Karwat,\n" +
                        "Ki Koi chah Kar Bhi Pyar Jata Nhi Pata…!!!","Pyaar me Maut se darta kaun hai?\n" +
                        "Pyar ho jata hai karta kaun hai?\n" +
                        "Hum to kardein Pyaar me Jaan bhi Kurban..\n" +
                        "Lekin Pata to chale ki hum se Pyaar karta kaun hai?","Kismat par naaz hai toh wajah teri rehmat,\n" +
                        "Khushiyan jo paas hai toh wajah teri rehmat,\n" +
                        "Mere apne mere sath hai toh wajah teri rehmat,\n" +
                        "Mai tujhse mohabbat ki talab kaise na karun,\n" +
                        "Chalti jo ye saans hai toh wajah teri rehmat.","Jane Ko Toh Dur Ham Bhi Ja Sakte Hain Ek Pal Mai Tumse,\n" +
                        "Par Tumhara Sath Isliye Nahi Chodte,\n" +
                        "Kyuki Tumhe Akela Dekhkar,\n" +
                        "Mujhe Bhi Apna Dard Najar Aaya Tha.","Sirf Isharoon Mai Hoti Mohabbat Agar,\n" +
                        "In Alfazoon Ko Khoobsurati Kaun Deta?\n" +
                        "Bas Patthar Ban Ke Reh Jata “Taj Mahal”,\n" +
                        "Agar Ishq Isey Apni Pehchan Na Deta.",
                        "Gile shikwe na dil se \n" +
                                "Laga lena..!\n" +
                                "Kabhi maan jana to \n" +
                                "Kabhi manaa lena..!\n" +
                                "Kal ka kya pata \"hum ho na ho\"\n" +
                                "Jab mauka mile thoda \n" +
                                "Hass lena aur hasaa dena","Isi Karz Ko Ada Krne K Wasty Hum Saari Raat Nahi Sote K \n" +
                        "\n" +
                        "Shayad Koi Jaag Raha Ho Is Duniya Main Mere Liye !!!!!","Parwah kar uski jo teri parwah kare,\n" +
                        "Zindagi mein jo kabi na tanha kare,\n" +
                        "Jaan ban ke utar jaa uski ruh mein,\n" +
                        "Jo jaan se bhi jyada tujhse wafa kare.","ab chhoti chhoti baaton mein,\n" +
                        "hum haste they , rote they ,\n" +
                        "TAB SE TUMSE PYAAR KIYA\n" +
                        "Jab bin mausam barsaato mein,\n" +
                        "hum jhoom jhoom ke gaate they ,\n" +
                        "TAB SE TUMSE PYAAR KIYA\n" +
                        "Jab chup chup ke aadhi raaton mein,\n" +
                        "chhat pe taare ginte they ,\n" +
                        "TAB SE TUMSE PYAAR KIYA\n" +
                        "Ab toh khud bhi bhool chuka hu,\n" +
                        "ki kabse tumse pyaar kiya,\n" +
                        "bas itna he keh sakta hu, ki SIRF TUMSE,\n" +
                        "TUMHI SE PYAAR KIYA ..","Kalam thi hath mai likhna sikhaya apne,\n" +
                        "Takat thi hath mai hosla dilaya apne,\n" +
                        "Manzil thi samne rasta dikhaya apne,\n" +
                        "Hum to sirf dost they,\n" +
                        "AASHIQ BANAYA Aap ne","Zindagi ka pehla pyaar kaun bhulata hai,\n" +
                        "Ye pehli baar hota hai jab koi kisi ko\n" +
                        "khud se badh kar chahta hai… Uski pasand, uski khwahish\n" +
                        "mein khud ko bhool jata hai,\n" +
                        "Akele mein uska naam likh likh kar mitata hai…\n" +
                        "Baat karne se pehle sochta hai.. kya kehna hai,\n" +
                        "Baat hone ke baad phir kuch kehna reh jata hai....","Jaante Ho Mahobbat Kise Kehte Hain ??\"\n" +
                        "Kisi ko Sochna, Soch kar Muskurana,,\n" +
                        "Phir Aansoo Baha kar So Jana....\n" +
                        "Usey mohabbat kehte hain.","Pyaar me Maut se darta kaun hai?\n" +
                        "Pyar ho jata hai karta kaun hai?\n" +
                        "Hum to kardein Pyaar me Jaan bhi Kurban..\n" +
                        "Lekin Pata to chale ki hum se Pyaar karta kaun hai?","Kismat par naaz hai toh wajah teri rehmat,\n" +
                        "Khushiyan jo paas hai toh wajah teri rehmat,\n" +
                        "Mere apne mere sath hai toh wajah teri rehmat,\n" +
                        "Mai tujhse mohabbat ki talab kaise na karun,\n" +
                        "Chalti jo ye saans hai toh wajah teri rehmat.","Jane Ko Toh Dur Ham Bhi Ja Sakte Hain Ek Pal Mai Tumse,\n" +
                        "Par Tumhara Sath Isliye Nahi Chodte,\n" +
                        "Kyuki Tumhe Akela Dekhkar,\n" +
                        "Mujhe Bhi Apna Dard Najar Aaya Tha.","Sirf Isharoon Mai Hoti Mohabbat Agar,\n" +
                        "In Alfazoon Ko Khoobsurati Kaun Deta?\n" +
                        "Bas Patthar Ban Ke Reh Jata “Taj Mahal”,\n" +
                        "Agar Ishq Isey Apni Pehchan Na Deta."
                };

        viewpager= (ViewPager) findViewById(R.id.vp);
        ma= new MyAdapter(Ishq,Ishq.this);
        viewpager.setAdapter(ma);






        shayaricount = findViewById(R.id.count);
        shayaricount.setText(String.format("Ishq Shayari : %d/%d", viewpager.getCurrentItem() + 1, Ishq.length));
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @SuppressLint("DefaultLocale")
            @Override
            public void onPageSelected(int position) {

                shayaricount.setText(String.format("Ishq Shayari : %d/%d", position+1 , Ishq.length));
            }


            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



        next=(ImageButton)findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos=viewpager.getCurrentItem();
                if ((pos+1)==ma.getCount()){
                    viewpager.setCurrentItem(0);
                }else{
                    viewpager.setCurrentItem(pos+1);
                }
            }
        });



        previous=(ImageButton)findViewById(R.id.previous);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos=viewpager.getCurrentItem();
                if (pos==0){
                    viewpager.setCurrentItem(ma.getCount());
                }else{
                    viewpager.setCurrentItem(pos-1);
                }
            }
        });


        whatsapp = findViewById(R.id.whatsapp);
        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
                whatsappIntent.setType("text/plain");
                whatsappIntent.setPackage("com.whatsapp");
                whatsappIntent.putExtra(Intent.EXTRA_TEXT, Ishq[viewpager.getCurrentItem()]);
                try {
                    startActivity(whatsappIntent);
                } catch (ActivityNotFoundException ex) {
                    Toast.makeText(getBaseContext(),"Whatsapp Not Installed",Toast.LENGTH_SHORT).show();
                }
            }
        });

        copy = findViewById(R.id.copy);
        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("msg", Ishq[viewpager.getCurrentItem()]);
                assert clipboard != null;
                clipboard.setPrimaryClip(clip);
                Toast.makeText(getBaseContext(),"Copied To Clipboard !",Toast.LENGTH_SHORT).show();
            }
        });

// for addddddd
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }

}



