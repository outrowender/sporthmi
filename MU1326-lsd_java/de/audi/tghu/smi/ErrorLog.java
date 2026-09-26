/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.smi;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.tghu.smi.AbstractStateMachine;
import de.audi.tghu.smi.ErrorLog$HistoryRingBuffer;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import java.io.PrintStream;

class ErrorLog
implements DumpInfoProvider {
    private static final int MAX_HISTORY_SIZE;
    private final String name;
    private ErrorLog$HistoryRingBuffer stateHistory = new ErrorLog$HistoryRingBuffer(this, 100);
    private ErrorLog$HistoryRingBuffer eventHistory = new ErrorLog$HistoryRingBuffer(this, 100);
    private boolean processingEvent = false;
    private int executingEnterAction = -1;
    private int executingEnteredAction = -1;
    private int executingExitAction = -1;
    private int executingTransitionAction = -1;
    private int executingFocusLostAction = -1;
    private int executingFocusGainedAction = -1;
    private int activatingScreen = -1;
    private int executingSDForState = -1;
    private final boolean sdsTerminal;
    private final IFrameworkAccess fw;

    public ErrorLog(AbstractStateMachine abstractStateMachine) {
        int n = abstractStateMachine.getTerminalID();
        int n2 = abstractStateMachine.getSubterminalID();
        this.name = new StringBuffer().append("sm-").append(n).append('-').append(n2).append('-').append(abstractStateMachine.getTerminalName()).append('-').append(abstractStateMachine.getTag()).toString();
        this.sdsTerminal = n == 6;
        this.fw = abstractStateMachine.getFramework();
    }

    @Override
    public String getName() {
        return this.name;
    }

    private boolean isSDSTerminal() {
        return this.sdsTerminal;
    }

    @Override
    public void dump(PrintStream printStream, String string) {
        int n;
        printStream.println("+++ State Machine state +++");
        printStream.println();
        int n2 = -1;
        if (this.eventHistory.size() > 0) {
            n2 = this.eventHistory.get(this.eventHistory.size() - 1);
        }
        printStream.print("processing event: ");
        printStream.println(!this.processingEvent ? "no" : String.valueOf(n2));
        printStream.print("activating screen: ");
        printStream.println(this.activatingScreen == -1 ? "no" : String.valueOf(this.activatingScreen));
        if (this.isSDSTerminal()) {
            printStream.print("executing enter for sdForState: ");
            printStream.println(this.executingSDForState == -1 ? "no" : String.valueOf(this.executingSDForState));
        }
        printStream.print("executing enter action: ");
        printStream.println(this.executingEnterAction == -1 ? "no" : String.valueOf(this.executingEnterAction));
        printStream.print("executing entered action: ");
        printStream.println(this.executingEnteredAction == -1 ? "no" : String.valueOf(this.executingEnteredAction));
        printStream.print("executing exit action: ");
        printStream.println(this.executingExitAction == -1 ? "no" : String.valueOf(this.executingExitAction));
        printStream.print("executing focus-lost action: ");
        printStream.println(this.executingFocusLostAction == -1 ? "no" : String.valueOf(this.executingFocusLostAction));
        printStream.print("executing focus-gained action: ");
        printStream.println(this.executingFocusGainedAction == -1 ? "no" : String.valueOf(this.executingFocusGainedAction));
        printStream.print("executing transition action: ");
        printStream.println(this.executingTransitionAction == -1 ? "no" : String.valueOf(this.executingTransitionAction));
        printStream.println();
        printStream.println();
        printStream.println();
        printStream.println("+++ event history +++");
        printStream.println();
        for (n = 0; n < this.eventHistory.size(); ++n) {
            printStream.print('[');
            printStream.print(this.eventHistory.getTimestamp(n));
            printStream.print("] (EVENTID#");
            printStream.print(this.eventHistory.get(n));
            printStream.println(")");
        }
        printStream.println();
        printStream.println();
        printStream.println();
        printStream.println("+++ state history +++");
        printStream.println();
        for (n = 0; n < this.stateHistory.size(); ++n) {
            printStream.print('[');
            printStream.print(this.stateHistory.getTimestamp(n));
            printStream.print("] (STATEID#");
            printStream.print(this.stateHistory.get(n));
            printStream.println(")");
        }
    }

    public void startProcessingEvent(int n) {
        this.processingEvent = true;
        this.eventHistory.put(n);
    }

    public void finishedProcessingEvent() {
        this.processingEvent = false;
    }

    public void startExecutingEnterAction(int n) {
        this.executingEnterAction = n;
    }

    public void finishedExecutingEnterAction() {
        this.executingEnterAction = -1;
    }

    public void startExecutingEnteredAction(int n) {
        this.executingEnteredAction = n;
    }

    public void finishedExecutingEnteredAction() {
        this.executingEnteredAction = -1;
    }

    public void startExecutingExitAction(int n) {
        this.executingExitAction = n;
    }

    public void finishedExecutingExitAction() {
        this.executingExitAction = -1;
    }

    public void startExecutingTransitionAction(int n) {
        this.executingTransitionAction = n;
    }

    public void finishedExecutingTransitionAction() {
        this.executingTransitionAction = -1;
    }

    public void startExecutingFocusLostAction(int n) {
        this.executingFocusLostAction = n;
    }

    public void finishedExecutingFocusLostAction() {
        this.executingFocusLostAction = -1;
    }

    public void startExecutingFocusGainedAction(int n) {
        this.executingFocusGainedAction = n;
    }

    public void finishedExecutingFocusGainedAction() {
        this.executingFocusGainedAction = -1;
    }

    public void startActivatingScreen(int n, int n2) {
        this.stateHistory.put(n);
        this.activatingScreen = n2;
    }

    public void uiActivated(int n, boolean bl) {
        this.stateHistory.put(n);
    }

    public void finishedActivatingScreen() {
        this.activatingScreen = -1;
    }

    public void startExecutingSDForState(int n) {
        this.executingSDForState = n;
    }

    public void finishedExecutingSDForState() {
        this.executingSDForState = -1;
    }

    static /* synthetic */ IFrameworkAccess access$000(ErrorLog errorLog) {
        return errorLog.fw;
    }
}

