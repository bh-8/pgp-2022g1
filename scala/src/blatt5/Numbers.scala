package blatt5;

object Numbers {
  def teilerfremd(n: Int, m: Int): Unit = {
    if(gcd(n, m) == 1) then {
      println(n + " ist teilerfremd zu " + m);
    }
    if(m != 0) then {
      teilerfremd(n, m - 1);
    }
  }

  def relativePrimes(n: Int): Unit = {
    teilerfremd(n, n);
  }

  def gcd(a: Int, b: Int): Int = {
    if(b == 0) then {
      a;
    } else {
      if(a == 0) then {
        b;
      } else {
        if(a > b) then {
          gcd(a - b, b);
        } else {
          gcd(a, b - a);
        }
      }
    }
  }

  def main(args:Array[String]): Unit = {
    println(gcd(1071, 462));
    relativePrimes(77);
    relativePrimes(25);
  }
}