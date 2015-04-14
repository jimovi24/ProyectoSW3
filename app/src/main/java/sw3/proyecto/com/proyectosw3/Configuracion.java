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
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;


public class Configuracion extends Activity {

    private Spinner spinner;
    private static final String[]paths = {"Cedula", "RUC", "Pasaporte"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

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

        TextView id = (TextView) findViewById(R.id.editText);
        TextView nombres = (TextView) findViewById(R.id.editText2);
        TextView calle = (TextView) findViewById(R.id.editText3);
        TextView num_calle = (TextView) findViewById(R.id.editText4);
        TextView prov = (TextView) findViewById(R.id.editText5);
        TextView cant = (TextView) findViewById(R.id.editText6);
        TextView telef = (TextView) findViewById(R.id.editText7);

        Intent i = new Intent(this, conf2.class);
        i.putExtra("id", id.getText());
        i.putExtra("nombres", nombres.getText());
        i.putExtra("calle", calle.getText());
        i.putExtra("num_calle", num_calle.getText());
        i.putExtra("prov", prov.getText());
        i.putExtra("cant", cant.getText());
        i.putExtra("telef", telef.getText());
        startActivity(i);
    }
}
