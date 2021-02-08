package com.example.seadev.dzhealth_mobileapp;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


public class Prelevement extends AsyncTask<String, Void, Void> {
    Context c;

    Prelevement(Context c) {
        this.c = c;
    }

    @Override
    protected Void doInBackground(String... params) {
        String line = "", url_service = "http://192.168.43.96/service_DzHealth/prelevement_service.php";
        String id = params[0], typePrelev = params[1], resultat = params[2];


        try {

            URL url = new URL(url_service);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);

            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter =
                    new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            String post_data =
                    URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(id, "UTF-8") + "&"
                            + URLEncoder.encode("typePrelevement", "UTF-8") + "=" + URLEncoder.encode(typePrelev, "UTF-8") +
                            "&" + URLEncoder.encode("resultat", "UTF-8") + "=" + URLEncoder.encode(resultat, "UTF-8");
            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();


        } catch (MalformedURLException e) {
            Toast.makeText(c, "prblm connection", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}
