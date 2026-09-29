/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings.parental;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tv.app.settings.parental.PasswordController;
import de.audi.tv.app.settings.parental.PasswordController$1;

class PasswordController$EnterPasswordListener
extends DefaultButtonListener {
    private final /* synthetic */ PasswordController this$0;

    private PasswordController$EnterPasswordListener(PasswordController passwordController) {
        this.this$0 = passwordController;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        switch (n) {
            case 2600020: {
                PasswordController.access$200((PasswordController)this.this$0).lcHMI.log(-2137614336, "[PasswordController.EnterPasswordListener.keyTyped] parental rating entered.");
                PasswordController.access$300(this.this$0).setStatus(1);
                this.this$0.resetPasswordConfirmation();
                PasswordController.access$400(this.this$0).fireEvent(n3);
                break;
            }
            case 2600122: {
                PasswordController.access$200((PasswordController)this.this$0).lcHMI.log(-2137614336, "[PasswordController.EnterPasswordListener.keyTyped] parental rating entered through options.");
                PasswordController.access$300(this.this$0).setStatus(0);
                this.this$0.resetPasswordConfirmation();
                PasswordController.access$300(this.this$0).fireEvent(n3);
                break;
            }
            case 2600012: {
                PasswordController.access$200((PasswordController)this.this$0).lcHMI.log(-2137614336, "[PasswordController.EnterPasswordListener.keyTyped] entered changing password mode.");
                PasswordController.access$502(this.this$0, 1);
                PasswordController.access$600(this.this$0).clear();
                PasswordController.access$700(this.this$0).setStatus(0);
                PasswordController.access$800(this.this$0).fireEvent(n3);
                break;
            }
            case 2600124: {
                PasswordController.access$200((PasswordController)this.this$0).lcHMI.log(-2137614336, "[PasswordController.EnterPasswordListener.keyTyped] confirmation button pressed.");
                PasswordController.access$900(this.this$0);
                PasswordController.access$700(this.this$0).fireEvent(n3);
                break;
            }
        }
    }

    /* synthetic */ PasswordController$EnterPasswordListener(PasswordController passwordController, PasswordController$1 passwordController$1) {
        this(passwordController);
    }
}

