/*
 * Programa para almacenar información de mascotas
 * Autor: Emmanuel Murillo Usuga
 * Fecha: Agosto 2025
 * Licencia: GNU GPL v3
 */

package app;

import model.CuentaAhorros;
import model.CuentaCorriente;
import model.Cuenta;
import javax.swing.JOptionPane;

public class Aplicacion {
    public static void main(String[] args) {

        String[] opcionesCuenta = {"Cuenta de Ahorros", "Cuenta Corriente"};
        int tipoCuenta = JOptionPane.showOptionDialog(
                null,
                "Seleccione el tipo de cuenta:",
                "Tipo De Cuenta",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opcionesCuenta,
                opcionesCuenta[0]);

        float saldoInicial = Float.parseFloat(JOptionPane.showInputDialog("Ingrese saldo inicial:"));
        float tasaAnual = Float.parseFloat(JOptionPane.showInputDialog("Ingrese tasa anual (En porcentaje):"));

        Cuenta cuenta;
        if (tipoCuenta == 0) {
            cuenta = new CuentaAhorros(saldoInicial, tasaAnual);
        } else {
            cuenta = new CuentaCorriente(saldoInicial, tasaAnual);
        }

        boolean salir = false;
        while (!salir) {
            String[] opciones = {
                    "Consignar dinero",
                    "Retirar dinero",
                    "Mostrar extracto mensual",
                    "Mostrar información de la cuenta",
                    "Salir"
            };

            int opcion = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione una opción:",
                    "Menú Cuenta Bancaria",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opciones,
                    opciones[0]);

            switch (opcion) {
                case 0: // consignar
                    float cantConsignar = Float.parseFloat(JOptionPane.showInputDialog("Ingrese cantidad a consignar:"));
                    cuenta.consignar(cantConsignar);
                    JOptionPane.showMessageDialog(null, "Consignación realizada.");
                    break;

                case 1: // retirar
                    float cantRetirar = Float.parseFloat(JOptionPane.showInputDialog("Ingrese cantidad a retirar:"));
                    cuenta.retirar(cantRetirar);
                    JOptionPane.showMessageDialog(null, "Retiro realizado");
                    break;

                case 2: // extracto mensual
                    cuenta.extractoMensual();
                    JOptionPane.showMessageDialog(null, "Extracto mensual realizado");
                    break;

                case 3: // mostrar informacion
                    JOptionPane.showMessageDialog(null, cuenta.imprimir(), "Información de la Cuenta",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;

                case 4: // salir
                default:
                    salir = true;
                    JOptionPane.showMessageDialog(null, "Saliendo . . .");
                    break;
            }
        }
    }
}
