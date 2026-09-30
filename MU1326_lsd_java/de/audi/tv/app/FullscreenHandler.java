/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.base.TVEventDefaultListener;

public class FullscreenHandler {
    private final ChoiceModelApp fullscreenModel;
    public final FullscreenEventListener eventListener = new FullscreenEventListener();
    private static final int FULLSCREEN_INACTIVE = 0;
    private static final int FULLSCREEN_ACTIVE = 1;

    public FullscreenHandler(TVEnv tVEnv) {
        this.fullscreenModel = tVEnv.getChoiceModel(3926);
    }

    private class FullscreenEventListener
    extends TVEventDefaultListener {
        private FullscreenEventListener() {
        }

        public void onFullscreenEntered(int n) {
            FullscreenHandler.this.fullscreenModel.setValue(1);
        }

        public void onFullscreenLeft(int n) {
            FullscreenHandler.this.fullscreenModel.setValue(0);
        }
    }
}

