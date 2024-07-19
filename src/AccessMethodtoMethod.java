
public class AccessMethodtoMethod {

	public static void main(String[] args) {
		AccessMethodtoMethod d = new AccessMethodtoMethod();
		String name = d.getData();
		System.out.println(name);
	}
	public String getData() 
	{
		
		System.out.println("This is a method from BrowsersNavigations Class");
		return "Trexaii";
		
	}
}
