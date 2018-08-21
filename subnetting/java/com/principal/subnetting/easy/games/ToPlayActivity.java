package com.principal.subnetting.easy.games;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.principal.subnetting.easy.R;

import java.util.Random;

public class ToPlayActivity extends AppCompatActivity {

    private TextView tvPoints, tvAccount, tvLives, tvCorrect, tvIncorrect;
    private ImageView imageGuess;
    private EditText edtAnswer;
    private  Button btConfirm;

    String[] answersName;
    String[] answersNameTwo;

    String[] questions_image ={"img1","img2","img3","img4","img5","img6","img7","img8","img9","img10","img11","img12"};


    int intPoints = 0;
    int intLives=3;
    int generatedNumber=0;
    int accou=0;


    int [] imagesSeen = new int[12];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        final String[] answersName = new String[]{getString(R.string.eight),getString(R.string.twenty_four),getString(R.string.sixten),
                getString(R.string.range),getString(R.string.mask_one),getString(R.string.mask_two),getString(R.string.mask_three),
                getString(R.string.cidr),getString(R.string.vlsm),getString(R.string.twenty_four),getString(R.string.eight),getString(R.string.sixten)};

        final  String[] answersNameTwo = new String[]{getString(R.string.eight),getString(R.string.twenty_four),getString(R.string.sixten),getString(R.string.range_two),
                                                        getString(R.string.mask_one),getString(R.string.mask_two),getString(R.string.mask_three),getString(R.string.cidr_two),
                                                    getString(R.string.vlsm_two),getString(R.string.twenty_four),getString(R.string.eight),getString(R.string.sixten)};


        tvCorrect = findViewById(R.id.tv_right);
        tvIncorrect =  findViewById(R.id.tv_incorrect);

        tvPoints = findViewById(R.id.tv_points);
        tvLives = findViewById(R.id.tv_lives);
        tvAccount = findViewById(R.id.tv_count);
        imageGuess = findViewById(R.id.image_image_guess);
        edtAnswer = findViewById(R.id.edt_enter_text);
        btConfirm = findViewById(R.id.bt_right);

        Random random = new Random(System.currentTimeMillis());
        generatedNumber = random.nextInt(12);
        random.setSeed(System.currentTimeMillis());
        init();

        imagesSeen[accou]= generatedNumber;
        //Log.d("GENERADO", ""+ numerogenerado);
        //Log.d("CONTADOR", ""+ cont);

        setImage(generatedNumber);

        btConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (accou < 12) {
                    String edtConfirm = edtAnswer.getText().toString().toLowerCase();
                    if (edtConfirm.equals(answersName[generatedNumber]) | edtConfirm.equals(answersNameTwo[generatedNumber])) {
                        tvCorrect.setVisibility(View.VISIBLE);
                        intPoints = intPoints + 1;
                        tvPoints.setText(getString(R.string.points_text) + intPoints);
                        accou++;

                        if (accou == 12) {
                            Toast.makeText(ToPlayActivity.this, R.string.finish_toplay, Toast.LENGTH_SHORT).show();
                            finish();
                        }
                        waitOne();
                    } else {

                        tvIncorrect.setVisibility(View.VISIBLE);
                        intLives = intLives - 1;
                        imagesSeen[accou] = 0;
                        tvLives.setText(getString(R.string.lives_txt) + intLives);
                        waitTwo();
                    }
                    if (intLives == 0) {
                        finish();
                    }


                }else{
                    Toast.makeText(ToPlayActivity.this, R.string.finish_toplay, Toast.LENGTH_SHORT).show();
                }

            }

        });
    }

    void waitTwo(){
        new CountDownTimer(2000,1) {
            @Override
            public void onTick(long millisUntilFinished) {
                btConfirm.setVisibility(View.GONE);
            }
            @Override
            public void onFinish() {
                btConfirm.setVisibility(View.VISIBLE);
                tvIncorrect.setVisibility(View.INVISIBLE);
                edtAnswer.setText("");
                edtAnswer.setHint(R.string.enter_correct);
            }
        }.start();
    }

    void waitOne(){


        new CountDownTimer(3000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvAccount.setText(""+(millisUntilFinished/1000 +1));
                btConfirm.setVisibility(View.GONE);
            }

            @Override
            public void onFinish() {
                btConfirm.setVisibility(View.VISIBLE);
                //numerogenerado=numerogenerado+1;
                tvAccount.setText("");
                boolean isFound = false;


                do {
                    isFound = false;
                    Random random = new Random(System.currentTimeMillis());
                    generatedNumber = random.nextInt(12);
                    random.setSeed(System.currentTimeMillis());

                    if (accou > 0) {
                        for (int idx = 0; idx < accou; idx++) {
                            print();
                            if (imagesSeen[idx] == generatedNumber) {
                                isFound = true;

                                break;
                            }
                        }
                    } else {
                        break;
                    }
                } while (isFound == true);


                setImage(generatedNumber);
                imagesSeen[accou] = generatedNumber;
                tvCorrect.setVisibility(View.INVISIBLE);
                edtAnswer.setText("");
                edtAnswer.setHint(R.string.enter_correct);

            }
        }.start();

    }


    void init() {

        for (int i = 0; i < imagesSeen.length; i++){
            imagesSeen[i] = -1;
        }

    }
    void print() {
        String val="";
        for (int i = 0; i < imagesSeen.length; i++){
            val += imagesSeen[i] + "-";
        }
   //     Log.d("array ", val);
    }

    void setImage(int numero){
        int id = getResources().getIdentifier(questions_image[numero], "mipmap", getPackageName());
        imageGuess.setImageResource(id);
    }
}
