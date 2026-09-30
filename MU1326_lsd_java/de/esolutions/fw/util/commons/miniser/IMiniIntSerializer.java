/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.miniser;

import de.esolutions.fw.util.commons.miniser.IMiniIntDeserializer;

public interface IMiniIntSerializer {
    public void storeLong(long var1, byte[] var3);

    public void storeInt(int var1, byte[] var2);

    public void storeShort(short var1, byte[] var2);

    public void storeLong(long var1, byte[] var3, int var4);

    public void storeInt(int var1, byte[] var2, int var3);

    public void storeShort(short var1, byte[] var2, int var3);

    public String getDescription();

    public IMiniIntSerializer createCompatibleSerializer();

    public IMiniIntDeserializer createCompatibleDeserializer();
}

