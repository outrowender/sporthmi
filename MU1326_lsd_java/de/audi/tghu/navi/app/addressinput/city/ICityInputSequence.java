/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.city;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.navi.app.addressinput.IMatchspellerInputSequence;
import org.dsi.ifc.navigation.LICityHistoryEntry;

public interface ICityInputSequence
extends IMatchspellerInputSequence {
    public static final int CRITERIA_UNDEFINED;
    public static final int CRITERIA_CITY_ONLY;
    public static final int CRITERIA_ZIP_ONLY;
    public static final int CRITERIA_CITY_ZIP;
    public static final int CRITERIA_CITY_ZIP_LICENSEPLATE;

    default public void selectHistoryElement(LICityHistoryEntry lICityHistoryEntry, boolean bl) {
    }

    default public void showHistoryLocationInPreviewMap(IPreviewMap iPreviewMap, LICityHistoryEntry lICityHistoryEntry) {
    }
}

