/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.esolutions.hmi.widgets.audi.evo.widgets.ContainerController$MutableAnimationTransformation;

public interface ContainerController$AnimationTransformation {
    default public float getTransX() {
    }

    default public float getTransY() {
    }

    default public float getScale() {
    }

    default public float getOpacity() {
    }

    default public ContainerController$MutableAnimationTransformation copyTo(ContainerController$MutableAnimationTransformation containerController$MutableAnimationTransformation) {
    }

    default public ContainerController$MutableAnimationTransformation getIntermediateTransformation(ContainerController$MutableAnimationTransformation containerController$MutableAnimationTransformation, ContainerController$AnimationTransformation containerController$AnimationTransformation, float f2) {
    }
}

