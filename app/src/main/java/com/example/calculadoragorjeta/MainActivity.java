package com.example.calculadoragorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText textValorConta;
    private TextView tvPorcentagem, tvValorGorjeta, tvValorTotal;
    private SeekBar seekBarProgresso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textValorConta = findViewById(R.id.tietValorConta);
        tvPorcentagem = findViewById(R.id.textViewPorcentagem);
        tvValorGorjeta = findViewById(R.id.tvValorGorjeta);
        tvValorTotal = findViewById(R.id.tvTotal);
        seekBarProgresso = findViewById(R.id.seekBarProgresso);

        seekBarGorjeta();
    }


    public void seekBarGorjeta() {

        seekBarProgresso.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tvPorcentagem.setText(i + "%");
                ContarGorjeta();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void ContarGorjeta() {

        String textoRecuperado = textValorConta.getText().toString();

        if (textoRecuperado == null || textoRecuperado.equals("")) {

            Toast.makeText(getApplicationContext(), "Informe o valor da Nota", Toast.LENGTH_SHORT).show();
        } else {
            Double recuperarValorConta = Double.parseDouble(textoRecuperado);
            Double sumCalculo = ((recuperarValorConta * seekBarProgresso.getProgress()) / 100);
            tvValorGorjeta.setText("R$ " + String.format("%.2f", sumCalculo));
            tvValorTotal.setText("R$ " + String.format("%.2f", (recuperarValorConta + sumCalculo)));

        }


    }


}