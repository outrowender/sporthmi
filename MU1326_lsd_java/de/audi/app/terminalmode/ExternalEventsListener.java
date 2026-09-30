/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.INavigationStateListener;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.SmartphoneManager;
import de.audi.app.terminalmode.TerminalModeUtils;
import de.audi.app.terminalmode.actionproxy.IActionProxyListener;
import de.audi.app.terminalmode.audio.AudioConnectionState;
import de.audi.app.terminalmode.audio.IAudioStateListener;
import de.audi.app.terminalmode.commands.AudioFocusChanged;
import de.audi.app.terminalmode.commands.HMIActivated;
import de.audi.app.terminalmode.commands.HMIDeactivated;
import de.audi.app.terminalmode.commands.NavigationStateChanged;
import de.audi.app.terminalmode.commands.PhoneStateUpdate;
import de.audi.app.terminalmode.events.DefaultEventListener;
import de.audi.app.terminalmode.events.IEventBus;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.commands.AbstractCommand;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.event.DrawerEvent;
import de.audi.atip.interapp.phone.ITelState;
import de.audi.atip.interapp.phone.ITelStateListener;
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
    public static final int ACTION_PROXY_DEBOUNCE_TIME = 70;
    private static final String LOGCLASS = "ExternalEventsListener";
    private final LogChannel logger;
    private final IContext context;
    private volatile ServiceRegistration phoneServiceRegistration;
    private final IStateHandler stateHandler;
    private final IEventBus eventBus;
    private volatile boolean bigStage;
    private volatile boolean screenActive;
    private final IDispatcher dispatcher;
    private final Property<Integer> lastActionProxyCall;
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

    public void init() {
        this.logger.log(100000000, "[%1.init]", (Object)LOGCLASS);
        this.bigStage = true;
        this.screenActive = false;
        this.context.addActionProxyListener(1001, this);
        this.context.addActionProxyListener(1002, this);
        this.eventBus.registerListener(this);
        this.context.getChoiceModel(3200035).setValue(78);
        this.phoneServiceRegistration = this.context.getServiceManager().registerService(class$de$audi$atip$interapp$phone$ITelStateListener == null ? (class$de$audi$atip$interapp$phone$ITelStateListener = ExternalEventsListener.class$("de.audi.atip.interapp.phone.ITelStateListener")) : class$de$audi$atip$interapp$phone$ITelStateListener, new ITelStateListener(){

            public void updateTelState(int n, ITelState iTelState) {
                ExternalEventsListener.this.logger.log(1000000, "<- [%1.updateTelState]", (Object)ExternalEventsListener.LOGCLASS);
                ExternalEventsListener.this.context.getCommandListHelper().create().addSingle(new PhoneStateUpdate(ExternalEventsListener.this.context, iTelState.getCallActive(), ExternalEventsListener.this.stateHandler)).execute("ExternalEventsListener.updateTelState");
                ExternalEventsListener.this.smartphoneProperties.getPropertyMUHFPPhonecallActive().accept(new Boolean(iTelState.getCallActive()));
            }
        }, new Hashtable(0));
        this.context.getNaviAppHandler().setNavigationStateListener(this);
        this.context.getAudioManager().addAudioContextListener(this);
        this.lastActionProxyCall.observe().log(this.logger, "beforeDebounce").debounce(70, this.dispatcher).log(this.logger, "afterDebounce").redirectTo(new Consumer<Integer>(){

            @Override
            public void accept(Integer n) {
                switch (n) {
                    case 1001: {
                        ExternalEventsListener.this.logger.log(1000000, "<<- [%1.actionProxyCallPerformed] AP_METHOD_HMI_ACTIVATED", (Object)ExternalEventsListener.LOGCLASS);
                        if (ExternalEventsListener.this.bigStage) {
                            ExternalEventsListener.this.hmiActivated();
                        }
                        ExternalEventsListener.this.screenActive = true;
                        break;
                    }
                    case 1002: {
                        ExternalEventsListener.this.logger.log(1000000, "<<- [%1.actionProxyCallPerformed] AP_METHOD_HMI_DEACTIVATED", (Object)ExternalEventsListener.LOGCLASS);
                        ExternalEventsListener.this.hmiDeactivated();
                        ExternalEventsListener.this.screenActive = false;
                        break;
                    }
                }
            }

            @Override
            public /* synthetic */ void accept(Object object) {
                this.accept((Integer)object);
            }
        });
    }

    public void deinit() {
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.context.removeActionProxyListener(this);
        this.eventBus.unregisterListener(this);
        if (null != this.phoneServiceRegistration) {
            this.context.getServiceManager().unregisterService(this.phoneServiceRegistration);
        }
        this.context.getNaviAppHandler().setNavigationStateListener(null);
    }

    public void actionProxyCallPerformed(int n, Map map) {
        this.lastActionProxyCall.accept(new Integer(n));
    }

    private void hmiDeactivated() {
        this.context.getKeyEventsHandler().deactivate();
        this.context.getCommandListHelper().create().addSingle(new HMIDeactivated(this.context, this.stateHandler)).execute("ExternalEventsListener.AP_METHOD_HMI_DEACTIVATED");
    }

    private void closeAllDrawer() {
        this.logger.log(10000000, "[%1.hmiActivated] - closeSelectionDrawer()", (Object)LOGCLASS);
        DrawerEvent drawerEvent = new DrawerEvent(this.hmiService.getRootWindow(0), 7);
        this.hmiService.getEventDispatcher().postEvent(drawerEvent);
    }

    private void hmiActivated() {
        this.context.getKeyEventsHandler().activate();
        this.closeAllDrawer();
        this.context.getCommandListHelper().create().addSingle(new HMIActivated(this.context, this.stateHandler)).execute("ExternalEventsListener.AP_METHOD_HMI_ACTIVATED");
    }

    public void audioStateChanged(AudioConnectionState audioConnectionState) {
        this.logger.log(100000000, "[%1.audioStateChanged] '%2'", (Object)LOGCLASS, (Object)audioConnectionState);
    }

    public void audioFocusChanged(boolean bl) {
        SmartphoneManager.SmartphoneType smartphoneType = this.context.getSmartphoneDSIManager().getSmartphoneType();
        this.logger.log(1000000, "<- [%1.audioFocusChanged] %2 %3", (Object)LOGCLASS, (Object)String.valueOf(bl), (Object)smartphoneType);
        this.context.getChoiceModel(4451).setValue(bl && smartphoneType.isNot(SmartphoneManager.SmartphoneType.UNKNOWN) ? TerminalModeUtils.mapActiveSmartphoneTypeToEntertainmentAudioModelType(smartphoneType) : 0);
        AbstractCommand abstractCommand = this.getCurrentCommand();
        if (null == abstractCommand || !abstractCommand.updateAudioFocus(bl)) {
            this.context.getCommandListHelper().create().addSingle(new AudioFocusChanged(this.context, bl, this.stateHandler)).execute("ExternalEventsListener.audioFocusChanged]");
        }
    }

    public void stateChanged(boolean bl) {
        this.logger.log(1000000, "<- [%1.stateChanged]", (Object)LOGCLASS);
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
}

