/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.benchmark;

import de.audi.atip.benchmark.AnimationStatistics$AnimationInfo;
import de.audi.atip.benchmark.AnimationStatistics$NullAnimationStatistics;
import de.audi.atip.benchmark.IAnimationStatistics;
import de.audi.atip.benchmark.IStatisticsManager;
import de.audi.atip.benchmark.StatisticsManager;
import de.audi.atip.hmi.view.IAnimationController;
import de.esolutions.fw.util.commons.Buffer;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class AnimationStatistics
implements IAnimationStatistics {
    static final String HEADER;
    static IAnimationStatistics NULL_OBJECT;
    private final List animations = new LinkedList();
    private final IAnimationController animationController;

    AnimationStatistics(StatisticsManager statisticsManager) {
        this.animationController = statisticsManager.getHMITerminal(0).getIAnimationController();
    }

    @Override
    public void reset() {
        this.animations.clear();
    }

    @Override
    public String getName() {
        return "AnimationStatistics.csv";
    }

    @Override
    public void dump(PrintStream printStream, String string) {
        try {
            this.doDump(printStream);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void registerAnimation(int n, int n2, long l, long l2, long l3, int n3, Exception exception) {
        AnimationStatistics$AnimationInfo animationStatistics$AnimationInfo = new AnimationStatistics$AnimationInfo(null);
        AnimationStatistics$AnimationInfo.access$202(animationStatistics$AnimationInfo, n);
        AnimationStatistics$AnimationInfo.access$302(animationStatistics$AnimationInfo, n2);
        AnimationStatistics$AnimationInfo.access$402(animationStatistics$AnimationInfo, l2);
        AnimationStatistics$AnimationInfo.access$502(animationStatistics$AnimationInfo, l);
        AnimationStatistics$AnimationInfo.access$602(animationStatistics$AnimationInfo, l3);
        AnimationStatistics$AnimationInfo.access$702(animationStatistics$AnimationInfo, n3);
        AnimationStatistics$AnimationInfo.access$802(animationStatistics$AnimationInfo, exception);
        this.animations.add(animationStatistics$AnimationInfo);
    }

    private void doDump(PrintStream printStream) {
        if (this.animations.isEmpty()) {
            printStream.println("No measurements have been collected");
            return;
        }
        printStream.println("Animation Type;Animation Name;Start;End;Duration;Steps;Planned Duration;Updates/sec;Error?");
        Iterator iterator = this.animations.iterator();
        while (iterator.hasNext()) {
            AnimationStatistics$AnimationInfo animationStatistics$AnimationInfo = (AnimationStatistics$AnimationInfo)iterator.next();
            int n = (int)(AnimationStatistics$AnimationInfo.access$400(animationStatistics$AnimationInfo) - AnimationStatistics$AnimationInfo.access$500(animationStatistics$AnimationInfo));
            Buffer buffer = new Buffer(64).append(AnimationStatistics$AnimationInfo.access$200(animationStatistics$AnimationInfo)).append(";").append(this.animationController.getAnimationName(AnimationStatistics$AnimationInfo.access$200(animationStatistics$AnimationInfo))).append(";").append(AnimationStatistics$AnimationInfo.access$500(animationStatistics$AnimationInfo)).append(";").append(AnimationStatistics$AnimationInfo.access$400(animationStatistics$AnimationInfo)).append(";").append(AnimationStatistics$AnimationInfo.access$400(animationStatistics$AnimationInfo) - AnimationStatistics$AnimationInfo.access$500(animationStatistics$AnimationInfo)).append(";").append(AnimationStatistics$AnimationInfo.access$300(animationStatistics$AnimationInfo)).append(";").append(AnimationStatistics$AnimationInfo.access$600(animationStatistics$AnimationInfo)).append(";").append((float)AnimationStatistics$AnimationInfo.access$300(animationStatistics$AnimationInfo) / ((float)(n + AnimationStatistics$AnimationInfo.access$700(animationStatistics$AnimationInfo)) / 31300)).append(";").append(AnimationStatistics$AnimationInfo.access$800(animationStatistics$AnimationInfo));
            printStream.println(buffer);
        }
    }

    static {
        NULL_OBJECT = IStatisticsManager.INSTRUMENTATION_ENABLED ? new AnimationStatistics$NullAnimationStatistics(null) : null;
    }
}

