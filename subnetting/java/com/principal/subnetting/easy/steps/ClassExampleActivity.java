package com.principal.subnetting.easy.steps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import com.principal.subnetting.easy.R;


public class ClassExampleActivity extends AppCompatActivity {

    private EditText edtEnterData;
    private Button btSubmitData;
    private TextView tvFedback;


    String address1;
    String address2;
    String address3; // 255.255.255.192
    String address4; // 255.255.240.0
    String address5;

    int acco;
    int index = 5;
    Random rand = new Random();
    ArrayList<String> address = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class);


        address1= "192.168.5.0/24"; //254 privada
        address2 = "10.0.0.0/8"; //	16,777,214  privada
        address3= "172.10.0.0/16"; //65,534 privada
        address4= "10.0.2.0/8"; //16,777,214 privada
        address5= "224.0.0.0/10";// 	4,194,302  publica, experimental D

        address.add(address1);
        address.add(address2);
        address.add(address3);
        address.add(address4);
        address.add(address5);


        acco = 5;
        index = 0;

        //Vincular vistas

//        showAddress  = findViewById(R.id.showAddress);
        edtEnterData = findViewById(R.id.edt_enter_data);
        tvFedback = findViewById(R.id.tv_fedback);
        btSubmitData = findViewById(R.id.bt_submit_network);

        final EditText showStart = findViewById(R.id.edt_show_address);
        final TextView showFedback = findViewById(R.id.tv_fedback);
        final ImageView imgBack = findViewById(R.id.image_back);

        index = rand.nextInt(5);

        showStart.setText(address.get(index));
        showStart.setEnabled(false);

        showFedback.setText(R.string.fedback);


        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        btSubmitData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String edtSubmint1 = edtEnterData.getText().toString().trim();

                if (TextUtils.isEmpty(edtSubmint1)) {

                    Toast.makeText(ClassExampleActivity.this, R.string.fill_field, Toast.LENGTH_LONG).show();

                    return;
                }

                int enteredAddress = Integer.valueOf(edtSubmint1);

             //   Log.d("QUIZ ", "Muestra indice  " + index);

                if (address.size() >=1 ) {

                    switch (index) {
                        case 0:
                            if (enteredAddress <=245  ) {

                                tvFedback.setText(R.string.answer1);
                                Toast.makeText(ClassExampleActivity.this, R.string.its_ok, Toast.LENGTH_LONG).show();
                                edtEnterData.setText("");

                            } else {

                                tvFedback.setText(R.string.answer2);
                                Toast.makeText(ClassExampleActivity.this, R.string.its_file, Toast.LENGTH_LONG).show();
                                edtEnterData.setText("");
                                // return;

                            }
                            break;

                        case 1:
                            if (enteredAddress <=245) {

                                tvFedback.setText(R.string.answer3);
                                Toast.makeText(ClassExampleActivity.this, R.string.error1, Toast.LENGTH_LONG).show();
                                edtEnterData.setText("");
                                //return;
                            } else if (enteredAddress >= 255 && enteredAddress <=2500) {
                                // tvFedback.setText(address.get(index));
                                tvFedback.setText(R.string.answer4);
                                Toast.makeText(ClassExampleActivity.this, R.string.error2, Toast.LENGTH_LONG).show();
                                edtEnterData.setText("");
                            } else {


                                tvFedback.setText(R.string.answer5);
                                Toast.makeText(ClassExampleActivity.this, R.string.answer6, Toast.LENGTH_LONG).show();
                                edtEnterData.setText("");


                            }
                            break;
                        case 2:
                            if (enteredAddress <=245) {

                                tvFedback.setText(R.string.answer7);
                                Toast.makeText(ClassExampleActivity.this, R.string.error4, Toast.LENGTH_LONG).show();
                                edtEnterData.setText("");
                                //return;
                            } else  if (enteredAddress >=255 && enteredAddress <=2500 ){

                                tvFedback.setText(R.string.answer8);
                                Toast.makeText(ClassExampleActivity.this, R.string.error6, Toast.LENGTH_LONG).show();
                                edtEnterData.setText("");
                            } else  {

                                tvFedback.setText(R.string.answer9);
                                Toast.makeText(ClassExampleActivity.this, R.string.error5, Toast.LENGTH_LONG).show();
                                edtEnterData.setText("");

                            }
                            break;
                        case 3:
                            if (enteredAddress <=245) {

                                tvFedback.setText(R.string.answer10);
                                Toast.makeText(ClassExampleActivity.this, R.string.answer12, Toast.LENGTH_LONG).show();
                                edtEnterData.setText("");
                                //return;

                            } else if (enteredAddress >= 255 && enteredAddress <=2500){
                                Toast.makeText(ClassExampleActivity.this, R.string.error7, Toast.LENGTH_LONG).show();

                                tvFedback.setText(R.string.answer13);
                                edtEnterData.setText("");

                            } else {

                                tvFedback.setText(R.string.answer14);
                                Toast.makeText(ClassExampleActivity.this, R.string.error9, Toast.LENGTH_LONG).show();
                                edtEnterData.setText("");
                            }

                            break;
                        case 4:
                            if (enteredAddress >=1) {

                                tvFedback.setText(R.string.answer16);
                                Toast.makeText(ClassExampleActivity.this, R.string.error8, Toast.LENGTH_LONG).show();
                                edtEnterData.setText("");
                                // return;
                            }
                            break;
                        default:

                            //Lg.d("mostrar retroalimentacion", "hh" + index);
                            tvFedback.setText(R.string.finaliz);
                            Toast.makeText(ClassExampleActivity.this, R.string.finaliz, Toast.LENGTH_LONG).show();

                            //   fileList();

                    }

                    if (address.size() >=1) {
                  //      Log.d("QUIZ ", "Removiendo indice  " + index);
                        address.remove(index);


                        if (address.size() == 0) {
                            Toast.makeText(ClassExampleActivity.this, R.string.finaliz, Toast.LENGTH_LONG).show();
                            return;
                        }
                        if (tvFedback.getTextSize() ==0) {
                            Toast.makeText(ClassExampleActivity.this, R.string.finaliz, Toast.LENGTH_LONG).show();
                            return;
                        }



                        index = rand.nextInt(address.size());
                        showStart.setText(address.get(index));

                    }




                }


            }
        });


    }

}
