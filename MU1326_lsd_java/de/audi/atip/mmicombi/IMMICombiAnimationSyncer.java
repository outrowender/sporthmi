/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.mmicombi;

import de.audi.atip.hmi.view.IAnimation;
import de.audi.atip.mmicombi.IMMICombiAnimationPlan;
import de.audi.atip.mmicombi.exchange.MMICombiDisplayStatus;

public interface IMMICombiAnimationSyncer {
    public static final int ANNOTATION_VERSION_COUNT = 2;
    public static final int ANNOTATION_VERSION_0 = 0;
    public static final int ANNOTATION_VERSION_1 = 1;
    public static final int ANNOTATION_VERSION_PREVIOUS = 0;
    public static final int ANNOTATION_VERSION_CURRENT = 1;
    public static final String ANNOTATION_HEADER = "V";
    public static final String ANNOTATION_BLOCK_END = "|";
    public static final String ANNOTATION_PARAMETER_SEPARATOR = "-";
    public static final String ANNOTATION_EMPTY_TEXT = "";
    public static final String ANNOTATION_ANIMATION_SEPARATOR = ":";
    public static final String ANIMATION_STATUS_FINISHED_TEXT = "f";
    public static final String ANIMATION_STATUS_CONTINUING_TEXT = "c";
    public static final String ANIMATION_STATUS_AT_START_TEXT = "s";
    public static final String ANIMATION_STATUS_WAITING_FOR_START_TEXT = "w";
    public static final int ANIMATION_STATUS_WAITING_FOR_START = 0;
    public static final int ANIMATION_STATUS_AT_START = 1;
    public static final int ANIMATION_STATUS_CONTINUING = 2;
    public static final int ANIMATION_STATUS_FINISHED = 3;

    public void blockAnimations(boolean var1);

    public void executeAnimationPlan(IMMICombiAnimationPlan var1);

    public void processAnimationPlanUpdate(IMMICombiAnimationPlan var1);

    public String getSyncAnnotation(int var1);

    public boolean isCombiSyncNeeded(int var1);

    public void animationActivated(IAnimation var1);

    public int getDefinedCanContext(int var1);

    public MMICombiDisplayStatus getLastConfirmedDisplayStatus();

    public int[] getSyncedAnimationTypes();

    public int getMappedMMICombiContext(int var1);

    public boolean isAnimationPlanActive();

    public void activateNewAnimationPlan();

    public IMMICombiAnimationPlan getCurrentAnimationPlan();

    public void setSkin(int var1);

    public void setKdKVisible(boolean var1);
}

