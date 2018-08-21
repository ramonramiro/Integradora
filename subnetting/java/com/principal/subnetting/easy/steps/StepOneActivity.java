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

public class StepOneActivity extends AppCompatActivity {

  private   EditText edtDataOne;
  private Button btCheck;
  private  EditText edtEntryData;
  private TextView edtInformation;
  private Typeface all;
  private ImageView imageButtonActivity;

    String addOne;
    String addTwo;
    String addThree; // 255.255.255.192
    String addFour; // 255.255.240.0
    //String addresFive; // 255.224.0.0

    int accountant;
    int index;
    Random random = new Random();
    //creamos arreglo de tipo cadena
    ArrayList<String> address = new ArrayList<String>();
    ArrayList<String> answer = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_one);
        addOne = getString(R.string.masc_bin_p1);
        addTwo = getString(R.string.mask_bin_p1);
        addThree = getString(R.string.mask_bin_p2);
        addFour = getString(R.string.mask_bin_p4);
        //addresFive = getString(R.string.mask_bin5);

        address.add(addOne);
        address.add(addTwo);
        address.add(addThree);
        address.add(addFour);
        //binarias.add(addresFive);

        answer.add(getString(R.string.first_1));
        answer.add(getString(R.string.second_1));
        answer.add(getString(R.string.third_1));
        answer.add(getString(R.string.fourth_1));
        //decimales.add("255.224.0.0");

        accountant = 4;
        index=0;

        //Vincular las vistas
        edtDataOne = findViewById(R.id.edt_data_one);

        btCheck = findViewById(R.id.bt_check);
        edtInformation = findViewById(R.id.tv_source_format);
        final EditText entryClass = findViewById(R.id.edt_data_one);
        edtEntryData = findViewById(R.id.tv_source_format_four2);
        imageButtonActivity = findViewById(R.id.image_back);
        index = random.nextInt(4);


        entryClass.setText(address.get(index));
        entryClass.setEnabled(false);


        imageButtonActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        btCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String stringData = edtEntryData.getText().toString().trim();

                if (TextUtils.isEmpty(stringData)) {

                    Toast.makeText(StepOneActivity.this, R.string.fill_field, Toast.LENGTH_LONG).show();

                    return;
                }

                //Collections.shuffle(Arrays.asList(arreglo)); se puede utilizar en un futuro
                // para mover los lugares sin utizar random

                // while (account < 5) {
           /*     Log.d("Tamaño de binario",""+ binarias.size());
                Log.d("Contenido Binarias ", Arrays.toString(binarias.toArray()));
                Log.d("Contenido Decimales ", Arrays.toString(decimales.toArray()));
                Log.d("indice", "" + index); */
                if(address.size() >= 1) {


                    switch (index) {
                        case 0: //adOne
                            if (stringData.equals(answer.get(index))) {

                                Toast.makeText(StepOneActivity.this, R.string.its_ok, Toast.LENGTH_LONG).show();
                                edtEntryData.setText("");
//                                Log.d("QUIZ ", "Correcto!!");

                            } else {

                                Toast.makeText(StepOneActivity.this, R.string.its_file, Toast.LENGTH_LONG).show();
                                return;
                            }
                            break;

                        case 1:
                            if (stringData.equals(answer.get(index))) {
                                Toast.makeText(StepOneActivity.this, R.string.its_ok, Toast.LENGTH_LONG).show();
                                edtEntryData.setText("");
                             //   Log.d("QUIZ ", "Correcto!!");

                            } else {
                                Toast.makeText(StepOneActivity.this,  R.string.its_file, Toast.LENGTH_LONG).show();
                                edtEntryData.setText("");
                                return;

                            }

                            break;
                        case 2:
                            if (stringData.equals(answer.get(index))) {

                                Toast.makeText(StepOneActivity.this, R.string.its_ok, Toast.LENGTH_LONG).show();
                                edtEntryData.setText("");
                             //   Log.d("QUIZ ", "Correcto!!");

                            } else {
                                Toast.makeText(StepOneActivity.this,  R.string.its_file, Toast.LENGTH_LONG).show();
                                edtEntryData.setText("");
                                return;


                            }
                            break;
                        case 3:
                            if (stringData.equals(answer.get(index))) {

                                Toast.makeText(StepOneActivity.this, R.string.its_ok, Toast.LENGTH_LONG).show();
                                edtEntryData.setText("");
                            //    Log.d("QUIZ ", "Correcto!!");
                            } else {
                                Toast.makeText(StepOneActivity.this,  R.string.its_file, Toast.LENGTH_LONG).show();
                                edtEntryData.setText("");
                                return;

                            }

                            break;

                        default:

                            Toast.makeText(StepOneActivity.this, R.string.end_return, Toast.LENGTH_LONG).show();
                            //finish();

                    }

                    if (address.size() >= 1) {
                    //    Log.d("QUIZ ", "Removiendo " + index);
                        address.remove(index);
                        answer.remove(index);


                        if (address.size() == 0){
                            Toast.makeText(StepOneActivity.this, R.string.end_return, Toast.LENGTH_LONG).show();

                            return;

                        }
                        index = random.nextInt(address.size());
                       // Log.d("QUIZ ", "GENERADO " + index);
                        entryClass.setText(address.get(index));

                    }

                }
            }

        });

        String fuente = "fuente/all.otf";
        this.all = Typeface.createFromAsset(getAssets(), fuente);
        edtInformation.setTypeface(all);
        }
}
