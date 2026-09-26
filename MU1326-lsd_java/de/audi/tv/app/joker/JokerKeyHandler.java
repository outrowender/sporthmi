/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.joker;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tv.app.HardKeyListener;
import de.audi.tv.app.audio.AudioFocusClient;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.joker.JokerKeyHandler$ButtonListener;

public class JokerKeyHandler {
    private final HardKeyListener hardKeyListener;
    private final AudioFocusClient audioFocusClient;
    private final ChoiceModelApp jokerMeaning;

    public JokerKeyHandler(TVEnv tVEnv, HardKeyListener hardKeyListener, AudioFocusClient audioFocusClient) {
        this.hardKeyListener = hardKeyListener;
        this.audioFocusClient = audioFocusClient;
        this.jokerMeaning = tVEnv.getChoiceModel(395);
        tVEnv.getButtonModel(229451520).setButtonListener(new JokerKeyHandler$ButtonListener(this, null));
    }

    static /* synthetic */ ChoiceModelApp access$100(JokerKeyHandler jokerKeyHandler) {
        return jokerKeyHandler.jokerMeaning;
    }

    static /* synthetic */ AudioFocusClient access$200(JokerKeyHandler jokerKeyHandler) {
        return jokerKeyHandler.audioFocusClient;
    }

    static /* synthetic */ HardKeyListener access$300(JokerKeyHandler jokerKeyHandler) {
        return jokerKeyHandler.hardKeyListener;
    }
}

