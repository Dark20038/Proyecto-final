package proyecto.pkgfinal;

import java.util.Scanner;

public class ProcesosProyecto { 
    public static void Menu(){
        //Scanner 
        Scanner teclado = new Scanner(System.in);
        
        //Lineas decorativas 
        String linea = "========================================";
        String guiones = "----------------------------------------";
  
        //variables 
        int op;
        int salir = 0;
        
        int ventas = 0;
        int productosVendidos = 0;
        int ventasEfectivo = 0;
        int ventasTarjeta = 0;
        int ventasTransferencia = 0;
        double totalVendido = 0;
        double ventaMayor = 0;
        double ventaMenor = 0;
       
       do{
           System.out.println();
           System.out.println(linea);
           System.out.println("          SISTEMA DE VENTAS");
           System.out.println(linea);
           System.out.println("  1. Registrar una venta");
           System.out.println("  2. Consultar caja");
           System.out.println("  3. Mostrar estadisticas");
           System.out.println("  4. Salir");
           System.out.println(guiones);
           System.out.println("  Ingrese la opcion: ");
            System.out.println(guiones);
           op = teclado.nextInt();
           System.out.println(linea);
           System.out.println();
           
           switch (op){
               case 1:
                   System.out.println(linea);
                   System.out.println("          REGISTRO DE VENTA");
                   System.out.println(linea);
                    
                   //cantidad de productos 
                   System.out.println("  ¿Cuantos productos tendra la compra?");
                   int cantidadProductos = teclado.nextInt();
                   while(cantidadProductos <= 0){
                       System.out.println("  Debe ser mayor que cero. Intente de nuevo: ");
                       cantidadProductos = teclado.nextInt();
                   }
                   
                   double subtotal = 0;
                   int unidades = 0;
                   
                   //ingreso de productos 
                   for (int i = 1; i <= cantidadProductos; i++){
                       System.out.println();
                       System.out.println(guiones);
                       System.out.println("  Producto " + i +" de " + cantidadProductos);
                       System.out.println(guiones);
                       
                       System.out.println("  Codigo: ");
                       String codigo = teclado.next();
                       teclado.nextLine();
                       
                       System.out.println("  Nombre: ");
                       String nombre = teclado.nextLine();
                       
                       System.out.println("  Precio: Q");
                       double precio = teclado.nextDouble();
                       while(precio <= 0) {
                           System.out.println("  El precio tiene que ser mayor a cero. Intente de nuevo: Q");
                           precio = teclado.nextDouble();
                       }
                       
                       System.out.println("  Cantidad: ");
                       int cantidad = teclado.nextInt();
                       while (cantidad <= 0){
                           System.out.println("  La cantidad debe ser mayor que cero. Intente de nuevo: ");
                           cantidad = teclado.nextInt();
                       }
                       subtotal = subtotal + (precio * cantidad);
                       unidades = unidades + cantidad;
                       
                   }
                   //descuento
                   double porcentaje;
                   if (subtotal < 200){
                       porcentaje = 0;
                   }else if (subtotal < 500){
                       porcentaje = 0.05;
                   }else if (subtotal < 1000){
                       porcentaje = 0.08;    
                   }else {
                       porcentaje = 0.10;
                   }
                   
                   double descuento = subtotal * porcentaje;
                   double montoDescuento = subtotal - descuento;
                   double iva = montoDescuento * 0.12;
                   double total = montoDescuento + iva;
                   
                   System.out.println();
                   System.out.println(guiones);
                   System.out.printf("Total a pagar: Q%.2f%n", total);
                   System.out.println(guiones);
                   
                   //forma de pago
                  System.out.println();
                    System.out.println(linea);
                    System.out.println("            FORMA DE PAGO");
                    System.out.println(linea);
                    System.out.println("  1. Efectivo");
                    System.out.println("  2. Tarjeta");
                    System.out.println("  3. Transferencia");
                    System.out.println(guiones);
                    System.out.print("  Seleccione: ");
                    int formaPago = teclado.nextInt();
                    while (formaPago < 1 || formaPago > 3) {
                        System.out.print("  Opcion invalida. Seleccione 1, 2 o 3: ");
                        formaPago = teclado.nextInt();
                   }
                   String nombrePago = "";
                   double recibido = 0;
                   double cambio = 0;
                   int aprobacion = 0;
                   boolean pago = true;
                   
                   switch (formaPago){
                       case 1:
                           nombrePago = "Efectivo";
                           System.out.print("  Efectivo recibido: Q");
                           recibido = teclado.nextInt();
                           while (recibido < total){
                               System.out.print("  Efectivo insuficiente. Ingrese de nuevo: Q");
                               recibido = teclado.nextDouble();
                           }
                           cambio = recibido - total;
                           ventasEfectivo++;
                           break;
                       case 2: 
                           System.out.println();
                            System.out.println("  Inserte tarjeta en el pinpad");
                            System.out.println("  ...");
                            System.out.println("  ...");
                            System.out.println("  La transaccion fue aprobada?");
                            System.out.println("  1. Si");
                            System.out.println("  2. No");
                            System.out.print("  Seleccione: ");
                            aprobacion = teclado.nextInt();
                            while (aprobacion < 1 || aprobacion > 2) {
                                System.out.print("  Opcion invalida. Seleccione 1 o 2: ");
                                aprobacion = teclado.nextInt();
                       }
                       if (aprobacion == 1) {
                          pago = true;
                          ventasTarjeta++;
                          nombrePago = "Tarjeta";
                        } else {
                        pago = false;
                        }
                           break;
                       case 3:
                         System.out.println();
                         System.out.println("  La transferencia fue recibida?");
                         System.out.println("  1. Si");
                         System.out.println("  2. No");
                         System.out.print("  Seleccione: ");
                         aprobacion = teclado.nextInt();
                         while (aprobacion < 1 || aprobacion > 2) {
                                System.out.print("  Opcion invalida. Seleccione 1 o 2: ");
                                aprobacion = teclado.nextInt();
                       }
                       if (aprobacion == 1) {
                           pago = true;
                           ventasTransferencia++;
                           nombrePago = "Transferencia";
                       } else {
                           pago = false;
                       }
                           break;
                   }
                   
                   if (pago) {
                        ventas++;
                        productosVendidos = productosVendidos + unidades;
                        totalVendido = totalVendido + total;

                      if (ventas == 1) {
                            ventaMayor = total;
                            ventaMenor = total;
                      } else {
                          if (total > ventaMayor) {
                                ventaMayor = total;
                            }
                            if (total < ventaMenor) {
                                ventaMenor = total;
                            }
                   }
                   
                  System.out.println();
                  System.out.println(linea);
                  System.out.println("           RESUMEN DE VENTA");
                  System.out.println(linea);
                  System.out.println("  Cantidad de productos: " + unidades);
                  System.out.printf("  Subtotal:   Q%.2f%n", subtotal);
                  System.out.printf("  Descuento:  Q%.2f%n", descuento);
                  System.out.printf("  IVA:        Q%.2f%n", iva);
                  System.out.println(guiones);
                  System.out.printf("  TOTAL:      Q%.2f%n", total);
                  System.out.println(guiones);
                  System.out.println("  Forma de pago: " + nombrePago);
                  if (formaPago == 1) {
                      System.out.printf("  Efectivo recibido: Q%.2f%n", recibido);
                      System.out.printf("  Cambio:            Q%.2f%n", cambio);
                  }
                  System.out.println(linea);
                 } else {
                      System.out.println();
                      System.out.println(guiones);
                      System.out.println("  Pago rechazado. La venta fue cancelada.");
                      System.out.println(guiones);
                 }
                 break;
               
               case 2:
                   //consultar caja
                   System.out.println(linea);
                   System.out.println("            CONSULTA DE CAJA");
                   System.out.println(linea);
                   System.out.println("  Ventas realizadas:        " + ventas);
                   System.out.println("  Productos vendidos:       " + productosVendidos);
                   System.out.printf("  Total vendido:            Q%.2f%n", totalVendido);
                   System.out.println(guiones);
                   System.out.println("  Ventas en efectivo:       " + ventasEfectivo);
                   System.out.println("  Ventas con tarjeta:       " + ventasTarjeta);
                   System.out.println("  Ventas por transferencia: " + ventasTransferencia);
                   System.out.println(linea);
                   break;
                   
               case 3:
                   //mostrar estadisticas 
                   System.out.println(linea);
                   System.out.println("             ESTADISTICAS");
                   System.out.println(linea);
                   if (ventas == 0) {
                        System.out.println("  No existen ventas registradas.");
                   } else {
                       double promedio = totalVendido / ventas;

                       System.out.println("  Numero total de ventas:     " + ventas);
                       System.out.println("  Productos vendidos:         " + productosVendidos);
                       System.out.printf("  Total de dinero vendido:    Q%.2f%n", totalVendido);
                       System.out.printf("  Promedio de dinero por venta: Q%.2f%n", promedio);
                       System.out.println(guiones);
                       System.out.println("  Ventas por forma de pago:");
                       System.out.println("    Efectivo:      " + ventasEfectivo);
                       System.out.println("    Tarjeta:       " + ventasTarjeta);
                       System.out.println("    Transferencia: " + ventasTransferencia);
                       System.out.println(guiones);
                       System.out.printf("  Venta de mayor valor: Q%.2f%n", ventaMayor);
                       System.out.printf("  Venta de menor valor: Q%.2f%n", ventaMenor);
                   }
                   System.out.println(linea);
                   break; 
               case 4:
                    salir = 1;
                    System.out.println(linea);
                    System.out.println("  Gracias por usar el sistema. Hasta pronto!");
                    System.out.println(linea);
                    break;

                default:
                    System.out.println(guiones);
                    System.out.println("  Opcion invalida");
                    System.out.println(guiones);
            }

        } while (salir != 1);

        teclado.close();
    }
}
