package sw3.proyecto.com.proyectosw3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends Activity {
    ListView lv_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_main= (ListView) findViewById(R.id.lv_main);

        String [] lista= {"Ingreso de Facturas", "Reporte de Factura"};
        ArrayAdapter adaptador = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, lista );
        lv_main.setAdapter(adaptador);
lv_main.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0) {
            Intent ingreso= new Intent(getApplicationContext(),IngresoFacturas.class);
            startActivity(ingreso);
            finish();
        } else if (position == 1)
        {
            Intent reporte= new Intent(getApplicationContext(),ReporteFacturas.class);
            startActivity(reporte);
            finish();
        }

    }
});

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            Intent configuracion= new Intent(getApplicationContext(),Configuracion.class);
            startActivity(configuracion);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
