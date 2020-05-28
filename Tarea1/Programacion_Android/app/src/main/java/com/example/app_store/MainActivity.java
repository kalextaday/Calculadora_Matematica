package com.example.app_store;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText campo1,campo2,result;
    int num1,num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campo1=(EditText) findViewById(R.id.txtNum1);
        campo2=(EditText) findViewById(R.id.txtNum2);
        result=(EditText) findViewById(R.id.txtResult);

    }

    public void onClick(View view) {
        num1=Integer.parseInt(campo1.getText().toString());
        num2=Integer.parseInt(campo2.getText().toString());

        sumar();
    }

    private void sumar(){
        int suma=num1+num2;
        result.setText(Integer.toString(suma));
    }
}
