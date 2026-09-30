/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.navi.app.addressinput.IRestorable;
import de.audi.tghu.navi.app.addressinput.poi.IPoiCategoriesOrResultsModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.IPoiSpellerModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.IPoiSubstringSearchListener;
import de.audi.tghu.navi.app.addressinput.poi.ISpellerInputSequence;
import de.audi.tghu.navi.app.details.GuiModelAccessDetailsNavi;
import de.audi.tghu.navi.app.routeguidance.ILocationHandler;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;

public interface IPoiInputSequence
extends ISpellerInputSequence,
IPoiSubstringSearchListener,
IRestorable {
    public void startCategoriesOrResultsSequence(IPoiCategoriesOrResultsModelAccess var1, int var2);

    public void startCategories(IPoiSpellerModelAccess var1);

    public void startResultsSequence(IPoiSpellerModelAccess var1, int var2);

    public void startSubstringSearch(IPoiSpellerModelAccess var1);

    public void startBrands(IPoiSpellerModelAccess var1);

    public void startGuidance(IStartGuidanceToDestinationSequence var1);

    public void startGuidance(ILocationHandler var1, IStartGuidanceToDestinationSequence var2);

    public void startGuidanceToSingleDestination(IRouteManager var1);

    public void startParentChild(IPoiSpellerModelAccess var1, IStartGuidanceToDestinationSequence var2);

    public void retrieveNavLocation(GuiModelAccessDetailsNavi var1);

    public void startDetailsForSelectedElement(IPreviewMap var1, GuiModelAccessDetailsNavi var2);
}

