package hw1;

public class Salary {

    private int hoursOnDay;
    private int payForOneHours;
    private int workedDaysInMonth;
    private int hospitalDays;
    private int payForHospitalDays;
    private boolean absenteeism;
    private int countOfAbsenteeism;
    private int premium;
    int a = 5;


    public Salary(int hoursOnDay, int payForOneHours, int workedDaysInMonth, int hospitalDays,
                  int payForHospitalDays, boolean absenteeism, int countOfAbsenteeism, int premium) {
        this.hoursOnDay = hoursOnDay;
        this.payForOneHours = payForOneHours;
        this.workedDaysInMonth = workedDaysInMonth;
        this.hospitalDays = hospitalDays;
        this.payForHospitalDays = payForHospitalDays;
        this.absenteeism = absenteeism;
        this.countOfAbsenteeism = countOfAbsenteeism;
        this.premium = premium;
    }

    public int getSalary() throws DaysException {
        if (workedDaysInMonth > 31 || workedDaysInMonth < 1) {
            throw new DaysException("You can`t work more than 31 days or less than 1 day.");
        }
        int salary = hoursOnDay * payForOneHours * workedDaysInMonth + (getHospitalSalary());
        return salary;
    }

    public int getHospitalSalary() {
        int hospitalSalary = hospitalDays * payForHospitalDays;
        return hospitalSalary;
    }

    public int isAbsenteeismExist() throws DaysException {
        int salary = 0;
        if (absenteeism == true) {
            int fine = 1000;
            salary = (getSalary()) - fine;
        }
        if (countOfAbsenteeism > workedDaysInMonth) {
            salary = 0;
        }
        return salary;
    }

    public int getPremium() throws DaysException {
        int salary = 0;
        if (absenteeism == false && hospitalDays == 0) {
            salary = (getSalary()) + premium;
        }
        return salary;
    }

}
