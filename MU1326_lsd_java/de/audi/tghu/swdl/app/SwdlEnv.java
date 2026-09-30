/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app;

import de.audi.atip.base.IAppSystem;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.engineering.fsc.IFSCService;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.hmi.modelaccess.sysconst.SysConstModelApp;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceSystem;
import de.audi.atip.job.JobLogger;
import de.audi.atip.log.LogChannel;
import de.audi.atip.msg.MsgDistributor;
import de.audi.atip.storage.IStorageAccess;
import de.audi.atip.sysapp.SpeedThresholdListener;
import de.audi.tghu.swdl.app.AbstractSwdlTextFactory;
import de.audi.tghu.swdl.app.BulkCopyAccess;
import de.audi.tghu.swdl.app.SwdlModels;
import de.audi.tghu.swdl.app.customer.CustomerDLState;
import de.audi.tghu.swdl.app.hmiswitcher.HMISwitcher;
import de.esolutions.fw.util.commons.job.DispatcherBase;

public final class SwdlEnv {
    private final IFrameworkAccess framework;
    private final SwdlModels swdlModels;
    private final AbstractSwdlTextFactory textFactory;
    private final BulkCopyAccess bulkCopyAccess;
    private HMISwitcher hmiSwitcher;
    private final LogChannel logDSI;
    private final LogChannel logHMI;
    private final LogChannel logMain;
    private final LogChannel logCustomer;
    private final LogChannel logUota;
    private IFSCService fscService;
    private boolean swdlHMIActive;
    private boolean swdlSummaryEntered;
    private final MsgDistributor msgDistributor;
    private volatile CombiBAPServiceSystem combiBAPServiceSystem;
    static /* synthetic */ Class class$org$dsi$ifc$swdldeviceinfo$DSISwdlDeviceInfo;
    static /* synthetic */ Class class$org$dsi$ifc$swdllogging$DSISwdlLogging;
    static /* synthetic */ Class class$org$dsi$ifc$swdlprogress$DSISwdlProgress;
    static /* synthetic */ Class class$org$dsi$ifc$swdlselection$DSISwdlSelection;
    static /* synthetic */ Class class$org$dsi$ifc$uota$DSIUotA;

    public SwdlEnv(IFrameworkAccess iFrameworkAccess, AbstractSwdlTextFactory abstractSwdlTextFactory) {
        this.logDSI = iFrameworkAccess.getLogChannel("App.Swdl.DSI");
        this.logHMI = iFrameworkAccess.getLogChannel("App.Swdl.HMI");
        this.logMain = iFrameworkAccess.getLogChannel("App.Swdl.Main");
        this.logCustomer = iFrameworkAccess.getLogChannel("App.Swdl.Customer");
        this.logUota = iFrameworkAccess.getLogChannel("App.Swdl.Uota");
        this.framework = iFrameworkAccess;
        this.swdlModels = new SwdlModels(this);
        this.textFactory = abstractSwdlTextFactory;
        this.textFactory.setSwdlEnv(this);
        this.swdlHMIActive = false;
        this.swdlSummaryEntered = false;
        this.bulkCopyAccess = new BulkCopyAccess(this);
        this.hmiSwitcher = null;
        this.msgDistributor = iFrameworkAccess.getMsgDistrib();
    }

    public void enterSwdl(int n) {
        if (this.framework != null && this.framework.isPGen2() && this.framework.isSimulator()) {
            this.sleep(1500L);
        }
        this.getLogMain().log(1000000, "[SwdlEnv] enterSwdl");
        this.setSwdlHMIActive(true);
        this.getLogMain().log(10000000, "[SwdlEnv] enterSwdl: clear fall through flag");
        this.getSwdlModels().getRSESwdlJoinedChoice().setValue(0);
        this.setEngineeringDownloadActive(true);
        this.sendMessage(8);
    }

    public void exitSwdl() {
        this.getLogMain().log(1000000, "[SwdlEnv] exitSwdl");
        this.sendMessage(9);
        this.setEngineeringDownloadActive(false);
        this.setSwdlHMIActive(false);
    }

    public void registerSpeedThresholdListener(SpeedThresholdListener speedThresholdListener, int n) {
        this.getFramework().getSysApp().registerSpeedThresholdListener(speedThresholdListener, n);
    }

    public boolean isSwdlHMIActive() {
        return this.swdlHMIActive;
    }

    public void setSwdlHMIActive(boolean bl) {
        this.swdlHMIActive = bl;
    }

    public LogChannel getLogCustomer() {
        return this.logCustomer;
    }

    public LogChannel getLogDSI() {
        return this.logDSI;
    }

    public LogChannel getLogHMI() {
        return this.logHMI;
    }

    public LogChannel getLogMain() {
        return this.logMain;
    }

    public LogChannel getLogUota() {
        return this.logUota;
    }

    public SwdlModels getSwdlModels() {
        return this.swdlModels;
    }

    public AbstractSwdlTextFactory getTextFactory() {
        return this.textFactory;
    }

    public long getKombiTime() {
        return this.getFramework().getKombiTime();
    }

    private IFrameworkAccess getFramework() {
        return this.framework;
    }

    public BulkCopyAccess getBulkCopyAccess() {
        return this.bulkCopyAccess;
    }

    public HMISwitcher getHMISwitcher() {
        return this.hmiSwitcher;
    }

    public DispatcherBase createDispatcher(String string, LogChannel logChannel) {
        return this.getFramework().getDispatcherManager().createDispatcher(string, new JobLogger(logChannel));
    }

    public IStorageAccess getStorageMgr() {
        return this.framework.getStorageMgr();
    }

    public void setHMISwitcher(HMISwitcher hMISwitcher) {
        this.hmiSwitcher = hMISwitcher;
    }

    public CustomerDLState getCustomerDLState() {
        if (this.hmiSwitcher != null) {
            return this.hmiSwitcher.getCustomerDLState();
        }
        return null;
    }

    public void removeCustomerDLState() {
        if (this.hmiSwitcher != null) {
            this.hmiSwitcher.removeCustomerDLState();
        }
    }

    public int getTerminalId() {
        return this.isFrontMU() ? 0 : 5;
    }

    public boolean isFrontMU() {
        return this.getFramework().isFrontMU();
    }

    public IAppSystem getVariantAppSystem() {
        return this.framework.getSysApp().getVariantAppSystem();
    }

    public void setCustProgressIconVisible(boolean bl) {
        if (bl) {
            this.getSwdlModels().getSummaryDownloadAndInstallProgressRange().setStatus(0);
        } else if (!this.isUotaNavDBMergeProcessNeeded() || !this.getHMISwitcher().getUOTAController().isMapIntegrationInProgress()) {
            this.getSwdlModels().getSummaryDownloadAndInstallProgressRange().setStatus(1);
        }
    }

    public IFSCService getFscService() {
        this.getLogMain().log(10000000, "SwdlEnv gets FscService %1", (Object)this.fscService);
        return this.fscService;
    }

    public void setFscService(IFSCService iFSCService) {
        this.getLogMain().log(10000000, "SwdlEnv sets FscService %1", (Object)iFSCService);
        this.fscService = iFSCService;
    }

    public void setCombiBAPServiceSystem(CombiBAPServiceSystem combiBAPServiceSystem) {
        this.getLogMain().log(10000000, "[SwdlEnv].setCombiBAPServiceSystem(%1)", (Object)combiBAPServiceSystem);
        this.combiBAPServiceSystem = combiBAPServiceSystem;
        if (null != combiBAPServiceSystem) {
            if (!this.isCustomerDownloadActive()) {
                combiBAPServiceSystem.updateCustomerDownloadState(0, 0);
            } else if (3 != this.getSwdlModels().getCustomerProgressStateChoice().getValue()) {
                combiBAPServiceSystem.updateCustomerDownloadState(0, 0);
            } else {
                combiBAPServiceSystem.updateCustomerDownloadState(1, this.getSwdlModels().getSummaryDownloadAndInstallProgressRange().getValue());
            }
        }
    }

    public CombiBAPServiceSystem getCombiBAPServiceSystem() {
        return this.combiBAPServiceSystem;
    }

    public IHMIServiceApp getHMIService() {
        return this.getFramework().getHmiServiceApp();
    }

    public MsgDistributor getMsgDistributor() {
        return this.msgDistributor;
    }

    public void setExtendedPowerState(int n) {
        if (this.isFrontMU()) {
            this.getFramework().getPowerMgr().setExtendedPowerState(n, 0);
        } else {
            this.getFramework().getPowerMgr().setExtendedPowerState(n, 3);
            this.getFramework().getPowerMgr().setExtendedPowerState(n, 4);
        }
    }

    public void executeInUtilThread(Runnable runnable) {
        this.getFramework().getUtilThreadPool().execute(runnable);
    }

    public String getCurrentHmiLanguage() {
        return this.getFramework().getLanguageMgr().getCurrentLanguage("LANG_COMPONENT_HMI").getLanguageCode();
    }

    public void logStartupEvent(String string) {
        this.getFramework().getStartupMgr().logStartupEvent(string);
    }

    public boolean isCustomerDownloadActive() {
        return this.getFramework().getSysApp().isCustomerDownloadActive();
    }

    public boolean isResetDriverActiv() {
        return 0 != this.getHMIService().getChoiceModel(543).getValue();
    }

    public boolean isEngineeringDownloadActive() {
        return this.getFramework().getSysApp().isEngineeringDownloadActive();
    }

    public boolean isRebootToDownload() {
        return this.getFramework().getStartupMgr().isRebootToDownload();
    }

    public void storeSysConstsForSWDLReboot() {
        this.getFramework().getSysApp().storeSysConstsForSWDLReboot();
    }

    public void storeDummySwdlInfo() {
        this.getLogMain().log(1000000, "[SwdlEnv].storeDummySwdlInfo(): store SWDL_DISPLAY_MEDIA=-1, to display the screen title 'Diagnosis Tester'");
        this.getStorageManager().setString(257, 5003, "-1");
    }

    public void storeSwdlInfo(int n, String string) {
        this.getLogMain().log(10000000, "[SwdlEnv].storeSwdlInfo(%2,%1)", (Object)string, (long)n);
        this.getStorageManager().setString(257, 5003, Integer.toString(n));
        this.getStorageManager().setString(257, 5006, string);
        this.getFramework().getSysConstManager().storeSwdlCopy();
    }

    public void cleanSwdlCopy() {
        this.getLogMain().log(10000000, "[SwdlEnv].cleanSwdlCopy()");
        this.getFramework().getSysConstManager().clearSwdlCopy();
    }

    public void readSwdlInfo() {
        this.getLogMain().log(10000000, "[SwdlEnv].readSwdlInfo()");
        String string = this.getStorageManager().getString(257, 5003, "");
        if (string != null && string.length() > 0) {
            this.getSwdlModels().getMediumChoice().setValue(Integer.parseInt(string));
        } else {
            this.getLogMain().log(10000, "[SwdlEnv].readSwdlInfo(): value of SWDL_DISPLAY_MEDIA is undefined.");
        }
        String string2 = this.getStorageManager().getString(257, 5006, "");
        if (string2 != null) {
            this.getSwdlModels().getReleaseLabel().setText(string2);
        } else {
            this.getLogMain().log(10000, "[SwdlEnv].readSwdlInfo(): value of SWDL_DISPLAY_RELEASE is undefined.");
        }
    }

    public IStorageAccess getStorageManager() {
        return this.getFramework().getStorageMgr();
    }

    public boolean isSimulator() {
        return this.getFramework().isSimulator();
    }

    public void startDSIService(String string, int n) {
        this.getFramework().startDSIService(string, n);
    }

    public void startDSIServices() {
        this.startDSIService((class$org$dsi$ifc$swdldeviceinfo$DSISwdlDeviceInfo == null ? (class$org$dsi$ifc$swdldeviceinfo$DSISwdlDeviceInfo = SwdlEnv.class$("org.dsi.ifc.swdldeviceinfo.DSISwdlDeviceInfo")) : class$org$dsi$ifc$swdldeviceinfo$DSISwdlDeviceInfo).getName(), 0);
        this.startDSIService((class$org$dsi$ifc$swdllogging$DSISwdlLogging == null ? (class$org$dsi$ifc$swdllogging$DSISwdlLogging = SwdlEnv.class$("org.dsi.ifc.swdllogging.DSISwdlLogging")) : class$org$dsi$ifc$swdllogging$DSISwdlLogging).getName(), 0);
        this.startDSIService((class$org$dsi$ifc$swdlprogress$DSISwdlProgress == null ? (class$org$dsi$ifc$swdlprogress$DSISwdlProgress = SwdlEnv.class$("org.dsi.ifc.swdlprogress.DSISwdlProgress")) : class$org$dsi$ifc$swdlprogress$DSISwdlProgress).getName(), 0);
        this.startDSIService((class$org$dsi$ifc$swdlselection$DSISwdlSelection == null ? (class$org$dsi$ifc$swdlselection$DSISwdlSelection = SwdlEnv.class$("org.dsi.ifc.swdlselection.DSISwdlSelection")) : class$org$dsi$ifc$swdlselection$DSISwdlSelection).getName(), 0);
        if (this.isSimulator()) {
            this.startDSIService((class$org$dsi$ifc$uota$DSIUotA == null ? (class$org$dsi$ifc$uota$DSIUotA = SwdlEnv.class$("org.dsi.ifc.uota.DSIUotA")) : class$org$dsi$ifc$uota$DSIUotA).getName(), 0);
        }
    }

    public void sendMessage(int n) {
        this.getFramework().getMsgDistrib().sendMessage(n);
    }

    public void updateCustomerDownloadState(int n, int n2) {
        this.getLogMain().log(10000000, "[SwdlEnv].updateCustomerDownloadState(%1,%2)", (long)n, (long)n2);
        CombiBAPServiceSystem combiBAPServiceSystem = this.combiBAPServiceSystem;
        if (null != combiBAPServiceSystem) {
            combiBAPServiceSystem.updateCustomerDownloadState(n, n2);
        }
    }

    public void setEngineeringDownloadActive(boolean bl) {
        this.getFramework().getSysApp().setEngineeringDownloadActive(bl);
    }

    public void setCustomerDownloadActive(boolean bl) {
        this.getFramework().getSysApp().setCustomerDownloadActive(bl);
    }

    public boolean isUpdateOverTheAirFeatureEnabled() {
        return this.getFramework().getSysConst(3969) == 1;
    }

    public void setUpdateOverTheAirNotAvailable() {
        this.getLogMain().log(10000000, "[SwdlEnv] setUpdateOverTheAirNotAvailable");
        HMIModelApp hMIModelApp = this.getFramework().getHmiServiceApp().getModelApp(3969);
        if (hMIModelApp instanceof SysConstModelApp) {
            ((SysConstModelApp)hMIModelApp).setValue(0);
        }
        this.getFramework().getErrorMgr().handleError(new Exception("Incorrect UotA coding"), "UotaClient is not available", 0, 1, 4);
    }

    public int getUotaPackageTypeFilter() {
        return this.getFramework().getSysConst(4120);
    }

    public void sleep(long l) {
        try {
            Thread.sleep(l);
        }
        catch (InterruptedException interruptedException) {
            Thread.interrupted();
        }
    }

    public boolean isUotaNavDBMergeProcessNeeded() {
        return this.getFramework().getSysConst(4466) == 1;
    }

    public boolean preselectUOTASysProposals() {
        return this.getFramework().getSysConst(4467) == 1;
    }

    public boolean isUotaTravelCaseAllowed() {
        return this.getFramework().getSysConst(4463) == 1;
    }

    public boolean showUotaSysProposalWithoutLicense() {
        return this.getFramework().getSysConst(4465) == 1;
    }

    public boolean isUotaUpdateRegionCountRestricted() {
        return this.getUotaUpdateRegionCount() < Integer.MAX_VALUE;
    }

    public boolean isSortingUotaRegionByIsoCode() {
        return this.getFramework().getSysConst(4511) == 1;
    }

    public int getUotaUpdateRegionCount() {
        return this.getFramework().getSysConst(4464);
    }

    public int getUotaProgressDownloadPartPercentage() {
        return this.getFramework().getSysConst(4543);
    }

    public boolean isUotaLecensingAlowed() {
        return this.getFramework().getSysConst(5542) == 1;
    }

    public int getUotaProgressMapintegrationPartPercentage() {
        if (this.isUotaNavDBMergeProcessNeeded()) {
            return this.getFramework().getSysConst(4544);
        }
        return 0;
    }

    public int getUotaRegion() {
        return this.getFramework().getSysConst(442);
    }

    public static String formatVersion(long l) {
        String string = l > 9999L ? new StringBuffer().append("0x").append(Long.toHexString(l)).toString() : Long.toString(l);
        return string;
    }

    public boolean isSwdlSummaryEntered() {
        return this.swdlSummaryEntered;
    }

    public void setSwdlSummaryEntered(boolean bl) {
        this.swdlSummaryEntered = bl;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

