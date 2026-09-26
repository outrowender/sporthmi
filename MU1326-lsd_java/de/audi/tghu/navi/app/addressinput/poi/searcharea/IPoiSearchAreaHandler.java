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
    default public void start(boolean bl, int n) {
    }

    default public void startCountryCity(boolean bl) {
    }

    default public void startCountryInputSequence(IMatchspellerModelAccess iMatchspellerModelAccess, boolean bl) {
    }

    default public void startCountryInputSequence(char c2, IMatchspellerModelAccess iMatchspellerModelAccess, boolean bl) {
    }

    default public void startPoiAreaCityZipInputSequence(IMatchspellerModelAccess iMatchspellerModelAccess, boolean bl) {
    }

    default public void startPoiAreaCityZipInputSequence(IMatchspellerModelAccess iMatchspellerModelAccess, CommandList commandList, boolean bl) {
    }

    default public void updateSearchArea(int n, NavLocation navLocation) {
    }

    default public void selectListElement(LICityHistoryEntry lICityHistoryEntry, CommandList commandList, boolean bl) {
    }

    default public NavLocation getCountryLocation() {
    }

    default public void showCityInPreviewMap(LIValueListElement lIValueListElement) {
    }

    default public void showCityInPreviewMap(LICityHistoryEntry lICityHistoryEntry) {
    }

    default public void showCCPInPreviewMap() {
    }

    default public void showRouteInPreviewMap() {
    }

    default public void showDestinationAreaInPreviewMap(NavLocation navLocation) {
    }

    default public void hidePreviewMap() {
    }
}

