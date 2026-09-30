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
import de.audi.remotehmi.util.LogAppender;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.mib.swdiagnosis.online.OnlineDiag;

public final class Online
implements HMIApplication {
    public static final int MODULE_ID = 23;
    private static Online instance = new Online();
    private static final String LOG_NAME_MAIN = "App.Online.Main";
    private static final String LOG_NAME_REMOTEHMI = "App.Online.RemoteHMI";
    private static final String LOG_NAME_REMOTEHMI_INTERPRETER = "App.Online.RemoteHMI.Interpreter";
    private static final String LOG_NAME_REMOTEHMI_SPEECH = "App.Online.RemoteHMI.Speech";
    private static final String LOG_NAME_OPERATORCALL = "App.Online.OperatorCall";
    private static final String LOG_NAME_PRESETS = "App.Online.Presets";
    private static final String LOG_NAME_BUNDLED_CONNECTIVITY = "App.Online.BundledConnectivity";
    public static boolean OVERRIDE_CODING_REMOTEHMI = false;
    public static boolean OVERRIDE_CODING_REMOTEHMI_SDS = false;
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
        this.mainLogChannel = iFrameworkAccess.getLogChannel(LOG_NAME_MAIN);
        this.remoteHmiLogChannel = iFrameworkAccess.getLogChannel(LOG_NAME_REMOTEHMI);
        this.remoteHmiInterpreterLogChannel = iFrameworkAccess.getLogChannel(LOG_NAME_REMOTEHMI_INTERPRETER);
        this.remoteHmiSpeechLogChannel = iFrameworkAccess.getLogChannel(LOG_NAME_REMOTEHMI_SPEECH);
        this.operatorCallLogChannel = iFrameworkAccess.getLogChannel(LOG_NAME_OPERATORCALL);
        this.presetsLogChannel = iFrameworkAccess.getLogChannel(LOG_NAME_PRESETS);
        this.bundledConnectivityLogChannel = iFrameworkAccess.getLogChannel(LOG_NAME_BUNDLED_CONNECTIVITY);
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

    public int getId() {
        return 23;
    }

    public ButtonModelApp getVirtualButton(int n) {
        this.getLogChannel().log(10000000, "Online#getVirtualButton() keyCode: %1", (long)n);
        if (n == 13) {
            return this.frameworkAccess.getHMIService().getButtonModel(2301256);
        }
        return null;
    }

    public void popupHidden(int n, int n2) {
        this.getLogChannel().log(10000000, "Online#popupHidden()");
    }

    public void popupRemoved(int n, int n2) {
        this.getLogChannel().log(10000000, "Online#popupRemoved()");
    }

    public void popupVisible(int n, int n2) {
        this.getLogChannel().log(10000000, "Online#popupVisible()");
    }

    public void screenHidden(int n, int n2) {
        this.getLogChannel().log(10000000, "Online#screenHidden() %1", (long)n);
    }

    public void screenVisible(int n, int n2) {
        this.getLogChannel().log(10000000, "Online#screenVisible() %1", (long)n);
    }

    public void screenFadedOut(int n, int n2) {
        this.getLogChannel().log(10000000, "Online#screenFadedOut() %1", (long)n);
    }

    public void screenConnected(int n, int n2) {
        this.getLogChannel().log(10000000, "Online#screenConnected() %1", (long)n);
        if (this.remoteHMIService == null) {
            this.getLogChannel().log(100000, "Online#screenConnected() remoteHmiService is null");
            return;
        }
        this.remoteHMIService.execute(new AbstractRemoteHMITask("screen-connected", LogAppender.Factory.fromInt(n)){

            public void run() {
                Online.this.remoteHMIService.unlockModelGroup();
            }
        });
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
}

