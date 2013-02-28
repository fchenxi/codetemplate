package com.dream.algorithm.math;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 扩展数学工具类
 * 
 * @author liushaohui
 * 
 */
public class MathEx {
	/**
	 * 整数二进制最高位的位置
	 * 
	 * @param x
	 * @return
	 */
	public static int highBin(long x) {
		int ret = 0;
		while (x > 0) {
			x = x / 2;
			ret++;
		}
		return ret;
	}

	/**
	 * 整数二进制最低位的位置
	 * 
	 * @param x
	 * @return
	 */
	public static int lowBin(long x) {
		int ret = 0;
		while (x > 0) {
			if (x % 2 == 1) {
				return ret;
			}
			x = x / 2;
			ret++;
		}
		return ret;
	}

	/**
	 * 欧几里得求最大公约数
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static long gcd(long a, long b) {
		if (a % 2 == 0 && b % 2 == 0) {
			return 2 * gcd(a, b);
		} else if (a % 2 == 0) {
			return gcd(a / 2, b);
		} else if (b % 2 == 0) {
			return gcd(a, b / 2);
		} else {
			if (a == 0) {
				return b;
			}
			if (b == 0) {
				return a;
			}
			return gcd(b, a % b);
		}
	}

	/**
	 * 扩展欧几里得
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static long[] extgcd(long a, long b) {
		if (b == 0) {
			return new long[] { a, 1, 0 };
		} else {
			long t[] = extgcd(b, a % b);
			return new long[] { t[0], t[2], t[1] - (a / b) * t[2] };
		}
	}

	/**
	 * 欧几里得求最小公倍数
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static long lcm(long a, long b) {
		return a * b / gcd(a, b);
	}

	/**
	 * 统计数字(32位以内)2进制中1的个数
	 * 
	 * @param v
	 *            数字(32位以内)
	 * @return 数字(32位以内)2进制中1的个数
	 */
	public static int bitsCount(long v) {
		int count = 0;
		while (v > 0) {
			count++;
			v = v & (v - 1); // 消除数字v的最低的二进制位
		}
		return count;
	}

	/**
	 * 给点一个标准，判断一个实数是否为0
	 * 
	 * @param value
	 *            一个实数
	 * @param eps
	 *            一个标准
	 * @return 是0 返回true，否则返回false
	 */
	public static boolean isZero(double value, double eps) {
		if (Math.abs(value) < eps) {
			return true;
		}
		return false;
	}

	/**
	 * a^b %mod
	 * 
	 * @param a
	 * @param b
	 * @param mod
	 * @return
	 */
	public static long pow(long a, long b, long mod) {
		long ret = 1;
		long base = 1;
		while (b > 0) {
			base = base * base % mod;
			if (b % 2 == 1) {
				ret = ret * base % mod;
			}
			b = b / 2;
		}
		return ret;
	}

	/**
	 * catalan(n)%mod
	 * 
	 * @param n
	 * @param mod
	 * @return
	 */
	public static long catalan(long n, long mod) {
		return (comb(2 * n, n, mod) - comb(2 * n, n - 1, mod) + mod) % mod;
	}

	/**
	 * C(m,n)%mod
	 * 
	 * @param m
	 * @param n
	 * @param mod
	 * @return
	 */
	public static long comb(long m, long n, long mod) {
		List<Long> pfactors = primeFactors(mod);
		long[] p = new long[pfactors.size()];
		long[] a = new long[p.length];
		for (int i = 0; i < p.length; i++) {
			a[i] = combModPrime(m, n, p[i]);
		}
		return chineseReminderThorem(a, p);
	}

	/**
	 * C(m,n)%prime<br>
	 * 组合数对素数去模 For the theorem in complex analysis, see Gauss–Lucas theorem.<br>
	 * 
	 * @param m
	 * @param n
	 * @param prime
	 *            prime<=10^5
	 * @return
	 */
	public static long combModPrime(long _n, long _k, long prime) {
		long ret = 1;
		while (_n > 0 || _k > 0) {
			long n = _n % prime;
			long k = _k % prime;
			_n = _n / prime;
			_k = _k / prime;
			ret = ret * combSamllModPrime(n, k, prime) % prime;
		}
		return ret;
	}

	/**
	 * 小组合数模素数<br>
	 * n,k <prime<10^4
	 * 
	 * @param n
	 * @param k
	 * @param p
	 * @return
	 */
	private static long combSamllModPrime(long n, long k, long p) {
		long f1 = 1;
		for (long i = n - k + 1; i <= n; ++i)
			f1 = (f1 * i) % p;
		long f2 = 1;
		for (long i = 1; i <= k; ++i)
			f2 = (f2 * i) % p;
		return divModPrime(f1, f2, p);
	}

	/**
	 * 欧拉函数
	 * 
	 * @param n
	 *            sqrt(n)< 10^6
	 * @return
	 */
	public static long euler(long n) {
		int ret = 1;
		List<Long> pList = primeFactors(n);
		for (long p : pList) {
			if (n % p == 0) {
				int t = 0;
				while (n % p == 0) {
					t++;
					n = n / p;
				}
				ret = ret * (t + 1);
			}
		}
		return n - ret;
	}

	/**
	 * 除法对素数取模
	 * 
	 * @param a
	 * @param b
	 * @param prime
	 * @return
	 */
	private static long divModPrime(long a, long b, long p) {
		return (a * pow(b, p - 2, p)) % p;
	}

	/**
	 * [1,n]数字中0-9出现的次数
	 * 
	 * @param n
	 * @return
	 */
	public static int[] digtalCount(int n) {
		int[] ret = new int[10];
		String str = Integer.toString(n);
		int len = str.length();
		int[] base = new int[len];

		base[len - 1] = 1;
		for (int i = len - 2; i >= 0; i--) {
			base[i] = 10 * base[i + 1];
		}

		for (int i = 0; i < str.length(); i++) {
			int t = (int) (str.charAt(i) - '0');
			for (int j = 1; j < t; j++) {
				ret[j] += base[i];
			}
			ret[t] += n - t * base[i] + 1;

			for (int j = 0; j < 10; j++) {
				ret[j] += t * (len - 1 - i) * base[i] / 10;
			}
			n = n - t * base[i];
			for (int j = i + 1; j < len; j++) {
				ret[0] -= base[j];
			}
		}
		// ret[0]++;如果从0开始的话加1
		return ret;
	}

	/**
	 * 高斯消元法
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static double[] guass(double[][] a, double[] b) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int k = i;
			for (int j = i + 1; j < n; j++) {
				if (Math.abs(a[j][i]) > Math.abs(a[k][i])) {
					k = j;
				}
			}
			double[] tmp = a[i];
			a[i] = a[k];
			a[k] = tmp;
			double t = b[i];
			b[i] = b[k];
			b[k] = t;
			for (int j = i + 1; j < n; j++) {
				if (a[j][i] != 0) {
					double d = a[j][i] / a[i][i];
					for (int p = i; p < n; p++) {
						a[j][p] -= d * a[i][p];
					}
					b[j] -= d * b[i];
				}
			}
		}
		double[] x = new double[n];
		for (int k = n - 1; k >= 0; k--) {
			x[k] = b[k];
			for (int i = k + 1; i < n; i++) {
				x[k] -= x[i] * a[k][i];
			}
			x[k] /= a[k][k];
		}
		return x;
	}

	/**
	 * 小素数检测
	 * 
	 * @param x
	 * @return
	 */
	public static boolean isPrime(int x) {
		if (x <= 1)
			return false;
		if (x == 2)
			return true;
		if (x % 2 == 0)
			return false;
		int m = (int) Math.sqrt(x);

		for (int i = 3; i <= m; i += 2) {
			if (x % i == 0)
				return false;
		}
		return true;
	}

	/**
	 * 大素数探测
	 * 
	 * @param x
	 * @return
	 */
	public static boolean MillerRabbin(long x) {
		for (int i = 0; i < 10; i++) {
			long a = (long) Math.random() * (x - 2) + 2;
			if (pow(a, x - 1, x) != 1L) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 大素数探测
	 * 
	 * @param x
	 * @param n
	 *            探测次数
	 * @return
	 */
	public static boolean MillerRabbin(long x, int n) {
		for (int i = 0; i < n; i++) {
			long a = (long) Math.random() * (x - 2) + 2;
			if (pow(a, x - 1, x) != 1L) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 获取数n的所有素因子
	 * 
	 * @param v
	 * @return
	 */
	public static List<Long> primeFactors(long v) {
		List<Long> ret = new ArrayList<Long>();
		for (long i = 2; i * i < v; i++) {
			if (v % i == 0) {
				ret.add(i);
				v = v / i;
				while (v % i == 0) {
					v = v / i;
				}
			}
		}
		if (v != 1) {
			ret.add(v);
		}
		return ret;
	}

	/**
	 * 获取区间区[1,n]的所有素数
	 * 
	 * @param v
	 * @return
	 */
	public static List<Integer> getPrimes(int v) {
		List<Integer> primes = new ArrayList<Integer>();
		boolean[] flag = new boolean[v + 1];
		for (int i = 0; i < v + 1; i++) {
			flag[i] = true;
		}
		flag[0] = flag[1] = false;
		for (int i = 2; i < v + 1; i++) {
			if (flag[i]) {
				primes.add(i);
				for (int j = i; i * j < v + 1; j++) {
					flag[i * j] = false;
				}
			}
		}
		return primes;
	}

	/**
	 * 中国剩余定理<br>
	 * x=ai(mode pi)<br>
	 * 
	 * @param a
	 * @param p
	 * @return
	 */
	public static long chineseReminderThorem(long[] a, long[] p) {
		long x = a[0];
		long m = p[0];
		for (int i = 1; i < a.length; i++) {
			x = chineseReminderThorem(x, a[i], m, p[i]);
			m = m * p[i];
		}
		return x;
	}

	/**
	 * 中国剩余定理<br>
	 * x=a1(mode p1)<br>
	 * x=a2(mode p2) <br>
	 * 
	 * @param a1
	 * @param a2
	 * @param p1
	 * @param p2
	 * @return
	 */
	private static long chineseReminderThorem(long a1, long a2, long p1, long p2) {
		BigInteger mod = BigInteger.valueOf(p1)
				.multiply(BigInteger.valueOf(p2));
		long ret[] = extgcd(p1, p2);
		BigInteger t1 = BigInteger.valueOf(p2).multiply(
				BigInteger.valueOf(ret[2])).multiply(BigInteger.valueOf(a1));

		BigInteger t2 = BigInteger.valueOf(p1).multiply(
				BigInteger.valueOf(ret[1])).multiply(BigInteger.valueOf(a2));

		return t1.add(t2).mod(mod).add(mod).mod(mod).longValue();
	}

	/**
	 * 数组中超过半数元素检测
	 * 
	 * @param array
	 * @return
	 */
	public static int getHalfItem(int[] array) {
		int counter = 1;
		int key = array[0];
		for (int x : array) {
			if (x == key) {
				counter++;
			} else {
				counter--;
			}
			if (counter < 0) {
				key = x;
				counter = 1;
			}
		}
		return key;
	}
}
