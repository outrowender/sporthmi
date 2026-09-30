/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.searcharea;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.IMatchspellerInputSequence;
import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LICityHistoryEntry;
import org.dsi.ifc.navigation.LIValueListElement;

public interface IPoiSearchAreaHandler
extends IMatchspellerInputSequence {
    public void start(boolean var1, int var2);

    public void startCountryCity(boolean var1);

    public void startCountryInputSequence(IMatchspellerModelAccess var1, boolean var2);

    public void startCountryInputSequence(char var1, IMatchspellerModelAccess var2, boolean var3);

    public void startPoiAreaCityZipInputSequence(IMatchspellerModelAccess var1, boolean var2);

    public void startPoiAreaCityZipInputSequence(IMatchspellerModelAccess var1, CommandList var2, boolean var3);

    public void updateSearchArea(int var1, NavLocation var2);

    public void selectListElement(LICityHistoryEntry var1, CommandList var2, boolean var3);

    public NavLocation getCountryLocation();

    public void showCityInPreviewMap(LIValueListElement var1);

    public void showCityInPreviewMap(LICityHistoryEntry var1);

    public void showCCPInPreviewMap();

    public void showRouteInPreviewMap();

    public void showDestinationAreaInPreviewMap(NavLocation var1);

    public void hidePreviewMap();
}

