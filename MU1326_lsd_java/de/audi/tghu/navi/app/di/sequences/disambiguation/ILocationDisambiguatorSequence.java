/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.disambiguation;

import de.audi.tghu.navi.app.addressinput.poi.IPoiService;
import de.audi.tghu.navi.app.di.sequences.disambiguation.ILocationDisambiguationCallback;
import de.audi.tghu.navi.app.sds.NotifyNaviServiceListenerCommand;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueListElement;

public interface ILocationDisambiguatorSequence {
    default public void startDisambiguationForNavLocation(NavLocation navLocation, ILocationDisambiguationCallback iLocationDisambiguationCallback, int n, int n2, int n3) {
    }

    default public void startDisambiguationForLiValueListElement(LIValueListElement lIValueListElement, ILocationDisambiguationCallback iLocationDisambiguationCallback, int n, int n2, int n3) {
    }

    default public void startDisambiguationForMapCode(ILocationDisambiguationCallback iLocationDisambiguationCallback, int n, int n2, int n3) {
    }

    default public void startDisambiguationForMapCodeBySds(ILocationDisambiguationCallback iLocationDisambiguationCallback, int n, NotifyNaviServiceListenerCommand notifyNaviServiceListenerCommand) {
    }

    default public void startRouteGuidance(NavLocation navLocation) {
    }

    default public void setLocationAsCurrentLdForSds(int n, NotifyNaviServiceListenerCommand notifyNaviServiceListenerCommand, NotifyNaviServiceListenerCommand notifyNaviServiceListenerCommand2) {
    }

    default public void setAsHomeAddress(NavLocation navLocation) {
    }

    default public void setAsContact(NavLocation navLocation) {
    }

    default public void setAsContactFromAdb(NavLocation navLocation) {
    }

    default public void setForPoiAtThisLocation(NavLocation navLocation) {
    }

    default public boolean setAsFavorite(NavLocation navLocation) {
    }

    default public void setPoiService(IPoiService iPoiService) {
    }
}

