package com.pimenta.avaliacaotrovata.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pimenta.avaliacaotrovata.R;
import com.pimenta.avaliacaotrovata.dao.EmpresasDAO;
import com.pimenta.avaliacaotrovata.model.Empresas;
import com.pimenta.avaliacaotrovata.recyclerView.RecyclerView_ListaEmpresas;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerView_ListaEmpresas.ClickEmpresas {


    private RecyclerView recyclerView;
    private RecyclerView_ListaEmpresas recyclerView_listaEmpresas;
    private List<Empresas> empresas = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarComponentes();

    }

    private void inicializarComponentes() {

        recyclerView = findViewById(R.id.recyclerView_Database_EmpresasLista);
    }

    @Override
    public void click_empresa(Empresas empresas) {

        Intent intent = new Intent(MainActivity.this, ProdutosActivity.class);
//        intent.putExtra("tarefaSelecionada", tarefaSelecionada );
        startActivity(intent);

    }

    @Override
    protected void onStart() {
        listarEmpresas();
        super.onStart();
    }

    private void listarEmpresas() {

        EmpresasDAO empresasDAO = new EmpresasDAO(getApplicationContext());
        empresas = empresasDAO.listar();

        recyclerView_listaEmpresas = new RecyclerView_ListaEmpresas(getBaseContext(), empresas,
                this);

         RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
         recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(recyclerView_listaEmpresas);

    }
}