/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.gui;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.IMapPartialPopupHandler;

public class MapPartialPopupEvoHandler
implements IMapPartialPopupHandler {
    private final NavigationEnv env;

    public MapPartialPopupEvoHandler(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
    }

    public void showPopupSemidynBlockMain() {
        this.env.getFramework().getHmiServiceApp().showPartialPopup(0, 400133);
    }

    public void showPopupSemidynBetterMain() {
        this.env.getFramework().getHmiServiceApp().showPartialPopup(0, 400134);
    }

    public void hidePopupSemidynBlockMain() {
        this.env.getFramework().getHmiServiceApp().removePartialPopup(0, 400133);
    }

    public void hidePopupSemidynBetterMain() {
        this.env.getFramework().getHmiServiceApp().removePartialPopup(0, 400134);
    }

    public void showPopupGoogleOfflineNoCache() {
        this.env.getFramework().getHmiServiceApp().showPartialPopup(0, 400215);
    }

    public void showPopupTrafficeNoticeMap(boolean bl) {
        if (bl) {
            this.env.getFramework().getHmiServiceApp().showPartialPopup(0, 400347);
        } else {
            this.env.getFramework().getHmiServiceApp().removePartialPopup(0, 400347);
        }
    }

    public void showOnlineTrafficWarningPPU(boolean bl) {
        if (bl) {
            this.env.getFramework().getHmiServiceApp().showPartialPopup(0, 400358);
        } else {
            this.env.getFramework().getHmiServiceApp().removePartialPopup(0, 400358);
        }
    }
}

