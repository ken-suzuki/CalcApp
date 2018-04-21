package jp.techacademy.ken.suzuki.calcapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mEditText;
    EditText mEditText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        mEditText = (EditText) findViewById(R.id.editText);

        mEditText1 = (EditText) findViewById(R.id.editText1);

    }

    @Override
    public void onClick(View v) {

        String str = mEditText.getText().toString();

        if (".".equals(str) || "-".equals(str) || "-.".equals(str) || "".equals(str)) {

            Toast ts = Toast.makeText(this, "何か数値を入力してください", Toast.LENGTH_LONG);
            ts.show();

            return;
        }

        Double i = Double.parseDouble(str);

        String str1 = mEditText1.getText().toString();

        if (".".equals(str1) || "-".equals(str1) || "-.".equals(str1) || "".equals(str1))  {

            Toast ts = Toast.makeText(this, "何か数値を入力してください", Toast.LENGTH_LONG);
            ts.show();

            return;
        }

        Double j = Double.parseDouble(str1);

        Intent intent = new Intent(this, SecondActivity.class);
        if (v.getId() == R.id.button) {
            intent.putExtra("VALUE",(i + j));
        }else if (v.getId() == R.id.button1) {
                intent.putExtra("VALUE",(i - j));
        } else if (v.getId() == R.id.button2) {
                intent.putExtra("VALUE",(i * j));
        } else {
            if ( j == 0 ){
                Toast ts = Toast.makeText(this, "0以外の数値で割ってください", Toast.LENGTH_LONG);
                ts.show();
                return;
            }else {
                intent.putExtra("VALUE",(i / j));}
        }

        startActivity(intent);
    }
}