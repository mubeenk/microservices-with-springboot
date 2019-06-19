package demo;

public class Client2 {

	public static String echo(String val) {
		//return (DoSomething(e->e.toUpperCase()));
		return val;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String resp = echo("this is so fun");
		System.out.println(resp);
	}

}
