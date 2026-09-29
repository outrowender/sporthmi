/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.hmi.model.DefaultOptionListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.amfm.IDoTagging;
import de.audi.tuner.app.memory.AmFmMemoryRow;
import de.audi.tuner.app.memory.SDARSMemoryRow;

class TaggingOptionModelListener
extends DefaultOptionListener {
    private final IDoTagging hdTagging;
    private final IDoTagging sdarsTagging;
    private final TunerModels models;

    TaggingOptionModelListener(TunerBasics tunerBasics, IDoTagging iDoTagging, IDoTagging iDoTagging2) {
        this.models = tunerBasics.getModels();
        this.hdTagging = iDoTagging;
        this.sdarsTagging = iDoTagging2;
        this.models.getOptionModel(8978688).setListener(this, 1753743616);
        this.models.getOptionModel(8978688).setListener(this, 1770520832);
        this.models.getOptionModel(8978688).setListener(this, 2005401856);
        this.models.getOptionModel(8978688).setListener(this, 1938292992);
        this.models.getOptionModel(8978688).setListener(this, 1921515776);
    }

    @Override
    public void keyTyped(int n, int n2, int n3, int n4, int n5) {
        switch (n2) {
            case 100456: 
            case 100457: {
                this.hdTagging.doTagging(n, n5);
                TunerProxyManager.getInstance().getAmFmTuner().setNotification(new int[]{20});
                break;
            }
            case 100471: {
                this.sdarsTagging.doTagging(n, n5);
                break;
            }
            default: {
                EvoListRow evoListRow = this.models.getBaseListModel(n2).getRow(n3);
                if (evoListRow instanceof SDARSMemoryRow) {
                    this.sdarsTagging.doTagging(n, n5);
                    break;
                }
                if (!(evoListRow instanceof AmFmMemoryRow)) break;
                this.hdTagging.doTagging(n, n5);
                TunerProxyManager.getInstance().getAmFmTuner().setNotification(new int[]{20});
            }
        }
    }
}

