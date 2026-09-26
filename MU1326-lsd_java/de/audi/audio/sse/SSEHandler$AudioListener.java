/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sse;

import de.audi.audio.intra.DefaultAudioListener;
import de.audi.audio.sse.SSEHandler;
import de.audi.audio.sse.SSEHandler$1;

class SSEHandler$AudioListener
extends DefaultAudioListener {
    private final /* synthetic */ SSEHandler this$0;

    private SSEHandler$AudioListener(SSEHandler sSEHandler) {
        this.this$0 = sSEHandler;
    }

    @Override
    public void updateConnStatus(int n, int n2, int n3) {
        if (n == 100) {
            SSEHandler.access$200(this.this$0, n2);
        }
        if (n == 113) {
            SSEHandler.access$300(this.this$0, n2);
        }
        if (SSEHandler.access$400((SSEHandler)this.this$0).framework.getSysConst(4065) == 1) {
            if (n == 164) {
                SSEHandler.access$500(this.this$0, n, n2);
            }
            if (n == 163) {
                SSEHandler.access$600(this.this$0, n, n2);
            }
            if (n == 159 || n == 153) {
                SSEHandler.access$700(this.this$0, n, n2);
            }
        }
        if (n == 137) {
            SSEHandler.access$800(this.this$0, n2);
        }
    }

    /* synthetic */ SSEHandler$AudioListener(SSEHandler sSEHandler, SSEHandler$1 sSEHandler$1) {
        this(sSEHandler);
    }
}

