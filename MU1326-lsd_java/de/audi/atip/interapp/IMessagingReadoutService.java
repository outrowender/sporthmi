/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.AbstractSDSApplicationService;

public interface IMessagingReadoutService
extends AbstractSDSApplicationService {
    public static final int MSG_TYPE_ANY;
    public static final int MSG_TYPE_SMS;
    public static final int MSG_TYPE_MAIL;
    public static final int SELECT_LEVEL_ACCOUNT_LIST;
    public static final int SELECT_LEVEL_MESSAGE_LIST;
    public static final int SELECT_LEVEL_CURRENT_MSG;
    public static final int RESULT_OK;
    public static final int RESULT_ERROR_GENERAL;
    public static final int RESULT_ERROR_ILLEGAL_ARGUMENT;
    public static final int RESULT_ERROR_ILLEGAL_STATE;

    default public void requestBeginDialog(boolean bl, int n, int n2) {
    }

    default public void requestEndDialog() {
    }

    default public void requestReadoutMessage() {
    }

    default public String requestReadoutText() {
    }

    default public void requestBeginLastSelectedEntry() {
    }
}

