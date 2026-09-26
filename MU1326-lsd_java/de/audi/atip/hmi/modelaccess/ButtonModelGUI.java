/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.modelaccess.HMIModelGUI;

public interface ButtonModelGUI
extends HMIModelGUI {
    default public boolean getPressed() {
    }

    default public void keyPressed(int n, int n2) {
    }

    default public void keyReleased(int n, int n2) {
    }

    default public void keyTyped(int n, int n2) {
    }

    default public void keyLongTyped(int n, int n2) {
    }
}

