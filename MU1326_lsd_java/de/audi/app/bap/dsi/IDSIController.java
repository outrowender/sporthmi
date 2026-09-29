/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.dsi;

import org.dsi.ifc.base.DSIBase;

public interface IDSIController {
    default public void setDSI(DSIBase dSIBase) {
    }

    default public DSIBase getDSI() {
    }

    default public Class getDSIClass() {
    }

    default public void deregisterDSI() {
    }
}

