/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.array.fsg;

import de.vw.mib.bap.array.requests.BAPChangedArray;
import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.array.requests.BAPStatusArray;

public interface FsgArrayMessageBlockingTracker {
    public void reset();

    public boolean requestGetArray(BAPGetArray var1);

    public void reportChangedArray(BAPChangedArray var1);

    public void reportStatusArray(BAPStatusArray var1);

    public void requestAcknowledge();

    public void indicationError(int var1);
}

