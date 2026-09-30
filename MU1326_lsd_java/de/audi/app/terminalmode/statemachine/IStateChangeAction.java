/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.statemachine;

import de.audi.app.terminalmode.statemachine.IRequestor;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.tghu.command.CommandList;

public interface IStateChangeAction {
    public void execute(CommandList var1, TMState var2, IRequestor var3, long var4);

    public static interface IStateChangeActionOverride
    extends IStateChangeAction {
        public boolean executeSuperAction();
    }

    public static abstract class AbstractStateChangeActionHook
    implements IStateChangeActionOverride {
        public boolean executeSuperAction() {
            return true;
        }
    }

    public static abstract class AbstractStateChangeActionOverride
    implements IStateChangeActionOverride {
        public boolean executeSuperAction() {
            return false;
        }
    }
}

