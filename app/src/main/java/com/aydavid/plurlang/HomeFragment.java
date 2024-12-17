package com.aydavid.plurlang;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.*;

import android.os.Bundle;
import android.widget.*;
import android.content.*;
import android.graphics.*;
import android.graphics.drawable.*;
import java.util.*;


public class HomeFragment extends Fragment {

    public HomeFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        // Add code here to set up the view for the HomeFragment
        
        setTextViewsTypeface(rootView);
        populateRecentListens(rootView);
        return rootView;
    }
    public void setTextViewsTypeface(View rootView) { 
      try{
        this.applyCustomFont(getContext(), (ViewGroup) rootView, "fonts/Geological-Regular.ttf");
    	 }catch(Exception e) {Toast.makeText(getContext(), e.toString(), 2000).show();}
    }
    public void applyCustomFont(Context context, ViewGroup parentView, String fontPath) {
        Typeface customTypeface = Typeface.createFromAsset(context.getAssets(), fontPath);

        for (int i = 0; i < parentView.getChildCount(); i++) {
            View childView = parentView.getChildAt(i);

            if (childView instanceof TextView) {
                ((TextView) childView).setTypeface(customTypeface);
            } else if (childView instanceof ViewGroup) {
                applyCustomFont(context, (ViewGroup) childView, fontPath);
            }
        }
    }
    
    public void populateRecentListens(View rootView) { 
    	 try{
          Integer numberOfTabs = 2;
          LinearLayout linearLayout = rootView.findViewById(R.id.linear_layout_tabs);
          LinearLayout tabTemplate = rootView.findViewById(R.id.tab_template); // Existing tab layout to use as a template
          
          
          
          for (int i = 0; i < numberOfTabs; i++) {
              // Clone the tab template
              LinearLayout tabLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(
                  R.layout.recents_tab, linearLayout, false);
              // Customize the cloned tab layout
              ImageView imageView = tabLayout.findViewById(R.id.tab_image);
              //Toast.makeText(getContext(), "imageView", 2000).show();
              TextView textView = tabLayout.findViewById(R.id.tab_name);
              // Customize the ImageView and TextView as needed
              // For example:
              Integer[] icons = {
                R.drawable.colorsplash0, 
                R.drawable.colorsplash1, 
                R.drawable.colorsplash2, 
                R.drawable.colorsplash3, 
                R.drawable.colorsplash4, 
              };
              Integer randomIcon = icons[new Random().nextInt(icons.length)];
              imageView.setImageResource(randomIcon);
              textView.setText("Tab " + (i + 1));
              
              // Add the cloned tab layout to the parent LinearLayout
              linearLayout.addView(tabLayout);
          }
    	  }catch(Exception e) {Toast.makeText(getContext(), e.toString(), 2000).show();}
    }
}