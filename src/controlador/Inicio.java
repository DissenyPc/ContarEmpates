package controlador;

import javax.swing.JOptionPane;

public class Inicio {

    public static void main(String[] args) {

        int nGoles = 0;

        String[] cambio = new String[2];

        nGoles = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero de goles:"));

        while (nGoles >= 0) {

            String[] segundos = new String[2];

            String[][] tiempos = new String[nGoles][2];

            for (int i = 0; i < nGoles; i++) {

                tiempos[i] = JOptionPane.showInputDialog("Introduce los datos del gool " + (i + 1) + ":").split(" ");

            }

            for (int i = 0; i < nGoles; i++) {

                segundos = tiempos[i][1].split(":");

                tiempos[i][1] = Integer.parseInt(segundos[0]) * 60 + Integer.parseInt(segundos[1]) + "";

            }

            for (int i = 0; i < nGoles - 1; i++) {

                for (int j = 0; j < nGoles - 1; j++) {

                    if (Integer.parseInt(tiempos[j][1]) < Integer.parseInt(tiempos[j + 1][1])) {

                    } else {

                        cambio = tiempos[j + 1];

                        tiempos[j + 1] = tiempos[j];

                        tiempos[j] = cambio;

                    }

                }

            }

            int visitantes = 0;

            int locales = 0;

            int nEmpates = 1;

            for (int i = 0; i < nGoles; i++) {

                if (tiempos[i][0].equals("L")) {

                    locales++;

                } else {
                    
                    visitantes++;
                }

                if (locales == visitantes) {

                    nEmpates++;
                }

            }

            System.out.println(locales + "-" + visitantes + " " + nEmpates);

            nGoles = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero de goles:"));
        }

    }

}
