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
public class CacheCalcSuperF extends CalcSuperFat{
    private HashMap<BigInteger, BigInteger> cache = new HashMap();
    
    @Override
    public BigInteger getSuperFatorial(BigInteger numero) throws InputException {
        
        if(numero.equals(BigInteger.ZERO)) return BigInteger.ONE;
        
        else 
            if(numero.signum() == -1) throw new InputException();
        
        else 
            if(cache.containsKey(numero)) return cache.get(numero);
        
        else{
            cache.put(numero, getSFatorial(numero, numero));
            return cache.get(numero);
            }   
        
    }
}
