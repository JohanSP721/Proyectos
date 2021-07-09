public class GeometricFigures
{
	public GeometricFigures()
	{}

	public double triangleArea(double base, double height)
	{
		return (base * height) / 2;
	}

	public double circleArea(double radio)
	{
		final double pi = 3.141592;

		return pi * Math.pow(radio, 2);
	}

	public double rectangleArea(double base, double height)
	{
		return base * height;
	}
}
