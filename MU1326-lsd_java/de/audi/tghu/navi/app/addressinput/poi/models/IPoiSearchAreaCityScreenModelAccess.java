/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.models;

import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.commands.IPoiScreenUpdateSpeller;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiScreenOnStart;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiScreenRequestItems;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiScreenUnrequestItems;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiScreenUpdateResultList;

public interface IPoiSearchAreaCityScreenModelAccess
extends IPoiScreenOnStart,
IPoiScreenUpdateResultList,
IPoiScreenUpdateSpeller,
IPoiScreenRequestItems,
IPoiScreenUnrequestItems,
IMatchspellerModelAccess {
}

