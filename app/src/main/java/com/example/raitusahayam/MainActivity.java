package com.example.raitusahayam;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fm = getSupportFragmentManager();
    final Fragment dailyFragment = new DailyCommodity();
    final Fragment chatbot = new ChatBotFragment();
    final Fragment settings = new Settings();
    final Fragment realtime = new RealtimeFragment();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_daily:
                    fm.beginTransaction().replace(R.id.container_frame, dailyFragment, "home").commit();
                    return true;
                case R.id.navigation_chatbot:
                    fm.beginTransaction().replace(R.id.container_frame, chatbot, "home").commit();
                    return true;
                case R.id.navigation_settings:
                    fm.beginTransaction().replace(R.id.container_frame, settings, "home").commit();
                    return true;
                case R.id.navigation_realtime:
                    fm.beginTransaction().replace(R.id.container_frame, realtime, "home").commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        fm.beginTransaction().replace(R.id.container_frame, dailyFragment, "Home").commit();
    }

}
