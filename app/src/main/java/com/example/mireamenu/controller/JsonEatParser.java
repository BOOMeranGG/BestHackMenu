package com.example.mireamenu.controller;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.example.mireamenu.model.listsOfJsonBody.EatList;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.example.mireamenu.Variables.PARSER_LOGGER;

public class JsonEatParser {

    public EatList doParse(Context context, String universityName, String eatName, Class clazz) {
        Gson gson = new Gson();
        String filePath = "menus/" + universityName + "/" + eatName + ".json";
        Log.d(PARSER_LOGGER, "doParse()" + filePath);
        String jsonString = convertJsonToString(filePath, context);
        EatList result = (EatList) gson.fromJson(jsonString, clazz);
        return result;
    }

    private String convertJsonToString(String filePath, Context context) {
        String word;
        StringBuilder result = new StringBuilder();
        Log.d(PARSER_LOGGER, "Start convert" + filePath);
        try {
            AssetManager assetManager = context.getAssets();
            InputStreamReader istream = new InputStreamReader(assetManager.open(filePath));
            BufferedReader in = new BufferedReader(istream);

            while ((word = in.readLine()) != null) {
                result.append(word);
            }
            in.close();
        } catch (FileNotFoundException e) {
            Log.e(PARSER_LOGGER, "FileNotFoundExpeption");
        } catch (IOException e) {
            Log.e(PARSER_LOGGER, "IOExeption");
        }
        Log.d(PARSER_LOGGER, "convert ended");
        return result.toString();
    }
}
