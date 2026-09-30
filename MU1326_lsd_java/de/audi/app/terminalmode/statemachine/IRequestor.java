/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.statemachine;

import de.audi.app.terminalmode.util.Enum;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class IRequestor
extends Enum<IRequestor> {
    public static final IRequestor MAINUNIT = new IRequestor("MAINUNIT");
    public static final IRequestor DEVICE = new IRequestor("DEVICE");
    public static final IRequestor DEVICE_WHILE_DISCONNECTING = new IRequestor("DEVICE_WHILE_DISCONNECTING");

    protected IRequestor(String string) {
        super(string);
    }
}

