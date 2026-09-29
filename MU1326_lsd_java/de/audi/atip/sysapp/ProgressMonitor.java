/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.sysapp;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.progress.IProgressMonitor;
import de.audi.atip.progress.ProgressMap;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.Formatter;

public class ProgressMonitor
implements IProgressMonitor,
TimerListener {
    private LogChannel lc;
    private String name;
    private Timer progressTimer;
    private ChoiceModelApp progressModel;
    private LabelModelApp progressLabel;
    private ProgressMap progressMap;
    private int tasksCompleted;
    private int ticks;
    private int ticksPerTask;
    private boolean resetProgressModelWhenCompleted;
    private boolean autoCompleteByTimer;

    public ProgressMonitor(String string, LogChannel logChannel, ChoiceModelApp choiceModelApp, LabelModelApp labelModelApp, ProgressMap progressMap, long l, boolean bl) {
        this.name = string == null ? "ProgressMonitor" : string;
        this.lc = logChannel;
        this.progressModel = choiceModelApp;
        this.progressLabel = labelModelApp;
        this.progressMap = progressMap;
        this.progressTimer = l > 0L ? new Timer("ProgressTimer", l, false, this) : null;
        this.tasksCompleted = 0;
        this.ticks = 0;
        this.ticksPerTask = 100 / progressMap.getTaskCount();
        this.autoCompleteByTimer = bl;
        this.resetProgressModelWhenCompleted = false;
        this.refreshProgress();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void start() {
        this.lc.log(-2137614336, "%1#start()", (Object)this.name);
        ProgressMonitor progressMonitor = this;
        synchronized (progressMonitor) {
            this.tasksCompleted = 0;
            this.ticks = 0;
            this.progressMap.reset();
            this.refreshProgress();
            this.resume();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void stop() {
        this.lc.log(-2137614336, "%1#stop()", (Object)this.name);
        ProgressMonitor progressMonitor = this;
        synchronized (progressMonitor) {
            if (this.progressTimer != null) {
                this.progressTimer.cancel();
            }
        }
    }

    private void pause() {
        this.lc.log(-2137614336, "%1#pause()", (Object)this.name);
        if (this.progressTimer != null) {
            this.progressTimer.cancel();
        }
    }

    private void resume() {
        this.lc.log(-2137614336, "%1#resume()", (Object)this.name);
        if (this.progressTimer != null && !this.progressTimer.isRunning()) {
            this.progressTimer.restart();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void taskCompleted(int n, boolean bl) {
        ProgressMonitor progressMonitor = this;
        synchronized (progressMonitor) {
            this.lc.log(-2137614336, "%3#taskCompleted( %2, %1 )", bl, (Object)this.progressMap.taskIDToString(n), (Object)this.name);
            int n2 = this.progressMap.taskCompleted(n, bl);
            if (n2 != this.tasksCompleted) {
                this.tasksCompleted = n2;
                if (this.tasksCompleted < this.progressMap.getTaskCount()) {
                    this.ticks = 0;
                    this.resume();
                } else {
                    this.stop();
                }
                this.refreshProgress();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void refreshProgress() {
        int n;
        ProgressMonitor progressMonitor = this;
        synchronized (progressMonitor) {
            if (this.tasksCompleted == this.progressMap.getTaskCount()) {
                n = 100;
            } else {
                n = this.tasksCompleted * this.ticksPerTask + this.ticks;
                if (!this.autoCompleteByTimer && n >= 100) {
                    n = 99;
                }
            }
        }
        if (this.progressModel != null) {
            if (this.resetProgressModelWhenCompleted) {
                this.progressModel.setValue(n % 100);
            } else {
                this.progressModel.setValue(n);
            }
        } else {
            this.lc.log(-2137614336, "%1#refreshProgress() - progress: %2 %", (Object)this.name, (long)n);
        }
        if (this.progressLabel != null) {
            this.progressLabel.setText(new StringBuffer().append(n).append(" %").toString());
        }
    }

    public String toString() {
        Buffer buffer = new Buffer();
        if (this.progressLabel != null) {
            buffer.append(this.progressLabel.getText()).append(Formatter.LINE_SEPARATOR);
        } else if (this.progressMap != null) {
            buffer.append(this.tasksCompleted).append('/').append(this.progressMap.getTaskCount()).append(Formatter.LINE_SEPARATOR);
        }
        if (this.progressMap != null) {
            buffer.append(this.progressMap);
        }
        return buffer.toString();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void fireTimer(Timer timer) {
        ProgressMonitor progressMonitor = this;
        synchronized (progressMonitor) {
            if (this.ticks < this.ticksPerTask) {
                ++this.ticks;
                this.refreshProgress();
            } else {
                this.pause();
            }
        }
    }

    @Override
    public void cancelTimer(Timer timer) {
    }
}

