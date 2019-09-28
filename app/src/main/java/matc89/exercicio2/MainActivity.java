package matc89.exercicio2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btAltUs;
    private TextView tv;
    String aux;
    String aux2;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intentReceiver = getIntent();
        btAltUs = (Button) findViewById(R.id.btnTrocar);
        tv = (TextView) findViewById(R.id.textView);

        Bundle extras = intentReceiver.getExtras();
        if(extras != null) {
            aux = extras.getString("chave_aux");
            if (aux != "" && aux != null)
            tv.setText("Oi, " + aux + "!");
            aux2 = aux;
        }
        else
            tv.setText("Oi!");
    }
    public void goToScreenTwo(View view){

        if(aux == null || aux == "")
        {
            Intent intentActivityTwo = new Intent(getApplicationContext(), ChangeNameActivity.class);
            startActivity(intentActivityTwo);
        }
        else
        {
            aux2 = aux;
        Intent intentSender = new Intent(getApplicationContext(), ChangeNameActivity.class);
        Bundle extras = new Bundle();
        if(extras != null)
            extras.putString("chave_aux2", aux2);
        intentSender.putExtras(extras);
        startActivity(intentSender);
        }
    }


    protected void onSaveInstanceState(Bundle state)
    {
        super.onSaveInstanceState(state);
        state.putString("aux", aux);
    }
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        if (aux != "" && aux != null)
        tv.setText("Oi, " + aux + "!");
        else
            tv.setText("Oi!");
    }
}
