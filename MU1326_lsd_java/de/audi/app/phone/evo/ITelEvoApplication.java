/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.evo.entertainmentdrawer.IEntertainmentDrawerControllerNew;
import de.audi.app.phone.evo.favorite.ITelFavoriteHandler;
import de.audi.app.phone.evo.intellicall.ITelIntellicallHandler;

public interface ITelEvoApplication
extends ITelApplication {
    public static final String LOGCHANNEL_ENTERTAINMENT_DRAWER = "App.Phone.EntertainmentDrawer";

    public ITelFavoriteHandler getFavoriteHandler();

    public ITelIntellicallHandler getIntellicallHandler();

    public IEntertainmentDrawerControllerNew getNewEntertainmentDrawerController();
}

