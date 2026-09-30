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
    private static final int ENABLED = 1;
    private static final int DISABLED = 0;
    private static final int TEXT_COLUMN = 0;
    private static final int FOCUSABLE_COLUMN = 1;

    public AddressInputFormModelAccessHelperNAR(NavigationEnv navigationEnv) {
        super(navigationEnv);
    }

    public void onUpdateLocation(NavigationEnv navigationEnv, LogChannel logChannel, NavLocation navLocation, Map map) {
        this.onUpdateLocation(navigationEnv, logChannel, null, navLocation, map);
    }

    public void onUpdateLocation(NavigationEnv navigationEnv, LogChannel logChannel, GuiModelAccessDetailsNavi guiModelAccessDetailsNavi, NavLocation navLocation, Map map) {
        this.notifySDSForStateOrCountry(navigationEnv, navLocation);
        navigationEnv.getTextfieldModel(402578).setText1(this.createCountryOrStateText(navLocation));
        navigationEnv.getTextfieldModel(401166).setText1(this.createCityText(navigationEnv, navLocation));
        navigationEnv.getTextfieldModel(400874).setText1(LocationFormatter.formatStreetTextfield(navLocation));
        navigationEnv.getTextfieldModel(401186).setText1(navLocation.getHousenumber());
        navigationEnv.getTextfieldModel(401173).setText1(navLocation.getJunction());
        this.updateChoiceModelsDependingOnCurrentLocation(navLocation, navigationEnv, map);
        this.fillFollowUpScreenModels(navigationEnv.getBaseListModel(401891), navLocation);
        boolean bl = this.getValueFromMap(map, "routeGuidancePossible");
        navigationEnv.getChoiceModel(400180).setValue(bl ? 1 : 0);
        if (null != guiModelAccessDetailsNavi && bl) {
            guiModelAccessDetailsNavi.onUpdateLocation(navLocation);
        }
        if (navLocation.isPositionValid()) {
            navigationEnv.getPropertyModel(401518).setProperties(698976777, new int[0]);
        } else {
            navigationEnv.getPropertyModel(401518).setProperties(-1, new int[0]);
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
        EvoListRow evoListRow2 = new EvoListRow(2L, 2);
        if (navLocation.isPositionValid()) {
            String string = AddressFormatter.formatTwoLines(navLocation, this.env).getFirstLineAsText();
            String string2 = AddressFormatter.formatTwoLines(navLocation, this.env).getSecondLineAsText();
            evoListRow.setText(0, string);
            evoListRow.setInteger(1, 0);
            evoListRow2.setText(0, string2);
            evoListRow2.setInteger(1, 0);
        } else {
            this.logChannel.log(10000000, "AddressInputFormModelAccessHelperNAR#fillFollowUpScreenModels NavLocation not valid, FollowUpScreen will be empty");
        }
        baseListModelApp.setLength(2);
        baseListModelApp.setRow(0, evoListRow);
        baseListModelApp.setRow(1, evoListRow2);
    }

    private void updateChoiceModelsDependingOnCurrentLocation(NavLocation navLocation, NavigationEnv navigationEnv, Map map) {
        if (Util.isEmpty(navLocation.junction)) {
            navigationEnv.getChoiceModel(400945).setValue(0);
        } else {
            navigationEnv.getChoiceModel(400945).setValue(1);
        }
        if (Util.isEmpty(navLocation.street)) {
            navigationEnv.getChoiceModel(400166).setValue(0);
            navigationEnv.getChoiceModel(400177).setValue(0);
            navigationEnv.getChoiceModel(400175).setValue(this.getIntValueFromMap(map, "streetEnabled"));
            navigationEnv.getChoiceModel(400167).setValue(0);
            navigationEnv.getChoiceModel(400171).setValue(0);
        } else if (Util.isEmpty(navLocation.junction) && Util.isEmpty(navLocation.housenumber)) {
            navigationEnv.getChoiceModel(400166).setValue(0);
            navigationEnv.getChoiceModel(400177).setValue(0);
            navigationEnv.getChoiceModel(400175).setValue(0);
            if (navigationEnv.getContainer().selectionCriterionAvailable(4)) {
                navigationEnv.getChoiceModel(400167).setValue(this.getIntValueFromMap(map, "junctionEnabled"));
            } else {
                navigationEnv.getChoiceModel(400167).setValue(0);
            }
            if (navigationEnv.getContainer().selectionCriterionAvailable(136)) {
                navigationEnv.getChoiceModel(400171).setValue(this.getIntValueFromMap(map, "housenumberEnabled"));
            } else {
                navigationEnv.getChoiceModel(400171).setValue(0);
            }
        } else {
            navigationEnv.getChoiceModel(400166).setValue(0);
            navigationEnv.getChoiceModel(400177).setValue(0);
            navigationEnv.getChoiceModel(400175).setValue(0);
            navigationEnv.getChoiceModel(400167).setValue(0);
            navigationEnv.getChoiceModel(400171).setValue(0);
        }
    }

    protected int getIntValueFromMap(Map map, String string) {
        boolean bl = this.getValueFromMap(map, string);
        return bl ? 1 : 0;
    }
}

