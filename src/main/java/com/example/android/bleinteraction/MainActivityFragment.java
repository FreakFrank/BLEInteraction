package com.example.android.bleinteraction;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import static android.app.Activity.RESULT_OK;
import static android.content.ContentValues.TAG;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    static BluetoothAdapter mBluetoothAdapter;
    static View rootView;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = (View) inflater.inflate(R.layout.fragment_main, container, false);
        final BluetoothManager bluetoothManager =
                (BluetoothManager) inflater.getContext().getSystemService(Context.BLUETOOTH_SERVICE);
        mBluetoothAdapter = bluetoothManager.getAdapter();
        if (mBluetoothAdapter == null || !mBluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, RESULT_OK);
        }
        Button scan = (Button) rootView.findViewById(R.id.scan_button);
        scan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d(TAG, "onClick: whatever");
                Intent intent = new Intent(getActivity(),DeviceScanActivity.class);
                startActivity(intent);
            }
        });
        return inflater.inflate(R.layout.fragment_main, container, false);
    }


}
