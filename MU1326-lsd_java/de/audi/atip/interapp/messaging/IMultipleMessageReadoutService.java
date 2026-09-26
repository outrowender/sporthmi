/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.messaging;

public interface IMultipleMessageReadoutService {
    public static final int MSG_TYPE_ANY;
    public static final int MSG_TYPE_SMS;
    public static final int MSG_TYPE_MAIL;
    public static final int RESULT_OK;
    public static final int RESULT_ERROR_GENERAL;
    public static final int RESULT_ERROR_ILLEGAL_ARGUMENT;
    public static final int RESULT_ERROR_ILLEGAL_STATE;
    public static final int RESULT_ERROR_NO_MESSAGES;

    default public void requestBeginDialog(boolean bl, int n) {
    }

    default public void requestEndDialog() {
    }

    default public boolean isMessageAvailable() {
    }

    default public void requestNextMessage() {
    }
}

