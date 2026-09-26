/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.base.ComponentStateListener;
import de.audi.atip.base.IAppStateManager;
import de.audi.atip.base.IDomainListener;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.progress.IProgressMonitor;
import de.audi.atip.progress.NaviProgressMap;
import de.audi.atip.startup.AppStateManager$1;
import de.audi.atip.startup.AppStateManager$2;
import de.audi.atip.startup.AppStateManager$DependentCompomnentStart;
import de.audi.atip.startup.AppStateManager$StartDomain;
import de.audi.atip.startup.BundleHandler;
import de.audi.atip.startup.ComponentState;
import de.audi.atip.startup.DomainHandler;
import de.audi.atip.startup.GUIDEModuleManager;
import de.audi.atip.startup.StartupManager;
import de.audi.atip.startup.config.Component;
import de.audi.atip.startup.config.StartupConfigProvider;
import de.audi.atip.sysapp.ProgressMonitor;
import de.audi.atip.sysapp.carcoding.CarFuncAdap;
import de.esolutions.fw.util.commons.SimpleIntIntMap;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.osgi.framework.Bundle;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class AppStateManager
implements IAppStateManager,
DumpInfoProvider,
IDomainListener {
    public static final String BUNDLES_LASTMODE_ORDER;
    public static final String BUNDLES_STATIC_INIT;
    public static final String BUNDLES_HMI_BASICS;
    public static final String BUNDLES_BEFORE_AUDIO;
    public static final String BUNDLES_BEFORE_APP;
    public static final String BUNDELS_ADD_ON;
    public static final String BUNDLES_SWDL_START;
    public static final int DEVICE_MODE_RELEASE;
    public static final int DEVICE_MODE_DEVELOPMENT;
    public static final int DEVICE_MODE_PCSIM;
    private final LogChannel lc;
    private final List listeners;
    private StartupManager startupManager;
    private BundleHandler bundleHandler;
    private ProgressMonitor navProgressMonitor;
    private HashMap compStateMap;
    private HashMap bundleStateMap;
    private HashMap lastmodeAppIdMap;
    private SimpleIntIntMap keyCodesMap;
    private ComponentState lastmodeOrder;
    private GUIDEModuleManager guideModuleManager;
    private HashMap stopOnFailDependencyMap;
    private HashMap notStartedDependentComponents;
    static /* synthetic */ Class class$de$audi$atip$base$IDomainListener;
    static /* synthetic */ Class class$de$audi$atip$base$ComponentStateListener;

    AppStateManager(StartupManager startupManager) {
        this.startupManager = startupManager;
        this.bundleHandler = startupManager.getBundleHandler();
        this.listeners = new ArrayList(10);
        this.lc = this.getFramework().getLogChannel("Fw.Startup.State");
        this.lc.log(1078071040, "AppStateManager.<init>");
        this.initComponentStates();
        this.getFramework().getErrorMgr().registerDumpInfoProvider(this);
        this.initDomainStateListenerTracker();
        this.initComponentStateListenerTracker();
    }

    private void initDomainStateListenerTracker() {
        this.lc.log(1078071040, "AppStateManager.initDomainStateListenerTracker()");
        new ServiceTracker(this.getFramework().getBundleCxt(), (class$de$audi$atip$base$IDomainListener == null ? (class$de$audi$atip$base$IDomainListener = AppStateManager.class$("de.audi.atip.base.IDomainListener")) : class$de$audi$atip$base$IDomainListener).getName(), (ServiceTrackerCustomizer)new AppStateManager$1(this)).open();
    }

    private void initComponentStateListenerTracker() {
        new ServiceTracker(this.getFramework().getBundleCxt(), (class$de$audi$atip$base$ComponentStateListener == null ? (class$de$audi$atip$base$ComponentStateListener = AppStateManager.class$("de.audi.atip.base.ComponentStateListener")) : class$de$audi$atip$base$ComponentStateListener).getName(), (ServiceTrackerCustomizer)new AppStateManager$2(this)).open();
    }

    private void initComponentStates() {
        ComponentState componentState;
        StartupConfigProvider startupConfigProvider = new StartupConfigProvider(this.lc, this.getDeviceMode(this.startupManager.getFramework()));
        this.guideModuleManager = new GUIDEModuleManager(this);
        this.compStateMap = new HashMap(50, 1.0f);
        this.bundleStateMap = new HashMap(100, 1.0f);
        this.lastmodeAppIdMap = new HashMap();
        this.keyCodesMap = new SimpleIntIntMap(8);
        this.notStartedDependentComponents = new HashMap(10, 1.0f);
        Iterator iterator = startupConfigProvider.getComponentsIterator();
        while (iterator.hasNext()) {
            Component component = (Component)iterator.next();
            if (component == null) continue;
            componentState = this.getComponentByName(component.getName());
            if (componentState == null) {
                componentState = new ComponentState(this, component);
                this.addComponentState(component.getName(), componentState);
                if (componentState.getBundles() != null) {
                    for (int i2 = 0; i2 < componentState.getBundles().length; ++i2) {
                        this.addBundleComponentState(this.bundleHandler.getBundleName(componentState.getBundles()[i2]), componentState);
                    }
                }
                if (-1 != componentState.getId()) {
                    this.lastmodeAppIdMap.put(new Integer(componentState.getId()), componentState);
                    if (componentState.getKeyCode() != 0) {
                        this.keyCodesMap.add(componentState.getKeyCode(), componentState.getId());
                    }
                }
                this.guideModuleManager.setGUIDEModuleState(componentState.getGUIDEModuleState());
                continue;
            }
            this.lc.log(1000, "AppStateManager.initComponentStates: duplicate component %1", (Object)component.getName());
        }
        iterator = this.compStateMap.values().iterator();
        while (iterator.hasNext()) {
            componentState = (ComponentState)iterator.next();
            componentState.initSubComponents();
            this.checkStopOnFailDependency(componentState);
        }
        this.lastmodeOrder = this.getComponentByName("LastmodeOrder");
    }

    private void addStopOnFailDependency(String string, String string2) {
        HashSet hashSet;
        if (this.stopOnFailDependencyMap == null) {
            this.stopOnFailDependencyMap = new HashMap();
        }
        if ((hashSet = (HashSet)this.stopOnFailDependencyMap.get(string)) == null) {
            hashSet = new HashSet(2);
        }
        hashSet.add(string2);
        this.stopOnFailDependencyMap.put(string, hashSet);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void addNotStartedDependendComponent(ComponentState componentState, AppStateManager$DependentCompomnentStart appStateManager$DependentCompomnentStart) {
        HashMap hashMap = this.notStartedDependentComponents;
        synchronized (hashMap) {
            ArrayList arrayList = (ArrayList)this.notStartedDependentComponents.get(componentState.getComponentName());
            if (arrayList == null) {
                arrayList = new ArrayList(5);
            }
            arrayList.add(appStateManager$DependentCompomnentStart);
            this.notStartedDependentComponents.put(componentState.getComponentName(), arrayList);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void checkNotStartedDependendComponents(String string) {
        HashMap hashMap = this.notStartedDependentComponents;
        synchronized (hashMap) {
            ArrayList arrayList = (ArrayList)this.notStartedDependentComponents.get(string);
            if (arrayList != null) {
                this.notStartedDependentComponents.remove(string);
                Iterator iterator = arrayList.iterator();
                while (iterator.hasNext()) {
                    AppStateManager$DependentCompomnentStart appStateManager$DependentCompomnentStart = (AppStateManager$DependentCompomnentStart)iterator.next();
                    if (appStateManager$DependentCompomnentStart == null) continue;
                    appStateManager$DependentCompomnentStart.reCheckDependency();
                }
                arrayList = null;
            }
        }
    }

    private void checkStopOnFailDependency(ComponentState componentState) {
        List list = componentState.getStopOnFailDependentComponents();
        if (list != null) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                ComponentState componentState2 = (ComponentState)iterator.next();
                this.addStopOnFailDependency(componentState2.getComponentName(), componentState.getComponentName());
            }
        }
    }

    List getStopOnFailComponents(String string) {
        HashSet hashSet;
        if (this.stopOnFailDependencyMap != null && (hashSet = (HashSet)this.stopOnFailDependencyMap.get(string)) != null) {
            ArrayList arrayList = new ArrayList(hashSet.size());
            Iterator iterator = hashSet.iterator();
            while (iterator.hasNext()) {
                String string2 = (String)iterator.next();
                ComponentState componentState = (ComponentState)this.compStateMap.get(string2);
                if (componentState != null) {
                    arrayList.add(componentState);
                    continue;
                }
                this.lc.log(1000, "AppStateManager.getStopOnFailComponents: stop on fail component is not found %1", (Object)string2);
            }
            return arrayList;
        }
        return null;
    }

    private int getDeviceMode(IFrameworkAccess iFrameworkAccess) {
        int n = 0;
        if (Boolean.getBoolean("dev_mode")) {
            n |= 1;
        }
        if (iFrameworkAccess.isSimulator()) {
            n |= 3;
        }
        return n;
    }

    public static String deviceModeToString(int n) {
        String string = "RELEASE";
        if ((n & 1) == 1) {
            string = "DEVELOPMENT";
        }
        if ((n & 2) == 2) {
            string = "PC SYMULATION";
        }
        return string;
    }

    boolean isDomainEnabled(int n) {
        return this.getDomainHandler().isDomainEnabled(n);
    }

    void initComponentStateModels(int n) {
        Object object;
        int[] nArray = new int[]{4253, 4190, 353, 350, 374, 367, 4079, 363, 3853, 371, 4021, 4045, 359, 3888, 357, 509, 456, 361, 356, 545, 4033};
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            object = this.getSysChoiceModel(n, nArray[i2]);
            if (object == null) continue;
            object.setValue(1024);
            object.setStatus(1);
        }
        Iterator iterator = this.compStateMap.values().iterator();
        while (iterator.hasNext()) {
            ChoiceModelApp choiceModelApp;
            object = (ComponentState)iterator.next();
            if (object == null || (choiceModelApp = ((ComponentState)object).getSysChoiceModel(n)) == null) continue;
            choiceModelApp.setValue(0);
            choiceModelApp.setStatus(0);
        }
    }

    void sysConstIsInitialized() {
        CarFuncAdap carFuncAdap;
        IFrameworkAccess iFrameworkAccess = this.getFramework();
        if (iFrameworkAccess.getSysConst(470) == 0) {
            this.componentNotPresent("AddressBook");
        }
        if (iFrameworkAccess.getSysConst(459) == 0) {
            this.componentNotPresent("Navi");
            this.componentNotPresent("Info");
            this.componentNotPresent("GoogleEarth");
            this.componentNotPresent("StreetView");
            this.componentNotPresent("AppPictureNav");
            this.componentNotPresent("service.dsi.picnav");
            this.componentNotPresent("InfoKR");
            this.getDomainHandler().disableDomain(6);
        }
        if (iFrameworkAccess.getSysConst(4324) == 0) {
            this.componentNotPresent("InfoKR");
        }
        if (iFrameworkAccess.getSysConst(4323) == 0) {
            this.componentNotPresent("TrafficInfoJP");
        }
        if (iFrameworkAccess.getSysConst(489) == 0) {
            this.componentNotPresent("AppPictureNav");
            this.componentNotPresent("service.dsi.picnav");
        }
        if (iFrameworkAccess.getSysConst(461) == 0 && iFrameworkAccess.getSysConst(492) == 0) {
            this.componentNotPresent("Connectivity");
        }
        if (iFrameworkAccess.getSysConst(473) == 0) {
            this.componentNotPresent("Phone");
            this.componentNotPresent("Messaging");
            this.componentNotPresent("Online");
        }
        if (iFrameworkAccess.getSysConst(4162) == 0) {
            this.componentNotPresent("WirelessCharging");
        }
        if (iFrameworkAccess.getSysConst(472) == 0) {
            this.componentNotPresent("Messaging");
        }
        if (iFrameworkAccess.getSysConst(460) == 0) {
            this.componentNotPresent("SDSManager");
        }
        if (iFrameworkAccess.getSysConst(479) == 0) {
            this.componentNotPresent("GoogleEarth");
        }
        if (iFrameworkAccess.getSysConst(490) == 0) {
            this.componentNotPresent("StreetView");
        }
        if (iFrameworkAccess.getSysConst(474) == 0) {
            this.componentNotPresent("RemoteHMI");
        }
        if (iFrameworkAccess.getSysConst(486) == 0) {
            this.componentNotPresent("service.dsi.poi");
        }
        if (iFrameworkAccess.getSysConst(485) == 0) {
            this.componentNotPresent("service.dsi.myaudi");
        }
        if (iFrameworkAccess.getSysConst(488) == 0) {
            this.componentNotPresent("service.dsi.onlinetraffic");
        }
        if (iFrameworkAccess.getSysConst(488) == 0) {
            this.componentNotPresent("service.dsi.onlinedictation");
        }
        if (iFrameworkAccess.getSysConst(488) == 0 && iFrameworkAccess.getSysConst(485) == 0 && iFrameworkAccess.getSysConst(486) == 0 && iFrameworkAccess.getSysConst(474) == 0) {
            this.componentNotPresent("service.core.registration");
        }
        if (iFrameworkAccess.getSysConst(3892) == 0) {
            this.componentNotPresent("SystemSDIS");
        }
        if (iFrameworkAccess.getSysConst(4252) == 0) {
            this.componentNotPresent("ENI");
        }
        if (iFrameworkAccess.getSysConst(4082) == 0) {
            this.componentNotPresent("Ecall");
        }
        if (!(carFuncAdap = iFrameworkAccess.getSysConstManager().getCarFuncAdaptation()).isMenuDisplayActivated((short)24)) {
            this.componentNotPresent("CarHybrid");
        }
        if (!carFuncAdap.isMenuDisplayActivated((short)8)) {
            this.componentNotPresent("CarClimate");
        }
        if (!carFuncAdap.isMenuDisplayActivated((short)17)) {
            this.componentNotPresent("CarDrive");
        }
        if (iFrameworkAccess.getKombiProtocol() == 1) {
            this.componentNotPresent("CombiBAP");
        } else {
            this.componentNotPresent("CombiDDP2");
        }
        if (iFrameworkAccess.getSysConst(522) == 1 && iFrameworkAccess.getSysConst(4581) == 0 && iFrameworkAccess.getSysConst(4168) == 1) {
            this.componentNotPresent("TV");
        }
        if (iFrameworkAccess.getSysConst(4237) == 0 && iFrameworkAccess.getSysConst(5571) == 0 && iFrameworkAccess.getSysConst(4238) == 0) {
            this.componentNotPresent("TerminalMode");
            this.componentNotPresent("TerminalModeAudio");
        }
    }

    StartupManager getStartupManager() {
        return this.startupManager;
    }

    private ChoiceModelApp getSysChoiceModel(int n) {
        return this.startupManager.getSysChoiceModel(n);
    }

    ChoiceModelApp getSysChoiceModel(int n, int n2) {
        return this.startupManager.getSysChoiceModel(n2);
    }

    IFrameworkAccess getFramework() {
        return this.getStartupManager().getFramework();
    }

    private BundleHandler getBundleHandler() {
        return this.bundleHandler;
    }

    private DomainHandler getDomainHandler() {
        return this.getStartupManager().getDomainHandler();
    }

    LogChannel getLog() {
        return this.lc;
    }

    GUIDEModuleManager getGUIGuideModuleManager() {
        return this.guideModuleManager;
    }

    Bundle getBundle(String string) {
        return this.getBundleHandler().getBundle(string);
    }

    ComponentState getStaticInit() {
        return this.getComponentByName("StaticInit");
    }

    ComponentState getHMIBasics() {
        return this.getComponentByName("HMIBasics");
    }

    ComponentState getBeforeAudio() {
        return this.getComponentByName("BeforeAudio");
    }

    ComponentState getBeforeApp() {
        return this.getComponentByName("BeforeApp");
    }

    ComponentState getAddon() {
        return this.getComponentByName("Addon");
    }

    boolean isLastmodeApplication(int n) {
        ComponentState componentState = this.getComponentState(n);
        if (componentState != null) {
            this.lc.log(-2137614336, "AppStateManager.isLastmodeApplication[%2]: %1", componentState.isLastmodeApp(), (long)n);
            return componentState.isLastmodeApp();
        }
        return false;
    }

    boolean isLastmodeAudioApplication(int n) {
        ComponentState componentState = this.getComponentState(n);
        if (componentState != null) {
            this.lc.log(-2137614336, "AppStateManager.isLastmodeAudioApp[%2]: %1", componentState.isLastmodeAudioApp(), (long)n);
            return componentState.isLastmodeAudioApp();
        }
        return false;
    }

    int getSwdlLastmode() {
        return 12;
    }

    ComponentState getSwdl() {
        return this.getComponentByName("SWDLReboot");
    }

    ComponentState getComponentState(int n) {
        ComponentState componentState = null;
        if (n != 0) {
            if (this.lastmodeAppIdMap != null) {
                componentState = (ComponentState)this.lastmodeAppIdMap.get(new Integer(n));
                if (componentState != null) {
                    this.lc.log(-2137614336, "AppstateManager::getComponentState[%2] -> componentName='%1'", (Object)componentState.getComponentName(), (long)n);
                } else {
                    this.lc.log(-1601830656, "AppstateManager::getComponentState[%1] - not found", (long)n);
                }
            } else {
                this.lc.log(10000, "AppstateManager::getComponentState[%1] - map of lastmode Id is not initialized ", (long)n);
            }
        }
        return componentState;
    }

    public ComponentState getComponentByName(String string) {
        return (ComponentState)this.compStateMap.get(string);
    }

    public ComponentState getComponentByBundleName(String string) {
        return (ComponentState)this.bundleStateMap.get(string);
    }

    int convertKeyToLastmode(int n) {
        int n2 = this.keyCodesMap.get(n);
        if (n2 > 0) {
            return n2;
        }
        return 0;
    }

    void addBundleComponentState(String string, ComponentState componentState) {
        if (string != null && componentState != null && this.getComponentByBundleName(string) == null) {
            this.bundleStateMap.put(string, componentState);
        }
    }

    void addComponentState(String string, ComponentState componentState) {
        if (string != null && componentState != null && this.getComponentByName(string) == null) {
            this.compStateMap.put(string, componentState);
        }
    }

    ComponentState[] getComponentStateByDomainId(int n) {
        int n2 = 0;
        Set set = this.compStateMap.keySet();
        ComponentState[] componentStateArray = new ComponentState[set.size()];
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            ComponentState componentState = this.getComponentByName((String)iterator.next());
            if (null == componentState || componentState.getDomainId() != n) continue;
            componentStateArray[n2] = componentState;
            ++n2;
        }
        return n2 > 0 ? componentStateArray : null;
    }

    public String getComponentNameByLastmodeAppId(int n) {
        ComponentState componentState;
        if (this.lastmodeAppIdMap != null && n > 0 && null != (componentState = this.getComponentState(n))) {
            return componentState.getComponentName();
        }
        return null;
    }

    ChoiceModelApp getChoiceModelApp(int n, String string) {
        ComponentState componentState = this.getComponentByName(string);
        if (componentState != null) {
            return componentState.getChoiceModelApp(n, string);
        }
        return null;
    }

    @Override
    public boolean isAppSwdlStarted() {
        ChoiceModelApp choiceModelApp = this.getChoiceModelApp(this.getFramework().isFrontMU() ? 0 : 5, "SWDL");
        if (choiceModelApp != null) {
            return choiceModelApp.getValue() == 1;
        }
        this.lc.log(10000, "Choice model for SWDLApp - not found");
        return false;
    }

    private void componentNotPresent(String string) {
        ComponentState componentState;
        this.lc.log(1078071040, "AppStateManager: component %1 not present", (Object)string);
        ChoiceModelApp choiceModelApp = this.getChoiceModelApp(0, string);
        if (choiceModelApp != null) {
            choiceModelApp.setValue(1024);
            choiceModelApp.setStatus(1);
            this.componentStateChanged(string, 1024);
        }
        if (null != (componentState = this.getComponentByName(string))) {
            componentState.setIsRunning(false);
        }
    }

    public void setNavEnabled(boolean bl, boolean bl2) {
        ComponentState componentState = this.getComponentByName("Navi");
        if (componentState != null) {
            componentState.setEnabled(bl, bl2);
        }
    }

    void updateComponentState(String string) {
        ComponentState componentState = this.getComponentByBundleName(string);
        if (componentState != null) {
            this.getLog().log(1078071040, "AppStateManager.updateComponentState(bundle:%1), componentState:%2 ", (Object)string, (Object)componentState.getComponentName());
            componentState.stateUpdate();
        }
    }

    void initializeModels() {
        this.initComponentStateModels(0);
        this.initComponentStateModels(3);
        this.initComponentStateModels(4);
        this.initComponentStateModels(5);
        this.sysConstIsInitialized();
        Iterator iterator = this.compStateMap.keySet().iterator();
        while (iterator.hasNext()) {
            ComponentState componentState = this.getComponentByName((String)iterator.next());
            if (null == componentState) continue;
            componentState.stateUpdate();
        }
    }

    protected boolean mustWaitForMU(int n) {
        boolean bl = !this.getDomainHandler().isDomainStartedOnMU(n);
        this.lc.log(1078071040, "AppStateManager.mustWaitForMU( %2 ): %1", bl, (long)n);
        return bl;
    }

    @Override
    public void updateDomainState(int n, int n2) {
        Iterator iterator = this.compStateMap.values().iterator();
        while (iterator.hasNext()) {
            ComponentState componentState = (ComponentState)iterator.next();
            if (null == componentState || componentState.getDomainId() != n || !componentState.isReferenced()) continue;
            componentState.updateDomainState(n, n2);
        }
    }

    @Override
    public void muDomainIsAvailable(int n, int n2) {
    }

    public void delayedDomainIsAvailable(int n, int n2) {
    }

    void enqueueBackgroundApps(List list) {
        this.lc.log(1078071040, "AppStateManager.enqueueLastmodeApps()");
        this.startupManager.enqueueStartComponent(list, this.lastmodeOrder, true);
    }

    @Override
    public IProgressMonitor getNavProgressMonitor() {
        if (null == this.navProgressMonitor) {
            LogChannel logChannel = this.getFramework().getLogChannel("App.Navi.Main");
            this.navProgressMonitor = new ProgressMonitor("NavProgressMonitor", logChannel, this.getSysChoiceModel(165), (LabelModelApp)((Object)this.getFramework().getHMIService().getModel(166)), new NaviProgressMap(), 0, true);
        }
        return this.navProgressMonitor;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void registerComponentStateListener(ComponentStateListener componentStateListener) {
        this.lc.log(-2137614336, "registerAppStateListener( %1 )", (Object)componentStateListener);
        if (null != componentStateListener) {
            Object object = this.listeners;
            synchronized (object) {
                this.listeners.add(componentStateListener);
            }
            object = this.compStateMap.values().iterator();
            while (object.hasNext()) {
                ComponentState componentState = (ComponentState)object.next();
                if (componentState == null || componentState.getStateModelId() == 0) continue;
                ChoiceModelApp choiceModelApp = componentState.getSysChoiceModel(0);
                if (choiceModelApp != null) {
                    componentStateListener.appStateChanged(componentState.getComponentName(), choiceModelApp.getValue());
                    continue;
                }
                this.lc.log(10000, "ChoiceModelApp not found for the component %1", (Object)componentState.getComponentName());
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void unregisterComponentStateListener(ComponentStateListener componentStateListener) {
        this.lc.log(-2137614336, "unregisterComponentStateListener( %1 )", (Object)componentStateListener);
        if (componentStateListener != null) {
            List list = this.listeners;
            synchronized (list) {
                this.listeners.remove(componentStateListener);
            }
        }
    }

    void componentStateChanged(String string, int n) {
        for (int i2 = 0; i2 < this.listeners.size(); ++i2) {
            ComponentStateListener componentStateListener = (ComponentStateListener)this.listeners.get(i2);
            componentStateListener.appStateChanged(string, n);
        }
    }

    @Override
    public void enqueueDomainStart(int n, int n2) {
        this.getStartupManager().logStartupEvent(null, 0, new StringBuffer().append("AppStateManager#enqueueDomainStart(").append(this.getDomainName(n)).append(", 0x").append(Integer.toHexString(n2)).append(")").toString());
        this.enqueueDomainStart(this.getStartupManager().getDelayedQueue(), n, n2, n2, null, false, false, null);
    }

    @Override
    public void dump(PrintStream printStream, String string) {
        printStream.println("Lastmode Order:");
        if (this.lastmodeOrder.getSubComponentStates() != null) {
            for (int i2 = 0; i2 < this.lastmodeOrder.getSubComponentStates().length; ++i2) {
                printStream.print(this.lastmodeOrder.getSubComponentStates()[i2].getComponentName());
                printStream.print(i2 < this.lastmodeOrder.getSubComponentStates().length - 1 ? ", " : "");
            }
            printStream.println();
        }
        printStream.println();
        printStream.println("ComponentStates:");
        printStream.println();
        Iterator iterator = new HashSet(this.compStateMap.values()).iterator();
        while (iterator.hasNext()) {
            try {
                ((ComponentState)iterator.next()).dump(printStream);
            }
            catch (Throwable throwable) {
                printStream.println(throwable.toString());
            }
            printStream.println();
        }
    }

    @Override
    public String getName() {
        return "AppStateManager";
    }

    @Override
    public void registerDomainStateListener(IDomainListener iDomainListener) {
        this.getDomainHandler().addDomainListener(iDomainListener);
    }

    @Override
    public void unregisterDomainStateListener(IDomainListener iDomainListener) {
        this.getDomainHandler().removeDomainListener(iDomainListener);
    }

    HashMap getNotStartedComponentMap() {
        return this.notStartedDependentComponents;
    }

    private String getDomainName(int n) {
        return DomainHandler.getDomainName(n);
    }

    void enqueueDomainStart(List list, int n, int n2, int n3, Runnable runnable, boolean bl, boolean bl2, ComponentState componentState) {
        if (this.isDomainEnabled(n)) {
            this.getLog().log(1078071040, "AppStateManager.enqueueDomainStart( %1, 0x%2 )", (long)n, (long)n2);
            this.getStartupManager().getStartupQueue().enqueue(list, new AppStateManager$StartDomain(this, n, n2, n3, runnable, bl, componentState), bl2);
        }
    }

    AppStateManager$DependentCompomnentStart getDependentCompomnentStart(String string, List list, boolean bl) {
        return new AppStateManager$DependentCompomnentStart(this, string, list, bl);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ LogChannel access$000(AppStateManager appStateManager) {
        return appStateManager.lc;
    }

    static /* synthetic */ String access$100(AppStateManager appStateManager, int n) {
        return appStateManager.getDomainName(n);
    }

    static /* synthetic */ DomainHandler access$200(AppStateManager appStateManager) {
        return appStateManager.getDomainHandler();
    }
}

