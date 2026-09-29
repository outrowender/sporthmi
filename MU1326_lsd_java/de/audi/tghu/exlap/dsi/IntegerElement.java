/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.dsi;

import org.dsi.ifc.has.HASDataElement;

public class IntegerElement
extends HASDataElement {
    public IntegerElement(int n, int n2) {
        super(n, 0, n2, null, 0.0, null, null);
    }

    public IntegerElement(int n, Integer n2) {
        this(n, (int)n2);
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1400);
        stringBuffer.append("HASDataElement(elementId=");
        stringBuffer.append(this.elementId);
        stringBuffer.append(",integerData=");
        stringBuffer.append(this.numericData);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

