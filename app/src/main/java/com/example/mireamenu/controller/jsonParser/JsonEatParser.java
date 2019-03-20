package com.example.mireamenu.controller.jsonParser;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.example.mireamenu.model.FoodList;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.example.mireamenu.Variables.PARSER_LOGGER;

public class JsonEatParser {

    FoodList doParse(Context context, String universityName, String foodName) {
        Gson gson = new Gson();
        String filePath = "menus/" + universityName + "/" + foodName + ".json";
        Log.d(PARSER_LOGGER, "doParse()" + filePath);
        String jsonString = convertJsonToString(filePath, context);
        Log.d(PARSER_LOGGER, "parse ended");
        return gson.fromJson(jsonString, FoodList.class);
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
            Log.e(PARSER_LOGGER, "FileNotFoundException");
        } catch (IOException e) {
            Log.e(PARSER_LOGGER, "IOException");
        }
        return result.toString();
    }
}
