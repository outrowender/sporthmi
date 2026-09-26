/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AbstractConversionWidgetController$ICandidateItem;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ConversionMatrixController;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.ConversionMatrixController$1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConversionMatrixController$ViewPort {
    private int topRowIndex = -1;
    private int bottomRowIndex = -1;
    private boolean viewPortChanged;
    private List viewPortData = new ArrayList();
    private final /* synthetic */ ConversionMatrixController this$0;

    private ConversionMatrixController$ViewPort(ConversionMatrixController conversionMatrixController) {
        this.this$0 = conversionMatrixController;
        this.reset();
    }

    private void reset() {
        this.topRowIndex = 0;
        this.bottomRowIndex = 2;
        this.viewPortChanged();
    }

    private int getDeltaFromTop() {
        return this.topRowIndex / 1;
    }

    void updateViewPortRowIndex(int n) {
        if (n < this.topRowIndex) {
            this.topRowIndex = n;
            this.bottomRowIndex = this.topRowIndex + 3 - 1;
            this.viewPortChanged();
        } else if (n > this.bottomRowIndex) {
            this.bottomRowIndex = n;
            this.topRowIndex = this.bottomRowIndex - 3 + 1;
            this.viewPortChanged();
        }
    }

    public int getTopRowIndex() {
        return this.topRowIndex;
    }

    public int getBottomRowIndex() {
        return this.bottomRowIndex;
    }

    public List getCandidates() {
        AbstractConversionWidgetController$ICandidateItem abstractConversionWidgetController$ICandidateItem;
        int n;
        this.viewPortData.clear();
        Iterator iterator = this.this$0.getCandidateIterator();
        while (iterator.hasNext() && (n = (abstractConversionWidgetController$ICandidateItem = (AbstractConversionWidgetController$ICandidateItem)iterator.next()).getRowIndex()) <= this.getBottomRowIndex()) {
            if (n < this.getTopRowIndex()) continue;
            this.viewPortData.add(abstractConversionWidgetController$ICandidateItem);
        }
        return this.viewPortData;
    }

    private void viewPortChanged() {
        this.this$0.setDataChanged(true);
        this.viewPortChanged = true;
    }

    public boolean hasChanged() {
        return this.viewPortChanged;
    }

    public void onChangeRendered() {
        this.viewPortChanged = false;
    }

    /* synthetic */ ConversionMatrixController$ViewPort(ConversionMatrixController conversionMatrixController, ConversionMatrixController$1 conversionMatrixController$1) {
        this(conversionMatrixController);
    }

    static /* synthetic */ int access$100(ConversionMatrixController$ViewPort conversionMatrixController$ViewPort) {
        return conversionMatrixController$ViewPort.getDeltaFromTop();
    }

    static /* synthetic */ void access$200(ConversionMatrixController$ViewPort conversionMatrixController$ViewPort) {
        conversionMatrixController$ViewPort.reset();
    }
}

