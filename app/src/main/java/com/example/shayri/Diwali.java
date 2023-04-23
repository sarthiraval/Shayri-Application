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

public class Diwali extends AppCompatActivity {
    NavigationView navigationView;

    TextView shayaricount;

    ViewPager viewpager;
    MyAdapter ma;

    ImageButton previous;
    ImageButton next;
    ImageButton whatsapp;
    ImageButton copy;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diwali);

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
        final String[] diwali =
                {"Ki aap chillar pane ko tarse.\n" +
                        "HAPPY DHANTERAS !!\n" +
                        "Deepak ki roshni, Mithaiyo ki mithas,\n" +
                        "Patakho ki bochar, Dhan ki barsaat,\n" +
                        "Har pal Har din Aapke liye laye Dhanteras ka tyohar.\n" +
                        "Happy Dhanteras!!!","Dear All ,\n" +
                        "May the lamps of joy, illuminate your life and fill your days with the bright sparkles of peace, mirth and goodwill. I wish you & your family a very happy deepawali !!! May god bless you!!!\n" +
                        "Wishing you happy diwali and prosperous New Year!!!\n" +
                        "With affection\n" +
                        "Rahul :)","\n" +
                        "Iss diwali pe hamari dua hai ki,\n" +
                        "Apka har sapnna pura ho,\n" +
                        "Duniya ke unche mukam apke ho,\n" +
                        "Shoharat ki bulandiyon par naam apka ho!\n" +
                        "Wish U a very Happy Diwali!","Deep jalte jagmagate rahe,\n" +
                        "Hum aapko aap hame yaad aate rahe,\n" +
                        "Jab tak zindagi hai,\n" +
                        "Dua hai hamari,\n" +
                        "Aap chand ki tarah zagmagate rahe.\n" +
                        "“Happy Diwali”","Safalta kadam chumti rahe,\n" +
                        "Khushi aaspas ghumti rahe,\n" +
                        "Yash itna faile ki KASTURI sharma jaye,\n" +
                        "Laxmi ki kripa itni ho ki BALAJI bhi dekhte rah jaye.\n" +
                        "“Happy Diwali”","Pal pal sunhare phool khile,\n" +
                        "Kabhi na ho kaanto ka saamna,\n" +
                        "Jindagi aapki khushiyo se bhari rahe,\n" +
                        "Dipawali par humaari yahi shubhkaamna…","Ek Dua Mangte hain hum apne Bhagwan se,\n" +
                        "Chahte hai Aapki Khushi Pure imaan se,\n" +
                        "Sab Hasratein Puri Ho Aapki,\n" +
                        "Aur Aap Muskarayen Dil-o-Jaan se!!\n" +
                        "Happy Diwali that leads you on the road of Success…","Diyon ki roshni se jhilmilata aangan ho..\n" +
                        "patakhon ki goonjo se aasman roshan ho..\n" +
                        "aisi aaye jhum ke yeh diwali..\n" +
                        "har taraf kushiyon ka mausam ho..\n" +
                        "HAPPY DIWALI TO ALL FRIENDS..","Diyon ki roshni se jhilmilata aangan ho..\n" +
                        "patakhon ki goonjo se aasman roshan ho..\n" +
                        "aisi aaye jhum ke yeh diwali..\n" +
                        "har taraf kushiyon ka mausam ho..","Tamaan jahaan jagmagaya,\n" +
                        "Fir seTyohar Roshni ka aaya,\n" +
                        "Koi tumhe hamnse pehle\n" +
                        "Na dede badhayian,\n" +
                        "Isliye,\n" +
                        "ye paigam e mubarak\n" +
                        "sabse pehle humne bhijwaya\n" +
                        "“Diwali Mubarak“","Muskarte hanste deep tum jalana,\n" +
                        "Jivan main nai khushiyon ko lana,\n" +
                        "Dukh dard apne bhool kar,\n" +
                        "Sabko gale lagna, sabko gale lagna…\n" +
                        "Appko is diwali ki shubhkamnaye…"," Let this diwali burn all your bad times and enter you in good times.\n",
                        "o The truth is that existence wants your life to become a festival…because when you are unhappy, you also throw unhappiness all around.\n",
                        "o Ram! The light of lights, the self-luminous inner light of the Self is ever shining steadily in the chamber of your heart. Sit quietly. Close your eyes. Withdraw the senses. Fix the mind on this supreme light and enjoy the real Deepavali, by attaining illumination of the soul.\n",
                        "o He who Himself sees all but whom no one beholds, who illumines the intellect, the sun, the moon and the stars and the whole universe but whom they cannot illumine, He indeed is Brahman, He is the inner Self. Celebrate the real Deepavali by living in Brahman, and enjoy the eternal bliss of the soul.\n",
                        "o The sun does not shine there, nor do the moon and the stars, nor do lightning shine? All the lights of the world cannot be compared even to a ray of the inner light of the Self. Merge yourself in this light of lights and enjoy the supreme Deepavali.\n",
                        "o Many Deepavali festivals have come and gone. Yet the hearts of the vast majority are as dark as the night of the new moon. The house is lit with lamps, but the heart is full of the darkness of ignorance. O man! wake up from the slumber of ignorance. Realize the constant and eternal light of the Soul which neither rises nor sets, through meditation and deep enquiry.\n",
                        "o May you all attain full inner illumination! May the supreme light of lights enlighten your understanding! May you all attain the inexhaustible spiritual wealth of the Self! May you all prosper gloriously on the material as well as spiritual planes\n","Puja ki Thali, Rasoi me PAKWAAN.\n",
                        "Aangan me Diya, Khushiya ho TAMAAM.\n" +
                                "Haathon me fuljhariya, Roshan ho JAHAAN.\n" +
                                "Mubarak ho aapko DIWALI Meri JAAN…\n" +
                                "Laxmi devi ka nur aap par barse,\n" +
                                "Har koi aapse loan lene ko tarse,\n" +
                                "Bhagwan aapko de itne paise,\n" +
                                "Ki aap chillar pane ko tarse.\n" +
                                "HAPPY DHANTERAS !!","Deepak ki roshni, Mithaiyo ki mithas,\n" +
                        "Patakho ki bochar, Dhan ki barsaat,\n" +
                        "Har pal Har din Aapke liye laye Dhanteras ka tyohar.\n" +
                        "Happy Dhanteras!!!"};
        ma= new MyAdapter(diwali,Diwali.this);
        viewpager.setAdapter(ma);






        shayaricount = findViewById(R.id.count);
        shayaricount.setText(String.format("Diwali Shayari : %d/%d", viewpager.getCurrentItem() + 1, diwali.length));
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @SuppressLint("DefaultLocale")
            @Override
            public void onPageSelected(int position) {

                shayaricount.setText(String.format("Diwali Shayari : %d/%d", position+1 , diwali.length));
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
                whatsappIntent.putExtra(Intent.EXTRA_TEXT, diwali[viewpager.getCurrentItem()]);
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
                ClipData clip = ClipData.newPlainText("msg", diwali[viewpager.getCurrentItem()]);
                assert clipboard != null;
                clipboard.setPrimaryClip(clip);
                Toast.makeText(getBaseContext(),"Copied To Clipboard !",Toast.LENGTH_SHORT).show();
            }
        });

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
