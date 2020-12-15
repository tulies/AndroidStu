package com.tulies.androidstu.utils;

import android.app.Application;
import android.util.Log;

import com.tulies.androidstu.BaseApplication;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JSONUtil {
    public static JSONObject jsonFileToJSONObject(String jsonPath){
        try {
            InputStream inputStream = BaseApplication.context.getResources().getAssets().open(jsonPath);
            // 读取JSON文件流
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"utf8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String temp = "";
            String jsonSource = "";
            //一行一行的读取
            while ((temp = bufferedReader.readLine()) != null)
            {
                jsonSource += temp;
            }
            //关闭
            bufferedReader.close();
            inputStream.close();
            // JSON解析对象
            JSONObject jsonObject = new JSONObject(jsonSource);
            return jsonObject;
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
    public static JSONArray jsonFileToJSONArray(String jsonPath){
        try {
            InputStream inputStream = BaseApplication.context.getResources().getAssets().open(jsonPath);
            // 读取JSON文件流
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"utf8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String temp = "";
            String jsonSource = "";
            //一行一行的读取
            while ((temp = bufferedReader.readLine()) != null)
            {
                jsonSource += temp;
            }
            //关闭
            bufferedReader.close();
            inputStream.close();
            // JSON解析对象
            JSONArray jsonArray = new JSONArray(jsonSource);
            return jsonArray;
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
