/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.volume.lowered;

import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tone.app.ToneEnv;
import de.audi.tone.app.dsi.IDSISoundHandler;
import de.audi.tone.app.volume.AbstractVolumeRange;
import de.audi.tone.app.volume.VolumeRangeManager;
import de.esolutions.fw.util.commons.Buffer;

public abstract class AbstractLoweredEnt
extends AbstractVolumeRange
implements ChoiceListener {
    private static final int INDEX_OFF;
    private static final int INDEX_LOW;
    private static final int INDEX_MIDDLE;
    private static final int INDEX_STRONG;
    protected final IDSISoundHandler dsiSound;
    protected final ChoiceModelApp ddbchoiceModel;
    private final String LABEL;
    protected final ToneEnv env;
    private int focusedIndex = -1;
    protected boolean loweringInitialized = false;

    AbstractLoweredEnt(VolumeRangeManager volumeRangeManager, IDSISoundHandler iDSISoundHandler, String string, int n, int n2) {
        this(volumeRangeManager, iDSISoundHandler, string, n, -1, n2);
    }

    AbstractLoweredEnt(VolumeRangeManager volumeRangeManager, IDSISoundHandler iDSISoundHandler, String string, int n, int n2, int n3) {
        super(volumeRangeManager, n2, -1, n);
        this.env = volumeRangeManager.getEnv();
        this.dsiSound = iDSISoundHandler;
        this.LABEL = new Buffer(100).append("[").append(this.getName()).append("] [AbstractLoweredEnt").toString();
        this.ddbchoiceModel = n3 == -1 ? new ChoiceModel(n3) : this.env.getChoiceModel(n3);
        this.ddbchoiceModel.setChoiceListener(this);
    }

    public abstract int getLoweringType() {
    }

    abstract int getModelID() {
    }

    void opened() {
        this.env.lcHMI.log(-2137614336, "%1.opened]", (Object)this.LABEL);
        this.volMenuManager.entered(this.getID(), 0);
    }

    void closed() {
        this.env.lcHMI.log(-2137614336, "%1.closed]", (Object)this.LABEL);
        this.volMenuManager.left(this.getID(), 0);
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
        int n5 = n2 == -1 ? this.getPreset(this.ddbchoiceModel.getValue()) : this.getPreset(n2);
        this.env.lcHMI.log(-2137614336, "%1.itemFocused] index:%2 preset:%3", (Object)this.LABEL, (long)n2, (long)n5);
        if (n2 == -1) {
            this.closed();
        } else if (n2 > -1 && this.focusedIndex == -1) {
            this.opened();
        }
        this.focusedIndex = n2;
        this.dsiSound.setLoweringEntertainment(this.getLoweringType(), n5);
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.env.lcHMI.log(-2137614336, "%1.itemSelected] index:%2", (Object)this.LABEL, (long)n2);
        this.ddbchoiceModel.setValue(n2);
    }

    @Override
    public void viewSizeChanged(int n) {
        this.env.lcHMI.log(-2137614336, "%1.viewSizeChanged] do nothing, no impact on DDB ", (Object)this.LABEL);
    }

    public void updateLoweringEntertainment(int n, int n2) {
        int n3;
        this.env.lcHMI.log(-2137614336, "%1.updateLoweringEntertainment] entType:%2 preset:%3", (Object)this.LABEL, (long)n, (long)n2);
        if (this.focusedIndex != -1) {
            return;
        }
        if (n == this.getLoweringType()) {
            int n4 = this.getIndex(n2);
            this.env.lcHMI.log(-2137614336, "%1.updateLoweringEntertainment] index:%2 preset:%3", (Object)this.LABEL, (long)n4, (long)n2);
            this.ddbchoiceModel.setValue(n4);
            if (!this.loweringInitialized) {
                this.env.lcDSI.log(1078071040, "%1.updateLoweringEntertainment] loweringInitialized", (Object)this.LABEL);
                this.loweringInitialized = true;
            }
        } else if (!this.loweringInitialized && (n3 = this.audioService.getActiveEntertainmentConnection(0)) != 0) {
            this.env.lcHMI.log(-2137614336, "%1.updateLoweringEntertainment] getLoweringEntertainment for connection:%2, entType:%3", (Object)this.LABEL, (long)n3, (long)this.getLoweringType());
            this.dsiSound.getLoweringEntertainment(n3, 0, this.getLoweringType());
        }
    }

    @Override
    protected void limitVolumeToHmiLimits() {
        this.env.lcHMI.log(-2137614336, "%1.limitVolumeToHmiLimits] don\u00b4t limit in Lowering DDB", (Object)this.LABEL);
    }

    @Override
    public void decrease(int n, int n2) {
        this.env.lcHMI.log(-2137614336, "%1.decrease] don\u00b4t adjust volume while Lowering DDB is open", (Object)this.LABEL);
    }

    @Override
    public void increase(int n, int n2) {
        this.env.lcHMI.log(-2137614336, "%1.increase] don\u00b4t adjust volume while Lowering DDB is open", (Object)this.LABEL);
    }

    private int getPreset(int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 1: {
                return 2;
            }
            case 2: {
                return 3;
            }
            case 3: {
                return 4;
            }
        }
        this.env.lcHMI.log(-2137614336, "%1.getPreset] Unknown lowering index %2", (Object)this.LABEL, (long)n);
        return -1;
    }

    private int getIndex(int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 2: {
                return 1;
            }
            case 3: {
                return 2;
            }
            case 4: {
                return 3;
            }
        }
        this.env.lcHMI.log(-2137614336, "%1.getPreset] Unknown lowering preset %2", (Object)this.LABEL, (long)n);
        return -1;
    }
}

