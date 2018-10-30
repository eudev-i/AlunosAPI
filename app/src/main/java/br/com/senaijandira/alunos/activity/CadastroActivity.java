package br.com.senaijandira.alunos.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

import br.com.senaijandira.alunos.R;
import br.com.senaijandira.alunos.model.Aluno;
import br.com.senaijandira.alunos.presenter.CadastroPresenter;
import br.com.senaijandira.alunos.service.AlunoService;
import br.com.senaijandira.alunos.service.ServiceFactory;
import br.com.senaijandira.alunos.util.DateUtil;
import br.com.senaijandira.alunos.view.CadastroView;

public class CadastroActivity extends AppCompatActivity implements CadastroView{

    static EditText txtNome, txtDtNascimento, txtMatricula, txtCpf;

    //INSTANCIANDO A CLASSE DE SERVIÇO DA API
    AlunoService service = ServiceFactory.create();

     CadastroPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        /*INSTANCIANDO O CADASTRO PRESENTER*/
        presenter = new CadastroPresenter(this, service);

        txtNome = findViewById(R.id.txtNome);
        txtDtNascimento = findViewById(R.id.txtDtNascimento);
        txtMatricula = findViewById(R.id.txtMastricula);
        txtCpf = findViewById(R.id.txtCpf);
    }

    //FUNÇÃO PARA QUE NO CLIQUE CADASTRE UM ALUNO
    public void cadastrarAluno(View view) {

        //TESTANDO O CADASTRO DE UM ALUNO
        /*Aluno aluno = new Aluno();
        aluno.setNome("Clara");
        aluno.setDataNascimento(20101204);
        aluno.setMatricula(12345);
        aluno.setCpf("260.655.892-99");*/

        String nome = txtNome.getText().toString();
        String dtNascimento = txtDtNascimento.getText().toString();
        String matricula = txtMatricula.getText().toString();
        String cpf = txtCpf.getText().toString();

        int dataFormatada = new DateUtil().convertToInt(dtNascimento);

        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setDataNascimento(dataFormatada);
        aluno.setMatricula(Integer.parseInt(matricula));
        aluno.setCpf(cpf);


        presenter.cadastrarAluno(aluno);
    }



    /*NA ÇÃO DO CLICK NO ICONE DO CALENDARIO, ABRIR O CALENDARIO*/
    public void abrirCalendario(View view) {

        /*CODIGO DA PESQUISA android datepiker NA DOCUMENTAÇAO DO ANDROID: Showing the date picker*/
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    /*IMPLEMENTSANDO O MÉTODO DEFINIDO NO CONTRATO*/


    @Override
    public void showMessage(String titulo, String mensagem) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle(titulo);
        alert.setMessage(mensagem);
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alert.show();
    }


    /*CODIGO DA PESQUISA android datepiker NA DOCUMENTAÇAO DO ANDROID: Creating a Date Picker*/
    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            //USE A DATA ATUAL COMO A DATA PADRÃO NO SELECIONADOR
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            //CRIA UMA NOVA INSTÂNCIA DE DatePickerDialog E RETORNE-A
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            //FAÇA ALGO COM A DATA ESSCOLHIDA PELO USUÁRIO

            //String dia = String.format("%02d", day); /*VIRÁ 2 DIGITOS, SE VIR SÓ UM ELE VAI COMPLETAR COM UM ZERO*/
            //String mes = String.format("%02d", month+1); /*VIRÁ 2 DIGITOS, SE VIR SÓ UM ELE VAI COMPLETAR COM UM ZERO*/
            //String ano = String.format("%d", year);

            String data = String.format("%02d/%02d/%d", day, month, year);/*ESSA LINHA SUBSTITUÍ AS TRES QUE FORAM COMENTADAS*/
            txtDtNascimento.setText(data);

        }
    }
}
