/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.functions;

import de.vw.mib.bap.array.requests.BAPChangedArray;
import de.vw.mib.bap.array.requests.BAPStatusArray;
import de.vw.mib.bap.functions.Array;
import de.vw.mib.bap.functions.BAPFunctionListener;

public interface ArrayListener
extends BAPFunctionListener {
    public void statusArray(BAPStatusArray var1, Array var2);

    public void changedArray(BAPChangedArray var1, Array var2);
}

