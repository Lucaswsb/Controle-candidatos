package candidatura;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {        
        System.out.println("Processo seletivo");
        System.out.println("___________________________________");
        System.out.println(" ");
        

        // usar de base para concluir o codigo

        List<String> candidatosSelecionados = selecaoCandidatos();

        imprimirSelecionados(candidatosSelecionados);

        // Lista para armazenar candidatos que atenderam
        List<String> candidatosQueAtenderam = new ArrayList<String>();

        // Entrar em contato com os candidatos selecionados
        for (String candidato : candidatosSelecionados) {
            if (entrarEmContato(candidato)) {
                    candidatosQueAtenderam.add(candidato);
            }
        }

        // Imprimir candidatos que atenderam
        imprimirCandidatosQueAtenderam(candidatosQueAtenderam);
        
        
        // String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};

        // for(String candidato: candidatos) {
        //     entrarEmContato(candidato);
        // }


    }

    static void imprimirCandidatosQueAtenderam(List<String> candidatosQueAtenderam) {
        System.out.println("__________________________________________________________________________"); 
        System.out.println(" "); 
        System.out.println("Candidatos que atenderam:");
        for (int indice = 0; indice < candidatosQueAtenderam.size(); indice++) {
            System.out.println((indice + 1) + ". " + candidatosQueAtenderam.get(indice));
        }
    }

    static boolean entrarEmContato (String candidato) {
        System.out.println(" ");
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do {
          atendeu = atender();
          continuarTentando = !atendeu;

          if (continuarTentando)
           tentativasRealizadas ++;

          else
           System.out.println("Contato realizado com sucesso");

        } while (continuarTentando && tentativasRealizadas < 3);

        if (atendeu)
         System.out.println("Conseguimos contato com " + candidato + " na " + tentativasRealizadas);
        else
         System.out.println("Não conseguimos contato com " + candidato + " numero maximo tentativas " + tentativasRealizadas + " realizadas");

        return atendeu;
    }

    //metodo auxiliar
    static boolean atender() {
        return new Random().nextInt(3)==1;
    }

    static void imprimirSelecionados(List<String> candidatosSelecionados) {   
        System.out.println("__________________________________________________________________________"); 
        System.out.println(" "); 
        System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");
        // forma abreviada abaixo

        // for (String candidato: candidatos) {
        //     System.out.println("O candidato selecionado foi " + candidato);
        // }

        for (int indice = 0; indice < candidatosSelecionados.size(); indice++) {
                System.out.println("O candidato de nº " + (indice + 1) + " é o " + candidatosSelecionados.get(indice));           
        }

        
    }

    static List<String> selecaoCandidatos () {

        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "DANIELA", "JORGE"};
        List<String> candidatosSelecionados = new ArrayList<String>();
        
        int candidatosSelecionadosContador = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;

        while(candidatosSelecionadosContador < 5 && candidatoAtual < candidatos.length) {
         String candidato = candidatos[candidatoAtual];
         double salarioCandidato = valorCandidato();

         System.out.println("O candidato " + candidato + " Solicitou este valor de salario " + salarioCandidato);
         if (salarioBase >= salarioCandidato) {
            System.out.println("O candidato " + candidato + " foi selecionado para a vaga");       
            candidatosSelecionados.add(candidato);
            candidatosSelecionadosContador++ ;
         }
         System.out.println(" ");
         candidatoAtual ++ ;
        } 
        
        return candidatosSelecionados;
        
    }
    static double valorCandidato() {
        return ThreadLocalRandom.current().nextDouble(1800,2200);
    }

    static void analisarCandidato (Double salarioCandidato) {
        
        double salarioBase = 2000.0;

        if (salarioBase > salarioCandidato){  
         System.out.println("Ligar para o candidato");

        }else if (salarioBase == salarioCandidato) 
         System.out.println("Ligar para o candidato com contra proposta");

        else {
         System.out.println("Aguardando o resultado dos demais candidatos"); 

        }

    }
}
