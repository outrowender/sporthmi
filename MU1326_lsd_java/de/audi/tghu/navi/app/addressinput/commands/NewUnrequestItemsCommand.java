/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.commands;

import de.audi.tghu.navi.app.addressinput.poi.models.IPoiScreenUnrequestItems;
import de.audi.tghu.navi.app.command.NavCommand;

public class NewUnrequestItemsCommand
extends NavCommand {
    private final int length;
    private final int startIndex;
    private final IPoiScreenUnrequestItems modelAccess;

    public NewUnrequestItemsCommand(int n, int n2, IPoiScreenUnrequestItems iPoiScreenUnrequestItems) {
        this.startIndex = n;
        this.length = n2;
        this.modelAccess = iPoiScreenUnrequestItems;
    }

    public void execute() {
        this.modelAccess.onUnrequestItems(this.startIndex, this.length);
        this.getCommandList().commandFinished();
    }
}

