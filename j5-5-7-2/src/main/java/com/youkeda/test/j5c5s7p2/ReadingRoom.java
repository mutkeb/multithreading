package com.youkeda.test.j5c5s7p2;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 停车场
 */
public class ReadingRoom {
    private static AtomicBoolean[] PLACES ={new AtomicBoolean(false),new AtomicBoolean(false),
            new AtomicBoolean(false),new AtomicBoolean(false),new AtomicBoolean(false)};

    // 坐下。返回 成功/失败，败表示没有空位
    public boolean sit(Student student) {

        for(int i = 0 ;i < 5; i++){
            if(PLACES[i].compareAndSet(false,true)){
                student.setPlaceIndex(i);
                return true;
            }
        }
        return false;
    }

    // 离开
    public void leave(Student student) {
        if(student.getPlaceIndex() >= 0 && student.getPlaceIndex() < 5){
            boolean b = PLACES[student.getPlaceIndex()].compareAndSet(true, false);
            student.setPlaceIndex(-1);
        }
    }
}
