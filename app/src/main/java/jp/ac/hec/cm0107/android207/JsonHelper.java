package jp.ac.hec.cm0107.android207;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonHelper {
    public static ArrayList<Student> parseJson(String strJson){
        ArrayList<Student> list = new ArrayList<>();
        try{
            JSONObject json = new JSONObject(strJson);
            JSONObject feed = json.getJSONObject("cmStudents");
            JSONArray entries = feed.getJSONArray("list");
            for(int i = 0; i < entries.length();i++) {
                JSONObject entry = entries.getJSONObject(i);
                list.add(parseToStudent(entry));
            }
        }catch (Exception e) {
            Log.e("JsonHelper", e.getMessage());
        }
            return list;
        }
            public static Student parseToStudent (JSONObject json) throws JSONException {
                Student tmp = new Student();
                tmp.setId(json.getString("id"));
                tmp.setName(json.getString("name"));
                tmp.setAge(json.getInt("age"));
                tmp.setHasOCJP(json.getBoolean("hasOCJP"));

                JSONObject info = json.getJSONObject("info");
                tmp.setLike(info.getString("like"));
                tmp.setFood(info.getString("food"));
                tmp.setGame(info.getString("game"));
                tmp.setHp(info.getString("hp"));
                return tmp;
            }
        }