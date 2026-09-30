/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.guidance;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.guidance.CoreVehicleModelAccess;
import de.audi.tghu.navi.app.guidance.Vehicle;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.AddressFormatter;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingResponse;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.NavLocation;

public class EvoVehicleModelAccess
extends CoreVehicleModelAccess {
    private final BaseListModelApp posList;
    private final LogChannel logChannel;
    private static final int ROW_COUNTRY = 0;
    private static final int ROW_CITY = 1;
    private static final int ROW_STREET_OR_LATLONG = 2;
    private static final int COLS = 3;
    private static final int COL_ICON = 0;
    private static final int COL_TEXT = 1;
    private static final int COL_TYPE = 2;
    private String country = "";
    private String countryAbr = "";
    private String city = "";
    private String street = "";
    private String latitude = "";
    private String longitude = "";

    public EvoVehicleModelAccess(NavigationEnv navigationEnv) {
        super(navigationEnv);
        this.logChannel = navigationEnv.getGuidanceLogChannel();
        this.posList = navigationEnv.getBaseListModel(402572);
        this.posList.removeAll();
    }

    public void updateCountryNCity(String string, String string2, String string3) {
        super.updateCountryNCity(string, string2, string3);
        this.country = string;
        this.countryAbr = string2;
        this.city = string3;
    }

    private EvoListRow getRowCountry() {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "EvoVehicleModelAccess#getRowCountry(%1)", (Object)this.country);
        }
        EvoListRow evoListRow = new EvoListRow(0L, 3);
        evoListRow.setHMIResourceLocator(0, null);
        evoListRow.setText(1, this.country);
        evoListRow.setInteger(2, 0);
        return evoListRow;
    }

    private EvoListRow getRowCity(boolean bl) {
        Object object;
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "EvoVehicleModelAccess#getRowCity(%1)", (Object)this.city);
        }
        String string = this.city;
        if (bl) {
            object = new Buffer(50);
            if (!Util.isEmpty(this.countryAbr)) {
                ((Buffer)object).append("(").append(this.countryAbr).append(") ").append(string);
                string = ((Buffer)object).toString();
            }
        }
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "EvoVehicleModelAccess#getRowCity(%1)", (Object)string);
        }
        object = new EvoListRow(1L, 3);
        ((EvoListRow)object).setHMIResourceLocator(0, null);
        ((EvoListRow)object).setText(1, string);
        ((EvoListRow)object).setInteger(2, 0);
        return object;
    }

    public void updateStreet(String string) {
        super.updateStreet(string);
        this.street = string;
    }

    public EvoListRow getRowStreet() {
        EvoListRow evoListRow = new EvoListRow(2L, 3);
        evoListRow.setHMIResourceLocator(0, null);
        evoListRow.setText(1, this.street);
        evoListRow.setInteger(2, 0);
        return evoListRow;
    }

    public void updateSatInfo(String string, String string2, int n, int n2, int n3, int n4) {
        super.updateSatInfo(string, string2, n, n2, n3, n4);
        this.latitude = string;
        this.longitude = string2;
    }

    private EvoListRow getRowLatLong() {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "EvoVehicleModelAccess#getRowLatLong(%1, %2)", (Object)this.latitude, (Object)this.longitude);
        }
        EvoListRow evoListRow = new EvoListRow(2L, 3);
        evoListRow.setHMIResourceLocator(0, null);
        evoListRow.setText(1, this.latitude + " / " + this.longitude);
        evoListRow.setInteger(2, 0);
        return evoListRow;
    }

    private EvoListRow getAsiaRow(int n, String string) {
        EvoListRow evoListRow = new EvoListRow(n, 3);
        evoListRow.setHMIResourceLocator(0, null);
        evoListRow.setText(1, string);
        evoListRow.setInteger(2, 0);
        return evoListRow;
    }

    public void buildRows() {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "EvoVehicleModelAccess#buildRows");
        }
        BaseListModelApp baseListModelApp = this.posList.getEmptyCopy();
        if (!Util.isHURegionAsia()) {
            if (!Util.isEmpty(this.street)) {
                if (!Util.isEmpty(this.city)) {
                    if (!Util.isEmpty(this.countryAbr)) {
                        baseListModelApp.append(this.getRowCity(true));
                    } else {
                        baseListModelApp.append(this.getRowCity(false));
                    }
                } else if (!Util.isEmpty(this.country)) {
                    baseListModelApp.append(this.getRowCountry());
                }
                baseListModelApp.append(this.getRowStreet());
            } else {
                if (!Util.isEmpty(this.country)) {
                    baseListModelApp.append(this.getRowCountry());
                }
                if (!Util.isEmpty(this.city)) {
                    baseListModelApp.append(this.getRowCity(false));
                }
            }
            if (!Util.isEmpty(this.latitude) && !Util.isEmpty(this.longitude)) {
                baseListModelApp.append(this.getRowLatLong());
            }
        } else {
            NavLocation navLocation = Vehicle.getInstance().getVehicleLocationDescription();
            if (this.logChannel.isDebug2()) {
                this.logChannel.log(100000000, "EvoVehicleModelAccess#buildRows for Asia vehicleLocation = %1", (Object)LocationFormatter.formatLocationShort(navLocation));
            }
            LocationFormattingResponse locationFormattingResponse = AddressFormatter.formatTwoLines(navLocation, this.env);
            baseListModelApp.append(this.getAsiaRow(0, locationFormattingResponse.getFirstLineAsText()));
            baseListModelApp.append(this.getAsiaRow(1, locationFormattingResponse.getSecondLineAsText()));
            baseListModelApp.append(this.getAsiaRow(2, ""));
        }
        this.posList.update(baseListModelApp);
    }
}

