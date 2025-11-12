package javaBasics;

public class ForLoop {

	public static void main(String[] args) {
		ForLoop forLoopMethod = new ForLoop();
		//forLoopMethod.forLoopExample();
		forLoopMethod.nestedForLoopExample();
	}
	
	public void forLoopExample(){
		int i;
		for(i=1; i<=5; i++) {
			System.out.println(i);
		}
	}
	
	public void nestedForLoopExample(){
		int i;
		int j;
		for(i=1; i<=5; i++) {
			System.out.print(i);
			for(j=1; j<=5; j++) {
				System.out.println("*");
			}
		}
	}

}
