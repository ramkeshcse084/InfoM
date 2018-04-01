package com.nestedmango.infom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

public class AppAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private List<AppList> listStorage;

    public AppAdapter(Context context, List<AppList> customizedListView) {
        layoutInflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        listStorage = customizedListView;
    }

    @Override
    public int getCount() {
        return listStorage.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder listViewHolder;
        if(convertView == null){
            listViewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.installed_app_list, parent, false);

            listViewHolder.textInListView = (TextView)convertView.findViewById(R.id.list_app_name);
            listViewHolder.imageInListView = (ImageView)convertView.findViewById(R.id.app_icon);
            listViewHolder.txtPakName=(TextView)convertView.findViewById(R.id.textViewPack);
            listViewHolder.txtInListInstDate=(TextView)convertView.findViewById(R.id.textViewInstDate);
            listViewHolder.txtInListUp=(TextView)convertView.findViewById(R.id.textViewLastUp);
            listViewHolder.txtInListVerName=(TextView)convertView.findViewById(R.id.textViewVerName);
            listViewHolder.txtInListVerNum=(TextView)convertView.findViewById(R.id.textViewVeNum) ;
            convertView.setTag(listViewHolder);
        }else{
            listViewHolder = (ViewHolder)convertView.getTag();
        }
        SimpleDateFormat fmt=new SimpleDateFormat( "dd-MM-yyyy");
        listViewHolder.textInListView.setText(listStorage.get(position).getName());
        listViewHolder.imageInListView.setImageDrawable(listStorage.get(position).getIcon());
        listViewHolder.txtInListVerNum.setText(String.valueOf(listStorage.get(position).getVersionCode()+":verCode"));
        listViewHolder.txtInListVerName.setText(listStorage.get(position).getVerName()+":VerName");
        listViewHolder.txtPakName.setText(listStorage.get(position).getPackageName());
        listViewHolder.txtInListUp.setText(fmt.format(listStorage.get(position).getUp()));
        listViewHolder.txtInListInstDate.setText(fmt.format(listStorage.get(position).getInstadate()));


        return convertView;
    }

    static class ViewHolder{

        TextView textInListView;
        ImageView imageInListView;
        TextView txtInListVerNum;
        TextView txtInListVerName;
        TextView txtInListInstDate;
        TextView txtInListUp;
        TextView txtPakName;

    }
}
