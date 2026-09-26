/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.truffles;

import de.audi.app.tuner.truffles.SearchGUI$PerformQueryCmd;
import de.audi.app.tuner.truffles.TrufflesCommandHandler$1;
import de.audi.app.tuner.truffles.TrufflesCommandHandler$ITrufflesCommand;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class TrufflesCommandHandler {
    private final Comparator commandComperator = new TrufflesCommandHandler$1(this);
    private LinkedList commandList = new LinkedList();
    private TrufflesCommandHandler$ITrufflesCommand cmd = null;

    synchronized void add(TrufflesCommandHandler$ITrufflesCommand trufflesCommandHandler$ITrufflesCommand) {
        if (!this.commandList.isEmpty() && this.commandList.getLast() instanceof SearchGUI$PerformQueryCmd && trufflesCommandHandler$ITrufflesCommand instanceof SearchGUI$PerformQueryCmd) {
            this.commandList.removeLast();
        }
        this.commandList.add(trufflesCommandHandler$ITrufflesCommand);
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
            this.cmd = (TrufflesCommandHandler$ITrufflesCommand)this.commandList.removeFirst();
        }
        this.cmd.execute();
        return !(this.cmd instanceof SearchGUI$PerformQueryCmd);
    }

    boolean runCommands() {
        while (this.runCommand()) {
        }
        return this.cmd instanceof SearchGUI$PerformQueryCmd;
    }
}

