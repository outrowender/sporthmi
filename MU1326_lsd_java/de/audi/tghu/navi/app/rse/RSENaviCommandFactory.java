/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.rse;

import de.audi.atip.rse.AbstractRSECommand;
import de.audi.atip.rse.AbstractRSECommandFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.rse.RSENaviCommand;
import de.audi.tghu.navi.app.rse.RSESyncCriteria;
import de.audi.tghu.navi.app.rse.RSETransferLocation;

public class RSENaviCommandFactory
extends AbstractRSECommandFactory {
    public RSENaviCommandFactory(NavigationEnv navigationEnv) {
        super(5);
        RSENaviCommandFactory.setLog(navigationEnv.getRSELogChannel());
    }

    protected AbstractRSECommand getRSECommand(int n) {
        log.log(10000000, "RSENaviCommandFactory#getRSECommand( %1 )", (long)n);
        RSENaviCommand rSENaviCommand = null;
        switch (n) {
            case 1281: {
                rSENaviCommand = new RSETransferLocation();
                break;
            }
            case 1282: {
                rSENaviCommand = new RSESyncCriteria();
                break;
            }
            default: {
                log.log(100000, "RSENaviCommandFactory#getRSECommand() - unsupported command id: %1", (long)n);
            }
        }
        return rSENaviCommand;
    }
}

