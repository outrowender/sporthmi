/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.fuelwarning;

import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.IPoiSpellerModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.FuelWarningWrapperSequence;
import de.audi.tghu.navi.app.details.IDetailsScreen;
import de.audi.tghu.navi.app.guidance.IVehicle;

public class FuelWarningWrapperSequenceEvo
extends FuelWarningWrapperSequence {
    public FuelWarningWrapperSequenceEvo(IPoiSpellerModelAccess iPoiSpellerModelAccess, IPoiSpellerModelAccess iPoiSpellerModelAccess2, ICommandListFactory iCommandListFactory, NavigationEnv navigationEnv, int n, IVehicle iVehicle, int n2, int n3, IPoiSpellerModelAccess iPoiSpellerModelAccess3, IDetailsScreen iDetailsScreen) {
        super(iPoiSpellerModelAccess, iPoiSpellerModelAccess2, iCommandListFactory, navigationEnv, n, iVehicle, n2, n3, iPoiSpellerModelAccess3, iDetailsScreen);
    }

    public void start() {
        int n = this.env.getContainer().isRgActive() ? 1 : 0;
        this.env.getChoiceModel(402577).setValue(n);
        super.start();
    }
}

