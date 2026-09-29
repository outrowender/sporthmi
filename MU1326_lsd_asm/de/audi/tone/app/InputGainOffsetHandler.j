.version 50 0 
.class public super [220] 
.super [222] 
.implements [224] 
.field private static final [225] [226] 
.field private final [227] [228] 
.field private final [229] [230] 
.field private final [231] [232] 
.field private final [233] [234] 

.method public [236] : [237] 
    .attribute [235] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokespecial [36] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [40] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [41] 
L14:    aload_0 
L15:    bipush 8 
L17:    newarray int 
L19:    putfield [42] 
L22:    aload_0 
L23:    getfield [28] 
L26:    iconst_0 
L27:    invokestatic [2] 
L30:    aload_0 
L31:    aload_1 
L32:    iconst_0 
L33:    ldc [3] 
L35:    invokevirtual [29] 
L38:    putfield [43] 
L41:    aload_0 
L42:    getfield [30] 
L45:    aload_0 
L46:    invokeinterface [44] 0 
L51:    return 
L52:    
    .end code 
.end method 

.method public [238] : [239] 
    .attribute [235] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     iload_2 
L3:     invokeinterface [45] 0 
L8:     iload_2 
L9:     invokespecial [37] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [240] : [241] 
    .attribute [235] .code stack 3 locals 0 
L0:     iload_2 
L1:     iconst_2 
L2:     if_icmpeq L6 
L5:     return 
L6:     aload_0 
L7:     iload_1 
L8:     iload_3 
L9:     invokespecial [37] 
L12:    return 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method private [242] : [243] 
    .attribute [235] .code stack 7 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     invokespecial [38] 
L5:     ifeq L66 
L8:     aload_0 
L9:     getfield [26] 
L12:    getfield [31] 
L15:    ldc [4] 
L17:    ldc [5] 
L19:    iload_1 
L20:    i2l 
L21:    iload_2 
L22:    i2l 
L23:    invokevirtual [32] 
L26:    pop 
L27:    iload_1 
L28:    aload_0 
L29:    getfield [28] 
L32:    iload_2 
L33:    iaload 
L34:    if_icmpeq L66 
L37:    aload_0 
L38:    getfield [28] 
L41:    iload_2 
L42:    iload_1 
L43:    iastore 
L44:    aload_0 
L45:    getfield [27] 
L48:    iload_2 
L49:    iload_1 
L50:    invokeinterface [46] 0 
L55:    aload_0 
L56:    getfield [27] 
L59:    iload_2 
L60:    iload_1 
L61:    invokeinterface [47] 0 
L66:    return 
L67:    nop 
L68:    
    .end code 
.end method 

.method public [244] : [245] 
    .attribute [235] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [26] 
L4:     getfield [31] 
L7:     ldc [4] 
L9:     ldc [6] 
L11:    iload_1 
L12:    i2l 
L13:    iload_2 
L14:    i2l 
L15:    invokevirtual [32] 
L18:    pop 
L19:    aload_0 
L20:    getfield [30] 
L23:    iload_1 
L24:    iload_2 
L25:    iconst_1 
L26:    invokeinterface [48] 0 
L31:    return 
L32:    
    .end code 
.end method 

.method public [246] : [247] 
    .attribute [235] .code stack 5 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     invokespecial [38] 
L5:     ifeq L38 
L8:     aload_0 
L9:     getfield [26] 
L12:    getfield [31] 
L15:    ldc [4] 
L17:    ldc [7] 
L19:    iload_2 
L20:    i2l 
L21:    invokevirtual [33] 
L24:    pop 
L25:    aload_0 
L26:    getfield [30] 
L29:    iload_2 
L30:    invokeinterface [49] 0 
L35:    goto L55 
L38:    aload_0 
L39:    getfield [26] 
L42:    getfield [31] 
L45:    ldc [4] 
L47:    ldc [8] 
L49:    iload_2 
L50:    i2l 
L51:    invokevirtual [33] 
L54:    pop 
L55:    return 
L56:    
    .end code 
.end method 

.method public [248] : [249] 
    .attribute [235] .code stack 9 locals 1 
L0:     aload_0 
L1:     getfield [28] 
L4:     iload_3 
L5:     iaload 
L6:     istore 4 
L8:     iload 4 
L10:    ifeq L51 
L13:    aload_0 
L14:    getfield [26] 
L17:    getfield [34] 
L20:    ldc [4] 
L22:    ldc [9] 
L24:    iload_1 
L25:    i2l 
L26:    iload_2 
L27:    i2l 
L28:    iload_3 
L29:    i2l 
L30:    invokevirtual [35] 
L33:    pop 
L34:    aload_0 
L35:    getfield [27] 
L38:    iload_3 
L39:    iload 4 
L41:    iload_2 
L42:    ineg 
L43:    invokeinterface [50] 0 
L48:    goto L68 
L51:    aload_0 
L52:    getfield [26] 
L55:    getfield [34] 
L58:    ldc [10] 
L60:    ldc [11] 
L62:    iload_3 
L63:    i2l 
L64:    invokevirtual [33] 
L67:    pop 
L68:    return 
L69:    nop 
L70:    nop 
L71:    nop 
L72:    
    .end code 
.end method 

.method public [250] : [251] 
    .attribute [235] .code stack 9 locals 1 
L0:     aload_0 
L1:     getfield [28] 
L4:     iload_3 
L5:     iaload 
L6:     istore 4 
L8:     iload 4 
L10:    ifeq L50 
L13:    aload_0 
L14:    getfield [26] 
L17:    getfield [34] 
L20:    ldc [4] 
L22:    ldc [12] 
L24:    iload_1 
L25:    i2l 
L26:    iload_2 
L27:    i2l 
L28:    iload_3 
L29:    i2l 
L30:    invokevirtual [35] 
L33:    pop 
L34:    aload_0 
L35:    getfield [27] 
L38:    iload_3 
L39:    iload 4 
L41:    iload_2 
L42:    invokeinterface [50] 0 
L47:    goto L67 
L50:    aload_0 
L51:    getfield [26] 
L54:    getfield [34] 
L57:    ldc [10] 
L59:    ldc [13] 
L61:    iload_3 
L62:    i2l 
L63:    invokevirtual [33] 
L66:    pop 
L67:    return 
L68:    
    .end code 
.end method 

.method public [252] : [253] 
    .attribute [235] .code stack 7 locals 0 
L0:     aload_0 
L1:     getfield [26] 
L4:     getfield [34] 
L7:     ldc [4] 
L9:     ldc [14] 
L11:    iload_1 
L12:    i2l 
L13:    iload_3 
L14:    i2l 
L15:    invokevirtual [32] 
L18:    pop 
L19:    aload_0 
L20:    getfield [30] 
L23:    iload_3 
L24:    invokeinterface [51] 0 
L29:    pop 
L30:    return 
L31:    nop 
L32:    
    .end code 
.end method 

.method private [254] : [255] 
    .attribute [235] .code stack 2 locals 0 
L0:     getstatic [15] 
L3:     iload_1 
L4:     invokestatic [16] 
L7:     iflt L14 
L10:    iconst_1 
L11:    goto L15 
L14:    iconst_0 
L15:    areturn 
L16:    
    .end code 
.end method 

.method static [256] : [257] 
    .attribute [235] .code stack 4 locals 0 
L0:     iconst_3 
L1:     newarray int 
L3:     dup 
L4:     iconst_0 
L5:     bipush 16 
L7:     iastore 
L8:     dup 
L9:     iconst_1 
L10:    bipush 17 
L12:    iastore 
L13:    dup 
L14:    iconst_2 
L15:    bipush 21 
L17:    iastore 
L18:    putstatic [39] 
L21:    getstatic [15] 
L24:    invokestatic [17] 
L27:    return 
L28:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [52] [53] 
.const [3] = Int 1833045760 
.const [4] = Int -2137614336 
.const [5] = String [54] 
.const [6] = String [55] 
.const [7] = String [56] 
.const [8] = String [57] 
.const [9] = String [58] 
.const [10] = Int -1601830656 
.const [11] = String [59] 
.const [12] = String [60] 
.const [13] = String [61] 
.const [14] = String [62] 
.const [15] = Field [63] [64] 
.const [16] = Method [65] [66] 
.const [17] = Method [67] [68] 
.const [18] = Class [69] 
.const [19] = Class [70] 
.const [20] = Class [71] 
.const [21] = Class [72] 
.const [22] = Class [73] 
.const [23] = Class [74] 
.const [24] = Class [75] 
.const [25] = Class [76] 
.const [26] = Field [77] [78] 
.const [27] = Field [79] [80] 
.const [28] = Field [81] [82] 
.const [29] = Method [83] [84] 
.const [30] = Field [85] [86] 
.const [31] = Field [87] [88] 
.const [32] = Method [89] [90] 
.const [33] = Method [91] [92] 
.const [34] = Field [93] [94] 
.const [35] = Method [95] [96] 
.const [36] = Method [97] [98] 
.const [37] = Method [99] [100] 
.const [38] = Method [101] [102] 
.const [39] = Field [103] [104] 
.const [40] = Field [105] [106] 
.const [41] = Field [107] [108] 
.const [42] = Field [109] [110] 
.const [43] = Field [111] [112] 
.const [44] = InterfaceMethod [113] [114] 
.const [45] = InterfaceMethod [115] [116] 
.const [46] = InterfaceMethod [117] [118] 
.const [47] = InterfaceMethod [119] [120] 
.const [48] = InterfaceMethod [121] [122] 
.const [49] = InterfaceMethod [123] [124] 
.const [50] = InterfaceMethod [125] [126] 
.const [51] = InterfaceMethod [127] [128] 
.const [52] = Class [129] 
.const [53] = NameAndType [130] [131] 
.const [54] = Utf8 '[InputGainOffsetHandler.requestRangeAndLevel] AC:%1 HT:%2' 
.const [55] = Utf8 '[InputGainOffsetHandler.inputGainOffsetRange] min:%1 max:%2' 
.const [56] = Utf8 '[InputGainOffsetHandler.updateInputGainOffset] inputGainOffset:%1' 
.const [57] = Utf8 '[InputGainOffsetHandler.updateInputGainOffset] connection :%1 is not in use do not update' 
.const [58] = Utf8 '[InputGainOffsetHandler.decrement] model:%1 steps:%2 HT:%3' 
.const [59] = Utf8 '[InputGainOffsetHandler.decrement] No connection active for HT:%1' 
.const [60] = Utf8 '[InputGainOffsetHandler.increment] model:%1 steps:%2 HT:%3' 
.const [61] = Utf8 '[InputGainOffsetHandler.increment] No connection active for HT:%1' 
.const [62] = Utf8 '[InputGainOffsetHandler.keyTyped] model:%1 HT:%2' 
.const [63] = Class [132] 
.const [64] = NameAndType [133] [134] 
.const [65] = Class [135] 
.const [66] = NameAndType [136] [137] 
.const [67] = Class [138] 
.const [68] = NameAndType [139] [140] 
.const [69] = Utf8 de/audi/tone/app/InputGainOffsetHandler 
.const [70] = Utf8 de/audi/tone/app/intra/AbstractAppListener 
.const [71] = Utf8 java/util/Arrays 
.const [72] = Utf8 de/audi/tone/app/ToneEnv 
.const [73] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelApp 
.const [74] = Utf8 de/audi/atip/audio/HMIAudioService 
.const [75] = Utf8 de/audi/atip/log/LogChannel 
.const [76] = Utf8 de/audi/tone/app/dsi/IDSISoundHandler 
.const [77] = Class [141] 
.const [78] = NameAndType [142] [143] 
.const [79] = Class [144] 
.const [80] = NameAndType [145] [146] 
.const [81] = Class [147] 
.const [82] = NameAndType [148] [149] 
.const [83] = Class [150] 
.const [84] = NameAndType [151] [152] 
.const [85] = Class [153] 
.const [86] = NameAndType [154] [155] 
.const [87] = Class [156] 
.const [88] = NameAndType [157] [158] 
.const [89] = Class [159] 
.const [90] = NameAndType [160] [161] 
.const [91] = Class [162] 
.const [92] = NameAndType [163] [164] 
.const [93] = Class [165] 
.const [94] = NameAndType [166] [167] 
.const [95] = Class [168] 
.const [96] = NameAndType [169] [170] 
.const [97] = Class [171] 
.const [98] = NameAndType [172] [173] 
.const [99] = Class [174] 
.const [100] = NameAndType [175] [176] 
.const [101] = Class [177] 
.const [102] = NameAndType [178] [179] 
.const [103] = Class [180] 
.const [104] = NameAndType [181] [182] 
.const [105] = Class [183] 
.const [106] = NameAndType [184] [185] 
.const [107] = Class [186] 
.const [108] = NameAndType [187] [188] 
.const [109] = Class [189] 
.const [110] = NameAndType [190] [191] 
.const [111] = Class [192] 
.const [112] = NameAndType [193] [194] 
.const [113] = Class [195] 
.const [114] = NameAndType [196] [197] 
.const [115] = Class [198] 
.const [116] = NameAndType [199] [200] 
.const [117] = Class [201] 
.const [118] = NameAndType [202] [203] 
.const [119] = Class [204] 
.const [120] = NameAndType [205] [206] 
.const [121] = Class [207] 
.const [122] = NameAndType [208] [209] 
.const [123] = Class [210] 
.const [124] = NameAndType [211] [212] 
.const [125] = Class [213] 
.const [126] = NameAndType [214] [215] 
.const [127] = Class [216] 
.const [128] = NameAndType [217] [218] 
.const [129] = Utf8 java/util/Arrays 
.const [130] = Utf8 fill 
.const [131] = Utf8 ([II)V 
.const [132] = Utf8 de/audi/tone/app/InputGainOffsetHandler 
.const [133] = Utf8 CONNECTIONS 
.const [134] = Utf8 [I 
.const [135] = Utf8 java/util/Arrays 
.const [136] = Utf8 binarySearch 
.const [137] = Utf8 ([II)I 
.const [138] = Utf8 java/util/Arrays 
.const [139] = Utf8 sort 
.const [140] = Utf8 ([I)V 
.const [141] = Utf8 de/audi/tone/app/InputGainOffsetHandler 
.const [142] = Utf8 env 
.const [143] = Utf8 Lde/audi/tone/app/ToneEnv; 
.const [144] = Utf8 de/audi/tone/app/InputGainOffsetHandler 
.const [145] = Utf8 dsiSound 
.const [146] = Utf8 Lde/audi/tone/app/dsi/IDSISoundHandler; 
.const [147] = Utf8 de/audi/tone/app/InputGainOffsetHandler 
.const [148] = Utf8 activeConnections 
.const [149] = Utf8 [I 
.const [150] = Utf8 de/audi/tone/app/ToneEnv 
.const [151] = Utf8 getRangeModel 
.const [152] = Utf8 (II)Lde/audi/atip/hmi/modelaccess/RangeModelApp; 
.const [153] = Utf8 de/audi/tone/app/InputGainOffsetHandler 
.const [154] = Utf8 mediaAuxLevelRange 
.const [155] = Utf8 Lde/audi/atip/hmi/modelaccess/RangeModelApp; 
.const [156] = Utf8 de/audi/tone/app/ToneEnv 
.const [157] = Utf8 lcMain 
.const [158] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [159] = Utf8 de/audi/atip/log/LogChannel 
.const [160] = Utf8 log 
.const [161] = Utf8 (ILjava/lang/String;JJ)Z 
.const [162] = Utf8 de/audi/atip/log/LogChannel 
.const [163] = Utf8 log 
.const [164] = Utf8 (ILjava/lang/String;J)Z 
.const [165] = Utf8 de/audi/tone/app/ToneEnv 
.const [166] = Utf8 lcHMI 
.const [167] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [168] = Utf8 de/audi/atip/log/LogChannel 
.const [169] = Utf8 log 
.const [170] = Utf8 (ILjava/lang/String;JJJ)Z 
.const [171] = Utf8 de/audi/tone/app/intra/AbstractAppListener 
.const [172] = Utf8 <init> 
.const [173] = Utf8 ()V 
.const [174] = Utf8 de/audi/tone/app/InputGainOffsetHandler 
.const [175] = Utf8 requestRangeAndLevel 
.const [176] = Utf8 (II)V 
.const [177] = Utf8 de/audi/tone/app/InputGainOffsetHandler 
.const [178] = Utf8 isUsedConnection 
.const [179] = Utf8 (I)Z 
.const [180] = Utf8 de/audi/tone/app/InputGainOffsetHandler 
.const [181] = Utf8 CONNECTIONS 
.const [182] = Utf8 [I 
.const [183] = Utf8 de/audi/tone/app/InputGainOffsetHandler 
.const [184] = Utf8 env 
.const [185] = Utf8 Lde/audi/tone/app/ToneEnv; 
.const [186] = Utf8 de/audi/tone/app/InputGainOffsetHandler 
.const [187] = Utf8 dsiSound 
.const [188] = Utf8 Lde/audi/tone/app/dsi/IDSISoundHandler; 
.const [189] = Utf8 de/audi/tone/app/InputGainOffsetHandler 
.const [190] = Utf8 activeConnections 
.const [191] = Utf8 [I 
.const [192] = Utf8 de/audi/tone/app/InputGainOffsetHandler 
.const [193] = Utf8 mediaAuxLevelRange 
.const [194] = Utf8 Lde/audi/atip/hmi/modelaccess/RangeModelApp; 
.const [195] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelApp 
.const [196] = Utf8 setRangeListener 
.const [197] = Utf8 (Lde/audi/atip/hmi/model/RangeListener;)V 
.const [198] = Utf8 de/audi/atip/audio/HMIAudioService 
.const [199] = Utf8 getActiveEntertainmentConnection 
.const [200] = Utf8 (I)I 
.const [201] = Utf8 de/audi/tone/app/dsi/IDSISoundHandler 
.const [202] = Utf8 getInputGainOffsetRange 
.const [203] = Utf8 (II)V 
.const [204] = Utf8 de/audi/tone/app/dsi/IDSISoundHandler 
.const [205] = Utf8 getInputGainOffset 
.const [206] = Utf8 (II)V 
.const [207] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelApp 
.const [208] = Utf8 setLimits 
.const [209] = Utf8 (III)V 
.const [210] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelApp 
.const [211] = Utf8 setValue 
.const [212] = Utf8 (I)V 
.const [213] = Utf8 de/audi/tone/app/dsi/IDSISoundHandler 
.const [214] = Utf8 changeInputGainOffset 
.const [215] = Utf8 (III)V 
.const [216] = Utf8 de/audi/atip/hmi/modelaccess/RangeModelApp 
.const [217] = Utf8 fireEvent 
.const [218] = Utf8 (I)Z 
.const [219] = Utf8 de/audi/tone/app/InputGainOffsetHandler 
.const [220] = Class [219] 
.const [221] = Utf8 de/audi/tone/app/intra/AbstractAppListener 
.const [222] = Class [221] 
.const [223] = Utf8 de/audi/atip/hmi/model/RangeListener 
.const [224] = Class [223] 
.const [225] = Utf8 CONNECTIONS 
.const [226] = Utf8 [I 
.const [227] = Utf8 dsiSound 
.const [228] = Utf8 Lde/audi/tone/app/dsi/IDSISoundHandler; 
.const [229] = Utf8 env 
.const [230] = Utf8 Lde/audi/tone/app/ToneEnv; 
.const [231] = Utf8 mediaAuxLevelRange 
.const [232] = Utf8 Lde/audi/atip/hmi/modelaccess/RangeModelApp; 
.const [233] = Utf8 activeConnections 
.const [234] = Utf8 [I 
.const [235] = Utf8 Code 
.const [236] = Utf8 <init> 
.const [237] = Utf8 (Lde/audi/tone/app/ToneEnv;Lde/audi/tone/app/dsi/IDSISoundHandler;)V 
.const [238] = Utf8 init 
.const [239] = Utf8 (Lde/audi/atip/audio/HMIAudioService;I)V 
.const [240] = Utf8 updateConnectionStatus 
.const [241] = Utf8 (III)V 
.const [242] = Utf8 requestRangeAndLevel 
.const [243] = Utf8 (II)V 
.const [244] = Utf8 inputGainOffsetRange 
.const [245] = Utf8 (II)V 
.const [246] = Utf8 updateInputGainOffset 
.const [247] = Utf8 (II)V 
.const [248] = Utf8 decrement 
.const [249] = Utf8 (III)V 
.const [250] = Utf8 increment 
.const [251] = Utf8 (III)V 
.const [252] = Utf8 keyTyped 
.const [253] = Utf8 (III)V 
.const [254] = Utf8 isUsedConnection 
.const [255] = Utf8 (I)Z 
.const [256] = Utf8 <clinit> 
.const [257] = Utf8 ()V 
.end class 
