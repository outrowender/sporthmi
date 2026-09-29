/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.smi;

import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.State;
import de.audi.atip.testsupport.ITestSupportService;
import de.audi.atip.testsupport.ITestSupportSession;
import de.audi.atip.testsupport.NullTestSupportSession;
import de.audi.tghu.smi.PopupStack;
import de.audi.tghu.smi.PopupStateMachine;
import de.audi.tghu.smi.SMI;
import de.audi.tghu.smi.SMIOnscreenStatisticsHandler$SMDataProvider;
import de.audi.tghu.smi.StateMachine;
import de.audi.tghu.smi.StateMachineTerminal;
import de.esolutions.fw.util.commons.Buffer;

public class SMIOnscreenStatisticsHandler {
    private final LogChannel logChan;
    private final SMI smi;
    public static final int TYPE_MAIN;
    public static final int TYPE_SDS;
    private volatile ITestSupportSession bemSessionMain;
    private volatile ITestSupportSession bemSessionSDS;
    private volatile SMIOnscreenStatisticsHandler$SMDataProvider mainDataProvider;
    private volatile SMIOnscreenStatisticsHandler$SMDataProvider sdsDataProvider;

    public SMIOnscreenStatisticsHandler(SMI sMI, LogChannel logChannel) {
        this.logChan = logChannel;
        this.smi = sMI;
        this.bemSessionMain = new NullTestSupportSession(-1601830656, logChannel);
        this.bemSessionSDS = new NullTestSupportSession(-1601830656, logChannel);
        this.mainDataProvider = new SMIOnscreenStatisticsHandler$SMDataProvider(this, "SMI - Statistics - Main", 0);
        this.sdsDataProvider = new SMIOnscreenStatisticsHandler$SMDataProvider(this, "SMI - Statistics - SDS", 6);
    }

    public void updateStatistics() {
        try {
            this.mainDataProvider.updateData();
            this.sdsDataProvider.updateData();
        }
        catch (Exception exception) {
            this.logChan.log(1000, "[SMIOnscreenStatisticsHandler#updateStatistics] exception occured", (Throwable)exception);
        }
    }

    private String[] getSMDetails(int n) {
        String[] stringArray;
        boolean bl = n == 6;
        StateMachineTerminal stateMachineTerminal = this.smi.getSMTerminal(n);
        if (stateMachineTerminal == null) {
            return new String[]{"not initialized"};
        }
        StateMachine stateMachine = stateMachineTerminal.getActiveSubterminalStateMachine();
        if (stateMachine == null || !stateMachine.isStarted()) {
            return new String[]{"not started"};
        }
        int n2 = stateMachine.getActiveStates();
        State[] stateArray = stateMachine.getActiveStateStack();
        State state = stateArray[n2 - 1];
        String string = this.getStateDetails(state, bl).toString();
        PopupStack popupStack = stateMachineTerminal.getPopupStack();
        int n3 = popupStack.size();
        if (n3 == 0) {
            stringArray = new String[]{"None active."};
        } else {
            stringArray = new String[n3];
            for (int i2 = 0; i2 < n3; ++i2) {
                PopupStateMachine popupStateMachine = popupStack.get(i2);
                if (popupStateMachine != null) {
                    int n4 = popupStateMachine.getActiveStates();
                    State[] stateArray2 = popupStateMachine.getActiveStateStack();
                    State state2 = stateArray2[n4 - 1];
                    stringArray[i2] = this.getStateDetails(state2, bl).append(" PID=").append(popupStateMachine.getID()).append(",PRIO=").append(popupStateMachine.getPriority()).toString();
                    continue;
                }
                stringArray[i2] = "-";
            }
        }
        String[] stringArray2 = new String[3 + stringArray.length];
        stringArray2[0] = "Normal:";
        stringArray2[1] = string;
        stringArray2[2] = "Popups:";
        for (int i3 = 0; i3 < stringArray.length; ++i3) {
            stringArray2[3 + i3] = stringArray[i3];
        }
        return stringArray2;
    }

    private Buffer getStateDetails(State state, boolean bl) {
        Buffer buffer = new Buffer(25);
        buffer.append("[id=").append(state.getStateID());
        if (bl) {
            if (state.hasSDPrompt()) {
                buffer.append(",PROMPT");
            } else if (state.hasSDCommandWithoutInheritance()) {
                buffer.append(",COMMAND noI.");
            } else if (state.hasSDCommand()) {
                buffer.append(",COMMAND");
            }
        }
        buffer.append(",f=").append(state.getAllFlags());
        buffer.append("]");
        return buffer;
    }

    public void setTestSupportService(ITestSupportService iTestSupportService) {
        if (iTestSupportService == null) {
            this.bemSessionMain = new NullTestSupportSession(-1601830656, this.logChan);
            this.bemSessionSDS = new NullTestSupportSession(-1601830656, this.logChan);
            return;
        }
        this.bemSessionMain = iTestSupportService.registerDataProvider(this.mainDataProvider);
        this.mainDataProvider.setSession(this.bemSessionMain);
        this.bemSessionMain.activateMenuEntry(true);
        this.bemSessionSDS = iTestSupportService.registerDataProvider(this.sdsDataProvider);
        this.sdsDataProvider.setSession(this.bemSessionSDS);
        this.bemSessionSDS.activateMenuEntry(true);
    }

    static /* synthetic */ LogChannel access$000(SMIOnscreenStatisticsHandler sMIOnscreenStatisticsHandler) {
        return sMIOnscreenStatisticsHandler.logChan;
    }

    static /* synthetic */ String[] access$100(SMIOnscreenStatisticsHandler sMIOnscreenStatisticsHandler, int n) {
        return sMIOnscreenStatisticsHandler.getSMDetails(n);
    }
}

