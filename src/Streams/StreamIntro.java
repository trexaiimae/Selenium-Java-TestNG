package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.print.DocFlavor.STRING;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class StreamIntro {
	public void Streamssample() {
			ArrayList<String> names =new ArrayList<String>();
			names.add("Adam");
			names.add("Trexaii");
			names.add("Allan");
			names.add("Andrew");
			names.add("John");
			
			
			Long c = names.stream().filter(s->s.startsWith("A")).count();//scam the list parralely not each
			System.out.println(c);
			
			Long d= Stream.of("Adam","Trexaii","Allan", "Andrew","John"  ).filter(s->
			
			{
				s.startsWith("A");
				return false;
			}).count();
			System.out.println(d);
			
			//print all the names of ArrayList
			
//			names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));//print names greater than 4 char
			names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s)); //print the first name in the arraylist
	}

	
@Test

	public void StreamMap() {
	ArrayList<String> names=new ArrayList<String>();
	names.add("man");
	names.add("Don");
	names.add("Allan");
	names.add("women");

	
	
	//print names with last name "a" with Uppercase
	//Alekya to ALEKYA
	Stream.of("Adam","Rama","Allan", "Andrew","Alikya").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	
	//print names wich have first letter as "a" with Uppercase and sorted 
	List<String> names1= Arrays.asList("Adam","Rama","Allan", "Andrew","Alikya");
	names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	
	//combile 2 list in one string
	Stream<String> newStream = Stream.concat(names.stream(), names1.stream()); 
	//newStream.sorted().forEach(s->System.out.println(s)); //sort string
	
	boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Adam")); //check if Adam is present in the array
	System.out.println(flag);
	Assert.assertTrue(flag);
}



@Test
public void StreamCollect() {
	//collect all results and convert back to list
	List<String> newList= Stream.of("Adam","Rama","Allan", "Andrew","Alikya").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).collect(Collectors.toList());
	System.out.println(newList.get(0));
	
	List<Integer> values= Arrays.asList(3,2,2,7,5,1,9,7);
	//print unique number from this array
	//sort the array
	
	
	//1,2,3,5,7,9 print only 3rd index "4"
	//values.stream().distinct().forEach(s->System.out.println(s));// print unique number from this array
	List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());//convert the stream integer to list
	System.out.println(li.get(3));//get the 3rd index in sorted list
}
}

//cannot use test if static
//lambda express (s->s.)