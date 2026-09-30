/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.benchmark;

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
    static final String HEADER = "Animation Type;Animation Name;Start;End;Duration;Steps;Planned Duration;Updates/sec;Error?";
    static IAnimationStatistics NULL_OBJECT = IStatisticsManager.INSTRUMENTATION_ENABLED ? new NullAnimationStatistics() : null;
    private final List animations = new LinkedList();
    private final IAnimationController animationController;

    AnimationStatistics(StatisticsManager statisticsManager) {
        this.animationController = statisticsManager.getHMITerminal(0).getIAnimationController();
    }

    public void reset() {
        this.animations.clear();
    }

    public String getName() {
        return "AnimationStatistics.csv";
    }

    public void dump(PrintStream printStream, String string) {
        try {
            this.doDump(printStream);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void registerAnimation(int n, int n2, long l, long l2, long l3, int n3, Exception exception) {
        AnimationInfo animationInfo = new AnimationInfo();
        animationInfo.type = n;
        animationInfo.steps = n2;
        animationInfo.end = l2;
        animationInfo.start = l;
        animationInfo.plannedTime = l3;
        animationInfo.timerInterval = n3;
        animationInfo.e = exception;
        this.animations.add(animationInfo);
    }

    private void doDump(PrintStream printStream) {
        if (this.animations.isEmpty()) {
            printStream.println("No measurements have been collected");
            return;
        }
        printStream.println(HEADER);
        Iterator iterator = this.animations.iterator();
        while (iterator.hasNext()) {
            AnimationInfo animationInfo = (AnimationInfo)iterator.next();
            int n = (int)(animationInfo.end - animationInfo.start);
            Buffer buffer = new Buffer(64).append(animationInfo.type).append(";").append(this.animationController.getAnimationName(animationInfo.type)).append(";").append(animationInfo.start).append(";").append(animationInfo.end).append(";").append(animationInfo.end - animationInfo.start).append(";").append(animationInfo.steps).append(";").append(animationInfo.plannedTime).append(";").append((float)animationInfo.steps / ((float)(n + animationInfo.timerInterval) / 1000.0f)).append(";").append(animationInfo.e);
            printStream.println(buffer);
        }
    }

    private static class AnimationInfo {
        private int type = 0;
        private long start = 0L;
        private int steps = 0;
        private long end = 0L;
        private long plannedTime = 0L;
        private int timerInterval = 0;
        private Exception e = null;

        private AnimationInfo() {
        }
    }

    private static final class NullAnimationStatistics
    implements IAnimationStatistics {
        private NullAnimationStatistics() {
        }

        public String getName() {
            return "AnimationStatistics.csv";
        }

        public void dump(PrintStream printStream, String string) {
        }

        public void reset() {
        }

        public void registerAnimation(int n, int n2, long l, long l2, long l3, int n3, Exception exception) {
        }
    }
}

