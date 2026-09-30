/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput;

import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.interapp.locationaccessor.IMyLocationAccessor;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.details.GuiModelAccessDetailsNavi;
import de.audi.tghu.navi.app.di.AbstractAddressInputFormModelAccessHelper;
import de.audi.tghu.navi.app.di.AddressInputUtil;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputHouseNumberSequenceAsia;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputStreetSequenceCN;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import java.util.Map;
import org.dsi.ifc.global.NavLocation;

public class AddressInputFormModelAccessHelperCN
extends AbstractAddressInputFormModelAccessHelper {
    public AddressInputFormModelAccessHelperCN(NavigationEnv navigationEnv) {
        super(navigationEnv);
    }

    public void onUpdateLocation(NavigationEnv navigationEnv, LogChannel logChannel, NavLocation navLocation, Map map) {
        this.onUpdateLocation(navigationEnv, logChannel, null, navLocation, map);
        this.updateValueOfIsStreetCenterSelected();
        this.updateValueOfIsHouseNumberCenterSelected();
    }

    public void onUpdateLocation(NavigationEnv navigationEnv, LogChannel logChannel, GuiModelAccessDetailsNavi guiModelAccessDetailsNavi, NavLocation navLocation, Map map) {
        if (logChannel.isDebug2()) {
            logChannel.log(100000000, "%1#onUpdateLocation with navLocation=%2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
        }
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
        String string = AddressInputUtil.formatCompleteCityNameAsia(navigationEnv, navLocation);
        String string2 = this.getStreetName(iMyLocationAccessor);
        String string3 = this.getHouseNumber(iMyLocationAccessor);
        String string4 = iMyLocationAccessor.getJunction();
        logChannel.log(10000000, this.CLASS_NAME + "#onUpdateLocation with" + " cityName=%1, streetName=%2, intersection=%3, houseNumber=%4", (Object)string, (Object)string2, (Object)string4, (Object)string3);
        boolean bl = this.getValueFromMap(map, "cityEnabled");
        boolean bl2 = this.getValueFromMap(map, "poiNameEnabled");
        boolean bl3 = this.getValueFromMap(map, "streetEnabled");
        boolean bl4 = this.getValueFromMap(map, "housenumberEnabled");
        boolean bl5 = this.getValueFromMap(map, "junctionEnabled");
        logChannel.log(10000000, this.CLASS_NAME + "#onUpdateLocation with cityEnabled=" + bl + ", locationNameEnabled=" + bl2 + ", streetEnabled=" + bl3 + ", housenumberEnabled=" + bl4 + ", junctionEnabled=" + bl5);
        navigationEnv.getTextfieldModel(401166).setText1(string);
        navigationEnv.getTextfieldModel(400874).setText1(string2);
        navigationEnv.getTextfieldModel(401186).setText1(string3);
        navigationEnv.getTextfieldModel(401173).setText1(string4);
        navigationEnv.getChoiceModel(400177).setValue(bl ? 1 : 0);
        navigationEnv.getChoiceModel(401682).setValue(bl2 ? 1 : 0);
        navigationEnv.getChoiceModel(400175).setValue(bl3 ? 1 : 0);
        navigationEnv.getChoiceModel(400167).setValue(bl5 ? 1 : 0);
        navigationEnv.getChoiceModel(400171).setValue(bl4 ? 1 : 0);
        boolean bl6 = this.getValueFromMap(map, "routeGuidancePossible") && !Util.isEmpty(string);
        navigationEnv.getChoiceModel(400180).setValue(bl6 ? 1 : 0);
        int n = this.findCursorPositionForNavLocation(logChannel, navLocation, map);
        if (logChannel.isDebug2()) {
            logChannel.log(100000000, "%1#onUpdateLocation - nextCursorPosition will be = %2", (Object)this.CLASS_NAME, (long)n);
        }
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

    private int findCursorPositionForNavLocation(LogChannel logChannel, NavLocation navLocation, Map map) {
        boolean bl = this.getValueFromMap(map, "poiNameEnabled");
        boolean bl2 = this.getValueFromMap(map, "streetEnabled");
        boolean bl3 = this.getValueFromMap(map, "housenumberEnabled");
        boolean bl4 = this.getValueFromMap(map, "junctionEnabled");
        if (navLocation == null) {
            return 1;
        }
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
        String string = iMyLocationAccessor.getTown();
        String string2 = this.getStreetName(iMyLocationAccessor);
        String string3 = this.getHouseNumber(iMyLocationAccessor);
        String string4 = iMyLocationAccessor.getJunction();
        if (!(bl || bl2 || bl3 || bl4 || Util.isEmpty(string))) {
            return 6;
        }
        if (Util.isEmpty(string)) {
            return 1;
        }
        if (Util.isEmpty(string2)) {
            if (bl && !this.inputModeManager.isSdsActive()) {
                return 2;
            }
            return 3;
        }
        if (bl3 && bl4) {
            if (this.inputModeManager.isSdsActive() && this.inputModeManager.getSdsDestinationType() == 5) {
                return 5;
            }
            if (Util.isEmpty(string3) && Util.isEmpty(string4)) {
                return 4;
            }
            if (!Util.isEmpty(string3) || !Util.isEmpty(string4)) {
                return 6;
            }
        } else {
            if (!bl3 && bl4) {
                if (Util.isEmpty(string4)) {
                    return 5;
                }
                return 6;
            }
            if (bl3 && !bl4) {
                if (Util.isEmpty(string3)) {
                    return 4;
                }
                return 6;
            }
            if (!bl3 && !bl4) {
                return 6;
            }
        }
        return 2;
    }

    private String getStreetName(IMyLocationAccessor iMyLocationAccessor) {
        if (AddressInputStreetSequenceCN.isStreetCenterSelected()) {
            return this.env.getTranslatedText(403214);
        }
        return iMyLocationAccessor.getStreet();
    }

    private void updateValueOfIsStreetCenterSelected() {
        if (AddressInputStreetSequenceCN.isStreetCenterSelected()) {
            AddressInputStreetSequenceCN.setIsStreetCenterSelected(false);
        }
    }

    private String getHouseNumber(IMyLocationAccessor iMyLocationAccessor) {
        if (AddressInputHouseNumberSequenceAsia.isHouseNumberCenterSelected()) {
            return this.env.getTranslatedText(403214);
        }
        return iMyLocationAccessor.getHousenumber();
    }

    private void updateValueOfIsHouseNumberCenterSelected() {
        if (AddressInputHouseNumberSequenceAsia.isHouseNumberCenterSelected()) {
            AddressInputHouseNumberSequenceAsia.setIsHouseNumberCenterSelected(false);
        }
    }
}

