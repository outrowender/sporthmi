/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.storage;

import de.audi.atip.storage.NoSuchDataException;

public class ValueMissingException
extends NoSuchDataException {
    private static final long serialVersionUID = -2529189574871616004L;

    public ValueMissingException(int n, int n2) {
        super(n, n2, "Value missing!");
    }
}

