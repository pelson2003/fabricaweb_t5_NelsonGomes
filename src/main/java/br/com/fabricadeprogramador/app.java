package br.com.fabricadeprogramador;


public class app {

	public static void main(String[] args) {
		
		String s = "123";
		System.out.println(s.concat("456"));
		System.out.println(s.length());
		System.out.println(s.length() + 2);
		if (s.length() < 2)
			s.concat("456");
		for(int x = 0; x <3; x++)
		s += "x";
		System.out.println(s);
		
	}
}
