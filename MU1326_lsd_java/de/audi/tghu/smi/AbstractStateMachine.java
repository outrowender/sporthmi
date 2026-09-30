/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.smi;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.KbdService;
import de.audi.atip.hmi.model.AdditionalScreenData;
import de.audi.atip.statemachine.EventMediator;
import de.audi.atip.statemachine.SMModule;
import de.audi.atip.statemachine.SMServices;
import de.audi.atip.statemachine.SMSyncTarget;
import de.audi.atip.statemachine.State;
import de.audi.atip.statemachine.SyncTargetProcessor;
import de.audi.atip.statemachine.Transition;
import de.audi.atip.statemachine.sds.TTSASR;
import de.audi.tghu.smi.AbstractUIService;
import de.audi.tghu.smi.DrawerIDSet;
import de.audi.tghu.smi.ErrorLog;
import de.audi.tghu.smi.EventQueue;
import de.audi.tghu.smi.IStateMachinePresetAccess;
import de.audi.tghu.smi.Logger;
import de.audi.tghu.smi.SMI;
import de.audi.tghu.smi.StateMachineData;
import de.audi.tghu.smi.StateMachineTerminal;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.IntList;
import de.esolutions.fw.util.commons.LongList;

abstract class AbstractStateMachine
implements SMServices,
SyncTargetProcessor,
IStateMachinePresetAccess {
    private static final int STATESTACK_SIZE = 128;
    private static final int MAX_MEDIATOR_EVENTS = 16;
    private static final int MAX_MEDIATOR_EVENT_COUNT = 100;
    private static final int WARN_MEDIATOR_EVENT_COUNT = 50;
    private static final int MAX_INTERNAL_EVENT_COUNT = 600;
    private static final int WARN_INTERNAL_EVENT_COUNT = 400;
    private KbdService keyboardService;
    private final SMI smi;
    protected Logger logger;
    protected final String tag;
    protected final ErrorLog errLog;
    protected final StateMachineData data;
    protected AbstractUIService uiService;
    private EventQueue mediatorEventQueue;
    private boolean started = false;
    private boolean utUnprocessed = false;
    private String unprocessedExtState = null;
    private boolean hasFocus = true;
    private int activeStates = 0;
    private State[] activeStateStack = new State[128];
    protected int internalEvent = -1;
    private int internalEventCounter = 0;
    private int[] internalEventStates = new int[600];
    private int includeJumpEvent = -1;
    private boolean enforceMediationEvent = false;
    private State[] tmpStateStack = new State[128];
    private int restoredHistories = 0;
    private int[] restoredHistoryStack = new int[128];
    private int[] restoredStateStack = new int[128];
    private boolean reinitScreen = false;
    private boolean animateScreenChange = false;
    private int trgtStateIdx = -1;
    private boolean includeBindingChanged = false;
    private boolean eventProcessed = false;
    private boolean mediatorStarted = false;
    protected IntList partialPopupShowList = new IntList(4, 2);
    protected IntList partialPopupHideList = new IntList(4, 2);
    private int lastSyncEvent = -1;
    private final LongList contexts;
    private static final int DRAWER_STACK_MAX_SIZE = 20;
    private int drawerCount = 0;
    private DrawerIDSet[] drawerStack = new DrawerIDSet[20];
    private int screenAnimations;
    private static final int INVALID_COLOR_SET = -1;
    private int currentColorSet = -1;
    private static final int INVALID_SCREEN_MODE = -1;
    private int screenMode = -1;
    private AdditionalScreenData nextScreenMetaInfo;

    public AbstractStateMachine(SMI sMI, Logger logger, String string, StateMachineData stateMachineData) {
        this.smi = sMI;
        this.logger = logger;
        this.tag = string;
        this.data = stateMachineData;
        this.mediatorEventQueue = new EventQueue(sMI, logger.sm[this.getTerminalID()][this.getSubterminalID()], 16);
        this.errLog = new ErrorLog(this);
        this.contexts = new LongList(15);
    }

    public final StateMachineTerminal getTerminal() {
        return this.data.terminal;
    }

    protected final IFrameworkAccess getFramework() {
        return this.getSMI().getFramework();
    }

    protected final SMI getSMI() {
        return this.smi;
    }

    public final int getTerminalID() {
        return this.data.terminalID;
    }

    public final String getTerminalName() {
        return this.data.terminal.getTerminalName();
    }

    public final String getTag() {
        return this.tag;
    }

    public final ErrorLog getErrorLog() {
        return this.errLog;
    }

    public final int getSubterminalID() {
        return this.data.subterminalID;
    }

    public void setKeyboardService(KbdService kbdService) {
        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000000, "[AbstractStateMachine#setKeyboardService] [%1] set new keyboard service (%2).", (Object)this.tag, (Object)kbdService);
        this.keyboardService = kbdService;
    }

    public KbdService getKeyboardService() {
        return this.keyboardService;
    }

    public void showPartialPopup(int n) {
        if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug2()) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(100000000, "[AbstractStateMachine#showPartialPopup] add partialPopup %1 to the list", (long)n);
        }
        if (!this.partialPopupShowList.contains(n)) {
            this.partialPopupShowList.add(n);
        }
    }

    public void hidePartialPopup(int n) {
        if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug2()) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(100000000, "[AbstractStateMachine#hidePartialPopup] add partialPopup %1 to the list", (long)n);
        }
        if (!this.partialPopupHideList.contains(n)) {
            this.partialPopupHideList.add(n);
        }
    }

    protected abstract int getTopLevelStateID();

    public boolean isInitialised() {
        return this.data.isInitialised();
    }

    public boolean isStarted() {
        return this.started;
    }

    public void start() {
        if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug2()) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(100000000, "[AbstractStateMachine#start] [%1] called", (Object)this.tag);
        }
        if (this.started) {
            return;
        }
        if (!this.isInitialised()) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000000, "[AbstractStateMachine#start] [%1] state machine started before it was initialised.", (Object)this.tag);
            return;
        }
        this.started = true;
        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000000, "[AbstractStateMachine#start] [%1] starting SM...", (Object)this.tag);
        State state = this.data.getState(this.getTopLevelStateID());
        if (state == null) {
            this.started = false;
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000, "[AbstractStateMachine#start] [%1] toplevelState (STATEID#%2) is null.", (Object)this.tag, (Object)Integer.toString(this.getTopLevelStateID()), (Object)this.tag);
            return;
        }
        if (!state.isComposite()) {
            this.started = false;
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000, "[AbstractStateMachine#start] [%1] unable to start state machine as System Top-Level State is not a composite state.", (Object)this.tag);
            return;
        }
        this.activeStateStack[0] = state;
        this.activeStates = 1;
        this.stateEntered(state, false, false);
        this.processSMEvent(1, null);
        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000000, "[AbstractStateMachine#start] [%1] SM started", (Object)this.tag);
        if (this.lastSyncEvent != -1 && this.started) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000000, "[AbstractStateMachine#start] [%1] (SYNC) buffered SyncEvent detected (SYNCEVID#%2), firing event.", (Object)this.tag, (long)this.lastSyncEvent);
            this.processSyncEvent(this.lastSyncEvent);
            this.lastSyncEvent = -1;
        }
    }

    public void stop() {
        if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug2()) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(100000000, "[AbstractStateMachine#stop] [%1] called", (Object)this.tag);
        }
        if (!this.started) {
            return;
        }
        this.started = false;
        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000000, "[AbstractStateMachine#stop] [%1] stopping SM...", (Object)this.tag);
        for (int i2 = this.activeStates - 1; i2 >= 0; --i2) {
            State state = this.activeStateStack[i2];
            if (this.data.isSMM4IDregistered(state.getStateID())) {
                this.stateExited(state);
                continue;
            }
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#stop] [%1] state (STATEID#%2) exited.", (Object)this.tag, (long)state.getStateID());
        }
        this.clearActiveStateStack();
        this.uiService.stopUI();
        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000000, "[AbstractStateMachine#stop] [%1] SM stopped", (Object)this.tag);
    }

    public void setFocus(boolean bl) {
        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000000, "[AbstractStateMachine#setFocus] called, focus set to '%1', current focus: '%2'.", bl, this.hasFocus);
        if (this.hasFocus != bl) {
            this.hasFocus = bl;
            for (int i2 = 0; i2 < this.activeStates; ++i2) {
                State state = this.activeStateStack[i2];
                int n = state.getStateID();
                SMModule sMModule = this.data.getSMM4ID(n);
                if (this.hasFocus) {
                    if (!state.hasFocusGainedAction()) continue;
                    this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#setFocus] [%1] call focus-gained action of state (STATEID#%2).", (Object)this.tag, (long)n);
                    this.errLog.startExecutingFocusGainedAction(n);
                    try {
                        sMModule.execFocusGainedAction(this, n);
                    }
                    catch (Exception exception) {
                        this.getFramework().getErrorMgr().handleError(exception, "exception in focus-lost action call of state " + n, 0, 3, 0);
                        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000, "[AbstractStateMachine#setFocus] error in focus-gained action call of state (STATEID#%1).", (long)n, (Throwable)exception);
                    }
                    this.errLog.finishedExecutingFocusGainedAction();
                    continue;
                }
                if (!state.hasFocusLostAction()) continue;
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#setFocus] [%1] call focus-lost action of state (STATEID#%2).", (long)n);
                this.errLog.startExecutingFocusLostAction(n);
                try {
                    sMModule.execFocusLostAction(this, n);
                }
                catch (Exception exception) {
                    this.getFramework().getErrorMgr().handleError(exception, "exception in focus-lost action call of state " + n, 0, 3, 0);
                    this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000, "[AbstractStateMachine#setFocus] error in focus-lost action call of state (STATEID#%1).", (long)n, (Throwable)exception);
                }
                this.errLog.finishedExecutingFocusLostAction();
            }
        }
    }

    public int getActiveScreenState() {
        return this.activeStateStack[this.activeStates - 1].getStateID();
    }

    public int getActiveScreenID() {
        return this.activeStateStack[this.activeStates - 1].getScreenID();
    }

    public boolean processSMEvent(int n, AdditionalScreenData additionalScreenData) {
        if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug2()) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(100000000, "[AbstractStateMachine#processSMEvent] [%1] called for event (EVENTID#%2), metaInfo='%3'", (Object)this.tag, (Object)Integer.toString(n), (Object)additionalScreenData);
        }
        if (additionalScreenData != null) {
            this.nextScreenMetaInfo = additionalScreenData;
        }
        this.errLog.startProcessingEvent(n);
        this.eventProcessed = false;
        this.utUnprocessed = false;
        this.unprocessedExtState = null;
        this.clearPartialPopupLists();
        try {
            if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isInfo()) {
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000000, "[AbstractStateMachine#processSMEvent] [%1] start processing event (EVENTID#%2).", (Object)this.tag, (long)n);
            }
            this.start();
            if (!this.isInitialised() || !this.started) {
                if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isInfo()) {
                    this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000000, "[AbstractStateMachine#processSMEvent] [%1] tried to process event before SM started (started=%2).", (Object)this.tag, (Object)Boolean.toString(this.started));
                    this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000000, "[AbstractStateMachine#processSMEvent] [%1] processing event (EVENTID#%2) aborted.", (Object)this.tag, (long)n);
                }
                return false;
            }
            this.animateScreenChange = false;
            this.includeBindingChanged = false;
            State state = this.processEvent(n);
            if (state != null) {
                this.jumpToState(state);
            } else if (this.mediatorStarted) {
                int n2 = this.getActiveScreenID();
                if (!this.partialPopupShowList.isEmpty()) {
                    this.showPartialPopups(n2, this.partialPopupShowList.toArray());
                }
                if (!this.partialPopupHideList.isEmpty()) {
                    this.hidePartialPopups(n2, this.partialPopupHideList.toArray());
                }
            }
            this.mediatorStarted = false;
            if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isInfo()) {
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000000, "[AbstractStateMachine#processSMEvent] [%1] event (EVENTID#%2) processed (%3).", (Object)this.tag, (Object)Integer.toString(n), (Object)Boolean.toString(this.eventProcessed));
            }
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            this.logger.smi.log(1000, "[AbstractStateMachine#processSMEvent] [%1] invalid data access in method processEvent.", (Object)this.tag, (Throwable)arrayIndexOutOfBoundsException);
            this.smi.criticalError("unexpected error during SMI processing", arrayIndexOutOfBoundsException);
        }
        this.errLog.finishedProcessingEvent();
        return this.eventProcessed;
    }

    private void clearPartialPopupLists() {
        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000000, "[AbstractStateMachine#clearPartialPopupLists] [%1] clearing partial popup lists.", (Object)this.tag);
        this.partialPopupShowList.clear();
        this.partialPopupHideList.clear();
    }

    protected void jumpToState(State state) {
        if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug2()) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(100000000, "[AbstractStateMachine#jumpToState] [%1] jumping to state (STATEID#%2)", (Object)this.tag, (long)state.getStateID());
        }
        if (this.activeStateStack[this.activeStates - 1].getStateID() != state.getStateID() || this.includeBindingChanged) {
            this.switch2State(state);
            int n = 0;
            if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug2()) {
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(100000000, "[AbstractStateMachine#jumpToState] [%1] %2", (Object)this.tag, (Object)(this.mediatorEventQueue.isEmpty() ? "no mediators have been executed, no further processing necessary" : "mediators have been executed, correcting the state..."));
            }
            while (!this.mediatorEventQueue.isEmpty()) {
                int n2 = this.mediatorEventQueue.getNextEvent();
                if (++n >= 50) {
                    if (n == 50) {
                        System.out.println("Warning: more than 50 nested mediator events (e" + n2 + ")");
                    }
                    if ((n - 50) % 5 == 0) {
                        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000, "[AbstractStateMachine#jumpToState] [%1] %2 nested mediator events, last was (EVENTID#%3).", (Object)this.tag, (long)n, (long)n2);
                        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000, "[AbstractStateMachine#jumpToState] [%1] active state stack is: '%2'.", (Object)this.tag, (Object)this.getActiveStateStackString(), 100L);
                    }
                    try {
                        Thread.sleep(n - 50);
                    }
                    catch (InterruptedException interruptedException) {
                        Thread.interrupted();
                    }
                    if (n >= 100) {
                        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000, "[AbstractStateMachine#jumpToState] [%1] %2 nested mediator events, last was (EVENTID#%3).", (Object)this.tag, (long)n, (long)n2);
                        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000, "[AbstractStateMachine#jumpToState] [%1] active state stack is: '%2'.", (Object)this.tag, (Object)this.getActiveStateStackString(), 100L);
                        this.smi.criticalError("Mediator Events nested to deep!");
                    }
                }
                if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isInfo()) {
                    this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000000, "[AbstractStateMachine#jumpToState] [%1] start processing mediator event #%3 in the Queue, (EVENTID#%2), trying to determine target state...", (Object)this.tag, (long)n2, (long)n);
                }
                if ((state = this.processEvent(n2)) != null) {
                    if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isInfo()) {
                        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000000, "[AbstractStateMachine#jumpToState] [%1] mediator event (EVENTID#%2) has been processed, determined target state is (STATEID#%3).", (Object)this.tag, (Object)Integer.toString(n2), (Object)Integer.toString(state.getStateID()));
                    }
                    if (this.activeStateStack[this.activeStates - 1].getStateID() != state.getStateID()) {
                        this.switch2State(state);
                    }
                }
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000000, "[AbstractStateMachine#jumpToState] [%1] mediator event (EVENTID#%2) processed, targetState for this mediator event is (STATEID#%3).", (Object)this.tag, (long)n2, state != null ? (long)state.getStateID() : -1L);
            }
            this.uiService.activateUI(this.activeStateStack, this.activeStates, this.nextScreenMetaInfo);
            this.nextScreenMetaInfo = null;
            State state2 = this.activeStateStack[this.activeStates - 1];
            if (state2 != null && state2.hasEnteredAction()) {
                int n3 = state2.getStateID();
                if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isInfo()) {
                    this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000000, "[AbstractStateMachine#jumpToState] [%1] executing enterED action for state (STATEID#%2).", (Object)this.tag, (long)n3);
                }
                this.errLog.startExecutingEnteredAction(n3);
                try {
                    SMModule sMModule = this.data.getSMM4ID(n3);
                    sMModule.execEnteredAction(this, n3);
                }
                catch (Exception exception) {
                    this.getFramework().getErrorMgr().handleError(exception, "exception in entered action call of state " + n3, 0, 3, 0);
                    this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000, "[AbstractStateMachine#jumpToState] [%1] error in entered action call of state (STATEID#%2).", (Object)this.tag, (Object)Integer.toString(n3));
                    this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000, "[AbstractStateMachine#jumpToState] Exception: ", (Throwable)exception);
                }
                this.errLog.finishedExecutingEnteredAction();
            }
        } else if (this.reinitScreen) {
            if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug2()) {
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(100000000, "[AbstractStateMachine#jumpToState] [%1] current state stack has not changed, but reinitFlag is set", (Object)this.tag, (long)state.getStateID());
            }
            this.uiService.activateUI(this.activeStateStack, this.activeStates, this.nextScreenMetaInfo);
        } else {
            if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug2()) {
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(100000000, "[AbstractStateMachine#jumpToState] [%1] current state stack has not changed, no reinitFlag is set", (Object)this.tag, (long)state.getStateID());
            }
            int n = this.getActiveScreenID();
            if (!this.partialPopupShowList.isEmpty()) {
                this.showPartialPopups(n, this.partialPopupShowList.toArray());
            }
            if (!this.partialPopupHideList.isEmpty()) {
                this.hidePartialPopups(n, this.partialPopupHideList.toArray());
            }
            if (!this.lockingScreen()) {
                this.uiService.lockScreen(false);
            } else {
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000000, "[AbstractStateMachine#jumpToState] [%1] screen (VIEWID#%2) did not change.", (Object)this.tag, (long)n);
            }
            this.uiService.noStateChange();
        }
    }

    public boolean isUnboundEventUnprocessed() {
        return this.utUnprocessed;
    }

    public String getUnproccessedExtStateLabel() {
        return this.unprocessedExtState;
    }

    private Buffer getActiveStateStackString() {
        Buffer buffer = new Buffer(256);
        buffer.append('[');
        for (int i2 = 0; i2 < this.activeStates; ++i2) {
            buffer.append(this.activeStateStack[i2]);
            if (i2 >= this.activeStates - 1) continue;
            buffer.append('|');
        }
        buffer.append(']');
        return buffer;
    }

    private State processEvent(int n) {
        if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug2()) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(100000000, "[AbstractStateMachine#processEvent] [%1] processing event (EVENTID#%2)", (Object)this.tag, (long)n);
        }
        this.restoredHistories = 0;
        State state = null;
        for (int i2 = this.activeStates - 1; i2 >= 0; --i2) {
            state = this.triggerTransition(this.activeStateStack[i2], n);
            if (state == null) {
                if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug2()) {
                    this.logger.sm[this.data.terminalID][this.data.subterminalID].log(100000000, "[AbstractStateMachine#processEvent] [%1] event (EVENTID#%2) has lead to no target state at (STATEID#%3), %4", (Object)this.tag, (Object)Integer.toString(n), (Object)Integer.toString(this.activeStateStack[i2].getStateID()), (Object)(this.mediatorStarted ? "mediator has been started, finish here" : "no mediator started, checking internal events"));
                }
                if (this.mediatorStarted) {
                    this.eventProcessed = true;
                    break;
                }
                state = this.processInternalEvents(this.activeStateStack[i2]);
                if (this.mediatorStarted) {
                    break;
                }
            } else {
                if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug2()) {
                    this.logger.sm[this.data.terminalID][this.data.subterminalID].log(100000000, "[AbstractStateMachine#processEvent] [%1] event (EVENTID#%2) has lead to a target state (STATEID#%3); processing internal events...", (Object)this.tag, (Object)Integer.toString(n), (Object)Integer.toString(state.getStateID()));
                }
                State state2 = this.processInternalEvents(state);
                if (this.mediatorStarted) {
                    state.dispose();
                    state = null;
                    break;
                }
                if (state2 != null || !this.isStarted()) {
                    state.dispose();
                    state = state2;
                }
            }
            if (state == null && this.isStarted()) continue;
            this.eventProcessed = true;
            break;
        }
        if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug2()) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(100000000, "[AbstractStateMachine#processEvent] [%1] event (EVENTID#%2) processed, targetState is (STATEID#%3), %4", (Object)this.tag, (Object)Integer.toString(n), (Object)(state != null ? Integer.toString(state.getStateID()) : "NONE"), (Object)(this.mediatorStarted ? "mediator has been started" : "no mediator has been started"));
        }
        return state;
    }

    protected State processInternalEvents(State state) {
        if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isInfo()) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000000, "[AbstractStateMachine#processInternalEvents] [%1] called, currentState is (STATEID#%2), internal Event is '%3'.", (Object)this.tag, (Object)Integer.toString(state.getStateID()), (Object)this.getInternalEventDescription(this.internalEvent));
        }
        if (this.internalEvent == -1) {
            if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug2()) {
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(100000000, "[AbstractStateMachine#processInternalEvents] [%1] nothing to do, no internal event stored", (Object)this.tag);
            }
            return null;
        }
        State state2 = (State)state.clone();
        State state3 = null;
        this.internalEventCounter = 0;
        while (this.internalEvent > -1) {
            this.monitorInternalEvents(state2);
            boolean bl = false;
            if (this.internalEvent == 1) {
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000000, "[AbstractStateMachine#processInternalEvents] [%1] start processing internal Enter event, currentState is (STATEID#%2).", (Object)this.tag, (long)state.getStateID());
                state3 = this.triggerDefaultTransition(state2);
                if (state3 == null) {
                    if (this.mediatorStarted) {
                        this.eventProcessed = true;
                        break;
                    }
                    if (this.internalEvent != 3) {
                        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000, "[AbstractStateMachine#processInternalEvents] [%1] Unable to fire Default Transition!", (Object)this.tag);
                        this.smi.criticalError("critical model error during SMI processing");
                    }
                    bl = true;
                    this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000000, "[AbstractStateMachine#processInternalEvents] [%1] internal Enter event processed!", (Object)this.tag);
                    continue;
                }
                state2.dispose();
                state2 = state3;
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000000, "[AbstractStateMachine#processInternalEvents] [%1] internal Enter event processed!", (Object)this.tag);
                continue;
            }
            if (this.internalEvent == 2) {
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000000, "[AbstractStateMachine#processInternalEvents] [%1] start processing internal Completion event.", (Object)this.tag);
                state3 = this.triggerCompletionTransition(state2);
                if (state3 == null) {
                    if (this.mediatorStarted) {
                        this.eventProcessed = true;
                        break;
                    }
                    if (this.internalEvent != 3) {
                        if (state2.getStateID() != this.getTopLevelStateID()) {
                            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000, "[AbstractStateMachine#processInternalEvents] [%1] Unable to fire Completion Transition! CurrentStateID is (STATEID#%2), TopLevelStateID is (STATEID#%3).", (Object)this.tag, (long)state2.getStateID(), (long)this.getTopLevelStateID());
                            this.smi.criticalError("critical model error during SMI processing");
                        }
                        return null;
                    }
                    bl = true;
                    this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000000, "[AbstractStateMachine#processInternalEvents] [%1] internal Completion event processed.", (Object)this.tag);
                    continue;
                }
                state2.dispose();
                state2 = state3;
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000000, "[AbstractStateMachine#processInternalEvents] [%1] internal Completion event processed.", (Object)this.tag);
                continue;
            }
            if (this.internalEvent == 3) {
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000000, "[AbstractStateMachine#processInternalEvents] [%1] start processing internal External-State-Unbound event.", (Object)this.tag);
                state3 = this.triggerUnboundTransition(state2);
                if (state3 == null) {
                    if (this.mediatorStarted) {
                        this.eventProcessed = true;
                        this.unprocessedExtState = null;
                        break;
                    }
                    if (bl) {
                        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000, "[AbstractStateMachine#processInternalEvents] [%1] Unable to fire Unbound Transition after unfired Default or Completion Transition.", (Object)this.tag);
                        this.smi.criticalError("critical model error during SMI processing");
                    }
                } else {
                    bl = false;
                    this.unprocessedExtState = null;
                    state2.dispose();
                    state2 = state3;
                }
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000000, "[AbstractStateMachine#processInternalEvents] [%1] internal External-State-Unbound event processed.", (Object)this.tag);
                continue;
            }
            if (this.internalEvent == 4) {
                state3 = this.triggerDefaultTransition(state2);
                if (state3 == null) {
                    if (this.mediatorStarted) {
                        this.eventProcessed = true;
                        break;
                    }
                    if (this.internalEvent != 3) {
                        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000, "[AbstractStateMachine#processInternalEvents] [%1] Unable to fire Default Transition for IncludeJump!", (Object)this.tag);
                        this.smi.criticalError("critical model error during SMI processing");
                    }
                    bl = true;
                    this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000000, "[AbstractStateMachine#processInternalEvents] [%1] internal Enter event processed!", (Object)this.tag);
                    continue;
                }
                state2.dispose();
                state2 = state3;
                state3 = this.triggerIncludeJumpTransition(state2);
                if (state3 == null) {
                    if (this.mediatorStarted) {
                        this.eventProcessed = true;
                        break;
                    }
                    if (this.internalEvent != 3) {
                        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000, "[AbstractStateMachine#processInternalEvents] [%1] Unable to fire IncludeJump Transition!", (Object)this.tag);
                        this.smi.criticalError("critical model error during SMI processing");
                    }
                    bl = true;
                    this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000000, "[AbstractStateMachine#processInternalEvents] [%1] internal IncludeJump event processed!", (Object)this.tag);
                    continue;
                }
                state2.dispose();
                state2 = state3;
                continue;
            }
            this.logger.smi.log(1000, "[AbstractStateMachine#processInternalEvents] [%1] unexpected internal event (EVENTID#%2).", (Object)this.tag, (long)this.internalEvent);
            this.smi.criticalError("critical error during SMI processing");
        }
        if (state3 == null) {
            state2.dispose();
        }
        if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isInfo()) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000000, "[AbstractStateMachine#processInternalEvents] [%1] finished, targetState is (STATEID#%2).", (Object)this.tag, (Object)(state3 != null ? Integer.toString(state3.getStateID()) : Integer.toString(-1)));
        }
        return state3;
    }

    private void monitorInternalEvents(State state) {
        if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug2()) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(100000000, "[AbstractStateMachine#monitorInternalEvents] [%1] currentState='(STATEID#%2)'", (Object)this.tag, (long)state.getStateID());
        }
        this.internalEventStates[this.internalEventCounter] = state.getStateID();
        ++this.internalEventCounter;
        if (this.internalEventCounter >= 600) {
            for (int i2 = 0; i2 < 600; ++i2) {
                this.logger.smi.log(1000000, "[AbstractStateMachine#monitorInternalEvents] internal event state at '%1': (STATEID#%2).", (long)i2, (long)this.internalEventStates[i2]);
            }
            this.smi.criticalError("Internal Events nested to deep!");
        } else if (this.internalEventCounter >= 400) {
            if (this.internalEventCounter == 400) {
                this.logger.smi.log(1000000, "[AbstractStateMachine#monitorInternalEvents] Warning! More than %1 nested internal events.", 400L);
            }
            try {
                Thread.sleep(this.internalEventCounter - 400);
            }
            catch (InterruptedException interruptedException) {
                Thread.interrupted();
            }
        }
    }

    private State triggerTransition(State state, int n) {
        int n2;
        if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug2()) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(100000000, "[AbstractStateMachine#triggerTransition] [%1] trigger transition for state=(STATEID#%2), event=(EVENTID#%3)", (Object)this.tag, (long)state.getStateID(), (long)n);
        }
        if ((n2 = state.getOutgoingTransition(n)) == -1) {
            if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug2()) {
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(100000000, "[AbstractStateMachine#triggerTransition] [%1] no outgoing transition found for the event (EVENTID#%3) at state (STATEID#%2)", (Object)this.tag, (long)state.getStateID(), (long)n);
            }
            return null;
        }
        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#triggerTransition] [%1] transition found: (TRANSID#%2)", (Object)this.tag, (long)n2);
        Transition transition = this.data.getTransition(n2);
        State state2 = this.determineTrgtState(transition);
        if (this.mediatorStarted) {
            if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug2()) {
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(100000000, "[AbstractStateMachine#triggerTransition] [%1] mediator was started by the event, no target state determined", (Object)this.tag);
            }
            return null;
        }
        if (this.internalEvent > -1) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#triggerTransition] [%1] internal event '%2' generated", (Object)this.tag, (Object)this.getInternalEventDescription(this.internalEvent));
        }
        if (state2 != null) {
            this.transitionFired(transition);
        }
        if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug2()) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(100000000, "[AbstractStateMachine#triggerTransition] [%1] finished, targetState is (STATEID#%2)", (Object)this.tag, state2 != null ? (long)state2.getStateID() : -1L);
        }
        return state2;
    }

    private State triggerIncludeJumpTransition(State state) {
        if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug2()) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(100000000, "[AbstractStateMachine#triggerIncludeJumpTransition] [%1] state is (STATEID#%2), includeJumpEvent is (EVENTID#%3)", (Object)this.tag, (long)state.getStateID(), (long)this.includeJumpEvent);
        }
        this.internalEvent = -1;
        if (!state.isInclude()) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000, "[AbstractStateMachine#triggerIncludeJumpTransition] [%1] state (STATEID#%2) is no include-state!", (Object)this.tag, (long)state.getStateID());
            return null;
        }
        int n = state.getOutgoingTransition(this.includeJumpEvent);
        if (n == -1) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000, "[AbstractStateMachine#triggerIncludeJumpTransition] [%1] The transition for the includeJumpEvent (EVENTID#%2) at Include-State (STATEID#%3) cannot be found. Using enter-Transtion for processing.", (Object)this.tag, (long)this.includeJumpEvent, (long)state.getStateID());
            this.includeJumpEvent = -1;
            return this.triggerDefaultTransition(state);
        }
        this.includeJumpEvent = -1;
        Transition transition = this.data.getTransition(n);
        if (transition.startsMediator()) {
            this.trgtStateIdx = 0;
            this.msTransitionFired(transition);
            return null;
        }
        State state2 = this.determineTrgtState(transition);
        if (this.mediatorStarted) {
            return null;
        }
        if (state2 == null) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(100000, "[AbstractStateMachine#triggerDefaultTransition] [%1] IncludeJump-Transition (TRANSID#%2) could not be fired.", (Object)this.tag, (long)n);
        } else {
            this.transitionFired(transition);
        }
        return state2;
    }

    private State triggerDefaultTransition(State state) {
        if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug2()) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(100000000, "[AbstractStateMachine#triggerDefaultTransition] [%1] state='(STATEID#%2)'", (Object)this.tag, (long)state.getStateID());
        }
        this.internalEvent = -1;
        int n = state.getOutgoingTransition(1);
        if (n == -1) {
            if (state.isComposite()) {
                if (state.hasEventMediators()) {
                    this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#triggerDefaultTransition] [%1] Composite State (STATEID#%2) has no Default Transition, Event Mediator must ensure firing of event.", (Object)this.tag, (long)state.getStateID());
                    this.enforceMediationEvent = true;
                    return (State)state.clone();
                }
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000, "[AbstractStateMachine#triggerDefaultTransition] [%1] accessed Composite State (STATEID#%2) without Default Transition or Event Mediator.", (Object)this.tag, (long)state.getStateID());
                this.smi.criticalError("critical model error during SMI processing");
            } else {
                this.logger.smi.log(1000, "[AbstractStateMachine#triggerDefaultTransition] [%1] tried to trigger Default Transition of Simple State (STATEID#%2).", (Object)this.tag, (long)state.getStateID());
                this.smi.criticalError("critical error during SMI processing");
            }
        }
        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#triggerDefaultTransition] [%1] Default Transition (TRANSID#%2) triggered.", (Object)this.tag, (long)n);
        Transition transition = this.data.getTransition(n);
        if (transition.startsMediator()) {
            this.trgtStateIdx = 0;
            this.msTransitionFired(transition);
            return null;
        }
        State state2 = this.determineTrgtState(transition);
        if (this.mediatorStarted) {
            return null;
        }
        if (state2 == null) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(100000, "[AbstractStateMachine#triggerDefaultTransition] [%1] Default Transition (TRANSID#%2) could not be fired.", (Object)this.tag, (long)n);
        } else {
            this.transitionFired(transition);
        }
        return state2;
    }

    private State triggerCompletionTransition(State state) {
        if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug2()) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(100000000, "[AbstractStateMachine#triggerCompletionTransition] [%1] state='(STATEID#%2)'", (Object)this.tag, (long)state.getStateID());
        }
        this.internalEvent = -1;
        int n = state.getOutgoingTransition(2);
        if (n == -1) {
            if (state.getStateID() == this.getTopLevelStateID()) {
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#triggerCompletionTransition] State (STATEID#%1) is topLevel-State! Stopping statemachine!", (long)state.getStateID());
                this.stop();
                return null;
            }
            if (state.isComposite()) {
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000, "[AbstractStateMachine#triggerCompletionTransition] [%1] encountered Final State (STATEID#%2) without associated Completion Transition.", (Object)this.tag, (long)state.getStateID());
                this.smi.criticalError("critical model error during SMI processing");
            } else {
                this.logger.smi.log(1000, "[AbstractStateMachine#triggerCompletionTransition] [%1] tried to trigger Completion Transition of Simple State (STATEID#%2).", (Object)this.tag, (long)state.getStateID());
                this.smi.criticalError("critical error during SMI processing");
            }
        }
        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#triggerCompletionTransition] [%1] Completion Transition (TRANSID#%2) triggered.", (Object)this.tag, (long)n);
        Transition transition = this.data.getTransition(n);
        if (transition.startsMediator()) {
            this.trgtStateIdx = 0;
            this.msTransitionFired(transition);
            return null;
        }
        State state2 = this.determineTrgtState(transition);
        if (this.mediatorStarted) {
            return null;
        }
        if (state2 == null) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(100000, "[AbstractStateMachine#triggerCompletionTransition] [%1] Completion Transition (TRANSID#%2) could not be fired, TargetState is null!", (Object)this.tag, (long)n);
        } else {
            this.transitionFired(transition);
        }
        return state2;
    }

    private State triggerUnboundTransition(State state) {
        if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug2()) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(100000000, "[AbstractStateMachine#triggerUnboundTransition] [%1] state='(STATEID#%2)'", (Object)this.tag, (long)state.getStateID());
        }
        this.internalEvent = -1;
        int n = state.getOutgoingTransition(3);
        if (n == -1) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(100000, "[AbstractStateMachine#triggerUnboundTransition] [%1] No Unbound Transition defined for state (STATEID#%2).", (Object)this.tag, (long)state.getStateID());
            this.utUnprocessed = true;
            return null;
        }
        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#triggerUnboundTransition] [%1] Unbound Transition (TRANSID#%2) triggered.", (Object)this.tag, (long)n);
        Transition transition = this.data.getTransition(n);
        State state2 = this.determineTrgtState(transition);
        if (this.mediatorStarted) {
            return null;
        }
        if (state2 == null) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(100000, "[AbstractStateMachine#triggerUnboundTransition] [%1] Unbound Transition (TRANSID#%2) could not be fired, TargetState is null!", (Object)this.tag, (long)n);
        } else {
            this.transitionFired(transition);
        }
        if (this.internalEvent == 3) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000, "[AbstractStateMachine#triggerUnboundTransition] [%1] Unbound Transition (TRANSID#%2) tried to generate an External-State-Unbound event!", (Object)this.tag, (long)n);
            this.internalEvent = -1;
        }
        return state2;
    }

    private State determineTrgtState(Transition transition) {
        int n;
        if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug2()) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(100000000, "[AbstractStateMachine#determineTrgtState] [%1] (START) transition=(TRANSID#%2)", (Object)this.tag, (long)transition.getTransitionID());
        }
        int n2 = transition.getTransitionID();
        int n3 = 0;
        this.trgtStateIdx = -1;
        if (transition.hasGuard()) {
            SMModule sMModule = this.data.getSMM4ID(n2);
            int n4 = transition.targetStates();
            if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug2()) {
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(100000000, "[AbstractStateMachine#determineTrgtState] [%1] transition (TRANSID#%2) %3", (Object)this.tag, (Object)Integer.toString(n2), (Object)(n4 == 1 ? "one target state, transition has a condition itself" : "has several target states, transition leads to condition"));
            }
            for (n3 = 0; n3 < n4; ++n3) {
                if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug()) {
                    this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#determineTrgtState] [%1] check guard (index %3) for transition (TRANSID#%2).", (Object)this.tag, (long)n2, (long)n3);
                }
                try {
                    if (sMModule.checkGuard(this, n2, n3)) {
                        if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug()) {
                            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#determineTrgtState] [%1] guard for transition (TRANSID#%2) (index %3) fulfilled.", (Object)this.tag, (long)n2, (long)n3);
                        }
                        if (transition.startsMediator(n3)) {
                            if (!this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug2()) break;
                            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(100000000, "[AbstractStateMachine#determineTrgtState] [%1] transition (TRANSID#%2) (index %3) is starting a mediator.", (Object)this.tag, (long)n2, (long)n3);
                            break;
                        }
                        n = transition.getTargetState(n3);
                        if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug2()) {
                            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(100000000, "[AbstractStateMachine#determineTrgtState] [%1] target state of the transition is (STATEID#%2)", (Object)this.tag, (long)n);
                        }
                        if (n > -1) break;
                        if (n == -10) {
                            this.internalEvent = 3;
                            this.unprocessedExtState = transition.getTargetExtStateLabel(n3);
                            if (!this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug()) continue;
                            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#determineTrgtState] [%1] transition (TRANSID#%2) generated External-State-Unbound event, no TargetState was found!", (Object)this.tag, (long)n2);
                            continue;
                        }
                        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000, "[AbstractStateMachine#determineTrgtState] [%1] encountered invalid TargetState (STATEID#%2) for transition (TRANSID#%3) (index %4).", (Object)this.tag, (Object)Integer.toString(n), (Object)Integer.toString(n2), (Object)Integer.toString(n3));
                        this.smi.criticalError("critical model error during SMI processing");
                        continue;
                    }
                    if (!this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug()) continue;
                    this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#determineTrgtState] [%1] guard for transition (TRANSID#%2) (index %3) not fulfilled!", (Object)this.tag, (long)n2, (long)n3);
                    continue;
                }
                catch (Exception exception) {
                    this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000, "[AbstractStateMachine#determineTrgtState] [%1] error during checking guard for transition (TRANSID#%2) (index %3).", (Object)this.tag, (long)n2, (long)n3);
                    this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000, "[AbstractStateMachine#determineTrgtState] [%1] error: '%2'.", (Object)this.tag, (Throwable)exception);
                }
            }
            if (n3 == transition.targetStates()) {
                if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug()) {
                    this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#determineTrgtState] [%1] (END) no target state for transition (TRANSID#%2) found, generated internal event is '%3'", (Object)this.tag, (Object)Integer.toString(n2), (Object)this.getInternalEventDescription(this.internalEvent));
                }
                return null;
            }
            this.internalEvent = -1;
        }
        if (transition.startsMediator(n3)) {
            this.trgtStateIdx = n3;
            if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug2()) {
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(100000000, "[AbstractStateMachine#determineTrgtState] [%1] (END) transition starts mediator", (Object)this.tag);
            }
            this.msTransitionFired(transition);
            return null;
        }
        int n5 = transition.getTargetState(n3);
        if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug2()) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(100000000, "[AbstractStateMachine#determineTrgtState] [%1] normal use-case, transition leads to state (STATEID#%2)", (Object)this.tag, (long)n5);
        }
        if (n5 == -10) {
            this.internalEvent = 3;
            this.unprocessedExtState = transition.getTargetExtStateLabel(n3);
            if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug()) {
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#determineTrgtState] [%1] (END) transition (TRANSID#%3) generated External-State-Unbound event (to ExtState: '%2'), no TargetState found! Maybe Target-SM-Module not initialized.", (Object)this.tag, (Object)this.unprocessedExtState, (long)n2);
            }
            return null;
        }
        if (n5 <= -1) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000, "[AbstractStateMachine#determineTrgtState] [%1] (END) encountered undefined target State for transition (TRANSID#%2) (index %3).", (Object)this.tag, (long)n2, (long)n3);
            this.smi.criticalError("critical model error during SMI processing");
        }
        State state = null;
        if (transition.leadsToHistory(n3)) {
            if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug2()) {
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(100000000, "[AbstractStateMachine#determineTrgtState] [%1] transition leads to history", (Object)this.tag);
            }
            if (!(state = this.data.getState(n5)).hasHistory()) {
                if (!state.isComposite()) {
                    this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000, "[AbstractStateMachine#determineTrgtState] [%1] tried to restore history of Simple State (STATEID#%2), doing nothing.", (Object)this.tag, (long)n5);
                } else {
                    this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000, "[AbstractStateMachine#determineTrgtState] [%1] tried to restore nonexisting history of state (STATEID#%2), adding default-Transition to internal events.", (Object)this.tag, (long)n5);
                    this.internalEvent = 1;
                    if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug()) {
                        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#determineTrgtState] [%1] transition (TRANSID#%2) generated Enter event (default-Transition).", (Object)this.tag, (long)n2);
                    }
                }
            } else {
                do {
                    SMModule sMModule;
                    int n6;
                    if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug()) {
                        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#determineTrgtState] [%1] (iteration) restoring history for target state %2", (Object)this.tag, (Object)state.toString());
                    }
                    n = state.hasDeepHistory() ? 1 : 0;
                    if (state.isIncludeSlot()) {
                        n6 = state.getIncludeStateID();
                        sMModule = this.data.getSMM4ID(n6);
                        if (n6 == -10) {
                            this.internalEvent = 3;
                            if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug()) {
                                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#determineTrgtState] [%1] transition (TRANSID#%2) generated External-State-Unbound event, include state is unbound external state.", (Object)this.tag, (long)n2);
                            }
                            break;
                        }
                        if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug()) {
                            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#determineTrgtState] [%1] bind include state (STATEID#%2) to slot (STATEID#%3).", (Object)this.tag, (long)n6, (long)n5);
                        }
                        if (sMModule.bindIncludeState(n6, n5)) {
                            this.includeBindingChanged = true;
                        }
                        if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug()) {
                            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#determineTrgtState] [%1] restore history of Include Slot (STATEID#%2).", (Object)this.tag, (long)n5);
                        }
                    } else if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug()) {
                        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#determineTrgtState] [%1] restore history of State (STATEID#%2).", (Object)this.tag, (long)n5);
                    }
                    sMModule = this.data.getSMM4ID(n5);
                    n6 = sMModule.getHistory(n5);
                    if (n6 <= -1) {
                        if (state.isIncludeSlot()) {
                            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000, "[AbstractStateMachine#determineTrgtState] [%1] (END) tried to restore history of include slot (STATEID#%2) in module %3 from history of state (STATEID#%4) unsuccessfully.", (Object)this.tag, (Object)(n5 + ""), (Object)sMModule.getSMMName(), (long)transition.getTargetState(n3));
                            this.getSMI().criticalError("critical error during SMI processing - caused by crash or restart of module " + sMModule.getSMMName());
                        } else {
                            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000, "[AbstractStateMachine#determineTrgtState] [%1] (END) tried to restore history at state (STATEID#%2) without default value.", (Object)this.tag, (long)n5);
                            this.smi.criticalError("critical model error during SMI processing");
                        }
                    }
                    this.restoredStateStack[this.restoredHistories] = n6;
                    this.restoredHistoryStack[this.restoredHistories] = n5;
                    ++this.restoredHistories;
                    state.dispose();
                    state = this.data.getState(n6);
                    n5 = n6;
                    if (state.isIncludeSlot()) {
                        int n7 = state.getIncludeStateID();
                        if (n7 == -10) {
                            this.internalEvent = 3;
                            if (!this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug()) continue;
                            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#determineTrgtState] [%1] transition (TRANSID#%2) generated External-State-Unbound event.", (Object)this.tag, (long)n2);
                            continue;
                        }
                        if (n7 <= -1) {
                            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000, "[AbstractStateMachine#determineTrgtState] [%1] undefined include state for include slot (STATEID#%2).", (Object)this.tag, (long)n5);
                            this.smi.criticalError("critical model error during SMI processing");
                            continue;
                        }
                        SMModule sMModule2 = this.data.getSMM4ID(n7);
                        if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug()) {
                            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#determineTrgtState] [%1] (transition leads to history, state in history is include-slot) bind include state (STATEID#%2) to slot (STATEID#%3).", (Object)this.tag, (long)n7, (long)n5);
                        }
                        if (sMModule2.bindIncludeState(n7, n5)) {
                            this.includeBindingChanged = true;
                        }
                        if (n != 0) continue;
                        this.internalEvent = 1;
                        if (!this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug()) continue;
                        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#determineTrgtState] [%1] transition (TRANSID#%2) generated Enter event.", (Object)this.tag, (long)n2);
                        continue;
                    }
                    if (!state.isComposite()) continue;
                    this.internalEvent = 1;
                    if (!this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug()) continue;
                    this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#determineTrgtState] [%1] transition (TRANSID#%2) generated Enter event.", (Object)this.tag, (long)n2);
                } while (state.isIncludeSlot() && n != 0);
            }
        } else if (transition.leadsToFinalState(n3)) {
            this.internalEvent = 2;
            if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug()) {
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#determineTrgtState] [%1] transition (TRANSID#%2), leading to a final state, generated Completion event.", (Object)this.tag, (long)n2);
            }
            state = this.data.getState(n5);
        } else {
            if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug()) {
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#determineTrgtState] [%1] transition leads NOT to history and not to a final state (TRANSID#%2)", (Object)this.tag, (long)n2);
            }
            if ((state = this.data.getState(n5)) != null && state.isIncludeSlot()) {
                n = state.getIncludeStateID();
                if (n == -10) {
                    this.internalEvent = 3;
                    if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug()) {
                        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#determineTrgtState] [%1] target state (STATEID#%3) is include-slot; transition (TRANSID#%2) generated External-State-Unbound event.", (Object)this.tag, (long)n2, (long)n5);
                    }
                } else if (n <= -1) {
                    this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000, "[AbstractStateMachine#determineTrgtState] [%1] (END) target state (STATEID#%3) is include-slot; undefined include state for include slot (STATEID#%2).", (Object)this.tag, (long)n5, (long)n5);
                    this.smi.criticalError("critical model error during SMI processing");
                } else {
                    SMModule sMModule = this.data.getSMM4ID(n);
                    if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug()) {
                        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#determineTrgtState] [%1] target state (STATEID#%3) is include-slot; bind include state (STATEID#%2) to slot (STATEID#%3).", (Object)this.tag, (long)n, (long)n5);
                    }
                    if (sMModule.bindIncludeState(n, n5)) {
                        this.includeBindingChanged = true;
                    }
                    if (transition.isIncludeJumpTransition()) {
                        this.internalEvent = 4;
                        SMModule sMModule3 = this.data.getSMM4ID(transition.getTransitionID());
                        this.includeJumpEvent = sMModule3.getTransIncludeJumpEvent(transition.getTransitionID());
                        if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug()) {
                            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#determineTrgtState] [%1] responsible SMM for transition (TRANSID#%2) is '%3'", (Object)this.tag, (Object)Integer.toString(transition.getTransitionID()), (Object)sMModule3.getSMMName());
                        }
                        if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug()) {
                            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#determineTrgtState] [%1] target state (STATEID#%3) is include-slot; transition (TRANSID#%2) is flagged as INCLUDE-JUMP, Jump-Transition is (TRANSID#%4).", (Object)this.tag, (Object)Integer.toString(n2), (Object)Integer.toString(n5), (Object)Integer.toString(this.includeJumpEvent));
                        }
                    } else {
                        this.internalEvent = 1;
                        if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug()) {
                            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#determineTrgtState] [%1] target state (STATEID#%3) is include-slot; transition (TRANSID#%2) generated Enter event.", (Object)this.tag, (long)n2, (long)n5);
                        }
                    }
                }
            } else if (state != null && state.isComposite()) {
                this.internalEvent = 1;
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#determineTrgtState] [%1] target state (STATEID#%3) is composite state; transition (TRANSID#%2) generated Enter event", (Object)this.tag, (long)n2, (long)n5);
            }
        }
        if (transition.animatesScreenChange(n3) && this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug()) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#determineTrgtState] [%1] transition (TRANSID#%2) with index %3 has animates screen-change flag.", (Object)this.tag, (long)n2, (long)n3);
        }
        this.animateScreenChange |= transition.animatesScreenChange(n3);
        this.reinitScreen = transition.reinitsScreen(n3);
        this.trgtStateIdx = n3;
        if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug()) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#determineTrgtState] [%1] (END) finished, transition (TRANSID#%2) leads to state (STATEID#%3)", (Object)this.tag, (long)n2, state != null ? (long)state.getStateID() : -1L);
        }
        return state;
    }

    private void transitionFired(Transition transition) {
        int n = transition.getTransitionID();
        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#transitionFired] [%1] transition (TRANSID#%2) fired, targetStateIndex is '%3'.", (Object)this.tag, (long)n, (long)this.trgtStateIdx);
        if (transition.hasAction(this.trgtStateIdx)) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#transitionFired] [%1] call action of transition (TRANSID#%2), targetStateIndex is %3.", (Object)this.tag, (long)n, (long)this.trgtStateIdx);
            this.callTransitionAction(n);
        }
    }

    private void msTransitionFired(Transition transition) {
        int n;
        EventMediator eventMediator;
        int n2 = transition.getTransitionID();
        if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug()) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#msTransitionFired] [%1] mediator-start transition (TRANSID#%2) fired.", (Object)this.tag, (long)n2);
        }
        if (transition.hasAction(this.trgtStateIdx)) {
            if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug()) {
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#msTransitionFired] [%1] call action of mediator-start transition (TRANSID#%2).", (Object)this.tag, (long)n2);
            }
            this.callTransitionAction(n2);
        }
        if ((eventMediator = this.data.getMediator(n = transition.getMediator(this.trgtStateIdx))) != null) {
            if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug()) {
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#msTransitionFired] [%1] start mediator (MEDID#%2).", (Object)this.tag, (long)n);
            }
            eventMediator.start();
            this.mediatorStarted = true;
        } else {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000, "[AbstractStateMachine#msTransitionFired] [%1] mediator (MEDID#%2) not found!", (Object)this.tag, (long)n);
        }
    }

    private void callTransitionAction(int n) {
        if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug2()) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(100000000, "[AbstractStateMachine#callTransitionAction] [%1] transition='(TRANSID#%2)'", (Object)this.tag, (long)n);
        }
        SMModule sMModule = this.data.getSMM4ID(n);
        this.errLog.startExecutingTransitionAction(n);
        try {
            sMModule.execTransitionAction(this, n, this.trgtStateIdx);
        }
        catch (Exception exception) {
            this.getFramework().getErrorMgr().handleError(exception, "exception in transition action call of transition " + n + "." + this.trgtStateIdx, 0, 3, 0);
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000, "[AbstractStateMachine#callTransitionAction] [%1] error in transition action call of transition (TRANSID#%2) (index %3).", (Object)this.tag, (long)n, (long)this.trgtStateIdx);
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000, "[AbstractStateMachine#callTransitionAction] [%1] error: '%2'.", (Object)this.tag, (Throwable)exception);
        }
        this.errLog.finishedExecutingTransitionAction();
    }

    private void switch2State(State state) {
        int n;
        if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug2()) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(100000000, "[AbstractStateMachine#switchToState(State)] [%1] state='(STATEID#%2)'", (Object)this.tag, (long)state.getStateID());
        }
        if ((n = this.stateInActiveStack(state.getStateID())) > -1 && !this.includeBindingChanged) {
            if (state.isComposite() && state.hasEventMediators()) {
                int[] nArray = state.getEventMediatorIDs();
                for (int i2 = 0; i2 < nArray.length; ++i2) {
                    int n2 = nArray[i2];
                    int n3 = state.getStateID();
                    SMModule sMModule = this.data.getSMM4ID(n3);
                    EventMediator eventMediator = sMModule.getEventMediator(n2);
                    this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#switch2State(State)] [%1] activate event mediator (MEDID#%2) in state (STATEID#%3) to replace default transition.", (Object)this.tag, (long)n2, (long)n3);
                    int n4 = eventMediator.activate(true);
                    if (n4 <= -1) continue;
                    this.logger.event.log(1000000, "[AbstractStateMachine#switch2State(State)] [%1] SMI received mediator state machine event (EVENTID#%3).", (Object)this.tag, (long)n4);
                    this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#switch2State(State)] [%1] mediator (MEDID#%2) generated event (EVENTID#%3), enqueue event.", (Object)this.tag, (long)n2, (long)n4);
                    this.mediatorEventQueue.enqueueEvent(n4);
                }
            }
            return;
        }
        this.tmpStateStack[0] = state;
        int n5 = 1;
        int n6 = this.activeStates;
        if (this.includeBindingChanged) {
            for (int i3 = 0; i3 < this.activeStates; ++i3) {
                if (!this.activeStateStack[i3].isInclude()) continue;
                State state2 = this.data.getState(this.activeStateStack[i3].getStateID());
                if (this.activeStateStack[i3].getSuperstateID() != state2.getSuperstateID()) {
                    n6 = i3;
                    state2.dispose();
                    break;
                }
                state2.dispose();
            }
            if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug2()) {
                State state3 = this.activeStateStack[n6];
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(100000000, "[AbstractStateMachine#switchToState(State)] [%1] identifed include state with changed binding: state '%2' at position '%3'", (Object)this.tag, (Object)state3, (long)n6);
            }
        }
        int n7 = state.getSuperstateID();
        int n8 = -1;
        State state4 = null;
        while (n7 > -1 && ((n8 = this.stateInActiveStack(n7)) <= -1 || n8 >= n6)) {
            this.tmpStateStack[n5] = state4 = this.data.getState(n7);
            n7 = state4.getSuperstateID();
            if (++n5 <= 128) continue;
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000, "[AbstractStateMachine#switch2State(State)] [%1] state depth (%3) is too high (max = %2).", (Object)this.tag, 128L, (long)n5);
            this.smi.criticalError("critical model error during SMI processing");
        }
        if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug2()) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(100000000, "[AbstractStateMachine#switchToState] [%1] common superstate found: the superstate of '%2', position '%3'", (Object)this.tag, (Object)state4, (long)n8);
        }
        if (n8 > -1) {
            int n9;
            int n10;
            if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug2()) {
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(100000000, "[AbstractStateMachine#switchToState] [%1] updating active state stack...", (Object)this.tag);
            }
            for (n10 = this.activeStates - 1; n10 > n8; --n10) {
                this.stateExited(this.activeStateStack[n10]);
                this.activeStateStack[n10].dispose();
                this.activeStateStack[n10] = null;
                --this.activeStates;
            }
            n10 = 0;
            int n11 = 0;
            boolean bl = false;
            for (n9 = n5 - 1; n9 >= 0; --n9) {
                state4 = this.tmpStateStack[n9];
                int n12 = state4.getStateID();
                this.tmpStateStack[n9] = null;
                --n5;
                this.activeStateStack[this.activeStates] = state4;
                bl = n10 != n11;
                if (n10 < this.restoredHistories && this.restoredHistoryStack[n10] == n12) {
                    ++n10;
                }
                if (n11 < this.restoredHistories && this.restoredStateStack[n11] == n12) {
                    ++n11;
                }
                this.stateEntered(this.activeStateStack[this.activeStates], bl, n9 == 0 && this.enforceMediationEvent);
                ++this.activeStates;
                if (this.activeStates <= 128) continue;
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000, "[AbstractStateMachine#switch2State(State)] [%1] active state depth (%3) is too high (max = %2).", (Object)this.tag, 128L, (long)this.activeStates);
                this.smi.criticalError("critical model error during SMI processing");
            }
            n9 = this.activeStateStack[this.activeStates - 1].getStateID();
            for (int i4 = this.activeStates - 2; i4 >= 0; --i4) {
                SMModule sMModule;
                int n13;
                State state5 = this.activeStateStack[i4];
                if (state5.hasShallowHistory()) {
                    n13 = state5.getStateID();
                    int n14 = this.activeStateStack[i4 + 1].getStateID();
                    sMModule = this.data.getSMM4ID(n13);
                    this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#switch2State(State)] [%1] set shallow history of state (STATEID#%2) to (STATEID#%3).", (Object)this.tag, (long)n13, (long)n14);
                    sMModule.setHistory(n13, n14);
                } else if (state5.hasDeepHistory()) {
                    n13 = state5.getStateID();
                    sMModule = this.data.getSMM4ID(n13);
                    this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#switch2State(State)] [%1] set deep history of state (STATEID#%2) to (STATEID#%3).", (Object)this.tag, (long)n13, (long)n9);
                    sMModule.setHistory(n13, n9);
                }
                if (!state5.isIncludeSlot()) continue;
                n9 = state5.getStateID();
            }
            if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug2()) {
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(100000000, "[AbstractStateMachine#switchToState] [%1] ... active state stack updated.", (Object)this.tag);
            }
        } else {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000, "[AbstractStateMachine#switch2State(State)] [%1] two states (STATEID#%2) (targetState) & (STATEID#%3) (currentState) without common superstate in system.", (Object)this.tag, (long)state.getStateID(), (long)this.activeStateStack[this.activeStates - 1].getStateID());
            this.smi.criticalError("critical model error during SMI processing");
        }
    }

    public void reactivateUI() {
        this.uiService.reactivateUI(this.activeStateStack, this.activeStates, null);
    }

    protected abstract void showPartialPopups(int var1, int[] var2);

    protected abstract void hidePartialPopups(int var1, int[] var2);

    public void enterJointUse(int n, int n2) {
    }

    public void leaveJointUse(int n, int n2) {
    }

    public int getJointUseCount() {
        return 0;
    }

    boolean lockingScreen() {
        for (int i2 = this.activeStates - 1; i2 >= 0; --i2) {
            State state = this.activeStateStack[i2];
            if (!state.hasEventMediators()) continue;
            int[] nArray = state.getEventMediatorIDs();
            SMModule sMModule = this.data.getSMM4ID(state.getStateID());
            for (int i3 = 0; i3 < nArray.length; ++i3) {
                if (!sMModule.getEventMediator(nArray[i3]).locksScreen()) continue;
                if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug2()) {
                    this.logger.sm[this.data.terminalID][this.data.subterminalID].log(100000000, "[AbstractStateMachine#lockingScreen] [%1] screen is still locked by mediator (MEDID#%2) within state (STATEID#%3)", (Object)this.tag, (long)nArray[i3], (long)state.getStateID());
                }
                return true;
            }
        }
        return false;
    }

    private void stateEntered(State state, boolean bl, boolean bl2) {
        int n;
        int[] nArray;
        int n2 = state.getStateID();
        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#stateEntered] [%1] state (STATEID#%3) entered (%2).", (Object)this.tag, (Object)(bl ? "restored" : "not restored"), (long)n2);
        SMModule sMModule = this.data.getSMM4ID(n2);
        if (state.hasEnterAction()) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#stateEntered] [%1] call enter action of state (STATEID#%2).", (Object)this.tag, (long)n2);
            this.errLog.startExecutingEnterAction(n2);
            try {
                sMModule.execEnterAction(this, n2);
            }
            catch (Exception exception) {
                this.getFramework().getErrorMgr().handleError(exception, "exception in enter action call of state " + n2, 0, 3, 0);
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000, "[AbstractStateMachine#stateEntered] [%1] error in enter action call of state (STATEID#%2).", (Object)this.tag, (Object)Integer.toString(n2));
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000, "[AbstractStateMachine#stateEntered] Exception: ", (Throwable)exception);
            }
            this.errLog.finishedExecutingEnterAction();
        }
        if (!this.hasFocus && state.hasFocusLostAction()) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#stateEntered] [%1] call focus-lost action of state (STATEID#%2).", (Object)this.tag, (long)n2);
            this.errLog.startExecutingFocusLostAction(n2);
            try {
                sMModule.execFocusLostAction(this, n2);
            }
            catch (Exception exception) {
                this.getFramework().getErrorMgr().handleError(exception, "exception in focus-lost action call of state " + n2, 0, 3, 0);
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000, "[AbstractStateMachine#stateEntered] [%1] error in focus-lost action call of state (STATEID#%2).", (Object)this.tag, (Object)Integer.toString(n2));
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000, "[AbstractStateMachine#stateEntered] Exception: ", (Throwable)exception);
            }
            this.errLog.finishedExecutingFocusLostAction();
        }
        if (state.hasEventMediators()) {
            nArray = state.getEventMediatorIDs();
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                int n3;
                n = nArray[i2];
                EventMediator eventMediator = sMModule.getEventMediator(n);
                if (bl) {
                    this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#stateEntered] [%1] reactivate event mediator (MEDID#%2).", (Object)this.tag, (long)n);
                    n3 = eventMediator.reactivate(bl2);
                } else {
                    this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#stateEntered] [%1] activate event mediator (MEDID#%2).", (Object)this.tag, (long)n);
                    n3 = eventMediator.activate(bl2);
                }
                if (n3 <= -1) continue;
                this.logger.event.log(1000000, "[AbstractStateMachine#stateEntered] [%1] SMI received mediator state machine event: Terminal='sm%1', Event=(EVENTID#%2).", (Object)this.tag, (long)this.data.terminalID, (long)n3);
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#stateEntered] [%1] mediator (MEDID#%2) generated event (EVENTID#%3).", (Object)this.tag, (long)n, (long)n3);
                this.mediatorEventQueue.enqueueEvent(n3);
            }
        }
        if (state.hasSyncTriggerEvents()) {
            nArray = state.getSyncTriggerEventIDs();
            for (n = 0; n < nArray.length; ++n) {
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#stateEntered] [%1] (SYNC) fire syncTrigger event (SYNCEVID#%2) for state (STATEID#%3).", (Object)this.tag, (long)nArray[n], (long)state.getStateID());
                this.smi.processSyncEvent(this.data.terminalID, nArray[n]);
            }
        }
        if (state.hasSyncTargets()) {
            nArray = state.getSyncTargetIDList();
            for (n = 0; n < nArray.length; ++n) {
                int n4 = nArray[n];
                SMSyncTarget sMSyncTarget = sMModule.getSyncTarget(n4);
                if (sMSyncTarget != null) {
                    this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#stateEntered] [%1] (SYNC) activate syncTarget (SYNCTARID#%2).", (Object)this.tag, (long)n4);
                    sMSyncTarget.activate(this);
                    continue;
                }
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000, "[AbstractStateMachine#stateEntered] [%1] (SYNC) syncTarget (SYNCTARID#%2) has no INSTANCE in generated SMM!", (Object)this.tag, (long)n4);
            }
        }
    }

    private void stateExited(State state) {
        int n;
        int[] nArray;
        int n2 = state.getStateID();
        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#stateExited] [%1] state (STATEID#%2) exited.", (Object)this.tag, (long)n2);
        SMModule sMModule = this.data.getSMM4ID(n2);
        if (state.hasEventMediators()) {
            nArray = state.getEventMediatorIDs();
            for (n = 0; n < nArray.length; ++n) {
                EventMediator eventMediator = sMModule.getEventMediator(nArray[n]);
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#stateExited] [%1] deactivate event mediator (MEDID#%2).", (Object)this.tag, (long)nArray[n]);
                eventMediator.deactivate();
            }
        }
        if (state.hasExitAction()) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#stateExited] [%1] call exit action of state (STATEID#%2).", (Object)this.tag, (long)n2);
            this.errLog.startExecutingExitAction(n2);
            try {
                sMModule.execExitAction(this, n2);
            }
            catch (Exception exception) {
                this.getFramework().getErrorMgr().handleError(exception, "exception in exit action call of state " + n2, 0, 3, 0);
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000, "[AbstractStateMachine#stateExited] [%1] error in exit action call of state (STATEID#%2).", (Object)this.tag, (Object)Integer.toString(n2));
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000, "[AbstractStateMachine#stateExited] Exception: ", (Throwable)exception);
            }
            this.errLog.finishedExecutingExitAction();
        }
        if (state.hasSyncExitTriggerEvents()) {
            nArray = state.getSyncExitTriggerEventIDs();
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#stateExited] [%1] (SYNC) fire syncExitTrigger event (SYNCEVID#%2) for state (STATEID#%3).", (Object)this.tag, (long)nArray[i2], (long)state.getStateID());
                this.smi.processSyncEvent(this.data.terminalID, nArray[i2]);
            }
        }
        if (state.hasSyncTargets()) {
            nArray = state.getSyncTargetIDList();
            for (int i3 = 0; i3 < nArray.length; ++i3) {
                n = nArray[i3];
                SMSyncTarget sMSyncTarget = sMModule.getSyncTarget(n);
                if (sMSyncTarget != null) {
                    this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#stateExited] [%1] (SYNC) deactivate SyncTarget (SYNCTARID#%2) for state (STATEID#%3).", (Object)this.tag, (long)n, (long)n2);
                    sMSyncTarget.deactivate();
                    continue;
                }
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000, "[AbstractStateMachine#stateExited] [%1] (SYNC) SyncTarget (SYNCTARID#%2) for state (STATEID#%3) not found (null)!", (Object)this.tag, (long)n, (long)n2);
            }
        }
    }

    private void clearActiveStateStack() {
        for (int i2 = 0; i2 < this.activeStateStack.length; ++i2) {
            if (this.activeStateStack[i2] == null) continue;
            this.activeStateStack[i2].dispose();
            this.activeStateStack[i2] = null;
        }
        this.activeStates = 0;
    }

    protected void reinitActiveStateStack() {
        for (int i2 = 0; i2 < this.activeStates; ++i2) {
            int n = this.activeStateStack[i2].getStateID();
            if (!this.data.isSMM4IDregistered(n)) {
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000000, "[AbstractStateMachine#reinitActiveStateStack] [%1] SMM of an active state (STATEID#%2) was removed!", (Object)this.tag, (long)n);
                this.stop();
                return;
            }
            this.activeStateStack[i2].dispose();
            this.activeStateStack[i2] = this.data.getState(n);
        }
    }

    private int stateInActiveStack(int n) {
        int n2 = -1;
        for (n2 = this.activeStates - 1; n2 >= 0; --n2) {
            if (this.activeStateStack[n2].getStateID() != n) continue;
            return n2;
        }
        return n2;
    }

    public State[] getActiveStateStack() {
        return this.activeStateStack;
    }

    public int getActiveStates() {
        return this.activeStates;
    }

    boolean isReinitScreen() {
        return this.reinitScreen;
    }

    boolean isAnimateScreenChange() {
        return this.animateScreenChange;
    }

    int[] getPartialPopupShowList() {
        return this.partialPopupShowList.toArray();
    }

    protected void setSDSService(TTSASR tTSASR) {
        this.data.setSDSSerivce(tTSASR);
    }

    public TTSASR getSDSService() {
        return this.data.getSDSService();
    }

    public void processSyncEvent(int n) {
        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#processSyncEvent] [%1] (SYNC) processing syncEvent (SYNCEVID#%2).", (Object)this.tag, (long)n);
        this.clearPartialPopupLists();
        this.animateScreenChange = false;
        if (!this.isStarted()) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#processSyncEvent] [%1] (SYNC) SM not startet, buffering last SyncEventID (SYNCEVID#%2).", (Object)this.tag, (long)n);
            this.lastSyncEvent = n;
            return;
        }
        for (int i2 = this.activeStates - 1; i2 >= 0; --i2) {
            State state = this.activeStateStack[i2];
            if (!state.hasSyncTargets()) continue;
            int[] nArray = state.getSyncTargetIDList();
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#processSyncEvent] [%1] (SYNC) state (STATEID#%2) in activeStateStack in position '%3' has '%4' SyncTargets.", (Object)this.tag, (Object)Integer.toString(state.getStateID()), (Object)Integer.toString(i2), (Object)Integer.toString(nArray.length));
            for (int i3 = 0; i3 < nArray.length; ++i3) {
                int n2 = nArray[i3];
                SMModule sMModule = this.data.getSMM4ID(n2);
                SMSyncTarget sMSyncTarget = sMModule.getSyncTarget(n2);
                if (sMSyncTarget != null) {
                    boolean bl = sMSyncTarget.triggerSync(this, n);
                    if (!bl) continue;
                    this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#processSyncEvent] [%1] (SYNC) SyncTarget for SyncEvent found! SyncTarget-ID: (SYNCTARID#%2).", (Object)this.tag, (long)n2);
                    for (int i4 = 0; i4 < nArray.length; ++i4) {
                        if (i4 == i3) continue;
                        int n3 = nArray[i3];
                        SMModule sMModule2 = this.data.getSMM4ID(n3);
                        if (sMModule2 != null) {
                            SMSyncTarget sMSyncTarget2 = sMModule2.getSyncTarget(n3);
                            if (sMSyncTarget2 == null) continue;
                            sMSyncTarget2.resetTrigger();
                            continue;
                        }
                        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000, "[AbstractStateMachine#processSyncEvent] [%1] (SYNC) Inner SMM is null!", (Object)this.tag);
                    }
                    return;
                }
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000, "[AbstractStateMachine#processSyncEvent] [%1] (SYNC) SyncTarget (SYNCTARID#%2) has no INSTANCE in SMM!", (Object)this.tag, (long)n2);
            }
        }
    }

    public boolean processSyncTransition(int n) {
        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#processSyncTransition] [%1] (SYNC) processing transition (TRANSID#%2) from SyncTarget.", (Object)this.tag, (long)n);
        this.restoredHistories = 0;
        Transition transition = this.data.getTransition(n);
        State state = this.determineTrgtState(transition);
        if (this.logger.sm[this.data.terminalID][this.data.subterminalID].isDebug()) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#processSyncTransition] [%1] determined target state is (STATEID#%2).", (Object)this.tag, (Object)(state == null ? "NONE" : new Integer(state.getStateID()).toString()));
        }
        if (state != null && this.stateInActiveStack(state.getStateID()) > -1) {
            if (!transition.reinitsScreen(0)) {
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#processSyncTransition] [%1] (SYNC) Target-State (STATEID#%2) already in ActiveStateStack, finished.", (Object)this.tag, (long)state.getStateID());
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#processSyncTransition] [%1] (SYNC) transition processed.", (Object)this.tag);
                this.internalEvent = -1;
                return false;
            }
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#processSyncTransition] [%1] (SYNC) Target-State (STATEID#%2) already in ActiveStateStack, but transition is flagged as 'REINIT'. Determine target-state.", (Object)this.tag, (long)state.getStateID());
        }
        if (state == null && this.mediatorStarted) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000, "[AbstractStateMachine#processSyncTransition] [%1] (SYNC) SyncTargets are not allowed to start mediators! Aborting!", (Object)this.tag);
            this.mediatorStarted = false;
            return false;
        }
        if (state != null) {
            if (!this.isStateActive(state) || this.internalEvent == 2) {
                this.transitionFired(transition);
                State state2 = this.processInternalEvents(state);
                if (state2 == null && this.mediatorStarted) {
                    this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000, "[AbstractStateMachine#processSyncTransition] [%1] (SYNC) SyncTargets are not allowed to start mediators! Aborting!", (Object)this.tag);
                    this.mediatorStarted = false;
                    return false;
                }
                if (state2 != null || !this.isStarted()) {
                    state.dispose();
                    state = state2;
                }
                if (state != null) {
                    this.jumpToState(state);
                }
            } else {
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#processSyncTransition] [%1] (SYNC) TargetState (STATEID#%2) is already in ActiveStateStack. Transition not flagged as reinit. Nothing to do!", (Object)this.tag, (long)state.getStateID());
                this.internalEvent = -1;
            }
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#processSyncTransition] [%1] (SYNC) transition processed.", (Object)this.tag);
            return true;
        }
        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(10000000, "[AbstractStateMachine#processSyncTransition] [%1] (SYNC) transition not processed, targetState is null (condition not fullfilled).", (Object)this.tag);
        return false;
    }

    public void setJumpBackPoint(int n) {
        for (int i2 = this.activeStates - 1; i2 >= 0; --i2) {
            State state = this.activeStateStack[i2];
            SMModule sMModule = this.data.getSMM4ID(state.getStateID());
            sMModule.setJumpBackPoint(state.getStateID(), n);
        }
    }

    private boolean isStateActive(State state) {
        for (int i2 = this.activeStates - 1; i2 >= 0; --i2) {
            State state2 = this.activeStateStack[i2];
            if (state2 != state) continue;
            return true;
        }
        return false;
    }

    private String getInternalEventDescription(int n) {
        switch (n) {
            case -1: {
                return "EVENT_UNDEFINED";
            }
            case 2: {
                return "EVENT_COMPLETION";
            }
            case 1: {
                return "EVENT_ENTER";
            }
            case 3: {
                return "EVENT_EXTSTATE_UNBOUND";
            }
            case 4: {
                return "EVENT_INCLUDE_JUMP";
            }
        }
        return Integer.toString(n);
    }

    public void addContext(long l) {
        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000000, "[AbstractStateMachine#addContext] [%1] context '%2' added.", (Object)this.tag, l);
        if (this.contexts.contains(l)) {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(100000, "[AbstractStateMachine#addContext] [%1] context '%2' already added.", (Object)this.tag, l);
        } else {
            this.contexts.add(l);
        }
    }

    public void removeContext(long l) {
        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000000, "[AbstractStateMachine#removeContext] [%1] context '%2' removed.", (Object)this.tag, l);
        if (this.contexts.contains(l)) {
            this.contexts.removeElement(l);
        } else {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000000, "[AbstractStateMachine#removeContext] [%1] context '%2' was not added", (Object)this.tag, l);
        }
    }

    protected long[] getContexts() {
        return this.contexts.toArray();
    }

    public void pushDrawerIDs(long l, long l2) {
        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000000, "[AbstractStateMachine#pushDrawerIDs] selectionDrawer='%1', optionDrawer='%2', currentCount='%3'", l, l2, (long)this.drawerCount);
        if (this.drawerCount < 20) {
            if (l == -1L) {
                l = this.drawerCount > 0 ? this.drawerStack[this.drawerCount - 1].getSelectionDrawerID() : 0L;
            }
            if (l2 == -1L) {
                l2 = this.drawerCount > 0 ? this.drawerStack[this.drawerCount - 1].getOptionsDrawerID() : 0L;
            }
            this.drawerStack[this.drawerCount++] = new DrawerIDSet(l, l2);
        } else {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000, "[AbstractStateMachine#pushDrawerIDs] max size '%1' of stack reached!", 20L);
            for (int i2 = 0; i2 < 20; ++i2) {
                this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000, "[AbstractStateMachine#pushDrawerIDs] position %2: %1", (Object)(this.drawerStack[i2] != null ? this.drawerStack[i2].toString() : "null"), (long)i2);
            }
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000, "[AbstractStateMachine#pushDrawerIDs] selectionDrawer='%1', optionDrawer='%2', currentCount='%3'", l, l2, (long)this.drawerCount);
        }
    }

    public void popDrawerIDs() {
        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000000, "[AbstractStateMachine#popDrawerIDs] called, currentCount='%1'", (long)this.drawerCount);
        if (this.drawerCount > 0) {
            this.drawerStack[--this.drawerCount] = null;
        } else {
            this.logger.sm[this.data.terminalID][this.data.subterminalID].log(100000, "[AbstractStateMachine#popDrawerIDs] stack already empty!");
        }
    }

    public void setColor(int n) {
        this.currentColorSet = n;
    }

    protected int getColor() {
        return this.currentColorSet;
    }

    public void setScreenMode(int n) {
        this.screenMode = n;
    }

    protected int getScreenMode() {
        return this.screenMode;
    }

    protected DrawerIDSet getDrawerIDs() {
        if (this.drawerCount > 0) {
            return this.drawerStack[this.drawerCount - 1];
        }
        return null;
    }

    public State getCurrentTopState() {
        if (this.activeStates > 0) {
            return this.activeStateStack[this.activeStates - 1];
        }
        return null;
    }

    public void addScreenAnimation(int n) {
        this.logger.sm[this.data.terminalID][this.data.subterminalID].log(1000000, "[AbstractStateMachine#addScreenAnimation] called, current='%1', added='%2'", (long)this.screenAnimations, (long)n);
        this.screenAnimations |= n;
    }

    public void resetScreenAnimations() {
        this.screenAnimations = 0;
    }

    public int getScreenAnimations() {
        return this.screenAnimations;
    }

    public AbstractUIService getUIService() {
        return this.uiService;
    }
}

