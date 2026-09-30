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
    public static final int DIALOG_CONTEXT_MAIN = 0;
    public static final int DIALOG_CONTEXT_ADB = 1;
    public static final int DIALOG_CONTEXT_MEDIA = 2;
    public static final int DIALOG_CONTEXT_MESSAGING = 3;
    public static final int DIALOG_CONTEXT_NAVI = 4;
    public static final int DIALOG_CONTEXT_NAVI_ASIA_CNTW = 5;
    public static final int DIALOG_CONTEXT_NAVI_POI_ONLINE = 6;
    public static final int DIALOG_CONTEXT_PHONE = 7;
    public static final int DIALOG_CONTEXT_RHMI = 8;
    public static final int DIALOG_CONTEXT_TUNER = 9;
    public static final int DIALOG_CONTEXT_NAVI_ASIA_JP = 10;
    public static final int DIALOG_CONTEXT_NAVI_ASIA_KR = 11;

    public void abortedCurrentRecognition();

    public void abortedCurrentPrompt();

    public boolean abortCurrentRecognition(byte var1, boolean var2, int var3);

    public boolean abortCurrentPrompt(byte var1, boolean var2, int var3);

    public void setCommandListManager(CommandListManager var1);

    public void setSystemVBIHandler(ISystemVBIHandler var1);

    public void handleIllegalCommand(String var1);

    public void responseHandleIllegalCommand();

    public void responseRequestAudioConnections(boolean var1);

    public void responseReleaseAudioConnections(boolean var1);

    public void responseRequestGGAsNBestList(int var1, NBestList var2);

    public void setConnectivityService(ISdsConnectivityService var1);

    public void unsetConnectivityService();

    public void systemScreenConnected(int var1);

    public void systemScreenFadedOut(int var1);

    public SpeechTTSHandler getTTSHandler();

    public byte getAbortingType();

    public void setPlayPrioPromptCallback(PlayPrioPromptCallback var1);
}

