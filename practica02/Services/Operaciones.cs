using System;
using WSDL.mensajes;

namespace WSDL.operaciones{
    public class Operaciones : Mensajes{
        List<String> nombres = new List<String>();
        public string Saludar(string nombre){
            string msj = "hola " + nombre;
            nombres.Add(nombre);
            return msj;
        }
        public string Mostrar(string id){
            string combinedString = string.Join( ",", nombres);
            return combinedString;
        }
    }

}