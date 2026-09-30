/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.aircondition;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.aircondition.AbstractAirconInterappComponent;
import org.dsi.ifc.caraircondition.AirconMasterViewOptions;

public class AirconInterappComponentEvo
extends AbstractAirconInterappComponent {
    public AirconInterappComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    public int getID() {
        return 54;
    }

    protected void initModels() {
    }

    protected void deinitModels() {
    }

    protected void initVisibility() {
    }

    protected void deinitVisibility() {
    }

    protected void updateMenuEntryVisibility(AirconMasterViewOptions airconMasterViewOptions) {
    }
}

