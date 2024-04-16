package com.chainsys.day2;
import java.util.*;
//using operator
class StudentDetails{
	int id;
	String name;
	int cs;
	int maths;
	int total;
	double avg;
	int rank;
	int age;
	char grade;
	boolean isEligibleToVote;
	StudentDetails(int id,String name,int cs,int maths,int age){
		this.id=id;
		this.maths=maths;
		this.name=name;
		this.cs=cs;
		this.age=age;
	}
}
public class ResultUsingAllOperators {
	public static void main(String[] args) {
		List<StudentDetails> students=new ArrayList<>();
		students.add(new StudentDetails(1,"vikram",90,70,23));
		students.add(new StudentDetails(2,"mani",80,70,18));
		students.add(new StudentDetails(3,"kishor",90,90,17));
		students.add(new StudentDetails(4,"abinesh",90,80,17));
		for(StudentDetails sm:students) { 
			//arithmetic operator +,-,*,/
		    sm.total=sm.cs+sm.maths;
		    sm.avg=sm.total/2;
		    //relational operator <,>,<=,==,>=
		    if(sm.total>=190 ) {
		    	sm.grade='a';
		    }
		    //logical operator && , ||,!
		    else if(sm.total<=180 && sm.total>=160){
		    	sm.grade='b';
		    }
		    else {
		    	sm.grade='c';
		    }
		}
		 //sorting based on rank using streamApi
		students.sort(Comparator.comparingInt((StudentDetails s)->s.total).reversed()); 
		     //increment operator ++ 
		    int i=1;
		    for(StudentDetails s:students) { 
		    	s.rank=i++;    	
		    }
		//ternary operator 
		    for(StudentDetails s:students) { 
                 s.isEligibleToVote=s.age>=18?true:false;
		    }
			//System.out.println(" id    name     avg    grade     total   rank    iseligibletovoteb ");
		    for(StudentDetails s:students) {
		    	System.out.println("id: "+s.id+" name  :"+s.name+" avg :"+s.avg+" grade :"+s.grade+" total  :  "+s.total+" rank: "+s.rank+" age:"+s.age+" iseligibletovote: "+s.isEligibleToVote);
		    }
		    //bitwise to find odd or even 
			System.out.println("print even number id :");
		    for(StudentDetails s:students) { 
		    	if((s.id&1)==0) {
		    		System.out.print(s.id+" ");
		    	}
		    }
	}
}


