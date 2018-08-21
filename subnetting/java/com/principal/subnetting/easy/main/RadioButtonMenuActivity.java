package com.principal.subnetting.easy.main;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.principal.subnetting.easy.steps.ActivityThreeActivity;
import com.principal.subnetting.easy.steps.StepOneActivity;
import com.principal.subnetting.easy.R;
import com.principal.subnetting.easy.steps.StepFourActivity;
import com.principal.subnetting.easy.steps.StepTwoActivity;

public class RadioButtonMenuActivity extends AppCompatActivity {
    private Button btNext;
    private RadioButton rdbOne, rdbTwo, rdbThree, rdbFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button_menu);

        btNext = findViewById(R.id.bt_next);
        rdbOne = findViewById(R.id.bt_activity_one);
        rdbTwo = findViewById(R.id.bt_activity_two);
        rdbThree = findViewById(R.id.bt_activity_three);
        rdbFour = findViewById(R.id.bt_activity_four);

        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rdbOne.isChecked()) {
                    Intent b1 = new Intent(RadioButtonMenuActivity.this, StepOneActivity.class);
                    //Paso 1
                    startActivity(b1);
                } else if (rdbTwo.isChecked()) {
                    Intent b2 = new Intent(RadioButtonMenuActivity.this, StepTwoActivity.class);
                    //Paso 2
                    startActivity(b2);
                } else if (rdbThree.isChecked()) {
                    Intent b3 = new Intent(RadioButtonMenuActivity.this, ActivityThreeActivity.class);
                    //Paso 3
                    //Esta es la actividad 3 que estaba en el menu del circulito ActivityThreeActivity
                    startActivity(b3);
                } else if (rdbFour.isChecked()) {
                    Intent b4 = new Intent(RadioButtonMenuActivity.this, StepFourActivity.class);
                    //Paso 4
                    //Esta es la actividad 4 que esta en el menu de circulito StepFourActivity
                    startActivity(b4);
                }

            }
        });

    }
    public void btOpenDialogOne(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.title);
        builder.setMessage(R.string.messager);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(RadioButtonMenuActivity.this, R.string.ok1, Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton(R.string.nose, null);
        Dialog dialog = builder.create();
        dialog.show();
    }
    public void openDialogTwo(View v)  {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.title2);
        builder.setMessage(R.string.messager2);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(RadioButtonMenuActivity.this, R.string.ok1, Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton(R.string.nose, null);
        Dialog dialog = builder.create();
        dialog.show();
    }

    public void btOpenDialogThree(View v)  {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.title3);
        builder.setMessage(R.string.messager3);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(RadioButtonMenuActivity.this, R.string.ok1, Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton(R.string.nose, null);
        Dialog dialog = builder.create();
        dialog.show();
    }
    public void btOpenDialogFour(View v)  {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.title4);
        builder.setMessage(R.string.messager4);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(RadioButtonMenuActivity.this, R.string.ok1, Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton(R.string.nose, null);
        Dialog dialog = builder.create();
        dialog.show();
    }
}
