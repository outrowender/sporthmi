/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.favorite.d5;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.LocationToStreamCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.favorite.FavoriteLocationFormatDummy;
import de.audi.tghu.navi.app.favorite.IFavoriteLocationFormat;
import de.audi.tghu.navi.app.favorite.d5.FavoriteIndex;
import de.audi.tghu.navi.app.favorite.d5.FavoriteLocation;
import de.audi.tghu.navi.app.favorite.d5.FavoriteObserver;
import de.audi.tghu.navi.app.favorite.d5.NotifyTrufflesCommand;
import de.audi.tghu.navi.app.favorite.d5.PersistFavoritesListCommand;
import de.audi.tghu.navi.app.favorite.d5.PersistNavLocationCommand;
import de.audi.tghu.navi.app.search.AbstractNaviSearchDataProvider;
import de.audi.tghu.navi.app.util.LocalPersistNavLocationHelper;
import de.audi.tghu.navi.app.util.Util;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.dsi.ifc.global.NavLocation;

public class FavoriteStore {
    private static final String CLASS_NAME = Util.getClassNameFromPackageName(class$de$audi$tghu$navi$app$favorite$d5$FavoriteStore == null ? (class$de$audi$tghu$navi$app$favorite$d5$FavoriteStore = FavoriteStore.class$("de.audi.tghu.navi.app.favorite.d5.FavoriteStore")) : class$de$audi$tghu$navi$app$favorite$d5$FavoriteStore);
    protected final NavigationEnv env;
    private final AbstractNaviSearchDataProvider provider;
    private final ICommandListFactory factory;
    private FavoriteIndex favorites;
    private final IFavoriteLocationFormat favoriteLocationFormat;
    private final Set observer;
    static /* synthetic */ Class class$de$audi$tghu$navi$app$favorite$d5$FavoriteStore;
    static /* synthetic */ Class class$de$audi$tghu$command$ICommandListFactory;

    public FavoriteStore(NavigationEnv navigationEnv, AbstractNaviSearchDataProvider abstractNaviSearchDataProvider) {
        this.env = navigationEnv;
        this.provider = abstractNaviSearchDataProvider;
        this.observer = new HashSet();
        this.factory = (ICommandListFactory)navigationEnv.getService(class$de$audi$tghu$command$ICommandListFactory == null ? (class$de$audi$tghu$command$ICommandListFactory = FavoriteStore.class$("de.audi.tghu.command.ICommandListFactory")) : class$de$audi$tghu$command$ICommandListFactory);
        this.favorites = this.loadFavoriteIndex();
        if (this.favorites == null) {
            this.favorites = new FavoriteIndex();
        }
        this.favoriteLocationFormat = new FavoriteLocationFormatDummy();
    }

    private FavoriteIndex loadFavoriteIndex() {
        FavoriteIndex favoriteIndex = null;
        byte[] byArray = new LocalPersistNavLocationHelper(this.env, 990).loadPersistentState();
        if (byArray != null && byArray.length > 1) {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
                DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
                ObjectInputStream objectInputStream = new ObjectInputStream(dataInputStream);
                favoriteIndex = (FavoriteIndex)objectInputStream.readObject();
                objectInputStream.close();
                dataInputStream.close();
                byteArrayInputStream.close();
            }
            catch (StreamCorruptedException streamCorruptedException) {
                this.logException(streamCorruptedException);
            }
            catch (EOFException eOFException) {
                this.logException(eOFException);
            }
            catch (IOException iOException) {
                this.logException(iOException);
            }
            catch (ClassNotFoundException classNotFoundException) {
                this.logException(classNotFoundException);
            }
        }
        this.env.getLogChannel().log(10000000, "%1#loadFavoriteIndex() - %2", (Object)CLASS_NAME, favoriteIndex);
        return favoriteIndex;
    }

    private void logException(Exception exception) {
        this.env.getLogChannel().log(10000, "%1#loadFavoriteIndex() failed - %2", (Object)CLASS_NAME, (Throwable)exception);
    }

    public FavoriteLocation saveNewFavorite(NavLocation navLocation, String string, CommandList commandList) {
        Util.setFavoriteNameOnLocation(navLocation, string);
        FavoriteLocation favoriteLocation = this.createFavorite(navLocation, string);
        int n = this.favorites.addFavorite(favoriteLocation);
        CommandList commandList2 = this.commandsToSave(navLocation, commandList, n);
        commandList2.execute("SaveNewFavoriteCommandList");
        return favoriteLocation;
    }

    public CommandList getCommandsToSaveNewFavorite(NavLocation navLocation, String string, CommandList commandList) {
        Util.setFavoriteNameOnLocation(navLocation, string);
        FavoriteLocation favoriteLocation = this.createFavorite(navLocation, string);
        int n = this.favorites.addFavorite(favoriteLocation);
        return this.commandsToSave(navLocation, commandList, n);
    }

    private CommandList commandsToSave(NavLocation navLocation, CommandList commandList, int n) {
        CommandList commandList2 = this.factory.createCommandList(1);
        commandList2.add(new LocationToStreamCommand(navLocation));
        commandList2.add(new PersistNavLocationCommand(n));
        commandList2.add(new PersistFavoritesListCommand(this.favorites));
        commandList2.add(new NotifyTrufflesCommand(this.provider));
        commandList2.add(new NotifyObserversCommand());
        commandList2.add(commandList);
        return commandList2;
    }

    public void resetFavorites() {
        this.favorites = new FavoriteIndex();
        CommandList commandList = this.factory.createCommandList(1);
        commandList.add(new PersistFavoritesListCommand(this.favorites));
        commandList.add(new NotifyTrufflesCommand(this.provider));
        commandList.add(new NotifyObserversCommand());
        commandList.execute("Commandlist to reset favorites");
    }

    private FavoriteLocation createFavorite(NavLocation navLocation, String string) {
        FavoriteLocation favoriteLocation = new FavoriteLocation();
        favoriteLocation.update(navLocation);
        if (string != null && string.length() > 0) {
            favoriteLocation.setField("NAME", string);
        }
        return favoriteLocation;
    }

    public void updateLocation(NavLocation navLocation, long l) {
        this.getCommandsToUpdateLocation(navLocation, l).execute("Commandlist to update stored location");
    }

    public CommandList getCommandsToUpdateLocation(NavLocation navLocation, long l) {
        FavoriteLocation favoriteLocation = this.favorites.getFavoriteByKey(l);
        CommandList commandList = this.factory.createCommandList(1);
        if (favoriteLocation != null && navLocation != null && navLocation.isPositionValid()) {
            favoriteLocation.update(navLocation);
            commandList.add(new LocationToStreamCommand(navLocation));
            commandList.add(new PersistNavLocationCommand(favoriteLocation.getKey()));
            commandList.add(new PersistFavoritesListCommand(this.favorites));
            commandList.add(new NotifyTrufflesCommand(this.provider));
            commandList.add(new NotifyObserversCommand());
        }
        return commandList;
    }

    public boolean delete(FavoriteLocation favoriteLocation) {
        if (this.favorites.delete(favoriteLocation)) {
            this.updatePersistance();
            return true;
        }
        return false;
    }

    public boolean delete(long l) {
        if (this.favorites.delete((int)l)) {
            this.updatePersistance();
            return true;
        }
        return false;
    }

    public boolean delete(Collection collection) {
        if (this.favorites.delete(collection)) {
            this.updatePersistance();
            return true;
        }
        return false;
    }

    private void updatePersistance() {
        CommandList commandList = this.factory.createCommandList(1);
        commandList.add(new PersistFavoritesListCommand(this.favorites));
        commandList.add(new NotifyTrufflesCommand(this.provider));
        commandList.add(new NotifyObserversCommand());
        commandList.execute("Commandlist to delete favorite from index");
    }

    public FavoriteIndex getIndex() {
        return this.favorites;
    }

    public void registerObserver(FavoriteObserver favoriteObserver) {
        if (favoriteObserver != null) {
            this.observer.add(favoriteObserver);
            favoriteObserver.notify(this.getIndex().getFavoritesList());
        }
    }

    public boolean unregisterObserver(FavoriteObserver favoriteObserver) {
        return this.observer.remove(favoriteObserver);
    }

    private void notifyObservers() {
        List list = this.getIndex().getFavoritesList();
        Iterator iterator = this.observer.iterator();
        while (iterator.hasNext()) {
            FavoriteObserver favoriteObserver = (FavoriteObserver)iterator.next();
            favoriteObserver.notify(list);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private class NotifyObserversCommand
    extends NavCommand {
        public NotifyObserversCommand() {
            super("notify observers");
        }

        public void execute() {
            FavoriteStore.this.notifyObservers();
            this.getCommandList().commandFinished();
        }
    }
}

