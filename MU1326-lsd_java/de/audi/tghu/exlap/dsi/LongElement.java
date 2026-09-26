/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.dsi;

import org.dsi.ifc.has.HASDataElement;

public class LongElement
extends HASDataElement {
    public LongElement(int n, long l) {
        super(n, 1, l, null, 0.0, null, null);
    }

    public LongElement(int n, Long l) {
        this(n, (long)l);
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1400);
        stringBuffer.append("HASDataElement(elementId=");
        stringBuffer.append(this.elementId);
        stringBuffer.append(",longData=");
        stringBuffer.append(this.numericData);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

