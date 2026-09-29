/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi.fuelwarning;

import de.audi.app.navi.evo.addressinput.poi.fuelwarning.FuelWarningWrapperSequenceEvo;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.OperationManager;
import de.audi.tghu.navi.app.addressinput.poi.IPoiSpellerModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.fuelwarning.IFuelWarningModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.fuelwarning.PoiFuelWarningService;
import de.audi.tghu.navi.app.addressinput.poi.fuelwarning.PoiFuelWarningSetup;
import de.audi.tghu.navi.app.car.kombi.ICarKombiService;
import de.audi.tghu.navi.app.details.IDetailsScreen;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;

public class PoiFuelWarningServiceEvo
extends PoiFuelWarningService {
    public PoiFuelWarningServiceEvo(NavigationEnv navigationEnv, ICarKombiService iCarKombiService, IFuelWarningModelAccess iFuelWarningModelAccess, IRouteManager iRouteManager, PoiFuelWarningSetup poiFuelWarningSetup, ICommandListFactory iCommandListFactory, IVehicle iVehicle, OperationManager operationManager, IDetailsScreen iDetailsScreen) {
        super(navigationEnv, iCarKombiService, iFuelWarningModelAccess, iRouteManager, poiFuelWarningSetup, iCommandListFactory, iVehicle, operationManager, iDetailsScreen);
    }

    @Override
    public void preparePetrolStationSearch(IPoiSpellerModelAccess iPoiSpellerModelAccess, IPoiSpellerModelAccess iPoiSpellerModelAccess2, int n, int n2, IPoiSpellerModelAccess iPoiSpellerModelAccess3) {
        this.fuelWarningWrapperSequence = new FuelWarningWrapperSequenceEvo(iPoiSpellerModelAccess, iPoiSpellerModelAccess2, this.commandListFactory, this.env, this.pendingWarningCategory, this.vehicle, n, n2, iPoiSpellerModelAccess3, this.detailsScreen);
        this.fuelWarningWrapperSequence.start();
    }
}

