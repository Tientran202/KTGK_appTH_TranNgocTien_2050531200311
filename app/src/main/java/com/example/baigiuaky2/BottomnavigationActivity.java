package com.example.baigiuaky2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
public class BottomnavigationActivity extends AppCompatActivity {

    ViewPager  vp;
    BottomNavigationView navigationview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottomnavigation);

        //anh xa
         navigationview = findViewById(R.id.bottom_nv);
         vp = findViewById(R.id.view_pg);

        setUpViewPager();

        //su kien
        navigationview.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.action_home:
                    vp.setCurrentItem(0);
                    break;
                case R.id.action_profile:
                    vp.setCurrentItem(1);
                    break;
            }
            return true;
        });
    }
    private void setUpViewPager() {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vp.setAdapter(viewPagerAdapter);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        navigationview.getMenu().findItem(R.id.action_home).setChecked(true);
                        break;
                    case 1:
                        navigationview.getMenu().findItem(R.id.action_profile).setChecked(true);
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}