/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.sound;

public class SoundShapeValue {
    public int x;
    public int y;
    public int z;

    public int getX() {
        return this.x;
    }

    public void setX(int n) {
        this.x = n;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int n) {
        this.y = n;
    }

    public int getZ() {
        return this.z;
    }

    public void setZ(int n) {
        this.z = n;
    }

    public SoundShapeValue() {
    }

    public SoundShapeValue(int n, int n2, int n3) {
        this.x = n;
        this.y = n2;
        this.z = n3;
    }

    public String toString() {
        return new StringBuffer("SoundShapeValue{").append("x=").append(this.x).append(", y=").append(this.y).append(", z=").append(this.z).append("}").toString();
    }
}

