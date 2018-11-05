package br.com.senaijandira.alunos.presenter;

import br.com.senaijandira.alunos.model.Aluno;
import br.com.senaijandira.alunos.service.AlunoService;
import br.com.senaijandira.alunos.view.VisualizarView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VisualizarPresenter {

    VisualizarView view;
    AlunoService service;

    public VisualizarPresenter(VisualizarView view, AlunoService service){
        this.view = view;
        this.service = service;
    }

    public void alunoResult(int id){
        service.alunoPorId(id).enqueue((new Callback<Aluno>() {
            @Override
            public void onResponse(Call<Aluno> call, Response<Aluno> response) {
                view.apresentarAluno(response.body());
            }

            @Override
            public void onFailure(Call<Aluno> call, Throwable t) {

            }
        }));
    }
}
