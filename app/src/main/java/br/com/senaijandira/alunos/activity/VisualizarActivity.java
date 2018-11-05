package br.com.senaijandira.alunos.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import br.com.senaijandira.alunos.R;
import br.com.senaijandira.alunos.model.Aluno;
import br.com.senaijandira.alunos.presenter.VisualizarPresenter;
import br.com.senaijandira.alunos.service.ServiceFactory;
import br.com.senaijandira.alunos.view.VisualizarView;

public class VisualizarActivity extends AppCompatActivity implements VisualizarView{

    TextView txtResultNome, txtResultDtNasc, txtResultMatricula, txtResultCpf, txtResutMedia;
    VisualizarPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar);

        int idAluno = getIntent().getIntExtra("idAluno", 0);

        Log.d("VISUALIZAR", idAluno+"");

        txtResultNome = findViewById(R.id.txtResultNome);
        txtResultDtNasc = findViewById(R.id.txtResultDtNasc);
        txtResultMatricula = findViewById(R.id.txtResultMatricula);
        txtResultCpf = findViewById(R.id.txtResultCpf);
        txtResutMedia = findViewById(R.id.txtResutMedia);

        presenter = new VisualizarPresenter(this, ServiceFactory.create());
        presenter.alunoResult(idAluno);

    }
    @Override
    public void apresentarAluno(Aluno aluno){
        txtResultNome.setText(aluno.getNome());
        txtResultDtNasc.setText(String.valueOf(aluno.getDataNascimento()));
        txtResultMatricula.setText(String.valueOf(aluno.getMatricula()));
        txtResultCpf.setText(aluno.getCpf());
        txtResutMedia.setText(aluno.getNotas().toString());
    }


}
