/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.keyevents;

import de.audi.app.terminalmode.util.Enum;

public class Key
extends Enum {
    public static final Key DDS_SELECT = new Key("DDS_SELECT");
    public static final Key BACK = new Key("BACK");
    public static final Key SOFTKEY_EAST = new Key("SOFTKEY_EAST");
    public static final Key SOFTKEY_WEST = new Key("SOFTKEY_WEST");
    public static final Key SOFTKEY_NORTHWEST = new Key("SOFTKEY_NORTHWEST");
    public static final Key SOFTKEY_SOUTHWEST = new Key("SOFTKEY_SOUTHWEST");
    public static final Key SOFTKEY_NORTHEAST = new Key("SOFTKEY_NORTHEAST");
    public static final Key SOFTKEY_SOUTHEAST = new Key("SOFTKEY_SOUTHEAST");
    public static final Key JS_NORTH = new Key("JS_NORTH");
    public static final Key JS_SOUTH = new Key("JS_SOUTH");
    public static final Key JS_WEST = new Key("JS_WEST");
    public static final Key JS_EAST = new Key("JS_EAST");
    public static final Key JS_MIDDLE = new Key("JS_MIDDLE");

    public Key(String string) {
        super(string);
    }
}

