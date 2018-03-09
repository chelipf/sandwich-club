package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    private static final String TAG = JsonUtils.class.getSimpleName();

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject sandwichJson = new JSONObject(json);
            JSONObject nameJson = sandwichJson.getJSONObject("name");

            String mainName = nameJson.getString("mainName");

            JSONArray alsoKnownAsJson = nameJson.getJSONArray("alsoKnownAs");
            List<String> alsoKnownAs = new ArrayList<>();
            for (int i = 0; i < alsoKnownAsJson.length(); i++) {
                alsoKnownAs.add(alsoKnownAsJson.getString(i));
            }

            String placeOfOrigin = sandwichJson.getString("placeOfOrigin");
            String description = sandwichJson.getString("description");
            String image = sandwichJson.getString("image");

            JSONArray ingredientsJson = sandwichJson.getJSONArray("ingredients");
            List<String> ingredients = new ArrayList<>();
            for (int i = 0; i < ingredientsJson.length(); i++) {
                ingredients.add(ingredientsJson.getString(i));
            }

            Sandwich sandwich = new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);

            return sandwich;
        } catch (JSONException e) {
            Log.w(TAG, "Json parser has failed.");

            return null;
        }
    }
}
