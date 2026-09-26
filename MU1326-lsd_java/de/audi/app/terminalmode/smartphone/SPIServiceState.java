/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone;

import de.audi.app.terminalmode.util.Enum;

public class SPIServiceState
extends Enum {
    public static final SPIServiceState NOT_STARTED = new SPIServiceState("NOT_STARTED");
    public static final SPIServiceState STARTING = new SPIServiceState("STARTING");
    public static final SPIServiceState STARTED = new SPIServiceState("STARTED");

    protected SPIServiceState(String string) {
        super(string);
    }
}

