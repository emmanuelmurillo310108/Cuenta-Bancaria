/*
 * Programa para mostrar información de una cuenta bancaria
 * Autor: Emmanuel Murillo Usuga
 * Fecha: Septiembre 2025
 * Licencia: GNU GPL v3
 */

package model;

public class CuentaCorriente extends Cuenta {
    private float sobregiro;

    public CuentaCorriente(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
        this.sobregiro = 0;
    }

    public float getSobregiro() {
        return sobregiro;
    }

    public void setSobregiro(float sobregiro) {
        this.sobregiro = sobregiro;
    }

    public void retirar(float cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
        } else {
            float faltante = cantidad - saldo;
            saldo = 0;
            sobregiro += faltante;
        }
        numRetiros++;
    }


    public void consignar(float cantidad) {
        if (sobregiro > 0) {
            if (cantidad >= sobregiro) {
                cantidad -= sobregiro;
                sobregiro = 0;
                saldo += cantidad;
            } else {
                sobregiro -= cantidad;
            }
        } else {
            super.consignar(cantidad);
        }
        numConsignaciones++;
    }

    public void extractoMensual() {
        super.extractoMensual();
    }

    public String imprimir() {
        return "--- Cuenta Corriente ---" +
                "\nSaldo: " + saldo +
                "\nComisión mensual: " + comMensual +
                "\nTransacciones totales: " + (numConsignaciones + numRetiros) +
                "\nSobregiro: " + sobregiro;
    }
}

