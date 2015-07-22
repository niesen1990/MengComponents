package com.cmbb.smartkids.testmenglist.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by N.Sun
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final String TAG = DBHelper.class.getSimpleName();


    //public static int DATABASE_VERSION = 14;
    // 当前释放
    //public static int DATABASE_VERSION = 15;
    public static int DATABASE_VERSION = 16;

    public DBHelper(Context context) {
        super(context, SmartKidContract.DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, "DB Create");
        db.execSQL(SmartKidContract.UserAccount.CREATE_TABLE);
        db.execSQL(SmartKidContract.UserBasic.CREATE_TABLE);
        db.execSQL(SmartKidContract.HomeSameAge.CREATE_TABLE);
        db.execSQL(SmartKidContract.HomeSameAgeList.CREATE_TABLE);
        db.execSQL(SmartKidContract.HomeSameAgeListDetail.CREATE_TABLE);
        db.execSQL(SmartKidContract.HomeSameAgeListReplays.CREATE_TABLE);
        db.execSQL(SmartKidContract.PostModelWonderful.CREATE_TABLE);
        db.execSQL(SmartKidContract.PostModelWonderfulList.CREATE_TABLE);
        db.execSQL(SmartKidContract.PostModelWonderfulListDetail.CREATE_TABLE);
        db.execSQL(SmartKidContract.PostModelWonderfulListReplays.CREATE_TABLE);
        db.execSQL(SmartKidContract.CaseList.CREATE_TABLE);
        db.execSQL(SmartKidContract.CaseDetailList.CREATE_TABLE);
        db.execSQL(SmartKidContract.CaseDetail.CREATE_TABLE);
        db.execSQL(SmartKidContract.CaseReplays.CREATE_TABLE);
        db.execSQL(SmartKidContract.SearchUser.CREATE_TABLE);
        db.execSQL(SmartKidContract.SearchCase.CREATE_TABLE);
        db.execSQL(SmartKidContract.SearchPost.CREATE_TABLE);
        db.execSQL(SmartKidContract.GrowthRecord.CREATE_TABLE);
        db.execSQL(SmartKidContract.MasterFindType.CREATE_TABLE);
        db.execSQL(SmartKidContract.MasterFindByTypeUser.CREATE_TABLE);
        db.execSQL(SmartKidContract.MasterFindAttentionUser.CREATE_TABLE);
        db.execSQL(SmartKidContract.BabyFindByBaby.CREATE_TABLE);
        db.execSQL(SmartKidContract.BabyDaily.CREATE_TABLE);
        db.execSQL(SmartKidContract.EredarList.CREATE_TABLE);
        db.execSQL(SmartKidContract.HomeImgList.CREATE_TABLE);
        db.execSQL(SmartKidContract.PlateList.CREATE_TABLE);
        db.execSQL(SmartKidContract.ExpertList.CREATE_TABLE);
        db.execSQL(SmartKidContract.ServeList.CREATE_TABLE);
        db.execSQL(SmartKidContract.XmppContacts.CREATE_TABLE);
        db.execSQL(SmartKidContract.BabyaGrowthRecord.CREATE_TABLE);
        db.execSQL(SmartKidContract.AttentionPlate.CREATE_TABLE);
        db.execSQL(SmartKidContract.UserAttention.CREATE_TABLE);
        db.execSQL(SmartKidContract.HomeSameCityPost.CREATE_TABLE);
        db.execSQL(SmartKidContract.HomeSameCityList.CREATE_TABLE);
        db.execSQL(SmartKidContract.HomeSameCityListDetail.CREATE_TABLE);
        db.execSQL(SmartKidContract.HomeSameCityListReplays.CREATE_TABLE);
        db.execSQL(SmartKidContract.ExpertFindByTypeUser.CREATE_TABLE);
        db.execSQL(SmartKidContract.Message.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SmartKidContract.UserAccount.DELETE_TABLE);
        db.execSQL(SmartKidContract.UserBasic.DELETE_TABLE);
        db.execSQL(SmartKidContract.HomeSameAge.DELETE_TABLE);
        db.execSQL(SmartKidContract.HomeSameAgeList.DELETE_TABLE);
        db.execSQL(SmartKidContract.HomeSameAgeListDetail.DELETE_TABLE);
        db.execSQL(SmartKidContract.HomeSameAgeListReplays.DELETE_TABLE);
        db.execSQL(SmartKidContract.PostModelWonderful.DELETE_TABLE);
        db.execSQL(SmartKidContract.PostModelWonderfulList.DELETE_TABLE);
        db.execSQL(SmartKidContract.PostModelWonderfulListDetail.DELETE_TABLE);
        db.execSQL(SmartKidContract.PostModelWonderfulListReplays.DELETE_TABLE);
        db.execSQL(SmartKidContract.CaseList.DELETE_TABLE);
        db.execSQL(SmartKidContract.CaseDetailList.DELETE_TABLE);
        db.execSQL(SmartKidContract.CaseDetail.DELETE_TABLE);
        db.execSQL(SmartKidContract.CaseReplays.DELETE_TABLE);
        db.execSQL(SmartKidContract.SearchCase.DELETE_TABLE);
        db.execSQL(SmartKidContract.SearchPost.DELETE_TABLE);
        db.execSQL(SmartKidContract.SearchUser.DELETE_TABLE);
        db.execSQL(SmartKidContract.GrowthRecord.DELETE_TABLE);
        db.execSQL(SmartKidContract.MasterFindType.DELETE_TABLE);
        db.execSQL(SmartKidContract.MasterFindByTypeUser.DELETE_TABLE);
        db.execSQL(SmartKidContract.MasterFindAttentionUser.DELETE_TABLE);
        db.execSQL(SmartKidContract.BabyFindByBaby.DELETE_TABLE);
        db.execSQL(SmartKidContract.BabyDaily.DELETE_TABLE);
        db.execSQL(SmartKidContract.HomeImgList.DELETE_TABLE);
        db.execSQL(SmartKidContract.EredarList.DELETE_TABLE);
        db.execSQL(SmartKidContract.PlateList.DELETE_TABLE);
        db.execSQL(SmartKidContract.ExpertList.DELETE_TABLE);
        db.execSQL(SmartKidContract.ServeList.DELETE_TABLE);
        db.execSQL(SmartKidContract.XmppContacts.DELETE_TABLE);
        db.execSQL(SmartKidContract.BabyaGrowthRecord.DELETE_TABLE);
        db.execSQL(SmartKidContract.AttentionPlate.DELETE_TABLE);
        db.execSQL(SmartKidContract.UserAttention.DELETE_TABLE);
        db.execSQL(SmartKidContract.HomeSameCityPost.DELETE_TABLE);
        db.execSQL(SmartKidContract.HomeSameCityList.DELETE_TABLE);
        db.execSQL(SmartKidContract.HomeSameCityListDetail.DELETE_TABLE);
        db.execSQL(SmartKidContract.HomeSameCityListReplays.DELETE_TABLE);
        db.execSQL(SmartKidContract.ExpertFindByTypeUser.DELETE_TABLE);
        db.execSQL(SmartKidContract.Message.DELETE_TABLE);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        onUpgrade(db, oldVersion, newVersion);
    }
}
