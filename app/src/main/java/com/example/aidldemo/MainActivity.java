package com.example.aidldemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    IAdditionService mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intentService = new Intent(this, AdditionService.class);
        bindService(intentService, mConnection, Context.BIND_AUTO_CREATE);
    }
    ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mService = IAdditionService.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
    public void add(View view) throws RemoteException {
        EditText text1 = findViewById(R.id.edt_enter_first_value);
        EditText text2 = findViewById(R.id.edt_enter_second_value);

        int value1 = Integer.parseInt(text1.getText().toString());
        int value2 = Integer.parseInt(text2.getText().toString());

        int result = mService.add(value1,value2);
        TextView textview = findViewById(R.id.display_result);
        textview.setText(""+result);
    }

    public void subtract(View view) throws RemoteException {
        EditText text1 = findViewById(R.id.edt_enter_first_value);
        EditText text2 = findViewById(R.id.edt_enter_second_value);

        int value1 = Integer.parseInt(text1.getText().toString());
        int value2 = Integer.parseInt(text2.getText().toString());

        int result = mService.subtract(value1,value2);
        TextView textview = findViewById(R.id.display_result);
        textview.setText(""+result);
    }

    public void multiply(View view) throws RemoteException {
        EditText text1 = findViewById(R.id.edt_enter_first_value);
        EditText text2 = findViewById(R.id.edt_enter_second_value);

        int value1 = Integer.parseInt(text1.getText().toString());
        int value2 = Integer.parseInt(text2.getText().toString());

        int result = mService.multiply(value1,value2);
        TextView textview = findViewById(R.id.display_result);
        textview.setText(""+result);
    }
}