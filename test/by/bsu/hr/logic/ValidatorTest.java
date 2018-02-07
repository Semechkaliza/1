package by.bsu.hr.logic;

import by.bsu.hr.entity.User;
import org.apache.catalina.Session;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ValidatorTest {

    @Test
    public void validVacancy() throws Exception {
        String emptyVacancy="";
        String company="My company";
        boolean actual=Validator.validVacancy(emptyVacancy,company);
        assertEquals(false,actual);
    }

    @Test
    public void dateValid() throws Exception {
        boolean[] expected={true,true,false};
        boolean[] actual=new boolean[3];
        String trueDate1="12.12.2018";
        String trueDate2="12/12/2018";
        String falseDate="13.13.2018";
        actual[0]=Validator.dateValid(trueDate1);
        actual[1]=Validator.dateValid(trueDate2);
        actual[2]=Validator.dateValid(falseDate);
        assertArrayEquals(expected,actual);
    }

    @Test
    public void timeValid() throws Exception {
        String timeTrue24="17:00";
        String timeTrue12="10:00 AM";
        String timeFalse24="25:17";
        String timeFalse12="13:00 PM";
        boolean[] expected= new boolean[]{true, true, false, false};
        boolean[] actual=new boolean[4];
        actual[0] =Validator.timeValid(timeTrue24);
        actual[1] =Validator.timeValid(timeTrue12);
        actual[2] =Validator.timeValid(timeFalse24);
        actual[3] =Validator.timeValid(timeFalse12);
        assertArrayEquals(expected,actual);

    }

    @Test
    public void markValid() throws Exception {
        String trueMark="10";
        String falseMark="11";
        boolean[] expected= new boolean[]{true,false};
        boolean[] actual=new boolean[2];
        actual[0]=Validator.markValid(trueMark);
        actual[1]=Validator.markValid(falseMark);
        assertArrayEquals(expected,actual);
    }

}