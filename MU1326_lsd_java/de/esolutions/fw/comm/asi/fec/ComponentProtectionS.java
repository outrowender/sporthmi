/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec;

import de.esolutions.fw.comm.asi.fec.ComponentProtectionReply;
import de.esolutions.fw.comm.core.method.MethodException;

public interface ComponentProtectionS {
    public void authString(String var1, int var2, int var3, ComponentProtectionReply var4) throws MethodException;
}

