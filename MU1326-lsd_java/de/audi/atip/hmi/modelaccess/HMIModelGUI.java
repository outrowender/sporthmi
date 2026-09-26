/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.modelaccess.HMIModelBase;

public interface HMIModelGUI
extends HMIModelBase {
    default public int getModelType() {
    }

    default public void addReference() {
    }

    default public void removeReference() {
    }

    default public int getChangeState() {
    }

    default public int startDrag(int n, long l, int n2) {
    }

    default public void stopDrag(int n, long l, long l2) {
    }

    default public void drop(int n, long l, long l2, int n2, int n3) {
    }
}

