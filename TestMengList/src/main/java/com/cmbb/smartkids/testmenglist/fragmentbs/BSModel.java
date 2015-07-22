package com.cmbb.smartkids.testmenglist.fragmentbs;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 项目名称：MengBao
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：15/7/22 上午10:29
 */
public class BSModel implements Parcelable {

    private String name;
    private int tag;

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.tag);
    }

    public BSModel() {
    }

    protected BSModel(Parcel in) {
        this.name = in.readString();
        this.tag = in.readInt();
    }

    public static final Parcelable.Creator<BSModel> CREATOR = new Parcelable.Creator<BSModel>() {
        public BSModel createFromParcel(Parcel source) {
            return new BSModel(source);
        }

        public BSModel[] newArray(int size) {
            return new BSModel[size];
        }
    };
}
