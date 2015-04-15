package sw3.proyecto.com.proyectosw3;

import android.util.Xml;

import org.xmlpull.v1.XmlSerializer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by user on 13/04/2015.
 */
public class crearXML {
    public static void guardarPedidos(FileOutputStream lfos_Fos,
                                      gastosPersonales gasto) {
        try {

            XmlSerializer lxs_Serializer = Xml.newSerializer();
            lxs_Serializer = Xml.newSerializer();
            lxs_Serializer.setOutput(lfos_Fos, "UTF-8");
            lxs_Serializer.startDocument(null, Boolean.valueOf(true));
            lxs_Serializer.setFeature(
                    "http://xmlpull.org/v1/doc/features.html#indent-output",
                    true);

                lxs_Serializer.startTag(null, "gastosPersonales");
                lxs_Serializer.startTag(null, "tipoIdentificacion");
                lxs_Serializer.text(gasto.getTipoId());
                lxs_Serializer.endTag(null, "tipoIdentificacion");
            lxs_Serializer.startTag(null, "identificacion");
            lxs_Serializer.text(gasto.getId());
            lxs_Serializer.endTag(null, "identificacion");
            lxs_Serializer.startTag(null, "nombresApellidos");
            lxs_Serializer.text(gasto.getNombres());
            lxs_Serializer.endTag(null, "nombresApellidos");

            lxs_Serializer.startTag(null, "dirNumero");
            lxs_Serializer.text(gasto.getNcalle());
            lxs_Serializer.endTag(null, "dirNumero");
            lxs_Serializer.startTag(null, "dirInterseccion");
            lxs_Serializer.text(gasto.getCalle());
            lxs_Serializer.endTag(null, "dirInterseccion");
            lxs_Serializer.startTag(null, "dirProvincia");
            lxs_Serializer.text(gasto.getProvincia());
            lxs_Serializer.endTag(null, "dirProvincia");
            lxs_Serializer.startTag(null, "dirCanton");
            lxs_Serializer.text(gasto.getParroquia());
            lxs_Serializer.endTag(null, "dirCanton");
            lxs_Serializer.startTag(null, "telefono");
            lxs_Serializer.text(gasto.getTelefono());
            lxs_Serializer.endTag(null, "telefono");
            lxs_Serializer.startTag(null, "periodoFiscal");
            lxs_Serializer.text(gasto.getPeriodo());
            lxs_Serializer.endTag(null, "periodoFiscal");


            lxs_Serializer.startTag(null, "gastos");

                for (int indice = 0; indice < gasto.
                      getDetalles().size(); indice++) {
                    lxs_Serializer.startTag(null, "detalleGasto");
                    lxs_Serializer.startTag(null, "rucProveedor");
                    lxs_Serializer.text(gasto.getDetalles().get(indice).getRucProveedor());
                    lxs_Serializer.endTag(null, "rucProveedor");
                    lxs_Serializer.startTag(null, "totalComprobantesVenta");
                    lxs_Serializer.text(""+gasto.getDetalles().get(indice).getTotalComprobantes());
                    lxs_Serializer.endTag(null, "totalComprobantesVenta");
                    lxs_Serializer.startTag(null, "totalBaseImponible");
                    lxs_Serializer.text(""+gasto.getDetalles().get(indice).getTotalBase());
                    lxs_Serializer.endTag(null, "totalBaseImponible");
                    lxs_Serializer.startTag(null, "tipoGasto");
                    lxs_Serializer.text(gasto.getDetalles().get(indice).getTipoGasto());
                    lxs_Serializer.endTag(null, "tipoGasto");
                    lxs_Serializer.endTag(null, "detalleGasto");
                }
                lxs_Serializer.endTag(null, "gastos");
                lxs_Serializer.endTag(null, "gastosPersonales");

            lxs_Serializer.endDocument();
            lxs_Serializer.flush();
            lfos_Fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
