/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm;

interface ITouchpadHandler {
    public static final short VALUE_DO_NOTHING;
    public static final short VALUE_FIRE_EVENT;

    default public short jsWest() {
    }

    default public short jsEast() {
    }

    default public short jsNorth() {
    }

    default public short jsSouth() {
    }

    default public short touchScreenPressed() {
    }

    default public short touchScreenReleased() {
    }

    default public short keyPressed() {
    }

    default public short keyReleased() {
    }

    default public short increment() {
    }

    default public short decrement() {
    }
}

