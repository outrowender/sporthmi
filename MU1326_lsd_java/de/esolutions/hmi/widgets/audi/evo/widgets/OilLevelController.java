/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.IEmptyableWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListItemWidget;

public class OilLevelController
extends AbstractWidgetController
implements ListItemWidget,
IEmptyableWidget {
    private int modelColumn = -1;
    private int maxLevel;
    private int minLevel;
    private int maxBars;
    private IRenderer renderer;
    private int level;
    private int barCount;
    private int[] barOffset = new int[]{0, 0};
    private boolean horizontal = false;

    @Override
    protected void initializeWidget() {
        super.initializeWidget();
        this.updateModelValue();
    }

    private void updateModelValue() {
        if (this.model != null && this.model instanceof ChoiceModelGUI) {
            if (this.getChildren().size() == 1) {
                this.maxLevel = this.maxBars = ((ChoiceModelGUI)((AbstractWidgetController)this.getChild(0)).getModel()).getValue();
            }
            this.level = ((ChoiceModelGUI)this.model).getValue();
            float f2 = 0.0f;
            if (this.level != 0) {
                f2 = (float)this.maxBars / (float)this.maxLevel * (float)this.level;
            }
            this.barCount = Math.min(this.maxLevel, Math.round(f2));
            this.barCount = Math.max(this.minLevel, Math.round(f2));
        }
    }

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        int n = this.barCount;
        int n2 = this.maxBars;
        this.updateModelValue();
        if (n != this.barCount) {
            this.setCompositesDirty(true);
        }
        if (n2 != this.maxBars) {
            this.setCompositesDirty(true);
        }
        super.processModelUpdateEvent(modelUpdateEvent);
    }

    @Override
    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void setRenderer(IRenderer iRenderer) {
        this.renderer = iRenderer;
    }

    public void setLevel(int n) {
        this.level = n;
    }

    public int getLevel() {
        return this.level;
    }

    public int getBarCount() {
        return this.barCount;
    }

    public void setMinLevel(int n) {
        this.minLevel = n;
    }

    public int getMinlevbel() {
        return this.minLevel;
    }

    public void setMaxLevel(int n) {
        this.maxLevel = n;
    }

    public int getMaxLevel() {
        return this.maxLevel;
    }

    public void setMaxBars(int n) {
        this.maxBars = n;
    }

    public int getMaxBars() {
        return this.maxBars;
    }

    public void setBarOffset(int n, int n2) {
        this.barOffset = new int[]{n, n2};
    }

    public int[] getBarOffset() {
        return this.barOffset;
    }

    public void setHorizontal(boolean bl) {
        this.horizontal = bl;
    }

    public boolean isHorizontal() {
        return this.horizontal;
    }

    @Override
    public int getModelColumn() {
        return this.modelColumn;
    }

    public void setModelColumn(int n) {
        this.modelColumn = n;
    }

    @Override
    public boolean hasContent() {
        return this.model != null;
    }
}

