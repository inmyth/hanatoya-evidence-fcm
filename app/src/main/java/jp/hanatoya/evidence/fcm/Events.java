package jp.hanatoya.evidence.fcm;

/**
 * Created by desktop on 2016/12/31.
 */

public class Events {

    public static class GotFCM{
        public        String message;

        public GotFCM(String message) {
            this.message = message;
        }
    }
}
