package com.example.newyorktimes.view;

import android.app.Fragment;
import android.app.FragmentTransaction;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import com.arellomobile.mvp.MvpActivity;
import com.example.newyorktimes.R;
import com.example.newyorktimes.view.Fragments.FavoritesFragment;
import com.example.newyorktimes.view.Fragments.FragmentFix;
import com.example.newyorktimes.view.Fragments.NewsFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoadFragment(NewsFragment.getInstance());

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.item_news:
                        LoadFragment(NewsFragment.getInstance());
                        return true;
                    case R.id.fix:
                        LoadFragment(FragmentFix.getFragmentFix());
                        return true;
                    case R.id.favorites:
                        LoadFragment(FavoritesFragment.getFavoritesFragment());
                        return true;
                }
                return false;
            }
        });
    }

        public void LoadFragment (Fragment fragment){
            FragmentTransaction ft;
            ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.main_frame_layout, fragment);
            ft.commit();
        }
}
