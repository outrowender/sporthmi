/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.comp;

import de.audi.app.car.common.comp.CarDSIAttributesSet;
import org.dsi.ifc.base.DSIBase;

public interface ICarComponent {
    public static final int LOG_CHANNEL_TYPE_DEFAULT;
    public static final int LOG_CHANNEL_TYPE_DSI;
    public static final int LOG_CHANNEL_TYPE_MSC;
    public static final int LOG_CHANNEL_TYPE_FREQUENT;

    default public void init() {
    }

    default public void deinit() {
    }

    default public void setSimulatedDSI(DSIBase dSIBase) {
    }

    default public int getID() {
    }

    default public String getName() {
    }

    default public CarDSIAttributesSet[] getDSIAttributesSets() {
    }

    default public String getCurrentViewOptions() {
    }
}

