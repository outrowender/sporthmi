/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;

public class MixedListPlaceholder
extends AbstractWidgetController {
    private int dataCellIndex = -1;
    private int alignmentHorizontal = 1;
    private int alignmentVertical = 4;
    private boolean isCenterAligned = false;
    public MixedListPlaceholder secondaryEntity;
    public Object additionalData;

    public MixedListPlaceholder() {
    }

    public MixedListPlaceholder(int n) {
        this.setModelColumn(n);
    }

    public MixedListPlaceholder(int n, int n2, int n3, int n4, int n5) {
        this.setModelColumn(n);
        this.setBounds(n2, n3, n4, n5);
    }

    public MixedListPlaceholder(int n, int n2, int n3, int n4, int n5, boolean bl) {
        this(n, n2, n3, n4, n5);
        this.setCenterAligned(bl);
    }

    public MixedListPlaceholder(int n, int n2, int n3, int n4, int n5, Object object) {
        this(n, n2, n3, n4, n5);
        this.additionalData = object;
    }

    public MixedListPlaceholder(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        this(n, n2, n3, n4, n5);
        this.setAlignment(n6, n7);
    }

    public MixedListPlaceholder(int n, int n2, int n3, int n4, int n5, int n6, int n7, MixedListPlaceholder mixedListPlaceholder) {
        this(n, n2, n3, n4, n5, n6, n7);
        this.secondaryEntity = mixedListPlaceholder;
    }

    public int getHorizontalAlignment() {
        return this.alignmentHorizontal;
    }

    public int getModelColumn() {
        return this.dataCellIndex;
    }

    @Override
    public IRenderer getRenderer() {
        return null;
    }

    public int getVerticalAlignment() {
        return this.alignmentVertical;
    }

    public boolean isCenterAligned() {
        return this.isCenterAligned;
    }

    public void setAlignment(int n, int n2) {
        this.alignmentHorizontal = n;
        this.alignmentVertical = n2;
    }

    public void setCenterAligned(boolean bl) {
        this.isCenterAligned = bl;
    }

    public void setModelColumn(int n) {
        this.dataCellIndex = n;
    }
}

