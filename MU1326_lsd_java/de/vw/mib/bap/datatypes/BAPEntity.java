/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.datatypes;

import de.vw.mib.bap.stream.BitStreamSerializer;

public interface BAPEntity
extends BitStreamSerializer {
    public void reset();

    public boolean equalTo(BAPEntity var1);

    public String toString();
}

