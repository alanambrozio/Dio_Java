package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String [] listaCandidatosSelecionados = {"FELIPE", "MARCIA", "JULIA", "PAULO","MONICA"};
        for (String candidato: listaCandidatosSelecionados){
            entrandoEmContato(candidato);
        }
        
    }
    static void entrandoEmContato(String candidato){
        int tentativasRealizadas=1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if(continuarTentando){
                tentativasRealizadas++;
            }else{
                System.out.println("Contato realizado com sucesso.");    
        }
        }while(continuarTentando && tentativasRealizadas<3);

        if(atendeu){
            System.out.println("Conseguimos falar com o "+candidato+" na "+tentativasRealizadas+"° tentativa."  );
        }else{
            System.out.println("Não conseguimos contato com "+ candidato+" número maximo de tentaivas "+ tentativasRealizadas+".");
        }

    }

    static boolean atender(){
        return new Random().nextInt(3)==1;
    }
    static void imprimirSelecionados(){
        String [] listaCandidatosSelecionados = {"FELIPE", "MARCIA", "JULIA", "PAULO","MONICA"};
        for (int indice = 0; indice < listaCandidatosSelecionados.length; indice++){
            System.out.println("O canditado de n° "+(indice +1)+" é o "+listaCandidatosSelecionados[indice]);
        }
    }

    static void selecaoDeCandidato(){
        String [] canditatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE"};
        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000;
        
        while (candidatosSelecionados < 5 && candidatoAtual < canditatos.length){
            String candidato = canditatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato "+candidato+" solicitou este valor de salário "+salarioPretendido);
            if(salarioBase >= salarioPretendido){
                System.out.println("O candidato "+candidato+" foi selecionado para a vaga.");
                candidatosSelecionados ++;

            }
            candidatoAtual ++;


        }
    }
    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800,2200);
    }

    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido){
            System.out.println("LIGAR PARA O CANDIDATO");
        }else if (salarioBase == salarioPretendido){
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
        }else 
            System.out.println("AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS");
    }
}
