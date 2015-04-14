package sw3.proyecto.com.proyectosw3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;


public class SQLiteDB extends SQLiteOpenHelper {

    //Sentencia SQL para crear la tabla de Usuarios
    String sqlCreate = "CREATE TABLE factura (rubro VARCHAR(20), num_factura VARCHAR(45), ruc VARCHAR(45), fecha_fact DATE, valor DOUBLE)";

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
        db.execSQL("DROP TABLE IF EXISTS detalle_gastos");

        //Se crea la nueva versión de la tabla
        db.execSQL(sqlCreate);
    }

    public boolean insertar(String rubro, String num_factura,String ruc,String fecha_fact,double valor){

        boolean resultado=false;

        try{

            String query="INSERT INTO detalle_gastos(rubro, num_factura, ruc, fecha_fact, valor) VALUES('"+rubro+"','"+num_factura+"','"+

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
}
