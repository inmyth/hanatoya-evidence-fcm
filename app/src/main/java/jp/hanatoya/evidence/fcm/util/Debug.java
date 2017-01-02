package jp.hanatoya.evidence.fcm.util;

import jp.hanatoya.evidence.fcm.repo.Notice;
import jp.hanatoya.evidence.fcm.repo.NoticeDao;

/**
 * Created by desktop on 2017/01/03.
 */

public class Debug {


    public static void addLogs(NoticeDao dao){
        Notice n1 = new Notice();
        n1.setMessage("Plant needs water");
        n1.setTs(1483376573);

        dao.insert(n1);

        Notice n2 = new Notice();
        n2.setMessage("Temperature drops below 20");
        n2.setTs(1483290173);

        dao.insert(n2);



    }
}
