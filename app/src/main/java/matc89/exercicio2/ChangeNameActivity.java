package matc89.exercicio2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ChangeNameActivity extends AppCompatActivity {

    private Button btConf;
    private EditText et;
    private Button btCancel;
    String aux_CA;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_name);

        btConf = (Button) findViewById(R.id.btnConfirmar);
        et = (EditText) findViewById(R.id.editText);
        btCancel = (Button) findViewById(R.id.btnCancelar);

    }

    public void onClickBtnConf(View view){
        aux_CA = et.getText().toString();

        Intent intentSender = new Intent(getApplicationContext(), MainActivity.class);
        Bundle extras = new Bundle();
        if(extras != null)
            extras.putString("chave_texto", aux_CA);
        intentSender.putExtras(extras);
        startActivity(intentSender);
    }
    public void onClickBtnCancel(View view){
        aux_CA = et.getText().toString();

        Intent intentSender = new Intent(getApplicationContext(), MainActivity.class);
        Bundle extras = new Bundle();
        if(extras != null)
            extras.putString("chave_texto", aux_CA);
        intentSender.putExtras(extras);
        startActivity(intentSender);
    }
    protected void onSaveInstanceState(Bundle state)
    {
        super.onSaveInstanceState(state);
    }
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        et.setText("");
    }
}
