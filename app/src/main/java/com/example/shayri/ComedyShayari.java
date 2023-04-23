package com.example.shayri;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
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

public class ComedyShayari extends AppCompatActivity {

  
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
        setContentView(R.layout.activity_comedy_shayari);

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
        final String[] Comedypmsg =
                {
                      "किसी का हाथ थाम के छोड़ना नहीं,\n" +
                              "वादा किसी से कर के तोड़ना नहीं,\n" +
                              "कोई अगर तोड़ दे दिल आपका तो,\n" +
                              "बिना हाथ पैर तोड़े उसे छोड़ना नहीं।",

                        "अर्ज किया है...\n" +
                                "वो तुम्हें Dp दिखाकर गुमराह करेगी,\n" +
                                "मगर तुम आधार कार्ड पर अड़े रहना।",

                        "तुम्हारी शायरी बड़ी है फाइरी,\n" +
                                "तुम्हारी शायरी बड़ी है फाइरी,\n" +
                                "दिल करता है जल जाये\n" +
                                "तुम्हारी शायरी वाली डायरी।",

                        "मेरी प्रेम कहानी का क्या अजीब एंडिंग था,\n" +
                                "मेरी प्रेम कहानी का क्या अजीब एंडिंग था,\n" +
                                "मैंने प्रोपोज़ किआ SMS से,\n" +
                                "कमबख्त वह उसकी शादी तक पेंडिंग था।",

                        "ताजमहल किसी के लिए एक अजूबा है,\n" +
                                "तो किसी के लिए प्यार का एहसास है,\n" +
                                "हमारे तुम्हारे लिए तो बकवास है,\n" +
                                "क्यूँ की की रोज़ बदलती हमारी मुम्ताज़ है।",


                        "अजब सी हालत है तेरे जाने के बाद,\n" +
                                "मुझे भूख लगती नहीं खाना खाने के बाद,\n" +
                                "मेरे पास दो ही समोसे थे जो मैंने खा लिए,\n" +
                                "एक तेरे आने से पहले, एक तेरे जाने के बाद।",

                        "ए गुलाब अपनी खुशबू को\n" +
                                "मेरे दोस्तों पर न्योछावर कर दे,\n" +
                                "यह सर्दी के मौसम में\n" +
                                "अक्सर नहाया नहीं करते।",

                        "देखा है तुम्हारे आगे,\n" +
                                "शर्मा के फूलों को मुरझाते,\n" +
                                "ए जहाँ को घायल करने वाले\n" +
                                "तुम डिओडोरेंट क्यों नहीं लगाते।",

                        "आज कुछ शर्माए से लगते हो,\n" +
                                "सर्दी के कारण कपकपए से लगते हो,\n" +
                                "चेहरा आपका खिलखिलाये सा लगता है,\n" +
                                "हफ्ते के बाद नहाए से लगते हो।",

                        "खुद का बच्चा रोये तो दिल में दर्द होता है,\n" +
                                "किसी और का रोये तो सर में दर्द होता है,\n" +
                                "खुद की बीवी रोये तो भी सर में दर्द होता है,\n" +
                                "किसी और की रोये तो दिल में दर्द होता है।",

                        "जब हम उनके घर गए...\n" +
                                "कहने दिल से दिल लगा लो,\n" +
                                "उनकी माँ ने खोला दरवाजा,\n" +
                                "हम घवरा के बोले..\n" +
                                "आंटी बच्चो को पोलियो ड्राप पिलवा लो।",

                        "इश्क के चर्चे बहुत हैं दोस्तों,\n" +
                                "हुस्न के पर्चे बहुत है यारों,\n" +
                                "इश्क करने से पहले जान लेना,\n" +
                                "इसमें खर्चे बहुत है दोस्तो।",

                        "कुछ बोलूं तो इतराते बहुत हो,\n" +
                                "जानेमन तुम मुस्कुराते बहुत हो,\n" +
                                "मन करता है तुम्हे दावत पर बुलाऊँ,\n" +
                                "लेकिन जानेमन तुम खाते बहुत हो।",

                        "जब तिरछी नजरों से उन्होंने हमको देखा,\n" +
                                "तो हम मदहोश हो गए\n" +
                                "जब पता लगा उनकी नज़रें ही तिरछी हैं\n" +
                                "तो हम बेहोश हो गए।",

                        "नजर न लग जाये आँखों में काजल लगा लो,\n" +
                                "हम कहते हैं आँखों में काजल ही नहीं,\n" +
                                "हो सके तो...\n" +
                                "गले में नीबू मिर्ची चप्पल भी लटका लो,",

                        "मीठी मीठी यादों को पलकों पे सजा लेना,\n" +
                                "साथ गुज़रे लम्हों को दिल में बसा लेना,\n" +
                                "मैं तो बरसों का प्यासा हूँ, 'फराज़',\n" +
                                "बिजली आ जाये तो याद से मोटर चला देना।",

                        "मेरी ख़ुशी के लम्हे इस कदर\n" +
                                "मुख़्तसर हैं फ़राज़,\n" +
                                "अभी मुजरा शुरू ही हुआ था\n" +
                                "के छापा पड़ गया।",

                        "मासूम सी मुहब्बत का फ़राज़\n" +
                                "बस इतना सा फ़साना है..\n" +
                                "अम्मी घर से निकलने नहीं देती\n" +
                                "और मुझी डेट पर जाना है।",

                        "मोहब्बत करते हैं लोग बड़े शोर के साथ,\n" +
                                "हमने भी बड़े जोर के साथ,\n" +
                                "लेकिन अब करेंगे थोड़ा गौर के साथ,\n" +
                                "क्योंकि कल उसे देखा है किसी और के साथ।",

                        "दोस्तो हम उन्हें मुड़ मुड़कर देखते रहे,\n" +
                                "और वो हमें मुड़-मुड़ कर देखते रहे,\n" +
                                "वो हमें हम उन्हें, वो हमें हम उन्हें,\n" +
                                "क्योंकि परीक्षा में न उन्हें कुछ आता था न हमे।",

                        "जब दरवाजा खोलने गये तो चेहरे पर हसी थी,\n" +
                                "दरवाजा खोला तो आँखों में आँसू दिल में बेबसी थी,\n" +
                                "ज्यादा मत सोच पगले,\n" +
                                "मेरी ऊँगली दरवाजे में फंसी थी,",


                        "इस दुनिया में लाखों लोग रहते हैं,\n" +
                                "कोई हँसता है तो कोई रोता है,\n" +
                                "पर सबसे सुखी वही होता है,\n" +
                                "जो शाम को दो पैग मार के सोता है।",


                        "न वफ़ा का ज़िक्र होगा,\n" +
                                "न वफ़ा की बात होगी,\n" +
                                "अब मोहब्बत जिस से भी होगी,\n" +
                                "राखी के बाद होगी।",

                        "अर्ज किया है…\n" +
                                "तेरे चेहरे पर उदासी, आँखों में नमी है,\n" +
                                "तेरे चेहरे पर उदासी, आँखों में नमी है,\n" +
                                "टाटा नमक इस्तेमाल करो,\n" +
                                "क्योंकि तुम में आयोडीन की कमी है।",

                        "ज़िन्दगी में सदा मुस्कराते रहो,\n" +
                                "फासले कम करो दिल से दिल मिलाते रहो,\n" +
                                "दर्द कैसा भी हो कोई ग़म न करो,\n" +
                                "आयोडेक्स खरीदो और लगाते रहो।",

                        "कदम -कदम पर हवा की आहट का ध्यान रखना,\n" +
                                "मुश्किल समय में भी इस दोस्त को याद रखना,\n" +
                                "हमारी यादों की खुशबू जरूर आएगी,\n" +
                                "तुम बस अपनी नाक साफ़ रखना।\n",

                        "ए खूबसूरत हसीना,\n" +
                                "तू सिर्फ सवाल नहीं एक पहेली है,\n" +
                                "और जिसपे हम लाइन मारते हैं,\n" +
                                "वो तू नहीं तेरी सहेली है।",

                        "मेरी गैरत को क्या ललकारेगा जमाना,\n" +
                                "A फॉर Apple B फॉर Banana।",

                        "दोस्तो हम उन्हें मुड़ मुड़कर देखते रहे,\n" +
                                "और वो हमें मुड़-मुड़ कर देखते रहे,\n" +
                                "वो हमें हम उन्हें, वो हमें हम उन्हें,\n" +
                                "क्योंकि परीक्षा में न उन्हें कुछ आता था न हमे।",

                        "तेरे ग़म में तड़प कर मर जायेंगे,\n" +
                                "मर गए तो तेरा नाम ले जायेंगे,\n" +
                                "रिश्वत देकर तुझे भी बुलायेंगे,\n" +
                                "तुम ऊपर आओगे तो साथ बैठकर कुरकुरे खायेंगे।",

                        "अर्ज किया है…\n" +
                                "खिड़की से झाँक के देखा तो रास्ते में कोई नहीं था,\n" +
                                "खिड़की से झाँक के देखा तो रास्ते में कोई नहीं था,\n" +
                                "वाह वाह… फिर रास्ते में जा कर देखा…\n" +
                                "तो खिड़की पर कोई नहीं था।",

                        "दोस्ती बुरी हो तो होने उसे मत दो,\n" +
                                "अगर हो गयी तो उसे खोने मत दो,\n" +
                                "और अगर दोस्त हो सबसे प्यारा तो,\n" +
                                "उसे चैन की नींद सोने मत दो।",

                        "रंग और नूर से भरी शाम हो आपकी,\n" +
                                "चाँद सितारों से ज्यादा शान हो आपकी,\n" +
                                "इस ज़िन्दगी में बस एक ही आरजू है हमारी,\n" +
                                "कि बंदर से ऊँची छलांग हो आपकी।",

                        "इश्क को सर का दर्द कहने वाले सुन,\n" +
                                "हमने तो ये दर्द अपने सर ले लिया,\n" +
                                "हमारी निगाहों से बचकर वो कहाँ जायेंगे,\n" +
                                "हमने उनके मोहल्ले में ही घर ले लिया।",

                        "सितारों में आप, हवाओ में आप,\n" +
                                "फिज़ाओ में आप, बहरो में आप,\n" +
                                "धूप में आप, चाओं में आप,\n" +
                                "सच ही सुना है कि….\n" +
                                "बुरी आत्माओं का कोई ठिकाना नहीं होता।",


                        "मीठी मीठी यादों को पलकों पे सजा लेना,\n" +
                                "साथ गुज़रे लम्हों को दिल में बसा लेना,\n" +
                                "मैं तो बरसों का प्यासा हूँ, ‘फराज़’,\n" +
                                "बिजली आ जाये तो याद से मोटर चला देना।",

                        "प्यार-मोहब्बत की बस इतनी सी कहानी है,\n" +
                                "इक टूटी हुई कश्ती और ठहरा हुआ पानी है,\n" +
                                "इक फूल जो किताबों में कहीं दम तोड़ चुका है,\n" +
                                "कुछ याद नहीं आता किसकी निशानी है।",

                        "वो दिन दिन नही, वो रात रात नही,\n" +
                                "वो पल पल नही, जिस पल आपकी बात नही,\n" +
                                "आपकी यादों से मौत हमे अलग कर सके,\n" +
                                "मौत की भी इतनी औकात नही।",

                        "जब तिरछी नजरों से उन्होंने हमको देखा,\n" +
                                "तो हम मदहोश हो गए\n" +
                                "जब पता लगा उनकी नज़रें ही तिरछी हैं\n" +
                                "तो हम बेहोश हो गए।",

                        "शादी करनी थी पर किस्मत खुलती नहीं,\n" +
                                "ताज बनाना था पर मुमताज मिलती नहीं,\n" +
                                "एक दिन किस्मत खुली और शादी हो गई,\n" +
                                "अब ताज बनाना है पर मुमताज मरती नहीं।",

                        "जितने भी लड़के लगाते हैं\n" +
                                "तेरी गली की गेरियां,\n" +
                                "मुहं पर थूक जाएँ अगर देख ले\n" +
                                "तेरी फटी हुई एड़ियाँ।",

                        "मेरी ख़ुशी के लम्हे इस कदर\n" +
                                "मुख़्तसर हैं फ़राज़,\n" +
                                "अभी मुजरा शुरू ही हुआ था\n" +
                                "के छापा पड़ गया।",

                        "रख ले 2-4 बोतल कफ़न में,\n" +
                                "साथ बैठ कर पिया करेंगे,\n" +
                                "जब मांगे गए हिसाब गुनाहों का,\n" +
                                "एक पेग उससे भी दे दिया करेंगे।",

                        "छलकते पैमाने ने मेरे अश्को से कहा,\n" +
                                "छलकते पैमाने ने मेरे अश्को से कहा,\n" +
                                "आई हेट टीयर्स पुष्पा आई हेट टीयर्स।",

                        "नजर न लग जाये आँखों में काजल लगा लो,\n" +
                                "हम कहते हैं आँखों में काजल ही नहीं,\n" +
                                "हो सके तो…\n" +
                                "गले में नीबू मिर्ची चप्पल भी लटका लो,",

                        "जवानी के दिन चमकीले हो गए,\n" +
                                "हुस्न के तेवर भी नुकीले हो गए,\n" +
                                "हम इंतज़ार करने में रह गए यारो,\n" +
                                "और उधर उनके हाथ पीले हो गए।",

                        "जब होता है तुम्हारा दीदार,\n" +
                                "दिल धड़कता है बार-बार,\n" +
                                "आदत से मजबूर हो तुम,\n" +
                                "न जाने कब मांग लो उधार।",

                        "फ़िज़ाओं के बदलने का इंतजार मत कर,\n" +
                                "आँधियों के रुकने का इंतजार मत कर,\n" +
                                "पकड़ किसी को और फरार हो जा,\n" +
                                "पापा की पसंद का इंतजार मत कर।",

                        "आज-कल तुम मुस्कुराती बहुत हो,\n" +
                                "मेरे दिल को भाती बहुत हो,\n" +
                                "दिल करता है ले जाऊँ तुम्हे डिनर पर,\n" +
                                "पर सुना है तुम खाती बहुत हो।",

                        "काला न कहो मेरे महबूब को,\n" +
                                "काला न कहो मेरे महबूब को,\n" +
                                "खुदा तो तिल ही बना रहा था,\n" +
                                "स्याही का प्याला लुढ़क गया।",

                        "अर्ज किया है…\n" +
                                "हटा लो अपने चेहरे से ये जुल्फे\n" +
                                "ऐ जाने तमन्ना…. खुदा कसम…\n" +
                                "अगली बार खाने में बाल आया तो\n" +
                                "सजनी से गजनी बना दूंगा।",

                        "कुछ बोलूं तो इतराते बहुत हो,\n" +
                                "जानेमन तुम मुस्कुराते बहुत हो,\n" +
                                "मन करता है तुम्हे दावत पर बुलाऊँ,\n" +
                                "लेकिन जानेमन तुम खाते बहुत हो।",

                        "ये जो लड़कियों के बाल होते हैं,\n" +
                                "लड़कों को फ़साने के जाल होते हैं,\n" +
                                "खून चूस लेती हैं लड़कों का सारा,\n" +
                                "तभी तो इनके होंठ लाल होते हैं।",

                        "मासूम सी मुहब्बत का फ़राज़\n" +
                                "बस इतना सा फ़साना है..\n" +
                                "अम्मी घर से निकलने नहीं देती\n" +
                                "और मुझी डेट पर जाना है।",

                        "अजब सी हालत है तेरे जाने के बाद,\n" +
                                "मुझे भूख लगती नहीं खाना खाने के बाद,\n" +
                                "मेरे पास दो ही समोसे थे जो मैंने खा लिए,\n" +
                                "एक तेरे आने से पहले, एक तेरे जाने के बाद।",

                        "आज तुम पे आँसुओं की बरसात होगी,\n" +
                                "फिर वही कडकती काली रात होगी,\n" +
                                "एस.एम.एस. न करके तूने जो दिल दुखाया मेरा,\n" +
                                "जा तेरे बदन में खुजली सारी रात होगी।",

                        "अर्ज किया है-\n" +
                                "तुम से नज़र मिलाते ही,\n" +
                                "भड़क उठे मेरे दिल में,\n" +
                                "मोहब्बत के शोले,\n" +
                                "ओले ओले ओले, ओले ओले।",

                        "इश्क के चर्चे बहुत हैं दोस्तों,\n" +
                                "हुस्न के पर्चे बहुत है यारों,\n" +
                                "इश्क करने से पहले जान लेना,\n" +
                                "इसमें खर्चे बहुत है दोस्तो।",

                        "उम्मीदों की शमा दिल में मत जलाना,\n" +
                                "इस जहां से अलग दुनिया मत बसाना,\n" +
                                "आज बस मूड में था तो मैसेज कर दिया,\n" +
                                "पर रोज इंतज़ार में पलके मत बिछाना।",

                        "याद रख कर मेरी दोस्ती को तुमने,\n" +
                                "मेरी जिंदगी पर एहसान कर दिया,\n" +
                                "मेरे मोबाइल में ये आखिरी रुपया था,\n" +
                                "ले वो भी तेरे नाम कर दिया।",

                        "क्यों बरसों से जुदाई का गम\n" +
                                "लैला और हीर सह रही हैं,\n" +
                                "जरा अपना रुमाल तो देना\n" +
                                "मेरी नाक बह रही है।",

                        "हमने धूप समझी वो छाया निकली,\n" +
                                "हमने गाय समझी वो भैंस निकली।\n" +
                                "बेडा गर्क हो इन ब्यूटी पार्लरों का,\n" +
                                "हमने तो उसे लडकी समझा था,\n" +
                                "लेकिन वो तो लड़की की माँ निकली।",

                        "अपनी सूरत का कभी तो दीदार दे,\n" +
                                "तड़प रहा हूँ अब और न इंतज़ार दे,\n" +
                                "अपनी आवाज नहीं सुनानी तो मत सुना,\n" +
                                "कम से कम एक मिस काल ही मार दे।",

                        "जब हम उनके घर गए…\n" +
                                "कहने दिल से दिल लगा लो,\n" +
                                "उनकी माँ ने खोला दरवाजा,\n" +
                                "हम घवरा के बोले..\n" +
                                "आंटी बच्चो को पोलियो ड्राप पिलवा लो।",

                        "वो बेवफा होती तो यारों बात और थी,\n" +
                                "उसकी वफ़ा से ही दिल में जखम है,\n" +
                                "हर दूसरे दिन उसका मैसेज आ जाता है,\n" +
                                "मोबाइल रिचार्ज करा दो बैलेंस ख़त्म है।",

                        "पहली नजर में लगा वो मेरी है,\n" +
                                "आँखें उसकी झील सी गहरी हैं,\n" +
                                "प्रोपोज़ कर कर के थक गए हम,\n" +
                                "अब पता चला वो तो बहरी है।",

                        "मेरे प्यार को बेवफाई का इनाम दे गई,\n" +
                                "मेरे दिल को अपनी यादों का पैगाम दे गई,\n" +
                                "मैंने कहा मेरे दिल में दर्द है तेरे बिना,\n" +
                                "तो वो जाते-जाते \"झंडूबाम\" दे गई।",

                        "धोखा मिला जब प्यार में हमे,\n" +
                                "ज़िन्दगी में उदासी छा गयी,\n" +
                                "सोचा था छोड़ देंगे प्यार करना,\n" +
                                "पर आज मोहल्ले में दूसरी आ गयी।",

                        "काश प्यार का इन्स्योरेंसे करवाया जाता,\n" +
                                "प्यार करने से पहले प्रीमियम भरवाया जाता,\n" +
                                "अगर प्यार में वफ़ा मिली तो ठीक वरना,\n" +
                                "जो खर्चा होता उसका क्लेम दिलवाया जाता।",

                        "एक बूँद से सागर नहीं बनता,\n" +
                                "रोने से मुक़द्दर नहीं बनता,\n" +
                                "पटाना है तो पूरा गर्ल्स हॉस्टल पटाओ,\n" +
                                "एक लड़की पटाके कोई सिकंदर नहीं बनता।",

                        "उम्मीदों की मंजिल टूट गयी,\n" +
                                "आँखों से अश्को की धारा बह गयी,\n" +
                                "अरे तुम्हरी भी क्या इज्ज़त रह गयी,\n" +
                                "जब क्लास में लड़की भैया कह गयी।",

                        "अर्ज़ किया है…\n" +
                                "बेइज़्ज़ती और बीवी अजीब चीज़ होती है,\n" +
                                "गौर फरमाइएगा…\n" +
                                "बेइज़्ज़ती और बीवी अजीब चीज़ होती है,\n" +
                                "अच्छी तभी लगती है जब दूसरे की होती है।",

                        "मुक़द्दर में रात को नींद नहीं तो क्या,\n" +
                                "मुक़द्दर में रात को नींद नहीं तो क्या,\n" +
                                "हम भी मुक़द्दर को चूना लगाते हैं,\n" +
                                "और दिन में ही सो जाते हैं।",

                        "तेरी दुनिया में कोई गम न हो,\n" +
                                "तेरी खुशियाँ कभी कम न हों,\n" +
                                "भगवान तुझे ऐसी आइटम दे,\n" +
                                "जो सनी लिओने से कम न हो।",

                        "धोखा मिला जब प्यार में हमें,\n" +
                                "ज़िंदगी में उदासी छा गयी,\n" +
                                "सोचा था छोड़ देंगे प्यार करना,\n" +
                                "पर आज मोहल्ले में दूसरी आ गयी।",

                        "धड़कन दिल की रुक जाती है,\n" +
                                "साँसें भी अक्सर थम जाती है,\n" +
                                "बहुत बुरी हालत होती है यारो,\n" +
                                "जब गर्लफ्रेंड से शादी की नौबत आती है।",

                        "तेरी दुनिया में कोई गम ना हो,\n" +
                                "तेरी खुशियाँ कभी कम न हो,\n" +
                                "भगवान तुझे ऐसी आइटम दे,\n" +
                                "जो सनी लिओनी से कम ना हो।",

                        "उम्मीदों की मंजिल ढह गयी,\n" +
                                "ख्वाबों की दुनिया बह गयी,\n" +
                                "अबे तेरी क्या इज्ज़त रह गयी,\n" +
                                "जब झक्कास आइटम तेरे को भैया कह गयी।",

                        "मेरे दोस्त तुम भी लिखा करो शायरी,\n" +
                                "तुम्हारा भी मेरी तरह नाम हो जाएगा,\n" +
                                "जब तुम पर भी पड़ेंगे अंडे और टमाटर,\n" +
                                "तो शाम की सब्जी का इंतज़ाम हो जाएगा।",

                        "ख्याल को किसी आहट की आस रहती है,\n" +
                                "निगाह को किसी सूरत की तलास रहती है,\n" +
                                "तेरे बिन कोई कमी तो नहीं है, दोस्त,\n" +
                                "बस गली वाली जमादारनी उदास रहती है।",

                        "आसमान में काली घटा छाई है,\n" +
                                "आज फिर तूने गर्लफ्रेंड से मार खाई है,\n" +
                                "मगर इसमें तेरी गलती नहीं है दोस्त,\n" +
                                "तू शकल से लगता कालू हलवाई है।",

                        "जब सफेद साड़ी पे लाल बिंदी लगाती हो,\n" +
                                "कसम से एम्बुलेंस नजर आती हो,\n" +
                                "वो तो घायलों को लेकर जाती है,\n" +
                                "और तुम घायल कर के जाती हो।",

                        "ना जाने वो हमसे क्या छुपाती थी,\n" +
                                "कुछ था जरुर उसके प्यारे से होंठो पे,\n" +
                                "मगर ना जाने क्यों हमसे शर्माती थी,\n" +
                                "जब मुह खुलबाया तब जाकर मालूम हुआ,\n" +
                                "साली चुप-चाप पान मसाला चबाती थी।",

                        "फूलों में गुलाब अच्छा लगता है,\n" +
                                "हर चेहरे पर शबाब अच्छा लगता है,\n" +
                                "आप जब नाक से चूहे निकालते हो,\n" +
                                "हमें आपका वो अंदाज़ अच्छा लगता है।",

                        "मेरी हँसी का हिसाब कौन करेगा?\n" +
                                "मेरी गलती को माफ़ कौन करेगा?\n" +
                                "ऐ-खुदा, मेरे दोस्त को सलामत रखना,\n" +
                                "वरना मेरी शादी पे “लुंगी डांस” कौन करेगा",

                        "जुल्फों में फूलों को सजा के आयी,\n" +
                                "चेहरे से दुपट्टा उठा के आयी,\n" +
                                "किसी ने पूछा आज बड़ी खुबसूरत लग रही है,\n" +
                                "हमने कहा शायद आज नहा के आयी।",

                        "सफ़र लम्बा है दोस्त बनाते रहिये,\n" +
                                "दिल मिले ना मिले हाथ बढ़ाते रहिये,\n" +
                                "ताजमहल न बनाईये महंगा पड़ेगा,\n" +
                                "मगर हर तरफ मुमताज़ बनाते रहिये।",

                        "तुम सा कोई दूसरा जमीन पर हुआ,\n" +
                                "तो रब से शिकायत होगी,\n" +
                                "एक को तो झेला नहीं जाता,\n" +
                                "दूसरा आ गया तो क्या हालत होगी।",

                        "असमान में काली घटा छाई है,\n" +
                                "आज फिर तूने गर्लफ्रेंड से मार खाई है,\n" +
                                "मगर इसमें तेरी गलती नहीं है दोस्त,\n" +
                                "तू सकल लगता कालू हलवाई है।",

                        "खुद का बच्चा रोये तो दिल में दर्द होता है,\n" +
                                "किसी और का रोये तो सर में दर्द होता है,\n" +
                                "खुद की बीवी रोये तो भी सर में दर्द होता है,\n" +
                                "किसी और की रोये तो दिल में दर्द होता है।",

                        "दोस्ती को बड़े प्यार से निभाएंगे,\n" +
                                "कोशिश रहेगी तुझे न सतायेंगे,\n" +
                                "कभी पसंद न आये मेरा साथ तो बता देना,\n" +
                                "गिन भी न पाओगे इतने “थप्पड़” लगाएंगे।",

                        "दिल का दर्द दिल तोड़ने वाला क्या जाने,\n" +
                                "प्यार के रिवाजों को ये ज़माना क्या जाने,\n" +
                                "होती है कितनी तकलीफ लड़की पटाने में,\n" +
                                "ये घर बैठा उसका बाप क्या जाने।",

                        "दिल में आंसुओं के मेले हैं,\n" +
                                "तुम बिन हम बहुत अकेले हैं,\n" +
                                "सब कुछ छोड़कर एसएमएस करते हैं,\n" +
                                "देखो हम कितने वेल्ले हैं।",

                        "मोहब्बत कर ली तुमसे बहुत सोचने के बाद,\n" +
                                "अब किसी को देखना नहीं तुम्हे देखने के बाद,\n" +
                                "दुनिया छोड़ देंगे तुम्हे पाने के बाद,\n" +
                                "खुदा माफ़ करे इतना झूट बुलवाने के बाद।",

                        "जब होता है तुम्हारा दीदार,\n" +
                                "दिल धड़कता है बार-बार,\n" +
                                "आदत से मजबूर हो तुम,\n" +
                                "ना जाने कब माँग लो उधार।",


                        "ताजमहल किसी के लिए एक अजूबा है,\n" +
                                "तो किसी के लिए प्यार का एहसास है,\n" +
                                "हमारे तुम्हारे लिए तो बकवास है,\n" +
                                "क्यूँ की की रोज़ बदलती हमारी मुम्ताज़ है।",

                        "हमेशा ज़िन्दगी में मुस्कुराते रहो,\n" +
                                "हर इंसान को अपना बनाते रहो,\n" +
                                "जब तक कोई कार वाली ना बने तुम्हारी गर्लफ्रेंड,\n" +
                                "तब तक स्कूटर वाली से ही काम चलाते रहो।",

                        "उधर आप मजबूर बैठे हैं,\n" +
                                "इधर हम खामोश बैठे है,\n" +
                                "बात हो तो कैसे हो,\n" +
                                "जब दोनों तरफ दो कंजूस बैठे हैं।",

                        "हंसी के लिए गम कुर्बान,\n" +
                                "ख़ुशी के लिए आंसू कुर्बान,\n" +
                                "दोस्त के लिए जान भी कुर्बान,\n" +
                                "और अगर\n" +
                                "दोस्त की गर्लफ्रेंड मिल जाए तो,\n" +
                                "साला दोस्त भी कुर्बान",

                        "खयाल को आहट की आस रहती है,\n" +
                                "निगाह को किसी सूरत की तलाश रहती है,\n" +
                                "तेरे बिन कोई कमी नहीं है ऐ दोस्त,\n" +
                                "बस गली वाली जमादारनी उदास रहती है।",

                        "आँखों में आँसू चेहरे पर हँसी है,\n" +
                                "साँसों में आहें दिल में बेबसी है,\n" +
                                "पहले क्यों नहीं बताया यार कि,\n" +
                                "दरवाज़े में ऊँगली फँसी है।",

                        "बाजुओं में दम रखता हूँ,\n" +
                                "दिल में ग़म रखता हूँ,\n" +
                                "पता था SMS आएगा तेरा,\n" +
                                "इसलिए पेनकिलर संग रखता हूँ।",

                        "हर रात हम तुम्हें याद किया करते है,\n" +
                                "सितारों में तुम्हें देखा करते है,\n" +
                                "लेकिन हमारे ख्वाबों में मत आना तुम,\n" +
                                "क्योंकि हम भूत से डरा करते है।",

                        "रामचंद्र कह गए सिया से,\n" +
                                "ऐसा कलयुग आएगा,\n" +
                                "एक दोस्त एक तरफ से SMS करेगा,\n" +
                                "दूसरा अपना पैसा बचाएगा।",

                        "रामचंद्र कह गए सिया से,\n" +
                                "ऐसा कलयुग आएगा,\n" +
                                "एक दोस्त एक तरफ से SMS करेगा,\n" +
                                "दूसरा अपना पैसा बचाएगा।",

                        "आप दिल पर न मेरे यूँ वार कीजिये,\n" +
                                "छोड़ो ये नफरत थोड़ा प्यार कीजिये,\n" +
                                "करवा देंगे हम आपकी अच्छी जगह शादी,\n" +
                                "तब तक हमारे साथ आँखें चार कीजिये।",
                        "Julfo me fulo ko saja kar aayi hai,\n" +
        "chehre se dupatta utha kar aayi hai,\n" +
                "kisi ne pucha ki kitni khubsurat lag rahi hai,\n" +
                "Hamne kaha sawad aaj naha kar aayi hai!","\n" +
                "Nakhre aap ke toba-toba,\n" +
                "gajab aapka style hai,\n" +
                "message to aap kabhi karte nahi,\n" +
                "bas halla macha rakha hai ki..\n" +
                "hamare pass bhi mobile hai!!","\n" +
                "Manzil unhi ko milti hai,\n" +
                "jinke hoslo me jaan hoti hai,\n" +
                "aur band bhatti me bhi daaru unhi ko milti hai..\n" +
                "jinki bhatti me pehchaan hoi hai.","Sitam dhane ki had hoti hai,\n" +
                "pas na ane ki roth jane ki hadh hoti hai..\n" +
                "Ek SMS to kar de Zalim,\n" +
                "Paise bachane ki bhi hadh hoti hai..","Kya hua jo usne racha li mehndi,\n" +
                "Hamm bhi ab to sehra sajayenge,\n" +
                "Mujhe pata tha wo apne naseeb main nahi hai,\n" +
                "Ab uski chotti bahen ko fasayenge.","Sharab Sareer Ko Khatam Krti Hai\n" +
                "Sharab Samaj Ko Khatam Krti Hai,\n" +
                "Aao Aaj Is Sharab Ko Khatam Krte Hain,\n" +
                "Ek Bottle Tum Khtam Kro, Ek Bottle Hum Khatam Krte Hai..","Hum dil fek aashiq har kam me kamal kar de.\n" +
                "Jo wada kare use pura har haal me kar de.\n" +
                "Tujhe lipistik lagane ki kya jarurat,\n" +
                "hum hot chum-chum ke lal kar de.","Umar ki raah mein JAZBAAT badal jate hai,\n" +
                "Waqt ki AAndhi me HALLAT badal jaate hai,\n" +
                "Sochta hoon kaam kar kar ke Record tod dun,\n" +
                "Lekin kambhakt salary dekhte he KHAYAAL badal jaate hai..","Bindas muskurao kya gam hai,\n" +
                "Zindgi me tension kisko kam hai,\n" +
                "Yaad karne wale to bahut hai aapko,\n" +
                "Dil se ‘TANG’ karne wale to sirf HUM hai.\n" +
                "Arz hai..","Pink lips are the girls beauty,\n" +
                "Wah Wah\n" +
                "Pink lips are the girls beauty,\n" +
                "Wah Wah\n" +
                "And Kissing them is the Boys duty..","\n" +
                "Chali jati hain wo beauty parlour mein yun,\n" +
                "Unka maksad hain misaal-e-hoor ho jana..\n" +
                "Ab kon samjhaye en ladkiyo (girls) ko\n" +
                "Mumkin nahi kishmish ka fir se angur ho jana. ??","eh jo ladkiyon (girls) ke baal hote hai,\n" +
                "ladkon ko fasane ka jaal hote hai.\n" +
                "Khoon choos keti hai ladkon ka saara,\n" +
                "tabhi to inke honth laal hote hai!\n" +
                "Kasam Se Har Ek Ladki (girl) Bhula Dunga,\n" +
                "Sab hi Ki Tasverain Jala DunGa,\n" +
                "Ek Tum hi Raho Ge Iss Dil Me !\n" +
                "Balance Dalwa Do Bhout Dua Dunga.\n" +
                "Pyar karne ki apni 1 reet hai..\n" +
                "Pyaar ka dusra naam hi to Preet hai…\n" +
                "Isliye Try maro har Ladki (girl) par..\n" +
                ".\n" +
                "Kyunki\n" +
                ".\n" +
                "Darr ke aage Jeet hai.","Na ishq kar mare yaar yeh ladkiya (girls) bahut satati hai,\n" +
                "na karna in par aitbaar yah kharcha bahut karwati hai,\n" +
                "recharge tum karwa ke dete ho aur number mera lagati hai..","Ajib hai nakhre tere,\n" +
                "Ajib hai tera style.\n" +
                "Naak pochhne ki tameez nahin aur haath mein hai mobile!","Cham Cham kar ke aayi,\n" +
                "Cham Cham kar ke chali gayi,\n" +
                "Main Sindoor leke khada raha,\n" +
                "Aur woh rakhi ban ke chali gayi.\n" +
                "Tumhari Saalgirah Pe Jaana Kia Bhejoon,\n" +
                "Apni Jaan Bhejoon Keh Apna Dil Bhejoon,\n" +
                "Phir Soochta Hoon Jaana Kion Na,\n" +
                "Tumhare Liye Kee Hui Shopping Ka Bill Bhejoon. ","tna khubsurat kaise muskura lete ho,\n" +
                "Itna qatil kaise sharma lete ho,\n" +
                "Kitni aasani se jaan le lete ho,\n" +
                "Kisi ne sikhaya hai.. ya bachpan se hi kamine ho? ","\n" +
                "Dhadkan Dil Ki Ruk Jati Hai,\n" +
                "Sanse Aksar Tham Jati Hai,\n" +
                "Bahut Buri Halat Hoti Hai Yaaro,\n" +
                "Jab GF Se Shaadi Karne Ki Naubat Aati Hai! "


                };


        ma= new MyAdapter(Comedypmsg,ComedyShayari.this);
        viewpager.setAdapter(ma);






        shayaricount = findViewById(R.id.count);
        shayaricount.setText(String.format("Comedy Shayari : %d/%d", viewpager.getCurrentItem() + 1, Comedypmsg.length));
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @SuppressLint("DefaultLocale")
            @Override
            public void onPageSelected(int position) {

                shayaricount.setText(String.format("Comedy Shayari : %d/%d", position+1 , Comedypmsg.length));
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
                whatsappIntent.putExtra(Intent.EXTRA_TEXT, Comedypmsg[viewpager.getCurrentItem()]);
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
                ClipData clip = ClipData.newPlainText("msg", Comedypmsg[viewpager.getCurrentItem()]);
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
