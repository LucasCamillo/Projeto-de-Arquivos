/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udescpra.sortalgorithms;

import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class RadixSort extends AbstractSortStrategy {
    
    public RadixSort(int[] vet){
        super();
        this.setElements(vet);
       
    }
    
    public RadixSort(){
        super();
        int[] vet;
        int tam = (int)(Math.random()*10);
        vet = new int[tam];
        int cont;
        
        for(cont = 0; cont < tam; cont++)
            vet[cont] = ((int)(Math.random()*200));
        
        this.setElements(vet);
        
    }
    
    @Override
    public void sort(){
        int[] vet;
        vet = this.getElements();
        int tam = vet.length;
        int maior = 0;
        Integer casas = 0;
        
        System.out.println("Vetor não ordenado");
        for(int num : vet)
            System.out.println(num + " ");
        System.out.println("\n-----------------------------------------\n");
        
        for(int num : vet)
            if( num > maior)
                maior = num;
        
        casas = Integer.toString(maior).length();
        
        for(int passada = 1; passada <= casas; passada++){
            ArrayList<Integer>[] ord;
            ord = new ArrayList[10];
            
            for(int cont = 0; cont < ord.length; cont++) 
                ord[cont] = new ArrayList<Integer>();
            
            for(int num: vet){                          
                int mod = (int)Math.pow(10,passada);
                int div = (int)mod/10;
                int chave = (num%mod)/div;    
                ord[chave].add(num);
            }
           
           ArrayList<Integer> aux = new ArrayList<Integer>();
           
           for(ArrayList<Integer> fim : ord)
               for(Integer x : fim)
                   aux.add(x);
           for(int cont = 0; cont < aux.size(); cont++)
           vet[cont] = aux.get(cont);
        }
        
        System.out.println("Vetor ordeando");
        for(int num : vet)
            System.out.println(num + " ");
        System.out.println("\n-----------------------------------------\n");
    }
}