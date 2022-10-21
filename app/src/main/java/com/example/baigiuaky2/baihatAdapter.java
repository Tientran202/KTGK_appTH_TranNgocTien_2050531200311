package com.example.baigiuaky2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.List;

public class baihatAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<baiHat> baiHatList;

    public baihatAdapter(Context context, int layout, List<baiHat> monAnList) {
        this.context = context;
        this.layout = layout;
        this.baiHatList = monAnList;
    }

    @Override
    public int getCount() {

        return baiHatList.size();
    }

    @Override
    public Object getItem(int i)
    {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);

        //ánh xạ view
        TextView txtten = (TextView) view.findViewById(R.id.tenbaihat);
        TextView txtmota = (TextView) view.findViewById(R.id.motabaihat);
        ImageView imgmonan = (ImageView) view.findViewById(R.id.anhbaihat);

        //gán giá trị
        baiHat baihat = baiHatList.get(i);
        txtten.setText(baihat.getTen());
        txtmota.setText(baihat.getMota());
        imgmonan.setImageResource(baihat.getAnh());

        return view;
    }
}



