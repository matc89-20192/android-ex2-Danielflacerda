package matc89.exercicio2;

        import android.content.Intent;
        import android.net.Uri;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btAltUs;
    private TextView tv;
    String aux;



    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intentReceiver = getIntent();
        btAltUs = (Button) findViewById(R.id.btnTrocar);
        tv = (TextView) findViewById(R.id.textView);

        Bundle extras = intentReceiver.getExtras();
        if(extras != null) {
            aux = extras.getString("chave_texto");
            tv.setText("Oi, " + aux + "!");
        }
        else
            tv.setText("Oi!");
    }
    protected void goToScreenTwo(View view){
        Intent intentActivityTwo = new Intent(getApplicationContext(), ChangeNameActivity.class);
        startActivity(intentActivityTwo);
    }

    protected void onSaveInstanceState(Bundle state)
    {
        super.onSaveInstanceState(state);
        state.putString("aux", aux);
    }
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        tv.setText("Oi, " + aux + "!");
    }
}
