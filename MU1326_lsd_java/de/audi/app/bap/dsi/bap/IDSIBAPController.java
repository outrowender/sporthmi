/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.dsi.bap;

import de.audi.app.bap.dsi.IDSIController;

public interface IDSIBAPController
extends IDSIController {
    public boolean isDSIBAPAvailable();

    public void getBAPState(int var1);

    public void setHMIState(int var1, int var2);

    public void request(int var1, int var2, int var3, int var4, int var5);

    public void requestVoid(int var1, int var2, int var3);

    public void requestByteSequence(int var1, int var2, int var3, byte[] var4);

    public void requestError(int var1, int var2, int var3);
}

