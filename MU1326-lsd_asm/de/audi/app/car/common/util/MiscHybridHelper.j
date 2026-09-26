.version 50 0 
.class public super [11] 
.super [13] 
.field public static final [14] [15] 
.field public static final [16] [17] 
.field public static final [18] [19] 
.field public static final [20] [21] 
.field public static final [22] [23] 
.field public static final [24] [25] 
.field public static final [26] [27] 
.field public static final [28] [29] 
.field public static final [30] [31] 
.field public static final [32] [33] 

.method private annotation [35] : [36] 
    .attribute [34] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [3] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public static [37] : [38] 
    .attribute [34] .code stack 2 locals 0 
L0:     iload_0 
L1:     bipush 100 
L3:     if_icmpgt L15 
L6:     iload_0 
L7:     bipush 88 
L9:     if_icmplt L15 
L12:    bipush 8 
L14:    areturn 
L15:    iload_0 
L16:    bipush 88 
L18:    if_icmpge L30 
L21:    iload_0 
L22:    bipush 75 
L24:    if_icmplt L30 
L27:    bipush 7 
L29:    areturn 
L30:    iload_0 
L31:    bipush 75 
L33:    if_icmpge L45 
L36:    iload_0 
L37:    bipush 63 
L39:    if_icmplt L45 
L42:    bipush 6 
L44:    areturn 
L45:    iload_0 
L46:    bipush 63 
L48:    if_icmpge L59 
L51:    iload_0 
L52:    bipush 50 
L54:    if_icmplt L59 
L57:    iconst_5 
L58:    areturn 
L59:    iload_0 
L60:    bipush 50 
L62:    if_icmpge L73 
L65:    iload_0 
L66:    bipush 38 
L68:    if_icmplt L73 
L71:    iconst_4 
L72:    areturn 
L73:    iload_0 
L74:    bipush 38 
L76:    if_icmpge L87 
L79:    iload_0 
L80:    bipush 25 
L82:    if_icmplt L87 
L85:    iconst_3 
L86:    areturn 
L87:    iload_0 
L88:    bipush 25 
L90:    if_icmpge L101 
L93:    iload_0 
L94:    bipush 10 
L96:    if_icmplt L101 
L99:    iconst_2 
L100:   areturn 
L101:   iload_0 
L102:   bipush 10 
L104:   if_icmpge L114 
L107:   iload_0 
L108:   iconst_1 
L109:   if_icmplt L114 
L112:   iconst_1 
L113:   areturn 
L114:   iconst_0 
L115:   areturn 
L116:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [4] 
.const [3] = Method [5] [6] 
.const [4] = Utf8 java/lang/Object 
.const [5] = Class [7] 
.const [6] = NameAndType [8] [9] 
.const [7] = Utf8 java/lang/Object 
.const [8] = Utf8 <init> 
.const [9] = Utf8 ()V 
.const [10] = Utf8 de/audi/app/car/common/util/MiscHybridHelper 
.const [11] = Class [10] 
.const [12] = Utf8 java/lang/Object 
.const [13] = Class [12] 
.const [14] = Utf8 BATTERY_CHARGE_MIN_LEVEL_0_SEGMENTS 
.const [15] = Utf8 I 
.const [16] = Utf8 BATTERY_CHARGE_MIN_LEVEL_1_SEGMENTS 
.const [17] = Utf8 I 
.const [18] = Utf8 BATTERY_CHARGE_MIN_LEVEL_2_SEGMENTS 
.const [19] = Utf8 I 
.const [20] = Utf8 BATTERY_CHARGE_MIN_LEVEL_3_SEGMENTS 
.const [21] = Utf8 I 
.const [22] = Utf8 BATTERY_CHARGE_MIN_LEVEL_4_SEGMENTS 
.const [23] = Utf8 I 
.const [24] = Utf8 BATTERY_CHARGE_MIN_LEVEL_5_SEGMENTS 
.const [25] = Utf8 I 
.const [26] = Utf8 BATTERY_CHARGE_MIN_LEVEL_6_SEGMENTS 
.const [27] = Utf8 I 
.const [28] = Utf8 BATTERY_CHARGE_MIN_LEVEL_7_SEGMENTS 
.const [29] = Utf8 I 
.const [30] = Utf8 BATTERY_CHARGE_MIN_LEVEL_8_SEGMENTS 
.const [31] = Utf8 I 
.const [32] = Utf8 BATTERY_CHARGE_MAX_LEVEL_8_SEGMENTS 
.const [33] = Utf8 I 
.const [34] = Utf8 Code 
.const [35] = Utf8 <init> 
.const [36] = Utf8 ()V 
.const [37] = Utf8 getBatterySegmentForPercentage 
.const [38] = Utf8 (I)I 
.end class 
