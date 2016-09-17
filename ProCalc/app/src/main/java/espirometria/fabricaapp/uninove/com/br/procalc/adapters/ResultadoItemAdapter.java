package espirometria.fabricaapp.uninove.com.br.procalc.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import espirometria.fabricaapp.uninove.com.br.procalc.R;
import espirometria.fabricaapp.uninove.com.br.procalc.models.ResultadoItem;


/**
 * Created by internet on 10/09/2016.
 */
public class ResultadoItemAdapter extends BaseAdapter {
    private ArrayList<ResultadoItem> lsResultado;
    private Context context;
    private static LayoutInflater inflater=null;

    public ResultadoItemAdapter(Context context, ArrayList<ResultadoItem> lsResultado){
        this.context = context;
        this.lsResultado = lsResultado;
        inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return this.lsResultado.size();
    }

    @Override
    public ResultadoItem getItem(int position) {
        return this.lsResultado.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView =  inflater.inflate(R.layout.item_resultado, null);

        TextView txtTitulo = (TextView)convertView.findViewById(R.id.txtTitulo);
        TextView txtPrevisto = (TextView)convertView.findViewById(R.id.txtPrevisto);
        TextView txtLimite = (TextView)convertView.findViewById(R.id.txtLimite);

        ResultadoItem res = getItem(position);
        if(res==null){
            System.out.print("Veio nullo");
        }
        txtTitulo.setText(res.getTitulo());
        txtPrevisto.setText(String.valueOf(res.getPrevisto()));
        txtLimite.setText(String.valueOf(res.getInferior()));

        return convertView;


    }
}
