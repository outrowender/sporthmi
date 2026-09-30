/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.marshalling;

import de.vw.mib.bap.datatypes.BAPEntity;

public interface BAPIndicationMarshaller {
    public void resultEntity(int var1, BAPEntity var2);

    public void statusEntity(int var1, BAPEntity var2);

    public void changedEntity(int var1, BAPEntity var2);

    public void statusAckEntity(int var1, BAPEntity var2);

    public void error(int var1, int var2);
}

