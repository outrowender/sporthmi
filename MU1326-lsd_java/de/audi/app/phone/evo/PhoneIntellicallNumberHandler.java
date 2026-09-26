/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo;

import de.audi.app.phone.evo.AbstractEvoPhoneComponent;
import de.audi.app.phone.evo.ITelEvoApplication;
import de.audi.atip.hmi.model.SpellerListener;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.esolutions.fw.util.commons.Buffer;

public class PhoneIntellicallNumberHandler
extends AbstractEvoPhoneComponent
implements SpellerListener {
    public PhoneIntellicallNumberHandler(ITelEvoApplication iTelEvoApplication) {
        super(iTelEvoApplication, "App.Phone.Main");
    }

    @Override
    public void init() {
        this.getSpellerModel(1737819136).setSpellerListener(this);
    }

    @Override
    public void deinit() {
        this.getSpellerModel(1737819136).resetListener();
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.log.log(-2137614336, "[PhoneIntellicallNumberHandler#keyPressed] model=%1, key=%2, terminal=%3", (long)n, (long)n2, (long)n3);
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
        this.log.log(-2137614336, "[PhoneIntellicallNumberHandler#keyReleased] model=%1, key=%2, terminal=%3", (long)n, (long)n2, (long)n3);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1078071040, "[PhoneIntellicallNumberHandler#keyTyped] model=%1, key=%2, terminal=%3", (long)n, (long)n2, (long)n3);
        if (n == 1737819136) {
            SpellerModelApp spellerModelApp = this.getSpellerModel(1737819136);
            String string = spellerModelApp.getText();
            if (string != null && string.length() > 0) {
                this.log.log(-2137614336, "[PhoneIntellicallNumberHandler#keyTyped] dialing number %1", (Object)string);
                this.getApplication().getTelephoneDSIAccess().dialNumber(string, n3);
                spellerModelApp.clear();
            } else {
                this.log.log(-2137614336, "[PhoneIntellicallNumberHandler#keyTyped] no number entered --> NOP!");
            }
        }
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        if (this.log.isInfo()) {
            Buffer buffer = new Buffer();
            buffer.append("model=");
            buffer.append(n);
            buffer.append(", text=");
            buffer.append(string);
            buffer.append(", latestChar=");
            buffer.append(c2);
            buffer.append(", terminal=");
            buffer.append(n2);
            this.log.log(1078071040, "[PhoneIntellicallNumberHandler#textChanged] %1", (Object)buffer);
        }
    }

    @Override
    public void commandPressed(int n, int n2, int n3) {
        this.log.log(-2137614336, "[PhoneIntellicallNumberHandler#commandPressed] model=%1, index=%2, terminal=%3", (long)n, (long)n2, (long)n3);
    }

    @Override
    public void focusedCharacter(int n, char c2, int n2) {
    }
}

