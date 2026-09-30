/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes.protocol;

import de.vw.mib.bap.requests.StatusAckProperty;
import de.vw.mib.bap.requests.StatusProperty;

public interface IBAPPropertyFSGREQ {
    public void sendStatus(StatusProperty var1);

    public void sendStatusIfChanged(StatusProperty var1);

    public void resendLastStatus();

    public void sendStatusAck(StatusAckProperty var1);

    public void resendLastStatusAck();

    public void setInitialStatus(StatusProperty var1);

    public void setInitialStatusAck(StatusAckProperty var1);

    public StatusProperty getLastStatus();

    public StatusAckProperty getLastStatusAck();
}

