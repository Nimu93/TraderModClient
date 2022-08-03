package com.nimu.tradermodclient.json;



import com.google.gson.Gson;
import com.nimu.tradermodclient.utils.ItemSell;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.List;

public class JsonItemSellLoader {
    public static List<ItemSell> LoadItems(String s) {
        try {
            JSONArray json = (JSONArray) (new JSONParser()).parse(s);
            ArrayList<ItemSell> res = new ArrayList<ItemSell>();
            Gson gson = new Gson();
            for (int i = 0; i < json.size(); i++) {
                res.add(gson.fromJson(json.get(i).toString(), ItemSell.class));
            }
            return res;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    return null;
    }
}

