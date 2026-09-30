/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.poi.IPoiCategoriesOrResultsModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.IPoiSpellerModelAccess;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;

public interface IPoiExtendedInputSequence {
    public CommandList createStartCategoriesOrResultsSequence(IPoiCategoriesOrResultsModelAccess var1);

    public CommandList createStartResultsSequence(IPoiSpellerModelAccess var1, int var2);

    public CommandList createStartSubstringSearch(IPoiSpellerModelAccess var1);

    public CommandList createStartBrands(IPoiSpellerModelAccess var1);

    public CommandList createStartGuidance(IStartGuidanceToDestinationSequence var1);

    public CommandList createStartParentChild(IPoiSpellerModelAccess var1, IStartGuidanceToDestinationSequence var2);
}

