/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.models;

import de.audi.tghu.navi.app.addressinput.poi.IPoiScreenOnElementSelected;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiScreenOnStart;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiScreenUpdateResultList;
import org.dsi.ifc.navigation.LIValueListElement;

public interface IPoiParentChildCategoryScreenModelAccess
extends IPoiScreenOnStart,
IPoiScreenUpdateResultList,
IPoiScreenOnElementSelected {
    public void setParentElement(LIValueListElement var1);
}

