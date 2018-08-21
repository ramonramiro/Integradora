package com.principal.subnetting.easy.steps;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.principal.subnetting.easy.R;

import java.util.ArrayList;
import java.util.Random;

public class PublicPrivateActivity extends AppCompatActivity {

    private EditText edtDataFirst;
    private Button btChek;
    private TextView tvDataDesign;
    private  EditText tvDataEntry;
    private ImageView imgReturn;
    private Typeface allDesign;

    String addresOne;
    String addresTwo;
    String addresThree; // 255.255.255.192
    String addresFour; // 255.255.240.0
    String addresFive; // 255.224.0.0

    int account;
    int index;
    Random rand = new Random();
    //creamos arreglo de tipo cadena
    ArrayList<String> addres = new ArrayList<String>();
    ArrayList<String> answers = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public_private);
        addresOne = getString(R.string.private_one); // privada
        addresTwo = getString(R.string.private_two); //	privada
        addresThree = getString(R.string.private_three); ///privada
        addresFour = getString(R.string.public_one); //publica
        addresFive = getString(R.string.public_two);  //publica

        addres.add(addresOne);
        addres.add(addresTwo);
        addres.add(addresThree);
        addres.add(addresFour);
        addres.add(addresFive);

        answers.add(getString(R.string.answerOne));
        answers.add(getString(R.string.answerTwo));
        answers.add(getString(R.string.answerThree));
        answers.add(getString(R.string.answerFour));
        answers.add(getString(R.string.answerFive));

        account = 5;
        index=0;

        //Vincular las vistas
        edtDataFirst = findViewById(R.id.edt_data_one);
        final EditText classAddress =findViewById(R.id.edt_data_one);

        btChek = findViewById(R.id.bt_check);
        tvDataEntry =findViewById(R.id.tv_source_format_four2);
        imgReturn = findViewById(R.id.image_return_one);
        tvDataDesign = findViewById(R.id.tv_information_three);

        index = rand.nextInt(5);

        classAddress.setText(addres.get(index));
        classAddress.setEnabled(false);

        imgReturn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        finish();
    }
});
        btChek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String stringData = tvDataEntry.getText().toString().trim();

                if (TextUtils.isEmpty(stringData)) {

                    Toast.makeText(PublicPrivateActivity.this, R.string.fill_field, Toast.LENGTH_LONG).show();

                    return;
                }

                if(addres.size() >= 1) {


                    switch (index) {
                        case 0:
                            if (stringData.equals(answers.get(index))) {

                                Toast.makeText(PublicPrivateActivity.this, R.string.its_ok, Toast.LENGTH_LONG).show();
                                tvDataEntry.setText("");

                            } else {

                                Toast.makeText(PublicPrivateActivity.this, R.string.its_file, Toast.LENGTH_LONG).show();
                                return;
                            }
                            break;

                        case 1:
                            if (stringData.equals(answers.get(index))) {
                                Toast.makeText(PublicPrivateActivity.this, R.string.its_ok, Toast.LENGTH_LONG).show();
                                tvDataEntry.setText("");

                            } else {
                                Toast.makeText(PublicPrivateActivity.this, R.string.its_file, Toast.LENGTH_LONG).show();
                                tvDataEntry.setText("");
                                return;

                            }

                            break;
                        case 2:
                            if (stringData.equals(answers.get(index))) {

                                Toast.makeText(PublicPrivateActivity.this, R.string.its_ok, Toast.LENGTH_LONG).show();
                                tvDataEntry.setText("");

                            } else {
                                Toast.makeText(PublicPrivateActivity.this, R.string.its_file, Toast.LENGTH_LONG).show();
                                tvDataEntry.setText("");
                                return;


                            }
                            break;
                        case 3:
                            if (stringData.equals(answers.get(index))) {

                                Toast.makeText(PublicPrivateActivity.this, R.string.its_ok, Toast.LENGTH_LONG).show();
                                tvDataEntry.setText("");
                            } else {
                                Toast.makeText(PublicPrivateActivity.this, R.string.its_file, Toast.LENGTH_LONG).show();
                                tvDataEntry.setText("");
                                return;

                            }

                            break;
                        case 4:
                            if (stringData.equals(answers.get(index))) {
                                tvDataEntry.setText("");
                                Toast.makeText(PublicPrivateActivity.this, R.string.its_ok, Toast.LENGTH_LONG).show();

                            } else {
                                Toast.makeText(PublicPrivateActivity.this, R.string.its_file, Toast.LENGTH_LONG).show();
                                tvDataEntry.setText("");
                                return;
                            }

                            break;

                        default:

                            Toast.makeText(PublicPrivateActivity.this,R.string.end_return, Toast.LENGTH_LONG).show();

                    }

                    if (addres.size() >= 1) {

                        addres.remove(index);
                        answers.remove(index);

                        if (addres.size() == 0){
                            Toast.makeText(PublicPrivateActivity.this, R.string.end_return, Toast.LENGTH_LONG).show();
                            return;
                        }
                        index = rand.nextInt(addres.size());

                        classAddress.setText(addres.get(index));


                    }
                }
            }

        });

        String source = "fuente/all.otf";
        this.allDesign = Typeface.createFromAsset(getAssets(), source);
        tvDataDesign.setTypeface(allDesign);
        edtDataFirst.setTypeface(allDesign);
    }
}

