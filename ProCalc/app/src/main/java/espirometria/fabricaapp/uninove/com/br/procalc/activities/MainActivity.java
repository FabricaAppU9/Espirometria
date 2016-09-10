package espirometria.fabricaapp.uninove.com.br.procalc.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import espirometria.fabricaapp.uninove.com.br.procalc.R;
import espirometria.fabricaapp.uninove.com.br.procalc.controllers.Calculo;
import espirometria.fabricaapp.uninove.com.br.procalc.helper.HomeActivityHelper;
import espirometria.fabricaapp.uninove.com.br.procalc.models.Pessoa;

import static espirometria.fabricaapp.uninove.com.br.procalc.R.id.actionFaixas;


public class MainActivity extends AppCompatActivity {

    EditText txtAltura, txtIdade, txtPeso;
    RadioButton btnMasc, btnFem;
    public Character genero;
    Button btnCalcular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        txtAltura = (EditText) findViewById(R.id.txtAltura);
        txtIdade = (EditText) findViewById(R.id.txtIdade);
        txtPeso = (EditText) findViewById(R.id.txtPeso);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeActivityHelper helper = new HomeActivityHelper(MainActivity.this);
                Pessoa pessoa = helper.getModel(MainActivity.this);
                Calculo calculo = new Calculo();

                calculo.calcular(pessoa);

            }
        });
    }

    //Tratando evento de click do Gênero
    public void onRadioButtonClicked(View view){
        // Verifica se algum botao foi clicado
        boolean checked = ((RadioButton) view).isChecked();

        //Verifica qual botao foi selecionado
        switch(view.getId()) {
            case R.id.btnFem:
                if (checked) {
                    genero = 'F';
                    view.setBackgroundResource(R.mipmap.female_checked);
                    findViewById(R.id.btnMasc).setBackgroundResource(R.mipmap.masculine_unchecked);
                }
                break;
            case R.id.btnMasc:
                if (checked){
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
