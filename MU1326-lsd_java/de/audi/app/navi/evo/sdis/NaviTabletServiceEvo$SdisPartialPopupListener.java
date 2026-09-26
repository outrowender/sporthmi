/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.sdis;

import de.audi.app.navi.evo.sdis.NaviTabletServiceEvo;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.view.IPartialPopupListener;
import de.audi.tghu.navi.app.sdis.NaviSDISStartGuidanceHandler;

class NaviTabletServiceEvo$SdisPartialPopupListener
implements IPartialPopupListener {
    private final int[] registeredPopups = new int[]{179};
    private final NaviSDISStartGuidanceHandler naviSDISStartGuidanceHandler;
    private final ChoiceModelApp naviSdisPopupChoice;
    private final /* synthetic */ NaviTabletServiceEvo this$0;

    public NaviTabletServiceEvo$SdisPartialPopupListener(NaviTabletServiceEvo naviTabletServiceEvo, NaviSDISStartGuidanceHandler naviSDISStartGuidanceHandler, ChoiceModelApp choiceModelApp) {
        this.this$0 = naviTabletServiceEvo;
        this.naviSDISStartGuidanceHandler = naviSDISStartGuidanceHandler;
        this.naviSdisPopupChoice = choiceModelApp;
    }

    @Override
    public void partialPopupVisible(int n, int n2) {
    }

    @Override
    public void partialPopupHidden(int n, int n2) {
    }

    @Override
    public void partialPopupRemoved(int n, int n2) {
        if (n != 179) {
            return;
        }
        NaviTabletServiceEvo.access$000(this.this$0).log(-2137614336, "NaviTabletServiceEvo.SdisPartialPopupListener#partialPopupRemoved");
        this.naviSdisPopupChoice.setValue(0);
        this.naviSDISStartGuidanceHandler.decline();
    }

    @Override
    public int[] getPPIDsForCallbacks() {
        return this.registeredPopups;
    }

    @Override
    public void partialPopupListenerRegistered(int n, int n2, boolean bl) {
    }

    @Override
    public void informAboutPPCoordinates(int n, int n2, int n3, int n4, int n5, int n6) {
    }
}

