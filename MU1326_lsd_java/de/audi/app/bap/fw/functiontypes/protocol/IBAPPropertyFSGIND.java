/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes.protocol;

import de.vw.mib.bap.requests.AckProperty;
import de.vw.mib.bap.requests.SetGetProperty;

public interface IBAPPropertyFSGIND {
    public void getIND();

    public void setGetIND(SetGetProperty var1);

    public void setIND(SetGetProperty var1);

    public void ackIND(AckProperty var1);
}

