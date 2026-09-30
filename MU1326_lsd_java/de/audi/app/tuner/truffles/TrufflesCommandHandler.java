/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.truffles;

import de.audi.app.tuner.truffles.SearchGUI;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class TrufflesCommandHandler {
    private final Comparator commandComperator = new Comparator(){

        public int compare(Object object, Object object2) {
            return ((ITrufflesCommand)object).getPriority() - ((ITrufflesCommand)object2).getPriority();
        }
    };
    private LinkedList commandList = new LinkedList();
    private ITrufflesCommand cmd = null;

    synchronized void add(ITrufflesCommand iTrufflesCommand) {
        if (!this.commandList.isEmpty() && this.commandList.getLast() instanceof SearchGUI.PerformQueryCmd && iTrufflesCommand instanceof SearchGUI.PerformQueryCmd) {
            this.commandList.removeLast();
        }
        this.commandList.add(iTrufflesCommand);
        Collections.sort(this.commandList, this.commandComperator);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean runCommand() {
        TrufflesCommandHandler trufflesCommandHandler = this;
        synchronized (trufflesCommandHandler) {
            if (this.commandList.isEmpty()) {
                this.cmd = null;
                return false;
            }
            this.cmd = (ITrufflesCommand)this.commandList.removeFirst();
        }
        this.cmd.execute();
        return !(this.cmd instanceof SearchGUI.PerformQueryCmd);
    }

    boolean runCommands() {
        while (this.runCommand()) {
        }
        return this.cmd instanceof SearchGUI.PerformQueryCmd;
    }

    public static interface ITrufflesCommand {
        public static final int PRIO_INVALIDATE = 0;
        public static final int PRIO_QUERY = 1;

        public int getPriority();

        public void execute();
    }
}

