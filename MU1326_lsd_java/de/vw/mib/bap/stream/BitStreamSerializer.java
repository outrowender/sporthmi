/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.stream;

import de.vw.mib.bap.stream.BitStream;

public interface BitStreamSerializer {
    public void serialize(BitStream var1);

    public void deserialize(BitStream var1);

    public int bitSize();
}

