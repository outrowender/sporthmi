/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.pla;

import de.audi.app.earlyfunc.core.parking.pla.PLAPopinHandler;

class PLAPopinHandler$PlaSMTransition {
    private final int sourceState;
    private final int targetState;
    private final int[] actions;
    private final /* synthetic */ PLAPopinHandler this$0;

    PLAPopinHandler$PlaSMTransition(PLAPopinHandler pLAPopinHandler, int n, int n2, int[] nArray) {
        this.this$0 = pLAPopinHandler;
        this.sourceState = n;
        this.targetState = n2;
        this.actions = nArray;
    }

    int getSourceState() {
        return this.sourceState;
    }

    int getTargetState() {
        return this.targetState;
    }

    int[] getActions() {
        return this.actions;
    }
}

