/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.iconrenderer;

import de.audi.atip.interapp.icon.RenderingInfo;
import de.audi.tghu.iconrenderer.IconRenderer;
import de.audi.tghu.iconrenderer.IconRenderer$QueueElement;
import de.esolutions.fw.util.commons.Buffer;

class IconRenderer$RoadQueueElement
extends IconRenderer$QueueElement {
    private int iconReference;
    private int textLength;
    private final /* synthetic */ IconRenderer this$0;

    public IconRenderer$RoadQueueElement(IconRenderer iconRenderer, int n, int n2, int n3) {
        this.this$0 = iconRenderer;
        super(iconRenderer, n, null);
        this.iconReference = n2;
        this.textLength = n3;
    }

    int getIconReference() {
        return this.iconReference;
    }

    int getTextLength() {
        return this.textLength;
    }

    @Override
    protected void putIntoCache(RenderingInfo renderingInfo) {
        IconRenderer.access$1500(this.this$0, this.iconReference, this.textLength, renderingInfo);
    }

    public String toString() {
        Buffer buffer = new Buffer(80);
        buffer.append('[');
        buffer.append("request type: ");
        buffer.append(this.requestType);
        buffer.append("icon reference: ");
        buffer.append(this.iconReference);
        buffer.append("text length: ");
        buffer.append(this.textLength);
        buffer.append(']');
        return buffer.toString();
    }
}

