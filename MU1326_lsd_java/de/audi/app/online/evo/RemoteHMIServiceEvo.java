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
import de.audi.app.online.evo.RemoteHMIServiceEvo$1;
import de.audi.app.online.evo.RemoteHMIServiceEvo$2;
import de.audi.app.online.evo.RemoteHMIServiceEvo$3;
import de.audi.app.online.evo.RemoteHMIServiceEvo$4;
import de.audi.app.online.evo.RemoteHMIServiceEvo$5;
import de.audi.app.online.evo.RemoteHMIServiceEvo$6;
import de.audi.app.online.evo.RemoteHMIServiceEvo$7;
import de.audi.app.online.evo.RemoteHMIServiceEvo$8;
import de.audi.app.online.evo.RemoteHMIServiceEvo$LoadViewTask;
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
import de.audi.atip.i18n.Language;
import de.audi.atip.interapp.online.IRemoteHMIMediaOnlineServiceListener;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.HMIProperties;
import de.audi.remotehmi.IRemoteHMISpeechContext$CommandDisplay;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.remotehmi.ui.mib2.grid.IGridList;
import de.audi.remotehmi.util.LogAppender$Factory;
import de.audi.tghu.online.app.remotehmi.AbstractExternalServiceProvider;
import de.audi.tghu.online.app.remotehmi.AbstractHMIViewListener;
import de.audi.tghu.online.app.remotehmi.I18NTextComponent;
import de.audi.tghu.online.app.remotehmi.OnlineModelBankAccess;
import de.audi.tghu.online.app.remotehmi.RemoteHMIMediaHandler;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.remotehmi.connectivity.bundled.BundledConnectivityComponent;
import java.util.Set;

public class RemoteHMIServiceEvo
extends RemoteHMIService {
    public static final int CONNECTIVITY_CONTEXT_DEFAULT;
    public static final int CONNECTIVITY_CONTEXT_MEDIA;
    private final RemoteHMIServiceEvo$LoadViewTask loadViewTask = new RemoteHMIServiceEvo$LoadViewTask(this, null);
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
    public IRemoteHMISpeechContext$CommandDisplay pttCommandDisplay;
    static /* synthetic */ Class class$de$audi$atip$hmi$app$AppOnlineTextConstants;

    protected RemoteHMIServiceEvo(LogChannel logChannel, LogChannel logChannel2, IFrameworkAccess iFrameworkAccess, OnlineModelBankAccess onlineModelBankAccess, boolean bl) {
        super(logChannel, logChannel2, iFrameworkAccess, onlineModelBankAccess, bl, new RemoteHMIComponentFactoryEvo());
    }

    public RemoteHMIServiceEvo(LogChannel logChannel, LogChannel logChannel2, IFrameworkAccess iFrameworkAccess, OnlineModelBankAccess onlineModelBankAccess) {
        super(logChannel, logChannel2, iFrameworkAccess, onlineModelBankAccess, false, new RemoteHMIComponentFactoryEvo());
        this.viewTypeModelGroup.add(onlineModelBankAccess.getChoiceModel(1025254144));
        this.leftDrawerHandler = new LeftDrawerHandler(logChannel, this, this.hmiModelGroup);
        this.rightDrawerHandler = new RightDrawerHandler(logChannel, this);
        iFrameworkAccess.getLogChannel("App.Online.RemoteHMI.Grid");
        ChoiceModelApp choiceModelApp = onlineModelBankAccess.getChoiceModel(907813632);
        if (Boolean.getBoolean("RemoteHMIConnecitivityOverride")) {
            choiceModelApp.setValue(1);
        }
        this.onlineEvoServiceProvider = new ExternalServiceProviderEvo();
        this.addComponent(this.onlineEvoServiceProvider);
        this.distributedServiceComponent = new DistributedServiceComponentEvo();
        this.addComponent(this.distributedServiceComponent);
        this.onlineSearchComponent = new OnlineSearchComponent();
        this.addComponent(this.onlineSearchComponent);
        BundledConnectivityPopupConfigEvo bundledConnectivityPopupConfigEvo = new BundledConnectivityPopupConfigEvo(logChannel, 1730028288, 1713251072, 1696473856, 1746805504);
        bundledConnectivityPopupConfigEvo.registerDefaultPopupId(1696080640);
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
        this.addCommandHandler(-2126436030, new RemoteHMIServiceEvo$1(this, "goto-audi-connect", logChannel));
        this.addCommandHandler(718180417, new RemoteHMIServiceEvo$2(this, "connectivity_state_changed", logChannel));
        this.addCommandHandler(682332225, new RemoteHMIServiceEvo$3(this, "activate-speech-dictionary", logChannel));
        this.addCommandHandler(1017876545, new RemoteHMIServiceEvo$4(this, "active-mobile-device-connected", logChannel));
    }

    @Override
    public void setRemoteHMIMediaOnlineServiceListener(IRemoteHMIMediaOnlineServiceListener iRemoteHMIMediaOnlineServiceListener) {
        super.setRemoteHMIMediaOnlineServiceListener(iRemoteHMIMediaOnlineServiceListener);
        if (iRemoteHMIMediaOnlineServiceListener != null) {
            this.onlineEvoServiceProvider.sendSavedInfoToMedia(iRemoteHMIMediaOnlineServiceListener);
        }
    }

    @Override
    public void setLanguage(Language language) {
        super.setLanguage(language);
        this.hmiLanuage = language;
        if (this.i18NComponent != null) {
            this.execute(new RemoteHMIServiceEvo$5(this, "set-language-", LogAppender$Factory.fromString(language == null ? "null" : this.getCorrectLanguageString(language))));
        }
    }

    @Override
    public Object getDistributedServiceComponent() {
        return this.distributedServiceComponent;
    }

    @Override
    protected void initializeViewListeners() {
        ChoiceModelApp choiceModelApp = this.modelBank.getChoiceModel(1025254144);
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

    @Override
    protected void triggerScreenEnter(String string) {
        this.triggerScreenEnter(string, false);
    }

    private void triggerScreenEnter(String string, boolean bl) {
        boolean bl2 = this.contextManagerComponent.isRemoteHMIActive();
        if (!bl2 && !bl) {
            this.logChannel.log(-1601830656, "RemoteHMIServiceEvo#triggerScreenEnter: first loadview recieved for context '%1' before RemoteHMI is active -> delay", (Object)string);
            this.loadViewTask.setEntryPointContextName(string);
            this.execute(this.loadViewTask);
        } else if (this.contextManagerComponent.getWaitForApplicationValue() == 1) {
            this.logChannel.log(1078071040, "RemoteHMIServiceEvo#triggerScreenEnter: first loadview recieved for context '%1' so removing waiting screen", (Object)string);
            this.contextManagerComponent.setWaitForApplicationValue(0);
        }
    }

    public RightDrawerHandler getRightDrawerHandler() {
        return this.rightDrawerHandler;
    }

    public LeftDrawerHandler getLeftDrawerHandler() {
        return this.leftDrawerHandler;
    }

    @Override
    public AbstractExternalServiceProvider getOnlineServiceProvider() {
        return this.onlineEvoServiceProvider;
    }

    @Override
    public Object getI18NTextComponent() {
        return this.i18NComponent;
    }

    @Override
    public void indicateContextsCommandDisplay(IRemoteHMISpeechContext$CommandDisplay iRemoteHMISpeechContext$CommandDisplay) {
        this.execute(new RemoteHMIServiceEvo$6(this, "indicate-context_commandDisplay", iRemoteHMISpeechContext$CommandDisplay));
    }

    public OnlineSearchComponent getSearchComponent() {
        return this.onlineSearchComponent;
    }

    @Override
    public void setConnectivityContext(int n) {
        this.hmiService.getChoiceModel(-1793318144).setValue(n);
        this.logChannel.log(1078071040, "RemoteHMIServiceEvo#setConnectivityContext connectivityContext: %1", (long)n);
    }

    @Override
    public int getActiveAppModelId() {
        return super.getActiveAppModelId();
    }

    @Override
    public RemoteHMIMediaHandler getMediaHandler() {
        return null;
    }

    @Override
    public void onExit() {
        ChoiceModelApp choiceModelApp = this.getModelBankAccess().getChoiceModel(907813632);
        choiceModelApp.setValue(0);
        super.onExit();
    }

    @Override
    public void remoteHmiDsiReady() {
        this.logChannel.log(-2137614336, "RemoteHMIServiceEvo#remoteHmiDsiReady: sending language as DSI is now available");
        this.setLanguage(this.hmiLanuage);
    }

    @Override
    protected void updateViews(LogChannel logChannel, String string, IGridList iGridList, boolean bl, Set set, AbstractHMIViewListener abstractHMIViewListener, int n) {
        if (abstractHMIViewListener instanceof HMIViewGridListener) {
            HMIViewGridListener hMIViewGridListener = (HMIViewGridListener)abstractHMIViewListener;
            IGridList iGridList2 = hMIViewGridListener.getCurrentGridList();
            if (iGridList2 != iGridList) {
                String string2 = "RemoteHMIServiceEvo#indicateCommand: updateViews: not rendering (gridlist instance doesn't match) for context '%1'.";
                logChannel.log(-1601830656, string2, (Object)string);
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

    @Override
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

    @Override
    public void triggerPrivacyMode(boolean bl) {
        this.rightDrawerHandler.togglePrivacyMode(bl);
        HMIProperties hMIProperties = new HMIProperties();
        hMIProperties.put("value", bl);
        RemoteHMIAction remoteHMIAction = new RemoteHMIAction(1421449216);
        remoteHMIAction.setParameters(hMIProperties);
        if (!this.hasDsiAccess()) {
            this.dsiAccess.addDSIListener(new RemoteHMIServiceEvo$7(this, remoteHMIAction));
        } else {
            this.invokeAction(remoteHMIAction);
        }
    }

    public void triggerFleetMode(boolean bl) {
        HMIProperties hMIProperties = new HMIProperties();
        hMIProperties.put("value", bl);
        RemoteHMIAction remoteHMIAction = new RemoteHMIAction(1438226432);
        remoteHMIAction.setParameters(hMIProperties);
        if (!this.hasDsiAccess()) {
            this.dsiAccess.addDSIListener(new RemoteHMIServiceEvo$8(this, remoteHMIAction));
        } else {
            this.invokeAction(remoteHMIAction);
        }
    }

    @Override
    public void processMsg(int n) {
        super.processMsg(n);
        if (n == 206) {
            this.rightDrawerHandler.updateLockingState(true);
        } else if (n == 207) {
            this.rightDrawerHandler.updateLockingState(false);
        }
    }

    static /* synthetic */ void access$000(RemoteHMIServiceEvo remoteHMIServiceEvo, String string, boolean bl) {
        remoteHMIServiceEvo.triggerScreenEnter(string, bl);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ boolean access$200(RemoteHMIServiceEvo remoteHMIServiceEvo) {
        return remoteHMIServiceEvo.isEntered();
    }

    static /* synthetic */ int access$300(RemoteHMIServiceEvo remoteHMIServiceEvo) {
        return remoteHMIServiceEvo.getEntryPointId();
    }

    static /* synthetic */ I18NTextComponent access$400(RemoteHMIServiceEvo remoteHMIServiceEvo) {
        return remoteHMIServiceEvo.i18NComponent;
    }

    static /* synthetic */ LogChannel access$500(RemoteHMIServiceEvo remoteHMIServiceEvo) {
        return remoteHMIServiceEvo.logChannel;
    }
}

