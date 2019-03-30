package com.example.listviewor;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private Database db;
    private List<Person> modelList;

    public CustomAdapter(Context context) {
        this.context = context;
        db = new Database(context);
        modelList = db.AllRecordlist();
    }

    @Override
    public int getCount() {
        return modelList.size();
    }

    @Override
    public Object getItem(int position) {
        return modelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return modelList.get(position).getP_id();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Person model = modelList.get(position);

        LinearLayout linearLayout = (LinearLayout) ((Activity) context).getLayoutInflater().inflate(R.layout.custom_listview, null);

        TextView tv_nameSurname = linearLayout.findViewById(R.id.tv_nameSurname);
        TextView tv_email = linearLayout.findViewById(R.id.tv_email);
        TextView tv_adress = linearLayout.findViewById(R.id.tv_adress);


        ImageView ımageView = linearLayout.findViewById(R.id.imgView);
       // ımageView.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), R.drawable.per));
        tv_nameSurname.setText(model.getP_nameSurname());
        tv_email.setText(model.getP_eMail());
        tv_adress.setText(model.getP_adress());


        ımageView.setImageResource(R.drawable.per);
        return linearLayout;
    }
}
