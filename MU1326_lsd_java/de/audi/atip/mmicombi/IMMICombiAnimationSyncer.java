/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.mmicombi;

import de.audi.atip.hmi.view.IAnimation;
import de.audi.atip.mmicombi.IMMICombiAnimationPlan;
import de.audi.atip.mmicombi.exchange.MMICombiDisplayStatus;

public interface IMMICombiAnimationSyncer {
    public static final int ANNOTATION_VERSION_COUNT;
    public static final int ANNOTATION_VERSION_0;
    public static final int ANNOTATION_VERSION_1;
    public static final int ANNOTATION_VERSION_PREVIOUS;
    public static final int ANNOTATION_VERSION_CURRENT;
    public static final String ANNOTATION_HEADER;
    public static final String ANNOTATION_BLOCK_END;
    public static final String ANNOTATION_PARAMETER_SEPARATOR;
    public static final String ANNOTATION_EMPTY_TEXT;
    public static final String ANNOTATION_ANIMATION_SEPARATOR;
    public static final String ANIMATION_STATUS_FINISHED_TEXT;
    public static final String ANIMATION_STATUS_CONTINUING_TEXT;
    public static final String ANIMATION_STATUS_AT_START_TEXT;
    public static final String ANIMATION_STATUS_WAITING_FOR_START_TEXT;
    public static final int ANIMATION_STATUS_WAITING_FOR_START;
    public static final int ANIMATION_STATUS_AT_START;
    public static final int ANIMATION_STATUS_CONTINUING;
    public static final int ANIMATION_STATUS_FINISHED;

    default public void blockAnimations(boolean bl) {
    }

    default public void executeAnimationPlan(IMMICombiAnimationPlan iMMICombiAnimationPlan) {
    }

    default public void processAnimationPlanUpdate(IMMICombiAnimationPlan iMMICombiAnimationPlan) {
    }

    default public String getSyncAnnotation(int n) {
    }

    default public boolean isCombiSyncNeeded(int n) {
    }

    default public void animationActivated(IAnimation iAnimation) {
    }

    default public int getDefinedCanContext(int n) {
    }

    default public MMICombiDisplayStatus getLastConfirmedDisplayStatus() {
    }

    default public int[] getSyncedAnimationTypes() {
    }

    default public int getMappedMMICombiContext(int n) {
    }

    default public boolean isAnimationPlanActive() {
    }

    default public void activateNewAnimationPlan() {
    }

    default public IMMICombiAnimationPlan getCurrentAnimationPlan() {
    }

    default public void setSkin(int n) {
    }

    default public void setKdKVisible(boolean bl) {
    }
}

