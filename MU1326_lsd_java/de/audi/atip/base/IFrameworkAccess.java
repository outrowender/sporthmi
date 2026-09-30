/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.base;

import de.audi.atip.base.IAppStateManager;
import de.audi.atip.base.IVersionInfo;
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
import de.audi.atip.msg.MsgDistributor;
import de.audi.atip.onlinelogo.IOnlineLogoProvider;
import de.audi.atip.power.IPowerManager;
import de.audi.atip.progress.IProgressMonitor;
import de.audi.atip.progress.ProgressMap;
import de.audi.atip.start.ILastmodeHandler;
import de.audi.atip.start.IStartupManager;
import de.audi.atip.statemachine.SMInterpreter;
import de.audi.atip.storage.IStorageAccess;
import de.audi.atip.storagecache.CacheHandler;
import de.audi.atip.sync.IWaitSyncer;
import de.audi.atip.sysapp.ISysApp;
import de.audi.atip.sysapp.carcoding.ISysConstManager;
import de.esolutions.fw.util.commons.job.IDispatcherManager;
import de.esolutions.fw.util.commons.threading.ThreadPool;
import de.esolutions.fw.util.commons.timeout.ITimeSource;
import org.osgi.framework.BundleContext;

public interface IFrameworkAccess
extends LogChannelFactory {
    public static final int KOMBI_PROTOCOL_NONE = 0;
    public static final int KOMBI_PROTOCOL_DDP2 = 1;
    public static final int KOMBI_PROTOCOL_BAP = 2;
    public static final int KOMBI_TYPE_NONE = 0;
    public static final int KOMBI_TYPE_NORMAL = 1;
    public static final int KOMBI_TYPE_TOP = 2;
    public static final int KOMBI_TYPE_FPK = 3;
    public static final int KOMBI_TYPE_MMI = 4;
    public static final int SCREEN_RES_400 = 0;
    public static final int SCREEN_RES_800 = 1;
    public static final int SCREEN_RES_1024 = 2;
    public static final int SCREEN_RES_1280 = 3;
    public static final int SCREEN_RES_1440 = 4;
    public static final int SCREEN_RES_1680 = 5;
    public static final int SCREEN_RES_1920 = 6;
    public static final int SCREEN_RES_COUNT = 7;

    public BundleContext getBundleCxt();

    public int getSysConst(int var1);

    public LogChannel getLogChannel(String var1);

    public void activateTracingPreset(String var1);

    public boolean startDSIService(String var1, int var2);

    public void stopDSIService(String var1, int var2);

    public IAppStateManager getAppStateMgr();

    public IErrorManager getErrorMgr();

    public LogServAdmin getLogChannelAdmin();

    public MsgDistributor getMsgDistrib();

    public IStorageAccess getStorageMgr();

    public IPowerManager getPowerMgr();

    public IStartupManager getStartupMgr();

    public ILastmodeHandler getLastmodeHandler();

    public SMInterpreter getSMInterpreter();

    public HMIService getHMIService();

    public IHMIServiceApp getHmiServiceApp();

    public ILanguageManager getLanguageMgr();

    public InfotainmentRecorder getInfotainmentrecorder();

    public IProgressMonitor getNavProgressMonitor();

    public IProgressMonitor createProgressMonitor(String var1, LogChannel var2, ChoiceModelApp var3, LabelModelApp var4, ProgressMap var5, long var6);

    public boolean isFrontMU();

    public boolean isDualView();

    public boolean isTarget();

    public boolean isSimulator();

    public boolean isPBuild();

    public boolean isEu();

    public boolean isKorea();

    public boolean isJp();

    public boolean isCn();

    public boolean isTaiwan();

    public boolean isRdw();

    public boolean isAsia();

    public boolean isNar();

    public boolean isEvoHigh();

    public boolean isEvoHighMMIKombi();

    public boolean isEvoStd();

    public boolean isPorscheHigh();

    public boolean isPorscheStd();

    public boolean isBentley();

    public boolean isPorsche();

    public boolean isPGen2();

    public boolean isAppSwdlStarted();

    public IVersionInfo getVersionInfo();

    public IHMITerminalRegistry getHMITerminalRegistry();

    public ISysApp getSysApp();

    public ThreadPool getHMIThreadPool();

    public ThreadPool getUtilThreadPool();

    public IDispatcherManager getDispatcherManager();

    public long getMonotonicTime();

    public ITimeSource getMonotonicTimeSource();

    public long getKombiTime();

    public long getUTCTime();

    public long convertLocalTimeToUTCTime(long var1);

    public long convertUTCTimeToLocalTime(long var1);

    public long getCurrentTimezoneOffsetMilliseconds();

    public int getKombiProtocol();

    public int getKombiType();

    public int getScreenRes();

    public CacheHandler getCacheHandler();

    public ISysConstManager getSysConstManager();

    public IOnlineLogoProvider getOnlineLogoProvider();

    public boolean isSDISEnabled();

    public boolean isShowDDP2Combi();

    public IWaitSyncer getWaitSyncer(String var1, long var2, LogChannel var4);
}

