package com.mk.s1_clase;

public class Operaciones {
    int resultado;
    public int Sumar(int num1, int num2){
        resultado = num1 + num2;
        return resultado;
    }

    public int Restar(int num1, int num2){
        resultado = num1 - num2;
        return resultado;
    }

    public int Multiplicar(int num1, int num2){
        resultado = num1 * num2;
        return resultado;
    }

    public float Dividir(int num1, int num2){
        float rs;
        if(num2 == 0){
            rs = 0;
        }else{
            rs = (float)num1 / (float)num2;
        }
        return rs;
    }
}
