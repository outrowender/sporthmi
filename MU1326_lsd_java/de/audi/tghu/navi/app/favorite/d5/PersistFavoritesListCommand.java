/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.favorite.d5;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.favorite.d5.FavoriteIndex;
import de.audi.tghu.navi.app.util.LocalPersistNavLocationHelper;
import de.audi.tghu.navi.app.util.Util;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class PersistFavoritesListCommand
extends NavCommand {
    private static final String CLASS_NAME = Util.getClassNameFromPackageName(class$de$audi$tghu$navi$app$favorite$d5$PersistFavoritesListCommand == null ? (class$de$audi$tghu$navi$app$favorite$d5$PersistFavoritesListCommand = PersistFavoritesListCommand.class$("de.audi.tghu.navi.app.favorite.d5.PersistFavoritesListCommand")) : class$de$audi$tghu$navi$app$favorite$d5$PersistFavoritesListCommand);
    private FavoriteIndex favoritesList;
    static /* synthetic */ Class class$de$audi$tghu$navi$app$favorite$d5$PersistFavoritesListCommand;

    public PersistFavoritesListCommand(FavoriteIndex favoriteIndex) {
        this.favoritesList = favoriteIndex;
    }

    public void execute() {
        try {
            byte[] byArray = this.serialize();
            new LocalPersistNavLocationHelper(this.env, 990).savePersistentState(byArray);
        }
        catch (IOException iOException) {
            this.env.getLogChannel().log(10000, "%1#execute - Failed to persist favorites index because of %2", (Object)CLASS_NAME, (Throwable)iOException);
        }
        this.getCommandList().commandFinished();
    }

    protected byte[] serialize() throws IOException {
        this.logger.log(10000000, "[%1#serialize] favorites=%2", (Object)CLASS_NAME, (Object)this.favoritesList);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(dataOutputStream);
        objectOutputStream.writeObject(this.favoritesList);
        objectOutputStream.close();
        dataOutputStream.close();
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

