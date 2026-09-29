/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.asia;

import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AbstractToneAndCaseTogglingTable$1;
import de.esolutions.hmi.widgets.audi.evo.widgets.asia.AbstractToneAndCaseTogglingTable$ICharacterWithToneAndCase;

class AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus
implements AbstractToneAndCaseTogglingTable$ICharacterWithToneAndCase {
    private final char charValue;
    private final int status;
    private AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus mainCharWithStatus;
    private AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus nextCharWithStatus;

    private AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus(char c2, int n) {
        this.charValue = c2;
        this.status = n;
    }

    @Override
    public int getCurrentStatus() {
        return this.status;
    }

    @Override
    public AbstractToneAndCaseTogglingTable$ICharacterWithToneAndCase getNextCharWithStatus() {
        return this.nextCharWithStatus;
    }

    @Override
    public char getCurrentStatusChar() {
        return this.charValue;
    }

    @Override
    public char getMainChar() {
        if (null == this.mainCharWithStatus) {
            this.mainCharWithStatus = this;
        }
        return this.mainCharWithStatus.charValue;
    }

    @Override
    public AbstractToneAndCaseTogglingTable$ICharacterWithToneAndCase getMainCharWithStatus() {
        return this.mainCharWithStatus;
    }

    /* synthetic */ AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus(char c2, int n, AbstractToneAndCaseTogglingTable$1 abstractToneAndCaseTogglingTable$1) {
        this(c2, n);
    }

    static /* synthetic */ AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus access$102(AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus, AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus2) {
        abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.mainCharWithStatus = abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus2;
        return abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.mainCharWithStatus;
    }

    static /* synthetic */ AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus access$202(AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus, AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus2) {
        abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.nextCharWithStatus = abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus2;
        return abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.nextCharWithStatus;
    }

    static /* synthetic */ AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus access$200(AbstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus) {
        return abstractToneAndCaseTogglingTable$JPCharacterWrapperWithStatus.nextCharWithStatus;
    }
}

