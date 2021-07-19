import java.util.Scanner;


public class Main
{
    public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		while (true)
		{
			System.out.println("PAGO DE SERVICIOS PÚBLICOS\n" +
								"Seleccione el servicio público:\n" +
								" 1. Energia\n" +
								" 2. Acueducto\n" +
								" 3. Gas Natural\n" +
								" 4. Salir\n" +
								"Opción:");

			int option = input.nextInt();

			switch (option) {
				case 1:
					PayEnergy(input);
					break;
				case 2:
					PayWater(input);
					break;
				case 3:
					PayGas(input);
					break;
				case 4:
					System.out.println("Hasta pronto");
					System.exit(0);
				default:
					break;
			}
		}
    }

	public static String Data(double value, Scanner scanner)
	{
		System.out.println("Estrato del inmueble:");
		int stratum = scanner.nextInt();

		System.out.println("Consumo del inmueble:");
		int intake = scanner.nextInt();

		double discount = 0;
		double overrun = 0;

		double totalCost = value * intake;

		double tax = totalCost * 0.01;

		if ( stratum == 1 || stratum == 2 )
		{
			discount = totalCost * 0.5;
		}
		else if ( stratum == 3 || stratum == 4 )
		{
			discount = totalCost * 0.1;
		}
		else if ( stratum == 5 || stratum == 6 )
		{
			overrun = totalCost * 0.25;
		}

		double totalPay = (discount != 0) ? totalCost + tax - discount : totalCost + tax + overrun;
		double disOrOver = (discount != 0 ) ? discount * -1 : overrun;

		String toPay = "El consumo fue: " + intake + "\n" +
		"Valor unidad: " + value + "\n" +
		"Estrato del inmueble: " + stratum + "\n" +
		"Costo total: " + totalCost + "\n" +
		"Descuento o sobrecosto: " + disOrOver + "\n" +
		"Impuesto por infraestructura: " + tax + "\n" +
		"TOTAL A PAGAR: " + totalPay + "\n";

		return toPay;
	}

	public static void PayEnergy(Scanner scanner)
	{
		final double valueUnit = 6200;

		System.out.println("Pago de Servicio de Energia");

		String Pay = Data(valueUnit, scanner);

		System.out.println(Pay);
	}

	public static void PayWater(Scanner scanner)
	{
		final double valueUnit = 9256;

		System.out.println("Pago de Servicio de Acueducto");

		String Pay = Data(valueUnit, scanner);

		System.out.println(Pay);
	}

	public static void PayGas(Scanner scanner)
	{
		final double valueUnit = 5234;

		System.out.println("Pago de Servicio de Gas Natural");

		String Pay = Data(valueUnit, scanner);

		System.out.println(Pay);
	}
}
