.version 50 0 
.class public super [181] 
.super [183] 
.implements [185] 
.field public static final [186] [187] 
.field public static final [188] [189] 
.field public static final [190] [191] 
.field private [192] [193] 
.field private [194] [195] 
.field private [196] [197] 
.field private [198] [199] 
.field private [200] [201] 
.field private [202] [203] 
.field private [204] [205] 

.method public [207] : [208] 
    .attribute [206] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [30] 
L4:     aload_0 
L5:     iconst_1 
L6:     putfield [31] 
L9:     aload_0 
L10:    iconst_0 
L11:    putfield [32] 
L14:    aload_0 
L15:    aload_1 
L16:    putfield [33] 
L19:    aload_0 
L20:    iload_2 
L21:    putfield [34] 
L24:    aload_0 
L25:    aload_3 
L26:    putfield [35] 
L29:    aload_0 
L30:    getfield [23] 
L33:    iconst_0 
L34:    invokeinterface [36] 0 
L39:    aload_0 
L40:    iload 4 
L42:    putfield [32] 
L45:    aload_0 
L46:    aload 5 
L48:    putfield [37] 
L51:    return 
L52:    
    .end code 
.end method 

.method public [209] : [210] 
    .attribute [206] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [38] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [211] : [212] 
    .attribute [206] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     aload_0 
L9:     getfield [20] 
L12:    invokestatic [4] 
L15:    aload_0 
L16:    getfield [23] 
L19:    invokeinterface [39] 0 
L24:    invokestatic [5] 
L27:    invokevirtual [26] 
L30:    aload_0 
L31:    getfield [20] 
L34:    ifeq L90 
L37:    aload_0 
L38:    getfield [23] 
L41:    invokeinterface [39] 0 
L46:    iconst_2 
L47:    if_icmpeq L90 
L50:    aload_0 
L51:    getfield [24] 
L54:    ldc [2] 
L56:    ldc [6] 
L58:    aload_0 
L59:    getfield [22] 
L62:    i2l 
L63:    invokevirtual [27] 
L66:    pop 
L67:    aload_0 
L68:    getfield [23] 
L71:    iconst_1 
L72:    invokeinterface [36] 0 
L77:    aload_0 
L78:    getfield [21] 
L81:    aload_0 
L82:    getfield [22] 
L85:    invokeinterface [40] 0 
L90:    return 
L91:    nop 
L92:    
    .end code 
.end method 

.method public [213] : [214] 
    .attribute [206] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     ldc [2] 
L6:     ldc [7] 
L8:     invokevirtual [28] 
L11:    pop 
L12:    aload_0 
L13:    getfield [23] 
L16:    iconst_2 
L17:    invokeinterface [36] 0 
L22:    aload_0 
L23:    getfield [25] 
L26:    ifnull L42 
L29:    aload_0 
L30:    getfield [25] 
L33:    iconst_0 
L34:    invokeinterface [41] 0 
L39:    goto L54 
L42:    aload_0 
L43:    getfield [24] 
L46:    ldc [8] 
L48:    ldc [9] 
L50:    invokevirtual [28] 
L53:    pop 
L54:    return 
L55:    nop 
L56:    
    .end code 
.end method 

.method public enum [215] : [216] 
    .attribute [206] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [217] : [218] 
    .attribute [206] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public enum [219] : [220] 
    .attribute [206] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [221] : [222] 
    .attribute [206] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     ldc [2] 
L6:     ldc [10] 
L8:     aload_0 
L9:     getfield [23] 
L12:    invokeinterface [39] 0 
L17:    invokestatic [5] 
L20:    aload_0 
L21:    getfield [19] 
L24:    invokestatic [4] 
L27:    iload_1 
L28:    invokestatic [4] 
L31:    invokevirtual [29] 
L34:    aload_0 
L35:    getfield [23] 
L38:    invokeinterface [39] 0 
L43:    iconst_2 
L44:    if_icmpne L80 
L47:    aload_0 
L48:    getfield [19] 
L51:    ifeq L80 
L54:    iload_1 
L55:    ifne L80 
L58:    aload_0 
L59:    getfield [24] 
L62:    ldc [2] 
L64:    ldc [11] 
L66:    invokevirtual [28] 
L69:    pop 
L70:    aload_0 
L71:    getfield [23] 
L74:    iconst_0 
L75:    invokeinterface [36] 0 
L80:    aload_0 
L81:    iload_1 
L82:    putfield [31] 
L85:    return 
L86:    nop 
L87:    nop 
L88:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1078071040 
.const [3] = String [42] 
.const [4] = Method [43] [44] 
.const [5] = Method [45] [46] 
.const [6] = String [47] 
.const [7] = String [48] 
.const [8] = Int -1601830656 
.const [9] = String [49] 
.const [10] = String [50] 
.const [11] = String [51] 
.const [12] = Class [52] 
.const [13] = Class [53] 
.const [14] = Class [54] 
.const [15] = Class [55] 
.const [16] = Class [56] 
.const [17] = Class [57] 
.const [18] = Class [58] 
.const [19] = Field [59] [60] 
.const [20] = Field [61] [62] 
.const [21] = Field [63] [64] 
.const [22] = Field [65] [66] 
.const [23] = Field [67] [68] 
.const [24] = Field [69] [70] 
.const [25] = Field [71] [72] 
.const [26] = Method [73] [74] 
.const [27] = Method [75] [76] 
.const [28] = Method [77] [78] 
.const [29] = Method [79] [80] 
.const [30] = Method [81] [82] 
.const [31] = Field [83] [84] 
.const [32] = Field [85] [86] 
.const [33] = Field [87] [88] 
.const [34] = Field [89] [90] 
.const [35] = Field [91] [92] 
.const [36] = InterfaceMethod [93] [94] 
.const [37] = Field [95] [96] 
.const [38] = Field [97] [98] 
.const [39] = InterfaceMethod [99] [100] 
.const [40] = InterfaceMethod [101] [102] 
.const [41] = InterfaceMethod [103] [104] 
.const [42] = Utf8 'GPSPopupController#showPopup GPS in use; popupIfGpsInUse: %1; popup state: %2' 
.const [43] = Class [105] 
.const [44] = NameAndType [106] [107] 
.const [45] = Class [108] 
.const [46] = NameAndType [109] [110] 
.const [47] = Utf8 'GPSPopupController#showPopup showing popup %1' 
.const [48] = Utf8 "GPSPopupController#gpsPopupAcknowledged GPS popup acknowledged by the user, won't display the popup anymore for the rest of the bus cycle" 
.const [49] = Utf8 'GPSPopupController#gpsPopupAcknowledged no DSI available; sending no feedback to the south-side' 
.const [50] = Utf8 'GPSPopupController#updateClampState popup state: %1; clampSOld: %2; clampS: %3' 
.const [51] = Utf8 'GPSPopupController#updateClampState new clamp S cycle detected; the GPS popup can be shown again' 
.const [52] = Utf8 de/audi/app/online/privacysettings/GPSPopupController 
.const [53] = Utf8 java/lang/Object 
.const [54] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [55] = Utf8 java/lang/String 
.const [56] = Utf8 de/audi/atip/log/LogChannel 
.const [57] = Utf8 de/audi/atip/hmi/view/IPopupManager 
.const [58] = Utf8 org/dsi/ifc/online/DSIOnlineServiceRegistration 
.const [59] = Class [111] 
.const [60] = NameAndType [112] [113] 
.const [61] = Class [114] 
.const [62] = NameAndType [115] [116] 
.const [63] = Class [117] 
.const [64] = NameAndType [118] [119] 
.const [65] = Class [120] 
.const [66] = NameAndType [121] [122] 
.const [67] = Class [123] 
.const [68] = NameAndType [124] [125] 
.const [69] = Class [126] 
.const [70] = NameAndType [127] [128] 
.const [71] = Class [129] 
.const [72] = NameAndType [130] [131] 
.const [73] = Class [132] 
.const [74] = NameAndType [133] [134] 
.const [75] = Class [135] 
.const [76] = NameAndType [136] [137] 
.const [77] = Class [138] 
.const [78] = NameAndType [139] [140] 
.const [79] = Class [141] 
.const [80] = NameAndType [142] [143] 
.const [81] = Class [144] 
.const [82] = NameAndType [145] [146] 
.const [83] = Class [147] 
.const [84] = NameAndType [148] [149] 
.const [85] = Class [150] 
.const [86] = NameAndType [151] [152] 
.const [87] = Class [153] 
.const [88] = NameAndType [154] [155] 
.const [89] = Class [156] 
.const [90] = NameAndType [157] [158] 
.const [91] = Class [159] 
.const [92] = NameAndType [160] [161] 
.const [93] = Class [162] 
.const [94] = NameAndType [163] [164] 
.const [95] = Class [165] 
.const [96] = NameAndType [166] [167] 
.const [97] = Class [168] 
.const [98] = NameAndType [169] [170] 
.const [99] = Class [171] 
.const [100] = NameAndType [172] [173] 
.const [101] = Class [174] 
.const [102] = NameAndType [175] [176] 
.const [103] = Class [177] 
.const [104] = NameAndType [178] [179] 
.const [105] = Utf8 java/lang/String 
.const [106] = Utf8 valueOf 
.const [107] = Utf8 (Z)Ljava/lang/String; 
.const [108] = Utf8 java/lang/String 
.const [109] = Utf8 valueOf 
.const [110] = Utf8 (I)Ljava/lang/String; 
.const [111] = Utf8 de/audi/app/online/privacysettings/GPSPopupController 
.const [112] = Utf8 clampSOld 
.const [113] = Utf8 Z 
.const [114] = Utf8 de/audi/app/online/privacysettings/GPSPopupController 
.const [115] = Utf8 popupIfGpsInUse 
.const [116] = Utf8 Z 
.const [117] = Utf8 de/audi/app/online/privacysettings/GPSPopupController 
.const [118] = Utf8 popupManager 
.const [119] = Utf8 Lde/audi/atip/hmi/view/IPopupManager; 
.const [120] = Utf8 de/audi/app/online/privacysettings/GPSPopupController 
.const [121] = Utf8 popupId 
.const [122] = Utf8 I 
.const [123] = Utf8 de/audi/app/online/privacysettings/GPSPopupController 
.const [124] = Utf8 popupShouldAppearModel 
.const [125] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [126] = Utf8 de/audi/app/online/privacysettings/GPSPopupController 
.const [127] = Utf8 logChannel 
.const [128] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [129] = Utf8 de/audi/app/online/privacysettings/GPSPopupController 
.const [130] = Utf8 dsi 
.const [131] = Utf8 Lorg/dsi/ifc/online/DSIOnlineServiceRegistration; 
.const [132] = Utf8 de/audi/atip/log/LogChannel 
.const [133] = Utf8 log 
.const [134] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [135] = Utf8 de/audi/atip/log/LogChannel 
.const [136] = Utf8 log 
.const [137] = Utf8 (ILjava/lang/String;J)Z 
.const [138] = Utf8 de/audi/atip/log/LogChannel 
.const [139] = Utf8 log 
.const [140] = Utf8 (ILjava/lang/String;)Z 
.const [141] = Utf8 de/audi/atip/log/LogChannel 
.const [142] = Utf8 log 
.const [143] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [144] = Utf8 java/lang/Object 
.const [145] = Utf8 <init> 
.const [146] = Utf8 ()V 
.const [147] = Utf8 de/audi/app/online/privacysettings/GPSPopupController 
.const [148] = Utf8 clampSOld 
.const [149] = Utf8 Z 
.const [150] = Utf8 de/audi/app/online/privacysettings/GPSPopupController 
.const [151] = Utf8 popupIfGpsInUse 
.const [152] = Utf8 Z 
.const [153] = Utf8 de/audi/app/online/privacysettings/GPSPopupController 
.const [154] = Utf8 popupManager 
.const [155] = Utf8 Lde/audi/atip/hmi/view/IPopupManager; 
.const [156] = Utf8 de/audi/app/online/privacysettings/GPSPopupController 
.const [157] = Utf8 popupId 
.const [158] = Utf8 I 
.const [159] = Utf8 de/audi/app/online/privacysettings/GPSPopupController 
.const [160] = Utf8 popupShouldAppearModel 
.const [161] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [162] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [163] = Utf8 setValue 
.const [164] = Utf8 (I)V 
.const [165] = Utf8 de/audi/app/online/privacysettings/GPSPopupController 
.const [166] = Utf8 logChannel 
.const [167] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [168] = Utf8 de/audi/app/online/privacysettings/GPSPopupController 
.const [169] = Utf8 dsi 
.const [170] = Utf8 Lorg/dsi/ifc/online/DSIOnlineServiceRegistration; 
.const [171] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [172] = Utf8 getValue 
.const [173] = Utf8 ()I 
.const [174] = Utf8 de/audi/atip/hmi/view/IPopupManager 
.const [175] = Utf8 showPopup 
.const [176] = Utf8 (I)V 
.const [177] = Utf8 org/dsi/ifc/online/DSIOnlineServiceRegistration 
.const [178] = Utf8 setGPSUseMode 
.const [179] = Utf8 (I)V 
.const [180] = Utf8 de/audi/app/online/privacysettings/GPSPopupController 
.const [181] = Class [180] 
.const [182] = Utf8 java/lang/Object 
.const [183] = Class [182] 
.const [184] = Utf8 de/audi/atip/power/PowerEventListener 
.const [185] = Class [184] 
.const [186] = Utf8 GPS_POPUP_NOT_TRIGGERED 
.const [187] = Utf8 I 
.const [188] = Utf8 GPS_POPUP_SHOULD_APPEAR 
.const [189] = Utf8 I 
.const [190] = Utf8 GPS_POPUP_ACKNOWLEDGED 
.const [191] = Utf8 I 
.const [192] = Utf8 popupManager 
.const [193] = Utf8 Lde/audi/atip/hmi/view/IPopupManager; 
.const [194] = Utf8 popupId 
.const [195] = Utf8 I 
.const [196] = Utf8 popupShouldAppearModel 
.const [197] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [198] = Utf8 logChannel 
.const [199] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [200] = Utf8 dsi 
.const [201] = Utf8 Lorg/dsi/ifc/online/DSIOnlineServiceRegistration; 
.const [202] = Utf8 clampSOld 
.const [203] = Utf8 Z 
.const [204] = Utf8 popupIfGpsInUse 
.const [205] = Utf8 Z 
.const [206] = Utf8 Code 
.const [207] = Utf8 <init> 
.const [208] = Utf8 (Lde/audi/atip/hmi/view/IPopupManager;ILde/audi/atip/hmi/modelaccess/ChoiceModelApp;ZLde/audi/atip/log/LogChannel;)V 
.const [209] = Utf8 setDsi 
.const [210] = Utf8 (Lorg/dsi/ifc/online/DSIOnlineServiceRegistration;)V 
.const [211] = Utf8 showPopup 
.const [212] = Utf8 ()V 
.const [213] = Utf8 gpsPopupAcknowledged 
.const [214] = Utf8 (I)V 
.const [215] = Utf8 notifyPowerListenerOnEnterState 
.const [216] = Utf8 (II)V 
.const [217] = Utf8 notifyPowerListenerOnExitState 
.const [218] = Utf8 (II)V 
.const [219] = Utf8 notifyPowerTriggerAction 
.const [220] = Utf8 (II)V 
.const [221] = Utf8 updateClampState 
.const [222] = Utf8 (ZZZZ)V 
.end class 
