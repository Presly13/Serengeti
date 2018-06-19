package com.radissonblu.www.bluit;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    String[] shoeNames = {"Nike Aptare SE Lifestyle Shoes","Converse One Star Ox Retro Shoes","Nike Cortez Ultra Moire","Nike Flight Bonafide Lifestyle Shoes","Nike Lebron Soldier XI SFG Safari","Converse Chuck Taylor '70 Prep Embroidery"};
    int[] shoeImages = {R.drawable.nike_aptare_se_lifestyle_shoes,R.drawable.converse_one_star_ox_retro_shoes,R.drawable.nike_cortez_ultra_moire,R.drawable.nike_flight_bonafide_lifestyle_shoes,R.drawable.nike_lebron_soldier_xi_sfg_safari,R.drawable.converse_chuck_taylor_70_prep_embroidery};

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private HomeFragment homeFragment;
    private DiscoverFragment discoverFragment;
    private ProfileFragment profileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridview1);
/*
        CustomAdapter customAdapter = new CustomAdapter();
        gridView.setAdapter(customAdapter);*/
/*

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),GridItemActivity.class);
                intent.putExtra("name",shoeNames[position]);
                intent.putExtra("image",shoeImages[position]);
                startActivity(intent);
            }
        });
*/


        mMainFrame = (FrameLayout) findViewById(R.id.main_frame);
        mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);

        homeFragment = new HomeFragment();
        discoverFragment = new DiscoverFragment();
        profileFragment = new ProfileFragment();

       // setFragment(homeFragment);

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.nav_home :
                        mMainNav.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(homeFragment);
                        return true;

                    case R.id.nav_discover :
                        mMainNav.setItemBackgroundResource(R.color.colorPrimaryDark);
                        setFragment(discoverFragment);
                        return true;

                    case R.id.nav_profile :
                        mMainNav.setItemBackgroundResource(R.color.colorPrimaryDark);
                        setFragment(profileFragment);
                        return true;

                        default:
                            return false;


                }
            }

            private void setFragment(Fragment fragment) {

                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_frame, fragment);
                fragmentTransaction.commit();
            }
        });
    }
/*
    private class CustomAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return shoeImages.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            @SuppressLint("ViewHolder") View view1 = getLayoutInflater().inflate(R.layout.row_data,null);

            TextView name = view1.findViewById(R.id.shoeText1);
            ImageView image =view1.findViewById(R.id.shoeImage1);

            name.setText(shoeNames[position]);
            image.setImageResource(shoeImages[position]);
            return view1;
        }
    }*/
}
