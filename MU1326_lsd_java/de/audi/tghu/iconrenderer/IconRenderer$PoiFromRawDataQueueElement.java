/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.iconrenderer;

import de.audi.atip.interapp.icon.RenderingInfo;
import de.audi.atip.interapp.icon.RenderingInfoProvider$PoiIconCallback;
import de.audi.tghu.iconrenderer.IconRenderer;
import de.audi.tghu.iconrenderer.IconRenderer$QueueElement;
import de.esolutions.fw.util.commons.Buffer;

class IconRenderer$PoiFromRawDataQueueElement
extends IconRenderer$QueueElement {
    private int countryCode;
    private int catReference;
    private RenderingInfoProvider$PoiIconCallback callback;
    private final /* synthetic */ IconRenderer this$0;

    public IconRenderer$PoiFromRawDataQueueElement(IconRenderer iconRenderer, int n, int n2, int n3, RenderingInfoProvider$PoiIconCallback renderingInfoProvider$PoiIconCallback) {
        this.this$0 = iconRenderer;
        super(iconRenderer, n, null);
        this.countryCode = n2;
        this.catReference = n3;
        this.callback = renderingInfoProvider$PoiIconCallback;
    }

    int getCountryCode() {
        return this.countryCode;
    }

    int getCatReference() {
        return this.catReference;
    }

    @Override
    protected void putIntoCache(RenderingInfo renderingInfo) {
        IconRenderer.access$1800(this.this$0, this.countryCode, this.catReference, renderingInfo);
    }

    @Override
    synchronized void setRenderingInfo(RenderingInfo renderingInfo, boolean bl) {
        IconRenderer.access$300(this.this$0).log(-2137614336, "[IconRenderer#PoiQueueElement#setRenderingInfo] called");
        if (this.callback != null) {
            this.callback.renderingInfoReceived(this.countryCode, this.catReference, renderingInfo);
        } else {
            super.setRenderingInfo(renderingInfo, bl);
        }
    }

    public String toString() {
        Buffer buffer = new Buffer(80);
        buffer.append('[');
        buffer.append("request type: ");
        buffer.append(this.requestType);
        buffer.append("countryCode: ");
        buffer.append(this.countryCode);
        buffer.append("catReference: ");
        buffer.append(this.catReference);
        buffer.append(']');
        return buffer.toString();
    }
}

