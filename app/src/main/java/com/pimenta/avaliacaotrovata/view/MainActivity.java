package com.pimenta.avaliacaotrovata.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.pimenta.avaliacaotrovata.R;
import com.pimenta.avaliacaotrovata.model.Empresa;
import com.pimenta.avaliacaotrovata.recyclerView.RecyclerView_ListaEmpresas;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerView_ListaEmpresas.ClickEmpresas {


    private RecyclerView recyclerView;
    private List<Empresa> empresas = new ArrayList<>();
    private RecyclerView_ListaEmpresas recyclerView_listaEmpresas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarRecyclerView();
    }

    private void iniciarRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView_listaEmpresas = new RecyclerView_ListaEmpresas(getBaseContext(), empresas,
                this);

        recyclerView.setAdapter(recyclerView_listaEmpresas);
    }

    @Override
    public void click_Empresa(Empresa empresa) {

    }

    @Override
    protected void onStart() {
        super.onStart();
        recuperarEmpresas();
    }

    private void recuperarEmpresas() {

    }
}