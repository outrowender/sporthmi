/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.personal;

import de.audi.tghu.navi.app.addressinput.poi.personal.PersonalPoiHandler;
import de.audi.tghu.navi.app.command.NavCommand;

class PersonalPoiHandler$1
extends NavCommand {
    private final /* synthetic */ String[] val$paths;
    private final /* synthetic */ PersonalPoiHandler this$0;

    PersonalPoiHandler$1(PersonalPoiHandler personalPoiHandler, String string, String[] stringArray) {
        this.this$0 = personalPoiHandler;
        this.val$paths = stringArray;
        super(string);
    }

    @Override
    public void execute() {
        PersonalPoiHandler.access$000(this.this$0).flushCacheForPOIIcon();
        PersonalPoiHandler.access$100(this.this$0).onDatabaseDeleted(this.val$paths);
        this.getCommandList().commandFinished();
    }
}

