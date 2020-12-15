package com.tulies.androidstu.ui.dashboard;

import android.content.ComponentName;
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
import com.tulies.androidstu.ui.example.ExampleTextView;
import com.tulies.androidstu.utils.JSONUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
        JSONArray jsonArray = JSONUtil.jsonFileToJSONArray("example.json");
        if(jsonArray!= null){
            LinearLayout linearLayout = (LinearLayout) root.findViewById(R.id.rootLayout);
            for (int i = 0; i < jsonArray.length(); i++) {
                try {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    Button button = new Button(this.getContext());
                    button.setText(jsonObject.getString("name"));
                    button.setTag(jsonObject);
                    linearLayout.addView(button);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            try {
                                Intent intent = new Intent();
                                JSONObject tagObj =  (JSONObject) view.getTag();
//                                intent.setClass(DashboardFragment.this.getContext(), Class.forName(tagObj.getString("clazz")));
                                intent.setComponent(new ComponentName(DashboardFragment.this.getContext(), tagObj.getString("clazz")));
                                startActivity(intent);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return root;
    }
}