/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superfatorial;

import java.math.BigInteger;
/**
 *
 * @author lucas
 */
public class CalcSuperFat implements ISuperFatorial{

    @Override
    public BigInteger getSuperFatorial(BigInteger numero) throws InputException {
        
        if(numero.equals(BigInteger.ZERO)) return BigInteger.ONE;
        
        else 
            if(numero.signum() == -1) throw new InputException();
        
        
        BigInteger aux = getSFatorial(numero, numero);
          
        return aux;
    }
   
    protected BigInteger getSFatorial(BigInteger numero, BigInteger aux){
        if(numero.equals(BigInteger.ONE))
            return numero;
        
        else if(aux.equals(BigInteger.ONE))
            return getSFatorial(numero.subtract(BigInteger.ONE), numero.subtract(BigInteger.ONE));
        
        else            
            return getSFatorial(numero, aux.subtract(BigInteger.ONE)).multiply(aux);
        
    }
}
