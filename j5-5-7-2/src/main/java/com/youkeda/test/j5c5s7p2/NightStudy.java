package com.youkeda.test.j5c5s7p2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 晚自习
 */
public class NightStudy {
    private static ReadingRoom room = new ReadingRoom();
    private static Random r = new Random();

    public static void main(String[] args) {
        Student s = new Student();
        s.setName("文征明");

        room.sit(s);

        if (s.getPlaceIndex() < 0) {
            throw new RuntimeException("抢座位后，座位号应该大于等于 0");
        }

        room.leave(s);

        if (s.getPlaceIndex() != -1) {
            throw new RuntimeException("离开座位后，座位号应该等于 -1");
        }
    }

    private static Student studyBegin(Student s) {

        return s;
    }

    private static Student study(Student s) {

        return s;
    }

    private static void studyComplete(Student s) {

    }

    private static List<Student> initStudents() {
        List<Student> students = new ArrayList<>();

        return students;
    }
}
