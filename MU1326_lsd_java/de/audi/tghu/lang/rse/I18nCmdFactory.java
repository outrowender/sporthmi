/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.lang.rse;

import de.audi.atip.base.FwServices;
import de.audi.atip.rse.AbstractRSECommand;
import de.audi.atip.rse.AbstractRSECommandFactory;
import de.audi.tghu.lang.rse.I18nCmdQueryLanguage;
import de.audi.tghu.lang.rse.I18nCmdSetLanguage;

public class I18nCmdFactory
extends AbstractRSECommandFactory {
    private final FwServices fwServices;

    public I18nCmdFactory(FwServices fwServices) {
        super(18);
        this.fwServices = fwServices;
    }

    protected AbstractRSECommand getRSECommand(int n) {
        switch (n) {
            case 4609: {
                return new I18nCmdSetLanguage(this.fwServices);
            }
            case 4610: {
                return new I18nCmdQueryLanguage(this.fwServices);
            }
        }
        return null;
    }
}

