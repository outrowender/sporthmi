/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.audi.atip.hmi.modelaccess.HMIModelGUI;
import de.audi.atip.hmi.modelaccess.RangeModel2DGUI;
import de.audi.atip.hmi.modelaccess.RangeModelGUI;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.IEmptyableWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.ProgressBarRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.menu.list.ListItemWidget;

public class ProgressBarController
extends AbstractWidgetController
implements ListItemWidget,
IEmptyableWidget {
    public static final float MIN_PROGRESS = 0.0f;
    public static final float MAX_PROGRESS = 1.0f;
    private ProgressBarRenderer renderer;
    private int minimumModelValue = -1;
    private int maximumModelValue = -1;
    private int bufferMinimumModelValue = -1;
    private int bufferMaximumModelValue = -1;
    private float progress;
    private float bufferProgress;
    private int modelColumn = -1;
    private boolean hasContent;

    public ProgressBarController() {
        this.resetContent();
    }

    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void setRenderer(ProgressBarRenderer progressBarRenderer) {
        this.renderer = progressBarRenderer;
    }

    protected void initializeWidget() {
        super.initializeWidget();
        this.updateContent();
    }

    public void disconnecting() {
        this.resetContent();
        super.disconnecting();
    }

    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        int n = modelUpdateEvent.getUpdateType();
        if (n == 1 || n == 4 || n == 14) {
            this.updateContent();
        }
        super.processModelUpdateEvent(modelUpdateEvent);
    }

    protected void updateContent() {
        float f2 = this.progress;
        float f3 = this.bufferProgress;
        boolean bl = this.hasContent;
        this.calculateContent();
        if (f2 != this.progress || f3 != this.bufferProgress) {
            this.setCompositesDirty(true);
        }
        if (bl != this.hasContent) {
            this.setCompositesDirty(true);
            this.invalidateParentLayout();
        }
    }

    protected void calculateContent() {
        if (this.model == null) {
            return;
        }
        if (this.model instanceof HMIModelGUI && ((HMIModelGUI)this.model).getStatus() == 3) {
            this.resetContent();
            return;
        }
        if (this.model instanceof RangeModelGUI) {
            RangeModelGUI rangeModelGUI = (RangeModelGUI)this.model;
            int n = this.minimumModelValue != -1 ? this.minimumModelValue : rangeModelGUI.getMinimum();
            int n2 = this.maximumModelValue != -1 ? this.maximumModelValue : rangeModelGUI.getMaximum();
            this.progress = this.calculateContentValue(n, n2, rangeModelGUI.getValue());
            this.hasContent = true;
        } else if (this.model instanceof RangeModel2DGUI) {
            RangeModel2DGUI rangeModel2DGUI = (RangeModel2DGUI)this.model;
            int n = this.minimumModelValue != -1 ? this.minimumModelValue : rangeModel2DGUI.getMinimumX();
            int n3 = this.maximumModelValue != -1 ? this.maximumModelValue : rangeModel2DGUI.getMaximumX();
            int n4 = this.bufferMinimumModelValue != -1 ? this.bufferMinimumModelValue : rangeModel2DGUI.getMinimumY();
            int n5 = this.bufferMaximumModelValue != -1 ? this.bufferMaximumModelValue : rangeModel2DGUI.getMaximumY();
            this.progress = this.calculateContentValue(n, n3, rangeModel2DGUI.getValueX());
            this.bufferProgress = this.calculateContentValue(n4, n5, rangeModel2DGUI.getValueY());
        } else if (this.model instanceof ChoiceModelGUI) {
            ChoiceModelGUI choiceModelGUI = (ChoiceModelGUI)this.model;
            this.progress = this.calculateContentValue(this.minimumModelValue, this.maximumModelValue, choiceModelGUI.getValue());
            this.hasContent = true;
        } else if (this.model instanceof IntegerListCell) {
            IntegerListCell integerListCell = (IntegerListCell)this.model;
            int n = this.maximumModelValue != -1 ? this.maximumModelValue : integerListCell.getMaxValue();
            int n6 = integerListCell.getValue();
            this.progress = this.calculateContentValue(this.minimumModelValue, n, n6);
            this.hasContent = this.calculateHasContent(this.minimumModelValue, n6);
        } else if (this.model instanceof Integer) {
            int n = (Integer)this.model;
            this.progress = this.calculateContentValue(this.minimumModelValue, this.maximumModelValue, n);
            this.hasContent = this.calculateHasContent(this.minimumModelValue, n);
        } else {
            logChannel.log(100000, "ProgressBarController#calculateContent: Unknown model %2: %1", this.model, (long)this.modelID);
            this.resetContent();
        }
    }

    protected void resetContent() {
        this.progress = 0.0f;
        this.bufferProgress = 0.0f;
        this.hasContent = true;
    }

    protected float calculateContentValue(int n, int n2, int n3) {
        int n4 = n2 - n;
        if (n4 == 0) {
            logChannel.log(100000, "ProgressBarController: min and max values are equal: %1, %2", (long)n, (long)n2);
            return 0.0f;
        }
        int n5 = n3 - n;
        float f2 = (float)n5 / (float)n4;
        return this.ensureValueValid(f2);
    }

    private boolean calculateHasContent(int n, int n2) {
        return n2 >= n;
    }

    private float ensureValueValid(float f2) {
        f2 = Math.max(f2, 0.0f);
        f2 = Math.min(f2, 1.0f);
        return f2;
    }

    public float getProgress() {
        return this.progress;
    }

    public float getBufferProgress() {
        return this.bufferProgress;
    }

    public void setProgress(float f2) {
        this.progress = f2;
    }

    public int getMinimumModelValue() {
        return this.minimumModelValue;
    }

    public void setMinimumModelValue(int n) {
        this.minimumModelValue = n;
    }

    public int getMaximumModelValue() {
        return this.maximumModelValue;
    }

    public void setMaximumModelValue(int n) {
        this.maximumModelValue = n;
    }

    public int getPreferredWidth() {
        if (this.preferredWidth != -1) {
            return this.preferredWidth;
        }
        if (this.renderer != null) {
            return this.renderer.getPreferredWidth();
        }
        return 0;
    }

    public int getPreferredHeight() {
        if (this.preferredHeight != -1) {
            return this.preferredHeight;
        }
        if (this.renderer != null) {
            return this.renderer.getPreferredHeight();
        }
        return 0;
    }

    public void setModelColumn(int n) {
        this.modelColumn = n;
    }

    public int getModelColumn() {
        return this.modelColumn;
    }

    public boolean hasContent() {
        return this.hasContent;
    }

    public boolean shouldRender() {
        return super.shouldRender() && this.hasContent;
    }
}

