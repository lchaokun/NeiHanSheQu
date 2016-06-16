package com.example.chaokun.neihanduanzi.utils;

import android.content.Context;

import com.example.chaokun.neihanduanzi.bean.DataBase;
import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.db.sqlite.Selector;
import com.lidroid.xutils.exception.DbException;

/**
 * Created by linchaokun on 2016/6/1.
 */
public class DataBaseCrete {
    // 数据库名称
    public static final String DATABASE_NAME = "neihantu";
    // 数据库版本号
    public static final int DATABASE_VERSION = 1;

    //无聊图表名
    public static final String PICTURE_TABLE_NAME = "PICTURE_CACHE";

    private DbUtils db;

    public DataBaseCrete(Context context) throws DbException {
        DbUtils.DaoConfig config = new DbUtils.DaoConfig(context);

        config.setDbName(DATABASE_NAME); //db名

        config.setDbVersion(1);  //db版本

        db = DbUtils.create(config);//db还有其他的一些构造方法，比如含有更新表版本的监听器的

        db.createTableIfNotExist(DataBase.class); //创建一个表User
//        db.configAllowTransaction(true);//开启事务

//        db.save(user);//在表中保存一个user对象。最初执行保存动作时，也会创建User表
    }


    /**
     * 保存
     * @param dataBase
     */
    public void sava(DataBase dataBase) throws DbException {
        db.save(dataBase);
    }

    /**
     * 查找
     */
    public DataBase findPage(int page,int menu) throws DbException {
        DataBase dataBase = db.findFirst(Selector.from(DataBase.class).where("page","=",page).and("MenuNumber","=",menu));
        return dataBase;
    }

    /**
     * 删除
     */
    public void delete(int page,int menu) throws DbException {
        DataBase dataBase = db.findFirst(Selector.from(DataBase.class).where("page","=",page).and("MenuNumber","=",menu));
        if(dataBase!=null){
            db.delete(dataBase);
        }

    }
}
