/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.application;

public final class MessagingConstants {
    public static final String MSG_MAIN_LOG;
    public static final String MSG_CMDLIST_LOG;
    public static final String MSG_INTERNAL_DISPATCHER_LOG;
    public static final String MSG_INTER_APP_DISPATCHER_LOG;
    public static final String MSG_ADB_CMD_LOG;
    public static final String MSG_SEARCH_LOG;
    public static final String MSG_APP_NAME;
    public static final int MSG_MODULE_ID;
    public static final int DSI_MESSAGING_INSTANCE_ID;
    public static final int DSI_BLUETOOTH_INSTANCE_ID;
    public static final int ACCOUNT_ID_NONE;
    public static final int ACCOUNT_TYPE_ANY;
    public static final int ACCOUNT_TYPE_SMS;
    public static final int ACCOUNT_TYPE_EMAIL;
    public static final int FALSE;
    public static final int TRUE;
    public static final int ADDRESS_DATA_INDEX_BUSINESS;
    public static final int ADDRESS_DATA_INDEX_PRIVATE;
    public static final int RECIPIENT_TYPE_ANY;
    public static final int RECIPIENT_TYPE_TO;
    public static final int RECIPIENT_TYPE_CC;
    public static final int RECIPIENT_TYPE_BCC;
    static /* synthetic */ Class class$de$audi$app$messaging$core$application$AbstractMsgApplication;

    private MessagingConstants() {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        MSG_APP_NAME = (class$de$audi$app$messaging$core$application$AbstractMsgApplication == null ? (class$de$audi$app$messaging$core$application$AbstractMsgApplication = MessagingConstants.class$("de.audi.app.messaging.core.application.AbstractMsgApplication")) : class$de$audi$app$messaging$core$application$AbstractMsgApplication).getName();
    }
}

