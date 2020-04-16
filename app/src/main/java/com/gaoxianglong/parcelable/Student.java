package com.gaoxianglong.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable{
    private String name;
    private Score score;

    public Student(String name, Score score) {
        this.name = name;
        this.score = score;
    }

    protected Student(Parcel in) {
        name = in.readString();
        score = in.readParcelable(Score.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeParcelable(score, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}

/**
 * 实现接口Parcelable 点中类名alt+enter选择AddParcelableImplementation
 */
class Score implements Parcelable {
    private int math;
    private int Chinese;

    public Score(int math, int chinese) {
        this.math = math;
        Chinese = chinese;
    }

    protected Score(Parcel in) {
        math = in.readInt();
        Chinese = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(math);
        dest.writeInt(Chinese);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Score> CREATOR = new Creator<Score>() {
        @Override
        public Score createFromParcel(Parcel in) {
            return new Score(in);
        }

        @Override
        public Score[] newArray(int size) {
            return new Score[size];
        }
    };

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getChinese() {
        return Chinese;
    }

    public void setChinese(int chinese) {
        Chinese = chinese;
    }
}
