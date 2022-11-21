package com.youkeda.test.j5c5s7p2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 晚自习
 */
public class NightStudy {
    private static ReadingRoom room = new ReadingRoom();
    private static Random r = new Random();

    public static void main(String[] args) {
        List<Student> students = initStudents();
        List<CompletableFuture> cfs = new ArrayList<>();
        students.stream()
                .forEach(student -> {
                    CompletableFuture<Void> cf = CompletableFuture.supplyAsync(() -> studyBegin(student))
                            .thenApply(student1 -> {
                                return study(student1);
                            })
                            .thenAccept(student1 -> {
                                studyComplete(student1);
                            });
                    cfs.add(cf);
                });
        try {
            CompletableFuture.allOf(cfs.toArray(new CompletableFuture[]{})).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    private static Student studyBegin(Student s) {
        while (s.getPlaceIndex() == -1) {
            if (room.sit(s)) {
                System.out.println(s.getName() + "抢座位成功，座位号：" + s.getPlaceIndex());
                break;
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return s;
    }

    private static Student study(Student s) {
        int time = r.nextInt(201) + 200;
        System.out.println(s.getName() + "学习" + time + "毫秒");
        return s;
    }

    private static void studyComplete(Student s) {
        room.leave(s);
        System.out.println(s.getName() + "学习结束离开座位，座位号：" + s.getPlaceIndex());
    }

    private static List<Student> initStudents() {
        List<Student> students = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            Student s = new Student();
            s.setName("同学" + i + "号");
            students.add(s);
        }

        return students;
    }
}
