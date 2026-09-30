/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi;

import de.audi.app.media.dsi.IRequestParameter;
import org.dsi.ifc.base.DSIBase;

public interface IRequestHandler {
    public IRequestParameter dataResponded();

    public void setDSI(DSIBase var1);

    public boolean request(IRequestParameter var1);

    public void discard(int var1);

    public boolean isRequestRunning(IRequestParameter var1);

    public void reset();
}

