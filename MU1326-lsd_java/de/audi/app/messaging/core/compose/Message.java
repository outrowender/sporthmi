/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.messaging.MessageDetails;

public final class Message {
    private final int hmiMessageId;
    private final int initialChangeId;
    private final int changeId;
    private final MessageDetails messageDetails;

    public Message(int n, int n2, int n3, MessageDetails messageDetails) {
        this.hmiMessageId = n;
        this.initialChangeId = n2;
        this.changeId = n3;
        this.messageDetails = messageDetails;
    }

    public int getHmiMessageId() {
        return this.hmiMessageId;
    }

    public int getInitialChangeId() {
        return this.initialChangeId;
    }

    public int getChangeId() {
        return this.changeId;
    }

    public MessageDetails getMessageDetails() {
        return this.messageDetails;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("Message {getHmiMessageId() = ");
        buffer.append(this.getHmiMessageId());
        buffer.append(", getInitialChangeId() = ");
        buffer.append(this.getInitialChangeId());
        buffer.append(", getChangeId() = ");
        buffer.append(this.getChangeId());
        buffer.append(", getMessageDetails().getMessageID() = ");
        buffer.append(this.getMessageDetails().getMessageID());
        buffer.append('}');
        return buffer.toString();
    }
}

