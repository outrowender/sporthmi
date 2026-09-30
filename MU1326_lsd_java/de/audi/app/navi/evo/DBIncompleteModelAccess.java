/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo;

import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.tghu.navi.app.IDBIncompleteModelAccess;
import de.audi.tghu.navi.app.NavigationEnv;
import de.esolutions.fw.util.commons.Buffer;

public class DBIncompleteModelAccess
implements IDBIncompleteModelAccess {
    private static final String COMMA = ",";
    private final NavigationEnv env;

    public DBIncompleteModelAccess(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
    }

    public void onUpdateNavDbRegionsState(int n, String[] stringArray) {
        String string;
        if (n != 1) {
            return;
        }
        this.env.getLogChannel().log(10000000, "DBIncompleteModelAccess#onUpdateNavDbRegionsState()");
        LabelModelApp labelModelApp = this.env.getLabelModel(401327);
        if (stringArray == null) {
            string = "";
        } else {
            int n2 = stringArray.length;
            Buffer buffer = new Buffer();
            for (int i2 = 0; i2 < n2 - 1; ++i2) {
                buffer.append(stringArray[i2]);
                buffer.append(COMMA);
            }
            buffer.append(stringArray[n2 - 1]);
            string = buffer.toString();
        }
        this.env.getLogChannel().log(10000000, "DBIncompleteModelAccess#onUpdateNavDbRegionsState() - countries: %1", (Object)string);
        labelModelApp.setText(string);
        this.showPopUp();
    }

    private void showPopUp() {
        this.env.getFramework().getHmiServiceApp().showPartialPopup(0, 400149);
    }
}

