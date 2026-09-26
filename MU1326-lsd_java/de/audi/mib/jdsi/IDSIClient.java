/*
 * Decompiled with CFR 0.152.
 */
package de.audi.mib.jdsi;

import org.dsi.ifc.base.DSIBase;

public interface IDSIClient {
    default public void setDSI(DSIBase dSIBase) {
    }

    default public int[] getAutoNotifications() {
    }
}

