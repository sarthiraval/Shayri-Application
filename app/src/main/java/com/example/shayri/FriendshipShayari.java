package com.example.shayri;

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

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.navigation.NavigationView;

public class FriendshipShayari extends AppCompatActivity {

  
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
        setContentView(R.layout.activity_friendship_shayari);
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
        final String[] Friendshipmsg =
                {
                        "लोग कहते हैं ज़मीं पर किसी को खुदा नहीं मिलता,\n" +
                                "शायद उन लोगों को दोस्त तुम-सा नहीं मिलता।",

                        "एक चाहत होती है दोस्तों के साथ जीने की जनाब,\n" +
                                "वरना पता तो हमें भी है की मरना अकेले ही है।",



                        "दिन बीत जाते हैं सुहानी यादें बनकर,\n" +
                                "बातें रह जाती हैं #किस्से और कहानी बनकर,\n" +
                                "पर #दोस्त तो हमेशा दिल के करीब रहेंगे,\n" +
                                "कभी मुस्कान तो कभी आँखों में पानी बनकर।",

                        "कोशिश करो कोई आपसे ना रूठे,\n" +
                                "जिंदगी में अपनों का साथ ना छूटे,\n" +
                                "दोस्ती कोई भी हो उसे ऐसा निभाओ,\n" +
                                "कि उस दोस्ती की डोर जिंदगी भर ना टूटे।",

                        "आंसू बहें तो एहसास होता है,\n" +
                                "दोस्ती के बिना जीवन कितना उदास होता है,\n" +
                                "उम्र हो आपकी चाँद जितनी लंबी,\n" +
                                "आप जैसा दोस्त कहाँ हर किसी के पास होता है।",

                        "मुस्कराहट का कोई मोल नहीं होता,\n" +
                                "कुछ रिश्तों का कोई तोल नहीं होता,\n" +
                                "लोग तो मिल जाते है हर मोड़ पर,\n" +
                                "हर कोई आप की तरह अनमोल नहीं होता।",

                        "मुस्कुराना ही ख़ुशी नहीं होती,\n" +
                                "उम्र बिताना ही ज़िन्दगी नहीं होती,\n" +
                                "दोस्त को रोज याद करना पड़ता है,\n" +
                                "दोस्ती कर लेना हीं दोस्ती नहीं होती।",

                        "गम को बेचकर खुशी खरीद लेंगे,\n" +
                                "ख्वाबो को बेचकर जिन्दगी खरीद लेंगे ,\n" +
                                "होगा इम्तहान तो देखेगी दुनिया,\n" +
                                "खुद को बेचकर आपकी दोस्ती खरीद लेंगे।",

                        "गीत की जरुरत महफ़िल में होती है,\n" +
                                "प्यार की जरुरत हर दिल में होती है,\n" +
                                "बिना दोस्त के अधूरी है जिंदगी,\n" +
                                "क्योंकि दोस्त की जरुरत हर पल में होती है।",

                        "दोस्ती का शुक्रिया कुछ इस तरह अदा करूँ,\n" +
                                "आप भूल भी जाओ तो मैं हर पल याद करूँ,\n" +
                                "खुदा ने बस इतना सिखाया हैं मुझे,\n" +
                                "कि खुद से पहले आपके लिए दुआ करूँ।",

                        "दोस्ती दर्द नहीं खुशियों कि सौगात है,\n" +
                                "किसी अपने का ज़िन्दगी भर का साथ है,\n" +
                                "ये दिलो का वो खूबसूरत एहसास है,\n" +
                                "जिसके दम से रोशन ये सारी कायनात है।",

                        "एक चिंगारी अंगार से कम नहीं होती,\n" +
                                "सादगी श्रृंगार से कम नहीं होती,\n" +
                                "ये तो अपनी-अपनी सोच का फर्क है,\n" +
                                "वर्ना दोस्ती भी किसी प्यार से कम नहीं होती।",

                        "लाख बंदिशे लगा ले दुनिया हम पर,\n" +
                                "मगर हम दिल पर काबू नहीं कर पाएंगे,\n" +
                                "वो लम्हा आखिरी होगा ज़िन्दगी का हमारा,\n" +
                                "जिस दिन हम यार तुझ को भूल जायेंगे।",

                        "हर पल की दोस्ती का इरादा है आपसे,\n" +
                                "अपनापन ही कुछ ज्यादा है आपसे,\n" +
                                "साथ रहेंगे आपके उम्र भर के लिए,\n" +
                                "हमेशा दोस्ती निभाएंगे वादा है आपसे।",

                        "तुम्हारी दुनिया से जाने के बाद,\n" +
                                "हम एक तारे में नजर आया करेंगे,\n" +
                                "तुम हर पल कोई दुआ मांग लेना,\n" +
                                "और हम हर पल टूट जाया करेंगे।",

                        "ज़िन्दगी नहीं हमे दोस्तों से प्यारी,\n" +
                                "दोस्तों के लिए हाजिर है जान  हमारी,\n" +
                                "आँखों में हमारी आँसू है तो क्या,\n" +
                                "खुदा से भी प्यारी है मुस्कान तुम्हारी।",

                        "जीने की उसने हमें नयी अदा दी है,\n" +
                                "खुश रहने की उसने हमें दुआ दी है,\n" +
                                "ऐ खुदा उसको खुशियाँ तमाम देना,\n" +
                                "जिसने अपने दिल  में हमें जगह दी है।\n" +
                                "\n",

                        "लाखों की हँसी तुम्हारे नाम कर देंगे,\n" +
                                "हर खुशी तुम पर कुर्बान कर देंगे,\n" +
                                "जिस दिन हो कमी मेरी दोस्ती में बता देना,\n" +
                                "उस दिन ज़िन्दगी को आखिरी सलाम कह देंगे।",

                        "कुछ तो बात है तेरी फितरत में ऐ दोस्त,\n" +
                                "तूझे याद करने की खता हम बार बार न करते।",

                        "दोस्तों से बिछड़ के यह एहसास हुआ, ग़ालिब,\n" +
                                "थे तो कमीने लेकिन रौनक भी उन्ही से थी।",

                        "उम्मीद ऐसी हो जो जीने को मजबूर करे,\n" +
                                "राह ऐसी हो जो चलने को मजबूर करे,\n" +
                                "महक कम न हो कभी अपनी दोस्ती की,\n" +
                                "दोस्ती ऐसी हो जो मिलने को मजबूर करे।",

                        "वो दिल क्या जो मिलने की दुआ न करे,\n" +
                                "तुम्हे भूल कर जियूं ये खुदा न करे,\n" +
                                "रहे तेरी दोस्ती मेरी ज़िन्दगी बन कर,\n" +
                                "ये बात और है ज़िन्दगी वफ़ा न करे।",

                        "जब आपकी पलकों पर रह जाये कोई,\n" +
                                "आपकी साँसों पर नाम लिख जाये कोई,\n" +
                                "चलो वादा रहा भूल जाना हमें,\n" +
                                "अगर हमसे अच्छा दोस्त मिल जाये कोई।",

                        "दोस्त ज़िन्दगी का चाँद होता है,\n" +
                                "दिल ज़मीन का आसमान होता है,\n" +
                                "बदनसीब वो होते हैं जिनका कोई दोस्त नहीं,\n" +
                                "क्योंकि दोस्त तो धड़कते दिल की जान होता है।",

                        "तन्हाई सी थी दुनिया की भीड़ में,\n" +
                                "सोचा कोई अपना नहीं तकदीर में,\n" +
                                "एक दिन जब दोस्ती की आपसे तो यूँ लगा,\n" +
                                "कुछ ख़ास था मेरे हाथ की लकीर में।",

                        "तुम सदा मुस्कुराते रहो यह तमन्ना है हमारी,\n" +
                                "हर दुआ में मांगी है बस खुशी तुम्हारी,\n" +
                                "तुम सारी दुनिया को दोस्त बना कर देख लो,\n" +
                                "फिर भी महसूस करोगे कमी हमारी।",

                        "लोग कहते हैं ज़मीन पर किसी को खुदा नहीं मिलता,\n" +
                                "शायद उन्हें दोस्त कोई तुम सा नहीं मिलता,\n" +
                                "किस्मत वालों को ही मिलती है पनाह किसी के दिल में,\n" +
                                "यूँ हर शख्स को तो जन्नत का पता नहीं मिलता।",

                        "हर खुशी से खूबसूरत तेरी शाम कर दूँ,\n" +
                                "अपना प्यार और दोस्ती तेरे नाम कर दूँ,\n" +
                                "मिल जाये अगर दोबारा ये ज़िन्दगी ऐ दोस्त,\n" +
                                "हर बार ये ज़िन्दगी तुझ पे कुर्बान कर दूँ।",

                        "जिक्र हुआ जब खुदा की रहमतों का,\n" +
                                "हमने खुद को खुश नसीब पाया,\n" +
                                "तमन्ना थी एक प्यारे से दोस्त की,\n" +
                                "खुदा खुद दोस्त बनकर चला आया।",

                        "गुनाह कर के सज़ा से डरते हैं,\n" +
                                "ज़हर पी के दवा से डरतें हैं ,\n" +
                                "दुश्मनो के सितम का खौफ नहीं हमें,\n" +
                                "हम दोस्तों के खफा होने से डरते है।",

                        "रिश्तों से बड़ी चाहत और क्या होगी,\n" +
                                "दोस्ती से बड़ी इबादत और क्या होगी,\n" +
                                "जिसे दोस्त मिल सके कोई आप जैसा,\n" +
                                "उसे ज़िन्दगी से शिकायत क्या होगी।\n" +
                                "\n",

                        "दोस्ती का फ़र्ज़ हम यूँ अदा करते हैं,\n" +
                                "दोस्त के नाम पर जान फ़िदा करते हैं,\n" +
                                "तुम्हे फूल का ज़ख्म भी न आने पाए,\n" +
                                "अल्लाह से रोज बस ये ही दुआ करते है।\n" ,

                        "दोस्ती वो एहसास है जो मिलता नहीं,\n" +
                                "दोस्ती वो पर्वत है जो झुकता नहीं,\n" +
                                "इसकी कीमत क्या है पूछो हमसे,\n" +
                                "ये वो अनमोल मोती है जो बिकता नहीं।",

                        "बिंदास मुस्कराओ यार क्या गम है,\n" +
                                "ज़िन्दगी में टेंसन किसको कम है,\n" +
                                "याद करने वाले तो बहुत हैं आपको,\n" +
                                "तंग करने वाले तो सिर्फ हम हैं।",

                        "कुछ वक़्त का इंतज़ार मिला मुझको,\n" +
                                "पर खुदा से बढकर यार मिला मुझको,\n" +
                                "न रही  तमन्ना किसी जन्नत की मुझे,\n" +
                                "तेरी दोस्ती से वो प्यार मिला मुझको।",

                        "और क्या लिखूं अपनी ज़िन्दगी के बारे में दोस्तों,\n" +
                                "वो लोग ही बिछड़ गए जो ज़िन्दगी हुआ करते थे।",

                        "जो कोई समझ न सके वो बात है हम,\n" +
                                "जो ढल के नई सुबह लाये वो रात हैं हम,\n" +
                                "छोड़ देते हैं लोग रिस्ते बनाकर यूँ ही,\n" +
                                "जो कभी न छूटे ऐसा साथ हैं हम।",

                        "तू दूर भी है मुझसे और पास भी है,\n" +
                                "मुझे तेरी कमी का एहसास भी है,\n" +
                                "दोस्त तो हमारे लाखों हैं इस जहाँ में,\n" +
                                "पर तू प्यारा भी है और खास भी है।\n" +
                                "\n",

                        "करनी है खुदा से गुजारिश,\n" +
                                "तेरी दोस्ती के शिवा कोई बंदगी न मिले,\n" +
                                "हर जनम में मिले दोस्त तेरे जैसा,\n" +
                                "या फिर कभी ज़िन्दगी न मिले।",

                        "आपकी हमारी दोस्ती का साज है,\n" +
                                "आप जैसे दोस्त पर हमे नाज़ है,\n" +
                                "अब चाहे कुछ भी हो जाये ज़िन्दगी में,\n" +
                                "दोस्ती बैसे ही रहेगी जैसी आज है।",

                        "मिलना बिछड़ना सब किस्मत का खेल है,\n" +
                                "कभी नफरत तो कभी दिलों का मेल है,\n" +
                                "बिक जाता है हर रिस्ता इस जमाने में,\n" +
                                "सिर्फ दोस्ती ही यहाँ नोट फॉर सेल है।",

                        "दिए तो आंधी में भी जला करते हैं,\n" +
                                "गुलाब तो काँटों में ही खिला करते हैं,\n" +
                                "खुशनसीब बहुत होती है वो शाम,\n" +
                                "जिसमे दोस्त आप जैसे मिला करते हैं।",

                        "तेरे हर एक दर्द का एहसास है मुझे,\n" +
                                "तेरी मेरी दोस्ती पर बहुत नाज़ है मुझे,\n" +
                                "क़यामत तक न बिछड़ेंगे हम दो दोस्त,\n" +
                                "कल से भी ज्यादा भरोसा आज है मुझे।",

                        "हम तो पतझड़ में भी बहार ले आएंगे,\n" +
                                "हम गहरी उदासी में भी प्यार ले आएंगे,\n" +
                                "दोस्तों आप एक बार दिल से आवाज़ तो दो,\n" +
                                "हम तो आपके लिए मौत से भी साँसे उधार ले आएंगे।",

                        "अगर दिल न मिले तो प्यार अधूरा होता है,\n" +
                                "चाँदनी के बिना चाँद कब पूरा होता है,\n" +
                                "दोस्तों की भूल कर ज़िन्दगी कटती नहीं,\n" +
                                "क्यूँकी हर एक फ्रेंड जरूरी होता है।",

                        "वक्त की राहों में तुम भुला दो चाहे हमें,\n" +
                                "पर हम तुमको न भूल पाएंगे,\n" +
                                "तेरी दोस्ती की कसम ऐ दोस्त तू आवाज दे ख्वाबों में\n" +
                                "हम हकीकत में चले आएंगे।",

                        "दोस्ती नज़ारों से हो तो उसे कुदरत कहते हैं,\n" +
                                "चाँद-सितारों से हो तो जन्नत कहते हैं,\n" +
                                "हसीनों से हो तो मोहब्बत कहते हैं,\n" +
                                "और आपसे हो तो उसे किस्मत कहते हैं।",

                        "बूंदों से बना हुआ छोटा सा समंदर,\n" +
                                "लहरों से भीगती छोटी सी बस्ती,\n" +
                                "चलो ढूंढ़े बारिश में दोस्ती की यादें,\n" +
                                "हाथ में लेकर एक कागज़ की कश्ती।",

                        "दोस्ती नाम है सुख-दुख की कहानी का,\n" +
                                "दोस्ती नाम है सदा मुस्कुराने का,\n" +
                                "ये कोई पल भर की जान-पहचान नहीं,\n" +
                                "दोस्ती नाम है सदा साथ निभाने का।",

                        "आपका साथ है तो मुझे क्या कमी है,\n" +
                                "आपकी मुस्कान से मिलती मुझे ख़ुशी है,\n" +
                                "मुस्कुराते रहना दोस्त इसी तरह हमेशा,\n" +
                                "आपकी मुस्कराहट में मेरी जान बसी है।\n" +
                                "\n",

                        "उम्मीद की हस्ती को कोई डुबा नहीं सकता,\n" +
                                "रौशनी का दीया कोई बुझा नहीं सकता,\n" +
                                "हमारी दोस्ती है ताजमहल की तरह,\n" +
                                "जिसे कोई दोबारा बना नहीं सकता।",

                        "दोस्ती वो एहसास है जो मिटता नहीं,\n" +
                                "दोस्ती वो पर्वत है जो कभी झुकता नहीं,\n" +
                                "इसकी कीमत क्या है पूछो हमसे,\n" +
                                "ये वो अनमोल मोती है जो बिकता नहीं।",

                        "समंदर न हो तो कश्ती किस काम की,\n" +
                                "मजाक न हो तो मस्ती किस काम की,\n" +
                                "दोस्तों के लिए कुर्बान है ये ज़िन्दगी,\n" +
                                "दोस्त न हो तो ये ज़िन्दगी किस काम की।",

                        "मंज़िलों से अपनी कभी दूर मत जाना,\n" +
                                "रास्तों की परेशानियों से टूट मत जाना,\n" +
                                "जब भी जरूरत हो ज़िन्दगी में अपनों की,\n" +
                                "ऐ दोस्त हम तेरे अपने हैं ये भूल मत जाना।",

                        "हर ख़ुशी दिल के करीब नहीं होती,\n" +
                                "ज़िन्दगी ग़मों से दूर नहीं होती,\n" +
                                "ऐ दोस्त दोस्ती को संजो कर रखना,\n" +
                                "दोस्ती हर किसी को नसीब नहीं होती।",

                        "दोस्ती की राह में हद से गुजर जायेंगे हम,\n" +
                                "आँखों के रास्ते तेरे दिल मे उतर जायेंगे हम,\n" +
                                "ऐ दोस्त तू अगर आने का वादा करें तो,\n" +
                                "तेरी राहों में फूल बनकर बिखर जायेंगे हम।",

                        "एक प्यारा सा दिल जो, कभी नफरत नहीं करता,\n" +
                                "एक प्यारी सी मुस्कान जो, कभी फीकी नही पड़ती,\n" +
                                "एक एहसास जो कभी दु:ख नहीं देता,\n" +
                                "और एक रिश्ता जो कभी खत्म नहीं होता।",

                        "तुम खफा हो गए तो कोई ख़ुशी न रहेगी,\n" +
                                "तुम्हारे बिना चिरागों में रौशनी न रहेगी,\n" +
                                "क्या कहें क्या गुजरेगी दिल पर ऐ दोस्त,\n" +
                                "जिंदा तो रहेंगे लेकिन ज़िंदगी न रहेगी।",


                        "वादा करते हैं आपसे हमेशा दोस्ती निभाएंगे,\n" +
                                "कोशिश यही रहेगी आपको नहीं सतायेंगे,\n" +
                                "जरुरत कभी पड़े तो दिल से पुकार लेना,\n" +
                                "किसी और के दिल में होंगे तो भी चले आएंगे।",

                        "मांगी थी दुआ हमने रब से,\n" +
                                "मुझे दोस्त दो जो अलग हो सबसे,\n" +
                                "उसने मिला दिया हमें आपसे,\n" +
                                "और कहा संभालो इसे ये अनमोल है सबसे।",

                        "आओ ताल्लुकात को कुछ और नाम दें,\n" +
                                "ये दोस्ती का नाम तो बदनाम हो गया।",

                        "दिल की किताब कुछ इस तरह बनाई है,\n" +
                                "हर पन्ने पर आपकी ही याद समाई है,\n" +
                                "फट न जाए एक भी पन्ना इसलिए हमने,\n" +
                                "हर पन्ने पर दोस्ती की लेमिनेसन चिपकाई है।",

                        "आपकी दोस्ती ने हमें जीना सिखा दिया,\n" +
                                "रोते हुए दिल को हँसना सिखा दिया,\n" +
                                "कर्ज़दार रहेंगे हम उस खुदा के,\n" +
                                "जिसने आप जैसे दोस्त से मिला दिया।",

                        "ज़िंदगी के सागर का एक ही किनारा है,\n" +
                                "ये किनारा सब किनारों से प्यारा है,\n" +
                                "तू मुझसे कभी मत रूठना ऐ मेरे दोस्त,\n" +
                                "मुझे इस दुनिया में बस तेरा ही सहारा है।",

                        "उदास हो जाओ तो मेरी हँसी माँग लेना,\n" +
                                "अगर ग़म हों तो मेरी ख़ुशी माँग लेना,\n" +
                                "रब आपको लम्बी उम्र दे जीने के लिए,\n" +
                                "एक पल भी कम पड़े तो मेरी जिंदगी माँग लेना।",

                        "नफरत करो उनसे जो भुलाना जानते हों,\n" +
                                "रूठो उनसे जो मनाना जानते हों,\n" +
                                "प्यार करो उनसे जो निभाना जानते हों,\n" +
                                "दोस्ती उनसे जो दिल लुटाना जानते हों।",


                        "शुक्रिया ऐ दोस्त मेरी ज़िन्दगी में आने के लिए,\n" +
                                "हर लम्हे को इतना खूबसूरत बनाने के लिए,\n" +
                                "तू है तो हर ख़ुशी पर मेरा नाम लिख गया है,\n" +
                                "शुक्रिया मुझे इतना खुशनसीब बनाने के लिए।",

                        "प्यार से कहो तो आसमान मांग लो,\n" +
                                "रूठ कर कहो तो मुस्कान मांग लो,\n" +
                                "तमन्ना यही है कि दोस्ती मत तोड़ना,\n" +
                                "फिर चाहें हँसकर हमारी जान मांग लो।",

                        "एक ताबीज़ तेरी मेरी दोस्ती को भी चाहिए...\n" +
                                "थोड़ी सी दिखी नहीं कि नज़र लगने लगती है।",

                        "हम अपने आप पर गुरूर नहीं करते,\n" +
                                "किसी को प्यार करने पर मजबूर नहीं करते,\n" +
                                "जिसे एक बार दिल से दोस्त बना लें,\n" +
                                "उसे मरते दम तक दिल से दूर नहीं करते।",

                        "गुनगुनाना तो तकदीर में लिखा कर लाए थे,\n" +
                                "खिलखिलाना दोस्तों से तोहफ़े में मिल गया।",

                        "दोस्ती चेहरे की मीठी मुस्कान होती है,\n" +
                                "दोस्ती सुख दुःख की पहचान होती है,\n" +
                                "रूठ भी जाये हम तो दिल से मत लगाना,\n" +
                                "क्योंकि दोस्ती थोड़ी सी नादान होती है।\n" +
                                "\n",

                        "कहीं अँधेरा तो कहीं शाम होगी,\n" +
                                "मेरी हर ख़ुशी आपके नाम होगी,\n" +
                                "कुछ माँग कर तो देखो...दोस्त...\n" +
                                "होंठों पर हँसी और हथेली पर मेरी जान होगी।",

                        "दर्द था दिल में पर जताया कभी नहीं,\n" +
                                "आँसू थे आँखो में पर दिखाया कभी नहीं,\n" +
                                "यही फ़र्क है दोस्ती और प्यार में,\n" +
                                "इश्क़ ने हँसाया कभी नहीं...\n" +
                                "और दोस्तों ने रुलाया कभी नहीं।\n" +
                                "\n",

                        "महफ़िल में कुछ तो सुनाना पड़ता है,\n" +
                                "ग़म छुपाकर मुस्कराना पड़ता है,\n" +
                                "कभी हम भी हुआ करते थे उनके दोस्त...\n" +
                                "आजकल दोस्तों को याद दिलाना पड़ता है।",

                        "दोस्ती में किसी का इम्तिहान न लेना,\n" +
                                "निभा न सको वो किसी को वादा न देना,\n" +
                                "जिसे तुम बिन जीने की आदत न हो,\n" +
                                "उसे जिन्दगी जीने की दुआ न देना।",

                        "प्यार का रिश्ता इतना गहरा नहीं होता,\n" +
                                "दोस्ती के रिश्ते से बड़ा कोई रिश्ता नहीं होता,\n" +
                                "कहा था इस दोस्ती को प्यार में न बदलो,\n" +
                                "क्यूंकि प्यार में धोखे के सिवा कुछ नहीं होता।",

                        "मेरी दोस्ती का हिसाब जो लगाओगे\n" +
                                "तो मेरी दोस्ती को बेहिसाब पाओगे,\n" +
                                "पानी के बुलबुलों की तरह है हमारी दोस्ती,\n" +
                                "अगर जरा सी ठेस पहुँची तो ढूंढ़ते रह जाओगे।",

                        "खुदा से एक फरियाद वाकी है,\n" +
                                "प्यार जिन्दा है क्यूंकि एक याद वाकी है,\n" +
                                "मौत आये तो कह देंगे लौट जाए,\n" +
                                "क्यूंकि...\n" +
                                "अभी किसी ख़ास से मुलाकात वाकी है।",

                        "जिंदगी की राहों में बहुत से यार मिलेंगे,\n" +
                                "हम क्या हम से भी अच्छे हजार मिलेंगे,\n" +
                                "इन अच्छों की भीड़ में हमें न भूल जाना,\n" +
                                "हम कहाँ आपको बार बार मिलेंगे।",

                        "नन्हे से दिल में अरमान कोई रखना,\n" +
                                "दुनिया की भीड़ में पहचान कोई रखना,\n" +
                                "अच्छे नहीं लगते जब तुम रहते हो उदास,\n" +
                                "अपने होठों पे सदा मुस्कान कोई रखना।",

                        "खूबसूरत सा एक पल किस्सा बन जाता है,\n" +
                                "जाने कब कौन जिंदगी का हिस्सा बन जाता है,\n" +
                                "कुछ लोग ऐसे भी मिलते हैं जिंदगी में,\n" +
                                "जिनसे कभी न टूटने वाला रिश्ता बन जाता है।",

                        "खुशी आपके लिए गम हमारे लिए,\n" +
                                "जिंदगी आपके लिए मौत हमारे लिए,\n" +
                                "हँसी आपके लिए रोना हमारे लिए,\n" +
                                "सबकुछ आपके लिए आप हमारे लिए।",

                        "दोस्तों से दूर होना मजबूरी होती है,\n" +
                                "हकीकत की दुनिया भी जरुरी होती है,\n" +
                                "ऐ दोस्त अगर तू साथ न हो तो,\n" +
                                "मेरी तो हर ख़ुशी अधूरी होती है।",

                        "जिंदगी ज़ख्मों से भरी है,\n" +
                                "वक़्त को मरहम बनाना सीख लो,\n" +
                                "हारना तो है एक दिन मौत से,\n" +
                                "फिलहाल...\n" +
                                "दोस्तों के साथ जिंदगी जीना सीख लो।",

                        "करनी है खुदा से गुजारिश कि,\n" +
                                "तेरी दोस्ती के सिवा कोई बंदगी न मिले,\n" +
                                "हर जन्म में मिले दोस्त तेरे जैसा,\n" +
                                "या फिर कभी जिंदगी न मिले।",

                        "वो पूछते हैं इतने गम में भी खुश कैसे हो?\n" +
                                "मैने कहा, प्यार साथ दे न दे, यार साथ हैं!",

                        "आकाश में चमकते सितारे हो आप,\n" +
                                "चाँद के खूबसूरत नज़ारे हो आप,\n" +
                                "इस जिंदगी को जीने के सहारे हो आप,\n" +
                                "मेरे प्यार से भी प्यारे हो आप।",

                        "बातें ऐसी करो कि जज्बात कम न हों,\n" +
                                "ख़यालात ऐसे रखो कि कभी ग़म न हो,\n" +
                                "दिल में अपनी इतनी जगह देना हमें दोस्त,\n" +
                                "कि खाली खाली सा लगे जब हम न हों।",

                        "खुशबू की तरह मेरी सांसों में रहना,\n" +
                                "लहू बनके मेरे आँसुओं में बहना,\n" +
                                "दोस्ती होती है रिश्तों का अनमोल गहना,\n" +
                                "इसीलिए दोस्त को कभी अलविदा न कहना।",

                        "केबल पानी से तस्वीर कहाँ बनती है,\n" +
                                "रूठे ख्वाबों से तकदीर कहां बनती है,\n" +
                                "किसी से दोस्ती करो तो सच्चे दिल से,\n" +
                                "क्यूँकि यह जिंदगी फिर कहाँ मिलती है।",

                        "दिल से दिल का गहरा रिश्ता है हमारा,\n" +
                                "दिल की हर धड़कन पर नाम है तुम्हारा,\n" +
                                "अगर हम आपके साथ नहीं तो क्या हुआ,\n" +
                                "जिंदगी भर साथ निभाने का वादा है हमारा।",

                        "बरसों बाद न जाने क्या समां होगा,\n" +
                                "हमसब दोस्तों में न जानें कौन कहाँ होगा,\n" +
                                "अगर मिलना हुआ तो मिलेंगें ख्वाबों में,\n" +
                                "जैसे सूखे हुये गुलाब मिलते हैं किताबों में।",

                        "सबकी जिंदगी में खुशियाँ देने वाले दोस्त,\n" +
                                "तेरी जिंदगी में कोई गम ना हो,\n" +
                                "तुझे तब भी दोस्त मिलते रहें अच्छे अच्छे,\n" +
                                "जब इस दुनिया में हम ना हो।",

                        "काश वो पल साथ बिताए ना होते,\n" +
                                "तो आँखों में ये आँसू आए ना होते,\n" +
                                "जिनसे रहा ना जाए एक पल भी दूर,\n" +
                                "काश ऐसे प्यारे दोस्त बनाए ना होते।",

                        "हर खुशी दिल के करीब नहीं होती,\n" +
                                "ग़मों से जिन्दगी दूर नहीं होती,\n" +
                                "ऐ मेरे दोस्त दोस्ती संजो के रखना,\n" +
                                "हर किसी को दोस्ती नसीब नहीं होती।",

                        "क्यूँ मुश्किलों में साथ देते हैं दोस्त,\n" +
                                "क्यूँ सारे ग़मों को बाँट लेते हैं दोस्त,\n" +
                                "न रिश्ता खून का न रिवाज से बंधा है,\n" +
                                "फिर भी ज़िन्दगी भर साथ देते हैं दोस्त।",

                        "शायद फिर हमें वो तकदीर मिल जाये,\n" +
                                "जीवन के वो हसीं पल फिर मिल जाये,\n" +
                                "चल फिर से बैठें क्लास की लास्ट बैंच पे,\n" +
                                "शायद फिर से वो पुराने दोस्त मिल जाएँ।",

                        "न जाने किस मिट्टी से खुदा ने तुमको बनाया है,\n" +
                                "अनजाने में इक ख्वाब इन आँखों को दिखाया है,\n" +
                                "मेरी हसरत थी हमेशा से खुदा से मिलने की दोस्त,\n" +
                                "शायद इसीलिये किस्मत ने मुझे तुमसे मिलाया है।\n" +
                                "\n",

                        "सफ़र दोस्ती का कभी ख़त्म न होगा,\n" +
                                "दोस्तों मेरा प्यार कभी कम न होगा,\n" +
                                "दूर रहकर भी रहेगी महक इसकी,\n" +
                                "हमें कभी बिछड़ने का ग़म न होगा।",

                        "कुछ लोग भूल के भी भुलाये नहीं जाते,\n" +
                                "ऐतबार इतना है कि आजमाये नहीं जाते,\n" +
                                "हो जाते हैं दिल में इस तरह शामिल कि,\n" +
                                "उनके ख्याल दिल से मिटाये नहीं जाते।",

                        "दोस्ती के लिए दोस्ती जैसा अहसास चाहिए,\n" +
                                "मुश्किल हो रहना जिसके बिना वो प्यास चाहिए,\n" +
                                "दोस्ती वही सच्ची होती है जो कायम रहे हमेशा,\n" +
                                "क्योंकि दोस्ती के लिए जगह दिल में खास चाहिए।",

                        "कुछ सितारों की चमक नहीं जाती,\n" +
                                "कुछ यादों की खनक नहीं जाती,\n" +
                                "कुछ लोगों से होता है ऐसा रिश्ता,\n" +
                                "कि दूर रहके भी उनकी महक नहीं जाती।",

                        "ज़िन्दगी में किसी मोड़ पर खुद को तन्हा न समझना,\n" +
                                "साथ हूँ मैं आपके खुद से जुदा मत समझना,\n" +
                                "उम्र भर आपसे दोस्ती करने का वादा किया है,\n" +
                                "अगर जिंदगी साथ न दे तो हमें बेवफा मत समझना।",

                        "न जाने क्यूँ हमें आँसू बहाना नहीं आता,\n" +
                                "न जाने क्यूँ हाले दिल बताना नहीं आता,\n" +
                                "क्यूँ सब दोस्त बिछड़ गए हमसे,\n" +
                                "शायद हमें ही साथ निभाना नहीं आता।",

                        "Maine socha ham bhi kar le dosti, Dost hi nahi mila waisa to kya kare dosti.\n" +
                                "\n" +
                                "Pee Lete Hain Dost Ki Jhooti Bottle Ka Paani…. Dosti Mazhab Ki Mohtaaj Nhi Hoti.. #FriendsForLife\n" +
                                "\n" +
                                "Waqt ki Yaari to Har Koi Karta Hai,,,Maza to Tab aata hai,, Jab Waqt Badal Jaaye Magar Yaar na Badle.\n" +
                                "\n" +
                                "Short line :Jab Ap Apni reputation Khone Ke Dar Se Dost Ka Sath ya Dosti Tod Dete Ho To Ap kabhi Ache Dost Nahi Ban Sakte.\n" +
                                "\n" +
                                "Real? love to vo tha jab mere friend ne mujhe hug kar ke kaha daulat h shohrat h aur izzat? bhi h but tere bina ye sab bekar? hai.","KucH FRIEND SIRF\n" +
                        "FRIEND NaHI HoTe…!!\n" +
                        "FAMILY HoTe He..!!!","\n" +
                        "Hum dosti dikhane ke liye nahi nibhane ke liye karte hai…\n" +
                        "\n" +
                        "Woh glass hi kya jisme drink chhoot jaye.?\n" +
                        "Aur woh “yaari” hi kya jo ek ladki ki wajah se tut jaye..","Dosti Buri Ho Ya Achhi..!!\n" +
                        "Par Honi ChaHiye Sachhi..!!\n","Aap jahan bhi jao log aapka exploit karenge sabse jyada exploitation toh dosti ke naam pe hote haibut I’m serious\n" +
                        "\n" +
                        "Sab pe bhari he hmari yari, tabhi to no.1 khitab pe hmari hi bari he.\n","Ab to raha hi nahi yaqeen kuch pyaar me,\n" +
                        "Ae dost, Jab se tuj sa koi paa liya he!!","Gaadi maang kar le jane wale dost petrol dalwaye ya na dalwaye, lekin gyan jarur dekar jayenge:-Bhai Gaadi Service maang rahi hai.","Jahan mohabbat dhoka deti hai\n" +
                        "Wahan dosti sahara banti hai…","Jab Dost Tarakki Kare To Fakhar Se Kaho ki Wo Mera Dost Hai…..\n" +
                        "Aur Jab Dost Musibat Me Ho To Fakhar Se Kaho Ki Mai Us Ka Dost Hu.","\n" +
                        "Jab ladki POPAT bana kar jaaye to dost hi kaam aate hai…","Jinke boyfriend/girlfriend nahi hote hai unke BEST FRIENDS hi unke jaanu hote hai…","Ek sacha dost hi apko ye 2 baatein bataega:\n" +
                        "1. Anda non-veg nahi hota\n" +
                        "2. Beer daaru nahi hoti..","\n" +
                        "Kis tarah se teri dosti ki kahani bayan karu\n" +
                        "E-dost Tune har mod pe Ek nya zakham Diya hai mujhey..","\n" +
                        "Kuch friends to itne ache hote hai,\n" +
                        "Jab tak unko gaali na do tab tak msgs ka reply nai krte.","Dost dil ki har baat samajh jaya karte h,\n" +
                        "Dukh sukh k har pal mein sath hua karte h\n" +
                        "Dost toh mila karte hain taqdeer walo ko,\n" +
                        "Mile aisi taqdeer har bar hume dua karte h…","Kal raat maut aayi thi\n" +
                        "Gusse mein boli\n" +
                        "“Jaan le lungi teri”\n" +
                        "Me ne bhi haste huwe keh diya,\n" +
                        "Jism le jaao , jaan toh meri doston ke paas hai…","Ae dost zindagi bhar mujhse dosti nibhaana,\n" +
                        "dil ki koi bhi baat humse kabhi na chupaana,\n" +
                        "sath chalna mere tum dukh sukh mein\n" +
                        "bhatak jau mein jo kabhi sahi raasta dikhlaana.","Phool hai gulab ka toda nahi jata….\n" +
                        "Phool hai gulab ka toda nahi jata….\n" +
                        "Aap jaise dosto ko chooda nahi jata.","Kabhi kabhi mere dost kehte hai\n" +
                        "Ki dost aisa ho to dushman kise chahiye\n" +
                        "Main kehta hoon\n" +
                        "Ek hee hona chahiye\n" +
                        "Jo dono role achhe se perform kare.","\n" +
                        "Ladte h dosto se par jeetna nhi chahte.\n" +
                        "Dosto se kabi bichdna nhi chahte.\n" +
                        "Haqiqt h ki juda karegi jindgi 1din\n" +
                        "Pr haqiqat me hum wo din dekhna nhi chahte.","School Ki Dosti 10th Tak\n" +
                        "College Ki Dosti University Tak\n" +
                        "University Ki Dosti Office Tak\n" +
                        "Office Ki Dosti Love Tak\n" +
                        "Lover Ki Dosti Shadi Tak\n" +
                        "Humari Apse Dosti 30th February Tak.","Bachpan se 2 hi Cheeze# sabse jyada mili hai,\n" +
                        "Dard aur Dost# fark sirf itna hai,\n" +
                        "Ki Dard mujhe hasne nahi deta#\n" +
                        "aur\n" +
                        "DOST Mujhe rone nahi dete..!!","Dost OR lover me bahut bada fark hai ?\n" +
                        "“Lover” Kehta hai agar tume\n" +
                        "kuch ho gaya toh me jee nai paunga\n" +
                        "Jabki”Dost” kehta hai Pagal mere\n" +
                        "hote huye tujhe Kuch nai ho Sakta.","\n" +
                        "Aap se door ho kar hum jayenge kaha,\n" +
                        "Aap jaisa dost ham payenge kaha,\n" +
                        "Dil ko kaise bhi sambhal lenge,\n" +
                        "Par aankho ke aansu hum chupayege kaha.","Dost vo insaan hai jiske pass problam leke jao ;\n" +
                        "To problem solve ho ya na ho,\n" +
                        "par jitni der saath raho problem jarur bhula dete h."





                };


        ma= new MyAdapter(Friendshipmsg,FriendshipShayari.this);
        viewpager.setAdapter(ma);






        shayaricount = findViewById(R.id.count);
        shayaricount.setText(String.format("Friendship Shayari : %d/%d", viewpager.getCurrentItem() + 1, Friendshipmsg.length));
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @SuppressLint("DefaultLocale")
            @Override
            public void onPageSelected(int position) {

                shayaricount.setText(String.format("Friendship Shayari : %d/%d", position+1 , Friendshipmsg.length));
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
                whatsappIntent.putExtra(Intent.EXTRA_TEXT, Friendshipmsg[viewpager.getCurrentItem()]);
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
                ClipData clip = ClipData.newPlainText("msg", Friendshipmsg[viewpager.getCurrentItem()]);
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


