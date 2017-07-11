package com.yxy.study.demos.bean;


import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.yxy.study.demos.BR;

public class StudentEntity extends BaseObservable{
    private String studentName;

    @Bindable
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
        notifyPropertyChanged(BR.studentName);
    }

}
