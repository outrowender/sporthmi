/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.commands.LISetCurrentLDCommand;
import de.audi.tghu.navi.app.addressinput.poi.IPoiSpellerModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultsGeneralInputSequence;
import de.audi.tghu.navi.app.details.IDetailsScreen;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueListElement;

public class PoiSpellerSearchInputSequence
extends PoiResultsGeneralInputSequence {
    public PoiSpellerSearchInputSequence(IPoiSpellerModelAccess iPoiSpellerModelAccess, ICommandListFactory iCommandListFactory, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv, LIValueListElement lIValueListElement, IVehicle iVehicle, IDetailsScreen iDetailsScreen) {
        super(iPoiSpellerModelAccess, iCommandListFactory, poiSearchArea, navigationEnv, lIValueListElement, iVehicle, false, iDetailsScreen);
    }

    public PoiSpellerSearchInputSequence(IPoiSpellerModelAccess iPoiSpellerModelAccess, ICommandListFactory iCommandListFactory, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv, LIValueListElement lIValueListElement, IVehicle iVehicle, boolean bl, IDetailsScreen iDetailsScreen) {
        super(iPoiSpellerModelAccess, iCommandListFactory, poiSearchArea, navigationEnv, lIValueListElement, iVehicle, bl, iDetailsScreen);
    }

    public void start() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new LISetCurrentLDCommand(this.getSpellerCountryLocation()));
        commandList.add(this.createStartSequence());
        commandList.execute("[PoiInput] PoiSpellerSearchInputSequence#start");
    }

    public void startSubstringSearch(IPoiSpellerModelAccess iPoiSpellerModelAccess) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.startSubstringSearch(iPoiSpellerModelAccess);
            return;
        }
        this.env.getLogChannel().log(10000000, "[PoiInput] AbstractPoiSequence( %1 )#startSubstringSearch()", (Object)this.getStringId());
        throw new UnsupportedOperationException("Cannot start a Substring Search Sequence from the current speller state.");
    }

    public void startBrands(IPoiSpellerModelAccess iPoiSpellerModelAccess) {
        if (this.hasActiveSubSequence()) {
            this.currentInputSequence.startBrands(iPoiSpellerModelAccess);
            return;
        }
        this.env.getLogChannel().log(10000000, "[PoiInput] AbstractPoiSequence( %1 )#startBrands()", (Object)this.getStringId());
        throw new UnsupportedOperationException("Cannot start brands sequence from the current speller state.");
    }

    private NavLocation getSpellerCountryLocation() {
        NavLocation navLocation = this.searchArea.getSearchContext() == 2 || this.searchArea.getSearchContext() == 3 ? this.searchArea.getLocation() : (this.searchArea.getSearchContext() == 0 || this.searchArea.getSearchContext() == 1 ? this.vehicle.getVehicleCountryLocation() : (this.searchArea.getSearchContext() == 4 ? this.searchArea.getLocation() : (this.searchArea.getSearchContext() == 5 ? this.searchArea.getLocation() : this.vehicle.getVehicleCountryLocation())));
        return this.transformLocationBySurrounding(navLocation);
    }

    protected String getStringId() {
        return "PoiSpellerSearchInputSequence";
    }

    private NavLocation transformLocationBySurrounding(NavLocation navLocation) {
        int n = navLocation.getLongitude();
        int n2 = navLocation.getLatitude();
        navLocation = Util.getLocationFromGeoPos(n, n2);
        return navLocation;
    }
}

