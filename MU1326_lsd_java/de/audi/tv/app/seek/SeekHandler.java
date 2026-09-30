/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.seek;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.log.LogChannel;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DSIHandler;

public class SeekHandler {
    private final DSIHandler dsi;
    private final LogChannel logChannel;

    public SeekHandler(TVEnv tVEnv, DSIHandler dSIHandler, LogChannel logChannel) {
        this.dsi = dSIHandler;
        this.logChannel = logChannel;
        ButtonListener buttonListener = new ButtonListener();
        tVEnv.getButtonModel(2600110).setButtonListener(buttonListener);
        tVEnv.getButtonModel(2600111).setButtonListener(buttonListener);
    }

    public void abortSeek() {
        this.logChannel.log(10000000, "[SeekHandler.abortSeek] seek abortion requested.");
        this.dsi.abortSeek();
    }

    private class ButtonListener
    extends DefaultButtonListener {
        private ButtonListener() {
        }

        public void keyPressed(int n, int n2, int n3) {
            switch (n) {
                case 2600110: {
                    SeekHandler.this.logChannel.log(10000000, "[SeekHandler.ButtonListener.keyPressed] seek upwards (frequenzy wise)");
                    SeekHandler.this.dsi.selectNextService(1);
                    break;
                }
                case 2600111: {
                    SeekHandler.this.logChannel.log(10000000, "[SeekHandler.ButtonListener.keyPressed] seek downwards (frequenzy wise)");
                    SeekHandler.this.dsi.selectNextService(2);
                    break;
                }
            }
        }
    }
}

