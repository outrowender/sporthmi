/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.handler.business;

import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIBase;

public interface ModelEventBusiness {
    default public LogChannel getLogChannel() {
    }

    default public DSIBase getDSI() {
    }
}

