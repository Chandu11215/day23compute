class computeEmpWage {
        //constant
        public static final int IS_FULL_TIME = 1;
        public static final int IS_PART_TIME = 2;

	private int numOfCompany = 0;
	private ArrayList<CompanyEmpWage> companyEmpWageArrayList;
	public EmployeeWageOops() {
		companyEmpWageArrayList = new ArrayList<>();

	}
	private void addCompanyEmpWage(String company, int empRatePerHr, int numberOfWorkingDays, int maxHrPerMonth) {
		CompanyEmpWage companyEmpWage = new CompanyEmpWage(company, empRatePerHr, numberOfWorkingDays, maxHrPerMonth);
		companyEmpWageArrayList.add(companyEmpWage);
		//numOfCompany++;


	}
	private void computeEmpWage() {
		for (int i=0; i<companyEmpWageArrayList.size(); i++) {
			CompanyEmpWage companyEmpWage = companyEmpWageArrayList.get(i);
			companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage));
			System.out.println(companyEmpWage);
		}
	}
       private int computeEmpWage(CompanyEmpWage companyEmpWage) {
                //variables

		int empHrs = 0;
		int totalEmpHrs = 0;
		int totalWorkingDays = 0;
		//int totalEmpWage = 0;

		//computation
		while (totalEmpHrs <= companyEmpWage.maxHrPerMonth && totalWorkingDays < companyEmpWage.numberOfWorkingDays) {

			totalWorkingDays++;
			double empCheck = Math.floor(Math.random() * 10) % 3;
			switch ((int)empCheck) {
                        	case IS_FULL_TIME :
                                        empHrs = 8;
                                        break;
                                case IS_PART_TIME :
                                        empHrs = 4;
                                        break;
                                default :
                                        empHrs = 0;

			}//switch
			totalEmpHrs += empHrs;
			System.out.println("totalWorkingDays: "+totalWorkingDays+"/ daly empHrs: "+empHrs+"/ totalEmpHrs: "+totalEmpHrs);
		}//while

		return totalEmpHrs * companyEmpWage.empRatePerHr;


        }//empSalary()
		//public String toString() {
		//	return "Total employee wage for: " +company+ "is " +totalEmpWage;
		//}


        public static void main(String[] args) {
        	EmployeeWageOops empWageBuilder = new EmployeeWageOops();
		empWageBuilder.addCompanyEmpWage("icici", 50, 20, 100);
		empWageBuilder.addCompanyEmpWage("DMart", 20, 20, 100);
		empWageBuilder.addCompanyEmpWage("accenture", 100, 20, 100);
		empWageBuilder.addCompanyEmpWage("IBM", 100, 20, 100);
		empWageBuilder.addCompanyEmpWage("google", 100, 20, 100);
		empWageBuilder.computeEmpWage();
        }//main()
}//class
