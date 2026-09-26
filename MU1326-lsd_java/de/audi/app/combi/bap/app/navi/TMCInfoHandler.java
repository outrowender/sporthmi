/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.navi;

import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPTMCInfoMessage;
import de.audi.atip.log.LogChannel;
import de.vw.mib.bap.generated.navsd.serializer.TMCinfo_Status;
import java.util.ArrayList;
import java.util.List;

public class TMCInfoHandler {
    private final LogChannel logChannel;
    private final List pendingMessages = new ArrayList(5);
    private boolean waitingForConfirmation = false;
    private final BAPFunctionPropertyFSG tmcInfoFunction;

    protected TMCInfoHandler(BAPFunctionPropertyFSG bAPFunctionPropertyFSG, LogChannel logChannel) {
        this.tmcInfoFunction = bAPFunctionPropertyFSG;
        this.logChannel = logChannel;
    }

    protected void updateTMCInfoMessages(CombiBAPTMCInfoMessage[] combiBAPTMCInfoMessageArray) {
        if (combiBAPTMCInfoMessageArray == null) {
            this.logChannel.log(-1601830656, "[TMCInfoHandler#updateTMCInfoMessages] xUrgentMessages is null");
            return;
        }
        this.logChannel.log(-2137614336, "[TMCInfoHandler#updateTMCInfoMessages] %1 messages received", (long)combiBAPTMCInfoMessageArray.length);
        this.pendingMessages.clear();
        this.waitingForConfirmation = false;
        for (int i2 = 0; i2 < combiBAPTMCInfoMessageArray.length; ++i2) {
            this.pendingMessages.add(combiBAPTMCInfoMessageArray[i2]);
        }
        this.updateStatus();
    }

    private void updateStatus() {
        if (this.waitingForConfirmation || this.pendingMessages.isEmpty()) {
            TMCinfo_Status tMCinfo_Status = new TMCinfo_Status();
            int n = TMCInfoHandler.getMessageWaitingIndication(this.pendingMessages.size());
            if (n != tMCinfo_Status.messageWaitingIndication) {
                tMCinfo_Status.messageId = 15;
                tMCinfo_Status.messageStatus = this.pendingMessages.isEmpty() ? 0 : 1;
                tMCinfo_Status.messageWaitingIndication = n;
                tMCinfo_Status.tmcinfo.priority = 0;
                tMCinfo_Status.tmcinfo.streetName.setContent("");
                tMCinfo_Status.tmcinfo.location.setContent("");
                tMCinfo_Status.tmcinfo.infotext.setContent("");
                tMCinfo_Status.tmcinfo.length_Validity.lengthValid = false;
                tMCinfo_Status.tmcinfo.length_Value = 0;
                tMCinfo_Status.tmcinfo.length_Unit = 255;
                this.tmcInfoFunction.sendStatusIfChanged(tMCinfo_Status);
            }
        } else {
            this.sendNextMessage();
        }
    }

    protected void notifyMessagePresentationConfirmed(int n) {
        this.logChannel.log(-2137614336, "[TMCInfoHandler#notifyMessagePresentationConfirmed] presentation confirmed for messageID=%1", (long)n);
        if (this.pendingMessages.isEmpty()) {
            this.logChannel.log(-1601830656, "[TMCInfoHandler#notifyMessagePresentationConfirmed] no waiting messages to be confirmed");
        } else {
            this.pendingMessages.remove(0);
            this.waitingForConfirmation = false;
            this.updateStatus();
        }
    }

    private void sendNextMessage() {
        CombiBAPTMCInfoMessage combiBAPTMCInfoMessage = (CombiBAPTMCInfoMessage)this.pendingMessages.get(0);
        TMCinfo_Status tMCinfo_Status = new TMCinfo_Status();
        tMCinfo_Status.messageId = 1;
        tMCinfo_Status.messageStatus = 1;
        tMCinfo_Status.messageWaitingIndication = TMCInfoHandler.getMessageWaitingIndication(this.pendingMessages.size());
        tMCinfo_Status.tmcinfo.priority = combiBAPTMCInfoMessage.getPriority();
        tMCinfo_Status.tmcinfo.streetName.setContent(combiBAPTMCInfoMessage.getStreetName());
        tMCinfo_Status.tmcinfo.location.setContent(combiBAPTMCInfoMessage.getLocation());
        tMCinfo_Status.tmcinfo.infotext.setContent(combiBAPTMCInfoMessage.getInfotext());
        tMCinfo_Status.tmcinfo.length_Validity.lengthValid = true;
        tMCinfo_Status.tmcinfo.length_Value = (int)combiBAPTMCInfoMessage.getLength();
        tMCinfo_Status.tmcinfo.length_Unit = combiBAPTMCInfoMessage.getLengthUnit();
        this.waitingForConfirmation = true;
        this.tmcInfoFunction.sendStatusIfChanged(tMCinfo_Status);
    }

    private static int getMessageWaitingIndication(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return 2;
    }

    public List getPendingMessages() {
        return this.pendingMessages;
    }
}

