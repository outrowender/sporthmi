/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc.readout;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.info.app.InfoEnv;
import de.audi.tghu.info.app.tmc.readout.TMCAbstractReadOutQueue;
import de.audi.tghu.info.app.tmc.readout.TMCReadOutMessage;
import de.audi.tghu.info.app.tmc.readout.TMCReadOutMessageImpl;
import de.audi.tghu.info.app.tmc.readout.TMCReadOutOnRouteQueue$TMCComparator;
import java.util.Collections;

public class TMCReadOutOnRouteQueue
extends TMCAbstractReadOutQueue {
    protected TMCReadOutOnRouteQueue$TMCComparator comparator = new TMCReadOutOnRouteQueue$TMCComparator(this);

    public TMCReadOutOnRouteQueue(LogChannel logChannel, InfoEnv infoEnv) {
        super(logChannel, infoEnv);
    }

    @Override
    protected void sortMessageQueue() {
        if (this.logCh.isDebug2()) {
            this.logCh.log(14808325, "[TMCReadOutOnRouteQueue#sortMessageQueue] Called. ");
        }
        if (this.distanceToTarget != -1L) {
            if (this.logCh.isDebug2()) {
                this.logCh.log(14808325, "[TMCReadOutOnRouteQueue#sortMessageQueue] Sorting read out queue. ");
            }
            Collections.sort(this.messageQueue, this.comparator);
        }
        if (this.logCh.isDebug2()) {
            this.logCh.log(14808325, "[TMCReadOutOnRouteQueue#sortMessageQueue] Finished. ");
        }
    }

    @Override
    protected void messageVersionChangedAfterUpdate(int n, TMCReadOutMessageImpl tMCReadOutMessageImpl) {
        this.logCh.log(-2137614336, "[TMCReadOutOnRouteQueue#messageVersionChangedAfterUpdate] Called, readout state: %2, newMsg: %1", (Object)tMCReadOutMessageImpl, (long)n);
        switch (n) {
            case 3: {
                this.logCh.log(-2137614336, "[TMCReadOutOnRouteQueue#messageVersionChangedAfterUpdate] Set readout state of new msg to READ_OUT_ONCE.");
                tMCReadOutMessageImpl.setReadOutState(1);
                break;
            }
            case 1: {
                this.logCh.log(-2137614336, "[TMCReadOutOnRouteQueue#messageVersionChangedAfterUpdate] Set readout state of new msg to READ_OUT_NEVER.");
                tMCReadOutMessageImpl.setReadOutState(-1);
                break;
            }
        }
    }

    @Override
    protected synchronized TMCReadOutMessage provideMsgForReadOut() {
        int n = this.messageQueue.size();
        for (int i2 = 0; i2 < n; ++i2) {
            TMCReadOutMessageImpl tMCReadOutMessageImpl = (TMCReadOutMessageImpl)this.messageQueue.get(i2);
            this.logCh.log(-2137614336, "[TMCReadOutOnRouteQueue#provideMsgForReadOut] Checking message %1. ", tMCReadOutMessageImpl.getMessageID());
            if (this.distanceToTarget - tMCReadOutMessageImpl.getDistanceToAttentionPoint2() <= 0L) {
                this.logCh.log(-2137614336, "[TMCReadOutOnRouteQueue#provideMsgForReadOut] Vehicle reached second attention point");
                if (tMCReadOutMessageImpl.getReadOutState() != 3) {
                    this.logCh.log(-2137614336, "[TMCReadOutOnRouteQueue#provideMsgForReadOut] Message is not readout completely, return msg.");
                    this.readOutStringHelper.createStringForOnRouteMsgSecondAttentionPoint(tMCReadOutMessageImpl, this.distanceToTarget);
                    return tMCReadOutMessageImpl;
                }
                this.logCh.log(-2137614336, "[TMCReadOutOnRouteQueue#provideMsgForReadOut] Ignore message %1, because it was read out completely! ", tMCReadOutMessageImpl.getMessageID());
                continue;
            }
            if (this.distanceToTarget - tMCReadOutMessageImpl.getDistanceToAttentionPoint1() <= 0L) {
                this.logCh.log(-2137614336, "[TMCReadOutOnRouteQueue#provideMsgForReadOut] Vehicle reached first attention point");
                if (tMCReadOutMessageImpl.getReadOutState() != 1) {
                    this.logCh.log(-2137614336, "[TMCReadOutOnRouteQueue#provideMsgForReadOut] Message is not readout ONCE, return msg.");
                    this.readOutStringHelper.createStringForOnRouteMsgFirstAttentionPoint(tMCReadOutMessageImpl, this.distanceToTarget);
                    return tMCReadOutMessageImpl;
                }
                this.logCh.log(-2137614336, "[TMCReadOutOnRouteQueue#provideMsgForReadOut] Ignore message %1, because it was already read out once! ", tMCReadOutMessageImpl.getMessageID());
                continue;
            }
            this.logCh.log(-2137614336, "[TMCReadOutOnRouteQueue#provideMsgForReadOut] Return null, because no message is in range! ");
            return null;
        }
        return null;
    }

    @Override
    protected void changeReadOutStateAfterSpeaking(TMCReadOutMessageImpl tMCReadOutMessageImpl) {
        switch (tMCReadOutMessageImpl.getReadOutState()) {
            case -1: {
                if (this.distanceToTarget < tMCReadOutMessageImpl.getDistanceToAttentionPoint2()) {
                    this.logCh.log(-2137614336, "[TMCReadOutOnRouteQueue#changeReadOutStateAfterSpeaking] Distance to target: %1, distance to attention point 2: %2", this.distanceToTarget, tMCReadOutMessageImpl.getDistanceToAttentionPoint2());
                    this.logCh.log(-2137614336, "[TMCReadOutOnRouteQueue#changeReadOutStateAfterSpeaking] Changed read out state of message %1 from NEVER to COMPLETELY.", tMCReadOutMessageImpl.getMessageID());
                    tMCReadOutMessageImpl.setReadOutState(3);
                    break;
                }
                this.logCh.log(-2137614336, "[TMCReadOutOnRouteQueue#changeReadOutStateAfterSpeaking] Changed read out state of message %1 from NEVER to ONCE.", tMCReadOutMessageImpl.getMessageID());
                tMCReadOutMessageImpl.setReadOutState(1);
                break;
            }
            case 1: {
                tMCReadOutMessageImpl.setReadOutState(3);
                this.logCh.log(-2137614336, "[TMCReadOutOnRouteQueue#changeReadOutStateAfterSpeaking] Changed read out state of message %1 to from ONCE to COMPLETELY.", tMCReadOutMessageImpl.getMessageID());
                break;
            }
            default: {
                this.logCh.log(-2137614336, "[TMCReadOutOnRouteQueue#changeReadOutStateAfterSpeaking] Message %1 is already in state COMPLETELY, should not happen.", tMCReadOutMessageImpl.getMessageID());
            }
        }
    }
}

