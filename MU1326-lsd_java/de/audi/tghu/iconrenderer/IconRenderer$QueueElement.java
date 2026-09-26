/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.iconrenderer;

import de.audi.atip.interapp.icon.RenderingInfo;
import de.audi.tghu.iconrenderer.IconRenderer;
import de.audi.tghu.iconrenderer.IconRenderer$1;
import de.audi.tghu.iconrenderer.IconRenderer$RequestQueue;

abstract class IconRenderer$QueueElement {
    protected IconRenderer$RequestQueue queue;
    protected int requestType;
    private boolean responseReceived = false;
    private RenderingInfo renderingInfo;
    private final /* synthetic */ IconRenderer this$0;

    private IconRenderer$QueueElement(IconRenderer iconRenderer, int n) {
        this.this$0 = iconRenderer;
        this.requestType = n;
    }

    private int getRequestType() {
        return this.requestType;
    }

    void setQueue(IconRenderer$RequestQueue iconRenderer$RequestQueue) {
        this.queue = iconRenderer$RequestQueue;
    }

    synchronized RenderingInfo waitForResponse() {
        IconRenderer.access$300(this.this$0).log(-2137614336, "[IconRenderer#QueueElement#waitForResponse] called");
        while (!this.responseReceived) {
            try {
                IconRenderer.access$300(this.this$0).log(-2137614336, "[IconRenderer#QueueElement#waitForResponse] Wait...");
                long l = System.currentTimeMillis();
                super.wait(0);
                long l2 = System.currentTimeMillis();
                if (this.responseReceived) continue;
                IconRenderer.access$300(this.this$0).log(-2137614336, "[IconRenderer#QueueElement#waitForResponse] Timeout, time: %1", l2 - l);
                if (this.queue == null) break;
                this.queue.dequeue(null, false);
                break;
            }
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
        if (this.renderingInfo != null) {
            this.putIntoCache(this.renderingInfo);
        }
        return this.renderingInfo;
    }

    protected abstract void putIntoCache(RenderingInfo renderingInfo) {
    }

    synchronized void setRenderingInfo(RenderingInfo renderingInfo, boolean bl) {
        IconRenderer.access$300(this.this$0).log(-2137614336, "[IconRenderer#QueueElement#setRenderingInfo] called");
        this.renderingInfo = renderingInfo;
        this.responseReceived = bl;
        super.notifyAll();
        IconRenderer.access$300(this.this$0).log(-2137614336, "[IconRenderer#QueueElement#setRenderingInfo] Notify");
    }

    static /* synthetic */ int access$400(IconRenderer$QueueElement iconRenderer$QueueElement) {
        return iconRenderer$QueueElement.getRequestType();
    }

    /* synthetic */ IconRenderer$QueueElement(IconRenderer iconRenderer, int n, IconRenderer$1 iconRenderer$1) {
        this(iconRenderer, n);
    }
}

