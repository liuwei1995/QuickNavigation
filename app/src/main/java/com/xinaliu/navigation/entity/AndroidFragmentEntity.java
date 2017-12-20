package com.xinaliu.navigation.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by liuwei on 2017/12/20 10:36
 */

public class AndroidFragmentEntity implements Serializable, Parcelable {

    private String title;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public AndroidFragmentEntity() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.url);
    }

    protected AndroidFragmentEntity(Parcel in) {
        this.title = in.readString();
        this.url = in.readString();
    }

    public static final Creator<AndroidFragmentEntity> CREATOR = new Creator<AndroidFragmentEntity>() {
        @Override
        public AndroidFragmentEntity createFromParcel(Parcel source) {
            return new AndroidFragmentEntity(source);
        }

        @Override
        public AndroidFragmentEntity[] newArray(int size) {
            return new AndroidFragmentEntity[size];
        }
    };

    @Override
    public String toString() {
        return "AndroidFragmentEntity{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
