package com.example;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class MyDaoGenerator {

    private static final String PROJECT_DIR = System.getProperty("user.dir").replace("\\", "/");
    private static final String OUT_DIR = PROJECT_DIR + "/app/src/main/java";

    public static void main(String[] args) throws Exception{

        Schema schema = new Schema(1, "jp.hanatoya.evidence.fcm.android");
        // Call the addTables method which appends our Objects definition to the schema
        Entity noticeDb = schema.addEntity("Notice");
        noticeDb.addIdProperty().primaryKey().autoincrement();
        noticeDb.addStringProperty("message");
        noticeDb.addStringProperty("title");
        noticeDb.addLongProperty("ts").notNull();

        new DaoGenerator().generateAll(schema, OUT_DIR);



    }
}
