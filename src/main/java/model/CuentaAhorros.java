/*
 * Programa para mostrar información de una cuenta bancaria
 * Autor: Emmanuel Murillo Usuga
 * Fecha: Septiembre 2025
 * Licencia: GNU GPL v3
 */

package model;

public class CuentaAhorros extends Cuenta {
    private boolean activa;

    public CuentaAhorros(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
        this.activa = saldo >= 10000;
    }

    public void consignar(float cantidad) {
        if (activa) {
            super.consignar(cantidad);
        }
    }

    public void retirar(float cantidad) {
        if (activa) {
            super.retirar(cantidad);
        }
    }

    public void extractoMensual() {
        if (numRetiros > 4) {
            comMensual += (numRetiros - 4) * 1000;
        }
        super.extractoMensual();
        activa = saldo >= 10000;
    }

    @Override
    public String imprimir() {
        return "--- Cuenta de Ahorros ---" +
                "\nSaldo: " + saldo +
                "\nComisión mensual: " + comMensual +
                "\nConsignaciones: " + numConsignaciones +
                "\nRetiros: " + numRetiros +
                "\nCuenta activa: " + activa;
    }
}
