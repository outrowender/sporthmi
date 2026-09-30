/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.sound;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tone.app.ToneEnv;
import de.audi.tone.app.dsi.IDSISoundHandler;
import de.audi.tone.app.intra.AbstractAppListener;
import de.audi.tone.app.intra.IAppSoundListener;
import de.esolutions.fw.util.commons.SimpleIntIntMap;

public class ThreeDMode
extends AbstractAppListener
implements IAppSoundListener {
    private static final int[] MAP_HMI_TO_DSI = new int[]{1, 2, 4, 8};
    private static final SimpleIntIntMap MAP_DSI_TO_HMI = new SimpleIntIntMap();
    private final ToneEnv env;
    private final IDSISoundHandler dsiSound;
    private ChoiceModelApp show3DModel;

    public ThreeDMode(ToneEnv toneEnv, IDSISoundHandler iDSISoundHandler) {
        this.env = toneEnv;
        this.dsiSound = iDSISoundHandler;
        toneEnv.getChoiceModel(1000152).setChoiceListener(new ThreeDChoiceListener());
        this.show3DModel = toneEnv.getChoiceModel(1000144);
    }

    public void updateThreeDMode(int n) {
        int n2 = MAP_DSI_TO_HMI.get(n);
        this.env.lcHMI.log(10000000, "[ThreeDMode.updateThreeDMode] mode3d:%1 -> index:%2", (long)n, (long)n2);
        this.env.getChoiceModel(1000152).setValue(n2);
    }

    public void updateThreeDModeRange(int n, int n2) {
        if (n == 0 && n2 == 0) {
            this.env.lcHMI.log(10000000, "[ThreeDMode.updateThreeDModeRange] do not show 3D mode");
            this.show3DModel.setValue(0);
        } else {
            this.env.lcHMI.log(10000000, "[ThreeDMode.updateThreeDModeRange] show 3D mode");
            this.show3DModel.setValue(1);
        }
    }

    public void updateConnectionStatus(int n, int n2, int n3) {
        if ((n2 == 2 || n2 == 4) && n == 13 && MAP_HMI_TO_DSI[this.env.getChoiceModel(1000152).getValue()] != 1) {
            this.dsiSound.setThreeDMode(1);
        }
    }

    static {
        MAP_DSI_TO_HMI.add(1, 0);
        MAP_DSI_TO_HMI.add(2, 1);
        MAP_DSI_TO_HMI.add(4, 2);
        MAP_DSI_TO_HMI.add(8, 3);
    }

    private class ThreeDChoiceListener
    extends DefaultChoiceListener {
        private ThreeDChoiceListener() {
        }

        public void itemSelected(int n, int n2, int n3, int n4) {
            int n5 = MAP_HMI_TO_DSI[n2];
            ((ThreeDMode)ThreeDMode.this).env.lcHMI.log(10000000, "[ThreeDMode.itemSelected] index:%1 -> mode3d:%2", (long)n2, (long)n5);
            ThreeDMode.this.dsiSound.setThreeDMode(n5);
        }
    }
}

