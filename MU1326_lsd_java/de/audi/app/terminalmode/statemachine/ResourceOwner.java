/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.statemachine;

import de.audi.app.terminalmode.util.Enum;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class ResourceOwner
extends Enum<ResourceOwner> {
    public static final ResourceOwner DEVICE = new ResourceOwner(0, "DEVICE");
    public static final ResourceOwner MAINUNIT = new ResourceOwner(1, "MAINUNIT");

    protected ResourceOwner(int n, String string) {
        super(n, string);
    }
}

