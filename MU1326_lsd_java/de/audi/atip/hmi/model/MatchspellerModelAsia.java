/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.AbstractModel;
import de.audi.atip.hmi.model.MatchspellerListenerAsia;
import de.audi.atip.hmi.model.MatchspellerModel;
import de.audi.atip.hmi.modelaccess.MatchspellerModelAsiaApp;
import de.audi.atip.hmi.modelaccess.MatchspellerModelAsiaGUI;
import de.esolutions.fw.util.commons.Buffer;

public class MatchspellerModelAsia
extends MatchspellerModel
implements MatchspellerModelAsiaApp,
MatchspellerModelAsiaGUI {
    private String validNonAlphaNumTPChars;
    private int nonAlphaNumMode;
    private int initialInputMode;
    private boolean allowNonAlphaNumInput = true;

    public MatchspellerModelAsia(int n) {
        super(n);
    }

    public MatchspellerModelAsia(int n, int n2) {
        super(n, n2);
    }

    public String dumpContent() {
        Buffer buffer = new Buffer(200);
        buffer.append(super.dumpContent());
        buffer.append("\nvalidNonAlphaNumTPChars: ");
        buffer.append(this.validNonAlphaNumTPChars);
        buffer.append("\nnonAlphaNumMode: ");
        buffer.append(this.nonAlphaNumMode);
        buffer.append("\ninitialInputMode: ");
        buffer.append(this.initialInputMode);
        return buffer.toString();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void copy(AbstractModel abstractModel) {
        try {
            Object object = this.mutex;
            synchronized (object) {
                MatchspellerModelAsia matchspellerModelAsia = (MatchspellerModelAsia)abstractModel;
                this.validNonAlphaNumTPChars = matchspellerModelAsia.validNonAlphaNumTPChars;
                this.nonAlphaNumMode = matchspellerModelAsia.nonAlphaNumMode;
                this.initialInputMode = matchspellerModelAsia.initialInputMode;
                super.copy(abstractModel);
            }
        }
        catch (Exception exception) {
            this.lc.log(10000, "(%2) [MatchspellerModelAsia.copy] FAILED to copy %1", (Object)abstractModel, (long)this.id);
            this.lc.log(10000, "ERROR: ", (Throwable)exception);
        }
    }

    public int getModelType() {
        return 21;
    }

    public void nonAlphaNumTPCharsChanged(String string, int n) {
        try {
            ((MatchspellerListenerAsia)this.spellerListener).nonAlphaNumTPCharsChanged(this.id, n, string);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setValidNonAlphaNumTPCharacters(String string) {
        Object object = this.mutex;
        synchronized (object) {
            this.validNonAlphaNumTPChars = string;
            this.stateChanged();
        }
        this.fireModelUpdateEvent(17);
    }

    public void setInitialInputMode(int n) {
        this.initialInputMode = n;
    }

    public void setAllowNonAlphaNumInput(boolean bl) {
        this.allowNonAlphaNumInput = bl;
    }

    public int getNonAlphaNumMode(int n) {
        return this.nonAlphaNumMode;
    }

    public int getInitialInputMode(int n) {
        return this.initialInputMode;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String getValidNonAlphaNumTPCharacters(int n) {
        Object object = this.mutex;
        synchronized (object) {
            return this.validNonAlphaNumTPChars;
        }
    }

    public void inputModeTPChanged(int n, int n2) {
        try {
            ((MatchspellerListenerAsia)this.spellerListener).inputModeTPChanged(this.id, n, n2);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    public boolean getAllowNonAlphaNumInput(int n) {
        return this.allowNonAlphaNumInput;
    }
}

