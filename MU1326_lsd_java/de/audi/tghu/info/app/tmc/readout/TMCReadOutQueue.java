/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc.readout;

import de.audi.tghu.info.app.tmc.readout.TMCReadOutMessage;
import de.audi.tghu.info.app.tmc.readout.TMCReadOutQueueListener;
import org.dsi.ifc.tmc.TmcMessage;

public interface TMCReadOutQueue {
    public TMCReadOutMessage getTmcMessage();

    public void setDistanceToTarget(long var1);

    public void speakingFinished(TMCReadOutMessage var1);

    public void updateTmcMessageList(TmcMessage[] var1);

    public void setQueueListener(TMCReadOutQueueListener var1);
}

