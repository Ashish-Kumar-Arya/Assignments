package assignments.task2;

interface Shape {
	void draw();
}

class Circle implements Shape {
	public void draw() {
		System.out.println("Drawing a circle");
	}
}

class Square implements Shape {
	public void draw() {
		System.out.println("Drawing a square");
	}
}

class Rectangle implements Shape {
	public void draw() {
		System.out.println("Drawing a Rectangle");
	}
}

public class ShapeFactory {
	public Shape createShape(String shape) {
		shape=shape.toLowerCase();
			if(shape.equals("circle")) {
				return new Circle();
			}
			else if(shape.equals("square")) {
				return new Square();
			}
			else if(shape.equals("rectangle")) {
					return new Rectangle();
			}
			else {
				throw new IllegalArgumentException("Unknown shape: "+shape);
			}
	}
	
	public static void main(String[] args) {
		try {
			ShapeFactory obj=new ShapeFactory();
			Shape circle=obj.createShape("circle");
			circle.draw();
			Shape square=obj.createShape("square");
			square.draw();
			Shape rectangle=obj.createShape("rectangle");
			rectangle.draw();
			Shape triangle=obj.createShape("triangle");
			triangle.draw();
		}
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
	}
}