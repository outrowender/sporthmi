/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.navi;

import de.audi.atip.interapp.combi.bap.CombiBAPServiceListener;
import de.audi.atip.interapp.combi.bap.navi.data.CombiBAPNaviDestination;

public interface CombiBAPServiceNaviListener
extends CombiBAPServiceListener {
    default public void startRouteGuidanceToHomeAddress() {
    }

    default public void startRouteGuidance(CombiBAPNaviDestination combiBAPNaviDestination) {
    }

    default public void stopRouteGuidance() {
    }

    default public void repeatLastNavAnnouncement() {
    }

    default public void setVoiceGuidanceState(int n) {
    }

    default public void setActiveRGType(int n) {
    }

    default public void setMapColor(int n) {
    }

    default public void setMapType(int n, int n2) {
    }

    default public void setMapView(int n, int n2) {
    }

    default public void mapViewChanged(boolean bl) {
    }

    default public void setMapVisibility(boolean bl, boolean bl2) {
    }

    default public void setMapOrientation(int n) {
    }

    default public void setMapScale(int n) {
    }

    default public void setMapScaleSetting(int n) {
    }

    default public void startPOISearch(int n, int n2) {
    }

    default public void setMapPresentation(boolean bl, boolean bl2, boolean bl3) {
    }

    default public void resetSupportedMapViews() {
    }

    default public void updateLockingState(boolean bl) {
    }
}

