package com.sevenheaven.curtain;

import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.shapes.PathShape;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.View;

import com.sevenheaven.shcurtainslidingmenu.CurtainMenuActivity;
import com.sevenheaven.shtextextend.MDEditText;
import com.sevenheaven.shtextextend.style.ArrowBackgroundSpan;
import com.sevenheaven.shtextextend.style.CornerBackgroundSpan;
import com.sevenheaven.shtextextend.style.DrawableBackgroundSpan;
import com.sevenheaven.shtextextend.style.ShapeBackgroundSpan;

public class MainActivity extends CurtainMenuActivity {


    MDEditText editText;
    boolean enableLineNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setMenu(R.layout.menu_left);

        editText = (MDEditText) findViewById(R.id.mdedit_text);
        SpannableString ss = new SpannableString("I see a beautiful city and a brilliant people rising from this abyss, and, in their struggles to be truly free, in their triumphs and defeats, through long years to come, I see the evil of this time and of the previous time of which this is the natural birth, gradually making expiation for itself and wearing out.\n" +
                "I see the lives for which I lay down my life, peaceful, useful, prosperous and happy, in that England which I shall see no more.\n" +
                "I see that I hold a sanctuary in their hearts, and in the hearts of their descendants, generations hence. I see her, an old woman, weeping for me on the anniversary of this day. I see her and her husband, their course done, lying side by side in their last earthly bed, and I know that each was not more honoured and held sacred in the other's soul, than I was in the souls of both.\n" +
                "I see that child who lay upon her bosom and who bore my name, a man winning his way up in that path of life which once was mine. I see him winning it so well, that my name is made illustrious there by the light of his. I see the blots I threw upon it, faded away. I see him, foremost of just judges and honoured men, bringing a boy of my name, with a forehead that I know and golden hair, to this place— then fair to look upon, with not a trace of this day's disfigurement— and I hear him tell the child my story, with a tender and a faltering voice.\n" +
                "Crush humanity out of shape once more, under similar hammers, and it will twist itself into the same tortured forms. Sow the same seed of rapacious license and oppression over again, and it will surely yield the same fruit according to its kind.\n" +
                "It is a far, far better thing that I do, than I have ever done; it is a far, far better rest that I go to than I have ever known.");

        editText.setText(ss);

    }

    public void redBackgroundButtonClick(View view){
        Drawable drawable = getResources().getDrawable(R.drawable.paint_streak);
        editText.setSelectionSpan(new BackgroundColorSpan(0x33000000), new DrawableBackgroundSpan(drawable), new ForegroundColorSpan(0xFFFFFFFF));
    }

    public void crossLineButtonClick(View view){
        Path path = new Path();
        path.moveTo(0, 12);
        path.lineTo(100, 88);

        ShapeBackgroundSpan shapeSpan = new ShapeBackgroundSpan(0xFF000000, new PathShape(path, 100, 100), true);
        shapeSpan.setStrokeWidth(6);

        editText.setSelectionSpan(shapeSpan, new ArrowBackgroundSpan(0xFF7373, 0x22000000));
    }

    public void roundRectButtonClick(View view){
        editText.setSelectionSpan(new CornerBackgroundSpan(0xFF0099CC, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, this.getResources().getDisplayMetrics())), new ForegroundColorSpan(0xFFFFFFFF));

    }

    public void lineNumberButtonClick(View view){
        if(enableLineNumber){
            editText.showLineNumber(false);

        }else{
            editText.showLineNumber(true);
        }

        enableLineNumber = !enableLineNumber;
    }

    public void menuClick(View view){
        getCurtainLayout().toggle();
    }
}
