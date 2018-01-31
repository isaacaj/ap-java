package daily.day02;

class PayrollProgram

{

    public static void main(String[] args)

    {

        long hoursWorked;

        double payRate, taxRate;

        hoursWorked = 40;
        payRate = 10;
        taxRate = 0.10;

        System.out.println("Hours Worked: " + hoursWorked);

        System.out.println("pay Amount  : " + (hoursWorked * payRate));

        System.out.println("tax Amount  : " + (hoursWorked * payRate * taxRate));

    }

}
