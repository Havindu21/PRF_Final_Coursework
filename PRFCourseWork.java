import java.util.*;
class PRFCourseWork{
	
	public static String[] idArray=new String[0];
	public static String[] nameArray=new String[0];
	public static String[] numberArray=new String[0];
	public static String[] companyArray=new String[0];
	public static double[] salaryArray=new double[0];
	public static String[] bdayArray=new String[0];
	
	public static int index;
	public static int length;
	
	public final static void clearConsole() { 
		try {
			final String os = System.getProperty("os.name"); 
			if (os.contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\033[H\033[2J"); 
				System.out.flush();
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		homepage();
		option();
	}
	
	public static void homepage(){
		System.out.println("\t  iFRIEND\n\nContacts Organizer\n\n=================================\n");
		System.out.println("\t[01] ADD Contacts\n\t[02] UPDATE Contacts\n\t[03] DELETE Contacts\n\t[04] SEARCH Contacts\n\t[05] LIST Contacts\n\t[06] Exit\n\n");
	}	
	
	public static void option(){
		Scanner input=new Scanner(System.in);
		System.out.print("Enter an Option -> ");		
		int option=input.nextInt();
		switch(option){
			case 1:clearConsole();add();break;
			case 2:clearConsole();update();break;
			case 3:clearConsole();delete();break;
			case 4:clearConsole();search();break;
			case 5:clearConsole();list();break;
			case 6:return;
		}
	}
	
	public static void add(){
		Scanner input=new Scanner(System.in);
		name();
		number();
		company();
		salary();
		bday();
		testing();
		System.out.print("\n\tContact has been added successfully..\n\nDo you want to add another Contact (y/n) : ");
		char command=input.next().charAt(0);
		clearConsole();
		if(command=='y'||command=='Y'){
			add();
		}
		if(command=='n'||command=='N'){
			main(null);
		}
	}
	
	public static void name(){
		System.out.println("+--------------------------------------+");
		System.out.println("|       ADD Contact to the list        |");
		System.out.println("+--------------------------------------+\n\n");
		extendsArray();
		code();
		Scanner input=new Scanner(System.in);
		System.out.print("=======\n\nName                : ");
		String name=input.next();
		nameArray[nameArray.length-1]=name;
	}
	public static void company(){
		Scanner input=new Scanner(System.in);
		System.out.print("Company Name        : ");
		String company=input.next();
		companyArray[companyArray.length-1]=company;
	}
	public static void salary(){
		Scanner input=new Scanner(System.in);
		System.out.print("Salary              : ");
		double salary=input.nextDouble();
		if(salary>0){
			salaryArray[salaryArray.length-1]=salary;
		}else{
			System.out.print("\n\tInvalid Input...\n\nDo you want to add the correct salary (y/n) ?");
			char command=input.next().charAt(0);
			System.out.print("\033[5A");
			System.out.print("\033[0J");
			if(command=='y'||command=='Y'){
				salary();
			}
			if(command=='n'||command=='N'){
				main(null);
			}
		}
	}
	
	public static void number(){
		Scanner input=new Scanner(System.in);
		System.out.print("Phone Number        : ");
		String number=input.next();
		boolean bool=isDuplicate(number);
		if(bool){
			if(number.charAt(0)=='0'&&number.length()==10){
				numberArray[numberArray.length-1]=number;
			}else{
				System.out.print("\n\tInvalid phone number...\n\nDo you want to add phone number again (y/n) : ");
				char command=input.next().charAt(0);
				System.out.print("\033[5A");
				System.out.print("\033[0J");
				if(command=='y'||command=='Y'){
					number();
				}
				if(command=='n'||command=='N'){
					main(null);
				}
			}	
		}else{
			System.out.print("\n\tThis number is already added...\n\nDo you want to add phone number again (y/n) : ");		
			char command=input.next().charAt(0);
			System.out.print("\033[5A");
			System.out.print("\033[0J");
			if(command=='y'||command=='Y'){
				number();
			}
			if(command=='n'||command=='N'){
				main(null);
			}
		}
	}
	
	public static void bday(){
		Scanner input=new Scanner(System.in);
		System.out.print("B'Day(YYYY-MM-DD)   : ");
		String bday=input.nextLine();
		int year=Integer.parseInt(bday.charAt(0)+""+bday.charAt(1)+bday.charAt(2)+bday.charAt(3));
		int month=Integer.parseInt(bday.charAt(5)+""+bday.charAt(6));
		int days=Integer.parseInt(bday.charAt(8)+""+bday.charAt(9));
		boolean bool=isBday(year,month,days);
		if(bool){
			bdayArray[bdayArray.length-1]=bday;
		}else{
			System.out.print("\n\tInvalid Birthday...\n\nDo you want to input birthday again (y/n) : ");		
			char command=input.next().charAt(0);
			System.out.print("\033[5A");
			System.out.print("\033[0J");
			if(command=='y'||command=='Y'){
				bday();
			}
			if(command=='n'||command=='N'){
				main(null);
			}
		}
	}
	
	public static boolean isBday(int year, int month, int days){
		if(year>0&&year<=2023){
			if((year%4==0&&month==2&&days==29)||(year%4!=0&&month==2&&days==28)||((month==1||month==3||month==5||month==7||month==8||month==10||month==12)&&days<=31)||((month==4||month==6||month==9||month==11)&&days<=30)){
				if(year==2023&&month>5){
					return false;
				}else{
					return true;
				}
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	public static void extendsArray(){
		length=idArray.length;
		String[] tempIdArray=new String[length+1];
		String[] tempNameArray=new String[length+1];
		String[] tempNumberArray=new String[length+1];
		String[] tempCompanyArray=new String[length+1];
		double[] tempSalaryArray=new double[length+1];
		String[] tempBDayArray=new String[length+1];
		for(int i=0;i<length;i++){
			tempIdArray[i]=idArray[i];
			tempNameArray[i]=nameArray[i];
			tempNumberArray[i]=numberArray[i];
			tempCompanyArray[i]=companyArray[i];
			tempSalaryArray[i]=salaryArray[i];
			tempBDayArray[i]=bdayArray[i];
		}
		idArray=tempIdArray;
		nameArray=tempNameArray;
		numberArray=tempNumberArray;
		companyArray=tempCompanyArray;
		salaryArray=tempSalaryArray;
		bdayArray=tempBDayArray;
	}

	public static void reduceArray(){
		length=idArray.length;
		String[] tempIdArray=new String[length-1];
		String[] tempNameArray=new String[length-1];
		String[] tempNumberArray=new String[length-1];
		String[] tempCompanyArray=new String[length-1];
		double[] tempSalaryArray=new double[length-1];
		String[] tempBDayArray=new String[length-1];
		for(int i=0;i<index;i++){
			tempIdArray[i]=idArray[i];
			tempNameArray[i]=nameArray[i];
			tempNumberArray[i]=numberArray[i];
			tempCompanyArray[i]=companyArray[i];
			tempSalaryArray[i]=salaryArray[i];
			tempBDayArray[i]=bdayArray[i];
		}
		for(int i=index+1;i<length;i++){
			tempIdArray[i-1]=idArray[i];
			tempNameArray[i-1]=nameArray[i];
			tempNumberArray[i-1]=numberArray[i];
			tempCompanyArray[i-1]=companyArray[i];
			tempSalaryArray[i-1]=salaryArray[i];
			tempBDayArray[i-1]=bdayArray[i];
		}		
		idArray=tempIdArray;
		nameArray=tempNameArray;
		numberArray=tempNumberArray;
		companyArray=tempCompanyArray;
		salaryArray=tempSalaryArray;
		bdayArray=tempBDayArray;
	}
	
	public static void testing(){
		System.out.println(Arrays.toString(nameArray));
		System.out.println(Arrays.toString(numberArray));
		System.out.println(Arrays.toString(idArray));
		System.out.println(Arrays.toString(companyArray));
		System.out.println(Arrays.toString(salaryArray));
		System.out.println(Arrays.toString(bdayArray));
	}
	
	public static void code(){
		String id;
		if(idArray.length==0){
			id="C0001";
		}else{
			id=String.format("C%04d",(idArray.length));
		}
		System.out.println(" "+id);
		idArray[idArray.length-1]=id;
	}
	
	public static boolean isDuplicate(String number){
		for(int i=0;i<numberArray.length-1;i++){
			if(Integer.parseInt(numberArray[i])==Integer.parseInt(number)){
				return false;
			}
		}
		return true;
	}

	
	public static void update(){
		Scanner input=new Scanner(System.in);
		System.out.println("+--------------------------------------+");
		System.out.println("|            UPDATE Contact            |");
		System.out.print("+--------------------------------------+\n\n\nSearch Contact by Name or Phone Number - ");		
		String search=input.next();
		index=search(search);
		if(index==-1){
			System.out.print("\n\tNo contact found for \""+search+"\"...\n\nDo you want to try a new search (y/n) : ");
			char command=input.next().charAt(0);
			clearConsole();
			if(command=='y'||command=='Y'){
				update();
			}
			if(command=='n'||command=='N'){
				main(null);
			}
		}else{
			System.out.println("\n\n\tContact ID        : "+idArray[index]);
			System.out.println("\tName              : "+nameArray[index]);
			System.out.println("\tPhone Number      : "+numberArray[index]);
			System.out.println("\tCompany name      : "+companyArray[index]);
			System.out.println("\tSalary            : "+salaryArray[index]);
			System.out.println("\tB'Day(YYYY-MM-DD) : "+bdayArray[index]);
			System.out.println("\n\n\nWhat do you want to update...\n\n");
			option1();
			System.out.println("\n\nDo you want to update another Contact(y/n) :");
			char command=input.next().charAt(0);
			clearConsole();
			if(command=='y'||command=='Y'){
				update();
			}
			if(command=='n'||command=='N'){
				main(null);
			}
		}
	}
	
	public static void option1(){
		Scanner input=new Scanner(System.in);
		System.out.println("\t[01] Name");
		System.out.println("\t[02] Phone Number");
		System.out.println("\t[03] Company Name");
		System.out.println("\t[04] Salary\n\n\n");
		System.out.print("\tEnter an option to continue -> ");
		int option=input.nextInt();
		System.out.print("\033[11A");
		System.out.print("\033[0J");
		switch(option){
			case 1:nameU();break;
			case 2:numberU();break;
			case 3:companyU();break;
			case 4:salaryU();break;
		}
	}

	public static void nameU(){
		Scanner input=new Scanner(System.in);
		System.out.print(" Update Name\n============================\n\nInput new name - ");
		String name=input.next();
		nameArray[index]=name;
	}
	
	public static void companyU(){
		Scanner input=new Scanner(System.in);
		System.out.print(" Update Comapany Name\n============================\n\nInput new name - ");
		String company=input.next();
		companyArray[index]=company;
	}		
	
	public static void salaryU(){
		Scanner input=new Scanner(System.in);
		System.out.print(" Update Comapany Name\n============================\n\nInput new name - ");
		double salary=input.nextDouble();
		salaryArray[index]=salary;
	}		

	public static void numberU(){
		Scanner input=new Scanner(System.in);
		System.out.print(" Update Phone Number\n============================\n\nInput new phone number - ");
		String number=input.next();
		boolean bool=isDuplicate(number);
		if(bool){
			if(number.charAt(0)=='0'&&number.length()==10){
				numberArray[index]=number;
			}else{
				System.out.print("\n\tInvalid phone number...\n\nDo you want to add phone number again (y/n) : ");
				char command=input.next().charAt(0);
				System.out.print("\033[5A");
				System.out.print("\033[0J");
				if(command=='y'||command=='Y'){
					numberU();
				}
				if(command=='n'||command=='N'){
					main(null);
				}
			}	
		}else{
			System.out.print("\n\tThis number is already added...\n\nDo you want to add phone number again (y/n) : ");		
			char command=input.next().charAt(0);
			System.out.print("\033[5A");
			System.out.print("\033[0J");
			if(command=='y'||command=='Y'){
				numberU();
			}
			if(command=='n'||command=='N'){
				main(null);
			}
		}
		System.out.println("\t Contact has been update successfully..\n\n\nDo you want to update another Contact (y/n) : ");
		char command=input.next().charAt(0);
		clearConsole();
		if(command=='y'||command=='Y'){
			update();
		}
		if(command=='n'||command=='N'){
			main(null);
		}
	}
		
		
	
	public static int search(String search){
		for(int i=0;i<nameArray.length;i++){
			if(nameArray[i].equalsIgnoreCase(search)||numberArray[i].equalsIgnoreCase(search)){
				return i;
			}
		}
		return -1;
	}
	
	public static void delete(){
		Scanner input=new Scanner(System.in);
		System.out.println("+--------------------------------------+");
		System.out.println("|            DELETE Contact            |");
		System.out.print("+--------------------------------------+\n\n\nSearch Contact by Name or Phone Number - ");				
		String search=input.next();
		int index=search(search);
		if(index==-1){
			System.out.print("\n\tNo contact found for \""+search+"\"...\n\nDo you want to try a new search (y/n) : ");
			char command=input.next().charAt(0);
			clearConsole();
			if(command=='y'||command=='Y'){
				delete();
			}
			if(command=='n'||command=='N'){
				main(null);
			}
		}else{
			System.out.println("\n\n\tContact ID        : "+idArray[index]);
			System.out.println("\tName              : "+nameArray[index]);
			System.out.println("\tPhone Number      : "+numberArray[index]);
			System.out.println("\tCompany name      : "+companyArray[index]);
			System.out.println("\tSalary            : "+salaryArray[index]);
			System.out.println("\tB'Day(YYYY-MM-DD) : "+bdayArray[index]);
			System.out.print("\nDo you want to delete this Contact (y/n) : ");
			char command=input.next().charAt(0);
			if(command=='y'||command=='Y'){
				deleting();
			}
			if(command=='n'||command=='N'){
				main(null);
			}
			System.out.print("\n\nDo you want to delete another Contact(y/n) :");
			command=input.next().charAt(0);
			clearConsole();
			if(command=='y'||command=='Y'){
				delete();
			}
			if(command=='n'||command=='N'){
				main(null);
			}
		}
	}
	
	public static void deleting(){
		Scanner input=new Scanner(System.in);
		reduceArray();
		System.out.println("\n\n\tContact has been deleted successfully..");
		System.out.println("\n\nDo you want to delete another Contact (y/n) : ");
		char command=input.next().charAt(0);
		clearConsole();
		if(command=='y'||command=='Y'){
			delete();
		}
		if(command=='n'||command=='N'){
			main(null);
		}
	}
		
	
	public static void search(){
		Scanner input=new Scanner(System.in);
		System.out.println("+--------------------------------------+");
		System.out.println("|            SEARCH Contact            |");
		System.out.print("+--------------------------------------+\n\n\nSearch Contact by Name or Phone Number - ");				
		String search=input.next();
		int index=search(search);
		if(index==-1){
			System.out.print("\n\tNo contact found for \""+search+"\"...\n\nDo you want to try a new search (y/n) : ");
			char command=input.next().charAt(0);
			clearConsole();
			if(command=='y'||command=='Y'){
				search();
			}
			if(command=='n'||command=='N'){
				main(null);
			}
		}else{
			System.out.println("\n\n\tContact ID        : "+idArray[index]);
			System.out.println("\tName              : "+nameArray[index]);
			System.out.println("\tPhone Number      : "+numberArray[index]);
			System.out.println("\tCompany name      : "+companyArray[index]);
			System.out.println("\tSalary            : "+salaryArray[index]);
			System.out.print("\tB'Day(YYYY-MM-DD) : "+bdayArray[index]+"\n\nDo you want to search another Contact(y/n) :");
			char command=input.next().charAt(0);
			clearConsole();
			if(command=='y'||command=='Y'){
				search();
			}
			if(command=='n'||command=='N'){
				main(null);
			}
		}
	}
	
	public static void list(){
		Scanner input=new Scanner(System.in);
		System.out.println("+--------------------------------------+");
		System.out.println("|            SEARCH Contact            |");
		System.out.println("+--------------------------------------+");
		System.out.println("\t[01] Sorting by Name\n\n\t[02] Sorting by Salary\n\n\t[03] Sorting by Birthday");	
		option2();
}

	public static void option2(){
		Scanner input=new Scanner(System.in);
		System.out.print("\n\nEnter an option to continue ->");
		int option2=input.nextInt();
		clearConsole();
		switch(option2){
			case 1:nameS();break;
			case 2:salaryS();break;
			case 3:bdayS();break;
		}
		System.out.print("\n\nDo you want to go to Home Page (y/n) : ");
		char command=input.next().charAt(0);
		clearConsole();
		if(command=='y'||command=='Y'){
			main(null);
		}
		if(command=='n'||command=='N'){
			return;
		}
	}
	
	public static void nameS(){
		System.out.println("\t+--------------------------------------+");
		System.out.println("\t|         LIST Contact by Name         |");
		System.out.println("\t+--------------------------------------+\n\n");		
		naming();
		sorting();
	}
	
	public static void sorting(){
		System.out.println("+----------------+-------------------------+------------------+-----------------+------------------+-------------------+");
		System.out.println("|  Contact ID    |        Name             |    Phone Number  |      Company    |      Salary      |      Birthday     |");
		System.out.println("+----------------+-------------------------+------------------+-----------------+------------------+-------------------+");
		for (int i = 0; i <=length; i++){
			System.out.printf("| %-15s|    %-20s |  %-15s |  %-15s|   %-15s|   %-15s |\n",idArray[i],nameArray[i],numberArray[i],companyArray[i],salaryArray[i],bdayArray[i]);
		}
		System.out.println("+----------------+-------------------------+------------------+-----------------+------------------+-------------------+");	
	}
	
	public static void naming(){
		for(int j=length;j>=0;j--){
			for(int i=0;i<j-1;i++){
				if(nameArray[i].compareToIgnoreCase(nameArray[i+1])>0){
					String nameT=nameArray[i];
					nameArray[i]=nameArray[i+1];
					nameArray[i+1]=nameT;
					String numberT=numberArray[i];
					numberArray[i]=numberArray[i+1];
					numberArray[i+1]=numberT;
					String companyT=companyArray[i];
					companyArray[i]=companyArray[i+1];
					companyArray[i+1]=companyT;
					double salaryT=salaryArray[i];
					salaryArray[i]=salaryArray[i+1];
					salaryArray[i+1]=salaryT;
					String bdayT=bdayArray[i];
					bdayArray[i]=bdayArray[i+1];
					bdayArray[i+1]=bdayT;
					String idT=idArray[i];
					idArray[i]=idArray[i+1];
					idArray[i+1]=idT;
				}
			}
		}
	}
	
	public static void salaryS(){
		System.out.println("\t+--------------------------------------+");
		System.out.println("\t|        LIST Contact by Salary        |");
		System.out.println("\t+--------------------------------------+\n\n");		
		salaring();
		sorting();		
	}
	
	public static void salaring(){
		for(int j=length;j>=0;j--){
			for(int i=0;i<j-1;i++){
				if(salaryArray[i]>salaryArray[i+1]){
					String nameT=nameArray[i];
					nameArray[i]=nameArray[i+1];
					nameArray[i+1]=nameT;
					String numberT=numberArray[i];
					numberArray[i]=numberArray[i+1];
					numberArray[i+1]=numberT;
					String companyT=companyArray[i];
					companyArray[i]=companyArray[i+1];
					companyArray[i+1]=companyT;
					double salaryT=salaryArray[i];
					salaryArray[i]=salaryArray[i+1];
					salaryArray[i+1]=salaryT;
					String bdayT=bdayArray[i];
					bdayArray[i]=bdayArray[i+1];
					bdayArray[i+1]=bdayT;
					String idT=idArray[i];
					idArray[i]=idArray[i+1];
					idArray[i+1]=idT;
				}
			}
		}
	}
	
	public static void bdayS(){
		System.out.println("\t+--------------------------------------+");
		System.out.println("\t|       LIST Contact by Birthday       |");
		System.out.println("\t+--------------------------------------+\n\n");		
		daying();
		sorting();		
	}		
	
	public static void daying(){
		for(int j=length;j>=0;j--){
			for(int i=0;i<j-1;i++){
				if(bdayArray[i].compareToIgnoreCase(bdayArray[i+1])>0){
					String nameT=nameArray[i];
					nameArray[i]=nameArray[i+1];
					nameArray[i+1]=nameT;
					String numberT=numberArray[i];
					numberArray[i]=numberArray[i+1];
					numberArray[i+1]=numberT;
					String companyT=companyArray[i];
					companyArray[i]=companyArray[i+1];
					companyArray[i+1]=companyT;
					double salaryT=salaryArray[i];
					salaryArray[i]=salaryArray[i+1];
					salaryArray[i+1]=salaryT;
					String bdayT=bdayArray[i];
					bdayArray[i]=bdayArray[i+1];
					bdayArray[i+1]=bdayT;
					String idT=idArray[i];
					idArray[i]=idArray[i+1];
					idArray[i+1]=idT;
				}
			}
		}
	}
		
}
