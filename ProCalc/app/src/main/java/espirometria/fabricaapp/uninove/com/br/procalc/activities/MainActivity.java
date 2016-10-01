package espirometria.fabricaapp.uninove.com.br.procalc.activities;

import android.app.Activity;
import android.content.Intent;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import espirometria.fabricaapp.uninove.com.br.procalc.R;
import espirometria.fabricaapp.uninove.com.br.procalc.adapters.ResultadoItemAdapter;
import espirometria.fabricaapp.uninove.com.br.procalc.controllers.Calculo;
import espirometria.fabricaapp.uninove.com.br.procalc.controllers.Validacao;
import espirometria.fabricaapp.uninove.com.br.procalc.helper.HomeActivityHelper;
import espirometria.fabricaapp.uninove.com.br.procalc.models.Pessoa;
import espirometria.fabricaapp.uninove.com.br.procalc.models.Resultado;
import espirometria.fabricaapp.uninove.com.br.procalc.models.ResultadoItem;
import espirometria.fabricaapp.uninove.com.br.procalc.models.ResultadoValidacao;

import static espirometria.fabricaapp.uninove.com.br.procalc.R.id.actionFaixas;

public class MainActivity extends AppCompatActivity {

    EditText txtAltura, txtIdade, txtPeso;
    RadioButton btnMasc, btnFem;
    public Character genero;
    Button btnCalcular;
    ListView lvResultado;
    boolean checked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        txtAltura = (EditText) findViewById(R.id.txtAltura);
        txtIdade = (EditText) findViewById(R.id.txtIdade);
        txtPeso = (EditText) findViewById(R.id.txtPeso);
        lvResultado = (ListView) findViewById(R.id.lvResultado);
        btnMasc = (RadioButton) findViewById(R.id.btnMasc);
        btnFem = (RadioButton) findViewById(R.id.btnFem);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( txtIdade.getText().toString().trim().equals("")){

                    txtIdade.setError( "Idade não preenchida!" );

                } else if( txtAltura.getText().toString().trim().equals("")){

                    txtAltura.setError( "Altura não preenchida!" );

                } else if( txtPeso.getText().toString().trim().equals("")){

                    txtPeso.setError( "Peso não preenchido!" );

                } else if(!checked){
                    Toast.makeText(getApplicationContext(), "Selecione um gênero!", Toast.LENGTH_SHORT).show();
                } else {
                    HomeActivityHelper helper = new HomeActivityHelper(MainActivity.this);
                    Pessoa pessoa = helper.getModel(MainActivity.this);
                    Validacao val = new Validacao();
                    ResultadoValidacao resVal = val.validar(pessoa);
                    Calculo calculo = new Calculo();
                    if (resVal.isResultado()){
                        updateListResult(calculo.calcular(pessoa));
                    } else{
                        Toast.makeText(MainActivity.this, resVal.getMensagen(), Toast.LENGTH_SHORT).show();
                        Resultado res = calculo.calcular(pessoa);
                        res.getCv().setPrevisto(0);
                        res.getCvf().setPrevisto(0);
                        res.getFef().setPrevisto(0);
                        res.getFefcvf().setPrevisto(0);
                        res.getVefcvf().setPrevisto(0);
                        res.getPfe().setPrevisto(0);
                        res.getVef().setPrevisto(0);

                        res.getCv().setInferior(0);
                        res.getCvf().setInferior(0);
                        res.getFef().setInferior(0);
                        res.getFefcvf().setInferior(0);
                        res.getVefcvf().setInferior(0);
                        res.getPfe().setInferior(0);
                        res.getVef().setInferior(0);
                        updateListResult(res);
                    }
                }

                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

            }
        });

    }

    public void updateListResult(Resultado res){

        ResultadoItemAdapter adapter = new ResultadoItemAdapter(this,res.toList());
        lvResultado.setAdapter(adapter);

    }

    //Tratando evento de click do Gênero
    public void onRadioButtonClicked(View view){
        // Verifica se algum botao foi clicado
        checked = ((RadioButton) view).isChecked();

        //Verifica qual botao foi selecionado
        switch (view.getId()) {
            case R.id.btnFem:
                if (checked) {
                    genero = 'F';
                    view.setBackgroundResource(R.mipmap.female_checked);
                    findViewById(R.id.btnMasc).setBackgroundResource(R.mipmap.masculine_unchecked);
                }
                break;
            case R.id.btnMasc:
                if (checked) {
                    genero = 'M';
                    view.setBackgroundResource(R.mipmap.masculine_checked);
                    findViewById(R.id.btnFem).setBackgroundResource(R.mipmap.female_unchecked);
                }
                break;
        }



    }

    // Trazendo o menu para a Action Bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_sobre, menu);
        return true;
    }

    // Ações do Menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            // Ao clicar no icone "Informações" abre a activity de informações
            case R.id.actionSobre:
                startActivity(new Intent(this, InfoActivity.class));
                break;
            case R.id.actionFaixas:
                startActivity(new Intent(this, FaixasLimiteActivity.class));
                break;
        }
        return true;
    }


}
