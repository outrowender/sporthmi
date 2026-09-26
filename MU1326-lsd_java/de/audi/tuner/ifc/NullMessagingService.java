/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.ifc;

import de.audi.atip.interapp.IMessagingService;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;

public class NullMessagingService
extends NullService
implements IMessagingService {
    public NullMessagingService(LogChannel logChannel) {
        super(logChannel, "NullMessagingService");
    }

    @Override
    public void composeMsgPresetRecipient(int n, long l, int n2) {
        this.log("composeMsgPresetRecipient");
    }

    @Override
    public void composeMsgPresetRecipient(int n, String string) {
        this.log("composeMsgPresetRecipient");
    }

    @Override
    public void composeMsgAttachVCard(int n, String string, long l) {
        this.log("composeMsgAttachVCard");
    }

    @Override
    public void composeMsgPresetRecipient(int n, long l, int n2, int n3) {
        this.log("composeMsgPresetRecipient");
    }
}

