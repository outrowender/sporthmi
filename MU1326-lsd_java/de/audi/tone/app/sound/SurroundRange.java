/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.sound;

import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.sysapp.carcoding.Coding;
import de.audi.tone.app.ToneEnv;
import de.audi.tone.app.dsi.IDSISoundHandler;
import de.audi.tone.app.sound.AbstractSoundRange;

public class SurroundRange
extends AbstractSoundRange
implements ChoiceListener {
    public static final int MODEL;
    public static final int ON_OFF_MODEL;
    public static final int SURROUND_ON;
    public static final int SURROUND_OFF;
    private static final int PREMIUM_ALPINE_BENTLEY;
    private static final int BENTLEY_SURROUND_OFF;
    private static final int BENTAYGA_CLASS;
    private static final int BENTAYGA_GENERATION;
    private static final int BENTAYGA_DERIVATE;
    private static final int BENTLEY_BENTAYGA_PREMIUM_STEP_WIDTH;
    private final ChoiceModelApp autoVolumeModel;

    SurroundRange(IDSISoundHandler iDSISoundHandler, ToneEnv toneEnv, int n) {
        super(iDSISoundHandler, toneEnv, 1749159680, -1740501248, n, false);
        this.autoVolumeModel = toneEnv.getChoiceModel(-1270739200);
        this.autoVolumeModel.setChoiceListener(this);
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.env.lcHMI.log(-2137614336, "[SurroundRange.itemSelected] modelID: %1, itemID: %2", (long)n, (long)n2);
        if (n2 == 1) {
            this.dsiSound.setSurround(0, true);
        } else {
            this.dsiSound.setSurround(0, false);
        }
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    @Override
    void changeBy(int n) {
        this.dsiSound.changeSurroundLevel(this.hmiTerminal, n);
    }

    @Override
    void updateLimits(int n, int n2) {
        super.updateLimits(n, n2);
        if (this.isBentleyBentayga() && this.isBentleyAlpinePremium()) {
            this.env.lcHMI.log(-2137614336, "[SurroundRange.updateLimits] set stepwith to %1 for BY-Bentayga-Premium", (long)0);
            this.model.setLimits(n, n2, 9);
        }
    }

    @Override
    protected void updateValue(int n, int n2) {
        this.env.lcHMI.log(-2137614336, "[SurroundRange.updateValue] modelID: %1, value: %2", (long)n, (long)n2);
        if (n == -1270739200) {
            this.autoVolumeModel.setValue(n2);
        } else {
            this.model.setValue(n2);
        }
    }

    @Override
    protected void updateValue(int n) {
        super.updateValue(n);
        if (this.isBentleyBentayga() && this.isBentleyAlpinePremium()) {
            this.dsiSound.setSurround(0, n != -9);
        }
    }

    private boolean isBentleyBentayga() {
        Coding coding = this.env.getFramework().getSysConstManager().getCarCoding();
        boolean bl = coding.getCarClass() == 7 && coding.getCarGeneration() == 3 && coding.getCarDerivate() == 6;
        return bl;
    }

    private boolean isBentleyAlpinePremium() {
        int n = this.env.getChoiceModel(1665273600).getValue();
        return n == 9;
    }
}

