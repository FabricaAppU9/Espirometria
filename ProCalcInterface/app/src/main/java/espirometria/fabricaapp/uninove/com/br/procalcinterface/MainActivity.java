package espirometria.fabricaapp.uninove.com.br.procalcinterface;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText txtAltura, txtIdade, txtPeso;
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
                Pessoa pessoa = new Pessoa();
                Calculo calculo = new Calculo();

                //Inserir nesse if a função de validação
                //if(validar(Pessoa)){
                    //Chamar cálculo
                //}
            }
        });
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
            case R.id.actionAbout:
                startActivity(new Intent(this, InfoActivity.class));
                break;
        }
        return true;
    }


}
