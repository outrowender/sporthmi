/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.smi;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.error.FatalSystemError;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.HMIServiceSM;
import de.audi.atip.hmi.KbdService;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.event.RunnableEvent;
import de.audi.atip.hmi.event.StateMachineEvent;
import de.audi.atip.hmi.model.AdditionalScreenData;
import de.audi.atip.hmi.view.ScreenData;
import de.audi.atip.statemachine.ApplicationSMM;
import de.audi.atip.statemachine.Popup;
import de.audi.atip.statemachine.SMInterpreter;
import de.audi.atip.statemachine.SMListener;
import de.audi.atip.statemachine.SMModule;
import de.audi.atip.statemachine.SystemSMM;
import de.audi.atip.statemachine.sds.TTSASR;
import de.audi.tghu.smi.DrawerIDSet;
import de.audi.tghu.smi.Logger;
import de.audi.tghu.smi.SMIOnscreenStatisticsHandler;
import de.audi.tghu.smi.StateMachineTerminal;
import java.util.LinkedList;
import java.util.List;

public class SMI
implements SMInterpreter {
    private static final boolean COMBI_ENABLED = false;
    private final IFrameworkAccess framework;
    private final Logger logger;
    private final HMIServiceSM hmiService;
    private final StateMachineTerminal[] smTerminalList = new StateMachineTerminal[8];
    private final int[] activeSubterminalList = new int[8];
    private final int[] delayedEvent = new int[8];
    private final boolean[] jointUseActive = new boolean[8];
    private int activeJointUseModule = -1;
    private SMListener smListener;
    private List syncEventQueue = new LinkedList();
    private SyncEventQueueElement lastSyncEvent = null;
    private final KbdService[] keyboardServices = new KbdService[8];
    private SMIOnscreenStatisticsHandler onScreenStatisticsHandler;
    private final Object sdsServiceMutex = new Object();
    private volatile TTSASR sdsService;

    public SMI(IFrameworkAccess iFrameworkAccess, KbdService kbdService) {
        int n;
        this.framework = iFrameworkAccess;
        this.hmiService = (HMIServiceSM)((Object)iFrameworkAccess.getHMIService());
        this.logger = new Logger(iFrameworkAccess);
        for (n = 0; n < 8; ++n) {
            this.delayedEvent[n] = -1;
        }
        for (n = 0; n < 4; ++n) {
            this.activeSubterminalList[n] = -1;
        }
        if (!iFrameworkAccess.isFrontMU()) {
            this.keyboardServices[3] = kbdService;
            this.keyboardServices[4] = kbdService;
            this.keyboardServices[5] = kbdService;
        } else {
            this.keyboardServices[0] = kbdService;
        }
        this.keyboardServices[1] = kbdService;
        this.onScreenStatisticsHandler = new SMIOnscreenStatisticsHandler(this, this.logger.smi);
    }

    public final Logger getLogger() {
        return this.logger;
    }

    final IFrameworkAccess getFramework() {
        return this.framework;
    }

    final HMIServiceSM getHMIServiceSM() {
        return this.hmiService;
    }

    protected SMIOnscreenStatisticsHandler getSOSHandler() {
        return this.onScreenStatisticsHandler;
    }

    void criticalError(String string) {
        this.criticalError(string, null);
    }

    void criticalError(String string, Exception exception) {
        this.getFramework().getErrorMgr().handleError(exception, string, 0, 0, 0);
        throw new FatalSystemError(string, exception);
    }

    public KbdService getKeyboardService(int n) {
        return this.keyboardServices[n];
    }

    public void registersSMListener(SMListener sMListener) {
        this.smListener = sMListener;
        if (sMListener != null) {
            for (int i2 = 0; i2 < 8; ++i2) {
                StateMachineTerminal stateMachineTerminal = this.smTerminalList[i2];
                if (stateMachineTerminal == null) continue;
                for (int i3 = 0; i3 < 4; ++i3) {
                    for (int i4 = 0; i4 < 40; ++i4) {
                        if (stateMachineTerminal.isSMMregistered(i3, i4)) {
                            sMListener.smModuleRegistered(i2, i3, i4);
                            continue;
                        }
                        sMListener.smModuleUnregistered(i2, i3, i4);
                    }
                }
            }
        }
    }

    public final boolean hasHMIService() {
        return this.hmiService != null;
    }

    void showScreen(int n, int n2, int n3, int[] nArray, boolean bl, boolean bl2, boolean bl3, int[] nArray2, long[] lArray, DrawerIDSet drawerIDSet, int n4, int n5, int n6, AdditionalScreenData additionalScreenData) {
        ScreenData screenData = drawerIDSet == null ? new ScreenData(n3, bl, bl3, nArray, bl2, null, nArray2, lArray, -1L, -1L, n4, n5, n6, additionalScreenData) : new ScreenData(n3, bl, bl3, nArray, bl2, null, nArray2, lArray, drawerIDSet.getSelectionDrawerID(), drawerIDSet.getOptionsDrawerID(), n4, n5, n6, additionalScreenData);
        if (this.logger.sm[n][n2].isInfo()) {
            this.logger.sm[n][n2].log(1000000, "[SMI#showScreen] calling hmiService.showScreen, screenData='%1', metaInfos='%2'", (Object)((Object)screenData).toString(), (Object)additionalScreenData);
        }
        this.getHMIServiceSM().showScreen(n, n2, screenData);
    }

    void showPopupScreen(int n, Popup popup, int n2, int n3, int[] nArray, boolean bl, boolean bl2, boolean bl3, int[] nArray2, long[] lArray, DrawerIDSet drawerIDSet, int n4, int n5, int n6, AdditionalScreenData additionalScreenData) {
        ScreenData screenData = drawerIDSet == null ? new ScreenData(n3, bl, bl3, nArray, bl2, null, nArray2, popup.getPopupID(), popup.getZpmPriority(), popup.getZpmSlotID(), true, popup.getPriority(), lArray, -1L, -1L, n4, n5, n6, additionalScreenData) : new ScreenData(n3, bl, bl3, nArray, bl2, null, nArray2, popup.getPopupID(), popup.getZpmPriority(), popup.getZpmSlotID(), true, popup.getPriority(), lArray, drawerIDSet.getSelectionDrawerID(), drawerIDSet.getOptionsDrawerID(), n4, n5, n6, additionalScreenData);
        if (n2 < 0) {
            if (this.logger.sm[n][0].isInfo()) {
                this.logger.sm[n][0].log(1000000, "[SMI#showScreen] calling hmiService.showPopupScreen, screenData='%1', metaInfos='%2'", (Object)((Object)screenData).toString(), (Object)additionalScreenData);
            }
            this.getHMIServiceSM().showPopupScreen(n, screenData);
        } else {
            if (this.logger.sm[n][0].isInfo()) {
                this.logger.sm[n][0].log(1000000, "[SMI#showScreen] calling hmiService.replacePopupScreen, screenData='%1', oldScreenID='%2', popupID='%3', metaInfos='%4'", (Object)((Object)screenData).toString(), (Object)Integer.toString(n2), (Object)Integer.toString(popup.getPopupID()), (Object)additionalScreenData);
            }
            this.getHMIServiceSM().replacePopupScreen(n, n2, popup.getPopupID(), screenData);
        }
    }

    void removePopupScreen(int n, Popup popup, int n2) {
        this.getHMIServiceSM().removePopupScreen(n, n2, popup.getPopupID(), true);
    }

    void showPartialPopups(int n, int n2, int[] nArray) {
        this.getHMIServiceSM().showPartialPopups(n, n2, nArray);
    }

    void hidePartialPopups(int n, int n2, int[] nArray) {
        this.getHMIServiceSM().removePartialPopups(n, n2, nArray);
    }

    void showPartialPopupsOnPopup(int n, Popup popup, int n2, int[] nArray) {
        this.getHMIServiceSM().showPartialPopupsForPopup(n, n2, popup.getPopupID(), nArray);
    }

    void hidePartialPopupsOnPopup(int n, Popup popup, int n2, int[] nArray) {
        this.getHMIServiceSM().removePartialPopupsFromPopup(n, n2, popup.getPopupID(), nArray);
    }

    void lockCurrentScreen(int n, int n2, boolean bl) {
        ((HMIService)((Object)this.getHMIServiceSM())).lockCurrentScreen(n, bl);
    }

    void noStateChange(int n) {
        this.getHMIServiceSM().sMActionRequiresNoScreenChange(n);
    }

    void enterJointUse(int n, int n2) {
        switch (n) {
            case 3: 
            case 4: {
                boolean bl = this.activeJointUseModule != n2;
                this.activeJointUseModule = n2;
                this.jointUseActive[n] = true;
                switch (n2) {
                    case 4: {
                        if (this.getJointUseCount() == 1 || !bl) break;
                        break;
                    }
                    case 17: {
                        if (this.getJointUseCount() == 1 || !bl) break;
                        break;
                    }
                }
                this.logger.smi.log(10000000, "[SMI#enterJointUse] for terminal: %1", (long)n);
                break;
            }
        }
    }

    void leaveJointUse(int n, int n2) {
        switch (n) {
            case 3: 
            case 4: {
                this.jointUseActive[n] = false;
                switch (n2) {
                    case 4: {
                        if (this.getJointUseCount() != 0) break;
                        this.activeJointUseModule = -1;
                        break;
                    }
                    case 17: {
                        if (this.getJointUseCount() != 0) break;
                        this.activeJointUseModule = -1;
                        break;
                    }
                }
                this.logger.smi.log(10000000, "[SMI#leaveJointUse] for terminal: %1", (long)n);
                break;
            }
        }
    }

    public void jointModeLeft(int n) {
    }

    int getJointUseCount() {
        int n = 0;
        for (int i2 = 0; i2 < 8; ++i2) {
            if (!this.jointUseActive[i2]) continue;
            ++n;
        }
        return n;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean addSMM(SMModule sMModule) {
        this.logger.smi.log(1000000, "[SMI#addSMM] called");
        if (sMModule == null) {
            return false;
        }
        int n = sMModule.getTerminalID();
        int n2 = sMModule.getSubterminalID();
        StateMachineTerminal stateMachineTerminal = this.retrieveSMTerminal(n, sMModule.getTerminalName());
        if (stateMachineTerminal == null) {
            return false;
        }
        boolean bl = false;
        if (sMModule instanceof SystemSMM) {
            bl = stateMachineTerminal.addSysSMM((SystemSMM)sMModule);
            Object object = this.sdsServiceMutex;
            synchronized (object) {
                if (n == 6) {
                    if (this.sdsService != null) {
                        this.logger.smi.log(1000000, "[SMI#addSMM] setting SDS service to speech terminal");
                        stateMachineTerminal.setSDSService(this.sdsService);
                    } else {
                        this.logger.smi.log(1000000, "[SMI#addSMM] sds service not yet available for speech terminal");
                    }
                }
            }
            if (this.lastSyncEvent != null) {
                this.logger.smi.log(1000000, "[SMI#addSMM] forwarding last syncEvent (SYNCEVID#%1)", (long)this.lastSyncEvent.syncEventID);
                stateMachineTerminal.processSyncEvent(this.lastSyncEvent.syncEventID);
            }
        } else if (sMModule instanceof ApplicationSMM) {
            bl = stateMachineTerminal.addAppSMM((ApplicationSMM)sMModule);
        } else {
            this.logger.sm[n][n2].log(1000, "[SMI#addSMM] SMM %1 (moduleID %2) of unauthorized subclass of SMModule", (Object)sMModule.getSMMName(), (long)sMModule.getModuleID());
            this.logger.sm[n][n2].log(1000000, "[SMI#addSMM] SMM %1 (moduleID %2) ignored", (Object)sMModule.getSMMName(), (long)sMModule.getModuleID());
            return false;
        }
        if (bl) {
            if (stateMachineTerminal.isInitialised() && this.delayedEvent[n] != -1) {
                ((HMIService)((Object)this.getHMIServiceSM())).fireSMEvent(n, this.delayedEvent[n]);
            }
            if (this.smListener != null) {
                this.smListener.smModuleRegistered(n, sMModule.getSubterminalID(), sMModule.getModuleID());
            }
        }
        return bl;
    }

    public boolean removeSMM(SMModule sMModule) {
        if (this.logger.smi.isDebug2()) {
            this.logger.smi.log(100000000, "[SMI#removeSMM] called");
        }
        int n = sMModule.getTerminalID();
        int n2 = sMModule.getSubterminalID();
        StateMachineTerminal stateMachineTerminal = this.getSMTerminal(n);
        if (stateMachineTerminal == null) {
            return true;
        }
        boolean bl = false;
        if (sMModule instanceof SystemSMM) {
            bl = stateMachineTerminal.removeSysSMM((SystemSMM)sMModule);
        } else if (sMModule instanceof ApplicationSMM) {
            bl = stateMachineTerminal.removeAppSMM((ApplicationSMM)sMModule);
        } else {
            this.logger.sm[n][n2].log(1000, "[SMI#removeSMM] SMM %1 (moduleID %2) of unauthorized subclass of SMModule", (Object)sMModule.getSMMName(), (long)sMModule.getModuleID());
            return false;
        }
        if (bl && this.smListener != null) {
            this.smListener.smModuleUnregistered(n, sMModule.getSubterminalID(), sMModule.getModuleID());
        }
        return bl;
    }

    public void removeAllSMMs() {
        if (this.logger.smi.isDebug2()) {
            this.logger.smi.log(100000000, "[SMI#removeAllSMMs] called");
        }
        for (int i2 = 0; i2 < 8; ++i2) {
            StateMachineTerminal stateMachineTerminal = this.getSMTerminal(i2);
            if (stateMachineTerminal == null) continue;
            stateMachineTerminal.removeAllSMMs();
        }
    }

    public void startPopup(int n, int n2) {
        if (this.logger.smi.isDebug2()) {
            this.logger.smi.log(100000000, "[SMI#startPopup] terminalID='%1', popupID='%2'", (long)n, (long)n2);
        }
        this.logger.event.log(1000000, "[SMI#startPopup] SMI received start-popup event, TerminalID='%1', PopupID='(POPUPID#%2)'.", (long)n, (long)n2);
        StateMachineTerminal stateMachineTerminal = this.getSMTerminal(n);
        try {
            if (stateMachineTerminal == null) {
                this.logger.smi.log(100000, "[SMI#startPopup] SM-%1 does not exist in System.", (long)n);
                return;
            }
            stateMachineTerminal.startPopup(n2);
        }
        catch (Exception exception) {
            this.logger.smi.log(1000, "[SMI#startPopup] unexpected exception starting popup, TerminalID='%1', PopupID='(POPUPID#%2)'.", (long)n, (long)n2);
            this.getFramework().getErrorMgr().handleError(exception, "[SMI#startPopup] unexpected exception starting popup.", 0, 3, 0);
            throw new FatalSystemError("[SMI#startPopup] unexpected exception starting popup.", exception);
        }
        this.onScreenStatisticsHandler.updateStatistics();
    }

    public void stopPopup(int n, int n2) {
        if (this.logger.smi.isDebug2()) {
            this.logger.smi.log(100000000, "[SMI#stopPopup] terminalID='%1', popupID='%2'", (long)n, (long)n2);
        }
        this.logger.event.log(1000000, "[SMI#stopPopup] SMI received stop-popup event, TerminalID='%1', PopupID='(POPUPID#%2)'.", (long)n, (long)n2);
        StateMachineTerminal stateMachineTerminal = this.getSMTerminal(n);
        boolean bl = false;
        try {
            StateMachineTerminal stateMachineTerminal2;
            if (stateMachineTerminal == null) {
                this.logger.smi.log(100000, "[SMI#stopPopup] SM-%1 does not exist in System.", (long)n);
                return;
            }
            bl = stateMachineTerminal.stopPopup(n2);
            if (!stateMachineTerminal.isPopupActive() && this.jointUseActive[n] && (stateMachineTerminal2 = this.getSMTerminal(5)) != null) {
                stateMachineTerminal2.getActiveSubterminalStateMachine().reactivateUI();
            }
        }
        catch (Exception exception) {
            this.logger.smi.log(1000, "[SMI#stopPopup] unexpected exception stopping popup, TerminalID='%1', PopupID='(POPUPID#%2)'.", (long)n, (long)n2);
            this.getFramework().getErrorMgr().handleError(exception, "[SMI#stopPopup] unexpected exception stopping popup.", 0, 3, 0);
            throw new FatalSystemError("[SMI#stopPopup] unexpected exception stopping popup.", exception);
        }
        if (bl) {
            this.onScreenStatisticsHandler.updateStatistics();
        }
    }

    public void setActiveSubterminal(int n, int n2) {
        StateMachineTerminal stateMachineTerminal = this.getSMTerminal(n);
        this.logger.smi.log(1000000, "[SMI#setActiveSubterminal] set active subterminal for terminal '%1' to '%2'.", (long)n, (long)n2);
        if (stateMachineTerminal != null) {
            stateMachineTerminal.setActiveSubterminal(n2);
        }
        this.activeSubterminalList[n] = n2;
        this.getHMIServiceSM().setActiveSubterminal(n, n2);
    }

    public int getActiveSubterminal(int n) {
        int n2 = 0;
        StateMachineTerminal stateMachineTerminal = this.getSMTerminal(n);
        if (stateMachineTerminal != null) {
            n2 = stateMachineTerminal.getActiveSubterminal();
        }
        return n2;
    }

    public void processEvent(StateMachineEvent stateMachineEvent) {
        AdditionalScreenData additionalScreenData = stateMachineEvent.getMetaData();
        int n = stateMachineEvent.getStateMachineID();
        int n2 = stateMachineEvent.getSMEventID();
        boolean bl = false;
        if (this.logger.event.isInfo()) {
            this.logger.event.log(1000000, "[SMI#processEvent(StateMachineEvent)] [%1] SMI received state machine event (EVENTID#%2), '%3'.", (Object)Integer.toString(n), (Object)Integer.toString(n2), (Object)stateMachineEvent);
        }
        if (this.logger.smi.isInfo()) {
            this.logger.smi.log(1000000, "[SMI#processEvent(StateMachineEvent)] [%1] SMI received state machine event (EVENTID#%2), '%3'.", (Object)Integer.toString(n), (Object)Integer.toString(n2), (Object)stateMachineEvent);
        }
        if (n == -1) {
            for (int i2 = 0; i2 < 8; ++i2) {
                this.processEvent(i2, n2, additionalScreenData);
            }
        } else {
            this.processEvent(n, n2, additionalScreenData);
        }
        while (!this.syncEventQueue.isEmpty()) {
            SyncEventQueueElement syncEventQueueElement = (SyncEventQueueElement)this.syncEventQueue.remove(0);
            this.logger.smi.log(10000000, "[SMI#processEvent(StateMachineEvent)] (SYNC) SyncEventQueue size is '%1', processing SyncEvent (SYNCEVID#%3) from terminal '%2'.", (long)this.syncEventQueue.size(), (long)syncEventQueueElement.sourceTerminalID, (long)syncEventQueueElement.syncEventID);
            for (int i3 = 0; i3 < 8; ++i3) {
                StateMachineTerminal stateMachineTerminal = this.getSMTerminal(i3);
                if (stateMachineTerminal == null || i3 == syncEventQueueElement.sourceTerminalID) continue;
                stateMachineTerminal.processSyncEvent(syncEventQueueElement.syncEventID);
            }
        }
        if (bl) {
            this.logger.event.log(1000000, "[SMI#processEvent(StateMachineEvent)] [%1] SMI processed state machine event (EVENTID#%2).", (long)n, (long)n2);
        }
        this.onScreenStatisticsHandler.updateStatistics();
    }

    void processSyncEvent(int n, int n2) {
        this.logger.smi.log(10000000, "[SMI#processSyncEvent] putting SyncEvent (SYNCEVID#%1) from Terminal '%2' in SyncEventQueue.", (long)n2, (long)n);
        this.lastSyncEvent = new SyncEventQueueElement(n, n2);
        this.syncEventQueue.add(this.lastSyncEvent);
    }

    private boolean processEvent(int n, int n2, AdditionalScreenData additionalScreenData) {
        if (this.logger.smi.isDebug2()) {
            this.logger.smi.log(100000000, "[SMI#processEvent] terminalID='%1', eventID='(EVENTID#%2)'", (long)n, (long)n2);
        }
        StateMachineTerminal stateMachineTerminal = this.getSMTerminal(n);
        if (n == 1 && !this.framework.isShowDDP2Combi()) {
            return false;
        }
        if (stateMachineTerminal != null) {
            if (!stateMachineTerminal.isPopupActive() && SMI.isEventJointUseSensitive(n2) && this.jointUseActive[n]) {
                boolean bl = false;
                StateMachineTerminal stateMachineTerminal2 = this.getSMTerminal(5);
                if (stateMachineTerminal2 != null) {
                    bl = stateMachineTerminal2.processSMEvent(n2, additionalScreenData);
                    if (stateMachineTerminal2.isUnboundEventUnprocessed()) {
                        this.logger.smi.log(1000000, "[SMI#processEvent(int,int)] unbound event unprocessed");
                        String string = stateMachineTerminal2.getUnboundExtStateLabel();
                        stateMachineTerminal.jumpToState(string);
                    } else {
                        this.logger.smi.log(1000000, "[SMI#processEvent(int,int)] all unbound processed");
                    }
                }
                if (!bl) {
                    stateMachineTerminal.processSMEvent(n2, additionalScreenData);
                }
            } else {
                stateMachineTerminal.processSMEvent(n2, additionalScreenData);
                if (stateMachineTerminal.isUnboundEventUnprocessed() && stateMachineTerminal.getTerminalID() == 5) {
                    this.logger.smi.log(1000000, "[SMI#processEvent(int,int)] unbound event unprocessed");
                    String string = stateMachineTerminal.getUnboundExtStateLabel();
                    StateMachineTerminal stateMachineTerminal3 = this.getFocusedTerminal();
                    if (stateMachineTerminal3 != null) {
                        stateMachineTerminal3.jumpToState(string);
                    }
                } else {
                    this.logger.smi.log(1000000, "[SMI#processEvent(int,int)] all unbound processed");
                }
            }
            return true;
        }
        this.logger.smi.log(100000, "[SMI#processEvent(int,int)] SM-%1 does not exist in System", (long)n);
        this.logger.smi.log(1000000, "[SMI#processEvent(int,int)] event (EVENTID#%1) postponed as responsible state machine is not present", (long)n2);
        this.delayedEvent[n] = n2;
        return false;
    }

    public void processUpdate(ModelUpdateEvent modelUpdateEvent) {
        int n = modelUpdateEvent.getModelType();
        if (n == 100) {
            ModelUpdateEvent[] modelUpdateEventArray = modelUpdateEvent.getNestedEvents();
            if (modelUpdateEventArray != null) {
                int n2 = modelUpdateEventArray.length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    this.processModelUpdate(modelUpdateEventArray[i2]);
                }
            }
        } else {
            this.processModelUpdate(modelUpdateEvent);
        }
    }

    private void processModelUpdate(ModelUpdateEvent modelUpdateEvent) {
        int n = modelUpdateEvent.getTerminalID();
        int n2 = modelUpdateEvent.getModelId();
        this.logger.event.log(1000000, "[SMI#processModelUpdate] SMI received model-update event (MODELID#%1) with terminalID %2", (long)n2, (long)n);
        if (n == -1) {
            for (int i2 = 0; i2 < 8; ++i2) {
                StateMachineTerminal stateMachineTerminal = this.getSMTerminal(i2);
                if (stateMachineTerminal == null) continue;
                stateMachineTerminal.processModelUpdate(modelUpdateEvent);
            }
        } else if (n == 0) {
            StateMachineTerminal stateMachineTerminal = this.getSMTerminal(0);
            if (stateMachineTerminal != null) {
                stateMachineTerminal.processModelUpdate(modelUpdateEvent);
            }
            if ((stateMachineTerminal = this.getSMTerminal(1)) != null) {
                stateMachineTerminal.processModelUpdate(modelUpdateEvent);
            }
            if ((stateMachineTerminal = this.getSMTerminal(6)) != null) {
                stateMachineTerminal.processModelUpdate(modelUpdateEvent);
            }
        } else {
            StateMachineTerminal stateMachineTerminal = this.getSMTerminal(n);
            if (stateMachineTerminal != null) {
                stateMachineTerminal.processModelUpdate(modelUpdateEvent);
            }
        }
    }

    private StateMachineTerminal retrieveSMTerminal(int n, String string) {
        if (n >= this.smTerminalList.length) {
            this.logger.smi.log(1000, "[SMI#retrieveSMTerminal] unsupported Terminal-ID (%1); Terminal-ID must be lower than %2 ", (long)n, (long)this.smTerminalList.length);
            return null;
        }
        StateMachineTerminal stateMachineTerminal = this.smTerminalList[n];
        if (stateMachineTerminal == null) {
            stateMachineTerminal = new StateMachineTerminal(n, string, this, this.logger);
            int n2 = this.activeSubterminalList[n];
            if (n2 != -1) {
                stateMachineTerminal.setActiveSubterminal(n2);
            }
            this.smTerminalList[n] = stateMachineTerminal;
        }
        return stateMachineTerminal;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void setSDSService(TTSASR tTSASR) {
        this.logger.smi.log(1000000, "[SMI#setSDSService] setting sdsService '%1'", (Object)(tTSASR != null ? "available" : "null"));
        Object object = this.sdsServiceMutex;
        synchronized (object) {
            this.sdsService = tTSASR;
            StateMachineTerminal stateMachineTerminal = this.getSMTerminal(6);
            if (stateMachineTerminal == null) {
                this.logger.smi.log(100000, "[SMI#setSDSService] speech terminal still NOT available, waiting for terminal to be started..");
            } else {
                this.logger.smi.log(1000000, "[SMI#setSDSService] speech terminal available, setting SDS service...");
                stateMachineTerminal.setSDSService(this.sdsService);
            }
        }
    }

    public StateMachineTerminal getSMTerminal(int n) {
        if (n >= this.smTerminalList.length) {
            return null;
        }
        return this.smTerminalList[n];
    }

    private final StateMachineTerminal getFocusedTerminal() {
        return this.getSMTerminal(this.getHMIServiceSM().getFocusedTerminal());
    }

    private static boolean isEventJointUseSensitive(int n) {
        switch (n) {
            default: 
        }
        return false;
    }

    public void triggerSMModuleAddition(SMModule sMModule) {
        this.logger.smi.log(1000000, "[SMI#triggerSMModuleAddition] (moduleID=%1)", (long)sMModule.getModuleID());
        this.getFramework().getHMIService().getEventDispatcher().postEvent(new RunnableEvent(true, new AddSMModuleRunnable(sMModule)));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void triggerSMModuleRemoval(SMModule sMModule) {
        this.logger.smi.log(1000000, "[SMI#triggerSMModuleRemoval] Enter method! (moduleID=%1)", (long)sMModule.getModuleID());
        RemoveSMModuleRunnable removeSMModuleRunnable = new RemoveSMModuleRunnable(sMModule);
        this.getFramework().getHMIService().getEventDispatcher().postEvent(new RunnableEvent(true, removeSMModuleRunnable));
        if (this.getFramework().getHMIService().getEventDispatcher().isDispatchThread()) {
            this.logger.smi.log(1000000, "[SMI#triggerSMModuleRemoval] Exit method without waiting! (moduleID=%1)", (long)sMModule.getModuleID());
        } else {
            RemoveSMModuleRunnable removeSMModuleRunnable2 = removeSMModuleRunnable;
            synchronized (removeSMModuleRunnable2) {
                if (!removeSMModuleRunnable.done) {
                    try {
                        removeSMModuleRunnable.wait(5000L);
                    }
                    catch (InterruptedException interruptedException) {
                        Thread.interrupted();
                    }
                }
            }
            this.logger.smi.log(1000000, "[SMI#triggerSMModuleRemoval] Exit method! (moduleID=%1)", (long)sMModule.getModuleID());
        }
    }

    public class AddSMModuleRunnable
    implements Runnable {
        final SMModule stateMachineModule;

        public AddSMModuleRunnable(SMModule sMModule) {
            this.stateMachineModule = sMModule;
        }

        public final void run() {
            if (!SMI.this.addSMM(this.stateMachineModule)) {
                ((SMI)SMI.this).logger.smi.log(10000, "[AddSMModuleRunnable#run] Failed to add state machine module! (moduleID=%1)", (long)this.stateMachineModule.getModuleID());
            }
        }

        public final String toString() {
            return new StringBuffer().append("AddSMModuleRunnable( ").append(this.stateMachineModule.getModuleID()).append(" )").toString();
        }
    }

    class SyncEventQueueElement {
        public int sourceTerminalID;
        public int syncEventID;

        public SyncEventQueueElement(int n, int n2) {
            this.sourceTerminalID = n;
            this.syncEventID = n2;
        }
    }

    public class RemoveSMModuleRunnable
    implements Runnable {
        final SMModule stateMachineModule;
        boolean done = false;

        public RemoveSMModuleRunnable(SMModule sMModule) {
            this.stateMachineModule = sMModule;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public final void run() {
            SMI.this.removeSMM(this.stateMachineModule);
            RemoveSMModuleRunnable removeSMModuleRunnable = this;
            synchronized (removeSMModuleRunnable) {
                this.done = true;
                this.notifyAll();
            }
        }

        public final String toString() {
            return new StringBuffer().append("RemoveSMModuleRunnable( ").append(this.stateMachineModule.getModuleID()).append(" )").toString();
        }
    }
}

