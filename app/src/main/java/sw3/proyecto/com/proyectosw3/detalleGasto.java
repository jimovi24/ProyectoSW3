package sw3.proyecto.com.proyectosw3;

/**
 * Created by user on 13/04/2015.
 */
public class detalleGasto {
    private String RucProveedor;
    private String tipoGasto;
    private Double totalBase;
    private int totalComprobantes;


    public String getRucProveedor() {
        return RucProveedor;
    }

    public void setRucProveedor(String rucProveedor) {
        RucProveedor = rucProveedor;
    }

    public String getTipoGasto() {
        return tipoGasto;
    }

    public void setTipoGasto(String tipoGasto) {
        this.tipoGasto = tipoGasto;
    }

    public Double getTotalBase() {
        return totalBase;
    }

    public void setTotalBase(Double totalBase) {
        this.totalBase = totalBase;
    }

    public int getTotalComprobantes() {
        return totalComprobantes;
    }

    public void setTotalComprobantes(int totalComprobantes) {
        this.totalComprobantes = totalComprobantes;
    }
}
