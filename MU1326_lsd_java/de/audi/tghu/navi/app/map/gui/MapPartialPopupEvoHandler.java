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

    @Override
    public void showPopupSemidynBlockMain() {
        this.env.getFramework().getHmiServiceApp().showPartialPopup(0, 85657088);
    }

    @Override
    public void showPopupSemidynBetterMain() {
        this.env.getFramework().getHmiServiceApp().showPartialPopup(0, 102434304);
    }

    @Override
    public void hidePopupSemidynBlockMain() {
        this.env.getFramework().getHmiServiceApp().removePartialPopup(0, 85657088);
    }

    @Override
    public void hidePopupSemidynBetterMain() {
        this.env.getFramework().getHmiServiceApp().removePartialPopup(0, 102434304);
    }

    @Override
    public void showPopupGoogleOfflineNoCache() {
        this.env.getFramework().getHmiServiceApp().showPartialPopup(0, 1461388800);
    }

    @Override
    public void showPopupTrafficeNoticeMap(boolean bl) {
        if (bl) {
            this.env.getFramework().getHmiServiceApp().showPartialPopup(0, -618985984);
        } else {
            this.env.getFramework().getHmiServiceApp().removePartialPopup(0, -618985984);
        }
    }

    @Override
    public void showOnlineTrafficWarningPPU(boolean bl) {
        if (bl) {
            this.env.getFramework().getHmiServiceApp().showPartialPopup(0, -434436608);
        } else {
            this.env.getFramework().getHmiServiceApp().removePartialPopup(0, -434436608);
        }
    }
}

