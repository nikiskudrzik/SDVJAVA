import java.math.*;
import java.util.Scanner;

public class Exercise13_15 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter rational r1 with numerator and denominator seperated by a space: ");
    String n1 = input.next();
    String d1 = input.next();

    System.out.print("Enter rational r2 with numerator and denominator seperated by a space: ");
    String n2 = input.next();
    String d2 = input.next();

    RationalUsingBigInteger r1 = new RationalUsingBigInteger(
      new BigInteger(n1), new BigInteger(d1));
    RationalUsingBigInteger r2 = new RationalUsingBigInteger(
      new BigInteger(n2), new BigInteger(d2));

    System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
    System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
    System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
    System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));
    System.out.println(r2 + " is " + r2.doubleValue());
  }
}

class RationalUsingBigInteger extends Number
    implements Comparable<RationalUsingBigInteger> {

  private BigInteger numerator = BigInteger.ZERO;
  private BigInteger denominator = BigInteger.ONE;

  public RationalUsingBigInteger() {
    this(BigInteger.ZERO, BigInteger.ONE);
  }

  public RationalUsingBigInteger(BigInteger numerator, BigInteger denominator) {
    if (denominator.equals(BigInteger.ZERO)) {
      throw new ArithmeticException("Denominator cannot be zero");
    }

    if (denominator.signum() < 0) {
      numerator = numerator.negate();
      denominator = denominator.negate();
    }

    BigInteger gcd = numerator.gcd(denominator);
    this.numerator = numerator.divide(gcd);
    this.denominator = denominator.divide(gcd);
  }

  public BigInteger getNumerator() {
    return numerator;
  }

  public BigInteger getDenominator() {
    return denominator;
  }

  public RationalUsingBigInteger add(RationalUsingBigInteger second) {
    BigInteger n = numerator.multiply(second.denominator)
        .add(second.numerator.multiply(denominator));
    BigInteger d = denominator.multiply(second.denominator);
    return new RationalUsingBigInteger(n, d);
  }

  public RationalUsingBigInteger subtract(RationalUsingBigInteger second) {
    BigInteger n = numerator.multiply(second.denominator)
        .subtract(second.numerator.multiply(denominator));
    BigInteger d = denominator.multiply(second.denominator);
    return new RationalUsingBigInteger(n, d);
  }

  public RationalUsingBigInteger multiply(RationalUsingBigInteger second) {
    BigInteger n = numerator.multiply(second.numerator);
    BigInteger d = denominator.multiply(second.denominator);
    return new RationalUsingBigInteger(n, d);
  }

  public RationalUsingBigInteger divide(RationalUsingBigInteger second) {
    BigInteger n = numerator.multiply(second.denominator);
    BigInteger d = denominator.multiply(second.numerator);
    return new RationalUsingBigInteger(n, d);
  }

  @Override
  public int compareTo(RationalUsingBigInteger other) {
    BigInteger left = numerator.multiply(other.denominator);
    BigInteger right = other.numerator.multiply(denominator);
    return left.compareTo(right);
  }

  @Override
  public String toString() {
    if (denominator.equals(BigInteger.ONE)) {
      return numerator.toString();
    }
    return numerator + "/" + denominator;
  }

  @Override
  public int intValue() {
    return (int) doubleValue();
  }

  @Override
  public long longValue() {
    return (long) doubleValue();
  }

  @Override
  public float floatValue() {
    return (float) doubleValue();
  }

  @Override
  public double doubleValue() {
    return numerator.doubleValue() / denominator.doubleValue();
  }
}