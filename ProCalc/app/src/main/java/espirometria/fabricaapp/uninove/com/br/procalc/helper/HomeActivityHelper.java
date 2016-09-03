package espirometria.fabricaapp.uninove.com.br.procalc.helper;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;

import espirometria.fabricaapp.uninove.com.br.procalc.R;
import espirometria.fabricaapp.uninove.com.br.procalc.activities.MainActivity;
import espirometria.fabricaapp.uninove.com.br.procalc.models.Model;
import espirometria.fabricaapp.uninove.com.br.procalc.models.Pessoa;

/**
 * Created by internet on 27/08/2016.
 */
public class HomeActivityHelper implements ViewHelper {
    private final EditText txtAltura;
    private final EditText txtIdade;
    private final EditText txtPeso;

    private Pessoa pessoa;

    public HomeActivityHelper(MainActivity activity){
        txtAltura = (EditText) activity.findViewById(R.id.txtAltura);
        txtIdade = (EditText) activity.findViewById(R.id.txtIdade);
        txtPeso = (EditText) activity.findViewById(R.id.txtPeso);
        pessoa = new Pessoa();
    }

    public Pessoa getPessoa(){
        pessoa.setAltura(Double.parseDouble(txtAltura.getText().toString()));
        pessoa.setIdade(Integer.parseInt(txtIdade.getText().toString()));
        pessoa.setMassa(Double.parseDouble(txtPeso.getText().toString()));
        return pessoa;
    }


    @Override
    public void getModel(Activity activity) {


    }

    @Override
    public void setActivity(Activity activity, Model model) {

    }
}
