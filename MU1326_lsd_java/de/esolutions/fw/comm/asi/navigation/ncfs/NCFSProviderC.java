/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.ncfs;

import de.esolutions.fw.comm.asi.navigation.ncfs.sBoundingBox;
import de.esolutions.fw.comm.core.method.MethodException;

public interface NCFSProviderC {
    public void requestVZORestrictions(sBoundingBox var1) throws MethodException;

    public void requestLGI(sBoundingBox var1) throws MethodException;
}

