/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.remotehmi.util.LogAppender;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService$20;
import de.esolutions.fw.util.commons.Buffer;

class RemoteHMIService$20$1
implements LogAppender {
    private final /* synthetic */ RemoteHMIService$20 this$1;

    RemoteHMIService$20$1(RemoteHMIService$20 remoteHMIService$20) {
        this.this$1 = remoteHMIService$20;
    }

    @Override
    public void appendTo(Buffer buffer) {
        buffer.append("Contextname: ").append(RemoteHMIService$20.access$400(this.this$1));
    }

    @Override
    public int getEstimatedLength() {
        return 32;
    }
}

