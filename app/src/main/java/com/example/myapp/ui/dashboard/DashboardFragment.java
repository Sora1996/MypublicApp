package com.example.myapp.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.myapp.R;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private Button button;
    private TextView textView;
    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private EditText editText4;
    private EditText editText5;
    private double result=0;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        button=getActivity().findViewById(R.id.btn1);
        textView=getActivity().findViewById(R.id.tv_result);
        editText1=getActivity().findViewById(R.id.ed1);
        editText2=getActivity().findViewById(R.id.ed2);
        editText3=getActivity().findViewById(R.id.ed3);
        editText4=getActivity().findViewById(R.id.ed4);
        editText5=getActivity().findViewById(R.id.ed5);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getActivity(), "success2",Toast.LENGTH_LONG).show();
                bmath();
                String str=String.format("%.2f", result);
                textView.setText(str);
            }
        });
    }

    public double bmath(){
        double sum=0;
        //double num1=Double.parseDouble(editText1.getText().toString());
        double num1,num2,num3,num4,num5;
        if(editText1.getText().toString().isEmpty()) num1=0;
        else num1=Double.parseDouble(editText1.getText().toString());
        if(editText2.getText().toString().isEmpty()) num2=0;
        else num2=Double.parseDouble(editText2.getText().toString());
        if(editText3.getText().toString().isEmpty()) num3=0;
        else num3=Double.parseDouble(editText3.getText().toString());
        if(editText4.getText().toString().isEmpty()) num4=0;
        else num4=Double.parseDouble(editText4.getText().toString());
        if(editText5.getText().toString().isEmpty()) num5=0;
        else num5=Double.parseDouble(editText5.getText().toString());
        sum = num1 * 10000;
        while(num2>0){
            if(num2>12){
                for(int i=0;i<12;i++){
                    sum +=num4;
                    sum *=(100+num3/12)/100;
                }
            }else{
                for(int i=0;i<num2;i++){
                    sum +=num4;
                    sum *=(100+num3/12)/100;
                }
            }
            num4+=num5;
            num2-=12;
        }
        result=sum /10000;
        //result=num1;
        return result;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

//        final TextView textView = root.findViewById(R.id.tv_result);
//        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
}