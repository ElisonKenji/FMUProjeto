package com.example.exemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatabaseActivity extends AppCompatActivity {



    private EditText editTextRE;
    private EditText editTextNome;
    private EditText editTextDataAdmissao;
    private EditText editTextSalario;
    private EditText editTextCargo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        editTextRE = findViewById(R.id.editTextRE);
        editTextNome = findViewById(R.id.editTextNome);
        editTextDataAdmissao = findViewById(R.id.editTextDataAdmissao);
        editTextSalario = findViewById(R.id.editTextSalario);
        editTextCargo = findViewById(R.id.editTextCargo);

    }


    public void cadastrar(View view){



        int RE = Integer.parseInt(editTextRE.getText().toString());
        String Nome = editTextNome.getText().toString();
        SimpleDateFormat DateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date DataAdmissao;
        try {

            DataAdmissao = DateFormat.parse(editTextDataAdmissao.getText().toString());
        }
        catch (ParseException e){
            DataAdmissao = new Date();
        }
        Double Salario = Double.parseDouble(editTextSalario.getText().toString());
        String Cargo = editTextCargo.getText().toString();
        AppDatabase db=AppDatabase.getInstance(this);
        FuncionarioDAO dao =db.funcionarioDao();
        Funcionario f = new Funcionario(RE,Nome,DataAdmissao,Salario,Cargo );
        dao.insert(f);

    }
}