package com.bit.lv.bitndt3;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListFragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import com.eurosonic.eurosonicut.EurosonicUT;
import com.eurosonic.eurosonicut.EurosonicUTCard;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by lv on 2016/3/16.
 */
public class DeviceListFragment extends ListFragment {

    private List<String> devices=new ArrayList<>();
    View mContentView=null;


    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        for (int i=0;i<10;i++){
            devices.add("UTC_"+i);
        }
        DeviceAdapter adapter=new DeviceAdapter(getActivity(), R.layout.row_devices,devices);
        this.setListAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        mContentView=inflater.inflate(R.layout.list_devices,container,false);
        return mContentView;
    }

    public void onListItemClick(ListView parent,View v,int position,long id){
        super.onListItemClick(parent, v, position, id);
        String device=getListAdapter().getItem(position).toString();
        dialog(device);

    }

    private void dialog(final String device){
        DialogInterface.OnClickListener dialogOnClickListener=new DialogInterface.OnClickListener(){

            private final Context cont=getActivity();

            @Override
        public void onClick(DialogInterface dialog,int which){
                switch (which){
                    case Dialog.BUTTON_POSITIVE:
                        Toast.makeText(cont,"连接"+device,Toast.LENGTH_SHORT).show();
                        break;
                    case Dialog.BUTTON_NEGATIVE:
                        Toast.makeText(cont,"取消"+device,Toast.LENGTH_SHORT).show();
                        break;
                    case Dialog.BUTTON_NEUTRAL:
                        Toast.makeText(cont,"忽略"+device,Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle("提示");
        builder.setMessage("是否连接" + device + "?");
        builder.setIcon(R.mipmap.prompt);
        builder.setPositiveButton("连接", dialogOnClickListener);
        builder.setNegativeButton("取消", dialogOnClickListener);
        builder.setNeutralButton("忽略", dialogOnClickListener);
        builder.create().show();
    }


}

