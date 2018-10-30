package br.com.senaijandira.alunos.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.List;

import br.com.senaijandira.alunos.R;
import br.com.senaijandira.alunos.adapter.AlunoAdapter;
import br.com.senaijandira.alunos.model.Aluno;
import br.com.senaijandira.alunos.presenter.MainPresenter;
import br.com.senaijandira.alunos.service.ServiceFactory;
import br.com.senaijandira.alunos.view.MainView;

public class MainActivity extends AppCompatActivity implements MainView, AdapterView.OnItemClickListener {

    ListView listView;
    AlunoAdapter adapter;

    ProgressBar progressBar;

    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        progressBar = findViewById(R.id.progressBar);

        listView = findViewById(R.id.listView);
        adapter = new AlunoAdapter(this);/*INSTANCIAR O ADAPTER*/
        listView.setAdapter(adapter);/*PLUGAR O ADAPTER NA LISTA*/
        listView.setOnItemClickListener(this);

        /*CONFIG PRESENTER*/
        presenter = new MainPresenter(this, ServiceFactory.create());



    }

    @Override
    protected void onResume() {
        super.onResume();

        presenter.carregarAlunos(); /*PARA QUANDO CADASTRAR JÁ APARECER O CADASTRO*/

    }

    @Override
    public void exibirBarraProgresso(){

        progressBar.setVisibility(View.VISIBLE);
        listView.setVisibility(View.GONE);
    }

    @Override
    public void esconderBarraProgresso(){

        progressBar.setVisibility(View.GONE);
        listView.setVisibility(View.VISIBLE);
    }

    @Override
    public void preencherLista(List<Aluno> lstAlunos){

        adapter.clear();
        adapter.addAll(lstAlunos);
    }

    /*ONCLIK PARA QUANDO APERTAR NO BOTÃO ABRIR OUTRA PAGINA*/
    public void abrirCadastro(View view) {
        startActivity(new Intent(this, CadastroActivity.class));
    }

    /*IDENTIFICAR O CLIQUE DA LISTA*/
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        /*PEGANDO O CLIQUE*/
        Aluno alunoSelecionado = adapter.getItem(position);

        Intent intent  = new Intent(this, VisualizarActivity.class);
        intent.putExtra("idAluno", alunoSelecionado.getId());

        startActivity(intent);
    }
}
