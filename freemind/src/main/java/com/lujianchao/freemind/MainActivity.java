package com.lujianchao.freemind;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.freemind.lujianchao.core_socket.Core.Base.ClientManager;
import com.freemind.lujianchao.core_socket.Core.Interface.onLoginRegListener;
import com.freemind.lujianchao.core_socket.Core.Utils.Utils;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;
    private EditText name, pwd;
    private Button login, reg;
    private onLoginRegListener mOnLoginRegListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = (TextView) findViewById(R.id.textView);
        name = (EditText) findViewById(R.id.name);
        pwd = (EditText) findViewById(R.id.pwd);
        login = (Button) findViewById(R.id.login);
        reg = (Button) findViewById(R.id.reg);

        mOnLoginRegListener = new onLoginRegListener() {
            @Override
            public void onSuccess(final String UserID, final String Flag) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.append(UserID + "\r\n" + Flag + "\r\n");
                    }
                });

            }

            @Override
            public void onError(final String Errormsg) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.append(Errormsg + "\r\n");
                    }
                });
            }

            @Override
            public void onLoginForcedOut(final String mS) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.append(mS + "\r\n");
                        new AlertDialog.Builder(MainActivity.this).setMessage(mS).setPositiveButton("确定", null).show();
                    }
                });
            }
        };
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.reg:
                ClientManager.ClientRegister(name.getText().toString(), pwd.getText().toString(), mOnLoginRegListener);
                break;
            case R.id.login:
                ClientManager.ClientLogin(name.getText().toString(), pwd.getText().toString(), mOnLoginRegListener);
                break;
            case R.id.test:


                break;
        }
    }
}
