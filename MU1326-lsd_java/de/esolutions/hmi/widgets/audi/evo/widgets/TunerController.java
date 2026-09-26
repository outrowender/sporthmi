/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.event.WheelButtonEvent;
import de.audi.atip.hmi.modelaccess.RangeModelGUI;
import de.audi.atip.preset.Preset;
import de.audi.tghu.hmi.evo.IPresetPopupData;
import de.eso.widgets.preset.PresetPopupData;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.ExtHMITerminalEvo;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconRenderer;

public class TunerController
extends AbstractWidgetController {
    private IRenderer renderer;
    private IconController scaleIcon;
    private IconController needleIcon;
    private boolean automaticTuneMode;
    private int rangeMin;
    private int rangeMax;
    private int stepSize;
    private static final int MAX_TIME_SPAN;
    private static final int TIME_SPAN_EVT;
    private static final int MAX_CLICK_COUNT;
    private static final int FAST_TUNE_FACTOR;
    private long timeSpanStart = 0L;
    private long lastEvtTime = 0L;
    private int currentClickCount = 0;
    private boolean fastTune;
    private int lastDirection = -1;

    public TunerController() {
    }

    @Override
    protected void initializeWidget() {
        if (this.scaleIcon == null) {
            this.createScaleIcon();
        }
        if (this.needleIcon == null) {
            this.createNeedleIcon();
        }
        this.rangeMin = ((RangeModelGUI)this.model).getMinimum();
        this.rangeMax = ((RangeModelGUI)this.model).getMaximum();
        this.stepSize = ((RangeModelGUI)this.model).getStep();
    }

    @Override
    protected void afterConnected() {
        this.updateNeedleToCurrentPosition();
        super.afterConnected();
    }

    public TunerController(IRenderer iRenderer) {
        this.renderer = iRenderer;
    }

    public void setRenderer(IRenderer iRenderer) {
        this.renderer = iRenderer;
    }

    @Override
    public IRenderer getRenderer() {
        return this.renderer;
    }

    private void updateNeedleToCurrentPosition() {
        if (this.model instanceof RangeModelGUI) {
            int n = this.getCurrentModelPosition();
            if (this.rangeMin >= this.rangeMax) {
                logChannel.log(-1601830656, "TunerController#updateNeedleToCurrentPosition: invalid range. min: %1, max: %2", (long)this.rangeMin, (long)this.rangeMax);
                this.needleIcon.setX(0);
            } else {
                boolean bl;
                boolean bl2 = bl = framework.getLanguageMgr() != null && !framework.getLanguageMgr().isLeftToRightOrientation();
                if (bl) {
                    n = this.rangeMin + (this.rangeMax - n);
                }
                int n2 = Math.round((float)(this.scaleIcon.getPreferredWidth() - this.needleIcon.getPreferredWidth()) * (float)(n - this.rangeMin) / (float)(this.rangeMax - this.rangeMin));
                this.needleIcon.setX(n2);
            }
        }
    }

    public boolean isAutomaticTuneMode() {
        return this.automaticTuneMode;
    }

    public void setAutomaticTuneMode(boolean bl) {
        this.automaticTuneMode = bl;
    }

    private int getCurrentModelPosition() {
        if (this.model instanceof RangeModelGUI) {
            return ((RangeModelGUI)this.model).getValue();
        }
        return 0;
    }

    private int getSteps(long l, int n, int n2) {
        long l2 = l - this.timeSpanStart;
        if (n2 != this.lastDirection && this.lastDirection != -1) {
            this.fastTune = false;
            this.currentClickCount = 0;
        } else if (l2 < 0 || this.fastTune && l - this.lastEvtTime < 0) {
            this.currentClickCount += n;
            if (this.currentClickCount > 10) {
                this.fastTune = true;
            }
        } else {
            this.timeSpanStart = l;
            this.fastTune = false;
            this.currentClickCount = 0;
        }
        this.lastDirection = n2;
        this.lastEvtTime = l;
        return (this.fastTune ? 5 : 1) * (n * this.stepSize);
    }

    @Override
    public void keyTurned(WheelButtonEvent wheelButtonEvent) {
        super.keyTurned(wheelButtonEvent);
        if (this.automaticTuneMode || wheelButtonEvent.getClickCount() == 0) {
            return;
        }
        if (this.isVisible() && this.isActive() && this.isEnabled()) {
            int n = wheelButtonEvent.getDirection();
            if (wheelButtonEvent.getKeyCode() == 20) {
                n = wheelButtonEvent.getDirection() == 0 ? 1 : 0;
            }
            int n2 = wheelButtonEvent.getClickCount();
            int n3 = this.getTerminalImpl().getTerminalID();
            int n4 = this.getSteps(framework.getMonotonicTime(), n2, n);
            if (n == 0) {
                ((RangeModelGUI)this.model).increment(n4, n3);
            } else {
                ((RangeModelGUI)this.model).decrement(n4, n3);
            }
            wheelButtonEvent.consume();
        }
    }

    private void createScaleIcon() {
        this.scaleIcon = new IconController();
        IconRenderer iconRenderer = ((ExtHMITerminalEvo)((Object)this.getTerminalImpl())).getRendererFactory().createIconRenderer(this.scaleIcon);
        this.scaleIcon.setRenderer(iconRenderer);
        this.scaleIcon.setBitmaps(new int[]{this.getBitmap(0)});
        this.scaleIcon.setVisible(true);
        this.add(this.scaleIcon);
        this.scaleIcon.setBounds(0, 0, this.scaleIcon.getPreferredWidth(), this.scaleIcon.getPreferredHeight());
    }

    private void createNeedleIcon() {
        this.needleIcon = new IconController();
        IconRenderer iconRenderer = ((ExtHMITerminalEvo)((Object)this.getTerminalImpl())).getRendererFactory().createIconRenderer(this.needleIcon);
        this.needleIcon.setRenderer(iconRenderer);
        this.needleIcon.setBitmaps(new int[]{this.getBitmap(1)});
        this.needleIcon.setVisible(true);
        this.add(this.needleIcon);
        this.needleIcon.setBounds(0, 0, this.needleIcon.getPreferredWidth(), this.needleIcon.getPreferredHeight());
    }

    @Override
    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        int n = modelUpdateEvent.getUpdateType();
        if (n == 1) {
            this.updateNeedleToCurrentPosition();
        }
        super.processModelUpdateEvent(modelUpdateEvent);
    }

    @Override
    public IPresetPopupData getPresetPopupData() {
        if (!this.isVisible()) {
            return null;
        }
        return new PresetPopupData(0, -19456, new Preset(1, this.modelID, 0, null, null, 99), null, null, -1, null);
    }
}

