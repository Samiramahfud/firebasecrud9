package com.example.sam.notes.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import com.example.sam.notes.R;
import com.example.sam.notes.adapters.NoteAdapter;
import com.example.sam.notes.models.Data;
import com.example.sam.notes.models.Constant;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class NoteFragment extends Fragment {

    private OnNoteFragmentListener listener;
    private RecyclerView recyclerView;
    private NoteAdapter adapter;

    public NoteFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_note, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note, container, false);
        recyclerView = view.findViewById(R.id.rv_notes);

        adapter = new NoteAdapter(getContext(), Data.getNotes());
        recyclerView.setAdapter(adapter);
        //displayAsList();
        try {
            if (listener.getMenu() == 0){
                displayAsList();
            }if (listener.getMenu() == 1){
                displayAsGrid();
            }
            Toast.makeText(getContext(), listener.getMenu(), Toast.LENGTH_SHORT).show();
        }catch(Exception e){

        }
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_show_list:
                displayAsList();
                listener.menuClick(0);
                return true;
            case R.id.action_show_grid:
                displayAsGrid();
                listener.menuClick(1);
                return true;

            case R.id.action_logout:
                listener.onLogoutClick();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

//    public interface OnNoteFragmentListener {
//        void onLogoutClick();
//    }

    public void setListener(OnNoteFragmentListener listener) {
        this.listener = listener;
    }

    private void displayAsList() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter.setLayout(Constant.LAYOUT_MODE_LIST);
    }

    private void displayAsGrid() {
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        adapter.setLayout(Constant.LAYOUT_MODE_GRID);
    }

    public interface OnNoteFragmentListener {
        void onLogoutClick();
        void menuClick(int layout);
        int getMenu();
    }
}
