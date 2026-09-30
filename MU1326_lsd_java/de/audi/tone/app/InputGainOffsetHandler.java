/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app;

import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.hmi.model.RangeListener;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.tone.app.ToneEnv;
import de.audi.tone.app.dsi.IDSISoundHandler;
import de.audi.tone.app.intra.AbstractAppListener;
import java.util.Arrays;

public class InputGainOffsetHandler
extends AbstractAppListener
implements RangeListener {
    private static final int[] CONNECTIONS = new int[]{16, 17, 21};
    private final IDSISoundHandler dsiSound;
    private final ToneEnv env;
    private final RangeModelApp mediaAuxLevelRange;
    private final int[] activeConnections;

    public InputGainOffsetHandler(ToneEnv toneEnv, IDSISoundHandler iDSISoundHandler) {
        this.env = toneEnv;
        this.dsiSound = iDSISoundHandler;
        this.activeConnections = new int[8];
        Arrays.fill(this.activeConnections, 0);
        this.mediaAuxLevelRange = toneEnv.getRangeModel(0, 1000045);
        this.mediaAuxLevelRange.setRangeListener(this);
    }

    public void init(HMIAudioService hMIAudioService, int n) {
        this.requestRangeAndLevel(hMIAudioService.getActiveEntertainmentConnection(n), n);
    }

    public void updateConnectionStatus(int n, int n2, int n3) {
        if (n2 != 2) {
            return;
        }
        this.requestRangeAndLevel(n, n3);
    }

    private void requestRangeAndLevel(int n, int n2) {
        if (this.isUsedConnection(n)) {
            this.env.lcMain.log(10000000, "[InputGainOffsetHandler.requestRangeAndLevel] AC:%1 HT:%2", (long)n, (long)n2);
            if (n != this.activeConnections[n2]) {
                this.activeConnections[n2] = n;
                this.dsiSound.getInputGainOffsetRange(n2, n);
                this.dsiSound.getInputGainOffset(n2, n);
            }
        }
    }

    public void inputGainOffsetRange(int n, int n2) {
        this.env.lcMain.log(10000000, "[InputGainOffsetHandler.inputGainOffsetRange] min:%1 max:%2", (long)n, (long)n2);
        this.mediaAuxLevelRange.setLimits(n, n2, 1);
    }

    public void updateInputGainOffset(int n, int n2) {
        if (this.isUsedConnection(n)) {
            this.env.lcMain.log(10000000, "[InputGainOffsetHandler.updateInputGainOffset] inputGainOffset:%1", (long)n2);
            this.mediaAuxLevelRange.setValue(n2);
        } else {
            this.env.lcMain.log(10000000, "[InputGainOffsetHandler.updateInputGainOffset] connection :%1 is not in use do not update", (long)n2);
        }
    }

    public void decrement(int n, int n2, int n3) {
        int n4 = this.activeConnections[n3];
        if (n4 != 0) {
            this.env.lcHMI.log(10000000, "[InputGainOffsetHandler.decrement] model:%1 steps:%2 HT:%3", (long)n, (long)n2, (long)n3);
            this.dsiSound.changeInputGainOffset(n3, n4, -n2);
        } else {
            this.env.lcHMI.log(100000, "[InputGainOffsetHandler.decrement] No connection active for HT:%1", (long)n3);
        }
    }

    public void increment(int n, int n2, int n3) {
        int n4 = this.activeConnections[n3];
        if (n4 != 0) {
            this.env.lcHMI.log(10000000, "[InputGainOffsetHandler.increment] model:%1 steps:%2 HT:%3", (long)n, (long)n2, (long)n3);
            this.dsiSound.changeInputGainOffset(n3, n4, n2);
        } else {
            this.env.lcHMI.log(100000, "[InputGainOffsetHandler.increment] No connection active for HT:%1", (long)n3);
        }
    }

    public void keyTyped(int n, int n2, int n3) {
        this.env.lcHMI.log(10000000, "[InputGainOffsetHandler.keyTyped] model:%1 HT:%2", (long)n, (long)n3);
        this.mediaAuxLevelRange.fireEvent(n3);
    }

    private boolean isUsedConnection(int n) {
        return Arrays.binarySearch(CONNECTIONS, n) >= 0;
    }

    static {
        Arrays.sort(CONNECTIONS);
    }
}

