/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc.readout;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.info.app.InfoEnv;
import de.audi.tghu.info.app.tmc.readout.TMCReadOutMessage;
import de.audi.tghu.info.app.tmc.readout.TMCReadOutMessageImpl;
import de.audi.tghu.info.app.tmc.readout.TMCReadOutQueue;
import de.audi.tghu.info.app.tmc.readout.TMCReadOutQueueListener;
import de.audi.tghu.info.app.tmc.readout.TMCReadOutStringHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.dsi.ifc.tmc.TmcMessage;

public abstract class TMCAbstractReadOutQueue
implements TMCReadOutQueue {
    protected long distanceToTarget = Long.MAX_VALUE;
    protected TmcMessage[] currentMsgs;
    protected HashMap newTmcMessages;
    protected HashMap readTmcMessages;
    protected List messageQueue;
    protected LogChannel logCh;
    protected TMCReadOutQueueListener listener;
    protected TMCReadOutStringHelper readOutStringHelper;

    public TMCAbstractReadOutQueue(LogChannel logChannel, InfoEnv infoEnv) {
        this.readOutStringHelper = new TMCReadOutStringHelper(infoEnv);
        this.logCh = logChannel;
        this.logCh.log(-2137614336, "[TMCAbstractReadOutQueue#TMCAbstractReadOutQueue] Called. ");
        this.currentMsgs = new TmcMessage[0];
        this.newTmcMessages = new HashMap(20);
        this.readTmcMessages = new HashMap(20);
        this.messageQueue = new ArrayList(20);
    }

    @Override
    public void setQueueListener(TMCReadOutQueueListener tMCReadOutQueueListener) {
        this.listener = tMCReadOutQueueListener;
    }

    public synchronized String getMessageQueueContent() {
        return this.messageQueue.toString();
    }

    @Override
    public synchronized void updateTmcMessageList(TmcMessage[] tmcMessageArray) {
        int n;
        String string = tmcMessageArray == null ? "null" : String.valueOf(tmcMessageArray.length);
        this.logCh.log(-2137614336, "[TMCAbstractReadOutQueue#updateTmcMessageList] Called, number of msgs: %1 ", (Object)string);
        if (tmcMessageArray == null) {
            tmcMessageArray = new TmcMessage[]{};
        }
        TMCReadOutMessageImpl tMCReadOutMessageImpl = null;
        this.messageQueue.clear();
        for (n = 0; n < tmcMessageArray.length; ++n) {
            if (tmcMessageArray[n] == null) {
                this.logCh.log(-1601830656, "[TMCAbstractReadOutQueue#updateTmcMessageList] messages[%1] is null, continue", (long)n);
                continue;
            }
            tMCReadOutMessageImpl = new TMCReadOutMessageImpl(tmcMessageArray[n]);
            this.newTmcMessages.put(new Long(tmcMessageArray[n].getMessageID()), tMCReadOutMessageImpl);
            if (!this.wasAlreadyRead(tMCReadOutMessageImpl)) {
                this.logCh.log(-2137614336, "[TMCAbstractReadOutQueue#updateTmcMessageList] Add message '%1' to queue.", (Object)tMCReadOutMessageImpl);
                this.messageQueue.add(tMCReadOutMessageImpl);
                continue;
            }
            this.logCh.log(-2137614336, "[TMCAbstractReadOutQueue#updateTmcMessageList] Message %1 was already read and is not put into read out queue. ", tMCReadOutMessageImpl.getMessageID());
        }
        for (n = 0; n < this.currentMsgs.length; ++n) {
            if (this.currentMsgs[n] == null) {
                this.logCh.log(-1601830656, "[TMCAbstractReadOutQueue#updateTmcMessageList] currentMsgs[%1] is null, continue", (long)n);
                continue;
            }
            Long l = new Long(this.currentMsgs[n].getMessageID());
            if (this.newTmcMessages.get(l) != null) continue;
            this.readTmcMessages.remove(l);
            this.logCh.log(-2137614336, "[TMCAbstractReadOutQueue#updateTmcMessageList] Message %1 was removed from hashtable which stores read messages. ", (Object)l);
        }
        this.currentMsgs = tmcMessageArray;
        this.sortMessageQueue();
    }

    protected boolean wasAlreadyRead(TMCReadOutMessageImpl tMCReadOutMessageImpl) {
        this.logCh.log(-2137614336, "[TMCAbstractReadOutQueue#wasAlreadyRead] Called. ");
        TMCReadOutMessageImpl tMCReadOutMessageImpl2 = (TMCReadOutMessageImpl)this.readTmcMessages.get(new Long(tMCReadOutMessageImpl.getMessageID()));
        if (tMCReadOutMessageImpl2 != null) {
            if (tMCReadOutMessageImpl.getVersionInfo() > tMCReadOutMessageImpl2.getVersionInfo()) {
                this.logCh.log(-2137614336, "[TMCAbstractReadOutQueue#wasAlreadyRead] The version info of message %1 changed, mark for reading out again... ", tMCReadOutMessageImpl.getMessageID());
                this.messageVersionChangedAfterUpdate(tMCReadOutMessageImpl2.getReadOutState(), tMCReadOutMessageImpl);
                return false;
            }
            if (tMCReadOutMessageImpl2.getReadOutState() == 3) {
                this.logCh.log(-2137614336, "[TMCAbstractReadOutQueue#wasAlreadyRead] Message %1 was already read out completely. ", tMCReadOutMessageImpl.getMessageID());
                return true;
            }
            this.logCh.log(-2137614336, "[TMCAbstractReadOutQueue#wasAlreadyRead] Message %1 was NOT read out completely yet. ", tMCReadOutMessageImpl.getMessageID());
            tMCReadOutMessageImpl.setReadOutState(tMCReadOutMessageImpl2.getReadOutState());
            return false;
        }
        return false;
    }

    protected abstract void messageVersionChangedAfterUpdate(int n, TMCReadOutMessageImpl tMCReadOutMessageImpl) {
    }

    @Override
    public synchronized TMCReadOutMessage getTmcMessage() {
        if (this.logCh.isDebug2()) {
            this.logCh.log(14808325, "[TMCAbstractReadOutQueue#getTmcMessage] Called. ");
        }
        if (this.messageQueue.isEmpty()) {
            if (this.logCh.isDebug2()) {
                this.logCh.log(14808325, "[TMCAbstractReadOutQueue#getTmcMessage] Message queue is empty, return null! ");
            }
            return null;
        }
        if (this.logCh.isDebug2()) {
            this.logCh.log(14808325, "[TMCAbstractReadOutQueue#getTmcMessage] Search for a message for read out.");
        }
        return this.provideMsgForReadOut();
    }

    protected abstract TMCReadOutMessage provideMsgForReadOut() {
    }

    @Override
    public synchronized void speakingFinished(TMCReadOutMessage tMCReadOutMessage) {
        this.logCh.log(-2137614336, "[TMCAbstractReadOutQueue#speakingFinished] Called, message: %1", (Object)tMCReadOutMessage);
        if (tMCReadOutMessage == null) {
            return;
        }
        TMCReadOutMessageImpl tMCReadOutMessageImpl = (TMCReadOutMessageImpl)tMCReadOutMessage;
        int n = this.messageQueue.indexOf(tMCReadOutMessage);
        if (n >= 0) {
            this.logCh.log(-2137614336, "[TMCAbstractReadOutQueue#speakingFinished] Message found in queue.");
            TMCReadOutMessageImpl tMCReadOutMessageImpl2 = (TMCReadOutMessageImpl)this.messageQueue.get(n);
            if (tMCReadOutMessageImpl.getReadOutState() != tMCReadOutMessageImpl2.getReadOutState()) {
                this.logCh.log(-2137614336, "[TMCAbstractReadOutQueue#speakingFinished] During reading out the read out state of the message %1 changed. ", tMCReadOutMessageImpl.getMessageID());
                tMCReadOutMessageImpl2.setReadOutState(tMCReadOutMessageImpl.getReadOutState());
            } else {
                this.changeReadOutStateAfterSpeaking(tMCReadOutMessageImpl2);
            }
            if (tMCReadOutMessageImpl2.getReadOutState() == 3) {
                this.messageQueue.remove(tMCReadOutMessage);
                this.logCh.log(-2137614336, "[TMCAbstractReadOutQueue#speakingFinished] Message %1 was removed from message queue, because it was read completely! ", tMCReadOutMessage.getMessageID());
            }
            this.readTmcMessages.put(new Long(tMCReadOutMessageImpl.getMessageID()), tMCReadOutMessageImpl2);
            this.logCh.log(-2137614336, "[TMCAbstractReadOutQueue#speakingFinished] Message %1 put into hashtable which stores the read out state of messages. ", tMCReadOutMessage.getMessageID());
        } else {
            this.logCh.log(-2137614336, "[TMCAbstractReadOutQueue#speakingFinished] Message %1 is NOT in message queue. ", tMCReadOutMessage.getMessageID());
        }
    }

    protected abstract void changeReadOutStateAfterSpeaking(TMCReadOutMessageImpl tMCReadOutMessageImpl) {
    }

    @Override
    public synchronized void setDistanceToTarget(long l) {
        if (this.logCh.isDebug2()) {
            this.logCh.log(14808325, "[TMCAbstractReadOutQueue#setDistanceToTarget] Called. ");
        }
        this.distanceToTarget = l;
        this.sortMessageQueue();
    }

    protected abstract void sortMessageQueue() {
    }
}

