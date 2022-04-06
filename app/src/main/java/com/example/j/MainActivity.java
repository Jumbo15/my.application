package com.example.j;
import java.net.*;
import java.io.*;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {


    Socket s;
    DataInputStream din;
    DataOutputStream dout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void connect(View view) {
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            s = new Socket("172.20.10.4", 5555);
        } catch (IOException e) {
            e.printStackTrace();
            //output.setText();
        }
    }
     public void send(View view){
         EditText mes = (EditText) findViewById(R.id.mes);
         TextView output = (TextView)findViewById(R.id.textView);
            try {
                din=new DataInputStream(s.getInputStream());
                dout=new DataOutputStream(s.getOutputStream());
                String str = "";
                String str2 = "";
                str = mes.getText().toString();

                dout.writeUTF(str);
                dout.flush();
                str2 = din.readUTF();
                output.setText(str2);

            } catch (IOException e) {
                e.printStackTrace();
            }



    }



        //SEND = findViewById(R.id.S);
        //CONNECT = findViewById(R.id.C);
       /// SEND.setOnClickListener(new View.OnClickListener() {
         //   @Override
          //  public void onClick(View view) {

          /*      Socket s= null;

                try {
                    s = new Socket("127.0.0.1",5555);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    DataInputStream din=new DataInputStream(s.getInputStream());

                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {

                    DataOutputStream dout=new DataOutputStream(s.getOutputStream());
                    Object mes = null;
                   // dout.writeUTF((String) mes.getText().toString);
                    dout.flush();
                    dout.close();
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
           */
}