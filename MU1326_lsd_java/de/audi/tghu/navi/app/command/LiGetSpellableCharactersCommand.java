/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;

public class LiGetSpellableCharactersCommand
extends NavCommand {
    public static final String RESULT = "SPELLABLE_CHARACTERS_RESULT";
    private final NavLocation location;
    private final int criterion;

    public LiGetSpellableCharactersCommand(NavLocation navLocation, int n) {
        this.location = navLocation;
        this.criterion = n;
    }

    public void execute() {
        this.logger.log(10000000, "LiGetSpellableCharactersCommand#execute() - calling liGetSpellableCharacters( %1, %2 )", (Object)LocationFormatter.formatLocationShort(this.location), (long)this.criterion);
        this.getDSINavigation().liGetSpellableCharacters(this.location, this.criterion);
    }

    public void liGetSpellableCharactersResult(NavLocation navLocation, int n, String string, int n2) {
        this.logger.log(10000000, "LiGetSpellableCharactersCommand#liGetSpellableCharactersResult() - using location: %1, criterion: %2", (Object)LocationFormatter.formatLocationShort(navLocation), (long)n);
        if (n2 == 0) {
            this.logger.log(10000000, "LiGetSpellableCharactersCommand#liGetSpellableCharactersResult() - got characters '%1'", (Object)string);
            this.getCommandList().put(RESULT, string);
            this.getCommandList().commandFinished();
        } else {
            this.logger.log(10000, "LiGetSpellableCharactersCommand#liGetSpellableCharactersResult() - got error code %1 !", (long)n2);
            this.getCommandList().commandAborted(n2);
        }
    }
}

