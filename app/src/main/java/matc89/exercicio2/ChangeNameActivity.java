package matc89.exercicio2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ChangeNameActivity extends AppCompatActivity {

    private Button btConf;
    private EditText et;
    private Button btCancel;
    String aux_CA;
    static String aux_CA2;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_name);
        Toast.makeText(this, "Entrou man", Toast.LENGTH_SHORT).show();

        Intent intentReceiver = getIntent();
        btConf = (Button) findViewById(R.id.btnConfirmar);
        et = (EditText) findViewById(R.id.editText);
        btCancel = (Button) findViewById(R.id.btnCancelar);

        Bundle extras = intentReceiver.getExtras();
        if(extras != null)
            aux_CA2 = extras.getString("chave_aux2");
        et.setText(aux_CA2);
    }

    public void onClickBtnConf(View view){
        aux_CA = et.getText().toString();

        if(!et.getText().toString().equals(""))
        {
            Toast.makeText(this, "Entrou man", Toast.LENGTH_SHORT).show();
        Intent intentSender = new Intent(getApplicationContext(), MainActivity.class);
        Bundle extras = new Bundle();
        if(extras != null)
            extras.putString("chave_aux", aux_CA);
        intentSender.putExtras(extras);
        startActivity(intentSender);
        }
        else
        {
            Intent intentScreenMain = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intentScreenMain);
            finish();
        }
    }
    public void onClickBtnCancel(View view){
        Intent intentScreenMain = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intentScreenMain);
    }
    protected void onSaveInstanceState(Bundle state)
    {
        super.onSaveInstanceState(state);
        state.putString("aux_CA", aux_CA);
    }
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        et.setText(aux_CA2);
    }
    public void onResume() {
        super.onResume();
        et.setText(aux_CA2);

    }
}
