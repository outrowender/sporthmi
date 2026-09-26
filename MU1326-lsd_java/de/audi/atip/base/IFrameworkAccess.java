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
    public static final int KOMBI_PROTOCOL_NONE;
    public static final int KOMBI_PROTOCOL_DDP2;
    public static final int KOMBI_PROTOCOL_BAP;
    public static final int KOMBI_TYPE_NONE;
    public static final int KOMBI_TYPE_NORMAL;
    public static final int KOMBI_TYPE_TOP;
    public static final int KOMBI_TYPE_FPK;
    public static final int KOMBI_TYPE_MMI;
    public static final int SCREEN_RES_400;
    public static final int SCREEN_RES_800;
    public static final int SCREEN_RES_1024;
    public static final int SCREEN_RES_1280;
    public static final int SCREEN_RES_1440;
    public static final int SCREEN_RES_1680;
    public static final int SCREEN_RES_1920;
    public static final int SCREEN_RES_COUNT;

    default public BundleContext getBundleCxt() {
    }

    default public int getSysConst(int n) {
    }

    @Override
    default public LogChannel getLogChannel(String string) {
    }

    default public void activateTracingPreset(String string) {
    }

    default public boolean startDSIService(String string, int n) {
    }

    default public void stopDSIService(String string, int n) {
    }

    default public IAppStateManager getAppStateMgr() {
    }

    default public IErrorManager getErrorMgr() {
    }

    default public LogServAdmin getLogChannelAdmin() {
    }

    default public MsgDistributor getMsgDistrib() {
    }

    default public IStorageAccess getStorageMgr() {
    }

    default public IPowerManager getPowerMgr() {
    }

    default public IStartupManager getStartupMgr() {
    }

    default public ILastmodeHandler getLastmodeHandler() {
    }

    default public SMInterpreter getSMInterpreter() {
    }

    default public HMIService getHMIService() {
    }

    default public IHMIServiceApp getHmiServiceApp() {
    }

    default public ILanguageManager getLanguageMgr() {
    }

    default public InfotainmentRecorder getInfotainmentrecorder() {
    }

    default public IProgressMonitor getNavProgressMonitor() {
    }

    default public IProgressMonitor createProgressMonitor(String string, LogChannel logChannel, ChoiceModelApp choiceModelApp, LabelModelApp labelModelApp, ProgressMap progressMap, long l) {
    }

    default public boolean isFrontMU() {
    }

    default public boolean isDualView() {
    }

    default public boolean isTarget() {
    }

    default public boolean isSimulator() {
    }

    default public boolean isPBuild() {
    }

    default public boolean isEu() {
    }

    default public boolean isKorea() {
    }

    default public boolean isJp() {
    }

    default public boolean isCn() {
    }

    default public boolean isTaiwan() {
    }

    default public boolean isRdw() {
    }

    default public boolean isAsia() {
    }

    default public boolean isNar() {
    }

    default public boolean isEvoHigh() {
    }

    default public boolean isEvoHighMMIKombi() {
    }

    default public boolean isEvoStd() {
    }

    default public boolean isPorscheHigh() {
    }

    default public boolean isPorscheStd() {
    }

    default public boolean isBentley() {
    }

    default public boolean isPorsche() {
    }

    default public boolean isPGen2() {
    }

    default public boolean isAppSwdlStarted() {
    }

    default public IVersionInfo getVersionInfo() {
    }

    default public IHMITerminalRegistry getHMITerminalRegistry() {
    }

    default public ISysApp getSysApp() {
    }

    default public ThreadPool getHMIThreadPool() {
    }

    default public ThreadPool getUtilThreadPool() {
    }

    default public IDispatcherManager getDispatcherManager() {
    }

    default public long getMonotonicTime() {
    }

    default public ITimeSource getMonotonicTimeSource() {
    }

    default public long getKombiTime() {
    }

    default public long getUTCTime() {
    }

    default public long convertLocalTimeToUTCTime(long l) {
    }

    default public long convertUTCTimeToLocalTime(long l) {
    }

    default public long getCurrentTimezoneOffsetMilliseconds() {
    }

    default public int getKombiProtocol() {
    }

    default public int getKombiType() {
    }

    default public int getScreenRes() {
    }

    default public CacheHandler getCacheHandler() {
    }

    default public ISysConstManager getSysConstManager() {
    }

    default public IOnlineLogoProvider getOnlineLogoProvider() {
    }

    default public boolean isSDISEnabled() {
    }

    default public boolean isShowDDP2Combi() {
    }

    default public IWaitSyncer getWaitSyncer(String string, long l, LogChannel logChannel) {
    }
}

