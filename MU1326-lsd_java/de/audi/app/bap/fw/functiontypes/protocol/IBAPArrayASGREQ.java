/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes.protocol;

import de.vw.mib.bap.requests.GetArray;
import de.vw.mib.bap.requests.SetGetArray;

public interface IBAPArrayASGREQ {
    default public void getArrayREQ(GetArray getArray) {
    }

    default public void setGetArrayREQ(SetGetArray setGetArray) {
    }

    default public void setArrayREQ(SetGetArray setGetArray) {
    }

    default public void ackArrayREQ() {
    }
}

