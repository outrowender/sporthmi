/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi;

import de.audi.app.terminalmode.util.Enum;

public class IResource$OwnershipType
extends Enum {
    public static final IResource$OwnershipType UNSPECIFIED = new IResource$OwnershipType("UNSPECIFIED");
    public static final IResource$OwnershipType BORROW = new IResource$OwnershipType("BORROW");
    public static final IResource$OwnershipType TAKE = new IResource$OwnershipType("TAKE");

    protected IResource$OwnershipType(String string) {
        super(string);
    }
}

