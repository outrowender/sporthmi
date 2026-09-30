/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.messaging;

public interface IMultipleMessageReadoutService {
    public static final int MSG_TYPE_ANY = 0;
    public static final int MSG_TYPE_SMS = 1;
    public static final int MSG_TYPE_MAIL = 2;
    public static final int RESULT_OK = 0;
    public static final int RESULT_ERROR_GENERAL = 1;
    public static final int RESULT_ERROR_ILLEGAL_ARGUMENT = 2;
    public static final int RESULT_ERROR_ILLEGAL_STATE = 3;
    public static final int RESULT_ERROR_NO_MESSAGES = 4;

    public void requestBeginDialog(boolean var1, int var2);

    public void requestEndDialog();

    public boolean isMessageAvailable();

    public void requestNextMessage();
}

