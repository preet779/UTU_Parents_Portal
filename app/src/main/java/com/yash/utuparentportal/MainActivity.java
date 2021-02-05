package com.yash.utuparentportal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bnv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.Framecontainer,new CollegeFragment()).commit();

        bnv=(BottomNavigationView)findViewById(R.id.bottomNavigation);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                Fragment temp = null;
                switch (item.getItemId())
                {
                    case R.id.menu_college : temp = new CollegeFragment();
                        break;
                    case R.id.menu_parent : temp = new ParentFragment();
                        break;
                    case R.id.menu_message : temp = new MessageFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.Framecontainer,temp).commit();
                return true;
            }
        });

    }
}