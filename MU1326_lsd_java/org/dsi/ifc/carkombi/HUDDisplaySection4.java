/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

public class HUDDisplaySection4 {
    public boolean compass;
    public boolean nightvision;
    public boolean warnings;
    public boolean revolution;

    public HUDDisplaySection4() {
        this.compass = false;
        this.nightvision = false;
        this.warnings = false;
        this.revolution = false;
    }

    public HUDDisplaySection4(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.compass = bl;
        this.nightvision = bl2;
        this.warnings = bl3;
        this.revolution = bl4;
    }

    public boolean isCompass() {
        return this.compass;
    }

    public boolean isNightvision() {
        return this.nightvision;
    }

    public boolean isWarnings() {
        return this.warnings;
    }

    public boolean isRevolution() {
        return this.revolution;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("HUDDisplaySection4");
        stringBuffer.append('(');
        stringBuffer.append("compass");
        stringBuffer.append('=');
        stringBuffer.append(this.compass);
        stringBuffer.append(',');
        stringBuffer.append("nightvision");
        stringBuffer.append('=');
        stringBuffer.append(this.nightvision);
        stringBuffer.append(',');
        stringBuffer.append("warnings");
        stringBuffer.append('=');
        stringBuffer.append(this.warnings);
        stringBuffer.append(',');
        stringBuffer.append("revolution");
        stringBuffer.append('=');
        stringBuffer.append(this.revolution);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

