/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.online.OnlineDiag
 */
package de.audi.tghu.online.app;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIApplication;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.util.LogAppender$Factory;
import de.audi.tghu.online.app.Online$1;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.mib.swdiagnosis.online.OnlineDiag;

public final class Online
implements HMIApplication {
    public static final int MODULE_ID;
    private static Online instance;
    private static final String LOG_NAME_MAIN;
    private static final String LOG_NAME_REMOTEHMI;
    private static final String LOG_NAME_REMOTEHMI_INTERPRETER;
    private static final String LOG_NAME_REMOTEHMI_SPEECH;
    private static final String LOG_NAME_OPERATORCALL;
    private static final String LOG_NAME_PRESETS;
    private static final String LOG_NAME_BUNDLED_CONNECTIVITY;
    public static boolean OVERRIDE_CODING_REMOTEHMI;
    public static boolean OVERRIDE_CODING_REMOTEHMI_SDS;
    private LogChannel mainLogChannel = null;
    private LogChannel remoteHmiLogChannel = null;
    private LogChannel remoteHmiInterpreterLogChannel = null;
    private LogChannel remoteHmiSpeechLogChannel = null;
    private LogChannel operatorCallLogChannel = null;
    private LogChannel presetsLogChannel = null;
    private LogChannel bundledConnectivityLogChannel = null;
    private IFrameworkAccess frameworkAccess = null;
    private OnlineDiag onlineDiag;
    private RemoteHMIService remoteHMIService;

    public static Online getInstance() {
        return instance;
    }

    private Online() {
    }

    public void initialize(IFrameworkAccess iFrameworkAccess) {
        this.frameworkAccess = iFrameworkAccess;
        this.mainLogChannel = iFrameworkAccess.getLogChannel("App.Online.Main");
        this.remoteHmiLogChannel = iFrameworkAccess.getLogChannel("App.Online.RemoteHMI");
        this.remoteHmiInterpreterLogChannel = iFrameworkAccess.getLogChannel("App.Online.RemoteHMI.Interpreter");
        this.remoteHmiSpeechLogChannel = iFrameworkAccess.getLogChannel("App.Online.RemoteHMI.Speech");
        this.operatorCallLogChannel = iFrameworkAccess.getLogChannel("App.Online.OperatorCall");
        this.presetsLogChannel = iFrameworkAccess.getLogChannel("App.Online.Presets");
        this.bundledConnectivityLogChannel = iFrameworkAccess.getLogChannel("App.Online.BundledConnectivity");
    }

    public LogChannel getLogChannel() {
        return this.mainLogChannel;
    }

    public LogChannel getRemoteHMILogChannel() {
        return this.remoteHmiLogChannel;
    }

    public LogChannel getOperatorCallLogChannel() {
        return this.operatorCallLogChannel;
    }

    public LogChannel getRemoteHMIInterpreterLogChannel() {
        return this.remoteHmiInterpreterLogChannel;
    }

    public LogChannel getPresetsLogChannel() {
        return this.presetsLogChannel;
    }

    public LogChannel getBundledConnectivityLogChannel() {
        return this.bundledConnectivityLogChannel;
    }

    @Override
    public int getId() {
        return 23;
    }

    @Override
    public ButtonModelApp getVirtualButton(int n) {
        this.getLogChannel().log(-2137614336, "Online#getVirtualButton() keyCode: %1", (long)n);
        if (n == 13) {
            return this.frameworkAccess.getHMIService().getButtonModel(1209869056);
        }
        return null;
    }

    @Override
    public void popupHidden(int n, int n2) {
        this.getLogChannel().log(-2137614336, "Online#popupHidden()");
    }

    @Override
    public void popupRemoved(int n, int n2) {
        this.getLogChannel().log(-2137614336, "Online#popupRemoved()");
    }

    @Override
    public void popupVisible(int n, int n2) {
        this.getLogChannel().log(-2137614336, "Online#popupVisible()");
    }

    @Override
    public void screenHidden(int n, int n2) {
        this.getLogChannel().log(-2137614336, "Online#screenHidden() %1", (long)n);
    }

    @Override
    public void screenVisible(int n, int n2) {
        this.getLogChannel().log(-2137614336, "Online#screenVisible() %1", (long)n);
    }

    @Override
    public void screenFadedOut(int n, int n2) {
        this.getLogChannel().log(-2137614336, "Online#screenFadedOut() %1", (long)n);
    }

    @Override
    public void screenConnected(int n, int n2) {
        this.getLogChannel().log(-2137614336, "Online#screenConnected() %1", (long)n);
        if (this.remoteHMIService == null) {
            this.getLogChannel().log(-1601830656, "Online#screenConnected() remoteHmiService is null");
            return;
        }
        this.remoteHMIService.execute(new Online$1(this, "screen-connected", LogAppender$Factory.fromInt(n)));
    }

    public IFrameworkAccess getFramework() {
        return this.frameworkAccess;
    }

    public OnlineDiag getOnlineDiag() {
        return this.onlineDiag;
    }

    public void setOnlineDiag(OnlineDiag onlineDiag) {
        this.onlineDiag = onlineDiag;
    }

    public void uninitialize() {
        this.frameworkAccess = null;
        this.mainLogChannel = null;
        this.remoteHmiLogChannel = null;
    }

    public LogChannel getLogChannelRemoteHMISpeech() {
        return this.remoteHmiSpeechLogChannel;
    }

    public boolean isRemoteHMICoded() {
        return OVERRIDE_CODING_REMOTEHMI || this.frameworkAccess.getSysConst(474) == 1;
    }

    public boolean isEniCoded() {
        return this.frameworkAccess.getSysConst(4252) == 1;
    }

    public boolean isRemoteHMISDSCoded() {
        return true;
    }

    public boolean isBrowserOnlineServicesCoded() {
        return this.frameworkAccess.getSysConst(487) == 1;
    }

    public void setRemoteHMIService(RemoteHMIService remoteHMIService) {
        this.remoteHMIService = remoteHMIService;
    }

    static /* synthetic */ RemoteHMIService access$000(Online online) {
        return online.remoteHMIService;
    }

    static {
        instance = new Online();
        OVERRIDE_CODING_REMOTEHMI = false;
        OVERRIDE_CODING_REMOTEHMI_SDS = false;
    }
}

