import java.util.Arrays;

public class Main {
	public static void main(String[] args) {

		final Pessoa p1 = new Pessoa("Nuno", 36);
		final Pessoa p2 = new Pessoa("Alexandre", 35);
		final Pessoa p3 = new Pessoa("Bruno", 34);
		final Pessoa p4 = new Pessoa("Beatriz", 33);
		final Pessoa[] p = { p1, p2, p3, p4 };

		Arrays.sort(p);


		int result = p2.compareTo(p3);
		System.out.println(result);

		for (Pessoa pe : p) {
			System.out.println(pe);
		}
	}
}