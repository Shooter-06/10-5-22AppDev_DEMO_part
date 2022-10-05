package com.example.a10_5_22appdev;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ConvertCurrencyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConvertCurrencyFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ConvertCurrencyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ConvertCurrencyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ConvertCurrencyFragment newInstance(String param1, String param2) {
        ConvertCurrencyFragment fragment = new ConvertCurrencyFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    Button result;
    TextView CAD, USD;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_convert_currency, container, false);

        result=(Button) rootView.findViewById(R.id.button);
        USD=(EditText) rootView.findViewById(R.id.editTextTextPersonName);
        CAD=(EditText) rootView.findViewById(R.id.editTextTextPersonName2);

        String usaDollars =USD.getText().toString();

        double usd = Double.parseDouble(usaDollars);

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(USD.equals(null)){
                    Toast.makeText(getContext(), "You can't convert null USD dollars", Toast.LENGTH_LONG )
                            .show();
                }else{
                    double res = usd * 1.35;
                    CAD.setText(String.valueOf(res));
                }
            }
        });
        return rootView;
    }
}