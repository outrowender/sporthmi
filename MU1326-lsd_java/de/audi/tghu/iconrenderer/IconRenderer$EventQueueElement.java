/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.iconrenderer;

import de.audi.atip.interapp.icon.RenderingInfo;
import de.audi.tghu.iconrenderer.IconRenderer;
import de.audi.tghu.iconrenderer.IconRenderer$QueueElement;
import de.esolutions.fw.util.commons.Buffer;

class IconRenderer$EventQueueElement
extends IconRenderer$QueueElement {
    private int iconId;
    private int subIndex;
    private final /* synthetic */ IconRenderer this$0;

    public IconRenderer$EventQueueElement(IconRenderer iconRenderer, int n, int n2, int n3) {
        this.this$0 = iconRenderer;
        super(iconRenderer, n, null);
        this.iconId = n2;
        this.subIndex = n3;
    }

    int getIconId() {
        return this.iconId;
    }

    int getSubIndex() {
        return this.subIndex;
    }

    @Override
    protected void putIntoCache(RenderingInfo renderingInfo) {
        IconRenderer.access$1000(this.this$0, this.iconId, this.subIndex, renderingInfo);
    }

    public String toString() {
        Buffer buffer = new Buffer(80);
        buffer.append('[');
        buffer.append("request type: ");
        buffer.append(this.requestType);
        buffer.append("icon id: ");
        buffer.append(this.iconId);
        buffer.append("sub index: ");
        buffer.append(this.subIndex);
        buffer.append(']');
        return buffer.toString();
    }
}

