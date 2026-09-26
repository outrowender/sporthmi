/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes.protocol;

import de.vw.mib.bap.datatypes.BAPArray;
import de.vw.mib.bap.requests.GetArray;
import de.vw.mib.bap.requests.SetGetArray;

public interface IBAPArrayFSGIND {
    default public void setGetArrayIND(SetGetArray setGetArray) {
    }

    default public void setArrayIND(SetGetArray setGetArray) {
    }

    default public void getArrayIND(GetArray getArray) {
    }

    default public void ackArrayIND() {
    }

    default public void ackArrayIND(BAPArray bAPArray) {
    }
}

