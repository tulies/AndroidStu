package com.tulies.androidstu.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.tulies.androidstu.R;
import com.tulies.androidstu.example.ExampleTextView;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
//        final TextView textView = root.findViewById(R.id.text_dashboard);
//        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        LinearLayout linearLayout = (LinearLayout) root.findViewById(R.id.rootLayout);
        for(int i =0; i< 10; i++){
            Button button = new Button(this.getContext());
            button.setText("button"+i);
            button.setTag("button"+i);
            linearLayout.addView(button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                   String btnName =  (String) view.getTag();
                   switch (btnName){
                       case "button1":
                           Log.i("btn-click","btn1111111");
                           intent.setClass(DashboardFragment.this.getContext(), ExampleTextView.class);
                           startActivity(intent);
                           break;
                   }
                }
            });
        }
        return root;
    }
}