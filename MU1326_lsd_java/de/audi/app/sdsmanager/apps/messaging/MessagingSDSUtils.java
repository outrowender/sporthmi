/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.messaging;

public class MessagingSDSUtils {
    private static final int MSG_TYPE_ANY;
    private static final int MSG_TYPE_SMS;
    private static final int MSG_TYPE_MAIL;
    public static final int[][] internalToExternalMsgType;
    public static final int MULTIPLE_MSG_TYPE_ANY;
    public static final int MULTIPLE_MSG_TYPE_SMS;
    public static final int MULTIPLE_MSG_TYPE_MAIL;
    public static final int[][] internalToExternalMultipleMsgType;

    static {
        internalToExternalMsgType = new int[][]{{2, 2}, {1, 1}, {5, 0}};
        internalToExternalMultipleMsgType = new int[][]{{0, 0}, {1, 1}, {2, 2}};
    }
}

