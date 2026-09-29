/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.messaging.core.compose.NewMessage;
import de.audi.app.messaging.core.swdiagnosis.IDiagPlugIn;
import de.esolutions.fw.util.commons.Buffer;

final class NewMessage$DiagPlugIn
implements IDiagPlugIn {
    private final /* synthetic */ NewMessage this$0;

    NewMessage$DiagPlugIn(NewMessage newMessage) {
        this.this$0 = newMessage;
    }

    public void cmdSetBodyExampleText() {
        String[][] stringArray = new String[][]{{"Hallo"}, {".", "!"}, {" "}, {"Stehe", "Schlehe", "Sehe", "Gehe"}, {" "}, {"gerade"}, {" "}, {"im Stau", "am Bau", "genau"}, {"."}, {" "}, {"Komme"}, {" "}, {"sp\u00e4ter", "\u00c4ther"}, {"."}};
        NewMessage.access$1500(this.this$0).setText(stringArray, -1);
        this.this$0.bodyChanged(false);
    }

    public void cmdSetBodyByLength(int n) {
        String string = "Hallo! Stehe gerade im Stau. Komme sp\u00e4ter. ";
        Buffer buffer = new Buffer(n);
        for (int i2 = 0; i2 < n; ++i2) {
            buffer.append(string.charAt(i2 % string.length()));
        }
        NewMessage.access$1500(this.this$0).setText(buffer.toString(), -1);
        this.this$0.bodyChanged(false);
    }
}

