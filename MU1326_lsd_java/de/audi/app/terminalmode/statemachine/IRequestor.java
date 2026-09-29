/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.statemachine;

import de.audi.app.terminalmode.util.Enum;

public class IRequestor
extends Enum {
    public static final IRequestor MAINUNIT = new IRequestor("MAINUNIT");
    public static final IRequestor DEVICE = new IRequestor("DEVICE");
    public static final IRequestor DEVICE_WHILE_DISCONNECTING = new IRequestor("DEVICE_WHILE_DISCONNECTING");

    protected IRequestor(String string) {
        super(string);
    }
}

