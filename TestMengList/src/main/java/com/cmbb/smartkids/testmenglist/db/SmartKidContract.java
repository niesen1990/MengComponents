package com.cmbb.smartkids.testmenglist.db;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by N.Sun
 */
public final class SmartKidContract {

    private SmartKidContract() {

    }

    private static final String TEXT_TYPE = " TEXT,";
    private static final String INT_TYPE = " INTEGER,";
    public static final String DATABASE_NAME = " SmartKids.db";

    public final static class UserAccount implements BaseColumns {

        private UserAccount() {

        }

        // scheme
        public static final String SCHEME = "content";

        // Authority
        public static final String AUTHORITY = "com.cmbb.smartkids.useraccount";

        // content uri
        public static final Uri CONTENT_URI = Uri.parse(SCHEME + "://" + AUTHORITY);

        // multiple rows
        public static final String MIME_TYPE_ROWS = "vnd.android.cursor.dir/vnd.com.cmbb.smartkids.useraccount";

        // single row
        public static final String MIME_TYPE_SINGLE_ROWS = "vnd.android.cursor.item/vnd.com.cmbb.smartkids.useraccount";

        // primary key column name
        public static final String ROW_ID = BaseColumns._ID;

        // table name
        public static final String TABLE_NAME = "UserAccount";

        // table content URI
        public static final Uri TABLE_CONTENT_URI = Uri.withAppendedPath(CONTENT_URI, TABLE_NAME);

        //Columns
        public static final String COLUMN_USERNAME = "username";
        public static final String COLUMN_PHONE = "phone";
        public static final String COLUMN_TOKEN = "token";
        public static final String COLUMN_AVATARURL = "avatarUrl";
        public static final String COLUMN_ID = "id";

        // create table

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + ROW_ID +
                " INTEGER PRIMARY KEY," + COLUMN_USERNAME + TEXT_TYPE + COLUMN_PHONE + TEXT_TYPE
                + COLUMN_TOKEN + TEXT_TYPE
                + COLUMN_AVATARURL + TEXT_TYPE + COLUMN_ID + " INTEGER" + ");";

        // delete table
        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    }

    public final static class CaseList implements BaseColumns {

        private CaseList() {

        }

        // scheme
        public static final String SCHEME = "content";

        // Authority
        public static final String AUTHORITY = "com.cmbb.smartkids.caselist";

        // content uri
        public static final Uri CONTENT_URI = Uri.parse(SCHEME + "://" + AUTHORITY);

        // multiple rows
        public static final String MIME_TYPE_ROWS = "vnd.android.cursor.dir/vnd.com.cmbb" +
                ".smartkids.caselist";

        // single row
        public static final String MIME_TYPE_SINGLE_ROWS = "vnd.android.cursor.item/vnd.com.cmbb" +
                ".smartkids.caselist";

        // primary key column name
        public static final String ROW_ID = BaseColumns._ID;

        // table name
        public static final String TABLE_NAME = "CaseList";

        // table content URI
        public static final Uri TABLE_CONTENT_URI = Uri.withAppendedPath(CONTENT_URI, TABLE_NAME);

        //Columns
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_CONTEXT = "context";
        public static final String COLUMN_TYPE = "type";
        public static final String COLUMN_STATUS = "status";
        public static final String COLUMN_BACKGROUND_FLAG = "background_flag";

        // create table
        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + ROW_ID +
                " INTEGER PRIMARY KEY," + COLUMN_NAME + TEXT_TYPE + COLUMN_CONTEXT + TEXT_TYPE + COLUMN_TYPE + INT_TYPE + COLUMN_BACKGROUND_FLAG + INT_TYPE
                + COLUMN_STATUS + " INTEGER" + ");";

        // delete table
        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    }

    public final static class CaseDetailList implements BaseColumns {

        private CaseDetailList() {

        }

        // scheme
        public static final String SCHEME = "content";

        // Authority
        public static final String AUTHORITY = "com.cmbb.smartkids.casedetaillist";

        // content uri
        public static final Uri CONTENT_URI = Uri.parse(SCHEME + "://" + AUTHORITY);

        // multiple rows
        public static final String MIME_TYPE_ROWS = "vnd.android.cursor.dir/vnd.com.cmbb" +
                ".smartkids.casedetaillist";

        // single row
        public static final String MIME_TYPE_SINGLE_ROWS = "vnd.android.cursor.item/vnd.com.cmbb" +
                ".smartkids.casedetaillist";

        // primary key column name
        public static final String ROW_ID = BaseColumns._ID;

        // table name
        public static final String TABLE_NAME = "CaseDetailList";

        // table content URI
        public static final Uri TABLE_CONTENT_URI = Uri.withAppendedPath(CONTENT_URI, TABLE_NAME);

        //Columns
        public static final String COLUMN_ATTENT = "attent";
        public static final String COLUMN_AUTHORITY = "authority";
        public static final String COLUMN_BIGIMG = "bigImg";
        public static final String COLUMN_BIGIMGHEIGHT = "bigImgHeight";
        public static final String COLUMN_BIGIMGWIDTH = "bigImgWidth";
        public static final String COLUMN_CONTEXT = "context";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_NIKE = "nike";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_REPLYS = "replys";
        public static final String COLUMN_SMALLIMG = "smallImg";
        public static final String COLUMN_SMALLIMGHEIGHT = "smallImgHeight";
        public static final String COLUMN_SMALLIMGWIDTH = "smallImgWidth";
        public static final String COLUMN_STORE = "store";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_TYPE = "type";
        public static final String COLUMN_USERBIGHEADIMG = "userBigHeadImg";
        public static final String COLUMN_USERID = "userId";
        public static final String COLUMN_USERSMALLHEADIMG = "userSmallHeadImg";
        public static final String COLUMN_USERSTATUS = "userStatus";

        // create table

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + ROW_ID +
                " INTEGER PRIMARY KEY," +
                COLUMN_ATTENT + INT_TYPE + COLUMN_BIGIMG + TEXT_TYPE + COLUMN_CONTEXT + TEXT_TYPE
                + COLUMN_BIGIMGHEIGHT + INT_TYPE + COLUMN_BIGIMGWIDTH + INT_TYPE + COLUMN_NAME + TEXT_TYPE + COLUMN_DATE + TEXT_TYPE + COLUMN_ID + INT_TYPE + COLUMN_AUTHORITY
                + INT_TYPE + COLUMN_QUESTION + TEXT_TYPE + COLUMN_NIKE + TEXT_TYPE +
                COLUMN_REPLYS + INT_TYPE + COLUMN_SMALLIMG + TEXT_TYPE + COLUMN_SMALLIMGHEIGHT + INT_TYPE +
                COLUMN_SMALLIMGWIDTH + INT_TYPE + COLUMN_STORE + INT_TYPE
                + COLUMN_USERBIGHEADIMG + TEXT_TYPE +
                COLUMN_TITLE + TEXT_TYPE + COLUMN_TYPE + TEXT_TYPE + COLUMN_USERID + INT_TYPE + COLUMN_USERSMALLHEADIMG + TEXT_TYPE + COLUMN_USERSTATUS
                + " TEXT"
                + ");";

        // delete table
        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public final static class CaseDetail implements BaseColumns {

        private CaseDetail() {

        }

        // scheme
        public static final String SCHEME = "content";

        // Authority
        public static final String AUTHORITY = "com.cmbb.smartkids.casedetail";

        // content uri
        public static final Uri CONTENT_URI = Uri.parse(SCHEME + "://" + AUTHORITY);

        // multiple rows
        public static final String MIME_TYPE_ROWS = "vnd.android.cursor.dir/vnd.com.cmbb" +
                ".smartkids.casedetail";

        // single row
        public static final String MIME_TYPE_SINGLE_ROWS = "vnd.android.cursor.item/vnd.com.cmbb" +
                ".smartkids.casedetail";

        // primary key column name
        public static final String ROW_ID = BaseColumns._ID;

        // table name
        public static final String TABLE_NAME = "CaseDetail";

        // table content URI
        public static final Uri TABLE_CONTENT_URI = Uri.withAppendedPath(CONTENT_URI, TABLE_NAME);

        //Columns
        public static final String COLUMN_ATTENT = "attent";
        public static final String COLUMN_AUTHORITY = "authority";
        public static final String COLUMN_BIGIMG = "bigImg";
        public static final String COLUMN_BIGIMGHEIGHT = "bigImgHeight";
        public static final String COLUMN_BIGIMGWIDTH = "bigImgWidth";
        public static final String COLUMN_CONTEXT = "context";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_NIKE = "nike";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_REPLYS = "replys";
        public static final String COLUMN_SMALLIMG = "smallImg";
        public static final String COLUMN_SMALLIMGHEIGHT = "smallImgHeight";
        public static final String COLUMN_SMALLIMGWIDTH = "smallImgWidth";
        public static final String COLUMN_STORE = "store";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_TYPE = "type";
        public static final String COLUMN_USERBIGHEADIMG = "userBigHeadImg";
        public static final String COLUMN_USERID = "userId";
        public static final String COLUMN_USERSMALLHEADIMG = "userSmallHeadImg";
        public static final String COLUMN_USERSTATUS = "userStatus";

        // create table

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + ROW_ID +
                " INTEGER PRIMARY KEY," +
                COLUMN_ATTENT + INT_TYPE + COLUMN_BIGIMG + TEXT_TYPE + COLUMN_CONTEXT + TEXT_TYPE
                + COLUMN_BIGIMGHEIGHT + INT_TYPE + COLUMN_BIGIMGWIDTH + INT_TYPE + COLUMN_NAME + TEXT_TYPE + COLUMN_DATE + TEXT_TYPE + COLUMN_ID + INT_TYPE + COLUMN_AUTHORITY
                + INT_TYPE + COLUMN_QUESTION + TEXT_TYPE + COLUMN_NIKE + TEXT_TYPE +
                COLUMN_REPLYS + INT_TYPE + COLUMN_SMALLIMG + TEXT_TYPE + COLUMN_SMALLIMGHEIGHT + INT_TYPE +
                COLUMN_SMALLIMGWIDTH + INT_TYPE + COLUMN_STORE + INT_TYPE
                + COLUMN_USERBIGHEADIMG + TEXT_TYPE +
                COLUMN_TITLE + TEXT_TYPE + COLUMN_TYPE + TEXT_TYPE + COLUMN_USERID + INT_TYPE + COLUMN_USERSMALLHEADIMG + TEXT_TYPE + COLUMN_USERSTATUS
                + " TEXT"
                + ");";

        // delete table
        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public final static class CaseReplays implements BaseColumns {

        private CaseReplays() {

        }

        // scheme
        public static final String SCHEME = "content";

        // Authority
        public static final String AUTHORITY = "com.cmbb.smartkids.casereplays";

        // content uri
        public static final Uri CONTENT_URI = Uri.parse(SCHEME + "://" + AUTHORITY);

        // multiple rowsr
        public static final String MIME_TYPE_ROWS = "vnd.android.cursor.dir/vnd.com.cmbb" +
                ".smartkids.casereplays";

        // single row
        public static final String MIME_TYPE_SINGLE_ROWS = "vnd.android.cursor.item/vnd.com.cmbb" +
                ".smartkids.casereplays";

        // primary key column name
        public static final String ROW_ID = BaseColumns._ID;

        // table name
        public static final String TABLE_NAME = "CaseReplays";

        // table content URI
        public static final Uri TABLE_CONTENT_URI = Uri.withAppendedPath(CONTENT_URI, TABLE_NAME);

        //Columns
        public static final String COLUMN_AUTHORITY = "authority";
        public static final String COLUMN_BIGIMG = "bigImg";
        public static final String COLUMN_BIGIMGHEIGHT = "bigImgHeight";
        public static final String COLUMN_BIGIMGWIDTH = "bigImgWidth";
        public static final String COLUMN_CONTEXT = "context";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_DELETETAG = "deleteTag";
        public static final String COLUMN_EREDAR = "eredar";
        public static final String COLUMN_EREDARNAME = "eredarName";
        public static final String COLUMN_EREDARRANK = "eredarRank";
        public static final String COLUMN_EREDARTYPE = "eredarType";
        public static final String COLUMN_FLOOR = "floor";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_ISCURRENTUSER = "isCurrentUser";
        public static final String COLUMN_NIKE = "nike";
        public static final String COLUMN_OTHERCONTEXT = "otherContext";
        public static final String COLUMN_OTHERDELETETAG = "otherDeleteTag";
        public static final String COLUMN_OTHERFLOOR = "otherFloor";
        public static final String COLUMN_OTHERNIKE = "otherNike";
        public static final String COLUMN_OTHERUSERID = "otherUserId";
        public static final String COLUMN_OTHERUSERSMALLHEADIMG = "otherUserSmallHeadImg";
        public static final String COLUMN_OTHERUSERSMALLIMGHEIGHT = "otherUserSmallImgHeight";
        public static final String COLUMN_OTHERUSERSMALLIMGWIDTH = "otherUserSmallImgWidth";
        public static final String COLUMN_REPLYS = "replys";
        public static final String COLUMN_REPLYSPARENTID = "replysParentId";
        public static final String COLUMN_SMALLIMG = "smallImg";
        public static final String COLUMN_SMALLIMGHEIGHT = "smallImgHeight";
        public static final String COLUMN_SMALLIMGWIDTH = "smallImgWidth";
        public static final String COLUMN_USERID = "userId";
        public static final String COLUMN_USERSMALLHEADIMG = "userSmallHeadImg";
        public static final String COLUMN_USERSMALLIMGHEIGHT = "userSmallImgHeight";
        public static final String COLUMN_USERSMALLIMGWIDTH = "usersmallimgwidth";
        public static final String COLUMN_WEIXINIMG = "weixinImg";
        public static final String COLUMN_TAG = "tag";

        // create table

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + ROW_ID +
                " INTEGER PRIMARY KEY," + COLUMN_BIGIMGWIDTH + INT_TYPE + COLUMN_EREDAR + INT_TYPE + COLUMN_EREDARNAME + TEXT_TYPE + COLUMN_EREDARRANK + INT_TYPE + COLUMN_EREDARTYPE + INT_TYPE +
                COLUMN_BIGIMGHEIGHT + INT_TYPE + COLUMN_BIGIMG + TEXT_TYPE + COLUMN_CONTEXT + TEXT_TYPE
                + COLUMN_FLOOR + INT_TYPE + COLUMN_ISCURRENTUSER + INT_TYPE + COLUMN_DELETETAG + INT_TYPE +
                COLUMN_OTHERDELETETAG + INT_TYPE + COLUMN_DATE + TEXT_TYPE + COLUMN_ID + INT_TYPE + COLUMN_AUTHORITY
                + INT_TYPE + COLUMN_OTHERCONTEXT + TEXT_TYPE + COLUMN_OTHERNIKE + TEXT_TYPE +
                COLUMN_OTHERFLOOR + INT_TYPE + COLUMN_NIKE + TEXT_TYPE + COLUMN_OTHERUSERID + INT_TYPE +
                COLUMN_OTHERUSERSMALLHEADIMG + TEXT_TYPE + COLUMN_SMALLIMG + TEXT_TYPE + COLUMN_SMALLIMGHEIGHT + INT_TYPE +
                COLUMN_SMALLIMGWIDTH + INT_TYPE + COLUMN_OTHERUSERSMALLIMGHEIGHT + INT_TYPE + COLUMN_OTHERUSERSMALLIMGWIDTH + INT_TYPE
                + COLUMN_WEIXINIMG + TEXT_TYPE + COLUMN_TAG + INT_TYPE +
                COLUMN_REPLYS + INT_TYPE + COLUMN_REPLYSPARENTID + INT_TYPE + COLUMN_USERSMALLIMGHEIGHT + INT_TYPE + COLUMN_USERSMALLIMGWIDTH + INT_TYPE + COLUMN_USERID + INT_TYPE + COLUMN_USERSMALLHEADIMG
                + " TEXT"
                + ");";

        // delete table
        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    }

    // 同城
    public final static class HomeSameCity implements BaseColumns {

        private HomeSameCity() {

        }

        // scheme
        public static final String SCHEME = "content";

        // Authority
        public static final String AUTHORITY = "com.cmbb.smartkids.homesamecity";

        // content uri
        public static final Uri CONTENT_URI = Uri.parse(SCHEME + "://" + AUTHORITY);

        // multiple rows
        public static final String MIME_TYPE_ROWS = "vnd.android.cursor.dir/vnd.com.cmbb" +
                ".smartkids.homesamecity";

        // single row
        public static final String MIME_TYPE_SINGLE_ROWS = "vnd.android.cursor.item/vnd.com.cmbb" +
                ".smartkids.homesamecity";

        // primary key column name
        public static final String ROW_ID = BaseColumns._ID;

        // table name
        public static final String TABLE_NAME = "HomeSameCity";

        // table content URI
        public static final Uri TABLE_CONTENT_URI = Uri.withAppendedPath(CONTENT_URI, TABLE_NAME);

        //Columns
        public static final String COLUMN_USERNAME = "username";
        public static final String COLUMN_PHONE = "phone";
        public static final String COLUMN_TOKEN = "token";
        public static final String COLUMN_AVATARURL = "avatarUrl";
        public static final String COLUMN_ID = "id";

        // create table

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + ROW_ID +
                " INTEGER PRIMARY KEY," + COLUMN_USERNAME + TEXT_TYPE + COLUMN_PHONE + TEXT_TYPE
                + COLUMN_TOKEN + TEXT_TYPE
                + COLUMN_AVATARURL + TEXT_TYPE + COLUMN_ID + " INTEGER" + ");";

        // delete table
        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    }

    //同龄
    public final static class HomeSameAge implements BaseColumns {

        private HomeSameAge() {

        }

        // scheme
        public static final String SCHEME = "content";

        // Authority
        public static final String AUTHORITY = "com.cmbb.smartkids.homesameage";

        // content uri
        public static final Uri CONTENT_URI = Uri.parse(SCHEME + "://" + AUTHORITY);

        // multiple rows
        public static final String MIME_TYPE_ROWS = "vnd.android.cursor.dir/vnd.com.cmbb" +
                ".smartkids.homesameage";

        // single row
        public static final String MIME_TYPE_SINGLE_ROWS = "vnd.android.cursor.item/vnd.com.cmbb" +
                ".smartkids.homesameage";

        // primary key column name
        public static final String ROW_ID = BaseColumns._ID;

        // table name
        public static final String TABLE_NAME = "HomeSameAge";

        // table content URI
        public static final Uri TABLE_CONTENT_URI = Uri.withAppendedPath(CONTENT_URI, TABLE_NAME);

        //Columns
        public static final String COLUMN_BIGIMG = "bigImg";
        public static final String COLUMN_BIGIMGHEIGHT = "bigImgHeight";
        public static final String COLUMN_BIGIMGWIDTH = "bigImgWidth";
        public static final String COLUMN_CONNECTOR = "connector";
        public static final String COLUMN_CONTEXT = "context";
        public static final String COLUMN_COUNT = "count";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_SMALLIMG = "smallImg";
        public static final String COLUMN_SMALLIMGHEIGHT = "smallImgHeight";
        public static final String COLUMN_SMALLIMGWIDTH = "smallImgWidth";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_TYPE = "type";
        public static final String COLUMN_ATTENTION_FLAG = "attention_flag";

        // create table

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + ROW_ID +
                " INTEGER PRIMARY KEY," + COLUMN_BIGIMG + TEXT_TYPE + COLUMN_BIGIMGHEIGHT + INT_TYPE
                + COLUMN_BIGIMGWIDTH + INT_TYPE
                + COLUMN_CONNECTOR + TEXT_TYPE + COLUMN_ATTENTION_FLAG + INT_TYPE +
                COLUMN_CONTEXT + TEXT_TYPE + COLUMN_COUNT + INT_TYPE + COLUMN_ID
                + INT_TYPE + COLUMN_SMALLIMG + TEXT_TYPE + COLUMN_SMALLIMGHEIGHT + INT_TYPE
                + COLUMN_SMALLIMGWIDTH + INT_TYPE + COLUMN_TITLE + TEXT_TYPE + COLUMN_TYPE
                + " TEXT"
                + ");";

        // delete table
        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    }

    //同龄
    public final static class HomeSameAgeList implements BaseColumns {

        private HomeSameAgeList() {

        }

        // scheme
        public static final String SCHEME = "content";

        // Authority
        public static final String AUTHORITY = "com.cmbb.smartkids.homesameagelist";

        // content uri
        public static final Uri CONTENT_URI = Uri.parse(SCHEME + "://" + AUTHORITY);

        // multiple rows
        public static final String MIME_TYPE_ROWS = "vnd.android.cursor.dir/vnd.com.cmbb" +
                ".smartkids.homesameagelist";

        // single row
        public static final String MIME_TYPE_SINGLE_ROWS = "vnd.android.cursor.item/vnd.com.cmbb" +
                ".smartkids.homesameagelist";

        // primary key column name
        public static final String ROW_ID = BaseColumns._ID;

        // table name
        public static final String TABLE_NAME = "HomeSameAgeList";

        // table content URI
        public static final Uri TABLE_CONTENT_URI = Uri.withAppendedPath(CONTENT_URI, TABLE_NAME);

        //Columns
        public static final String COLUMN_ATTENT = "attent";
        public static final String COLUMN_AUTHORITY = "authority";
        public static final String COLUMN_AREAID = "areaId";
        public static final String COLUMN_AREANAME = "areaName";
        public static final String COLUMN_AREATYPE = "areaType";
        public static final String COLUMN_BIGIMG = "bigImg";
        public static final String COLUMN_CONTEXT = "context";
        public static final String COLUMN_CREAM = "cream";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_EREDAR = "eredar";
        public static final String COLUMN_EREDARNAME = "eredarName";
        public static final String COLUMN_EREDARRANK = "eredarRank";
        public static final String COLUMN_EREDARTYPE = "eredarType";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_LOGINTIMES = "loginTimes";
        public static final String COLUMN_NIKE = "nike";
        public static final String COLUMN_PLATENAME = "plateName";
        public static final String COLUMN_RELPYS = "relpys";
        public static final String COLUMN_SMALLIMG = "smallImg";
        public static final String COLUMN_PORTCONNECTOR = "portConnector";
        public static final String COLUMN_SMALLIMGHEIGHT = "smallImgHeight";
        public static final String COLUMN_SMALLIMGWIDTH = "smallImgWidth";
        public static final String COLUMN_STICK = "stick";
        public static final String COLUMN_STORE = "store";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_TYPE = "type";
        public static final String COLUMN_USERID = "userId";
        public static final String COLUMN_USERSMALLHEADIMG = "userSmallHeadImg";
        public static final String COLUMN_VALIDCURRENTUSER = "validCurrentUser";
        public static final String COLUMN_WEIXINIMG = "weixinImg";
        // 用户中心数据标识
        public static final String COLUMN_USERCENTER_FLAG = "usercenter_flag";
        // 帖子标识
        public static final String COLUMN_POSTMODEL_FLAG = "postmodel_flag";

        // create table

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + ROW_ID + " INTEGER PRIMARY KEY," +
                COLUMN_ATTENT + INT_TYPE + COLUMN_BIGIMG + TEXT_TYPE + COLUMN_CONTEXT + TEXT_TYPE + COLUMN_EREDAR + INT_TYPE + COLUMN_EREDARNAME + TEXT_TYPE + COLUMN_EREDARRANK + INT_TYPE
                + COLUMN_EREDARTYPE + INT_TYPE
                + COLUMN_AREANAME + TEXT_TYPE + COLUMN_AREATYPE + TEXT_TYPE + COLUMN_AREAID + INT_TYPE +
                COLUMN_CREAM + INT_TYPE + COLUMN_DATE + TEXT_TYPE + COLUMN_ID + INT_TYPE + COLUMN_AUTHORITY
                + INT_TYPE + COLUMN_PORTCONNECTOR + TEXT_TYPE + COLUMN_VALIDCURRENTUSER + TEXT_TYPE +
                COLUMN_LOGINTIMES + INT_TYPE + COLUMN_NIKE + TEXT_TYPE + COLUMN_PLATENAME + TEXT_TYPE +
                COLUMN_RELPYS + INT_TYPE + COLUMN_SMALLIMG + TEXT_TYPE + COLUMN_SMALLIMGHEIGHT + INT_TYPE +
                COLUMN_SMALLIMGWIDTH + INT_TYPE + COLUMN_STICK + INT_TYPE + COLUMN_STORE + INT_TYPE
                + COLUMN_WEIXINIMG + TEXT_TYPE + COLUMN_POSTMODEL_FLAG + INT_TYPE +
                COLUMN_TITLE + TEXT_TYPE + COLUMN_TYPE + TEXT_TYPE + COLUMN_USERID + INT_TYPE + COLUMN_USERSMALLHEADIMG + TEXT_TYPE + COLUMN_USERCENTER_FLAG
                + " INTEGER" + ");";

        // delete table
        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    }

    public final static class HomeSameAgeListDetail implements BaseColumns {

        private HomeSameAgeListDetail() {

        }

        // scheme
        public static final String SCHEME = "content";

        // Authority
        public static final String AUTHORITY = "com.cmbb.smartkids.homesameagelistdetail";

        // content uri
        public static final Uri CONTENT_URI = Uri.parse(SCHEME + "://" + AUTHORITY);

        // multiple rows
        public static final String MIME_TYPE_ROWS = "vnd.android.cursor.dir/vnd.com.cmbb" +
                ".smartkids.homesameagelistdetail";

        // single row
        public static final String MIME_TYPE_SINGLE_ROWS = "vnd.android.cursor.item/vnd.com.cmbb" +
                ".smartkids.homesameagelistdetail";

        // primary key column name
        public static final String ROW_ID = BaseColumns._ID;

        // table name
        public static final String TABLE_NAME = "HomeSameAgeListDetail";

        // table content URI
        public static final Uri TABLE_CONTENT_URI = Uri.withAppendedPath(CONTENT_URI, TABLE_NAME);

        //Columns
        public static final String COLUMN_ATTENT = "attent";
        public static final String COLUMN_AUTHORITY = "authority";
        public static final String COLUMN_AREAID = "areaId";
        public static final String COLUMN_AREANAME = "areaName";
        public static final String COLUMN_AREATYPE = "areaType";
        public static final String COLUMN_BIGIMG = "bigImg";
        public static final String COLUMN_CONTEXT = "context";
        public static final String COLUMN_CREAM = "cream";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_LOGINTIMES = "loginTimes";
        public static final String COLUMN_NIKE = "nike";
        public static final String COLUMN_PLATENAME = "plateName";
        public static final String COLUMN_RELPYS = "relpys";
        public static final String COLUMN_SMALLIMG = "smallImg";
        public static final String COLUMN_PORTCONNECTOR = "portConnector";
        public static final String COLUMN_SMALLIMGHEIGHT = "smallImgHeight";
        public static final String COLUMN_SMALLIMGWIDTH = "smallImgWidth";
        public static final String COLUMN_STICK = "stick";
        public static final String COLUMN_STORE = "store";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_TYPE = "type";
        public static final String COLUMN_USERID = "userId";
        public static final String COLUMN_USERSMALLHEADIMG = "userSmallHeadImg";
        public static final String COLUMN_VALIDCURRENTUSER = "validCurrentUser";
        public static final String COLUMN_WEIXINIMG = "weixinImg";

        // 添加点赞字段
        public static final String COLUMN_CURRENTUSERSPOT = "currentUserSpot";
        public static final String COLUMN_SPOTCOUNT = "spotCount";

        // create table

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + ROW_ID +
                " INTEGER PRIMARY KEY," +
                COLUMN_ATTENT + INT_TYPE + COLUMN_BIGIMG + TEXT_TYPE + COLUMN_CONTEXT + TEXT_TYPE
                + COLUMN_AREANAME + TEXT_TYPE + COLUMN_AREATYPE + TEXT_TYPE + COLUMN_AREAID + INT_TYPE +
                COLUMN_CREAM + INT_TYPE + COLUMN_DATE + TEXT_TYPE + COLUMN_ID + INT_TYPE + COLUMN_AUTHORITY
                + INT_TYPE + COLUMN_PORTCONNECTOR + TEXT_TYPE + COLUMN_VALIDCURRENTUSER + TEXT_TYPE +
                COLUMN_LOGINTIMES + INT_TYPE + COLUMN_NIKE + TEXT_TYPE + COLUMN_PLATENAME + TEXT_TYPE +
                COLUMN_RELPYS + INT_TYPE + COLUMN_SMALLIMG + TEXT_TYPE + COLUMN_SMALLIMGHEIGHT + INT_TYPE +
                COLUMN_SMALLIMGWIDTH + INT_TYPE + COLUMN_STICK + INT_TYPE + COLUMN_STORE + INT_TYPE
                + COLUMN_WEIXINIMG + TEXT_TYPE +
                COLUMN_TITLE + TEXT_TYPE + COLUMN_TYPE + TEXT_TYPE +
                COLUMN_USERID + INT_TYPE +
                COLUMN_CURRENTUSERSPOT + INT_TYPE +
                COLUMN_SPOTCOUNT + INT_TYPE +
                COLUMN_USERSMALLHEADIMG
                + " TEXT"
                + ");";

        // delete table
        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    }

    public final static class HomeSameAgeListReplays implements BaseColumns {

        private HomeSameAgeListReplays() {

        }

        // scheme
        public static final String SCHEME = "content";

        // Authority
        public static final String AUTHORITY = "com.cmbb.smartkids.homesameagelistreplays";

        // content uri
        public static final Uri CONTENT_URI = Uri.parse(SCHEME + "://" + AUTHORITY);

        // multiple rowsr
        public static final String MIME_TYPE_ROWS = "vnd.android.cursor.dir/vnd.com.cmbb" +
                ".smartkids.homesameagelistreplays";

        // single row
        public static final String MIME_TYPE_SINGLE_ROWS = "vnd.android.cursor.item/vnd.com.cmbb" +
                ".smartkids.homesameagelistreplays";

        // primary key column name
        public static final String ROW_ID = BaseColumns._ID;

        // table name
        public static final String TABLE_NAME = "HomeSameAgeListReplays";

        // table content URI
        public static final Uri TABLE_CONTENT_URI = Uri.withAppendedPath(CONTENT_URI, TABLE_NAME);

        //Columns
        public static final String COLUMN_AUTHORITY = "authority";
        public static final String COLUMN_BIGIMG = "bigImg";
        public static final String COLUMN_BIGIMGHEIGHT = "bigImgHeight";
        public static final String COLUMN_CONTEXT = "context";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_DELETETAG = "deleteTag";
        public static final String COLUMN_FLOOR = "floor";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_TAG = "tag";
        public static final String COLUMN_ISCURRENTUSER = "isCurrentUser";
        public static final String COLUMN_NIKE = "nike";
        public static final String COLUMN_OTHERCONTEXT = "otherContext";
        public static final String COLUMN_OTHERDELETETAG = "otherDeleteTag";
        public static final String COLUMN_OTHERFLOOR = "otherFloor";
        public static final String COLUMN_OTHERNIKE = "otherNike";
        public static final String COLUMN_OTHERUSERID = "otherUserId";
        public static final String COLUMN_OTHERUSERSMALLHEADIMG = "otherUserSmallHeadImg";
        public static final String COLUMN_OTHERUSERSMALLIMGHEIGHT = "otherUserSmallImgHeight";
        public static final String COLUMN_OTHERUSERSMALLIMGWIDTH = "otherUserSmallImgWidth";
        public static final String COLUMN_REPLYS = "replys";
        public static final String COLUMN_REPLYSPARENTID = "replysParentId";
        public static final String COLUMN_SMALLIMG = "smallImg";
        public static final String COLUMN_SMALLIMGHEIGHT = "smallImgHeight";
        public static final String COLUMN_SMALLIMGWIDTH = "smallImgWidth";
        public static final String COLUMN_USERID = "userId";
        public static final String COLUMN_USERSMALLHEADIMG = "userSmallHeadImg";
        public static final String COLUMN_USERSMALLIMGHEIGHT = "userSmallImgHeight";
        public static final String COLUMN_USERSMALLIMGWIDTH = "usersmallimgwidth";
        public static final String COLUMN_WEIXINIMG = "weixinImg";

        // create table

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + ROW_ID +
                " INTEGER PRIMARY KEY," + COLUMN_TAG + TEXT_TYPE +
                COLUMN_BIGIMGHEIGHT + INT_TYPE + COLUMN_BIGIMG + TEXT_TYPE + COLUMN_CONTEXT + TEXT_TYPE
                + COLUMN_FLOOR + INT_TYPE + COLUMN_ISCURRENTUSER + INT_TYPE + COLUMN_DELETETAG + INT_TYPE +
                COLUMN_OTHERDELETETAG + INT_TYPE + COLUMN_DATE + TEXT_TYPE + COLUMN_ID + INT_TYPE + COLUMN_AUTHORITY
                + INT_TYPE + COLUMN_OTHERCONTEXT + TEXT_TYPE + COLUMN_OTHERNIKE + TEXT_TYPE +
                COLUMN_OTHERFLOOR + INT_TYPE + COLUMN_NIKE + TEXT_TYPE + COLUMN_OTHERUSERID + INT_TYPE +
                COLUMN_OTHERUSERSMALLHEADIMG + TEXT_TYPE + COLUMN_SMALLIMG + TEXT_TYPE + COLUMN_SMALLIMGHEIGHT + INT_TYPE +
                COLUMN_SMALLIMGWIDTH + INT_TYPE + COLUMN_OTHERUSERSMALLIMGHEIGHT + INT_TYPE + COLUMN_OTHERUSERSMALLIMGWIDTH + INT_TYPE
                + COLUMN_WEIXINIMG + TEXT_TYPE +
                COLUMN_REPLYS + INT_TYPE + COLUMN_REPLYSPARENTID + INT_TYPE + COLUMN_USERSMALLIMGHEIGHT + INT_TYPE + COLUMN_USERSMALLIMGWIDTH + INT_TYPE + COLUMN_USERID + INT_TYPE + COLUMN_USERSMALLHEADIMG
                + " TEXT"
                + ");";

        // delete table
        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    }

    //同龄
    public final static class HomeSameCityPost implements BaseColumns {

        private HomeSameCityPost() {

        }

        // scheme
        public static final String SCHEME = "content";

        // Authority
        public static final String AUTHORITY = "com.cmbb.smartkids.homesamecitypost";

        // content uri
        public static final Uri CONTENT_URI = Uri.parse(SCHEME + "://" + AUTHORITY);

        // multiple rows
        public static final String MIME_TYPE_ROWS = "vnd.android.cursor.dir/vnd.com.cmbb" +
                ".smartkids.homesamecitypost";

        // single row
        public static final String MIME_TYPE_SINGLE_ROWS = "vnd.android.cursor.item/vnd.com.cmbb" +
                ".smartkids.homesamecitypost";

        // primary key column name
        public static final String ROW_ID = BaseColumns._ID;

        // table name
        public static final String TABLE_NAME = "HomeSameCityPost";

        // table content URI
        public static final Uri TABLE_CONTENT_URI = Uri.withAppendedPath(CONTENT_URI, TABLE_NAME);

        //Columns
        public static final String COLUMN_BIGIMG = "bigImg";
        public static final String COLUMN_BIGIMGHEIGHT = "bigImgHeight";
        public static final String COLUMN_BIGIMGWIDTH = "bigImgWidth";
        public static final String COLUMN_CONNECTOR = "connector";
        public static final String COLUMN_CONTEXT = "context";
        public static final String COLUMN_COUNT = "count";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_SMALLIMG = "smallImg";
        public static final String COLUMN_SMALLIMGHEIGHT = "smallImgHeight";
        public static final String COLUMN_SMALLIMGWIDTH = "smallImgWidth";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_TYPE = "type";
        public static final String COLUMN_ATTENTION_FLAG = "attention_flag";

        // create table

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + ROW_ID +
                " INTEGER PRIMARY KEY," + COLUMN_BIGIMG + TEXT_TYPE + COLUMN_BIGIMGHEIGHT + INT_TYPE
                + COLUMN_BIGIMGWIDTH + INT_TYPE
                + COLUMN_CONNECTOR + TEXT_TYPE + COLUMN_ATTENTION_FLAG + INT_TYPE +
                COLUMN_CONTEXT + TEXT_TYPE + COLUMN_COUNT + INT_TYPE + COLUMN_ID
                + INT_TYPE + COLUMN_SMALLIMG + TEXT_TYPE + COLUMN_SMALLIMGHEIGHT + INT_TYPE
                + COLUMN_SMALLIMGWIDTH + INT_TYPE + COLUMN_TITLE + TEXT_TYPE + COLUMN_TYPE
                + " TEXT"
                + ");";

        // delete table
        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    }

    //同龄
    public final static class HomeSameCityList implements BaseColumns {

        private HomeSameCityList() {

        }

        // scheme
        public static final String SCHEME = "content";

        // Authority
        public static final String AUTHORITY = "com.cmbb.smartkids.homesamecitylist";

        // content uri
        public static final Uri CONTENT_URI = Uri.parse(SCHEME + "://" + AUTHORITY);

        // multiple rows
        public static final String MIME_TYPE_ROWS = "vnd.android.cursor.dir/vnd.com.cmbb" +
                ".smartkids.homesamecitylist";

        // single row
        public static final String MIME_TYPE_SINGLE_ROWS = "vnd.android.cursor.item/vnd.com.cmbb" +
                ".smartkids.homesamecitylist";

        // primary key column name
        public static final String ROW_ID = BaseColumns._ID;

        // table name
        public static final String TABLE_NAME = "HomeSameCityList";

        // table content URI
        public static final Uri TABLE_CONTENT_URI = Uri.withAppendedPath(CONTENT_URI, TABLE_NAME);

        //Columns
        public static final String COLUMN_ATTENT = "attent";
        public static final String COLUMN_AUTHORITY = "authority";
        public static final String COLUMN_AREAID = "areaId";
        public static final String COLUMN_AREANAME = "areaName";
        public static final String COLUMN_AREATYPE = "areaType";
        public static final String COLUMN_BIGIMG = "bigImg";
        public static final String COLUMN_CONTEXT = "context";
        public static final String COLUMN_CREAM = "cream";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_EREDAR = "eredar";
        public static final String COLUMN_EREDARNAME = "eredarName";
        public static final String COLUMN_EREDARRANK = "eredarRank";
        public static final String COLUMN_EREDARTYPE = "eredarType";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_LOGINTIMES = "loginTimes";
        public static final String COLUMN_NIKE = "nike";
        public static final String COLUMN_PLATENAME = "plateName";
        public static final String COLUMN_RELPYS = "relpys";
        public static final String COLUMN_SMALLIMG = "smallImg";
        public static final String COLUMN_PORTCONNECTOR = "portConnector";
        public static final String COLUMN_SMALLIMGHEIGHT = "smallImgHeight";
        public static final String COLUMN_SMALLIMGWIDTH = "smallImgWidth";
        public static final String COLUMN_STICK = "stick";
        public static final String COLUMN_STORE = "store";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_TYPE = "type";
        public static final String COLUMN_USERID = "userId";
        public static final String COLUMN_USERSMALLHEADIMG = "userSmallHeadImg";
        public static final String COLUMN_VALIDCURRENTUSER = "validCurrentUser";
        public static final String COLUMN_WEIXINIMG = "weixinImg";
        // 用户中心数据标识
        public static final String COLUMN_USERCENTER_FLAG = "usercenter_flag";
        // 帖子标识
        public static final String COLUMN_POSTMODEL_FLAG = "postmodel_flag";

        // create table

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + ROW_ID +
                " INTEGER PRIMARY KEY," +
                COLUMN_ATTENT + INT_TYPE + COLUMN_BIGIMG + TEXT_TYPE + COLUMN_CONTEXT + TEXT_TYPE + COLUMN_EREDAR + INT_TYPE + COLUMN_EREDARNAME + TEXT_TYPE + COLUMN_EREDARRANK + INT_TYPE
                + COLUMN_EREDARTYPE + INT_TYPE
                + COLUMN_AREANAME + TEXT_TYPE + COLUMN_AREATYPE + TEXT_TYPE + COLUMN_AREAID + INT_TYPE +
                COLUMN_CREAM + INT_TYPE + COLUMN_DATE + TEXT_TYPE + COLUMN_ID + INT_TYPE + COLUMN_AUTHORITY
                + INT_TYPE + COLUMN_PORTCONNECTOR + TEXT_TYPE + COLUMN_VALIDCURRENTUSER + TEXT_TYPE +
                COLUMN_LOGINTIMES + INT_TYPE + COLUMN_NIKE + TEXT_TYPE + COLUMN_PLATENAME + TEXT_TYPE +
                COLUMN_RELPYS + INT_TYPE + COLUMN_SMALLIMG + TEXT_TYPE + COLUMN_SMALLIMGHEIGHT + INT_TYPE +
                COLUMN_SMALLIMGWIDTH + INT_TYPE + COLUMN_STICK + INT_TYPE + COLUMN_STORE + INT_TYPE
                + COLUMN_WEIXINIMG + TEXT_TYPE + COLUMN_POSTMODEL_FLAG + INT_TYPE +
                COLUMN_TITLE + TEXT_TYPE + COLUMN_TYPE + TEXT_TYPE + COLUMN_USERID + INT_TYPE + COLUMN_USERSMALLHEADIMG + TEXT_TYPE + COLUMN_USERCENTER_FLAG
                + " INTEGER"
                + ");";

        // delete table
        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    }

    public final static class HomeSameCityListDetail implements BaseColumns {

        private HomeSameCityListDetail() {

        }

        // scheme
        public static final String SCHEME = "content";

        // Authority
        public static final String AUTHORITY = "com.cmbb.smartkids.homesamecitylistdetail";

        // content uri
        public static final Uri CONTENT_URI = Uri.parse(SCHEME + "://" + AUTHORITY);

        // multiple rows
        public static final String MIME_TYPE_ROWS = "vnd.android.cursor.dir/vnd.com.cmbb" +
                ".smartkids.homesamecitylistdetail";

        // single row
        public static final String MIME_TYPE_SINGLE_ROWS = "vnd.android.cursor.item/vnd.com.cmbb" +
                ".smartkids.homesamecitylistdetail";

        // primary key column name
        public static final String ROW_ID = BaseColumns._ID;

        // table name
        public static final String TABLE_NAME = "HomeSameCityListDetail";

        // table content URI
        public static final Uri TABLE_CONTENT_URI = Uri.withAppendedPath(CONTENT_URI, TABLE_NAME);

        //Columns
        public static final String COLUMN_ATTENT = "attent";
        public static final String COLUMN_AUTHORITY = "authority";
        public static final String COLUMN_AREAID = "areaId";
        public static final String COLUMN_AREANAME = "areaName";
        public static final String COLUMN_AREATYPE = "areaType";
        public static final String COLUMN_BIGIMG = "bigImg";
        public static final String COLUMN_CONTEXT = "context";
        public static final String COLUMN_CREAM = "cream";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_LOGINTIMES = "loginTimes";
        public static final String COLUMN_NIKE = "nike";
        public static final String COLUMN_PLATENAME = "plateName";
        public static final String COLUMN_RELPYS = "relpys";
        public static final String COLUMN_SMALLIMG = "smallImg";
        public static final String COLUMN_PORTCONNECTOR = "portConnector";
        public static final String COLUMN_SMALLIMGHEIGHT = "smallImgHeight";
        public static final String COLUMN_SMALLIMGWIDTH = "smallImgWidth";
        public static final String COLUMN_STICK = "stick";
        public static final String COLUMN_STORE = "store";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_TYPE = "type";
        public static final String COLUMN_USERID = "userId";
        public static final String COLUMN_USERSMALLHEADIMG = "userSmallHeadImg";
        public static final String COLUMN_VALIDCURRENTUSER = "validCurrentUser";
        public static final String COLUMN_WEIXINIMG = "weixinImg";

        // create table

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + ROW_ID +
                " INTEGER PRIMARY KEY," +
                COLUMN_ATTENT + INT_TYPE + COLUMN_BIGIMG + TEXT_TYPE + COLUMN_CONTEXT + TEXT_TYPE
                + COLUMN_AREANAME + TEXT_TYPE + COLUMN_AREATYPE + TEXT_TYPE + COLUMN_AREAID + INT_TYPE +
                COLUMN_CREAM + INT_TYPE + COLUMN_DATE + TEXT_TYPE + COLUMN_ID + INT_TYPE + COLUMN_AUTHORITY
                + INT_TYPE + COLUMN_PORTCONNECTOR + TEXT_TYPE + COLUMN_VALIDCURRENTUSER + TEXT_TYPE +
                COLUMN_LOGINTIMES + INT_TYPE + COLUMN_NIKE + TEXT_TYPE + COLUMN_PLATENAME + TEXT_TYPE +
                COLUMN_RELPYS + INT_TYPE + COLUMN_SMALLIMG + TEXT_TYPE + COLUMN_SMALLIMGHEIGHT + INT_TYPE +
                COLUMN_SMALLIMGWIDTH + INT_TYPE + COLUMN_STICK + INT_TYPE + COLUMN_STORE + INT_TYPE
                + COLUMN_WEIXINIMG + TEXT_TYPE +
                COLUMN_TITLE + TEXT_TYPE + COLUMN_TYPE + TEXT_TYPE + COLUMN_USERID + INT_TYPE + COLUMN_USERSMALLHEADIMG
                + " TEXT"
                + ");";

        // delete table
        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    }

    public final static class HomeSameCityListReplays implements BaseColumns {

        private HomeSameCityListReplays() {

        }

        // scheme
        public static final String SCHEME = "content";

        // Authority
        public static final String AUTHORITY = "com.cmbb.smartkids.homesamecitylistreplays";

        // content uri
        public static final Uri CONTENT_URI = Uri.parse(SCHEME + "://" + AUTHORITY);

        // multiple rowsr
        public static final String MIME_TYPE_ROWS = "vnd.android.cursor.dir/vnd.com.cmbb" +
                ".smartkids.homesamecitylistreplays";

        // single row
        public static final String MIME_TYPE_SINGLE_ROWS = "vnd.android.cursor.item/vnd.com.cmbb" +
                ".smartkids.homesamecitylistreplays";

        // primary key column name
        public static final String ROW_ID = BaseColumns._ID;

        // table name
        public static final String TABLE_NAME = "HomeSameCityListReplays";

        // table content URI
        public static final Uri TABLE_CONTENT_URI = Uri.withAppendedPath(CONTENT_URI, TABLE_NAME);

        //Columns
        public static final String COLUMN_AUTHORITY = "authority";
        public static final String COLUMN_BIGIMG = "bigImg";
        public static final String COLUMN_BIGIMGHEIGHT = "bigImgHeight";
        public static final String COLUMN_CONTEXT = "context";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_DELETETAG = "deleteTag";
        public static final String COLUMN_FLOOR = "floor";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_TAG = "tag";
        public static final String COLUMN_ISCURRENTUSER = "isCurrentUser";
        public static final String COLUMN_NIKE = "nike";
        public static final String COLUMN_OTHERCONTEXT = "otherContext";
        public static final String COLUMN_OTHERDELETETAG = "otherDeleteTag";
        public static final String COLUMN_OTHERFLOOR = "otherFloor";
        public static final String COLUMN_OTHERNIKE = "otherNike";
        public static final String COLUMN_OTHERUSERID = "otherUserId";
        public static final String COLUMN_OTHERUSERSMALLHEADIMG = "otherUserSmallHeadImg";
        public static final String COLUMN_OTHERUSERSMALLIMGHEIGHT = "otherUserSmallImgHeight";
        public static final String COLUMN_OTHERUSERSMALLIMGWIDTH = "otherUserSmallImgWidth";
        public static final String COLUMN_REPLYS = "replys";
        public static final String COLUMN_REPLYSPARENTID = "replysParentId";
        public static final String COLUMN_SMALLIMG = "smallImg";
        public static final String COLUMN_SMALLIMGHEIGHT = "smallImgHeight";
        public static final String COLUMN_SMALLIMGWIDTH = "smallImgWidth";
        public static final String COLUMN_USERID = "userId";
        public static final String COLUMN_USERSMALLHEADIMG = "userSmallHeadImg";
        public static final String COLUMN_USERSMALLIMGHEIGHT = "userSmallImgHeight";
        public static final String COLUMN_USERSMALLIMGWIDTH = "usersmallimgwidth";
        public static final String COLUMN_WEIXINIMG = "weixinImg";

        // create table

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + ROW_ID +
                " INTEGER PRIMARY KEY," + COLUMN_TAG + TEXT_TYPE +
                COLUMN_BIGIMGHEIGHT + INT_TYPE + COLUMN_BIGIMG + TEXT_TYPE + COLUMN_CONTEXT + TEXT_TYPE
                + COLUMN_FLOOR + INT_TYPE + COLUMN_ISCURRENTUSER + INT_TYPE + COLUMN_DELETETAG + INT_TYPE +
                COLUMN_OTHERDELETETAG + INT_TYPE + COLUMN_DATE + TEXT_TYPE + COLUMN_ID + INT_TYPE + COLUMN_AUTHORITY
                + INT_TYPE + COLUMN_OTHERCONTEXT + TEXT_TYPE + COLUMN_OTHERNIKE + TEXT_TYPE +
                COLUMN_OTHERFLOOR + INT_TYPE + COLUMN_NIKE + TEXT_TYPE + COLUMN_OTHERUSERID + INT_TYPE +
                COLUMN_OTHERUSERSMALLHEADIMG + TEXT_TYPE + COLUMN_SMALLIMG + TEXT_TYPE + COLUMN_SMALLIMGHEIGHT + INT_TYPE +
                COLUMN_SMALLIMGWIDTH + INT_TYPE + COLUMN_OTHERUSERSMALLIMGHEIGHT + INT_TYPE + COLUMN_OTHERUSERSMALLIMGWIDTH + INT_TYPE
                + COLUMN_WEIXINIMG + TEXT_TYPE +
                COLUMN_REPLYS + INT_TYPE + COLUMN_REPLYSPARENTID + INT_TYPE + COLUMN_USERSMALLIMGHEIGHT + INT_TYPE + COLUMN_USERSMALLIMGWIDTH + INT_TYPE + COLUMN_USERID + INT_TYPE + COLUMN_USERSMALLHEADIMG
                + " TEXT"
                + ");";

        // delete table
        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    }

    //精彩专区
    public final static class PostModelWonderful implements BaseColumns {

        private PostModelWonderful() {

        }

        // scheme
        public static final String SCHEME = "content";

        // Authority
        public static final String AUTHORITY = "com.cmbb.smartkids.testmenglist.postmodelwonderful";

        // content uri
        public static final Uri CONTENT_URI = Uri.parse(SCHEME + "://" + AUTHORITY);

        // multiple rows
        public static final String MIME_TYPE_ROWS = "vnd.android.cursor.dir/vnd.com.cmbb.smartkids.testmenglist.postmodelwonderful";

        // single row
        public static final String MIME_TYPE_SINGLE_ROWS = "vnd.android.cursor.item/vnd.com.cmbb.smartkids.testmenglist.postmodelwonderful";

        // primary key column name
        public static final String ROW_ID = BaseColumns._ID;

        // table name
        public static final String TABLE_NAME = "PostModelWonderful";

        // table content URI
        public static final Uri TABLE_CONTENT_URI = Uri.withAppendedPath(CONTENT_URI, TABLE_NAME);

        //Columns
        public static final String COLUMN_BIGIMG = "bigImg";
        public static final String COLUMN_BIGIMGHEIGHT = "bigImgHeight";
        public static final String COLUMN_BIGIMGWIDTH = "bigImgWidth";
        public static final String COLUMN_CONNECTOR = "connector";
        public static final String COLUMN_CONTEXT = "context";
        public static final String COLUMN_COUNT = "count";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_SMALLIMG = "smallImg";
        public static final String COLUMN_SMALLIMGHEIGHT = "smallImgHeight";
        public static final String COLUMN_SMALLIMGWIDTH = "smallImgWidth";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_TYPE = "type";
        public static final String COLUMN_COUNT_NAME = "countName";
        public static final String COLUMN_ATTENTION_FLAG = "attention_flag";

        // create table

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + ROW_ID +
                " INTEGER PRIMARY KEY," + COLUMN_BIGIMG + TEXT_TYPE + COLUMN_BIGIMGHEIGHT + INT_TYPE
                + COLUMN_BIGIMGWIDTH + INT_TYPE
                + COLUMN_CONNECTOR + TEXT_TYPE + COLUMN_ATTENTION_FLAG + INT_TYPE +
                COLUMN_CONTEXT + TEXT_TYPE + COLUMN_COUNT + INT_TYPE + COLUMN_ID
                + INT_TYPE + COLUMN_SMALLIMG + TEXT_TYPE + COLUMN_SMALLIMGHEIGHT + INT_TYPE
                + COLUMN_SMALLIMGWIDTH + INT_TYPE + COLUMN_TITLE + TEXT_TYPE + COLUMN_COUNT_NAME + TEXT_TYPE + COLUMN_TYPE
                + " TEXT"
                + ");";

        // delete table
        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    }

    //同龄
    public final static class PostModelWonderfulList implements BaseColumns {

        private PostModelWonderfulList() {

        }

        // scheme
        public static final String SCHEME = "content";

        // Authority
        public static final String AUTHORITY = "com.cmbb.smartkids.postmodelwonderfullist";

        // content uri
        public static final Uri CONTENT_URI = Uri.parse(SCHEME + "://" + AUTHORITY);

        // multiple rows
        public static final String MIME_TYPE_ROWS = "vnd.android.cursor.dir/vnd.com.cmbb" +
                ".smartkids.postmodelwonderfullist";

        // single row
        public static final String MIME_TYPE_SINGLE_ROWS = "vnd.android.cursor.item/vnd.com.cmbb" +
                ".smartkids.postmodelwonderfullist";

        // primary key column name
        public static final String ROW_ID = BaseColumns._ID;

        // table name
        public static final String TABLE_NAME = "PostModelWonderfulList";

        // table content URI
        public static final Uri TABLE_CONTENT_URI = Uri.withAppendedPath(CONTENT_URI, TABLE_NAME);

        //Columns
        public static final String COLUMN_ATTENT = "attent";
        public static final String COLUMN_AUTHORITY = "authority";
        public static final String COLUMN_AREAID = "areaId";
        public static final String COLUMN_AREANAME = "areaName";
        public static final String COLUMN_AREATYPE = "areaType";
        public static final String COLUMN_BIGIMG = "bigImg";
        public static final String COLUMN_CONTEXT = "context";
        public static final String COLUMN_CREAM = "cream";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_EREDAR = "eredar";
        public static final String COLUMN_EREDARNAME = "eredarName";
        public static final String COLUMN_EREDARRANK = "eredarRank";
        public static final String COLUMN_EREDARTYPE = "eredarType";
        public static final String COLUMN_LOGINTIMES = "loginTimes";
        public static final String COLUMN_NIKE = "nike";
        public static final String COLUMN_PLATENAME = "plateName";
        public static final String COLUMN_RELPYS = "relpys";
        public static final String COLUMN_SMALLIMG = "smallImg";
        public static final String COLUMN_PORTCONNECTOR = "portConnector";
        public static final String COLUMN_SMALLIMGHEIGHT = "smallImgHeight";
        public static final String COLUMN_SMALLIMGWIDTH = "smallImgWidth";
        public static final String COLUMN_STICK = "stick";
        public static final String COLUMN_STORE = "store";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_TYPE = "type";
        public static final String COLUMN_USERID = "userId";
        public static final String COLUMN_USERSMALLHEADIMG = "userSmallHeadImg";
        public static final String COLUMN_VALIDCURRENTUSER = "validCurrentUser";
        public static final String COLUMN_WEIXINIMG = "weixinImg";
        public static final String COLUMN_WONDERFUL_FLAG = "wonderful_flag";

        // create table

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + ROW_ID +
                " INTEGER PRIMARY KEY," +
                COLUMN_ATTENT + INT_TYPE + COLUMN_BIGIMG + TEXT_TYPE
                + COLUMN_CONTEXT + TEXT_TYPE + COLUMN_EREDAR + INT_TYPE
                + COLUMN_EREDARNAME + TEXT_TYPE + COLUMN_EREDARRANK + INT_TYPE + COLUMN_EREDARTYPE + INT_TYPE
                + COLUMN_AREANAME + TEXT_TYPE + COLUMN_AREATYPE + TEXT_TYPE + COLUMN_AREAID + INT_TYPE +
                COLUMN_CREAM + INT_TYPE + COLUMN_DATE + TEXT_TYPE + COLUMN_ID + INT_TYPE + COLUMN_AUTHORITY
                + INT_TYPE + COLUMN_PORTCONNECTOR + TEXT_TYPE + COLUMN_VALIDCURRENTUSER + TEXT_TYPE +
                COLUMN_LOGINTIMES + INT_TYPE + COLUMN_NIKE + TEXT_TYPE + COLUMN_PLATENAME + TEXT_TYPE +
                COLUMN_RELPYS + INT_TYPE + COLUMN_SMALLIMG + TEXT_TYPE + COLUMN_SMALLIMGHEIGHT + INT_TYPE +
                COLUMN_SMALLIMGWIDTH + INT_TYPE + COLUMN_STICK + INT_TYPE + COLUMN_STORE + INT_TYPE
                + COLUMN_WEIXINIMG + TEXT_TYPE + COLUMN_WONDERFUL_FLAG + INT_TYPE +
                COLUMN_TITLE + TEXT_TYPE + COLUMN_TYPE + TEXT_TYPE + COLUMN_USERID + INT_TYPE + COLUMN_USERSMALLHEADIMG
                + " TEXT"
                + ");";

        // delete table
        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    }

    public final static class PostModelWonderfulListDetail implements BaseColumns {

        private PostModelWonderfulListDetail() {

        }

        // scheme
        public static final String SCHEME = "content";

        // Authority
        public static final String AUTHORITY = "com.cmbb.smartkids.postmodelwonderfullistdetail";

        // content uri
        public static final Uri CONTENT_URI = Uri.parse(SCHEME + "://" + AUTHORITY);

        // multiple rows
        public static final String MIME_TYPE_ROWS = "vnd.android.cursor.dir/vnd.com.cmbb" +
                ".smartkids.postmodelwonderfullistdetail";

        // single row
        public static final String MIME_TYPE_SINGLE_ROWS = "vnd.android.cursor.item/vnd.com.cmbb" +
                ".smartkids.postmodelwonderfullistdetail";

        // primary key column name
        public static final String ROW_ID = BaseColumns._ID;

        // table name
        public static final String TABLE_NAME = "PostModelWonderfulListDetail";

        // table content URI
        public static final Uri TABLE_CONTENT_URI = Uri.withAppendedPath(CONTENT_URI, TABLE_NAME);

        //Columns
        public static final String COLUMN_ATTENT = "attent";
        public static final String COLUMN_AUTHORITY = "authority";
        public static final String COLUMN_AREAID = "areaId";
        public static final String COLUMN_AREANAME = "areaName";
        public static final String COLUMN_AREATYPE = "areaType";
        public static final String COLUMN_BIGIMG = "bigImg";
        public static final String COLUMN_CONTEXT = "context";
        public static final String COLUMN_CREAM = "cream";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_LOGINTIMES = "loginTimes";
        public static final String COLUMN_NIKE = "nike";
        public static final String COLUMN_PLATENAME = "plateName";
        public static final String COLUMN_RELPYS = "relpys";
        public static final String COLUMN_SMALLIMG = "smallImg";
        public static final String COLUMN_PORTCONNECTOR = "portConnector";
        public static final String COLUMN_SMALLIMGHEIGHT = "smallImgHeight";
        public static final String COLUMN_SMALLIMGWIDTH = "smallImgWidth";
        public static final String COLUMN_STICK = "stick";
        public static final String COLUMN_STORE = "store";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_TYPE = "type";
        public static final String COLUMN_USERID = "userId";
        public static final String COLUMN_USERSMALLHEADIMG = "userSmallHeadImg";
        public static final String COLUMN_VALIDCURRENTUSER = "validCurrentUser";
        public static final String COLUMN_WEIXINIMG = "weixinImg";
        // 添加点赞字段
        public static final String COLUMN_CURRENTUSERSPOT = "currentUserSpot";
        public static final String COLUMN_SPOTCOUNT = "spotCount";

        // create table

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + ROW_ID +
                " INTEGER PRIMARY KEY," +
                COLUMN_ATTENT + INT_TYPE + COLUMN_BIGIMG + TEXT_TYPE + COLUMN_CONTEXT + TEXT_TYPE
                + COLUMN_AREANAME + TEXT_TYPE + COLUMN_AREATYPE + TEXT_TYPE + COLUMN_AREAID + INT_TYPE +
                COLUMN_CREAM + INT_TYPE + COLUMN_DATE + TEXT_TYPE + COLUMN_ID + INT_TYPE + COLUMN_AUTHORITY
                + INT_TYPE + COLUMN_PORTCONNECTOR + TEXT_TYPE + COLUMN_VALIDCURRENTUSER + TEXT_TYPE +
                COLUMN_LOGINTIMES + INT_TYPE + COLUMN_NIKE + TEXT_TYPE + COLUMN_PLATENAME + TEXT_TYPE +
                COLUMN_RELPYS + INT_TYPE + COLUMN_SMALLIMG + TEXT_TYPE + COLUMN_SMALLIMGHEIGHT + INT_TYPE +
                COLUMN_SMALLIMGWIDTH + INT_TYPE + COLUMN_STICK + INT_TYPE + COLUMN_STORE + INT_TYPE
                + COLUMN_WEIXINIMG + TEXT_TYPE +
                COLUMN_TITLE + TEXT_TYPE + COLUMN_TYPE + TEXT_TYPE +
                COLUMN_USERID + INT_TYPE +
                COLUMN_CURRENTUSERSPOT + INT_TYPE +
                COLUMN_SPOTCOUNT + INT_TYPE +
                COLUMN_USERSMALLHEADIMG
                + " TEXT"
                + ");";

        // delete table
        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    }

    public final static class PostModelWonderfulListReplays implements BaseColumns {

        private PostModelWonderfulListReplays() {

        }

        // scheme
        public static final String SCHEME = "content";

        // Authority
        public static final String AUTHORITY = "com.cmbb.smartkids.postmodelwonderfullistreplays";

        // content uri
        public static final Uri CONTENT_URI = Uri.parse(SCHEME + "://" + AUTHORITY);

        // multiple rowsr
        public static final String MIME_TYPE_ROWS = "vnd.android.cursor.dir/vnd.com.cmbb" +
                ".smartkids.postmodelwonderfullistreplays";

        // single row
        public static final String MIME_TYPE_SINGLE_ROWS = "vnd.android.cursor.item/vnd.com.cmbb" +
                ".smartkids.postmodelwonderfullistreplays";

        // primary key column name
        public static final String ROW_ID = BaseColumns._ID;

        // table name
        public static final String TABLE_NAME = "PostModelWonderfulListReplays";

        // table content URI
        public static final Uri TABLE_CONTENT_URI = Uri.withAppendedPath(CONTENT_URI, TABLE_NAME);

        //Columns
        public static final String COLUMN_AUTHORITY = "authority";
        public static final String COLUMN_BIGIMG = "bigImg";
        public static final String COLUMN_BIGIMGHEIGHT = "bigImgHeight";
        public static final String COLUMN_CONTEXT = "context";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_DELETETAG = "deleteTag";
        public static final String COLUMN_FLOOR = "floor";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_TAG = "tag";
        public static final String COLUMN_ISCURRENTUSER = "isCurrentUser";
        public static final String COLUMN_NIKE = "nike";
        public static final String COLUMN_OTHERCONTEXT = "otherContext";
        public static final String COLUMN_OTHERDELETETAG = "otherDeleteTag";
        public static final String COLUMN_OTHERFLOOR = "otherFloor";
        public static final String COLUMN_OTHERNIKE = "otherNike";
        public static final String COLUMN_OTHERUSERID = "otherUserId";
        public static final String COLUMN_OTHERUSERSMALLHEADIMG = "otherUserSmallHeadImg";
        public static final String COLUMN_OTHERUSERSMALLIMGHEIGHT = "otherUserSmallImgHeight";
        public static final String COLUMN_OTHERUSERSMALLIMGWIDTH = "otherUserSmallImgWidth";
        public static final String COLUMN_REPLYS = "replys";
        public static final String COLUMN_REPLYSPARENTID = "replysParentId";
        public static final String COLUMN_SMALLIMG = "smallImg";
        public static final String COLUMN_SMALLIMGHEIGHT = "smallImgHeight";
        public static final String COLUMN_SMALLIMGWIDTH = "smallImgWidth";
        public static final String COLUMN_USERID = "userId";
        public static final String COLUMN_USERSMALLHEADIMG = "userSmallHeadImg";
        public static final String COLUMN_USERSMALLIMGHEIGHT = "userSmallImgHeight";
        public static final String COLUMN_USERSMALLIMGWIDTH = "usersmallimgwidth";
        public static final String COLUMN_WEIXINIMG = "weixinImg";

        // create table

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + ROW_ID +
                " INTEGER PRIMARY KEY," + COLUMN_TAG + TEXT_TYPE +
                COLUMN_BIGIMGHEIGHT + INT_TYPE + COLUMN_BIGIMG + TEXT_TYPE + COLUMN_CONTEXT + TEXT_TYPE
                + COLUMN_FLOOR + INT_TYPE + COLUMN_ISCURRENTUSER + INT_TYPE + COLUMN_DELETETAG + INT_TYPE +
                COLUMN_OTHERDELETETAG + INT_TYPE + COLUMN_DATE + TEXT_TYPE + COLUMN_ID + INT_TYPE + COLUMN_AUTHORITY
                + INT_TYPE + COLUMN_OTHERCONTEXT + TEXT_TYPE + COLUMN_OTHERNIKE + TEXT_TYPE +
                COLUMN_OTHERFLOOR + INT_TYPE + COLUMN_NIKE + TEXT_TYPE + COLUMN_OTHERUSERID + INT_TYPE +
                COLUMN_OTHERUSERSMALLHEADIMG + TEXT_TYPE + COLUMN_SMALLIMG + TEXT_TYPE + COLUMN_SMALLIMGHEIGHT + INT_TYPE +
                COLUMN_SMALLIMGWIDTH + INT_TYPE + COLUMN_OTHERUSERSMALLIMGHEIGHT + INT_TYPE + COLUMN_OTHERUSERSMALLIMGWIDTH + INT_TYPE
                + COLUMN_WEIXINIMG + TEXT_TYPE +
                COLUMN_REPLYS + INT_TYPE + COLUMN_REPLYSPARENTID + INT_TYPE + COLUMN_USERSMALLIMGHEIGHT + INT_TYPE + COLUMN_USERSMALLIMGWIDTH + INT_TYPE + COLUMN_USERID + INT_TYPE + COLUMN_USERSMALLHEADIMG
                + " TEXT"
                + ");";

        // delete table
        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    }

    //Search 3 case
    public final static class SearchCase implements BaseColumns {

        private SearchCase() {

        }

        // scheme
        public static final String SCHEME = "content";

        // Authority
        public static final String AUTHORITY = "com.cmbb.smartkids.searchcase";

        // content uri
        public static final Uri CONTENT_URI = Uri.parse(SCHEME + "://" + AUTHORITY);

        // multiple rows
        public static final String MIME_TYPE_ROWS = "vnd.android.cursor.dir/vnd.com.cmbb" +
                ".smartkids.searchcase";

        // single row
        public static final String MIME_TYPE_SINGLE_ROWS = "vnd.android.cursor.item/vnd.com.cmbb" +
                ".smartkids.searchpost";

        // primary key column name
        public static final String ROW_ID = BaseColumns._ID;

        // table name
        public static final String TABLE_NAME = "SearchCase";

        // table content URI
        public static final Uri TABLE_CONTENT_URI = Uri.withAppendedPath(CONTENT_URI, TABLE_NAME);
        //Columns
        public static final String COLUMN_ATTENT = "attent";
        public static final String COLUMN_AUTHORITY = "authority";
        public static final String COLUMN_BIGIMG = "bigImg";
        public static final String COLUMN_BIGIMGHEIGHT = "bigImgHeight";
        public static final String COLUMN_BIGIMGWIDTH = "bigImgWidth";
        public static final String COLUMN_CONTEXT = "context";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_NIKE = "nike";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_REPLYS = "replys";
        public static final String COLUMN_SMALLIMG = "smallImg";
        public static final String COLUMN_SMALLIMGHEIGHE = "smallImgHeight";
        public static final String COLUMN_SMALLIMGWIDTH = "smallImgWidth";
        public static final String COLUMN_STORE = "store";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_TYPE = "type";
        public static final String COLUMN_USERBIGHEADIMG = "userBigHeadImg";
        public static final String COLUMN_USERID = "userId";
        public static final String COLUMN_USERSTATUS = "userStatus";

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + ROW_ID + " INTEGER PRIMARY KEY," +
                COLUMN_ATTENT + INT_TYPE +
                COLUMN_AUTHORITY + TEXT_TYPE +
                COLUMN_BIGIMG + TEXT_TYPE +
                COLUMN_BIGIMGHEIGHT + INT_TYPE +
                COLUMN_BIGIMGWIDTH + INT_TYPE +
                COLUMN_CONTEXT + TEXT_TYPE +
                COLUMN_DATE + TEXT_TYPE +
                COLUMN_ID + INT_TYPE +
                COLUMN_NAME + TEXT_TYPE +
                COLUMN_NIKE + TEXT_TYPE +
                COLUMN_QUESTION + TEXT_TYPE +
                COLUMN_REPLYS + TEXT_TYPE +
                COLUMN_SMALLIMG + TEXT_TYPE +
                COLUMN_SMALLIMGHEIGHE + INT_TYPE +
                COLUMN_SMALLIMGWIDTH + INT_TYPE +
                COLUMN_STORE + TEXT_TYPE +
                COLUMN_TITLE + TEXT_TYPE +
                COLUMN_TYPE + TEXT_TYPE +
                COLUMN_USERBIGHEADIMG + TEXT_TYPE +
                COLUMN_USERID + INT_TYPE +
                COLUMN_USERSTATUS + " INTEGER"
                + ");";
        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    //Search 1 user
    public final static class SearchUser implements BaseColumns {

        private SearchUser() {
        }

        // scheme
        public static final String SCHEME = "content";
        // Authority
        public static final String AUTHORITY = "com.cmbb.smartkids.searchuser";
        // content uri
        public static final Uri CONTENT_URI = Uri.parse(SCHEME + "://" + AUTHORITY);
        // multiple rows
        public static final String MIME_TYPE_ROWS = "vnd.android.cursor.dir/vnd.com.cmbb" +
                ".smartkids.searchuser";
        // single row
        public static final String MIME_TYPE_SINGLE_ROWS = "vnd.android.cursor.item/vnd.com.cmbb" +
                ".smartkids.searchuser";
        // primary key column name
        public static final String ROW_ID = BaseColumns._ID;
        // table name
        public static final String TABLE_NAME = "SearchUser";
        // table content URI
        public static final Uri TABLE_CONTENT_URI = Uri.withAppendedPath(CONTENT_URI, TABLE_NAME);

        public static final String COLUMN_ATTENTION = "attention";
        public static final String COLUMN_AUTHORITY = "authority";
        public static final String COLUMN_BIGIMGHEIGHT = "bigImgHeight";
        public static final String COLUMN_BIGIMGWIDTH = "bigImgWidth";
        public static final String COLUMN_EREDAR = "eredar";
        public static final String COLUMN_EREDARNAME = "eredarName";
        public static final String COLUMN_EREDARANK = "eredarRank";
        public static final String COLUMN_USERID = "userId";
        public static final String COLUMN_EREDARTYPE = "eredarType";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_LOGINTIMES = "loginTimes";
        public static final String COLUMN_NIKE = "nike";
        public static final String COLUMN_SMALLIMGHEIGHT = "smallImgHeight";
        public static final String COLUMN_SMALLIMGWIDTH = "smallImgWidth";
        public static final String COLUMN_USERBIGHEADIMG = "userBigHeadImg";
        public static final String COLUMN_USERSMALLHEADIMG = "userSmallHeadImg";
        public static final String COLUMN_USERSTATUS = "userStatus";
        public static final String COLUMN_VALIDCURRENTUSER = "validCurrentUser";
        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + ROW_ID + " INTEGER PRIMARY KEY," +
                COLUMN_AUTHORITY + INT_TYPE +
                COLUMN_ATTENTION + INT_TYPE +
                COLUMN_BIGIMGHEIGHT + INT_TYPE +
                COLUMN_BIGIMGWIDTH + INT_TYPE +
                COLUMN_EREDAR + INT_TYPE +
                COLUMN_EREDARNAME + TEXT_TYPE +
                COLUMN_EREDARANK + INT_TYPE +
                COLUMN_USERID + INT_TYPE +
                COLUMN_EREDARTYPE + INT_TYPE +
                COLUMN_ID + INT_TYPE +
                COLUMN_LOGINTIMES + INT_TYPE +
                COLUMN_NIKE + TEXT_TYPE +
                COLUMN_SMALLIMGHEIGHT + INT_TYPE +
                COLUMN_SMALLIMGWIDTH + INT_TYPE +
                COLUMN_USERBIGHEADIMG + TEXT_TYPE +
                COLUMN_USERSMALLHEADIMG + TEXT_TYPE +
                COLUMN_USERSTATUS + TEXT_TYPE + COLUMN_VALIDCURRENTUSER + "INTEGER" + ");";

        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    }

    //Search
    public final static class SearchPost implements BaseColumns {

        private SearchPost() {
        }

        // scheme
        public static final String SCHEME = "content";
        // Authority
        public static final String AUTHORITY = "com.cmbb.smartkids.searchpost";
        // content uri
        public static final Uri CONTENT_URI = Uri.parse(SCHEME + "://" + AUTHORITY);
        // multiple rows
        public static final String MIME_TYPE_ROWS = "vnd.android.cursor.dir/vnd.com.cmbb" +
                ".smartkids.searchpost";
        // single row
        public static final String MIME_TYPE_SINGLE_ROWS = "vnd.android.cursor.item/vnd.com.cmbb" +
                ".smartkids.searchpost";
        // primary key column name
        public static final String ROW_ID = BaseColumns._ID;
        // table name
        public static final String TABLE_NAME = "SearchPost";
        // table content URI
        public static final Uri TABLE_CONTENT_URI = Uri.withAppendedPath(CONTENT_URI, TABLE_NAME);

        public static final String COLUMN_AREAID = "areaId";
        public static final String COLUMN_AREANAME = "areaName";
        public static final String COLUMN_AREATYPE = "areaType";
        public static final String COLUMN_ATTENT = "attent";
        public static final String COLUMN_AUTHORITY = "authority";
        public static final String COLUMN_BIGIMG = "bigImg";
        public static final String COLUMN_CONTEXT = "context";
        public static final String COLUMN_CREAM = "cream";
        public static final String COLUMN_DATA = "date";
        public static final String COLUMN_EREDAR = "eredar";
        public static final String COLUMN_EREDARNAME = "eredarName";
        public static final String COLUMN_EREDARRANK = "eredarRank";
        public static final String COLUMN_EREDARTYPE = "eredarType";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_LOGINTIMES = "loginTimes";
        public static final String COLUMN_NIKE = "nike";
        public static final String COLUMN_PLATENAME = "plateName";
        public static final String COLUMN_PORTCONNECTOR = "portConnector";
        public static final String COLUMN_RELPYS = "relpys";
        public static final String COLUMN_SMALLIMG = "smallImg";
        public static final String COLUMN_SMALLIMGHEIGHT = "smallImgHeight";
        public static final String COLUMN_SMALLIMGWIDTH = "smallImgWidth";
        public static final String COLUMN_STICK = "stick";
        public static final String COLUMN_STORE = "store";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_TYPE = "type";
        public static final String COLUMN_USERID = "userId";
        public static final String COLUMN_USERSMALLHEADIMG = "userSmallHeadImg";
        public static final String COLUMN_USERSTATUS = "userStatus";
        public static final String COLUMN_VALIDCURRENTUSER = "validCurrentUser";
        public static final String COLUMN_WEIXINIMG = "weixinImg";

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + ROW_ID + " INTEGER PRIMARY KEY," +
                COLUMN_AREAID + INT_TYPE +
                COLUMN_AREANAME + TEXT_TYPE +
                COLUMN_AREATYPE + TEXT_TYPE +
                COLUMN_ATTENT + INT_TYPE +
                COLUMN_AUTHORITY + INT_TYPE +
                COLUMN_BIGIMG + TEXT_TYPE +
                COLUMN_CONTEXT + TEXT_TYPE +
                COLUMN_CREAM + INT_TYPE +
                COLUMN_DATA + TEXT_TYPE +
                COLUMN_EREDAR + INT_TYPE +
                COLUMN_EREDARNAME + TEXT_TYPE +
                COLUMN_EREDARRANK + INT_TYPE +
                COLUMN_EREDARTYPE + INT_TYPE +
                COLUMN_ID + INT_TYPE +
                COLUMN_LOGINTIMES + INT_TYPE +
                COLUMN_NIKE + TEXT_TYPE +
                COLUMN_PLATENAME + TEXT_TYPE +
                COLUMN_PORTCONNECTOR + TEXT_TYPE +
                COLUMN_RELPYS + INT_TYPE +
                COLUMN_SMALLIMG + TEXT_TYPE +
                COLUMN_SMALLIMGHEIGHT + INT_TYPE +
                COLUMN_SMALLIMGWIDTH + INT_TYPE +
                COLUMN_STICK + INT_TYPE +
                COLUMN_STORE + INT_TYPE +
                COLUMN_TITLE + TEXT_TYPE +
                COLUMN_TYPE + TEXT_TYPE +
                COLUMN_USERID + INT_TYPE +
                COLUMN_USERSMALLHEADIMG + TEXT_TYPE +
                COLUMN_USERSTATUS + INT_TYPE +
                COLUMN_VALIDCURRENTUSER + INT_TYPE +
                COLUMN_WEIXINIMG + " TEXT" + ");";
        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    }

    public final static class GrowthRecord implements BaseColumns {

        private GrowthRecord() {
        }

        // scheme
        public static final String SCHEME = "content";
        // Authority
        public static final String AUTHORITY = "com.cmbb.smartkids.growthrecord";
        // content uri
        public static final Uri CONTENT_URI = Uri.parse(SCHEME + "://" + AUTHORITY);
        // multiple rows
        public static final String MIME_TYPE_ROWS = "vnd.android.cursor.dir/vnd.com.cmbb" +
                ".smartkids.growthrecord";
        // single row
        public static final String MIME_TYPE_SINGLE_ROWS = "vnd.android.cursor.item/vnd.com.cmbb" +
                ".smartkids.growthrecord";
        // primary key column name
        public static final String ROW_ID = BaseColumns._ID;
        // table name
        public static final String TABLE_NAME = "GrowthRecord";
        // table content URI
        public static final Uri TABLE_CONTENT_URI = Uri.withAppendedPath(CONTENT_URI, TABLE_NAME);

        public static final String COLUMN_NICK = "nick";
        public static final String COLUMN_WEIGHT = "weight";
        public static final String COLUMN_SPORTTIME = "sportTime";
        public static final String COLUMN_STATUS = "status";

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + ROW_ID + " INTEGER PRIMARY KEY," +
                COLUMN_NICK + TEXT_TYPE +
                COLUMN_WEIGHT + TEXT_TYPE +
                COLUMN_SPORTTIME + TEXT_TYPE +
                COLUMN_STATUS +
                " INTEGER" + ");";
        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    }

    //Search
    public final static class MasterFindType implements BaseColumns {

        private MasterFindType() {
        }

        // scheme
        public static final String SCHEME = "content";

        // Authority
        public static final String AUTHORITY = "com.cmbb.smartkids.masterfindtype";

        // content uri
        public static final Uri CONTENT_URI = Uri.parse(SCHEME + "://" + AUTHORITY);

        // multiple rows
        public static final String MIME_TYPE_ROWS = "vnd.android.cursor.dir/vnd.com.cmbb" +
                ".smartkids.masterfindtype";

        // single row
        public static final String MIME_TYPE_SINGLE_ROWS = "vnd.android.cursor.item/vnd.com.cmbb" +
                ".smartkids.masterfindtype";

        // primary key column name
        public static final String ROW_ID = BaseColumns._ID;

        // table name
        public static final String TABLE_NAME = "MasterFindType";

        // table content URI
        public static final Uri TABLE_CONTENT_URI = Uri.withAppendedPath(CONTENT_URI, TABLE_NAME);

        public static final String COLUMN_EREDARTYPE = "eredarType";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_FLAG = "flag";
        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + ROW_ID + " INTEGER PRIMARY KEY," +
                COLUMN_EREDARTYPE + INT_TYPE + COLUMN_FLAG + INT_TYPE +
                COLUMN_NAME + " TEXT" + ");";
        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public final static class MasterFindByTypeUser implements BaseColumns {

        private MasterFindByTypeUser() {
        }

        // scheme
        public static final String SCHEME = "content";

        // Authority
        public static final String AUTHORITY = "com.cmbb.smartkids.masterfindbytypeuser";

        // content uri
        public static final Uri CONTENT_URI = Uri.parse(SCHEME + "://" + AUTHORITY);

        // multiple rows
        public static final String MIME_TYPE_ROWS = "vnd.android.cursor.dir/vnd.com.cmbb" +
                ".smartkids.masterfindbytypeuser";

        // single row
        public static final String MIME_TYPE_SINGLE_ROWS = "vnd.android.cursor.item/vnd.com.cmbb" +
                ".smartkids.masterfindbytypeuser";

        // primary key column name
        public static final String ROW_ID = BaseColumns._ID;

        // table name
        public static final String TABLE_NAME = "MasterFindByTypeUser";

        // table content URI
        public static final Uri TABLE_CONTENT_URI = Uri.withAppendedPath(CONTENT_URI, TABLE_NAME);

        public static final String COLUMN_ATTENTION = "attention";
        public static final String COLUMN_AUTHORITY = "authority";
        public static final String COLUMN_BIGIMGHEIGHT = "bigImgHeight";
        public static final String COLUMN_BIGIMGWIDTH = "bigImgWidth";
        public static final String COLUMN_CURRENTUSER = "currentUser";
        public static final String COLUMN_EREDAR = "eredar";
        public static final String COLUMN_EREDARNAME = "eredarName";
        public static final String COLUMN_EREDARRANK = "eredarRank";
        public static final String COLUMN_EREDARTYPE = "eredarType";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_LOGINTIMES = "loginTimes";
        public static final String COLUMN_NIKE = "nike";
        public static final String COLUMN_SMALLIMGHEIGHT = "smallImgHeight";
        public static final String COLUMN_SMALLIMGWIDTH = "smallImgWidth";
        public static final String COLUMN_USERBIGHEADIMG = "userBigHeadImg";
        public static final String COLUMN_USERSMALLHEADIMG = "userSmallHeadImg";
        public static final String COLUMN_USERSTATUS = "userStatus";
        public static final String COLUMN_FLAG = "flag";
        public static final String COLUMN_MASTER_OR_EXPERT = "master_or_expert";

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + ROW_ID + " INTEGER PRIMARY KEY," +
                COLUMN_ATTENTION + INT_TYPE +
                COLUMN_AUTHORITY + INT_TYPE +
                COLUMN_BIGIMGHEIGHT + INT_TYPE +
                COLUMN_EREDAR + INT_TYPE +
                COLUMN_EREDARNAME + TEXT_TYPE +
                COLUMN_BIGIMGWIDTH + INT_TYPE +
                COLUMN_CURRENTUSER + INT_TYPE +
                COLUMN_EREDARRANK + INT_TYPE +
                COLUMN_EREDARTYPE + INT_TYPE +
                COLUMN_ID + INT_TYPE +
                COLUMN_LOGINTIMES + INT_TYPE +
                COLUMN_NIKE + TEXT_TYPE +
                COLUMN_SMALLIMGHEIGHT + INT_TYPE +
                COLUMN_SMALLIMGWIDTH + INT_TYPE +
                COLUMN_USERBIGHEADIMG + TEXT_TYPE +
                COLUMN_USERSMALLHEADIMG + TEXT_TYPE +
                COLUMN_USERSTATUS + INT_TYPE +
                COLUMN_FLAG + INT_TYPE +
                COLUMN_MASTER_OR_EXPERT + INT_TYPE +
                COLUMN_USERSMALLHEADIMG + "INTEGER" + ");";
        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public final static class ExpertFindByTypeUser implements BaseColumns {

        private ExpertFindByTypeUser() {
        }

        // scheme
        public static final String SCHEME = "content";

        // Authority
        public static final String AUTHORITY = "com.cmbb.smartkids.expertfindbytypeuser";

        // content uri
        public static final Uri CONTENT_URI = Uri.parse(SCHEME + "://" + AUTHORITY);

        // multiple rows
        public static final String MIME_TYPE_ROWS = "vnd.android.cursor.dir/vnd.com.cmbb" +
                ".smartkids.expertfindbytypeuser";

        // single row
        public static final String MIME_TYPE_SINGLE_ROWS = "vnd.android.cursor.item/vnd.com.cmbb" +
                ".smartkids.expertfindbytypeuser";

        // primary key column name
        public static final String ROW_ID = BaseColumns._ID;

        // table name
        public static final String TABLE_NAME = "ExpertFindByTypeUser";

        // table content URI
        public static final Uri TABLE_CONTENT_URI = Uri.withAppendedPath(CONTENT_URI, TABLE_NAME);

        public static final String COLUMN_ABSTRACTING = "abstracting";
        public static final String COLUMN_ADDRESS = "address";
        public static final String COLUMN_ATTENTION = "attention";
        public static final String COLUMN_BEGOODAT = "beGoodAt";
        public static final String COLUMN_BIGIMGHEIGHT = "bigImgHeight";
        public static final String COLUMN_BIGIMGWIDTH = "bigImgWidth";
        public static final String COLUMN_CASECOUNT = "caseCount";
        public static final String COLUMN_CHATCOUNT = "chatCount";
        public static final String COLUMN_CITY = "city";
        public static final String COLUMN_CURRENTUSER = "currentUser";
        public static final String COLUMN_EREDAR = "eredar";
        public static final String COLUMN_HELPCOUNT = "helpCount";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_ONLINE = "online";
        public static final String COLUMN_REALNAME = "realName";
        public static final String COLUMN_SMALLIMGHEIGHT = "smallImgHeight";
        public static final String COLUMN_SMALLIMGWIDTH = "smallImgWidth";
        public static final String COLUMN_TYPE = "type";
        public static final String COLUMN_USERBIGHEADIMG = "userBigHeadImg";
        public static final String COLUMN_USERID = "userId";
        public static final String COLUMN_USERSMALLHEADIMG = "userSmallHeadImg";

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + ROW_ID + " INTEGER PRIMARY KEY," +
                COLUMN_ABSTRACTING + TEXT_TYPE +
                COLUMN_ADDRESS + TEXT_TYPE +
                COLUMN_ATTENTION + INT_TYPE +
                COLUMN_BEGOODAT + TEXT_TYPE +
                COLUMN_BIGIMGHEIGHT + INT_TYPE +
                COLUMN_BIGIMGWIDTH + INT_TYPE +
                COLUMN_CASECOUNT + INT_TYPE +
                COLUMN_CHATCOUNT + INT_TYPE +
                COLUMN_CITY + INT_TYPE +
                COLUMN_CURRENTUSER + INT_TYPE +
                COLUMN_EREDAR + INT_TYPE +
                COLUMN_HELPCOUNT + INT_TYPE +
                COLUMN_NAME + TEXT_TYPE +
                COLUMN_ONLINE + INT_TYPE +
                COLUMN_REALNAME + TEXT_TYPE +
                COLUMN_SMALLIMGHEIGHT + INT_TYPE +
                COLUMN_SMALLIMGWIDTH + INT_TYPE +
                COLUMN_TYPE + INT_TYPE +
                COLUMN_USERBIGHEADIMG + TEXT_TYPE +
                COLUMN_USERID + INT_TYPE +
                COLUMN_USERSMALLHEADIMG + " TEXT" + ");";
        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public final static class MasterFindAttentionUser implements BaseColumns {

        private MasterFindAttentionUser()

        {

        }

        // scheme
        public static final String SCHEME = "content";

        // Authority
        public static final String AUTHORITY = "com.cmbb.smartkids.masterfindattentionuser";

        // content uri
        public static final Uri CONTENT_URI = Uri.parse(SCHEME + "://" + AUTHORITY);

        // multiple rows
        public static final String MIME_TYPE_ROWS = "vnd.android.cursor.dir/vnd.com.cmbb" +
                ".smartkids.masterfindattentionuser";

        // single row
        public static final String MIME_TYPE_SINGLE_ROWS = "vnd.android.cursor.item/vnd.com.cmbb" +
                ".smartkids.masterfindattentionuser";

        // primary key column name
        public static final String ROW_ID = BaseColumns._ID;

        // table name
        public static final String TABLE_NAME = "MasterFindAttentionUser";

        // table content URI
        public static final Uri TABLE_CONTENT_URI = Uri.withAppendedPath(CONTENT_URI, TABLE_NAME);

        public static final String COLUMN_ATTENTION = "attention";
        public static final String COLUMN_AUTHORITY = "authority";
        public static final String COLUMN_BIGIMGHEIGHT = "bigImgHeight";
        public static final String COLUMN_BIGIMGWIDTH = "bigImgWidth";
        public static final String COLUMN_CURRENTUSER = "currentUser";
        public static final String COLUMN_EREDARRANK = "eredarRank";
        public static final String COLUMN_EREDARTYPE = "eredarType";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_LOGINTIMES = "loginTimes";
        public static final String COLUMN_NIKE = "nike";
        public static final String COLUMN_SMALLIMGHEIGHT = "smallImgHeight";
        public static final String COLUMN_SMALLIMGWIDTH = "smallImgWidth";
        public static final String COLUMN_USERBIGHEADIMG = "userBigHeadImg";
        public static final String COLUMN_USERSMALLHEADIMG = "userSmallHeadImg";
        public static final String COLUMN_USERSTATUS = "userStatus";

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + ROW_ID + " INTEGER PRIMARY KEY," +
                COLUMN_ATTENTION + INT_TYPE +
                COLUMN_AUTHORITY + INT_TYPE +
                COLUMN_BIGIMGHEIGHT + INT_TYPE +
                COLUMN_BIGIMGWIDTH + INT_TYPE +
                COLUMN_CURRENTUSER + INT_TYPE +
                COLUMN_EREDARRANK + INT_TYPE +
                COLUMN_EREDARTYPE + INT_TYPE +
                COLUMN_ID + INT_TYPE +
                COLUMN_LOGINTIMES + INT_TYPE +
                COLUMN_NIKE + TEXT_TYPE +
                COLUMN_SMALLIMGHEIGHT + INT_TYPE +
                COLUMN_SMALLIMGWIDTH + INT_TYPE +
                COLUMN_USERBIGHEADIMG + TEXT_TYPE +
                COLUMN_USERSMALLHEADIMG + TEXT_TYPE +
                COLUMN_USERSTATUS + "INTEGER" + ");";
        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public final static class UserBasic implements BaseColumns {

        private UserBasic() {

        }

        // scheme
        public static final String SCHEME = "content";

        // Authority
        public static final String AUTHORITY = "com.cmbb.smartkids.userbasic";

        // content uri
        public static final Uri CONTENT_URI = Uri.parse(SCHEME + "://" + AUTHORITY);

        // multiple rows
        public static final String MIME_TYPE_ROWS = "vnd.android.cursor.dir/vnd.com.cmbb" +
                ".smartkids.userbasic";

        // single row
        public static final String MIME_TYPE_SINGLE_ROWS = "vnd.android.cursor.item/vnd.com.cmbb" +
                ".smartkids.userbasic";

        // primary key column name
        public static final String ROW_ID = BaseColumns._ID;

        // table name
        public static final String TABLE_NAME = "UserBasic";

        // table content URI
        public static final Uri TABLE_CONTENT_URI = Uri.withAppendedPath(CONTENT_URI, TABLE_NAME);

        public static final String COLUMN_ATTENTIONCOUNT = "attentionCount";
        public static final String COLUMN_AUTHORITY = "authority";
        public static final String COLUMN_BIGIMGHEIGHT = "bigImgHeight";
        public static final String COLUMN_BIGIMGWIDTH = "bigImgWidth";
        public static final String COLUMN_EREDAR = "eredar";
        public static final String COLUMN_EREDARNAME = "eredarName";
        public static final String COLUMN_EREDARRANK = "eredarRank";
        public static final String COLUMN_EREDARTYPE = "eredarType";
        public static final String COLUMN_FLAG = "flag";

        public static final String COLUMN_GOID = "gold";
        public static final String COLUMN_LOGINTIMES = "loginTimes";
        public static final String COLUMN_NIKE = "nike";
        public static final String COLUMN_PUBLISHCOUNT = "publishCount";
        public static final String COLUMN_SMALLIMGHEIGHT = "smallImgHeight";
        public static final String COLUMN_SMALLIMGWIDTH = "smallImgWidth";
        public static final String COLUMN_STORECOUNT = "storeCount";
        public static final String COLUMN_USERBIGHEADIMG = "userBigHeadImg";
        public static final String COLUMN_USERID = "userId";
        public static final String COLUMN_USERPHONE = "userPhone";
        public static final String COLUMN_USERSMALLHEADIMG = "userSmallHeadImg";
        public static final String COLUMN_USERSTATUS = "userStatus";
        public static final String COLUMN_USERWEIXINHEADIMG = "userWeiXinHeadImg";

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + ROW_ID + " INTEGER PRIMARY KEY," +
                COLUMN_ATTENTIONCOUNT + INT_TYPE +
                COLUMN_AUTHORITY + INT_TYPE +
                COLUMN_BIGIMGHEIGHT + INT_TYPE +
                COLUMN_BIGIMGWIDTH + INT_TYPE +
                COLUMN_EREDAR + INT_TYPE +
                COLUMN_EREDARNAME + TEXT_TYPE +
                COLUMN_EREDARRANK + INT_TYPE +
                COLUMN_EREDARTYPE + INT_TYPE +
                COLUMN_FLAG + TEXT_TYPE +
                COLUMN_GOID + INT_TYPE +
                COLUMN_LOGINTIMES + TEXT_TYPE +
                COLUMN_NIKE + TEXT_TYPE +
                COLUMN_PUBLISHCOUNT + INT_TYPE +
                COLUMN_SMALLIMGHEIGHT + INT_TYPE +
                COLUMN_SMALLIMGWIDTH + INT_TYPE +
                COLUMN_STORECOUNT + INT_TYPE +
                COLUMN_USERBIGHEADIMG + TEXT_TYPE +
                COLUMN_USERID + INT_TYPE +
                COLUMN_USERPHONE + TEXT_TYPE +
                COLUMN_USERSMALLHEADIMG + TEXT_TYPE +
                COLUMN_USERSTATUS + INT_TYPE +
                COLUMN_USERWEIXINHEADIMG + " TEXT" + ");";

        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public final static class UserAttention implements BaseColumns {

        private UserAttention() {

        }

        // scheme
        public static final String SCHEME = "content";

        // Authority
        public static final String AUTHORITY = "com.cmbb.smartkids.userattention";

        // content uri
        public static final Uri CONTENT_URI = Uri.parse(SCHEME + "://" + AUTHORITY);

        // multiple rows
        public static final String MIME_TYPE_ROWS = "vnd.android.cursor.dir/vnd.com.cmbb" +
                ".smartkids.userattention";

        // single row
        public static final String MIME_TYPE_SINGLE_ROWS = "vnd.android.cursor.item/vnd.com.cmbb" +
                ".smartkids.userattention";

        // primary key column name
        public static final String ROW_ID = BaseColumns._ID;

        // table name
        public static final String TABLE_NAME = "UserAttention";

        // table content URI
        public static final Uri TABLE_CONTENT_URI = Uri.withAppendedPath(CONTENT_URI, TABLE_NAME);

        public static final String COLUMN_ATTENTIONCOUNT = "attentionCount";
        public static final String COLUMN_ATTENTIONTOKEN = "attentionToken";
        public static final String COLUMN_AUTHORITY = "authority";
        public static final String COLUMN_BIGIMGHEIGHT = "bigImgHeight";
        public static final String COLUMN_BIGIMGWIDTH = "bigImgWidth";
        public static final String COLUMN_EREDAR = "eredar";
        public static final String COLUMN_EREDARNAME = "eredarName";
        public static final String COLUMN_EREDARRANK = "eredarRank";
        public static final String COLUMN_EREDARTYPE = "eredarType";
        public static final String COLUMN_FLAG = "flag";

        public static final String COLUMN_GOID = "gold";
        public static final String COLUMN_LOGINTIMES = "loginTimes";
        public static final String COLUMN_NIKE = "nike";
        public static final String COLUMN_PUBLISHCOUNT = "publishCount";
        public static final String COLUMN_SMALLIMGHEIGHT = "smallImgHeight";
        public static final String COLUMN_SMALLIMGWIDTH = "smallImgWidth";
        public static final String COLUMN_STORECOUNT = "storeCount";
        public static final String COLUMN_USERBIGHEADIMG = "userBigHeadImg";
        public static final String COLUMN_USERID = "userId";
        public static final String COLUMN_USERPHONE = "userPhone";
        public static final String COLUMN_USERSMALLHEADIMG = "userSmallHeadImg";
        public static final String COLUMN_USERSTATUS = "userStatus";
        public static final String COLUMN_USERWEIXINHEADIMG = "userWeiXinHeadImg";

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + ROW_ID + " INTEGER PRIMARY KEY," +
                COLUMN_ATTENTIONCOUNT + INT_TYPE +
                COLUMN_ATTENTIONTOKEN + TEXT_TYPE +
                COLUMN_AUTHORITY + INT_TYPE +
                COLUMN_BIGIMGHEIGHT + INT_TYPE +
                COLUMN_BIGIMGWIDTH + INT_TYPE +
                COLUMN_EREDAR + INT_TYPE +
                COLUMN_EREDARNAME + TEXT_TYPE +
                COLUMN_EREDARRANK + INT_TYPE +
                COLUMN_EREDARTYPE + INT_TYPE +
                COLUMN_FLAG + TEXT_TYPE +
                COLUMN_GOID + INT_TYPE +
                COLUMN_LOGINTIMES + TEXT_TYPE +
                COLUMN_NIKE + TEXT_TYPE +
                COLUMN_PUBLISHCOUNT + INT_TYPE +
                COLUMN_SMALLIMGHEIGHT + INT_TYPE +
                COLUMN_SMALLIMGWIDTH + INT_TYPE +
                COLUMN_STORECOUNT + INT_TYPE +
                COLUMN_USERBIGHEADIMG + TEXT_TYPE +
                COLUMN_USERID + INT_TYPE +
                COLUMN_USERPHONE + TEXT_TYPE +
                COLUMN_USERSMALLHEADIMG + TEXT_TYPE +
                COLUMN_USERSTATUS + INT_TYPE +
                COLUMN_USERWEIXINHEADIMG + " TEXT" + ");";

        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public final static class BabyFindByBaby implements BaseColumns {

        private static final String TEXT_TYPE = " TEXT,";
        private static final String INT_TYPE = " INTEGER,";

        private BabyFindByBaby() {

        }

        // scheme
        public static final String SCHEME = "content";

        // Authority
        public static final String AUTHORITY = "com.cmbb.smartkids.babyfindbybaby";

        // content uri
        public static final Uri CONTENT_URI = Uri.parse(SCHEME + "://" + AUTHORITY);

        // multiple rows
        public static final String MIME_TYPE_ROWS = "vnd.android.cursor.dir/vnd.com.cmbb" +
                ".smartkids.babyfindbybaby";

        // single row
        public static final String MIME_TYPE_SINGLE_ROWS = "vnd.android.cursor.item/vnd.com.cmbb" +
                ".smartkids.babyfindbybaby";

        // primary key column name
        public static final String ROW_ID = BaseColumns._ID;

        // table name
        public static final String TABLE_NAME = "BabyFindByBaby";

        // table content URI
        public static final Uri TABLE_CONTENT_URI = Uri.withAppendedPath(CONTENT_URI, TABLE_NAME);

        public static final String COLUMN_AGECOUNT = "ageCount";
        public static final String COLUMN_BABYBIGHEADIMG = "babyBigHeadImg";
        public static final String COLUMN_BABYID = "babyId";
        public static final String COLUMN_BABYNICK = "babyNick";
        public static final String COLUMN_BABYSEX = "babySex";
        public static final String COLUMN_BABYSMALLHEADIMG = "babySmallHeadImg";
        public static final String COLUMN_BIGIMGHEIGHT = "bigImgHeight";
        public static final String COLUMN_BIGIMGWIDTH = "bigImgWidth";
        public static final String COLUMN_BRITHDAY = "brithday";
        public static final String COLUMN_GROWINGCOUNT = "growingCount";
        public static final String COLUMN_SMALLIMGHEIGHT = "smallImgHeight";
        public static final String COLUMN_SMALLIMGWIDTH = "smallImgWidth";
        public static final String COLUMN_WEIXINIMG = "weixinImg";

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + ROW_ID + " INTEGER PRIMARY KEY," +
                COLUMN_AGECOUNT + INT_TYPE +
                COLUMN_BABYBIGHEADIMG + TEXT_TYPE +
                COLUMN_BABYID + INT_TYPE +
                COLUMN_BABYNICK + TEXT_TYPE +
                COLUMN_BABYSEX + INT_TYPE +
                COLUMN_BABYSMALLHEADIMG + TEXT_TYPE +
                COLUMN_BIGIMGHEIGHT + INT_TYPE +
                COLUMN_BIGIMGWIDTH + INT_TYPE +
                COLUMN_BRITHDAY + TEXT_TYPE +
                COLUMN_GROWINGCOUNT + INT_TYPE +
                COLUMN_SMALLIMGHEIGHT + INT_TYPE +
                COLUMN_SMALLIMGWIDTH + INT_TYPE +
                COLUMN_WEIXINIMG + " TEXT" + ");";

        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    }

    public final static class BabyDaily {

        private BabyDaily() {

        }

        // scheme
        public static final String SCHEME = "content";

        // Authority
        public static final String AUTHORITY = "com.cmbb.smartkids.babydaily";

        // content uri
        public static final Uri CONTENT_URI = Uri.parse(SCHEME + "://" + AUTHORITY);

        // multiple rows
        public static final String MIME_TYPE_ROWS = "vnd.android.cursor.dir/vnd.com.cmbb" +
                ".smartkids.babydaily";

        // single row
        public static final String MIME_TYPE_SINGLE_ROWS = "vnd.android.cursor.item/vnd.com.cmbb" +
                ".smartkids.babydaily";

        // primary key column name
        public static final String ROW_ID = BaseColumns._ID;

        // table name
        public static final String TABLE_NAME = "BabyDaily";

        // table content URI
        public static final Uri TABLE_CONTENT_URI = Uri.withAppendedPath(CONTENT_URI, TABLE_NAME);

        public static final String COLUMN_BIGIMG = "bigImg";
        public static final String COLUMN_CONTTEXT = "context";
        public static final String COLUMN_DATA = "date";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_SMALLIMG = "smallImg";
        public static final String COLUMN_WEIXINIMG = "weixinImg";
        public static final String COLUMN_TAG = "tag";

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + ROW_ID + " INTEGER PRIMARY KEY," +
                COLUMN_BIGIMG + TEXT_TYPE +
                COLUMN_CONTTEXT + TEXT_TYPE +
                COLUMN_DATA + TEXT_TYPE +
                COLUMN_ID + INT_TYPE +
                COLUMN_SMALLIMG + TEXT_TYPE +
                COLUMN_TAG + INT_TYPE +
                COLUMN_WEIXINIMG + " TEXT" + ");";

        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static final class EredarList implements BaseColumns {

        private EredarList() {

        }

        // scheme
        public static final String SCHEME = "content";

        // Authority
        public static final String AUTHORITY = "com.cmbb.smartkids.eredarlist";

        // content uri
        public static final Uri CONTENT_URI = Uri.parse(SCHEME + "://" + AUTHORITY);

        // multiple rows
        public static final String MIME_TYPE_ROWS = "vnd.android.cursor.dir/vnd.com.cmbb" +
                ".smartkids.eredarlist";

        // single row
        public static final String MIME_TYPE_SINGLE_ROWS = "vnd.android.cursor.item/vnd.com.cmbb" +
                ".smartkids.eredarlist";

        // primary key column name
        public static final String ROW_ID = BaseColumns._ID;

        // table name
        public static final String TABLE_NAME = "EredarList";

        // table content URI
        public static final Uri TABLE_CONTENT_URI = Uri.withAppendedPath(CONTENT_URI, TABLE_NAME);

        public static final String COLUMN_ATTENTION = "attention";
        public static final String COLUMN_AUTHORITY = "authority";
        public static final String COLUMN_BIGIMGHEIGHT = "bigImgHeight";
        public static final String COLUMN_BIGIMGWIDTH = "bigImgWidth";
        public static final String COLUMN_CURRENTUSER = "currentUser";
        public static final String COLUMN_EREDAR = "eredar";
        public static final String COLUMN_EREDARNAME = "eredarName";
        public static final String COLUMN_EREDARRANK = "eredarRank";
        public static final String COLUMN_EREDARTYPE = "eredarType";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_LOGINTIMES = "loginTimes";
        public static final String COLUMN_NIKE = "nike";
        public static final String COLUMN_SMALLIMGHEIGHT = "smallImgHeight";
        public static final String COLUMN_SMALLIMGWIDTH = "smallImgWidth";
        public static final String COLUMN_USERBIGHEADIMG = "userBigHeadImg";
        public static final String COLUMN_USERSMALLHEADIMG = "userSmallHeadImg";
        public static final String COLUMN_USERATATUS = "userStatus";

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + ROW_ID + " INTEGER PRIMARY KEY," +
                COLUMN_ATTENTION + INT_TYPE +
                COLUMN_AUTHORITY + INT_TYPE +
                COLUMN_BIGIMGHEIGHT + INT_TYPE +
                COLUMN_BIGIMGWIDTH + INT_TYPE +
                COLUMN_CURRENTUSER + INT_TYPE +
                COLUMN_EREDAR + INT_TYPE +
                COLUMN_EREDARNAME + TEXT_TYPE +
                COLUMN_EREDARRANK + INT_TYPE +
                COLUMN_EREDARTYPE + INT_TYPE +
                COLUMN_ID + INT_TYPE +
                COLUMN_LOGINTIMES + INT_TYPE +
                COLUMN_NIKE + TEXT_TYPE +
                COLUMN_SMALLIMGHEIGHT + INT_TYPE +
                COLUMN_SMALLIMGWIDTH + INT_TYPE +
                COLUMN_USERBIGHEADIMG + TEXT_TYPE +
                COLUMN_USERSMALLHEADIMG + TEXT_TYPE +
                COLUMN_USERATATUS + " INTEGER" + ");";

        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    }

    /**
     * 首页图片轮播
     * Created by Administrator on 2015/4/21.
     */
    public static final class HomeImgList implements BaseColumns {

        private HomeImgList() {

        }

        // scheme
        public static final String SCHEME = "content";

        // Authority
        public static final String AUTHORITY = "com.cmbb.smartkids.homeimglist";

        // content uri
        public static final Uri CONTENT_URI = Uri.parse(SCHEME + "://" + AUTHORITY);

        // multiple rows
        public static final String MIME_TYPE_ROWS = "vnd.android.cursor.dir/vnd.com.cmbb" +
                ".smartkids.homeimglist";

        // single row
        public static final String MIME_TYPE_SINGLE_ROWS = "vnd.android.cursor.item/vnd.com.cmbb" +
                ".smartkids.homeimglist";

        // primary key column name
        public static final String ROW_ID = BaseColumns._ID;

        // table name
        public static final String TABLE_NAME = "HomeImgList";

        // table content URI
        public static final Uri TABLE_CONTENT_URI = Uri.withAppendedPath(CONTENT_URI, TABLE_NAME);

        public static final String COLUMN_AREATYPE = "areaType";
        public static final String COLUMN_ATTENT = "attent";
        public static final String COLUMN_AUTHORITY = "authority";
        public static final String COLUMN_BIGIMG = "bigImg";
        public static final String COLUMN_BIGIMGHEIGHT = "bigImgHeight";
        public static final String COLUMN_BIGIMGWIDTH = "bigImgWidth";
        public static final String COLUMN_EREDAR = "eredar";
        public static final String COLUMN_EREDARNAME = "eredarName";
        public static final String COLUMN_EREDARANK = "eredarRank";
        public static final String COLUMN_EREDARTYPE = "eredarType";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_LOGINTIMES = "loginTimes";
        public static final String COLUMN_NICK = "nike";
        public static final String COLUMN_PORTCONNECTOR = "portConnector";
        public static final String COLUMN_RELPYS = "relpys";
        public static final String COLUMN_SMALLIMG = "smallImg";
        public static final String COLUMN_SMALLIMGHEIGHE = "smallImgHeight";
        public static final String COLUMN_SMALLIMGWIDTH = "smallImgWidth";
        public static final String COLUMN_STORE = "store";
        public static final String COLUMN_TYPE = "type";
        public static final String COLUMN_USERID = "userId";
        public static final String COLUMN_USERSMALLHEADIMG = "userSmallHeadImg";
        public static final String COLUMN_USERSMALLIMGHEIGHT = "userSmallImgHeight";
        public static final String COLUMN_USERSMALLIMGWIDTH = "userSmallImgWidth";
        public static final String COLUMN_USERSTATUS = "userStatus";
        public static final String COLUMN_VALIDCURRENTUSER = "validCurrentUser";

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + ROW_ID + " INTEGER PRIMARY KEY," +
                COLUMN_AREATYPE + TEXT_TYPE +
                COLUMN_ATTENT + INT_TYPE +
                COLUMN_AUTHORITY + INT_TYPE +
                COLUMN_BIGIMG + TEXT_TYPE +
                COLUMN_BIGIMGHEIGHT + INT_TYPE +
                COLUMN_BIGIMGWIDTH + INT_TYPE +
                COLUMN_EREDAR + INT_TYPE +
                COLUMN_EREDARNAME + TEXT_TYPE +
                COLUMN_EREDARANK + INT_TYPE +
                COLUMN_EREDARTYPE + INT_TYPE +
                COLUMN_ID + INT_TYPE +
                COLUMN_LOGINTIMES + INT_TYPE +
                COLUMN_NICK + TEXT_TYPE +
                COLUMN_PORTCONNECTOR + TEXT_TYPE +
                COLUMN_RELPYS + INT_TYPE +
                COLUMN_SMALLIMG + TEXT_TYPE +
                COLUMN_SMALLIMGHEIGHE + INT_TYPE +
                COLUMN_SMALLIMGWIDTH + INT_TYPE +
                COLUMN_STORE + INT_TYPE +
                COLUMN_TYPE + TEXT_TYPE +
                COLUMN_USERID + INT_TYPE +
                COLUMN_USERSMALLHEADIMG + TEXT_TYPE +
                COLUMN_USERSMALLIMGHEIGHT + INT_TYPE +
                COLUMN_USERSMALLIMGWIDTH + INT_TYPE +
                COLUMN_USERSTATUS + INT_TYPE +
                COLUMN_VALIDCURRENTUSER + " INTEGER" + ");";

        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    /**
     * 萌宝热度
     * Created by Administrator on 2015/4/21.
     */
    public static final class PlateList implements BaseColumns {

        private PlateList() {

        }

        // scheme
        public static final String SCHEME = "content";

        // Authority
        public static final String AUTHORITY = "com.cmbb.smartkids.platelist";

        // content uri
        public static final Uri CONTENT_URI = Uri.parse(SCHEME + "://" + AUTHORITY);

        // multiple rows
        public static final String MIME_TYPE_ROWS = "vnd.android.cursor.dir/vnd.com.cmbb" +
                ".smartkids.platelist";

        // single row
        public static final String MIME_TYPE_SINGLE_ROWS = "vnd.android.cursor.item/vnd.com.cmbb" +
                ".smartkids.platelist";

        // primary key column name
        public static final String ROW_ID = BaseColumns._ID;

        // table name
        public static final String TABLE_NAME = "PlateList";

        // table content URI
        public static final Uri TABLE_CONTENT_URI = Uri.withAppendedPath(CONTENT_URI, TABLE_NAME);

        public static final String COLUMN_BIGIMG = "bigImg";
        public static final String COLUMN_BIGIMGHEIGHT = "bigImgHeight";
        public static final String COLUMN_BIGIMGWIDTH = "bigImgWidth";
        public static final String COLUMN_CONNECTOR = "connector";
        public static final String COLUMN_CONTEXT = "context";
        public static final String COLUMN_COUNT = "count";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_PLATEPARENTTYPE = "plateParentType";
        public static final String COLUMN_SAMALLIMG = "smallImg";
        public static final String COLUMN_SMALLIMGHEIGHT = "smallImgHeight";
        public static final String COLUMN_SMALLIMGWIDTH = "smallImgWidth";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_TYPE = "type";

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + ROW_ID + " INTEGER PRIMARY KEY," +
                COLUMN_BIGIMG + TEXT_TYPE +
                COLUMN_BIGIMGHEIGHT + INT_TYPE +
                COLUMN_BIGIMGWIDTH + INT_TYPE +
                COLUMN_CONNECTOR + TEXT_TYPE +
                COLUMN_CONTEXT + TEXT_TYPE +
                COLUMN_COUNT + INT_TYPE +
                COLUMN_ID + INT_TYPE +
                COLUMN_PLATEPARENTTYPE + TEXT_TYPE +
                COLUMN_SAMALLIMG + TEXT_TYPE +
                COLUMN_SMALLIMGHEIGHT + INT_TYPE +
                COLUMN_SMALLIMGWIDTH + INT_TYPE +
                COLUMN_TITLE + TEXT_TYPE +
                COLUMN_TYPE + " TEXT" + ");";

        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    }

    public static final class ExpertList implements BaseColumns {

        private ExpertList() {

        }

        // scheme
        public static final String SCHEME = "content";

        // Authority
        public static final String AUTHORITY = "com.cmbb.smartkids.expertlist";

        // content uri
        public static final Uri CONTENT_URI = Uri.parse(SCHEME + "://" + AUTHORITY);

        // multiple rows
        public static final String MIME_TYPE_ROWS = "vnd.android.cursor.dir/vnd.com.cmbb" +
                ".smartkids.expertlist";

        // single row
        public static final String MIME_TYPE_SINGLE_ROWS = "vnd.android.cursor.item/vnd.com.cmbb" +
                ".smartkids.expertlist";

        // primary key column name
        public static final String ROW_ID = BaseColumns._ID;

        // table name
        public static final String TABLE_NAME = "ExpertList";

        // table content URI
        public static final Uri TABLE_CONTENT_URI = Uri.withAppendedPath(CONTENT_URI, TABLE_NAME);

        public static final String COLUMN_ABSTRACTING = "abstracting";
        public static final String COLUMN_AUTHORITYNAME = "authorityName";
        public static final String COLUMN_AUTHORITYRELATIONID = "authorityRelationId";
        public static final String COLUMN_BEGOODAT = "beGoodAt";
        public static final String COLUMN_BIGIMGHEIGHT = "bigImgHeight";
        public static final String COLUMN_BIGIMGWIDTH = "bigImgWidth";
        public static final String COLUMN_LOGINTIMES = "loginTimes";
        public static final String COLUMN_REALNAME = "realName";
        public static final String COLUMN_SMALLIMGHEIGHT = "smallImgHeight";
        public static final String COLUMN_SMALLIMGWIDTH = "smallImgWidth";
        public static final String COLUMN_TOKEN = "token";
        public static final String COLUMN_USERBIGHEADIMG = "userBigHeadImg";
        public static final String COLUMN_USERID = "userId";
        public static final String COLUMN_USERSMALLHEADIMG = "userSmallHeadImg";

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + ROW_ID + " INTEGER PRIMARY KEY," +
                COLUMN_ABSTRACTING + TEXT_TYPE +
                COLUMN_AUTHORITYNAME + TEXT_TYPE +
                COLUMN_AUTHORITYRELATIONID + INT_TYPE +
                COLUMN_BEGOODAT + TEXT_TYPE +
                COLUMN_BIGIMGHEIGHT + INT_TYPE +
                COLUMN_BIGIMGWIDTH + INT_TYPE +
                COLUMN_LOGINTIMES + INT_TYPE +
                COLUMN_REALNAME + TEXT_TYPE +
                COLUMN_SMALLIMGHEIGHT + INT_TYPE +
                COLUMN_SMALLIMGWIDTH + INT_TYPE +
                COLUMN_TOKEN + TEXT_TYPE +
                COLUMN_USERBIGHEADIMG + TEXT_TYPE +
                COLUMN_USERID + INT_TYPE +
                COLUMN_USERSMALLHEADIMG + " TEXT" + ");";

        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    }

    public static final class ServeList implements BaseColumns {

        private ServeList() {

        }

        // scheme
        public static final String SCHEME = "content";

        // Authority
        public static final String AUTHORITY = "com.cmbb.smartkids.servelist";

        // content uri
        public static final Uri CONTENT_URI = Uri.parse(SCHEME + "://" + AUTHORITY);

        // multiple rows
        public static final String MIME_TYPE_ROWS = "vnd.android.cursor.dir/vnd.com.cmbb" +
                ".smartkids.servelist";

        // single row
        public static final String MIME_TYPE_SINGLE_ROWS = "vnd.android.cursor.item/vnd.com.cmbb" +
                ".smartkids.servelist";

        // primary key column name
        public static final String ROW_ID = BaseColumns._ID;

        // table name
        public static final String TABLE_NAME = "ServeList";

        // table content URI
        public static final Uri TABLE_CONTENT_URI = Uri.withAppendedPath(CONTENT_URI, TABLE_NAME);

        public static final String COLUMN_ABSTRACTING = "abstracting";
        public static final String COLUMN_AUTHORITYNAME = "authorityName";
        public static final String COLUMN_AUTHORITYRELATIONID = "authorityRelationId";
        public static final String COLUMN_BEGOODAT = "beGoodAt";
        public static final String COLUMN_BIGIMGHEIGHT = "bigImgHeight";
        public static final String COLUMN_BIGIMGWIDTH = "bigImgWidth";
        public static final String COLUMN_LOGINTIMES = "loginTimes";
        public static final String COLUMN_REALNAME = "realName";
        public static final String COLUMN_SMALLIMGHEIGHT = "smallImgHeight";
        public static final String COLUMN_SMALLIMGWIDTH = "smallImgWidth";
        public static final String COLUMN_TOKEN = "token";
        public static final String COLUMN_RONGYUNSERVICEID = "rongyunServiceId";
        public static final String COLUMN_USERBIGHEADIMG = "userBigHeadImg";
        public static final String COLUMN_USERID = "userId";
        public static final String COLUMN_USERSMALLHEADIMG = "userSmallHeadImg";

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + ROW_ID + " INTEGER PRIMARY KEY," +
                COLUMN_ABSTRACTING + TEXT_TYPE +
                COLUMN_AUTHORITYNAME + TEXT_TYPE +
                COLUMN_AUTHORITYRELATIONID + INT_TYPE +
                COLUMN_BEGOODAT + TEXT_TYPE +
                COLUMN_BIGIMGHEIGHT + INT_TYPE +
                COLUMN_BIGIMGWIDTH + INT_TYPE +
                COLUMN_LOGINTIMES + INT_TYPE +
                COLUMN_REALNAME + TEXT_TYPE +
                COLUMN_RONGYUNSERVICEID + TEXT_TYPE +
                COLUMN_SMALLIMGHEIGHT + INT_TYPE +
                COLUMN_SMALLIMGWIDTH + INT_TYPE +
                COLUMN_TOKEN + TEXT_TYPE +
                COLUMN_USERBIGHEADIMG + TEXT_TYPE +
                COLUMN_USERID + INT_TYPE +
                COLUMN_USERSMALLHEADIMG + " TEXT" + ");";

        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    }

    public static final class XmppContacts implements BaseColumns {

        private XmppContacts() {

        }

        // scheme
        public static final String SCHEME = "content";

        // Authority
        public static final String AUTHORITY = "com.cmbb.smartkids.xmppcontacts";

        // content uri
        public static final Uri CONTENT_URI = Uri.parse(SCHEME + "://" + AUTHORITY);

        // multiple rows
        public static final String MIME_TYPE_ROWS = "vnd.android.cursor.dir/vnd.com.cmbb" +
                ".smartkids.xmppcontacts";

        // single row
        public static final String MIME_TYPE_SINGLE_ROWS = "vnd.android.cursor.item/vnd.com.cmbb" +
                ".smartkids.xmppcontacts";

        // primary key column name
        public static final String ROW_ID = BaseColumns._ID;

        // table name
        public static final String TABLE_NAME = "XmppContacts";

        // table content URI
        public static final Uri TABLE_CONTENT_URI = Uri.withAppendedPath(CONTENT_URI, TABLE_NAME);

        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_NICK = "nick";
        public static final String COLUMN_STATUS = "status ";
        public static final String COLUMN_JID = "JID";
        public static final String COLUMN_TYPE = "type";
        public static final String COLUMN_FROM = "from_";
        public static final String COLUMN_AVATAR = "avatar";

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + ROW_ID + " INTEGER PRIMARY KEY," +
                COLUMN_NAME + TEXT_TYPE +
                COLUMN_NICK + TEXT_TYPE +
                COLUMN_STATUS + TEXT_TYPE +
                COLUMN_JID + TEXT_TYPE +
                COLUMN_TYPE + TEXT_TYPE +
                COLUMN_FROM + TEXT_TYPE +
                COLUMN_AVATAR + " BLOB" + ");";

        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    }

    public static final class BabyaGrowthRecord implements BaseColumns {

        private BabyaGrowthRecord() {

        }

        // scheme
        public static final String SCHEME = "content";

        // Authority
        public static final String AUTHORITY = "com.cmbb.smartkids.babyaGrowthRecord";

        // content uri
        public static final Uri CONTENT_URI = Uri.parse(SCHEME + "://" + AUTHORITY);

        // multiple rows
        public static final String MIME_TYPE_ROWS = "vnd.android.cursor.dir/vnd.com.cmbb" +
                ".smartkids.babyaGrowthRecord";

        // single row
        public static final String MIME_TYPE_SINGLE_ROWS = "vnd.android.cursor.item/vnd.com.cmbb" +
                ".smartkids.babyaGrowthRecord";

        // primary key column name
        public static final String ROW_ID = BaseColumns._ID;

        // table name
        public static final String TABLE_NAME = "BabyaGrowthRecord";

        // table content URI
        public static final Uri TABLE_CONTENT_URI = Uri.withAppendedPath(CONTENT_URI, TABLE_NAME);

        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_TAG = "tag";
        public static final String COLUMN_HEIGHT = "height";
        public static final String COLUMN_WEIGHT = "weight";
        public static final String COLUMN_RUNTIME = "runtime";
        public static final String COLUMN_FITNESS = "fitness";
        public static final String COLUMN_TIME = "time";
        public static final String BABYNAME = "babyname";//作为tag标示用于标示用户名
        public static final String BABYDATE = "babydata";//作为tag标示用于标示用户数据

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + ROW_ID + " INTEGER PRIMARY KEY," +
                COLUMN_NAME + TEXT_TYPE +
                COLUMN_TAG + TEXT_TYPE +
                COLUMN_HEIGHT + TEXT_TYPE +
                COLUMN_WEIGHT + TEXT_TYPE +
                COLUMN_RUNTIME + TEXT_TYPE +
                COLUMN_FITNESS + TEXT_TYPE +
                COLUMN_TIME + " TEXT" + ");";
        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    }

    public static final class AttentionPlate implements BaseColumns {

        private AttentionPlate() {

        }

        // scheme
        public static final String SCHEME = "content";

        // Authority
        public static final String AUTHORITY = "com.cmbb.smartkids.attentionplate";

        // content uri
        public static final Uri CONTENT_URI = Uri.parse(SCHEME + "://" + AUTHORITY);

        // multiple rows
        public static final String MIME_TYPE_ROWS = "vnd.android.cursor.dir/vnd.com.cmbb" +
                ".smartkids.attentionplate";

        // single row
        public static final String MIME_TYPE_SINGLE_ROWS = "vnd.android.cursor.item/vnd.com.cmbb" +
                ".smartkids.attentionplate";

        // primary key column name
        public static final String ROW_ID = BaseColumns._ID;

        // table name
        public static final String TABLE_NAME = "AttentionPlate";

        // table content URI
        public static final Uri TABLE_CONTENT_URI = Uri.withAppendedPath(CONTENT_URI, TABLE_NAME);

        public static final String COLUMN_BIGIMG = "bigImg";
        public static final String COLUMN_BIGIMGHEIGHT = "bigImgHeight";
        public static final String COLUMN_BIGIMGWIDTH = "bigImgWidth";
        public static final String COLUMN_CONNECTOR = "connector";
        public static final String COLUMN_CONTEXT = "context";
        public static final String COLUMN_COUNT = "count";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_PLATEPARENTTYPE = "plateParentType";
        public static final String COLUMN_SMALLIMG = "smallImg";
        public static final String COLUMN_SMALLIMGHEIGHT = "smallImgHeight";
        public static final String COLUMN_SMALLIMGWIDTH = "smallImgWidth";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_TYPE = "type";

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + ROW_ID + " INTEGER PRIMARY KEY," +
                COLUMN_BIGIMG + TEXT_TYPE +
                COLUMN_BIGIMGHEIGHT + INT_TYPE +
                COLUMN_BIGIMGWIDTH + INT_TYPE +
                COLUMN_CONNECTOR + TEXT_TYPE +
                COLUMN_CONTEXT + TEXT_TYPE +
                COLUMN_COUNT + INT_TYPE +
                COLUMN_ID + INT_TYPE +
                COLUMN_PLATEPARENTTYPE + TEXT_TYPE +
                COLUMN_SMALLIMG + TEXT_TYPE +
                COLUMN_SMALLIMGHEIGHT + INT_TYPE +
                COLUMN_SMALLIMGWIDTH + INT_TYPE +
                COLUMN_TITLE + TEXT_TYPE +
                COLUMN_TYPE + " TEXT" + ");";

        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    }

    public static final class Message implements BaseColumns {

        private Message() {

        }

        // scheme
        public static final String SCHEME = "content";

        // Authority
        public static final String AUTHORITY = "com.cmbb.smartkids.message";

        // content uri
        public static final Uri CONTENT_URI = Uri.parse(SCHEME + "://" + AUTHORITY);

        // multiple rows
        public static final String MIME_TYPE_ROWS = "vnd.android.cursor.dir/vnd.com.cmbb" +
                ".smartkids.message";

        // single row
        public static final String MIME_TYPE_SINGLE_ROWS = "vnd.android.cursor.item/vnd.com.cmbb" +
                ".smartkids.message";

        // primary key column name
        public static final String ROW_ID = BaseColumns._ID;

        // table name
        public static final String TABLE_NAME = "Message";

        // table content URI
        public static final Uri TABLE_CONTENT_URI = Uri.withAppendedPath(CONTENT_URI, TABLE_NAME);

        public static final String COLUMN_AREATYPE = "areaType";
        public static final String COLUMN_AUTHORITY = "authority";
        public static final String COLUMN_BIGIMGHEIGHT = "bigImgHeight";
        public static final String COLUMN_BIGIMGWIDTH = "bigImgWidth";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_EREDAR = "eredar";
        public static final String COLUMN_EREDARNAME = "eredarName";
        public static final String COLUMN_EREDARRANK = "eredarRank";
        public static final String COLUMN_EREDARTYPE = "eredarType";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_LOGINTIMES = "loginTimes";
        public static final String COLUMN_MESSAGEID = "messageId";
        public static final String COLUMN_NIKE = "nike";
        public static final String COLUMN_PLATETYPE = "plateType";
        public static final String COLUMN_PORTNAME = "portName";
        public static final String COLUMN_PUBLISHUSERID = "publishUserId";
        public static final String COLUMN_REPLYBIGIMG = "replyBigImg";
        public static final String COLUMN_REPLYBIGIMGHEIGHT = "replyBigImgHeight";
        public static final String COLUMN_REPLYBIGIMGWIDTH = "replyBigImgWidth";
        public static final String COLUMN_REPLYCONTEXT = "replyContext";
        public static final String COLUMN_REPLYSMALLIMG = "replySmallImg";
        public static final String COLUMN_REPLYSMALLIMGHEIGHT = "replySmallImgHeight";
        public static final String COLUMN_REPLYSMALLIMGWIDTH = "replySmallImgWidth";
        public static final String COLUMN_SMALLIMGHEIGHT = "smallImgHeight";
        public static final String COLUMN_SMALLIMGWIDTH = "smallImgWidth";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_USERBIGHEADIMG = "userBigHeadImg";
        public static final String COLUMN_USERID = "userId";
        public static final String COLUMN_USERSMALLHEADIMG = "userSmallHeadImg";
        public static final String COLUMN_USERSTATUS = "userStatus";

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + ROW_ID + " INTEGER PRIMARY KEY," +
                COLUMN_AREATYPE + TEXT_TYPE +
                COLUMN_AUTHORITY + INT_TYPE +
                COLUMN_BIGIMGHEIGHT + INT_TYPE +
                COLUMN_BIGIMGWIDTH + INT_TYPE +
                COLUMN_DATE + TEXT_TYPE +
                COLUMN_EREDAR + INT_TYPE +
                COLUMN_EREDARNAME + TEXT_TYPE +
                COLUMN_EREDARRANK + INT_TYPE +
                COLUMN_EREDARTYPE + INT_TYPE +
                COLUMN_ID + INT_TYPE +
                COLUMN_LOGINTIMES + INT_TYPE +
                COLUMN_MESSAGEID + INT_TYPE +
                COLUMN_NIKE + TEXT_TYPE +
                COLUMN_PLATETYPE + TEXT_TYPE +
                COLUMN_PORTNAME + TEXT_TYPE +
                COLUMN_PUBLISHUSERID + INT_TYPE +
                COLUMN_REPLYBIGIMG + TEXT_TYPE +
                COLUMN_REPLYBIGIMGHEIGHT + INT_TYPE +
                COLUMN_REPLYBIGIMGWIDTH + INT_TYPE +
                COLUMN_REPLYCONTEXT + TEXT_TYPE +
                COLUMN_REPLYSMALLIMG + TEXT_TYPE +
                COLUMN_REPLYSMALLIMGHEIGHT + INT_TYPE +
                COLUMN_REPLYSMALLIMGWIDTH + INT_TYPE +
                COLUMN_SMALLIMGHEIGHT + INT_TYPE +
                COLUMN_SMALLIMGWIDTH + INT_TYPE +
                COLUMN_TITLE + TEXT_TYPE +
                COLUMN_USERBIGHEADIMG + TEXT_TYPE +
                COLUMN_USERID + INT_TYPE +
                COLUMN_USERSMALLHEADIMG + TEXT_TYPE +
                COLUMN_USERSTATUS + " INTEGER" + ");";

        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    }

}
