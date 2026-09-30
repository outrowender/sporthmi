/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LIValueListElement;

public class LispSetInputSimpleCommand
extends NavCommand {
    private LIValueListElement element;

    public LispSetInputSimpleCommand(LIValueListElement lIValueListElement) {
        this.element = lIValueListElement;
    }

    public void execute() {
        if (this.element.isHasListIndex()) {
            this.logger.log(10000000, "LispSetInputCommand#execute() - calling lispSelectListItem( %1 ) ", (long)this.element.getListIndex());
            this.getDSINavigation().lispSelectListItem(this.element.getListIndex());
        } else {
            this.logger.log(10000000, "LispSetInputCommand#execute() - calling lispSetInput( %2, %1 ) ", true, (Object)this.element.getData());
            this.getDSINavigation().lispSetInput(this.element.getData(), true);
        }
    }

    public void liResult(long l) {
        this.logger.log(10000000, "LispSetInputCommand#liResult()", l);
        if (l == 0L) {
            this.getCommandList().commandFinished();
        } else {
            this.logger.log(10000000, "LispSetInputCommand#liResult() - got error code %1 !", l);
            this.getCommandList().commandAborted(l);
        }
    }
}

