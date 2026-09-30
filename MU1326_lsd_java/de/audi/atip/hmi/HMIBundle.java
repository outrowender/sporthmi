/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi;

import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.view.IDrawerController;
import de.audi.atip.hmi.view.IPartialPopupController;
import de.audi.atip.hmi.view.Screen;
import java.net.URL;
import java.util.List;

public interface HMIBundle {
    public static final String PROP_KEY_APP_NAME = "ApplicationName";
    public static final String PROP_KEY_SKIN = "Skin";

    public Screen getScreen(int var1, int var2);

    public String getSkin();

    public int getId();

    public URL getKzbUrlFromClassloader(int var1);

    public URL getKzbUrlFromClassloader(String var1);

    public URL getImageUrlFromClassloader(int var1);

    public URL getImageUrlFromClassloader(int var1, int var2);

    public String getImagePath(int var1, int var2);

    public String getKzbPath(String var1);

    public String getKzbPath(int var1, int var2);

    public String getText(int var1);

    public IDrawerController[] getSelectionDrawers(int var1);

    public IDrawerController[] getOptionDrawers(int var1);

    public List getEntertainmentDrawerContent(int var1);

    public IDrawerController getEntertainmentDrawer(int var1);

    public HMIConditionBank getConditionBank();

    public IPartialPopupController[] getPartialPopupStubs(int var1);

    public IPartialPopupController getPartialPopup(int var1, int var2);
}

