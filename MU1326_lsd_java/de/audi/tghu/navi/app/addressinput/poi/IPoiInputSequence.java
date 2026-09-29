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
    default public void startCategoriesOrResultsSequence(IPoiCategoriesOrResultsModelAccess iPoiCategoriesOrResultsModelAccess, int n) {
    }

    default public void startCategories(IPoiSpellerModelAccess iPoiSpellerModelAccess) {
    }

    default public void startResultsSequence(IPoiSpellerModelAccess iPoiSpellerModelAccess, int n) {
    }

    default public void startSubstringSearch(IPoiSpellerModelAccess iPoiSpellerModelAccess) {
    }

    default public void startBrands(IPoiSpellerModelAccess iPoiSpellerModelAccess) {
    }

    default public void startGuidance(IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence) {
    }

    default public void startGuidance(ILocationHandler iLocationHandler, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence) {
    }

    default public void startGuidanceToSingleDestination(IRouteManager iRouteManager) {
    }

    default public void startParentChild(IPoiSpellerModelAccess iPoiSpellerModelAccess, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence) {
    }

    default public void retrieveNavLocation(GuiModelAccessDetailsNavi guiModelAccessDetailsNavi) {
    }

    default public void startDetailsForSelectedElement(IPreviewMap iPreviewMap, GuiModelAccessDetailsNavi guiModelAccessDetailsNavi) {
    }
}

