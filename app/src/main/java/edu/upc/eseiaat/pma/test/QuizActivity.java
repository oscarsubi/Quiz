package edu.upc.eseiaat.pma.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static edu.upc.eseiaat.pma.test.R.id.text_pregunta;

public class QuizActivity extends AppCompatActivity {

    private int id_respuestas[]={
            R.id.res1, R.id.res2, R.id.res3, R.id.res4
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        TextView Pregunta = (TextView) findViewById(text_pregunta);
        Pregunta.setText(R.string.s_pregunta);

        String[]array_res = getResources().getStringArray(R.array.res);

        //RadioButton rd =(RadioButton) findViewById(R.id.res1);
        for (int i=0; i<id_respuestas.length; i++){
            RadioButton rb = (RadioButton) findViewById(id_respuestas[i]);
            rb.setText(array_res[i]);
        }

        final RadioGroup rg = (RadioGroup) findViewById(R.id.res_group);
        Button bt = (Button) findViewById (R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int id = rg.getCheckedRadioButtonId();
                int respuesta = -1;
                for (int i=0; i<id_respuestas.length; i++){
                    if (id_respuestas[i] == id){
                        respuesta = i;
                    }
                }
                if (respuesta == 1){
                    Toast.makeText(QuizActivity.this, R.string.correcta, Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(QuizActivity.this, R.string.incorrecta, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
