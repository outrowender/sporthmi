/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high;

import de.audi.atip.benchmark.IStatisticsManager;
import de.audi.atip.benchmark.StatisticsManager;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.animation.AbstractAnimation;
import de.esolutions.hmi.widgets.audi.evo.high.AnimationControllerMIB2High;
import de.esolutions.hmi.widgets.audi.evo.high.AnimationControllerMIB2High$AnimationInfo;
import de.esolutions.hmi.widgets.audi.evo.high.AnimationControllerMIB2High$AnimationStatistics;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class AnimationControllerMIB2High$AnimationInfoProvider
implements DumpInfoProvider {
    private static final int HISTORY_RECORDS;
    private final List animErrorHistory = new LinkedList();
    private final AnimationControllerMIB2High$AnimationStatistics[] statistics;
    private final /* synthetic */ AnimationControllerMIB2High this$0;

    public AnimationControllerMIB2High$AnimationInfoProvider(AnimationControllerMIB2High animationControllerMIB2High) {
        this.this$0 = animationControllerMIB2High;
        this.statistics = new AnimationControllerMIB2High$AnimationStatistics[animationControllerMIB2High.actualAnimations.length];
    }

    private synchronized void animationEnded(AbstractAnimation abstractAnimation, Exception exception) {
        this.addToHistory(abstractAnimation, exception);
        this.updateStatistics(abstractAnimation, null != exception);
    }

    private void addToHistory(AbstractAnimation abstractAnimation, Exception exception) {
        if (IStatisticsManager.INSTRUMENTATION_ENABLED && abstractAnimation.isInitialized()) {
            StatisticsManager.instance().getAnimationStatistics().registerAnimation(abstractAnimation.getType(), abstractAnimation.getCurrentAnimationStep(), abstractAnimation.getStartTime(), abstractAnimation.isAnimating() ? AbstractWidget.framework.getMonotonicTime() : abstractAnimation.getEndTime(), abstractAnimation.getPlannedDuration(), abstractAnimation.getTimerIntervall(), exception);
        }
        if (null != exception) {
            AnimationControllerMIB2High$AnimationInfo animationControllerMIB2High$AnimationInfo = new AnimationControllerMIB2High$AnimationInfo(null);
            AnimationControllerMIB2High$AnimationInfo.access$200(animationControllerMIB2High$AnimationInfo, abstractAnimation.getType());
            AnimationControllerMIB2High$AnimationInfo.access$300(animationControllerMIB2High$AnimationInfo, abstractAnimation.getCurrentAnimationStep());
            AnimationControllerMIB2High$AnimationInfo.access$400(animationControllerMIB2High$AnimationInfo, abstractAnimation.isAnimating() ? AbstractWidget.framework.getMonotonicTime() : abstractAnimation.getEndTime());
            AnimationControllerMIB2High$AnimationInfo.access$500(animationControllerMIB2High$AnimationInfo, abstractAnimation.getStartTime());
            AnimationControllerMIB2High$AnimationInfo.access$600(animationControllerMIB2High$AnimationInfo, abstractAnimation.getPlannedDuration());
            AnimationControllerMIB2High$AnimationInfo.access$700(animationControllerMIB2High$AnimationInfo, exception);
            AnimationControllerMIB2High$AnimationInfo.access$800(animationControllerMIB2High$AnimationInfo, abstractAnimation.getTimerIntervall());
            this.animErrorHistory.add(0, animationControllerMIB2High$AnimationInfo);
            if (20 < this.animErrorHistory.size()) {
                this.animErrorHistory.remove(20);
            }
        }
    }

    private void updateStatistics(AbstractAnimation abstractAnimation, boolean bl) {
        AnimationControllerMIB2High$AnimationStatistics animationControllerMIB2High$AnimationStatistics = this.statistics[abstractAnimation.getType()];
        if (null == animationControllerMIB2High$AnimationStatistics) {
            this.statistics[abstractAnimation.getType()] = animationControllerMIB2High$AnimationStatistics = new AnimationControllerMIB2High$AnimationStatistics(null);
        }
        AnimationControllerMIB2High$AnimationStatistics.access$1004(animationControllerMIB2High$AnimationStatistics);
        if (bl) {
            AnimationControllerMIB2High$AnimationStatistics.access$1104(animationControllerMIB2High$AnimationStatistics);
        }
        AnimationControllerMIB2High$AnimationStatistics.access$1214(animationControllerMIB2High$AnimationStatistics, abstractAnimation.getCurrentAnimationStep());
        AnimationControllerMIB2High$AnimationStatistics.access$1314(animationControllerMIB2High$AnimationStatistics, (abstractAnimation.isAnimating() ? AbstractWidget.framework.getMonotonicTime() : abstractAnimation.getEndTime()) - abstractAnimation.getStartTime());
    }

    @Override
    public String getName() {
        return "AnimationStatistics";
    }

    @Override
    public synchronized void dump(PrintStream printStream, String string) {
        Object object;
        Object object2;
        printStream.println("### Animation Statistics ###");
        printStream.println("\nCurrently Running Animations:");
        boolean bl = false;
        try {
            if (null != this.this$0.actualAnimations) {
                for (int i2 = 0; i2 < this.this$0.actualAnimations.length; ++i2) {
                    object2 = this.this$0.actualAnimations[i2];
                    if (null == object2 || object2.isEmpty()) continue;
                    object = (AbstractAnimation[])object2.toArray(new AbstractAnimation[object2.size()]);
                    bl = true;
                    printStream.println(new StringBuffer().append("Animations of type ").append(this.this$0.getAnimationName(i2)).append("(").append(i2).append("):").toString());
                    for (int i3 = 0; i3 < ((Object)object).length; ++i3) {
                        this.dumpAnimationInfo(printStream, (AbstractAnimation)object[i3]);
                    }
                }
            }
            if (!bl) {
                printStream.println("### NONE ###");
            }
        }
        catch (Exception exception) {
            printStream.println("Failed to print current animations!");
            printStream.println(exception);
        }
        printStream.println("\nAnimation error history (last 20 records):");
        bl = false;
        Iterator iterator = this.animErrorHistory.iterator();
        while (iterator.hasNext()) {
            bl = true;
            this.dumpAnimationInfo(printStream, (AnimationControllerMIB2High$AnimationInfo)iterator.next());
        }
        if (!bl) {
            printStream.println("### NONE ###");
        }
        printStream.println("\nGeneral Animation Statistics:");
        bl = false;
        for (int i4 = 0; i4 < this.statistics.length; ++i4) {
            object2 = this.statistics[i4];
            if (null == object2) continue;
            bl = true;
            object = new Buffer(100);
            ((Buffer)object).append("\tType: ").append(this.this$0.getAnimationName(i4)).append('(').append(i4).append(')').append(", Count: ").append(AnimationControllerMIB2High$AnimationStatistics.access$1000((AnimationControllerMIB2High$AnimationStatistics)object2)).append(", Error Count: ").append(AnimationControllerMIB2High$AnimationStatistics.access$1100((AnimationControllerMIB2High$AnimationStatistics)object2)).append(", Error%: ").append((float)(51266 * ((float)AnimationControllerMIB2High$AnimationStatistics.access$1100((AnimationControllerMIB2High$AnimationStatistics)object2) / (float)AnimationControllerMIB2High$AnimationStatistics.access$1000((AnimationControllerMIB2High$AnimationStatistics)object2)))).append('%').append(", Average Steps: ").append((float)AnimationControllerMIB2High$AnimationStatistics.access$1200((AnimationControllerMIB2High$AnimationStatistics)object2) / (float)AnimationControllerMIB2High$AnimationStatistics.access$1000((AnimationControllerMIB2High$AnimationStatistics)object2)).append(", Average Time: ").append((float)AnimationControllerMIB2High$AnimationStatistics.access$1300((AnimationControllerMIB2High$AnimationStatistics)object2) / (float)AnimationControllerMIB2High$AnimationStatistics.access$1000((AnimationControllerMIB2High$AnimationStatistics)object2));
            printStream.println(object);
        }
        if (!bl) {
            printStream.println("### NONE ###");
        }
    }

    private void dumpAnimationInfo(PrintStream printStream, AnimationControllerMIB2High$AnimationInfo animationControllerMIB2High$AnimationInfo) {
        Buffer buffer = new Buffer(256);
        long l = AnimationControllerMIB2High$AnimationInfo.access$1400(animationControllerMIB2High$AnimationInfo);
        long l2 = AnimationControllerMIB2High$AnimationInfo.access$1500(animationControllerMIB2High$AnimationInfo);
        long l3 = AnimationControllerMIB2High$AnimationInfo.access$1600(animationControllerMIB2High$AnimationInfo);
        int n = AnimationControllerMIB2High$AnimationInfo.access$1700(animationControllerMIB2High$AnimationInfo);
        int n2 = AnimationControllerMIB2High$AnimationInfo.access$1800(animationControllerMIB2High$AnimationInfo);
        buffer.append("\tType: ").append(this.this$0.getAnimationName(n2)).append('(').append(n2).append(')').append(", Start: ").append(l2).append(", Steps: ").append(n).append(", End: ").append(l).append(", Elapsed time: ").append(l3).append(", Planned duration: ").append(AnimationControllerMIB2High$AnimationInfo.access$2000(animationControllerMIB2High$AnimationInfo)).append(", Updates/sec: ").append(AnimationControllerMIB2High$AnimationInfo.access$1900(animationControllerMIB2High$AnimationInfo));
        if (AnimationControllerMIB2High$AnimationInfo.access$2100(animationControllerMIB2High$AnimationInfo)) {
            buffer.append(", Exeption: ").append(AnimationControllerMIB2High$AnimationInfo.access$2200(animationControllerMIB2High$AnimationInfo));
        }
        printStream.println(buffer);
    }

    private void dumpAnimationInfo(PrintStream printStream, AbstractAnimation abstractAnimation) {
        Buffer buffer = new Buffer(256);
        long l = abstractAnimation.isAnimating() ? AbstractWidget.framework.getMonotonicTime() : abstractAnimation.getEndTime();
        long l2 = abstractAnimation.getStartTime();
        long l3 = l - l2;
        int n = abstractAnimation.getCurrentAnimationStep();
        buffer.append("\tType: ").append(this.this$0.getAnimationName(abstractAnimation.getType())).append('(').append(abstractAnimation.getType()).append(')').append(", Start: ").append(l2).append(", Steps: ").append(n).append(", End: ").append(l).append(", Elapsed time: ").append(l3).append(", Planned duration: ").append(abstractAnimation.getPlannedDuration()).append(", Updates/sec: ").append((float)n / ((float)(l3 + (long)abstractAnimation.getTimerIntervall()) / 31300));
        if (abstractAnimation.isAnimating()) {
            buffer.append(", Target: ").append(abstractAnimation.getTarget()).append(", Value: ").append(abstractAnimation.getValue()).append(", Progress: ").append(abstractAnimation.getProgress()).append(", Blocked: ").append(abstractAnimation.isBlocked());
        }
        printStream.println(buffer);
    }

    static /* synthetic */ void access$000(AnimationControllerMIB2High$AnimationInfoProvider animationControllerMIB2High$AnimationInfoProvider, AbstractAnimation abstractAnimation, Exception exception) {
        animationControllerMIB2High$AnimationInfoProvider.animationEnded(abstractAnimation, exception);
    }
}

