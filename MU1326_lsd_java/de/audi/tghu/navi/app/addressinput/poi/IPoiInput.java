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
    default public void startTopPoiInputSequence(IPoiSpellerModelAccess iPoiSpellerModelAccess) {
    }

    default public CommandList getStartTopPoiInputSequence(IPoiSpellerModelAccess iPoiSpellerModelAccess) {
    }

    default public void startPoiClassesInputSequence(IPoiSpellerModelAccess iPoiSpellerModelAccess) {
    }

    default public void startPersonalPoiInputSequence(IPoiSpellerModelAccess iPoiSpellerModelAccess) {
    }

    default public void startTopPoiByUID(IPoiSpellerModelAccess iPoiSpellerModelAccess, IPoiSpellerModelAccess iPoiSpellerModelAccess2, PoiSearchArea poiSearchArea, int n) {
    }

    default public CommandList getTopPoiByUID(IPoiSpellerModelAccess iPoiSpellerModelAccess, IPoiSpellerModelAccess iPoiSpellerModelAccess2, PoiSearchArea poiSearchArea, int n) {
    }

    default public void cancelAlongRouteSearch() {
    }

    default public boolean isActive() {
    }

    default public void finish() {
    }

    default public void updateAdbNavLocation(byte[] byArray) {
    }

    default public void startStoringNavLocationOnAdbEntry(NavLocation navLocation) {
    }

    default public void saveHomeAddress(NavLocation navLocation) {
    }
}

