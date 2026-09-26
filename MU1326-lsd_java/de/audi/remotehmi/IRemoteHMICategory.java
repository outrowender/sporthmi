/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi;

public class IRemoteHMICategory {
    public static final String COMMUNICATION;
    public static final String INFORMATION;
    public static final String NAVIGATION;
    public static final String CAR_REMOTE;
    public static final String ENTERTAINMENT;
    public static final String HOME;
    public static final int COMMUNICATION_CRITERIA;
    public static final int INFORMATION_CRITERIA;
    public static final int NAVIGATION_CRITERIA;
    public static final int CAR_REMOTE_CRITERIA;
    public static final int ENTERTAINMENT_CRITERIA;

    public static int getSortCriteriaForCategory(String string) {
        if (string == null || string.length() <= 0) {
            return 0;
        }
        if (string.equals("communication")) {
            return 30000;
        }
        if (string.equals("information")) {
            return 10000;
        }
        if (string.equals("navigation")) {
            return 20000;
        }
        if (string.equals("carRemote")) {
            return 1354956800;
        }
        if (string.equals("entertainment")) {
            return 1083965440;
        }
        return 10000;
    }
}

