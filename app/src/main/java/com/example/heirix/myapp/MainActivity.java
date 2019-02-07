package com.example.heirix.myapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
//import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

//import java.util.Timer;
//import java.util.TimerTask;

public class MainActivity extends Activity
{
    //private Timer timer1;
    //private String[] saCaptions = { "Symbol","Schreibweise","Phonetic","Klang","Bedeutung" };
    private final String[][] stringArray1 = {
    { "ก",	"ก ไก่",  "goh gài",			"g",	"Huhn",                 },
    { "ข",	"ข ไข่",	"kóh kài",			"k",	"Ei",                   },
    { "ฃ",	"ฃ ฃวด",	"kóh kwuad",		"k",	"Flasche",              },
    { "ค",	"ค ควาย",	"koh kwaai",		"k",	"Wasserbüffel",         },
    { "ฅ",	"ฅ คน",	"koh kon",			"k",	"Person",               },
    { "ฆ",	"ฆ ระฆัง",	"koh rá kang",		"k",	"Glocke",               },
    { "ง",	"ง งู",	"ngoh nguh",		"ng",	"Schlange",             },
    { "จ",	"จ จาน",	"dschoh dschahn",	"dsch",	"Teller, Geschirr",     },
    { "ฉ",	"ฉ ฉิ่ง",	"tschóh tsching",	"tsch",	"Zimbel",               },
    { "ช",	"ช ช้าง",	"tschoh tscháhng",	"tsch",	"Elefant",              },
    { "ซ",	"ซ โซ่",	"soh sôh",			"s",	"Kette",                },
    { "ฌ",	"ฌ เฌอ",	"dschoh gá dschö",	"dsch",	"Baumart",              },
    { "ญ",	"ญ หญิง",	"joh jîng",			"j",	"Frau",                 },
    { "ฎ",	"ฎ ชะฎา",	"doh tschádah",		"d",	"Tanzkrone",            },
    { "ฏ",	"ฏ ปะฏัก",	"dtoh bpà dtàk",	"dt",	"Speer",                },
    { "ฐ",	"ฐ ฐาน",	"tõh tãhn",			"t",	"Podest",               },
    { "ฑ",	"ฑ มฌโฑ",	"toh montoh",		"t",	"Vertraute des Königs", },
    { "ฒ",	"ฒ ผู้เฒ่า",	"toh pûh tâo",		"t",	"alte Person",          },
    { "ณ",	"ณ เณร",	"noh nehn",			"n",	"junger Mönch",         },
    { "ด",	"ด เด็ก",	"doh dèk",			"d",	"Kind",                 },
    { "ต",	"ต เต่า",	"dtoh dtào",		"dt",	"Schildkröte",          },
    { "ถ",	"ถ ถุง",	"tõh tung",			"t",	"Tüte, Tasche",         },
    { "ท",	"ท ทหาร",	"toh tá hãhn",		"t",	"Soldat",               },
    { "ธ",	"ธ ธง",	"toh tong",			"t",	"Fahne",                },
    { "น",	"น หนู",  "noh nuh",			"n",	"Maus",                 },
    { "บ",	"บ ใบไม้",	"boh bai máhi",		"b",	"Blatt",                },
    { "ป",	"ป ปลา", "bpoh bplah",		"bp",	"Fisch",                },
    { "ผ",	"ผ ผึ้ง",	"põh pûeng",		"p",	"Biene",                },
    { "ฝ",	"ฝ ฝา",	"fõh fãh",			"f",	"Deckel",               },
    { "พ",	"พ พาน",	"poh pahn",			"p",	"Besondere Schale",     },
    { "ฟ",	"ฟ ฟัน",	"foh fan",			"f",	"Zahn",                 },
    { "ภ",	"ภ สำเภา",	"poh sãmpao",		"p",	"traditionelles Schiff",},
    { "ม",	"ม ม้า",  "moh máh",			"m",	"Pferd",                },
    { "ย",	"ย ยักษ์",	"joh ják",			"j",	"Riese",                },
    { "ร",	"ร เรือ",	"roh rüa",			"r",	"Boot",                 },
    { "ล",	"ล ลิง",	"loh ling",			"l",	"Affe",                 },
    { "ว",	"ว แหวน",	"woh wãehn",		"w",	"Ring",                 },
    { "ศ",	"ศ ศาลา",	"sõh sãh lah",		"s",	"Pavillon",             },
    { "ษ",	"ษ ฤๅษี",	"sõh rüh sie",		"s",	"Einsiedler",           },
    { "ส",	"ส เสือ",	"sõh süha",			"s",	"Tiger",                },
    { "ห",	"ห หีบ",	"hõh hìep",			"h",	"Truhe",                },
    { "ฬ",	"ฬ จุฬา",	"loh dschù lah",	"l",	"Drachen",              },
    { "อ",	"อ อ่าง",	"oh àhng",			"oh",	"Schale,Schüssel",      },
    { "ฮ",	"ฮ นกฮูก",	"hoh nókhûhk",		"h",	"Eule",                 },
    };

    private int cnt = 0;
    private final static int arraySize = 44;
    private TextView text1;
    private TextView text2;
    private TextView text3;
    private TextView text4;
    private TextView textEx;
    private TextView textTrans;

    private void populateTextViews (int i)
    {
        //String str = " เครื่องบิน ";
        //String str = " ๅภถ คตจขช ๆไพะ รนยบล ฟหกดเ าสวงฃ ฃผปแอ ทมใฝ ";
        //text1.setText("Custom Font! \uE01B \uE02B \uE03B \uE04B \uE05B \uE06B");
        //String str = "♫";
        //byte spbyte[] = str.getBytes("UTF-8");
        //str = new String( spbyte,"UTF-8");
        //text1.setText(str);
        String letter = stringArray1[i][0];
        String letter_ex = stringArray1[i][1];
        String letter_meaning = stringArray1[i][4];
        text1.setText(Html.fromHtml(letter));
        text2.setText(Html.fromHtml(letter));
        text3.setText(Html.fromHtml(letter));
        text4.setText(Html.fromHtml(letter));
        textEx.setText(Html.fromHtml(letter_ex));
        textTrans.setText(Html.fromHtml(letter_meaning));
    }

    public void sendMessage(View view) {
        Toast.makeText( this, "test", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, DisplayTableActivity.class);
//        String message = "hallo";
//        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        LinearLayout layout = new LinearLayout(this);
//        layout.setOrientation(LinearLayout.VERTICAL);
//        RelativeLayout layout = new RelativeLayout(this);
//        final TextView text1 = new TextView(this);
//        final TextView text2 = new TextView(this);
//        final TextView text3 = new TextView(this);
//        final TextView text4 = new TextView(this);
//        Button button1 = new Button(this);
//        layout.addView(button1);
//        layout.addView(text1);
//        layout.addView(text2);
//        layout.addView(text3);
//        layout.addView(text4);
//        setContentView(layout);

        final Typeface typeface1 = Typeface.createFromAsset(getAssets(), "fonts/NotoSansThai-Regular.ttf");
        final Typeface typeface2 = Typeface.createFromAsset(getAssets(), "fonts/HelveticaNeueLTThai-Regular.ttf");
        final Typeface typeface3 = Typeface.createFromAsset(getAssets(), "fonts/ThaiAltOTS.ttf");
        final Typeface typeface4 = Typeface.createFromAsset(getAssets(), "fonts/AnuParpLTThai.ttf");

        text1 = findViewById(R.id.text1);
        text1.setTextSize(80);
        text1.setTypeface(typeface1);

        text2 = findViewById(R.id.text2);
        text2.setTextSize(80);
        text2.setTypeface(typeface2);

        text3 = findViewById(R.id.text3);
        text3.setTextSize(80);
        text3.setTypeface(typeface3);

        text4 = findViewById(R.id.text4);
        text4.setTextSize(80);
        text4.setTypeface(typeface4);

        textEx = findViewById(R.id.textEx);
        textEx.setText("textEx");
        textEx.setTextSize(40);

        textTrans = findViewById(R.id.textTrans);
        textTrans.setText("Translation");
        textTrans.setTextSize(40);

        populateTextViews(0);

        final TextView buttonNext = findViewById(R.id.buttonNext);
        buttonNext.setText(">");
        buttonNext.setTextSize(28);
        buttonNext.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                if (++cnt >= arraySize) cnt = 0;
                populateTextViews(cnt);
            }
        });

        final TextView buttonPrev = findViewById(R.id.buttonPrev);
        buttonPrev.setText("<");
        buttonPrev.setTextSize(28);
        buttonPrev.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                if (--cnt < 0) cnt = arraySize-1;
                populateTextViews(cnt);
            }
        });

//        timer1 = new Timer();
//        timer1.scheduleAtFixedRate(new UpdateTimeTask(), 2000, 250);
    }

    private static final int CLEAR_ID = Menu.FIRST;
    private static final int FADE_ID  = Menu.FIRST + 1;
    private boolean mFading;

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, CLEAR_ID, 0, "Clear");
        menu.add(0, FADE_ID, 0, "Fade").setCheckable(true);
        return super.onCreateOptionsMenu(menu);
    }

    @Override public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(FADE_ID).setChecked(mFading);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case CLEAR_ID:
                return true;
            case FADE_ID:
                mFading = !mFading;
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

//    class UpdateTimeTask extends TimerTask
//    {
//        public void run() {
//            long millis = System.currentTimeMillis() - startTime;
//            int seconds = (int) (millis / 1000);
//            int minutes = seconds / 60;
//            seconds     = seconds % 60;
//            timeLabel.setText(String.format("%d:%02d", minutes, seconds));
//            mGLView.requestRender();
//        }
//    }
}
