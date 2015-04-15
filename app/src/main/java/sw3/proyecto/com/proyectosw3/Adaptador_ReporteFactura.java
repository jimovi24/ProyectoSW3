package sw3.proyecto.com.proyectosw3;

import java.text.DecimalFormat;
import java.util.ArrayList;


import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Adaptador_ReporteFactura extends BaseAdapter {
	ArrayList<detalleGasto> ls_Producto;
	LayoutInflater inflater;

    Adaptador_ReporteFactura() {
		ls_Producto = null;
	}

	public void setInflater(LayoutInflater inf) {
		inflater = inf;
	}

	public Adaptador_ReporteFactura(
			ArrayList<detalleGasto> pal_Detalle) {
		ls_Producto = pal_Detalle;
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return ls_Producto.size();
	}

	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public long getItemId(int pi_Posicion) {
		// TODO Auto-generated method stub
		return pi_Posicion;
	}

	@SuppressLint("ViewHolder")
	public View getView(int pi_Posicion, View pv_ConvertView,
			ViewGroup pvg_Parent) {
		View lv_Fila;
		lv_Fila = inflater.inflate(R.layout.lista_reportefactura, pvg_Parent, false);
        TextView ruc,rubro, total, cantidad;
		ruc = (TextView) lv_Fila.findViewById(R.id.tv_Ruc);
        rubro = (TextView) lv_Fila.findViewById(R.id.tv_rubro);
        total = (TextView) lv_Fila.findViewById(R.id.tv_total);
        cantidad = (TextView) lv_Fila.findViewById(R.id.tv_cantidad);

        ruc.setText(ls_Producto.get(pi_Posicion).getRucProveedor());
        rubro.setText(ls_Producto.get(pi_Posicion).getTipoGasto());
        total.setText(""+ls_Producto.get(pi_Posicion).getTotalBase());
        cantidad.setText(""+ls_Producto.get(pi_Posicion).getTotalComprobantes());

		return (lv_Fila);
	}
}
