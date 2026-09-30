/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.display;

import de.esolutions.fw.util.commons.Buffer;

class ContextSetting {
    public static final byte DEFAULT_VALUE = 0;
    private final byte context;
    private final byte color;
    private final byte contrast;
    private final byte brightness;
    private final byte tint;

    public ContextSetting(byte by) {
        this.context = by;
        this.color = 0;
        this.contrast = 0;
        this.brightness = 0;
        this.tint = 0;
    }

    public ContextSetting(byte by, byte by2, byte by3, byte by4, byte by5) {
        this.context = by;
        this.color = by2;
        this.contrast = by3;
        this.brightness = by4;
        this.tint = by5;
    }

    public ContextSetting(byte by, byte[] byArray) {
        this.context = by;
        if (byArray.length == 4) {
            this.color = byArray[0];
            this.contrast = byArray[1];
            this.brightness = byArray[2];
            this.tint = byArray[3];
        } else {
            this.color = 0;
            this.contrast = 0;
            this.brightness = 0;
            this.tint = 0;
        }
    }

    public byte getContext() {
        return this.context;
    }

    public byte getColor() {
        return this.color;
    }

    public byte getContrast() {
        return this.contrast;
    }

    public byte getBrightness() {
        return this.brightness;
    }

    public byte getTint() {
        return this.tint;
    }

    public byte[] getDataArray() {
        return new byte[]{this.getColor(), this.getContrast(), this.getBrightness(), this.getTint()};
    }

    public String toString() {
        return new Buffer(100).append("[ContextSetting cl='").append(this.color).append("',ct='").append(this.contrast).append("',bg='").append(this.brightness).append("',tn='").append(this.tint).append("',@").append(this.hashCode()).append("]").toString();
    }
}

