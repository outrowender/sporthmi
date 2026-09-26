/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.fileplayer.content;

import de.audi.app.media.content.media.fileplayer.FilePlayerSession;
import de.audi.app.media.content.media.fileplayer.content.FilePlayerContent;
import de.audi.app.media.content.media.fileplayer.content.FilePlayerContent$SessionPlayer$1;
import de.audi.app.media.content.media.fileplayer.content.FilePlayerContent$SessionPlayer$2;
import de.audi.app.media.content.media.fileplayer.content.FilePlayerContent$SessionPlayer$3;
import de.audi.app.media.content.media.fileplayer.content.FilePlayerContent$SessionPlayer$4;
import de.audi.app.media.content.media.fileplayer.content.FilePlayerContent$SessionPlayer$5;
import de.audi.app.media.content.media.fileplayer.content.FilePlayerContent$SessionPlayer$6;
import de.audi.app.media.content.media.fileplayer.content.FilePlayerContent$SessionPlayer$7;
import de.audi.app.media.content.media.fileplayer.content.IFilePlayer;
import de.audi.atip.interapp.media.IMediaFileSessionPlayer;

class FilePlayerContent$SessionPlayer
implements IMediaFileSessionPlayer {
    private final FilePlayerSession session;
    private final IFilePlayer player;
    private final /* synthetic */ FilePlayerContent this$0;

    public FilePlayerContent$SessionPlayer(FilePlayerContent filePlayerContent, FilePlayerSession filePlayerSession, IFilePlayer iFilePlayer) {
        this.this$0 = filePlayerContent;
        this.session = filePlayerSession;
        this.player = iFilePlayer;
    }

    public FilePlayerSession getSession() {
        return this.session;
    }

    @Override
    public void resume() {
        FilePlayerContent.access$800(this.this$0).main().log(1078071040, "[%1.resume] [%2]", (Object)"FilePlayerContent", (Object)this.session);
        this.this$0.getTerminal().getDispatcher().execute(new FilePlayerContent$SessionPlayer$1(this, "FilePlayer.resume"));
    }

    @Override
    public void pause() {
        FilePlayerContent.access$1800(this.this$0).main().log(1078071040, "[%1.pause] [%2]", (Object)"FilePlayerContent", (Object)this.session);
        this.this$0.getTerminal().getDispatcher().execute(new FilePlayerContent$SessionPlayer$2(this, "FilePlayer.pause"));
    }

    @Override
    public void play(String string, boolean bl) {
        FilePlayerContent.access$2100(this.this$0).main().log(1078071040, "[%1.play] [%2] '%3'", (Object)"FilePlayerContent", (Object)this.session, (Object)string);
        this.this$0.getTerminal().getDispatcher().execute(new FilePlayerContent$SessionPlayer$3(this, "FilePlayer.playURL", string, bl));
    }

    @Override
    public void setVideoScaling(int n, int n2, int n3, int n4) {
        FilePlayerContent.access$2400(this.this$0).main().log(1078071040, "[%1.setVideoScaling] [%2]", (Object)"FilePlayerContent", (Object)this.session);
        this.this$0.getTerminal().getDispatcher().execute(new FilePlayerContent$SessionPlayer$4(this, "FilePlayer.setVideoScaling", n, n2, n3, n4));
    }

    @Override
    public void stop() {
        FilePlayerContent.access$2700(this.this$0).main().log(1078071040, "[%1.stop] [%2]", (Object)"FilePlayerContent", (Object)this.session);
        this.this$0.getTerminal().getDispatcher().execute(new FilePlayerContent$SessionPlayer$5(this, "FilePlayer.stop"));
    }

    @Override
    public void seek(boolean bl) {
        FilePlayerContent.access$3000(this.this$0).main().log(1078071040, "[%1.seek] [%2] '%3'", (Object)"FilePlayerContent", (Object)this.session, (Object)(bl ? "FORWARD" : "BACKWARD"));
        this.this$0.getTerminal().getDispatcher().execute(new FilePlayerContent$SessionPlayer$6(this, "FilePlayer.seek", bl));
    }

    @Override
    public void skip(int n) {
        FilePlayerContent.access$3500(this.this$0).main().log(1078071040, "[%1.skip] [%2] '%3'", (Object)"FilePlayerContent", (Object)this.session, (long)n);
        this.this$0.getTerminal().getDispatcher().execute(new FilePlayerContent$SessionPlayer$7(this, "FilePlayer.skip", n));
    }

    static /* synthetic */ FilePlayerContent access$900(FilePlayerContent$SessionPlayer filePlayerContent$SessionPlayer) {
        return filePlayerContent$SessionPlayer.this$0;
    }

    static /* synthetic */ FilePlayerSession access$1000(FilePlayerContent$SessionPlayer filePlayerContent$SessionPlayer) {
        return filePlayerContent$SessionPlayer.session;
    }

    static /* synthetic */ IFilePlayer access$1500(FilePlayerContent$SessionPlayer filePlayerContent$SessionPlayer) {
        return filePlayerContent$SessionPlayer.player;
    }
}

