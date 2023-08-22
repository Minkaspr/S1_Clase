package com.mk.s1_clase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tvResultado;
    private EditText etNum1;
    private EditText etNum2;
    Operaciones op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResultado = findViewById(R.id.resultado);
        etNum1 = findViewById(R.id.num1);
        etNum2 = findViewById(R.id.num2);

        op = new Operaciones();

        Button bSumar = findViewById(R.id.btnSumar);
        Button bRestar = findViewById(R.id.btnRestar);
        Button bMultiplicar = findViewById(R.id.btnMultiplicar);
        Button bDividir = findViewById(R.id.btnDividir);

        bSumar.setOnClickListener(view -> opciones("+"));
        bRestar.setOnClickListener(view -> opciones("-"));
        bMultiplicar.setOnClickListener(view -> opciones("*"));
        bDividir.setOnClickListener(view -> opciones("/"));
    }

    private void opciones(String opcion){
        if (!etNum1.getText().toString().isEmpty() && !etNum2.getText().toString().isEmpty()) {
            int num1 = Integer.parseInt(etNum1.getText().toString());
            int num2 = Integer.parseInt(etNum2.getText().toString());

            float resultado = 0;
            String mensaje = "";
            switch (opcion) {
                case "+":
                    resultado = op.Sumar(num1, num2);
                    break;
                case "-":
                    resultado = op.Restar(num1, num2);
                    break;
                case "*":
                    resultado = op.Multiplicar(num1, num2);
                    break;
                case "/":
                    resultado = op.Dividir(num1, num2);
                    if (resultado == 0) {
                        //Toast.makeText(this, "No se puede dividir entre 0", Toast.LENGTH_SHORT).show();
                        mensaje ="No se puede dividir entre 0";
                    }
                    break;
            }
            tvResultado.setText(mensaje.isEmpty() ? String.valueOf(resultado) : mensaje);
        } else {
            Toast.makeText(this, "Llenar los campos", Toast.LENGTH_SHORT).show();
        }
    }
}