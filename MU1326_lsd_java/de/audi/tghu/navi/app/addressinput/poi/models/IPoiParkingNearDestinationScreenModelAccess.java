/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.models;

import de.audi.tghu.navi.app.addressinput.poi.models.IPoiScreenOnStart;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiScreenRequestItems;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiScreenUnrequestItems;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiScreenUpdateResultList;
import de.audi.tghu.navi.app.addressinput.poi.models.ISubstringSearchModelAccess;
import org.dsi.ifc.global.NavLocation;

public interface IPoiParkingNearDestinationScreenModelAccess
extends IPoiScreenOnStart,
IPoiScreenUpdateResultList,
IPoiScreenRequestItems,
IPoiScreenUnrequestItems,
ISubstringSearchModelAccess {
    public void updateNavLocationForAirDistance(NavLocation var1);
}

