/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings.parental;

import de.audi.atip.hmi.model.listener.DefaultSpellerListener;
import de.audi.tv.app.settings.parental.PasswordController;
import de.audi.tv.app.settings.parental.PasswordController$1;

class PasswordController$PasswordModifiedListener
extends DefaultSpellerListener {
    private final /* synthetic */ PasswordController this$0;

    private PasswordController$PasswordModifiedListener(PasswordController passwordController) {
        this.this$0 = passwordController;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        PasswordController.access$200((PasswordController)this.this$0).lcHMI.log(-2137614336, "[PasswordController.PasswordModifiedListener.keyTyped] confirmation button pressed.");
        PasswordController.access$900(this.this$0);
        PasswordController.access$600(this.this$0).fireEvent(n3);
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        PasswordController.access$200((PasswordController)this.this$0).lcHMI.log(-2137614336, "[PasswordController.PasswordModifiedListener.textChanged] %1", (Object)string);
        PasswordController.access$600(this.this$0).setText(string);
        PasswordController.access$600(this.this$0).setStatus(1);
        if (string.length() < 4 || string.length() > 8) {
            PasswordController.access$700(this.this$0).setStatus(0);
        } else {
            PasswordController.access$700(this.this$0).setStatus(1);
        }
    }

    /* synthetic */ PasswordController$PasswordModifiedListener(PasswordController passwordController, PasswordController$1 passwordController$1) {
        this(passwordController);
    }
}

