/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.message;

import de.esolutions.fw.util.serializer.ISerializer;

public interface ICallMethodSerializeCallback {
    public void beginSerializeCallMethodPayload(short var1, short var2, ISerializer var3);

    public void endSerializeCallMethodPayload(short var1, short var2, ISerializer var3);
}

