/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.dsi;

import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.has.HASDataElement;

public class ResourceElement
extends HASDataElement {
    private static final String INVALID_PREFIX;

    public ResourceElement(int n, ResourceLocator resourceLocator) {
        super(n, 6, 0L, null, 0.0, null, resourceLocator);
        if (resourceLocator != null && resourceLocator.getUrl() != null && resourceLocator.getUrl().startsWith("file://")) {
            this.resourceLocator = new ResourceLocator(resourceLocator.getUrl().substring("file://".length()));
        }
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1400);
        stringBuffer.append("HASDataElement(elementId=");
        stringBuffer.append(this.elementId);
        stringBuffer.append(",resourceData=");
        stringBuffer.append(this.resourceLocator);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

