/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

public interface Layout {
    public static final int MAP_FONT_SIZE_POINTS_TO_PIXELS;
    public static final int MAP_FONT_SIZE_PIXELS_TO_POINTS;
    public static final int LINE_DESCRIPTION_SUBMENU;
    public static final int LINE_DESCRIPTION_CHECK_BOX;
    public static final int LINE_DESCRIPTION_COMBO_BOX;
    public static final int LINE_DESCRIPTION_ROTARY_ACTION;
    public static final int LINE_DESCRIPTION_SUBMENU_CHECK_BOX;
    public static final int LINE_DESCRIPTION_SUBMENU_PREVIEW;
    public static final int LINE_DESCRIPTION_MAX;
    public static final int DISTANCE_DISPLAY_WIDTH;
    public static final int DISTANCE_DISPLAY_HEIGHT;
    public static final int DISTANCE_MENU_CLIPPING_WIDTH;
    public static final int DISTANCE_SUBTITLE_LINE_X;
    public static final int DISTANCE_SUBTITLE_LINE_Y;
    public static final int DISTANCE_SUBTITLE_OFFSET_X;
    public static final int DISTANCE_SUBTITLE_OFFSET_X_ICON_RIGHT_ALIGNED;
    public static final int DISTANCE_TOOLTIP_DISTANCE_TO_BORDER_H;
    public static final int DISTANCE_TOOLTIP_DISTANCE_TO_BORDER_V;
    public static final int DISTANCE_FONT_SIZE_ROADICON;
    public static final int DISTANCE_TOOLTIP_BOTTOM_LINE_Y;
    public static final int DISTANCE_SDS_SYMBOL_WIDTH;
    public static final int DISTANCE_SDS_SYMBOL_Y_OFFSET;
    public static final int DISTANCE_TOOLTIP_OFFSET_TOP_LINE_Y;
    public static final int DISTANCE_MOVE_CURSOR_X_OFFSET;
    public static final int DISTANCE_UNSUPPORTED_DEVELOPMENT_BUILD_IMAGE_ID;
    public static final int DISTANCE_MAX_MENU_LINES;
    public static final int DISTANCE_TEXTFIELD_LEFT_BOUNDS;
    public static final int DISTANCE_POPIN_DELTA_TURNOVER;
    public static final int DISTANCE_SUBTITLE_BASELINE_Y;
    public static final int DISTANCE_OSD_LINE_OFFSET_Y;
    public static final int DISTANCE_DISPLAY_OFFSET_X;
    public static final int DISTANCE_DISPLAY_OFFSET_Y;
    public static final int DISTANCE_MIXED_LIST_ITEM_HEIGHT;
    public static final int DISTANCE_MIXED_LIST_ITEM_GAP;
    public static final int DISTANCE_MIXED_LIST_LOCATION_HEIGHT;
    public static final int DISTANCE_MIXED_LIST_ITEM_LOCATION_GAP;
    public static final int DISTANCE_MIXED_LIST_HORIZONTAL_OFFSET;
    public static final int DISTANCE_MIXED_LIST_ROW_HEIGHT_TOP;
    public static final int DISTANCE_MIXED_LIST_ROW_HEIGHT_CENTER;
    public static final int DISTANCE_MIXED_LIST_ROW_HEIGHT_BOTTOM;
    public static final int DISTANCE_MIXED_LIST_BORDER_WIDTH;
    public static final int DISTANCE_MIXED_LIST_SHIFT_TURN_ARROW_DOWN;
    public static final int DISTANCE_TMC_DETAIL_ROW_OVERALL;
    public static final int DISTANCE_CELL_Y_OFFSET;
    public static final int DISTANCE_MENU_CLIPPING_X;
    public static final int DISTANCE_TOOLTIP_MAX_TOP_Y;
    public static final int DISTANCE_MENU_SCROLLBAR_WIDTH;
    public static final int DISTANCE_BALANCE_FADER_MIDDLE_POS_X;
    public static final int DISTANCE_BALANCE_FADER_MIDDLE_POS_Y;
    public static final int DISTANCE_BALANCE_FADER_MOVEABLE_WIDTH;
    public static final int DISTANCE_BALANCE_FADER_MOVEABLE_HEIGHT;
    public static final int DISTANCE_FONT_XDPI;
    public static final int DISTANCE_FONT_YDPI;
    public static final int DISTANCE_ROUTE_SELECT_NUMBER_X;
    public static final int DISTANCE_ROUTE_SELECT_NUMBER_Y;
    public static final int DISTANCE_SEPARATOR_LINE_X_OFFSET;
    public static final int DISTANCE_SEPARATOR_LINE_Y_OFFSET;
    public static final int DISTANCE_MENU_SCROLLER_TICKS_TO_TRIGGER_FASTSCROLL;
    public static final int DISTANCE_BORDERWIDGETD4_BORDER_X_OFFSET;
    public static final int DISTANCE_BORDERWIDGETD4_BORDER_Y_OFFSET_UPPER;
    public static final int DISTANCE_BORDERWIDGETD4_OVERLAY_STATUSBAR;
    public static final int DISTANCE_BORDERWIDGETD4_MIN_SK_WIDTH;
    public static final int DISTANCE_BORDERWIDGETD4_NEW_WINDOW_NO_BORDER_SPELLER_X_OFFSET_LEFT;
    public static final int DISTANCE_BORDERWIDGETD4_NEW_WINDOW_NO_BORDER_SPELLER_X_OFFSET_RIGHT;
    public static final int DISTANCE_BORDERWIDGETD4_NEW_WINDOW_NO_BORDER_SPELLER_Y_OFFSET_LOWER;
    public static final int DISTANCE_BORDERWIDGETD4_NEW_WINDOW_NO_BORDER_SPELLER_Y_OFFSET_UPPER;
    public static final int DISTANCE_BORDERWIDGETD4_NEW_WINDOW_SHADOW_LOWER_HEIGHT;
    public static final int DISTANCE_BORDERWIDGETD4_NEW_WINDOW_SHADOW_RIGHT_WIDTH;
    public static final int DISTANCE_BORDERWIDGETD4_NEW_WINDOW_X_OFFSET_LEFT;
    public static final int DISTANCE_BORDERWIDGETD4_NEW_WINDOW_X_OFFSET_RIGHT;
    public static final int DISTANCE_BORDERWIDGETD4_NEW_WINDOW_Y_OFFSET_LOWER;
    public static final int DISTANCE_BORDERWIDGETD4_NEW_WINDOW_Y_OFFSET_UPPER;
    public static final int DISTANCE_BORDERWIDGETD4_SOFTKEY_LABEL_MARGIN;
    public static final int DISTANCE_BORDERWIDGETD4_VERTICAL_LINE_NONSKSIDE_MIN_DISTANCE;
    public static final int DISTANCE_BORDERWIDGETD4_SKLINE_SHADOW_OFFSET;
    public static final int DISTANCE_BORDERWIDGETD4_BORDER_Y_OFFSET_TURNOVER;
    public static final int DISTANCE_CURSORBARWIDGETD4_MASK_WIDTH;
    public static final int DISTANCE_CHECKBOXCELLWIDGETD4_BOX_SIZE;
    public static final int DISTANCE_WIZARDWIDGET_TOOLTIP_SIZE_GLOW;
    public static final int DISTANCE_WIZARDWIDGET_TOOLTIP_HEIGHT_SINGLE;
    public static final int DISTANCE_WIZARDWIDGET_TOOLTIP_HEIGHT_DOUBLE;
    public static final int DISTANCE_WIZARDWIDGET_TOOLTIP_GAP;
    public static final int DISTANCE_WIZARDWIDGET_TOOLTIP_MARGIN_HOR;
    public static final int DISTANCE_WIZARDWIDGET_TOOLTIP_SPACING_HOR;
    public static final int DISTANCE_WIZARDWIDGET_TOOLTIP_LABEL_OFFSET_Y;
    public static final int DISTANCE_WIZARDWIDGET_TOOLTIP_ARROW_HEIGHT;
    public static final int DISTANCE_WIZARDWIDGET_C2_HEIGHT_SINGLE;
    public static final int DISTANCE_WIZARDWIDGET_C2_HEIGHT_DOUBLE;
    public static final int DISTANCE_WIZARDWIDGET_PREVIEW_LABEL_GAP;
    public static final int DISTANCE_BALANCE_FADER_CROSSHAIR_MIDDLE_POS_X;
    public static final int DISTANCE_BALANCE_FADER_CROSSHAIR_MIDDLE_POS_Y;
    public static final int DISTANCE_CURSORBARWIDGETD4_MOVECURSOR_FILL_OFFSET_X;
    public static final int DISTANCE_CURSORBARWIDGETD4_MOVECURSOR_ARROW_DOWN_Y_OFFSET;
    public static final int DISTANCE_CURSORBARWIDGETD4_MOVECURSOR_ARROW_UP_POS_Y;
    public static final int DISTANCE_CURSORBARWIDGETD4_MOVECURSOR_ARROW_X_OFFSET;
    public static final int DISTANCE_MENU_X_OFFSET;
    public static final int DISTANCE_CURSOR_BACKGROUND_PIXEL_OFFSET;
    public static final int DISTANCE_CURSOR_POS_Y_OFFSET;
    public static final int DISTANCE_CURSOR_X_POS_DENOMINATOR;
    public static final int DISTANCE_MIXEDLISTBACKGROUNDRENDERER_TOP_BITMAP_HEIGHT;
    public static final int DISTANCE_MIXEDLISTBACKGROUNDRENDERER_SCALE_FACTOR_MIDDLE;
    public static final int DISTANCE_SCROLLBAR_RADIUS;
    public static final int DISTANCE_BACKGROUND_TEXTURE_LEFT_ARC_WIDTH;
    public static final int DISTANCE_TIMERWIDGETD4_INDENT_SIZE;
    public static final int DISTANCE_TIMERWIDGETD4_GPS_CELL_RIGHT_OFFSET;
    public static final int DISTANCE_SHADOW_LABEL_OFFSET_LEFT;
    public static final int DISTANCE_SHADOW_LABEL_OFFSET_RIGHT;
    public static final int DISTANCE_SHADOW_LABEL_OFFSET_TOP;
    public static final int DISTANCE_CURSOR_ARROW_OFFSET_X;
    public static final int DISTANCE_CURSOR_ARROW_UP_OFFSET_Y;
    public static final int DISTANCE_CURSOR_ARROW_DOWN_OFFSET_Y;
    public static final int DISTANCE_TEXTFIELD_OFFSET_RIGHT;
    public static final int DISTANCE_ROTARY_CELL_BASE_RADIUS;
    public static final int DISTANCE_ROTARY_CELL_VISIBLE_ARROW_WIDTH;
    public static final int DISTANCE_ROTARY_CELL_CENTER_IMAGE_WIDTH;
    public static final int DISTANCE_CURSOR_C2_OFFSET_RIGHT;
    public static final int DISTANCE_MENU_CLIPPING_BOTTOM;
    public static final int DISTANCE_PRESET_SYMBOL_X_OFFSET;
    public static final int DISTANCE_PRESET_SYMBOL_Y_OFFSET;
    public static final int DISTANCE_PRESET_NUMBER_Y_POSITION;
    public static final int DISTANCE_TIMEZONEWIDGETD4_COUNTRY_BORDERS_IMAGE_POS_X;
    public static final int DISTANCE_TIMEZONEWIDGETD4_COUNTRY_BORDERS_IMAGE_POS_Y;
    public static final int DISTANCE_ROUTE_SELECT_GAS_PUMP_X;
    public static final int DISTANCE_ROUTE_SELECT_GAS_PUMP_Y;
    public static final int DISTANCE_ROUTE_SELECT_CONSUMPTION_TEXT_Y;
    public static final int DISTANCE_SIDEBAR_DROP_SHADOW_OFFSET_X;
    public static final int DISTANCE_FASTSCROLL_BAR_WIDTH;
    public static final int DISTANCE_FASTSCROLL_BAR_HEIGHT;
    public static final int DISTANCE_FASTSCROLL_BAR_CONTENT_HEIGHT;
    public static final int DISTANCE_FASTSCROLL_SLIDER_TEXTURE_X;
    public static final int DISTANCE_FASTSCROLL_SLIDER_TEXTURE_WIDTH;
    public static final int DISTANCE_FASTSCROLL_MIN_HEIGHT;
    public static final int DISTANCE_FASTSCROLL_MAX_HEIGHT;
    public static final int DISTANCE_FASTSCROLL_BAR_X;
    public static final int DISTANCE_FASTSCROLL_BAR_Y;
    public static final int DISTANCE_FASTSCROLL_TEXT_X;
    public static final int DISTANCE_FASTSCROLL_TEXT_Y;
    public static final int DISTANCE_DROP_SHADOW_OFFSET;
    public static final int DISTANCE_DROP_SHADOW_HEIGHT;
    public static final int DISTANCE_DROP_SHADOW_CORNER_X_OFFSET;
    public static final int DISTANCE_DROP_SHADOW_CORNER_Y_OFFSET;
    public static final int DISTANCE_DROP_SHADOW_RIGHT_TOP_X_OFFSET;
    public static final int DISTANCE_DROP_SHADOW_RIGHT_Y_OFFSET;
    public static final int DISTANCE_DROP_SHADOW_RIGHT_HEIGHT_OFFSET;
    public static final int DISTANCE_NAVI_INFOTEXT_LINE_SPACING;
    public static final int DISTANCE_NAVI_INFOTEXT_CROSSHAIR_LINE_OFFSET_X;
    public static final int DISTANCE_NAVI_INFOTEXT_CROSSHAIR_LINE_OFFSET_Y;
    public static final int DISTANCE_NAVI_INFOTEXT_LEFT_BORDER_OFFSET;
    public static final int DISTANCE_NAVI_INFOTEXT_MAX_WIDTH;
    public static final int DISTANCE_NAVI_INFOTEXT_FRAME_MIN_WIDTH;
    public static final int DISTANCE_NAVI_INFOTEXT_FRAME_MAX_WIDTH;
    public static final int DISTANCE_NAVI_INFOTEXT_FRAME_TEXTURE_WIDTH;
    public static final int DISTANCE_NAVI_INFOTEXT_FRAME_TEXTURE_HEIGHT;
    public static final int DISTANCE_NAVI_INFOTEXT_FIRST_LINE_OFFSET;
    public static final int DISTANCE_NAVI_INFOTEXT_HEIGHT_OFFSET;
    public static final int DISTANCE_INFOBOXWIDGETD4_SPLIT_SCREEN_SPACING;
    public static final int DISTANCE_WIZARDWIDGET_TOOLTIP_LINE_SPACING;
    public static final int DISTANCE_SUBMENU_PREVIEW_FRAME_TO_TEXT_OFFSET;
    public static final int DISTANCE_SUBMENU_PREVIEW_CELL_TABULATOR_OFFSET;
    public static final int DISTANCE_PICTURE_CONFIG_COVERART_WIDTH;
    public static final int DISTANCE_PICTURE_CONFIG_COVERART_HEIGHT;
    public static final int DISTANCE_PICTURE_CONFIG_PICTUREVIEWER_WIDTH;
    public static final int DISTANCE_PICTURE_CONFIG_PICTUREVIEWER_HEIGHT;
    public static final int DISTANCE_PICTURE_CONFIG_THUMBNAILICONS_WIDTH;
    public static final int DISTANCE_PICTURE_CONFIG_THUMBNAILICONS_HEIGHT;
    public static final int DISTANCE_PICTURE_CONFIG_ADDRESSBOOK_WIDTH;
    public static final int DISTANCE_PICTURE_CONFIG_ADDRESSBOOK_HEIGHT;
    public static final int DISTANCE_PICTURE_CONFIG_TUNERPRESETSTATIONS_WIDTH;
    public static final int DISTANCE_PICTURE_CONFIG_TUNERPRESETSTATIONS_HEIGHT;
    public static final int DISTANCE_PICTURE_CONFIG_TUNERSLIDESHOW_WIDTH;
    public static final int DISTANCE_PICTURE_CONFIG_TUNERSLIDESHOW_HEIGHT;
    public static final int DISTANCE_TIMER_OFFSET_HOURS_ONE_DIGIT;
    public static final int DISTANCE_TIMER_OFFSET_HOURS_TWO_DIGITS;
    public static final int DISTANCE_GEOPOSWIDGET_DISTANCE_TO_BORDER;
    public static final int DISTANCE_MIXED_LIST_BOX_WIDTH;
    public static final int DISTANCE_TOOLTIP_SHADOW_SIZE;
    public static final int DISTANCE_FASTSCROLL_LINE_X_OFFSET;
    public static final int DISTANCE_FASTSCROLL_LINE_Y_OFFSET;
    public static final int DISTANCE_NAVI_INFOTEXT_ONLINE_ICON_OFFSET;
    public static final int DISTANCE_MIXED_LIST_SHIFT_ALLOWED_VELOCITY_DOWN;
    public static final int DISTANCE_MIXED_LIST_SHIFT_BORDER_FLAG_DOWN;
    public static final int DISTANCE_MIXED_LIST_PICTURE_NAV_IMAGE_Y_TOP;
    public static final int DISTANCE_MIXED_LIST_PICTURE_NAV_IMAGE_Y_BOTTOM;
    public static final int DISTANCE_MIXED_LIST_PICTURE_NAV_IMAGE_HEIGHT;
    public static final int DISTANCE_MIXED_LIST_SHIFT_BORDER_FLAG_UP_SINGLE_BOX;
    public static final int DISTANCE_NAVI_INFOTEXT_TEXT_SMALL_ICON;
    public static final int DISTANCE_NAVI_INFOTEXT_TEXT_BIG_ICON;
    public static final int DISTANCE_NAVI_INFOTEXT_MIN_LINES_FOR_BIG_ICON;
    public static final int DISTANCE_NAVI_INFOTEXT_RIGHT_BORDER_OFFSET;
    public static final int DISTANCE_TOOLTIP_X_OFFSET;
    public static final int DISTANCE_TOOLTIP_WIDTH_OFFSET;
    public static final int DISTANCE_MIXED_LIST_TURN_ICON_WIDTH;
    public static final int DISTANCE_MIXED_LIST_BOX_INSETS;
    public static final int DISTANCE_WIZARD_TOOLTIP_CENTER_Y;
    public static final int DISTANCE_WIZARD_TOOLTIP_TOP_Y;
    public static final int DISTANCE_WIZARD_TOOLTIP_CENTER_X;
    public static final int DISTANCE_ROTARY_VALUE_ANGLE_LB;
    public static final int DISTANCE_ROTARY_VALUE_ANGLE_HB;
    public static final int DISTANCE_WAIT_ANIM_KZB_W;
    public static final int DISTANCE_WAIT_ANIM_KZB_H;
    public static final int DISTANCE_STATUSBAR_BOTTOM;
    public static final int DISTANCE_SIDEBAR_RIGHT;
    public static final int DISTANCE_SIDEBAR_AR_RIGHT;
    public static final int DISTANCE_ROUTEINFO_LEFT;
    public static final int DISTANCE_MAPTOOLTIP_TOP;
    public static final int DISTANCE_MAPTOOLTIP_LEFT;
    public static final int DISTANCE_INFOLINE_BOTTOM;
    public static final int DISTANCE_REITERLINE_TOP;
    public static final int DISTANCE_ROUTECRITERIABOX_LEFT;
    public static final int DISTANCE_TUBE_LEFT;
    public static final int DISTANCE_TUBE_RIGHT;
    public static final int DISTANCE_TUBE_LEFT_KB;
    public static final int DISTANCE_TUBE_RIGHT_KB;
    public static final int DISTANCE_SIDEBAR_BOTTOM;
    public static final int DISTANCE_ROUTECRITERIABOX_TOP;
    public static final int DISTANCE_LEFT_DRAWER_ICON_LEFT;
    public static final int DISTANCE_CURSOR_WAIT_ANIM_NO_ICON_X_OFFSET;
    public static final int DISTANCE_CURSOR_WAIT_ANIM_WITH_ICON_X_OFFSET;
    public static final int DISTANCE_CURSOR_WAIT_ANIM_MAX_Y_OFFSET;
    public static final int DISTANCE_GAP_SUBMENU_PREVIEW_LEFT_RIGHT;
    public static final int DISTANCE_SDS_CMD_LINE_BOTTOM;
    public static final int DISTANCE_MAPTOOLTIP_BOTTOM;
    public static final int DISTANCE_MATRIX_MARGIN_LEFT_GRID;
    public static final int DISTANCE_MATRIX_MARGIN_RIGHT_GRID;
    public static final int DISTANCE_MATRIX_MARGIN_BOTTOM_GRID;
    public static final int DISTANCE_RAINRADAR_TIMESTAMP_X;
    public static final int DISTANCE_RAINRADAR_TIMESTAMP_Y;
    public static final int DISTANCE_RAINRADAR_TIMESTAMP_WIDTH;
    public static final int DISTANCE_RAINRADAR_TIMESTAMP_HEIGHT;
    public static final int DISTANCE_MATRIX_VERTICAL_SEPARATOR_HEIGHT;
    public static final int DISTANCE_SPELLER_CONVERSION_LINE_CURSOR_BOX_HEIGHT;
    public static final int DISTANCE_SPELLER_CONVERSION_LINE_Y_TOP_OFFSET_ABOVE_SPELLER;
    public static final int DISTANCE_SPELLER_CONVERSION_LINE_TEMPLATE_NODE_Y_OFFSET;
    public static final int DISTANCE_SPELLER_CONVERSION_LINE_OFFSET_CELL;
    public static final int DISTANCE_GRID_WIDTH;
    public static final int DISTANCE_CONVERSION_MATRIX_PADDING_LEFT_RIGHT_GRID_CELL;
    public static final int DISTANCE_COUNT;
    public static final int DEPTH_STATISTICS;
    public static final int DEPTH_SCREEN_POPIN;
    public static final int DEPTH_TA_OVERLAY;
    public static final int DEPTH_OSD;
    public static final int DEPTH_CURSOR;
    public static final int DEPTH_SOFTKEY;
    public static final int DEPTH_SIDE_BAR_ITEMS;
    public static final int DEPTH_TITLE_LINE;
    public static final int DEPTH_STATUS_LINE;
    public static final int DEPTH_SIDE_BAR;
    public static final int DEPTH_MIXED_LIST;
    public static final int DEPTH_COMBOBOX_OPEN;
    public static final int DEPTH_TOOLTIP;
    public static final int DEPTH_MENU;
    public static final int DEPTH_SUBTITLE;
    public static final int DEPTH_ROTARY;
    public static final int DEPTH_SPELLER;
    public static final int DEPTH_FUNC_WHEEL;
    public static final int DEPTH_WIZARD;
    public static final int DEPTH_WIZARD_TOOLTIP;
    public static final int DEPTH_SCREEN_OVERLAY;
    public static final int DEPTH_SCREEN_STANDARD;
    public static final int DEPTH_SCREEN_BACKGROUND;
    public static final int DEPTH_SCREENSHOT_FOREGROUND;
    public static final int DEPTH_SCREENSHOT_BACKGROUND;
    public static final int DEPTH_DRAWER;
    public static final int DEPTH_WIZARD_INFOBOX;
    public static final int DEPTH_COUNT;
    public static final int FC_SCROLLBAR_STROKE_WIDTH;
    public static final int FC_ROTARYBUTTONWIDGETD4_SCALE_STROKE_WIDTH;
    public static final int FC_ROTARYWIDGETD4_MED_MARKER_ANGLE_OF_CORNERS_TO_LINE;
    public static final int FC_ROTARYWIDGETD4_MED_MARKER_OUTER_CORNERS_RADIUS_OFFSET;
    public static final int FC_ROTARYWIDGETD4_MED_MARKER_PIKE_RADIUS_OFFSET;
    public static final int FC_ROTARYWIDGETD4_SCALE_BOLD_MARKERS_RADIUS_ADDITION;
    public static final int FC_ROTARYWIDGETD4_SCALE_STROKE_WIDTH_BOLD;
    public static final int FC_ROTARYWIDGETD4_SCALE_STROKE_WIDTH_DEFAULT;
    public static final int FC_NAVI_INFOTEXT_ARC_WIDTH;
    public static final int FC_NAVI_INFOTEXT_ARC_HEIGHT;
    public static final int FC_CURSOR_SCROLLBAR_CENTER_FACTOR_6LINE;
    public static final int FC_CURSOR_SCROLLBAR_CENTER_FACTOR_5LINE;
    public static final int FC_CURSOR_SCROLLBAR_CENTER_FACTOR_4LINE;
    public static final int FC_CURSOR_SCROLLBAR_CENTER_FACTOR_3LINE;
    public static final int FC_STATUSBAR_SCALE_FACTOR;
    public static final int FC_SMALL_STAGE_APP_ICON_OPACITY;
    public static final int FC_SDS_MENU_SCALING;
    public static final int FC_MENU_TOUCH_SWIPE_DISTANCE_FACTOR;
    public static final int FC_COUNT;
    public static final int DIRECTION_DOWN;
    public static final int DIRECTION_UP;
    public static final int FONT_PLAIN;
    public static final int FONT_BOLD;
    public static final int FONT_LIGHT;
    public static final int FONT_BASE;
    public static final int TEXT_EXPORT_NO_DESIRED_VALUE;
    public static final int TEXT_EXPORT_MAX_MENU_ITEM_WIDTH;
    public static final int TEXT_EXPORT_CURSOR_BAR_WIDTH;
    public static final int TEXT_EXPORT_TEXT_GAP;
    public static final int TEXT_EXPORT_INNER_COMBOBOX_GAP;
    public static final int TEXT_EXPORT_FAKE_VALUE;
    public static final int TEXT_EXPORT_ARROW_WIDTH_COMBOBOX;
    public static final int TEXT_EXPORT_CHECKBOX_WIDTH;
    public static final int TEXT_EXPORT_ROTARY_ACTION_WIDTH;
    public static final int TEXT_EXPORT_ARROW_WIDTH_SUBMENU;
    public static final int TEXT_EXPORT_INNER_TEXTFIELD_GAP;
    public static final int TEXT_EXPORT_MAX_DATE_WIDTH;
    public static final int TEXT_EXPORT_SUBMENU_PREVIEW_ARROW_GAP;
    public static final int TEXT_EXPORT_SUBMENU_CHECKBOX_ARROW_GAP;
    public static final int TEXT_EXPORT_SUBMENU_CHECKBOX_PREVIEW_ARROW_WIDTH;
    public static final int TEXT_EXPORT_SUBMENU_CHECKBOX_TEXT_CHECKBOX_GAP;
    public static final int TEXT_EXPORT_SUBMENU_CHECKBOX_WIDTH;
    public static final int TEXT_EXPORT_TEXT_GAP_TEXTFIELD;
    public static final int TEXT_EXPORT_RETURN_ICON_WIDTH;
    public static final int TEXT_EXPORT_BUTTONMANAGER_BUTTON_WIDTH;
    public static final int TEXT_EXPORT_TEXTFIELD_MAX_WIDTH;
    public static final int TEXT_EXPORT_COUNT;
    public static final int IC_COMBOBOX_CURSOR_MIN_WIDTH;
    public static final int IC_COMBOBOX_MAX_WIDTH_NO_SCROLLBAR;
    public static final int IC_COMBOBOX_MAX_WIDTH_WITH_SCROLLBAR;
    public static final int IC_COMBOBOX_MIN_WIDTH_NO_SCROLLBAR;
    public static final int IC_COMBOBOX_LEFT_DISTANCE_GLASSPLATE_TO_CURSOR;
    public static final int IC_COMBOBOX_OPEN_LEFT_DISTANCE_CURSOR_TO_C2ICON;
    public static final int IC_COMBOBOX_OPEN_LEFT_DISTANCE_C2ICON_TO_LABEL;
    public static final int IC_COMBOBOX_OPEN_RIGHT_DISTANCE_LABEL_TO_CURSOR;
    public static final int IC_COMBOBOX_OPEN_RIGHT_DISTANCE_CURSOR_TO_GLASSPLATE;
    public static final int IC_COMBOBOX_CLOSED_LEFT_DISTANCE_GLASSPLATE_TO_CLOSED_ICON;
    public static final int IC_COMBOBOX_CLOSED_RIGHT_DISTANCE_LABEL_TO_GLASSPLATE;
    public static final int IC_COMBOBOX_TOP_DISTANCE_GLASSPLATE_TO_LABEL;
    public static final int IC_INFOLINE_HEIGHT_1_LINE;
    public static final int IC_INFOLINE_HEIGHT_2_LINE;
    public static final int IC_MULTILINE_MENUITEM_GAP_TOP;
    public static final int IC_MULTILINE_MENUITEM_GAP_BOTTOM;
    public static final int IC_MULTILINE_MENUITEM_GAP_LEFT;
    public static final int IC_MULTILINE_MENUITEM_GAP_RIGHT;
    public static final int IC_COMBOBOX_CONTENT_LEFT_OFFSET;
    public static final int IC_COMBOBOX_CONTENT_RIGHT_OFFSET;
    public static final int IC_COMBOBOX_SCROLLBAR_WIDTH;
    public static final int IC_COMBOBOX_SCROLLBAR_MENU_RIGHT_OFFSET;
    public static final int IC_COMBOBOX_SCROLLBAR_MENU_TOP_OFFSET;
    public static final int IC_COMBOBOX_SCROLLBAR_MENU_BOTTOM_OFFSET;
    public static final int IC_COMBOBOX_MIN_DISTANCE_LABEL_COMBOBOX;
    public static final int IC_COMBOBOX_CLOSED_MIN_HEIGHT;
    public static final int IC_COMBOBOX_CLOSED_MAX_HEIGHT;
    public static final int IC_COMBOBOX_INSETS_PREVIEW_VERT;
    public static final int IC_TITLE_SHIFT_Y_FOR_OPTION_SCREENS;
    public static final int IC_PRESET_HEIGHT_TOUCH;
    public static final int IC_PRESET_Y_LONG_TOUCH;
    public static final int IC_PRESET_HEIGHT_LONG_TOUCH;
    public static final int IC_COMBOBOX_ICON_LABEL_GAP;
    public static final int IC_COMBOBOX_ICON_OFFSET_X;
    public static final int IC_COMBOBOX_MENU_CURSOR_DISTANCE;
    public static final int IC_COMBOBOX_CLOSED_ICON_WIDTH;
    public static final int IC_COMBOBOX_MENU_OFFSETX;
    public static final int IC_COMBOBOX_CONTENT_TOP_OFFSET;
    public static final int IC_COMBOBOX_CONTENT_BOTTOM_OFFSET;
    public static final int IC_COMBOBOX_SCROLLBAR_TOP_OFFSET;
    public static final int IC_COMBOBOX_BOTTOM_OFFSET;
    public static final int IC_COMBOBOX_SCROOLBAR_WIDTH;
    public static final int IC_COMBOBOX_CONTENT_SROLLBAR_DISTANCE;
    public static final int IC_COMBOBOX_SCROLLBAR_BACKGROUND_DISTANCE;
    public static final int IC_STATUSBAR_ICON_GAP;
    public static final int IC_STATUSBAR_GAP_SCREEN_BORDER;
    public static final int IC_STATUSBAR_ICON_Y_OFFSET;
    public static final int IC_STATUSBAR_LEFT_GROUP_MIN_WIDTH;
    public static final int IC_STATUSBAR_RIGHT_GROUP_MIN_WIDTH;
    public static final int IC_STATUSBAR_CONTAINER_HEIGHT;
    public static final int IC_PP_SMALL_STAGE_MAX_WIDTH;
    public static final int IC_PP_BIG_STAGE_MIN_WIDTH;
    public static final int IC_CHECKBOX_WIDTH;
    public static final int IC_CHECKBOX_HEIGHT;
    public static final int IC_PRESET_AIT_X;
    public static final int IC_PRESET_AIT_Y;
    public static final int IC_PRESET_AIT_WIDTH;
    public static final int IC_PRESET_AIT_HEIGHT;
    public static final int IC_POS_X_KDK_IN_TUBE;
    public static final int IC_POS_Y_KDK_IN_TUBE;
    public static final int IC_POS_X_KDK_ABOVE_TUBE;
    public static final int IC_POS_Y_KDK_ABOVE_TUBE;
    public static final int IC_TTS_SKIN_HORIZONTAL_SHIFT_SELECTION_DRAWER;
    public static final int IC_INFOLINE_LINE_SPACING;
    public static final int IC_EAL_DEFAULT_MEMORY_SIZE;
    public static final int IC_OPEN_COMBOBOX_TO_PARENT_GLASSPLATE_DISTANCE;
    public static final int IC_SUBMENU_PREVIEW_MIN_WIDTH;
    public static final int IC_SUBMENU_PREVIEW_MAX_WIDTH;
    public static final int IC_SUBMENU_PREVIEW_GAP_BEFORE;
    public static final int IC_OPEN_COMBOBOX_OFFSET_Y;
    public static final int IC_COMBOBOX_LABEL_RIGHT_GAP;
    public static final int IC_STATUSBAR_ICON_GAP_DATA_RATE;
    public static final int IC_SUBMENU_WIDTH_MIN;
    public static final int IC_SUBMENU_WIDTH_MAX;
    public static final int IC_STATUSBAR_LABEL_Y_OFFSET;
    public static final int IC_COMBOBOX_MAX_HEIGHT;
    public static final int IC_STATUSBAR_ICON_GAP_CLOCK;
    public static final int IC_STATUSBAR_Y_OFFSET_SYSTEM_UPDATE;
    public static final int IC_OFFSET_SMALL_STAGE_SCREEN_X;
    public static final int IC_OFFSET_SMALL_STAGE_SCREEN_Y;
    public static final int IC_OFFSET_BIG_STAGE_SCREEN_X;
    public static final int IC_OFFSET_BIG_STAGE_SCREEN_Y;
    public static final int IC_OFFSET_SMALL_STAGE_POPUP_X;
    public static final int IC_OFFSET_SMALL_STAGE_POPUP_Y;
    public static final int IC_OFFSET_BIG_STAGE_POPUP_X;
    public static final int IC_OFFSET_BIG_STAGE_POPUP_Y;
    public static final int IC_OFFSET_SMALL_STAGE_SELECTION_DRAWER_X;
    public static final int IC_OFFSET_SMALL_STAGE_SELECTION_DRAWER_Y;
    public static final int IC_OFFSET_BIG_STAGE_SELECTION_DRAWER_X;
    public static final int IC_OFFSET_BIG_STAGE_SELECTION_DRAWER_Y;
    public static final int IC_STATUSBAR_TTS_X_OFFSET;
    public static final int IC_STATUSBAR_TTS_Y_OFFSET;
    public static final int IC_SPELLER_OFFSET_INFOLINE_TEXT_TOP;
    public static final int IC_SCREENSHOT_TYPE_OFFSET_Y;
    public static final int IC_STATUSBAR_ICON_ROAMING_Y_OFFSET;
    public static final int IC_OFFSET_SMALL_STAGE_SELECTION_DRAWER_CLOSED_X;
    public static final int IC_OFFSET_SMALL_STAGE_SELECTION_DRAWER_CLOSED_Y;
    public static final int IC_OFFSET_SMALL_STAGE_OPTION_DRAWER_CLOSED_X;
    public static final int IC_OFFSET_SMALL_STAGE_OPTION_DRAWER_CLOSED_Y;
    public static final int IC_OFFSET_BIG_STAGE_SELECTION_DRAWER_CLOSED_X;
    public static final int IC_OFFSET_BIG_STAGE_SELECTION_DRAWER_CLOSED_Y;
    public static final int IC_OFFSET_BIG_STAGE_OPTION_DRAWER_CLOSED_X;
    public static final int IC_OFFSET_BIG_STAGE_OPTION_DRAWER_CLOSED_Y;
    public static final int IC_MATRIX_COLUMNS_AMOUNT;
    public static final int IC_USER_HINT_SEPERATOR_POSITION_Y;
    public static final int IC_KDK_IMAGE_ID;
    public static final int IC_OFFSET_NAVI_BACKGROUND_MAP_X;
    public static final int IC_OFFSET_NAVI_BACKGROUND_MAP_Y;
    public static final int IC_STATUSBAR_Y_OFFSET_DATA_STATUS;
    public static final int IC_GRID_DEFAULT_TRANSLATION;
    public static final int IC_GRID_GYRO_TRANSLATION;
    public static final int IC_CONVERSIONLINE_COLUMNS_AMOUNT;
    public static final int IC_MAP_WIDTH;
    public static final int IC_MAP_HEIGHT;
    public static final int IC_INPUTFIELD_SUGGESTION_OFFSET;
    public static final int IC_SPELLER_SUGGESTION_OFFSET;
    public static final int IC_CROP_X_KDK_BIG_STAGE;
    public static final int IC_CROP_Y_KDK_BIG_STAGE;
    public static final int IC_CROP_WIDTH_KDK_BIG_STAGE;
    public static final int IC_CROP_HEIGHT_KDK_BIG_STAGE;
    public static final int IC_CROP_X_KDK_SMALL_STAGE;
    public static final int IC_CROP_Y_KDK_SMALL_STAGE;
    public static final int IC_CROP_WIDTH_KDK_SMALL_STAGE;
    public static final int IC_CROP_HEIGHT_KDK_SMALL_STAGE;
    public static final int IC_RADIOBUTTON_WIDTH;
    public static final int IC_RADIOBUTTON_HEIGHT;
    public static final int IC_ROTARY_PREVIEW_WIDTH;
    public static final int IC_ROTARY_PREVIEW_HEIGHT;
    public static final int IC_FORMFIELD_INPUT_DROP_SHADOW_WIDTH;
    public static final int IC_STATUSBAR_TTS_X_OFFSET_RTL;
    public static final int IC_COUNT;
    public static final int INDEX_ICON;
    public static final int INDEX_DECORATOR;

    default public int[] getStaticBitmapParameters(int n) {
    }

    default public int getRowHeight() {
    }

    default public int getRowOverall() {
    }

    default public int getRowHeightToolTip() {
    }

    default public int getRowOverallToolTip() {
    }

    default public int getMenuLineWidth() {
    }

    default public int getDistance(int n) {
    }

    default public int getDepth(int n) {
    }

    default public int getTextExportWidth(int n) {
    }

    default public float getFloatConstant(int n) {
    }

    default public int getIntegerConstant(int n) {
    }

    default public int[] getTextPattern(int n) {
    }

    default public int getMappedFontSize(int n, int n2) {
    }

    default public int getRotationalDirection(int n) {
    }

    default public String getSplashscreenPath() {
    }

    default public String getFontName(int n) {
    }

    default public int[][] getTimeZoneImagePositions() {
    }

    default public int[] getInstructionTextLayoutParams() {
    }

    default public int[][] getMainWizardIconDecoratorMapping() {
    }

    default public int[] getMainWizardTextOffset() {
    }

    default public int[] getDisplayablePosition(int n) {
    }

    default public int getUserHintLabelOffset() {
    }
}

