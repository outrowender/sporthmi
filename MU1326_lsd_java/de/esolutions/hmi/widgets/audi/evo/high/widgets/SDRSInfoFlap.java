/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.model.AbstractModel;
import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.model.MetricsModel;
import de.audi.atip.hmi.modelaccess.ChoiceModelGUI;
import de.audi.atip.hmi.modelaccess.HMIModelGUI;
import de.audi.atip.hmi.modelaccess.MetricsModelGUI;
import de.audi.atip.hmi.view.AnimationListener;
import de.audi.atip.metrics.AbstractMetrics;
import de.audi.atip.metrics.DateMetric;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimationController;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.SDRSInfoFlapRenderer;

public class SDRSInfoFlap
extends AbstractWidgetController
implements AnimationListener {
    private static final float ANIMATION_SPEED = 300.0f;
    private static final int KILO = 1000;
    private static final int ANIMATION_CYCLE = 50;
    private static final int MODEL_BETTER_ROUTE_AVAILABLE = 401368;
    private static final int MODEL_BETTER_ROUTE_METRICS = 401369;
    private static final int TEXT_BETTER_ROUTE = 0;
    private static final int STATE_CLOSED = 0;
    private static final int STATE_HALF_OPENED = 1;
    private static final int STATE_FULL_OPENED = 2;
    private static final int[] TARGET_CLOSED = new int[]{0, 0};
    private static final int[] TARGET_HALF_OPENED = new int[]{1, 0};
    private static final int[] TARGET_FULL_OPENED = new int[]{1, 1};
    private SDRSInfoFlapRenderer renderer;
    private AbstractAnimation animation;
    private int[] textIds;
    private String cachedTextSavedTime;
    private boolean isVisible;
    private boolean isFullOpened;
    private int state;
    private int targetState = -1;
    private int[] targetValues;
    private float progress;
    private long timeStamp = -1L;
    private static final boolean useFadeInSpecial = false;

    public void animate(int n, float f2, int n2) {
        long l = framework.getMonotonicTime();
        long l2 = l - this.timeStamp;
        float f3 = (float)l2 / 1000.0f;
        float f4 = f3 * 300.0f;
        this.progress += f4;
        this.timeStamp = l;
        this.setCompositesDirty(true);
    }

    public void animationFinished(int n, int n2) {
    }

    public void animationStarted(int n, int n2) {
    }

    private int calculateTargetState() {
        if (this.isVisible) {
            if (this.isFullOpened) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    private static int[] calculateTargetValues(int n) {
        int[] nArray;
        switch (n) {
            case 0: {
                nArray = TARGET_CLOSED;
                break;
            }
            case 1: {
                nArray = TARGET_HALF_OPENED;
                break;
            }
            case 2: {
                nArray = TARGET_FULL_OPENED;
                break;
            }
            default: {
                nArray = TARGET_CLOSED;
            }
        }
        return nArray;
    }

    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
        this.updateContent();
        this.updateStatus();
        this.state = this.calculateTargetState();
        this.targetValues = SDRSInfoFlap.calculateTargetValues(this.state);
        this.targetState = this.state;
        this.updateVisibility();
        this.setCompositesDirty(true);
    }

    public void disconnecting() {
        super.disconnecting();
        this.stopAnimation();
        this.isVisible = false;
        this.isFullOpened = false;
    }

    private AbstractAnimation getAnimation(int n) {
        if (this.animation == null || this.animation.getType() != n) {
            this.animation = (AbstractAnimation)this.getAnimationController().getIAnimation(n);
            this.animation.addListener(this);
        }
        return this.animation;
    }

    private AbstractAnimationController getAnimationController() {
        return (AbstractAnimationController)this.getTerminal().getIAnimationController();
    }

    public float getAnimationProgress() {
        float f2 = this.progress;
        this.progress = 0.0f;
        return f2;
    }

    public IRenderer getRenderer() {
        return this.renderer;
    }

    public int[] getTargetValues() {
        return this.targetValues;
    }

    private String getText(int n) {
        if (this.textIds == null || n < 0 || n >= this.textIds.length) {
            return "";
        }
        return this.getInitContext().getScreenFactory().getText(this.textIds[n]);
    }

    public int[] getTextIds() {
        return this.textIds;
    }

    public String getTextInfo() {
        return this.getText(0);
    }

    public String getTextSavedTime() {
        return this.cachedTextSavedTime;
    }

    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        if (!this.isConnected()) {
            return;
        }
        mapOverlayLogCh.log(10000000, "SDRSInfoFlap#processModelUpdateEvent %1", (Object)modelUpdateEvent);
        int n = modelUpdateEvent.getModelId();
        int n2 = modelUpdateEvent.getUpdateType();
        if (n == 401368) {
            if (n2 == 1) {
                this.updateStatusAndHandleStatusChanged();
            } else {
                mapOverlayLogCh.log(10000, "SDRSInfoFlap#processModelUpdateEvent Model update event not processed (%1).", (Object)modelUpdateEvent);
            }
        } else if (n == 401369) {
            if (n2 == 1) {
                this.updateContent();
            } else if (n2 == 2) {
                this.updateStatusAndHandleStatusChanged();
            } else {
                mapOverlayLogCh.log(10000, "SDRSInfoFlap#processModelUpdateEvent Model update event not processed (%1).", (Object)modelUpdateEvent);
            }
        }
    }

    public void setRenderer(SDRSInfoFlapRenderer sDRSInfoFlapRenderer) {
        this.renderer = sDRSInfoFlapRenderer;
    }

    public void setRole(int n) {
        this.role = n;
    }

    public void setTextIds(int[] nArray) {
        this.textIds = nArray;
    }

    private void startAnimation() {
        if (this.isConnected() && (this.animation == null || !this.animation.isAnimating())) {
            this.getAnimation(107);
            this.timeStamp = framework.getMonotonicTime();
            this.animation.startEndlessAnimation(50, this);
        }
    }

    public void stopAnimation() {
        mapOverlayLogCh.log(10000000, "SDRSInfoFlap#stopAnimation state = %1, targetState = %2", (long)this.state, (long)this.targetState);
        if (this.animation != null && this.animation.isAnimating()) {
            this.animation.stopAnimation();
        }
        this.state = this.targetState;
        this.updateVisibility();
    }

    private void updateContent() {
        if (this.model instanceof MetricsModel) {
            MetricsModelGUI metricsModelGUI = (MetricsModelGUI)this.model;
            AbstractMetrics abstractMetrics = metricsModelGUI.getMetric();
            if (abstractMetrics instanceof DateMetric) {
                DateMetric dateMetric = (DateMetric)abstractMetrics;
                String string = dateMetric.format();
                if (string.equals(this.cachedTextSavedTime)) {
                    return;
                }
                this.cachedTextSavedTime = dateMetric.format();
                mapOverlayLogCh.log(10000000, "SDRSInfoFlap#updateContent Cache text saved time = %1.", (Object)this.cachedTextSavedTime);
                this.setCompositesDirty(true);
            } else {
                mapOverlayLogCh.log(10000000, "SDRSInfoFlap#updateContent Wrong metric %1.", (Object)abstractMetrics);
            }
        } else {
            mapOverlayLogCh.log(10000000, "SDRSInfoFlap#updateContent Wrong model %1 connected.", this.model);
        }
    }

    private void updateStatus() {
        HMIModelGUI hMIModelGUI;
        this.isVisible = false;
        this.isFullOpened = false;
        HMIModel hMIModel = hmiService.getModel(401368);
        if (hMIModel instanceof ChoiceModel) {
            hMIModelGUI = (ChoiceModelGUI)((Object)hMIModel);
            boolean bl = this.isVisible = hMIModelGUI.getValue() == 1;
        }
        if ((hMIModelGUI = hmiService.getModel(401369)) instanceof AbstractModel) {
            AbstractModel abstractModel = (AbstractModel)hMIModelGUI;
            this.isFullOpened = abstractModel.getStatus() == 1;
        }
        mapOverlayLogCh.log(10000000, "SDRSInfoFlap#updateStatus isVisible = %1, isFullOpened = %2", this.isVisible, this.isFullOpened);
    }

    private void updateStatusAndHandleStatusChanged() {
        this.updateStatus();
        int n = this.targetState;
        this.targetState = this.calculateTargetState();
        if (n != this.targetState) {
            mapOverlayLogCh.log(10000000, "SDRSInfoFlap#updateStatusAndHandleStatusChanged state = %1, targetState = %2", (long)this.state, (long)this.targetState);
            this.targetValues = SDRSInfoFlap.calculateTargetValues(this.targetState);
            this.updateVisibility();
            this.startAnimation();
        }
    }

    private void updateVisibility() {
        if (this.state == 0 && this.targetState == 0) {
            this.setOnScreen(false);
        } else {
            this.setOnScreen(true);
        }
        mapOverlayLogCh.log(10000000, "SDRSInfoFlap#updateVisibility onScreen = %1", this.isOnScreen());
    }
}

