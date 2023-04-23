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

public class Sad extends AppCompatActivity {
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
        setContentView(R.layout.activity_sad);
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
        viewpager= (ViewPager) findViewById(R.id.vp);
        final String[] sad =
                {
                        "Ek rishta jo muh bola tha\n" +
                                "Uska bhee tumne tiraskaar kiya\n" +
                                "Chhod kar dur chale gaye……\n" +
                                "Ye kaisa tumhaara pyaar hua…..\n" +
                                "\n","Saari umar poojte rahe log,\n" +
                        "Apne haath se banaye hue Khuda ko,\n" +
                        "Humne Khuda ke haath se bane insaan ko chaha,\n" +
                        "Toh gunehgaar ho gaye.","Na Chand Apna Tha Aur Na Tu Apna Tha,\n" +
                        "Kaashh Dil Bhi Maan Leta Ki Sab Sapna Tha..!!","Mujhe neend ki ijaazat bhi unki yaadon se leni padti hai,\n" +
                        "Jo khud aaraam se soye hain mujhe karwaton mein chhod kar.","Jab tum sath the toh gham bhi has ke seh lete the hum,\n" +
                        "Ab jo nhi ho sath toh khushiyan bhi sahi nhi jaa rahi hain.","Dekh ke teree aankhon mein , pal pal jiya hu mein.\n" +
                        "Tujhe dekh kisee ke baahon me, har pal mara hu main.\n" +
                        "Saath tera jab tak tha, jindagee se wafa main karata tha.\n" +
                        "Ab saath nahee jab tera , main wafa maut se karata hoon.","Socha na tha vo shakhs bhee itana jaldee saath chhod jaega, ❣\n" +
                        "Jo mujhe udaas dekhakar kehta tha “main hoo na”.","Mat raho door hamase itna ke apne faisle par afsos ho jaaye…\n" +
                        "Kal ko shaayad aisee mulaakaat ho hamaaree…\n" +
                        "Ke aap hamase lipatakar roye aur ham khaamosh ho jaaye..","Ek din meree aankhon ne bhee thak kar mujhse keh diya,\n" +
                        "Khwaab wo dekha karo jo poore ho, roj-roj hamase bhee roya nahee jaata..!!","Waqt badalne se utni takleef nahi hoti,\n" +
                        "Jitni kisi apne ke badal jaane se hoti hai.","Aksar jinki hansi khooburat hoti hai,\n" +
                        "\n" +
                        "Unke zakhm bhi kafi gehre hote hain.","Tere bina tanha ham rehne lage hain,\n" +
                        "Dard ke toophano ko sehne lage hain,\n" +
                        "Badal gayi hai isakadar meri jindagee,\n" +
                        "Ashk banakar palakon se behne lage hain!\n" +
                        "~•i miss you~.","Ashq wo bhi girane lage hain,\n" +
                        "Paigam unke bhi aane lage hain,\n" +
                        "Kareeb aaye bhi wo to aaye us waqt,\n" +
                        "Jab unhe laga hum unke bina muskurane lage hai.","Kis Pal Tum Ko Yaad Na Kiya Humne,\n" +
                        "Mere Rom Rom Se Puch,\n" +
                        "Maine Apne Aap Ko Kahan Nahi Jalaya Mom-Mom Se Puch,\n" +
                        "Tujhse Ruth Jane Ke Baad Khud Ko Kahan Nahi Jalaya Yeh Mujhse Puch.","Manzilein Bhi Uski Thi Rasta Bhi Uska Tha,\n" +
                        "Main Akela Tha Aur Qafila Bhi Uska Tha,\n" +
                        "Sath-Sath Chalne Ki Soch Bhi Uski Thi,\n" +
                        "Fir Rasta Badal Lene Ka Faisla Bhi Uska Tha,\n" +
                        "Aaj kyun akela hoon Dil sawal karta hai,\n" +
                        "Log to uske the Kya KHUDA bhi uska tha ?\n" +
                        "\n","Taqdeer ne jaisa chaha dhal gaye hum,\n" +
                        "Bahut sambhal ke chale fir Bhi fisal gaye hum,\n" +
                        "Hum to kisiko bhula na sake,\n" +
                        "Fir Bhi sabko laga ki badal gaye hum.",
                        "Sharab Sareer Ko Khatam Krti Hai\n" +
        "Sharab Samaj Ko Khatam Krti Hai,\n" +
                "Aao Aaj Is Sharab Ko Khatam Krte Hain,\n" +
                "Ek Bottle Tum Khtam Kro, Ek Bottle Hum Khatam Krte Hai..","Ishq-a-bewafai ne daal di hai aadat buri,\n" +
                "Main bhi sharif hua karta tha is zamane mein,\n" +
                "Pehle din shuru karta tha masjid mein namaaz se,\n" +
                "Ab dhalti hai shaam sharab ke sath mehkhane mein.","Madhhosh hum hardam raha karte hain,\n" +
                "Aur ilzaam sharaab ko diya karte hain,\n" +
                "Kasoor sharaab ka nahi unka hai yaron,\n" +
                "Jinka chehra hum har jaam mein talaash kiya karte hain.","Aashikon ko mohabbat ke alava agar kuchh kaam hota,\n" +
                "Toh maikhane jake har roz yun badnam na hota,\n" +
                "Mil jaati chahne wali usse bhi kahin raah mein koi,\n" +
                "Agar kadmon mein nasha aur hath mein jaam na hota.","Pee ke raat ko hum unko bhulane lage,\n" +
                "Sharab mein gham ko milane lage,\n" +
                "Daru bhi bewafa nikali yaron,\n" +
                "Nashe mein to woh aur bhi yaad aane lage.","Raat chup hai magar chand khamosh nahi,\n" +
                "Kaise kahoon aaj phir hosh nahi,\n" +
                "Is tarah dooba hoon teri mohabbat ki gahrai mein,\n" +
                "Hath mein jaam hai aur peena ka hosh nahi.","Rok do mere janaze ko zaalimon,\n" +
                "Mujh mein jaan aa gayi hai,\n" +
                "Peeche mud ke dekho kameeno,\n" +
                "Daru ki dukan aa gayi hai…\n" +
                "CHEERS !!","Ek jaam ulfat ke naam,\n" +
                "Ek jaam mohabat ke naam.\n" +
                "Ek jaam wafa k naam,\n" +
                "Puri botal bewafa ke naam,\n" +
                "Aur pura theka doston ke naam.","Teri aankhon ke ye jo pyale hain,\n" +
                "Meri andheri raaton ke ujale hain,\n" +
                "Peeta hoon jaam par jaam tere naam ka,\n" +
                "Hum to sharabi be-sharab wale hain..!!","Pee hai sharab har gali har dukan se,\n" +
                "Ek dosti si ho gai hai sharab ke jaam se,\n" +
                "Guzre hain hum ishq mein kuchh aise mukam se,\n" +
                "Ke nafrat si ho gai hai mohabbat ke naam se.","Gham is kadar mila ki ghabra ke pee gaye,\n" +
                "Khushi thodi si mili to mila ke pee gaye,\n" +
                "Yun to naa thi janam se peene ki aadat,\n" +
                "Sharab ko tanha dekha to taras khaa ke pee gaye.\n" +
                "\n","Nasha hum karte hain,\n" +
                "ilzaam sharaab ko diya jaata hai,\n" +
                "magar ilzaam sharab ka nahi unka hai,\n" +
                "jinka chehra hume har jaam me nazar aata hai.","Log Peete Hai Sharab Mehkhane Ja-Ja Kar,\n" +
                "\n" +
                "Jo Do Pal Mein Utar Jayegi,\n" +
                "\n" +
                "Humne To Pee Hai Apne Mehboob Ki Aankho Se,\n" +
                "\n" +
                "Jo Umar Bhar Naa Utar Payegi.","Kuch Log Peete Hain Gam Bhoolane Ko,\n" +
                "\n" +
                "Kuch Log Peete Hain Koi Aur Gam Bhoolaane Ko,\n" +
                "\n" +
                "Par Ai Dost Ye Kya,\n" +
                "\n" +
                "Hum To Mahoal Na Milane Ke Gam Mein Peete Hain.","Ek Jahan Maanga Tha Jisme Bahot Saara Pyar Mile,\n" +
                "\n" +
                "Magar De Diya Mehkhana Jahan Bahot Saari Sharab Thi\n" +
                "\n" +
                "Ek Kandha Maanga Tha Jiska Mujhe Sahara Mile,\n" +
                "\n" +
                "Magar De Di Zindagi Jahan Duniya Bhar Ki Tanhai Thi.","Dard Ki Mehfil Me Ek Sher Hum Bhi Arz Kiya Karte Hai,\n" +
                "\n" +
                "Na Kisi Se Marham Na Duaon Ki Ummed Kiya Karte Hai,\n" +
                "\n" +
                "Kayi Chehre Lekar Log Yaha Jiya Karte Hai,\n" +
                "\n" +
                "Hum In Aasunao Ko Ek Chehre Ke Liye Peeya Karte Hai.","Dil Pe Jab Se Sharab Ka Pehra Lag Gaya,\n" +
                "\n" +
                "Gam Ka Andar Aane Ka Raasta Band Ho Gaya,\n" +
                "\n" +
                "Zubaan Ne Jab Se Sharab Ko Choo Liya,\n" +
                "\n" +
                "Uska Naam Hamesha Ke Liye Bhool Gaya.","Gham Is Kadar Mila Ki Ghabra Ke Pee Gaye,\n" +
                "\n" +
                "Khushi Thodi Si Mili To Mila Ke Pee Gaye,\n" +
                "\n" +
                "Yun To Naa Thi Janam Se Peene Ki Aadat,\n" +
                "\n" +
                "Sharab Ko Tanha Dekha To Taras Khaa Ke Pee Gaye.","Raat Chup Hai Magar Chand Khamosh Nahi,\n" +
                "\n" +
                "Kaise Kahoon Aaj Phir Hosh Nahin,\n" +
                "\n" +
                "Is Tarah Dooba Hoon Teri Mohabbat Ki Gahrai Mein,\n" +
                "\n" +
                "Hath Mein Jaam Hai Aur Peena Ka Hosh Nahin.","Yaaron Ki Mehfil Aise Jamai Jati Hai,\n" +
                "\n" +
                "Khulne Se Pehle Botal Hilaayi Jati Hai,\n" +
                "\n" +
                "Fir Awaz Lagayi Jati Hai Aa Jao Tute Dil Walo,\n" +
                "\n" +
                "Yeh Dard-E-Dil Ki Dawa Pilayi Jati Hai.","Hamesha Yad Ati Hai Unki,\n" +
                "\n" +
                "Aur Mood Ho Jata Hai Kharab,\n" +
                "\n" +
                "Tab Hamesha Lekar Baithe Hai Hum,\n" +
                "\n" +
                "Ek Hath Me Kalam Aur Ek Hath Me Sharab.","Dil Pe Jab Se Sharab Ka Pehra Lag Gaya,\n" +
                "\n" +
                "Gam Ka Andar Aane Ka Raasta Band Ho Gaya\n" +
                "\n" +
                "Zubaan Ne Jab Se Sharab Ko Chhu Liya,\n" +
                "\n" +
                "Uska Naam Hamesha Ke Liye Bhool Gaya."
                };
        ma= new MyAdapter(sad,Sad.this);
        viewpager.setAdapter(ma);
        shayaricount = findViewById(R.id.count);
        shayaricount.setText(String.format("Sad Shayari : %d/%d", viewpager.getCurrentItem() + 1, sad.length));
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @SuppressLint("DefaultLocale")
            @Override
            public void onPageSelected(int position) {

                shayaricount.setText(String.format("Sad Shayari : %d/%d", position+1 , sad.length));
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
                whatsappIntent.putExtra(Intent.EXTRA_TEXT, sad[viewpager.getCurrentItem()]);
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
                ClipData clip = ClipData.newPlainText("msg", sad[viewpager.getCurrentItem()]);
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



