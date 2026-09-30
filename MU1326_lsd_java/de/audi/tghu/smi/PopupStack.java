/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.smi;

import de.audi.atip.hmi.KbdService;
import de.audi.tghu.smi.Logger;
import de.audi.tghu.smi.PopupStateMachine;
import de.audi.tghu.smi.StateMachineTerminal;
import java.util.ArrayList;
import java.util.List;

class PopupStack {
    private List stack = new ArrayList(4);
    private KbdService kbdServiceDummy;
    private final Logger logger;

    public PopupStack(Logger logger) {
        this.logger = logger;
    }

    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    public int size() {
        return this.stack.size();
    }

    public boolean contains(int n) {
        return this.getPopupIdx(n) > -1;
    }

    public void add(StateMachineTerminal stateMachineTerminal, PopupStateMachine popupStateMachine) {
        this.logger.smi.log(1000000, "[PopupStack#add] called for terminal '%1', popup '%2'.", (long)stateMachineTerminal.getTerminalID(), (long)popupStateMachine.getID());
        int n = popupStateMachine.getPriority();
        int n2 = this.stack.size();
        if (n2 == 0) {
            this.stack.add(popupStateMachine);
            if (stateMachineTerminal.getTerminalID() == 0 || stateMachineTerminal.getTerminalID() == 3 || stateMachineTerminal.getTerminalID() == 4) {
                KbdService kbdService = stateMachineTerminal.getSMI().getKeyboardService(stateMachineTerminal.getTerminalID());
                if (kbdService != null) {
                    stateMachineTerminal.getActiveSubterminalStateMachine().setKeyboardService(kbdService.getKbdService());
                }
                popupStateMachine.setKeyboardService(kbdService);
            }
            stateMachineTerminal.getActiveSubterminalStateMachine().setFocus(false);
            popupStateMachine.start();
        } else {
            boolean bl = false;
            for (int i2 = 0; i2 < n2; ++i2) {
                PopupStateMachine popupStateMachine2 = (PopupStateMachine)this.stack.get(i2);
                if (n < popupStateMachine2.getPriority()) continue;
                this.stack.add(i2, popupStateMachine);
                if (stateMachineTerminal.getTerminalID() == 0 || stateMachineTerminal.getTerminalID() == 3 || stateMachineTerminal.getTerminalID() == 4 || stateMachineTerminal.getTerminalID() == 6) {
                    if (i2 == 0) {
                        PopupStateMachine popupStateMachine3 = (PopupStateMachine)this.stack.get(1);
                        if (stateMachineTerminal.getTerminalID() != 6) {
                            KbdService kbdService = stateMachineTerminal.getSMI().getKeyboardService(stateMachineTerminal.getTerminalID());
                            popupStateMachine3.setKeyboardService(popupStateMachine3.getKeyboardService().getKbdService());
                            kbdService.synchronizeSettings(popupStateMachine.getKeyboardService());
                            popupStateMachine.setKeyboardService(kbdService);
                        }
                        popupStateMachine3.setFocus(false);
                    } else {
                        popupStateMachine.setFocus(false);
                    }
                }
                popupStateMachine.start();
                bl = true;
                break;
            }
            if (!bl) {
                this.stack.add(popupStateMachine);
                popupStateMachine.setFocus(false);
                popupStateMachine.start();
            }
        }
        if (!popupStateMachine.isStarted()) {
            this.remove(stateMachineTerminal, popupStateMachine.getID());
            stateMachineTerminal.getFramework().getErrorMgr().unregisterDumpInfoProvider(popupStateMachine.getErrorLog());
        }
    }

    public PopupStateMachine remove(StateMachineTerminal stateMachineTerminal, int n) {
        int n2 = this.getPopupIdx(n);
        this.logger.smi.log(1000000, "[PopupStack#remove] called for terminal '%1', popup (PID# %2), index at popup-stack is '%3'.'.", (long)stateMachineTerminal.getTerminalID(), (long)n, (long)n2);
        if (n2 > -1) {
            PopupStateMachine popupStateMachine = (PopupStateMachine)this.stack.remove(n2);
            if ((stateMachineTerminal.getTerminalID() == 0 || stateMachineTerminal.getTerminalID() == 3 || stateMachineTerminal.getTerminalID() == 4 || stateMachineTerminal.getTerminalID() == 6) && n2 == 0) {
                if (this.stack.isEmpty()) {
                    if (stateMachineTerminal.getTerminalID() != 6) {
                        KbdService kbdService = stateMachineTerminal.getSMI().getKeyboardService(stateMachineTerminal.getTerminalID());
                        if (kbdService != null) {
                            kbdService.synchronizeSettings(stateMachineTerminal.getActiveSubterminalStateMachine().getKeyboardService());
                        }
                        stateMachineTerminal.getActiveSubterminalStateMachine().setKeyboardService(kbdService);
                    }
                    stateMachineTerminal.getActiveSubterminalStateMachine().setFocus(true);
                } else {
                    PopupStateMachine popupStateMachine2 = (PopupStateMachine)this.stack.get(0);
                    if (stateMachineTerminal.getTerminalID() != 6) {
                        KbdService kbdService = stateMachineTerminal.getSMI().getKeyboardService(stateMachineTerminal.getTerminalID());
                        kbdService.synchronizeSettings(popupStateMachine2.getKeyboardService());
                        popupStateMachine2.setKeyboardService(kbdService);
                    }
                    popupStateMachine2.setFocus(true);
                }
                if (stateMachineTerminal.getTerminalID() != 6) {
                    popupStateMachine.setKeyboardService(this.getKbdServiceDummy(stateMachineTerminal));
                }
            }
            popupStateMachine.stop();
            return popupStateMachine;
        }
        return null;
    }

    public PopupStateMachine get() {
        if (!this.stack.isEmpty()) {
            return (PopupStateMachine)this.stack.get(0);
        }
        return null;
    }

    public PopupStateMachine get(int n) {
        if (n >= 0 && n < this.stack.size()) {
            return (PopupStateMachine)this.stack.get(n);
        }
        return null;
    }

    private int getPopupIdx(int n) {
        int n2 = this.stack.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            PopupStateMachine popupStateMachine = (PopupStateMachine)this.stack.get(i2);
            if (popupStateMachine.getID() != n) continue;
            return i2;
        }
        return -1;
    }

    private KbdService getKbdServiceDummy(StateMachineTerminal stateMachineTerminal) {
        if (this.kbdServiceDummy == null) {
            this.kbdServiceDummy = stateMachineTerminal.getSMI().getKeyboardService(stateMachineTerminal.getTerminalID()).getKbdService();
        }
        return this.kbdServiceDummy;
    }
}

