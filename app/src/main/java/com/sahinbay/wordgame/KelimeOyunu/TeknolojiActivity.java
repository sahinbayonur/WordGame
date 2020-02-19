package com.sahinbay.wordgame.KelimeOyunu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sahinbay.wordgame.R;

import java.util.ArrayList;
import java.util.Random;

public class TeknolojiActivity extends AppCompatActivity {
    TextView kelime, ipucu, score, kelimebilgi;
    EditText harf;
    Button showLetter, sayAnswer, button3;
    int sayac = 0;
    ImageView resim;

    private int presCounter = 0;
    private int maxPresCounter = 4;
    private String[] keys = {"R", "I", "B", "D", "X"};
    private String textAnswer = "BIRD";
    TextView textScreen, textQuestion, textTitle;
    Animation smallbigforth;

    EditText editText;
    LinearLayout linearLayout;

    private ExampleAdapter mExampleAdapter;
    private ArrayList<ExampleItem> mExampleList;
    private RecyclerView mRecyclerView;

    ArrayList<String> list = new ArrayList<String>();
    ArrayList<String> acilmamislar = new ArrayList<String>();
    ArrayList<ExampleItem> ac = new ArrayList<ExampleItem>();

    // Kelimelerin bulunacağı diziyi olusturuyoruz
    final String[] kelimeler = {"ONUR", "DILEK", "ARVEN", "TURKCELL"};

    // İpuçlarının bulunacağı diziyi olusturuyoruz
    final String[] ipuclari = {"Gurur, haysiyet", "Bir şeyi istemek", "Savaşçı", "Bir GSM şiketidir"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teknoloji);

        kelime = (TextView) findViewById(R.id.wordquestion);
        ipucu = (TextView) findViewById(R.id.wordhint);
        kelimebilgi = (TextView) findViewById(R.id.wordinfo);
        sayAnswer = (Button) findViewById(R.id.btn_sayansver);
        showLetter = (Button) findViewById(R.id.btn_showletter);
        //resim = (ImageView)findViewById(R.id.imageView);
        //score = (TextView)findViewById(R.id.textView5);
        //button3 = (Button)findViewById(R.id.button3);

        hello();
        smallbigforth = AnimationUtils.loadAnimation(this, R.anim.smallbigforth);
        editText = findViewById(R.id.editText);
        linearLayout = findViewById(R.id.layoutParent);


        for (String key : acilmamislar) {
           // addView(linearLayout, key, editText);
        }

        maxPresCounter = 4;

    }

    private void addView(LinearLayout viewParent, final String text, final EditText editText) {
        LinearLayout.LayoutParams linearLayoutParams = new LinearLayout.LayoutParams(
                100, 100

                /*LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT*/
        );

        linearLayoutParams.rightMargin = 10;

        final TextView textView = new TextView(this);

        textView.setLayoutParams(linearLayoutParams);
        textView.setBackground(this.getResources().getDrawable(R.drawable.hexagon_vertical));
        textView.setTextColor(this.getResources().getColor(R.color.colorPurple));
        textView.setGravity(Gravity.CENTER);
        textView.setText(text);
        textView.setPadding(15, 15, 15, 15);
        textView.setClickable(true);
        textView.setFocusable(true);
        textView.setTextSize(16);

        // Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/FredokaOneRegular.ttf");

        /*textQuestion.setTypeface(typeface);
        textScreen.setTypeface(typeface);
        textTitle.setTypeface(typeface);
        editText.setTypeface(typeface);
        textView.setTypeface(typeface);*/

/*        textView.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(presCounter < maxPresCounter) {
                    if (presCounter == 0)
                        editText.setText("");

                    editText.setText(editText.getText().toString() + text);
                    textView.startAnimation(smallbigforth);
                    textView.animate().alpha(0).setDuration(300);
                    presCounter++;

                    if (presCounter == maxPresCounter)
                    {

                    }
                }
            }
        });*/

        viewParent.addView(textView);

    }


    public void hello() {
        //Kelime listemizdeki kelime sayısını geçmeyecek random sayı üretiyoruz
        final int rastgele = (int) (Math.random() * kelimeler.length);

        //Kelimeler dizimizden random bir kelime secip kullanıcıya sunuyoruz
        final String secilen = kelimeler[rastgele];

        //Atadığımız stringi char dizisine ceviriyoruz
        final char[] charArray = secilen.toCharArray();

        // Char dizisine ayrılan harfleri bir arraylist e atıyoruz
        for (int i = 0; i < charArray.length; i++) {
            final String sec = String.valueOf(secilen.charAt(i));
            acilmamislar.add(sec);
        }

        //Çöp adamın asılmasını sağlayacak fotoğrafları diziye atıyoruz
        //final int images[] = {R.drawable.sifir,R.drawable.bir,R.drawable.iki,R.drawable.uc,R.drawable.dort,R.drawable.bes,R.drawable.son};


        // Kelimedeki harf sayısı kadar "_" koyar
        final char answer[] = new char[secilen.length()];

        int k;
        for (k = 0; k < charArray.length; k++) {
            answer[k] = '_';
        }

        kelime.setText(answer, 0, k);

        //İlk görünecek olan çarmıhı ekrana veriyoruz
        //resim.setImageResource(images[0]);

        //Kelimenin kaç harften oluştuğu bilgisini veriyoruz
        kelimebilgi.setText("Kelime\n" + charArray.length + " harften olusuyor");

        //ANA FONKSİYONUMUZ
        showLetter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = 0;
                int p;
                int k = 0;

                final int rast = (int) (Math.random() * charArray.length);

                /** Bunu yazdım ***************************************************************  */
                Random rnd = new Random();
                final String sec = String.valueOf(acilmamislar.get(rnd.nextInt(acilmamislar.size())));

                // ipucunu ekrana basar
                ipucu.setText(ipuclari[rastgele]);

                //Kullanıcıdan kelimede aranacak harfi alıyoruz
                final String[] gelenharf = {sec};

                acilmamislar.remove(sec);
                list.add(sec);

                ipucu.setText(String.valueOf(list));
                System.out.println("\n" + "\n**************" + "\n" + list + "\n**************");

                System.out.println("\n##############" + "\n" + acilmamislar + "\n##############");

                String msj = String.valueOf(list);

                Toast.makeText(getApplicationContext(), msj, Toast.LENGTH_LONG).show();

                //////////


                /////////

                for (p = 0; p < charArray.length; p++) {
                    if (gelenharf[0].equals(String.valueOf(charArray[p]))) {
                        answer[p] = gelenharf[0].charAt(0);

                        kelime.setText(String.valueOf(answer));


                        addView(linearLayout, String.valueOf(answer), editText);


                    } else {
                        a++;
                    }
                    if (a == charArray.length) {
                        sayac++;
                    }
                    if (sayac == 1) {
                        Toast.makeText(getApplicationContext(), "1 Hakkınız Gitti " + charArray.length + " Harften Olusuyor", Toast.LENGTH_SHORT).show();
                        // resim.setImageResource(images[1]);
                        ipucu.setText(ipuclari[rastgele]);

                    } else if (sayac == 2) {
                        Toast.makeText(getApplicationContext(), "2 Hakkınız" + charArray.length + " Harften Olusuyor", Toast.LENGTH_SHORT).show();
                        // resim.setImageResource(images[2]);
                    } else if (sayac == 3) {
                        Toast.makeText(getApplicationContext(), "3 Hakkınız Gitti " + charArray.length + " Harften Olusuyor", Toast.LENGTH_SHORT).show();
                        // resim.setImageResource(images[3]);
                    } else if (sayac == 4) {
                        Toast.makeText(getApplicationContext(), "4 Hakkınız Gitti  gitti dikkatli ol!  " + charArray.length + " Harften Olusuyor", Toast.LENGTH_SHORT).show();
                        // resim.setImageResource(images[4]);
                    } else if (sayac == 5) {
                        Toast.makeText(getApplicationContext(), "5 Hakkınız Gitti " + charArray.length + " Harften Olusuyor", Toast.LENGTH_SHORT).show();
                        // resim.setImageResource(images[5]);
                    } else if (sayac == 6) {
                        Toast.makeText(getApplicationContext(), "6 Hakkınız Gitti " + charArray.length + " Harften Olusuyor", Toast.LENGTH_SHORT).show();
                        // resim.setImageResource(images[6]);
                        kelime.setText("Kaybettiniz, " + secilen.toString() + " kelimesini bilemediniz");
                        //button3.setVisibility(View.VISIBLE);
                        ipucu.setVisibility(View.INVISIBLE);
                        showLetter.setVisibility(View.INVISIBLE);
                    }
                }
                String cevap = String.valueOf(answer);
                // harf.setText("");

                if (cevap.equals(secilen)) {
                    list.clear();
                    showLetter.setClickable(false);
                    ipucu.setText(String.valueOf(list));

                    Handler hndler = new Handler();
                    hndler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            kelime.setText("Tebrikler Bildiniz!");
                            ipucu.setVisibility(View.INVISIBLE);
                            // button3.setVisibility(View.VISIBLE);
                            hello();
                            showLetter.setClickable(true);
                        }
                        // Kodların ne kadar süre sonra çalışacağını belirttik. Burada 1000 değeri ms (milisaniye)
                    }, 500);

                }
            }
        });
    }

    public void btn_geri2(View v) {
        // Intent intent = new Intent(Cografya.this, kategoriler.class);
        // startActivity(intent);
    }

    public void ilerle(View v) {
        showLetter.setText("DENE");
        showLetter.setVisibility(View.VISIBLE);
        button3.setVisibility(View.INVISIBLE);
        final String[] kelimeler = {"KARADENİZ", "BEYABAN", "AKDENİZ", "ENLEM", "EKVATOR", "MAKİ"};
        final String[] ipuclari = {"Bölgelerimizden Biri", "Çöl", "Antalya", "Dünya'nın Üzerindeki Çizgi", "Dünyayı İkiye Böler", "Akdeniz Bölgesi/ Bitki"};

        sayac = 0;

        final int rastgele = (int) (Math.random() * kelimeler.length);
        final String[] gelenharf = {harf.getText().toString()};

        final String secilen = kelimeler[rastgele];
        final char[] charArray = secilen.toCharArray();


        final char answer[] = new char[secilen.length()];

        // final int images[] = {R.drawable.sifir,R.drawable.bir,R.drawable.iki,R.drawable.uc,R.drawable.dort,R.drawable.bes,R.drawable.son};

        int k;
        for (k = 0; k < charArray.length; k++) {
            answer[k] = '_';
        }
        kelime.setText(answer, 0, k);

        // resim.setImageResource(images[0]);
        kelimebilgi.setText("Kelime\n" + charArray.length + " Harften Olusuyor");

        showLetter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = 0;
                int p;
                int k = 0;

                gelenharf[0] = harf.getText().toString();
                for (p = 0; p < charArray.length; p++) {
                    if (gelenharf[0].equals(String.valueOf(charArray[p]))) {
                        answer[p] = gelenharf[0].charAt(0);
                        kelime.setText(String.valueOf(answer));

                    } else {
                        a++;
                    }
                    if (a == charArray.length) {
                        sayac++;

                    }
                    if (sayac == 1) {
                        Toast.makeText(getApplicationContext(), "1 Hakkınız Gitti " + charArray.length + " Harften Olusuyor", Toast.LENGTH_SHORT).show();
                        // resim.setImageResource(images[1]);
                        ipucu.setVisibility(View.VISIBLE);
                        ipucu.setText(ipuclari[rastgele]);

                    } else if (sayac == 2) {
                        Toast.makeText(getApplicationContext(), "2 Hakkınız" + charArray.length + " Harften Olusuyor", Toast.LENGTH_SHORT).show();
                        // resim.setImageResource(images[2]);
                    } else if (sayac == 3) {
                        Toast.makeText(getApplicationContext(), "3 Hakkınız Gitti " + charArray.length + " Harften Olusuyor", Toast.LENGTH_SHORT).show();
                        // resim.setImageResource(images[3]);
                    } else if (sayac == 4) {
                        Toast.makeText(getApplicationContext(), "4 Hakkınız Gitti  gitti dikkatli ol!  " + charArray.length + " Harften Olusuyor", Toast.LENGTH_SHORT).show();
                        // resim.setImageResource(images[4]);
                    } else if (sayac == 5) {
                        Toast.makeText(getApplicationContext(), "5 Hakkınız Gitti " + charArray.length + " Harften Olusuyor", Toast.LENGTH_SHORT).show();
                        // resim.setImageResource(images[5]);
                    } else if (sayac == 6) {
                        Toast.makeText(getApplicationContext(), "6 Hakkınız Gitti " + charArray.length + " Harften Olusuyor", Toast.LENGTH_SHORT).show();
                        // resim.setImageResource(images[6]);
                        kelime.setText("Kaybettiniz, " + secilen.toString() + " kelimesini bilemediniz");
                        button3.setVisibility(View.VISIBLE);
                        ipucu.setVisibility(View.INVISIBLE);
                        showLetter.setVisibility(View.INVISIBLE);

                        showLetter.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        });
                    }
                }
                String cevap = String.valueOf(answer);
                harf.setText("");

                if (cevap.equals(secilen)) {

                    kelime.setText("Tebrikler Bildiniz!");
                    ipucu.setVisibility(View.INVISIBLE);
                    button3.setVisibility(View.VISIBLE);
                    showLetter.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}