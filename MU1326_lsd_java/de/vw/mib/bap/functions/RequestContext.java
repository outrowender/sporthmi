/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.functions;

import de.vw.mib.bap.datatypes.BAPEntity;

public interface RequestContext {
    public void status(BAPEntity var1);

    public void requestError(int var1);

    public RequestContext copy();
}

