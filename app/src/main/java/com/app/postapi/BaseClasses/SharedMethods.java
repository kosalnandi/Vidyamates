package com.app.postapi.BaseClasses;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.app.postapi.Utils.AppData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;

//use this class to write methods, which are used in many other classes
public class SharedMethods {


    public static boolean isSuccess(String response, Context mContext) {
        if (response != null) {
            try {
                Log.d(mContext.getClass().getSimpleName(), "response: " + response.toString());

                JSONObject jsonObject = new JSONObject(response);
                if (jsonObject.getInt(AppData.result) == 1) {
                    return true;
                } else {
                    Toast.makeText(mContext, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                    return false;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(mContext, "No response from server. Please try again", Toast.LENGTH_SHORT).show();
        }

        return false;
    }


    public static JSONArray getDataArray(String response, Activity activity) {
        JSONArray jsonArray = null;
        if (response != null) {
            try {
                Log.d(activity.getClass().getSimpleName(), "response: " + response);
                JSONObject jsonObject = new JSONObject(response);

                if (jsonObject.getInt(AppData.result) == 1) {
                    jsonArray = jsonObject.getJSONArray(AppData.data);

                    if (jsonArray.length() > 0) {
                        return jsonArray;
                    } else {
                        Toast.makeText(activity, "Data not available", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(activity, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                Toast.makeText(activity, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        } else {

            Toast.makeText(activity, "No response from server. Please try again", Toast.LENGTH_SHORT).show();
        }
        return jsonArray;
    }

    public static String encodeImageBitmap(Bitmap bm) {
        String encImage = "";
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bm.compress(Bitmap.CompressFormat.JPEG, 50, baos);
            byte[] b = baos.toByteArray();
            encImage = Base64.encodeToString(b, Base64.DEFAULT);

        } catch (Exception e) {
            Log.d("SalonHomeActivity", "encodeImage: " + e.getMessage());
        }
        return encImage;
    }

//    public static void openSearch(Activity activity, ArrayList<String> name_list, int container_view_id, String title) {
//        try {
//            if (name_list.size() > 0) {
//                Bundle bundle = new Bundle();
//                bundle.putStringArrayList("name_list", name_list);
//                bundle.putString("title", title);
//                //bundle.putStringArrayList("code_list", biler_code_list);
//
//                Fragment fragment = new SearchFragment();
//                fragment.setArguments(bundle);
//
//                FragmentTransaction transaction = activity.getFragmentManager().beginTransaction();
//                transaction.replace(container_view_id, fragment); // fragmen container id in first parameter is the  container(Main layout id) of Activity
//                transaction.addToBackStack(null);  // this will manage backstack
//                transaction.commit();
//            } else {
//                Toast.makeText(activity, "No data found", Toast.LENGTH_SHORT).show();
//            }
//        } catch (Exception e) {
//            Toast.makeText(activity, e.getMessage(), Toast.LENGTH_SHORT).show();
//        }
//    }

//    public static void openSearch(Activity activity, ArrayList<String> name_list, int container_view_id, String title) {
//        try {
//            if (name_list.size() > 0) {
//                Bundle bundle = new Bundle();
//                bundle.putStringArrayList("name_list", name_list);
//                bundle.putString("title", title);
//                //bundle.putStringArrayList("code_list", biler_code_list);
//
//                Fragment fragment = new SearchFragment();
//                fragment.setArguments(bundle);
//
//                FragmentTransaction transaction = activity.getFragmentManager().beginTransaction();
//                transaction.replace(container_view_id, fragment); // fragmen container id in first parameter is the  container(Main layout id) of Activity
//                transaction.addToBackStack(null);  // this will manage backstack
//                transaction.commit();
//            } else {
//                Toast.makeText(activity, "No data found", Toast.LENGTH_SHORT).show();
//            }
//        } catch (Exception e) {
//            Toast.makeText(activity, e.getMessage(), Toast.LENGTH_SHORT).show();
//        }
//    }
}
