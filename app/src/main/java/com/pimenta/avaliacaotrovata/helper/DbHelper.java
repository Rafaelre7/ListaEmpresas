package com.pimenta.avaliacaotrovata.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;


public class DbHelper extends SQLiteOpenHelper {

    private Context context;
    public static String DATABASE_NAME = "Trovata.db";
    public static int DATABASE_VERSION = 1;

    public static String TABELA_EMPRESAS = "empresa";


    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    //apenas é chamado uma ve quando o aplicativo é instalado
    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE IF NOT EXISTS " + TABELA_EMPRESAS
                + " (empresa INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " nome_fantasia VARCHAR (30), " +
                " razao_social VARCHAR (50)," +
                " endereco VARCHAR (50)," +
                "bairro VARCHAR (30)," +
                "cep VARCHAR (10)," +
                "cidade VARCHAR (250)," +
                "telefone VARCHAR (15)," +
                "fax VARCHAR (15)," +
                "cnpj VARCHAR (18)," +
                "ie VARCHAR (18)); ";

        String insertEmpresas = "INSERT INTO EMPRESA (empresa, nome_fantasia, razao_social, " +
                "endereco, bairro, cep, cidade, telefone, cnpj, ie)" +
                " VALUES (1, 'ROMA VENDAS ONLINE', 'ROMA VENDAS LTDA', 'RUA NELSON CALIXTO 142', " +
                "'PARQUE SAO VICENTE', '16200-320', 1," +
                " '(18)3644-7333','88.060.431/0001-94','ISENTO');";

        String insertEmpresas1 = "INSERT INTO EMPRESA (empresa, nome_fantasia, razao_social," +
                " endereco, bairro, cep, cidade, telefone, cnpj, ie)" +
                " VALUES (2, 'MILANO VENDAS OFFLINE', 'MILANO VENDAS OFFLINE LTDA', 'RUA BELMONTE, 334', " +
                "'VILA MARIANA', '16334-532', 45," +
                " '(19)3523-5232','26.523.811/0001-60','ISENTO');";

        try {
            db.execSQL(sql);
            db.execSQL(insertEmpresas);
            db.execSQL(insertEmpresas1);

            Log.i("INFO DB", "Sucesso ao criar a tabela");
        } catch (Exception e) {
            Log.i("INFO DB", "Erro ao criar a tabela" + e.getMessage());
        }


    }

    //quando exite alguma atualizacao do bd
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABELA_EMPRESAS + " ;";

        try {
            db.execSQL(sql);
            onCreate(db);
            Log.i("INFO DB", "Sucesso ao atualizar App");
        } catch (Exception e) {
            Log.i("INFO DB", "Erro ao atualizar App" + e.getMessage());
        }
    }
}
