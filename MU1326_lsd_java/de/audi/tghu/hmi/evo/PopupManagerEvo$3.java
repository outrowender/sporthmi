/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

import de.audi.atip.hmi.view.IPopupKeyConsuptionStrategy;
import de.audi.atip.hmi.view.IScreenData;
import de.audi.atip.hmi.view.Screen;
import de.audi.tghu.hmi.evo.IScreenEvo;
import de.audi.tghu.hmi.evo.PopupManagerEvo;

class PopupManagerEvo$3
implements Runnable {
    private final /* synthetic */ IPopupKeyConsuptionStrategy val$strategy;
    private final /* synthetic */ PopupManagerEvo this$0;

    PopupManagerEvo$3(PopupManagerEvo popupManagerEvo, IPopupKeyConsuptionStrategy iPopupKeyConsuptionStrategy) {
        this.this$0 = popupManagerEvo;
        this.val$strategy = iPopupKeyConsuptionStrategy;
    }

    @Override
    public void run() {
        IScreenData iScreenData = this.this$0.getPopup(this.val$strategy.getPopupID());
        if (iScreenData == null) {
            PopupManagerEvo.access$200(this.this$0).log(-1601830656, "setPopupKeyConsumptionStrategy popup for id=%1 is null", (long)this.val$strategy.getPopupID());
            return;
        }
        Screen screen = iScreenData.getScreen();
        if (screen instanceof IScreenEvo) {
            PopupManagerEvo.access$300(this.this$0).log(-2137614336, "setPopupKeyConsuptionStrategy(%1) ", (Object)this.val$strategy);
            ((IScreenEvo)screen).setPopupKeyConsuptionStrategy(this.val$strategy);
        } else {
            PopupManagerEvo.access$400(this.this$0).log(10000, "setPopupKeyConsuptionStrategy(%1) is not IScreenEvo", (Object)this.val$strategy);
        }
    }

    public String toString() {
        return new StringBuffer().append("setPopupKeyConsuptionStrategy: ").append(this.val$strategy).toString();
    }
}

