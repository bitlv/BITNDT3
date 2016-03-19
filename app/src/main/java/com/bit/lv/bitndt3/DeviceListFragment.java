package com.bit.lv.bitndt3;

import android.app.ListFragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


import com.eurosonic.eurosonicut.EurosonicUT;
import com.eurosonic.eurosonicut.EurosonicUTCard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lv on 2016/3/16.
 */
public class DeviceListFragment extends ListFragment {

    private List<String> devices=new ArrayList<>();
    View mContentView=null;


    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        for (int i=0;i<30;i++){
            devices.add("symh"+i);
        }
        ArrayAdapter<String>  adapter=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,devices);
        this.setListAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        mContentView=inflater.inflate(R.layout.list_devices,container,false);
        return mContentView;
    }


}

