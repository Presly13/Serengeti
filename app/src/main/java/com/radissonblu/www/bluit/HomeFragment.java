package com.radissonblu.www.bluit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.

 */
public class HomeFragment extends Fragment {

    GridView gridView;
    String[] shoeNames = {"Nike Aptare SE Lifestyle Shoes","Converse One Star Ox Retro Shoes","Nike Cortez Ultra Moire","Nike Flight Bonafide Lifestyle Shoes","Nike Lebron Soldier XI SFG Safari","Converse Chuck Taylor '70 Prep Embroidery"};
    int[] shoeImages = {R.drawable.nike_aptare_se_lifestyle_shoes,R.drawable.converse_one_star_ox_retro_shoes,R.drawable.nike_cortez_ultra_moire,R.drawable.nike_flight_bonafide_lifestyle_shoes,R.drawable.nike_lebron_soldier_xi_sfg_safari,R.drawable.converse_chuck_taylor_70_prep_embroidery};





    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        gridView = root.findViewById(R.id.gridview1);

        ArrayAdapter adapter = new ArrayAdapter(getActivity(),R.layout.row_data,R.id.gridviewdata, shoeNames);

        gridView.setAdapter(adapter);
        CustomAdapter customAdapter = new CustomAdapter();
        gridView.setAdapter(customAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(),GridItemActivity.class);
                intent.putExtra("name",shoeNames[position]);
                intent.putExtra("image",shoeImages[position]);
                startActivity(intent);
            }
        });



        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
        private class CustomAdapter extends BaseAdapter {
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

        }
}
