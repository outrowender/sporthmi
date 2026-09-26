/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sse;

import de.audi.audio.sse.SSEHandler;
import de.audi.audio.sse.SSEHandler$1;
import org.dsi.ifc.sse.DSISSEListener;

class SSEHandler$SSEListener
implements DSISSEListener {
    private final /* synthetic */ SSEHandler this$0;

    private SSEHandler$SSEListener(SSEHandler sSEHandler) {
        this.this$0 = sSEHandler;
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        SSEHandler.access$400((SSEHandler)this.this$0).lcDSI.log(10000, "[SSEHandler.asyncException] errorCode:%1 requestType:%2", (long)n, (long)n2);
    }

    @Override
    public void responseSetMode(int n) {
        SSEHandler.access$400((SSEHandler)this.this$0).lcDSI.log(-2137614336, "[SSEHandler.responseSetMode] replyCode:%1", (long)n);
    }

    @Override
    public void updateMode(int n, int n2) {
        SSEHandler.access$400((SSEHandler)this.this$0).lcDSI.log(-2137614336, "[SSEHandler.updateMode] mode:%1 validFlag:%2", (long)n, (long)n2);
    }

    @Override
    public void updateMicGainLevel(int n, int n2) {
        SSEHandler.access$400((SSEHandler)this.this$0).lcDSI.log(-2137614336, "[SSEHandler.updateMicGainLevel] micGainLevel:%1 validFlag:%2", (long)n, (long)n2);
    }

    @Override
    public void responseSetMicGainLevel(int n) {
        SSEHandler.access$400((SSEHandler)this.this$0).lcDSI.log(-2137614336, "[SSEHandler.responseSetMicGainLevel] replyCode:%1", (long)n);
    }

    @Override
    public void updateMicMuteState(int n, int n2) {
        SSEHandler.access$400((SSEHandler)this.this$0).lcDSI.log(-2137614336, "[SSEHandler.updateMicMuteState] micMuteState:%1 validFlag:%2", (long)n, (long)n2);
    }

    @Override
    public void responseSetMicMuteState(int n) {
        SSEHandler.access$400((SSEHandler)this.this$0).lcDSI.log(-2137614336, "[SSEHandler.responseSetMicMuteState] replyCode:%1", (long)n);
    }

    /* synthetic */ SSEHandler$SSEListener(SSEHandler sSEHandler, SSEHandler$1 sSEHandler$1) {
        this(sSEHandler);
    }
}

