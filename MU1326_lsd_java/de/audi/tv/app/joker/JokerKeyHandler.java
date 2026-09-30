/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.joker;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tv.app.HardKeyListener;
import de.audi.tv.app.audio.AudioFocusClient;
import de.audi.tv.app.base.TVEnv;

public class JokerKeyHandler {
    private final HardKeyListener hardKeyListener;
    private final AudioFocusClient audioFocusClient;
    private final ChoiceModelApp jokerMeaning;

    public JokerKeyHandler(TVEnv tVEnv, HardKeyListener hardKeyListener, AudioFocusClient audioFocusClient) {
        this.hardKeyListener = hardKeyListener;
        this.audioFocusClient = audioFocusClient;
        this.jokerMeaning = tVEnv.getChoiceModel(395);
        tVEnv.getButtonModel(2600205).setButtonListener(new ButtonListener());
    }

    private class ButtonListener
    extends DefaultButtonListener {
        private ButtonListener() {
        }

        public void keyPressed(int n, int n2, int n3) {
            int n4 = JokerKeyHandler.this.jokerMeaning.getValue();
            boolean bl = JokerKeyHandler.this.audioFocusClient.hasAudioFocus(0);
            if (bl) {
                if (n4 == 9) {
                    JokerKeyHandler.this.hardKeyListener.simulateHkNext(n3);
                } else if (n4 == 14) {
                    JokerKeyHandler.this.hardKeyListener.simualteHkPrev(n3);
                }
            }
        }
    }
}

