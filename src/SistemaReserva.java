import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Reserva {
    private String nome;
    private int hora;

    public Reserva(String nome, int hora) {
        this.nome = nome;
        this.hora = hora;
    }

    public String getNome() {
        return nome;
    }

    public int getHora() {
        return hora;
    }

    @Override
    public String toString() {
        return "Hora: " + hora + "h - Reservado por: " + nome;
    }
}

// Main
public class SistemaReserva {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Reserva> reservas = new ArrayList<>();

        while (true) {
            System.out.println("1. Cadastrar reserva");
            System.out.println("2. Exibir reservas");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.print("Nome do responsável: ");
                String nome = scanner.nextLine();

                System.out.print("Hora da reserva: ");
                int hora = scanner.nextInt();

                if (hora < 0 || hora > 23) {
                    System.out.println("Hora inválida! Escolha um horário entre 1 e 23.");
                    continue;
                }

                boolean ocupado = false;
                for (Reserva r : reservas) {
                    if (r.getHora() == hora) {
                        ocupado = true;
                        break;
                    }
                }

                if (ocupado) {
                    System.out.println("Já existe uma reserva nesse horário!");
                } else {
                    reservas.add(new Reserva(nome, hora));
                    System.out.println("Reserva confirmada!");
                }

            } else if (opcao == 2) {
                if (reservas.isEmpty()) {
                    System.out.println("Nenhuma reserva encontrada.");
                } else {
                    System.out.println("\nReservas confirmadas:");
                    for (Reserva r : reservas) {
                        System.out.println(r);
                    }
                }

            } else if (opcao == 3) {
                System.out.println("Encerrando sistema...");
                break;

            } else {
                System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }
}

