/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.tm.UserInputModeHandler;

class UserInputModeHandler$1
extends DefaultChoiceListener {
    private final /* synthetic */ TVEnv val$env;
    private final /* synthetic */ UserInputModeHandler this$0;

    UserInputModeHandler$1(UserInputModeHandler userInputModeHandler, TVEnv tVEnv) {
        this.this$0 = userInputModeHandler;
        this.val$env = tVEnv;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.val$env.lcHMI.log(-2137614336, "[UserInputModeHandler.keyTyped] key panel timout");
        this.this$0.changeUserInputMode(1);
    }
}

