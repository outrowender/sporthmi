/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.readout;

import de.audi.app.messaging.evo.readout.EvoTemplateProperties$Bool;
import de.audi.app.messaging.evo.readout.EvoTemplateProperties$MessageStatus;
import de.audi.app.messaging.evo.readout.EvoTemplateProperties$MessageType;
import de.esolutions.fw.util.commons.Buffer;

final class EvoTemplateProperties {
    private final EvoTemplateProperties$MessageType messageType;
    private final EvoTemplateProperties$MessageStatus messageStatus;
    private final EvoTemplateProperties$Bool hasContact;
    private final EvoTemplateProperties$Bool hasTimestamp;
    private final EvoTemplateProperties$Bool hasSubject;
    private final int hashCode;

    EvoTemplateProperties(EvoTemplateProperties$MessageType evoTemplateProperties$MessageType, EvoTemplateProperties$MessageStatus evoTemplateProperties$MessageStatus, EvoTemplateProperties$Bool evoTemplateProperties$Bool, EvoTemplateProperties$Bool evoTemplateProperties$Bool2, EvoTemplateProperties$Bool evoTemplateProperties$Bool3) {
        this.messageType = evoTemplateProperties$MessageType;
        this.messageStatus = evoTemplateProperties$MessageStatus;
        this.hasContact = evoTemplateProperties$Bool;
        this.hasTimestamp = evoTemplateProperties$Bool2;
        this.hasSubject = evoTemplateProperties$Bool3;
        this.hashCode = 0;
    }

    public boolean equals(Object object) {
        boolean bl = false;
        try {
            EvoTemplateProperties evoTemplateProperties = (EvoTemplateProperties)object;
            boolean bl2 = this.messageType == EvoTemplateProperties$MessageType.IRRELEVANT || evoTemplateProperties.messageType == EvoTemplateProperties$MessageType.IRRELEVANT;
            boolean bl3 = this.messageStatus == EvoTemplateProperties$MessageStatus.IRRELEVANT || evoTemplateProperties.messageStatus == EvoTemplateProperties$MessageStatus.IRRELEVANT;
            boolean bl4 = this.hasContact == EvoTemplateProperties$Bool.IRRELEVANT || evoTemplateProperties.hasContact == EvoTemplateProperties$Bool.IRRELEVANT;
            boolean bl5 = this.hasTimestamp == EvoTemplateProperties$Bool.IRRELEVANT || evoTemplateProperties.hasTimestamp == EvoTemplateProperties$Bool.IRRELEVANT;
            boolean bl6 = this.hasSubject == EvoTemplateProperties$Bool.IRRELEVANT || evoTemplateProperties.hasSubject == EvoTemplateProperties$Bool.IRRELEVANT;
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
}

