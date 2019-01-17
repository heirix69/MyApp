package com.example.heirix.myapp;

import android.app.Activity;
import android.graphics.Typeface;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity
{
    private Timer timer1;
    private String[] saCaptions = { "Symbol","Schreibweise","Phonetic","Klang","Bedeutung" };
    private String[][] stringArray1 = {
    { "ก",	"ก ไก่",   	"goh gài",			"g",	"Huhn",                 },
    { "ข",	"ข ไข่",	    "kóh kài",			"k",	"Ei",                   },
    { "ฃ",	"ฃ ฃวด",	"kóh kwuad",		"k",	"Flasche",              },
    { "ค",	"ค ควาย",	"koh kwaai",		"k",	"Wasserbüffel",         },
    { "ฅ",	"ฅ คน",	    "koh kon",			"k",	"Person",               },
    { "ฆ",	"ฆ ระฆัง",	"koh rá kang",		"k",	"Glocke",               },
    { "ง",	"ง งู",		"ngoh nguh",		"ng",	"Schlange",             },
    { "จ",	"จ จาน",	"dschoh dschahn",	"dsch",	"Teller, Geschirr",     },
    { "ฉ",	"ฉ ฉิ่ง",	    "tschóh tsching",	"tsch",	"Zimbel",               },
    { "ช",	"ช ช้าง",	"tschoh tscháhng",	"tsch",	"Elefant",              },
    { "ซ",	"ซ โซ่",	    "soh sôh",			"s",	"Kette",                },
    { "ฌ",	"ฌ เฌอ",	"dschoh gá dschö",	"dsch",	"Baumart",              },
    { "ญ",	"ญ หญิง",	"joh jîng",			"j",	"Frau",                 },
    { "ฎ",	"ฎ ชะฎา",	"doh tschádah",		"d",	"Tanzkrone",            },
    { "ฏ",	"ฏ ปะฏัก",	"dtoh bpà dtàk",	"dt",	"Speer",                },
    { "ฐ",	"ฐ ฐาน",	"tõh tãhn",			"t",	"Podest",               },
    { "ฑ",	"ฑ มฌโฑ",	"toh montoh",		"t",	"Vertraute des Königs", },
    { "ฒ,",	"ฒ ผู้เฒ่า",	"toh pûh tâo",		"t",	"alte Person",          },
    { "ณ",	"ณ เณร",	"noh nehn",			"n",	"junger Mönch",         },
    { "ด",	"ด เด็ก",	    "doh dèk",			"d",	"Kind",                 },
    { "ต",	"ต เต่า",	    "dtoh dtào",		"dt",	"Schildkröte",          },
    { "ถ",	"ถ ถุง",	    "tõh tung",			"t",	"Tüte, Tasche",         },
    { "ท",	"ท ทหาร",	"toh tá hãhn",		"t",	"Soldat",               },
    { "ธ",	"ธ ธง",	    "toh tong",			"t",	"Fahne",                },
    { "น",	"น หนู",	    "noh nuh",			"n",	"Maus",                 },
    { "บ",	"บ ใบไม้",	"boh bai máhi",		"b",	"Blatt",                },
    { "ป",	"ป ปลา",    	"bpoh bplah",		"bp",	"Fisch",                },
    { "ผ",	"ผ ผึ้ง",	    "põh pûeng",		"p",	"Biene",                },
    { "ฝ",	"ฝ ฝา",	    "fõh fãh",			"f",	"Deckel",               },
    { "พ",	"พ พาน",	"poh pahn",			"p",	"Besondere Schale",     },
    { "ฟ",	"ฟ ฟัน",	    "foh fan",			"f",	"Zahn",                 },
    { "ภ",	"ภ สำเภา",	"poh sãmpao",		"p",	"traditionelles Schiff",},
    { "ม",	"ม ม้า",	    "moh máh",			"m",	"Pferd",                },
    { "ย",	"ย ยักษ์",	"joh ják",			"j",	"Riese",                },
    { "ร",	"ร เรือ",	    "roh rüa",			"r",	"Boot",                 },
    { "ล",	"ล ลิง",	    "loh ling",			"l",	"Affe",                 },
    { "ว",	"ว แหวน",	"woh wãehn",		"w",	"Ring",                 },
    { "ศ",	"ศ ศาลา",	"sõh sãh lah",		"s",	"Pavillon",             },
    { "ษ",	"ษ ฤๅษี",	"sõh rüh sie",		"s",	"Einsiedler",           },
    { "ส",	"ส เสือ",	    "sõh süha",			"s",	"Tiger",                },
    { "ห",	"ห หีบ",	    "hõh hìep",			"h",	"Truhe",                },
    { "ฬ",	"ฬ จุฬา",	"loh dschù lah",	"l",	"Drachen",              },
    { "อ",	"อ อ่าง",	    "oh àhng",			"oh",	"Schale,Schüssel",      },
    { "ฮ",	"ฮ นกฮูก",	"hoh nókhûhk",		"h",	"Eule",                 },
    };

    private int cnt = 0;
    private static int arraySize = 44;

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        // RelativeLayout layout = new RelativeLayout(this);

        final Typeface typeface1 = Typeface.createFromAsset(getAssets(), "fonts/NotoSansThai-Regular.ttf"); //CutiveMono.ttf");
        final Typeface typeface2 = Typeface.createFromAsset(getAssets(), "fonts/HelveticaNeueLTThai-Regular.ttf");
//      Typeface typeface2 = Typeface.createFromAsset(getAssets(), "fonts/NotoSansThai-Bold.ttf");
//      Typeface typeface2 = Typeface.createFromAsset(getAssets(), "fonts/AnuParpLTThai.ttf");
//      Typeface typeface2 = Typeface.createFromAsset(getAssets(), "fonts/ThaiAltOTS.ttf");

        final TextView text1 = new TextView(this);
        text1.setText("Custom Font 1");
        text1.setTextSize(40);
        if (typeface1 != null) {
            text1.setTypeface(typeface1);
        } else
            text1.setText("Error Loading Font!");

        final TextView text2 = new TextView(this);
        text2.setText("Custom Font 2");
        text2.setTextSize(40);
        if (typeface2 != null) {
            text2.setTypeface(typeface2);
        } else
            text2.setText("Error Loading Font!");

        final TextView text3 = new TextView(this);
        text3.setText("text3");
        text3.setTextSize(20);

        final TextView text4 = new TextView(this);
        text4.setText("text4");
        text4.setTextSize(20);

        Button button1 = new Button(this);
        button1.setText("button1");
        button1.setTextSize(28);
        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                //String str = " เครื่องบิน ";
                //String str = " ๅภถ คตจขช ๆไพะ รนยบล ฟหกดเ าสวงฃ ฃผปแอ ทมใฝ ";
                //text1.setText("Custom Font! \uE01B \uE02B \uE03B \uE04B \uE05B \uE06B");
                //String str = "♫";
                //byte spbyte[] = str.getBytes("UTF-8");
                //str = new String( spbyte,"UTF-8");
                //text1.setText(str);
                String letter = stringArray1[cnt][0];
                String letter_ex = stringArray1[cnt][1];
                String letter_meaning = stringArray1[cnt][4];

                text1.setText(Html.fromHtml(letter));
                text2.setText(Html.fromHtml(letter));
                text3.setText(Html.fromHtml(letter_ex));
                text4.setText(Html.fromHtml(letter_meaning));

                if (++cnt >= arraySize) cnt = 0;
            }
        });

        layout.addView(button1);
        layout.addView(text1);
        layout.addView(text2);
        layout.addView(text3);
        layout.addView(text4);
        setContentView(layout);

        timer1 = new Timer();
        timer1.scheduleAtFixedRate(new UpdateTimeTask(), 2000, 250);
    }

    class UpdateTimeTask extends TimerTask
    {
        public void run() {
//            long millis = System.currentTimeMillis() - startTime;
//            int seconds = (int) (millis / 1000);
//            int minutes = seconds / 60;
//            seconds     = seconds % 60;
//            timeLabel.setText(String.format("%d:%02d", minutes, seconds));
//            mGLView.requestRender();
        }
    }
}
