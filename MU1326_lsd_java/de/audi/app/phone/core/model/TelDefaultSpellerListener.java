/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.model;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.model.TelDefaultModelListenerBase;
import de.audi.atip.hmi.model.SpellerListener;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.esolutions.fw.util.commons.Buffer;

public class TelDefaultSpellerListener
extends TelDefaultModelListenerBase
implements SpellerListener {
    private final SpellerModelApp spellerModel;

    public static Buffer getTextChangedMsg(int n, String string, char c2, int n2) {
        Buffer buffer = new Buffer();
        buffer.append("model=");
        buffer.append(n);
        buffer.append(", ");
        buffer.append("text=");
        buffer.append(string);
        buffer.append(", ");
        buffer.append("latestChar=");
        buffer.append(c2);
        buffer.append(", ");
        buffer.append("terminal=");
        buffer.append(n2);
        return buffer;
    }

    public static Buffer getFocusedCharMsg(int n, char c2, int n2) {
        Buffer buffer = new Buffer();
        buffer.append("model=");
        buffer.append(n);
        buffer.append(", ");
        buffer.append("focusedCharacter=");
        buffer.append(c2);
        buffer.append(", ");
        buffer.append("terminal=");
        buffer.append(n2);
        return buffer;
    }

    public static Buffer getCmdPressedMsg(int n, int n2, int n3) {
        Buffer buffer = new Buffer();
        buffer.append("model=");
        buffer.append(n);
        buffer.append(", ");
        buffer.append("index=");
        buffer.append(n2);
        buffer.append(", ");
        buffer.append("terminal=");
        buffer.append(n3);
        return buffer;
    }

    public TelDefaultSpellerListener(ITelApplication iTelApplication, String string, int n) {
        super(iTelApplication, string, n);
        this.spellerModel = this.getSpellerModel(n);
    }

    public TelDefaultSpellerListener(ITelApplication iTelApplication, int n) {
        super(iTelApplication, n);
        this.spellerModel = this.getSpellerModel(n);
    }

    public void init() {
        super.init();
        this.getSpellerModel(this.modelID).setSpellerListener(this);
    }

    public void deinit() {
        super.deinit();
        this.getSpellerModel(this.modelID).resetListener();
    }

    protected SpellerModelApp getSpellerModel() {
        return this.spellerModel;
    }

    protected void setMinMaxLength(int n, int n2) {
        this.getSpellerModel().setMinLength(n);
        this.getSpellerModel().setMaxLength(n2);
    }

    public void clearSpeller() {
        this.getSpellerModel().clear();
    }

    public void getSpellerText() {
        this.getSpellerModel().getText();
    }

    public void keyPressed(int n, int n2, int n3) {
        if (this.log.isDebug()) {
            this.log.log(10000000, "[TelDefaultButtonListener#keyPressed] %1", (Object)TelDefaultSpellerListener.getLogMessage(n, n2, n3));
        }
    }

    public void keyReleased(int n, int n2, int n3) {
        if (this.log.isDebug()) {
            this.log.log(10000000, "[TelDefaultButtonListener#keyReleased] %1", (Object)TelDefaultSpellerListener.getLogMessage(n, n2, n3));
        }
    }

    public void keyTyped(int n, int n2, int n3) {
        if (this.log.isInfo()) {
            this.log.log(1000000, "[TelDefaultButtonListener#keyTyped] %1", (Object)TelDefaultSpellerListener.getLogMessage(n, n2, n3));
        }
    }

    public void textChanged(int n, String string, char c2, int n2) {
        if (this.log.isInfo()) {
            this.log.log(1000000, "[TelDefaultSpellerListener#textChanged] %1", (Object)TelDefaultSpellerListener.getTextChangedMsg(n, string, c2, n2));
        }
    }

    public void focusedCharacter(int n, char c2, int n2) {
        if (this.log.isDebug()) {
            this.log.log(10000000, "[TelDefaultSpellerListener#focusedCharacter] %1", (Object)TelDefaultSpellerListener.getFocusedCharMsg(n, c2, n2));
        }
    }

    public void commandPressed(int n, int n2, int n3) {
        if (this.log.isDebug()) {
            this.log.log(10000000, "[TelDefaultSpellerListener#commandPressed] %1", (Object)TelDefaultSpellerListener.getCmdPressedMsg(n, n2, n3));
        }
    }
}

