/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.details.GuiModelAccessDetailsNavi;
import java.util.Map;
import org.dsi.ifc.global.NavLocation;

public interface IAddressInputFormModelAccessHelper {
    public static final String ROUTE_GUIDANCE_POSSIBLE_KEY;
    public static final String COUNTRY_ENABLED_KEY;
    public static final String CITY_ENABLED_KEY;
    public static final String STREET_ENABLED_KEY;
    public static final String HOUSENUMBER_ENABLED_KEY;
    public static final String JUNCTION_ENABLED_KEY;
    public static final String POI_NAME_ENABLED_KEY;
    public static final String CENTER_SELECTED_KEY;
    public static final String PREFECTURE_ENABLED_KEY;
    public static final String PLACENAME_ENABLED_KEY;
    public static final String CHOME_ENABLED_KEY;
    public static final String WARD_ENABLED_KEY;
    public static final String TOWN_STREET_ENABLED_KEY;
    public static final String VILLAGE_STREET_ENABLED_KEY;

    default public void onUpdateLocation(NavigationEnv navigationEnv, LogChannel logChannel, NavLocation navLocation, Map map) {
    }

    default public void onUpdateLocation(NavigationEnv navigationEnv, LogChannel logChannel, GuiModelAccessDetailsNavi guiModelAccessDetailsNavi, NavLocation navLocation, Map map) {
    }
}

