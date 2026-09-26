.version 50 0 
.class public super [271] 
.super [273] 
.field private [274] [275] 

.method public [277] : [278] 
    .attribute [276] .code stack 7 locals 0 
L0:     aload_0 
L1:     invokespecial [50] 
L4:     aload_0 
L5:     aload 8 
L7:     putfield [53] 
L10:    aload_0 
L11:    aload_1 
L12:    putfield [54] 
L15:    aload_0 
L16:    aload_3 
L17:    putfield [55] 
L20:    aload_0 
L21:    getfield [21] 
L24:    aload_0 
L25:    getfield [20] 
L28:    invokevirtual [22] 
L31:    aload_0 
L32:    aload 8 
L34:    aload_1 
L35:    aload 8 
L37:    getfield [23] 
L40:    invokevirtual [24] 
L43:    putfield [56] 
L46:    aload_0 
L47:    aload_1 
L48:    aload_2 
L49:    lload 4 
L51:    lload 6 
L53:    invokevirtual [26] 
L56:    return 
L57:    nop 
L58:    nop 
L59:    nop 
L60:    
    .end code 
.end method 

.method public [279] : [280] 
    .attribute [276] .code stack 3 locals 0 
L0:     aconst_null 
L1:     aload_0 
L2:     getfield [20] 
L5:     invokevirtual [27] 
L8:     if_acmpeq L22 
L11:    aload_0 
L12:    getfield [20] 
L15:    invokevirtual [27] 
L18:    arraylength 
L19:    ifne L24 
L22:    iconst_0 
L23:    areturn 
L24:    aload_0 
L25:    getfield [19] 
L28:    aload_0 
L29:    getfield [20] 
L32:    invokevirtual [27] 
L35:    iconst_0 
L36:    aaload 
L37:    invokevirtual [28] 
L40:    areturn 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [281] : [282] 
    .attribute [276] .code stack 3 locals 2 
L0:     aload_0 
L1:     lload_1 
L2:     invokespecial [51] 
L5:     pop 
L6:     aload_0 
L7:     getfield [19] 
L10:    aload_0 
L11:    invokevirtual [29] 
L14:    invokevirtual [30] 
L17:    astore_3 
L18:    aload_0 
L19:    getfield [25] 
L22:    bipush 8 
L24:    if_icmpne L32 
L27:    bipush 26 
L29:    goto L34 
L32:    bipush 19 
L34:    istore 4 
L36:    aload_3 
L37:    aload_0 
L38:    getfield [21] 
L41:    iload 4 
L43:    invokevirtual [31] 
L46:    invokevirtual [32] 
L49:    ifne L64 
L52:    aload_0 
L53:    getfield [21] 
L56:    iload 4 
L58:    aload_3 
L59:    invokevirtual [33] 
L62:    iconst_1 
L63:    areturn 
L64:    iconst_0 
L65:    areturn 
L66:    nop 
L67:    nop 
L68:    
    .end code 
.end method 

.method public [283] : [284] 
    .attribute [276] .code stack 2 locals 6 
L0:     aload_0 
L1:     getfield [21] 
L4:     ifnonnull L9 
L7:     iconst_0 
L8:     areturn 
L9:     aload_0 
L10:    getfield [21] 
L13:    bipush 30 
L15:    invokevirtual [34] 
L18:    checkcast [2] 
L21:    invokevirtual [35] 
L24:    astore_1 
L25:    aload_0 
L26:    getfield [21] 
L29:    bipush 30 
L31:    invokevirtual [34] 
L34:    checkcast [2] 
L37:    invokevirtual [35] 
L40:    astore_2 
L41:    aload_1 
L42:    ifnull L105 
L45:    aload_2 
L46:    ifnull L105 
L49:    aload_1 
L50:    invokevirtual [36] 
L53:    istore_3 
L54:    aload_1 
L55:    invokevirtual [37] 
L58:    astore 4 
L60:    aload_2 
L61:    invokevirtual [36] 
L64:    istore 5 
L66:    aload_2 
L67:    invokevirtual [37] 
L70:    astore 6 
L72:    iload_3 
L73:    iconst_m1 
L74:    if_icmpne L85 
L77:    aload 4 
L79:    getstatic [3] 
L82:    if_acmpeq L103 
L85:    iload 5 
L87:    iconst_m1 
L88:    if_icmpne L99 
L91:    aload 6 
L93:    getstatic [3] 
L96:    if_acmpeq L103 
L99:    iconst_1 
L100:   goto L104 
L103:   iconst_0 
L104:   areturn 
L105:   iconst_0 
L106:   areturn 
L107:   nop 
L108:   
    .end code 
.end method 

.method public interface [285] : [286] 
    .attribute [276] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [287] : [288] 
    .attribute [276] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     invokevirtual [38] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [289] : [290] 
    .attribute [276] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     getfield [39] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [291] : [292] 
    .attribute [276] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     invokevirtual [38] 
L7:     lookupswitch 
            5 : L24 
            default : L26 

L24:    iconst_1 
L25:    areturn 
L26:    aconst_null 
L27:    aload_0 
L28:    getfield [20] 
L31:    getfield [39] 
L34:    if_acmpeq L66 
L37:    aload_0 
L38:    getfield [20] 
L41:    getfield [39] 
L44:    arraylength 
L45:    ifle L66 
L48:    iconst_4 
L49:    aload_0 
L50:    getfield [20] 
L53:    getfield [39] 
L56:    iconst_0 
L57:    aaload 
L58:    getfield [40] 
L61:    if_icmpne L66 
L64:    iconst_1 
L65:    areturn 
L66:    iconst_0 
L67:    areturn 
L68:    
    .end code 
.end method 

.method public [293] : [294] 
    .attribute [276] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     getfield [41] 
L7:     areturn 
L8:     
    .end code 
.end method 

.method public [295] : [296] 
    .attribute [276] .code stack 3 locals 1 
L0:     new [57] 
L3:     dup 
L4:     ldc [5] 
L6:     invokespecial [52] 
L9:     aload_0 
L10:    getfield [21] 
L13:    invokevirtual [42] 
L16:    invokevirtual [43] 
L19:    ldc [6] 
L21:    invokevirtual [43] 
L24:    aload_0 
L25:    invokevirtual [44] 
L28:    invokevirtual [45] 
L31:    ldc [7] 
L33:    invokevirtual [43] 
L36:    aload_0 
L37:    invokevirtual [46] 
L40:    invokevirtual [47] 
L43:    ldc [8] 
L45:    invokevirtual [43] 
L48:    aload_0 
L49:    invokevirtual [29] 
L52:    invokevirtual [45] 
L55:    ldc [9] 
L57:    invokevirtual [43] 
L60:    aload_0 
L61:    getfield [48] 
L64:    invokevirtual [45] 
L67:    ldc [10] 
L69:    invokevirtual [43] 
L72:    astore_1 
L73:    aload_1 
L74:    invokevirtual [49] 
L77:    areturn 
L78:    nop 
L79:    nop 
L80:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [58] 
.const [3] = Field [59] [60] 
.const [4] = Class [61] 
.const [5] = String [62] 
.const [6] = String [63] 
.const [7] = String [64] 
.const [8] = String [65] 
.const [9] = String [66] 
.const [10] = String [67] 
.const [11] = Class [68] 
.const [12] = Class [69] 
.const [13] = Class [70] 
.const [14] = Class [71] 
.const [15] = Class [72] 
.const [16] = Class [73] 
.const [17] = Class [74] 
.const [18] = Class [75] 
.const [19] = Field [76] [77] 
.const [20] = Field [78] [79] 
.const [21] = Field [80] [81] 
.const [22] = Method [82] [83] 
.const [23] = Field [84] [85] 
.const [24] = Method [86] [87] 
.const [25] = Field [88] [89] 
.const [26] = Method [90] [91] 
.const [27] = Method [92] [93] 
.const [28] = Method [94] [95] 
.const [29] = Method [96] [97] 
.const [30] = Method [98] [99] 
.const [31] = Method [100] [101] 
.const [32] = Method [102] [103] 
.const [33] = Method [104] [105] 
.const [34] = Method [106] [107] 
.const [35] = Method [108] [109] 
.const [36] = Method [110] [111] 
.const [37] = Method [112] [113] 
.const [38] = Method [114] [115] 
.const [39] = Field [116] [117] 
.const [40] = Field [118] [119] 
.const [41] = Field [120] [121] 
.const [42] = Method [122] [123] 
.const [43] = Method [124] [125] 
.const [44] = Method [126] [127] 
.const [45] = Method [128] [129] 
.const [46] = Method [130] [131] 
.const [47] = Method [132] [133] 
.const [48] = Field [134] [135] 
.const [49] = Method [136] [137] 
.const [50] = Method [138] [139] 
.const [51] = Method [140] [141] 
.const [52] = Method [142] [143] 
.const [53] = Field [144] [145] 
.const [54] = Field [146] [147] 
.const [55] = Field [148] [149] 
.const [56] = Field [150] [151] 
.const [57] = Class [152] 
.const [58] = Utf8 de/audi/atip/hmi/model/IconCell 
.const [59] = Class [153] 
.const [60] = NameAndType [154] [155] 
.const [61] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [62] = Utf8 '[TURN] ' 
.const [63] = Utf8 ' (UID: ' 
.const [64] = Utf8 ', destIndex: ' 
.const [65] = Utf8 ', distCarToEvent: ' 
.const [66] = Utf8 'm, distEventToFinalDest: ' 
.const [67] = Utf8 m) 
.const [68] = Utf8 de/audi/tghu/navi/app/map/routeinfo/MixedListItemTurn 
.const [69] = Utf8 de/audi/tghu/navi/app/map/routeinfo/MixedListItem 
.const [70] = Utf8 de/audi/tghu/navi/app/map/utils/MixedListRow 
.const [71] = Utf8 de/audi/tghu/navi/app/map/routeinfo/RouteInfoHelper 
.const [72] = Utf8 org/dsi/ifc/navigation/TurnListElement 
.const [73] = Utf8 java/lang/String 
.const [74] = Utf8 de/audi/atip/hmi/model/HMIResourceLocator 
.const [75] = Utf8 org/dsi/ifc/navigation/AdditionalTurnListIcon 
.const [76] = Class [156] 
.const [77] = NameAndType [157] [158] 
.const [78] = Class [159] 
.const [79] = NameAndType [160] [161] 
.const [80] = Class [162] 
.const [81] = NameAndType [163] [164] 
.const [82] = Class [165] 
.const [83] = NameAndType [166] [167] 
.const [84] = Class [168] 
.const [85] = NameAndType [169] [170] 
.const [86] = Class [171] 
.const [87] = NameAndType [172] [173] 
.const [88] = Class [174] 
.const [89] = NameAndType [175] [176] 
.const [90] = Class [177] 
.const [91] = NameAndType [178] [179] 
.const [92] = Class [180] 
.const [93] = NameAndType [181] [182] 
.const [94] = Class [183] 
.const [95] = NameAndType [184] [185] 
.const [96] = Class [186] 
.const [97] = NameAndType [187] [188] 
.const [98] = Class [189] 
.const [99] = NameAndType [190] [191] 
.const [100] = Class [192] 
.const [101] = NameAndType [193] [194] 
.const [102] = Class [195] 
.const [103] = NameAndType [196] [197] 
.const [104] = Class [198] 
.const [105] = NameAndType [199] [200] 
.const [106] = Class [201] 
.const [107] = NameAndType [202] [203] 
.const [108] = Class [204] 
.const [109] = NameAndType [205] [206] 
.const [110] = Class [207] 
.const [111] = NameAndType [208] [209] 
.const [112] = Class [210] 
.const [113] = NameAndType [211] [212] 
.const [114] = Class [213] 
.const [115] = NameAndType [214] [215] 
.const [116] = Class [216] 
.const [117] = NameAndType [217] [218] 
.const [118] = Class [219] 
.const [119] = NameAndType [220] [221] 
.const [120] = Class [222] 
.const [121] = NameAndType [223] [224] 
.const [122] = Class [225] 
.const [123] = NameAndType [226] [227] 
.const [124] = Class [228] 
.const [125] = NameAndType [229] [230] 
.const [126] = Class [231] 
.const [127] = NameAndType [232] [233] 
.const [128] = Class [234] 
.const [129] = NameAndType [235] [236] 
.const [130] = Class [237] 
.const [131] = NameAndType [238] [239] 
.const [132] = Class [240] 
.const [133] = NameAndType [241] [242] 
.const [134] = Class [243] 
.const [135] = NameAndType [244] [245] 
.const [136] = Class [246] 
.const [137] = NameAndType [247] [248] 
.const [138] = Class [249] 
.const [139] = NameAndType [250] [251] 
.const [140] = Class [252] 
.const [141] = NameAndType [253] [254] 
.const [142] = Class [255] 
.const [143] = NameAndType [256] [257] 
.const [144] = Class [258] 
.const [145] = NameAndType [259] [260] 
.const [146] = Class [261] 
.const [147] = NameAndType [262] [263] 
.const [148] = Class [264] 
.const [149] = NameAndType [265] [266] 
.const [150] = Class [267] 
.const [151] = NameAndType [268] [269] 
.const [152] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [153] = Utf8 de/audi/atip/hmi/model/HMIResourceLocator 
.const [154] = Utf8 UNDEFINED_URI 
.const [155] = Utf8 Ljava/lang/String; 
.const [156] = Utf8 de/audi/tghu/navi/app/map/routeinfo/MixedListItemTurn 
.const [157] = Utf8 helper 
.const [158] = Utf8 Lde/audi/tghu/navi/app/map/routeinfo/RouteInfoHelper; 
.const [159] = Utf8 de/audi/tghu/navi/app/map/routeinfo/MixedListItemTurn 
.const [160] = Utf8 mTurnElement 
.const [161] = Utf8 Lorg/dsi/ifc/navigation/TurnListElement; 
.const [162] = Utf8 de/audi/tghu/navi/app/map/routeinfo/MixedListItemTurn 
.const [163] = Utf8 mMixedListRow 
.const [164] = Utf8 Lde/audi/tghu/navi/app/map/utils/MixedListRow; 
.const [165] = Utf8 de/audi/tghu/navi/app/map/utils/MixedListRow 
.const [166] = Utf8 updateValuesForTurns 
.const [167] = Utf8 (Lorg/dsi/ifc/navigation/TurnListElement;)V 
.const [168] = Utf8 de/audi/tghu/navi/app/map/routeinfo/RouteInfoHelper 
.const [169] = Utf8 env 
.const [170] = Utf8 Lde/audi/tghu/navi/app/NavigationEnv; 
.const [171] = Utf8 de/audi/tghu/navi/app/map/routeinfo/RouteInfoHelper 
.const [172] = Utf8 getDefaultFormat 
.const [173] = Utf8 (Lorg/dsi/ifc/navigation/TurnListElement;Lde/audi/tghu/navi/app/NavigationEnv;)I 
.const [174] = Utf8 de/audi/tghu/navi/app/map/routeinfo/MixedListItemTurn 
.const [175] = Utf8 mFormat 
.const [176] = Utf8 I 
.const [177] = Utf8 de/audi/tghu/navi/app/map/routeinfo/MixedListItemTurn 
.const [178] = Utf8 init 
.const [179] = Utf8 (Ljava/lang/Object;Lde/audi/tghu/navi/app/map/routeinfo/RouteInfoHandler$TravelData;JJ)V 
.const [180] = Utf8 org/dsi/ifc/navigation/TurnListElement 
.const [181] = Utf8 getManeuver 
.const [182] = Utf8 ()[Lorg/dsi/ifc/navigation/ManeuverElement; 
.const [183] = Utf8 de/audi/tghu/navi/app/map/routeinfo/RouteInfoHelper 
.const [184] = Utf8 isRealTurnElement 
.const [185] = Utf8 (Lorg/dsi/ifc/navigation/ManeuverElement;)Z 
.const [186] = Utf8 de/audi/tghu/navi/app/map/routeinfo/MixedListItemTurn 
.const [187] = Utf8 getDistanceToCar 
.const [188] = Utf8 ()J 
.const [189] = Utf8 de/audi/tghu/navi/app/map/routeinfo/RouteInfoHelper 
.const [190] = Utf8 formatDistString 
.const [191] = Utf8 (J)Ljava/lang/String; 
.const [192] = Utf8 de/audi/tghu/navi/app/map/utils/MixedListRow 
.const [193] = Utf8 getText 
.const [194] = Utf8 (I)Ljava/lang/String; 
.const [195] = Utf8 java/lang/String 
.const [196] = Utf8 equals 
.const [197] = Utf8 (Ljava/lang/Object;)Z 
.const [198] = Utf8 de/audi/tghu/navi/app/map/utils/MixedListRow 
.const [199] = Utf8 setText 
.const [200] = Utf8 (ILjava/lang/String;)V 
.const [201] = Utf8 de/audi/tghu/navi/app/map/utils/MixedListRow 
.const [202] = Utf8 getCell 
.const [203] = Utf8 (I)Lde/audi/atip/hmi/model/ListCell; 
.const [204] = Utf8 de/audi/atip/hmi/model/IconCell 
.const [205] = Utf8 getResourceLocator 
.const [206] = Utf8 ()Lde/audi/atip/hmi/model/HMIResourceLocator; 
.const [207] = Utf8 de/audi/atip/hmi/model/HMIResourceLocator 
.const [208] = Utf8 getResourceID 
.const [209] = Utf8 ()I 
.const [210] = Utf8 de/audi/atip/hmi/model/HMIResourceLocator 
.const [211] = Utf8 getResourceURI 
.const [212] = Utf8 ()Ljava/lang/String; 
.const [213] = Utf8 org/dsi/ifc/navigation/TurnListElement 
.const [214] = Utf8 getType 
.const [215] = Utf8 ()I 
.const [216] = Utf8 org/dsi/ifc/navigation/TurnListElement 
.const [217] = Utf8 additionalIcons 
.const [218] = Utf8 [Lorg/dsi/ifc/navigation/AdditionalTurnListIcon; 
.const [219] = Utf8 org/dsi/ifc/navigation/AdditionalTurnListIcon 
.const [220] = Utf8 type 
.const [221] = Utf8 I 
.const [222] = Utf8 org/dsi/ifc/navigation/TurnListElement 
.const [223] = Utf8 destinationIndex 
.const [224] = Utf8 I 
.const [225] = Utf8 de/audi/tghu/navi/app/map/utils/MixedListRow 
.const [226] = Utf8 getShortDescription 
.const [227] = Utf8 ()Ljava/lang/String; 
.const [228] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [229] = Utf8 append 
.const [230] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [231] = Utf8 de/audi/tghu/navi/app/map/routeinfo/MixedListItemTurn 
.const [232] = Utf8 getUID 
.const [233] = Utf8 ()J 
.const [234] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [235] = Utf8 append 
.const [236] = Utf8 (J)Lde/esolutions/fw/util/commons/Buffer; 
.const [237] = Utf8 de/audi/tghu/navi/app/map/routeinfo/MixedListItemTurn 
.const [238] = Utf8 getDestinationIndex 
.const [239] = Utf8 ()I 
.const [240] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [241] = Utf8 append 
.const [242] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [243] = Utf8 de/audi/tghu/navi/app/map/routeinfo/MixedListItemTurn 
.const [244] = Utf8 mDistToFinalDest 
.const [245] = Utf8 J 
.const [246] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [247] = Utf8 toString 
.const [248] = Utf8 ()Ljava/lang/String; 
.const [249] = Utf8 de/audi/tghu/navi/app/map/routeinfo/MixedListItem 
.const [250] = Utf8 <init> 
.const [251] = Utf8 ()V 
.const [252] = Utf8 de/audi/tghu/navi/app/map/routeinfo/MixedListItem 
.const [253] = Utf8 updateDistanceToCar 
.const [254] = Utf8 (J)Z 
.const [255] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [256] = Utf8 <init> 
.const [257] = Utf8 (Ljava/lang/String;)V 
.const [258] = Utf8 de/audi/tghu/navi/app/map/routeinfo/MixedListItemTurn 
.const [259] = Utf8 helper 
.const [260] = Utf8 Lde/audi/tghu/navi/app/map/routeinfo/RouteInfoHelper; 
.const [261] = Utf8 de/audi/tghu/navi/app/map/routeinfo/MixedListItemTurn 
.const [262] = Utf8 mTurnElement 
.const [263] = Utf8 Lorg/dsi/ifc/navigation/TurnListElement; 
.const [264] = Utf8 de/audi/tghu/navi/app/map/routeinfo/MixedListItemTurn 
.const [265] = Utf8 mMixedListRow 
.const [266] = Utf8 Lde/audi/tghu/navi/app/map/utils/MixedListRow; 
.const [267] = Utf8 de/audi/tghu/navi/app/map/routeinfo/MixedListItemTurn 
.const [268] = Utf8 mFormat 
.const [269] = Utf8 I 
.const [270] = Utf8 de/audi/tghu/navi/app/map/routeinfo/MixedListItemTurn 
.const [271] = Class [270] 
.const [272] = Utf8 de/audi/tghu/navi/app/map/routeinfo/MixedListItem 
.const [273] = Class [272] 
.const [274] = Utf8 mTurnElement 
.const [275] = Utf8 Lorg/dsi/ifc/navigation/TurnListElement; 
.const [276] = Utf8 Code 
.const [277] = Utf8 <init> 
.const [278] = Utf8 (Lorg/dsi/ifc/navigation/TurnListElement;Lde/audi/tghu/navi/app/map/routeinfo/RouteInfoHandler$TravelData;Lde/audi/tghu/navi/app/map/utils/MixedListRow;JJLde/audi/tghu/navi/app/map/routeinfo/RouteInfoHelper;)V 
.const [279] = Utf8 isRealTurnElement 
.const [280] = Utf8 ()Z 
.const [281] = Utf8 updateDistanceToCar 
.const [282] = Utf8 (J)Z 
.const [283] = Utf8 isBorderCrossingSpeedInfoAvailable 
.const [284] = Utf8 ()Z 
.const [285] = Utf8 getEvent 
.const [286] = Utf8 ()Ljava/lang/Object; 
.const [287] = Utf8 getType 
.const [288] = Utf8 ()I 
.const [289] = Utf8 getAdditionalIcons 
.const [290] = Utf8 ()[Lorg/dsi/ifc/navigation/AdditionalTurnListIcon; 
.const [291] = Utf8 isAsia 
.const [292] = Utf8 ()Z 
.const [293] = Utf8 getDestinationIndex 
.const [294] = Utf8 ()I 
.const [295] = Utf8 toString 
.const [296] = Utf8 ()Ljava/lang/String; 
.end class 
