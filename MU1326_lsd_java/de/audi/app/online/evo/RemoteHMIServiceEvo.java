/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.ConnectivityOverrideListener;
import de.audi.app.online.evo.DistributedServiceComponentEvo;
import de.audi.app.online.evo.ExternalServiceProviderEvo;
import de.audi.app.online.evo.HMIViewGridListener;
import de.audi.app.online.evo.HMIViewGridScreenAccess;
import de.audi.app.online.evo.HMIViewLocationInputListenerEvo;
import de.audi.app.online.evo.HMIViewMapListener;
import de.audi.app.online.evo.HMIViewNpsListener;
import de.audi.app.online.evo.HMIViewTextDisplayListener;
import de.audi.app.online.evo.HMIViewTextDisplayScreenAccess;
import de.audi.app.online.evo.HMIViewWaitingListener;
import de.audi.app.online.evo.MapStateServiceImpl;
import de.audi.app.online.evo.PartialPopupComponent;
import de.audi.app.online.evo.RemoteHMIComponentFactoryEvo;
import de.audi.app.online.evo.RemoteHMILockingListenerEvo;
import de.audi.app.online.evo.SwitchToOnlineComponent;
import de.audi.app.online.evo.connectivity.bundled.BundledConnectivityHandlerEvo;
import de.audi.app.online.evo.connectivity.bundled.BundledConnectivityPopupConfigEvo;
import de.audi.app.online.evo.presets.OnlinePresetComponent;
import de.audi.app.online.evo.presets.OnlinePresetHandler;
import de.audi.app.online.evo.previews.PreviewUpdateComponent;
import de.audi.app.online.evo.remotehmi.browser.HMIViewBrowserListener;
import de.audi.app.online.evo.remotehmi.drawers.LeftDrawerHandler;
import de.audi.app.online.evo.remotehmi.drawers.RightDrawerHandler;
import de.audi.app.online.evo.search.OnlineSearchComponent;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.i18n.Language;
import de.audi.atip.interapp.OnlineServiceListener;
import de.audi.atip.interapp.online.IRemoteHMIMediaOnlineServiceListener;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.HMIProperties;
import de.audi.remotehmi.IRemoteHMISpeechContext;
import de.audi.remotehmi.ISpeechDictionary;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.remotehmi.ui.mib2.grid.IGridList;
import de.audi.remotehmi.util.LogAppender;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.AbstractExternalServiceProvider;
import de.audi.tghu.online.app.remotehmi.AbstractHMIViewListener;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.I18NTextComponent;
import de.audi.tghu.online.app.remotehmi.OnlineModelBankAccess;
import de.audi.tghu.online.app.remotehmi.RemoteHMIDSIAccess;
import de.audi.tghu.online.app.remotehmi.RemoteHMIMediaHandler;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.remotehmi.RemoteHMITask;
import de.audi.tghu.online.app.remotehmi.connectivity.bundled.BundledConnectivityComponent;
import de.audi.tghu.online.app.remotehmi.sds.HMISpeechASRListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RemoteHMIServiceEvo
extends RemoteHMIService {
    public static final int CONNECTIVITY_CONTEXT_DEFAULT = 0;
    public static final int CONNECTIVITY_CONTEXT_MEDIA = 1;
    private final LoadViewTask loadViewTask = new LoadViewTask();
    protected LeftDrawerHandler leftDrawerHandler;
    protected RightDrawerHandler rightDrawerHandler;
    private I18NTextComponent i18NComponent;
    private OnlinePresetHandler onlinePresetHandler;
    protected ExternalServiceProviderEvo onlineEvoServiceProvider;
    DistributedServiceComponentEvo distributedServiceComponent;
    private PartialPopupComponent popupComponent;
    private PreviewUpdateComponent previewUpdateComponent;
    protected OnlineSearchComponent onlineSearchComponent;
    private BundledConnectivityComponent bundledConnectivityComponent;
    private Language hmiLanuage;
    public IRemoteHMISpeechContext.CommandDisplay pttCommandDisplay;
    static /* synthetic */ Class class$de$audi$atip$hmi$app$AppOnlineTextConstants;

    protected RemoteHMIServiceEvo(LogChannel logChannel, LogChannel logChannel2, IFrameworkAccess iFrameworkAccess, OnlineModelBankAccess onlineModelBankAccess, boolean bl) {
        super(logChannel, logChannel2, iFrameworkAccess, onlineModelBankAccess, bl, new RemoteHMIComponentFactoryEvo());
    }

    public RemoteHMIServiceEvo(final LogChannel logChannel, LogChannel logChannel2, IFrameworkAccess iFrameworkAccess, OnlineModelBankAccess onlineModelBankAccess) {
        super(logChannel, logChannel2, iFrameworkAccess, onlineModelBankAccess, false, new RemoteHMIComponentFactoryEvo());
        this.viewTypeModelGroup.add(onlineModelBankAccess.getChoiceModel(2300989));
        this.leftDrawerHandler = new LeftDrawerHandler(logChannel, this, this.hmiModelGroup);
        this.rightDrawerHandler = new RightDrawerHandler(logChannel, this);
        iFrameworkAccess.getLogChannel("App.Online.RemoteHMI.Grid");
        ChoiceModelApp choiceModelApp = onlineModelBankAccess.getChoiceModel(2300982);
        if (Boolean.getBoolean("RemoteHMIConnecitivityOverride")) {
            choiceModelApp.setValue(1);
        }
        this.onlineEvoServiceProvider = new ExternalServiceProviderEvo();
        this.addComponent(this.onlineEvoServiceProvider);
        this.distributedServiceComponent = new DistributedServiceComponentEvo();
        this.addComponent(this.distributedServiceComponent);
        this.onlineSearchComponent = new OnlineSearchComponent();
        this.addComponent(this.onlineSearchComponent);
        BundledConnectivityPopupConfigEvo bundledConnectivityPopupConfigEvo = new BundledConnectivityPopupConfigEvo(logChannel, 2301543, 2301542, 2301541, 2301544);
        bundledConnectivityPopupConfigEvo.registerDefaultPopupId(2300005);
        BundledConnectivityHandlerEvo bundledConnectivityHandlerEvo = new BundledConnectivityHandlerEvo("bundled-connectivity-show-dataplan-popup", logChannel, (RemoteHMIService)this, bundledConnectivityPopupConfigEvo);
        this.bundledConnectivityComponent = new BundledConnectivityComponent(bundledConnectivityPopupConfigEvo, bundledConnectivityHandlerEvo);
        this.addComponent(this.bundledConnectivityComponent);
        this.addComponent(new OnlinePresetComponent());
        this.addComponent(new SwitchToOnlineComponent());
        HMIViewGridListener hMIViewGridListener = (HMIViewGridListener)this.getViewListener(13000);
        hMIViewGridListener.setTruffleComponent(this.onlineSearchComponent.getOnlineSearchHandler());
        this.i18NComponent = new I18NTextComponent((class$de$audi$atip$hmi$app$AppOnlineTextConstants == null ? (class$de$audi$atip$hmi$app$AppOnlineTextConstants = RemoteHMIServiceEvo.class$("de.audi.atip.hmi.app.AppOnlineTextConstants")) : class$de$audi$atip$hmi$app$AppOnlineTextConstants).getFields());
        this.addComponent(this.i18NComponent);
        this.previewUpdateComponent = new PreviewUpdateComponent(hMIViewGridListener.getRrdCalculationHandler());
        this.addComponent(this.previewUpdateComponent);
        this.dsiAccess.addDSIListener(this.i18NComponent);
        this.popupComponent = new PartialPopupComponent(logChannel, this, new ModelGroup(), this.getModelBankAccess());
        this.addComponent(this.popupComponent);
        new ConnectivityOverrideListener(this.getModelBankAccess(), logChannel, this);
        this.getDsiAccess().addDSIListener(this);
        this.setMapStateService(new MapStateServiceImpl(logChannel, this));
        this.lockingListener = new RemoteHMILockingListenerEvo(this.hmiService, this, logChannel);
        this.addCommandHandler(1110000001, new AbstractCommandHandler("goto-audi-connect"){

            public void indicateCommand(int n, Object object) {
                if (RemoteHMIServiceEvo.this.isEntered() && RemoteHMIServiceEvo.this.getEntryPointId() == 1) {
                    logChannel.log(1000000, "RemoteHMIServiceEvo#indicateCommand: state STATE_PREDEVELOPMENT_GOTO_AUDI_CONNECT skipped (already in Audi Connect)");
                    return;
                }
                ChoiceModelApp choiceModelApp = RemoteHMIServiceEvo.this.getModelBankAccess().getChoiceModel(452);
                choiceModelApp.setValue(~choiceModelApp.getValue());
                logChannel.log(1000000, "RemoteHMIServiceEvo#indicateCommand: state STATE_PREDEVELOPMENT_GOTO_AUDI_CONNECT triggered");
            }
        });
        this.addCommandHandler(1100009002, new AbstractCommandHandler("connectivity_state_changed"){

            public void indicateCommand(int n, Object object) {
                boolean bl;
                if (object instanceof Boolean && (bl = ((Boolean)object).booleanValue())) {
                    logChannel.log(1000000, "RemoteHMIServiceEvo#indicateCommand: state STATE_CONNECTIVITY_CHANGED");
                    RemoteHMIServiceEvo.this.getModelBankAccess().getChoiceModel(2300982).setValue(0);
                }
            }
        });
        this.addCommandHandler(1100000040, new AbstractCommandHandler("activate-speech-dictionary"){

            public void indicateCommand(int n, Object object) {
                logChannel.log(1000000, "RemoteHMIServiceEvo#ctor (AbstractCommandHandler): received dictionaries.");
                if (object instanceof List) {
                    String string = null;
                    String string2 = null;
                    int n2 = 2;
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < ((List)object).size(); ++i2) {
                        if (((List)object).get(i2) instanceof ISpeechDictionary) {
                            ISpeechDictionary iSpeechDictionary = (ISpeechDictionary)((List)object).get(i2);
                            if (string != null && !string.equals(iSpeechDictionary.getFormat()) || string2 != null && !string2.equals(iSpeechDictionary.getLanguage())) {
                                logChannel.log(10000, "RemoteHMIHandlerImpl#ctor (AbstractCommandHandler): format or language of available dictionaries do not fit");
                                continue;
                            }
                            string = iSpeechDictionary.getFormat();
                            string2 = iSpeechDictionary.getLanguage();
                            n2 = iSpeechDictionary.getType();
                            arrayList.addAll(iSpeechDictionary.getDictionaryEntries());
                            continue;
                        }
                        logChannel.log(1000000, "RemoteHMIHandlerImpl#ctor (AbstractCommandHandler): payload not of type SpeechDictionary, no registration of Online-Dictionary");
                    }
                    if (string2 != null && string != null && arrayList != null && !arrayList.isEmpty()) {
                        OnlineServiceListener.OnlineSpeechDictionary onlineSpeechDictionary = new OnlineServiceListener.OnlineSpeechDictionary(n2, string2, string, arrayList);
                        logChannel.log(1000000, "RemoteHMIHandlerImpl#ctor (AbstractCommandHandler): setting dictionary %1 at onlineServiceListener", (Object)onlineSpeechDictionary.toString());
                        RemoteHMIServiceEvo.this.getASR().getOnlineServiceListener().setDictionary(onlineSpeechDictionary);
                    } else {
                        logChannel.log(10000, "RemoteHMIHandlerImpl#ctor (AbstractCommandHandler): dictionary cannot be set due to missing fields");
                    }
                }
            }
        });
        this.addCommandHandler(1100000060, new AbstractCommandHandler("active-mobile-device-connected"){

            public void indicateCommand(int n, Object object) {
                logChannel.log(1000000, "RemoteHMIServiceEvo#ctor (ICommandHandler): mobile device was personalized via service discovery.");
                if (object instanceof String) {
                    String string = (String)object;
                    logChannel.log(1000000, "RemoteHMIServiceEvo#ctor (ICommandHandler): connected device %1, showing popzp", (Object)string);
                    LabelModelApp labelModelApp = RemoteHMIServiceEvo.this.getModelBankAccess().getLabelModel(2301043);
                    labelModelApp.setText(string);
                    ChoiceModelApp choiceModelApp = RemoteHMIServiceEvo.this.getModelBankAccess().getChoiceModel(2301044);
                    choiceModelApp.setValue(~choiceModelApp.getValue());
                }
            }
        });
    }

    public void setRemoteHMIMediaOnlineServiceListener(IRemoteHMIMediaOnlineServiceListener iRemoteHMIMediaOnlineServiceListener) {
        super.setRemoteHMIMediaOnlineServiceListener(iRemoteHMIMediaOnlineServiceListener);
        if (iRemoteHMIMediaOnlineServiceListener != null) {
            this.onlineEvoServiceProvider.sendSavedInfoToMedia(iRemoteHMIMediaOnlineServiceListener);
        }
    }

    public void setLanguage(Language language) {
        super.setLanguage(language);
        this.hmiLanuage = language;
        if (this.i18NComponent != null) {
            this.execute(new AbstractRemoteHMITask("set-language-", LogAppender.Factory.fromString(language == null ? "null" : this.getCorrectLanguageString(language))){

                public void run() {
                    RemoteHMIServiceEvo.this.i18NComponent.refresh();
                }
            });
        }
    }

    public Object getDistributedServiceComponent() {
        return this.distributedServiceComponent;
    }

    protected void initializeViewListeners() {
        ChoiceModelApp choiceModelApp = this.modelBank.getChoiceModel(2300989);
        HMIViewGridScreenAccess hMIViewGridScreenAccess = new HMIViewGridScreenAccess(this.logChannel, this, this.hmiModelGroup, this.modelBank, choiceModelApp);
        this.putViewListener(new HMIViewGridListener(this.logChannel, (ModelGroup)this.hmiModelGroup, this.modelBank, this.hmiService, this, hMIViewGridScreenAccess), 13000);
        this.putViewListener(new HMIViewNpsListener(this.logChannel, new ModelGroup(), this.modelBank, this.hmiService, this), 15000);
        this.putViewListener(new HMIViewBrowserListener(this.logChannel, (ModelGroup)this.hmiModelGroup, this.modelBank, this.hmiService, this), 3000);
        this.putViewListener(new HMIViewMapListener(this.logChannel, (ModelGroup)this.hmiModelGroup, this.modelBank, this.hmiService, this), 6000);
        this.putViewListener(new HMIViewLocationInputListenerEvo(this.logChannel, (ModelGroup)this.hmiModelGroup, this.modelBank, this.hmiService, this), 6100);
        this.putViewListener(new HMIViewWaitingListener(this.logChannel, (ModelGroup)this.hmiModelGroup, this.modelBank, this.hmiService, this), 14000);
        HMIViewTextDisplayScreenAccess hMIViewTextDisplayScreenAccess = new HMIViewTextDisplayScreenAccess(this.logChannel, this, this.hmiModelGroup, this.modelBank, choiceModelApp);
        this.putViewListener(new HMIViewTextDisplayListener(this.logChannel, (ModelGroup)this.hmiModelGroup, this.modelBank, this.hmiService, this, hMIViewTextDisplayScreenAccess), 4000);
    }

    protected void triggerScreenEnter(String string) {
        this.triggerScreenEnter(string, false);
    }

    private void triggerScreenEnter(String string, boolean bl) {
        boolean bl2 = this.contextManagerComponent.isRemoteHMIActive();
        if (!bl2 && !bl) {
            this.logChannel.log(100000, "RemoteHMIServiceEvo#triggerScreenEnter: first loadview recieved for context '%1' before RemoteHMI is active -> delay", (Object)string);
            this.loadViewTask.setEntryPointContextName(string);
            this.execute(this.loadViewTask);
        } else if (this.contextManagerComponent.getWaitForApplicationValue() == 1) {
            this.logChannel.log(1000000, "RemoteHMIServiceEvo#triggerScreenEnter: first loadview recieved for context '%1' so removing waiting screen", (Object)string);
            this.contextManagerComponent.setWaitForApplicationValue(0);
        }
    }

    public RightDrawerHandler getRightDrawerHandler() {
        return this.rightDrawerHandler;
    }

    public LeftDrawerHandler getLeftDrawerHandler() {
        return this.leftDrawerHandler;
    }

    public AbstractExternalServiceProvider getOnlineServiceProvider() {
        return this.onlineEvoServiceProvider;
    }

    public Object getI18NTextComponent() {
        return this.i18NComponent;
    }

    public void indicateContextsCommandDisplay(final IRemoteHMISpeechContext.CommandDisplay commandDisplay) {
        this.execute(new AbstractRemoteHMITask("indicate-context_commandDisplay"){

            public void run() {
                HMISpeechASRListener hMISpeechASRListener = RemoteHMIServiceEvo.this.getASR();
                if (hMISpeechASRListener != null) {
                    RemoteHMIServiceEvo.this.logChannel.log(10000000, "RemoteHMIServiceEvo#indicateContextsCommandDisplay: Called.");
                    hMISpeechASRListener.indicateApplicationCommands(commandDisplay);
                }
            }
        });
    }

    public OnlineSearchComponent getSearchComponent() {
        return this.onlineSearchComponent;
    }

    public void setConnectivityContext(int n) {
        this.hmiService.getChoiceModel(2301077).setValue(n);
        this.logChannel.log(1000000, "RemoteHMIServiceEvo#setConnectivityContext connectivityContext: %1", (long)n);
    }

    public int getActiveAppModelId() {
        return super.getActiveAppModelId();
    }

    public RemoteHMIMediaHandler getMediaHandler() {
        return null;
    }

    public void onExit() {
        ChoiceModelApp choiceModelApp = this.getModelBankAccess().getChoiceModel(2300982);
        choiceModelApp.setValue(0);
        super.onExit();
    }

    public void remoteHmiDsiReady() {
        this.logChannel.log(10000000, "RemoteHMIServiceEvo#remoteHmiDsiReady: sending language as DSI is now available");
        this.setLanguage(this.hmiLanuage);
    }

    protected void updateViews(LogChannel logChannel, String string, IGridList iGridList, boolean bl, Set set, AbstractHMIViewListener abstractHMIViewListener, int n) {
        if (abstractHMIViewListener instanceof HMIViewGridListener) {
            HMIViewGridListener hMIViewGridListener = (HMIViewGridListener)abstractHMIViewListener;
            IGridList iGridList2 = hMIViewGridListener.getCurrentGridList();
            if (iGridList2 != iGridList) {
                String string2 = "RemoteHMIServiceEvo#indicateCommand: updateViews: not rendering (gridlist instance doesn't match) for context '%1'.";
                logChannel.log(100000, string2, (Object)string);
                return;
            }
            boolean bl2 = bl || set.contains("decoratorUrl");
            hMIViewGridListener.renderGridList(n, bl2, 10);
        } else if (abstractHMIViewListener instanceof HMIViewNpsListener) {
            HMIViewNpsListener hMIViewNpsListener = (HMIViewNpsListener)abstractHMIViewListener;
            hMIViewNpsListener.updateLineLeadingIcons(iGridList);
        } else {
            String string3 = "RemoteHMIServiceEvo#indicateCommand: updateViews: not rendering context '%1' because it has not a grid list or now-playing-screen listener. Please correct code.";
            logChannel.log(10000, string3, (Object)string);
        }
    }

    protected void applyPropertyChanges(AbstractHMIViewListener abstractHMIViewListener, Set set, HMIProperties hMIProperties) {
        if (set.contains("providerLogo")) {
            abstractHMIViewListener.showProviderLogo(hMIProperties);
        }
        if (abstractHMIViewListener instanceof HMIViewGridListener && set.contains("decoratorUrl")) {
            HMIViewGridListener hMIViewGridListener = (HMIViewGridListener)abstractHMIViewListener;
            hMIViewGridListener.updateCommonDecorator(hMIProperties);
        }
    }

    public void setOnlinePresetHandler(OnlinePresetHandler onlinePresetHandler) {
        this.onlinePresetHandler = onlinePresetHandler;
    }

    public OnlinePresetHandler getOnlinePresetHandler() {
        return this.onlinePresetHandler;
    }

    public void triggerPrivacyMode(boolean bl) {
        this.rightDrawerHandler.togglePrivacyMode(bl);
        HMIProperties hMIProperties = new HMIProperties();
        hMIProperties.put("value", bl);
        final RemoteHMIAction remoteHMIAction = new RemoteHMIAction(10008916);
        remoteHMIAction.setParameters(hMIProperties);
        if (!this.hasDsiAccess()) {
            this.dsiAccess.addDSIListener(new RemoteHMIDSIAccess.IRemoteHMIDSIListener(){

                public void remoteHmiDsiReady() {
                    RemoteHMIServiceEvo.this.invokeAction(remoteHMIAction);
                }
            });
        } else {
            this.invokeAction(remoteHMIAction);
        }
    }

    public void triggerFleetMode(boolean bl) {
        HMIProperties hMIProperties = new HMIProperties();
        hMIProperties.put("value", bl);
        final RemoteHMIAction remoteHMIAction = new RemoteHMIAction(10008917);
        remoteHMIAction.setParameters(hMIProperties);
        if (!this.hasDsiAccess()) {
            this.dsiAccess.addDSIListener(new RemoteHMIDSIAccess.IRemoteHMIDSIListener(){

                public void remoteHmiDsiReady() {
                    RemoteHMIServiceEvo.this.invokeAction(remoteHMIAction);
                }
            });
        } else {
            this.invokeAction(remoteHMIAction);
        }
    }

    public void processMsg(int n) {
        super.processMsg(n);
        if (n == 206) {
            this.rightDrawerHandler.updateLockingState(true);
        } else if (n == 207) {
            this.rightDrawerHandler.updateLockingState(false);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private class LoadViewTask
    implements RemoteHMITask {
        private String entryPointContextName;

        private LoadViewTask() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void setEntryPointContextName(String string) {
            String string2 = string;
            synchronized (string2) {
                this.entryPointContextName = string;
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void run() {
            String string = this.entryPointContextName;
            synchronized (string) {
                RemoteHMIServiceEvo.this.triggerScreenEnter(this.entryPointContextName, true);
            }
        }

        public boolean isCoalescable() {
            return false;
        }

        public boolean coalesceWith(RemoteHMITask remoteHMITask) {
            return false;
        }

        public Long getDelayMillis() {
            return new Long(100L);
        }
    }
}

