/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.navi.data;

public final class CombiBAPNaviManeuverDescriptor {
    public int mainElement;
    public int direction;
    public int zLevelGuidance;
    public byte[] sideStreets;

    public CombiBAPNaviManeuverDescriptor() {
        this.mainElement = 0;
        this.direction = 0;
        this.zLevelGuidance = 0;
        this.sideStreets = null;
    }

    public CombiBAPNaviManeuverDescriptor(int n, int n2, int n3, byte[] byArray) {
        this.mainElement = n;
        this.direction = n2;
        this.zLevelGuidance = n3;
        this.sideStreets = byArray;
    }

    public int getMainElement() {
        return this.mainElement;
    }

    public int getDirection() {
        return this.direction;
    }

    public int getZLevelGuidance() {
        return this.zLevelGuidance;
    }

    public byte[] getSideStreets() {
        return this.sideStreets;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("CombiBAPManeuverDescriptor {mainElement=");
        stringBuffer.append(this.mainElement);
        stringBuffer.append(", direction=");
        stringBuffer.append(this.direction);
        stringBuffer.append(", zLevelGuidance=");
        stringBuffer.append(this.zLevelGuidance);
        stringBuffer.append(", sideStreets");
        if (this.sideStreets != null) {
            stringBuffer.append('[');
            stringBuffer.append(this.sideStreets.length);
            stringBuffer.append("]={");
            for (int i2 = 0; i2 < this.sideStreets.length; ++i2) {
                stringBuffer.append(this.sideStreets[i2]);
                if (i2 >= this.sideStreets.length - 1) continue;
                stringBuffer.append(',');
            }
            stringBuffer.append('}');
        } else {
            stringBuffer.append("=null");
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}

