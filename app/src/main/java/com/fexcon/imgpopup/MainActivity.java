package com.fexcon.imgpopup;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;

import android.widget.ImageView;


import com.ceylonlabs.imageviewpopup.ImagePopup;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** Set Image Height, Width & Background Color as you want **/
       final ImagePopup imagePopup = new ImagePopup(this);
        //imagePopup.setBackgroundColor(Color.BLACK);
        imagePopup.setWindowHeight(800);
        imagePopup.setWindowWidth(800);

        //imagePopup.setHideCloseIcon(true);
        imagePopup.setImageOnClickClose(true);



        final ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /** Initiate Popup view **/
                imagePopup.initiatePopup(imageView.getDrawable());
                ImageView closeBtn = new ImageView(MainActivity.this);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    closeBtn.setImageDrawable(getDrawable(R.drawable.x));
                    imagePopup.setCloseIcon(closeBtn);
                }

                //imagePopup.setBackgroundColor(R.color.colorAccent);
            }
        });
    }


}
