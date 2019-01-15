package com.example.pedro.nosurf;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private AlertDialog alerta;
    private SwipeRefreshLayout swipeContainer;

    private final String android_version_names[] = {
            "Capao da canoa",
            "Cal",
            "Molhes",
            "Rosa Norte",
            "Rosa Sul",
            "Tramandai"
    };
    private final String temperatura[] = {
            "18º",
            "21º",
            "19º",
            "12º",
            "11º",
            "8º"
    };

    private final String vento[] = {
            "6 km/h",
            "15 km/h",
            "8 km/h",
            "10 km/h",
            "7 km/h",
            "3 km/h"
    };

    private final  String ondas[] = {
            "L 0,5m a 1m",
            "L/ND 0,5m a 1m",
            "L 0,5m",
            "S/SD - de 0,5m",
            "L/ND 0,5m a 1m",
            "L 0,5m"
    };

    private final String android_image_urls[] = {
            "capaodacanoa.jpg",
            "praiacal.jpg",
            "molhes.jpg",
            "rosa_norte.jpg",
            "rosa_sul.jpg",
            "tramandai.jpg"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        initViews();
    }
    private void initViews(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),1);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Praias> androidVersions = prepareData();
        DataAdapter adapter = new DataAdapter(getApplicationContext(),androidVersions);
        recyclerView.setAdapter(adapter);

    }
    private ArrayList<Praias> prepareData(){

        ArrayList<Praias> android_version = new ArrayList<>();
        for(int i=0;i<android_version_names.length;i++){
            Praias androidVersion = new Praias();
            androidVersion.setAndroid_version_name(android_version_names[i]);
            androidVersion.setTemperatura(temperatura[i]);
            androidVersion.setOnda(ondas[i]);
            androidVersion.setVento(vento[i]);
            androidVersion.setAndroid_image_url(android_image_urls[i]);
            android_version.add(androidVersion);
        }
        return android_version;
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
            Context context;
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(Html.fromHtml("<b> Sobre o Aplicativo No Surf </b>"));
            builder.setMessage(Html.fromHtml("Esse Aplicativo foi desenvolvido por <a href=http://www.jarpdev.com.br>Pedro Bertucci</a>" +
                    "<br><br> Publicidade feita por <a href=http://www.athospublicidade.com.br> Athos Publicidade</a>"));
            alerta = builder.create();
            alerta.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
