/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.fuelwarning;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.models.AbstractPoiScreenModelAccess;
import org.dsi.ifc.navigation.LIValueListElement;

public abstract class FuelWarningSequenceCoreModelAccess
extends AbstractPoiScreenModelAccess {
    protected final int FUEL_TYPE_CHOICE;

    public FuelWarningSequenceCoreModelAccess(NavigationEnv navigationEnv) {
        super(navigationEnv);
        this.FUEL_TYPE_CHOICE = 401031;
    }

    public void onElementSelected(LIValueListElement lIValueListElement) {
    }
}

