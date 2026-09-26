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
    public static final String LOGCHANNEL_ENTERTAINMENT_DRAWER;

    default public ITelFavoriteHandler getFavoriteHandler() {
    }

    default public ITelIntellicallHandler getIntellicallHandler() {
    }

    default public IEntertainmentDrawerControllerNew getNewEntertainmentDrawerController() {
    }
}

