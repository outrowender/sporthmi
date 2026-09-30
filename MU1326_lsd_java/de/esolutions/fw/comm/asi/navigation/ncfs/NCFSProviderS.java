/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.ncfs;

import de.esolutions.fw.comm.asi.navigation.ncfs.NCFSProviderReply;
import de.esolutions.fw.comm.asi.navigation.ncfs.sBoundingBox;
import de.esolutions.fw.comm.core.method.MethodException;

public interface NCFSProviderS {
    public void requestVZORestrictions(sBoundingBox var1, NCFSProviderReply var2) throws MethodException;

    public void requestLGI(sBoundingBox var1, NCFSProviderReply var2) throws MethodException;
}

