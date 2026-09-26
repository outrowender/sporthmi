/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.favorite;

import de.audi.app.navi.favorite.NaviFavoriteHmiListener;
import de.audi.tghu.navi.app.command.NavCommand;

class NaviFavoriteHmiListener$1
extends NavCommand {
    private final /* synthetic */ NaviFavoriteHmiListener this$0;

    NaviFavoriteHmiListener$1(NaviFavoriteHmiListener naviFavoriteHmiListener, String string) {
        this.this$0 = naviFavoriteHmiListener;
        super(string);
    }

    @Override
    public void execute() {
        NaviFavoriteHmiListener.access$000(this.this$0).getPreviewMap().setPreviewAreaAroundCCP(1);
        this.getCommandList().commandFinished();
    }
}

