/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.rse;

import de.audi.atip.log.LogChannel;
import de.audi.atip.rse.AbstractRSECommand;

public abstract class AbstractRSECommandFactory {
    private final int moduleID;
    protected static LogChannel log;

    public AbstractRSECommandFactory(int n) {
        this.moduleID = n;
    }

    public synchronized AbstractRSECommand getCommand(int n) {
        AbstractRSECommand abstractRSECommand = null;
        int n2 = AbstractRSECommand.extractModuleID(n);
        if (n2 != this.moduleID) {
            throw new IllegalArgumentException(new StringBuffer().append("wrong module id ").append(n2).toString());
        }
        abstractRSECommand = this.getRSECommand(n);
        return abstractRSECommand;
    }

    public synchronized int getModuleID() {
        return this.moduleID;
    }

    public static LogChannel getLog() {
        return log;
    }

    public static void setLog(LogChannel logChannel) {
        log = logChannel;
    }

    protected abstract AbstractRSECommand getRSECommand(int n) {
    }
}

