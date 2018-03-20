package we3infotech.indiatour.com.indiatour.Gujarat;

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


public class Gj extends AppCompatActivity {
    private RecyclerView rvList;
    private GjAdapter gjAdapter;
    private ArrayList<GjLIst> gjLIsts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gj);
        initView();
    }
    private void initView() {

        if (isNetworkAvailable()) {
            AsyncPost asyncPost = new AsyncPost(Gj.this, new ResponseListener() {
                @Override
                public void onResponse(String result) {
                    Log.d("JD", "getRespne = " + result);
                    try {
                        JSONArray jsonArray = new JSONArray(result);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject e = jsonArray.getJSONObject(i);
                            GjLIst gjLIst = new GjLIst();
                            gjLIst.setName(e.getString("name"));
                            gjLIst.setDescription(e.getString("description"));
                            gjLIst.setPrice(e.getString("price"));
                            gjLIst.setImageUrl(e.getString("imageUrl"));
                            gjLIst.setMinOrder(e.getString("minOrder"));
                            gjLIst.setMenu(e.getString("menu"));
                            gjLIsts.add(gjLIst);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    rvList = (RecyclerView) findViewById(R.id.rvList);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                    rvList.setLayoutManager(layoutManager);
                    gjAdapter = new GjAdapter(getApplication(), gjLIsts);
                    rvList.setAdapter(gjAdapter);
                    gjAdapter.setOnClickListner(new GjAdapter.OnItemClickListener() {
                        @Override
                        public void OnItemClick(int position) {
                            Intent intent = new Intent(Gj.this,OnItemClic.class);
                            intent.putExtra("id",gjLIsts.get(position).getPrice());
                            intent.putExtra("name",gjLIsts.get(position).getName());
                            intent.putExtra("desc",gjLIsts.get(position).getDescription());
                            intent.putExtra("menu",gjLIsts.get(position).getMenu());
                            intent.putExtra("imageurl",gjLIsts.get(position).getImageUrl());
                            startActivity(intent);
                        }
                    });

                }
            }, true);
            asyncPost.execute("https://we3infotech.com/IndiaTour/gj.php");
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
