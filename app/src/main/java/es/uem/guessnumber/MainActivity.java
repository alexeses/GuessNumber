package es.uem.guessnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static RandomNumber rN = new RandomNumber();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View layout = findViewById(R.id.main);
        Button btnCheck = findViewById(R.id.botonComparacion);
        TextView nr = findViewById(R.id.numero);
        TextView restantes = findViewById(R.id.textoIntentos);
        TextView msgCentro = findViewById(R.id.textoPista);


        msgCentro.setText(R.string.msg_centro);
        layout.setBackgroundColor(getResources().getColor(R.color.normalBackground));
        btnCheck.setEnabled(true);


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                restantes.setText("Te quedan " + (rN.intentos - 1) + " intentos");

                if (rN.validAttempts()) {
                    if (rN.isCorrect(Integer.parseInt(nr.getText().toString()))) {
                        restantes.setText(getString(R.string.acertado));
                        btnCheck.setText(getString(R.string.endGame));
                        btnCheck.setEnabled(false);
                        layout.setBackgroundColor(getResources().getColor(R.color.correctFinal));
                    } else {

                        if (rN.randomNumber > Integer.parseInt(nr.getText().toString())) {
                            msgCentro.setText(getString(R.string.pistaMayor) + " " + rN.intentos);
                        } else {
                            msgCentro.setText(getString(R.string.pistaMenor) + " " + rN.intentos);
                        }
                    }
                } else {
                    restantes.setText(getString(R.string.noIntentos) + " " + rN.randomNumber);
                    btnCheck.setText(R.string.endGame);
                    btnCheck.setEnabled(false);
                    layout.setBackgroundColor(getResources().getColor(R.color.errorFinal));
                }
            }

        };
        btnCheck.setOnClickListener(listener);
    }

}