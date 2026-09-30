/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.base;

import de.audi.atip.activator.FrameworkException;
import de.audi.atip.base.FwServices;
import de.audi.atip.base.IAppStateManager;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.base.IVersionInfo;
import de.audi.atip.base.VersionInfo;
import de.audi.atip.config.carcoding.SysConstProvider;
import de.audi.atip.error.IErrorManager;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.IHMITerminalRegistry;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.i18n.ILanguageManager;
import de.audi.atip.irc.InfotainmentRecorder;
import de.audi.atip.log.LogChannel;
import de.audi.atip.log.LogChannelFactory;
import de.audi.atip.log.LogServAdmin;
import de.audi.atip.log.NullLogServImpl;
import de.audi.atip.msg.MsgDistributor;
import de.audi.atip.onlinelogo.IOnlineLogoProvider;
import de.audi.atip.onlinelogo.OnlineLogoActivator;
import de.audi.atip.power.IPowerManager;
import de.audi.atip.progress.IProgressMonitor;
import de.audi.atip.progress.ProgressMap;
import de.audi.atip.start.ILastmodeHandler;
import de.audi.atip.start.IStartupManager;
import de.audi.atip.statemachine.SMInterpreter;
import de.audi.atip.storage.IStorageAccess;
import de.audi.atip.storagecache.CacheHandler;
import de.audi.atip.sync.IWaitSyncer;
import de.audi.atip.sync.WaitSyncer;
import de.audi.atip.sysapp.ISysApp;
import de.audi.atip.sysapp.ProgressMonitor;
import de.audi.atip.sysapp.carcoding.ISysConstManager;
import de.audi.tghu.fwhmi.HMITerminalRegistry;
import de.esolutions.fw.util.commons.job.IDispatcherManager;
import de.esolutions.fw.util.commons.threading.IThreadPoolManager;
import de.esolutions.fw.util.commons.threading.ThreadPool;
import de.esolutions.fw.util.commons.timeout.ITimeSource;
import java.io.File;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public final class FrameworkAccess
implements IFrameworkAccess {
    private static final boolean IS_TARGET = System.getProperty("os.name").indexOf("QNX") >= 0;
    private static final boolean IS_EVO_HIGH = System.getProperty("variant.skin", "EvoHigh").indexOf("EvoHigh") >= 0;
    private static final boolean IS_EVO_STD = System.getProperty("variant.skin", "EvoHigh").indexOf("EvoStd") >= 0;
    private static final boolean IS_PORSCHE_HIGH = System.getProperty("variant.skin", "EvoHigh").indexOf("PorscheHigh") >= 0;
    private static final boolean IS_PGEN2 = System.getProperty("variant.skin", "EvoHigh").indexOf("PGen2") >= 0;
    private static final boolean IS_BENTLEY = System.getProperty("variant.skin", "EvoHigh").indexOf("Bentley") >= 0;
    private static final boolean IS_PORSCHE_STD = System.getProperty("variant.skin", "EvoHigh").indexOf("PorscheStandard") >= 0;
    private static final boolean IS_G24_WITHOUT_MMIKOMBI = Boolean.getBoolean("G24_NO_MMIKOMBI");
    private static final int SCREEN_RES = Integer.getInteger("ScreenRes", 2);
    private static final String PATH_PRESET_DEVICES = System.getProperty("preset.device.path", "/dev/eso/traceserver.callbacks/traceserver/Presets_");
    private final BundleContext context;
    private final FwServices fwServices;
    private final VersionInfo verInfo;
    private LogChannelFactory lcf;
    private HMITerminalRegistry hmiTerminalRegistry = null;
    private IDispatcherManager dispatcherManager;
    private IThreadPoolManager threadPoolMngr;
    private final SysConstProvider sysConstProvider;
    static /* synthetic */ Class class$de$esolutions$fw$util$commons$job$IDispatcherManager;
    static /* synthetic */ Class class$de$esolutions$fw$util$commons$threading$IThreadPoolManager;

    public BundleContext getBundleCxt() {
        return this.context;
    }

    FrameworkAccess(BundleContext bundleContext) {
        this.context = bundleContext;
        this.fwServices = new FwServices(this);
        this.fwServices.initBundleContext(this.context);
        this.lcf = NullLogServImpl.getInstance();
        this.sysConstProvider = new SysConstProvider(bundleContext, this);
        ServiceReference serviceReference = this.context.getServiceReference((class$de$esolutions$fw$util$commons$job$IDispatcherManager == null ? (class$de$esolutions$fw$util$commons$job$IDispatcherManager = FrameworkAccess.class$("de.esolutions.fw.util.commons.job.IDispatcherManager")) : class$de$esolutions$fw$util$commons$job$IDispatcherManager).getName());
        if (serviceReference != null) {
            this.dispatcherManager = (IDispatcherManager)this.context.getService(serviceReference);
        }
        if (this.dispatcherManager == null) {
            throw new FrameworkException("IDispatcherManager service not available!");
        }
        ServiceReference serviceReference2 = this.context.getServiceReference((class$de$esolutions$fw$util$commons$threading$IThreadPoolManager == null ? (class$de$esolutions$fw$util$commons$threading$IThreadPoolManager = FrameworkAccess.class$("de.esolutions.fw.util.commons.threading.IThreadPoolManager")) : class$de$esolutions$fw$util$commons$threading$IThreadPoolManager).getName());
        if (serviceReference2 != null) {
            this.threadPoolMngr = (IThreadPoolManager)this.context.getService(serviceReference2);
        }
        if (this.threadPoolMngr == null) {
            throw new FrameworkException("IThreadPoolManager service not available!");
        }
        this.verInfo = new VersionInfo();
    }

    void initLogChannelFactory() {
        this.lcf = this.fwServices.getLogChannelFactory();
    }

    public FwServices getFwServices() {
        return this.fwServices;
    }

    public IErrorManager getErrorMgr() {
        return this.fwServices.getErrorManager();
    }

    public HMIService getHMIService() {
        return this.fwServices.getHMIService();
    }

    public IHMIServiceApp getHmiServiceApp() {
        return this.fwServices.getHMIService();
    }

    public InfotainmentRecorder getInfotainmentrecorder() {
        return this.fwServices.getInfotainmentrecorder();
    }

    public MsgDistributor getMsgDistrib() {
        return this.fwServices.getMsgDistrib();
    }

    public IPowerManager getPowerMgr() {
        return this.fwServices.getPowerManager();
    }

    public IStartupManager getStartupMgr() {
        return this.fwServices.getStartupManager();
    }

    public ILastmodeHandler getLastmodeHandler() {
        return this.getStartupMgr().getLastmodeHandler();
    }

    public IAppStateManager getAppStateMgr() {
        return this.fwServices.getStartupManager().getAppStateManager();
    }

    public ILanguageManager getLanguageMgr() {
        return this.fwServices.getLanguageManager();
    }

    public SMInterpreter getSMInterpreter() {
        return this.fwServices.getSMInterpreter();
    }

    public IStorageAccess getStorageMgr() {
        return this.fwServices.getStorageManager();
    }

    public int getSysConst(int n) {
        return this.sysConstProvider.getSysConst(n);
    }

    public ISysConstManager getSysConstManager() {
        return this.sysConstProvider.getSysConstManager();
    }

    public boolean isFrontMU() {
        return true;
    }

    public boolean isDualView() {
        return false;
    }

    public boolean isTarget() {
        return IS_TARGET;
    }

    public boolean isSimulator() {
        return !IS_TARGET;
    }

    public boolean isPBuild() {
        return this.getVersionInfo().isProductionVersion();
    }

    public boolean isEu() {
        return this.getSysConst(442) == 0;
    }

    public boolean isKorea() {
        return this.getSysConst(442) == 4;
    }

    public boolean isJp() {
        return this.getSysConst(442) == 3;
    }

    public boolean isCn() {
        return this.getSysConst(442) == 2;
    }

    public boolean isTaiwan() {
        return this.getSysConst(442) == 5;
    }

    public boolean isRdw() {
        return this.getSysConst(442) == 6;
    }

    public boolean isAsia() {
        int n = this.getSysConst(442);
        return n == 2 || n == 3 || n == 5 || n == 4;
    }

    public boolean isNar() {
        return this.getSysConst(442) == 1;
    }

    public boolean isEvoHigh() {
        return IS_EVO_HIGH;
    }

    public boolean isEvoHighMMIKombi() {
        return this.isEvoHigh() && this.getScreenRes() == 4;
    }

    public boolean isG24WithoutMMIKombi() {
        return this.isEvoHighMMIKombi() && IS_G24_WITHOUT_MMIKOMBI;
    }

    public boolean isEvoStd() {
        return IS_EVO_STD;
    }

    public boolean isPorscheHigh() {
        return IS_PORSCHE_HIGH;
    }

    public boolean isPorscheStd() {
        return IS_PORSCHE_STD;
    }

    public boolean isBentley() {
        return IS_BENTLEY;
    }

    public boolean isPGen2() {
        return IS_PGEN2;
    }

    public boolean isPorsche() {
        return IS_PORSCHE_HIGH || IS_PORSCHE_STD || IS_BENTLEY;
    }

    public boolean startDSIService(String string, int n) {
        return this.fwServices.getJDSIAdmin().startDSIService(string, n);
    }

    public void stopDSIService(String string, int n) {
        this.fwServices.getJDSIAdmin().stopDSIService(string, n);
    }

    public boolean isAppSwdlStarted() {
        return this.getAppStateMgr().isAppSwdlStarted();
    }

    public LogServAdmin getLogChannelAdmin() {
        return (LogServAdmin)((Object)this.fwServices.getLogChannelFactory());
    }

    public LogChannel getLogChannel(String string) {
        return this.lcf.getLogChannel(string);
    }

    public void activateTracingPreset(String string) {
        File file = new File(new StringBuffer().append(PATH_PRESET_DEVICES).append(string).toString());
        if (file.exists()) {
            this.getLogChannel("Fw.Presets").log(1000000, "Preset %1 activated!", (Object)string);
            file.setLastModified(System.currentTimeMillis());
        } else {
            this.getLogChannel("Fw.Presets").log(100000, "Preset %1 not defined!", (Object)string);
        }
    }

    public IProgressMonitor getNavProgressMonitor() {
        return this.getAppStateMgr().getNavProgressMonitor();
    }

    public IProgressMonitor createProgressMonitor(String string, LogChannel logChannel, ChoiceModelApp choiceModelApp, LabelModelApp labelModelApp, ProgressMap progressMap, long l) {
        return new ProgressMonitor(string, logChannel, choiceModelApp, labelModelApp, progressMap, l, false);
    }

    public IVersionInfo getVersionInfo() {
        return this.verInfo;
    }

    public synchronized IHMITerminalRegistry getHMITerminalRegistry() {
        if (this.hmiTerminalRegistry == null) {
            this.hmiTerminalRegistry = new HMITerminalRegistry(this);
        }
        return this.hmiTerminalRegistry;
    }

    public ISysApp getSysApp() {
        return this.fwServices.getSysApp();
    }

    public ThreadPool getHMIThreadPool() {
        return this.threadPoolMngr.getThreadPool("HMIThreadPool");
    }

    public ThreadPool getUtilThreadPool() {
        return this.threadPoolMngr.getThreadPool("UtilThreadPool");
    }

    public long getMonotonicTime() {
        return this.getMonotonicTimeSource().getCurrentTime();
    }

    public ITimeSource getMonotonicTimeSource() {
        return this.fwServices.getMonotonicTimeSource();
    }

    public long getKombiTime() {
        return this.fwServices.getSysApp().getAdjustedTime();
    }

    public long getUTCTime() {
        return this.fwServices.getSysApp().getUTCTime();
    }

    public long convertLocalTimeToUTCTime(long l) {
        return this.fwServices.getSysApp().convertLocalTimeToUTCTime(l);
    }

    public long convertUTCTimeToLocalTime(long l) {
        return this.fwServices.getSysApp().convertUTCTimeToLocalTime(l);
    }

    public long getCurrentTimezoneOffsetMilliseconds() {
        return this.fwServices.getSysApp().getCurrentTimezoneOffsetMilliseconds();
    }

    public IDispatcherManager getDispatcherManager() {
        return this.dispatcherManager;
    }

    public int getKombiProtocol() {
        if (IS_BENTLEY && this.getSysConst(466) == 8 && this.getSysConst(469) == 3) {
            return 1;
        }
        return 2;
    }

    public int getKombiType() {
        if (this.getKombiProtocol() == 1) {
            return 2;
        }
        return 4 == this.getScreenRes() ? 4 : 1;
    }

    public int getScreenRes() {
        return SCREEN_RES;
    }

    public IOnlineLogoProvider getOnlineLogoProvider() {
        OnlineLogoActivator onlineLogoActivator = this.fwServices.getOnlineLogoActivator();
        return onlineLogoActivator != null ? onlineLogoActivator.getService() : null;
    }

    public boolean isSDISEnabled() {
        return 1 == this.getSysConst(3892);
    }

    public boolean isShowDDP2Combi() {
        return this.getKombiProtocol() == 1;
    }

    public CacheHandler getCacheHandler() {
        return this.fwServices.getCacheHandler();
    }

    public IWaitSyncer getWaitSyncer(String string, long l, LogChannel logChannel) {
        return new WaitSyncer(this, string, l, logChannel);
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

