/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.iconrenderer;

import de.audi.atip.interapp.icon.RenderingInfo;
import de.audi.tghu.iconrenderer.IconRenderer;
import de.audi.tghu.iconrenderer.IconRenderer$QueueElement;
import de.esolutions.fw.util.commons.Buffer;

class IconRenderer$SatelliteMapsLogoQueueElement
extends IconRenderer$QueueElement {
    private int styleReference;
    private final /* synthetic */ IconRenderer this$0;

    public IconRenderer$SatelliteMapsLogoQueueElement(IconRenderer iconRenderer, int n, int n2) {
        this.this$0 = iconRenderer;
        super(iconRenderer, n, null);
        this.styleReference = n2;
    }

    int getStyleReference() {
        return this.styleReference;
    }

    @Override
    protected void putIntoCache(RenderingInfo renderingInfo) {
    }

    public String toString() {
        Buffer buffer = new Buffer(80);
        buffer.append('[');
        buffer.append("request type: ");
        buffer.append(this.requestType);
        buffer.append("style reference: ");
        buffer.append(this.styleReference);
        buffer.append(']');
        return buffer.toString();
    }
}

