package com.pimenta.avaliacaotrovata.recyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.pimenta.avaliacaotrovata.R;
import com.pimenta.avaliacaotrovata.model.Empresas;

import java.util.List;

public class RecyclerView_ListaEmpresas extends RecyclerView.Adapter<RecyclerView_ListaEmpresas.ViewHolder> {

    private Context context;
    private List<Empresas> listaEmpresas;
    private ClickEmpresas clickEmpresas;

    public RecyclerView_ListaEmpresas(Context context,List<Empresas> empresas, ClickEmpresas clickEmpresas) {
        this.context = context;
        this.listaEmpresas = empresas;
        this.clickEmpresas = clickEmpresas;
    }

    @NonNull
    @Override
    public RecyclerView_ListaEmpresas.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lista_empresas, parent, false);

        ViewHolder holder = new ViewHolder(view);
        view.setTag(holder);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView_ListaEmpresas.ViewHolder holder, int position) {

        final Empresas empresas = listaEmpresas.get(position);

        holder.razao_social.setText(empresas.getRazao_social());
        holder.cidade.setText(empresas.getCidade());

        holder.cardView.setOnClickListener(click ->
                clickEmpresas.click_empresa(empresas));
    }

    @Override
    public int getItemCount() {
        return this.listaEmpresas.size();
    }

    public interface ClickEmpresas {
        void click_empresa(Empresas empresas);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView razao_social;
        TextView cidade;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            cardView = itemView.findViewById(R.id.cardView_listaEmpresas);
            razao_social = itemView.findViewById(R.id.textView_razaoSocial);
            cidade = itemView.findViewById(R.id.textView_Cidade);

            //Animação recycler
            Animation translate = AnimationUtils.loadAnimation(context,R.anim.translate_anim);
            cardView.setAnimation(translate);

        }
    }
}