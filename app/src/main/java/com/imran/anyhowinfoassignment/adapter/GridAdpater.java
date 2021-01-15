package com.imran.anyhowinfoassignment.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.imran.anyhowinfoassignment.model.Modelclass;
import com.imran.anyhowinfoassignment.R;

import java.util.List;

public class GridAdpater extends BaseAdapter
{
    List<Modelclass> list;
    Activity activity;

    public GridAdpater(Activity activity,List<Modelclass> list) {
        this.activity=activity;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    @Override
    public View getView(int i, View convertview, ViewGroup viewGroup) {
        View view;
        if (convertview==null)
        {
             view=activity.getLayoutInflater().inflate(R.layout.product,viewGroup,false);
            ImageView pimage=view.findViewById(R.id.productimage);
            TextView pname=view.findViewById(R.id.productname);
            TextView pprice=view.findViewById(R.id.productprice);

            pimage.setImageResource(list.get(i).getImage());
            pname.setText(list.get(i).getProductname());
            pprice.setText(list.get(i).getGetProductprice());
        }
        else
        {
            view=convertview;
        }
        return view;
    }
}
