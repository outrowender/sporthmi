/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.dsi;

import org.dsi.ifc.has.HASDataElement;

public class BinaryElement
extends HASDataElement {
    public BinaryElement(int n, byte[] byArray) {
        super(n, 5, 0L, null, 0.0, byArray, null);
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1400);
        stringBuffer.append("HASDataElement(elementId=");
        stringBuffer.append(this.elementId);
        stringBuffer.append(",binaryData[");
        if (this.binaryData != null) {
            stringBuffer.append(this.binaryData.length);
        }
        stringBuffer.append("]={");
        if (this.binaryData != null) {
            int n = this.binaryData.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.binaryData[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.binaryData);
        }
        stringBuffer.append("})");
        return stringBuffer.toString();
    }
}

