/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.ap;

import de.audi.atip.statemachine.ActionProxy;

public interface MessagingActionProxy
extends ActionProxy {
    public void parentFolderSelected(int var1);

    public void readoutScreensExited(int var1);

    public void detailViewTransition(int var1, int var2);

    public void messageCompositionTransition(int var1, int var2);

    public void compositionSpeedThresholdPopupReturn(int var1);

    public void messagingTransition(int var1, int var2);

    public void editViewTransition(int var1, int var2);

    public void templateReplacementExited(int var1);

    public void officeEnteredFromMainWizard(int var1);

    public void searchableViewTransition(int var1, int var2, int var3);
}

