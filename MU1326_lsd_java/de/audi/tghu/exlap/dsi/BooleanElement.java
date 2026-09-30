/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.dsi;

import org.dsi.ifc.has.HASDataElement;

public class BooleanElement
extends HASDataElement {
    public BooleanElement(int n, boolean bl) {
        super(n, 4, 0L, null, 0.0, null, null);
        this.numericData = bl ? 1L : 0L;
    }

    public BooleanElement(int n, Boolean bl) {
        this(n, (boolean)bl);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1400);
        stringBuffer.append("HASDataElement(elementId=");
        stringBuffer.append(this.elementId);
        stringBuffer.append(",booleanData=");
        if (this.numericData == 1L) {
            stringBuffer.append("true");
        } else {
            stringBuffer.append("false");
        }
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

