package com.rsm.stelarbank;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

// Vista principal
// Muestra textos, imagenes, botones con diferentes opciones
// Incluye icono sup. izq. para desplegar menu lateral
public class MainActivity2 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Contenedor principal
        setContentView(R.layout.activity_main2);

        // Barra de herramientas
        Toolbar toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        // menu lateral deslizable
        drawer = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }


    // Se configuran las acciones al seleccionar las opciones del menu
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.nav_item_one){
            //Toast.makeText(getApplicationContext(), "Item 1", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity2.this, MiCuenta.class);
            startActivity(intent);
        }
        if(item.getItemId() == R.id.nav_item_two){
            //Toast.makeText(getApplicationContext(), "Item 2", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity2.this, Transferencias.class);
            startActivity(intent);
        }
        if(item.getItemId() == R.id.nav_item_three){
            //Toast.makeText(getApplicationContext(), "Item 3", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity2.this, Inversiones.class);
            startActivity(intent);
        }

        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        toggle.syncState();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}