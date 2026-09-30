/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone;

import de.audi.app.terminalmode.util.Enum;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class SPIServiceState
extends Enum<SPIServiceState> {
    public static final SPIServiceState NOT_STARTED = new SPIServiceState("NOT_STARTED");
    public static final SPIServiceState STARTING = new SPIServiceState("STARTING");
    public static final SPIServiceState STARTED = new SPIServiceState("STARTED");

    protected SPIServiceState(String string) {
        super(string);
    }
}

