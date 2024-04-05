using System;
using System.ServiceModel;

namespace WSDL.calculadora {
    [ServiceContract]
    public interface Calculadora {
        [OperationContract]
        int Suma (int numero1,int numero2);
        [OperationContract]
        int Resta (int numero1, int numero2);
        [OperationContract]
        int Multiplicacion (int numero1, int numero2);
        [OperationContract]
        double Division (double numero1, double  numero2);
    }
}