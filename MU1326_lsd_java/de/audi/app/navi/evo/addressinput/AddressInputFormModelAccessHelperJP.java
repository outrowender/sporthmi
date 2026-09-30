/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput;

import de.audi.app.navi.evo.di.AddressInputUtilEvo;
import de.audi.app.navi.evo.di.DIScreensEvo;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.interapp.locationaccessor.IMyLocationAccessor;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.DSIResponseContainer;
import de.audi.tghu.navi.app.details.GuiModelAccessDetailsNavi;
import de.audi.tghu.navi.app.di.AbstractAddressInputFormModelAccessHelper;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputChomeSequence;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCitySequenceJP;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCityZipSequenceAsia;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputHouseNumberSequenceAsia;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputPlacenameSequence;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputWardSequence;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import java.util.Map;
import org.dsi.ifc.global.NavLocation;

public class AddressInputFormModelAccessHelperJP
extends AbstractAddressInputFormModelAccessHelper {
    public AddressInputFormModelAccessHelperJP(NavigationEnv navigationEnv) {
        super(navigationEnv);
    }

    public void onUpdateLocation(NavigationEnv navigationEnv, LogChannel logChannel, NavLocation navLocation, Map map) {
        this.onUpdateLocation(navigationEnv, logChannel, null, navLocation, map);
        this.updateValueOfIsCityCenterSelected();
        this.updateValueOfIsWardCenterSelected();
        this.updateValueOfIsPlaceNameCenterSelected();
        this.updateValueOfIsChomeCenterSelected();
        this.updateValueOfIsHouseNumberCenterSelected();
    }

    public void onUpdateLocation(NavigationEnv navigationEnv, LogChannel logChannel, GuiModelAccessDetailsNavi guiModelAccessDetailsNavi, NavLocation navLocation, Map map) {
        logChannel.log(10000000, "%1#onUpdateLocation, with navLocation = %2 ", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
        String string = iMyLocationAccessor.getState();
        String string2 = this.getCityWard(iMyLocationAccessor);
        String string3 = this.getPlaceName(iMyLocationAccessor);
        String string4 = this.getChomeNumber(iMyLocationAccessor);
        logChannel.log(10000000, this.CLASS_NAME + "#onUpdateLocation, with prefecture = %1, city = %2, placeName = %3, chomeName = %4", (Object)string, (Object)string2, (Object)string3, (Object)string4);
        boolean bl = this.getValueFromMap(map, "prefectureEnabled");
        boolean bl2 = this.getValueFromMap(map, "cityEnabled");
        boolean bl3 = this.getValueFromMap(map, "poiNameEnabled");
        boolean bl4 = this.getValueFromMap(map, "placenameEnbaled");
        boolean bl5 = this.getValueFromMap(map, "chomeEnabled") || this.getValueFromMap(map, "housenumberEnabled");
        logChannel.log(10000000, this.CLASS_NAME + "#onUpdateLocation, with prefectureEnabled = %1, cityEnabled = %2, placenameEnabled = %3, chomeNumberEnabled = %4", (Object)Boolean.toString(bl), (Object)Boolean.toString(bl2), (Object)Boolean.toString(bl4), (Object)Boolean.toString(bl5));
        logChannel.log(10000000, "%1#onUpdateLocation with facilityEnabled = %2", (Object)this.CLASS_NAME, (Object)Boolean.toString(bl3));
        navigationEnv.getChoiceModel(401693).setValue(bl ? 1 : 0);
        navigationEnv.getChoiceModel(400177).setValue(bl2 ? 1 : 0);
        navigationEnv.getChoiceModel(401695).setValue(bl3 ? 1 : 0);
        navigationEnv.getChoiceModel(401694).setValue(bl4 ? 1 : 0);
        navigationEnv.getChoiceModel(401712).setValue(bl5 ? 1 : 0);
        boolean bl6 = this.getValueFromMap(map, "routeGuidancePossible") && !Util.isEmpty(string);
        navigationEnv.getChoiceModel(400180).setValue(bl6 ? 1 : 0);
        if (Util.isEmpty(string) && !AddressInputUtilEvo.isInPOIRelatedContext(navigationEnv) && !navigationEnv.getInputModeManager().isSdsActive()) {
            String string5 = navigationEnv.getTranslatedText(403161);
            navigationEnv.getTextfieldModel(401691).setText1(string5);
        } else {
            navigationEnv.getTextfieldModel(401691).setText1(string);
        }
        navigationEnv.getTextfieldModel(401166).setText1(string2);
        navigationEnv.getTextfieldModel(402575).setText1(string3);
        navigationEnv.getTextfieldModel(401696).setText1(string4);
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
        StringBuffer stringBuffer = new StringBuffer();
        String string = iMyLocationAccessor.getTown();
        String string2 = iMyLocationAccessor.getWard();
        if (AddressInputCityZipSequenceAsia.isCityCenterSelected()) {
            stringBuffer.append(this.env.getTranslatedText(403214));
        } else if (!Util.isEmpty(string) && !Util.isEmpty(string2)) {
            stringBuffer.append(string);
            stringBuffer.append(" ");
            stringBuffer.append(string2);
        } else if (Util.isEmpty(string) && !Util.isEmpty(string2)) {
            stringBuffer.append(string2);
        } else if (!Util.isEmpty(string) && Util.isEmpty(string2)) {
            stringBuffer.append(string);
        }
        return stringBuffer.toString();
    }

    private String getPlaceName(IMyLocationAccessor iMyLocationAccessor) {
        if (AddressInputPlacenameSequence.isPlaceNameCenterSelected()) {
            return this.env.getTranslatedText(403214);
        }
        return iMyLocationAccessor.getPlaceName();
    }

    private String getChomeNumber(IMyLocationAccessor iMyLocationAccessor) {
        StringBuffer stringBuffer = new StringBuffer();
        String string = iMyLocationAccessor.getChome();
        String string2 = iMyLocationAccessor.getHousenumber();
        if (AddressInputChomeSequence.isChomeCenterSelected() || AddressInputHouseNumberSequenceAsia.isHouseNumberCenterSelected() && (this.env.getChoiceModel(DIScreensEvo.getDiJpNeedsChome()).getValue() == 0 || Util.isEmpty(string))) {
            stringBuffer.append(this.env.getTranslatedText(403214));
        } else if (!Util.isEmpty(string) && !Util.isEmpty(string2)) {
            stringBuffer.append(string);
            stringBuffer.append(" ");
            stringBuffer.append(string2);
        } else if (Util.isEmpty(string) && !Util.isEmpty(string2)) {
            stringBuffer.append(string2);
        } else if (!Util.isEmpty(string) && Util.isEmpty(string2)) {
            stringBuffer.append(string);
        }
        return stringBuffer.toString();
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

    private void updateValueOfIsPlaceNameCenterSelected() {
        if (AddressInputPlacenameSequence.isPlaceNameCenterSelected()) {
            AddressInputPlacenameSequence.setIsPlaceNameCenterSelected(false);
        }
    }

    private void updateValueOfIsChomeCenterSelected() {
        if (AddressInputChomeSequence.isChomeCenterSelected()) {
            AddressInputChomeSequence.setIsChomeCenterSelected(false);
        }
    }

    private void updateValueOfIsHouseNumberCenterSelected() {
        if (AddressInputHouseNumberSequenceAsia.isHouseNumberCenterSelected()) {
            AddressInputHouseNumberSequenceAsia.setIsHouseNumberCenterSelected(false);
        }
    }

    private int findCursorPositionForNavLocation(NavigationEnv navigationEnv, LogChannel logChannel, NavLocation navLocation, Map map) {
        if (AddressInputUtilEvo.isRemoteHMIPOIContext(navigationEnv)) {
            return this.findCursorPositionInRemoteHMIContext(logChannel, navLocation);
        }
        if (AddressInputUtilEvo.isOnlineOrNormalPOIContext(navigationEnv)) {
            return this.findCursorPositionWithoutFacilityName(logChannel, navLocation, map);
        }
        return this.findCursorPositionWithFacilityName(logChannel, navLocation, map);
    }

    private int findCursorPositionInRemoteHMIContext(LogChannel logChannel, NavLocation navLocation) {
        logChannel.log(10000000, "%1#findCursorPositionInRemoteHMIContext()", (Object)this.CLASS_NAME);
        if (navLocation == null) {
            return 1;
        }
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
        String string = iMyLocationAccessor.getState();
        String string2 = this.getCityWard(iMyLocationAccessor);
        if (Util.isEmpty(string)) {
            return 1;
        }
        if (Util.isEmpty(string2)) {
            return 2;
        }
        return 6;
    }

    private int findCursorPositionWithoutFacilityName(LogChannel logChannel, NavLocation navLocation, Map map) {
        boolean bl;
        logChannel.log(10000000, "%1#findCursorPositionWithoutFacilityName()", (Object)this.CLASS_NAME);
        boolean bl2 = this.getValueFromMap(map, "placenameEnbaled");
        boolean bl3 = bl = this.getValueFromMap(map, "chomeEnabled") || this.getValueFromMap(map, "housenumberEnabled");
        if (navLocation == null) {
            return 1;
        }
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
        String string = iMyLocationAccessor.getState();
        String string2 = this.getCityWard(iMyLocationAccessor);
        String string3 = this.getPlaceName(iMyLocationAccessor);
        String string4 = this.getChomeNumber(iMyLocationAccessor);
        if (Util.isEmpty(string)) {
            return 1;
        }
        if (Util.isEmpty(string2) || this.focusOnWard()) {
            return 2;
        }
        if (bl2 && Util.isEmpty(string3)) {
            return 4;
        }
        if (bl && (Util.isEmpty(string4) || this.focusOnHouseNumber())) {
            return 5;
        }
        return 6;
    }

    private int findCursorPositionWithFacilityName(LogChannel logChannel, NavLocation navLocation, Map map) {
        logChannel.log(10000000, "%1#findCursorPositionWithFacilityName()", (Object)this.CLASS_NAME);
        boolean bl = this.getValueFromMap(map, "cityEnabled");
        boolean bl2 = this.getValueFromMap(map, "placenameEnbaled");
        boolean bl3 = this.getValueFromMap(map, "chomeEnabled") || this.getValueFromMap(map, "housenumberEnabled");
        boolean bl4 = this.getValueFromMap(map, "poiNameEnabled");
        if (navLocation == null) {
            return 1;
        }
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
        String string = iMyLocationAccessor.getState();
        String string2 = this.getCityWard(iMyLocationAccessor);
        String string3 = this.getPlaceName(iMyLocationAccessor);
        String string4 = this.getChomeNumber(iMyLocationAccessor);
        if (!(bl2 || bl3 || bl4 || bl || Util.isEmpty(string))) {
            return 6;
        }
        if (Util.isEmpty(string)) {
            return 1;
        }
        if (Util.isEmpty(string2) || this.focusOnWard()) {
            return 2;
        }
        if (AddressInputWardSequence.isWardCenterSelected() || AddressInputCitySequenceJP.isCityCenterSelected()) {
            if (bl4) {
                return 3;
            }
            return 6;
        }
        if (bl2 && Util.isEmpty(string3)) {
            if (bl3 && !Util.isEmpty(string4)) {
                return 6;
            }
            if (bl3 && !this.inputModeManager.isSdsActive()) {
                return 5;
            }
            if (bl4 && !this.inputModeManager.isSdsActive()) {
                return 3;
            }
            return 4;
        }
        if (!Util.isEmpty(string2) && !bl2 && !this.inputModeManager.isSdsActive() && Util.isEmpty(string4)) {
            return 3;
        }
        if (bl3 && (Util.isEmpty(string4) || this.focusOnHouseNumber())) {
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

    private boolean focusOnHouseNumber() {
        if (this.inputModeManager.getSdsDestinationType() == 3) {
            return true;
        }
        DSIResponseContainer dSIResponseContainer = this.env.getContainer();
        return this.inputModeManager.isSdsActive() && dSIResponseContainer.selectionCriterionAvailable(5) && dSIResponseContainer.refinementCriterionAvailable(5);
    }
}

