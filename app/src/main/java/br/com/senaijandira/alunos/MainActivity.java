package br.com.senaijandira.alunos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.List;

import br.com.senaijandira.alunos.adapter.AlunoAdapter;
import br.com.senaijandira.alunos.model.Aluno;
import br.com.senaijandira.alunos.service.ServiceFactory;

public class MainActivity extends AppCompatActivity implements MainView{

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

        /*CONFIG PRESENTER*/
        presenter = new MainPresenter(this, ServiceFactory.create());

        presenter.carregarAlunos();

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


}
