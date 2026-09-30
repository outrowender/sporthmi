/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.poi.IPoiInputSequence;
import de.audi.tghu.navi.app.addressinput.poi.IPoiSpellerModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;
import org.dsi.ifc.global.NavLocation;

public interface IPoiInput
extends IPoiInputSequence {
    public void startTopPoiInputSequence(IPoiSpellerModelAccess var1);

    public CommandList getStartTopPoiInputSequence(IPoiSpellerModelAccess var1);

    public void startPoiClassesInputSequence(IPoiSpellerModelAccess var1);

    public void startPersonalPoiInputSequence(IPoiSpellerModelAccess var1);

    public void startTopPoiByUID(IPoiSpellerModelAccess var1, IPoiSpellerModelAccess var2, PoiSearchArea var3, int var4);

    public CommandList getTopPoiByUID(IPoiSpellerModelAccess var1, IPoiSpellerModelAccess var2, PoiSearchArea var3, int var4);

    public void cancelAlongRouteSearch();

    public boolean isActive();

    public void finish();

    public void updateAdbNavLocation(byte[] var1);

    public void startStoringNavLocationOnAdbEntry(NavLocation var1);

    public void saveHomeAddress(NavLocation var1);
}

