/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi;

import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.IPoiScreenOnElementSelected;
import de.audi.tghu.navi.app.addressinput.poi.IPoiScreenOnUpdatePoiList;
import de.audi.tghu.navi.app.addressinput.poi.models.ISubstringSearchModelAccess;

public interface IPoiSpellerModelAccess
extends IMatchspellerModelAccess,
ISubstringSearchModelAccess,
IPoiScreenOnUpdatePoiList,
IPoiScreenOnElementSelected {
}

