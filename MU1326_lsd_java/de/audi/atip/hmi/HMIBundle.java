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
    public static final String PROP_KEY_APP_NAME;
    public static final String PROP_KEY_SKIN;

    default public Screen getScreen(int n, int n2) {
    }

    default public String getSkin() {
    }

    default public int getId() {
    }

    default public URL getKzbUrlFromClassloader(int n) {
    }

    default public URL getKzbUrlFromClassloader(String string) {
    }

    default public URL getImageUrlFromClassloader(int n) {
    }

    default public URL getImageUrlFromClassloader(int n, int n2) {
    }

    default public String getImagePath(int n, int n2) {
    }

    default public String getKzbPath(String string) {
    }

    default public String getKzbPath(int n, int n2) {
    }

    default public String getText(int n) {
    }

    default public IDrawerController[] getSelectionDrawers(int n) {
    }

    default public IDrawerController[] getOptionDrawers(int n) {
    }

    default public List getEntertainmentDrawerContent(int n) {
    }

    default public IDrawerController getEntertainmentDrawer(int n) {
    }

    default public HMIConditionBank getConditionBank() {
    }

    default public IPartialPopupController[] getPartialPopupStubs(int n) {
    }

    default public IPartialPopupController getPartialPopup(int n, int n2) {
    }
}

