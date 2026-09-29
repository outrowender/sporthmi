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

    @Override
    public void onUpdateLocation(NavigationEnv navigationEnv, LogChannel logChannel, NavLocation navLocation, Map map) {
        this.onUpdateLocation(navigationEnv, logChannel, null, navLocation, map);
        this.updateValueOfIsStreetCenterSelected();
        this.updateValueOfIsHouseNumberCenterSelected();
    }

    @Override
    public void onUpdateLocation(NavigationEnv navigationEnv, LogChannel logChannel, GuiModelAccessDetailsNavi guiModelAccessDetailsNavi, NavLocation navLocation, Map map) {
        if (logChannel.isDebug2()) {
            logChannel.log(14808325, "%1#onUpdateLocation with navLocation=%2", (Object)this.CLASS_NAME, (Object)LocationFormatter.formatLocationShort(navLocation));
        }
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
        String string = AddressInputUtil.formatCompleteCityNameAsia(navigationEnv, navLocation);
        String string2 = this.getStreetName(iMyLocationAccessor);
        String string3 = this.getHouseNumber(iMyLocationAccessor);
        String string4 = iMyLocationAccessor.getJunction();
        logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#onUpdateLocation with").append(" cityName=%1, streetName=%2, intersection=%3, houseNumber=%4").toString(), (Object)string, (Object)string2, (Object)string4, (Object)string3);
        boolean bl = this.getValueFromMap(map, "cityEnabled");
        boolean bl2 = this.getValueFromMap(map, "poiNameEnabled");
        boolean bl3 = this.getValueFromMap(map, "streetEnabled");
        boolean bl4 = this.getValueFromMap(map, "housenumberEnabled");
        boolean bl5 = this.getValueFromMap(map, "junctionEnabled");
        logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#onUpdateLocation with cityEnabled=").append(bl).append(", locationNameEnabled=").append(bl2).append(", streetEnabled=").append(bl3).append(", housenumberEnabled=").append(bl4).append(", junctionEnabled=").append(bl5).toString());
        navigationEnv.getTextfieldModel(236914176).setText1(string);
        navigationEnv.getTextfieldModel(-367196672).setText1(string2);
        navigationEnv.getTextfieldModel(572458496).setText1(string3);
        navigationEnv.getTextfieldModel(354354688).setText1(string4);
        navigationEnv.getChoiceModel(823854592).setValue(bl ? 1 : 0);
        navigationEnv.getChoiceModel(304154112).setValue(bl2 ? 1 : 0);
        navigationEnv.getChoiceModel(790300160).setValue(bl3 ? 1 : 0);
        navigationEnv.getChoiceModel(656082432).setValue(bl5 ? 1 : 0);
        navigationEnv.getChoiceModel(723191296).setValue(bl4 ? 1 : 0);
        boolean bl6 = this.getValueFromMap(map, "routeGuidancePossible") && !Util.isEmpty(string);
        navigationEnv.getChoiceModel(874186240).setValue(bl6 ? 1 : 0);
        int n = this.findCursorPositionForNavLocation(logChannel, navLocation, map);
        if (logChannel.isDebug2()) {
            logChannel.log(14808325, "%1#onUpdateLocation - nextCursorPosition will be = %2", (Object)this.CLASS_NAME, (long)n);
        }
        navigationEnv.getMenuModel(-518126080).setFocusedItem(n, FocusAdvice.KEEP_POSITION, -1L);
        if (null != guiModelAccessDetailsNavi && bl6) {
            guiModelAccessDetailsNavi.onUpdateLocation(navLocation);
        }
        if (navLocation.isPositionValid()) {
            navigationEnv.getPropertyModel(1847592448).setProperties(160082217, new int[0]);
        } else {
            navigationEnv.getPropertyModel(1847592448).setProperties(-1, new int[0]);
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
            return this.env.getTranslatedText(237438464);
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
            return this.env.getTranslatedText(237438464);
        }
        return iMyLocationAccessor.getHousenumber();
    }

    private void updateValueOfIsHouseNumberCenterSelected() {
        if (AddressInputHouseNumberSequenceAsia.isHouseNumberCenterSelected()) {
            AddressInputHouseNumberSequenceAsia.setIsHouseNumberCenterSelected(false);
        }
    }
}

