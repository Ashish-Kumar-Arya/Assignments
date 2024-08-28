package cdp;

interface Fruit {
	void properties();
}

class Apple implements Fruit {
	public void properties() {
		System.out.println("Red Colour + Sweet Taste");
	}
}

class Orange implements Fruit {
	public void properties() {
		System.out.println("Orange Colour + Tangy Taste");
	}
}

class Mango implements Fruit {
	public void properties() {
		System.out.println("Yellow Colour + Sweet Taste");
	}
}

public class FactoryPatternEx {
	public Fruit createFruit(String type) {
		if(type.equals("Apple"))
			return new Apple();
		else if(type.equals("Orange")) {
			return new Orange();
		}
		else if(type.equals("Mango")) {
			return new Mango();
		}
		else {
			throw new IllegalArgumentException("Unknown fruit type: "+type);
		}
		
	}
	
	public static void main(String[] args) {
		try {
			FactoryPatternEx obj=new FactoryPatternEx();
			Fruit apple=obj.createFruit("Apple");
			apple.properties();
			Fruit orange=obj.createFruit("Orange");
			orange.properties();
			Fruit mango=obj.createFruit("Mango");
			mango.properties();
			Fruit pineapple=obj.createFruit("Pineapple");
			pineapple.properties();
		}
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
}
