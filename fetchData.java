package com.example.airquality;

import android.annotation.SuppressLint;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class fetchData extends AsyncTask<Void, Void, Void> {
    String  data="";
    String city;
    String dataParsed="";
    String singleParsed="";

    @SuppressLint("WrongThread")
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url=new URL("https://aqicn.org/json-api/doc/#api-City_Feed-GetCityFeed");

            HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
            InputStream inputStream=httpURLConnection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            city=Act2.cname.getText().toString();

            String line="";
            if(line==city) {
                while (line != null) {
                    line = bufferedReader.readLine();

                    data = data + line;

                    JSONArray JA = new JSONArray(data);
                    for (int i = 0; i < JA.length(); i++) {
                        JSONObject JO = (JSONObject) JA.get(i);
                        singleParsed = "City" + JO.get("city") + "\n" +
                                "pm25" + JO.get("pm25") + "\n" +
                                "forecast" + JO.get("forecast") + "\n" +
                                "daily" + JO.get("daily") + "\n" +
                                "pmp10" + JO.get("pmp10") + "\n" +
                                "o3" + JO.get("o3") + "\n" +
                                "uvi" + JO.get("uvi");
                        dataParsed = dataParsed + singleParsed;
                    }

                }
            }



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Act2.data.setText(this.dataParsed);
    }
}
