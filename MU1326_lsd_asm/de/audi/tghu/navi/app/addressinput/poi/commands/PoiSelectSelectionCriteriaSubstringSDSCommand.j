.version 50 0 
.class public super [256] 
.super [258] 
.field private [259] [260] 
.field private final [261] [262] 
.field private final [263] [264] 

.method public [266] : [267] 
    .attribute [265] .code stack 8 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     iload_2 
L3:     aload_3 
L4:     invokespecial [38] 
L7:     aload_0 
L8:     iconst_0 
L9:     putfield [43] 
L12:    aload_0 
L13:    new [44] 
L16:    dup 
L17:    iconst_3 
L18:    iconst_0 
L19:    iconst_0 
L20:    invokespecial [39] 
L23:    putfield [45] 
L26:    aload_0 
L27:    new [46] 
L30:    dup 
L31:    ldc [4] 
L33:    ldc_w [1] 
L36:    iconst_1 
L37:    aload_0 
L38:    invokespecial [40] 
L41:    putfield [47] 
L44:    return 
L45:    nop 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [268] : [269] 
    .attribute [265] .code stack 8 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     ldc [5] 
L6:     ldc [6] 
L8:     aload_0 
L9:     getfield [20] 
L12:    aload_0 
L13:    getfield [21] 
L16:    i2l 
L17:    aload_0 
L18:    getfield [22] 
L21:    i2l 
L22:    invokevirtual [23] 
L25:    pop 
L26:    aload_0 
L27:    invokevirtual [24] 
L30:    aload_0 
L31:    getfield [21] 
L34:    i2l 
L35:    invokeinterface [48] 0 
L40:    aload_0 
L41:    getfield [18] 
L44:    invokevirtual [25] 
L47:    return 
L48:    
    .end code 
.end method 

.method public [270] : [271] 
    .attribute [265] .code stack 4 locals 3 
L0:     aload_0 
L1:     getfield [19] 
L4:     ldc [5] 
L6:     ldc [7] 
L8:     aload_0 
L9:     getfield [20] 
L12:    invokevirtual [26] 
L15:    pop 
L16:    aload_0 
L17:    getfield [27] 
L20:    invokevirtual [28] 
L23:    astore_2 
L24:    aload_2 
L25:    ifnonnull L36 
L28:    aload_0 
L29:    getfield [17] 
L32:    astore_2 
L33:    goto L41 
L36:    aload_2 
L37:    iconst_3 
L38:    putfield [49] 
L41:    aload_0 
L42:    dup 
L43:    astore_3 
L44:    monitorenter 
        .catch [0] from L45 to L61 using L64 
L45:    aload_0 
L46:    invokespecial [41] 
L49:    aload_0 
L50:    aload_2 
L51:    invokevirtual [29] 
L54:    aload_0 
L55:    iconst_1 
L56:    putfield [43] 
L59:    aload_3 
L60:    monitorexit 
L61:    goto L71 
        .catch [0] from L64 to L68 using L64 
L64:    astore 4 
L66:    aload_3 
L67:    monitorexit 
L68:    aload 4 
L70:    athrow 
L71:    return 
L72:    
    .end code 
.end method 

.method private [272] : [273] 
    .attribute [265] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_1 
L2:     putfield [50] 
L5:     aload_0 
L6:     iconst_1 
L7:     putfield [51] 
L10:    aload_0 
L11:    iconst_1 
L12:    putfield [52] 
L15:    aload_0 
L16:    iconst_1 
L17:    putfield [53] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public synchronized [274] : [275] 
    .attribute [265] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [19] 
L4:     ldc [8] 
L6:     ldc [9] 
L8:     aload_0 
L9:     getfield [20] 
L12:    aload_1 
L13:    aload_0 
L14:    getfield [22] 
L17:    i2l 
L18:    invokevirtual [33] 
L21:    aload_0 
L22:    getfield [27] 
L25:    aload_1 
L26:    invokevirtual [34] 
L29:    aload_0 
L30:    getfield [16] 
L33:    ifne L41 
L36:    aload_0 
L37:    aload_1 
L38:    invokespecial [42] 
L41:    return 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method protected [276] : [277] 
    .attribute [265] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [30] 
L4:     ifeq L45 
L7:     aload_0 
L8:     getfield [31] 
L11:    ifeq L45 
L14:    aload_0 
L15:    getfield [35] 
L18:    ifeq L45 
L21:    aload_0 
L22:    getfield [32] 
L25:    ifeq L45 
L28:    aload_0 
L29:    getfield [18] 
L32:    invokevirtual [36] 
L35:    pop 
L36:    aload_0 
L37:    invokevirtual [37] 
L40:    invokeinterface [54] 0 
L45:    return 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [56] 
.const [3] = Class [57] 
.const [4] = String [58] 
.const [5] = Int 1078071040 
.const [6] = String [59] 
.const [7] = String [60] 
.const [8] = Int -2137614336 
.const [9] = String [61] 
.const [10] = Class [62] 
.const [11] = Class [63] 
.const [12] = Class [64] 
.const [13] = Class [65] 
.const [14] = Class [66] 
.const [15] = Class [67] 
.const [16] = Field [68] [69] 
.const [17] = Field [70] [71] 
.const [18] = Field [72] [73] 
.const [19] = Field [74] [75] 
.const [20] = Field [76] [77] 
.const [21] = Field [78] [79] 
.const [22] = Field [80] [81] 
.const [23] = Method [82] [83] 
.const [24] = Method [84] [85] 
.const [25] = Method [86] [87] 
.const [26] = Method [88] [89] 
.const [27] = Field [90] [91] 
.const [28] = Method [92] [93] 
.const [29] = Method [94] [95] 
.const [30] = Field [96] [97] 
.const [31] = Field [98] [99] 
.const [32] = Field [100] [101] 
.const [33] = Method [102] [103] 
.const [34] = Method [104] [105] 
.const [35] = Field [106] [107] 
.const [36] = Method [108] [109] 
.const [37] = Method [110] [111] 
.const [38] = Method [112] [113] 
.const [39] = Method [114] [115] 
.const [40] = Method [116] [117] 
.const [41] = Method [118] [119] 
.const [42] = Method [120] [121] 
.const [43] = Field [122] [123] 
.const [44] = Class [124] 
.const [45] = Field [125] [126] 
.const [46] = Class [127] 
.const [47] = Field [128] [129] 
.const [48] = InterfaceMethod [130] [131] 
.const [49] = Field [132] [133] 
.const [50] = Field [134] [135] 
.const [51] = Field [136] [137] 
.const [52] = Field [138] [139] 
.const [53] = Field [140] [141] 
.const [54] = InterfaceMethod [142] [143] 
.const [55] = Int 270991360 
.const [56] = Utf8 org/dsi/ifc/navigation/ValueListStatus 
.const [57] = Utf8 de/audi/atip/timer/Timer 
.const [58] = Utf8 'POI Search Waiting Timer' 
.const [59] = Utf8 '%1#execute() - selectionCriteriaIndex: %2, maxItemsCount: %3' 
.const [60] = Utf8 '%1#fireTimer - timer fired, ending command.' 
.const [61] = Utf8 '%1#updatePoiSubstringSearchStatus( %2 ), minimumItems to move on = %3' 
.const [62] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/PoiSelectSelectionCriteriaSubstringSDSCommand 
.const [63] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/PoiSelectSelectionCriteriaSubstringCommand 
.const [64] = Utf8 de/audi/atip/log/LogChannel 
.const [65] = Utf8 org/dsi/ifc/navigation/DSINavigation 
.const [66] = Utf8 de/audi/tghu/navi/app/command/DSIResponseContainer 
.const [67] = Utf8 de/audi/tghu/command/ICommandList 
.const [68] = Class [144] 
.const [69] = NameAndType [145] [146] 
.const [70] = Class [147] 
.const [71] = NameAndType [148] [149] 
.const [72] = Class [150] 
.const [73] = NameAndType [151] [152] 
.const [74] = Class [153] 
.const [75] = NameAndType [154] [155] 
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
.const [124] = Utf8 org/dsi/ifc/navigation/ValueListStatus 
.const [125] = Class [228] 
.const [126] = NameAndType [229] [230] 
.const [127] = Utf8 de/audi/atip/timer/Timer 
.const [128] = Class [231] 
.const [129] = NameAndType [232] [233] 
.const [130] = Class [234] 
.const [131] = NameAndType [235] [236] 
.const [132] = Class [237] 
.const [133] = NameAndType [238] [239] 
.const [134] = Class [240] 
.const [135] = NameAndType [241] [242] 
.const [136] = Class [243] 
.const [137] = NameAndType [244] [245] 
.const [138] = Class [246] 
.const [139] = NameAndType [247] [248] 
.const [140] = Class [249] 
.const [141] = NameAndType [250] [251] 
.const [142] = Class [252] 
.const [143] = NameAndType [253] [254] 
.const [144] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/PoiSelectSelectionCriteriaSubstringSDSCommand 
.const [145] = Utf8 ignoreFurtherUpdates 
.const [146] = Utf8 Z 
.const [147] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/PoiSelectSelectionCriteriaSubstringSDSCommand 
.const [148] = Utf8 fakedFinishedSearchStatusWithNoResults 
.const [149] = Utf8 Lorg/dsi/ifc/navigation/ValueListStatus; 
.const [150] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/PoiSelectSelectionCriteriaSubstringSDSCommand 
.const [151] = Utf8 timer 
.const [152] = Utf8 Lde/audi/atip/timer/Timer; 
.const [153] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/PoiSelectSelectionCriteriaSubstringSDSCommand 
.const [154] = Utf8 logger 
.const [155] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [156] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/PoiSelectSelectionCriteriaSubstringSDSCommand 
.const [157] = Utf8 CLASS_NAME 
.const [158] = Utf8 Ljava/lang/String; 
.const [159] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/PoiSelectSelectionCriteriaSubstringSDSCommand 
.const [160] = Utf8 selectionCriteriaIndex 
.const [161] = Utf8 I 
.const [162] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/PoiSelectSelectionCriteriaSubstringSDSCommand 
.const [163] = Utf8 maxItemsCount 
.const [164] = Utf8 I 
.const [165] = Utf8 de/audi/atip/log/LogChannel 
.const [166] = Utf8 log 
.const [167] = Utf8 (ILjava/lang/String;Ljava/lang/Object;JJ)Z 
.const [168] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/PoiSelectSelectionCriteriaSubstringSDSCommand 
.const [169] = Utf8 getDSINavigation 
.const [170] = Utf8 ()Lorg/dsi/ifc/navigation/DSINavigation; 
.const [171] = Utf8 de/audi/atip/timer/Timer 
.const [172] = Utf8 start 
.const [173] = Utf8 ()V 
.const [174] = Utf8 de/audi/atip/log/LogChannel 
.const [175] = Utf8 log 
.const [176] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [177] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/PoiSelectSelectionCriteriaSubstringSDSCommand 
.const [178] = Utf8 dsiResponseContainer 
.const [179] = Utf8 Lde/audi/tghu/navi/app/command/DSIResponseContainer; 
.const [180] = Utf8 de/audi/tghu/navi/app/command/DSIResponseContainer 
.const [181] = Utf8 getPoiSubstringSearchStatus 
.const [182] = Utf8 ()Lorg/dsi/ifc/navigation/ValueListStatus; 
.const [183] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/PoiSelectSelectionCriteriaSubstringSDSCommand 
.const [184] = Utf8 updatePoiSubstringSearchStatus 
.const [185] = Utf8 (Lorg/dsi/ifc/navigation/ValueListStatus;)V 
.const [186] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/PoiSelectSelectionCriteriaSubstringSDSCommand 
.const [187] = Utf8 liValueListResponded 
.const [188] = Utf8 Z 
.const [189] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/PoiSelectSelectionCriteriaSubstringSDSCommand 
.const [190] = Utf8 lispUpdateSpellerResponded 
.const [191] = Utf8 Z 
.const [192] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/PoiSelectSelectionCriteriaSubstringSDSCommand 
.const [193] = Utf8 liResultResponded 
.const [194] = Utf8 Z 
.const [195] = Utf8 de/audi/atip/log/LogChannel 
.const [196] = Utf8 log 
.const [197] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;J)V 
.const [198] = Utf8 de/audi/tghu/navi/app/command/DSIResponseContainer 
.const [199] = Utf8 setPoiSubstringSearchStatus 
.const [200] = Utf8 (Lorg/dsi/ifc/navigation/ValueListStatus;)V 
.const [201] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/PoiSelectSelectionCriteriaSubstringSDSCommand 
.const [202] = Utf8 updatePoiSubstringSearchResponded 
.const [203] = Utf8 Z 
.const [204] = Utf8 de/audi/atip/timer/Timer 
.const [205] = Utf8 cancel 
.const [206] = Utf8 ()Z 
.const [207] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/PoiSelectSelectionCriteriaSubstringSDSCommand 
.const [208] = Utf8 getCommandList 
.const [209] = Utf8 ()Lde/audi/tghu/command/ICommandList; 
.const [210] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/PoiSelectSelectionCriteriaSubstringCommand 
.const [211] = Utf8 <init> 
.const [212] = Utf8 (IILde/audi/tghu/navi/app/addressinput/poi/sequences/SubstringSearchHandler;)V 
.const [213] = Utf8 org/dsi/ifc/navigation/ValueListStatus 
.const [214] = Utf8 <init> 
.const [215] = Utf8 (III)V 
.const [216] = Utf8 de/audi/atip/timer/Timer 
.const [217] = Utf8 <init> 
.const [218] = Utf8 (Ljava/lang/String;JZLde/audi/atip/timer/TimerListener;)V 
.const [219] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/PoiSelectSelectionCriteriaSubstringSDSCommand 
.const [220] = Utf8 fakeCheckFinished 
.const [221] = Utf8 ()V 
.const [222] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/PoiSelectSelectionCriteriaSubstringCommand 
.const [223] = Utf8 updatePoiSubstringSearchStatus 
.const [224] = Utf8 (Lorg/dsi/ifc/navigation/ValueListStatus;)V 
.const [225] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/PoiSelectSelectionCriteriaSubstringSDSCommand 
.const [226] = Utf8 ignoreFurtherUpdates 
.const [227] = Utf8 Z 
.const [228] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/PoiSelectSelectionCriteriaSubstringSDSCommand 
.const [229] = Utf8 fakedFinishedSearchStatusWithNoResults 
.const [230] = Utf8 Lorg/dsi/ifc/navigation/ValueListStatus; 
.const [231] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/PoiSelectSelectionCriteriaSubstringSDSCommand 
.const [232] = Utf8 timer 
.const [233] = Utf8 Lde/audi/atip/timer/Timer; 
.const [234] = Utf8 org/dsi/ifc/navigation/DSINavigation 
.const [235] = Utf8 poiSelectSelectionCriteria 
.const [236] = Utf8 (J)V 
.const [237] = Utf8 org/dsi/ifc/navigation/ValueListStatus 
.const [238] = Utf8 status 
.const [239] = Utf8 I 
.const [240] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/PoiSelectSelectionCriteriaSubstringSDSCommand 
.const [241] = Utf8 substringSearchStarted 
.const [242] = Utf8 Z 
.const [243] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/PoiSelectSelectionCriteriaSubstringSDSCommand 
.const [244] = Utf8 liValueListResponded 
.const [245] = Utf8 Z 
.const [246] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/PoiSelectSelectionCriteriaSubstringSDSCommand 
.const [247] = Utf8 lispUpdateSpellerResponded 
.const [248] = Utf8 Z 
.const [249] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/PoiSelectSelectionCriteriaSubstringSDSCommand 
.const [250] = Utf8 liResultResponded 
.const [251] = Utf8 Z 
.const [252] = Utf8 de/audi/tghu/command/ICommandList 
.const [253] = Utf8 commandFinished 
.const [254] = Utf8 ()V 
.const [255] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/PoiSelectSelectionCriteriaSubstringSDSCommand 
.const [256] = Class [255] 
.const [257] = Utf8 de/audi/tghu/navi/app/addressinput/poi/commands/PoiSelectSelectionCriteriaSubstringCommand 
.const [258] = Class [257] 
.const [259] = Utf8 ignoreFurtherUpdates 
.const [260] = Utf8 Z 
.const [261] = Utf8 timer 
.const [262] = Utf8 Lde/audi/atip/timer/Timer; 
.const [263] = Utf8 fakedFinishedSearchStatusWithNoResults 
.const [264] = Utf8 Lorg/dsi/ifc/navigation/ValueListStatus; 
.const [265] = Utf8 Code 
.const [266] = Utf8 <init> 
.const [267] = Utf8 (IILde/audi/tghu/navi/app/addressinput/poi/sequences/SubstringSearchHandler;)V 
.const [268] = Utf8 execute 
.const [269] = Utf8 ()V 
.const [270] = Utf8 fireTimer 
.const [271] = Utf8 (Lde/audi/atip/timer/Timer;)V 
.const [272] = Utf8 fakeCheckFinished 
.const [273] = Utf8 ()V 
.const [274] = Utf8 updatePoiSubstringSearchStatus 
.const [275] = Utf8 (Lorg/dsi/ifc/navigation/ValueListStatus;)V 
.const [276] = Utf8 checkFinished 
.const [277] = Utf8 ()V 
.end class 
