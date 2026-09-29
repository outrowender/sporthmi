/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.info.app.tmc.TMCListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.tmc.DSITmcListener;

class TMCListener$10
extends CommandResponse {
    private final /* synthetic */ String val$currentLanguage;
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ TMCListener this$0;

    TMCListener$10(TMCListener tMCListener, String string, int n) {
        this.this$0 = tMCListener;
        this.val$currentLanguage = string;
        this.val$validFlag = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSITmcListener)dSIListener).updateCurrentLanguage(this.val$currentLanguage, this.val$validFlag);
    }
}

