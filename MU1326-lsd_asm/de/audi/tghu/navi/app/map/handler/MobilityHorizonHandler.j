.version 50 0 
.class public super [208] 
.super [210] 
.implements [212] 
.field private static final [213] [214] 
.field private final [215] [216] 
.field private final [217] [218] 
.field private final [219] [220] 
.field private [221] [222] 

.method public [224] : [225] 
    .attribute [223] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [39] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [43] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [44] 
L14:    aload_0 
L15:    aload_3 
L16:    putfield [45] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [226] : [227] 
    .attribute [223] .code stack 5 locals 1 
L0:     aload_0 
L1:     getfield [30] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     aload_1 
L9:     invokevirtual [31] 
L12:    pop 
L13:    aload_1 
L14:    ifnull L67 
L17:    aload_1 
L18:    iconst_4 
L19:    newarray int 
L21:    dup 
L22:    iconst_0 
L23:    iconst_2 
L24:    iastore 
L25:    dup 
L26:    iconst_1 
L27:    iconst_3 
L28:    iastore 
L29:    dup 
L30:    iconst_2 
L31:    iconst_1 
L32:    iastore 
L33:    dup 
L34:    iconst_3 
L35:    iconst_4 
L36:    iastore 
L37:    aload_0 
L38:    invokeinterface [46] 0 
L43:    aload_0 
L44:    invokespecial [40] 
L47:    istore_2 
L48:    aload_1 
L49:    iload_2 
L50:    invokeinterface [47] 0 
L55:    aload_1 
L56:    getstatic [4] 
L59:    invokeinterface [48] 0 
L64:    goto L84 
L67:    aload_0 
L68:    invokespecial [42] 
L71:    aload_0 
L72:    getfield [29] 
L75:    invokevirtual [32] 
L78:    iconst_0 
L79:    invokeinterface [49] 0 
L84:    aload_0 
L85:    aload_1 
L86:    putfield [50] 
L89:    return 
L90:    nop 
L91:    nop 
L92:    
    .end code 
.end method 

.method private [228] : [229] 
    .attribute [223] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [28] 
L4:     invokevirtual [34] 
L7:     invokestatic [5] 
L10:    ifeq L15 
L13:    iconst_0 
L14:    areturn 
L15:    aload_0 
L16:    getfield [28] 
L19:    invokevirtual [34] 
L22:    invokestatic [6] 
L25:    ifeq L30 
L28:    iconst_1 
L29:    areturn 
L30:    aload_0 
L31:    getfield [30] 
L34:    sipush 10000 
L37:    ldc [7] 
L39:    lconst_1 
L40:    invokevirtual [35] 
L43:    pop 
L44:    iconst_1 
L45:    areturn 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method private final [230] : [231] 
    .attribute [223] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [30] 
L4:     ldc [8] 
L6:     ldc [9] 
L8:     invokevirtual [36] 
L11:    pop 
L12:    aload_0 
L13:    getfield [33] 
L16:    ifnull L47 
        .catch [10] from L19 to L29 using L32 
L19:    aload_0 
L20:    getfield [33] 
L23:    aload_0 
L24:    invokeinterface [51] 0 
L29:    goto L47 
L32:    astore_1 
L33:    aload_0 
L34:    getfield [30] 
L37:    sipush 10000 
L40:    ldc [11] 
L42:    aload_1 
L43:    invokevirtual [37] 
L46:    pop 
L47:    return 
L48:    
    .end code 
.end method 

.method public [232] : [233] 
    .attribute [223] .code stack 8 locals 0 
L0:     aload_0 
L1:     getfield [30] 
L4:     ldc [2] 
L6:     ldc [12] 
L8:     aload_2 
L9:     iload_1 
L10:    i2l 
L11:    iload_3 
L12:    i2l 
L13:    invokevirtual [38] 
L16:    pop 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [234] : [235] 
    .attribute [223] .code stack 3 locals 0 
L0:     iload_2 
L1:     iconst_1 
L2:     if_icmpne L17 
L5:     aload_0 
L6:     getfield [30] 
L9:     ldc [13] 
L11:    ldc [14] 
L13:    invokevirtual [36] 
L16:    pop 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [236] : [237] 
    .attribute [223] .code stack 3 locals 0 
L0:     iload_2 
L1:     iconst_1 
L2:     if_icmpne L17 
L5:     aload_0 
L6:     getfield [30] 
L9:     ldc [13] 
L11:    ldc [15] 
L13:    invokevirtual [36] 
L16:    pop 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [238] : [239] 
    .attribute [223] .code stack 5 locals 0 
L0:     iload_2 
L1:     iconst_1 
L2:     if_icmpne L19 
L5:     aload_0 
L6:     getfield [30] 
L9:     ldc [2] 
L11:    ldc [16] 
L13:    iload_1 
L14:    i2l 
L15:    invokevirtual [35] 
L18:    pop 
L19:    return 
L20:    
    .end code 
.end method 

.method public [240] : [241] 
    .attribute [223] .code stack 5 locals 0 
L0:     iload_2 
L1:     iconst_1 
L2:     if_icmpne L32 
L5:     aload_0 
L6:     getfield [30] 
L9:     ldc [2] 
L11:    ldc [17] 
L13:    iload_1 
L14:    i2l 
L15:    invokevirtual [35] 
L18:    pop 
L19:    aload_0 
L20:    getfield [29] 
L23:    invokevirtual [32] 
L26:    iload_1 
L27:    invokeinterface [49] 0 
L32:    return 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [242] : [243] 
    .attribute [223] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [30] 
L4:     ldc [13] 
L6:     ldc [18] 
L8:     invokevirtual [36] 
L11:    pop 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [244] : [245] 
    .attribute [223] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [30] 
L4:     ldc [13] 
L6:     ldc [19] 
L8:     invokevirtual [36] 
L11:    pop 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method static [246] : [247] 
    .attribute [223] .code stack 4 locals 0 
L0:     iconst_1 
L1:     newarray int 
L3:     dup 
L4:     iconst_0 
L5:     iconst_1 
L6:     iastore 
L7:     putstatic [41] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1078071040 
.const [3] = String [52] 
.const [4] = Field [53] [54] 
.const [5] = Method [55] [56] 
.const [6] = Method [57] [58] 
.const [7] = String [59] 
.const [8] = Int -2137614336 
.const [9] = String [60] 
.const [10] = Class [61] 
.const [11] = String [62] 
.const [12] = String [63] 
.const [13] = Int 14808325 
.const [14] = String [64] 
.const [15] = String [65] 
.const [16] = String [66] 
.const [17] = String [67] 
.const [18] = String [68] 
.const [19] = String [69] 
.const [20] = Class [70] 
.const [21] = Class [71] 
.const [22] = Class [72] 
.const [23] = Class [73] 
.const [24] = Class [74] 
.const [25] = Class [75] 
.const [26] = Class [76] 
.const [27] = Class [77] 
.const [28] = Field [78] [79] 
.const [29] = Field [80] [81] 
.const [30] = Field [82] [83] 
.const [31] = Method [84] [85] 
.const [32] = Method [86] [87] 
.const [33] = Field [88] [89] 
.const [34] = Method [90] [91] 
.const [35] = Method [92] [93] 
.const [36] = Method [94] [95] 
.const [37] = Method [96] [97] 
.const [38] = Method [98] [99] 
.const [39] = Method [100] [101] 
.const [40] = Method [102] [103] 
.const [41] = Field [104] [105] 
.const [42] = Method [106] [107] 
.const [43] = Field [108] [109] 
.const [44] = Field [110] [111] 
.const [45] = Field [112] [113] 
.const [46] = InterfaceMethod [114] [115] 
.const [47] = InterfaceMethod [116] [117] 
.const [48] = InterfaceMethod [118] [119] 
.const [49] = InterfaceMethod [120] [121] 
.const [50] = Field [122] [123] 
.const [51] = InterfaceMethod [124] [125] 
.const [52] = Utf8 'MobilityHorizonHandler#setDSIMobilityHorizon() - mobilityHorizon: %1 ' 
.const [53] = Class [126] 
.const [54] = NameAndType [127] [128] 
.const [55] = Class [129] 
.const [56] = NameAndType [130] [131] 
.const [57] = Class [132] 
.const [58] = NameAndType [133] [134] 
.const [59] = Utf8 'MobilityHorizonHandler#retrieveDriveTrainMode() - could not determine drive train mode - using default: DRIVETRAINMODE_SECONDARY=%1 ' 
.const [60] = Utf8 'MobilityHorizonHandler#deinit()' 
.const [61] = Utf8 java/lang/Exception 
.const [62] = Utf8 'MobilityHorizonHandler#deinitDSI() - ERROR=%1' 
.const [63] = Utf8 'MobilityHorizonHandler#asyncException() - errorCode: %2, requestType: %3, errorMsg: %1' 
.const [64] = Utf8 'MobilityHorizonHandler#updateLocations() - not implemented ' 
.const [65] = Utf8 'MobilityHorizonHandler#updateConsideredLocationTypes() - not implemented ' 
.const [66] = Utf8 'MobilityHorizonHandler#updateDriveTrainMode() - driveTrainMode: %1 ' 
.const [67] = Utf8 'MobilityHorizonHandler#updateMobilityHorizonStatus() - status: %1 ' 
.const [68] = Utf8 'MobilityHorizonHandler#requestLocationRangeLevelResult() - unexpected call! ' 
.const [69] = Utf8 'MobilityHorizonHandler#locationRangeLevelChanged() - unexpected call! ' 
.const [70] = Utf8 de/audi/tghu/navi/app/map/handler/MobilityHorizonHandler 
.const [71] = Utf8 java/lang/Object 
.const [72] = Utf8 de/audi/atip/log/LogChannel 
.const [73] = Utf8 org/dsi/ifc/mobilityhorizon/DSIMobilityHorizon 
.const [74] = Utf8 de/audi/tghu/navi/app/map/instances/MapMain 
.const [75] = Utf8 de/audi/tghu/navi/app/map/IContext 
.const [76] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [77] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [78] = Class [135] 
.const [79] = NameAndType [136] [137] 
.const [80] = Class [138] 
.const [81] = NameAndType [139] [140] 
.const [82] = Class [141] 
.const [83] = NameAndType [142] [143] 
.const [84] = Class [144] 
.const [85] = NameAndType [145] [146] 
.const [86] = Class [147] 
.const [87] = NameAndType [148] [149] 
.const [88] = Class [150] 
.const [89] = NameAndType [151] [152] 
.const [90] = Class [153] 
.const [91] = NameAndType [154] [155] 
.const [92] = Class [156] 
.const [93] = NameAndType [157] [158] 
.const [94] = Class [159] 
.const [95] = NameAndType [160] [161] 
.const [96] = Class [162] 
.const [97] = NameAndType [163] [164] 
.const [98] = Class [165] 
.const [99] = NameAndType [166] [167] 
.const [100] = Class [168] 
.const [101] = NameAndType [169] [170] 
.const [102] = Class [171] 
.const [103] = NameAndType [172] [173] 
.const [104] = Class [174] 
.const [105] = NameAndType [175] [176] 
.const [106] = Class [177] 
.const [107] = NameAndType [178] [179] 
.const [108] = Class [180] 
.const [109] = NameAndType [181] [182] 
.const [110] = Class [183] 
.const [111] = NameAndType [184] [185] 
.const [112] = Class [186] 
.const [113] = NameAndType [187] [188] 
.const [114] = Class [189] 
.const [115] = NameAndType [190] [191] 
.const [116] = Class [192] 
.const [117] = NameAndType [193] [194] 
.const [118] = Class [195] 
.const [119] = NameAndType [196] [197] 
.const [120] = Class [198] 
.const [121] = NameAndType [199] [200] 
.const [122] = Class [201] 
.const [123] = NameAndType [202] [203] 
.const [124] = Class [204] 
.const [125] = NameAndType [205] [206] 
.const [126] = Utf8 de/audi/tghu/navi/app/map/handler/MobilityHorizonHandler 
.const [127] = Utf8 CONSIDERED_LOCATION_TYPES 
.const [128] = Utf8 [I 
.const [129] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [130] = Utf8 isRangeMapModeBEV 
.const [131] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;)Z 
.const [132] = Utf8 de/audi/tghu/navi/app/util/Util 
.const [133] = Utf8 isRangeMapModePHEV 
.const [134] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;)Z 
.const [135] = Utf8 de/audi/tghu/navi/app/map/handler/MobilityHorizonHandler 
.const [136] = Utf8 env 
.const [137] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [138] = Utf8 de/audi/tghu/navi/app/map/handler/MobilityHorizonHandler 
.const [139] = Utf8 mainMap 
.const [140] = Utf8 Lde/audi/tghu/navi/app/map/instances/MapMain; 
.const [141] = Utf8 de/audi/tghu/navi/app/map/handler/MobilityHorizonHandler 
.const [142] = Utf8 logChannel 
.const [143] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [144] = Utf8 de/audi/atip/log/LogChannel 
.const [145] = Utf8 log 
.const [146] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [147] = Utf8 de/audi/tghu/navi/app/map/instances/MapMain 
.const [148] = Utf8 getActiveContext 
.const [149] = Utf8 ()Lde/audi/tghu/navi/app/map/IContext; 
.const [150] = Utf8 de/audi/tghu/navi/app/map/handler/MobilityHorizonHandler 
.const [151] = Utf8 dsiMobilityHorizon 
.const [152] = Utf8 Lorg/dsi/ifc/mobilityhorizon/DSIMobilityHorizon; 
.const [153] = Utf8 de/audi/tghu/navi/app/NavigationEnv 
.const [154] = Utf8 getFramework 
.const [155] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [156] = Utf8 de/audi/atip/log/LogChannel 
.const [157] = Utf8 log 
.const [158] = Utf8 (ILjava/lang/String;J)Z 
.const [159] = Utf8 de/audi/atip/log/LogChannel 
.const [160] = Utf8 log 
.const [161] = Utf8 (ILjava/lang/String;)Z 
.const [162] = Utf8 de/audi/atip/log/LogChannel 
.const [163] = Utf8 log 
.const [164] = Utf8 (ILjava/lang/String;Ljava/lang/Throwable;)Z 
.const [165] = Utf8 de/audi/atip/log/LogChannel 
.const [166] = Utf8 log 
.const [167] = Utf8 (ILjava/lang/String;Ljava/lang/Object;JJ)Z 
.const [168] = Utf8 java/lang/Object 
.const [169] = Utf8 <init> 
.const [170] = Utf8 ()V 
.const [171] = Utf8 de/audi/tghu/navi/app/map/handler/MobilityHorizonHandler 
.const [172] = Utf8 retrieveDriveTrainMode 
.const [173] = Utf8 ()I 
.const [174] = Utf8 de/audi/tghu/navi/app/map/handler/MobilityHorizonHandler 
.const [175] = Utf8 CONSIDERED_LOCATION_TYPES 
.const [176] = Utf8 [I 
.const [177] = Utf8 de/audi/tghu/navi/app/map/handler/MobilityHorizonHandler 
.const [178] = Utf8 deinitDSI 
.const [179] = Utf8 ()V 
.const [180] = Utf8 de/audi/tghu/navi/app/map/handler/MobilityHorizonHandler 
.const [181] = Utf8 env 
.const [182] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [183] = Utf8 de/audi/tghu/navi/app/map/handler/MobilityHorizonHandler 
.const [184] = Utf8 mainMap 
.const [185] = Utf8 Lde/audi/tghu/navi/app/map/instances/MapMain; 
.const [186] = Utf8 de/audi/tghu/navi/app/map/handler/MobilityHorizonHandler 
.const [187] = Utf8 logChannel 
.const [188] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [189] = Utf8 org/dsi/ifc/mobilityhorizon/DSIMobilityHorizon 
.const [190] = Utf8 setNotification 
.const [191] = Utf8 ([ILorg/dsi/ifc/base/DSIListener;)V 
.const [192] = Utf8 org/dsi/ifc/mobilityhorizon/DSIMobilityHorizon 
.const [193] = Utf8 setDriveTrainMode 
.const [194] = Utf8 (I)V 
.const [195] = Utf8 org/dsi/ifc/mobilityhorizon/DSIMobilityHorizon 
.const [196] = Utf8 setConsideredLocationTypes 
.const [197] = Utf8 ([I)V 
.const [198] = Utf8 de/audi/tghu/navi/app/map/IContext 
.const [199] = Utf8 updateMobilityHorizonStatus 
.const [200] = Utf8 (I)V 
.const [201] = Utf8 de/audi/tghu/navi/app/map/handler/MobilityHorizonHandler 
.const [202] = Utf8 dsiMobilityHorizon 
.const [203] = Utf8 Lorg/dsi/ifc/mobilityhorizon/DSIMobilityHorizon; 
.const [204] = Utf8 org/dsi/ifc/mobilityhorizon/DSIMobilityHorizon 
.const [205] = Utf8 clearNotification 
.const [206] = Utf8 (Lorg/dsi/ifc/base/DSIListener;)V 
.const [207] = Utf8 de/audi/tghu/navi/app/map/handler/MobilityHorizonHandler 
.const [208] = Class [207] 
.const [209] = Utf8 java/lang/Object 
.const [210] = Class [209] 
.const [211] = Utf8 de/audi/tghu/navi/app/map/handler/IMobilityHorizonHandler 
.const [212] = Class [211] 
.const [213] = Utf8 CONSIDERED_LOCATION_TYPES 
.const [214] = Utf8 [I 
.const [215] = Utf8 env 
.const [216] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [217] = Utf8 logChannel 
.const [218] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [219] = Utf8 mainMap 
.const [220] = Utf8 Lde/audi/tghu/navi/app/map/instances/MapMain; 
.const [221] = Utf8 dsiMobilityHorizon 
.const [222] = Utf8 Lorg/dsi/ifc/mobilityhorizon/DSIMobilityHorizon; 
.const [223] = Utf8 Code 
.const [224] = Utf8 <init> 
.const [225] = Utf8 (Lde/audi/tghu/navi/app/NavigationEnv;Lde/audi/tghu/navi/app/map/instances/MapMain;Lde/audi/atip/log/LogChannel;)V 
.const [226] = Utf8 setDSIMobilityHorizon 
.const [227] = Utf8 (Lorg/dsi/ifc/mobilityhorizon/DSIMobilityHorizon;)V 
.const [228] = Utf8 retrieveDriveTrainMode 
.const [229] = Utf8 ()I 
.const [230] = Utf8 deinitDSI 
.const [231] = Utf8 ()V 
.const [232] = Utf8 asyncException 
.const [233] = Utf8 (ILjava/lang/String;I)V 
.const [234] = Utf8 updateLocations 
.const [235] = Utf8 ([Lorg/dsi/ifc/mobilityhorizon/MobilityHorizonLocation;I)V 
.const [236] = Utf8 updateConsideredLocationTypes 
.const [237] = Utf8 ([II)V 
.const [238] = Utf8 updateDriveTrainMode 
.const [239] = Utf8 (II)V 
.const [240] = Utf8 updateMobilityHorizonStatus 
.const [241] = Utf8 (II)V 
.const [242] = Utf8 requestLocationRangeLevelResult 
.const [243] = Utf8 (II)V 
.const [244] = Utf8 locationRangeLevelChanged 
.const [245] = Utf8 (I)V 
.const [246] = Utf8 <clinit> 
.const [247] = Utf8 ()V 
.end class 
