package TextArray;

public class TestKlasse {
	public static void main(String[] args){
		TextArray ta1=new TextArray();
		TextArray ta2=new TextArray("eintest");
		System.out.println(ta1.textForm());
		System.out.println(ta2.textForm());
		ta2.neuerText("neuerText");
		System.out.println(ta2.textForm());
		ta2.loeschen(2, 4);
		System.out.println(ta2.textForm());
		ta2.dazuhaengen("zwei");
		System.out.println(ta2.textForm());
		System.out.println(ta2.textForm()+" ident mit "+ta1.textForm()+" ? : "+ta2.equals(ta1));
		System.out.println(ta2.textForm()+" ident mit "+ta2.textForm()+" ? : "+ta2.equals(ta2));
	} 
}
