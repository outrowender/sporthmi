/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.application;

public final class MessagingConstants {
    public static final String MSG_MAIN_LOG = "App.Messaging.Main";
    public static final String MSG_CMDLIST_LOG = "App.Messaging.CmdList";
    public static final String MSG_INTERNAL_DISPATCHER_LOG = "App.Messaging.InternalDispatcher";
    public static final String MSG_INTER_APP_DISPATCHER_LOG = "App.Messaging.InterAppDispatcher";
    public static final String MSG_ADB_CMD_LOG = "App.Messaging.Adb.CmdList";
    public static final String MSG_SEARCH_LOG = "App.Messaging.Search";
    public static final String MSG_APP_NAME = (class$de$audi$app$messaging$core$application$AbstractMsgApplication == null ? (class$de$audi$app$messaging$core$application$AbstractMsgApplication = MessagingConstants.class$("de.audi.app.messaging.core.application.AbstractMsgApplication")) : class$de$audi$app$messaging$core$application$AbstractMsgApplication).getName();
    public static final int MSG_MODULE_ID = 22;
    public static final int DSI_MESSAGING_INSTANCE_ID = 0;
    public static final int DSI_BLUETOOTH_INSTANCE_ID = 0;
    public static final int ACCOUNT_ID_NONE = -1;
    public static final int ACCOUNT_TYPE_ANY = 0;
    public static final int ACCOUNT_TYPE_SMS = 1;
    public static final int ACCOUNT_TYPE_EMAIL = 2;
    public static final int FALSE = 0;
    public static final int TRUE = 1;
    public static final int ADDRESS_DATA_INDEX_BUSINESS = 0;
    public static final int ADDRESS_DATA_INDEX_PRIVATE = 1;
    public static final int RECIPIENT_TYPE_ANY = 0;
    public static final int RECIPIENT_TYPE_TO = 1;
    public static final int RECIPIENT_TYPE_CC = 2;
    public static final int RECIPIENT_TYPE_BCC = 3;
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
}

