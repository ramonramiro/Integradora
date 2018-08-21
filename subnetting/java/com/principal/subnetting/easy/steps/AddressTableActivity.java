package com.principal.subnetting.easy.steps;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.principal.subnetting.easy.R;

public class AddressTableActivity extends AppCompatActivity {

    char classAdd = 'A';

    private TextView tvDesign, tvDesignTwo;
    private Typeface allDesign;
    private ImageView imageReturn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adress_table);
        tvDesign = findViewById(R.id.tv_information);
        tvDesignTwo = findViewById(R.id.tv_information_two);
        final EditText classAddress = findViewById(R.id.edt_class);
        final EditText range = findViewById(R.id.edt_range);
        final EditText mask = findViewById(R.id.edt_more);
        final EditText bits = findViewById(R.id.edt_bits);
        final EditText prefix = findViewById(R.id.edt_prefix);
        imageReturn = findViewById(R.id.image_return);


        classAddress.setText("" + classAdd);
        classAddress.setEnabled(false);

imageReturn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        finish();
    }
});
        Button add = findViewById(R.id.bt_add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String rangeChain = range.getText().toString().trim();
                String maskChain = mask.getText().toString().trim();
                String bitsChain = bits.getText().toString().trim();
                String prefixChain = prefix.getText().toString().trim();

                if (TextUtils.isEmpty(rangeChain) || TextUtils.isEmpty(maskChain) || TextUtils.isEmpty(bitsChain)
                        || TextUtils.isEmpty(prefixChain)) {

                    Toast.makeText(AddressTableActivity.this, R.string.validation_classAdrees, Toast.LENGTH_LONG).show();

                    return;
                }

                String[] chain = {classAddress.getText().toString(), range.getText().toString(), mask.getText().toString(), bits.getText().toString(), prefix.getText().toString()};

                switch (classAdd) {
                    case 'A':
                        if (rangeChain.equals(getString(R.string.ciru_twentysix)) && maskChain.equals(getString(R.string.mask_address)) && bitsChain.equals(getString(R.string.twenty_four)) && prefixChain.equals(getString(R.string.eigth)) ) {

                            paintRow(chain);
                            classAdd++;
                            classAddress.setText("" + classAdd);
                            range.setText("");
                            mask.setText("");
                            bits.setText("");
                            prefix.setText("");
                            classAddress.setEnabled(false);

                        }
                        break;
                    case 'B':
                        if (rangeChain.equals(getString(R.string.other_range)) && maskChain.equals(getString(R.string.mask_addres_table)) && bitsChain.equals("16") && prefixChain.equals(getString(R.string.fiften))) {

                            paintRow(chain);
                            classAdd++;
                            classAddress.setText("" + classAdd);
                            range.setText("");
                            mask.setText("");
                            bits.setText("");
                            prefix.setText("");
                            classAddress.setEnabled(false);

                        }
                        break;
                    case 'C':
                        if (rangeChain.equals(getString(R.string.range_three)) && maskChain.equals(getString(R.string.mask_two_address)) && bitsChain.equals(getString(R.string.eigth)) && prefixChain.equals(getString(R.string.twenty_four))) {

                            paintRow(chain);
                            classAdd++;
                            classAddress.setText("" + classAdd);
                            range.setText("");
                            mask.setText("");
                            bits.setText("");
                            prefix.setText("");
                            classAddress.setEnabled(false);

                        }
                        break;
                    case 'D':
                        if (rangeChain.equals(getString(R.string.range_four_address)) && maskChain.equals(getString(R.string.complet_mask)) && bitsChain.equals(getString(R.string.ciru)) && prefixChain.equals(getString(R.string.thirty_two))) {

                            paintRow(chain);
                            classAdd++;
                            classAddress.setText("" + classAdd);
                            range.setText("");
                            mask.setText("");
                            bits.setText("");
                            prefix.setText("");
                            classAddress.setEnabled(false);

                        }
                        break;

                    default:
                        Toast.makeText(AddressTableActivity.this, R.string.complte_table, Toast.LENGTH_LONG).show();

                }

            }
        });
    }
    public void paintRow(String chain[]){

        Toast.makeText(AddressTableActivity.this, R.string.god, Toast.LENGTH_LONG).show();
        TableLayout tabla = (TableLayout) findViewById(R.id.table_list);
        TextView textView;
        //abrimos el table row agregar las filas
        TableRow row = new TableRow(getBaseContext());
        for (int i = 0; i < 5; i++) {

            //abrimos un constructor del textview haciendo referencia a este proyecto
            textView = new TextView(getBaseContext());
            //para centrar el texto
            textView.setGravity(Gravity.CENTER_VERTICAL);
            //le damos dimenciones al textview
            textView.setPadding(25, 25, 25, 25);
            //un color de fondo
            textView.setBackgroundResource(R.color.colorPrimary);
            //agregamos los datos del vector cadena uno por uno al textview
            textView.setText(chain[i]);
            //color de texto en el textview
            textView.setTextColor(Color.WHITE);
            //  textView.setTextSize(12);
            //agregamos el textview al TableRow
            row.addView(textView);
        }
        //Finalmente agregamos el TableRow al TableLayout
        tabla.addView(row);

        String fuente = "fuente/all.otf";
        this.allDesign = Typeface.createFromAsset(getAssets(), fuente);
        tvDesign.setTypeface(allDesign);
        tvDesignTwo.setTypeface(allDesign);


    }

}
