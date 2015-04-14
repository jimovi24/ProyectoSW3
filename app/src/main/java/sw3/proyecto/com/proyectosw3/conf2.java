package sw3.proyecto.com.proyectosw3;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class conf2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conf2);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_conf2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void guardar(View view){

        TextView vivienda = (TextView) findViewById(R.id.editText8);
        TextView alimentacion = (TextView) findViewById(R.id.editText9);
        TextView salud = (TextView) findViewById(R.id.editText10);
        TextView educacion = (TextView) findViewById(R.id.editText11);
        TextView vestimenta = (TextView) findViewById(R.id.editText12);
        TextView fiscal = (TextView) findViewById(R.id.editText13);

        getIntent().getStringExtra("id");
        getIntent().getStringExtra("nombres");
        getIntent().getStringExtra("calle");
        getIntent().getStringExtra("num_calle");
        getIntent().getStringExtra("prov");
        getIntent().getStringExtra("cant");
        getIntent().getStringExtra("telef");

        String shared = "Config";
        SharedPreferences.Editor editor = getSharedPreferences(shared, MODE_PRIVATE).edit();
        editor.putString("id", getIntent().getStringExtra("id"));
        editor.putString("nombres", getIntent().getStringExtra("nombres"));
        editor.putString("calle", getIntent().getStringExtra("calle"));
        editor.putString("num_calle", getIntent().getStringExtra("num_calle"));
        editor.putString("prov", getIntent().getStringExtra("prov"));
        editor.putString("cant", getIntent().getStringExtra("cant"));
        editor.putString("telef", getIntent().getStringExtra("telef"));
        editor.putString("vivienda", vivienda.getText().toString());
        editor.putString("alimentacion", alimentacion.getText().toString());
        editor.putString("salud", salud.getText().toString());
        editor.putString("educacion", educacion.getText().toString());
        editor.putString("vestimenta", vestimenta.getText().toString());
        editor.putString("fiscal", fiscal.getText().toString());


        editor.commit();
    }
}
