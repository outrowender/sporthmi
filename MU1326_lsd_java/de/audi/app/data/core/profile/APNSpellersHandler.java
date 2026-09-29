/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core.profile;

import de.audi.atip.hmi.model.SpellerListener;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;

public class APNSpellersHandler
implements SpellerListener {
    private static final char STAR;
    protected final LogChannel log;
    protected final SpellerModelApp apnSpeller;
    protected final SpellerModelApp apnSpeller2;
    protected final SpellerModelApp usernameSpeller;
    protected final SpellerModelApp usernameSpeller2;
    protected final SpellerModelApp passwordSpeller;
    protected final SpellerModelApp passwordSpeller2;

    static final String stars(String string) {
        Buffer buffer = new Buffer();
        if (null != string) {
            for (int i2 = 0; i2 < string.length(); ++i2) {
                buffer.append('*');
            }
        }
        return buffer.toString();
    }

    public APNSpellersHandler(LogChannel logChannel, SpellerModelApp spellerModelApp, SpellerModelApp spellerModelApp2, SpellerModelApp spellerModelApp3, SpellerModelApp spellerModelApp4, SpellerModelApp spellerModelApp5, SpellerModelApp spellerModelApp6) {
        this.log = logChannel;
        this.apnSpeller = spellerModelApp;
        this.apnSpeller2 = spellerModelApp2;
        this.usernameSpeller = spellerModelApp3;
        this.usernameSpeller2 = spellerModelApp4;
        this.passwordSpeller = spellerModelApp5;
        this.passwordSpeller2 = spellerModelApp6;
    }

    void init() {
        this.apnSpeller.setSpellerListener(this);
        this.apnSpeller2.setSpellerListener(this);
        this.usernameSpeller.setSpellerListener(this);
        this.usernameSpeller2.setSpellerListener(this);
        this.passwordSpeller.setSpellerListener(this);
        this.passwordSpeller2.setSpellerListener(this);
    }

    void deinit() {
        this.apnSpeller.resetListener();
        this.apnSpeller2.resetListener();
        this.usernameSpeller.resetListener();
        this.usernameSpeller2.resetListener();
        this.passwordSpeller.resetListener();
        this.passwordSpeller2.resetListener();
    }

    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        if (n == this.apnSpeller.getID()) {
            this.log.log(-2137614336, "AbstractDataProfile#textChanged(): APN: %1", (Object)string);
            this.updateSpellerStatusApn(string);
        } else if (n == this.apnSpeller2.getID()) {
            this.log.log(-2137614336, "AbstractDataProfile#textChanged(): APN: %1", (Object)string);
            if (string.length() <= this.apnSpeller.getMaxLength()) {
                this.apnSpeller.setText(string);
            }
            this.updateSpellerStatusApn(string);
            this.apnSpeller2.fireEvent(n2);
        } else if (n == this.usernameSpeller.getID()) {
            this.log.log(-2137614336, "AbstractDataProfile#textChanged(): user namer: %1", (Object)string);
            this.updateSpellerStatusUsername(string);
        } else if (n == this.usernameSpeller2.getID()) {
            this.log.log(-2137614336, "AbstractDataProfile#textChanged(): user namer: %1", (Object)string);
            if (string.length() <= this.usernameSpeller.getMaxLength()) {
                this.usernameSpeller.setText(string);
            }
            this.updateSpellerStatusUsername(string);
            this.usernameSpeller2.fireEvent(n2);
        } else if (n == this.passwordSpeller.getID()) {
            this.log.log(-2137614336, "AbstractDataProfile#textChanged(): password: %1", (Object)string);
            this.updateSpellerStatusPassword(string);
        } else if (n == this.passwordSpeller2.getID()) {
            this.log.log(-2137614336, "AbstractDataProfile#textChanged(): password: %1", (Object)string);
            if (string.length() <= this.passwordSpeller.getMaxLength()) {
                this.passwordSpeller.setText(string);
            }
            this.updateSpellerStatusPassword(string);
            this.passwordSpeller2.fireEvent(n2);
        }
    }

    void setupHMIValue(String string, String string2, String string3) {
        this.apnSpeller.setText(string);
        this.apnSpeller2.setText(string);
        this.updateSpellerStatusApn(string);
        this.usernameSpeller.setText(string2);
        this.usernameSpeller2.setText(string2);
        this.updateSpellerStatusUsername(string2);
        this.passwordSpeller.setText(string3);
        this.passwordSpeller2.setText(string3);
        this.updateSpellerStatusPassword(string3);
    }

    void onApnTextFieldClick(String string) {
        this.apnSpeller.setText(string);
        this.apnSpeller2.setText(string);
        this.updateSpellerStatusApn(string);
    }

    void onUsernameTextFieldClick(String string) {
        this.usernameSpeller.setText(string);
        this.usernameSpeller2.setText(string);
        this.updateSpellerStatusUsername(string);
    }

    void onPasswordTextFieldClick(String string) {
        this.passwordSpeller.setText(string);
        this.passwordSpeller2.setText(string);
        this.updateSpellerStatusPassword(string);
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void focusedCharacter(int n, char c2, int n2) {
    }

    @Override
    public void commandPressed(int n, int n2, int n3) {
    }

    protected void updateSpellerStatusApn(String string) {
        this.apnSpeller.setStatus(0);
    }

    protected void updateSpellerStatusUsername(String string) {
        this.usernameSpeller.setStatus(0);
    }

    protected void updateSpellerStatusPassword(String string) {
        this.passwordSpeller.setStatus(0);
    }
}

