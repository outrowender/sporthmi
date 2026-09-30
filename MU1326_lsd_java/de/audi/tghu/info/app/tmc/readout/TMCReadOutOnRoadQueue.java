/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc.readout;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.info.app.InfoEnv;
import de.audi.tghu.info.app.tmc.readout.TMCAbstractReadOutQueue;
import de.audi.tghu.info.app.tmc.readout.TMCReadOutMessage;
import de.audi.tghu.info.app.tmc.readout.TMCReadOutMessageImpl;

public class TMCReadOutOnRoadQueue
extends TMCAbstractReadOutQueue {
    public TMCReadOutOnRoadQueue(LogChannel logChannel, InfoEnv infoEnv) {
        super(logChannel, infoEnv);
    }

    protected void sortMessageQueue() {
        this.logCh.log(10000000, "[TMCReadOutOnRoadQueue#sortMessageQueue] Do not sort on road messages! ");
    }

    protected void messageVersionChangedAfterUpdate(int n, TMCReadOutMessageImpl tMCReadOutMessageImpl) {
        switch (n) {
            case 3: {
                tMCReadOutMessageImpl.setReadOutState(-1);
                break;
            }
        }
    }

    protected synchronized TMCReadOutMessage provideMsgForReadOut() {
        TMCReadOutMessageImpl tMCReadOutMessageImpl = (TMCReadOutMessageImpl)this.messageQueue.get(0);
        this.readOutStringHelper.createStringForOnRoadMsg(tMCReadOutMessageImpl);
        return tMCReadOutMessageImpl;
    }

    protected void changeReadOutStateAfterSpeaking(TMCReadOutMessageImpl tMCReadOutMessageImpl) {
        switch (tMCReadOutMessageImpl.getReadOutState()) {
            case -1: {
                tMCReadOutMessageImpl.setReadOutState(3);
                this.logCh.log(10000000, "[TMCReadOutOnRoadQueue#speakingFinished] Changed read out state of message %1 to ONCE. ", tMCReadOutMessageImpl.getMessageID());
                break;
            }
            default: {
                this.logCh.log(10000000, "[TMCReadOutOnRoadQueue#speakingFinished] Message %1 is already in state COMPLETELY, should not happen. ", tMCReadOutMessageImpl.getMessageID());
            }
        }
    }
}

