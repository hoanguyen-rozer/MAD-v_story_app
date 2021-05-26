package com.example.vstory.apiservice;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.vstory.model.Category;
import com.example.vstory.model.Chapter;
import com.example.vstory.model.Singleton;
import com.example.vstory.model.Story;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Service {

    private Context context;

    public Service(Context context) {
        this.context = context;
    }

    public interface GetListStoryResponse {
        void onError(String message);
        void onResponse(List<Story> listStory);
    }

    public void getAllStory(GetListStoryResponse getListStoryResponse){
        String url = "http://v-story-api.herokuapp.com/api/stories/";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
//                            Toast.makeText(context, response.toString(), Toast.LENGTH_SHORT).show();
                            JSONArray jsonArrayStory = response.getJSONArray("data");


                            List<Story> listStory = new ArrayList<>();
                            int lenArrStory = jsonArrayStory.length();
                            for(int i = 0; i < lenArrStory; i++){
                                JSONObject jsonStory = jsonArrayStory.getJSONObject(i);
                                Story story = new Story();
                                story.setId(jsonStory.getInt("id"));
                                story.setTitle(jsonStory.getString("title"));
                                story.setAuthor(jsonStory.getString("author"));

                                JSONArray jsonArrayCategory = jsonStory.getJSONArray("category");
                                List<String> categories = new ArrayList<>();
                                for(int j = 0; j < jsonArrayCategory.length(); j++){
                                    String category = jsonArrayCategory.getString(j);
                                    categories.add(category);
                                }
                                story.setCategory(categories);
                                story.setImgUrl(jsonStory.getString("image"));
                                story.setStatus(jsonStory.getString("status"));
                                story.setDescription(jsonStory.getString("description"));
                                story.setDate_update(jsonStory.getString("date_update"));
                                story.setTotal_chapters(jsonStory.getInt("total_chapters"));
                                listStory.add(story);
                            }




                            getListStoryResponse.onResponse(listStory);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, error.toString(), Toast.LENGTH_SHORT).show();
                        getListStoryResponse.onError("Something Wrong");
                    }
                });

        // Access the RequestQueue through your singleton class.
        Singleton.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }

    public void getStoryByCategory(int idCategory, GetListStoryResponse getListStoryResponse){
        String url = "http://v-story-api.herokuapp.com/api/categories/" + idCategory;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject jsonObject = response.getJSONObject("data");

                            JSONArray jsonArrayStory = jsonObject.getJSONArray("stories");
                            List<Story> listStory = new ArrayList<>();
                            int lenArrStory = jsonArrayStory.length();
                            for(int i = 0; i < lenArrStory; i++){
                                JSONObject jsonStory = jsonArrayStory.getJSONObject(i);
                                Story story = new Story();
                                story.setId(jsonStory.getInt("id"));
                                story.setTitle(jsonStory.getString("title"));
                                story.setAuthor(jsonStory.getString("author"));

                                JSONArray jsonArrayCategory = jsonStory.getJSONArray("category");
                                List<String> categories = new ArrayList<>();
                                for(int j = 0; j < jsonArrayCategory.length(); j++){
                                    String category = jsonArrayCategory.getString(j);
                                    categories.add(category);
                                }
                                story.setCategory(categories);
                                story.setImgUrl(jsonStory.getString("image"));
                                story.setStatus(jsonStory.getString("status"));
                                story.setDescription(jsonStory.getString("description"));
                                story.setDate_update(jsonStory.getString("date_update"));
                                story.setTotal_chapters(jsonStory.getInt("total_chapters"));
                                listStory.add(story);
                            }




                            getListStoryResponse.onResponse(listStory);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, error.toString(), Toast.LENGTH_SHORT).show();
                        getListStoryResponse.onError("Something Wrong");
                    }
                });

        // Access the RequestQueue through your singleton class.
        Singleton.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }

    public void searchStory(String str, GetListStoryResponse getListStoryResponse){
        String url = "http://v-story-api.herokuapp.com/api/stories?search=" + str;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
//                            Toast.makeText(context, response.toString(), Toast.LENGTH_SHORT).show();
                            JSONArray jsonArrayStory = response.getJSONArray("data");


                            List<Story> listStory = new ArrayList<>();
                            int lenArrStory = jsonArrayStory.length();
                            for(int i = 0; i < lenArrStory; i++){
                                JSONObject jsonStory = jsonArrayStory.getJSONObject(i);
                                Story story = new Story();
                                story.setId(jsonStory.getInt("id"));
                                story.setTitle(jsonStory.getString("title"));
                                story.setAuthor(jsonStory.getString("author"));

                                JSONArray jsonArrayCategory = jsonStory.getJSONArray("category");
                                List<String> categories = new ArrayList<>();
                                for(int j = 0; j < jsonArrayCategory.length(); j++){
                                    String category = jsonArrayCategory.getString(j);
                                    categories.add(category);
                                }
                                story.setCategory(categories);
                                story.setImgUrl(jsonStory.getString("image"));
                                story.setStatus(jsonStory.getString("status"));
                                story.setDescription(jsonStory.getString("description"));
                                story.setDate_update(jsonStory.getString("date_update"));
                                story.setTotal_chapters(jsonStory.getInt("total_chapters"));
                                listStory.add(story);
                            }




                            getListStoryResponse.onResponse(listStory);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, error.toString(), Toast.LENGTH_SHORT).show();
                        getListStoryResponse.onError("Something Wrong");
                    }
                });

        // Access the RequestQueue through your singleton class.
        Singleton.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }

    public interface GetListChapterResponse{
        void onError(String message);
        void onResponse(List<Chapter> listChapter);
    }

    public void getChapterByStory(int idStory, GetListChapterResponse getListChapterResponse){
        String url = "http://v-story-api.herokuapp.com/api/stories/" + idStory;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject jsonObject = response.getJSONObject("data");

                            JSONArray jsonArrayChapter = jsonObject.getJSONArray("chapters");
                            List<Chapter> listChapter = new ArrayList<>();
                            int lenArrChapter = jsonArrayChapter.length();
                            for(int i = 0; i < lenArrChapter; i++){
                                JSONObject jsonChapter = jsonArrayChapter.getJSONObject(i);
                                Chapter chapter = new Chapter();
                                chapter.setId(jsonChapter.getInt("id"));
                                chapter.setOrder(jsonChapter.getInt("order"));
                                chapter.setName(jsonChapter.getString("name"));
                                chapter.setContent(jsonChapter.getString("content"));
                                listChapter.add(chapter);
                            }




                            getListChapterResponse.onResponse(listChapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, error.toString(), Toast.LENGTH_SHORT).show();
                        getListChapterResponse.onError("Something Wrong");
                    }
                });

        // Access the RequestQueue through your singleton class.
        Singleton.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }

}
