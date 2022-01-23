package org.ltejeda.appfacturas.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura {

    private int folio;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private ItemFactura[] itemFactura;
    private int indiceItems;
    private static int ultimoFolio;
    public static final int MAX_ITEMS = 12;

    public Factura(String descripcion, Cliente cliente) {
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.itemFactura = new ItemFactura[MAX_ITEMS];
        this.folio = ++ultimoFolio;
        this.fecha = new Date();
    }

    public int getFolio() {
        return folio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ItemFactura[] getItemFactura() {
        return itemFactura;
    }

    public void addItemFactura(ItemFactura itemFactura){
        if(indiceItems < MAX_ITEMS){
            this.itemFactura[indiceItems++] = itemFactura;
        }
    }

    public float calcularTotal(){
        float total = 0.0f;
        for(ItemFactura itemFactura: this.itemFactura){
            if(itemFactura == null){
                continue;
            }
            total += itemFactura.calcularImporte();
        }
        return total;
    }

    public String generarDetalle(){
        StringBuilder sb = new StringBuilder("Factura N: ");
        sb.append(folio)
                .append("\nCliente: ")
                .append(this.cliente.getNombre())
                .append("\t RUT: ")
                .append(cliente.getRut())
                .append("\nDescripcion: ")
                .append(this.descripcion)
                .append("\n");

        SimpleDateFormat df = new SimpleDateFormat("dd 'de' MMMM, yyyy");
        sb.append("Fecha emision: ")
                .append(df.format(this.fecha))
                .append("\n")
                .append("\n#\tNombre\t$\tCant.\tTotal\n");

        for (ItemFactura itemFactura: this.itemFactura) {
            if(itemFactura == null){
                continue;
            }
            sb.append(itemFactura)
                    .append("\n");
        }
        sb.append("\nGran total: ")
                .append(calcularTotal());

        return sb.toString();
    }

    @Override
    public String toString() {
        return generarDetalle();
    }
}
