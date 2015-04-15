package sw3.proyecto.com.proyectosw3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;


public class ReporteFacturas extends Activity {
    TextView id,nombre,tipoId,direccion;
    ListView listaReporte;
    gastosPersonales gastos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte_facturas);
        id=(TextView)findViewById(R.id.tv_id);
        nombre=(TextView)findViewById(R.id.tv_nombre);
        tipoId=(TextView)findViewById(R.id.tv_tipoId);
        direccion=(TextView)findViewById(R.id.tv_Direccion);
        listaReporte=(ListView)findViewById(R.id.lista_Reporte);
        gastos= new gastosPersonales();
        String shared = "Config";

        SharedPreferences settings=getSharedPreferences(shared, Context.MODE_PRIVATE);
        String tipo_id = settings.getString("tipo_id", "");
        String id1 = settings.getString("id", "");
        String nombres = settings.getString("nombres", "");
        String calle = settings.getString("calle", "");
        String num_calle = settings.getString("num_calle", "");
        String prov = settings.getString("prov", "");
        String cant = settings.getString("cant", "");
        String telef = settings.getString("telef", "");
        String viv = settings.getString("vivienda",null);
        String fis = settings.getString("fiscal", null);


        id.setText(id1);
        nombre.setText(nombres);
        tipoId.setText(tipo_id);
        direccion.setText(calle+" "+ num_calle);
        gastos.setId(id1);
        gastos.setNombres(nombres);
        gastos.setTipoId(tipo_id);
        gastos.setCalle(calle);
        gastos.setNcalle(num_calle);
        gastos.setParroquia(cant);
        gastos.setPeriodo(fis);
        gastos.setProvincia(prov);
        gastos.setTelefono(telef);
        gastos.setVivienda(viv);

        SQLiteDB base=new SQLiteDB(getApplicationContext(), "base", null,1);
        gastos.setDetalles(base.ConsultaGastos(gastos.getPeriodo()));
        Adaptador_ReporteFactura adaptador = new Adaptador_ReporteFactura(base.ConsultaGastos(gastos.getPeriodo()));
        adaptador
                .setInflater((LayoutInflater) getApplicationContext()
                        .getSystemService(
                                Context.LAYOUT_INFLATER_SERVICE));
        listaReporte.setAdapter(adaptador);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_reporte_facturas, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_descarga) {

            try {
                File file = new File(Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_DOWNLOADS), "GastosPersonales.txt");
                FileOutputStream fileos = new FileOutputStream(file);

                crearXML.guardarPedidos(fileos, gastos);
                Toast.makeText(getApplicationContext(),"ver Descargas", Toast.LENGTH_LONG).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
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
}
