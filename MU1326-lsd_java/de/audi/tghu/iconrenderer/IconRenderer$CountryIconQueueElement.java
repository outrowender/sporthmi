/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.iconrenderer;

import de.audi.atip.interapp.icon.RenderingInfo;
import de.audi.tghu.iconrenderer.IconRenderer;
import de.audi.tghu.iconrenderer.IconRenderer$QueueElement;
import de.esolutions.fw.util.commons.Buffer;

class IconRenderer$CountryIconQueueElement
extends IconRenderer$QueueElement {
    private int iconId;
    private final /* synthetic */ IconRenderer this$0;

    public IconRenderer$CountryIconQueueElement(IconRenderer iconRenderer, int n, int n2) {
        this.this$0 = iconRenderer;
        super(iconRenderer, n, null);
        this.iconId = n2;
    }

    int getIconId() {
        return this.iconId;
    }

    @Override
    protected void putIntoCache(RenderingInfo renderingInfo) {
        IconRenderer.access$2000(this.this$0, this.iconId, renderingInfo);
    }

    public String toString() {
        Buffer buffer = new Buffer(80);
        buffer.append('[');
        buffer.append("request type: ");
        buffer.append(this.requestType);
        buffer.append("country icon ID: ");
        buffer.append(this.iconId);
        buffer.append(']');
        return buffer.toString();
    }
}

