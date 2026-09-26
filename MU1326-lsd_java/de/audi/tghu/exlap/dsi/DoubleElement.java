/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.audi.tghu.exlap.dsi;

import org.dsi.ifc.has.HASDataElement;

public class DoubleElement
extends HASDataElement {
    public DoubleElement(int n, double d2) {
        super(n, 3, 0L, null, d2, null, null);
    }

    public DoubleElement(int n, Double d2) {
        this(n, (double)d2);
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1400);
        stringBuffer.append("HASDataElement(elementId=");
        stringBuffer.append(this.elementId);
        stringBuffer.append(",doubleData=");
        stringBuffer.append(this.doubleData);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

