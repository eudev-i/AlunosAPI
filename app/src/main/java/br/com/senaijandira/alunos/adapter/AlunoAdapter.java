package br.com.senaijandira.alunos.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.senaijandira.alunos.R;
import br.com.senaijandira.alunos.model.Aluno;

public class AlunoAdapter extends ArrayAdapter<Aluno> {

    public AlunoAdapter(Context ctx){

        super(ctx, 0, new ArrayList<Aluno>()); /*CONSTRUTOR PADRÃO, CRIANDO UMA LISTA VAZIA*/
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;

        if(v == null){

            v = LayoutInflater.from(getContext()).inflate(R.layout.list_view_item, parent, false);
        }

        Aluno aluno = getItem(position);

        TextView txtNome = v.findViewById(R.id.txtNomeAluno);
        TextView txtMatricula = v.findViewById(R.id.txtMatriculaAluno);

        txtNome.setText(aluno.getNome());
        txtMatricula.setText(aluno.getMatricula()+"");

        return v;
    }
}
