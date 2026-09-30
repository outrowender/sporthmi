/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.messaging;

public class MessagingSDSUtils {
    private static final int MSG_TYPE_ANY = 5;
    private static final int MSG_TYPE_SMS = 1;
    private static final int MSG_TYPE_MAIL = 2;
    public static final int[][] internalToExternalMsgType = new int[][]{{2, 2}, {1, 1}, {5, 0}};
    public static final int MULTIPLE_MSG_TYPE_ANY = 0;
    public static final int MULTIPLE_MSG_TYPE_SMS = 1;
    public static final int MULTIPLE_MSG_TYPE_MAIL = 2;
    public static final int[][] internalToExternalMultipleMsgType = new int[][]{{0, 0}, {1, 1}, {2, 2}};
}

