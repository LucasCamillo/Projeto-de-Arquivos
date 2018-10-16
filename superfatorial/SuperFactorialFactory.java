package superfatorial;

/**
 *
 * @author lucas
 */
public class SuperFactorialFactory {
    
    private SuperFactorialFactory() {

	}

	
	public static CalcBasicSuperFact createBasicSuperFact() {
		return new CalcBasicSuperFact();
	}
	
	
	public static CalcCachedSuperF createCachedCalcSuperF() {
		return new CalcCachedSuperF();
	}

}
