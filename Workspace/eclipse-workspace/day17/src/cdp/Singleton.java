package cdp;

public class Singleton {
	
	private static Singleton obj;
	
	private Singleton() // private Constructor
	{
		
	}
	
	public static Singleton getInstance()
	{
		if(obj==null)
			obj=new Singleton();
		
		return obj;
	}
	
	public static void main(String[] args) {
		Singleton instance = Singleton.getInstance();
		System.out.println("Singleton instance "+instance);
		Singleton instance1 = Singleton.getInstance();
		System.out.println("Singleton instance "+instance1);
	}
}
