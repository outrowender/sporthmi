/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.util.Enum;

public class TMDevice$ConnectionState
extends Enum {
    public static final TMDevice$ConnectionState INVALID = new TMDevice$ConnectionState("INVALID");
    public static final TMDevice$ConnectionState NOT_ATTACHED = new TMDevice$ConnectionState("NOT_ATTACHED");
    public static final TMDevice$ConnectionState ATTACHED = new TMDevice$ConnectionState("ATTACHED");
    public static final TMDevice$ConnectionState ACTIVATING = new TMDevice$ConnectionState("ACTIVATING");
    public static final TMDevice$ConnectionState ACTIVE = new TMDevice$ConnectionState("ACTIVE");
    public static final TMDevice$ConnectionState CONNECTED = new TMDevice$ConnectionState("CONNECTED");
    public static final TMDevice$ConnectionState CONNECTING = new TMDevice$ConnectionState("CONNECTING");

    private TMDevice$ConnectionState(String string) {
        super(string);
    }
}

