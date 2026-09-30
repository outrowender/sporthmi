/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.comp;

import de.audi.app.car.common.comp.CarDSIAttributesSet;
import org.dsi.ifc.base.DSIBase;

public interface ICarComponent {
    public static final int LOG_CHANNEL_TYPE_DEFAULT = 0;
    public static final int LOG_CHANNEL_TYPE_DSI = 1;
    public static final int LOG_CHANNEL_TYPE_MSC = 2;
    public static final int LOG_CHANNEL_TYPE_FREQUENT = 3;

    public void init();

    public void deinit();

    public void setSimulatedDSI(DSIBase var1);

    public int getID();

    public String getName();

    public CarDSIAttributesSet[] getDSIAttributesSets();

    public String getCurrentViewOptions();
}

