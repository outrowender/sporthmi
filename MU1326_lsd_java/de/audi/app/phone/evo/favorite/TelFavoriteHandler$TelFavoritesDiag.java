/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.phone.IPhoneDiagComponent
 */
package de.audi.app.phone.evo.favorite;

import de.audi.app.phone.evo.favorite.TelFavoriteHandler;
import de.audi.app.phone.evo.favorite.TelFavoriteHandler$1;
import de.audi.app.phone.evo.favorite.TelFavoriteListHandler;
import de.mib.swdiagnosis.phone.IPhoneDiagComponent;
import org.dsi.ifc.organizer.ProfileInfo;

class TelFavoriteHandler$TelFavoritesDiag
implements IPhoneDiagComponent {
    private final /* synthetic */ TelFavoriteHandler this$0;

    private TelFavoriteHandler$TelFavoritesDiag(TelFavoriteHandler telFavoriteHandler) {
        this.this$0 = telFavoriteHandler;
    }

    public void cmdAddFavorite(String string, String string2) {
        TelFavoriteListHandler telFavoriteListHandler = TelFavoriteHandler.access$100(this.this$0);
        if (telFavoriteListHandler != null) {
            telFavoriteListHandler.addToFavorites(string, string2, 0);
        }
    }

    public void cmdAddMaximumFavorites() {
        for (int i2 = 0; i2 < 50; ++i2) {
            String string = new StringBuffer().append("Favorite ").append(i2).toString();
            TelFavoriteListHandler telFavoriteListHandler = TelFavoriteHandler.access$100(this.this$0);
            if (telFavoriteListHandler == null) continue;
            telFavoriteListHandler.addToFavorites(string, "084583332840", 0);
        }
    }

    public void cmdRemoveFavorite(int n) {
        TelFavoriteListHandler telFavoriteListHandler = TelFavoriteHandler.access$100(this.this$0);
        if (telFavoriteListHandler != null) {
            telFavoriteListHandler.removeFavorite(n);
        }
    }

    public void cmdRenameFavorite(int n, String string) {
        TelFavoriteListHandler telFavoriteListHandler = TelFavoriteHandler.access$100(this.this$0);
        if (telFavoriteListHandler != null) {
            telFavoriteListHandler.renameFavorite(n, string);
        }
    }

    public void cmdLoadFavoriteListFromPersistence() {
        TelFavoriteListHandler telFavoriteListHandler = TelFavoriteHandler.access$100(this.this$0);
        if (telFavoriteListHandler != null) {
            telFavoriteListHandler.loadFavoriteListFromPersistence();
        }
    }

    public void cmdFavoritesUpdateActiveProfile(int n) {
        ProfileInfo profileInfo = new ProfileInfo();
        profileInfo.num = n;
        this.this$0.updateActiveProfile(profileInfo);
    }

    public void cmdFavoritesProfileDeleted(int n) {
        this.this$0.profileDeleted(n);
    }

    /* synthetic */ TelFavoriteHandler$TelFavoritesDiag(TelFavoriteHandler telFavoriteHandler, TelFavoriteHandler$1 telFavoriteHandler$1) {
        this(telFavoriteHandler);
    }
}

