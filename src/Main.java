import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US); // notas com ponto: 7.5

        System.out.print("Quantos alunos serão cadastrados? ");
        int quantidadeAlunos = scanner.nextInt();
        scanner.nextLine();

        Aluno[] alunos = new Aluno[quantidadeAlunos];

        for (int i = 0; i < quantidadeAlunos; i++) {
            System.out.println("--- Aluno " + (i + 1) + " ---");
            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Quantas notas esse aluno teve no ano? ");
            int quantidadeNotas = scanner.nextInt();
            double[] notas = new double[quantidadeNotas];

            for (int j = 0; j < quantidadeNotas; j++) {
                double nota;
                do {
                    System.out.print("Digite a nota " + (j + 1) + " (0 a 10): ");
                    nota = scanner.nextDouble();
                    if (nota < 0 || nota > 10) {
                        System.out.println("Nota inválida! Digite um valor entre 0 e 10.");
                    }
                } while (nota < 0 || nota > 10);
                notas[j] = nota;
            }
            scanner.nextLine(); // limpa o buffer antes do próximo nome

            alunos[i] = new Aluno(nome, notas);
        }

        System.out.println();
        System.out.println("===== RESULTADO =====");
        for (Aluno aluno : alunos) {
            System.out.println("Aluno: " + aluno.getNome());
            System.out.print("Notas: ");
            for (double nota : aluno.getNotas()) {
                System.out.print(nota + " ");
            }
            System.out.println();
            System.out.printf("Média: %.2f%n", aluno.calcularMedia());
            System.out.println("-------------------");
        }

        scanner.close();
    }
}