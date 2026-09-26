/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.sound;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tone.app.ToneEnv;
import de.audi.tone.app.dsi.IDSISoundHandler;
import de.audi.tone.app.intra.AbstractAppListener;
import de.audi.tone.app.intra.IAppSoundListener;
import de.audi.tone.app.sound.ThreeDMode$ThreeDChoiceListener;
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
        toneEnv.getChoiceModel(-666759424).setChoiceListener(new ThreeDMode$ThreeDChoiceListener(this, null));
        this.show3DModel = toneEnv.getChoiceModel(-800977152);
    }

    @Override
    public void updateThreeDMode(int n) {
        int n2 = MAP_DSI_TO_HMI.get(n);
        this.env.lcHMI.log(-2137614336, "[ThreeDMode.updateThreeDMode] mode3d:%1 -> index:%2", (long)n, (long)n2);
        this.env.getChoiceModel(-666759424).setValue(n2);
    }

    @Override
    public void updateThreeDModeRange(int n, int n2) {
        if (n == 0 && n2 == 0) {
            this.env.lcHMI.log(-2137614336, "[ThreeDMode.updateThreeDModeRange] do not show 3D mode");
            this.show3DModel.setValue(0);
        } else {
            this.env.lcHMI.log(-2137614336, "[ThreeDMode.updateThreeDModeRange] show 3D mode");
            this.show3DModel.setValue(1);
        }
    }

    @Override
    public void updateConnectionStatus(int n, int n2, int n3) {
        if ((n2 == 2 || n2 == 4) && n == 13 && MAP_HMI_TO_DSI[this.env.getChoiceModel(-666759424).getValue()] != 1) {
            this.dsiSound.setThreeDMode(1);
        }
    }

    static /* synthetic */ int[] access$100() {
        return MAP_HMI_TO_DSI;
    }

    static /* synthetic */ ToneEnv access$200(ThreeDMode threeDMode) {
        return threeDMode.env;
    }

    static /* synthetic */ IDSISoundHandler access$300(ThreeDMode threeDMode) {
        return threeDMode.dsiSound;
    }

    static {
        MAP_DSI_TO_HMI.add(1, 0);
        MAP_DSI_TO_HMI.add(2, 1);
        MAP_DSI_TO_HMI.add(4, 2);
        MAP_DSI_TO_HMI.add(8, 3);
    }
}

