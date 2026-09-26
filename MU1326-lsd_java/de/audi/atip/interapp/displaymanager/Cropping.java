/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.displaymanager;

import de.esolutions.fw.util.commons.Buffer;

public class Cropping {
    public final int screenWidth;
    public final int screenHeight;
    public final int tgtX;
    public final int tgtY;
    public final int tgtWidth;
    public final int tgtHeight;
    private final Buffer label;

    Cropping(int n, int n2, int n3, int n4) {
        this.screenWidth = n3;
        this.screenHeight = n4;
        this.label = new Buffer().append(n).append(':').append(n2);
        float f2 = (float)n / (float)n2;
        float f3 = ((float)n3 - (float)n4 * f2) / 2.0f;
        float f4 = ((float)n4 - (float)n3 / f2) / 2.0f;
        float f5 = (float)n4 * f2;
        float f6 = (float)n3 / f2;
        this.tgtX = Math.max(0, (int)f3);
        this.tgtY = Math.max(0, (int)f4);
        this.tgtWidth = Math.min(n3, (int)f5);
        this.tgtHeight = Math.min(n4, (int)f6);
    }

    Cropping(int n, int n2) {
        this.screenWidth = n;
        this.screenHeight = n2;
        this.label = new Buffer().append(n).append(':').append(n2);
        this.tgtX = 0;
        this.tgtY = 0;
        this.tgtWidth = n;
        this.tgtHeight = n2;
    }

    Cropping(int n, int n2, int n3, int n4, int n5, int n6) {
        this.screenWidth = n3;
        this.screenHeight = n4;
        this.label = new Buffer().append(n).append(':').append(n2);
        float f2 = (float)n / (float)n2;
        float f3 = ((float)n3 - (float)n4 * f2) / 2.0f;
        float f4 = ((float)n4 - (float)n3 / f2) / 2.0f;
        float f5 = (float)n4 * f2;
        float f6 = (float)n3 / f2;
        this.tgtX = Math.max(0, (int)f3) + n5;
        this.tgtY = Math.max(0, (int)f4) + n6;
        this.tgtWidth = Math.min(n3, (int)f5);
        this.tgtHeight = Math.min(n4, (int)f6);
    }

    private Cropping(int n, int n2, int n3, int n4, int n5, int n6, Buffer buffer) {
        this.screenWidth = n;
        this.screenHeight = n2;
        this.tgtX = n3;
        this.tgtY = n4;
        this.tgtWidth = n5;
        this.tgtHeight = n6;
        this.label = buffer;
    }

    public String toString() {
        Buffer buffer = new Buffer(200);
        buffer.append(this.label);
        buffer.append(", tgtX:").append(this.tgtX);
        buffer.append(", tgtY:").append(this.tgtY);
        buffer.append(", tgtWidth:").append(this.tgtWidth);
        buffer.append(", tgtHeight:").append(this.tgtHeight);
        return buffer.toString();
    }

    public Cropping rightAlign(int n, int n2) {
        int n3 = this.screenWidth * n / 100;
        int n4 = n3 * 100 / this.tgtWidth;
        int n5 = this.tgtHeight * n4 / 100;
        int n6 = this.screenWidth - n3 - n2;
        int n7 = (this.screenHeight - n5) / 2;
        return new Cropping(this.screenWidth, this.screenHeight, n6, n7, n3, n5, this.label);
    }

    public Cropping leftAlign(int n, int n2) {
        int n3 = this.screenWidth * n / 100;
        int n4 = n3 * 100 / this.tgtWidth;
        int n5 = this.tgtHeight * n4 / 100;
        int n6 = n2;
        int n7 = (this.screenHeight - n5) / 2;
        return new Cropping(this.screenWidth, this.screenHeight, n6, n7, n3, n5, this.label);
    }

    public Cropping fixed(int n, int n2, int n3, int n4) {
        return new Cropping(this.screenWidth, this.screenHeight, n, n2, n3, n4, this.label);
    }
}

