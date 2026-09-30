/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.audi.atip.interapp.NavigationUtilities;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.HMIProperties;
import de.audi.remotehmi.media.MediaUtilities;
import de.audi.remotehmi.ui.mib2.Properties;
import de.audi.remotehmi.ui.mib2.grid.GeoPosition;
import de.audi.remotehmi.ui.mib2.grid.IGrid;
import de.audi.remotehmi.ui.mib2.grid.IGridList;
import de.audi.remotehmi.ui.mib2.grid.IReferencePoint;
import de.audi.remotehmi.util.Util;
import de.audi.tghu.online.app.remotehmi.NaviComponent;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;

class Decorator {
    private ResourceLocatorModelApp imageModel;
    private ChoiceModelApp layoutModel;
    private static final int LAYOUT_VALUE_INVISIBLE = 0;
    private static final int LAYOUT_VALUE_IMAGE = 1;
    private static final int LAYOUT_VALUE_MAP = 2;
    public static String[] layoutDescription = new String[]{"invisible", "image", "map"};
    public static final int TYPE_NONE = 0;
    public static final int TYPE_IMAGE = 1;
    public static final int TYPE_MAP = 2;
    public static String[] typeDescription = new String[]{"none", "image", "map"};
    private String commonImageUrl;
    private GeoPosition commonMapPositionDegree;
    private int commonStyle;
    private int decoratorType;
    private int originalLayout = 0;
    private LabelModelApp debugLabelModel;
    private final LogChannel logChannel;
    private final NaviComponent naviComponent;
    private final boolean showCoordinatesAsText;
    private final int variant;
    private final int VARIANT_TT;
    private final int VARIANT_HIGH;
    private final int VARIANT_SCALE;
    private static final int[] DEFAULT_RIGHT_OFFSET_NONE = new int[]{25, 25, 25};
    private static final int[] DEFAULT_RIGHT_OFFSET_MAP = new int[]{25, 290, 25};
    private static final int[] DEFAULT_RIGHT_OFFSET_IMAGE = new int[]{204, 245, 223};
    private int rightOffsetNone;
    private int rightOffsetMap;
    private int rightOffsetImage;
    private GeoPosition previousPositionWgs84 = GeoPosition.UNDEFINED_POSITION;

    public Decorator(LogChannel logChannel, RemoteHMIService remoteHMIService, ResourceLocatorModelApp resourceLocatorModelApp, ChoiceModelApp choiceModelApp, LabelModelApp labelModelApp) {
        this.VARIANT_TT = 0;
        this.VARIANT_HIGH = 1;
        this.VARIANT_SCALE = 2;
        this.logChannel = logChannel;
        this.imageModel = resourceLocatorModelApp;
        this.layoutModel = choiceModelApp;
        this.debugLabelModel = labelModelApp;
        this.variant = remoteHMIService.isTT() ? 0 : (remoteHMIService.isScale() ? 2 : 1);
        this.rightOffsetNone = DEFAULT_RIGHT_OFFSET_NONE[this.variant];
        this.rightOffsetMap = DEFAULT_RIGHT_OFFSET_MAP[this.variant];
        this.rightOffsetImage = DEFAULT_RIGHT_OFFSET_IMAGE[this.variant];
        this.naviComponent = remoteHMIService.getNaviComponent();
        this.showCoordinatesAsText = !remoteHMIService.isTarget();
    }

    private void setListItemImage(String string, int n) {
        String string2;
        int n2;
        String string3;
        String string4 = this.commonImageUrl;
        if (string == null || string.length() == 0) {
            if (string4 == null || string4.length() == 0) {
                string3 = ResourceLocatorModelApp.UNDEFINED_URI;
                n2 = n;
                string2 = "system image";
            } else {
                string3 = string4;
                n2 = -1;
                string2 = "common";
            }
        } else {
            string3 = string;
            n2 = -1;
            string2 = "list item specific";
        }
        this.imageModel.setResourceLocator(n2, string3);
        this.logChannel.log(1000000, "Decorator#setListItemImage: image decorator updated to %1 url='%2', id=%3", (Object)string2, (Object)string3, (long)n2);
    }

    private void setListItemMap(GeoPosition geoPosition, int n, IReferencePoint iReferencePoint) {
        boolean bl;
        String string;
        int n2;
        GeoPosition geoPosition2;
        GeoPosition geoPosition3 = iReferencePoint == null ? GeoPosition.UNDEFINED_POSITION : iReferencePoint.getGeoLocation();
        String string2 = iReferencePoint == null ? "rrd" : iReferencePoint.getType();
        this.logChannel.log(1000000, "Decorator#setListItemMap: refPointLocation='%1', refPointType='%2'", (Object)geoPosition3, (Object)string2);
        GeoPosition geoPosition4 = null;
        NavLocationWgs84 navLocationWgs84 = null;
        String string3 = "NULL";
        if (geoPosition == null) {
            geoPosition2 = this.commonMapPositionDegree;
            n2 = this.commonStyle;
            string = "common";
            bl = false;
        } else {
            geoPosition2 = geoPosition;
            n2 = n;
            string = "list item specific";
            bl = true;
        }
        if (geoPosition2 != null) {
            int n3 = NavigationUtilities.degreeToWgs84(geoPosition2.getLatitude());
            int n4 = NavigationUtilities.degreeToWgs84(geoPosition2.getLongitude());
            geoPosition4 = GeoPosition.createPosition(n3, n4);
            string3 = geoPosition2.toString(',');
            if (bl) {
                navLocationWgs84 = new NavLocationWgs84(n4, n3);
            }
        }
        if (this.showCoordinatesAsText) {
            this.debugLabelModel.setText(string3 + "(" + layoutDescription[this.layoutModel.getValue()] + ")");
        }
        if (GeoPosition.equals(geoPosition4, this.previousPositionWgs84)) {
            this.logChannel.log(1000000, "Decorator#setListItemMap: update cancelled: old and new coordinates are the same.");
            return;
        }
        this.previousPositionWgs84 = geoPosition4;
        this.logChannel.log(1000000, "Decorator#setListItemMap: setting %1 POI='%2' and style='%3' ", (Object)string, (Object)string3, (Object)Util.createInteger(n2));
        try {
            this.setPositionInMap(geoPosition3, string2, n2, navLocationWgs84);
        }
        catch (Exception exception) {
            this.logChannel.log(100000, "Decorator#setListItemMap: Exception %1", (Throwable)exception);
        }
    }

    private void setPositionInMap(GeoPosition geoPosition, String string, int n, NavLocationWgs84 navLocationWgs84) {
        NavLocation navLocation = null;
        if (navLocationWgs84 != null) {
            navLocation = new NavLocation();
            navLocation.latitude = navLocationWgs84.latitude;
            navLocation.longitude = navLocationWgs84.longitude;
        }
        this.logChannel.log(10000000, "Decorator#setPositionInMap: called for refPointLocation '%1', refPointType '%2', style '%3', poiPosition '%4'", (Object)geoPosition, (Object)string, (Object)new Integer(n), (Object)navLocation);
        IPreviewMap iPreviewMap = this.naviComponent.getPreviewMap();
        if (iPreviewMap == null) {
            this.logChannel.log(100000, "Decorator#setPositionInMap: IPreviewMap instance is null");
            return;
        }
        if (n != -1 && navLocation != null) {
            n = this.correctStyleType(n);
            iPreviewMap.setPreviewRouteEvent(navLocation, n, -1, null, null);
            return;
        }
        if (string.equalsIgnoreCase("rrd") || geoPosition.equals(GeoPosition.UNDEFINED_POSITION)) {
            if (navLocation == null) {
                iPreviewMap.setPreviewAreaAroundCCP(-1);
            } else {
                iPreviewMap.setPreviewLocationDistant(navLocation, -1, null, null);
            }
            return;
        }
        int n2 = NavigationUtilities.degreeToWgs84(geoPosition.getLongitude());
        int n3 = NavigationUtilities.degreeToWgs84(geoPosition.getLatitude());
        NavLocationWgs84 navLocationWgs842 = new NavLocationWgs84(n2, n3);
        NavLocation navLocation2 = new NavLocation();
        navLocation2.latitude = navLocationWgs842.latitude;
        navLocation2.longitude = navLocationWgs842.longitude;
        if (string.equalsIgnoreCase("city")) {
            if (navLocation == null) {
                iPreviewMap.setPreviewLocationCity(navLocation2, -1, null, null);
            } else {
                iPreviewMap.setPreviewLocationAroundReferencePoint(navLocation, navLocationWgs842, -1, null, null);
            }
            return;
        }
        if (string.equalsIgnoreCase("destination") || string.equalsIgnoreCase("stopover")) {
            if (navLocation == null) {
                iPreviewMap.setPreviewDestination(navLocation2, -1, null, null);
            } else {
                iPreviewMap.setPreviewLocationAroundDestination(navLocation, navLocationWgs842, -1, null, null);
            }
            return;
        }
        this.logChannel.log(100000, "Decorator#setPositionInMap: no position in map set: unknown reference point type: %1, location=%2", (Object)string, (Object)navLocation2);
    }

    private int correctStyleType(int n) {
        if (n == 2 || n == 3 || n == 4 || n == 5 || n == 6 || n == 7 || n == 8 || n == 9 || n == 10 || n == 11 || n == 12) {
            return 28;
        }
        return n;
    }

    public ResourceLocatorModelApp getImageModel() {
        return this.imageModel;
    }

    public void storeTypeAndDefault(HMIProperties hMIProperties, boolean bl) {
        int n;
        if (bl) {
            this.previousPositionWgs84 = GeoPosition.UNDEFINED_POSITION;
        }
        this.originalLayout = 0;
        if (hMIProperties.contains("decoratorUrl")) {
            String string = hMIProperties.getString("decoratorUrl");
            if (string.length() > 0) {
                n = 1;
                this.commonImageUrl = string;
            } else {
                n = 0;
                this.logChannel.log(100000, "Decorator#storeTypeAndDefault: common decoratorUrl should not be empty.");
            }
        } else if (hMIProperties.contains("decoratorMap")) {
            GeoPosition geoPosition;
            n = 2;
            this.commonMapPositionDegree = geoPosition = GeoPosition.fromDoubleArray(hMIProperties.getDoubleArray("decoratorMap"));
            this.commonStyle = hMIProperties.contains("decoratorMapStyle") ? hMIProperties.getInt("decoratorMapStyle") : -1;
        } else {
            n = 0;
        }
        this.logChannel.log(1000000, "Decorator#storeTypeAndDefault: Using %1 decorator", (Object)typeDescription[n]);
        this.decoratorType = n;
    }

    public void updateValues(IGrid iGrid, IReferencePoint iReferencePoint, boolean bl) {
        int n;
        int n2;
        GeoPosition geoPosition;
        String string;
        if (iGrid == null) {
            string = "";
            geoPosition = null;
            n2 = -1;
        } else {
            string = iGrid.getDecoratorImageUrl();
            geoPosition = iGrid.isMapDecoratorEnabled() ? iGrid.getMapDecoratorGeoPosition() : null;
            n2 = iGrid.getMapDecoratorStyle();
        }
        if (bl && iGrid != null) {
            String string2 = iGrid.getCloneForMediaList().getMediaCells()[3].getStringValue();
            n = MediaUtilities.calculateIdFromAlbum(string2, -1);
            this.logChannel.log(10000000, "Decorator#updateValues() system image %1 used for album '%2'.", (Object)new Integer(n), (Object)string2);
        } else {
            n = -1;
        }
        this.updateValues(string, n, geoPosition, iReferencePoint, n2);
    }

    private void updateValues(String string, int n, GeoPosition geoPosition, IReferencePoint iReferencePoint, int n2) {
        if (this.decoratorType == 1) {
            this.logChannel.log(1000000, "Decorator#updateValues: updating image decorator: decoratorImage=%1", (Object)string);
            this.setListItemImage(string, n);
        } else if (this.decoratorType == 2) {
            this.logChannel.log(1000000, "Decorator#updateValues: updating map decorator: geoPosition=%1 decoratorStyle=%2 referencePoint=%3", (Object)geoPosition, (Object)Util.createInteger(n2), (Object)iReferencePoint);
            this.setListItemMap(geoPosition, n2, iReferencePoint);
        } else if (this.decoratorType == 0) {
            this.logChannel.log(100000, "Decorator#updateValues: no decorator type set");
        } else {
            this.logChannel.log(100000, "Decorator#updateValues: Update cancelled: Unknown decoratorType=%1", (long)this.decoratorType);
        }
    }

    public void onExit() {
        this.previousPositionWgs84 = GeoPosition.UNDEFINED_POSITION;
        if (this.showCoordinatesAsText) {
            this.debugLabelModel.setText("");
        }
        if (this.decoratorType == 1) {
            this.imageModel.setResourceLocator(-1, ResourceLocatorModelApp.UNDEFINED_URI);
        }
    }

    public void setLayout(HMIProperties hMIProperties, IGridList iGridList) {
        String string = hMIProperties.getString("layout");
        if (string.length() == 0) {
            string = "auto";
        }
        if (!Properties.LAYOUTS.contains(string)) {
            this.logChannel.log(100000, "Decorator#setLayout: unknown layout '%1' given, using auto layout", (Object)string);
            string = "auto";
        }
        boolean bl = hMIProperties.contains("decoratorUrl");
        boolean bl2 = hMIProperties.contains("decoratorMap");
        this.logChannel.log(1000000, "Decorator#setLayout: default decorators given: image=%1, map=%2", (Object)bl, (Object)bl2);
        int n = string.equals("full") ? (bl2 && this.variant == 0 ? 2 : 0) : (string.equals("decorator") ? (bl ? 1 : (bl2 && this.variant != 2 ? 2 : 0)) : (bl && this.variant == 1 ? 1 : (bl2 && this.variant != 2 ? 2 : 0)));
        this.layoutModel.setValue(n);
        int n2 = n == 0 ? this.rightOffsetNone : (n == 1 ? this.rightOffsetImage : this.rightOffsetMap);
        if (iGridList != null) {
            iGridList.setContentRightOffset(n2);
        }
        this.logChannel.log(1000000, "Decorator#setLayout: setting layout=%1, offset=%2 for layout mask=%3", (Object)layoutDescription[n], (Object)new Integer(n2), (Object)string);
    }

    public void updateLayoutConstants(int n, int n2, int n3) {
        this.logChannel.log(100000, "Decorator#updateLayoutConstants: currently disabled, until actionProxy from Guide works in a way that it delivers different values for TT, High and Scale");
    }

    public boolean hideMapDecorator() {
        int n = this.layoutModel.getValue();
        if (n == 2) {
            this.originalLayout = n;
            this.layoutModel.setValue(0);
            if (this.showCoordinatesAsText) {
                this.debugLabelModel.setText("hidden");
            }
            return true;
        }
        return false;
    }

    public boolean revealMapDecorator() {
        int n = this.layoutModel.getValue();
        if (n == 0 && this.originalLayout == 2) {
            this.layoutModel.setValue(this.originalLayout);
            if (this.showCoordinatesAsText) {
                this.debugLabelModel.setText("revealed");
            }
            return true;
        }
        return false;
    }
}

