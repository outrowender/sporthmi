/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.navi;

import de.audi.atip.interapp.combi.bap.CombiBAPServiceListener;
import de.audi.atip.interapp.combi.bap.navi.data.CombiBAPNaviDestination;

public interface CombiBAPServiceNaviListener
extends CombiBAPServiceListener {
    public void startRouteGuidanceToHomeAddress();

    public void startRouteGuidance(CombiBAPNaviDestination var1);

    public void stopRouteGuidance();

    public void repeatLastNavAnnouncement();

    public void setVoiceGuidanceState(int var1);

    public void setActiveRGType(int var1);

    public void setMapColor(int var1);

    public void setMapType(int var1, int var2);

    public void setMapView(int var1, int var2);

    public void mapViewChanged(boolean var1);

    public void setMapVisibility(boolean var1, boolean var2);

    public void setMapOrientation(int var1);

    public void setMapScale(int var1);

    public void setMapScaleSetting(int var1);

    public void startPOISearch(int var1, int var2);

    public void setMapPresentation(boolean var1, boolean var2, boolean var3);

    public void resetSupportedMapViews();

    public void updateLockingState(boolean var1);
}

