/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.guide;

public interface ICoreActionProxy {
    public static final int TRANSITION_TYPE_ENTER;
    public static final int TRANSITION_TYPE_EXIT;
    public static final int SEARCHABLE_VIEW_FOLDER_CONTENTS;
    public static final int SEARCHABLE_VIEW_RECIPIENTS;

    default public void parentFolderSelected(int n) {
    }

    default public void messageCompositionEntered(int n) {
    }

    default public void readoutScreensExited(int n) {
    }

    default public void templateReplacementExited(int n) {
    }

    default public void templateListEntered(int n) {
    }

    default public void onlineLicenseCheckEntered(int n) {
    }

    default public void onlineLicenseCheckExited(int n) {
    }

    default public void officeEnteredFromMainWizard(int n) {
    }

    default public void searchableViewTransition(int n, int n2, int n3) {
    }

    default public void detailViewTransition(int n, int n2) {
    }

    default public void messageCompositionTransition(int n, int n2) {
    }
}

