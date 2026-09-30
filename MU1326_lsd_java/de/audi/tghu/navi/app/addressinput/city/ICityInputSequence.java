/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.city;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.navi.app.addressinput.IMatchspellerInputSequence;
import org.dsi.ifc.navigation.LICityHistoryEntry;

public interface ICityInputSequence
extends IMatchspellerInputSequence {
    public static final int CRITERIA_UNDEFINED = -1;
    public static final int CRITERIA_CITY_ONLY = 1;
    public static final int CRITERIA_ZIP_ONLY = 2;
    public static final int CRITERIA_CITY_ZIP = 3;
    public static final int CRITERIA_CITY_ZIP_LICENSEPLATE = 4;

    public void selectHistoryElement(LICityHistoryEntry var1, boolean var2);

    public void showHistoryLocationInPreviewMap(IPreviewMap var1, LICityHistoryEntry var2);
}

