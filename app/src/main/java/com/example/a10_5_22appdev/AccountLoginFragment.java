package com.example.a10_5_22appdev;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AccountLoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AccountLoginFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AccountLoginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AccountLoginFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AccountLoginFragment newInstance(String param1, String param2) {
        AccountLoginFragment fragment = new AccountLoginFragment();
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

    EditText username, password;
    Button signIn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_account_login, container, false);

        username=(EditText) rootView.findViewById(R.id.editTextTextPersonName);
        password=(EditText) rootView.findViewById(R.id.editTextTextPersonName2);
        signIn=(Button) rootView.findViewById(R.id.button);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = "TRGY";
                String pass = "23GY";
                if(username.getText().toString().equals(user) && password.getText().toString().equals(pass)){
                    Snackbar snack = Snackbar.make(view, "Successfully Logged In!",
                            Snackbar.LENGTH_INDEFINITE);
                    snack.setAction("close", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            snack.dismiss();
                        }
                    }).setActionTextColor(getResources().getColor(android.R.color.holo_red_dark)).show();
                }else{
                    Toast.makeText(getContext(), "Please Enter Valid Inputs", Toast.LENGTH_LONG).show();
                }
            }
        });
        return rootView;
    }
}