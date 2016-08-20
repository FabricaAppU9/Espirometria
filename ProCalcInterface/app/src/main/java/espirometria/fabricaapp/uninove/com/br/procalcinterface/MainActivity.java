package espirometria.fabricaapp.uninove.com.br.procalcinterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        
    }

}
