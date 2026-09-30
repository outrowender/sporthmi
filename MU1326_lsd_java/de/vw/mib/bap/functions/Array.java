/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.ArrayListener;
import de.vw.mib.bap.functions.BAPFunction;

public interface Array
extends BAPFunction {
    public void getArray(BAPEntity var1, ArrayListener var2);

    public void setGetArray(BAPEntity var1, ArrayListener var2);
}

