package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtResult;
        EditText wt,Inch,Feet;
        Button btn;
        LinearLayout mainCol;

        txtResult=findViewById(R.id.result);
        wt=findViewById(R.id.wt);
        Inch=findViewById(R.id.inch);
        Feet=findViewById(R.id.feet);
        btn=findViewById(R.id.btn);
        mainCol=findViewById(R.id.maincolor);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int w=Integer.parseInt(wt.getText().toString());
                int in=Integer.parseInt(Inch.getText().toString());
                int ft=Integer.parseInt(Feet.getText().toString());

                int totalInch=ft*12+in;
                double totalCm=totalInch*2.53;
                double totalM=totalCm/100;
                double bmi=w/(totalM*totalM);

                if(bmi>25){
                    txtResult.setText("You are overweighted!");
                    mainCol.setBackgroundColor(getResources().getColor(R.color.over));
                }else if(bmi<18){
                    txtResult.setText("You are underweighted!");
                    mainCol.setBackgroundColor(getResources().getColor(R.color.under));
                }else{
                    txtResult.setText("You are healthy!");
                    mainCol.setBackgroundColor(getResources().getColor(R.color.healthy));
                }
            }
        });

    }
}