package com.example.tz1993.w5_p1;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ControlFragment extends Fragment {

    private ListView listMsg;
    private Button btnSend;
    private String sentMsg;
    private int BGpos;

    public ControlFragment() {
        // Required empty public constructor
    }

    // need to create interface to ensure message passing
    public interface ControlFragmentListener {
        public void sendMessage(String msg);
        public void changeBG(int pos);
    }

    ControlFragmentListener CFL;

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        CFL = (ControlFragmentListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_control, container, false);

        listMsg = (ListView) view.findViewById(R.id.listMsg);
        btnSend = (Button) view.findViewById(R.id.btnSend);

        final String[] messages = {"Cheeseburgers are ok...",
        "French Toasts are great for brunch!", "Korean BBQ is a must for meat-eaters!", "Nachos are the best!", "Salmon Salsa is healthy as always!"};

        ArrayAdapter messageListAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, messages);

        listMsg.setAdapter(messageListAdapter);
        listMsg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sentMsg = String.valueOf(parent.getItemAtPosition(position));
                BGpos = position;
            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager input = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
//                input.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                CFL.sendMessage(sentMsg);
                CFL.changeBG(BGpos);
            }
        });

        return view;
    }

}
