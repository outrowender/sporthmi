/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.readout;

import de.esolutions.fw.util.commons.Buffer;

final class EvoTemplateProperties {
    private final MessageType messageType;
    private final MessageStatus messageStatus;
    private final Bool hasContact;
    private final Bool hasTimestamp;
    private final Bool hasSubject;
    private final int hashCode;

    EvoTemplateProperties(MessageType messageType, MessageStatus messageStatus, Bool bool, Bool bool2, Bool bool3) {
        this.messageType = messageType;
        this.messageStatus = messageStatus;
        this.hasContact = bool;
        this.hasTimestamp = bool2;
        this.hasSubject = bool3;
        this.hashCode = 0;
    }

    public boolean equals(Object object) {
        boolean bl = false;
        try {
            EvoTemplateProperties evoTemplateProperties = (EvoTemplateProperties)object;
            boolean bl2 = this.messageType == MessageType.IRRELEVANT || evoTemplateProperties.messageType == MessageType.IRRELEVANT;
            boolean bl3 = this.messageStatus == MessageStatus.IRRELEVANT || evoTemplateProperties.messageStatus == MessageStatus.IRRELEVANT;
            boolean bl4 = this.hasContact == Bool.IRRELEVANT || evoTemplateProperties.hasContact == Bool.IRRELEVANT;
            boolean bl5 = this.hasTimestamp == Bool.IRRELEVANT || evoTemplateProperties.hasTimestamp == Bool.IRRELEVANT;
            boolean bl6 = this.hasSubject == Bool.IRRELEVANT || evoTemplateProperties.hasSubject == Bool.IRRELEVANT;
            bl = !(!bl2 && this.messageType != evoTemplateProperties.messageType || !bl3 && this.messageStatus != evoTemplateProperties.messageStatus || !bl4 && this.hasContact != evoTemplateProperties.hasContact || !bl5 && this.hasTimestamp != evoTemplateProperties.hasTimestamp || !bl6 && this.hasSubject != evoTemplateProperties.hasSubject);
        }
        catch (Exception exception) {
            bl = false;
        }
        return bl;
    }

    public int hashCode() {
        return this.hashCode;
    }

    public String toString() {
        Buffer buffer = new Buffer(256);
        buffer.append("EvoTemplateProperties {messageType = ");
        buffer.append(this.messageType);
        buffer.append(", messageStatus = ");
        buffer.append(this.messageStatus);
        buffer.append(", hasContact = ");
        buffer.append(this.hasContact);
        buffer.append(", hasTimestamp = ");
        buffer.append(this.hasTimestamp);
        buffer.append(", hasSubject = ");
        buffer.append(this.hasSubject);
        buffer.append(", hashCode = ");
        buffer.append(this.hashCode);
        buffer.append('}');
        return buffer.toString();
    }

    static final class Bool {
        static final Bool IRRELEVANT = new Bool("IRRELEVANT");
        static final Bool FALSE = new Bool("FALSE");
        static final Bool TRUE = new Bool("TRUE");
        private final String name;

        private Bool(String string) {
            this.name = string;
        }

        public String toString() {
            return this.name;
        }
    }

    static final class MessageType {
        static final MessageType IRRELEVANT = new MessageType("IRRELEVANT");
        static final MessageType SMS = new MessageType("SMS");
        static final MessageType EMAIL = new MessageType("EMAIL");
        private final String name;

        private MessageType(String string) {
            this.name = string;
        }

        public String toString() {
            return this.name;
        }
    }

    static final class MessageStatus {
        static final MessageStatus IRRELEVANT = new MessageStatus("IRRELEVANT");
        static final MessageStatus RECEIVED = new MessageStatus("RECEIVED");
        static final MessageStatus SENT = new MessageStatus("SENT");
        static final MessageStatus DRAFT = new MessageStatus("DRAFT");
        static final MessageStatus OUTBOX = new MessageStatus("OUTBOX");
        private final String name;

        private MessageStatus(String string) {
            this.name = string;
        }

        public String toString() {
            return this.name;
        }
    }
}

