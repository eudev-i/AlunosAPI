package br.com.senaijandira.alunos.service;

import java.util.List;

import br.com.senaijandira.alunos.model.Aluno;
import br.com.senaijandira.alunos.model.ApiResult;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AlunoService {

    String URL_BASE = "http://10.0.2.2:5001/";

    @GET("/alunos")
    Call<List<Aluno>> obterAlunos();

    //@GET("alunos/{id)")
    //Call<ALuno> obterAlunoPorId(@Path("id") int id);

    @POST("/aluno/novo")
    //void cadastrarAluno(Aluno aluno);
    Call<ApiResult> cadastrarAluno(@Body Aluno aluno);

    @GET("aluno/{id}")
    Call<Aluno> alunoPorId(@Path("id")int id);


}
