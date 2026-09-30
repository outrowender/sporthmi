/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr;

public interface OnlineServiceRegistrationConstants {
    public static final int ONLINE_TRAFFIC_GROUP = 0;
    public static final long GET_SERVICE_LIST_DELAY_TIME = 1000L;
    public static final String MY_AUDI_AUTHENTICATION_IDENTIFIER = "AudiT21Realm";
    public static final int MY_AUDI_SECURE_KEY_MAX_LENGTH = 64;

    public static interface AUTH_HMI_STATES {
        public static final int OK = 0;
        public static final int WRONG_PASSWORD = 1;
        public static final int NO_ACCOUNT = 2;
        public static final int BACKEND_ERROR = 3;
        public static final int NO_CONNECTION = 4;
        public static final int COMPONENT_ERROR = 5;
        public static final int ERROR_GENERIC = 6;
        public static final int CREATE_USER_ERROR = 2;
        public static final int CREATE_USER_OK = 1;
        public static final int CREAT_USER_NOT = 0;
    }
}

