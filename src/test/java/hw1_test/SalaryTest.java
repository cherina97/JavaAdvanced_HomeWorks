package hw1_test;

import hw1.DaysException;
import hw1.Salary;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SalaryTest {

    private Salary salary;

    @Before
    public void beforeTest() {
        salary = new Salary(8, 40,
                50, 0, 30,
                false, 26, 1000);
    }

    @Test(expected = DaysException.class)
    public void itGetsSalary() throws DaysException {
        int realSalary = salary.getSalary();
        int expectedSalary = 8090;

        Assert.assertEquals(expectedSalary, realSalary);
    }

    @Test
    public void itAddsPremium(){
        int realSalary = salary.getPremium();
        int expectedSalary = 9090;

        Assert.assertEquals(expectedSalary, realSalary);
    }

    @Test
    public void itGetsSalaryWithAbsenteeism(){
        int realSalary = salary.isAbsenteeismExist();
        int expectedSalary = 0;

        Assert.assertEquals(expectedSalary, realSalary);
    }

    @Test
    public void itHospitalSalary() {
        int real = salary.getHospitalSalary();
        int expected = 90;

        Assert.assertEquals(expected, real);
    }


    @After
    public void AfterTest() {
        salary = null;
    }
}

