package superfatorial;

import java.math.BigInteger;
/**
 *
 * @author lucas
 */
    
public class CalcBasicSuperFact implements ISuperFatorial{
     
    /*
    *   Minha implementação com recursão da algum erro para numeros muitos grandes 
    *   Eu nao consegui descobrir qual é
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
    
    */
    
    //Implementação do professor com algumas pequenas mudanças
    
    @Override
    public  BigInteger getSuperFatorial(BigInteger numero) throws InputException{
        BigInteger superFact = BigInteger.ONE;
        
        if( numero.equals(BigInteger.ZERO) || numero.equals(BigInteger.ONE)) return BigInteger.ONE;
        else 
            if(numero.signum() == -1) throw new InputException();
        
        superFact = calcFat(numero);
        
        
        return superFact;
    }
	
    protected BigInteger getSFatorial(BigInteger n){
        BigInteger fact = BigInteger.ONE;
        
        if( n.equals(BigInteger.ZERO) || n.equals(BigInteger.ONE)) return BigInteger.ONE;
        
        for(BigInteger i = n; i.compareTo(BigInteger.ONE) == 1; i = i.subtract(BigInteger.ONE)){
            //System.out.println(n.toString() + "! ->"+ fact.toString() + "( " + i.toString() + ") ");
            fact = fact.multiply(i);
        }

        return fact;
    }
    
    protected BigInteger calcFat(BigInteger numero){
        BigInteger superFact = BigInteger.ONE;
        int e = 0;
        for(BigInteger i = numero; i.compareTo(BigInteger.ONE) == 1 ; i = i.subtract(BigInteger.ONE))
            superFact = superFact.multiply( getSFatorial(i) );
        
        return superFact;
    }
}
