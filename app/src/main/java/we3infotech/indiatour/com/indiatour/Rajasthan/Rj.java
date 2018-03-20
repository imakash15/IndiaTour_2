package we3infotech.indiatour.com.indiatour.Rajasthan;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import we3infotech.indiatour.com.indiatour.Network.AsyncPost;
import we3infotech.indiatour.com.indiatour.Network.ResponseListener;
import we3infotech.indiatour.com.indiatour.OnItemClic;
import we3infotech.indiatour.com.indiatour.R;

public class Rj extends AppCompatActivity {
    private RecyclerView rvList;
    private RjAdapter rjAdapter;
    private ArrayList<RjList> rjLists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rj);
        initView();
    }
    private void initView() {

        if (isNetworkAvailable()) {
            AsyncPost asyncPost = new AsyncPost(Rj.this, new ResponseListener() {
                @Override
                public void onResponse(String result) {
                    Log.d("JD", "getRespne = " + result);
                    try {
                        JSONArray jsonArray = new JSONArray(result);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject e = jsonArray.getJSONObject(i);
                            RjList rjList = new RjList();
                            rjList.setName(e.getString("name"));
                            rjList.setDescription(e.getString("description"));
                            rjList.setPrice(e.getString("price"));
                            rjList.setImageUrl(e.getString("imageUrl"));
                            rjList.setMinOrder(e.getString("minOrder"));
                            rjList.setMenu(e.getString("menu"));
                            rjLists.add(rjList);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    rvList = (RecyclerView) findViewById(R.id.rvList);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                    rvList.setLayoutManager(layoutManager);
                    rjAdapter = new RjAdapter(getApplication(), rjLists);
                    rvList.setAdapter(rjAdapter);
                    rjAdapter.setOnClickListner(new RjAdapter.OnItemClickListener() {
                        @Override
                        public void OnItemClick(int position) {
                            Intent intent = new Intent(Rj.this,OnItemClic.class);
                            intent.putExtra("id",rjLists.get(position).getPrice());
                            intent.putExtra("name",rjLists.get(position).getName());
                            intent.putExtra("desc",rjLists.get(position).getDescription());
                            intent.putExtra("menu",rjLists.get(position).getMenu());
                            intent.putExtra("imageurl",rjLists.get(position).getImageUrl());
                            startActivity(intent);
                        }
                    });

                }
            }, true);
            asyncPost.execute("https://we3infotech.com/IndiaTour/Rj.php");
        } /*else {
            bookTableListArrayList.clear();
            bookTableListArrayList = dbbooktable.getAllContacts();
            rvList = (RecyclerView) findViewById(R.id.rvList);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
            rvList.setLayoutManager(layoutManager);
            bookTableAdapter = new BookTableAdapter(getApplication(), bookTableListArrayList);
            rvList.setAdapter(bookTableAdapter);

            bookTableAdapter.setOnClickListner(new BookTableAdapter.OnItemClickListener() {
                @Override
                public void OnItemClick(int position) {
                    Intent intent = new Intent(BookingTable.this,OnItemClic.class);
                    intent.putExtra("id",bookTableListArrayList.get(position).getPrice());
                    intent.putExtra("name",bookTableListArrayList.get(position).getName());
                    intent.putExtra("desc",bookTableListArrayList.get(position).getDescription());
                    startActivity(intent);
                }
            });
        }*/
        else Toast.makeText(this, "No internet Connection", Toast.LENGTH_SHORT).show();
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
