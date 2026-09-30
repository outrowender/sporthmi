/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.dsi;

import org.dsi.ifc.base.DSIBase;

public interface IDSIController {
    public void setDSI(DSIBase var1);

    public DSIBase getDSI();

    public Class getDSIClass();

    public void deregisterDSI();
}

