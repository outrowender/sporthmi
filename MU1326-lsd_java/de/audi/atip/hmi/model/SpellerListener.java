/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

public interface SpellerListener {
    default public void keyPressed(int n, int n2, int n3) {
    }

    default public void keyReleased(int n, int n2, int n3) {
    }

    default public void keyTyped(int n, int n2, int n3) {
    }

    default public void textChanged(int n, String string, char c2, int n2) {
    }

    default public void focusedCharacter(int n, char c2, int n2) {
    }

    default public void commandPressed(int n, int n2, int n3) {
    }
}

