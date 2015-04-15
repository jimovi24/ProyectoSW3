package sw3.proyecto.com.proyectosw3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;


public class Configuracion extends Activity {

    private Spinner spinner;
    private static final String[]paths = {"Cedula", "RUC", "Pasaporte"};
    EditText id;
    EditText nombres;
    EditText calle;
    EditText num_calle;
    EditText prov;
    EditText cant;
    EditText telef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        id = (EditText) findViewById(R.id.editText);
        nombres = (EditText) findViewById(R.id.editText2);
        calle = (EditText) findViewById(R.id.editText3);
        num_calle = (EditText) findViewById(R.id.editText4);
        prov = (EditText) findViewById(R.id.editText5);
        cant = (EditText) findViewById(R.id.editText6);
        telef = (EditText) findViewById(R.id.editText7);

        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Configuracion.this,
                android.R.layout.simple_spinner_item,paths);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_configuracion, menu);
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
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent main= new Intent(getApplicationContext(),MainActivity.class);
        startActivity(main);
        finish();
    }
    public void onClick(View view){


        Intent i = new Intent(this, conf2.class);
        i.putExtra("tipo_id", spinner.getSelectedItem().toString());
        i.putExtra("id", id.getText().toString());
        i.putExtra("nombres", nombres.getText().toString());
        i.putExtra("calle", calle.getText().toString());
        i.putExtra("num_calle", num_calle.getText().toString());
        i.putExtra("prov", prov.getText().toString());
        i.putExtra("cant", cant.getText().toString());
        i.putExtra("telef", telef.getText().toString());
        startActivity(i);
    }
}
