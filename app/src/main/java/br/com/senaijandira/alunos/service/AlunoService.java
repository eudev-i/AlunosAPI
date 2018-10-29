package br.com.senaijandira.alunos.service;

import java.util.List;

import br.com.senaijandira.alunos.model.Aluno;
import retrofit2.Call;
import retrofit2.http.GET;

public interface AlunoService {

    String URL_BASE = "http://10.0.2.2:5001/";

    @GET("/alunos")
    Call<List<Aluno>> obterAlunos();

}
