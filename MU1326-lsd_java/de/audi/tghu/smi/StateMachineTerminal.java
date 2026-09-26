/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.smi;

import de.audi.atip.base.IAppSystem;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.model.AdditionalScreenData;
import de.audi.atip.statemachine.ApplicationSMM;
import de.audi.atip.statemachine.EventMediator;
import de.audi.atip.statemachine.MediatorRegistry;
import de.audi.atip.statemachine.SystemSMM;
import de.audi.atip.statemachine.sds.TTSASR;
import de.audi.atip.sysapp.ISysApp;
import de.audi.tghu.smi.ISMPresetHandler;
import de.audi.tghu.smi.Logger;
import de.audi.tghu.smi.NullSMPresetHandler;
import de.audi.tghu.smi.PopupStack;
import de.audi.tghu.smi.PopupStateMachine;
import de.audi.tghu.smi.SDSUIHandler;
import de.audi.tghu.smi.SMI;
import de.audi.tghu.smi.SMPresetHandler;
import de.audi.tghu.smi.StateMachine;
import de.esolutions.fw.util.commons.IntList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StateMachineTerminal
implements MediatorRegistry {
    private final SMI smi;
    private final Logger logger;
    private final int terminalID;
    private final String terminalName;
    private final Map mediatorRegistry = new HashMap();
    private int activeSubterminal = 0;
    private final StateMachine[] smList = new StateMachine[4];
    private final PopupStack popupStack;
    private boolean started = false;
    private boolean unboundEventUnprocessed = false;
    private String unboundExtStateLabel = null;
    private SDSUIHandler uiHandler = null;
    private final ISMPresetHandler presetHandler;

    public StateMachineTerminal(int n, String string, SMI sMI, Logger logger) {
        this.terminalID = n;
        this.terminalName = string;
        this.smi = sMI;
        this.logger = logger;
        this.popupStack = new PopupStack(logger);
        if (n == 6) {
            this.uiHandler = new SDSUIHandler();
        }
        this.presetHandler = n == 0 ? new SMPresetHandler(logger, sMI.getFramework()) : new NullSMPresetHandler();
    }

    protected SDSUIHandler getSDSUIHandler() {
        return this.uiHandler;
    }

    protected ISMPresetHandler getPresetHandler() {
        return this.presetHandler;
    }

    final SMI getSMI() {
        return this.smi;
    }

    final IFrameworkAccess getFramework() {
        return this.getSMI().getFramework();
    }

    public int getTerminalID() {
        return this.terminalID;
    }

    public String getTerminalName() {
        return this.terminalName;
    }

    public boolean isUnboundEventUnprocessed() {
        return this.unboundEventUnprocessed;
    }

    public String getUnboundExtStateLabel() {
        return this.unboundExtStateLabel;
    }

    public synchronized boolean addSysSMM(SystemSMM systemSMM) {
        this.logger.smi.log(1078071040, "[StateMachineTerminal#addSysSMM] SMI terminal '%1'", (Object)this.terminalName);
        int n = systemSMM.getSubterminalID();
        StateMachine stateMachine = this.retrieveSM(n);
        boolean bl = stateMachine.addSysSMM(systemSMM);
        if (bl) {
            systemSMM.setMediatorRegistry(this);
            systemSMM.setSyncTargetProcessor(stateMachine);
        }
        return bl;
    }

    /*
     * WARNING - void declaration
     */
    public synchronized boolean removeSysSMM(SystemSMM systemSMM) {
        void var5_6;
        this.logger.smi.log(1078071040, "[StateMachineTerminal#removeSysSMM] SMI terminal '%1'", (Object)this.terminalName);
        int n = systemSMM.getSubterminalID();
        StateMachine stateMachine = this.retrieveSM(n);
        int n2 = this.popupStack.size();
        int bl = n2 - 1;
        while (var5_6 >= 0) {
            PopupStateMachine popupStateMachine = this.popupStack.get((int)var5_6);
            if (popupStateMachine != null) {
                this.doStopPopup(popupStateMachine.getPopup().getPopupID());
            }
            --var5_6;
        }
        boolean bl2 = stateMachine.removeSysSMM(systemSMM);
        if (bl2) {
            systemSMM.setMediatorRegistry(null);
            systemSMM.setSyncTargetProcessor(null);
        }
        return bl2;
    }

    public synchronized boolean addAppSMM(ApplicationSMM applicationSMM) {
        int n = applicationSMM.getSubterminalID();
        StateMachine stateMachine = this.retrieveSM(n);
        boolean bl = stateMachine.addAppSMM(applicationSMM);
        if (bl) {
            applicationSMM.setMediatorRegistry(this);
            applicationSMM.setSyncTargetProcessor(stateMachine);
        }
        return bl;
    }

    public synchronized boolean removeAppSMM(ApplicationSMM applicationSMM) {
        int n = applicationSMM.getSubterminalID();
        StateMachine stateMachine = this.retrieveSM(n);
        this.logger.smi.log(1078071040, "[StateMachineTerminal#removeAppSMM] SMI terminal '%1' ModuleId: %2)", (Object)this.terminalName, (long)applicationSMM.getModuleID());
        this.stopAllPopupsOfSMM(applicationSMM);
        boolean bl = stateMachine.removeAppSMM(applicationSMM);
        if (bl) {
            applicationSMM.setMediatorRegistry(null);
            applicationSMM.setSyncTargetProcessor(null);
        }
        return bl;
    }

    private StateMachine retrieveSM(int n) {
        if (n >= 4) {
            this.logger.smi.log(1000, "[StateMachineTerminal#retrieveSM] [%1] unsupported Subterminal-ID (%2); Subterminal-ID must be lower than max value (%3).", (Object)this.terminalName, (long)n, (long)0);
            return null;
        }
        StateMachine stateMachine = this.smList[n];
        if (stateMachine == null) {
            stateMachine = new StateMachine(this, n, this.getSMI(), this.logger);
            if (this.terminalID != 1 && this.isSubterminalActive(n)) {
                stateMachine.setKeyboardService(this.getSMI().getKeyboardService(this.terminalID));
            } else {
                stateMachine.setKeyboardService(this.getSMI().getKeyboardService(this.terminalID).getKbdService());
            }
            this.smList[n] = stateMachine;
            this.getFramework().getErrorMgr().registerDumpInfoProvider(stateMachine.getErrorLog());
            if (this.started) {
                stateMachine.start();
            }
        }
        return stateMachine;
    }

    public boolean isInitialised() {
        boolean bl = false;
        StateMachine stateMachine = this.smList[this.activeSubterminal];
        if (stateMachine != null) {
            bl = stateMachine.isInitialised();
        }
        return bl;
    }

    public boolean isStarted() {
        StateMachine stateMachine = this.smList[this.activeSubterminal];
        if (stateMachine != null) {
            return stateMachine.isStarted();
        }
        return false;
    }

    public boolean isSMMregistered(int n, int n2) {
        boolean bl = false;
        StateMachine stateMachine = this.smList[n];
        if (stateMachine != null) {
            bl = stateMachine.data.isSMMregistered(n2);
        }
        return bl;
    }

    protected PopupStack getPopupStack() {
        return this.popupStack;
    }

    public int getActiveSubterminal() {
        return this.activeSubterminal;
    }

    public boolean isSubterminalActive(int n) {
        return n == this.activeSubterminal;
    }

    public StateMachine getActiveSubterminalStateMachine() {
        return this.smList[this.activeSubterminal];
    }

    public synchronized void removeAllSMMs() {
        for (int i2 = 0; i2 < 4; ++i2) {
            StateMachine stateMachine = this.smList[i2];
            if (stateMachine == null) continue;
            stateMachine.removeAllSMMs();
        }
    }

    public boolean isPopupActive() {
        return !this.popupStack.isEmpty();
    }

    public int getActiveScreenState() {
        int n = -1;
        StateMachine stateMachine = this.smList[this.activeSubterminal];
        if (stateMachine != null) {
            n = stateMachine.getActiveScreenState();
        }
        return n;
    }

    public long[] getActiveContexts() {
        StateMachine stateMachine = this.smList[this.activeSubterminal];
        long[] lArray = stateMachine != null ? (long[])stateMachine.getContexts().clone() : new long[]{};
        return lArray;
    }

    public synchronized void setActiveSubterminal(int n) {
        if (this.logger.smi.isDebug2()) {
            this.logger.smi.log(14808325, "[StateMachineTerminal#setActiveSubterminal] called");
        }
        if (n != this.activeSubterminal) {
            StateMachine stateMachine = this.smList[this.activeSubterminal];
            if (this.terminalID == 0 && stateMachine != null) {
                stateMachine.setKeyboardService(stateMachine.getKeyboardService().getKbdService());
            }
            this.activeSubterminal = n;
            stateMachine = this.smList[this.activeSubterminal];
            if (this.terminalID == 0 && stateMachine != null && this.popupStack.isEmpty()) {
                this.getSMI().getKeyboardService(this.terminalID).synchronizeSettings(stateMachine.getKeyboardService());
            }
        }
    }

    private void stopAllPopupsOfSMM(ApplicationSMM applicationSMM) {
        int n;
        this.logger.smi.log(-2137614336, "[StateMachineTerminal#stopAllPopupsOfSMM] TerminalID: '%1' ModuleID: %2", (long)this.terminalID, (long)applicationSMM.getModuleID());
        int n2 = this.popupStack.size();
        IntList intList = new IntList();
        for (n = n2 - 1; n >= 0; --n) {
            PopupStateMachine popupStateMachine = this.popupStack.get(n);
            if (popupStateMachine == null || applicationSMM.getModuleID() != this.getModuleId(popupStateMachine.getPopup().getPopupID())) continue;
            this.logger.smi.log(-2137614336, "[StateMachineTerminal#stopAllPopupsOfSMM] TerminalID: '%1' mark (POPUPID#%2) for removal", (long)this.terminalID, (long)popupStateMachine.getPopup().getPopupID());
            intList.add(popupStateMachine.getPopup().getPopupID());
        }
        for (n = 0; n < intList.size(); ++n) {
            this.doStopPopup(intList.get(n));
        }
        this.logger.smi.log(-2137614336, "[StateMachineTerminal#stopAllPopupsOfSMM] TerminalID: '%1' ModuleID: %2 done", (long)this.terminalID, (long)applicationSMM.getModuleID());
    }

    public synchronized void startPopup(int n) {
        this.logger.event.log(1078071040, "[StateMachineTerminal#startPopup] [%1] SMI terminal received start-popup event (TerminalID: %2), Popup: (POPUPID#%3).", (Object)this.terminalName, (long)this.terminalID, (long)n);
        if (!this.popupStack.contains(n)) {
            StateMachine stateMachine = this.smList[0];
            if (stateMachine == null) {
                this.logger.smi.log(-1601830656, "[StateMachineTerminal#startPopup] [%1] SM-%2-%3 does not exist in System.", (Object)this.terminalName, (long)this.terminalID, 0L);
                return;
            }
            PopupStateMachine popupStateMachine = stateMachine.createPopup(n);
            if (popupStateMachine != null) {
                this.logger.smi.log(1078071040, "[StateMachineTerminal#startPopup] [%1] start popup (POPUPID#%3) of SM-%2.", (Object)this.terminalName, (long)this.terminalID, (long)n);
                this.popupStack.add(this, popupStateMachine);
            } else {
                this.logger.smi.log(1000, "[StateMachineTerminal#startPopup] [%1] popup (POPUPID#%3) of SM-%2 not found.", (Object)this.terminalName, (long)this.terminalID, (long)n);
            }
        }
    }

    public synchronized boolean stopPopup(int n) {
        return this.doStopPopup(n);
    }

    public boolean doStopPopup(int n) {
        this.logger.event.log(1078071040, "[StateMachineTerminal#stopPopup] [%1] SMI terminal received stop-popup event, Popup: (POPUPID#%2).", (Object)this.terminalName, (long)n);
        StateMachine stateMachine = this.smList[0];
        if (stateMachine == null) {
            this.logger.smi.log(-1601830656, "[StateMachineTerminal#stopPopup] [%1] SM-%2.%3 does not exist in System.", (Object)this.terminalName, (long)this.terminalID, 0L);
            return false;
        }
        PopupStateMachine popupStateMachine = this.popupStack.remove(this, n);
        if (popupStateMachine != null) {
            this.logger.smi.log(1078071040, "[StateMachineTerminal#stopPopup] [%1] stopped popup (POPUPID#%3) of SM-%2.", (Object)this.terminalName, (long)this.terminalID, (long)n);
            if (this.terminalID != 6) {
                this.getSMI().removePopupScreen(this.terminalID, popupStateMachine.getPopup(), popupStateMachine.getLastScreen());
            }
            this.getSMI().getFramework().getErrorMgr().unregisterDumpInfoProvider(popupStateMachine.getErrorLog());
            return true;
        }
        return false;
    }

    public synchronized boolean processSMEvent(int n, AdditionalScreenData additionalScreenData) {
        if (this.logger.smi.isDebug2()) {
            this.logger.smi.log(14808325, "[StateMachineTerminal#processSMEvent] [%1] eventID='(EVENTID#%2)', metaInfos='%3'", (Object)this.terminalName, (Object)Integer.toString(n), (Object)additionalScreenData);
        }
        this.logger.event.log(1078071040, "[StateMachineTerminal#processSMEvent] [%1] SMI terminal received state machine event (EVENTID#%2).", (Object)this.terminalName, (long)n);
        this.unboundEventUnprocessed = false;
        this.unboundExtStateLabel = null;
        boolean bl = false;
        if (this.popupStack.isEmpty()) {
            bl |= this.processSMEventBySM(n, additionalScreenData);
        } else if (this.isEventContextSensitive(n)) {
            if (this.logger.smi.isDebug2()) {
                this.logger.smi.log(14808325, "[StateMachineTerminal#processSMEvent] [%1] event is context sensitive", (Object)this.terminalName);
            }
            boolean bl2 = false;
            for (int i2 = 0; i2 < this.popupStack.size(); ++i2) {
                PopupStateMachine popupStateMachine = this.popupStack.get(i2);
                if (popupStateMachine != null) {
                    int n2 = this.smi.getHMIServiceSM().getCurrentPopupID(this.terminalID);
                    if (popupStateMachine.getID() == n2) {
                        bl |= this.processSMEventByPopup(popupStateMachine, n, additionalScreenData);
                        bl2 = true;
                        break;
                    }
                    if (!this.logger.smi.isInfo()) continue;
                    this.logger.smi.log(1078071040, "[StateMachineTerminal#processSMEvent] [%1] SMI assumes Popup %2 is active, but currently (according to HMIService) Popup %3 is visible.", (Object)this.terminalName, (Object)Integer.toString(popupStateMachine.getID()), (Object)Integer.toString(n2));
                    continue;
                }
                this.logger.event.log(1000, "[StateMachineTerminal#processSMEvent] [%1] PopupStateMachine is null!", (Object)this.terminalName);
            }
            if (!bl2) {
                if (this.logger.smi.isInfo()) {
                    this.logger.smi.log(1078071040, "[StateMachineTerminal#processSMEvent] [%1] no valid Popup was found to forward the event to, forwarding it to the main SM", (Object)this.terminalName);
                }
                bl |= this.processSMEventBySM(n, additionalScreenData);
            }
        } else {
            if (this.logger.smi.isDebug2()) {
                this.logger.smi.log(14808325, "[StateMachineTerminal#processSMEvent] event is not context sensistive");
            }
            bl |= this.processSMEventBySM(n, additionalScreenData);
            int n3 = this.popupStack.size();
            for (int i3 = n3 - 1; i3 >= 0; --i3) {
                PopupStateMachine popupStateMachine = this.popupStack.get(i3);
                if (popupStateMachine != null) {
                    bl |= this.processSMEventByPopup(popupStateMachine, n, additionalScreenData);
                    continue;
                }
                this.logger.event.log(1000, "[StateMachineTerminal#processSMEvent] [%1] PopupStateMachine is null at stack-position '%2'!", (Object)this.terminalName, (long)i3);
            }
        }
        if (this.logger.smi.isDebug2()) {
            this.logger.smi.log(14808325, "[StateMachineTerminal#processSMEvent] [%1] event (EVENTID#%2) processed", (Object)this.terminalName, (long)n);
        }
        this.logger.event.log(1078071040, "[StateMachineTerminal#processSMEvent] [%1] SMI terminal processed state machine event (EVENTID#%2).", (Object)this.terminalName, (long)n);
        return bl;
    }

    private boolean processSMEventBySM(int n, AdditionalScreenData additionalScreenData) {
        if (this.logger.smi.isDebug2()) {
            this.logger.smi.log(14808325, "[StateMachineTerminal#processSMEventBySM] [%1] eventID='(EVENTID#%2)'", (Object)this.terminalName, (long)n);
        }
        boolean bl = false;
        StateMachine stateMachine = this.smList[this.activeSubterminal];
        if (stateMachine != null && (this.activeSubterminal != 0 || this.terminalID != 1)) {
            bl |= stateMachine.processSMEvent(n, additionalScreenData);
            this.unboundEventUnprocessed = stateMachine.isUnboundEventUnprocessed();
            this.unboundExtStateLabel = stateMachine.getUnproccessedExtStateLabel();
            if (stateMachine.isStarted()) {
                this.started = true;
            }
        }
        if (!this.isEventSubterminalSensitive(n)) {
            for (int i2 = 0; i2 < 4; ++i2) {
                if (i2 == 0 && this.terminalID == 1 || i2 == this.activeSubterminal || (stateMachine = this.smList[i2]) == null) continue;
                bl |= stateMachine.processSMEvent(n, additionalScreenData);
                if (!stateMachine.isStarted()) continue;
                this.started = true;
            }
        }
        return bl;
    }

    private boolean processSMEventByPopup(PopupStateMachine popupStateMachine, int n, AdditionalScreenData additionalScreenData) {
        if (this.logger.smi.isDebug2()) {
            this.logger.smi.log(14808325, "[StateMachineTerminal#processSMEventByPopup] popup='(POPUPID#%1)', event='(EVENTID#%2)'", (long)popupStateMachine.getID(), (long)n);
        }
        boolean bl = popupStateMachine.processSMEvent(n, additionalScreenData);
        if (!popupStateMachine.isStarted()) {
            this.logger.smi.log(1078071040, "[StateMachineTerminal] event has stopped the Popup-SM (POPUPID#%1), clearing up...", (long)popupStateMachine.getID());
            this.popupStack.remove(this, popupStateMachine.getID());
            this.getSMI().removePopupScreen(this.terminalID, popupStateMachine.getPopup(), popupStateMachine.getLastScreen());
            this.getSMI().getFramework().getErrorMgr().unregisterDumpInfoProvider(popupStateMachine.getErrorLog());
        }
        return bl;
    }

    public synchronized boolean jumpToState(String string) {
        if (this.logger.smi.isDebug2()) {
            this.logger.smi.log(14808325, "[StateMachineTerminal#jumpToState] [%1] stateLabel='%2'", (Object)this.terminalName, (Object)string);
        }
        boolean bl = false;
        StateMachine stateMachine = this.smList[this.activeSubterminal];
        if (stateMachine != null) {
            bl = stateMachine.jumpToState(string);
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public synchronized void processModelUpdate(ModelUpdateEvent modelUpdateEvent) {
        int n = modelUpdateEvent.getModelId();
        this.logger.event.log(1078071040, "[StateMachineTerminal#processModelUpdate] [%1] SMI terminal received model-update event (MODELID#%2).", (Object)this.terminalName, (long)n);
        if (this.logger.smi.isDebug2()) {
            this.logger.smi.log(14808325, "[StateMachineTerminal#processModelUpdate] [%1] (MODELID#%2)", (Object)this.terminalName, (long)n);
        }
        Map map = this.mediatorRegistry;
        synchronized (map) {
            Object object = this.mediatorRegistry.get(new Integer(n));
            if (object == null) {
                return;
            }
            if (object instanceof List) {
                List list = (List)object;
                int n2 = list.size();
                for (int i2 = n2 - 1; i2 >= 0; --i2) {
                    this.logger.event.log(-2137614336, "[StateMachineTerminal#processModelUpdate] [%1] SMI terminal forwards model-update event (MODELID#%2) to mediator.", (Object)this.terminalName, (long)n);
                    try {
                        EventMediator eventMediator = (EventMediator)list.get(i2);
                        eventMediator.processUpdate(modelUpdateEvent);
                        continue;
                    }
                    catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                        this.logger.smi.log(1000, "unexpected IndexOutOfBoundsException (mediatorList.size()=%1 ,mediatorListSize=%2, i=%3)", (long)list.size(), (long)n2, (long)i2);
                    }
                }
            } else {
                this.logger.event.log(-2137614336, "[StateMachineTerminal#processModelUpdate] [%1] SMI terminal forwards model-update event (MODELID#%2) to mediator.", (Object)this.terminalName, (long)n);
                ((EventMediator)object).processUpdate(modelUpdateEvent);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void registerMediator(EventMediator eventMediator, int[] nArray) {
        if (this.logger.smi.isInfo()) {
            this.logger.smi.log(1078071040, "[StateMachineTerminal#registerMediator] mediatorType='%1', models='%2'", (Object)Integer.toString(eventMediator.getType()), (Object)nArray);
        }
        Map map = this.mediatorRegistry;
        synchronized (map) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                List list;
                Integer n = new Integer(nArray[i2]);
                Object object = this.mediatorRegistry.get(n);
                if (object == null) {
                    this.mediatorRegistry.put(n, eventMediator);
                    continue;
                }
                if (object instanceof List) {
                    list = (List)object;
                    if (list.contains(eventMediator)) continue;
                    list.add(eventMediator);
                    continue;
                }
                if (object == eventMediator) continue;
                list = new ArrayList(8);
                list.add(object);
                list.add(eventMediator);
                this.mediatorRegistry.put(n, list);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void unregisterMediator(EventMediator eventMediator, int[] nArray) {
        if (this.logger.smi.isInfo()) {
            this.logger.smi.log(1078071040, "[StateMachineTerminal#unregisterMediator] mediatorType='%1', models='%2'", (Object)Integer.toString(eventMediator.getType()), (Object)nArray);
        }
        Map map = this.mediatorRegistry;
        synchronized (map) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                Integer n = new Integer(nArray[i2]);
                Object object = this.mediatorRegistry.get(n);
                if (object == null) continue;
                if (object instanceof List) {
                    List list = (List)object;
                    list.remove(eventMediator);
                    continue;
                }
                if (object != eventMediator) continue;
                this.mediatorRegistry.remove(n);
            }
        }
    }

    protected synchronized void setSDSService(TTSASR tTSASR) {
        if (this.terminalID == 6) {
            for (int i2 = 0; i2 < this.smList.length; ++i2) {
                if (this.smList[i2] == null) continue;
                this.smList[i2].setSDSService(tTSASR);
            }
        }
    }

    public synchronized void processSyncEvent(int n) {
        int n2;
        this.logger.smi.log(-2137614336, "[StateMachineTerminal.processSyncEvent] [%1] (SYNC) processing SyncEvent (SYNCEVID#%2), forward event to all SMs", (Object)this.terminalName, (long)n, (long)this.terminalID);
        for (n2 = 0; n2 < 4; ++n2) {
            StateMachine stateMachine = this.smList[n2];
            if (stateMachine == null) continue;
            stateMachine.processSyncEvent(n);
        }
        n2 = this.popupStack.size();
        for (int i2 = n2 - 1; i2 >= 0; --i2) {
            PopupStateMachine popupStateMachine = this.popupStack.get(i2);
            if (popupStateMachine == null) continue;
            popupStateMachine.processSyncEvent(n);
            if (popupStateMachine.isStarted()) continue;
            this.popupStack.remove(this, popupStateMachine.getID());
            this.getSMI().removePopupScreen(this.terminalID, popupStateMachine.getPopup(), popupStateMachine.getLastScreen());
            this.getSMI().getFramework().getErrorMgr().unregisterDumpInfoProvider(popupStateMachine.getErrorLog());
        }
    }

    private boolean isEventContextSensitive(int n) {
        IFrameworkAccess iFrameworkAccess = this.getFramework();
        ISysApp iSysApp = iFrameworkAccess != null ? iFrameworkAccess.getSysApp() : null;
        IAppSystem iAppSystem = iSysApp != null ? iSysApp.getVariantAppSystem() : null;
        boolean bl = iAppSystem != null ? iAppSystem.isEventContextSensitive(n) : false;
        return bl;
    }

    private boolean isEventSubterminalSensitive(int n) {
        IFrameworkAccess iFrameworkAccess = this.getFramework();
        ISysApp iSysApp = iFrameworkAccess != null ? iFrameworkAccess.getSysApp() : null;
        IAppSystem iAppSystem = iSysApp != null ? iSysApp.getVariantAppSystem() : null;
        boolean bl = iAppSystem != null ? iAppSystem.isEventSubterminalSensitive(n) : false;
        return bl;
    }

    private final int getModuleId(int n) {
        return n / -1601830656;
    }
}

