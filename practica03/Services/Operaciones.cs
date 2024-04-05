using System;
using WSDL.calculadora;

namespace WSDL.operaciones{
    public class Operaciones : Calculadora{

        public int Suma(int numero1, int numero2){
            return numero1 + numero2;
        }
        public int Resta(int numero1, int numero2){
            return numero1 - numero2;
        }
        public int Multiplicacion(int numero1, int numero2){
            return numero1 * numero2;
        }
        public double Division(double numero1, double numero2){
            return numero1 / numero2;
        }
    }

}