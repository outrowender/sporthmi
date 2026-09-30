/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.HMIImageConstantsSystem;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.audi.atip.hmi.modelaccess.HMIModelGUI;
import de.audi.atip.hmi.modelaccess.RangeModelGUI;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.ExtHMITerminalEvo;
import de.esolutions.hmi.widgets.audi.evo.widgets.IStatusbarChild;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconRenderer;

public class ProgressIconController
extends AbstractWidgetController
implements IStatusbarChild {
    private IRenderer renderer;
    private IconController icon;
    private IconController progressPixel;
    private int rangeMax;
    private int progressBarXOffset;
    private int progressBarWidth;
    private int processStateChange = 0;
    private int lastModelValue = 0;
    private int lastModelState;

    public void setProgressBarXOffset(int n) {
        this.progressBarXOffset = n;
    }

    public void setProgressBarWidth(int n) {
        this.progressBarWidth = n;
    }

    public ProgressIconController() {
    }

    public ProgressIconController(IRenderer iRenderer) {
        this.renderer = iRenderer;
    }

    public void setRenderer(IRenderer iRenderer) {
        this.renderer = iRenderer;
    }

    public IRenderer getRenderer() {
        return this.renderer;
    }

    protected void initializeWidget() {
        if (this.icon == null) {
            this.createIcon();
            if (this.progressBarWidth == 0) {
                this.progressBarWidth = 46;
                this.progressBarXOffset = 12;
            }
        }
        if (this.progressPixel == null) {
            this.createProgressPixel();
        }
        this.icon.setProcessStateChange(this.processStateChange);
        this.progressPixel.setProcessStateChange(this.processStateChange);
        this.setMinMax();
        super.initializeWidget();
    }

    private void setMinMax() {
        if (this.model != null) {
            if (this.model instanceof RangeModelGUI) {
                this.rangeMax = ((RangeModelGUI)this.model).getMaximum();
            } else if (this.model instanceof ChoiceModelGUI) {
                this.rangeMax = 100;
            }
        }
    }

    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        this.rangeMax = this.getModelMax();
        int n = this.getModelValue();
        int n2 = this.getModelStatus();
        if (n > this.rangeMax) {
            n = this.rangeMax;
        }
        int n3 = (int)((float)this.progressBarWidth * (float)n / (float)this.rangeMax + 0.5f);
        n3 = Math.max(n3, 1);
        if (this.progressPixel != null) {
            boolean bl;
            ((IconRenderer)this.progressPixel.getRenderer()).setScaleFactor(n3, 6.0f);
            this.progressPixel.setBounds(this.progressBarXOffset, 12, this.progressBarWidth, this.icon.getPreferredHeight());
            this.progressPixel.setCompositesDirty(true);
            this.setCompositesDirty(true);
            boolean bl2 = this.lastModelValue == 0 && n != 0 || this.lastModelValue != 0 && n == 0;
            boolean bl3 = bl = this.lastModelState != n2;
            if (bl2 || bl) {
                this.invalidateParentLayout();
            }
        }
        this.lastModelValue = n;
        this.lastModelState = n2;
        super.processModelUpdateEvent(modelUpdateEvent);
    }

    private void createIcon() {
        this.icon = new IconController();
        IconRenderer iconRenderer = ((ExtHMITerminalEvo)((Object)this.getTerminalImpl())).getRendererFactory().createIconRenderer(this.icon);
        this.icon.setRenderer(iconRenderer);
        this.icon.setBitmaps(new int[]{this.getBitmap(0)});
        this.icon.setVisible(true);
        this.add(this.icon);
        this.icon.setBounds(0, 0, this.icon.getPreferredWidth(), this.icon.getPreferredHeight());
    }

    private void createProgressPixel() {
        this.progressPixel = new IconController();
        this.progressPixel.setProcessStateChange(2);
        IconRenderer iconRenderer = ((ExtHMITerminalEvo)((Object)this.getTerminalImpl())).getRendererFactory().createIconRenderer(this.progressPixel);
        iconRenderer.setScaleFactor(0.1f, 5.0f);
        iconRenderer.setAlignment(1, 5);
        this.progressPixel.setRenderer(iconRenderer);
        this.progressPixel.setBitmaps(new int[]{HMIImageConstantsSystem.white_pixel});
        this.progressPixel.setVisible(true);
        this.add(this.progressPixel);
        this.progressPixel.setBounds(this.progressBarXOffset, 10, this.progressBarWidth, 5);
    }

    public int getModelValue() {
        if (this.model != null) {
            if (this.model instanceof ChoiceModelGUI) {
                return ((ChoiceModelGUI)this.model).getValue();
            }
            if (this.model instanceof RangeModelGUI) {
                return ((RangeModelGUI)this.model).getValue();
            }
        }
        return -1;
    }

    public int getModelStatus() {
        if (this.model != null && this.model instanceof HMIModelGUI) {
            return ((HMIModelGUI)this.model).getStatus();
        }
        return 3;
    }

    public int getModelMin() {
        if (this.model != null) {
            if (this.model instanceof RangeModelGUI) {
                return ((RangeModelGUI)this.model).getMinimum();
            }
            if (this.model instanceof ChoiceModelGUI) {
                return 0;
            }
        }
        return -1;
    }

    public int getModelMax() {
        if (this.model != null) {
            if (this.model instanceof RangeModelGUI) {
                return ((RangeModelGUI)this.model).getMaximum();
            }
            if (this.model instanceof ChoiceModelGUI) {
                return 100;
            }
        }
        return -1;
    }

    public int getHeight() {
        return this.icon == null ? 0 : this.icon.getHeight();
    }

    public int getPreferredHeight() {
        return this.icon == null ? 0 : this.icon.getPreferredHeight();
    }

    public int getWidth() {
        return this.icon == null ? 0 : this.icon.getWidth();
    }

    public int getPreferredWidth() {
        return this.icon == null ? 0 : this.icon.getPreferredWidth();
    }

    public void setProcessStateChange(int n) {
        this.processStateChange = n;
        if (this.icon != null) {
            this.icon.setProcessStateChange(n);
        }
        if (this.progressPixel != null) {
            this.progressPixel.setProcessStateChange(n);
        }
    }

    public void setEnabled(boolean bl) {
        if (this.icon != null) {
            this.icon.setEnabled(bl);
        }
        if (this.progressPixel != null) {
            this.progressPixel.setEnabled(bl);
        }
        super.setEnabled(bl);
    }
}

