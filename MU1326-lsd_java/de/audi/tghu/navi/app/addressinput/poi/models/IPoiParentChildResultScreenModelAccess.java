/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.models;

import de.audi.tghu.navi.app.addressinput.poi.IPoiScreenOnElementSelected;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiScreenOnElementFocused;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiScreenOnStart;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiScreenRequestItems;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiScreenUnrequestItems;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiScreenUpdateResultList;

public interface IPoiParentChildResultScreenModelAccess
extends IPoiScreenOnStart,
IPoiScreenOnElementSelected,
IPoiScreenUpdateResultList,
IPoiScreenRequestItems,
IPoiScreenUnrequestItems,
IPoiScreenOnElementFocused {
}

