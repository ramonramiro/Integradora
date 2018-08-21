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

public class StepTwoActivity extends AppCompatActivity {

    private EditText edtSubmint, edtAddress;
    //  private TextView edtShowBits;
    private Button btSubmit;
    private Typeface all;
    private TextView tvInformation, tvInformationTwo;
    int value = 1;
    final String  addOne = ("190.30.0.0");
    private ImageView imageBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_two);

        // edtShowBits = findViewById(R.id.edtShowBits);
        tvInformationTwo = findViewById(R.id.tv_source_format_two2);
        tvInformation = findViewById(R.id.tv_source_format_two);
        edtSubmint = findViewById(R.id.tv_source_format_two3);
        edtAddress = findViewById(R.id.edt_address);
        btSubmit = findViewById(R.id.bt_submit_network);

        imageBack = findViewById(R.id.image_back);

        final EditText viewBegan = findViewById(R.id.edt_address);
        // final TextView utilizar = findViewById(R.id.edtShowBits);

        viewBegan.setText(addOne);
        // utilizar.setText();

        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String edtSubmintData = edtSubmint.getText().toString().trim();

                if (TextUtils.isEmpty(edtSubmintData)) {

                    Toast.makeText(StepTwoActivity.this, R.string.fill_field, Toast.LENGTH_LONG).show();

                    return;
                }

                int recoveredData = Integer.valueOf(edtSubmintData);


                if (recoveredData <= 1) {

                    Toast.makeText(StepTwoActivity.this, R.string.error_1, Toast.LENGTH_LONG).show();
                    edtSubmint.setText("");
                    return;




                } else if (recoveredData == 2) {


                    Toast.makeText(StepTwoActivity.this, R.string.bit_1, Toast.LENGTH_LONG).show();

                    edtSubmint.setText("");
                    return;


                    //  value = 1;


                    //String value = null;


                }else if (recoveredData <= 4) {
                    Toast.makeText(StepTwoActivity.this, R.string.bit_2, Toast.LENGTH_LONG).show();
                    edtSubmint.setText("");

                }
                else if (recoveredData <= 8) {
                    Toast.makeText(StepTwoActivity.this, R.string.bit_3, Toast.LENGTH_LONG).show();
                    edtSubmint.setText("");
                }

                else if (recoveredData <= 16) {
                    Toast.makeText(StepTwoActivity.this, R.string.bit_4, Toast.LENGTH_LONG).show();
                    edtSubmint.setText("");
                }

                else if (recoveredData <= 32) {
                    Toast.makeText(StepTwoActivity.this, R.string.bit_5, Toast.LENGTH_LONG).show();
                    edtSubmint.setText("");
                }

                else if (recoveredData <= 69) {
                    Toast.makeText(StepTwoActivity.this, R.string.bit_6, Toast.LENGTH_LONG).show();
                    edtSubmint.setText("");
                }

                else if (recoveredData <= 128) {
                    Toast.makeText(StepTwoActivity.this, R.string.bit_7, Toast.LENGTH_LONG).show();
                    edtSubmint.setText("");
                }

                else if (recoveredData <= 256) {
                    Toast.makeText(StepTwoActivity.this, R.string.bit_8, Toast.LENGTH_LONG).show();
                    edtSubmint.setText("");
                }

                else if (recoveredData <= 512) {
                    Toast.makeText(StepTwoActivity.this, R.string.bit_9, Toast.LENGTH_LONG).show();
                    edtSubmint.setText("");

                }else if (recoveredData <= 1024) {
                    Toast.makeText(StepTwoActivity.this, R.string.bit_10, Toast.LENGTH_LONG).show();
                    edtSubmint.setText("");

                }else if (recoveredData <= 2048) {
                    Toast.makeText(StepTwoActivity.this, R.string.bit_11, Toast.LENGTH_LONG).show();
                    edtSubmint.setText("");

                } else if (recoveredData <= 4096) {
                    Toast.makeText(StepTwoActivity.this, R.string.bit_12, Toast.LENGTH_LONG).show();
                    edtSubmint.setText("");

                } else if (recoveredData <= 8192) {
                    Toast.makeText(StepTwoActivity.this, R.string.bit_13, Toast.LENGTH_LONG).show();
                    edtSubmint.setText("");

                } else if (recoveredData <= 16384) {
                    Toast.makeText(StepTwoActivity.this, R.string.bit_14, Toast.LENGTH_LONG).show();
                    edtSubmint.setText("");

                } else if (recoveredData > 16384) {
                    Toast.makeText(StepTwoActivity.this, R.string.error_a, Toast.LENGTH_LONG).show();
                    edtSubmint.setText("");

                }
            }
        });


        String source = "fuente/all.otf";
        this.all = Typeface.createFromAsset(getAssets(), source);
        tvInformation.setTypeface(all);
        edtAddress.setTypeface(all);
        tvInformationTwo.setTypeface(all);
    }
}
