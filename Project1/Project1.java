**Solution 1:**

import java.util.Scanner;

public class Project1 {

 	public static void main(String[] args) {
		String[][] emptable = { { "1001", "ashish", "01/04/2009", "e", "R&D", "20000", "8000", "3000" },
 								{ "1002", "sushma", "23/08/2012", "c", "PM", "30000", "12000", "9000" },
 								{ "1003", "Rahul", "12/11/2008", "k", "Acct", "10000", "8000", "1000" },
 								{ "1004", "Chahat", "29/01/2013", "r", "FrontDesk", "12000", "6000", "2000" },
 								{ "1005", "Ranjan", "16/07/2005", "m", "Engg", "50000", "20000", "20000" },
 								{ "1006", "Suman", "1/1/2000", "e", "Manufacturing", "23000", "9000", "4400" },
 								{ "1007", "Tanmay", "12/06/2006", "c", "PM", "29000", "12000", "10000" }
                               };
							  
 		String[][] empdes = {   { "e", "Engineer", "20000" }, 
 								{ "c", "Consultant", "32000" },
								{ "k", "Clerk", "12000" },
 								{ "r", "Receptionist", "15000" },
 							    { "m", "Manager", "40000" }

 		                    };

 		Scanner sc = new Scanner(System.in);

 		int empno = Integer.parseInt(args[0]); // As the program dmeands input using Command prompt so I used Command Line Arguments
 												// Line Arguments
 		int no = 0;
 		int flag = 0;
 		for (int i = 0; i < emptable.length; i++) {
 			if (empno == Integer.parseInt(emptable[i][0])) {
 				no = i;
 				flag = 1;
				break;
			}
 		}
 		char c = emptable[no][3].charAt(0);
		String des = "";
		int da = 0;
		String empname = emptable[no][1];
 		String dep = emptable[no][4];
 		switch (c) {
 			case 'e':
 				des = empdes[0][1];
 				da = Integer.parseInt(empdes[0][2]);
 				break;
 			case 'c':
 				des = empdes[1][1];
				da = Integer.parseInt(empdes[1][2]);
				break;
			case 'k':
				des = empdes[2][1];
				da = Integer.parseInt(empdes[2][2]);
				break;
			case 'r':
				des = empdes[3][1];
				da = Integer.parseInt(empdes[3][2]);
				break;
			case 'm':
				des = empdes[4][1];
				da = Integer.parseInt(empdes[4][2]);
 				break;
		}
 		int amt = Integer.parseInt(emptable[no][5]) + Integer.parseInt(emptable[no][6]) + da
 				- Integer.parseInt(emptable[no][7]);
 		if (flag == 1) {
 			System.out.println(
 					"\nEmp No. " + "|" + " Emp Name" + " |" + " Department" + " |" + " Desgination" + " |" + " Salary");
 			for (int i = 0; i < 55; i++)
 				System.out.print("=");
 			System.out.println(
 					"\n" + empno + "       " + empname + "       " + dep + "         " + des + "       " + amt);
 		} else {
 			System.out.println("\nThere is no employee with empid : " + empno);
		}

 	}

 }



**Solution 2:**

import java.util.Arrays;

public class Project1 {
	public static String[] empcolumn = { "EmpNo", "EmpName", "JoinDate", "DesignationCode", "Department", "Basic", "HRA", "IT" };
	public static String[][] empdetails = new String[][] {
								{ "1001", "Ashish", "01/04/2009", "e", "R & D", "20000", "8000", "3000" },
								{ "1002", "Sushma", "23/08/2012", "c", "PM", "30000", "12000", "9000" },
								{ "1003", "Rahul", "12/11/2008", "k", "Acct", "10000", "8000", "1000" },
							  	{ "1004", "Chahat", "29/01/2013", "r", "FrontDesk", "12000", "6000", "2000" },
								{ "1005", "Ranjan", "16/07/2005", "m", "Engg", "50000", "20000", "20000" },
								{ "1006", "Suman", "1/1/2000", "e", "Manufacturing", "23000", "9000", "4400" },
								{ "1007", "Tanmay", "12/06/2006", "c", "PM", "29000", "12000", "10000" } 
							};

	public static String[] desg = { "DesignationCode", "Designation", "DA" };
	public static String[][] desgdata = new String[][] { 
		                                                { "e", "Engineer", "20000" }, 
								{ "c", "Consultant", "32000" },
			                                        { "k", "Clerk", "12000" }, 
								{ "r", "Receptionist", "15000" }, 
								{ "m", "Manager", "40000" } 
							};

	public static void main(String[] args) {
		try {

			String[] employee = getEmployee(Integer.parseInt(args[0]));
			String DesignationCode = employee[Arrays.asList(empcolumn).indexOf("DesignationCode")];
			String[] da = getDA(DesignationCode);
			String Designation = da[Arrays.asList(desg).indexOf("Designation")];

			int Basic = Integer.parseInt(employee[Arrays.asList(empcolumn).indexOf("Basic")]);
			int HRA = Integer.parseInt(employee[Arrays.asList(empcolumn).indexOf("HRA")]);
			int IT = Integer.parseInt(employee[Arrays.asList(empcolumn).indexOf("IT")]);
			int DA = Integer.parseInt(da[Arrays.asList(desg).indexOf("DA")]);
			int salary = Basic + HRA + DA - IT;

			System.out.printf("%-10s%-10s%-15s%-15s%-10s\n", "Emp No", "Emp Name", "Department", "Designation",
					"Salary");
			for (int i = 0; i < 60; i++)
				System.out.print("-");
			System.out.println();
			System.out.printf("%-10s%-10s%-15s%-15s%-10s", employee[0], employee[1], employee[4], Designation, salary);
		} catch (Exception e) {
			System.out.println("There is no employee with empid : " + args[0]);
		}
	}

	public static String[] getEmployee(int EmpNo) {
		int rowSize = empdetails.length;
		int colSize = empdetails[0].length;
		String[] employee = new String[colSize];

		for (int i = 0; i < rowSize; i++) {
			if (EmpNo == Integer.parseInt(empdetails[i][0])) {
				for (int j = 0; j < colSize; j++) {
					employee[j] = empdetails[i][j];

				}
			}
		}

		return employee;
	}

	public static String[] getDA(String DesignationCode) {
        int rowSize = desgdata.length;
		int colSize = desgdata[0].length;
		String[] da = new String[colSize];

		switch (DesignationCode) {
			case "e":
				for (int i = 0; i < rowSize; i++) {
					if (DesignationCode.equals(desgdata[i][0])) {
						for (int j = 0; j < colSize; j++) {
							da[j] = desgdata[i][j];
						
					    }
				   }
			    }

				break;

			case "c":
				for (int i = 0; i < rowSize; i++) {
					if (DesignationCode.equals(desgdata[i][0])) {
						for (int j = 0; j < colSize; j++) {
							da[j] = desgdata[i][j];
					
						}
			   		}
				}

				break;

			case "k":
				for (int i = 0; i < rowSize; i++) {
					if (DesignationCode.equals(desgdata[i][0])) {
						for (int j = 0; j < colSize; j++) {
							da[j] = desgdata[i][j];
					
						}
			  		}
				}
				
				break;

			case "r":
				for (int i = 0; i < rowSize; i++) {
					if (DesignationCode.equals(desgdata[i][0])) {
						for (int j = 0; j < colSize; j++) {
							da[j] = desgdata[i][j];
					
						}
			   		}	
				}
				
				break;

			case "m":
				for (int i = 0; i < rowSize; i++) {
					if (DesignationCode.equals(desgdata[i][0])) {
						for (int j = 0; j < colSize; j++) {
							da[j] = desgdata[i][j];
					
						}
			   		}
				}
				
				break;
		}

		return da;
	}
}
