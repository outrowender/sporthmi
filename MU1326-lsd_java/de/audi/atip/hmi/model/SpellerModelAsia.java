/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.AbstractModel;
import de.audi.atip.hmi.model.SpellerListenerAsia;
import de.audi.atip.hmi.model.SpellerModel;
import de.audi.atip.hmi.modelaccess.SpellerModelAsiaApp;
import de.audi.atip.hmi.modelaccess.SpellerModelAsiaGUI;
import de.esolutions.fw.util.commons.Buffer;

public class SpellerModelAsia
extends SpellerModel
implements SpellerModelAsiaApp,
SpellerModelAsiaGUI {
    private String phonetic = "";

    public SpellerModelAsia(int n) {
        super(n);
    }

    public SpellerModelAsia(int n, int n2) {
        super(n, n2);
    }

    @Override
    public int getModelType() {
        return 15;
    }

    @Override
    public String dumpContent() {
        Buffer buffer = new Buffer(200);
        buffer.append(super.dumpContent());
        buffer.append("\nphonetic: \"");
        buffer.append(this.phonetic);
        buffer.append('\"');
        return buffer.toString();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void copy(AbstractModel abstractModel) {
        try {
            Object object = this.mutex;
            synchronized (object) {
                SpellerModelAsia spellerModelAsia = (SpellerModelAsia)abstractModel;
                this.phonetic = spellerModelAsia.phonetic;
                super.copy(abstractModel);
            }
        }
        catch (Exception exception) {
            this.lc.log(10000, "(%2) SpellerModelAsia.copy( %1 ) failed! ", (Object)abstractModel, (long)this.id);
            this.lc.log(10000, "ERROR: ", (Throwable)exception);
        }
    }

    @Override
    public String getPhonetic() {
        return this.phonetic;
    }

    @Override
    public void setText(String string, String string2) {
        this.phonetic = string2;
        super.setText(string);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void textChanged(String string, String string2, int n) {
        this.lc.log(-2137614336, "(%3) SpellerModelAsia.textChanged(%1, %2) ", (Object)string, (Object)string2, (long)this.id);
        Object object = this.mutex;
        synchronized (object) {
            this.text = string;
            this.phonetic = string2;
            this.stateChanged();
        }
        try {
            ((SpellerListenerAsia)this.spellerListener).textChanged(this.id, string, string2, n);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void textChanged(String string, String string2, char c2, int n) {
        if (this.lc.isDebug()) {
            this.lc.log(-2137614336, "(%4) SpellerModelAsia.textChanged(%1, %2, %3)", (Object)string, (Object)string2, (Object)Character.toString(c2), (long)this.id);
        }
        Object object = this.mutex;
        synchronized (object) {
            this.text = string;
            this.phonetic = string2;
            this.stateChanged();
        }
        try {
            ((SpellerListenerAsia)this.spellerListener).textChanged(this.id, string, string2, c2, n);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }
}

