/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.guide;

public interface ICoreActionProxy {
    public static final int TRANSITION_TYPE_ENTER = 0;
    public static final int TRANSITION_TYPE_EXIT = 1;
    public static final int SEARCHABLE_VIEW_FOLDER_CONTENTS = 0;
    public static final int SEARCHABLE_VIEW_RECIPIENTS = 1;

    public void parentFolderSelected(int var1);

    public void messageCompositionEntered(int var1);

    public void readoutScreensExited(int var1);

    public void templateReplacementExited(int var1);

    public void templateListEntered(int var1);

    public void onlineLicenseCheckEntered(int var1);

    public void onlineLicenseCheckExited(int var1);

    public void officeEnteredFromMainWizard(int var1);

    public void searchableViewTransition(int var1, int var2, int var3);

    public void detailViewTransition(int var1, int var2);

    public void messageCompositionTransition(int var1, int var2);
}

