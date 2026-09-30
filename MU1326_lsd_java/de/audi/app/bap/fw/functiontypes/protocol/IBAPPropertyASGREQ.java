/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes.protocol;

import de.vw.mib.bap.requests.AckProperty;
import de.vw.mib.bap.requests.SetGetProperty;

public interface IBAPPropertyASGREQ {
    public void getREQ();

    public void setGetREQ();

    public void setGetREQ(SetGetProperty var1);

    public void ackREQ(AckProperty var1);
}

