package com.app.postapi.Utils;

import android.content.Context;
import android.content.Intent;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class IntentController {

    public static void sendIntent(Context context1, Class<?> cls){
        context1.startActivity(makeIntent(context1,cls));
    }

    public static <T extends Object> Intent makeIntent(Context context1, Class<?> cls, Map<String,T> map){
        Intent intent = new Intent(context1, cls);
        for (Map.Entry<String,T> entry: map.entrySet()){
            try {
                intent.putExtra(entry.getKey(), Serializer.serialize(entry.getValue()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP| Intent.FLAG_ACTIVITY_NEW_TASK);
        return intent;
    }

    public static Intent makeIntent(Context context1, Class<?> cls){
        Intent intent = new Intent(context1, cls);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP| Intent.FLAG_ACTIVITY_NEW_TASK);
        return intent;
    }

    public static <T extends Object> void sendIntent(Context context1, Class<?> cls, Map<String,T> map){
        context1.startActivity(makeIntent(context1,cls,map));
    }

    public static Object receiveIntent(Intent intent, String key){
        try {
            return Serializer.deserialize(intent.getExtras().getByteArray(key));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static class CustomHashMap extends HashMap {

        public<T extends Object> CustomHashMap put(String key, T value) {
            super.put(key, value);
            return CustomHashMap.this;
        }
    }



   /* public static void sendIntent(Context context1, Class<?> cls, String key, String value){
        Intent intent = new Intent(context1, cls);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra(key, value);
        context1.startActivity(intent);
    }

    public static void sendIntent(Context context1, Class<?> cls, String key, byte[] byteObject){
        Intent intent = new Intent(context1, cls);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra(key, byteObject);
        context1.startActivity(intent);
    }

    public static void sendIntent(Context context1, Class<?> cls, String key, String value, byte[] byteObject){
        Intent intent = new Intent(context1, cls);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra(key, value);
        intent.putExtra(key, byteObject);
        context1.startActivity(intent);
    }

    public static void sendIntent(Context context1, Class<?> cls, String key1, int value, String key2, byte[] byteObject){
        Intent intent = new Intent(context1, cls);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra(key1, value);
        intent.putExtra(key2, byteObject);
        context1.startActivity(intent);
    }*/



}
