/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.miniser;

import de.esolutions.fw.util.commons.miniser.IMiniIntSerializer;

public interface IMiniIntDeserializer {
    public short retrieveShort(byte[] var1);

    public short retrieveShort(byte[] var1, int var2);

    public int retrieveUnsignedShort(byte[] var1);

    public int retrieveUnsignedShort(byte[] var1, int var2);

    public int retrieveInt(byte[] var1);

    public int retrieveInt(byte[] var1, int var2);

    public long retrieveUnsignedInt(byte[] var1);

    public long retrieveUnsignedInt(byte[] var1, int var2);

    public long retrieveLong(byte[] var1);

    public long retrieveLong(byte[] var1, int var2);

    public String getDescription();

    public IMiniIntSerializer createCompatibleSerializer();

    public IMiniIntDeserializer createCompatibleDeserializer();
}

