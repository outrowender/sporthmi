/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.iconrenderer;

import de.audi.atip.interapp.icon.RenderingInfo;
import de.audi.atip.interapp.icon.RenderingInfoProvider$PoiIconCallback;
import de.audi.tghu.iconrenderer.IconRenderer;
import de.audi.tghu.iconrenderer.IconRenderer$QueueElement;
import de.esolutions.fw.util.commons.Buffer;

class IconRenderer$PoiQueueElement
extends IconRenderer$QueueElement {
    private int catNumber;
    private int subIndex;
    private RenderingInfoProvider$PoiIconCallback callback;
    private final /* synthetic */ IconRenderer this$0;

    public IconRenderer$PoiQueueElement(IconRenderer iconRenderer, int n, int n2, int n3, RenderingInfoProvider$PoiIconCallback renderingInfoProvider$PoiIconCallback) {
        this.this$0 = iconRenderer;
        super(iconRenderer, n, null);
        this.catNumber = n2;
        this.subIndex = n3;
        this.callback = renderingInfoProvider$PoiIconCallback;
    }

    int getCatNumber() {
        return this.catNumber;
    }

    int getSubIndex() {
        return this.subIndex;
    }

    @Override
    protected void putIntoCache(RenderingInfo renderingInfo) {
        IconRenderer.access$1700(this.this$0, this.catNumber, this.subIndex, renderingInfo);
    }

    @Override
    synchronized void setRenderingInfo(RenderingInfo renderingInfo, boolean bl) {
        IconRenderer.access$300(this.this$0).log(-2137614336, "[IconRenderer#PoiQueueElement#setRenderingInfo] called");
        if (this.callback != null) {
            this.callback.renderingInfoReceived(this.catNumber, this.subIndex, renderingInfo);
        } else {
            super.setRenderingInfo(renderingInfo, bl);
        }
    }

    public String toString() {
        Buffer buffer = new Buffer(80);
        buffer.append('[');
        buffer.append("request type: ");
        buffer.append(this.requestType);
        buffer.append("icon id: ");
        buffer.append(this.catNumber);
        buffer.append("sub index: ");
        buffer.append(this.subIndex);
        buffer.append(']');
        return buffer.toString();
    }
}

