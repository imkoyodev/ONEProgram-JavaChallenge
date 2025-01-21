package com.alura.currency;

import java.io.IOException;
import java.util.Scanner;

public class CurrencyApplication {
    public static void main(String[] args) {
        // Variables y el Scanner que recepta la respuesta del usuario
        Scanner lectura = new Scanner(System.in);
        ConversorApi consulta = new ConversorApi();
        String origen = "";
        String destino = "";
        double valor;
        int usuario = 0;
//While que inicia el Menu al usuario
        while (usuario != 9) {
            System.out.println("""
                Te damos bienvenida al conversor de moneda
                ***********************************************
                Seleecione la moneda que desea cambiar
                1- Dólar [USD] =>> Peso argentino
                2- Peso argentino =>> Dólar [USD]
                3- Dólar [USD] =>> Real brasileño
                4- Real brasileño =>> Dólar
                5- Dólar =>> Peso colombiano [COP]
                6- Peso colombiano [COP] =>> Dólar [USD]
                7- Dólar [USD] =>> Peso chileno
                8- Peso Chileno =>> Dólar [USD]
                9- Salir.
                """);
            usuario = lectura.nextInt();
// Switch lleva el proseso de cada una de las seleccion tomada por el usuario
            switch (usuario){
                case 1:
                    origen = "USD";
                    destino = "ARS";
                    break;
                case 2:
                    origen = "ARS";
                    destino = "USD";
                    break;
                case 3:
                    origen = "USD";
                    destino = "BRL";
                    break;
                case 4:
                    origen = "BRL";
                    destino = "USD";
                    break;
                case 5:
                    origen = "USD";
                    destino = "COP";
                    break;
                case 6:
                    origen = "COP";
                    destino = "USD";
                    break;
                case 7:
                    origen = "USD";
                    destino = "CLP";
                    break;
                case 8:
                    origen = "CLP";
                    destino = "USD";
                    break;
                case 9:
                    System.out.println("Gracias por usar el conversor, !Hasta Pronto!");
                    break;

                default:
                    System.out.println("El numero ingresado no es valido, por favor intente nuevamente");
                    break;
            }
            if (usuario >= 1 && usuario <= 8) {
                System.out.println("Ingrese el valor que desea convertir");
                valor = lectura.nextDouble();
// Proceso de funcionamiento, encargado de llevar el monto que da el usuario para realizar la conversion
                if (valor > 0) {
                    MonedasApi operacion = consulta.tasaDeCambio(origen, destino,valor);
                    System.out.println("El valor de " + valor + " [" + origen +
                            "] equivale a " + operacion.conversion_result() +
                            " [" + destino + "]");
                    //funcion que genera el JSON
                    GenerarJson generador = new GenerarJson();
                    try {
                        generador.archivo(operacion, origen, destino);
                    } catch (IOException e) {
                        throw new RuntimeException("Error al grabar datos Json");
                    }
                }else {
                    System.out.println("Por favor ingrese un valor mayor a 0");
                }

            }



        }

        System.out.println("Fin del programa");
    }
}
