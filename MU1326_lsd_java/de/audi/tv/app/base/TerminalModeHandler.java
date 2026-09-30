/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.tv.app.ap.TVActionProxyDefaultListenerEvo;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.tm.handling.TerminalAndScreenModeHandler;

public class TerminalModeHandler {
    final TVActionProxy actionProxy = new TVActionProxy();
    private final TerminalAndScreenModeHandler.Properties terminalModeProperties;

    TerminalModeHandler(TerminalAndScreenModeHandler.Properties properties) {
        this.terminalModeProperties = properties;
    }

    public TerminalModeHandler(TVEnv tVEnv) {
        this(tVEnv.properties.terminalMode);
    }

    private class TVActionProxy
    extends TVActionProxyDefaultListenerEvo {
        private TVActionProxy() {
        }

        public void tvDataBroadcastEntered(int n) {
            Integer n2 = (Integer)((TerminalModeHandler)TerminalModeHandler.this).terminalModeProperties.correctDataBroadcastTerminalMode.get();
            if (n2 != null) {
                ((TerminalModeHandler)TerminalModeHandler.this).terminalModeProperties.desiredTerminalMode.accept(n2);
            }
        }

        public void tvEPGEntered(int n) {
            ((TerminalModeHandler)TerminalModeHandler.this).terminalModeProperties.desiredTerminalMode.accept(new Integer(13));
        }

        public void tvTeletextEntered(int n) {
            ((TerminalModeHandler)TerminalModeHandler.this).terminalModeProperties.desiredTerminalMode.accept(new Integer(1));
        }

        public void tvEngineeringEntered(int n) {
            ((TerminalModeHandler)TerminalModeHandler.this).terminalModeProperties.desiredTerminalMode.accept(new Integer(15));
        }

        public void tvCasDisclaimerEntered(int n) {
            ((TerminalModeHandler)TerminalModeHandler.this).terminalModeProperties.desiredTerminalMode.accept(new Integer(12));
        }

        public void tvVisualAudioEntered(int n) {
            ((TerminalModeHandler)TerminalModeHandler.this).terminalModeProperties.desiredTerminalMode.accept(new Integer(14));
        }

        public void avFullscreenEntered(int n) {
            ((TerminalModeHandler)TerminalModeHandler.this).terminalModeProperties.desiredTerminalMode.accept(new Integer(0));
        }

        public void tvParentalRatingLeft(int n) {
        }

        public void tvTxtEntered(int n) {
            ((TerminalModeHandler)TerminalModeHandler.this).terminalModeProperties.desiredTerminalMode.accept(new Integer(11));
        }
    }
}

