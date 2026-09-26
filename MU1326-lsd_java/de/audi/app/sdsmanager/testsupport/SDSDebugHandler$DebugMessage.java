/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.testsupport;

import de.audi.app.sdsmanager.testsupport.SDSDebugChannelsEnum;
import de.audi.app.sdsmanager.testsupport.SDSDebugHandler;
import de.audi.app.sdsmanager.testsupport.SDSDebugHandler$1;
import de.esolutions.fw.util.commons.Buffer;

class SDSDebugHandler$DebugMessage {
    private final SDSDebugChannelsEnum chl;
    private final String msg;
    private final String msgCounterStr;

    private SDSDebugHandler$DebugMessage(String string, SDSDebugChannelsEnum sDSDebugChannelsEnum) {
        this.msg = string == null ? "" : string;
        this.chl = sDSDebugChannelsEnum == null ? SDSDebugChannelsEnum.DEFAULT : sDSDebugChannelsEnum;
        this.msgCounterStr = Integer.toString(SDSDebugHandler.access$008());
    }

    public String toString() {
        Buffer buffer = new Buffer().append('[').append(this.msgCounterStr).append('|').append(this.chl.getChannelName()).append("] ").append(this.msg);
        return buffer.toString();
    }

    /* synthetic */ SDSDebugHandler$DebugMessage(String string, SDSDebugChannelsEnum sDSDebugChannelsEnum, SDSDebugHandler$1 sDSDebugHandler$1) {
        this(string, sDSDebugChannelsEnum);
    }
}

