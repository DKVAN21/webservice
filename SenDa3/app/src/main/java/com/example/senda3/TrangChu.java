package com.example.senda3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class TrangChu extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    DangNhapResponse dangNhapResponse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_container , new HomeFragment()).commit();
        bottomNavigationView.setSelectedItemId(R.id.nav_home);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.nav_location:
                        fragment = new LocationFragment();
                        break;
                    case R.id.nav_cart:
                        fragment = new CartFragment();
                        break;
                    case R.id.nav_account:
                        fragment = new AccountFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.main_container , fragment).commit();

                return true;
            }
        });

        Intent intent = getIntent();
        if(intent.getExtras() != null){
            dangNhapResponse = (DangNhapResponse) intent.getSerializableExtra("data");
            Log.e("Tag", "======>" +dangNhapResponse.getManv());
        }
        }
    }
