/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.AbstractSDSApplicationService;

public interface OnlineService
extends AbstractSDSApplicationService {
    public static final int HELP_TYPE_UNKNOWN = 0;
    public static final int HELP_TYPE_TOPICS = 1;
    public static final int HELP_TYPE_SUBTOPIC = 2;
    public static final byte HELP_ID_TYPE_IDX = 0;
    public static final byte HELP_ID_TYPE_ID = 1;

    public void setRemoteHMIRecognizedID(int var1);

    public void setRemoteHMIGlobalRecognizedID(int var1);

    public void setRemoteHMIHelpRecognizedID(int var1, byte var2);

    public void requestDialogContinuation();

    public void dialogStepFinished();

    public void helpOpened(int var1);

    public void setRemoteHMINavDestFormFinished();

    public void setRemoteHMIGlobalEnter();

    public void setDisclaimerResult(boolean var1);

    public void remoteHMIUpdateHelp();

    public void remoteHMISetRecognizedLineNumber();

    public void remoteHMIResetNavLocationInput();
}

