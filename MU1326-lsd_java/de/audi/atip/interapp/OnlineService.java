/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.AbstractSDSApplicationService;

public interface OnlineService
extends AbstractSDSApplicationService {
    public static final int HELP_TYPE_UNKNOWN;
    public static final int HELP_TYPE_TOPICS;
    public static final int HELP_TYPE_SUBTOPIC;
    public static final byte HELP_ID_TYPE_IDX;
    public static final byte HELP_ID_TYPE_ID;

    default public void setRemoteHMIRecognizedID(int n) {
    }

    default public void setRemoteHMIGlobalRecognizedID(int n) {
    }

    default public void setRemoteHMIHelpRecognizedID(int n, byte by) {
    }

    default public void requestDialogContinuation() {
    }

    default public void dialogStepFinished() {
    }

    default public void helpOpened(int n) {
    }

    default public void setRemoteHMINavDestFormFinished() {
    }

    default public void setRemoteHMIGlobalEnter() {
    }

    default public void setDisclaimerResult(boolean bl) {
    }

    default public void remoteHMIUpdateHelp() {
    }

    default public void remoteHMISetRecognizedLineNumber() {
    }

    default public void remoteHMIResetNavLocationInput() {
    }
}

