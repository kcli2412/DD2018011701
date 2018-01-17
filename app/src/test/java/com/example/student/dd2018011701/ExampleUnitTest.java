package com.example.student.dd2018011701;

import com.example.student.dd2018011701.data.Student;
import com.example.student.dd2018011701.data.StudentScoreDAO;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void test_add_data() throws Exception {
        StudentScoreDAO dao = new StudentScoreDAO();
        dao.add(new Student(1,"Bob",95));
        dao.add(new Student(2,"Mary",80));
        assertEquals(2, dao.getList().size());
    }

    @Test
    public void test_add_data2() throws Exception {
        StudentScoreDAO dao = new StudentScoreDAO();
        dao.add(new Student(1,"Bob",95));
        dao.add(new Student(2,"Mary",80));
        assertEquals(80,dao.getList().get(1).score);
    }

    @Test
    public void test_getStudent() throws Exception {
        StudentScoreDAO dao = new StudentScoreDAO();
        dao.add(new Student(1,"Bob",95));
        dao.add(new Student(2,"Mary",80));
        assertEquals(80, dao.getStudent(2).score);
    }

    @Test
    public void test_getStudent1() throws Exception {
        StudentScoreDAO dao = new StudentScoreDAO();
        dao.add(new Student(1,"Bob",95));
        dao.add(new Student(2,"Mary",80));
        assertEquals(null, dao.getStudent(3));
    }

    @Test
    public void test_updateStudent() throws Exception {
        StudentScoreDAO dao = new StudentScoreDAO();
        dao.add(new Student(1,"Bob",95));
        dao.add(new Student(2,"Mary",80));
        dao.update(new Student(1, "Helen", 90));
        assertEquals(90, dao.getStudent(1).score);
    }
    @Test
    public void test_udapteStudent1() throws Exception {
        StudentScoreDAO dao = new StudentScoreDAO();
        dao.add(new Student(1,"Bob",95));
        dao.add(new Student(2,"Mary",80));
        assertEquals(false, dao.update(new Student(3, "Jeff", 60)));
    }

    @Test
    public void test_deleteStudent() throws Exception {
        StudentScoreDAO dao = new StudentScoreDAO();
        dao.add(new Student(1,"Bob",95));
        dao.add(new Student(2,"Mary",80));
        dao.delete(1);
        assertEquals(1, dao.getList().size());
    }
    @Test
    public void test_deleteStudent1() throws Exception {
        StudentScoreDAO dao = new StudentScoreDAO();
        dao.add(new Student(1,"Bob",95));
        dao.add(new Student(2,"Mary",80));
        assertEquals(false, dao.delete(3));
    }
    @Test
    public void test_deleteStudent2() throws Exception {
        StudentScoreDAO dao = new StudentScoreDAO();
        dao.add(new Student(1,"Bob",95));
        dao.add(new Student(2,"Mary",80));
        dao.delete(2);
        assertEquals(null, dao.getStudent(2));
    }
}