/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc.readout;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.info.app.tmc.readout.TMCReadOutMessage;
import de.audi.tghu.info.app.tmc.readout.TMCReadOutOnRoadQueue;
import de.audi.tghu.info.app.tmc.readout.TMCReadOutOnRouteQueue;
import de.audi.tghu.info.app.tmc.readout.TMCReadOutQueue;
import de.audi.tghu.info.app.tmc.readout.TMCReadOutQueueListener;
import org.dsi.ifc.tmc.TmcMessage;

public class TMCReadOutAllQueue
implements TMCReadOutQueue,
TMCReadOutQueueListener {
    private static final int ON_ROUTE_QUEUE = 1;
    private static final int ON_ROAD_QUEUE = 2;
    private static final int URGENT_QUEUE = 3;
    private LogChannel logCh;
    private TMCReadOutOnRoadQueue urgentQueue;
    private TMCReadOutQueueListener listener;
    private int lastUsedQueue = 0;
    private int readOutMode = 0;

    public TMCReadOutAllQueue(LogChannel logChannel, TMCReadOutOnRouteQueue tMCReadOutOnRouteQueue, TMCReadOutOnRoadQueue tMCReadOutOnRoadQueue, TMCReadOutOnRoadQueue tMCReadOutOnRoadQueue2) {
        this.logCh = logChannel;
        this.urgentQueue = tMCReadOutOnRoadQueue2;
        this.urgentQueue.setQueueListener(this);
    }

    public String getUrgentQueueContent() {
        return this.urgentQueue.getMessageQueueContent();
    }

    public TMCReadOutMessage getTmcMessage() {
        TMCReadOutMessage tMCReadOutMessage;
        if (this.logCh.isDebug2()) {
            this.logCh.log(100000000, "[TMCReadOutAllQueue#getTmcMessage] Called, read out mode: %1 ", (long)this.readOutMode);
        }
        if ((tMCReadOutMessage = this.urgentQueue.getTmcMessage()) != null) {
            if (this.logCh.isDebug2()) {
                this.logCh.log(100000000, "[TMCReadOutAllQueue#getTmcMessage] Message is retrieved from urgent queue: %1 ", (Object)tMCReadOutMessage);
            }
            this.lastUsedQueue = 3;
            return tMCReadOutMessage;
        }
        if (this.logCh.isDebug2()) {
            this.logCh.log(100000000, "[TMCReadOutAllQueue#getTmcMessage] Message is null ");
        }
        return null;
    }

    public void setDistanceToTarget(long l) {
        if (this.logCh.isDebug2()) {
            this.logCh.log(100000000, "[TMCReadOutAllQueue#setDistanceToTarget] Forward to on route queue, distance: %1 ", l);
        }
    }

    public void setQueueListener(TMCReadOutQueueListener tMCReadOutQueueListener) {
        this.logCh.log(10000000, "[TMCReadOutAllQueue#setQueueListener] Called. ");
        this.listener = tMCReadOutQueueListener;
    }

    public void speakingFinished(TMCReadOutMessage tMCReadOutMessage) {
        this.logCh.log(10000000, "[TMCReadOutAllQueue#speakingFinished] Called. ");
        switch (this.lastUsedQueue) {
            case 3: {
                this.logCh.log(10000000, "[TMCReadOutAllQueue#speakingFinished] Forward to urgent queue, message: %1 ", (Object)tMCReadOutMessage);
                this.urgentQueue.speakingFinished(tMCReadOutMessage);
                break;
            }
            default: {
                this.logCh.log(10000000, "[TMCReadOutAllQueue#speakingFinished] Unhandled queue ID, message: %1 ", (Object)tMCReadOutMessage);
            }
        }
    }

    public void updateTmcMessageList(TmcMessage[] tmcMessageArray) {
        throw new UnsupportedOperationException("updateTmcMessageList not supported");
    }

    public void containsMessages() {
        this.logCh.log(10000000, "[TMCReadOutAllQueue#containsMessages] Notify listener. ");
        this.listener.containsMessages();
    }

    void setReadOutMode(int n) {
        this.logCh.log(10000000, "[TMCReadOutAllQueue#setReadOutMode] Called, mode: %1 ", (long)n);
        this.readOutMode = n;
        this.logCh.log(10000000, "[TMCReadOutAllQueue#setReadOutMode] This is a High variant, 'on/off/on route' is available ");
        if (this.readOutMode != 1) {
            this.logCh.log(10000000, "[TMCReadOutAllQueue#setReadOutMode] Notify AppTMCReadOut for reading out. ");
            this.containsMessages();
        }
    }

    public void updateTmcUrgentMessages(TmcMessage[] tmcMessageArray) {
        String string = tmcMessageArray == null ? "null" : String.valueOf(tmcMessageArray.length);
        this.logCh.log(10000000, "[TMCReadOutAllQueue#updateTmcUrgentMessages] Called, forward to urgent queue, number of messages: %1 ", (Object)string);
        this.urgentQueue.updateTmcMessageList(tmcMessageArray);
        this.containsMessages();
    }
}

