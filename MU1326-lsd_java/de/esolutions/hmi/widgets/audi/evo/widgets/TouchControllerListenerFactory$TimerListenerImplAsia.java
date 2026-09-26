/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.TimerEvent;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.TouchControllerListenerFactory$TimerListenerImpl;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.TouchControllerAsia;

public class TouchControllerListenerFactory$TimerListenerImplAsia
extends TouchControllerListenerFactory$TimerListenerImpl {
    public static final String TIMER_NAME_DELAY_SPEAKING_OF_TOUCH_RESULT_PREVIEW;
    private static final long TIME_DELAY_SPEAKING_OF_TOUCH_RESULT_PREVIEW_DEFAULT;
    private long timeDelaySpeakingOfResultPreview;
    private Job delaySpeakingOfPreviewJob = null;
    private TimerEvent delaySpeakingOfPreviewEvent = null;
    private String lastPreviewCharacterToSpeak = null;
    private final TouchControllerAsia touchControllerAsia;

    public TouchControllerListenerFactory$TimerListenerImplAsia(TouchControllerAsia touchControllerAsia) {
        super(touchControllerAsia, null);
        this.touchControllerAsia = touchControllerAsia;
        this.setDelayForSpeakingResultPreview(0);
    }

    public final void setDelayForSpeakingResultPreview(long l) {
        this.timeDelaySpeakingOfResultPreview = l;
        if (l > 0L) {
            this.disposeDelayJob();
        }
    }

    private void createAndStartDelaySpeakingOfPreviewTimer() {
        if (this.delaySpeakingOfPreviewJob == null) {
            this.delaySpeakingOfPreviewEvent = new TimerEvent(this);
            this.delaySpeakingOfPreviewJob = AbstractWidget.framework.getHMIService().getEventDispatcher().postEvent(this.delaySpeakingOfPreviewEvent, this.timeDelaySpeakingOfResultPreview);
        } else {
            this.delaySpeakingOfPreviewJob.cancel();
            this.delaySpeakingOfPreviewJob = AbstractWidget.framework.getHMIService().getEventDispatcher().postEvent(this.delaySpeakingOfPreviewEvent, this.timeDelaySpeakingOfResultPreview);
        }
    }

    public void speakPreviewCharacter(String string) {
        this.lastPreviewCharacterToSpeak = string;
        if (this.timeDelaySpeakingOfResultPreview == 0L) {
            this.doSpeakLastPreviewCharacterNow();
        } else {
            this.createAndStartDelaySpeakingOfPreviewTimer();
        }
    }

    @Override
    public void processEvent(ATIPEvent aTIPEvent) {
        super.processEvent(aTIPEvent);
        if (aTIPEvent.equals(this.delaySpeakingOfPreviewEvent)) {
            this.doSpeakLastPreviewCharacterNow();
        }
    }

    private void doSpeakLastPreviewCharacterNow() {
        this.touchControllerAsia.getTouchUtil().speakChar(this.lastPreviewCharacterToSpeak);
        this.lastPreviewCharacterToSpeak = null;
    }

    @Override
    public void disconnecting() {
        super.disconnecting();
        this.disposeDelayJob();
    }

    private void disposeDelayJob() {
        if (this.delaySpeakingOfPreviewEvent != null) {
            this.delaySpeakingOfPreviewEvent.consume();
            this.delaySpeakingOfPreviewEvent = null;
        }
        if (this.delaySpeakingOfPreviewJob != null) {
            this.delaySpeakingOfPreviewJob.cancel();
            this.delaySpeakingOfPreviewJob = null;
        }
    }
}

