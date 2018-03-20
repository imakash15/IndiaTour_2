package we3infotech.indiatour.com.indiatour.Himachal;

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


public class Hp extends AppCompatActivity {
    private RecyclerView rvList;
    private HpAdapter hpAdapter;
    private ArrayList<HpList> hpLists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hp);
        initView();
    }
    private void initView() {

        if (isNetworkAvailable()) {
            AsyncPost asyncPost = new AsyncPost(Hp.this, new ResponseListener() {
                @Override
                public void onResponse(String result) {
                    Log.d("JD", "getRespne = " + result);
                    try {
                        JSONArray jsonArray = new JSONArray(result);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject e = jsonArray.getJSONObject(i);
                            HpList hpList = new HpList();
                            hpList.setName(e.getString("name"));
                            hpList.setDescription(e.getString("description"));
                            hpList.setPrice(e.getString("price"));
                            hpList.setImageUrl(e.getString("imageUrl"));
                            hpList.setMinOrder(e.getString("minOrder"));
                            hpList.setMenu(e.getString("menu"));
                            hpLists.add(hpList);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    rvList = (RecyclerView) findViewById(R.id.rvList);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                    rvList.setLayoutManager(layoutManager);
                    hpAdapter = new HpAdapter(getApplication(), hpLists);
                    rvList.setAdapter(hpAdapter);
                    hpAdapter.setOnClickListner(new HpAdapter.OnItemClickListener() {
                        @Override
                        public void OnItemClick(int position) {
                            Intent intent = new Intent(Hp.this,OnItemClic.class);
                            intent.putExtra("id",hpLists.get(position).getPrice());
                            intent.putExtra("name",hpLists.get(position).getName());
                            intent.putExtra("desc",hpLists.get(position).getDescription());
                            intent.putExtra("menu",hpLists.get(position).getMenu());
                            intent.putExtra("imageurl",hpLists.get(position).getImageUrl());
                            startActivity(intent);
                        }
                    });

                }
            }, true);
            asyncPost.execute("https://we3infotech.com/IndiaTour/hp.php");
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
