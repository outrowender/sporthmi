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
    public static final String ROUTE_GUIDANCE_POSSIBLE_KEY = "routeGuidancePossible";
    public static final String COUNTRY_ENABLED_KEY = "countryEnabled";
    public static final String CITY_ENABLED_KEY = "cityEnabled";
    public static final String STREET_ENABLED_KEY = "streetEnabled";
    public static final String HOUSENUMBER_ENABLED_KEY = "housenumberEnabled";
    public static final String JUNCTION_ENABLED_KEY = "junctionEnabled";
    public static final String POI_NAME_ENABLED_KEY = "poiNameEnabled";
    public static final String CENTER_SELECTED_KEY = "cityCenterSelected";
    public static final String PREFECTURE_ENABLED_KEY = "prefectureEnabled";
    public static final String PLACENAME_ENABLED_KEY = "placenameEnbaled";
    public static final String CHOME_ENABLED_KEY = "chomeEnabled";
    public static final String WARD_ENABLED_KEY = "wardEnabled";
    public static final String TOWN_STREET_ENABLED_KEY = "townStreetEnabled";
    public static final String VILLAGE_STREET_ENABLED_KEY = "villageStreetEnabled";

    public void onUpdateLocation(NavigationEnv var1, LogChannel var2, NavLocation var3, Map var4);

    public void onUpdateLocation(NavigationEnv var1, LogChannel var2, GuiModelAccessDetailsNavi var3, NavLocation var4, Map var5);
}

