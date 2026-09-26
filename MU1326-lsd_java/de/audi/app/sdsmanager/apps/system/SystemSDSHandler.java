/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.system;

import de.audi.app.sdsmanager.apps.ISDSApplication;
import de.audi.app.sdsmanager.apps.PlayPrioPromptCallback;
import de.audi.app.sdsmanager.apps.system.ISystemVBIHandler;
import de.audi.app.sdsmanager.dsi.SpeechTTSHandler;
import de.audi.atip.interapp.ISdsConnectivityService;
import de.audi.tghu.command.CommandListManager;
import org.dsi.ifc.speechrec.NBestList;

public interface SystemSDSHandler
extends ISDSApplication {
    public static final int DIALOG_CONTEXT_MAIN;
    public static final int DIALOG_CONTEXT_ADB;
    public static final int DIALOG_CONTEXT_MEDIA;
    public static final int DIALOG_CONTEXT_MESSAGING;
    public static final int DIALOG_CONTEXT_NAVI;
    public static final int DIALOG_CONTEXT_NAVI_ASIA_CNTW;
    public static final int DIALOG_CONTEXT_NAVI_POI_ONLINE;
    public static final int DIALOG_CONTEXT_PHONE;
    public static final int DIALOG_CONTEXT_RHMI;
    public static final int DIALOG_CONTEXT_TUNER;
    public static final int DIALOG_CONTEXT_NAVI_ASIA_JP;
    public static final int DIALOG_CONTEXT_NAVI_ASIA_KR;

    default public void abortedCurrentRecognition() {
    }

    default public void abortedCurrentPrompt() {
    }

    default public boolean abortCurrentRecognition(byte by, boolean bl, int n) {
    }

    default public boolean abortCurrentPrompt(byte by, boolean bl, int n) {
    }

    default public void setCommandListManager(CommandListManager commandListManager) {
    }

    default public void setSystemVBIHandler(ISystemVBIHandler iSystemVBIHandler) {
    }

    default public void handleIllegalCommand(String string) {
    }

    default public void responseHandleIllegalCommand() {
    }

    default public void responseRequestAudioConnections(boolean bl) {
    }

    default public void responseReleaseAudioConnections(boolean bl) {
    }

    default public void responseRequestGGAsNBestList(int n, NBestList nBestList) {
    }

    default public void setConnectivityService(ISdsConnectivityService iSdsConnectivityService) {
    }

    default public void unsetConnectivityService() {
    }

    default public void systemScreenConnected(int n) {
    }

    default public void systemScreenFadedOut(int n) {
    }

    default public SpeechTTSHandler getTTSHandler() {
    }

    default public byte getAbortingType() {
    }

    default public void setPlayPrioPromptCallback(PlayPrioPromptCallback playPrioPromptCallback) {
    }
}

