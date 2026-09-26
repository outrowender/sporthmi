/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tv.app.FullscreenHandler$FullscreenEventListener;
import de.audi.tv.app.base.TVEnv;

public class FullscreenHandler {
    private final ChoiceModelApp fullscreenModel;
    public final FullscreenHandler$FullscreenEventListener eventListener = new FullscreenHandler$FullscreenEventListener(this, null);
    private static final int FULLSCREEN_INACTIVE;
    private static final int FULLSCREEN_ACTIVE;

    public FullscreenHandler(TVEnv tVEnv) {
        this.fullscreenModel = tVEnv.getChoiceModel(3926);
    }

    static /* synthetic */ ChoiceModelApp access$100(FullscreenHandler fullscreenHandler) {
        return fullscreenHandler.fullscreenModel;
    }
}

