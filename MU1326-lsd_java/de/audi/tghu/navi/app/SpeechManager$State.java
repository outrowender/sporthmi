/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.tghu.navi.app.PersistentState;
import de.audi.tghu.navi.app.SpeechManager;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class SpeechManager$State
extends PersistentState {
    public static final int VERSION;
    public static final int KEY;
    private int guidanceMode;
    private int announcementOnCall;
    private int guidanceLastMode;

    public SpeechManager$State(IStorageAccess iStorageAccess, LogChannel logChannel) {
        super(iStorageAccess, 2, 1004, 841, logChannel);
    }

    @Override
    protected void initWithDefaultValues() {
        this.guidanceMode = SpeechManager.getDefaultGuidanceMode();
        this.guidanceLastMode = SpeechManager.getDefaultGuidanceMode();
        this.announcementOnCall = SpeechManager.getDefaultAnnouncementOnCall();
    }

    @Override
    protected void initFromOldKeys(IStorageAccess iStorageAccess) {
        this.guidanceMode = iStorageAccess.getInt(1004, 300, SpeechManager.getDefaultGuidanceMode());
        this.announcementOnCall = iStorageAccess.getInt(1004, 310, SpeechManager.getDefaultAnnouncementOnCall());
    }

    @Override
    protected void serialize(DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(this.guidanceMode);
        dataOutputStream.writeInt(this.announcementOnCall);
        dataOutputStream.writeInt(this.guidanceLastMode);
    }

    @Override
    protected void deserialize(DataInputStream dataInputStream) {
        this.guidanceMode = dataInputStream.readInt();
        this.announcementOnCall = dataInputStream.readInt();
        this.guidanceLastMode = dataInputStream.readInt();
    }

    @Override
    protected void convertContainer(int n, int n2, DataInputStream dataInputStream) {
        this.getLogChannel().log(-2137614336, "SetupListener.State#convertContainer( %1, %2 )", (long)n, (long)n2);
        this.initWithDefaultValues();
        try {
            if (n > 0) {
                this.guidanceMode = dataInputStream.readInt();
                this.announcementOnCall = dataInputStream.readInt();
            }
            if (n > 1) {
                this.guidanceLastMode = dataInputStream.readInt();
            }
        }
        catch (IOException iOException) {
            this.getLogChannel().log(10000, "SetupListener.State#convertContainer - error on converting the persistent state format", (Throwable)iOException);
        }
    }

    public int getGuidanceMode() {
        return this.guidanceMode;
    }

    public void setGuidanceMode(int n) {
        this.guidanceMode = n;
    }

    public int getAnnouncementOnCall() {
        return this.announcementOnCall;
    }

    public void setAnnouncementOnCall(int n) {
        this.announcementOnCall = n;
    }

    public int getGuidanceLastMode() {
        return this.guidanceLastMode;
    }

    public void setGuidanceLastMode(int n) {
        this.guidanceLastMode = n;
    }
}

