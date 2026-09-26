/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.iconrenderer;

import de.audi.atip.interapp.icon.RenderingInfo;
import de.audi.tghu.iconrenderer.IconRenderer;
import de.audi.tghu.iconrenderer.IconRenderer$QueueElement;
import de.esolutions.fw.util.commons.Buffer;

class IconRenderer$AdditionalInfoIconQueueElement
extends IconRenderer$QueueElement {
    private int iconId;
    private int variant;
    private final /* synthetic */ IconRenderer this$0;

    public IconRenderer$AdditionalInfoIconQueueElement(IconRenderer iconRenderer, int n, int n2, int n3) {
        this.this$0 = iconRenderer;
        super(iconRenderer, n, null);
        this.iconId = n2;
        this.variant = n3;
    }

    int getIconId() {
        return this.iconId;
    }

    int getVariant() {
        return this.variant;
    }

    @Override
    protected void putIntoCache(RenderingInfo renderingInfo) {
        IconRenderer.access$1400(this.this$0, this.iconId, this.variant, renderingInfo);
    }

    public String toString() {
        Buffer buffer = new Buffer(80);
        buffer.append('[');
        buffer.append("request type: ");
        buffer.append(this.requestType);
        buffer.append("additional info icon ID: ");
        buffer.append(this.iconId);
        buffer.append("variant: ");
        buffer.append(this.variant);
        buffer.append(']');
        return buffer.toString();
    }
}

