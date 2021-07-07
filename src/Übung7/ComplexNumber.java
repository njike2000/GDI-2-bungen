/**
 * 
 */
package Übung7;

/**
 * @author samue
 *
 */
public class ComplexNumber implements Comparable {

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private double real;
	private double imag;
	
	public ComplexNumber() {
		this(0.0 , 0.0);
	}
	
	public ComplexNumber(double real) {
		
	}
	public ComplexNumber(double real, double imag) {
		this.real = real;
		this.imag = imag;
	}

	public double getReal() {
		return real;
	}

	public void setReal(double real) {
		this.real = real;
	}

	public double getImag() {
		return imag;
	}

	public void setImag(double imag) {
		this.imag = imag;
	}

	@Override
	public String toString() {
		return "ComplexNumber [real=" + real + ", imag=" + imag + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(imag);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(real);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComplexNumber other = (ComplexNumber) obj;
		if (Double.doubleToLongBits(imag) != Double.doubleToLongBits(other.imag))
			return false;
		if (Double.doubleToLongBits(real) != Double.doubleToLongBits(other.real))
			return false;
		return true;
	}
	
	public static ComplexNumber add(ComplexNumber a, ComplexNumber b) {
		return new ComplexNumber(a.getReal() + b.getReal(), a.getImag() + b.getImag());
	}
	
	public static ComplexNumber sub(ComplexNumber a, ComplexNumber b) {
		return new ComplexNumber(a.getReal() - b.getReal(), a.getImag() - b.getImag());
	}
	
	public static ComplexNumber mult(ComplexNumber a, ComplexNumber b) {
		return new ComplexNumber(a.getReal() * b.getReal(), a.getImag() * b.getImag());
	}
	
	

}
