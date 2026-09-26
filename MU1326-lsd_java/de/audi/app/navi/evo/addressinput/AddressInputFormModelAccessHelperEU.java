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
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Map;
import org.dsi.ifc.global.NavLocation;

public class AddressInputFormModelAccessHelperEU
extends AbstractAddressInputFormModelAccessHelper {
    public AddressInputFormModelAccessHelperEU(NavigationEnv navigationEnv) {
        super(navigationEnv);
    }

    @Override
    public void onUpdateLocation(NavigationEnv navigationEnv, LogChannel logChannel, NavLocation navLocation, Map map) {
        this.onUpdateLocation(navigationEnv, logChannel, null, navLocation, map);
    }

    @Override
    public void onUpdateLocation(NavigationEnv navigationEnv, LogChannel logChannel, GuiModelAccessDetailsNavi guiModelAccessDetailsNavi, NavLocation navLocation, Map map) {
        boolean bl = this.getValueFromMap(map, "countryEnabled");
        boolean bl2 = this.getValueFromMap(map, "cityEnabled");
        boolean bl3 = this.getValueFromMap(map, "streetEnabled");
        boolean bl4 = this.getValueFromMap(map, "housenumberEnabled");
        boolean bl5 = this.getValueFromMap(map, "junctionEnabled");
        navigationEnv.getTextfieldModel(-1843132928).setText1(navLocation.getCountry());
        Buffer buffer = new Buffer();
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
        if (!iMyLocationAccessor.isTownOrder9()) {
            if (!Util.isEmpty(iMyLocationAccessor.getZipCode()) && Util.isEmpty(iMyLocationAccessor.getStreetRefinement())) {
                buffer.append(navLocation.getZipCode());
                buffer.append(" ");
            }
            buffer.append(iMyLocationAccessor.getTown());
            if (!Util.isEmpty(iMyLocationAccessor.getStreetRefinement())) {
                buffer.append(", ");
                buffer.append(iMyLocationAccessor.getStreetRefinement());
            }
        } else {
            buffer.append(iMyLocationAccessor.getTownRefinement());
            buffer.append(", ");
            buffer.append(iMyLocationAccessor.getTown());
        }
        navigationEnv.getTextfieldModel(236914176).setText1(buffer.toString());
        navigationEnv.getTextfieldModel(-367196672).setText1(LocationFormatter.formatStreetTextfield(navLocation));
        navigationEnv.getTextfieldModel(572458496).setText1(navLocation.getHousenumber());
        navigationEnv.getTextfieldModel(354354688).setText1(navLocation.getJunction());
        navigationEnv.getChoiceModel(639305216).setValue(bl ? 1 : 0);
        navigationEnv.getChoiceModel(823854592).setValue(bl2 ? 1 : 0);
        navigationEnv.getChoiceModel(790300160).setValue(bl3 ? 1 : 0);
        navigationEnv.getChoiceModel(656082432).setValue(bl5 ? 1 : 0);
        navigationEnv.getChoiceModel(723191296).setValue(bl4 ? 1 : 0);
        boolean bl6 = this.getValueFromMap(map, "routeGuidancePossible");
        navigationEnv.getChoiceModel(874186240).setValue(bl6 ? 1 : 0);
        int n = this.findCursorPositionForNavLocation(navLocation, bl4, bl5);
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

    private int findCursorPositionForNavLocation(NavLocation navLocation, boolean bl, boolean bl2) {
        if (navLocation == null) {
            return 0;
        }
        if (!(Util.isEmpty(navLocation.getCountry()) || Util.isEmpty(navLocation.getTown()) || Util.isEmpty(navLocation.getStreet()))) {
            if (!bl && bl2) {
                if (Util.isEmpty(navLocation.getJunction())) {
                    return 4;
                }
                return 5;
            }
            if (!bl && !bl2) {
                return 5;
            }
        }
        if (!Util.isEmpty(navLocation.getHousenumber()) || !Util.isEmpty(navLocation.getJunction())) {
            return 5;
        }
        if (!Util.isEmpty(navLocation.getStreet())) {
            return 3;
        }
        if (!Util.isEmpty(navLocation.getTown())) {
            return 2;
        }
        if (!Util.isEmpty(navLocation.getCountry())) {
            return 1;
        }
        return 0;
    }
}

