import java.util.Scanner;

public class CalculadoraEstudo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ler quantidade de dias
        System.out.print("Quantos dias de estudo por semana(no máximo 7)? ");
        int dias = scanner.nextInt();

        if(dias <= 0 || dias > 7){
            System.out.println("Dados inválidos! Os dias precisam estar de 1 a 7");
        } else {
            // Vetor para armazenar as horas
            int[] horas = new int[dias];
            int total = 0;

            // Ler horas por dia
            for (int i = 0; i < dias; i++) {
                int aux;
                do {
                    System.out.print("Horas de estudo no dia " + (i + 1) + " (0 a 8): ");
                    aux = scanner.nextInt();
                    if (aux < 0 || aux > 8) {
                        System.out.println(" Número de horas inválido! Tente novamente.");
                    }
                } while (aux < 0 || aux > 8);

                horas[i] = aux;
                total += aux;
            }

            // Calcular média
            double media = (double) total / dias;

            // Mostrar resultados
            System.out.println("\nDias de estudo: " + dias);
            System.out.print("Horas: ");
            for (int h : horas) {
                System.out.print(h + " ");
            }
            System.out.println("\nTotal: " + total + " horas");
            System.out.printf("Média: %.1f horas/dia \n", media);

            // Verificar meta
            if (total >= 20) {
                System.out.println("Meta atingida!");
            } else {
                System.out.println("Meta não atingida.");
            }

            scanner.close();
        }
    }
}