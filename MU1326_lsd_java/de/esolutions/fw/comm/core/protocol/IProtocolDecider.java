/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.protocol;

import de.esolutions.fw.comm.core.protocol.IProtocolActions;

public interface IProtocolDecider {
    public boolean reportProtocolRole(boolean var1, short var2, Object var3);

    public boolean decideProtocolDrop(short var1, Object var2);

    public IProtocolActions setupProtocolActions(short var1, Object var2);
}

