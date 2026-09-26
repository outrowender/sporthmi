/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

public interface TextEditorListenerDD {
    default public void openAlternativesList(int n, int n2, int n3) {
    }

    default public boolean alternativeSelected(boolean bl, int n, int n2, int n3) {
    }

    default public void textChanged(int n, int n2, int n3) {
    }

    default public void commandPressed(int n, int n2, int n3) {
    }

    default public void maxTextLengthChanged(int n) {
    }
}

