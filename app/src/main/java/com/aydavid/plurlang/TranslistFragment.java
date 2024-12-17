package com.aydavid.plurlang;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.*;
import android.os.Bundle;


public class TranslistFragment extends Fragment {

    public TranslistFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_translist, container, false);

        // Add code here to set up the view for the TranslistFragment

        return rootView;
    }
}
