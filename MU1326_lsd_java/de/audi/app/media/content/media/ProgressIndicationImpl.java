/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.content.media.IProgressIndication;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

public class ProgressIndicationImpl
implements TimerListener,
IProgressIndication {
    private static final String LOGCLASS = "ProgressIndicationImpl";
    private static final int PROGRESS_INDICATION_TIMEOUT = 100;
    private static final int STATE_STOPPED = 0;
    private static final int STATE_STARTED = 1;
    private static final int STATE_PROGRESS = 2;
    private final LogChannel logger;
    private final Timer progressIconTimer;
    private final ChoiceModelApp progressModel;
    private final int usedModelBit;
    private int state = 0;

    public ProgressIndicationImpl(LogChannel logChannel, ChoiceModelApp choiceModelApp, int n) {
        this.logger = logChannel;
        this.progressIconTimer = new Timer("ProgressIconTimer", 100L, true, this);
        this.progressModel = choiceModelApp;
        this.usedModelBit = n;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setState(int n) {
        ChoiceModelApp choiceModelApp = this.progressModel;
        synchronized (choiceModelApp) {
            if (n == this.state) {
                this.logger.log(1000000, "[%1.setState] [%2,%3] State already reached", (Object)LOGCLASS, (long)this.progressModel.getID(), (long)this.usedModelBit);
                return;
            }
            int n2 = this.state;
            this.state = n;
            switch (n) {
                case 0: {
                    this.logger.log(1000000, "[%1.setState] [%2,%3] STOPPED", (Object)LOGCLASS, (long)this.progressModel.getID(), (long)this.usedModelBit);
                    this.progressIconTimer.cancel();
                    this.setProgressIndicationBit(false);
                    break;
                }
                case 1: {
                    this.logger.log(1000000, "[%1.setState] [%2,%3] STARTED", (Object)LOGCLASS, (long)this.progressModel.getID(), (long)this.usedModelBit);
                    if (n2 == 2) {
                        this.logger.log(1000000, "[%1.setState] [%2,%3] Already in progress.", (Object)LOGCLASS, (long)this.progressModel.getID(), (long)this.usedModelBit);
                        return;
                    }
                    this.progressIconTimer.start();
                    break;
                }
                case 2: {
                    this.logger.log(1000000, "[%1.setState] [%2,%3] PROGRESS", (Object)LOGCLASS, (long)this.progressModel.getID(), (long)this.usedModelBit);
                    if (n2 == 0) {
                        this.logger.log(1000000, "[%1.setState] [%2,%3] Stopped.", (Object)LOGCLASS, (long)this.progressModel.getID(), (long)this.usedModelBit);
                        return;
                    }
                    this.setProgressIndicationBit(true);
                    break;
                }
            }
        }
    }

    public void startIndication() {
        this.logger.log(1000000, "[%1.startIndication] [%2,%3]", (Object)LOGCLASS, (long)this.progressModel.getID(), (long)this.usedModelBit);
        this.setState(1);
    }

    public void stopIndication() {
        this.logger.log(1000000, "[%1.stopIndication] [%2,%3]", (Object)LOGCLASS, (long)this.progressModel.getID(), (long)this.usedModelBit);
        this.setState(0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setProgressIndicationBit(boolean bl) {
        ChoiceModelApp choiceModelApp = this.progressModel;
        synchronized (choiceModelApp) {
            int n = this.progressModel.getValue();
            n = bl ? (n |= 2 << this.usedModelBit) : (n &= ~(2 << this.usedModelBit));
            this.progressModel.setValue(n);
        }
    }

    public void fireTimer(Timer timer) {
        this.logger.log(1000000, "[%1.fireTimer] [%2,%3]", (Object)LOGCLASS, (long)this.progressModel.getID(), (long)this.usedModelBit);
        this.setState(2);
    }

    public void cancelTimer(Timer timer) {
    }
}

