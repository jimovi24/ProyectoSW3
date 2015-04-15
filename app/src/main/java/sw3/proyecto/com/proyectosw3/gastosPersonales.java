package sw3.proyecto.com.proyectosw3;

import java.util.ArrayList;

/**
 * Created by user on 13/04/2015.
 */
public class gastosPersonales {
private String nombres;
    private String calle;
    private String ncalle;
    private String provincia;
    private String parroquia;
    private String telefono;
    private String vivienda;
    private String id;
    private String tipoId;
    private String periodo;


    private ArrayList<detalleGasto> detalles;

    public ArrayList<detalleGasto> getDetalles() {
        return detalles;
    }

    public void setDetalles(ArrayList<detalleGasto> detalles) {
        this.detalles = detalles;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNcalle() {
        return ncalle;
    }

    public void setNcalle(String ncalle) {
        this.ncalle = ncalle;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getParroquia() {
        return parroquia;
    }

    public void setParroquia(String parroquia) {
        this.parroquia = parroquia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getVivienda() {
        return vivienda;
    }

    public void setVivienda(String vivienda) {
        this.vivienda = vivienda;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoId() {
        return tipoId;
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
}
