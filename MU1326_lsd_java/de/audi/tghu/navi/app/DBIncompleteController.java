/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.IDBIncompleteModelAccess;
import de.audi.tghu.navi.app.NavigationEnv;

public class DBIncompleteController {
    private final IDBIncompleteModelAccess dbIncompleteModelAccess;
    private final LogChannel logChannel;
    private final NavigationEnv env;

    public DBIncompleteController(IDBIncompleteModelAccess iDBIncompleteModelAccess, LogChannel logChannel, NavigationEnv navigationEnv) {
        this.dbIncompleteModelAccess = iDBIncompleteModelAccess;
        this.logChannel = logChannel;
        this.env = navigationEnv;
    }

    public void updateNavDbRegionsState(int n, String[] stringArray, int n2) {
        this.logChannel.log(10000000, "DBIncompleteController#updateNavDbRegionsState(%1,%2,%3)", (Object)stringArray, (long)n, (long)n2);
        if (n2 != 1) {
            return;
        }
        if (n == 0 || n == 2) {
            return;
        }
        if (n == 1 && this.env.getChoiceModel(392).getValue() == 0) {
            this.logChannel.log(10000000, "DBIncompleteController#updateNavDbRegionsState(%1,%2,%3) - update was not OK.", (Object)stringArray, (long)n, (long)n2);
            this.dbIncompleteModelAccess.onUpdateNavDbRegionsState(n, stringArray);
        }
    }
}

