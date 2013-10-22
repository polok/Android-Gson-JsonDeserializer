package com.learning.gsonexample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;

/*
* Simple project which demonstrates how to parse json data when the same tag can contains array of objects or
* be just a simple object, not an array.
*/
public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String text = loadJsonDataFromRaw();

        //build gson with custom deserializer
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Event.class, new CustomDeserializer())
                .create();

        JsonData d = gson.fromJson(text, JsonData.class);
    }

    private String loadJsonDataFromRaw() {
        InputStream input;
        byte[] reader = null;
        try {
            input = getResources().openRawResource(R.raw.data);
            reader = new byte[input.available()];
                while (input.read(reader) != -1) {
            }
            input.close();
        } catch (IOException e) {
            Log.e(TAG, e.getMessage());
            e.printStackTrace();
        }
        return new String(reader);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
