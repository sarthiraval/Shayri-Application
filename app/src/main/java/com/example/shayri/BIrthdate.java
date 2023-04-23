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

public class BIrthdate extends AppCompatActivity {
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
        setContentView(R.layout.activity_birthdate);
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
        final String[] birthdat =
                {"Aap wo phool ho jo gulshan mein nahin khilte,\n" +
                        "Par jis pe aasmaan ke farishte bhi fakr hai karte,\n" +
                        "Aap ki zindagi hadd se zyada kimti hain,\n" +
                        "Janam din aap hamesha mnaye yu hi hanste hanste.\n" +
                        "Janamdin Mubarak","Janm Din Ke Yeh Khaas Lamhe Mubarak,\n" +
                        "Aankho Mein Base Naye Khwab Mubarak,\n" +
                        "Zindgi Jo Lekar Aayi Hai Aapke Liye Aaj..\n" +
                        "Woh Tamaam Khushiyo Ki Haseen Saugat Mubarak.\n" +
                        "Happy Birthday!","Thofa Mai Tujhe Aaj Mera Dil Hi Deta Hu,\n" +
                        "Yeh Hasin Mauka Gawana Nahi Chata Hu,\n" +
                        "Apne Dil Ki Baat Tumhare Samne Batlata Hu,\n" +
                        "Aur Tumhare Janam Din Ki Shubh Kamnae Deta Hu.\n" +
                        "HAPPY BIRTHDAY","Main likh du tumhari umar chand sitaaro se,\n" +
                        "Janamdin manau main phoolo se baharo se,\n" +
                        "Har ek khoobsurti duniya se main lekar aau,\n" +
                        "Mehfil ye sajaau main har haseen najaro se.\n" +
                        "\n" +
                        "Happy Birthday My Dear","Life का हर Goal रहे आपका Clear,\n" +
                        "तुम Success पाओ Without any Fear\n" +
                        "हर पल जियो Without any Tear,\n" +
                        "Enjoy your day my Dear,\n" +
                        "HAPPY BIRTHDAY","On these Beautiful Birthday,\n" +
                        "भगवान करे आप Enjoyment से\n" +
                        "भरपूर और Smile से अपना आज\n" +
                        "का दिन Celebrate करो, और\n" +
                        "बहुत सारी Surprises पाओ,,,\n" +
                        "HAPPY BIRTHDAY","Har disha jine ki ek nayi aas de apko,\u2028Har lamha har pal kuch khaas de apko,\n" +
                        "Ugta huya suraj\uD83C\uDF1E, khiltaa huya phoool\uD83C\uDF37\u2028Har din taazgi bhara ehsaas de apko\n" +
                        "Zindagi me kabi koi chiz ki kami na ho,\u2028Jo maango rab se wo sab kuch de apko\n" +
                        "Wish u a very Happy Birthday","Tohfa-e-dil de doon ya de doon chand taare,\n" +
                        "Janam din pe tujhe kya du ye puche mujhse saare,\n" +
                        "Zindagi tere naam kar doon toh bhi kam hain,\n" +
                        "Daman me bhar du har pal khushiya main tumhare.\n" +
                        "\n" +
                        "Wish u a very Happy Birthday","Main likh du tumhari umar chand sitaaro se,\n" +
                        "Janamdin manau main phoolo se baharo se,\n" +
                        "Har ek khoobsurti duniya se main lekar aau,\n" +
                        "Mehfil ye sajaun main har haseen najaro se.\n" +
                        "\n" +
                        "Happy Birthday My Dear","Birthday ki toh party honi chahiye,\n" +
                        "wish to morning ki bhi hoti hai.","Tohfa-e-dil de doon ya de doon chand taare,\n" +
                        "Janam din pe tuje kya du ye puche mujhse saare\n" +
                        "Zindagi tere naam kar doon toh bhi kam hain,\n" +
                        "Daman me bhar du har pal khushiya me tumhare","Main likh du tumhari umar chand sitaaro se,\n" +
                        "Janamdin manau main phoolo se baharo se\n" +
                        "Har ek khoobsurti duniya se main lekar aau,\n" +
                        "Mehfil ye sajaau main har haseen najaro se","Zaroor tumko kisine dil se pukara hoga,\n" +
                        "Ek baar to chand ne bhi tumko nihara hoga,\n" +
                        "Mayus hue honge sitare bhi us din,\n" +
                        "Khuda ne jab Zamin par tumko utara hoga.\n" +
                        "Janmadin Mubarak!","Har lamha apke hothon pe muskan rahe,\n" +
                        "Har ghum se aap anjaan rahen,\n" +
                        "Jiske sath mehak uthe aapki zindgi,\n" +
                        "Hamsha aapke pass woh insan rahe.\n" +
                        "Happy Birthday","Har raah aasan ho,\n" +
                        "Har raah pe khushiya ho,\n" +
                        "Har din khubsoorat ho,\n" +
                        "Aisa hi poora jivan ho,\n" +
                        "Yahi har din meri dua ho,\n" +
                        "Aisa hi tumhara har janamdin ho!!!","Ae Khuda Mere Yaar Ka Daman Khusiyon Se Saza De,\n" +
                        "Uske Janamdin Par Usi Ki Koi Raza De,\n" +
                        "Dar Par Tere Aunga Har Saal,\n" +
                        "Ki Usko Gile Ki Na Koi Wajah De","Tamnnaon se bhari ho jindgi,\n" +
                        "Kwahisho se bhara ho har pal,\n" +
                        "Daaman bhi chhota lagne lage,\n" +
                        "Itani khushiya de aapko aane wala kal!!\n" +
                        "Happy Birth Day","Dua hai Ki Kamyabi ke har sikhar per aap ka naam hoga,\n" +
                        "Aapke har kadam per duniya ka salaam hoga,\n" +
                        "Himmat se mushkilon ka saamna karna,\n" +
                        "Hamari dua hai ki waqt bhi ek din aapka gulam hoga.","Dur hai to kya hoa aaj ka din to hame yaad hai,\n" +
                        "Tum na sahi par tumhara saya to hamare sath hai,\n" +
                        "Tumhe lagta hai hum sab bhul jate hai\n" +
                        "Par dekhlo tumhara janamdin to hame yaad hai."};


        ma= new MyAdapter(birthdat,BIrthdate.this);
        viewpager.setAdapter(ma);






        shayaricount = findViewById(R.id.count);
        shayaricount.setText(String.format("Birthday Shayari : %d/%d", viewpager.getCurrentItem() + 1, birthdat.length));
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @SuppressLint("DefaultLocale")
            @Override
            public void onPageSelected(int position) {

                shayaricount.setText(String.format("Birthday Shayari : %d/%d", position+1 , birthdat.length));
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
                whatsappIntent.putExtra(Intent.EXTRA_TEXT, birthdat[viewpager.getCurrentItem()]);
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
                ClipData clip = ClipData.newPlainText("msg", birthdat[viewpager.getCurrentItem()]);
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
