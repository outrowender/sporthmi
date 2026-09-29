/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.details.GuiModelAccessDetailsNavi;
import de.audi.tghu.navi.app.di.AbstractAddressInputFormModelAccessHelper;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.AddressFormatter;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Map;
import org.dsi.ifc.global.NavLocation;

public class AddressInputFormModelAccessHelperNAR
extends AbstractAddressInputFormModelAccessHelper {
    private static final int ENABLED;
    private static final int DISABLED;
    private static final int TEXT_COLUMN;
    private static final int FOCUSABLE_COLUMN;

    public AddressInputFormModelAccessHelperNAR(NavigationEnv navigationEnv) {
        super(navigationEnv);
    }

    @Override
    public void onUpdateLocation(NavigationEnv navigationEnv, LogChannel logChannel, NavLocation navLocation, Map map) {
        this.onUpdateLocation(navigationEnv, logChannel, null, navLocation, map);
    }

    @Override
    public void onUpdateLocation(NavigationEnv navigationEnv, LogChannel logChannel, GuiModelAccessDetailsNavi guiModelAccessDetailsNavi, NavLocation navLocation, Map map) {
        this.notifySDSForStateOrCountry(navigationEnv, navLocation);
        navigationEnv.getTextfieldModel(-1843132928).setText1(this.createCountryOrStateText(navLocation));
        navigationEnv.getTextfieldModel(236914176).setText1(this.createCityText(navigationEnv, navLocation));
        navigationEnv.getTextfieldModel(-367196672).setText1(LocationFormatter.formatStreetTextfield(navLocation));
        navigationEnv.getTextfieldModel(572458496).setText1(navLocation.getHousenumber());
        navigationEnv.getTextfieldModel(354354688).setText1(navLocation.getJunction());
        this.updateChoiceModelsDependingOnCurrentLocation(navLocation, navigationEnv, map);
        this.fillFollowUpScreenModels(navigationEnv.getBaseListModel(-484375040), navLocation);
        boolean bl = this.getValueFromMap(map, "routeGuidancePossible");
        navigationEnv.getChoiceModel(874186240).setValue(bl ? 1 : 0);
        if (null != guiModelAccessDetailsNavi && bl) {
            guiModelAccessDetailsNavi.onUpdateLocation(navLocation);
        }
        if (navLocation.isPositionValid()) {
            navigationEnv.getPropertyModel(1847592448).setProperties(160082217, new int[0]);
        } else {
            navigationEnv.getPropertyModel(1847592448).setProperties(-1, new int[0]);
        }
    }

    private String createCityText(NavigationEnv navigationEnv, NavLocation navLocation) {
        Buffer buffer = new Buffer();
        if (Util.isEmpty(navLocation.streetRefinement)) {
            if (Util.isEmpty(navLocation.zipCode)) {
                buffer.append(navLocation.getTown());
            } else {
                buffer.append(navLocation.getTown());
                buffer.append(", ");
                buffer.append(navLocation.getZipCode());
            }
        } else {
            buffer.append(navLocation.streetRefinement);
            buffer.append(", ");
            buffer.append(navLocation.getTown());
        }
        return buffer.toString();
    }

    private void fillFollowUpScreenModels(BaseListModelApp baseListModelApp, NavLocation navLocation) {
        EvoListRow evoListRow = new EvoListRow(1L, 2);
        EvoListRow evoListRow2 = new EvoListRow(0, 2);
        if (navLocation.isPositionValid()) {
            String string = AddressFormatter.formatTwoLines(navLocation, this.env).getFirstLineAsText();
            String string2 = AddressFormatter.formatTwoLines(navLocation, this.env).getSecondLineAsText();
            evoListRow.setText(0, string);
            evoListRow.setInteger(1, 0);
            evoListRow2.setText(0, string2);
            evoListRow2.setInteger(1, 0);
        } else {
            this.logChannel.log(-2137614336, "AddressInputFormModelAccessHelperNAR#fillFollowUpScreenModels NavLocation not valid, FollowUpScreen will be empty");
        }
        baseListModelApp.setLength(2);
        baseListModelApp.setRow(0, evoListRow);
        baseListModelApp.setRow(1, evoListRow2);
    }

    private void updateChoiceModelsDependingOnCurrentLocation(NavLocation navLocation, NavigationEnv navigationEnv, Map map) {
        if (Util.isEmpty(navLocation.junction)) {
            navigationEnv.getChoiceModel(824051200).setValue(0);
        } else {
            navigationEnv.getChoiceModel(824051200).setValue(1);
        }
        if (Util.isEmpty(navLocation.street)) {
            navigationEnv.getChoiceModel(639305216).setValue(0);
            navigationEnv.getChoiceModel(823854592).setValue(0);
            navigationEnv.getChoiceModel(790300160).setValue(this.getIntValueFromMap(map, "streetEnabled"));
            navigationEnv.getChoiceModel(656082432).setValue(0);
            navigationEnv.getChoiceModel(723191296).setValue(0);
        } else if (Util.isEmpty(navLocation.junction) && Util.isEmpty(navLocation.housenumber)) {
            navigationEnv.getChoiceModel(639305216).setValue(0);
            navigationEnv.getChoiceModel(823854592).setValue(0);
            navigationEnv.getChoiceModel(790300160).setValue(0);
            if (navigationEnv.getContainer().selectionCriterionAvailable(4)) {
                navigationEnv.getChoiceModel(656082432).setValue(this.getIntValueFromMap(map, "junctionEnabled"));
            } else {
                navigationEnv.getChoiceModel(656082432).setValue(0);
            }
            if (navigationEnv.getContainer().selectionCriterionAvailable(136)) {
                navigationEnv.getChoiceModel(723191296).setValue(this.getIntValueFromMap(map, "housenumberEnabled"));
            } else {
                navigationEnv.getChoiceModel(723191296).setValue(0);
            }
        } else {
            navigationEnv.getChoiceModel(639305216).setValue(0);
            navigationEnv.getChoiceModel(823854592).setValue(0);
            navigationEnv.getChoiceModel(790300160).setValue(0);
            navigationEnv.getChoiceModel(656082432).setValue(0);
            navigationEnv.getChoiceModel(723191296).setValue(0);
        }
    }

    protected int getIntValueFromMap(Map map, String string) {
        boolean bl = this.getValueFromMap(map, string);
        return bl ? 1 : 0;
    }
}

