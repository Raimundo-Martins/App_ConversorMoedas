package com.raimundo.conversormoedas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.editValor = findViewById(R.id.edit_Valor);
        this.mViewHolder.textDolar = findViewById(R.id.text_Dolar);
        this.mViewHolder.textEuro = findViewById(R.id.text_Euro);
        this.mViewHolder.buttonCalcular = findViewById(R.id.button_Calcular);

        this.mViewHolder.buttonCalcular.setOnClickListener(this);

        this.clearValor();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_Calcular){
            String valor = this.mViewHolder.editValor.getText().toString();
            if ("".equals(valor)){
                Toast.makeText(this, this.getString(R.string.valor_nao_informado), Toast.LENGTH_LONG).show();
            } else {
                Double real = Double.valueOf(valor);

                this.mViewHolder.textDolar.setText(String.format("%.2f", (real / 4)));
                this.mViewHolder.textEuro.setText(String.format("%.2f", (real / 5)));
            }
        }
    }

    private void clearValor(){
        this.mViewHolder.textDolar.setText("");
        this.mViewHolder.textEuro.setText("");
    }

    private static class ViewHolder{
        EditText editValor;
        TextView textDolar;
        TextView textEuro;
        Button buttonCalcular;
    }
}
