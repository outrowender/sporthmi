/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.statemachine;

import de.audi.app.terminalmode.util.Enum;

public final class ResourceOwner
extends Enum {
    public static final ResourceOwner DEVICE = new ResourceOwner(0, "DEVICE");
    public static final ResourceOwner MAINUNIT = new ResourceOwner(1, "MAINUNIT");

    protected ResourceOwner(int n, String string) {
        super(n, string);
    }
}

