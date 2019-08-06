package com.example.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;

import android.os.Bundle;

import com.example.mvvm.databinding.ActivityGardenBinding;
import com.google.android.material.appbar.AppBarLayout;

import static androidx.navigation.ui.NavigationUI.setupActionBarWithNavController;

public class GardenActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private AppBarLayout appBarLayout;
    private AppBarConfiguration appBarConfiguration;
    private NavController navController;
    private ActivityGardenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garden);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_garden);
        drawerLayout = binding.drawerLayout;
        appBarLayout = binding.appBar;

        appBarConfiguration = new AppBarConfiguration.Builder()
                .setDrawerLayout(drawerLayout)
                .build();

        navController = Navigation.findNavController(this, R.id.garden_nav_fragment);

        // Set up ActionBar
        setSupportActionBar(binding.toolbar);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp() || super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
