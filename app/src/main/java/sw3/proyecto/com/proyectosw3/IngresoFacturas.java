package sw3.proyecto.com.proyectosw3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class IngresoFacturas extends Activity {
    private Spinner spinner;
    private static final String[]paths = {"Vivienda", "Alimentacion", "Salud","Educacion","Vestimenta"};
    private EditText rubroField,facturaField, fechaField, valorField, rucField;

    SQLiteDB base=new SQLiteDB(this, "base", null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso_facturas);

        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(IngresoFacturas.this,
                android.R.layout.simple_spinner_item,paths);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        //Ingreso de variables
        rubroField = (EditText) findViewById(R.id.EdtextRubro);
         facturaField = (EditText) findViewById(R.id.EdtextFactura);
         rucField = (EditText) findViewById(R.id.EdtextRuc);
         fechaField = (EditText) findViewById(R.id.EdtextFecha);
         valorField = (EditText) findViewById(R.id.EdtextValor);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ingreso_facturas, menu);
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

    public void ingresar(View view){
        Toast.makeText(this,""+rubroField.getText().toString(),Toast.LENGTH_LONG).show();
        Toast.makeText(this,""+facturaField.getText().toString(),Toast.LENGTH_LONG).show();
        Toast.makeText(this,""+rucField.getText().toString(),Toast.LENGTH_LONG).show();
        Toast.makeText(this,""+fechaField.getText().toString(),Toast.LENGTH_LONG).show();
        Toast.makeText(this,""+Double.parseDouble(valorField.getText().toString()),Toast.LENGTH_LONG).show();


        base.insertar(rubroField.getText().toString(),facturaField.getText().toString(),
                rucField.getText().toString(),fechaField.getText().toString(),Double.parseDouble(valorField.getText().toString()));
    }
}
