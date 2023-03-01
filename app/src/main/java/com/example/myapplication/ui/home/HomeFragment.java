package com.example.myapplication.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.HomeActivity;
import com.example.myapplication.Login;
import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityProfileViewDrawerBinding;
import com.example.myapplication.databinding.FragmentHomeBinding;
import com.example.myapplication.ui.ChannelInfo;
import com.example.myapplication.ui.listDptr;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
//my code St@rt

        ArrayList<ChannelInfo> list=new ArrayList<>();
        list.add(new ChannelInfo("one","vcv","vdd","cd"));
        list.add(new ChannelInfo("two","vcv","vdd","cd"));
        list.add(new ChannelInfo("three","vcv","vdd","cd"));



//fetch list from fireDB
//        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("channels");
//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if(snapshot.exists()){
//                    ChannelInfo channelInfo=new ChannelInfo();
//                    channelInfo.channelName=snapshot.child("/").child("channelName").getValue(String.class);
//                    channelInfo.token=snapshot.child("/").child("token").getValue(String.class);
//
//                    list.add(channelInfo);
//
//                }
//                else{
//                    System.out.println("invalid query");
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                System.out.println("canceled operation");
//            }
//        });
//
//        RecyclerView recyclerView = (RecyclerView)container.findViewById(R.id.recyclerView);
//        listDptr adapter = new listDptr(list,getContext());
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        recyclerView.setAdapter(adapter);
//

//my code end
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}