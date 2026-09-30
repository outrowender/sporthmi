/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.event.EventDispatcher;
import de.audi.atip.util.Util;
import de.audi.tghu.hmi.evo.DrawerAnimationListener;
import de.esolutions.hmi.widgets.audi.evo.widgets.IAsyncLabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IAsyncMultiLineLabelRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelRenderer;

public class AsyncLabelController
extends LabelController
implements IAsyncLabelController,
ATIPEventListener,
DrawerAnimationListener {
    private EventDispatcher eventDispatcher;
    private boolean updatePosted;
    private IAsyncMultiLineLabelRenderer asyncRenderer;
    private int frameSize = 0;
    private boolean screenChangeRunning = false;
    private long eventDelay = 10L;

    private boolean updateLineBreaking() {
        return this.asyncRenderer == null ? false : this.asyncRenderer.updateLineBreaking(this.screenChangeRunning);
    }

    private void updateEventDispatcher() {
        if (this.eventDispatcher == null && this.terminal != null) {
            this.eventDispatcher = this.terminal.getFramework().getHMIService().getEventDispatcher();
        }
        logChannel.log(10000000, "AsyncLabelController#updateEventDispatcher: event dispatcher %1", (Object)(this.eventDispatcher == null ? "missing" : "present"));
    }

    protected void initializeWidget() {
        logChannel.log(10000000, "AsyncLabelController#initializeWidget");
        if (this.terminal != null) {
            this.terminal.getDrawerFocusManager().registerDrawerAnimationListener(this);
        }
        this.updateLineBreaking();
        super.initializeWidget();
    }

    private boolean updateSingleLine() {
        String string = this.text;
        Object object = this.calculateContent();
        if (!(object instanceof String)) {
            return super.updateContent();
        }
        this.text = (String)object;
        if (this.text.length() > 900) {
            this.text = this.text.substring(0, 900);
        }
        this.text = this.formatText(this.formatContent(this.text));
        if (!Util.equals(string, this.text)) {
            this.setCompositesDirty(true);
            this.invalidateParentLayout();
            return true;
        }
        return false;
    }

    public boolean updateContent() {
        boolean bl;
        boolean bl2 = bl = this.getMaxLines() == 1 ? this.updateSingleLine() : super.updateContent();
        if (bl) {
            logChannel.log(10000000, "AsyncLabelController#updateContent: text was changed.");
            this.markRendererTextChanged();
            this.postUpdateEvent();
            if (this.isConnectedSubtree()) {
                this.triggerWidgetUpdates(true);
            }
        }
        return bl;
    }

    private void markRendererTextChanged() {
        if (!(this.getRenderer() instanceof IAsyncMultiLineLabelRenderer)) {
            return;
        }
        ((IAsyncMultiLineLabelRenderer)((Object)this.getRenderer())).onTextChanged();
    }

    private void postUpdateEvent() {
        if (this.updatePosted) {
            return;
        }
        this.updateEventDispatcher();
        if (this.eventDispatcher != null) {
            this.eventDispatcher.postEvent(new TextUpdateEvent(this, 19901), this.getEventDelay());
            this.updatePosted = true;
        } else {
            logChannel.log(100000, "AsyncLabelController#postUpdateEvent: cannot post, dispatcher missing");
        }
    }

    public long getEventDelay() {
        return this.eventDelay;
    }

    public void setEventDelay(long l) {
        this.eventDelay = l;
    }

    public void processEvent(ATIPEvent aTIPEvent) {
        if (!(aTIPEvent instanceof TextUpdateEvent) || this.asyncRenderer == null) {
            return;
        }
        this.updatePosted = false;
        if (this.text == null) {
            return;
        }
        logChannel.log(10000000, "AsyncLabelController#processEvent");
        if (this.screenChangeRunning) {
            logChannel.log(10000000, "AsyncLabelController#processEvent: pausing updates while screen change animation is running");
            return;
        }
        boolean bl = this.updateLineBreaking();
        this.triggerWidgetUpdates(bl);
        if (this.asyncRenderer.isLineBreakingFinished()) {
            logChannel.log(10000000, "AsyncLabelController#processEvent: line breaking finished");
        } else {
            this.postUpdateEvent();
        }
    }

    private void triggerWidgetUpdates(boolean bl) {
        logChannel.log(10000000, "AsyncLabelController#triggerWidgetUpdates: invalidateLayout=%1", bl);
        this.setCompositesDirty(true);
        if (bl) {
            this.invalidateParentLayout();
        }
        this.triggerRepaint();
    }

    public void disconnecting() {
        super.disconnecting();
        if (this.terminal != null) {
            this.terminal.getDrawerFocusManager().unregisterDrawerAnimationListener(this);
        }
        this.text = null;
    }

    public void initializeDrawerAnimation(float[] fArray, float[] fArray2) {
    }

    public void drawerAnimationTargetChanged(float[] fArray, float[] fArray2, int n) {
    }

    public void drawerAnimationFinished(float[] fArray, float[] fArray2, int n) {
    }

    public void setDrawerAnimation(float[] fArray, float[] fArray2, int n) {
        if (fArray[12] == 0.0f && this.screenChangeRunning) {
            this.screenChangeRunning = false;
            logChannel.log(10000000, "AsyncLabelController#setDrawerAnimation: animation finished");
            this.postUpdateEvent();
        } else if (fArray[12] > 0.0f && !this.screenChangeRunning) {
            this.screenChangeRunning = true;
            logChannel.log(10000000, "AsyncLabelController#setDrawerAnimation: animation started");
        }
    }

    public int getDrawerAnimationMask() {
        return 4096;
    }

    public void setRenderer(LabelRenderer labelRenderer) {
        super.setRenderer(labelRenderer);
        if (labelRenderer instanceof IAsyncMultiLineLabelRenderer) {
            this.asyncRenderer = (IAsyncMultiLineLabelRenderer)((Object)labelRenderer);
        } else {
            logChannel.log(100000, "AsyncLabelController#setRenderer ", (Object)(labelRenderer != null ? labelRenderer.toString() : "null"));
        }
    }

    public void setFrameSize(int n) {
        this.frameSize = n;
    }

    public int getFrameSize() {
        return this.frameSize;
    }

    static final class TextUpdateEvent
    extends ATIPEvent {
        protected TextUpdateEvent(ATIPEventListener aTIPEventListener, int n) {
            super(aTIPEventListener, n);
        }
    }
}

