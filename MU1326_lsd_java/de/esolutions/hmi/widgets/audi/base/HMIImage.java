/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.audi.atip.util.Util;

public class HMIImage {
    public static final int PIXEL_FORMAT_A8 = 0;
    public static final int PIXEL_FORMAT_RGB888 = 2;
    public static final int PIXEL_FORMAT_PALETTE = 3;
    public static final int PIXEL_FORMAT_LA88 = 4;
    public static final int PIXEL_FORMAT_RGBA8888 = 6;
    private int format;
    private String path;
    private final int flags;

    public HMIImage(String string, int n) {
        this.path = string;
        this.format = n;
        this.flags = 0;
    }

    public HMIImage(String string, int n, int n2) {
        this.path = string;
        this.format = n;
        this.flags = n2;
    }

    public int getFormat() {
        return this.format;
    }

    public String getPath() {
        return this.path;
    }

    public boolean getPreventRTLFlipFlag() {
        return (this.flags & 1) == 0;
    }

    public static int getNumBytesPerPixel(int n) {
        switch (n) {
            case 0: {
                return 1;
            }
            case 4: {
                return 2;
            }
            case 2: {
                return 3;
            }
        }
        return 4;
    }

    public String toString() {
        return this.path;
    }

    public int hashCode() {
        if (null != this.path) {
            return this.path.hashCode();
        }
        return super.hashCode();
    }

    public boolean equals(Object object) {
        if (object instanceof HMIImage) {
            return Util.equals(this.path, ((HMIImage)object).path);
        }
        return super.equals(object);
    }
}

