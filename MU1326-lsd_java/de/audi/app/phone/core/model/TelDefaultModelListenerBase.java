/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.model;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.esolutions.fw.util.commons.Buffer;

public class TelDefaultModelListenerBase
extends AbstractPhoneComponent {
    protected final int modelID;

    protected static Buffer getLogMessage(int n, int n2, int n3) {
        Buffer buffer = new Buffer();
        buffer.append("modelID=");
        buffer.append(n);
        buffer.append(", ");
        buffer.append("keyID=");
        buffer.append(n2);
        buffer.append(", ");
        buffer.append("terminalID=");
        buffer.append(n3);
        return buffer;
    }

    public TelDefaultModelListenerBase(ITelApplication iTelApplication, String string, int n) {
        super(iTelApplication, string);
        this.modelID = n;
    }

    public TelDefaultModelListenerBase(ITelApplication iTelApplication, int n) {
        super(iTelApplication, "App.Phone.Main");
        this.modelID = n;
    }

    protected void fireEvent(int n) {
        this.getApplication().getFrameworkAccess().getHMIService().getModelApp(this.modelID).fireEvent(n);
    }
}

