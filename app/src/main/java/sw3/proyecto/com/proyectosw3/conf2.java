package sw3.proyecto.com.proyectosw3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class conf2 extends Activity {

    EditText vivienda;
    EditText alimentacion;
    EditText salud;
    EditText educacion;
    EditText vestimenta;
    EditText fiscal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conf2);
        vivienda = (EditText) findViewById(R.id.editText8);
        alimentacion = (EditText) findViewById(R.id.editText9);
        salud = (EditText) findViewById(R.id.editText10);
        educacion = (EditText) findViewById(R.id.editText11);
        vestimenta = (EditText) findViewById(R.id.editText12);
        fiscal = (EditText) findViewById(R.id.editText13);
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


        float sum = Float.parseFloat(vivienda.getText().toString())+Float.parseFloat(alimentacion.getText().toString())+Float.parseFloat(salud.getText().toString())
        +Float.parseFloat(educacion.getText().toString())+Float.parseFloat(vestimenta.getText().toString());

        if(sum>=17550){
            Toast.makeText(this,"Los rubros no deben ser mayores a 17000",Toast.LENGTH_LONG).show();
            vivienda.setText("");
            alimentacion.setText("");
            salud.setText("");
            educacion.setText("");
            vestimenta.setText("");
        }else{
            getIntent().getStringExtra("tipo_id");
            getIntent().getStringExtra("id");
            getIntent().getStringExtra("nombres");
            getIntent().getStringExtra("calle");
            getIntent().getStringExtra("num_calle");
            getIntent().getStringExtra("prov");
            getIntent().getStringExtra("cant");
            getIntent().getStringExtra("telef");

            String shared = "Config";
            SharedPreferences sharedPref = getSharedPreferences(shared, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("tipo_id", getIntent().getStringExtra("tipo_id"));
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

            Toast.makeText(getApplicationContext(),"Configuración Guardada",Toast.LENGTH_LONG).show();

            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            finish();
        }
        /*PARA LEER LOS DATOS EN EL SHARED PREFERENCES*/
        /*
        String shared = "Config";
        SharedPreferences settings=getSharedPreferences(shared,Context.MODE_PRIVATE);
        String tipo_id = settings.getString("tipo_id", "");
        String id = settings.getString("id", "");
        String nombres = settings.getString("nombres", "");
        String calle = settings.getString("calle", "");
        String num_calle = settings.getString("num_calle", "");
        String prov = settings.getString("prov", "");
        String cant = settings.getString("cant", "");
        String telef = settings.getString("telef", "");
        String viv = settings.getString("vivienda",null);
        String alimen = settings.getString("alimentacion", null);
        String sal = settings.getString("salud", null);
        String edu = settings.getString("educacion", null);
        String vest = settings.getString("vestimenta", null);
        String fis = settings.getString("fiscal", null);
        */
    }
}
