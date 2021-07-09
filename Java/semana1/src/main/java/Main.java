import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		GeometricFigures areas = new GeometricFigures();

		Scanner inputs = new Scanner(System.in);

		System.out.println("Ingrese la base y altura del triangulo:");

		double base = inputs.nextDouble();
		double height = inputs.nextDouble();

		System.out.println(areas.triangleArea(base, height));

		System.out.println("Ingrese el radio del circulo");

		double radio = inputs.nextDouble();

		System.out.println(areas.circleArea(radio));

		System.out.println("Ingrese la base y la altura del rectángulo: ");

		base = inputs.nextDouble();

		height = inputs.nextDouble();

		System.out.println(areas.rectangleArea(base, height));

		inputs.close();
	}
}
