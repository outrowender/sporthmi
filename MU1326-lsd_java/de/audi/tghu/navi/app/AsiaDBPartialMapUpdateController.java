/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.AsiaDBPartialMapUpdateModelAccess;
import de.esolutions.fw.util.commons.Buffer;

public class AsiaDBPartialMapUpdateController {
    private AsiaDBPartialMapUpdateModelAccess modelAccess;

    public AsiaDBPartialMapUpdateController(AsiaDBPartialMapUpdateModelAccess asiaDBPartialMapUpdateModelAccess, LogChannel logChannel) {
        this.modelAccess = asiaDBPartialMapUpdateModelAccess;
    }

    public void updateMapIntegrationState(int n) {
        this.modelAccess.onUpdateMapIntegrationState(n);
    }

    public void updateDatabaseVersionInfo(String[] stringArray) {
        String string;
        if (null == stringArray || stringArray.length == 0) {
            string = null;
        } else {
            Buffer buffer = new Buffer();
            if (stringArray.length > 4) {
                buffer.append(stringArray[3]);
                buffer.append(" ");
                buffer.append(stringArray[4]);
            } else {
                buffer.append(stringArray[0]);
            }
            string = buffer.toString();
        }
        this.modelAccess.setCurrentDatabaseVersionLabel(string);
    }
}

