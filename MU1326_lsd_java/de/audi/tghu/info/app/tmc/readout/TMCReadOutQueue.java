/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc.readout;

import de.audi.tghu.info.app.tmc.readout.TMCReadOutMessage;
import de.audi.tghu.info.app.tmc.readout.TMCReadOutQueueListener;
import org.dsi.ifc.tmc.TmcMessage;

public interface TMCReadOutQueue {
    default public TMCReadOutMessage getTmcMessage() {
    }

    default public void setDistanceToTarget(long l) {
    }

    default public void speakingFinished(TMCReadOutMessage tMCReadOutMessage) {
    }

    default public void updateTmcMessageList(TmcMessage[] tmcMessageArray) {
    }

    default public void setQueueListener(TMCReadOutQueueListener tMCReadOutQueueListener) {
    }
}

