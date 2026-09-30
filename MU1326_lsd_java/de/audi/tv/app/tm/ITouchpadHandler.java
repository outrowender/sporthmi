/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm;

interface ITouchpadHandler {
    public static final short VALUE_DO_NOTHING = -1;
    public static final short VALUE_FIRE_EVENT = -2;

    public short jsWest();

    public short jsEast();

    public short jsNorth();

    public short jsSouth();

    public short touchScreenPressed();

    public short touchScreenReleased();

    public short keyPressed();

    public short keyReleased();

    public short increment();

    public short decrement();
}

