package com.pimenta.avaliacaotrovata.recyclerView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pimenta.avaliacaotrovata.model.Empresa;

import java.util.List;

public class RecyclerView_ListaEmpresas extends RecyclerView.Adapter<RecyclerView_ListaEmpresas.ViewHolder> {

    private Context context;
    private List<Empresa> empresas;
    private ClickEmpresas clickEmpresas;

    public RecyclerView_ListaEmpresas(Context context, List<Empresa> empresas, ClickEmpresas clickEmpresas) {
        this.context = context;
        this.empresas = empresas;
        this.clickEmpresas = clickEmpresas;
    }

    @NonNull
    @Override
    public RecyclerView_ListaEmpresas.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView_ListaEmpresas.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public interface ClickEmpresas {
        void click_Empresa(Empresa empresa);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
