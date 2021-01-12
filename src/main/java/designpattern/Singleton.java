package main.java.designpattern;

public class Singleton {
	private Singleton connection = null;
	private String conn = "NOT OK";
	private Singleton()
	{
		conn = "OK";
	}
	public Singleton getConnection(){
		if (this.connection == null)
			return new Singleton();
		else
			return connection;
	}
}
