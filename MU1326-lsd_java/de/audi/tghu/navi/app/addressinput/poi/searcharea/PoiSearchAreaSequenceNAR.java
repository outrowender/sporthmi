/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.searcharea;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.CityHistory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.IPoiSearchAreaModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiCountryInputSequenceNAR;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchAreaSequence;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.li.SpellerStack;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;

public class PoiSearchAreaSequenceNAR
extends PoiSearchAreaSequence {
    public PoiSearchAreaSequenceNAR(IPoiSearchAreaModelAccess iPoiSearchAreaModelAccess, SpellerStack spellerStack, PoiSearchArea poiSearchArea, ICommandListFactory iCommandListFactory, IVehicle iVehicle, NavigationEnv navigationEnv, CityHistory cityHistory, IRouteManager iRouteManager, IAddressInputForm iAddressInputForm, IPreviewMap iPreviewMap) {
        super(iPoiSearchAreaModelAccess, spellerStack, poiSearchArea, iCommandListFactory, iVehicle, navigationEnv, cityHistory, iRouteManager, iAddressInputForm, iPreviewMap);
    }

    @Override
    public void startCountryInputSequence(IMatchspellerModelAccess iMatchspellerModelAccess, boolean bl) {
        this.currentInputSequence = new PoiCountryInputSequenceNAR(iMatchspellerModelAccess, this.modelAccess, this.spellerStack, this.commandListFactory, this.tempSearchArea, this.addressInputForm, this.previewMap, this.env);
        this.currentInputSequence.start(bl);
    }

    @Override
    public void startCountryInputSequence(char c2, IMatchspellerModelAccess iMatchspellerModelAccess, boolean bl) {
        this.logChannel.log(-2137614336, "PoiSearchAreaSequenceNAR#startCountryInputSequence(latestChar=%1)", c2);
        PoiCountryInputSequenceNAR poiCountryInputSequenceNAR = new PoiCountryInputSequenceNAR(iMatchspellerModelAccess, this.modelAccess, this.spellerStack, this.commandListFactory, this.tempSearchArea, this.addressInputForm, this.previewMap, this.env);
        this.currentInputSequence = poiCountryInputSequenceNAR;
        poiCountryInputSequenceNAR.start(c2, bl);
    }
}

