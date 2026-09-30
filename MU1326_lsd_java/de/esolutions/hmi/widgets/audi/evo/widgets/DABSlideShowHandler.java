/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.event.TimerEvent;
import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.IconCell;
import de.audi.atip.hmi.model.ResourceLocatorListCell;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelGUI;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.widgets.CoverStackController;
import de.esolutions.hmi.widgets.audi.evo.widgets.IconCrossFadeController;

public class DABSlideShowHandler
implements ATIPEventListener,
IWidgetLogChannel {
    protected Job timerJob = null;
    protected TimerEvent timerEvent = null;
    private boolean blockedUpdateEvent = false;
    private long currentMinDisplayDuration = 0L;
    private CoverStackController coverStackController;
    private IconCrossFadeController iconCrossFadeController;
    private ModelUpdateEvent modelUpdateEvent;

    public DABSlideShowHandler(CoverStackController coverStackController) {
        this.coverStackController = coverStackController;
    }

    public DABSlideShowHandler(IconCrossFadeController iconCrossFadeController) {
        this.iconCrossFadeController = iconCrossFadeController;
    }

    public void setModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        this.modelUpdateEvent = modelUpdateEvent;
    }

    public boolean isUpdateEventProccessable(Object object) {
        if (this.timerJob != null && !this.timerJob.isCanceled()) {
            if (object instanceof ResourceLocatorModelGUI) {
                return this.isSlsMinDurationChanged(((ResourceLocatorModelGUI)object).getResourceLocator());
            }
            if (object instanceof ResourceLocatorListCell) {
                return this.isSlsMinDurationChanged(((ResourceLocatorListCell)object).getResourceLocator());
            }
            if (object instanceof HMIResourceLocator) {
                return this.isSlsMinDurationChanged((HMIResourceLocator)object);
            }
            if (object instanceof IconCell) {
                return this.isSlsMinDurationChanged(((IconCell)object).getResourceLocator());
            }
            logChannelCoverStack.log(10000000, "DABSlideShowHandler#isUpdateEventProccessable given model has no MinDisplayDuration - cancel timerJob");
            this.cancelSlsTimer();
        }
        return true;
    }

    private boolean isSlsMinDurationChanged(HMIResourceLocator hMIResourceLocator) {
        if (this.currentMinDisplayDuration != (long)hMIResourceLocator.getMinDisplayDuration()) {
            logChannelCoverStack.log(10000000, "DABSlideShowHandler#isSlsMinDurationChanged new duration differs - cancel timerJob");
            this.cancelSlsTimer();
            return true;
        }
        logChannelCoverStack.log(10000000, "DABSlideShowHandler#isSlsMinDurationChanged block event");
        this.blockedUpdateEvent = true;
        return false;
    }

    public int startSlsTimer(HMIResourceLocator hMIResourceLocator) {
        if (this.timerEvent == null) {
            this.timerEvent = new TimerEvent(this);
        }
        this.cancelSlsTimer();
        this.currentMinDisplayDuration = hMIResourceLocator.getMinDisplayDuration();
        logChannelCoverStack.log(10000000, "DABSlideShowHandler#startSlsTimer with timeout: %1", this.currentMinDisplayDuration);
        this.timerJob = AbstractWidget.hmiService.getEventDispatcher().postEvent(this.timerEvent, this.currentMinDisplayDuration);
        return 0;
    }

    public void cancelSlsTimer() {
        if (this.timerJob != null && !this.timerJob.isCanceled()) {
            this.timerJob.cancel();
            this.timerJob = null;
            logChannelCoverStack.log(10000000, "DABSlideShowHandler#cancelSlsTimer cancel timer");
        }
        this.blockedUpdateEvent = false;
    }

    public void processEvent(ATIPEvent aTIPEvent) {
        if (aTIPEvent.equals(this.timerEvent)) {
            this.timerJob = null;
            if (this.blockedUpdateEvent) {
                if (this.coverStackController != null) {
                    logChannelCoverStack.log(1000000, "DABSlideShowHandler#processEvent timer expired, CoverStackController.menuLayouted() called");
                    this.coverStackController.menuLayouted();
                } else if (this.iconCrossFadeController != null) {
                    logChannelCoverStack.log(1000000, "DABSlideShowHandler#processEvent timer expired, IconCrossFadeController.updateContent() called");
                    this.iconCrossFadeController.updateContent(this.modelUpdateEvent);
                }
                this.blockedUpdateEvent = false;
            } else {
                logChannelCoverStack.log(10000000, "DABSlideShowHandler#processEvent timer expired, but no action was blocked.");
            }
        } else {
            logChannelCoverStack.log(10000000, "DABSlideShowHandler#processEvent is called with unexpected timerEvent: %1, expected timerEvent: %2", (Object)aTIPEvent, (Object)this.timerEvent);
        }
    }
}

