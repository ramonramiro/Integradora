package com.principal.subnetting.easy.games;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.principal.subnetting.easy.R;

import java.util.Arrays;
import java.util.Collections;

public class MemoryActivity extends AppCompatActivity {
    private Typeface all;
    private TextView tvCompetitor, tvCompetitorTwo;
    private ImageView imageEleven, imageTwelve, imageThirteen, imageFourteen, imageTwentyOne, imageTwentyTwo, imageTwentyThree,
            imageTwentyFour, imageThirtyOne, imageThirtyTwo, imageThirtyThree, imageThirtyFour, imageFortyOne, imageFortyTwo,
            imageFortyThree, imageFortyFour, imageFiftyOne, imageFiftyTwo,
            imageFiftyThree, imageFiftyFour, imageSixtyOne, imageSixtyTwo, imageSixtyThree, imageSixtyFour;

    //array for the images

    Integer[] cardArray = {101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112,  201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212 };

    int image101, image102, image103, image104, image105, image106, image107, image108, image109, image110, image111, image112,
            image201,image202, image203, image204,image205, image206, image207,image208, image209, image210,image211, image212;

    int firstCard, secondCard;
    int clickedFirst, clickedSecond;
    int cardNumber = 1;

    int turn = 1;
    int playerPoints = 0, cpuPoints = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);

        tvCompetitor =  findViewById(R.id.tv_p1);
        tvCompetitorTwo =  findViewById(R.id.tv_score_two);

        imageEleven =  findViewById(R.id.image_eleven);
        imageTwelve =  findViewById(R.id.image_twelve);
        imageThirteen =  findViewById(R.id.image_thirteen);
        imageFourteen =  findViewById(R.id.image_fourteen);
        imageTwentyOne =  findViewById(R.id.image_twenty_one);
        imageTwentyTwo =  findViewById(R.id.image_twenty_two);
        imageTwentyThree =  findViewById(R.id.image_twenty_three);
        imageTwentyFour =  findViewById(R.id.image_twenty_four);
        imageThirtyOne =  findViewById(R.id.image_thirty_one);
        imageThirtyTwo =  findViewById(R.id.image_thirty_two);
        imageThirtyThree =  findViewById(R.id.image_thirty_three);
        imageThirtyFour =  findViewById(R.id.image_thirty_four);


        imageFortyOne =  findViewById(R.id.image_forty_one);
        imageFortyTwo =  findViewById(R.id.image_forty_two);
        imageFortyThree =  findViewById(R.id.image_forty_three);
        imageFortyFour =  findViewById(R.id.image_forty_four);
        imageFiftyOne =  findViewById(R.id.image_fifty_one);
        imageFiftyTwo =  findViewById(R.id.image_fifty_two);
        imageFiftyThree =  findViewById(R.id.image_fifty_three);
        imageFiftyFour =  findViewById(R.id.image_fifty_four);
        imageSixtyOne =  findViewById(R.id.image_sixty_one);
        imageSixtyTwo =  findViewById(R.id.image_sixty_two);
        imageSixtyThree =  findViewById(R.id.image_sixty_three);
        imageSixtyFour =  findViewById(R.id.image_sixty_four);

        imageEleven.setTag("0");
        imageTwelve.setTag("1");
        imageThirteen.setTag("2");
        imageFourteen.setTag("3");
        imageTwentyOne.setTag("4");
        imageTwentyTwo.setTag("5");
        imageTwentyThree.setTag("6");
        imageTwentyFour.setTag("7");
        imageThirtyOne.setTag("8");
        imageThirtyTwo.setTag("9");
        imageThirtyThree.setTag("10");
        imageThirtyFour.setTag("11");

        imageFortyOne.setTag("12");
        imageFortyTwo.setTag("13");
        imageFortyThree.setTag("14");
        imageFortyFour.setTag("15");
        imageFiftyOne.setTag("16");
        imageFiftyTwo.setTag("17");
        imageFiftyThree.setTag("18");
        imageFiftyFour.setTag("19");
        imageSixtyOne.setTag("20");
        imageSixtyTwo.setTag("21");
        imageSixtyThree.setTag("22");
        imageSixtyFour.setTag("23");

        //load images

        frontOfCardResources ();

        //shuffle the images (barajeo de imagenes)
        Collections.shuffle(Arrays.asList(cardArray));

        //changin the color of the second player
        tvCompetitorTwo.setTextColor(Color.GRAY);

        imageEleven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageEleven, theCard);


            }
        });

        imageTwelve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageTwelve, theCard);

            }
        });

        imageThirteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageThirteen, theCard);

            }
        });




        imageFourteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageFourteen, theCard);

            }
        });


        imageTwentyOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageTwentyOne, theCard);

            }
        });

        imageTwentyTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageTwentyTwo, theCard);

            }
        });



        imageTwentyThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageTwentyThree, theCard);

            }
        });


        imageTwentyFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageTwentyFour, theCard);

            }
        });



        imageThirtyOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageThirtyOne, theCard);

            }
        });



        imageThirtyTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageThirtyTwo, theCard);

            }
        });


        imageThirtyThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageThirtyThree, theCard);

            }
        });


        imageThirtyFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageThirtyFour, theCard);

            }
        });

        imageFortyOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageFortyOne, theCard);


            }
        });

        imageFortyTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageFortyTwo, theCard);

            }
        });

        imageFortyThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageFortyThree, theCard);

            }
        });




        imageFortyFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageFortyFour, theCard);

            }
        });


        imageFiftyOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageFiftyOne, theCard);

            }
        });

        imageFiftyTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageFiftyTwo, theCard);

            }
        });



        imageFiftyThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageFiftyThree, theCard);

            }
        });


        imageFiftyFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageFiftyFour, theCard);

            }
        });



        imageSixtyOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageSixtyOne, theCard);

            }
        });



        imageSixtyTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageSixtyTwo, theCard);

            }
        });


        imageSixtyThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageSixtyThree, theCard);

            }
        });


        imageSixtyFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageSixtyFour, theCard);

            }
        });

        ///////////////////////////////////////////////////////////////
        imageEleven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageEleven, theCard);


            }
        });

        imageTwelve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageTwelve, theCard);

            }
        });

        imageThirteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageThirteen, theCard);

            }
        });




        imageFourteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageFourteen, theCard);

            }
        });


        imageTwentyOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageTwentyOne, theCard);

            }
        });

        imageTwentyTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageTwentyTwo, theCard);

            }
        });



        imageTwentyThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageTwentyThree, theCard);

            }
        });


        imageTwentyFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageTwentyFour, theCard);

            }
        });



        imageThirtyOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageThirtyOne, theCard);

            }
        });



        imageThirtyTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageThirtyTwo, theCard);

            }
        });


        imageThirtyThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageThirtyThree, theCard);

            }
        });


        imageThirtyFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageThirtyFour, theCard);

            }

        });
        imageFortyOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageFortyOne, theCard);

            }

        });

        imageFortyTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageFortyTwo, theCard);

            }

        });

        imageFortyThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageFortyThree, theCard);

            }

        });

        imageFortyFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageFortyFour, theCard);

            }

        });

        imageFiftyOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageFiftyOne, theCard);

            }

        });
        imageFiftyTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageFiftyTwo, theCard);

            }

        });
        imageFiftyThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageFiftyThree, theCard);

            }

        });
        imageFiftyFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageFiftyFour, theCard);

            }

        });
        imageSixtyOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageSixtyOne, theCard);

            }

        });
        imageSixtyTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageSixtyTwo, theCard);

            }

        });
        imageSixtyThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageSixtyThree, theCard);

            }

        });
        imageSixtyFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag()) ;
                dosStuff(imageSixtyFour, theCard);

            }

        });

    }

    private void dosStuff(ImageView iv, int card) {
        //set the correct image to the imageview

        if (cardArray[card] == 101) {
            iv.setImageResource(image101);
        } else if (cardArray[card] == 102) {
            iv.setImageResource(image102);
        } else if (cardArray[card] == 103) {
            iv.setImageResource(image103);
        } else if (cardArray[card] == 104) {
            iv.setImageResource(image104);
        } else if (cardArray[card] == 105) {
            iv.setImageResource(image105);
        } else if (cardArray[card] == 106) {
            iv.setImageResource(image106);
//////////////////////////////////////////////////7segundas
        } else if (cardArray[card] == 107) {
            iv.setImageResource(image107);
        } else if (cardArray[card] == 108) {
            iv.setImageResource(image108);
        } else if (cardArray[card] == 109) {
            iv.setImageResource(image109);
        } else if (cardArray[card] == 110) {
            iv.setImageResource(image110);
        } else if (cardArray[card] == 111) {
            iv.setImageResource(image111);

        } else if (cardArray[card] == 112) {
            iv.setImageResource(image112);

        } else if (cardArray[card] == 201) {
            iv.setImageResource(image201);
        } else if (cardArray[card] == 202) {
            iv.setImageResource(image202);
        } else if (cardArray[card] == 203) {
            iv.setImageResource(image203);
        } else if (cardArray[card] == 204) {
            iv.setImageResource(image204);
        } else if (cardArray[card] == 205) {
            iv.setImageResource(image205);
        } else if (cardArray[card] == 206) {
            iv.setImageResource(image206);

            /////////////////// segundas
        } else if (cardArray[card] == 207) {
            iv.setImageResource(image207);
        } else if (cardArray[card] == 208) {
            iv.setImageResource(image208);
        } else if (cardArray[card] == 209) {
            iv.setImageResource(image209);
        } else if (cardArray[card] == 210) {
            iv.setImageResource(image210);
        } else if (cardArray[card] == 211) {
            iv.setImageResource(image211);
        } else if (cardArray[card] == 212) {
            iv.setImageResource(image212);
        }




        //check chich image is selected and save it totemporary variable
        if (cardNumber == 1) {
            firstCard = cardArray[card];
            if (firstCard > 200) {
                firstCard = firstCard - 100;
            }
            cardNumber = 2;
            clickedFirst = card;

            iv.setEnabled(false);
        }else  if (cardNumber ==2 ){
            secondCard  = cardArray[card];
            if (secondCard > 200) {
                secondCard = secondCard - 100;
            }
            cardNumber = 1;
            clickedSecond = card;

            imageEleven.setEnabled(false);
            imageTwelve.setEnabled(false);
            imageThirteen.setEnabled(false);
            imageFourteen.setEnabled(false);
            imageTwentyOne.setEnabled(false);
            imageTwentyTwo.setEnabled(false);
            imageTwentyThree.setEnabled(false);
            imageTwentyFour.setEnabled(false);
            imageThirtyOne.setEnabled(false);
            imageThirtyTwo.setEnabled(false);
            imageThirtyThree.setEnabled(false);
            imageThirtyFour.setEnabled(false);

            ///////////////////////////////////////

            imageFortyOne.setEnabled(false);
            imageFortyTwo.setEnabled(false);
            imageFortyThree.setEnabled(false);
            imageFortyFour.setEnabled(false);
            imageFiftyOne.setEnabled(false);
            imageFiftyTwo.setEnabled(false);
            imageFiftyThree.setEnabled(false);
            imageFiftyFour.setEnabled(false);
            imageSixtyOne.setEnabled(false);
            imageSixtyTwo.setEnabled(false);
            imageSixtyThree.setEnabled(false);
            imageSixtyFour.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //check if the selected images are equals
                    calculate();

                }
            }, 900);

        }
    }
    private void calculate () {
        ///if mages are equals reomve tqem ND dd points
        if (firstCard == secondCard) {
            if (clickedFirst == 0) {

                imageEleven.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 1) {

                imageTwelve.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 2) {

                imageThirteen.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 3) {

                imageFourteen.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 4) {

                imageTwentyOne.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 5) {

                imageTwentyTwo.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 6) {

                imageTwentyThree.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 7) {

                imageTwentyFour.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 8) {

                imageThirtyOne.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 9) {

                imageThirtyTwo.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 10) {

                imageThirtyThree.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 11) {

                imageThirtyFour.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 12) {

                ///////////////////////////////////////////////////////////////////////////

                imageFortyOne.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 13) {

                imageFortyTwo.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 14) {

                imageFortyThree.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 15) {

                imageFortyFour.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 16) {

                imageFiftyOne.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 17) {

                imageFiftyTwo.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 18) {

                imageFiftyThree.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 19) {

                imageFiftyFour.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 20) {

                imageSixtyOne.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 21) {

                imageSixtyTwo.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 22) {

                imageSixtyThree.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 23) {

                imageSixtyFour.setVisibility(View.INVISIBLE);
            }


            if (clickedSecond == 0) {

                imageEleven.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 1) {

                imageTwelve.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 2) {

                imageThirteen.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 3) {

                imageFourteen.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 4) {

                imageTwentyOne.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 5) {

                imageTwentyTwo.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 6) {

                imageTwentyThree.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 7) {

                imageTwentyFour.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 8) {

                imageThirtyOne.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 9) {

                imageThirtyTwo.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 10) {

                imageThirtyThree.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 11) {

                imageThirtyFour.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 12) {

                ///////////////////////////////////////////////////////////////////////////

                imageFortyOne.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 13) {

                imageFortyTwo.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 14) {

                imageFortyThree.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 15) {

                imageFortyFour.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 16) {

                imageFiftyOne.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 17) {

                imageFiftyTwo.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 18) {

                imageFiftyThree.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 19) {

                imageFiftyFour.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 20) {

                imageSixtyOne.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 21) {

                imageSixtyTwo.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 22) {

                imageSixtyThree.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 23) {

                imageSixtyFour.setVisibility(View.INVISIBLE);
            }
            ///////////////////////////////////////////////////////////////////////7 segundas
            ///add points to the player

          /*  if (turn ==1) {  calcular los puntos de un jugado
                playerPoints++;
                tvCompetitor.setText("P1: " + playerPoints);
            } else if (turn ==2) {
                cpuPoints++;
                tvCompetitorTwo.setText("P2: " + cpuPoints);
            }*/

        } else {
            imageEleven.setImageResource(R.drawable.ic_back);
            imageTwelve.setImageResource(R.drawable.ic_back);
            imageThirteen.setImageResource(R.drawable.ic_back);
            imageFourteen.setImageResource(R.drawable.ic_back);
            imageTwentyOne.setImageResource(R.drawable.ic_back);
            imageTwentyTwo.setImageResource(R.drawable.ic_back);
            imageTwentyThree.setImageResource(R.drawable.ic_back);
            imageTwentyFour.setImageResource(R.drawable.ic_back);
            imageThirtyOne.setImageResource(R.drawable.ic_back);
            imageThirtyTwo.setImageResource(R.drawable.ic_back);
            imageThirtyThree.setImageResource(R.drawable.ic_back);
            imageThirtyFour.setImageResource(R.drawable.ic_back);

            imageFortyOne.setImageResource(R.drawable.ic_back);
            imageFortyTwo.setImageResource(R.drawable.ic_back);
            imageFortyThree.setImageResource(R.drawable.ic_back);
            imageFortyFour.setImageResource(R.drawable.ic_back);
            imageFiftyOne.setImageResource(R.drawable.ic_back);
            imageFiftyTwo.setImageResource(R.drawable.ic_back);
            imageFiftyThree.setImageResource(R.drawable.ic_back);
            imageFiftyFour.setImageResource(R.drawable.ic_back);
            imageSixtyOne.setImageResource(R.drawable.ic_back);
            imageSixtyTwo.setImageResource(R.drawable.ic_back);
            imageSixtyThree.setImageResource(R.drawable.ic_back);
            imageSixtyFour.setImageResource(R.drawable.ic_back);


            //change the player turn
            /* if (turn ==1) { cambio de jugador, no se utiliza para este ejemplo
                turn = 2;
                tvCompetitor.setTextColor(Color.GRAY);
                tvCompetitorTwo.setTextColor(Color.BLACK);
            } else if (turn ==2) {
                turn = 1;
                tvCompetitorTwo.setTextColor(Color.GRAY);
                tvCompetitor.setTextColor(Color.BLACK);
            } */
        }
        imageEleven.setEnabled(true);
        imageTwelve.setEnabled(true);
        imageThirteen.setEnabled(true);
        imageFourteen.setEnabled(true);
        imageTwentyOne.setEnabled(true);
        imageTwentyTwo.setEnabled(true);
        imageTwentyThree.setEnabled(true);
        imageTwentyFour.setEnabled(true);
        imageThirtyOne.setEnabled(true);
        imageThirtyTwo.setEnabled(true);
        imageThirtyThree.setEnabled(true);
        imageThirtyFour.setEnabled(true);


        imageFortyOne.setEnabled(true);
        imageFortyTwo.setEnabled(true);
        imageFortyThree.setEnabled(true);
        imageFortyFour.setEnabled(true);
        imageFiftyOne.setEnabled(true);
        imageFiftyTwo.setEnabled(true);
        imageFiftyThree.setEnabled(true);
        imageFiftyFour.setEnabled(true);
        imageSixtyOne.setEnabled(true);
        imageSixtyTwo.setEnabled(true);
        imageSixtyThree.setEnabled(true);
        imageSixtyFour.setEnabled(true);
        //check if the game is over
        checkEnd ();
    }
    private void checkEnd () {
        if (imageEleven.getVisibility() == View.INVISIBLE &&
                imageTwelve.getVisibility() == View.INVISIBLE &&
                imageThirteen.getVisibility() == View.INVISIBLE &&
                imageFourteen.getVisibility() == View.INVISIBLE &&
                imageTwentyOne.getVisibility() == View.INVISIBLE &&
                imageTwentyTwo.getVisibility() == View.INVISIBLE &&
                imageTwentyThree.getVisibility() == View.INVISIBLE &&
                imageTwentyFour.getVisibility() == View.INVISIBLE &&
                imageThirtyOne.getVisibility() == View.INVISIBLE &&
                imageThirtyTwo.getVisibility() == View.INVISIBLE &&
                imageThirtyThree.getVisibility() == View.INVISIBLE &&
                imageThirtyFour.getVisibility() == View.INVISIBLE &&

                imageFortyOne.getVisibility() == View.INVISIBLE &&
                imageFortyTwo.getVisibility() == View.INVISIBLE &&
                imageFortyThree.getVisibility() == View.INVISIBLE &&
                imageFortyFour.getVisibility() == View.INVISIBLE &&
                imageFiftyOne.getVisibility() == View.INVISIBLE &&
                imageFiftyTwo.getVisibility() == View.INVISIBLE &&
                imageFiftyThree.getVisibility() == View.INVISIBLE &&
                imageFiftyFour.getVisibility() == View.INVISIBLE &&
                imageSixtyOne.getVisibility() == View.INVISIBLE &&
                imageSixtyTwo.getVisibility() == View.INVISIBLE &&
                imageSixtyThree.getVisibility() == View.INVISIBLE &&
                imageSixtyFour.getVisibility() == View.INVISIBLE
                ) {

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MemoryActivity.this);
            alertDialogBuilder
                    .setMessage("¡¡Ganaste el juego!! ")
                    .setCancelable(false)
                    .setPositiveButton("Nuevo", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(getApplicationContext(), MemoryActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    })
                    .setNegativeButton("Salir", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();

                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

        }
    }

    private void frontOfCardResources () {

        image101 = R.drawable.ic_image101;
        image102 = R.drawable.ic_image102;
        image103 = R.drawable.ic_image103;
        image104 = R.drawable.ic_image104;
        image105 = R.drawable.ic_image105;
        image106 = R.drawable.ic_image106;

        image107 = R.drawable.ic_image107;
        image108 = R.drawable.ic_image108;
        image109 = R.drawable.ic_image109;
        image110 = R.drawable.ic_image110;
        image111 = R.drawable.ic_image111;
        image112 = R.drawable.ic_image112;



        image201 = R.drawable.ic_image201;
        image202 = R.drawable.ic_image202;
        image203 = R.drawable.ic_image203;
        image204 = R.drawable.ic_image204;
        image205 = R.drawable.ic_image205;
        image206 = R.drawable.ic_image206;

        image207 = R.drawable.ic_image207;
        image208 = R.drawable.ic_image208;
        image209 = R.drawable.ic_image209;
        image210 = R.drawable.ic_image210;
        image211 = R.drawable.ic_image211;
        image212 = R.drawable.ic_image212;

        String fuente = "fuente/all.otf";
        this.all = Typeface.createFromAsset(getAssets(), fuente);
        tvCompetitor.setTypeface(all);
    }
}