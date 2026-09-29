/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.TerminalModeUtils
 *  de.audi.atip.utils.reactive.properties.LoggingPropertyFactory
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.ExternalEventsListener$1;
import de.audi.app.terminalmode.ExternalEventsListener$2;
import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.INavigationStateListener;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.SmartphoneManager$SmartphoneType;
import de.audi.app.terminalmode.TerminalModeUtils;
import de.audi.app.terminalmode.actionproxy.IActionProxyListener;
import de.audi.app.terminalmode.audio.AudioConnectionState;
import de.audi.app.terminalmode.audio.IAudioStateListener;
import de.audi.app.terminalmode.commands.AudioFocusChanged;
import de.audi.app.terminalmode.commands.HMIActivated;
import de.audi.app.terminalmode.commands.HMIDeactivated;
import de.audi.app.terminalmode.commands.NavigationStateChanged;
import de.audi.app.terminalmode.events.DefaultEventListener;
import de.audi.app.terminalmode.events.IEventBus;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager$ISmartphoneProperties;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.commands.AbstractCommand;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.event.DrawerEvent;
import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.dispatching.IDispatcher;
import de.audi.atip.utils.generics.Consumer;
import de.audi.atip.utils.reactive.properties.LoggingPropertyFactory;
import de.audi.atip.utils.reactive.properties.Property;
import de.audi.tghu.command.CommandList;
import java.util.Hashtable;
import java.util.Map;
import org.osgi.framework.ServiceRegistration;

public class ExternalEventsListener
extends DefaultEventListener
implements IActionProxyListener,
IAudioStateListener,
INavigationStateListener,
ITerminalModeComponent {
    public static final int ACTION_PROXY_DEBOUNCE_TIME;
    private static final String LOGCLASS;
    private final LogChannel logger;
    private final IContext context;
    private volatile ServiceRegistration phoneServiceRegistration;
    private final IStateHandler stateHandler;
    private final IEventBus eventBus;
    private volatile boolean bigStage;
    private volatile boolean screenActive;
    private final IDispatcher dispatcher;
    private final Property lastActionProxyCall;
    private HMIService hmiService;
    private IDSISmartphoneManager.ISmartphoneProperties smartphoneProperties;
    static /* synthetic */ Class class$de$audi$atip$interapp$phone$ITelStateListener;

    public ExternalEventsListener(IContext iContext, IStateHandler iStateHandler, IDispatcher iDispatcher, IDSISmartphoneManager.ISmartphoneProperties iSmartphoneProperties) {
        this.logger = iContext.getLogger().main();
        this.context = iContext;
        this.hmiService = iContext.getFramework().getHMIService();
        this.stateHandler = iStateHandler;
        this.smartphoneProperties = iSmartphoneProperties;
        this.eventBus = iContext.getEventBus();
        this.dispatcher = iDispatcher;
        this.lastActionProxyCall = LoggingPropertyFactory.create().createProperty("lastActionProxyCall");
    }

    @Override
    public void init() {
        this.logger.log(14808325, "[%1.init]", (Object)"ExternalEventsListener");
        this.bigStage = true;
        this.screenActive = false;
        this.context.addActionProxyListener(1001, this);
        this.context.addActionProxyListener(1002, this);
        this.eventBus.registerListener(this);
        this.context.getChoiceModel(601108480).setValue(78);
        this.phoneServiceRegistration = this.context.getServiceManager().registerService(class$de$audi$atip$interapp$phone$ITelStateListener == null ? (class$de$audi$atip$interapp$phone$ITelStateListener = ExternalEventsListener.class$("de.audi.atip.interapp.phone.ITelStateListener")) : class$de$audi$atip$interapp$phone$ITelStateListener, new ExternalEventsListener$1(this), new Hashtable(0));
        this.context.getNaviAppHandler().setNavigationStateListener(this);
        this.context.getAudioManager().addAudioContextListener((IAudioStateListener)this);
        this.lastActionProxyCall.observe().log(this.logger, "beforeDebounce").debounce(70, this.dispatcher).log(this.logger, "afterDebounce").redirectTo((Consumer)new ExternalEventsListener$2(this));
    }

    @Override
    public void deinit() {
        this.logger.log(1078071040, "[%1.deinit]", (Object)"ExternalEventsListener");
        this.context.removeActionProxyListener(this);
        this.eventBus.unregisterListener(this);
        if (null != this.phoneServiceRegistration) {
            this.context.getServiceManager().unregisterService(this.phoneServiceRegistration);
        }
        this.context.getNaviAppHandler().setNavigationStateListener(null);
    }

    @Override
    public void actionProxyCallPerformed(int n, Map map) {
        this.lastActionProxyCall.accept(new Integer(n));
    }

    private void hmiDeactivated() {
        this.context.getKeyEventsHandler().deactivate();
        this.context.getCommandListHelper().create().addSingle(new HMIDeactivated(this.context, this.stateHandler)).execute("ExternalEventsListener.AP_METHOD_HMI_DEACTIVATED");
    }

    private void closeAllDrawer() {
        this.logger.log(-2137614336, "[%1.hmiActivated] - closeSelectionDrawer()", (Object)"ExternalEventsListener");
        DrawerEvent drawerEvent = new DrawerEvent(this.hmiService.getRootWindow(0), 7);
        this.hmiService.getEventDispatcher().postEvent(drawerEvent);
    }

    private void hmiActivated() {
        this.context.getKeyEventsHandler().activate();
        this.closeAllDrawer();
        this.context.getCommandListHelper().create().addSingle(new HMIActivated(this.context, this.stateHandler)).execute("ExternalEventsListener.AP_METHOD_HMI_ACTIVATED");
    }

    @Override
    public void audioStateChanged(AudioConnectionState audioConnectionState) {
        this.logger.log(14808325, "[%1.audioStateChanged] '%2'", (Object)"ExternalEventsListener", (Object)audioConnectionState);
    }

    @Override
    public void audioFocusChanged(boolean bl) {
        SmartphoneManager$SmartphoneType smartphoneManager$SmartphoneType = this.context.getSmartphoneDSIManager().getSmartphoneType();
        this.logger.log(1078071040, "<- [%1.audioFocusChanged] %2 %3", (Object)"ExternalEventsListener", (Object)String.valueOf(bl), (Object)smartphoneManager$SmartphoneType);
        this.context.getChoiceModel(4451).setValue(bl && smartphoneManager$SmartphoneType.isNot(SmartphoneManager$SmartphoneType.UNKNOWN) ? TerminalModeUtils.mapActiveSmartphoneTypeToEntertainmentAudioModelType((SmartphoneManager$SmartphoneType)smartphoneManager$SmartphoneType) : 0);
        AbstractCommand abstractCommand = this.getCurrentCommand();
        if (null == abstractCommand || !abstractCommand.updateAudioFocus(bl)) {
            this.context.getCommandListHelper().create().addSingle(new AudioFocusChanged(this.context, bl, this.stateHandler)).execute("ExternalEventsListener.audioFocusChanged]");
        }
    }

    @Override
    public void stateChanged(boolean bl) {
        this.logger.log(1078071040, "<- [%1.stateChanged]", (Object)"ExternalEventsListener");
        this.context.getCommandListHelper().create().addSingle(new NavigationStateChanged(this.context, bl, this.stateHandler)).execute("ExternalEventsListener.stateChanged]");
    }

    private AbstractCommand getCurrentCommand() {
        AbstractCommand abstractCommand = null;
        CommandList commandList = this.context.getCommandListManager().getActiveCommandList();
        if (null != commandList) {
            abstractCommand = (AbstractCommand)commandList.getActiveCommand();
        }
        return abstractCommand;
    }

    @Override
    public void updateKombiStage(boolean bl) {
        if (bl && this.screenActive) {
            this.hmiActivated();
        } else {
            this.hmiDeactivated();
        }
        this.bigStage = bl;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ LogChannel access$000(ExternalEventsListener externalEventsListener) {
        return externalEventsListener.logger;
    }

    static /* synthetic */ IContext access$100(ExternalEventsListener externalEventsListener) {
        return externalEventsListener.context;
    }

    static /* synthetic */ IStateHandler access$200(ExternalEventsListener externalEventsListener) {
        return externalEventsListener.stateHandler;
    }

    static /* synthetic */ IDSISmartphoneManager.ISmartphoneProperties access$300(ExternalEventsListener externalEventsListener) {
        return externalEventsListener.smartphoneProperties;
    }

    static /* synthetic */ boolean access$400(ExternalEventsListener externalEventsListener) {
        return externalEventsListener.bigStage;
    }

    static /* synthetic */ void access$500(ExternalEventsListener externalEventsListener) {
        externalEventsListener.hmiActivated();
    }

    static /* synthetic */ boolean access$602(ExternalEventsListener externalEventsListener, boolean bl) {
        externalEventsListener.screenActive = bl;
        return externalEventsListener.screenActive;
    }

    static /* synthetic */ void access$700(ExternalEventsListener externalEventsListener) {
        externalEventsListener.hmiDeactivated();
    }
}

