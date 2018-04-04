package com.nestedmango.infom;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Sensors extends AppCompatActivity {
    ListView listSens;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensors);
        listSens=(ListView)findViewById(R.id.listSensor);
        List<String>myList=new ArrayList<>();
        myList=senros();
        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myList);

        listSens.setAdapter(itemsAdapter);


    }

    public List<String> senros(){
        SensorManager sManager = (SensorManager) this
                .getSystemService(this.SENSOR_SERVICE);
        List<Sensor> sensorList = sManager.getSensorList(Sensor.TYPE_ALL);

        List sensorNames = new ArrayList();
        for (int i = 0; i < sensorList.size(); i++) {
            sensorNames.add(((Sensor) sensorList.get(i)).getName());
        }
        return sensorNames;

    }
}
