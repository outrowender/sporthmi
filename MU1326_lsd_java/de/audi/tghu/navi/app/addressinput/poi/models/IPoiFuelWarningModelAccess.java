/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.models;

import de.audi.tghu.navi.app.addressinput.poi.IPoiScreenOnElementSelected;
import de.audi.tghu.navi.app.addressinput.poi.IPoiScreenOnUpdatePoiList;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiScreenOnElementFocused;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiScreenOnStart;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiScreenPrepareParentChild;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiScreenUpdateResultList;
import de.audi.tghu.navi.app.addressinput.poi.models.ISubstringSearchModelAccess;

public interface IPoiFuelWarningModelAccess
extends ISubstringSearchModelAccess,
IPoiScreenUpdateResultList,
IPoiScreenOnElementSelected,
IPoiScreenOnUpdatePoiList,
IPoiScreenOnStart,
IPoiScreenPrepareParentChild,
IPoiScreenOnElementFocused {
}

