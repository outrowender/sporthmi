/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.indication;

public interface IBAPIndicationListener {
    public void processAcknowledge(int var1, int var2);

    public void processIndication(int var1, int var2, int var3, int var4);

    public void processIndicationByteSequence(int var1, int var2, byte[] var3);

    public void processIndicationVoid(int var1, int var2);

    public void processIndicationError(int var1, int var2);
}

