/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.rse;

import de.audi.atip.log.LogChannel;
import de.audi.atip.rse.AbstractRSECommand;
import de.audi.atip.rse.AbstractRSEConnection;

public abstract class AbstractRSECmdForwarder {
    protected LogChannel log;
    private AbstractRSEConnection rseConnection;

    public AbstractRSECmdForwarder(AbstractRSEConnection abstractRSEConnection, LogChannel logChannel) {
        if (abstractRSEConnection == null) {
            throw new IllegalArgumentException("AbstractRSECmdForwarder: RSE Connection is null");
        }
        this.rseConnection = abstractRSEConnection;
        this.log = logChannel;
    }

    public LogChannel getLog() {
        return this.log;
    }

    public void setLog(LogChannel logChannel) {
        this.log = logChannel;
    }

    protected void sendCommand(AbstractRSECommand abstractRSECommand) {
        if (this.rseConnection != null) {
            this.rseConnection.sendCommand(abstractRSECommand);
        } else {
            this.log.log(10000, "RSEConnection is null!");
        }
    }

    public AbstractRSEConnection getRseConnection() {
        return this.rseConnection;
    }

    public void setRseConnection(AbstractRSEConnection abstractRSEConnection) {
        this.rseConnection = abstractRSEConnection;
    }
}

