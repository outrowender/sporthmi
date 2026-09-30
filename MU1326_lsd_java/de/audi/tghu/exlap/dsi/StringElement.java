/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.dsi;

import org.dsi.ifc.has.HASDataElement;

public class StringElement
extends HASDataElement {
    public StringElement(int n, String string) {
        super(n, 2, 0L, string, 0.0, null, null);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1400);
        stringBuffer.append("HASDataElement(elementId=");
        stringBuffer.append(this.elementId);
        stringBuffer.append(",stringData=");
        stringBuffer.append(this.stringData);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

