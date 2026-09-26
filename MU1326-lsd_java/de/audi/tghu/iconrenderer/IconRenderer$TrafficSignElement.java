/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.iconrenderer;

import de.audi.atip.interapp.icon.RenderingInfo;
import de.audi.atip.interapp.icon.RenderingInfoProvider$TrafficSignCallback;
import de.audi.tghu.iconrenderer.IconRenderer;
import de.audi.tghu.iconrenderer.IconRenderer$1;
import de.audi.tghu.iconrenderer.IconRenderer$QueueElement;
import de.esolutions.fw.util.commons.Buffer;

class IconRenderer$TrafficSignElement
extends IconRenderer$QueueElement {
    private int signID;
    private int variant;
    private int size;
    private RenderingInfoProvider$TrafficSignCallback callback;
    private final /* synthetic */ IconRenderer this$0;

    private IconRenderer$TrafficSignElement(IconRenderer iconRenderer, int n, int n2, int n3, int n4) {
        this(iconRenderer, n, n2, n3, n4, (RenderingInfoProvider$TrafficSignCallback)null);
    }

    private IconRenderer$TrafficSignElement(IconRenderer iconRenderer, int n, int n2, int n3, RenderingInfoProvider$TrafficSignCallback renderingInfoProvider$TrafficSignCallback) {
        this(iconRenderer, n, n2, n3, 1, renderingInfoProvider$TrafficSignCallback);
    }

    private IconRenderer$TrafficSignElement(IconRenderer iconRenderer, int n, int n2, int n3, int n4, RenderingInfoProvider$TrafficSignCallback renderingInfoProvider$TrafficSignCallback) {
        this.this$0 = iconRenderer;
        super(iconRenderer, n, null);
        this.signID = n2;
        this.variant = n3;
        this.size = n4;
        this.callback = renderingInfoProvider$TrafficSignCallback;
    }

    private int getSignID() {
        return this.signID;
    }

    private int getVariant() {
        return this.variant;
    }

    private int getSize() {
        return this.size;
    }

    @Override
    protected void putIntoCache(RenderingInfo renderingInfo) {
        IconRenderer.access$1900(this.this$0, this.signID, this.variant, this.size, renderingInfo);
    }

    @Override
    synchronized void setRenderingInfo(RenderingInfo renderingInfo, boolean bl) {
        IconRenderer.access$300(this.this$0).log(-2137614336, "[TrafficSignElement#TrafficSignElement#setRenderingInfo] called");
        if (this.callback != null) {
            this.callback.renderingInfoReceived(this.signID, this.variant, renderingInfo);
        } else {
            super.setRenderingInfo(renderingInfo, bl);
        }
    }

    public String toString() {
        Buffer buffer = new Buffer(100);
        buffer.append('[');
        buffer.append("request type: ");
        buffer.append(this.requestType);
        buffer.append(", sign ID: ");
        buffer.append(this.signID);
        buffer.append(", variant index: ");
        buffer.append(this.variant);
        buffer.append(", icon size: ");
        buffer.append(this.size);
        buffer.append(']');
        return buffer.toString();
    }

    /* synthetic */ IconRenderer$TrafficSignElement(IconRenderer iconRenderer, int n, int n2, int n3, RenderingInfoProvider$TrafficSignCallback renderingInfoProvider$TrafficSignCallback, IconRenderer$1 iconRenderer$1) {
        this(iconRenderer, n, n2, n3, renderingInfoProvider$TrafficSignCallback);
    }

    /* synthetic */ IconRenderer$TrafficSignElement(IconRenderer iconRenderer, int n, int n2, int n3, int n4, IconRenderer$1 iconRenderer$1) {
        this(iconRenderer, n, n2, n3, n4);
    }

    static /* synthetic */ int access$600(IconRenderer$TrafficSignElement iconRenderer$TrafficSignElement) {
        return iconRenderer$TrafficSignElement.getSignID();
    }

    static /* synthetic */ int access$700(IconRenderer$TrafficSignElement iconRenderer$TrafficSignElement) {
        return iconRenderer$TrafficSignElement.getVariant();
    }

    static /* synthetic */ int access$800(IconRenderer$TrafficSignElement iconRenderer$TrafficSignElement) {
        return iconRenderer$TrafficSignElement.getSize();
    }
}

