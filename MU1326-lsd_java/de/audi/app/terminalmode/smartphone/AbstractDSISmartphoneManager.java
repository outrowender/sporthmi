/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 *  de.audi.atip.utils.Preconditions
 */
package de.audi.app.terminalmode.smartphone;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITMDeviceSubsystem;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.SmartphoneManager$SmartphoneType;
import de.audi.app.terminalmode.dsi.IDSIAppState;
import de.audi.app.terminalmode.dsi.IDSIControllerStateListener;
import de.audi.app.terminalmode.keyevents.TMKeyEventsHandler;
import de.audi.app.terminalmode.smartphone.AbstractDSISmartphoneManager$MediaChannelState;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManagerListener;
import de.audi.app.terminalmode.smartphone.IPlayerModificationListener;
import de.audi.app.terminalmode.statemachine.Application;
import de.audi.app.terminalmode.statemachine.SpeechMode;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.Preconditions;

public abstract class AbstractDSISmartphoneManager
implements IDSISmartphoneManager,
IDSIControllerStateListener,
IPlayerModificationListener,
ITerminalModeComponent,
ITMDeviceSubsystem {
    private static final String LOGCLASS;
    protected static final int INSTANCE_ID;
    protected final LogChannel logger;
    protected final IContext context;
    protected final TMKeyEventsHandler keyEventsHandler;
    private final SmartphoneManager$SmartphoneType type;
    protected volatile IDSISmartphoneManagerListener smartphoneManagerListener;
    private volatile boolean dsiAvailable;
    protected volatile boolean active;
    protected volatile long messageIdCounter;
    protected volatile AbstractDSISmartphoneManager$MediaChannelState mediaState;
    protected final AbstractDSISmartphoneManager$MediaChannelState NORMAL = new AbstractDSISmartphoneManager$MediaChannelState(this, "NORMAL");
    protected final AbstractDSISmartphoneManager$MediaChannelState PAUSE = new AbstractDSISmartphoneManager$MediaChannelState(this, "PAUSE");
    protected final AbstractDSISmartphoneManager$MediaChannelState PAUSED_BY_MUTE = new AbstractDSISmartphoneManager$MediaChannelState(this, "PAUSED_BY_MUTE");
    static /* synthetic */ Class class$de$audi$app$terminalmode$smartphone$IDSISmartphoneManagerListener;

    public AbstractDSISmartphoneManager(IContext iContext, SmartphoneManager$SmartphoneType smartphoneManager$SmartphoneType) {
        this.logger = iContext.getLogger().main();
        this.context = iContext;
        this.dsiAvailable = false;
        this.keyEventsHandler = iContext.getKeyEventsHandler();
        this.type = smartphoneManager$SmartphoneType;
        this.mediaState = this.NORMAL;
    }

    @Override
    public void init() {
        this.logger.log(14808325, "[%1.init]", (Object)"AbstractDSISmartphoneManager");
        this.messageIdCounter = 0L;
        this.smartphoneManagerListener = (IDSISmartphoneManagerListener)Preconditions.checkNotNull((Object)((IDSISmartphoneManagerListener)this.context.get(this.type, class$de$audi$app$terminalmode$smartphone$IDSISmartphoneManagerListener == null ? (class$de$audi$app$terminalmode$smartphone$IDSISmartphoneManagerListener = AbstractDSISmartphoneManager.class$("de.audi.app.terminalmode.smartphone.IDSISmartphoneManagerListener")) : class$de$audi$app$terminalmode$smartphone$IDSISmartphoneManagerListener)));
    }

    @Override
    public void deinit() {
        this.logger.log(1078071040, "[%1.deinit]", (Object)"AbstractDSISmartphoneManager");
    }

    @Override
    public void activate() {
        this.mediaState = this.NORMAL;
    }

    @Override
    public void deactivate() {
    }

    @Override
    public final void dsiUnavailable() {
        this.logger.log(1078071040, "[%1.dsiUnavailable]", (Object)"AbstractDSISmartphoneManager");
        this.dsiAvailable = false;
        this.smartphoneManagerListener.updateDSIState(false);
    }

    @Override
    public final void dsiAvailable() {
        this.logger.log(1078071040, "[%1.dsiAvailable]", (Object)"AbstractDSISmartphoneManager");
        this.dsiAvailable = true;
        if (this.active) {
            this.smartphoneManagerListener.updateDSIState(true);
        }
    }

    protected final boolean isDsiAvailable() {
        return this.dsiAvailable;
    }

    public final IDSIAppState[] getAppStates(TMState tMState) {
        IDSIAppState[] iDSIAppStateArray = new IDSIAppState[]{this.createAppState(2, tMState.isAppOwnerDevice(Application.NAVI) ? 2 : (tMState.isAppOwnerMainUnit(Application.NAVI) ? 1 : 3), 0), this.createAppState(1, tMState.isAppOwnerDevice(Application.PHONE) ? 2 : (tMState.isAppOwnerMainUnit(Application.PHONE) ? 1 : 3), 0), this.createAppState(3, tMState.isAppOwnerDevice(Application.SPEECH) ? 2 : (tMState.isAppOwnerMainUnit(Application.SPEECH) ? 1 : 3), this.getSpeechMode(tMState.getSpeechMode()))};
        return iDSIAppStateArray;
    }

    private int getSpeechMode(SpeechMode speechMode) {
        if (SpeechMode.NONE.is(speechMode)) {
            return 0;
        }
        if (SpeechMode.SPEEKING.is(speechMode)) {
            return 1;
        }
        if (SpeechMode.RECOGNIZING.is(speechMode)) {
            return 2;
        }
        return 0;
    }

    protected abstract IDSIAppState createAppState(int n, int n2, int n3) {
    }

    @Override
    public final IPlayerModificationListener getPlayerModificationListener() {
        return this;
    }

    @Override
    public final SmartphoneManager$SmartphoneType getSmartphoneType() {
        return this.type;
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

