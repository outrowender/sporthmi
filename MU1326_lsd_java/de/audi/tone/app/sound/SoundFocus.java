/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.sound;

import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tone.app.ToneEnv;
import de.audi.tone.app.dsi.IDSISoundHandler;
import de.audi.tone.app.intra.AbstractAppListener;

public class SoundFocus
extends AbstractAppListener
implements ChoiceListener {
    static final int INDEX_ALL = 0;
    static final int INDEX_DRIVER = 1;
    static final int INDEX_MOVIE = 2;
    static final int INDEX_FRONT = 3;
    static final int INDEX_REAR = 4;
    private static final int COUNT = 5;
    protected final LogChannel lc;
    private final IDSISoundHandler dsiSound;
    protected int[] presets;
    protected final ChoiceModelApp choiceModel;

    public SoundFocus(ToneEnv toneEnv, IDSISoundHandler iDSISoundHandler) {
        this.lc = toneEnv.lcHMI;
        this.dsiSound = iDSISoundHandler;
        this.choiceModel = toneEnv.getChoiceModel(1000014);
        this.choiceModel.setChoiceListener(this);
        this.init(toneEnv);
    }

    protected void init(ToneEnv toneEnv) {
        this.presets = new int[5];
        this.presets[0] = 1;
        this.presets[1] = 8;
        this.presets[2] = 16;
        this.presets[3] = 2;
        this.presets[4] = 4;
    }

    public void updatePresetPositionList(int n) {
        int n2 = 0;
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        boolean bl5 = false;
        if (this.isSet(n, 1)) {
            n2 |= 1;
            bl = true;
        }
        if (this.isSet(n, 2)) {
            n2 |= 8;
            bl2 = true;
        }
        if (this.isSet(n, 4)) {
            n2 |= 0x10;
            bl3 = true;
        }
        if (this.isSet(n, 8)) {
            n2 |= 2;
            bl5 = true;
        }
        if (this.isSet(n, 16)) {
            n2 |= 4;
            bl4 = true;
        }
        this.choiceModel.resetHints();
        this.choiceModel.addHint(n2);
        this.choiceModel.publishHints();
        if (this.lc.isDebug()) {
            this.lc.log(10000000, "[SoundFocus.updatePresetPositionList] presetPositionList:0b%1 hints:0b%2", (Object)Integer.toBinaryString(n), (Object)Integer.toBinaryString(n2));
            this.lc.log(10000000, "[SoundFocus.updatePresetPositionList] [%1] all", bl ? (char)'x' : ' ');
            this.lc.log(10000000, "[SoundFocus.updatePresetPositionList] [%1] movie", bl4 ? (char)'x' : ' ');
            this.lc.log(10000000, "[SoundFocus.updatePresetPositionList] [%1] front", bl2 ? (char)'x' : ' ');
            this.lc.log(10000000, "[SoundFocus.updatePresetPositionList] [%1] rear", bl3 ? (char)'x' : ' ');
            this.lc.log(10000000, "[SoundFocus.updatePresetPositionList] [%1] driver", bl5 ? (char)'x' : ' ');
        }
    }

    public void updatePresetPosition(int n) {
        for (int i2 = 0; i2 < this.presets.length; ++i2) {
            if (n != this.presets[i2]) continue;
            this.lc.log(10000000, "[SoundFocus.updatePresetPosition] presetPosition:%1 index:%2", (long)n, (long)i2);
            this.choiceModel.setValue(i2);
            return;
        }
        this.lc.log(10000, "[SoundFocus.updatePresetPosition] Unknown presetPosition %1", (long)n);
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        this.lc.log(10000000, "[SoundFocus.itemSelected] index:%1", (long)n2);
        if (n2 < this.presets.length) {
            this.dsiSound.setPresetPosition(n4, this.presets[n2]);
        } else {
            this.lc.log(10000, "[SoundFocus.itemSelected] index:%1 out of range!", (long)n2);
        }
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    protected boolean isSet(int n, int n2) {
        return (n & n2) == n2;
    }
}

