/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.statemachine;

import de.audi.app.terminalmode.util.Enum;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class ApplicationOwner
extends Enum<ApplicationOwner> {
    public static final ApplicationOwner NOBODY = new ApplicationOwner(0, "NOBODY");
    public static final ApplicationOwner DEVICE = new ApplicationOwner(1, "DEVICE");
    public static final ApplicationOwner MAINUNIT = new ApplicationOwner(2, "MAINUNIT");

    protected ApplicationOwner(int n, String string) {
        super(n, string);
    }
}

