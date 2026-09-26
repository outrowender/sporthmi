/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;

public class SetLanguageCommand
extends NavCommand {
    private String language;

    public SetLanguageCommand(String string) {
        this.language = string;
    }

    @Override
    public void execute() {
        String string = this.dsiResponseContainer.getLanguage();
        if (!this.language.equalsIgnoreCase(string)) {
            this.logger.log(-2137614336, "SetLanguageCommand#execute() - calling setLanguage( %1 -> %2 ) ", (Object)string, (Object)this.language);
            this.getDSINavigation().setLanguage(this.language);
        } else {
            this.logger.log(-2137614336, "SetLanguageCommand#execute() - language: %1 already set! ", (Object)this.language);
            this.getCommandList().commandFinished();
        }
    }

    @Override
    public void updateLanguage(String string) {
        this.logger.log(-2137614336, "SetLanguageCommand#updateLanguage( %1 ) ", (Object)string);
        super.updateLanguage(string);
        this.getCommandList().commandFinished();
    }
}

