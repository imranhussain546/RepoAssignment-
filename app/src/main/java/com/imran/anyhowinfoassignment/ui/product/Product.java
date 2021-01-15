package com.imran.anyhowinfoassignment.ui.product;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.imran.anyhowinfoassignment.adapter.GridAdpater;
import com.imran.anyhowinfoassignment.model.Modelclass;
import com.imran.anyhowinfoassignment.R;

import java.util.ArrayList;
import java.util.List;

public class Product extends Fragment {
    GridView gridView;
    List<Modelclass> productlist=new ArrayList<>();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_product, container, false);
        gridView=view.findViewById(R.id.gridview);








        adddata();
        setadapter();
        return view;
    }



    private void adddata()
    {
        productlist.add(new Modelclass(R.drawable.image1,"Dell I567","Rs:-34509"));
        productlist.add(new Modelclass(R.drawable.image2,"Godrej ","Rs:-20509"));
        productlist.add(new Modelclass(R.drawable.image3,"Sumsung ","Rs:-19990"));
        productlist.add(new Modelclass(R.drawable.image4,"Jens","Rs:-599"));
        productlist.add(new Modelclass(R.drawable.image5,"Addas","Rs:-1599"));
        productlist.add(new Modelclass(R.drawable.image6,"Nice","Rs:-1699"));

    }
    private void setadapter()
    {
        gridView.setAdapter(new GridAdpater(getActivity(),productlist));
    }


}