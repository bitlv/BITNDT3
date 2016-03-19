package com.bit.lv.bitndt3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.eurosonic.eurosonicut.EurosonicUTCard;

import java.util.List;

/**
 * Created by lv on 2016/3/17.
 */
public class DeviceAdapter extends ArrayAdapter<String> {

    private int resourceId;

    public DeviceAdapter(Context context,int textViewResourceId,List<String>objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent){
        String device=getItem(position);
        View view;
        ViewHolder viewHolder;
        if(convertView==null){
            view= LayoutInflater.from(getContext()).inflate(resourceId, null);
            viewHolder=new ViewHolder();
            viewHolder.deviceName=(TextView)view.findViewById(R.id.device_name);
            view.setTag(viewHolder);
        }else {
            view=convertView;
            viewHolder=(ViewHolder)view.getTag();
        }
        viewHolder.deviceName.setText(device);
        return view;
    }

    class ViewHolder{
        TextView deviceName;
    }
}
