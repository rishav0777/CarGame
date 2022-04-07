package com.example.cargame;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;

public class gammer extends View {

       Bitmap back,mycar,opcar1,opcar2,opcar3;
       private int cy,cx;
        Paint bc=new Paint();
        Paint rec=new Paint();
        Paint line=new Paint();
        MediaPlayer mediaPlayer,mm;
        private  int c1x,c1y=-600,c2x,c2y=-600,c3x,c3y=-600,c4x,c4y=-600,c5x,c5y=-600;
        int ll=10000;
        boolean ri=false,lef=false,touch=true,fi=true;
        private  float right=0,forw;
        int cou=0;
         float cc=0;
         int ccc=0;
         Paint score=new Paint();
         int sc=1;

        public gammer(Context context) {
            super(context);

            // back= BitmapFactory.decodeResource(getResources(),R.drawable.road);
            mycar= BitmapFactory.decodeResource(getResources(),R.drawable.mycar);
            opcar1= BitmapFactory.decodeResource(getResources(),R.drawable.oppcar1);
            opcar2= BitmapFactory.decodeResource(getResources(),R.drawable.oppcar21);
            opcar3= BitmapFactory.decodeResource(getResources(),R.drawable.mycarop);
            bc.setColor(Color.BLACK);
            rec.setColor(Color.WHITE);
            line.setColor(Color.RED);
            score.setColor(Color.GREEN);
            score.setAntiAlias(true);
            score.setTextSize(70);
            score.setTypeface(Typeface.DEFAULT);
            mediaPlayer=MediaPlayer.create(getContext(),R.raw.calm);
            mm=MediaPlayer.create(getContext(),R.raw.hjh);


        }


        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            cx=canvas.getWidth();
            cy=canvas.getHeight();
            // canvas.drawBitmap(back,0,0,bc);
            canvas.drawRect(0,0,cx,cy,bc);
            canvas.drawText("score :" +ccc,20,50,score);

            mediaPlayer.start();
            float nro=(float)cx/5;
            for(float j=0;j<+cx;j+=nro ){
                canvas.drawLine(j,0,j,cy,line);
            }
            int k=0;
            for (float j=(nro/2);j<cx;j+=(nro)){
                k=0;
                for (float l=0;l<=cy;l+=(70)){
                    k+=5;
                    canvas.drawRect((j-3),l,(j+3),(l+20),rec);
                }
            }

            if(right<1){
                right=cx/30;

            }
            if(right>((25*cx)/30))
                right=(25*cx/30);


            cc+=(1);
            if(cc%80==0)
                ccc++;
           sc++;
            forw=cy-250;
     if(ri && cou%2==0) {
            right=right+(cx/5);
            ri = false;
            lef=false;
            canvas.drawBitmap(mycar, right, forw, null);
            fi=true;
            cou=0;
        }
        if(lef && cou%2==0){
            lef=false;
            ri = false;
            right=right-(cx/5);
            canvas.drawBitmap(mycar, right, forw, null);
           fi=true;cou=0;

        }



            canvas.drawBitmap(mycar, right, forw, null);






            int kk;
            int lll =(int) Math.floor(Math.random() * (12 - 10 + 1) + 10);
            if (c1y > cy || c1y == -600) {
                kk=(int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
                c1x = cx / 30+(cx/5)*kk;
                c1y = (int) Math.floor(Math.random() * ((-3600) - (-300 * lll) + 1) + (-300 * lll));
            }


            lll = (int) Math.floor(Math.random() * (9 - 7 + 1) + 7);
            if (c2y > cy || c2y == -600) {
                kk=(int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
                c2x = cx / 30+(cx/5)*kk;
                c2y = (int) Math.floor(Math.random() * ((-2400) - (-300 * lll) + 1) + (-300 * lll));
            }


            lll = (int) Math.floor(Math.random() * (6 - 4 + 1) + 4);
            if (c3y > cy || c3y == -600) {
                kk=(int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
                c3x = cx / 30+(cx/5)*kk;
                c3y = (int) Math.floor(Math.random() * ((-1200) - (-300 * lll) + 1) + (-300 * lll));
            }


            lll = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
            if (c4y > cy || c4y == -600) {
                kk=(int) Math.floor(Math.random() * (4 - 0 + 1) + 0);
                c4x = cx / 30+(cx/5)*kk;
                c4y = (int) Math.floor(Math.random() * ((-300) - (-300 * lll) + 1) + (-300 * lll));
            }





            canvas.drawBitmap(opcar3, c1x, c1y, null);
            canvas.drawBitmap(opcar2, c2x, c2y, null);
            canvas.drawBitmap(mycar, c3x, c3y, null);
            canvas.drawBitmap(opcar1, c4x, c4y, null);

            if(touch) {
                c1y += (10+ccc);
                c2y +=(10+ccc);
                c3y += (10+ccc);
                c4y +=(10+ccc);
          }
         //  else{

           // }
         






            if(((c1y+300)>=forw && c1x==right) || ((c2y+300)>=forw && c2x==right) ||((c3y+300)>=forw && c3x==right)
                    || ((c4y+300)>=forw && c4x==right)){
                //touch=false;
                mediaPlayer.stop();

                mm.start();
                Intent itt=new Intent(getContext(),gameover.class);
                getContext().startActivity(itt);
                if((c1y+300)>=forw && c1x==right)
                c1y += (600+ccc);
                if((c2y+300)>=forw && c2x==right)
                c2y +=(600+ccc);
                if((c3y+300)>=forw && c3x==right)
                c3y += (600+ccc);
                if((c4y+300)>=forw && c4x==right)
                c4y +=(600+ccc);

            }



        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            int xx = (int)event.getX();
            // int yy = event.getY();
            cou++;
            if (xx>cx/2 && xx<cx && fi) {
                ri=true;
                lef=false;

                fi=false;
              //  right=right+(cx/10);
            }
            if (xx<cx/2 && xx>0 && fi  ) {
                lef=true;
                ri=false;
                fi=false;

              //  right=right-(cx/10);
            }
            return (true);
        }


}
