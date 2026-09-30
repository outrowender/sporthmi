/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.smi;

import de.audi.atip.error.FatalSystemError;
import de.audi.atip.statemachine.ApplicationSMM;
import de.audi.atip.statemachine.EventMediator;
import de.audi.atip.statemachine.Popup;
import de.audi.atip.statemachine.SMModule;
import de.audi.atip.statemachine.State;
import de.audi.atip.statemachine.SystemSMM;
import de.audi.atip.statemachine.Transition;
import de.audi.atip.statemachine.sds.TTSASR;
import de.audi.tghu.smi.Logger;
import de.audi.tghu.smi.StateMachineTerminal;
import java.util.HashMap;
import java.util.Map;

class StateMachineData {
    static final int MAX_SMMS = 40;
    private Logger logger;
    private TTSASR sdsService;
    final StateMachineTerminal terminal;
    final int terminalID;
    final int subterminalID;
    private SMModule[] smmList = new SMModule[40];
    private Map label2StateIDMap = new HashMap();
    private boolean initialised = false;

    public StateMachineData(StateMachineTerminal stateMachineTerminal, int n, Logger logger) {
        this.terminal = stateMachineTerminal;
        this.terminalID = stateMachineTerminal.getTerminalID();
        this.subterminalID = n;
        this.logger = logger;
    }

    void criticalError(String string) {
        this.criticalError(string, null);
    }

    void criticalError(String string, Exception exception) {
        this.terminal.getFramework().getErrorMgr().handleError(exception, string, 0, 3, 0);
        throw new FatalSystemError(string, exception);
    }

    public boolean addSysSMM(SystemSMM systemSMM) {
        if (systemSMM == null) {
            return false;
        }
        int n = systemSMM.getModuleID();
        if (n != 0) {
            this.logger.sm[this.terminalID][this.subterminalID].log(1000, "[StateMachineData#addSysSMM] [%1] SysSMM has invalid module ID (%2), ID has to be 0 for SysSMM!", (long)this.terminal.getTerminalID(), (long)n);
            this.criticalError("invalid SysSMM");
            return false;
        }
        try {
            int n2;
            String string;
            int n3;
            int n4;
            if (systemSMM == this.smmList[0]) {
                return true;
            }
            if (this.smmList[0] != null) {
                this.logger.sm[this.terminalID][this.subterminalID].log(10000, "[StateMachineData#addSysSMM] [%1] two System SMMs present!", (long)this.terminal.getTerminalID());
                this.logger.sm[this.terminalID][this.subterminalID].log(1000000, "[StateMachineData#addSysSMM] [%1] second System SMM is ignored.", (long)this.terminal.getTerminalID());
                return false;
            }
            for (n4 = 1; n4 < this.smmList.length; ++n4) {
                int n5;
                ApplicationSMM applicationSMM = (ApplicationSMM)this.smmList[n4];
                if (applicationSMM == null) continue;
                this.logger.sm[this.terminalID][this.subterminalID].log(100000000, "[StateMachineData#addSysSMM] [%1] register application SMM-%3 (moduleID %2) with new System-SMM.", (Object)Integer.toString(this.terminal.getTerminalID()), (Object)applicationSMM.getSMMName(), (Object)Integer.toString(applicationSMM.getModuleID()));
                systemSMM.registerSMM(applicationSMM);
                n3 = applicationSMM.externalStates();
                for (n5 = 0; n5 < n3; ++n5) {
                    string = applicationSMM.getExternalStateLabel(n5);
                    n2 = applicationSMM.getExternalStateID(n5);
                    this.logger.sm[this.terminalID][this.subterminalID].log(100000000, "[StateMachineData#addSysSMM] [%1] register external state (label '%2') of SMM-%4 (moduleID: %2) with System SMM.", (Object)Integer.toString(this.terminal.getTerminalID()), (Object)string, (Object)applicationSMM.getSMMName(), (Object)Integer.toString(applicationSMM.getModuleID()));
                    systemSMM.registerExternalState(string, n2);
                }
                n3 = systemSMM.externalStates();
                for (n5 = 0; n5 < n3; ++n5) {
                    string = systemSMM.getExternalStateLabel(n5);
                    n2 = systemSMM.getExternalStateID(n5);
                    this.logger.sm[this.terminalID][this.subterminalID].log(100000000, "[StateMachineData#addSysSMM] [%1] register external state (label '%2') of System SMM with SMM-%4 (moduleID: %3).", (Object)Integer.toString(this.terminal.getTerminalID()), (Object)string, (Object)applicationSMM.getSMMName(), (Object)Integer.toString(applicationSMM.getModuleID()));
                    applicationSMM.registerExternalState(string, n2);
                }
            }
            n3 = systemSMM.externalStates();
            for (n4 = 0; n4 < n3; ++n4) {
                string = systemSMM.getExternalStateLabel(n4);
                n2 = systemSMM.getExternalStateID(n4);
                this.label2StateIDMap.put(string, new Integer(n2));
            }
            this.smmList[0] = systemSMM;
            this.logger.sm[this.terminalID][this.subterminalID].log(1000000, "[StateMachineData#addSysSMM] [%1] SysSMM registered.", (long)this.terminal.getTerminalID());
            this.initialised = true;
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            this.logger.smi.log(1000, "[StateMachineData#addSysSMM] [%1] invalid access to smmList in method addSysSMM.", (long)this.terminal.getTerminalID(), (Throwable)arrayIndexOutOfBoundsException);
            this.criticalError("critical error during SMI init", arrayIndexOutOfBoundsException);
            return false;
        }
        return true;
    }

    public boolean removeSysSMM(SystemSMM systemSMM) {
        block9: {
            if (systemSMM == null) {
                return true;
            }
            try {
                if (systemSMM == this.smmList[0]) {
                    String string;
                    int n;
                    int n2;
                    this.initialised = false;
                    this.smmList[0] = null;
                    for (n2 = 1; n2 < this.smmList.length; ++n2) {
                        int n3;
                        ApplicationSMM applicationSMM = (ApplicationSMM)this.smmList[n2];
                        if (applicationSMM == null) continue;
                        this.logger.sm[this.terminalID][this.subterminalID].log(100000000, "[StateMachineData#removeSysSMM] [%1] deregister SMM-%2 (moduleID %3) from System SMM.", (Object)Integer.toString(this.terminal.getTerminalID()), (Object)applicationSMM.getSMMName(), (long)applicationSMM.getModuleID());
                        systemSMM.deregisterSMM(applicationSMM);
                        n = applicationSMM.externalStates();
                        for (n3 = 0; n3 < n; ++n3) {
                            string = applicationSMM.getExternalStateLabel(n3);
                            this.logger.sm[this.terminalID][this.subterminalID].log(100000000, "[StateMachineData#removeSysSMM] [%1] deregister external state (label '%2') of SMM-%4 (moduleID: %3) from System SMM.", (Object)Integer.toString(this.terminal.getTerminalID()), (Object)string, (Object)applicationSMM.getSMMName(), (Object)Integer.toString(applicationSMM.getModuleID()));
                            systemSMM.deregisterExternalState(string);
                        }
                        n = systemSMM.externalStates();
                        for (n3 = 0; n3 < n; ++n3) {
                            string = systemSMM.getExternalStateLabel(n3);
                            this.logger.sm[this.terminalID][this.subterminalID].log(100000000, "[StateMachineData#removeSysSMM] [%1] deregister external state (label '%2') of System SMM from SMM-%4 (moduleID: %3)", (Object)Integer.toString(this.terminal.getTerminalID()), (Object)string, (Object)applicationSMM.getSMMName(), (long)applicationSMM.getModuleID());
                            applicationSMM.deregisterExternalState(string);
                        }
                    }
                    n = systemSMM.externalStates();
                    for (n2 = 0; n2 < n; ++n2) {
                        string = systemSMM.getExternalStateLabel(n2);
                        this.label2StateIDMap.remove(string);
                    }
                    break block9;
                }
                if (this.smmList[0] == null) {
                    return true;
                }
                this.logger.sm[this.terminalID][this.subterminalID].log(10000, "[StateMachineData#removeSysSMM] [%1] two System SMMs present.", (long)this.terminal.getTerminalID());
                this.logger.sm[this.terminalID][this.subterminalID].log(1000000, "[StateMachineData#removeSysSMM] [%1] System SMM not removed as present System SMM and System SMM to remove are not the same.", (long)this.terminal.getTerminalID());
                return false;
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                this.logger.smi.log(1000, "[StateMachineData#removeSysSMM] [%1] invalid access to smmList in method removeSysSMM.", (long)this.terminal.getTerminalID(), (Throwable)arrayIndexOutOfBoundsException);
                this.criticalError("critical error during SMI deinit", arrayIndexOutOfBoundsException);
                return false;
            }
        }
        return true;
    }

    public boolean addAppSMM(ApplicationSMM applicationSMM) {
        if (applicationSMM == null) {
            return false;
        }
        int n = applicationSMM.getModuleID();
        this.logger.sm[this.terminalID][this.subterminalID].log(1000000, "[StateMachineData#addAppSMM] [%1] appSMM (%2, Module ID %3) added.", (Object)Integer.toString(this.terminal.getTerminalID()), (Object)applicationSMM.getSMMName(), (long)n);
        if (n == 0) {
            this.logger.sm[this.terminalID][this.subterminalID].log(10000, "[StateMachineData#addAppSMM] [%1] AppSMM %2 returns Module ID 0 (reserved for SysSMM).", (Object)Integer.toString(this.terminal.getTerminalID()), (Object)applicationSMM.getSMMName());
            this.logger.sm[this.terminalID][this.subterminalID].log(1000000, "[StateMachineData#addAppSMM] [%1] AppSMM %2 ignored.", (Object)Integer.toString(this.terminal.getTerminalID()), (Object)applicationSMM.getSMMName());
            return false;
        }
        try {
            int n2;
            String string;
            int n3;
            int n4;
            if (applicationSMM == this.smmList[n]) {
                return true;
            }
            if (this.smmList[n] != null) {
                this.logger.sm[this.terminalID][this.subterminalID].log(10000, "[StateMachineData#addAppSMM] [%1] two AppSMMs (Module ID %2) present.", (long)this.terminal.getTerminalID(), (long)n);
                this.logger.sm[this.terminalID][this.subterminalID].log(1000000, "[StateMachineData#addAppSMM] [%1] second AppSMM (Module ID %2) is ignored.", (long)this.terminal.getTerminalID(), (long)n);
                return false;
            }
            SystemSMM systemSMM = (SystemSMM)this.smmList[0];
            if (systemSMM != null) {
                this.logger.sm[this.terminalID][this.subterminalID].log(100000000, "[StateMachineData#addAppSMM] [%1] register SMM-%3 (Module ID %2) with System SMM.", (Object)Integer.toString(this.terminal.getTerminalID()), (Object)applicationSMM.getSMMName(), (long)applicationSMM.getModuleID());
                systemSMM.registerSMM(applicationSMM);
            }
            for (n4 = 0; n4 < this.smmList.length; ++n4) {
                int n5;
                SMModule sMModule = this.smmList[n4];
                if (sMModule == null) continue;
                n3 = sMModule.externalStates();
                for (n5 = 0; n5 < n3; ++n5) {
                    string = sMModule.getExternalStateLabel(n5);
                    n2 = sMModule.getExternalStateID(n5);
                    this.logger.sm[this.terminalID][this.subterminalID].log(100000000, "[StateMachineData#addAppSMM] [%1] register external state (label '%2') of SMM-%3 with SMM-%4.", (Object)Integer.toString(this.terminal.getTerminalID()), (Object)string, (Object)Integer.toString(sMModule.getModuleID()), (long)applicationSMM.getModuleID());
                    applicationSMM.registerExternalState(string, n2);
                }
                n3 = applicationSMM.externalStates();
                for (n5 = 0; n5 < n3; ++n5) {
                    string = applicationSMM.getExternalStateLabel(n5);
                    n2 = applicationSMM.getExternalStateID(n5);
                    this.logger.sm[this.terminalID][this.subterminalID].log(100000000, "[StateMachineData#addAppSMM] [%1] register external state (label '%2') of SMM-%3 with SMM-%4.", (Object)Integer.toString(this.terminal.getTerminalID()), (Object)string, (Object)Integer.toString(applicationSMM.getModuleID()), (long)sMModule.getModuleID());
                    sMModule.registerExternalState(string, n2);
                }
            }
            n3 = applicationSMM.externalStates();
            for (n4 = 0; n4 < n3; ++n4) {
                string = applicationSMM.getExternalStateLabel(n4);
                n2 = applicationSMM.getExternalStateID(n4);
                this.label2StateIDMap.put(string, new Integer(n2));
            }
            this.smmList[n] = applicationSMM;
            this.logger.sm[this.terminalID][this.subterminalID].log(1000000, "[StateMachineData#addAppSMM] [%1] AppSMM-%3 (Module ID %1) registered.", (Object)Integer.toString(this.terminal.getTerminalID()), (Object)applicationSMM.getSMMName(), (long)n);
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            if (n >= this.smmList.length) {
                this.logger.smi.log(1000, "[StateMachineData#addAppSMM] [%1] module ID %2 too high for SMI to handle, smmList.length is %3.", (Object)Integer.toString(this.terminal.getTerminalID()), (long)n, (long)this.smmList.length);
                this.criticalError("critical error during SMI init", arrayIndexOutOfBoundsException);
                return false;
            }
            this.logger.smi.log(1000, "[StateMachineData#addAppSMM] [%1] invalid access to smmList in method addAppSMM.", (long)this.terminal.getTerminalID(), (Throwable)arrayIndexOutOfBoundsException);
            this.criticalError("critical error during SMI init", arrayIndexOutOfBoundsException);
            return false;
        }
        return true;
    }

    public boolean removeAppSMM(ApplicationSMM applicationSMM) {
        block12: {
            if (applicationSMM == null) {
                return true;
            }
            int n = applicationSMM.getModuleID();
            if (n == 0) {
                this.logger.sm[this.terminalID][this.subterminalID].log(10000, "[StateMachineData#removeAppSMM] [%2] AppSMM %1 returns module ID 0 (reserved for SysSMM).", (Object)applicationSMM.getSMMName(), (long)this.terminal.getTerminalID());
                this.logger.sm[this.terminalID][this.subterminalID].log(1000000, "[StateMachineData#removeAppSMM] [%2] AppSMM %1 ignored.", (Object)applicationSMM.getSMMName(), (long)this.terminal.getTerminalID());
                return true;
            }
            try {
                if (applicationSMM == this.smmList[n]) {
                    String string;
                    int n2;
                    int n3;
                    SystemSMM systemSMM = (SystemSMM)this.smmList[0];
                    this.smmList[n] = null;
                    if (systemSMM != null) {
                        this.logger.sm[this.terminalID][this.subterminalID].log(100000000, "[StateMachineData#removeAppSMM] [%1] deregister SMM-%3 (moduleID %2) from System SMM.", (Object)Integer.toString(this.terminal.getTerminalID()), (Object)applicationSMM.getSMMName(), (long)applicationSMM.getModuleID());
                        systemSMM.deregisterSMM(applicationSMM);
                    }
                    for (n3 = 0; n3 < this.smmList.length; ++n3) {
                        int n4;
                        SMModule sMModule = this.smmList[n3];
                        if (sMModule == null) continue;
                        n2 = sMModule.externalStates();
                        for (n4 = 0; n4 < n2; ++n4) {
                            string = sMModule.getExternalStateLabel(n4);
                            this.logger.sm[this.terminalID][this.subterminalID].log(100000000, "[StateMachineData#removeAppSMM] [%1] deregister external state (label '%2') of SMM-%3 from SMM-%4.", (Object)Integer.toString(this.terminal.getTerminalID()), (Object)string, (Object)Integer.toString(sMModule.getModuleID()), (long)applicationSMM.getModuleID());
                            applicationSMM.deregisterExternalState(string);
                        }
                        n2 = applicationSMM.externalStates();
                        for (n4 = 0; n4 < n2; ++n4) {
                            string = applicationSMM.getExternalStateLabel(n4);
                            this.logger.sm[this.terminalID][this.subterminalID].log(100000000, "[StateMachineData#removeAppSMM] [%1] deregister external state (label '%2') of SMM-%3 from SMM-%4.", (Object)Integer.toString(this.terminal.getTerminalID()), (Object)string, (Object)Integer.toString(applicationSMM.getModuleID()), (long)sMModule.getModuleID());
                            sMModule.deregisterExternalState(string);
                        }
                    }
                    n2 = applicationSMM.externalStates();
                    for (n3 = 0; n3 < n2; ++n3) {
                        string = applicationSMM.getExternalStateLabel(n3);
                        this.label2StateIDMap.remove(string);
                    }
                    break block12;
                }
                if (this.smmList[n] == null) {
                    return true;
                }
                this.logger.sm[this.terminalID][this.subterminalID].log(10000, "[StateMachineData#removeAppSMM] [%1] two AppSMMs (mID %2) present,", (long)this.terminal.getTerminalID(), (long)n);
                this.logger.sm[this.terminalID][this.subterminalID].log(1000000, "[StateMachineData#removeAppSMM] [%1] AppSMM (Module ID %2) not removed as present AppSMM and AppSMM to remove are not the same.", (long)this.terminal.getTerminalID(), (long)n);
                return false;
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                if (n >= this.smmList.length) {
                    this.logger.smi.log(1000, "[StateMachineData#removeAppSMM] [%1] module ID %2 too high for SMI to handle.", (Object)Integer.toString(this.terminal.getTerminalID()), (Object)Integer.toString(n), (Object)arrayIndexOutOfBoundsException);
                    this.criticalError("[StateMachineData#removeAppSMM] critical error during SMI deinit", arrayIndexOutOfBoundsException);
                    return false;
                }
                this.logger.smi.log(1000, "[StateMachineData#removeAppSMM] [%1] invalid access to smmList in method removeAppSMM.", (long)this.terminal.getTerminalID(), (Throwable)arrayIndexOutOfBoundsException);
                this.criticalError("[StateMachineData#removeAppSMM] critical error during SMI deinit", arrayIndexOutOfBoundsException);
                return false;
            }
        }
        return true;
    }

    public void removeAllSMMs() {
        this.initialised = false;
        try {
            for (int i2 = this.smmList.length - 1; i2 > 0; --i2) {
                this.removeAppSMM((ApplicationSMM)this.smmList[i2]);
            }
            this.removeSysSMM((SystemSMM)this.smmList[0]);
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            this.logger.smi.log(1000, "[StateMachineData#removeAllSMMs] [%1] invalid access to smmList in method removeAllSMMs.", (long)this.terminal.getTerminalID(), (Throwable)arrayIndexOutOfBoundsException);
            this.criticalError("[StateMachineData#removeAllSMMs] critical error during SMI deinit", arrayIndexOutOfBoundsException);
        }
    }

    public boolean isInitialised() {
        if (this.terminalID == 6) {
            if (this.logger.smi.isInfo() && (!this.initialised || this.sdsService == null)) {
                this.logger.smi.log(100000, "[StateMachineData#isInitialized] terminal='%2', initialized='%1', sdsService='%3'", (Object)Boolean.toString(this.initialised), (Object)Integer.toString(this.terminalID), (Object)(this.sdsService == null ? "null" : "available"));
            }
            return this.initialised && this.sdsService != null;
        }
        return this.initialised;
    }

    public boolean isSMMregistered(int n) {
        if (n >= this.smmList.length) {
            return false;
        }
        return this.smmList[n] != null;
    }

    public boolean isSMM4IDregistered(int n) {
        int n2 = n / 100000;
        return this.isSMMregistered(n2);
    }

    public boolean isSysSMM(SMModule sMModule) {
        return sMModule != null && sMModule == this.smmList[0];
    }

    public SMModule getSMM4ID(int n) {
        SMModule sMModule = null;
        int n2 = n / 100000;
        if (n2 < this.smmList.length) {
            sMModule = this.smmList[n2];
        }
        if (sMModule == null) {
            this.logger.sm[this.terminalID][this.subterminalID].log(100000, "[StateMachineData#getSMM4ID] [%1] SMM for ID %2 not present?!?", (long)this.terminal.getTerminalID(), (long)n);
            this.logger.smi.log(1000, "[StateMachineData#getSMM4ID] [%1] SMM (mID %2) missing although ID is known to SMI?!?", (long)this.terminal.getTerminalID(), (long)n2);
            this.criticalError("[StateMachineData#getSMM4ID] critical error during SMI processing");
        }
        return sMModule;
    }

    public int getTopLevelState() {
        return this.smmList[0].getTopLevelState();
    }

    public State getState(int n) {
        SMModule sMModule = this.getSMM4ID(n);
        State state = sMModule.getState(n);
        if (state == null) {
            this.logger.sm[this.terminalID][this.subterminalID].log(1000, "[StateMachineData#getState] [%1] State (STATEID#%2) known but undefined in SMM.", (long)this.terminal.getTerminalID(), (long)n);
            this.criticalError("[StateMachineData#getState] critical model error during SMI processing");
        }
        return state;
    }

    public State getState(String string) {
        State state = null;
        Integer n = (Integer)this.label2StateIDMap.get(string);
        if (n != null) {
            SMModule sMModule = this.getSMM4ID(n);
            state = sMModule.getState(n);
        }
        return state;
    }

    public Transition getTransition(int n) {
        SMModule sMModule = this.getSMM4ID(n);
        Transition transition = sMModule.getTransition(n);
        if (transition == null) {
            this.logger.sm[this.terminalID][this.subterminalID].log(1000, "[StateMachineData#getTransition] [%1] Transition (TRANSID#%2) known but undefined in SMM.", (long)this.terminal.getTerminalID(), (long)n);
            this.criticalError("[StateMachineData#getTransition] critical model error during SMI processing");
        }
        return transition;
    }

    public EventMediator getMediator(int n) {
        SMModule sMModule = this.getSMM4ID(n);
        EventMediator eventMediator = sMModule.getEventMediator(n);
        if (eventMediator == null) {
            this.logger.sm[this.terminalID][this.subterminalID].log(1000, "[StateMachineData#getMediator] [%1] Event Mediator (MEDID#%2) known but undefined in SMM.", (long)this.terminal.getTerminalID(), (long)n);
            this.criticalError("[StateMachineData#getMediator] critical model error during SMI processing");
        }
        return eventMediator;
    }

    public Popup getPopup(int n) {
        if (n <= -1) {
            return null;
        }
        if (!this.isSMM4IDregistered(n)) {
            this.logger.sm[this.terminalID][this.subterminalID].log(1000000, "[StateMachineData#getPopup] [%1] SMM containing popup (POPUPID#%2) not present.", (long)this.terminal.getTerminalID(), (long)n);
            return null;
        }
        SMModule sMModule = this.getSMM4ID(n);
        Popup popup = null;
        if (sMModule != null) {
            popup = sMModule.getPopup(n);
        }
        return popup;
    }

    protected void setSDSSerivce(TTSASR tTSASR) {
        this.sdsService = tTSASR;
    }

    public TTSASR getSDSService() {
        return this.sdsService;
    }
}

