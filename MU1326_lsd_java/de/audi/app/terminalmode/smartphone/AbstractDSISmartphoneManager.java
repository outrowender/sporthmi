/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITMDeviceSubsystem;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.SmartphoneManager;
import de.audi.app.terminalmode.dsi.IDSIAppState;
import de.audi.app.terminalmode.dsi.IDSIControllerStateListener;
import de.audi.app.terminalmode.keyevents.TMKeyEventsHandler;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManagerListener;
import de.audi.app.terminalmode.smartphone.IPlayerModificationListener;
import de.audi.app.terminalmode.statemachine.Application;
import de.audi.app.terminalmode.statemachine.SpeechMode;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.util.Enum;
import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.Preconditions;

public abstract class AbstractDSISmartphoneManager
implements IDSISmartphoneManager,
IDSIControllerStateListener,
IPlayerModificationListener,
ITerminalModeComponent,
ITMDeviceSubsystem {
    private static final String LOGCLASS = "AbstractDSISmartphoneManager";
    protected static final int INSTANCE_ID = 0;
    protected final LogChannel logger;
    protected final IContext context;
    protected final TMKeyEventsHandler keyEventsHandler;
    private final SmartphoneManager.SmartphoneType type;
    protected volatile IDSISmartphoneManagerListener smartphoneManagerListener;
    private volatile boolean dsiAvailable;
    protected volatile boolean active;
    protected volatile long messageIdCounter;
    protected volatile MediaChannelState mediaState;
    protected final MediaChannelState NORMAL = new MediaChannelState("NORMAL");
    protected final MediaChannelState PAUSE = new MediaChannelState("PAUSE");
    protected final MediaChannelState PAUSED_BY_MUTE = new MediaChannelState("PAUSED_BY_MUTE");
    static /* synthetic */ Class class$de$audi$app$terminalmode$smartphone$IDSISmartphoneManagerListener;

    public AbstractDSISmartphoneManager(IContext iContext, SmartphoneManager.SmartphoneType smartphoneType) {
        this.logger = iContext.getLogger().main();
        this.context = iContext;
        this.dsiAvailable = false;
        this.keyEventsHandler = iContext.getKeyEventsHandler();
        this.type = smartphoneType;
        this.mediaState = this.NORMAL;
    }

    public void init() {
        this.logger.log(100000000, "[%1.init]", (Object)LOGCLASS);
        this.messageIdCounter = 0L;
        this.smartphoneManagerListener = Preconditions.checkNotNull((IDSISmartphoneManagerListener)this.context.get(this.type, class$de$audi$app$terminalmode$smartphone$IDSISmartphoneManagerListener == null ? (class$de$audi$app$terminalmode$smartphone$IDSISmartphoneManagerListener = AbstractDSISmartphoneManager.class$("de.audi.app.terminalmode.smartphone.IDSISmartphoneManagerListener")) : class$de$audi$app$terminalmode$smartphone$IDSISmartphoneManagerListener));
    }

    public void deinit() {
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
    }

    public void activate() {
        this.mediaState = this.NORMAL;
    }

    public void deactivate() {
    }

    public final void dsiUnavailable() {
        this.logger.log(1000000, "[%1.dsiUnavailable]", (Object)LOGCLASS);
        this.dsiAvailable = false;
        this.smartphoneManagerListener.updateDSIState(false);
    }

    public final void dsiAvailable() {
        this.logger.log(1000000, "[%1.dsiAvailable]", (Object)LOGCLASS);
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

    protected abstract IDSIAppState createAppState(int var1, int var2, int var3);

    public final IPlayerModificationListener getPlayerModificationListener() {
        return this;
    }

    public final SmartphoneManager.SmartphoneType getSmartphoneType() {
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

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public class MediaChannelState
    extends Enum<MediaChannelState> {
        protected MediaChannelState(String string) {
            super(string);
        }
    }
}

