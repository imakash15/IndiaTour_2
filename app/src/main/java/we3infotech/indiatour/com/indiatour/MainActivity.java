package we3infotech.indiatour.com.indiatour;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import we3infotech.indiatour.com.indiatour.Delhi.Delhi;
import we3infotech.indiatour.com.indiatour.Gujarat.Gj;
import we3infotech.indiatour.com.indiatour.Haryana.Haryana;
import we3infotech.indiatour.com.indiatour.Himachal.Hp;
import we3infotech.indiatour.com.indiatour.Jammu.Jk;
import we3infotech.indiatour.com.indiatour.Maharastra.Mh;
import we3infotech.indiatour.com.indiatour.Northpack.North;
import we3infotech.indiatour.com.indiatour.Rajasthan.Rj;
import we3infotech.indiatour.com.indiatour.UK.Uk;
import we3infotech.indiatour.com.indiatour.Up.up;
import we3infotech.indiatour.com.indiatour.Westbanga.Wb;
import we3infotech.indiatour.com.indiatour.assam.Assam;
import we3infotech.indiatour.com.indiatour.oddisa.Oddisa;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,tv10, tv11, tv12,tv13;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
/*

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/

        tv1 = (TextView)findViewById(R.id.tvmp);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, North.class);
                startActivity(i);
            }
        });

        tv2 = (TextView)findViewById(R.id.tvup);
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, up.class);
                startActivity(i);
            }
        });

        tv3 = (TextView)findViewById(R.id.tvgujrat);
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Gj.class);
                startActivity(i);
            }
        });

        tv4 = (TextView)findViewById(R.id.tvdelhi);
        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Delhi.class);
                startActivity(i);
            }
        });

        tv5 = (TextView)findViewById(R.id.tvharyana);
        tv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Haryana.class);
                startActivity(i);
            }
        });

        tv5 = (TextView)findViewById(R.id.tvmh);
        tv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Mh.class);
                startActivity(i);
            }
        });

        tv6 = (TextView)findViewById(R.id.tvwb);
        tv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Wb.class);
                startActivity(i);
            }
        });

        tv7 = (TextView)findViewById(R.id.tvuk);
        tv7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Uk.class);
                startActivity(i);
            }
        });

        tv8 = (TextView)findViewById(R.id.tvrj);
        tv8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Rj.class);
                startActivity(i);
            }
        });


        tv9 = (TextView)findViewById(R.id.tvassam);
        tv9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Assam.class);
                startActivity(i);
            }
        });


        tv10 = (TextView)findViewById(R.id.tvhp);
        tv10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Hp.class);
                startActivity(i);
            }
        });

        tv11 = (TextView)findViewById(R.id.tvjandk);
        tv11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Jk.class);
                startActivity(i);
            }
        });

        tv12 = (TextView)findViewById(R.id.tvoddisa);
        tv12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Oddisa.class);
                startActivity(i);
            }
        });



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.Rate) {
            // Handle the camera action
            Intent intent = new Intent(Intent.ACTION_VIEW);
            //Try Google play
            intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=we3infotech.indiatour.com.indiatour"));

            startActivity(intent);

        } else if (id == R.id.feedback) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("email"));
            String[] s = {"ceoindotech@gmail.com"};
            intent.putExtra(Intent.EXTRA_EMAIL, s);
            intent.putExtra(Intent.EXTRA_SUBJECT, "Give a Subject");
            intent.putExtra(Intent.EXTRA_TEXT, "");
            intent.setType("message/rfc822");
            Intent chooser = Intent.createChooser(intent, "Launch Email");
            startActivity(chooser);

        } else if (id == R.id.update) {

            Intent intent = new Intent(Intent.ACTION_VIEW);
            //Try Google play
            intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=we3infotech.indiatour.com.indiatour"));

            startActivity(intent);
        } else if (id == R.id.nav_share) {
            Intent si = new Intent(Intent.ACTION_SEND);
            si.setType("text/plain");
            si.putExtra(Intent.EXTRA_TEXT, "IndiaTour is a pocket guide application for vsiting places of india with full guidance about places." +
                    "Download it now");
            si.setPackage("com.whatsapp");
            startActivity(si);
        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
