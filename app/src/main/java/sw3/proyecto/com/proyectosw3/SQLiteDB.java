package sw3.proyecto.com.proyectosw3;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;


public class SQLiteDB extends SQLiteOpenHelper {

    //Sentencia SQL para crear la tabla de Usuarios
    String sqlCreate = "CREATE TABLE factura (rubro VARCHAR(20), num_factura VARCHAR(45), ruc VARCHAR(13), fecha_fact DATE, valor DOUBLE)";

    public SQLiteDB(Context contexto, String nombre,
                    CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }
    private SQLiteDatabase db1;



    @Override
    public void onCreate(SQLiteDatabase db) {
        //Se ejecuta la sentencia SQL de creación de la tabla
        db.execSQL(sqlCreate);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
        //NOTA: Por simplicidad del ejemplo aquí utilizamos directamente la opción de
        //      eliminar la tabla anterior y crearla de nuevo vacía con el nuevo formato.
        //      Sin embargo lo normal será que haya que migrar datos de la tabla antigua
        //      a la nueva, por lo que este método debería ser más elaborado.

        //Se elimina la versión anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS factura");

        //Se crea la nueva versión de la tabla
        db.execSQL(sqlCreate);
    }


    public boolean insertar(String rubro, String num_factura,String ruc,String fecha_fact,double valor){

        boolean resultado=false;
        db1 = this.getWritableDatabase();
        try{

            String query="INSERT INTO factura(rubro, num_factura, ruc, fecha_fact, valor) VALUES('"+rubro+"','"+num_factura+"','"+

                    ruc+"','"+fecha_fact+"','"+valor+"')";

            db1.execSQL(query);

            resultado=true;

            return resultado;
        }

        catch (Exception e){

            resultado=false;

            return resultado;

        }
    }

    public  ArrayList<detalleGasto> ConsultaGastos(String fiscal){

        db1 = this.getWritableDatabase();
        String valor="";
        ArrayList<detalleGasto>  detalles= new ArrayList<>();
        detalleGasto detalle= new detalleGasto();
        //Cursor c = db1.query("factura",new String[]{"ruc"}, null, null, null, null,
                //null);
        Cursor c = db1.rawQuery("SELECT ruc,sum(valor),count(num_factura),rubro from factura GROUP BY ruc,rubro", null);
        if (c.moveToFirst()) {
            do {
                detalle= new detalleGasto();
                detalle.setRucProveedor(c.getString(c.getColumnIndex("ruc")));
                detalle.setTipoGasto(c.getString(c.getColumnIndex("rubro")));
                detalle.setTotalBase(c.getDouble(c.getColumnIndex("sum(valor)")));
                detalle.setTotalComprobantes(c.getInt(c.getColumnIndex("count(num_factura)")));
                detalles.add(detalle);
            }while(c.moveToNext());
        }


        c.close();

        for (int i=0;i<detalles.size();i++){
            Log.v("BD","Ruc:"+detalles.get(i).getRucProveedor());
            Log.v("BD","Tipo:" +detalles.get(i).getTipoGasto());
            Log.v("BD","Total: "+detalles.get(i).getTotalBase());
            Log.v("BD","N Comprobantes: "+detalles.get(i).getTotalComprobantes());
    }

        return detalles;
    }
}
