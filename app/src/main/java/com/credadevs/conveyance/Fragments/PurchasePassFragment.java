package com.credadevs.conveyance.Fragments;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.credadevs.conveyance.R;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PurchasePassFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PurchasePassFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private ArrayList<String> arr = new ArrayList<String>(Arrays.asList("3", "300", "500", "700"));
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView textView;

    public PurchasePassFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PurchasePassFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PurchasePassFragment newInstance(String param1, String param2) {
        PurchasePassFragment fragment = new PurchasePassFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_purchase_pass, container, false);
    }

    /**
     * Called immediately after {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}
     * has returned, but before any saved state has been restored in to the view.
     * This gives subclasses a chance to initialize themselves once
     * they know their view hierarchy has been completely created.  The fragment's
     * view hierarchy is not however attached to its parent at this point.
     *
     * @param view               The View returned by {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView busCodeInput = requireView().findViewById(R.id.busCodeInput);

//        RadioGroup radioGroup = (RadioGroup) requireView().findViewById(R.id.radioGroup);
//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
//        {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                // checkedId is the RadioButton selected
//                if(checkedId == R.id.busCodeRadioButton){
//
//                }
//            }
//        });


                // initialize array list
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("300", "500", "3"));



        busCodeInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Initialize dialog
                Dialog dialog = new Dialog(requireActivity());

                // set custom dialog
                dialog.setContentView(R.layout.dialog_searchable_spinner);

                // set custom height and width
                dialog.getWindow().setLayout(650, 800);

                // set transparent background
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                // show dialog
                dialog.show();

                // Initialize and assign variable
                EditText editText = dialog.findViewById(R.id.edit_text);
                ListView listView = dialog.findViewById(R.id.list_view);

                // Initialize array adapter
                ArrayAdapter<String> adapter = new ArrayAdapter<>(requireActivity(), android.R.layout.simple_list_item_1, arrayList);

                // set adapter
                listView.setAdapter(adapter);
//              Filters the listview everytime the text entered is changed
                editText.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        adapter.getFilter().filter(s);
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        // when item selected from list
                        // set selected item on textView
                        String selectedBusCode = adapter.getItem(position);
                        busCodeInput.setText(selectedBusCode);
                        busCodeInput.setTextColor(Color.parseColor("#222222"));
                        // Dismiss dialog
                        dialog.dismiss();
                    }
                });
            }

        });


    }
}
//        RecyclerViewCustomAdapter ad = new RecyclerViewCustomAdapter(arr);
//
//        RecyclerView busCodeRecyclerView = requireView().findViewById(R.id.busCodeList);
//
//        busCodeRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
//        busCodeRecyclerView.setAdapter(ad);
//
//        busCodeInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View view, boolean hasFocus) {
//                if (hasFocus){
//                    busCodeRecyclerView.setVisibility(View.VISIBLE);
//                    busCodeInput.addTextChangedListener(new TextWatcher() {
//                        @Override
//                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//                        }
//
//                        @Override
//                        public void onTextChanged(CharSequence s, int start, int before, int count) {
//                            if (s.length()>0) {
//                                ArrayList<String> filteredList = new ArrayList<>();
//                                for (String busCode : arr) {
//                                    if (busCode.contains(s)) {
//                                        filteredList.add(busCode);
//                                    }
//                                }
//                                ad.updateList(filteredList);
//                            }
//                        }
//
//                        @Override
//                        public void afterTextChanged(Editable s) {
//
//                        }
//                    });
//                }
//                else{
//                    busCodeRecyclerView.setVisibility(View.GONE);
//                }
//            }
//        });


//        EditText editText=requireView().findViewById(R.id.busCodeInput);
//        ListView listView=requireView().findViewById(R.id.list_view);
//
//        // Initialize array adapter
//        ArrayAdapter<String> adapter=new ArrayAdapter<>(requireActivity(), android.R.layout.simple_list_item_1,arr);
//
//        // set adapter
//        listView.setAdapter(adapter);
////              Filters the listview everytime the text entered is changed
//        editText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                adapter.getFilter().filter(s);
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                // when item selected from list
//                // set selected item on textView
//                editText.setText(adapter.getItem(position));
//
//            }
//        });












        //Code to implement search using dialog
        // assign variable
//        TextView textview= requireView().findViewById(R.id.testView);
//
//        // initialize array list
//        ArrayList<String> arrayList=new ArrayList<>();
//
//        // set value in array list
//        arrayList.add("DSA Self Paced");
//        arrayList.add("Complete Interview Prep");
//        arrayList.add("Amazon SDE Test Series");
//        arrayList.add("Compiler Design");
//        arrayList.add("Git & Github");
//        arrayList.add("Python foundation");
//        arrayList.add("Operating systems");
//        arrayList.add("Theory of Computation");
//
//        textview.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Initialize dialog
//                Dialog dialog=new Dialog(requireActivity());
//
//                // set custom dialog
//                dialog.setContentView(R.layout.dialog_searchable_spinner);
//
//                // set custom height and width
//                dialog.getWindow().setLayout(650,800);
//
//                // set transparent background
//                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//
//                // show dialog
//                dialog.show();
//
//                // Initialize and assign variable
//                EditText editText=dialog.findViewById(R.id.edit_text);
//                ListView listView=dialog.findViewById(R.id.list_view);
//
//                // Initialize array adapter
//                ArrayAdapter<String> adapter=new ArrayAdapter<>(requireActivity(), android.R.layout.simple_list_item_1,arrayList);
//
//                // set adapter
//                listView.setAdapter(adapter);
////              Filters the listview everytime the text entered is changed
//                editText.addTextChangedListener(new TextWatcher() {
//                    @Override
//                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//                    }
//
//                    @Override
//                    public void onTextChanged(CharSequence s, int start, int before, int count) {
//                        adapter.getFilter().filter(s);
//                    }
//
//                    @Override
//                    public void afterTextChanged(Editable s) {
//
//                    }
//                });
//
//                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        // when item selected from list
//                        // set selected item on textView
//                        textview.setText(adapter.getItem(position));
//
//                        // Dismiss dialog
//                        dialog.dismiss();
//                    }
//                });
//            }
//        });


//    public void filter(String text){
//        List<DataHolder> temp = new ArrayList();
//        for(DataHolder d: displayedList){
//            //or use .equal(text) with you want equal match
//            //use .toLowerCase() for better matches
//            if(d.getEnglish().contains(text)){
//                temp.add(d);
//            }
//        }
//        //update recyclerview
//        disp_adapter.updateList(temp);
//    }
