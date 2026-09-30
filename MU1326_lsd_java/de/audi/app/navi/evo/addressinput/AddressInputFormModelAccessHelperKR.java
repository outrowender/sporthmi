/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput;

import de.audi.app.navi.evo.di.AddressInputUtilEvo;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.interapp.locationaccessor.IMyLocationAccessor;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.DSIResponseContainer;
import de.audi.tghu.navi.app.details.GuiModelAccessDetailsNavi;
import de.audi.tghu.navi.app.di.AbstractAddressInputFormModelAccessHelper;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCityZipSequenceAsia;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputHouseNumberSequenceAsia;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputTownStreetSequence;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputVillageStreetSequence;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputWardSequence;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Map;
import org.dsi.ifc.global.NavLocation;

public class AddressInputFormModelAccessHelperKR
extends AbstractAddressInputFormModelAccessHelper {
    public AddressInputFormModelAccessHelperKR(NavigationEnv navigationEnv) {
        super(navigationEnv);
    }

    public void onUpdateLocation(NavigationEnv navigationEnv, LogChannel logChannel, NavLocation navLocation, Map map) {
        this.onUpdateLocation(navigationEnv, logChannel, null, navLocation, map);
        this.updateValueOfIsCityCenterSelected();
        this.updateValueOfIsWardCenterSelected();
        this.updateValueOfIsTownStreetCenterSelected();
        this.updateValueOfIsVillageStreetCenterSelected();
        this.updateValueOfIsHouseNumberCenterSelected();
    }

    public void onUpdateLocation(NavigationEnv navigationEnv, LogChannel logChannel, GuiModelAccessDetailsNavi guiModelAccessDetailsNavi, NavLocation navLocation, Map map) {
        logChannel.log(10000000, "%1#onUpdateLocation, with navLocation=%2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
        String string = iMyLocationAccessor.getState();
        String string2 = this.getCityWard(iMyLocationAccessor);
        String string3 = this.getTownVillageStreet(iMyLocationAccessor);
        String string4 = this.getHouseNumber(iMyLocationAccessor);
        boolean bl = this.getValueFromMap(map, "prefectureEnabled");
        boolean bl2 = this.getValueFromMap(map, "cityEnabled");
        boolean bl3 = this.getValueFromMap(map, "poiNameEnabled");
        boolean bl4 = this.getValueFromMap(map, "townStreetEnabled");
        boolean bl5 = this.getValueFromMap(map, "housenumberEnabled");
        logChannel.log(10000000, this.CLASS_NAME + "#onUpdateLocation, with provinceEnabled = %1, cityWardEnabled = %2, townStreetEnabled = %3, numberEnabled = %4", (Object)Boolean.toString(bl), (Object)Boolean.toString(bl2), (Object)Boolean.toString(bl4), (Object)Boolean.toString(bl5));
        logChannel.log(10000000, "%1#onUpdateLocation with facilityEnabled = %2", (Object)this.CLASS_NAME, (Object)Boolean.toString(bl3));
        if (Util.isEmpty(string) && !AddressInputUtilEvo.isInPOIRelatedContext(navigationEnv) && !navigationEnv.getInputModeManager().isSdsActive()) {
            String string5 = navigationEnv.getTranslatedText(403161);
            navigationEnv.getTextfieldModel(401735).setText1(string5);
        } else {
            navigationEnv.getTextfieldModel(401735).setText1(string);
        }
        navigationEnv.getTextfieldModel(401733).setText1(string2);
        navigationEnv.getTextfieldModel(401738).setText1(string3);
        navigationEnv.getTextfieldModel(401696).setText1(string4);
        navigationEnv.getChoiceModel(401731).setValue(bl ? 1 : 0);
        navigationEnv.getChoiceModel(401730).setValue(bl2 ? 1 : 0);
        navigationEnv.getChoiceModel(401695).setValue(bl3 ? 1 : 0);
        navigationEnv.getChoiceModel(401732).setValue(bl4 ? 1 : 0);
        navigationEnv.getChoiceModel(400171).setValue(bl5 ? 1 : 0);
        boolean bl6 = this.getValueFromMap(map, "routeGuidancePossible") && !Util.isEmpty(string);
        navigationEnv.getChoiceModel(400180).setValue(bl6 ? 1 : 0);
        int n = this.findCursorPositionForNavLocation(navigationEnv, logChannel, navLocation, map);
        if (Util.isEmpty(string) && !AddressInputUtilEvo.isInPOIRelatedContext(navigationEnv) && !navigationEnv.getInputModeManager().isSdsActive()) {
            n = 3;
        }
        logChannel.log(10000000, "%1#onUpdateLocation - nextCursorPosition will be = %2", (Object)this.CLASS_NAME, (long)n);
        navigationEnv.getMenuModel(401121).setFocusedItem(n, FocusAdvice.KEEP_POSITION, -1L);
        if (null != guiModelAccessDetailsNavi && bl6) {
            guiModelAccessDetailsNavi.onUpdateLocation(navLocation);
        }
        if (navLocation.isPositionValid()) {
            navigationEnv.getPropertyModel(401518).setProperties(698976777, new int[0]);
        } else {
            navigationEnv.getPropertyModel(401518).setProperties(-1, new int[0]);
        }
    }

    private String getCityWard(IMyLocationAccessor iMyLocationAccessor) {
        if (iMyLocationAccessor.isLocationInCityState()) {
            return "";
        }
        Buffer buffer = new Buffer();
        String string = iMyLocationAccessor.getTown();
        String string2 = iMyLocationAccessor.getWard();
        if (AddressInputCityZipSequenceAsia.isCityCenterSelected()) {
            buffer.append(this.env.getTranslatedText(403214));
        } else if (!Util.isEmpty(string) && !Util.isEmpty(string2)) {
            buffer.append(string);
            buffer.append(" ");
            buffer.append(string2);
        } else if (Util.isEmpty(string) && !Util.isEmpty(string2)) {
            buffer.append(string2);
        } else if (!Util.isEmpty(string) && Util.isEmpty(string2)) {
            buffer.append(string);
        }
        return buffer.toString();
    }

    private String getTownVillageStreet(IMyLocationAccessor iMyLocationAccessor) {
        Buffer buffer = new Buffer();
        String string = iMyLocationAccessor.getSubmunicipalTown();
        String string2 = iMyLocationAccessor.getVillage();
        String string3 = iMyLocationAccessor.getStreet();
        if (AddressInputTownStreetSequence.isTownStreetCenterSelected()) {
            buffer.append(this.env.getTranslatedText(403214));
        } else if (!Util.isEmpty(string)) {
            buffer.append(string);
            if (!Util.isEmpty(string2)) {
                buffer.append(" ");
                buffer.append(string2);
            }
            if (!Util.isEmpty(string3)) {
                buffer.append(" ");
                buffer.append(string3);
            }
        } else {
            buffer.append(string3);
        }
        return buffer.toString();
    }

    private String getHouseNumber(IMyLocationAccessor iMyLocationAccessor) {
        if (AddressInputHouseNumberSequenceAsia.isHouseNumberCenterSelected()) {
            return this.env.getTranslatedText(403214);
        }
        return iMyLocationAccessor.getHousenumber();
    }

    private int findCursorPositionForNavLocation(NavigationEnv navigationEnv, LogChannel logChannel, NavLocation navLocation, Map map) {
        if (AddressInputUtilEvo.isInPOIRelatedContext(navigationEnv)) {
            return this.findCursorPositionWithoutFacilityName(logChannel, navLocation, map);
        }
        return this.findCursorPositionWithFacilityName(logChannel, navLocation, map);
    }

    private int findCursorPositionWithoutFacilityName(LogChannel logChannel, NavLocation navLocation, Map map) {
        if (navLocation == null) {
            return 1;
        }
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
        String string = iMyLocationAccessor.getState();
        String string2 = this.getCityWard(iMyLocationAccessor);
        String string3 = this.getTownVillageStreet(iMyLocationAccessor);
        boolean bl = this.getValueFromMap(map, "cityEnabled");
        boolean bl2 = this.getValueFromMap(map, "townStreetEnabled");
        if (Util.isEmpty(string)) {
            return 1;
        }
        if (bl && (Util.isEmpty(string2) || this.focusOnWard())) {
            return 2;
        }
        if (bl2 && (Util.isEmpty(string3) || this.focusOnVillage())) {
            return 4;
        }
        return 6;
    }

    private int findCursorPositionWithFacilityName(LogChannel logChannel, NavLocation navLocation, Map map) {
        if (navLocation == null) {
            return 3;
        }
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
        String string = iMyLocationAccessor.getState();
        String string2 = this.getCityWard(iMyLocationAccessor);
        String string3 = this.getTownVillageStreet(iMyLocationAccessor);
        String string4 = this.getHouseNumber(iMyLocationAccessor);
        boolean bl = this.getValueFromMap(map, "cityEnabled");
        boolean bl2 = this.getValueFromMap(map, "poiNameEnabled");
        boolean bl3 = this.getValueFromMap(map, "townStreetEnabled");
        boolean bl4 = this.getValueFromMap(map, "housenumberEnabled");
        if (!(bl2 || bl3 || bl4 || bl || Util.isEmpty(string))) {
            return 6;
        }
        if (Util.isEmpty(string)) {
            return 1;
        }
        if (bl && (Util.isEmpty(string2) || this.focusOnWard())) {
            return 2;
        }
        if (AddressInputWardSequence.isWardCenterSelected() || AddressInputCityZipSequenceAsia.isCityCenterSelected()) {
            if (bl2) {
                return 3;
            }
            return 6;
        }
        if (bl3 && Util.isEmpty(string3)) {
            if (bl2 && !this.inputModeManager.isSdsActive()) {
                return 3;
            }
            return 4;
        }
        if (!Util.isEmpty(string3)) {
            if (this.focusOnVillage()) {
                return 4;
            }
            if (bl4 && Util.isEmpty(string4)) {
                return 5;
            }
            return 6;
        }
        if (bl4 && Util.isEmpty(string4)) {
            if (bl2 && !this.inputModeManager.isSdsActive()) {
                return 3;
            }
            return 5;
        }
        return 6;
    }

    private boolean focusOnWard() {
        if (this.inputModeManager.getSdsDestinationType() == 14) {
            return true;
        }
        DSIResponseContainer dSIResponseContainer = this.env.getContainer();
        return this.inputModeManager.isSdsActive() && dSIResponseContainer.selectionCriterionAvailable(152) && dSIResponseContainer.refinementCriterionAvailable(152);
    }

    private boolean focusOnVillage() {
        if (this.inputModeManager.getSdsDestinationType() == 15) {
            return true;
        }
        DSIResponseContainer dSIResponseContainer = this.env.getContainer();
        return this.inputModeManager.isSdsActive() && dSIResponseContainer.selectionCriterionAvailable(151) && dSIResponseContainer.refinementCriterionAvailable(151);
    }

    private void updateValueOfIsCityCenterSelected() {
        if (AddressInputCityZipSequenceAsia.isCityCenterSelected()) {
            AddressInputCityZipSequenceAsia.setIsCityCenterSelected(false);
        }
    }

    private void updateValueOfIsWardCenterSelected() {
        if (AddressInputWardSequence.isWardCenterSelected()) {
            AddressInputWardSequence.setIsWardCenterSelected(false);
        }
    }

    private void updateValueOfIsTownStreetCenterSelected() {
        if (AddressInputTownStreetSequence.isTownStreetCenterSelected()) {
            AddressInputTownStreetSequence.setIsTownStreetCenterSelected(false);
        }
    }

    private void updateValueOfIsVillageStreetCenterSelected() {
        if (AddressInputVillageStreetSequence.isVillageStreetCenterSelected()) {
            AddressInputVillageStreetSequence.setIsVillageStreetCenterSelected(false);
        }
    }

    private void updateValueOfIsHouseNumberCenterSelected() {
        if (AddressInputHouseNumberSequenceAsia.isHouseNumberCenterSelected()) {
            AddressInputHouseNumberSequenceAsia.setIsHouseNumberCenterSelected(false);
        }
    }
}

