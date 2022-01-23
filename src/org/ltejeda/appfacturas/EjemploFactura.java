package org.ltejeda.appfacturas;

import org.ltejeda.appfacturas.modelo.Cliente;
import org.ltejeda.appfacturas.modelo.Factura;
import org.ltejeda.appfacturas.modelo.ItemFactura;
import org.ltejeda.appfacturas.modelo.Producto;

import java.util.Scanner;

public class EjemploFactura {
    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        cliente.setRut("8000.01445-1");
        cliente.setNombre("LuisNe");

        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese la descripcion de la factura: ");
        String descripcion = s.nextLine();
        Factura factura = new Factura(descripcion,cliente);

        Producto producto;

        System.out.println();

        for (int i = 0; i < 4; i++) {
            producto = new Producto();
            System.out.print("Ingrese producto no. " + producto.getCodigo() + ": " );
            producto.setNombre(s.nextLine());

            System.out.print("Ingrese el precio: ");
            producto.setPrecio(s.nextFloat());

            System.out.print("Ingrese la cantidad: ");
            factura.addItemFactura(new ItemFactura(s.nextInt(), producto));

            System.out.println();
            s.nextLine();
        }
        System.out.println(factura);
    }
}
