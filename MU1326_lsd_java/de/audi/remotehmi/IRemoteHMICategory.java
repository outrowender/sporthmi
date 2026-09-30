/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi;

public class IRemoteHMICategory {
    public static final String COMMUNICATION = "communication";
    public static final String INFORMATION = "information";
    public static final String NAVIGATION = "navigation";
    public static final String CAR_REMOTE = "carRemote";
    public static final String ENTERTAINMENT = "entertainment";
    public static final String HOME = "home";
    public static final int COMMUNICATION_CRITERIA = 30000;
    public static final int INFORMATION_CRITERIA = 10000;
    public static final int NAVIGATION_CRITERIA = 20000;
    public static final int CAR_REMOTE_CRITERIA = 50000;
    public static final int ENTERTAINMENT_CRITERIA = 40000;

    public static int getSortCriteriaForCategory(String string) {
        if (string == null || string.length() <= 0) {
            return 0;
        }
        if (string.equals(COMMUNICATION)) {
            return 30000;
        }
        if (string.equals(INFORMATION)) {
            return 10000;
        }
        if (string.equals(NAVIGATION)) {
            return 20000;
        }
        if (string.equals(CAR_REMOTE)) {
            return 50000;
        }
        if (string.equals(ENTERTAINMENT)) {
            return 40000;
        }
        return 10000;
    }
}

