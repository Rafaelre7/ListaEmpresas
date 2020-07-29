package com.pimenta.avaliacaotrovata.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.pimenta.avaliacaotrovata.helper.DbHelper;
import com.pimenta.avaliacaotrovata.model.Empresas;

import java.util.ArrayList;
import java.util.List;

public class EmpresasDAO implements IEmpresasDAO {

    private SQLiteDatabase escreve;
    private SQLiteDatabase le;

    public EmpresasDAO(Context context) {
        DbHelper db = new DbHelper(context);
        escreve = db.getWritableDatabase();
        le = db.getReadableDatabase();
    }

    @Override
    public List<Empresas> listar() {

        List<Empresas> empresas = new ArrayList<>();
        Log.e("listou", "---INICIOU LISTAGEM---");
        String sql = "SELECT * FROM "+ DbHelper.TABELA_EMPRESAS+" ;";
        Log.e("listou", sql);
        Cursor c = le.rawQuery(sql, null);

        while (c.moveToNext()){

            Empresas empresa = new Empresas();

            int empresaId = c.getInt(c.getColumnIndex("empresa"));
            String razaoSocial = c.getString(c.getColumnIndex("razao_social"));
            String cidade = c.getString(c.getColumnIndex("cidade"));

            empresa.setEmpresa(empresaId);
            empresa.setRazao_social(razaoSocial);
            empresa.setCidade(cidade);

            Log.e("listou", "RAZÃO SOCIAL: "+empresa.getRazao_social());
            empresas.add(empresa);

        }
        return empresas;
    }
}
