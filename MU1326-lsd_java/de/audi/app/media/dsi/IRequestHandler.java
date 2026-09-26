/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi;

import de.audi.app.media.dsi.IRequestParameter;
import org.dsi.ifc.base.DSIBase;

public interface IRequestHandler {
    default public IRequestParameter dataResponded() {
    }

    default public void setDSI(DSIBase dSIBase) {
    }

    default public boolean request(IRequestParameter iRequestParameter) {
    }

    default public void discard(int n) {
    }

    default public boolean isRequestRunning(IRequestParameter iRequestParameter) {
    }

    default public void reset() {
    }
}

