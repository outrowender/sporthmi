/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.poi.IPoiCategoriesOrResultsModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.IPoiSpellerModelAccess;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;

public interface IPoiExtendedInputSequence {
    default public CommandList createStartCategoriesOrResultsSequence(IPoiCategoriesOrResultsModelAccess iPoiCategoriesOrResultsModelAccess) {
    }

    default public CommandList createStartResultsSequence(IPoiSpellerModelAccess iPoiSpellerModelAccess, int n) {
    }

    default public CommandList createStartSubstringSearch(IPoiSpellerModelAccess iPoiSpellerModelAccess) {
    }

    default public CommandList createStartBrands(IPoiSpellerModelAccess iPoiSpellerModelAccess) {
    }

    default public CommandList createStartGuidance(IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence) {
    }

    default public CommandList createStartParentChild(IPoiSpellerModelAccess iPoiSpellerModelAccess, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence) {
    }
}

