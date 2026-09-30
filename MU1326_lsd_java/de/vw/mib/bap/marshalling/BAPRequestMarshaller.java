/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.marshalling;

import de.vw.mib.bap.datatypes.BAPEntity;

public interface BAPRequestMarshaller {
    public void startResult(int var1, BAPEntity var2);

    public void abortResult(int var1, BAPEntity var2);

    public void getEntity(int var1, BAPEntity var2);

    public void setGetEntity(int var1, BAPEntity var2);

    public void ackEntity(int var1, BAPEntity var2);

    public void writeHighLevelRetryError(int var1, int var2);
}

