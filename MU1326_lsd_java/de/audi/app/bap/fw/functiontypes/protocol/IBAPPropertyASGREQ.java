/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes.protocol;

import de.vw.mib.bap.requests.AckProperty;
import de.vw.mib.bap.requests.SetGetProperty;

public interface IBAPPropertyASGREQ {
    default public void getREQ() {
    }

    default public void setGetREQ() {
    }

    default public void setGetREQ(SetGetProperty setGetProperty) {
    }

    default public void ackREQ(AckProperty ackProperty) {
    }
}

