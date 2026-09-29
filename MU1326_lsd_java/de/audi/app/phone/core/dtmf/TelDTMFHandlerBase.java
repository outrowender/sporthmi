/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dtmf;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.util.TelLoggingUtils;
import de.audi.atip.hmi.model.SpellerListener;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;

public class TelDTMFHandlerBase
extends AbstractPhoneComponent
implements SpellerListener {
    public TelDTMFHandlerBase(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
    }

    @Override
    public void init() {
        super.init();
        this.getDTMFSpellerModel().setSpellerListener(this);
    }

    @Override
    public void deinit() {
        super.deinit();
        this.getDTMFSpellerModel().resetListener();
    }

    protected SpellerModelApp getDTMFSpellerModel() {
        return this.getSpellerModel(1603666944);
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        if (this.log.isInfo()) {
            this.log.log(1078071040, "[TelDTMFHandlerBase#textChanged] %1", (Object)TelLoggingUtils.textChanged(n, string, c2, n2));
        }
        if (string != null) {
            if (c2 == '\b') {
                if (string.length() == 0) {
                    this.log.log(-2137614336, "[TelDTMFHandlerBase#textChanged] all characters deleted --> NOP!");
                } else {
                    this.log.log(-2137614336, "[TelDTMFHandlerBase#textChanged] last character deleted --> NOP!");
                }
            } else {
                this.getApplication().getTelephoneDSIAccess().sendDTMF(String.valueOf(c2), n2);
            }
        }
    }

    @Override
    public void focusedCharacter(int n, char c2, int n2) {
    }

    @Override
    public void commandPressed(int n, int n2, int n3) {
    }
}

