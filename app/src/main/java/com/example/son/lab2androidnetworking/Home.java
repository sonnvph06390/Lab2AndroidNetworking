package com.example.son.lab2androidnetworking;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Home extends AppCompatActivity {
    private TextView tvData;
    private Button btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tvData = (TextView) findViewById(R.id.tvData);
        btnExit = findViewById(R.id.btnExit);

        HttpGetRequest httpGetRequest = new HttpGetRequest();
        httpGetRequest.execute();

    }

    public class HttpGetRequest extends AsyncTask<Void, Void, String> {
        String result;
        String readLine;
        public static final String SERVER = "http://dotplays.com/android/bai1.php?food=today";

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL(SERVER);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.connect();
                InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuilder stringBuilder = new StringBuilder();
                while ((readLine = bufferedReader.readLine()) != null) {
                    stringBuilder.append(readLine);

                }
                bufferedReader.close();
                inputStreamReader.close();
                result = stringBuilder.toString();
            } catch (Exception e) {
                Log.e("loi:", e.toString());
                result = e.toString();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            tvData.setText(result);
        }
    }
}
