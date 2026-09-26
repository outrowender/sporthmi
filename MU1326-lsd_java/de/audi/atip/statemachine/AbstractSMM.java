/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.ActionProxy;
import de.audi.atip.statemachine.EventMediator;
import de.audi.atip.statemachine.MediatorManager;
import de.audi.atip.statemachine.MediatorRegistry;
import de.audi.atip.statemachine.Popup;
import de.audi.atip.statemachine.SMModule;
import de.audi.atip.statemachine.SMServices;
import de.audi.atip.statemachine.SMSyncTarget;
import de.audi.atip.statemachine.State;
import de.audi.atip.statemachine.SyncTargetManager;
import de.audi.atip.statemachine.SyncTargetProcessor;
import de.audi.atip.statemachine.Transition;
import de.audi.atip.statemachine.mediator.JumpBackMediator;
import de.audi.atip.statemachine.sds.ITTSASRContext;
import de.audi.atip.statemachine.sds.TTSASR;
import de.esolutions.fw.util.commons.Buffer;
import java.util.HashMap;
import java.util.NoSuchElementException;

public abstract class AbstractSMM
implements SMModule,
MediatorManager,
SyncTargetManager {
    private final IFrameworkAccess framework;
    protected static final int INVALID_TLS;
    protected static final int INVALID_ID;
    protected static final int INIT_ERROR;
    protected static final int INIT_INFO;
    protected static final int BINDING_ERROR;
    protected static final int BINDING_INFO;
    protected static final int HISTORY_INFO;
    protected static final int ACTION_PROXY_MISSING;
    protected static final int EXEC_ACTION_ERROR;
    protected static final int EXEC_ACTION_INFO;
    protected static final int CHECK_GUARD_ERROR;
    protected static final int CHECK_GUARD_INFO;
    protected static final int CHECK_GUARD_MODEL_MISSING;
    protected static final boolean DEBUG_MODE;
    protected static final int[] EMPTY_INT_LIST;
    protected static final String[] EMPTY_STRING_LIST;
    protected static final EventMediator[] EMPTY_MEDIATOR_LIST;
    protected HMIService hmiService;
    protected MediatorRegistry mediatorRegistry;
    protected SyncTargetProcessor syncTargetProcessor;
    protected int moduleID;
    protected final String smmName;
    protected final int terminalID;
    protected final int subterminalID;
    protected final String terminalName;
    protected LogChannel logChannel;
    protected LogChannel eventLogChannel;
    protected LogChannel smLogChannel;
    protected int[] popupIDList;
    protected int[] popupPriorityList;
    protected int[] popupTopLevelStateIDList;
    protected int[] popupZPMPriorityList;
    protected int[] popupZPMSlotList;
    protected int topLevelStateID = -1;
    protected int[] extStateIDList;
    protected String[] extStateLabelList;
    private int[] reqExtStateIDList;
    protected String[] reqExtStateLabelList;
    protected int[] incSlotList;
    protected int[] incSlotStateIDList;
    protected int[] stateSuperstateList;
    protected int[] stateDHSList;
    private int[] stateHistoryList;
    protected int[] stateFlagList;
    protected int[][] stateTriggerEventList;
    protected int[][] stateOutTransList;
    protected int[][] stateMediatorList;
    protected int[][] stateSyncTriggerList;
    protected int[][] stateSyncExitTriggerList;
    protected int[][] stateSyncTargetList;
    protected int[] transFlagList;
    protected int[][] transTrgtStateList;
    protected int[][] transTrgtFlagList;
    protected HashMap transIncludeJumpEvents;
    protected EventMediator[] mediatorList;
    protected SMSyncTarget[] syncTargetList;

    public AbstractSMM(IFrameworkAccess iFrameworkAccess, int n, String string, int n2, int n3, String string2) {
        int n4;
        int n5;
        this.framework = iFrameworkAccess;
        this.terminalID = n;
        this.terminalName = string;
        this.subterminalID = n2;
        this.moduleID = n3;
        this.smmName = string2;
        this.logChannel = this.getFramework().getLogChannel(new Buffer(50).append("SM.sm-").append(n).append('-').append(string).append(n3 < 10 ? ".smm-0" : ".smm-").append(n3).append('-').append(this.smmName).toString());
        this.eventLogChannel = this.getFramework().getLogChannel("Fw.ATIPEvent");
        this.smLogChannel = this.getFramework().getLogChannel(new Buffer(50).append("SM.sm-").append(n).append('-').append(n2).append('-').append(this.getTerminalName()).toString());
        this.init();
        if (this.extStateIDList == null) {
            this.extStateIDList = EMPTY_INT_LIST;
        }
        if (this.extStateLabelList == null) {
            this.extStateLabelList = EMPTY_STRING_LIST;
        }
        if (this.reqExtStateLabelList == null) {
            this.reqExtStateLabelList = EMPTY_STRING_LIST;
        }
        if (this.incSlotList == null) {
            this.incSlotList = EMPTY_INT_LIST;
        }
        if (this.incSlotStateIDList == null) {
            this.incSlotStateIDList = EMPTY_INT_LIST;
        }
        if (this.stateMediatorList == null) {
            this.stateMediatorList = new int[this.stateSuperstateList.length][];
        }
        if (this.mediatorList == null) {
            this.mediatorList = EMPTY_MEDIATOR_LIST;
        }
        this.reqExtStateIDList = (n5 = this.reqExtStateLabelList.length) == 0 ? EMPTY_INT_LIST : new int[n5];
        for (n4 = 0; n4 < n5; ++n4) {
            this.reqExtStateIDList[n4] = -10;
        }
        n4 = this.stateDHSList.length;
        this.stateHistoryList = new int[n4];
        for (int i2 = 0; i2 < n4; ++i2) {
            this.stateHistoryList[i2] = this.hasHistory(i2) ? this.stateDHSList[i2] : -1;
        }
        if (this.stateFlagList.length <= this.id2ArrayIdx(this.topLevelStateID)) {
            this.logChannel.log(1000, "SMM has no valid top-level state!");
            throw new IllegalStateException(new StringBuffer().append("SMM-").append(n3).append(" ").append(this.smmName).append(" has no valid top-level state!").toString());
        }
        this.hmiService = this.getFramework().getHMIService();
    }

    @Override
    public IFrameworkAccess getFramework() {
        return this.framework;
    }

    protected abstract void init() {
    }

    @Override
    public ActionProxy addActionProxy(int n, ActionProxy actionProxy) {
        return null;
    }

    @Override
    public void removeActionProxy(int n, ActionProxy actionProxy) {
    }

    @Override
    public void setMediatorRegistry(MediatorRegistry mediatorRegistry) {
        if (mediatorRegistry != null) {
            this.mediatorRegistry = mediatorRegistry;
            this.logChannel.log(-2137614336, "[AbstractSMM#setMediatorRegistry] [%1] Mediator registry set.", (Object)this.terminalName);
        } else {
            this.logChannel.log(-2137614336, "[AbstractSMM#setMediatorRegistry] [%1] deinitialzing - killing all mediators", (Object)this.terminalName);
            if (this.mediatorList != null) {
                for (int i2 = 0; i2 < this.mediatorList.length; ++i2) {
                    EventMediator eventMediator = this.mediatorList[i2];
                    if (eventMediator == null) continue;
                    eventMediator.kill();
                }
            }
            this.mediatorRegistry = mediatorRegistry;
            this.logChannel.log(-2137614336, "[AbstractSMM#setMediatorRegistry] [%1] Mediator registry removed.", (Object)this.terminalName);
        }
    }

    @Override
    public void setSyncTargetProcessor(SyncTargetProcessor syncTargetProcessor) {
        this.syncTargetProcessor = syncTargetProcessor;
        if (syncTargetProcessor != null) {
            this.logChannel.log(-2137614336, "[AbstractSMM#setSyncTargetProcessor] [%1] SyncTarget processor set.", (Object)this.terminalName);
        } else {
            this.logChannel.log(-2137614336, "[AbstractSMM#setSyncTargetProcessor] [%1] SyncTarget processor removed.", (Object)this.terminalName);
        }
    }

    @Override
    public int getTerminalID() {
        return this.terminalID;
    }

    @Override
    public final String getTerminalName() {
        return this.terminalName;
    }

    @Override
    public int getSubterminalID() {
        return this.subterminalID;
    }

    @Override
    public int getModuleID() {
        return this.moduleID;
    }

    @Override
    public String getSMMName() {
        return this.smmName;
    }

    @Override
    public void registerExternalState(String string, int n) {
        for (int i2 = 0; i2 < this.reqExtStateLabelList.length; ++i2) {
            if (!string.equals(this.reqExtStateLabelList[i2])) continue;
            this.reqExtStateIDList[i2] = n;
            this.logChannel.log(1078071040, "[AbstractSMM#registerExternalState] [%1] required External State (idx %3) '%2' bound.", (Object)this.terminalName, (Object)this.reqExtStateLabelList[i2], (long)i2);
            break;
        }
    }

    @Override
    public void deregisterExternalState(String string) {
        for (int i2 = 0; i2 < this.reqExtStateLabelList.length; ++i2) {
            if (!string.equals(this.reqExtStateLabelList[i2])) continue;
            this.reqExtStateIDList[i2] = -10;
            this.logChannel.log(1078071040, "[AbstractSMM#deregisterExternalState] [%1] required External State (idx %3) '%2' unbound.", (Object)this.terminalName, (Object)this.reqExtStateLabelList[i2], (long)i2);
            break;
        }
    }

    @Override
    public boolean bindIncludeState(int n, int n2) {
        if (!this.responsibleFor(n)) {
            this.logChannel.log(10000, "[AbstractSMM#bindIncludeState] [%4] SMM-%2 %1 not responsible for state (STATEID#%3).", (Object)this.smmName, (Object)Integer.toString(this.moduleID), (Object)Integer.toString(n), (Object)this.terminalName);
            return false;
        }
        int n3 = this.id2ArrayIdx(n);
        if (!this.isInclude(n3)) {
            this.logChannel.log(1078071040, "[AbstractSMM#bindIncludeState] [%1] state (STATEID#%2) is no include state.", (Object)this.terminalName, (long)n);
            return false;
        }
        boolean bl = false;
        if (this.stateSuperstateList[n3] != n2) {
            this.stateSuperstateList[n3] = n2;
            int[] nArray = this.getTriggerEventList(n3);
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                if (nArray[i2] != 2) continue;
                int[] nArray2 = this.getOutTransList(n3);
                int n4 = nArray2[i2];
                int n5 = this.id2ArrayIdx(n4);
                this.transTrgtStateList[n5][0] = n2;
                break;
            }
            bl = true;
            this.logChannel.log(1078071040, "[AbstractSMM#bindIncludeState] [%1] include state (STATEID#%2) bound to slot (STATEID#%3).", (Object)this.terminalName, (long)n, (long)n2);
        } else {
            this.logChannel.log(1078071040, "[AbstractSMM#bindIncludeState] [%1] include state (STATEID#%2) was already bound to slot (STATEID#%3).", (Object)this.terminalName, (long)n, (long)n2);
        }
        return bl;
    }

    @Override
    public void resetJumpBackPoint(int n, int n2) {
        this.logChannel.log(1078071040, "[AbstractSMM#resetJumpBackPoint] [%1] reset transition (TRANSID#%2) back to state (STATEID#%3).", (Object)this.terminalName, (long)n, (long)n2);
        int n3 = this.id2ArrayIdx(n);
        this.transTrgtStateList[n3][0] = n2;
    }

    @Override
    public void setJumpBackPoint(int n, int n2) {
        this.logChannel.log(1078071040, "[AbstractSMM#setJumpBackPoint] [%1] called for stateID (STATEID#%2), jumpPointStateID (STATEID#%3).", (Object)this.terminalName, (long)n, (long)n2);
        if (!this.responsibleFor(n)) {
            this.logChannel.log(10000, "[AbstractSMM#setJumpBackPoint] [%1] SMM-%3 module '%2' not responsible for state (STATEID#%4)", (Object)this.terminalName, (Object)this.smmName, (Object)Integer.toString(this.moduleID), (Object)Integer.toString(n));
            return;
        }
        int n3 = this.id2ArrayIdx(n);
        int[] nArray = this.getMediatorIDList(n3);
        if (nArray.length > 0) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                EventMediator eventMediator = this.getEventMediator(nArray[i2]);
                if (eventMediator.getType() != 7) continue;
                int n4 = ((JumpBackMediator)eventMediator).getEventId();
                int[] nArray2 = this.getTriggerEventList(n3);
                for (int i3 = 0; i3 < nArray2.length; ++i3) {
                    if (nArray2[i3] != n4) continue;
                    int[] nArray3 = this.getOutTransList(n3);
                    int n5 = nArray3[i3];
                    int n6 = this.id2ArrayIdx(n5);
                    this.transTrgtStateList[n6][0] = n2;
                    if (!this.logChannel.isInfo()) continue;
                    this.logChannel.log(1078071040, "[AbstractSMM#setJumpBackPoint] [%1] set target transition (TRANSID#%4) of JumpBack-mediator at state (STATEID#%2) to state (STATEID#%3).", (Object)this.terminalName, (Object)Integer.toString(n), (Object)Integer.toString(n2), (Object)Integer.toString(n5));
                    this.logChannel.log(1078071040, "[AbstractSMM#setJumpBackPoint] [%1] EventID is (EVENTID#%2).", (Object)this.terminalName, (long)n4);
                }
            }
        }
    }

    @Override
    public int getTopLevelState() {
        return this.topLevelStateID;
    }

    @Override
    public Popup getPopup(int n) {
        for (int i2 = 0; i2 < this.popupIDList.length; ++i2) {
            if (n != this.popupIDList[i2]) continue;
            return Popup.newPopup(n, this.popupPriorityList[i2], this.popupTopLevelStateIDList[i2], this.popupZPMPriorityList != null ? this.popupZPMPriorityList[i2] : -1, this.popupZPMSlotList != null ? this.popupZPMSlotList[i2] : -1);
        }
        return null;
    }

    @Override
    public int externalStates() {
        return this.extStateLabelList.length;
    }

    @Override
    public String getExternalStateLabel(int n) {
        if (n > this.extStateLabelList.length) {
            return null;
        }
        return this.extStateLabelList[n];
    }

    @Override
    public int getExternalStateID(int n) {
        if (n > this.extStateIDList.length) {
            return -1;
        }
        return this.extStateIDList[n];
    }

    @Override
    public State getState(int n) {
        if (!this.responsibleFor(n)) {
            return null;
        }
        int n2 = this.id2ArrayIdx(n);
        if (n2 >= this.stateFlagList.length) {
            return null;
        }
        if (this.isIncludeSlot(n2)) {
            return State.newIncludeSlot(n, this.getSuperstateID(n2), this.getStateFlags(n2), this.getTriggerEventList(n2), this.getOutTransList(n2), this.getIncludeStateID(n), this.getSyncTriggerEventList(n2), this.getSyncExitTriggerEventList(n2), this.getSyncTargetIDList(n2));
        }
        if (this.isComposite(n2)) {
            return State.newCompositeState(n, this.getSuperstateID(n2), this.getStateFlags(n2), this.getTriggerEventList(n2), this.getOutTransList(n2), this.getMediatorIDList(n2), this.getSyncTriggerEventList(n2), this.getSyncExitTriggerEventList(n2), this.getSyncTargetIDList(n2));
        }
        return State.newSimpleState(n, this.getSuperstateID(n2), this.getStateFlags(n2), this.getScreenID(n2), this.getTriggerEventList(n2), this.getOutTransList(n2), this.getMediatorIDList(n2), this.getSyncTriggerEventList(n2), this.getSyncExitTriggerEventList(n2), this.getSyncTargetIDList(n2));
    }

    @Override
    public int getHistory(int n) {
        if (!this.responsibleFor(n)) {
            return -1;
        }
        int n2 = this.id2ArrayIdx(n);
        if (n2 >= this.stateFlagList.length) {
            return -1;
        }
        if (!this.hasHistory(n2)) {
            return -1;
        }
        return this.stateHistoryList[n2];
    }

    @Override
    public void setHistory(int n, int n2) {
        if (!this.responsibleFor(n)) {
            return;
        }
        int n3 = this.id2ArrayIdx(n);
        if (n3 >= this.stateFlagList.length) {
            return;
        }
        if (!this.hasHistory(n3)) {
            return;
        }
        this.stateHistoryList[n3] = n2;
        this.logChannel.log(-2137614336, "[AbstractSMM#setHistory] [%1] history of state (STATEID#%2) set to (STATEID#%3).", (Object)this.terminalName, (long)n, (long)n2);
    }

    @Override
    public void resetHistory(int n) {
        if (!this.responsibleFor(n)) {
            return;
        }
        int n2 = this.id2ArrayIdx(n);
        if (n2 >= this.stateFlagList.length) {
            return;
        }
        if (!this.hasHistory(n2)) {
            return;
        }
        this.stateHistoryList[n2] = this.stateDHSList[n2];
        this.logChannel.log(-2137614336, "[AbstractSMM#resetHistory] [%1] history of state (STATEID#%2) reset to (STATEID#%3).", (Object)this.terminalName, (long)n, (long)this.stateDHSList[n2]);
    }

    @Override
    public Transition getTransition(int n) {
        if (!this.responsibleFor(n)) {
            return null;
        }
        int n2 = this.id2ArrayIdx(n);
        if (n2 >= this.transFlagList.length) {
            return null;
        }
        return Transition.newTransition(n, this.getTransFlags(n2), this.getTrgtStates(n2), this.getTrgtExtStateLabels(n2), this.getTrgtStateFlagList(n2));
    }

    @Override
    public EventMediator getEventMediator(int n) {
        int n2 = this.id2ArrayIdx(n);
        if (n2 >= this.mediatorList.length) {
            return null;
        }
        return this.mediatorList[this.id2ArrayIdx(n)];
    }

    @Override
    public SMSyncTarget getSyncTarget(int n) {
        int n2 = this.id2ArrayIdx(n);
        if (n2 >= this.syncTargetList.length) {
            return null;
        }
        return this.syncTargetList[this.id2ArrayIdx(n)];
    }

    @Override
    public int getTransIncludeJumpEvent(int n) {
        if (!this.responsibleFor(n)) {
            return -1;
        }
        if (this.transIncludeJumpEvents == null) {
            return -1;
        }
        int n2 = this.id2ArrayIdx(n);
        Integer n3 = (Integer)this.transIncludeJumpEvents.get(new Integer(n2));
        if (n3 == null) {
            return -1;
        }
        return n3;
    }

    private int getSuperstateID(int n) {
        return this.stateSuperstateList[n];
    }

    private int getStateFlags(int n) {
        return this.stateFlagList[n];
    }

    private boolean isComposite(int n) {
        return (this.stateFlagList[n] & 1) == 1;
    }

    private boolean isInclude(int n) {
        return (this.stateFlagList[n] & 0x101) == 257;
    }

    private boolean isIncludeSlot(int n) {
        return (this.stateFlagList[n] & 0x251) == 593;
    }

    private int getIncludeStateID(int n) {
        int n2 = -1;
        for (int i2 = 0; i2 < this.incSlotList.length; ++i2) {
            if (n != this.incSlotList[i2]) continue;
            n2 = this.incSlotStateIDList[i2];
            if (n2 >= 0) break;
            n2 = this.reqExtStateIDList[-n2];
            break;
        }
        return n2;
    }

    private int getScreenID(int n) {
        return this.stateDHSList[n];
    }

    private int[] getTriggerEventList(int n) {
        int[] nArray = this.stateTriggerEventList[n];
        if (nArray == null) {
            return EMPTY_INT_LIST;
        }
        return nArray;
    }

    private int[] getOutTransList(int n) {
        int[] nArray = this.stateOutTransList[n];
        if (nArray == null) {
            return EMPTY_INT_LIST;
        }
        return nArray;
    }

    private int[] getSyncTriggerEventList(int n) {
        if (this.stateSyncTriggerList == null) {
            return EMPTY_INT_LIST;
        }
        int[] nArray = this.stateSyncTriggerList[n];
        if (nArray == null) {
            return EMPTY_INT_LIST;
        }
        return nArray;
    }

    private int[] getSyncExitTriggerEventList(int n) {
        if (this.stateSyncExitTriggerList == null) {
            return EMPTY_INT_LIST;
        }
        int[] nArray = this.stateSyncExitTriggerList[n];
        if (nArray == null) {
            return EMPTY_INT_LIST;
        }
        return nArray;
    }

    private int[] getSyncTargetIDList(int n) {
        if (this.stateSyncTargetList == null) {
            return EMPTY_INT_LIST;
        }
        int[] nArray = this.stateSyncTargetList[n];
        if (nArray == null) {
            return EMPTY_INT_LIST;
        }
        return nArray;
    }

    private boolean hasHistory(int n) {
        return (this.stateFlagList[n] & 0x10) == 16;
    }

    private boolean hasMediator(int n) {
        return (this.stateFlagList[n] & 8) == 8;
    }

    private int[] getMediatorIDList(int n) {
        if (!this.hasMediator(n)) {
            return EMPTY_INT_LIST;
        }
        int[] nArray = this.stateMediatorList[n];
        if (nArray == null) {
            return EMPTY_INT_LIST;
        }
        return nArray;
    }

    private int getTransFlags(int n) {
        return this.transFlagList[n];
    }

    private boolean isIMTrans(int n) {
        return (this.transFlagList[n] & 1) == 1;
    }

    private int[] getTrgtStates(int n) {
        int[] nArray = this.transTrgtStateList[n];
        if (nArray == null) {
            nArray = EMPTY_INT_LIST;
        }
        if (this.isIMTrans(n)) {
            int[] nArray2 = new int[nArray.length];
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                int n2 = nArray[i2];
                nArray2[i2] = n2 < 0 ? this.reqExtStateIDList[-n2] : n2;
            }
            return nArray2;
        }
        return nArray;
    }

    private String[] getTrgtExtStateLabels(int n) {
        if (this.isIMTrans(n)) {
            int[] nArray = this.transTrgtStateList[n];
            if (nArray == null) {
                return EMPTY_STRING_LIST;
            }
            String[] stringArray = new String[nArray.length];
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                int n2 = nArray[i2];
                stringArray[i2] = n2 < 0 ? this.reqExtStateLabelList[-n2] : null;
            }
            return stringArray;
        }
        return EMPTY_STRING_LIST;
    }

    private int[] getTrgtStateFlagList(int n) {
        int[] nArray = this.transTrgtFlagList[n];
        if (nArray == null) {
            return EMPTY_INT_LIST;
        }
        return nArray;
    }

    protected final int id2ArrayIdx(int n) {
        return n - this.moduleID * -1601830656;
    }

    protected boolean responsibleFor(int n) {
        return n / -1601830656 == this.moduleID;
    }

    @Override
    public void lockScreen() {
        this.hmiService.lockCurrentScreen(this.terminalID, true);
    }

    @Override
    public void unlockScreen() {
        this.hmiService.lockCurrentScreen(this.terminalID, false);
    }

    @Override
    public HMIModel getModel(int n) {
        HMIModel hMIModel = this.hmiService.getModel(this.terminalID == 6 ? 0 : this.terminalID, n);
        if (hMIModel == null) {
            throw new NoSuchElementException(new StringBuffer().append("model ").append(n).append(" could not be retrieved").toString());
        }
        return hMIModel;
    }

    @Override
    public LogChannel getLogChannel() {
        return this.logChannel;
    }

    @Override
    public LogChannel getEventLogChannel() {
        return this.eventLogChannel;
    }

    @Override
    public void fireEvent(int n) {
        this.hmiService.fireSMEvent(this.terminalID, n);
    }

    @Override
    public void registerMediator(EventMediator eventMediator, int[] nArray) {
        this.mediatorRegistry.registerMediator(eventMediator, nArray);
    }

    @Override
    public void unregisterMediator(EventMediator eventMediator, int[] nArray) {
        if (this.mediatorRegistry != null) {
            this.mediatorRegistry.unregisterMediator(eventMediator, nArray);
        }
    }

    public boolean processSyncTransition(int n) {
        if (this.syncTargetProcessor != null) {
            return this.syncTargetProcessor.processSyncTransition(n);
        }
        return false;
    }

    @Override
    public boolean checkGuard(SMServices sMServices, int n, int n2) {
        return this.checkGuard(n, n2);
    }

    @Override
    public void execFocusLostAction(SMServices sMServices, int n) {
    }

    @Override
    public void execFocusGainedAction(SMServices sMServices, int n) {
    }

    @Override
    public void execSDForState(TTSASR tTSASR, ITTSASRContext iTTSASRContext, int n) {
    }

    public void setStateFlagList(int[] nArray) {
        this.stateFlagList = nArray;
    }

    public void setStateSuperstateList(int[] nArray) {
        this.stateSuperstateList = nArray;
    }

    public void setStateDHSList(int[] nArray) {
        this.stateDHSList = nArray;
    }

    public void setSyncTargetList(SMSyncTarget[] sMSyncTargetArray) {
        this.syncTargetList = sMSyncTargetArray;
    }

    public void setStateTriggerEventList(int[][] nArray) {
        this.stateTriggerEventList = nArray;
    }

    public void setStateOutTransList(int[][] nArray) {
        this.stateOutTransList = nArray;
    }

    public void setStateMediatorList(int[][] nArray) {
        this.stateMediatorList = nArray;
    }

    public void setStateSyncTriggerList(int[][] nArray) {
        this.stateSyncTriggerList = nArray;
    }

    public void setStateSyncExitTriggerList(int[][] nArray) {
        this.stateSyncExitTriggerList = nArray;
    }

    public void setStateSyncTargetList(int[][] nArray) {
        this.stateSyncTargetList = nArray;
    }

    public void setMediatorList(EventMediator[] eventMediatorArray) {
        this.mediatorList = eventMediatorArray;
    }

    public void setTransFlagList(int[] nArray) {
        this.transFlagList = nArray;
    }

    public void setTransTrgtFlagList(int[][] nArray) {
        this.transTrgtFlagList = nArray;
    }

    public void setTransTrgtStateList(int[][] nArray) {
        this.transTrgtStateList = nArray;
    }

    public void setTransIncludeJumpTransition(HashMap hashMap) {
        this.transIncludeJumpEvents = hashMap;
    }

    static {
        EMPTY_INT_LIST = new int[0];
        EMPTY_STRING_LIST = new String[0];
        EMPTY_MEDIATOR_LIST = new EventMediator[0];
    }
}

