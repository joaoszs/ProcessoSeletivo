package candidatura;

import java.util.Random;
import  java.util.Scanner;
import  java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo
{
    public static void main(String[] args)
    {
      selecaoCandidatos();
      imprimirSelecionados();

        String [] listaCandidatos = {"Julia", "Joao", "Davi", "Lucio", "Patricia"};
        for (String candidato: listaCandidatos){
            entrandoEmContato(candidato);
        }
    }

    static void entrandoEmContato(String canditato)
    {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;

            if (continuarTentando){
                tentativasRealizadas++;
            } else {
                System.out.println("Chamada realizada com sucesso");
            }

        }while (continuarTentando && tentativasRealizadas < 3);{
            if (atendeu){
                System.out.println("conseguimos contato com "+canditato+" na "+tentativasRealizadas+" tentativa. ");
            } else {
                System.out.println("nao conseguimos contato com "+canditato+" numero de tentativas "+tentativasRealizadas);
            }
    }
    }

    static boolean atender()
    {
        return new Random().nextInt(3)==1;
    }

    static void imprimirSelecionados()
    {
        String [] listaCandidatos = {"Julia", "Joao", "Davi", "Lucio", "Patricia"};
        System.out.println("Imprimindo lista de candidatos selecionados : ");
        for (int indice=0; indice < listaCandidatos.length; indice++)
        {
            System.out.println("O candidato de n* = "+indice+" eh "+listaCandidatos[indice]);
        }
    }

    static void selecaoCandidatos()
    {
       String [] listaCandidatos = {"Julia", "Joao", "Davi", "Lucio", "Patricia", "Paloma", "Maria", "Jose"};

       int candidatosSelecionados = 0;
       int candidatoAtual = 0;
       double salarioBase = 2000.0;

       while(candidatosSelecionados < 5 && candidatoAtual < listaCandidatos.length)
       {
            String candidato = listaCandidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " +candidato+ " solicitou este valor de salario : " +salarioPretendido);
            if(salarioBase >= salarioPretendido) {
                System.out.println("O candidato " +candidato+ " foi selecionado para a vaga !");
                candidatosSelecionados++;
            }
            candidatoAtual++;
       }
    }

    static double valorPretendido()
    {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato (double salarioPretendido)
    {
        double salarioBase = 2000.0;

        if (salarioBase > salarioPretendido) {
            System.out.println("Ligar para candidato !");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("Aguardando os resultados dos demais candidatos .");
        } else {
            System.out.println("Ligar para caniddato com contra resposta !");
        }
    }
}
