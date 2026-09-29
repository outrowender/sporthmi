/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.commands;

import de.audi.tghu.navi.app.addressinput.poi.IPoiScreenOnElementSelected;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LIValueListElement;

public class ModelOnElementSelectedCommand
extends NavCommand {
    private final IPoiScreenOnElementSelected modelAccess;
    private final LIValueListElement selectedElement;

    public ModelOnElementSelectedCommand(IPoiScreenOnElementSelected iPoiScreenOnElementSelected, LIValueListElement lIValueListElement) {
        this.modelAccess = iPoiScreenOnElementSelected;
        this.selectedElement = lIValueListElement;
    }

    @Override
    public void execute() {
        this.modelAccess.onElementSelected(this.selectedElement);
        this.getCommandList().commandFinished();
    }
}

