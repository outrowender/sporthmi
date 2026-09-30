/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.functions;

import de.vw.mib.bap.functions.BAPOperationState;

public interface FSGOperationState
extends BAPOperationState {
    public void setState(int var1);

    public void setHMISystemDependent(boolean var1);

    public boolean isSystemDependent();
}

