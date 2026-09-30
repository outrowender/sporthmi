/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.AbstractSDSApplicationService;

public interface IMessagingReadoutService
extends AbstractSDSApplicationService {
    public static final int MSG_TYPE_ANY = 0;
    public static final int MSG_TYPE_SMS = 1;
    public static final int MSG_TYPE_MAIL = 2;
    public static final int SELECT_LEVEL_ACCOUNT_LIST = 0;
    public static final int SELECT_LEVEL_MESSAGE_LIST = 1;
    public static final int SELECT_LEVEL_CURRENT_MSG = 2;
    public static final int RESULT_OK = 0;
    public static final int RESULT_ERROR_GENERAL = 1;
    public static final int RESULT_ERROR_ILLEGAL_ARGUMENT = 2;
    public static final int RESULT_ERROR_ILLEGAL_STATE = 3;

    public void requestBeginDialog(boolean var1, int var2, int var3);

    public void requestEndDialog();

    public void requestReadoutMessage();

    public String requestReadoutText();

    public void requestBeginLastSelectedEntry();
}

