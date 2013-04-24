package main;

import java.util.Calendar;

public class ArgsTest {
	
    private boolean fileOpen(String fileName){
    	return true;
    }

    public void start(String date){
    	System.out.println(date);
    }
    
    private static void writeUsage(){
    	System.out.println( "사용법: java NtmsLinkage [ date ]" );
		System.out.println( "    예) java NtmsLinkage 20080101" );
		System.exit(0);
    }
	
	public static void main(String[] args){
		System.out.println("\n↓↓↓↓↓↓↓↓↓↓↓   NTMS 연동 시작   ↓↓↓↓↓↓↓↓↓↓");
		
		if ( args.length != 1 ){
			writeUsage();
		}
		
		String date = args[0];
		if ( date.length() != 8){
			writeUsage();
		}

		//날짜 형식이 맞는지 검사
		try {
			Calendar cal = Calendar.getInstance();
			
			System.out.println(date.substring(0,4));
			cal.set( Calendar.YEAR, Integer.parseInt(date.substring(0,4)));
			System.out.println(date.substring(4,6));
			cal.set( Calendar.MONTH, Integer.parseInt(date.substring(4,6)));
			System.out.println(date.substring(6,8));
			cal.set( Calendar.DATE, Integer.parseInt(date.substring(6,8)));
			
			System.out.println( cal.toString());
		}catch(Exception e){
			writeUsage();
		}

		new ArgsTest().start(args[0]);
	}
	
	
}
