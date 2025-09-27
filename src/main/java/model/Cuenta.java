/*
 * Programa para mostrar información de una cuenta bancaria
 * Autor: Emmanuel Murillo Usuga
 * Fecha: Septiembre 2025
 * Licencia: GNU GPL v3
 */

package model;

public class Cuenta {
    protected float saldo;
    protected int numConsignaciones;
    protected int numRetiros;
    protected float tasaAnual;
    protected float comMensual;

    public Cuenta(float saldo, float tasaAnual) {
        this.saldo = saldo;
        this.tasaAnual = tasaAnual;
        this.numConsignaciones = 0;
        this.numRetiros = 0;
        this.comMensual = 0;
    }

    public void consignar(float cantidad) {
        saldo += cantidad;
        numConsignaciones++;
    }

    public void retirar(float cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
            numRetiros++;
        }
    }

    public float calcularInteresMensual() {
        float interesMensual = (tasaAnual / 12) * saldo / 100;
        saldo += interesMensual;
        return interesMensual;
    }

    public void extractoMensual() {
        saldo -= comMensual;
        calcularInteresMensual();
    }

    public String imprimir() {
        return "--- Cuenta Genérica ---" +
                "\nSaldo: " + saldo +
                "\nNúmero de consignaciones: " + numConsignaciones +
                "\nNúmero de retiros: " + numRetiros +
                "\nTasa anual: " + tasaAnual + "%" +
                "\nComisión mensual: " + comMensual;
    }
}
