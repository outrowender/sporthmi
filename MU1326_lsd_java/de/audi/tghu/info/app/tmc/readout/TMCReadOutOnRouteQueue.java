/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc.readout;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.info.app.InfoEnv;
import de.audi.tghu.info.app.tmc.readout.TMCAbstractReadOutQueue;
import de.audi.tghu.info.app.tmc.readout.TMCReadOutMessage;
import de.audi.tghu.info.app.tmc.readout.TMCReadOutMessageImpl;
import java.util.Collections;
import java.util.Comparator;

public class TMCReadOutOnRouteQueue
extends TMCAbstractReadOutQueue {
    protected TMCComparator comparator = new TMCComparator();

    public TMCReadOutOnRouteQueue(LogChannel logChannel, InfoEnv infoEnv) {
        super(logChannel, infoEnv);
    }

    protected void sortMessageQueue() {
        if (this.logCh.isDebug2()) {
            this.logCh.log(100000000, "[TMCReadOutOnRouteQueue#sortMessageQueue] Called. ");
        }
        if (this.distanceToTarget != -1L) {
            if (this.logCh.isDebug2()) {
                this.logCh.log(100000000, "[TMCReadOutOnRouteQueue#sortMessageQueue] Sorting read out queue. ");
            }
            Collections.sort(this.messageQueue, this.comparator);
        }
        if (this.logCh.isDebug2()) {
            this.logCh.log(100000000, "[TMCReadOutOnRouteQueue#sortMessageQueue] Finished. ");
        }
    }

    protected void messageVersionChangedAfterUpdate(int n, TMCReadOutMessageImpl tMCReadOutMessageImpl) {
        this.logCh.log(10000000, "[TMCReadOutOnRouteQueue#messageVersionChangedAfterUpdate] Called, readout state: %2, newMsg: %1", (Object)tMCReadOutMessageImpl, (long)n);
        switch (n) {
            case 3: {
                this.logCh.log(10000000, "[TMCReadOutOnRouteQueue#messageVersionChangedAfterUpdate] Set readout state of new msg to READ_OUT_ONCE.");
                tMCReadOutMessageImpl.setReadOutState(1);
                break;
            }
            case 1: {
                this.logCh.log(10000000, "[TMCReadOutOnRouteQueue#messageVersionChangedAfterUpdate] Set readout state of new msg to READ_OUT_NEVER.");
                tMCReadOutMessageImpl.setReadOutState(-1);
                break;
            }
        }
    }

    protected synchronized TMCReadOutMessage provideMsgForReadOut() {
        int n = this.messageQueue.size();
        for (int i2 = 0; i2 < n; ++i2) {
            TMCReadOutMessageImpl tMCReadOutMessageImpl = (TMCReadOutMessageImpl)this.messageQueue.get(i2);
            this.logCh.log(10000000, "[TMCReadOutOnRouteQueue#provideMsgForReadOut] Checking message %1. ", tMCReadOutMessageImpl.getMessageID());
            if (this.distanceToTarget - tMCReadOutMessageImpl.getDistanceToAttentionPoint2() <= 0L) {
                this.logCh.log(10000000, "[TMCReadOutOnRouteQueue#provideMsgForReadOut] Vehicle reached second attention point");
                if (tMCReadOutMessageImpl.getReadOutState() != 3) {
                    this.logCh.log(10000000, "[TMCReadOutOnRouteQueue#provideMsgForReadOut] Message is not readout completely, return msg.");
                    this.readOutStringHelper.createStringForOnRouteMsgSecondAttentionPoint(tMCReadOutMessageImpl, this.distanceToTarget);
                    return tMCReadOutMessageImpl;
                }
                this.logCh.log(10000000, "[TMCReadOutOnRouteQueue#provideMsgForReadOut] Ignore message %1, because it was read out completely! ", tMCReadOutMessageImpl.getMessageID());
                continue;
            }
            if (this.distanceToTarget - tMCReadOutMessageImpl.getDistanceToAttentionPoint1() <= 0L) {
                this.logCh.log(10000000, "[TMCReadOutOnRouteQueue#provideMsgForReadOut] Vehicle reached first attention point");
                if (tMCReadOutMessageImpl.getReadOutState() != 1) {
                    this.logCh.log(10000000, "[TMCReadOutOnRouteQueue#provideMsgForReadOut] Message is not readout ONCE, return msg.");
                    this.readOutStringHelper.createStringForOnRouteMsgFirstAttentionPoint(tMCReadOutMessageImpl, this.distanceToTarget);
                    return tMCReadOutMessageImpl;
                }
                this.logCh.log(10000000, "[TMCReadOutOnRouteQueue#provideMsgForReadOut] Ignore message %1, because it was already read out once! ", tMCReadOutMessageImpl.getMessageID());
                continue;
            }
            this.logCh.log(10000000, "[TMCReadOutOnRouteQueue#provideMsgForReadOut] Return null, because no message is in range! ");
            return null;
        }
        return null;
    }

    protected void changeReadOutStateAfterSpeaking(TMCReadOutMessageImpl tMCReadOutMessageImpl) {
        switch (tMCReadOutMessageImpl.getReadOutState()) {
            case -1: {
                if (this.distanceToTarget < tMCReadOutMessageImpl.getDistanceToAttentionPoint2()) {
                    this.logCh.log(10000000, "[TMCReadOutOnRouteQueue#changeReadOutStateAfterSpeaking] Distance to target: %1, distance to attention point 2: %2", this.distanceToTarget, tMCReadOutMessageImpl.getDistanceToAttentionPoint2());
                    this.logCh.log(10000000, "[TMCReadOutOnRouteQueue#changeReadOutStateAfterSpeaking] Changed read out state of message %1 from NEVER to COMPLETELY.", tMCReadOutMessageImpl.getMessageID());
                    tMCReadOutMessageImpl.setReadOutState(3);
                    break;
                }
                this.logCh.log(10000000, "[TMCReadOutOnRouteQueue#changeReadOutStateAfterSpeaking] Changed read out state of message %1 from NEVER to ONCE.", tMCReadOutMessageImpl.getMessageID());
                tMCReadOutMessageImpl.setReadOutState(1);
                break;
            }
            case 1: {
                tMCReadOutMessageImpl.setReadOutState(3);
                this.logCh.log(10000000, "[TMCReadOutOnRouteQueue#changeReadOutStateAfterSpeaking] Changed read out state of message %1 to from ONCE to COMPLETELY.", tMCReadOutMessageImpl.getMessageID());
                break;
            }
            default: {
                this.logCh.log(10000000, "[TMCReadOutOnRouteQueue#changeReadOutStateAfterSpeaking] Message %1 is already in state COMPLETELY, should not happen.", tMCReadOutMessageImpl.getMessageID());
            }
        }
    }

    class TMCComparator
    implements Comparator {
        TMCComparator() {
        }

        public int compare(Object object, Object object2) {
            TMCReadOutMessageImpl tMCReadOutMessageImpl = (TMCReadOutMessageImpl)object;
            TMCReadOutMessageImpl tMCReadOutMessageImpl2 = (TMCReadOutMessageImpl)object2;
            long l = this.getDistanceForCalculation(tMCReadOutMessageImpl);
            long l2 = this.getDistanceForCalculation(tMCReadOutMessageImpl2);
            return (int)(TMCReadOutOnRouteQueue.this.distanceToTarget - l - (TMCReadOutOnRouteQueue.this.distanceToTarget - l2));
        }

        private long getDistanceForCalculation(TMCReadOutMessageImpl tMCReadOutMessageImpl) {
            switch (tMCReadOutMessageImpl.getReadOutState()) {
                case 1: 
                case 3: {
                    return tMCReadOutMessageImpl.getDistanceToAttentionPoint2();
                }
                case -1: {
                    return tMCReadOutMessageImpl.getDistanceToAttentionPoint1();
                }
            }
            return tMCReadOutMessageImpl.getDistanceToAttentionPoint1();
        }
    }
}

