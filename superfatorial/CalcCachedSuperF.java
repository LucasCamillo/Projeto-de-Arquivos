/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superfatorial;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author lucas
 */
public class CalcCachedSuperF extends CalcBasicSuperFact{
    static private Map<Integer, BigInteger> cache = new HashMap<>();
    
    @Override
    public BigInteger getSuperFatorial(BigInteger numero) throws InputException {
        Integer chave = numero.intValue();
        BigInteger superFact = BigInteger.ONE;
        
        System.out.println("------------------------------------------\n" + "MEMORIA CONTEM:");
        if(cache.isEmpty())
            System.out.println("\n" + "memoria ainda esta vazia" + "\n");
        else
            for(Map.Entry<Integer, BigInteger> entry : cache.entrySet())
                System.out.println("\n" + "Fatorial de " +entry.getKey()+ ": " +entry.getValue()+ "\n");
        
        if(numero.equals(BigInteger.ZERO)|| numero.equals(BigInteger.ONE)) return BigInteger.ONE;
        
        else 
            if(numero.signum() == -1) throw new InputException();
        
        else
            if(cache.isEmpty()){
                superFact = calcFat(numero, BigInteger.ONE);
                cache.put(chave, superFact);
                return cache.get(chave);
                }
        else
            if(cache.containsKey(chave)) {
                System.out.println("\n" + "Logo, o valor já calculando anteriormente é de: " +cache.get(chave));
                return cache.get(chave);
            }
            
           
        else{
            Integer aux = 0;
            BigInteger deposito;
            for(Integer n : cache.keySet()){
                if(n > aux && n < chave){
                    aux = n;
                }
            }
            
            deposito = cache.get(aux);
            superFact = calcFat(numero, BigInteger.valueOf(aux));
            superFact = superFact.multiply(deposito);
            System.out.println("Fatorial de " +aux+ " até 1 é: " +deposito);
            System.out.println("\n"+"Seu Super Fatorial total é de: " +superFact);
            cache.put(chave, superFact);
            return cache.get(chave);
            }   
    }
    
    protected BigInteger calcFat(BigInteger numero, BigInteger aux){
        BigInteger superFact = BigInteger.ONE;
        for(BigInteger i = numero; i.compareTo(aux) != 0 ; i = i.subtract(BigInteger.ONE))
            superFact = superFact.multiply( getSFatorial(i) );
        
        System.out.println("Fatorial de " +numero+ " até " +aux+ " é: " +superFact);
        return superFact;
    }
}

