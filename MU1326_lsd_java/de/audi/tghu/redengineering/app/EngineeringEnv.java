/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.redengineering.app;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.base.IVersionInfo;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.interapp.SDSService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.log.LogServAdmin;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.redengineering.app.AbstractEngineeringTextFactory;

public final class EngineeringEnv {
    private final IFrameworkAccess framework;
    private final LogChannel logMain;
    private final LogChannel logDSI;
    private final LogChannel logBenchmark;
    private final LogChannel logFSC;
    private final LogChannel logUDE;
    private SDSService sdsService;
    private boolean isREMactive = false;
    private final AbstractEngineeringTextFactory textFactory;

    public EngineeringEnv(IFrameworkAccess iFrameworkAccess, AbstractEngineeringTextFactory abstractEngineeringTextFactory) {
        this.framework = iFrameworkAccess;
        this.logMain = iFrameworkAccess.getLogChannel("App.Engineering.Main");
        this.logDSI = iFrameworkAccess.getLogChannel("App.Engineering.DSI");
        this.logBenchmark = iFrameworkAccess.getLogChannel("Ext.Benchmark");
        this.logFSC = iFrameworkAccess.getLogChannel("App.Swdl.FSC");
        this.logUDE = iFrameworkAccess.getLogChannel("App.Swdl.UDE");
        this.textFactory = abstractEngineeringTextFactory;
        this.textFactory.setEngineeringEnv(this);
    }

    public AbstractEngineeringTextFactory getTextFactory() {
        return this.textFactory;
    }

    public HMIService getHMIService() {
        return this.framework.getHMIService();
    }

    public LogChannel getLogMain() {
        return this.logMain;
    }

    public LogChannel getLogDSI() {
        return this.logDSI;
    }

    public LogChannel getLogFSC() {
        return this.logFSC;
    }

    public LogChannel getLogBenchmark() {
        return this.logBenchmark;
    }

    public LogChannel getLogUDE() {
        return this.logUDE;
    }

    public String[] getTargetIntegrityInfo() {
        return this.framework.getErrorMgr().getTargetIntegrityInfo();
    }

    public boolean isTarget() {
        return this.framework.isTarget();
    }

    public boolean isRebootToDownload() {
        return this.framework.getStartupMgr().isRebootToDownload();
    }

    public boolean isPBuild() {
        return this.framework.isPBuild();
    }

    public boolean isOfficialRelease() {
        return this.framework.getVersionInfo().isOfficialRelease();
    }

    public IVersionInfo getVersionInfo() {
        return this.framework.getVersionInfo();
    }

    public boolean isSimulator() {
        return this.framework.isSimulator();
    }

    public IStorageAccess getStorageMgr() {
        return this.framework.getStorageMgr();
    }

    public void sendMessage(int n) {
        this.framework.getMsgDistrib().sendMessage(n);
    }

    public int getSysConst(int n) {
        return this.framework.getSysConst(n);
    }

    public boolean isFrontMU() {
        return this.framework.isFrontMU();
    }

    public LogServAdmin getLogChannelAdmin() {
        return this.framework.getLogChannelAdmin();
    }

    public void executeInUtilThread(Runnable runnable) {
        this.framework.getUtilThreadPool().execute(runnable);
    }

    public void rebootSystem() {
        this.framework.getPowerMgr().rebootSystem();
    }

    public LabelModelApp getDebugLabel() {
        return this.getHMIService().getLabelModel(416);
    }

    private String readString(int n, int n2, String string) {
        return this.getStorageMgr().getString(n, n2, string);
    }

    private byte[] readBytes(int n, int n2, byte[] byArray) {
        return this.getStorageMgr().getByteArray(n, n2, byArray);
    }

    public String getTextToolVersion() {
        return this.getVersionInfo().getTextToolVersion();
    }

    public String getOptionDrawerVersion() {
        return this.getVersionInfo().getOptionDrawerVersion();
    }

    public String getHUSwVersion() {
        this.getLogMain().log(10000000, "EngineeringEnv: MU SW Version: Enter");
        String string = null;
        if (this.isSimulator()) {
            string = "WinHU";
        } else if (this.isRebootToDownload()) {
            string = this.getTextFactory().getTextConstantDownload();
        } else {
            byte[] byArray = this.readBytes(46924065, 400, new byte[0]);
            if (byArray.length >= 26) {
                byte[] byArray2 = new byte[4];
                System.arraycopy((Object)byArray, 22, (Object)byArray2, 0, 4);
                string = new String(byArray2);
            } else {
                string = "UNDEF";
            }
            this.getLogMain().log(100000, "EngineeringEnv: Release Version HIGH: calling getString %1", (Object)string);
        }
        return string;
    }

    public String getFOTTemp() {
        this.getLogMain().log(10000000, "EngineeringEnv: FOT Temp: Enter");
        String string = "1";
        if (this.isSimulator()) {
            string = "10";
        } else if (this.isRebootToDownload()) {
            string = this.getTextFactory().getTextConstantDownload();
        }
        return string;
    }

    protected String getMostTrainVersion() {
        String string = "";
        if (this.isSimulator()) {
            string = "WinTV";
            return "WinTV";
        }
        if (this.isRebootToDownload()) {
            string = this.getTextFactory().getTextConstantDownload();
            return string;
        }
        byte[] byArray = this.readBytes(46924065, 401, new byte[0]);
        string = byArray.length > 10 ? new String(byArray) : this.readString(46924065, 401, "UNDEF");
        this.getLogMain().log(10000000, "EngineeringEnv: Returned Train Version = %1", (Object)string);
        return string;
    }

    public void sleep(long l) {
        try {
            Thread.sleep(l);
        }
        catch (InterruptedException interruptedException) {
            Thread.interrupted();
        }
    }

    public int getTerminalId() {
        return this.isFrontMU() ? 0 : 5;
    }

    public void setSdsService(SDSService sDSService) {
        this.sdsService = sDSService;
    }

    public SDSService getSdsService() {
        return this.sdsService;
    }

    private void blockPTT(boolean bl) {
        this.getLogMain().log(1000000, "[EngineeringEnv] blockPTT(%1)", bl);
        if (this.isFrontMU()) {
            if (this.getSdsService() != null) {
                this.getSdsService().disablePTT(bl, true, (byte)4);
            } else {
                this.getLogMain().log(100000, "[EngineeringEnv] blockPTT: No SDS service available!");
            }
        }
    }

    private void setREMHMIactive(boolean bl) {
        this.isREMactive = bl;
    }

    public boolean isREMHMIactive() {
        return this.isREMactive;
    }

    public void enterREM() {
        this.getLogMain().log(1000000, "[EngineeringEnv] enterREM");
        this.setREMHMIactive(true);
        if (this.isRebootToDownload()) {
            this.getLogMain().log(10000000, "[EngineeringEnv] enterREM: during progress enable popups");
            this.getHMIService().enablePopups();
        } else {
            this.getLogMain().log(10000000, "[EngineeringEnv] enterREM: disable popups");
            this.getHMIService().disablePopups(17);
        }
        this.getHMIService().setPartialPopupsEnabled(-1, false);
        this.blockPTT(true);
    }

    public void leaveREM() {
        this.getLogMain().log(1000000, "[EngineeringEnv] leaveREM");
        this.blockPTT(false);
        this.getLogMain().log(10000000, "[EngineeringEnv] leaveREM: enable popups");
        this.getHMIService().setPartialPopupsEnabled(-1, true);
        this.getHMIService().enablePopups();
        this.setREMHMIactive(false);
    }
}

