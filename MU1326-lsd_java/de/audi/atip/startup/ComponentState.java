/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.startup.AppStateManager;
import de.audi.atip.startup.BundleHandler;
import de.audi.atip.startup.ComponentState$1;
import de.audi.atip.startup.ComponentState$CheckDependenciesJob;
import de.audi.atip.startup.ComponentState$WaitForStartupSyncer;
import de.audi.atip.startup.DomainHandler;
import de.audi.atip.startup.GUIDEModuleState;
import de.audi.atip.startup.NullModuleState;
import de.audi.atip.startup.StartupManager;
import de.audi.atip.startup.config.Component;
import de.audi.atip.startup.config.Dependency;
import de.audi.atip.startup.config.Domain;
import de.audi.atip.startup.config.GuideModule;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.osgi.framework.Bundle;

public class ComponentState {
    private static final boolean AT_END;
    private static final boolean AT_FRONT;
    private static final boolean SYNC;
    private static final String[] DOMAIN_STATE_NAMES;
    static final int DOMAIN_START_STATUS_RECOVERY;
    static final int DOMAIN_START_STATUS_ERROR;
    static final int DOMAIN_START_STATUS_DEFINED;
    static final int DOMAIN_START_STATUS_STARTING;
    static final int DOMAIN_START_STATUS_STARTED;
    public static final int STATE_MODEL_ID_UNDEFINED;
    public static final int LASTMODE_ID_UNDEFINED;
    private final AppStateManager appStateManager;
    private boolean isStopped = false;
    private int domainFlags = 0;
    private volatile int domainStartState = 0;
    private boolean enabled = true;
    private final int id;
    private final String componentName;
    private final int domainId;
    private final int keyCode;
    private final int stateFlagsRequired;
    private int stateFlagsMinimum;
    private final int stateModelId;
    private final boolean lastmode;
    private final boolean lastmodeAudio;
    private final boolean lastmodeTransient;
    private final int audioContextID;
    private final List dependencies;
    private List dependentComponents;
    private List stopOnFailDependentComponents;
    private final Bundle[] bundles;
    private ComponentState[] subComponentStates;
    private final GUIDEModuleState guideModuleState;
    private final boolean isReferenced;
    private Component component;
    private boolean isRunning;
    private boolean hasDependentComponents;

    ComponentState(AppStateManager appStateManager, Component component) {
        this.appStateManager = appStateManager;
        this.componentName = component.getName();
        this.isReferenced = component.isReferenced();
        this.guideModuleState = this.getGUIDEModuleState(component.getGuideModule());
        this.id = component.getLastmodeAppId();
        Domain domain = component.getDomain();
        if (domain != null) {
            this.domainId = domain.getId();
            this.stateFlagsRequired = domain.getRequiredState();
            this.stateFlagsMinimum = domain.getMinimumState();
            if (!DomainHandler.isIncluded(this.stateFlagsMinimum, this.stateFlagsRequired)) {
                this.getLog().log(10000, "ComponentState[%1]::initialize: the minimum domain state include(s) bit(s) that is/are not set in the required domain state!", (Object)this.componentName);
                this.stateFlagsMinimum = this.stateFlagsRequired;
            }
        } else {
            this.domainId = 0;
            this.stateFlagsRequired = 0;
            this.stateFlagsMinimum = 0;
        }
        this.stateModelId = component.getStateModelId();
        this.dependencies = component.getAllDependencies();
        this.bundles = this.getBundles(component.getBundleNames());
        this.lastmode = component.isLastmode();
        this.lastmodeAudio = component.isLastmodeAudio();
        this.audioContextID = component.getAudioConextID();
        this.lastmodeTransient = component.isLastmodeTransient();
        this.component = component;
        this.keyCode = component.getKeyCode();
        this.isRunning = false;
    }

    public void initSubComponents() {
        this.hasDependentComponents = false;
        this.initDependentComponents(this.component);
        this.subComponentStates = this.getSubComponentStates(this.component);
        this.component = null;
    }

    private GUIDEModuleState getGUIDEModuleState(GuideModule guideModule) {
        if (guideModule != null) {
            return new GUIDEModuleState(this.appStateManager, this, guideModule);
        }
        return new NullModuleState();
    }

    private Bundle[] getBundles(String[] stringArray) {
        Bundle[] bundleArray = null;
        if (stringArray != null && stringArray.length > 0) {
            bundleArray = new Bundle[stringArray.length];
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                Bundle bundle = this.appStateManager.getBundle(stringArray[i2]);
                if (bundle != null) {
                    bundleArray[i2] = bundle;
                    continue;
                }
                this.getLog().log(10000, "ComponentState[%1]::initBundles: bundle '%2' is not found", (Object)this.componentName, (Object)stringArray[i2]);
            }
        }
        return bundleArray;
    }

    private final ComponentState[] getSubComponentStates(Component component) {
        ComponentState[] componentStateArray = null;
        if (component.getSubComponentsNumber() > 0) {
            componentStateArray = new ComponentState[component.getSubComponentsNumber()];
            for (int i2 = 0; i2 < component.getSubComponentsNumber(); ++i2) {
                Component component2 = component.getSubComponent(i2);
                ComponentState componentState = this.appStateManager.getComponentByName(component2.getName());
                if (componentState == null) {
                    this.getLog().log(1000, "ComponentState.getSubComponentStates: undefined component %1", (Object)component.getName());
                    return null;
                }
                componentStateArray[i2] = componentState;
            }
        }
        return componentStateArray;
    }

    public final String toString() {
        return this.componentName;
    }

    private final LogChannel getLog() {
        return this.appStateManager.getLog();
    }

    private final StartupManager getStartupManager() {
        return this.appStateManager.getStartupManager();
    }

    private final DomainHandler getDomainHandler() {
        return this.getStartupManager().getDomainHandler();
    }

    private final BundleHandler getBundleHandler() {
        return this.getStartupManager().getBundleHandler();
    }

    public int getId() {
        return this.id;
    }

    public String getComponentName() {
        return this.componentName;
    }

    public int getDomainId() {
        return this.domainId;
    }

    public int getStateFlagsRequired() {
        return this.stateFlagsRequired;
    }

    public int getStateFlagsMinimum() {
        return this.stateFlagsMinimum;
    }

    public int getStateModelId() {
        return this.stateModelId;
    }

    public ChoiceModelApp getSysChoiceModel(int n) {
        if (this.appStateManager != null && this.stateModelId != 0) {
            return this.appStateManager.getSysChoiceModel(n, this.stateModelId);
        }
        return null;
    }

    public int getAudioContextID() {
        return this.audioContextID;
    }

    public int getKeyCode() {
        return this.keyCode;
    }

    public boolean isLastmodeApp() {
        return this.lastmode && this.isComponentEnabled();
    }

    public boolean isLastmodeAudioApp() {
        return this.lastmodeAudio;
    }

    public boolean isLastmodeTransient() {
        return this.lastmodeTransient;
    }

    boolean isReferenced() {
        return this.isReferenced;
    }

    Bundle[] getBundles() {
        return this.bundles;
    }

    private void initDependentComponents(Component component) {
        if (this.dependencies != null && !this.dependencies.isEmpty()) {
            this.dependentComponents = new ArrayList(4);
            this.stopOnFailDependentComponents = new ArrayList(2);
            Iterator iterator = this.dependencies.iterator();
            while (iterator.hasNext()) {
                Dependency dependency = (Dependency)iterator.next();
                if (!dependency.isComponentDependency() || dependency.getDependentComponent() == null) continue;
                Component component2 = dependency.getDependentComponent();
                ComponentState componentState = this.appStateManager.getComponentByName(component2.getName());
                if (componentState == null) {
                    this.getLog().log(1000, "ComponentState.initDependentComponents: undefined component %1", (Object)component.getName());
                    continue;
                }
                this.dependentComponents.add(componentState);
                this.hasDependentComponents = true;
                if (!dependency.isStopOnFailDependency()) continue;
                this.stopOnFailDependentComponents.add(componentState);
            }
        }
    }

    ComponentState[] getSubComponentStates() {
        return this.subComponentStates;
    }

    public final Dependency getDependency(int n) {
        return n >= 0 && n < this.dependencies.size() ? (Dependency)this.dependencies.get(n) : null;
    }

    private final void enqueueStartSubComponents(List list, boolean bl) {
        if (this.subComponentStates != null) {
            for (int i2 = 0; i2 < this.subComponentStates.length; ++i2) {
                this.getLog().log(-2137614336, "ComponentState[%1]::enqueStartSubComponents %2", (Object)this.getComponentName(), (Object)this.subComponentStates[i2].getComponentName());
                this.subComponentStates[i2].enqueueStartFull(list, bl);
            }
        }
    }

    private final void enqueueStartDependencies(List list, boolean bl) {
        if (this.dependencies != null && !this.dependencies.isEmpty()) {
            this.getLog().log(-2137614336, "ComponentState[%1]::enqueueStartDependencies", (Object)this.getComponentName());
            Iterator iterator = this.dependencies.iterator();
            while (iterator.hasNext()) {
                Dependency dependency = (Dependency)iterator.next();
                if (dependency.isComponentDependency() && dependency.getDependentComponent() != null) {
                    ComponentState componentState = this.appStateManager.getComponentByName(dependency.getDependentComponent().getName());
                    if (componentState != null) {
                        componentState.enqueueStartFull(list, bl);
                        continue;
                    }
                    this.getLog().log(10000, "ComponentState[%1]::enqueueStartDependencies - no ComponentState of dependent component %2 found", (Object)this.getComponentName(), (Object)dependency.getDependentComponent().getName());
                    continue;
                }
                this.enqueueDomainStart(list, dependency.getDomain(), dependency.getState(), dependency.getState(), null, dependency.isAsync(), bl);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean checkDependencies(List list, boolean bl) {
        if (this.dependencies != null && !this.dependencies.isEmpty()) {
            this.getLog().log(-2137614336, "ComponentState[%1]::checkDependencies(%2,%3)", (Object)this.getComponentName(), (Object)list, (Object)Boolean.toString(bl));
            HashMap hashMap = this.appStateManager.getNotStartedComponentMap();
            synchronized (hashMap) {
                Iterator iterator = this.dependencies.iterator();
                while (iterator.hasNext()) {
                    ComponentState componentState;
                    Dependency dependency = (Dependency)iterator.next();
                    if (!dependency.isComponentDependency()) continue;
                    this.getLog().log(-2137614336, "ComponentState[%1]:checkDependencies: %2 %3", (Object)this.getComponentName(), (Object)dependency.getDependentComponentName(), (Object)(dependency.isStartAnywayDependency() ? "start anyway" : ""));
                    if (dependency.getDependentComponent() == null || dependency.isStartAnywayDependency() || (componentState = this.appStateManager.getComponentByName(dependency.getDependentComponent().getName())) == null || componentState.isRunning) continue;
                    if (list != null) {
                        this.getLog().log(-2137614336, "ComponentState[%1]::checkDependencies(%2,%3):add", (Object)this.getComponentName(), (Object)list, (Object)Boolean.toString(bl));
                        this.appStateManager.addNotStartedDependendComponent(componentState, this.appStateManager.getDependentCompomnentStart(this.getComponentName(), list, bl));
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private final void enqueueStartBundles(List list, Bundle[] bundleArray, boolean bl) {
        block4: {
            if (bundleArray == null) break block4;
            if (bl) {
                for (int i2 = bundleArray.length - 1; i2 >= 0; --i2) {
                    if (bundleArray[i2] == null) continue;
                    this.enqueueStartBundle(list, bundleArray[i2], bl);
                    this.getLog().log(-2137614336, "ComponentState[%1]::enqueueStartBundles: Enqueue bundle '%2'", (Object)this.componentName, (Object)this.getBundleName(i2));
                }
            } else {
                for (int i3 = 0; i3 < bundleArray.length; ++i3) {
                    if (bundleArray[i3] == null) continue;
                    this.enqueueStartBundle(list, bundleArray[i3], bl);
                    this.getLog().log(-2137614336, "ComponentState[%1]::enqueueStartBundles: Enqueue bundle '%2'", (Object)this.componentName, (Object)this.getBundleName(i3));
                }
            }
        }
    }

    private final void enqueueStopBundles(List list, Bundle[] bundleArray, boolean bl) {
        block4: {
            if (bundleArray == null) break block4;
            if (bl) {
                for (int i2 = 0; i2 < bundleArray.length; ++i2) {
                    this.enqueueStopBundle(list, bundleArray[i2], bl);
                }
            } else {
                for (int i3 = bundleArray.length - 1; i3 >= 0; --i3) {
                    this.enqueueStopBundle(list, bundleArray[i3], bl);
                }
            }
        }
    }

    synchronized void stateUpdate() {
        if (this.isEnabled()) {
            if (this.isStarted()) {
                this.getLog().log(1078071040, "ComponentState[%1] flag component as started", (Object)this.componentName);
                this.componentStarted(this.getComponentName());
                this.isStopped = false;
            } else if (!this.isStopped()) {
                this.getLog().log(1078071040, "ComponentState[%1] flag component as stopped", (Object)this.componentName);
                this.componentStopped(this.componentName);
                this.isStopped = true;
            } else {
                this.getLog().log(1078071040, "ComponentState[%1] remains not completely started ", (Object)this.componentName);
            }
        } else {
            this.getLog().log(1078071040, "ComponentState[%1] flag component as not enabled", (Object)this.componentName);
            this.componentNotEnabled(this.componentName);
        }
    }

    boolean isStarted() {
        return this.checkBundlesActive() && this.getGUIDEModuleState().isActive() && this.checkDependencies(null, false);
    }

    boolean isStopped() {
        return this.isStopped;
    }

    private boolean checkBundlesActive() {
        if (this.bundles != null && this.bundles.length > 0) {
            for (int i2 = 0; i2 < this.bundles.length; ++i2) {
                if (this.bundles[i2] != null && this.bundles[i2].getState() == 32) continue;
                this.getLog().log(-2137614336, "ComponentState[%1].checkBundlesActive: bundle %2 isn't active", (Object)this.componentName, (Object)this.getBundleName(i2));
                return false;
            }
        }
        return true;
    }

    void setDomainStartState(int n) {
        this.domainStartState = n;
    }

    void setEnabled(boolean bl, boolean bl2) {
        this.enabled = bl;
        this.stateUpdate();
        if (bl && bl2 && this.getStartupManager().getDelayedQueue() != null) {
            this.enqueueStartFull(this.getStartupManager().getDelayedQueue(), false);
        }
    }

    boolean isEnabled() {
        return this.enabled;
    }

    private String getBundleName(int n) {
        return this.getBundleHandler().getBundleName(this.bundles[n]);
    }

    GUIDEModuleState getGUIDEModuleState() {
        return this.guideModuleState;
    }

    boolean isDomainFailed() {
        return this.domainStartState == -1;
    }

    boolean isWaitingForDomainStart() {
        if (this.domainId > 0) {
            return this.getDomainHandler().isWaitingForResponse(this.getDomainId(), this.getStateFlagsMinimum());
        }
        return false;
    }

    ChoiceModelApp getChoiceModelApp(int n, String string) {
        if (string == null) {
            return null;
        }
        if (this.getStateModelId() != 0) {
            return this.getSysChoiceModel(n);
        }
        this.getLog().log(-2137614336, "ComponentState::getChoiceModelApp[%1] - choice model not found", (Object)string);
        return null;
    }

    boolean isComponentEnabled() {
        if ("System".equals(this.getComponentName())) {
            return true;
        }
        ChoiceModelApp choiceModelApp = this.getChoiceModelApp(0, this.getComponentName());
        if (choiceModelApp != null) {
            if ((choiceModelApp.getValue() & 0xFFFFFD00) != 0) {
                this.getLog().log(1078071040, "ComponentState: Application '%1' is not enabled", (Object)this.getComponentName());
                return false;
            }
            this.getLog().log(1078071040, "ComponentState: Application '%1' is enabled", (Object)this.getComponentName());
            return true;
        }
        this.getLog().log(1078071040, "ComponentState: No Application state model found for '%1'!", (Object)this.getComponentName());
        return true;
    }

    private void enqueue(List list, Runnable runnable, boolean bl) {
        this.getStartupManager().getStartupQueue().enqueue(list, runnable, bl);
    }

    void enqueueStartBundle(List list, Bundle bundle, boolean bl) {
        this.getStartupManager().enqueueStartBundle(list, bundle, this, bl);
    }

    void enqueueStopBundle(List list, Bundle bundle, boolean bl) {
        this.getStartupManager().enqueueStopBundle(list, bundle, bl);
    }

    void enqueueStartBundlesAtomic(List list, Bundle[] bundleArray, boolean bl) {
        this.getStartupManager().enqueueStartBundles(list, bundleArray, this, bl);
    }

    void enqueueStopBundlesAtomic(List list, Bundle[] bundleArray, boolean bl) {
        this.getStartupManager().enqueueStopBundles(list, bundleArray, bl);
    }

    void enqueueDomainStart(List list, int n, int n2, int n3, Runnable runnable, boolean bl, boolean bl2) {
        this.getLog().log(1078071040, "ComponentState[%1] enqueueDomainStart( %2, 0x%3 )", (Object)this.getComponentName(), (long)n, (long)n2);
        if (bl || !DomainHandler.isFailed(this.domainFlags)) {
            this.appStateManager.enqueueDomainStart(list, n, n2, n3, runnable, bl, bl2, this);
        }
    }

    private void enqueueStart(List list, boolean bl, boolean bl2) {
        boolean bl3;
        boolean bl4 = bl3 = this.getId() != -1 && this.getStartupManager().getLastmodeHandler().isValidAudioLastmode(this.getId());
        if (bl) {
            Bundle[] bundleArray;
            if (bl2) {
                this.enqueueWaitAfterFullStart(list, true);
                this.enqueueStartSubComponents(list, true);
            }
            if ((bundleArray = this.getAtomicBundles()) != null) {
                this.enqueueStartBundlesAtomic(list, bundleArray, true);
            } else {
                this.enqueueStartBundles(list, this.bundles, true);
                this.guideModuleState.enqueueStartBundles(list, true);
            }
            if (bl3) {
                this.getStartupManager().getLastmodeHandler().setLastmodeAudioStarted(-1, true);
            }
        } else {
            Bundle[] bundleArray = this.getAtomicBundles();
            if (bundleArray != null) {
                this.enqueueStartBundlesAtomic(list, bundleArray, false);
            } else {
                this.guideModuleState.enqueueStartBundles(list, false);
                this.enqueueStartBundles(list, this.bundles, false);
            }
            if (bl2) {
                this.enqueueStartSubComponents(list, false);
                this.enqueueWaitAfterFullStart(list, false);
            }
            if (bl3) {
                this.getStartupManager().getLastmodeHandler().setLastmodeAudioStarted(-1, true);
            }
        }
    }

    private final Runnable getDelayedStart(List list, boolean bl) {
        return new ComponentState$1(this, list, bl);
    }

    public void enqueueComponentStart(List list, boolean bl, boolean bl2) {
        this.getLog().log(1078071040, "ComponentState[%1] enqueueStart(startSubComponents:%2)", (Object)this.getComponentName(), (Object)bl2);
        if (this.isComponentEnabled()) {
            if (this.hasDependentComponents()) {
                if (bl) {
                    this.enqueueCheckDependencies(list, true, bl2);
                    this.enqueueStartDependencies(list, true);
                } else {
                    this.enqueueStartDependencies(list, false);
                    this.enqueueCheckDependencies(list, false, bl2);
                }
            } else if (bl) {
                if (this.getDomainId() > 0) {
                    this.enqueueDomainStart(list, this.getDomainId(), this.getStateFlagsMinimum(), this.getStateFlagsRequired(), this.getDelayedStart(list, bl2), false, true);
                } else {
                    this.enqueueStart(list, true, bl2);
                }
                this.enqueueStartDependencies(list, true);
            } else {
                this.enqueueStartDependencies(list, false);
                if (this.getDomainId() > 0) {
                    this.enqueueDomainStart(list, this.getDomainId(), this.getStateFlagsMinimum(), this.getStateFlagsRequired(), this.getDelayedStart(list, bl2), false, false);
                } else {
                    this.enqueueStart(list, false, bl2);
                }
            }
        } else {
            this.getLog().log(1078071040, "ComponentState[%1] enqueueStart(): application is disabled", (Object)this.getComponentName());
        }
    }

    void enqueueStartAudio(List list) {
        this.getLog().log(1078071040, "ComponentState[%1] startAudio()", (Object)this.getComponentName());
        this.enqueueComponentStart(list, false, false);
    }

    void enqueueStartLastmode(List list) {
        this.getLog().log(1078071040, "ComponentState[%1] startLastmode()", (Object)this.getComponentName());
        this.enqueueComponentStart(list, false, true);
    }

    private void enqueueNavSyncer(List list, boolean bl) {
        this.enqueue(list, new ComponentState$WaitForStartupSyncer(this.getStartupManager().getSyncNav(), null), bl);
    }

    void enqueueCheckDependencies(List list, boolean bl, boolean bl2) {
        this.enqueue(list, new ComponentState$CheckDependenciesJob(this, list, bl2), bl);
    }

    private void enqueueWaitAfterFullStart(List list, boolean bl) {
        if (this.getDomainId() == 6) {
            ComponentState componentState = this.appStateManager.getComponentByName("TTS");
            if (componentState != null) {
                if (bl) {
                    this.enqueueNavSyncer(list, true);
                    componentState.enqueueStartFull(list, true);
                } else {
                    componentState.enqueueStartFull(list, false);
                    this.enqueueNavSyncer(list, false);
                }
            } else {
                this.enqueueNavSyncer(list, bl);
            }
        }
    }

    public void enqueueStartFull(List list, boolean bl) {
        this.getLog().log(1078071040, "ComponentState[%1] enqueueStartFull()", (Object)this.getComponentName());
        this.enqueueComponentStart(list, bl, true);
    }

    private void enqueStartFullWithStopOnFailDependentComponents(List list, boolean bl) {
        this.enqueueStartFull(list, bl);
        List list2 = this.appStateManager.getStopOnFailComponents(this.getComponentName());
        if (list2 != null) {
            Iterator iterator = list2.iterator();
            while (iterator.hasNext()) {
                ComponentState componentState = (ComponentState)iterator.next();
                this.getLog().log(1078071040, "ComponentState[%1] enqueStartFullWithStopOnFailDependentComponents() stop on fail dependent component: %2", (Object)this.getComponentName(), (Object)componentState.getComponentName());
                componentState.enqueStartFullWithStopOnFailDependentComponents(list, bl);
            }
        }
    }

    private Bundle[] getAtomicBundles() {
        ArrayList arrayList = new ArrayList();
        this.guideModuleState.appendBundles(arrayList);
        if (arrayList.isEmpty()) {
            return null;
        }
        if (this.bundles != null) {
            for (int i2 = 0; i2 < this.bundles.length; ++i2) {
                arrayList.add(this.bundles[i2]);
            }
        }
        return (Bundle[])arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public void enqueueStopApp(List list) {
        if (this.isComponentEnabled()) {
            Bundle[] bundleArray;
            this.getLog().log(1078071040, "ComponentState[%1] stopApp()", (Object)this.getComponentName());
            List list2 = this.appStateManager.getStopOnFailComponents(this.getComponentName());
            if (list2 != null) {
                bundleArray = list2.iterator();
                while (bundleArray.hasNext()) {
                    ComponentState componentState = (ComponentState)bundleArray.next();
                    this.getLog().log(-2137614336, "ComponentState[%1] stopApp stopOnFail component: %2", (Object)this.getComponentName(), (Object)componentState.getComponentName());
                    componentState.enqueueStopApp(list);
                }
            }
            if (this.getSubComponentStates() != null && this.getSubComponentStates().length > 0) {
                for (int i2 = this.getSubComponentStates().length - 1; i2 >= 0; --i2) {
                    this.getSubComponentStates()[i2].enqueueStopApp(list);
                }
            }
            if ((bundleArray = this.getAtomicBundles()) != null) {
                for (int i3 = 0; i3 < bundleArray.length / 2; ++i3) {
                    Bundle bundle = bundleArray[i3];
                    bundleArray[i3] = bundleArray[bundleArray.length - 1 - i3];
                    bundleArray[bundleArray.length - 1 - i3] = bundle;
                }
                this.enqueueStopBundlesAtomic(list, bundleArray, false);
            } else {
                this.enqueueStopBundles(list, this.bundles, false);
                this.guideModuleState.enqueueStopBundles(list, false);
            }
            if (this.getDomainId() == 6) {
                this.getStartupManager().getSyncNav().cancel();
            }
        }
    }

    void updateDomainState(int n, int n2) {
        this.domainFlags = n2;
        if (n == this.getDomainId()) {
            this.getLog().log(1078071040, "ComponentState[%1].updateDomainState(0x%2)", (Object)this.getComponentName(), (long)n2);
            if (DomainHandler.isFailed(n2)) {
                if (this.domainStartState != -1) {
                    this.getLog().log(1078071040, "ComponentState[%1] stopApp ( Error )", (Object)this.getComponentName());
                    this.enqueueStopApp(this.getStartupManager().getShutdownQueue());
                }
                this.domainStartState = -1;
            } else if (this.domainStartState == -1) {
                this.getLog().log(1078071040, "ComponentState[%1] enqueStartFullWithStopOnFailDependentComponents ( Recovery from Error )", (Object)this.getComponentName());
                this.enqueStartFullWithStopOnFailDependentComponents(this.getStartupManager().getDelayedQueue(), false);
            }
            if (DomainHandler.isIncluded(this.getStateFlagsMinimum(), n2)) {
                if (this.domainStartState == 0) {
                    this.domainStartState = 2;
                } else if (this.domainStartState == 1) {
                    this.domainStartState = 2;
                    this.getLog().log(1078071040, "ComponentState[%1] enqueueStart ( Delayed )", (Object)this.getComponentName());
                    this.enqueueStart(this.getStartupManager().getDelayedQueue(), true, true);
                } else if (this.domainStartState == -2) {
                    this.getLog().log(1078071040, "ComponentState[%1] enqueStartFullWithStopOnFailDependentComponents ( Recovery )", (Object)this.getComponentName());
                    this.enqueStartFullWithStopOnFailDependentComponents(this.getStartupManager().getDelayedQueue(), false);
                }
            } else if (this.domainStartState == 2) {
                this.getLog().log(1078071040, "ComponentState[%1] stopApp ( Recovery )", (Object)this.getComponentName());
                this.enqueueStopApp(this.getStartupManager().getShutdownQueue());
                this.domainStartState = -2;
            }
        }
        this.stateUpdate();
    }

    void setIsRunning(boolean bl) {
        this.isRunning = bl;
    }

    private final String getDomainStateName() {
        return DOMAIN_STATE_NAMES[this.domainStartState + 2];
    }

    boolean hasDependentComponents() {
        return this.hasDependentComponents;
    }

    public static String getBundleStateName(Bundle bundle) {
        switch (bundle.getState()) {
            case 1: {
                return "UNINSTALLED";
            }
            case 2: {
                return "INSTALLED";
            }
            case 4: {
                return "RESOLVED";
            }
            case 8: {
                return "STARTING";
            }
            case 16: {
                return "STOPPING";
            }
            case 32: {
                return "ACTIVE";
            }
        }
        return "";
    }

    List getStopOnFailDependentComponents() {
        return this.stopOnFailDependentComponents;
    }

    private final void printBundleStates(PrintStream printStream, String string) {
        if (this.bundles != null) {
            printStream.println("  bundleStates: ");
            for (int i2 = 0; i2 < this.bundles.length; ++i2) {
                String string2 = this.getBundleName(i2);
                printStream.print(string);
                printStream.print(string2);
                printStream.print(" = ");
                printStream.println(ComponentState.getBundleStateName(this.bundles[i2]));
            }
        }
    }

    public void dump(PrintStream printStream) {
        ChoiceModelApp choiceModelApp;
        int n;
        printStream.print("Component[");
        printStream.print(this.getId());
        printStream.print("] ");
        printStream.println(this.getComponentName());
        this.printBundleStates(printStream, "    ");
        this.guideModuleState.dump(printStream);
        if (this.dependencies != null && !this.dependencies.isEmpty()) {
            printStream.println("  Dependencies:");
            for (n = 0; n < this.dependencies.size(); ++n) {
                printStream.print("   ");
                printStream.println(this.dependencies.get(n));
            }
        }
        if (this.getDomainId() > 0) {
            printStream.print("  DomainId: ");
            printStream.print(this.getDomainId());
            printStream.print(" required state: 0x");
            printStream.print(Integer.toHexString(this.getStateFlagsRequired()));
            if (this.getStateFlagsRequired() != this.getStateFlagsMinimum()) {
                printStream.print(" minimum state: 0x");
                printStream.print(Integer.toHexString(this.getStateFlagsMinimum()));
            }
            printStream.print("  domainState = ");
            printStream.println(this.getDomainStateName());
        } else {
            printStream.println("  No Domain");
        }
        if (this.getKeyCode() != 0) {
            printStream.print(" keyCode= ");
            printStream.println(this.getKeyCode());
        }
        printStream.print("  enabled = ");
        printStream.println(this.enabled);
        printStream.print("  isRunning = ");
        printStream.println(this.isRunning);
        if (this.getStartupManager().isHMIServiceAvailable() && (choiceModelApp = this.appStateManager.getChoiceModelApp(0, this.getComponentName())) != null) {
            printStream.print("  Model: ");
            printStream.print(choiceModelApp.getID());
            printStream.print(", Value: ");
            printStream.print(choiceModelApp.getValue());
            printStream.print(", Status: ");
            printStream.println(choiceModelApp.getStatus());
        }
        if (this.subComponentStates != null && this.subComponentStates.length > 0) {
            printStream.println("  SubComponents:");
            for (n = 0; n < this.subComponentStates.length; ++n) {
                printStream.print("   ");
                printStream.println(this.subComponentStates[n].getComponentName());
            }
        }
    }

    private void componentStarted(String string) {
        this.getLog().log(1078071040, "ComponentState: component %1 is started!", (Object)string);
        ChoiceModelApp choiceModelApp = this.getChoiceModelApp(0, string);
        if (choiceModelApp != null && (choiceModelApp.getValue() == 0 || choiceModelApp.getValue() == 512)) {
            choiceModelApp.setValue(1);
            choiceModelApp.setStatus(1);
            this.appStateManager.componentStateChanged(string, 1);
        }
        this.setIsRunning(true);
        this.appStateManager.checkNotStartedDependendComponents(string);
    }

    private void componentStopped(String string) {
        ChoiceModelApp choiceModelApp = this.getChoiceModelApp(0, string);
        if (choiceModelApp != null && (choiceModelApp.getValue() == 1 || choiceModelApp.getValue() == 512)) {
            this.getLog().log(1078071040, "ComponentState: component %1 is not (yet) started!", (Object)string);
            choiceModelApp.setValue(0);
            choiceModelApp.setStatus(0);
            this.appStateManager.componentStateChanged(string, 0);
        }
        this.setIsRunning(false);
    }

    private void componentNotEnabled(String string) {
        this.getLog().log(1078071040, "ComponentState: component %1 not enabled", (Object)string);
        ChoiceModelApp choiceModelApp = this.getChoiceModelApp(0, string);
        if (choiceModelApp != null && (choiceModelApp.getValue() == 1 || choiceModelApp.getValue() == 0)) {
            choiceModelApp.setValue(512);
            choiceModelApp.setStatus(1);
            this.appStateManager.componentStateChanged(string, 512);
        }
    }

    static /* synthetic */ void access$000(ComponentState componentState, List list, boolean bl, boolean bl2) {
        componentState.enqueueStart(list, bl, bl2);
    }

    static /* synthetic */ boolean access$200(ComponentState componentState, List list, boolean bl) {
        return componentState.checkDependencies(list, bl);
    }

    static /* synthetic */ LogChannel access$300(ComponentState componentState) {
        return componentState.getLog();
    }

    static /* synthetic */ Runnable access$400(ComponentState componentState, List list, boolean bl) {
        return componentState.getDelayedStart(list, bl);
    }

    static {
        DOMAIN_STATE_NAMES = new String[]{"Recovery", "Error", "Defined", "Starting", "Running"};
    }
}

