/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.i18n.I18NTarget;
import de.audi.atip.i18n.Language;
import de.audi.atip.interapp.IConnectivityRHMIStateListener;
import de.audi.atip.interapp.NaviOnlineService;
import de.audi.atip.interapp.NaviOnlineService$MapStateService;
import de.audi.atip.interapp.OnlineHMIService;
import de.audi.atip.interapp.OnlineService;
import de.audi.atip.interapp.OnlineServiceListener;
import de.audi.atip.interapp.PortalAuthenticationService;
import de.audi.atip.interapp.PortalAuthenticationService$UpdateProfileInfoListener;
import de.audi.atip.interapp.SDSService;
import de.audi.atip.interapp.audio.VolumeOnOffPressListener;
import de.audi.atip.interapp.media.IMediaDrawerContext;
import de.audi.atip.interapp.media.IMediaOnlinePlayerService;
import de.audi.atip.interapp.media.IMediaService;
import de.audi.atip.interapp.messaging.folderbrowsing.IFolderBrowsingService;
import de.audi.atip.interapp.online.IRemoteHMIEsimLicenseListener;
import de.audi.atip.interapp.online.IRemoteHMIMediaOnlineServiceListener;
import de.audi.atip.interapp.online.OnlinePOICall;
import de.audi.atip.interapp.tts.TTSSessionBasedService;
import de.audi.atip.job.JobLogger;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.Consumption;
import de.audi.atip.metrics.Distance;
import de.audi.atip.metrics.Pressure;
import de.audi.atip.metrics.Speed;
import de.audi.atip.metrics.Temperature;
import de.audi.atip.metrics.Volume;
import de.audi.atip.msg.MsgListener;
import de.audi.atip.util.StringUtilities;
import de.audi.remotehmi.HMIProperties;
import de.audi.remotehmi.IOsrUserCacheInformation;
import de.audi.remotehmi.IRemoteHMI;
import de.audi.remotehmi.IRemoteHMIListener;
import de.audi.remotehmi.IRemoteHMIListener$LogLevel;
import de.audi.remotehmi.IRemoteHMISpeechCommandSDS;
import de.audi.remotehmi.IRemoteHMISpeechContext;
import de.audi.remotehmi.IRemoteHMISpeechContext$CommandDisplay;
import de.audi.remotehmi.IRemoteHMISpeechHelpContext;
import de.audi.remotehmi.IRemoteHMISpeechHelpIntroPrompt;
import de.audi.remotehmi.IRemoteHMISpeechTopicContext;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.remotehmi.RemoteHMIView;
import de.audi.remotehmi.ui.mib2.grid.IGridFactory;
import de.audi.remotehmi.ui.mib2.grid.IGridList;
import de.audi.remotehmi.util.LogAppender$Factory;
import de.audi.tghu.online.app.Online;
import de.audi.tghu.online.app.operatorcall.AbstractOperatorCallMain;
import de.audi.tghu.online.app.osr.IOnlineLanguageListener;
import de.audi.tghu.online.app.osr.license.LicenseCollectionService;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.AbstractExternalServiceProvider;
import de.audi.tghu.online.app.remotehmi.AbstractHMIViewListener;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMIComponent;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMILockingListener;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMIViewTask;
import de.audi.tghu.online.app.remotehmi.CarCodingComponent;
import de.audi.tghu.online.app.remotehmi.ContextManagerComponent;
import de.audi.tghu.online.app.remotehmi.DiagnosisComponent;
import de.audi.tghu.online.app.remotehmi.EntryPoint;
import de.audi.tghu.online.app.remotehmi.IndicateViewPropertyTask;
import de.audi.tghu.online.app.remotehmi.InitializationComponent;
import de.audi.tghu.online.app.remotehmi.LockingModelGroup;
import de.audi.tghu.online.app.remotehmi.MediaSubEntryPointsContainer;
import de.audi.tghu.online.app.remotehmi.NaviComponent;
import de.audi.tghu.online.app.remotehmi.OnlineModelBankAccess;
import de.audi.tghu.online.app.remotehmi.OpenTimedJobQueue;
import de.audi.tghu.online.app.remotehmi.PhoneComponent;
import de.audi.tghu.online.app.remotehmi.RemoteHMIAnimationComponent;
import de.audi.tghu.online.app.remotehmi.RemoteHMIComponentFactory;
import de.audi.tghu.online.app.remotehmi.RemoteHMIConnectivityChangedService;
import de.audi.tghu.online.app.remotehmi.RemoteHMIContext;
import de.audi.tghu.online.app.remotehmi.RemoteHMIDSIAccess;
import de.audi.tghu.online.app.remotehmi.RemoteHMIDSIAccess$IRemoteHMIDSIListener;
import de.audi.tghu.online.app.remotehmi.RemoteHMIMediaHandler;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService$1;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService$10;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService$11;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService$12;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService$13;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService$14;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService$15;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService$16;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService$17;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService$18;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService$19;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService$2;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService$20;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService$21;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService$22;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService$23;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService$24;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService$25;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService$26;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService$3;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService$4;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService$5;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService$6;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService$7;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService$8;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService$9;
import de.audi.tghu.online.app.remotehmi.RemoteHMITask;
import de.audi.tghu.online.app.remotehmi.UpdatingIconComponent;
import de.audi.tghu.online.app.remotehmi.browser.RemoteHMIBrowserComponent;
import de.audi.tghu.online.app.remotehmi.browser.RemoteHMIEfiComponent;
import de.audi.tghu.online.app.remotehmi.onlinemedia.OnlineMediaComponent;
import de.audi.tghu.online.app.remotehmi.sds.HMISpeechASRListener;
import de.audi.tghu.online.app.remotehmi.sds.HMISpeechTTSListener;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import de.esolutions.fw.util.commons.job.Job;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class RemoteHMIService
implements IRemoteHMIListener,
I18NTarget,
MsgListener,
RemoteHMIDSIAccess$IRemoteHMIDSIListener {
    public static final int DISABLED;
    public static final int ENABLED;
    protected LockingModelGroup hmiModelGroup;
    protected LogChannel logChannel;
    private LogChannel dispatcherLogChannel;
    protected LogChannel logChannelInterpreter;
    private IMediaDrawerContext mediaDrawerContext;
    private HMISpeechASRListener hmiAsrListener = null;
    private HMISpeechTTSListener hmiTtsListener = null;
    protected final IFrameworkAccess frameworkAccess;
    protected HMIService hmiService;
    private OnlineHMIService onlineHmiService;
    private String initialLanguage = null;
    private RemoteHMIAnimationComponent animationComponent;
    private SDSService sdsService;
    protected OnlineModelBankAccess modelBank;
    private RemoteHMIBrowserComponent browserComponent;
    protected RemoteHMIDSIAccess dsiAccess;
    protected ContextManagerComponent contextManagerComponent;
    private Map viewListenerMap = new HashMap();
    private RemoteHMIConnectivityChangedService connectivityChangedService;
    private InitializationComponent initComponent;
    private Map commandHandlers = new HashMap();
    private List components = new ArrayList(5);
    protected NaviComponent naviComponent;
    protected PhoneComponent phoneComponent;
    private IRemoteHMIMediaOnlineServiceListener remoteHMIMediaOnlineServiceListener;
    private RemoteHMIEfiComponent efiComponent;
    protected OnlineMediaComponent onlineMediaComponent;
    private DiagnosisComponent infotainmentRecorderComponent;
    private PortalAuthenticationService portalAuthentication;
    protected IGridFactory gridFactory;
    private CarCodingComponent carCodingComponent;
    private final DispatcherBase dispatcher;
    protected LicenseCollectionService licensingCollector;
    protected IConnectivityRHMIStateListener connectivityStateListener;
    private UpdatingIconComponent updatingIconComponent;
    private NaviOnlineService$MapStateService mapStateService;
    private AbstractOperatorCallMain operatorCallController;
    private IOsrUserCacheInformation ioSrUserCacheInformation;
    private IRemoteHMIEsimLicenseListener remoteHMIESimLicenseListener;
    private IFolderBrowsingService remotehmiFolderBrowsingService;
    private OnlinePOICall onlineOperatorCallService;
    private boolean privacyModeFeatureAvailable = true;
    protected AbstractRemoteHMILockingListener lockingListener;
    protected ModelGroup viewTypeModelGroup;
    private IOnlineLanguageListener languageListener;
    private int oldViewType;
    private Object oldViewId = "";
    private Object oldContextName = "";
    private volatile int overrideAnimation = -1;
    private volatile boolean entered = false;
    private volatile int entryPointId = 0;

    public RemoteHMIService(LogChannel logChannel, LogChannel logChannel2, IFrameworkAccess iFrameworkAccess, OnlineModelBankAccess onlineModelBankAccess) {
        this(logChannel, logChannel2, iFrameworkAccess, onlineModelBankAccess, false, null);
    }

    public void setPrivacyModeFeatureAvailable(boolean bl) {
        this.logChannel.log(1078071040, "RemoteHMIService#setPrivacyModeFeatureAvailable: %1", bl);
        this.privacyModeFeatureAvailable = bl;
        if (this.dsiAccess != null) {
            this.logChannel.log(1078071040, "RemoteHMIService#setPrivacyModeFeatureAvailable: forward to RemoteHMI.");
            this.invokeActionImmediately(this.getAction(1));
        }
    }

    protected RemoteHMIService(LogChannel logChannel, LogChannel logChannel2, IFrameworkAccess iFrameworkAccess, OnlineModelBankAccess onlineModelBankAccess, boolean bl, RemoteHMIComponentFactory remoteHMIComponentFactory) {
        RemoteHMIComponentFactory remoteHMIComponentFactory2;
        this.frameworkAccess = iFrameworkAccess;
        this.modelBank = onlineModelBankAccess;
        this.logChannel = logChannel;
        this.logChannelInterpreter = logChannel2;
        this.hmiService = iFrameworkAccess.getHMIService();
        this.dispatcherLogChannel = iFrameworkAccess.getLogChannel("App.Online.RemoteHMI.Dispatcher");
        JobLogger jobLogger = new JobLogger(this.dispatcherLogChannel);
        OpenTimedJobQueue openTimedJobQueue = new OpenTimedJobQueue(iFrameworkAccess.getMonotonicTimeSource());
        this.dispatcher = iFrameworkAccess.getDispatcherManager().createDispatcher("Online.RemoteHMI", jobLogger, openTimedJobQueue);
        this.dispatcher.start();
        RemoteHMIComponentFactory remoteHMIComponentFactory3 = remoteHMIComponentFactory2 = remoteHMIComponentFactory == null ? new RemoteHMIComponentFactory() : remoteHMIComponentFactory;
        if (bl) {
            return;
        }
        this.hmiModelGroup = new LockingModelGroup(logChannel, iFrameworkAccess);
        this.contextManagerComponent = remoteHMIComponentFactory2.createContextManagerComponent();
        this.addComponent(this.contextManagerComponent);
        this.browserComponent = remoteHMIComponentFactory2.createBrowserComponent();
        this.addComponent(this.browserComponent);
        this.dsiAccess = new RemoteHMIDSIAccess(logChannel, this);
        this.hmiAsrListener = remoteHMIComponentFactory2.createASRListener();
        this.addComponent(this.hmiAsrListener);
        this.hmiTtsListener = remoteHMIComponentFactory2.createTTSComponent();
        this.addComponent(this.hmiTtsListener);
        this.onlineMediaComponent = remoteHMIComponentFactory2.createOnlineMediaComponent();
        this.addComponent(this.onlineMediaComponent);
        this.updatingIconComponent = remoteHMIComponentFactory2.createUpdatingIconComponent();
        this.addComponent(this.updatingIconComponent);
        this.contextManagerComponent.setContextChangeListener(this.updatingIconComponent);
        if (!iFrameworkAccess.isTarget()) {
            iFrameworkAccess.getHmiServiceApp().getChoiceModel(367).setValue(1);
        }
        this.initComponent = remoteHMIComponentFactory2.createInitializationComponent();
        this.addComponent(this.initComponent);
        this.animationComponent = remoteHMIComponentFactory2.createAnimationComponent();
        this.addComponent(this.animationComponent);
        this.naviComponent = remoteHMIComponentFactory2.createNaviComponent();
        this.addComponent(this.naviComponent);
        this.phoneComponent = remoteHMIComponentFactory2.createPhoneComponent();
        this.addComponent(this.phoneComponent);
        this.efiComponent = remoteHMIComponentFactory2.createEfiComponent();
        this.addComponent(this.efiComponent);
        this.carCodingComponent = remoteHMIComponentFactory2.createCarCodingComponent();
        this.addComponent(this.carCodingComponent);
        this.infotainmentRecorderComponent = remoteHMIComponentFactory2.createDiagnosisComponent();
        this.addComponent(this.infotainmentRecorderComponent);
        this.dsiAccess.addDSIListener(this.carCodingComponent);
        this.viewTypeModelGroup = new ModelGroup();
        ChoiceModelApp choiceModelApp = this.hmiService.getChoiceModel(-1508367616);
        choiceModelApp.setStatus(14000);
        this.viewTypeModelGroup.add(choiceModelApp);
        this.initializeViewListeners();
        this.initializeCommandListeners();
    }

    protected final void addComponent(AbstractRemoteHMIComponent abstractRemoteHMIComponent) {
        abstractRemoteHMIComponent.init(this.logChannel, this);
        this.components.add(abstractRemoteHMIComponent);
    }

    protected void initializeCommandListeners() {
        this.addCommandHandler(212570177, new RemoteHMIService$1(this, "provide-grid-factory"));
        this.addCommandHandler(501, new RemoteHMIService$2(this, "invalidate-speech-help-context"));
        this.addCommandHandler(850104385, new RemoteHMIService$3(this, "update-service-discovery-devices"));
        this.addCommandHandler(346787905, new RemoteHMIService$4(this, "applist-loaded"));
        this.addCommandHandler(514560065, new RemoteHMIService$5(this, "servicelist-updated"));
        this.addCommandHandler(734957633, new RemoteHMIService$6(this, "status-mobile-applist-download"));
        this.addCommandHandler(751734849, new RemoteHMIService$7(this, "received-subscribe-message-count"));
        this.addCommandHandler(768512065, new RemoteHMIService$8(this, "parsed-mobile-apps"));
        this.addCommandHandler(785289281, new RemoteHMIService$9(this, "last-backend-access"));
        this.addCommandHandler(229347393, new RemoteHMIService$10(this, "grid-resource-available"));
    }

    protected abstract void initializeViewListeners() {
    }

    public void setIRemoteHMI(IRemoteHMI iRemoteHMI) {
        if (iRemoteHMI == null) {
            this.logChannel.log(1078071040, "RemoteHMIService#setIRemoteHMI: null");
            this.dsiAccess.setIRemoteHMI(null);
            this.initComponent.setInitialized(false);
            return;
        }
        this.dsiAccess.setIRemoteHMI(iRemoteHMI);
        this.logChannel.log(1078071040, "RemoteHMIService#setIRemoteHMI: send initial action data");
        this.invokeActionImmediately(this.getAction(1));
        if (this.initialLanguage != null) {
            iRemoteHMI.setHMILanguage(this.initialLanguage);
        } else {
            iRemoteHMI.setHMILanguage(this.getLanguageString());
        }
    }

    @Override
    public final void indicateView(String string, RemoteHMIView remoteHMIView) {
        this.logChannel.log(1078071040, "RemoteHMIService#indicateView: updating view for %1", (Object)string);
        this.execute(new RemoteHMIService$11(this, "indicate-view", LogAppender$Factory.fromString(string), string, remoteHMIView));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void cancelViewDependentJobsForContext(String string) {
        OpenTimedJobQueue openTimedJobQueue;
        OpenTimedJobQueue openTimedJobQueue2 = openTimedJobQueue = (OpenTimedJobQueue)this.dispatcher.getQueue();
        synchronized (openTimedJobQueue2) {
            Iterator iterator = openTimedJobQueue.getJobs().iterator();
            while (iterator.hasNext()) {
                AbstractRemoteHMIViewTask abstractRemoteHMIViewTask;
                Job job = (Job)iterator.next();
                Object object = job.getPayload();
                if (!(object instanceof AbstractRemoteHMIViewTask) || !(abstractRemoteHMIViewTask = (AbstractRemoteHMIViewTask)object).getContextName().equals(string)) continue;
                job.cancel();
                this.logChannel.log(1078071040, "RemoteHMIService#cancelViewDependentJobsForContext: cancelled previously scheduled view dependent task %1", (Object)abstractRemoteHMIViewTask);
            }
        }
    }

    public void loadView(String string, RemoteHMIView remoteHMIView) {
        this.logChannel.log(-2137614336, "RemoteHMIService#loadView: Loading view for %1 with view type = %2.", (Object)string, (long)remoteHMIView.getViewType());
        this.loadView(string, remoteHMIView.getViewType(), remoteHMIView.getViewID(), remoteHMIView.getProperties());
    }

    protected abstract void updateViews(LogChannel logChannel, String string, IGridList iGridList, boolean bl, Set set, AbstractHMIViewListener abstractHMIViewListener, int n) {
    }

    protected abstract void applyPropertyChanges(AbstractHMIViewListener abstractHMIViewListener, Set set, HMIProperties hMIProperties) {
    }

    public void loadView(String string, int n, String string2, HMIProperties hMIProperties) {
        Object object;
        int n2;
        this.logChannel.log(-2137614336, "RemoteHMIService#loadView: updating view for context %1", (Object)string);
        RemoteHMIContext remoteHMIContext = this.contextManagerComponent.getContext(string);
        if (remoteHMIContext == null) {
            this.logChannel.log(10000, "RemoteHMIService#loadView: context is null. No new screen shown.");
            return;
        }
        this.logChannel.log(1078071040, "CurrentContext is: %1", (Object)this.contextManagerComponent.getCurrentContext());
        AbstractHMIViewListener abstractHMIViewListener = remoteHMIContext.getViewListener();
        if (abstractHMIViewListener != null) {
            abstractHMIViewListener.onExit();
        }
        boolean bl = false;
        AbstractHMIViewListener abstractHMIViewListener2 = this.getViewListener(n);
        boolean bl2 = this.contextManagerComponent.isContextActive(remoteHMIContext);
        this.logChannel.log(1078071040, "RemoteHMIService#loadView is context active:  %1", bl2);
        if (abstractHMIViewListener2 != null) {
            n2 = n;
            remoteHMIContext.updateContext(n2, string2, hMIProperties, abstractHMIViewListener2);
            if (bl2) {
                boolean bl3;
                Object object2;
                if (hMIProperties != null) {
                    hMIProperties.setGridListSender("RemoteHMIService#loadView");
                }
                if (hMIProperties != null && (object2 = hMIProperties.get("gridList")) instanceof IGridList && (object = (IGridList)object2).getIdRangeStart() != 0) {
                    object.addUpdateMode(5);
                    object.setUpdateSource(11);
                }
                if (bl2 && abstractHMIViewListener2 != null && abstractHMIViewListener2.isTriggerScreenChange() && abstractHMIViewListener2.isModelGroupLockEnabled()) {
                    this.lockModelGroup();
                    if (this.oldViewType == n2 && this.oldViewId.equals(string2) && this.oldContextName.equals(string)) {
                        bl3 = true;
                        this.logChannel.log(1078071040, "RemoteHMIService#loadView: old and new view are the same (e.g. restoring old view after context change).");
                    } else {
                        bl3 = false;
                    }
                    this.oldViewType = n2;
                    this.oldViewId = string2 == null ? "" : string2;
                    this.oldContextName = string == null ? "" : string;
                } else {
                    bl3 = false;
                }
                try {
                    abstractHMIViewListener2.updateViewProperties(hMIProperties, true, remoteHMIContext);
                    bl = true;
                }
                catch (Exception exception) {
                    this.logChannel.log(10000, "RemoteHMIService#loadView: Exception in updateViewProperties, %1", (Throwable)exception);
                }
                this.getDiagnosisComponent().update(string2, 1);
                this.animationComponent.configureAnimation(string, abstractHMIViewListener2, this.overrideAnimation, bl3);
                this.overrideAnimation = -1;
            } else {
                this.logChannel.log(1078071040, "RemoteHMIService#loadView: Not updating view because context %1 not active. Ignoring viewType %2.", (Object)string, (long)n);
            }
        } else if (n == -1872822016) {
            n2 = n;
            this.logChannel.log(1078071040, "RemoteHMIService#loadView: view type exit");
        } else {
            this.logChannel.log(10000, "RemoteHMIService#loadView: Unknown new viewType=%1", (long)n);
            n2 = 0;
            remoteHMIContext.updateContext(n2, null, null, null);
        }
        if (bl2 && (abstractHMIViewListener2 == null || abstractHMIViewListener2.isTriggerScreenChange())) {
            this.logChannel.log(1078071040, "RemoteHMIService#loadView: view type=%1, view ID %2, context='%3'", (Object)Integer.toString(n2), (Object)string2, (Object)string);
            EntryPoint entryPoint = this.contextManagerComponent.getCurrentEntryPoint();
            if (entryPoint != null && entryPoint.getEntryPointId() == 1 && n2 == 3000 && this.contextManagerComponent.isIgnoreScreenConnect()) {
                this.logChannel.log(1078071040, "RemoteHMIService#loadView: ignoring view connnect");
                this.contextManagerComponent.setIgnoreScreenConnect(false);
            } else {
                object = this.modelBank.getChoiceModel(-1508367616);
                this.logChannel.log(-2137614336, "RemoteHMIService#loadView: changing REMOTE_HMI_CURRENT_VIEW_CHOICE status from %1 to %2", (long)object.getStatus(), (long)n2);
                object.setStatus(n2);
                object.setValue(object.getValue() ^ 1);
                this.viewTypeModelGroup.flush();
            }
        }
        if (bl) {
            this.flushModelGroup();
            this.releaseAppStartupWaitingScreen(true);
            EntryPoint entryPoint = this.contextManagerComponent.getCurrentEntryPoint();
            if (entryPoint == null) {
                this.logChannel.log(-1601830656, "RemoteHMIService#loadView: called for context '%1' but entrypoint is null which should not happen", (Object)string);
                return;
            }
            object = entryPoint.getCurrentContext();
            if (object == null) {
                this.logChannel.log(-1601830656, "RemoteHMIService#loadView: called for context '%1' and entrypoint context is null which should never happen", (Object)string);
                return;
            }
            String string3 = ((RemoteHMIContext)object).getContextName();
            if (!string.equals(string3)) {
                this.logChannel.log(1078071040, "RemoteHMIService#loadView: called for context '%1' but entrypoint context is '%2' so can't remove waiting screen", (Object)string, (Object)string3);
                return;
            }
            this.triggerScreenEnter(string3);
        }
    }

    public void releaseAppStartupWaitingScreen(boolean bl) {
    }

    protected void triggerScreenEnter(String string) {
        this.logChannel.log(-1601830656, "RemoteHMIService#triggerScreenEnter: has to be overridden in the derived class");
    }

    @Override
    public final void indicateViewProperties(String string, RemoteHMIView remoteHMIView) {
        this.execute(new IndicateViewPropertyTask("indicate-view-properties", LogAppender$Factory.fromString(string), this, string, remoteHMIView, this.contextManagerComponent, this.logChannel));
    }

    @Override
    public void indicateSpeechContext(String string, IRemoteHMISpeechContext iRemoteHMISpeechContext) {
        this.execute(new RemoteHMIService$12(this, "indicate-speech-context", LogAppender$Factory.fromString(string), string, iRemoteHMISpeechContext));
    }

    public void configureRemoteHMIContext() {
        EntryPoint entryPoint = this.contextManagerComponent.getCurrentEntryPoint();
        if (entryPoint == null) {
            this.logChannel.log(-1601830656, "RemoteHMIService#configureRemoteHMIContext: current entry point is null");
            return;
        }
        RemoteHMIContext remoteHMIContext = entryPoint.getCurrentContext();
        String string = remoteHMIContext == null ? null : remoteHMIContext.getContextName();
        String string2 = StringUtilities.getStringNotNull(entryPoint.getNameOfContextToBeStarted());
        int n = entryPoint.getEntryPointId();
        if (string == null && string2.equals("")) {
            this.logChannel.log(-1601830656, "RemoteHMIService#configureRemoteHMIContext: No context and nameOfContextToBeStarted exists for the entrypoint");
            if (n == 3 || n == 2) {
                ChoiceModelApp choiceModelApp = this.getModelBankAccess().getChoiceModel(-1508367616);
                choiceModelApp.setStatus(-1872822016);
                this.contextManagerComponent.setWaitForApplicationValue(0);
                choiceModelApp.setValue(choiceModelApp.getValue() ^ 1);
                this.viewTypeModelGroup.flush();
            } else {
                this.contextManagerComponent.setWaitForApplicationValue(2);
            }
            return;
        }
        if (string == null && n == 1) {
            string = entryPoint.getNameOfContextToBeStarted();
            this.logChannel.log(1078071040, "RemoteHMIService#configureRemoteHMIContext: current current for Audiconnect is null so using nameOfContextToBeStarted '%1'", (Object)string);
        }
        this.getBrowserController().checkWakeup();
        if (string == null) {
            this.logChannel.log(-1601830656, "RemoteHMIService#configureRemoteHMIContext: no contextName exists so can't trigger signal to south side");
            return;
        }
        this.dsiAccess.setContext(string);
        this.logChannel.log(1078071040, "RemoteHMIService#configureRemoteHMIContext: signal for starting context '%1' for entrypoint '%2' sent to south side", (Object)string, (long)n);
    }

    public void addCommandHandler(int n, AbstractCommandHandler abstractCommandHandler) {
        Integer n2 = new Integer(n);
        Object object = this.commandHandlers.get(n2);
        if (this.commandHandlers.containsKey(n2)) {
            String string = new StringBuffer().append("commandId ").append(n).append(" is already registered to handler '").append(object).append("', not setting it for requested handler '").append(abstractCommandHandler).append("'!").toString();
            this.logChannel.log(10000, new StringBuffer().append("RemoteHMIService#addCommandHandler:").append(string).toString());
            throw new IllegalStateException(string);
        }
        this.commandHandlers.put(n2, abstractCommandHandler);
    }

    @Override
    public final void indicateCommand(int n, Object object) {
        this.logChannel.log(-2137614336, "RemoteHMIService#indicateCommand: state %1", (long)n);
        Integer n2 = new Integer(n);
        AbstractCommandHandler abstractCommandHandler = (AbstractCommandHandler)this.commandHandlers.get(n2);
        if (abstractCommandHandler == null) {
            this.logChannel.log(-1601830656, "RemoteHMIService#indicateCommand: no handler found: %1", (Object)n2);
            return;
        }
        RemoteHMITask remoteHMITask = abstractCommandHandler.createTask(n, object);
        this.execute(new RemoteHMIService$13(this, "indicate-command", LogAppender$Factory.fromObject(abstractCommandHandler, 64), remoteHMITask));
    }

    public String getCurrentViewId() {
        RemoteHMIContext remoteHMIContext = this.contextManagerComponent.getCurrentContext();
        if (remoteHMIContext == null) {
            return null;
        }
        return remoteHMIContext.getViewId();
    }

    public HMISpeechTTSListener getTTS() {
        return this.hmiTtsListener;
    }

    public void setTTSService(TTSSessionBasedService tTSSessionBasedService) {
        this.hmiTtsListener.setTTSService(tTSSessionBasedService);
    }

    public void setOnlineMediaService(IMediaOnlinePlayerService iMediaOnlinePlayerService) {
        this.onlineMediaComponent.setOnlineMediaService(iMediaOnlinePlayerService);
    }

    public void setMediaService(IMediaService iMediaService) {
        this.onlineMediaComponent.setMediaService(iMediaService);
    }

    public OnlineMediaComponent getOnlineMediaComponent() {
        return this.onlineMediaComponent;
    }

    public void setSDSOnlineServiceListener(OnlineServiceListener onlineServiceListener) {
        this.hmiAsrListener.setOnlineServiceListener(onlineServiceListener);
    }

    public OnlineService getOnlineService() {
        return this.hmiAsrListener;
    }

    public void invokeAction(RemoteHMIAction remoteHMIAction) {
        this.invokeActionImmediately(remoteHMIAction);
    }

    protected void invokeActionImmediately(RemoteHMIAction remoteHMIAction) {
        if (remoteHMIAction == null) {
            if (this.logChannel != null) {
                this.logChannel.log(-1601830656, "RemoteHMIService#invokeActionImmediately: action was null!");
            }
            return;
        }
        this.logChannel.log(1078071040, "RemoteHMIService#invokeActionImmediately: called for action type '%1'", (long)remoteHMIAction.getType());
        this.adaptCoverArtDownload(remoteHMIAction);
        if (this.contextManagerComponent != null) {
            RemoteHMIContext remoteHMIContext = this.contextManagerComponent.getCurrentContext();
            if (remoteHMIContext != null) {
                this.dsiAccess.action(remoteHMIContext.getContextName(), remoteHMIAction);
            } else {
                this.dsiAccess.action(null, remoteHMIAction);
            }
        } else {
            this.logChannel.log(-1601830656, "RemoteHMIService#invokeActionImmediately: contextManagerComponent was null!");
        }
    }

    private void adaptCoverArtDownload(RemoteHMIAction remoteHMIAction) {
        if (remoteHMIAction.getType() == -575563776) {
            EntryPoint entryPoint = this.contextManagerComponent.getEntryPointFromMap(4);
            MediaSubEntryPointsContainer mediaSubEntryPointsContainer = entryPoint.getSubEntryPointContainer();
            EntryPoint entryPoint2 = mediaSubEntryPointsContainer.getCurrentEntryPoint();
            if (entryPoint2 == null) {
                this.logChannel.log(-2137614336, "RemoteHMIService#adaptCoverArtDownload: no subentry point found, action parameter PROP_ONLINE_MEDIA_CURRENT_CONTEXT not set.");
                return;
            }
            String string = entryPoint2.getNameOfContextToBeStarted();
            RemoteHMIContext remoteHMIContext = entryPoint2.getCurrentContext();
            if (remoteHMIContext != null) {
                String string2 = remoteHMIContext.getContextName();
                remoteHMIAction.getParameters().putString("onlineMediaCurrentContext", string2);
                this.logChannel.log(-2137614336, "RemoteHMIService#invokeActionImmediately: action type '%1'. Got current context name %2.", (Object)Integer.toString(remoteHMIAction.getType()), (Object)string2);
            } else if (string != null && !string.equals("")) {
                remoteHMIAction.getParameters().putString("onlineMediaCurrentContext", string);
                this.logChannel.log(-2137614336, "RemoteHMIService#invokeActionImmediately: action type '%1'. Got context name to be started %2.", (Object)Integer.toString(remoteHMIAction.getType()), (Object)string);
            } else {
                this.logChannel.log(-1601830656, "RemoteHMIService#invokeActionImmediately: action type '%1'. Could not retrieve media entry point. MediaCurrentEntryPoint.id = %2", (Object)Integer.toString(remoteHMIAction.getType()), (long)entryPoint2.getEntryPointId());
            }
        }
    }

    public IFrameworkAccess getFrameworkAccess() {
        return this.frameworkAccess;
    }

    @Override
    public void indicateSpeechHelpContexts(IRemoteHMISpeechHelpContext[] iRemoteHMISpeechHelpContextArray, IRemoteHMISpeechTopicContext[] iRemoteHMISpeechTopicContextArray, IRemoteHMISpeechHelpIntroPrompt iRemoteHMISpeechHelpIntroPrompt) {
        this.execute(new RemoteHMIService$14(this, "indicate-speech-help-contexts", iRemoteHMISpeechHelpContextArray, iRemoteHMISpeechTopicContextArray, iRemoteHMISpeechHelpIntroPrompt));
    }

    @Override
    public void indicateSpeechGlobalCommands(IRemoteHMISpeechCommandSDS[] iRemoteHMISpeechCommandSDSArray) {
        this.execute(new RemoteHMIService$15(this, "indicate-speech-global-commands", iRemoteHMISpeechCommandSDSArray));
    }

    @Override
    public void indicateContextsCommandDisplay(IRemoteHMISpeechContext$CommandDisplay iRemoteHMISpeechContext$CommandDisplay) {
    }

    public void setOnlineHmiService(OnlineHMIService onlineHMIService) {
        this.onlineHmiService = onlineHMIService;
    }

    public void setSDSService(SDSService sDSService) {
        this.sdsService = sDSService;
    }

    public OnlineHMIService getOnlineHMIService() {
        return this.onlineHmiService;
    }

    @Override
    public void indicateCurrentSpeechHelpContext(String string) {
        this.execute(new RemoteHMIService$16(this, "indicate-current-speech-help-context", string));
    }

    @Override
    public void setLanguage(Language language) {
        this.logChannel.log(1078071040, "RemoteHMIService#setLanguage: trigger set language %1", (Object)language);
        String string = this.getCorrectLanguageString(language);
        if (this.languageListener != null) {
            this.languageListener.setLanguage(string);
        }
        this.execute(new RemoteHMIService$17(this, "set-language", LogAppender$Factory.fromString(language == null ? "null" : string), language, string));
    }

    protected String getCorrectLanguageString(Language language) {
        String string = language.getHmiCode();
        if (language.getHmiCode().equals("nb_NO")) {
            string = language.getLanguageCode();
        }
        this.logChannel.log(-2137614336, "RemoteHMIService#getCorrectLanguageString: having corrected lanuage %1", (Object)string);
        return string;
    }

    private void invalidateSpeechHelpContext() {
        if (this.hmiAsrListener != null) {
            this.hmiAsrListener.indicateSpeechHelpContexts(null, null, null);
            this.logChannel.log(1078071040, "RemoteHMIService#invalidateSpeechHelpContext: Called");
        }
    }

    public HMISpeechASRListener getASR() {
        return this.hmiAsrListener;
    }

    public String getLanguageString() {
        Buffer buffer = new Buffer();
        Language language = Online.getInstance().getFramework().getLanguageMgr().getCurrentLanguage("LANG_COMPONENT_HMI");
        buffer.append(this.getCorrectLanguageString(language));
        NaviOnlineService naviOnlineService = this.naviComponent.getNaviOnlineService();
        if (naviOnlineService != null) {
            buffer.append(';');
            buffer.append(naviOnlineService.getDataFallBackLanguage());
        }
        return buffer.toString();
    }

    public void onExit() {
        this.logChannel.log(1078071040, "RemoteHMIService#onExit: Called.");
        for (int i2 = 0; i2 < this.components.size(); ++i2) {
            AbstractRemoteHMIComponent abstractRemoteHMIComponent = (AbstractRemoteHMIComponent)this.components.get(i2);
            try {
                abstractRemoteHMIComponent.onExit();
                continue;
            }
            catch (Exception exception) {
                this.logChannel.log(-1601830656, "RemoteHMIService#onExit: Exception in %1.onExit. %1", (Object)super.getClass().getName(), (Throwable)exception);
            }
        }
        this.contextManagerComponent.showProviderLogo("");
        this.logChannel.log(1078071040, "RemoteHMIService#onExit: sending EXIT action to interpreter");
        this.invokeAction(this.getAction(2));
        this.animationComponent.reset();
    }

    public void onEnter() {
        this.configureRemoteHMIContext();
        RemoteHMIAction remoteHMIAction = this.getAction(950179840);
        this.invokeAction(remoteHMIAction);
        this.logChannel.log(1078071040, "RemoteHMIService#onEnter: Called.");
        for (int i2 = 0; i2 < this.components.size(); ++i2) {
            AbstractRemoteHMIComponent abstractRemoteHMIComponent = (AbstractRemoteHMIComponent)this.components.get(i2);
            abstractRemoteHMIComponent.onEnter();
        }
    }

    @Override
    public void processMsg(int n) {
        if (n == 88) {
            this.execute(new RemoteHMIService$18(this, "reset-to-factory-settings"));
        } else if (n == 11) {
            this.execute(new RemoteHMIService$19(this, "units-changed"));
        } else if (n == 206) {
            if (this.lockingListener != null) {
                this.lockingListener.updateLockingState(true);
            } else {
                this.logChannel.log(1078071040, "RemoteHMIService#processMsg:  Locking concept not activated. (%1)", (long)n);
            }
            AbstractHMIViewListener abstractHMIViewListener = this.getViewListener(13000);
            if (abstractHMIViewListener != null) {
                abstractHMIViewListener.updateLockingState(true);
            }
        } else if (n == 207) {
            if (this.lockingListener != null) {
                this.lockingListener.updateLockingState(false);
            } else {
                this.logChannel.log(1078071040, "RemoteHMIService#processMsg:  Locking concept not activated. (%1)", (long)n);
            }
            AbstractHMIViewListener abstractHMIViewListener = this.getViewListener(13000);
            if (abstractHMIViewListener != null) {
                abstractHMIViewListener.updateLockingState(false);
            }
        }
    }

    public abstract RemoteHMIMediaHandler getMediaHandler() {
    }

    public AbstractHMIViewListener getCurrentView() {
        RemoteHMIContext remoteHMIContext = this.contextManagerComponent.getCurrentContext();
        if (remoteHMIContext == null) {
            return null;
        }
        return remoteHMIContext.getViewListener();
    }

    public RemoteHMIAction getAction(int n) {
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        String string7;
        RemoteHMIAction remoteHMIAction = new RemoteHMIAction(n);
        NaviOnlineService naviOnlineService = this.naviComponent.getNaviOnlineService();
        if (naviOnlineService != null) {
            string7 = naviOnlineService.getDataCountryAbbreviation();
            if (string7 != null) {
                remoteHMIAction.getParameters().put("carCountryAbbrev", StringUtilities.getStringNotNull(string7));
            }
            remoteHMIAction.getParameters().put("carVin", StringUtilities.getStringNotNull(naviOnlineService.getDataVIN()));
            remoteHMIAction.getParameters().put("carDay", StringUtilities.getStringNotNull(naviOnlineService.getDataDayNightView()));
            remoteHMIAction.getParameters().putInt("carXres", naviOnlineService.getDataScreenWidth());
            remoteHMIAction.getParameters().putInt("carYres", naviOnlineService.getDataScreenHeight());
        }
        string7 = "high";
        if (this.isScale()) {
            string7 = "low";
        } else if (this.isTT()) {
            string7 = "highTT";
        }
        remoteHMIAction.getParameters().putString("carScreenLayout", string7);
        remoteHMIAction.getParameters().put("carRevision", StringUtilities.getStringNotNull(this.hmiService.getLabelModel(151).getText()));
        remoteHMIAction.getParameters().putInt("carType", this.hmiService.getChoiceModel(42).getValue());
        remoteHMIAction.getParameters().put("carLan", this.getLanguageString());
        remoteHMIAction.getParameters().put("carOem", "audi");
        remoteHMIAction.getParameters().put("hmiBase", "MIB2Evo");
        remoteHMIAction.getParameters().putBoolean("privacyFeatureActivated", this.privacyModeFeatureAvailable);
        switch (Distance.getSystemUnit()) {
            case 1: {
                string6 = "km";
                break;
            }
            case 2: 
            case 3: 
            case 4: {
                string6 = "m";
                break;
            }
            default: {
                string6 = "km";
            }
        }
        remoteHMIAction.getParameters().put("carUnitDist", string6);
        switch (Speed.getSystemUnit()) {
            case 1: {
                string5 = "km/h";
                break;
            }
            case 2: {
                string5 = "mph";
                break;
            }
            default: {
                string5 = "km/h";
            }
        }
        remoteHMIAction.getParameters().put("carUnitVel", string5);
        switch (Temperature.getSystemUnit()) {
            case 1: {
                string4 = "C";
                break;
            }
            case 2: {
                string4 = "F";
                break;
            }
            case 3: {
                string4 = "K";
                break;
            }
            default: {
                string4 = "C";
            }
        }
        remoteHMIAction.getParameters().put("carUnitTemp", string4);
        switch (Pressure.getSystemUnit()) {
            case 1: {
                string3 = "bar";
                break;
            }
            case 2: {
                string3 = "psi";
                break;
            }
            default: {
                string3 = "bar";
            }
        }
        remoteHMIAction.getParameters().put("carUnitPress", string3);
        switch (Consumption.getSystemUnit()) {
            case 1: {
                string2 = "l/100km";
                break;
            }
            case 4: {
                string2 = "km/l";
                break;
            }
            case 2: {
                string2 = "mpg_US";
                break;
            }
            case 3: {
                string2 = "mpg_UK";
                break;
            }
            default: {
                string2 = "l/100km";
            }
        }
        remoteHMIAction.getParameters().put("carUnitFuel", string2);
        switch (Volume.getSystemUnit()) {
            case 3: {
                string = "gal_uk";
                break;
            }
            case 2: {
                string = "gal_us";
                break;
            }
            default: {
                string = "l";
            }
        }
        remoteHMIAction.getParameters().put("carUnitVolume", string);
        long l = System.currentTimeMillis() - this.frameworkAccess.getKombiTime();
        remoteHMIAction.getParameters().putString("carKombiTimeDiff", Long.toString(l));
        return remoteHMIAction;
    }

    public boolean isScreenLayoutHigh() {
        return !this.isScale() && !this.isTT();
    }

    public boolean isScale() {
        return this.getFrameworkAccess().getScreenRes() == 1;
    }

    public boolean isTT() {
        return this.getFrameworkAccess().getScreenRes() == 4;
    }

    public OnlineModelBankAccess getModelBankAccess() {
        return this.modelBank;
    }

    public RemoteHMIBrowserComponent getBrowserController() {
        return this.browserComponent;
    }

    @Override
    public void indicateContext(String string, int n) {
        this.execute(new RemoteHMIService$20(this, "indicate-context", LogAppender$Factory.fromString(string), string, n));
    }

    public void setColor(int n) {
        this.logChannel.log(1078071040, "RemoteHMIService#setColor: %1", (Object)Integer.toString(n));
        this.modelBank.getChoiceModel(-1525144832).setValue(n);
    }

    public InitializationComponent getInitializationHandler() {
        return this.initComponent;
    }

    public SDSService getSDSService() {
        return this.sdsService;
    }

    public RemoteHMIContext getContext() {
        return this.contextManagerComponent.getCurrentContext();
    }

    public void putViewListener(AbstractHMIViewListener abstractHMIViewListener, int n) {
        this.viewListenerMap.put(new Integer(n), abstractHMIViewListener);
    }

    public AbstractHMIViewListener getViewListener(int n) {
        return (AbstractHMIViewListener)this.viewListenerMap.get(new Integer(n));
    }

    @Override
    public void stopResult(int n) {
    }

    @Override
    public void setContextResult(int n) {
    }

    public NaviComponent getNaviComponent() {
        return this.naviComponent;
    }

    public PhoneComponent getPhoneComponent() {
        return this.phoneComponent;
    }

    public RemoteHMIEfiComponent getEfiComponent() {
        return this.efiComponent;
    }

    @Override
    public void indicateLogMessage(IRemoteHMIListener$LogLevel iRemoteHMIListener$LogLevel, String string, String string2, Object object, Object object2, Object object3, Object object4) {
        LogChannel logChannel = this.logChannelInterpreter;
        if (logChannel == null) {
            return;
        }
        int n = iRemoteHMIListener$LogLevel.equals(IRemoteHMIListener$LogLevel.TRACE) ? 14808325 : (iRemoteHMIListener$LogLevel.equals(IRemoteHMIListener$LogLevel.DEBUG) ? -2137614336 : (iRemoteHMIListener$LogLevel.equals(IRemoteHMIListener$LogLevel.INFO) ? 1078071040 : (iRemoteHMIListener$LogLevel.equals(IRemoteHMIListener$LogLevel.WARN) ? -1601830656 : (iRemoteHMIListener$LogLevel.equals(IRemoteHMIListener$LogLevel.ERROR) ? 10000 : -1601830656))));
        if (n > logChannel.getCurrentLogThreshold()) {
            return;
        }
        boolean bl = false;
        if (object instanceof Throwable) {
            this.logException(logChannel, string, string2, object, object2, object3, object4, n, (Throwable)object);
            bl = true;
        }
        if (object2 instanceof Throwable) {
            this.logException(logChannel, string, string2, object, object2, object3, object4, n, (Throwable)object2);
            bl = true;
        }
        if (object3 instanceof Throwable) {
            this.logException(logChannel, string, string2, object, object2, object3, object4, n, (Throwable)object3);
            bl = true;
        }
        if (object4 instanceof Throwable) {
            this.logException(logChannel, string, string2, object, object2, object3, object4, n, (Throwable)object4);
            bl = true;
        }
        if (!bl) {
            Buffer buffer = new Buffer("[".length() + string.length() + "]: ".length() + string2.length());
            buffer.append("[");
            buffer.append(string);
            buffer.append("]: ");
            buffer.append(string2);
            String string3 = buffer.toString();
            logChannel.log(n, string3, object, object2, object3, object4);
        }
    }

    private void logException(LogChannel logChannel, String string, String string2, Object object, Object object2, Object object3, Object object4, int n, Throwable throwable) {
        Buffer buffer = new Buffer(128);
        buffer.append("[");
        buffer.append(string);
        buffer.append("]: ");
        buffer.append(string2);
        String string3 = buffer.toString();
        buffer.clear();
        StringUtilities.formatMessage(buffer, string3, new String[]{String.valueOf(object), String.valueOf(object2), String.valueOf(object3), String.valueOf(object4)});
        String string4 = buffer.toString();
        logChannel.log(n, string4, throwable);
    }

    public ContextManagerComponent getContextManagerComponent() {
        return this.contextManagerComponent;
    }

    @Override
    public void indicateContextRemoved(String string) {
        this.execute(new RemoteHMIService$21(this, "context-removed", LogAppender$Factory.fromString(string), string));
    }

    @Override
    public void indicateContextCreated(String string, int n) {
        this.execute(new RemoteHMIService$22(this, "context-created", LogAppender$Factory.fromString(string), string, n));
    }

    @Override
    public void indicateContextSuspended(String string) {
        this.execute(new RemoteHMIService$23(this, "context-suspended", LogAppender$Factory.fromString(string), string));
    }

    public IRemoteHMIMediaOnlineServiceListener getRemoteHMIMediaOnlineServiceListener() {
        return this.remoteHMIMediaOnlineServiceListener;
    }

    public void setRemoteHMIMediaOnlineServiceListener(IRemoteHMIMediaOnlineServiceListener iRemoteHMIMediaOnlineServiceListener) {
        this.remoteHMIMediaOnlineServiceListener = iRemoteHMIMediaOnlineServiceListener;
    }

    public void setAuthenticationService(PortalAuthenticationService portalAuthenticationService) {
        this.portalAuthentication = portalAuthenticationService;
        if (portalAuthenticationService != null) {
            PortalAuthenticationService$UpdateProfileInfoListener portalAuthenticationService$UpdateProfileInfoListener = (PortalAuthenticationService$UpdateProfileInfoListener)((Object)this.getViewListener(13000));
            if (portalAuthenticationService$UpdateProfileInfoListener != null) {
                portalAuthenticationService.registerUpdateProfileInfoListener(portalAuthenticationService$UpdateProfileInfoListener);
            }
            portalAuthenticationService.registerUpdateProfileInfoListener(new RemoteHMIService$24(this));
        }
    }

    protected void forwardProfileInfoChanged(Object object) {
        this.logChannel.log(1078071040, "RemoteHMIService#updateProfileInfo queuing Authentication-result-action");
        RemoteHMIAction remoteHMIAction = new RemoteHMIAction(-340224000);
        remoteHMIAction.getParameters().put("userAuthenticationResult", object);
        this.ioSrUserCacheInformation = (IOsrUserCacheInformation)object;
        this.execute(new RemoteHMIService$25(this, "authentication-result-task", remoteHMIAction));
    }

    public PortalAuthenticationService getAuthenticationService() {
        return this.portalAuthentication;
    }

    public abstract Object getDistributedServiceComponent() {
    }

    public boolean hasDsiAccess() {
        return this.dsiAccess.hasDSI();
    }

    public abstract Object getI18NTextComponent() {
    }

    public abstract AbstractExternalServiceProvider getOnlineServiceProvider() {
    }

    public boolean isTarget() {
        return this.frameworkAccess.isTarget();
    }

    public void setConnectivtyStateListener(IConnectivityRHMIStateListener iConnectivityRHMIStateListener) {
        this.connectivityStateListener = iConnectivityRHMIStateListener;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void execute(RemoteHMITask remoteHMITask) {
        Object object;
        if (remoteHMITask.isCoalescable()) {
            Object object2 = object = (OpenTimedJobQueue)this.dispatcher.getQueue();
            synchronized (object2) {
                Iterator iterator = ((OpenTimedJobQueue)object).getJobs().iterator();
                while (iterator.hasNext()) {
                    RemoteHMITask remoteHMITask2;
                    Job job = (Job)iterator.next();
                    if (job.isCanceled() || !remoteHMITask.coalesceWith(remoteHMITask2 = (RemoteHMITask)job.getPayload())) continue;
                    return;
                }
            }
        }
        if ((object = remoteHMITask.getDelayMillis()) == null) {
            if (this.dispatcher.isDispatchThread()) {
                this.dispatcherLogChannel.log(-2137614336, "RemoteHMIService#execute: synchronous execution for %1 (run from within the queue)", (Object)remoteHMITask);
                remoteHMITask.run();
            } else {
                this.dispatcher.execute(remoteHMITask);
            }
        } else {
            this.dispatcher.execute(remoteHMITask, (Long)object);
        }
    }

    public DiagnosisComponent getDiagnosisComponent() {
        return this.infotainmentRecorderComponent;
    }

    public void setLicenseHandler(LicenseCollectionService licenseCollectionService) {
        this.licensingCollector = licenseCollectionService;
    }

    public LicenseCollectionService getLicenseCollectionService() {
        return this.licensingCollector;
    }

    public PortalAuthenticationService getPortalAuthentication() {
        return this.portalAuthentication;
    }

    protected boolean ignoreRemoteHMIActive() {
        return false;
    }

    public void lockModelGroup() {
        this.hmiModelGroup.lock();
    }

    public void unlockModelGroup() {
        this.hmiModelGroup.unlock();
    }

    public void triggerFlushModelGroup(String string) {
        this.execute(new RemoteHMIService$26(this, "flush-model-group", LogAppender$Factory.fromString(string)));
    }

    public void flushModelGroup() {
        this.hmiModelGroup.flush();
    }

    public void setConnectivityContext(int n) {
    }

    public void setCoreServiceLanguageListener(IOnlineLanguageListener iOnlineLanguageListener) {
        this.languageListener = iOnlineLanguageListener;
    }

    public int getActiveAppModelId() {
        return 8;
    }

    public void overrideAnimation(int n) {
        this.logChannel.log(1078071040, "RemoteHMIService#overrideAnimation: set to %1", (Object)new Integer(n));
        this.overrideAnimation = n;
    }

    public RemoteHMIDSIAccess getDsiAccess() {
        return this.dsiAccess;
    }

    public void setEntered(boolean bl) {
        this.entered = bl;
    }

    protected boolean isEntered() {
        return this.entered;
    }

    public void setEntryPointId(int n) {
        this.entryPointId = n;
    }

    protected int getEntryPointId() {
        return this.entryPointId;
    }

    public boolean isSDSRunning() {
        if (this.getModelBankAccess().getChoiceModel(335).getValue() == 2 || this.getModelBankAccess().getChoiceModel(335).getValue() == 8) {
            this.logChannel.log(-2137614336, "RemoteHMIService#isSDSRunning: SDS running");
            return true;
        }
        return false;
    }

    public IGridFactory getGridFactory() {
        if (this.gridFactory == null) {
            this.logChannel.log(-1601830656, "RemoteHMIService#getGridFactory: gridFactory is null with stacktrace %1", new Throwable());
        }
        return this.gridFactory;
    }

    protected void setMapStateService(NaviOnlineService$MapStateService naviOnlineService$MapStateService) {
        this.mapStateService = naviOnlineService$MapStateService;
    }

    public NaviOnlineService$MapStateService getMapStateService() {
        return this.mapStateService;
    }

    public AbstractOperatorCallMain getOperatorCallController() {
        return this.operatorCallController;
    }

    public void setOperatorCallController(AbstractOperatorCallMain abstractOperatorCallMain) {
        this.operatorCallController = abstractOperatorCallMain;
    }

    public void setOnlineOperatorCallService(OnlinePOICall onlinePOICall) {
        this.logChannel.log(1078071040, "RemoteHMIService#setOnlineOperatorCallService was called with %1.", (Object)onlinePOICall);
        this.onlineOperatorCallService = onlinePOICall;
    }

    public OnlinePOICall getOnlineOperatorCallService() {
        return this.onlineOperatorCallService;
    }

    public IOsrUserCacheInformation getIoSrUserCacheInformation() {
        return this.ioSrUserCacheInformation;
    }

    public void setRemoteHMIESimLicenseListener(IRemoteHMIEsimLicenseListener iRemoteHMIEsimLicenseListener) {
        this.remoteHMIESimLicenseListener = iRemoteHMIEsimLicenseListener;
    }

    public IRemoteHMIEsimLicenseListener getRemoteHMIESimLicenseListener() {
        return this.remoteHMIESimLicenseListener;
    }

    public void setRemotehmiIFolderBrowsingService(IFolderBrowsingService iFolderBrowsingService) {
        this.remotehmiFolderBrowsingService = iFolderBrowsingService;
    }

    public IFolderBrowsingService getRemotehmiIFolderBrowsingService() {
        return this.remotehmiFolderBrowsingService;
    }

    public String printGridList() {
        return "RemoteHMIService#printGridList: should be overridden by derived classes";
    }

    public void startMediaApp(int n) {
        this.logChannel.log(1078071040, "RemoteHmiService#startMediaApp entryPoint: %1", (long)n);
        this.hmiService.getChoiceModel(386990848).setValue(n);
    }

    public IMediaDrawerContext getMediaDrawerContext() {
        return this.mediaDrawerContext;
    }

    public void setMediaDrawerContext(IMediaDrawerContext iMediaDrawerContext) {
        this.mediaDrawerContext = iMediaDrawerContext;
    }

    public void setConnectivityChangedService(RemoteHMIConnectivityChangedService remoteHMIConnectivityChangedService) {
        this.connectivityChangedService = remoteHMIConnectivityChangedService;
    }

    public RemoteHMIConnectivityChangedService getConnectivityChangedService() {
        return this.connectivityChangedService;
    }

    public final UpdatingIconComponent getUpdatingIconComponent() {
        return this.updatingIconComponent;
    }

    public VolumeOnOffPressListener getVolumeListener() {
        return null;
    }

    public abstract void triggerPrivacyMode(boolean bl) {
    }

    static /* synthetic */ void access$000(RemoteHMIService remoteHMIService) {
        remoteHMIService.invalidateSpeechHelpContext();
    }

    static /* synthetic */ void access$100(RemoteHMIService remoteHMIService, String string) {
        remoteHMIService.cancelViewDependentJobsForContext(string);
    }

    static /* synthetic */ HMISpeechASRListener access$200(RemoteHMIService remoteHMIService) {
        return remoteHMIService.hmiAsrListener;
    }

    static /* synthetic */ String access$302(RemoteHMIService remoteHMIService, String string) {
        remoteHMIService.initialLanguage = string;
        return remoteHMIService.initialLanguage;
    }
}

