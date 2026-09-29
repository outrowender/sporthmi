.version 50 0 
.class public super [270] 
.super [272] 
.field public static final [273] [274] 
.field public static final [275] [276] 
.field public static final [277] [278] 
.field private static final [279] [280] 
.field private static final [281] [282] 
.field private static final [283] [284] 
.field private final [285] [286] 
.field private final [287] [288] 
.field private final [289] [290] 
.field private final [291] [292] 
.field private final [293] [294] 
.field private final [295] [296] 

.method public [298] : [299] 
    .attribute [297] .code stack 7 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     ldc [2] 
L4:     ldc [3] 
L6:     sipush 143 
L9:     invokespecial [44] 
L12:    aload_0 
L13:    iconst_2 
L14:    newarray int 
L16:    dup 
L17:    iconst_0 
L18:    sipush 142 
L21:    iastore 
L22:    dup 
L23:    iconst_1 
L24:    sipush 143 
L27:    iastore 
L28:    putfield [50] 
L31:    aload_0 
L32:    getstatic [4] 
L35:    putfield [51] 
L38:    aload_0 
L39:    ldc [5] 
L41:    putfield [52] 
L44:    aload_0 
L45:    ldc [6] 
L47:    putfield [53] 
L50:    aload_0 
L51:    aload_1 
L52:    getfield [28] 
L55:    ldc [7] 
L57:    invokevirtual [29] 
L60:    putfield [54] 
L63:    aload_0 
L64:    getfield [30] 
L67:    aload_0 
L68:    invokeinterface [55] 0 
L73:    aload_1 
L74:    getfield [28] 
L77:    ldc [8] 
L79:    invokevirtual [29] 
L82:    astore_2 
L83:    aload_0 
L84:    new [56] 
L87:    dup 
L88:    aload_2 
L89:    aload_0 
L90:    getfield [27] 
L93:    aload_1 
L94:    getfield [28] 
L97:    getfield [31] 
L100:   ldc [5] 
L102:   invokespecial [45] 
L105:   putfield [57] 
L108:   aload_0 
L109:   new [58] 
L112:   dup 
L113:   aload_1 
L114:   getfield [28] 
L117:   ldc [6] 
L119:   invokespecial [46] 
L122:   putfield [59] 
L125:   return 
L126:   nop 
L127:   nop 
L128:   
    .end code 
.end method 

.method protected [300] : [301] 
    .attribute [297] .code stack 4 locals 1 
L0:     aload_0 
L1:     invokespecial [47] 
L4:     aload_0 
L5:     getfield [33] 
L8:     getfield [28] 
L11:    invokevirtual [34] 
L14:    sipush 1009 
L17:    iconst_1 
L18:    iconst_2 
L19:    invokeinterface [60] 0 
L24:    istore_1 
L25:    aload_0 
L26:    getfield [32] 
L29:    aload_0 
L30:    iload_1 
L31:    invokespecial [48] 
L34:    invokevirtual [35] 
L37:    aload_0 
L38:    getfield [30] 
L41:    iload_1 
L42:    invokeinterface [61] 0 
L47:    return 
L48:    
    .end code 
.end method 

.method private [302] : [303] 
    .attribute [297] .code stack 5 locals 0 
L0:     iload_1 
L1:     ifle L91 
L4:     iload_1 
L5:     iconst_3 
L6:     if_icmpge L91 
L9:     aload_0 
L10:    getfield [33] 
L13:    getfield [28] 
L16:    getfield [31] 
L19:    ldc [11] 
L21:    ldc [12] 
L23:    iload_1 
L24:    i2l 
L25:    invokevirtual [36] 
L28:    pop 
L29:    iload_1 
L30:    lookupswitch 
            1 : L56 
            2 : L59 
            default : L70 

L56:    ldc [13] 
L58:    areturn 
L59:    aload_0 
L60:    getfield [37] 
L63:    iconst_2 
L64:    ldc [6] 
L66:    invokevirtual [38] 
L69:    areturn 
L70:    aload_0 
L71:    getfield [33] 
L74:    getfield [28] 
L77:    getfield [31] 
L80:    sipush 10000 
L83:    ldc [14] 
L85:    iload_1 
L86:    i2l 
L87:    invokevirtual [36] 
L90:    pop 
L91:    aload_0 
L92:    getfield [33] 
L95:    getfield [28] 
L98:    getfield [31] 
L101:   ldc [11] 
L103:   ldc [15] 
L105:   iload_1 
L106:   i2l 
L107:   invokevirtual [36] 
L110:   pop 
L111:   ldc [6] 
L113:   areturn 
L114:   nop 
L115:   nop 
L116:   
    .end code 
.end method 

.method public [304] : [305] 
    .attribute [297] .code stack 5 locals 0 
L0:     iload_1 
L1:     aload_0 
L2:     getfield [30] 
L5:     invokeinterface [62] 0 
L10:    if_icmpne L78 
L13:    aload_0 
L14:    getfield [33] 
L17:    getfield [28] 
L20:    getfield [31] 
L23:    ldc [11] 
L25:    ldc [16] 
L27:    iload_2 
L28:    i2l 
L29:    invokevirtual [36] 
L32:    pop 
L33:    aload_0 
L34:    getfield [33] 
L37:    getfield [28] 
L40:    invokevirtual [34] 
L43:    sipush 1009 
L46:    iconst_1 
L47:    iload_2 
L48:    invokeinterface [63] 0 
L53:    aload_0 
L54:    getfield [32] 
L57:    aload_0 
L58:    iload_2 
L59:    invokespecial [48] 
L62:    invokevirtual [35] 
L65:    aload_0 
L66:    getfield [30] 
L69:    iload_2 
L70:    invokeinterface [61] 0 
L75:    goto L107 
L78:    aload_0 
L79:    getfield [33] 
L82:    getfield [28] 
L85:    getfield [31] 
L88:    ldc [11] 
L90:    ldc [17] 
L92:    iload_1 
L93:    i2l 
L94:    invokevirtual [36] 
L97:    pop 
L98:    aload_0 
L99:    iload_1 
L100:   iload_2 
L101:   iload_3 
L102:   iload 4 
L104:   invokespecial [49] 
L107:   return 
L108:   
    .end code 
.end method 

.method protected [306] : [307] 
    .attribute [297] .code stack 4 locals 1 
L0:     aload_0 
L1:     invokevirtual [39] 
L4:     aload_0 
L5:     getfield [37] 
L8:     invokevirtual [34] 
L11:    sipush 1009 
L14:    iconst_1 
L15:    iconst_2 
L16:    invokeinterface [60] 0 
L21:    istore_1 
L22:    aload_0 
L23:    getfield [32] 
L26:    aload_0 
L27:    iload_1 
L28:    invokespecial [48] 
L31:    invokevirtual [35] 
L34:    aload_0 
L35:    getfield [32] 
L38:    invokevirtual [40] 
L41:    return 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method protected [308] : [309] 
    .attribute [297] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [32] 
L4:     invokevirtual [41] 
L7:     return 
L8:     
    .end code 
.end method 

.method protected [310] : [311] 
    .attribute [297] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [32] 
L4:     aload_1 
L5:     invokevirtual [42] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method protected [312] : [313] 
    .attribute [297] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [32] 
L4:     aload_1 
L5:     invokevirtual [43] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method protected interface [314] : [315] 
    .attribute [297] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [32] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected interface [316] : [317] 
    .attribute [297] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [26] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [318] : [319] 
    .attribute [297] .code stack 1 locals 0 
L0:     ldc [5] 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method protected [320] : [321] 
    .attribute [297] .code stack 1 locals 0 
L0:     bipush 11 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -1488843008 
.const [3] = Int -1455288576 
.const [4] = Field [64] [65] 
.const [5] = String [66] 
.const [6] = String [67] 
.const [7] = Int -1505620224 
.const [8] = Int -1472065792 
.const [9] = Class [68] 
.const [10] = Class [69] 
.const [11] = Int 1078071040 
.const [12] = String [70] 
.const [13] = String [71] 
.const [14] = String [72] 
.const [15] = String [73] 
.const [16] = String [74] 
.const [17] = String [75] 
.const [18] = Class [76] 
.const [19] = Class [77] 
.const [20] = Class [78] 
.const [21] = Class [79] 
.const [22] = Class [80] 
.const [23] = Class [81] 
.const [24] = Class [82] 
.const [25] = Class [83] 
.const [26] = Field [84] [85] 
.const [27] = Field [86] [87] 
.const [28] = Field [88] [89] 
.const [29] = Method [90] [91] 
.const [30] = Field [92] [93] 
.const [31] = Field [94] [95] 
.const [32] = Field [96] [97] 
.const [33] = Field [98] [99] 
.const [34] = Method [100] [101] 
.const [35] = Method [102] [103] 
.const [36] = Method [104] [105] 
.const [37] = Field [106] [107] 
.const [38] = Method [108] [109] 
.const [39] = Method [110] [111] 
.const [40] = Method [112] [113] 
.const [41] = Method [114] [115] 
.const [42] = Method [116] [117] 
.const [43] = Method [118] [119] 
.const [44] = Method [120] [121] 
.const [45] = Method [122] [123] 
.const [46] = Method [124] [125] 
.const [47] = Method [126] [127] 
.const [48] = Method [128] [129] 
.const [49] = Method [130] [131] 
.const [50] = Field [132] [133] 
.const [51] = Field [134] [135] 
.const [52] = Field [136] [137] 
.const [53] = Field [138] [139] 
.const [54] = Field [140] [141] 
.const [55] = InterfaceMethod [142] [143] 
.const [56] = Class [144] 
.const [57] = Field [145] [146] 
.const [58] = Class [147] 
.const [59] = Field [148] [149] 
.const [60] = InterfaceMethod [150] [151] 
.const [61] = InterfaceMethod [152] [153] 
.const [62] = InterfaceMethod [154] [155] 
.const [63] = InterfaceMethod [156] [157] 
.const [64] = Class [158] 
.const [65] = NameAndType [159] [160] 
.const [66] = Utf8 WirelessChargingVolumeRange 
.const [67] = Utf8 'Text not available' 
.const [68] = Utf8 de/audi/tone/app/volume/greyout/DefaultGreyOutAndPopupHandler 
.const [69] = Utf8 de/audi/tone/app/volume/samples/TTSSamplePlayer 
.const [70] = Utf8 '[WirelessChargingVolumeRange.getText] textId: %1' 
.const [71] = Utf8 '<audio src="WLC-reminder.wav"/>' 
.const [72] = Utf8 '[WirelessChargingVolumeRange.getText] Invalid textId %1' 
.const [73] = Utf8 '[WirelessChargingVolumeRange.getText]  wrong textId: %1' 
.const [74] = Utf8 '[WirelessChargingVolumeRange.itemSelected] itemID : %1' 
.const [75] = Utf8 '[WirelessChargingVolumeRange.itemSelected]   modelID: %1 handle in superclass' 
.const [76] = Utf8 de/audi/tone/app/volume/WirelessChargingVolumeRange 
.const [77] = Utf8 de/audi/tone/app/volume/AbstractVolumeRange 
.const [78] = Utf8 de/audi/atip/audio/AudioConnection 
.const [79] = Utf8 de/audi/tone/app/volume/VolumeRangeManager 
.const [80] = Utf8 de/audi/tone/app/ToneEnv 
.const [81] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [82] = Utf8 de/audi/atip/storage/IStorageAccess 
.const [83] = Utf8 de/audi/atip/log/LogChannel 
.const [84] = Class [161] 
.const [85] = NameAndType [162] [163] 
.const [86] = Class [164] 
.const [87] = NameAndType [165] [166] 
.const [88] = Class [167] 
.const [89] = NameAndType [168] [169] 
.const [90] = Class [170] 
.const [91] = NameAndType [171] [172] 
.const [92] = Class [173] 
.const [93] = NameAndType [174] [175] 
.const [94] = Class [176] 
.const [95] = NameAndType [177] [178] 
.const [96] = Class [179] 
.const [97] = NameAndType [180] [181] 
.const [98] = Class [182] 
.const [99] = NameAndType [183] [184] 
.const [100] = Class [185] 
.const [101] = NameAndType [186] [187] 
.const [102] = Class [188] 
.const [103] = NameAndType [189] [190] 
.const [104] = Class [191] 
.const [105] = NameAndType [192] [193] 
.const [106] = Class [194] 
.const [107] = NameAndType [195] [196] 
.const [108] = Class [197] 
.const [109] = NameAndType [198] [199] 
.const [110] = Class [200] 
.const [111] = NameAndType [201] [202] 
.const [112] = Class [203] 
.const [113] = NameAndType [204] [205] 
.const [114] = Class [206] 
.const [115] = NameAndType [207] [208] 
.const [116] = Class [209] 
.const [117] = NameAndType [210] [211] 
.const [118] = Class [212] 
.const [119] = NameAndType [213] [214] 
.const [120] = Class [215] 
.const [121] = NameAndType [216] [217] 
.const [122] = Class [218] 
.const [123] = NameAndType [219] [220] 
.const [124] = Class [221] 
.const [125] = NameAndType [222] [223] 
.const [126] = Class [224] 
.const [127] = NameAndType [225] [226] 
.const [128] = Class [227] 
.const [129] = NameAndType [228] [229] 
.const [130] = Class [230] 
.const [131] = NameAndType [231] [232] 
.const [132] = Class [233] 
.const [133] = NameAndType [234] [235] 
.const [134] = Class [236] 
.const [135] = NameAndType [237] [238] 
.const [136] = Class [239] 
.const [137] = NameAndType [240] [241] 
.const [138] = Class [242] 
.const [139] = NameAndType [243] [244] 
.const [140] = Class [245] 
.const [141] = NameAndType [246] [247] 
.const [142] = Class [248] 
.const [143] = NameAndType [249] [250] 
.const [144] = Utf8 de/audi/tone/app/volume/greyout/DefaultGreyOutAndPopupHandler 
.const [145] = Class [251] 
.const [146] = NameAndType [252] [253] 
.const [147] = Utf8 de/audi/tone/app/volume/samples/TTSSamplePlayer 
.const [148] = Class [254] 
.const [149] = NameAndType [255] [256] 
.const [150] = Class [257] 
.const [151] = NameAndType [258] [259] 
.const [152] = Class [260] 
.const [153] = NameAndType [261] [262] 
.const [154] = Class [263] 
.const [155] = NameAndType [264] [265] 
.const [156] = Class [266] 
.const [157] = NameAndType [267] [268] 
.const [158] = Utf8 de/audi/atip/audio/AudioConnection 
.const [159] = Utf8 GREY_OUT_ALL 
.const [160] = Utf8 [I 
.const [161] = Utf8 de/audi/tone/app/volume/WirelessChargingVolumeRange 
.const [162] = Utf8 volumeConnections 
.const [163] = Utf8 [I 
.const [164] = Utf8 de/audi/tone/app/volume/WirelessChargingVolumeRange 
.const [165] = Utf8 greyOutConnections 
.const [166] = Utf8 [I 
.const [167] = Utf8 de/audi/tone/app/volume/VolumeRangeManager 
.const [168] = Utf8 env 
.const [169] = Utf8 Lde/audi/tone/app/ToneEnv; 
.const [170] = Utf8 de/audi/tone/app/ToneEnv 
.const [171] = Utf8 getChoiceModel 
.const [172] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [173] = Utf8 de/audi/tone/app/volume/WirelessChargingVolumeRange 
.const [174] = Utf8 ddbModel 
.const [175] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [176] = Utf8 de/audi/tone/app/ToneEnv 
.const [177] = Utf8 lcHMI 
.const [178] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [179] = Utf8 de/audi/tone/app/volume/WirelessChargingVolumeRange 
.const [180] = Utf8 samplePlayer 
.const [181] = Utf8 Lde/audi/tone/app/volume/samples/TTSSamplePlayer; 
.const [182] = Utf8 de/audi/tone/app/volume/WirelessChargingVolumeRange 
.const [183] = Utf8 volMenuManager 
.const [184] = Utf8 Lde/audi/tone/app/volume/VolumeRangeManager; 
.const [185] = Utf8 de/audi/tone/app/ToneEnv 
.const [186] = Utf8 getStorageAccess 
.const [187] = Utf8 ()Lde/audi/atip/storage/IStorageAccess; 
.const [188] = Utf8 de/audi/tone/app/volume/samples/TTSSamplePlayer 
.const [189] = Utf8 setText 
.const [190] = Utf8 (Ljava/lang/String;)V 
.const [191] = Utf8 de/audi/atip/log/LogChannel 
.const [192] = Utf8 log 
.const [193] = Utf8 (ILjava/lang/String;J)Z 
.const [194] = Utf8 de/audi/tone/app/volume/WirelessChargingVolumeRange 
.const [195] = Utf8 env 
.const [196] = Utf8 Lde/audi/tone/app/ToneEnv; 
.const [197] = Utf8 de/audi/tone/app/ToneEnv 
.const [198] = Utf8 getTranslatedText 
.const [199] = Utf8 (ILjava/lang/String;)Ljava/lang/String; 
.const [200] = Utf8 de/audi/tone/app/volume/WirelessChargingVolumeRange 
.const [201] = Utf8 limitVolumeToHmiLimits 
.const [202] = Utf8 ()V 
.const [203] = Utf8 de/audi/tone/app/volume/samples/TTSSamplePlayer 
.const [204] = Utf8 startSession 
.const [205] = Utf8 ()V 
.const [206] = Utf8 de/audi/tone/app/volume/samples/TTSSamplePlayer 
.const [207] = Utf8 stopSession 
.const [208] = Utf8 ()V 
.const [209] = Utf8 de/audi/tone/app/volume/samples/TTSSamplePlayer 
.const [210] = Utf8 registerService 
.const [211] = Utf8 (Ljava/lang/Object;)V 
.const [212] = Utf8 de/audi/tone/app/volume/samples/TTSSamplePlayer 
.const [213] = Utf8 deregisterService 
.const [214] = Utf8 (Ljava/lang/Object;)V 
.const [215] = Utf8 de/audi/tone/app/volume/AbstractVolumeRange 
.const [216] = Utf8 <init> 
.const [217] = Utf8 (Lde/audi/tone/app/volume/VolumeRangeManager;III)V 
.const [218] = Utf8 de/audi/tone/app/volume/greyout/DefaultGreyOutAndPopupHandler 
.const [219] = Utf8 <init> 
.const [220] = Utf8 (Lde/audi/atip/hmi/modelaccess/ChoiceModelApp;[ILde/audi/atip/log/LogChannel;Ljava/lang/String;)V 
.const [221] = Utf8 de/audi/tone/app/volume/samples/TTSSamplePlayer 
.const [222] = Utf8 <init> 
.const [223] = Utf8 (Lde/audi/tone/app/ToneEnv;Ljava/lang/String;)V 
.const [224] = Utf8 de/audi/tone/app/volume/AbstractVolumeRange 
.const [225] = Utf8 init 
.const [226] = Utf8 ()V 
.const [227] = Utf8 de/audi/tone/app/volume/WirelessChargingVolumeRange 
.const [228] = Utf8 getText 
.const [229] = Utf8 (I)Ljava/lang/String; 
.const [230] = Utf8 de/audi/tone/app/volume/AbstractVolumeRange 
.const [231] = Utf8 itemSelected 
.const [232] = Utf8 (IIII)V 
.const [233] = Utf8 de/audi/tone/app/volume/WirelessChargingVolumeRange 
.const [234] = Utf8 volumeConnections 
.const [235] = Utf8 [I 
.const [236] = Utf8 de/audi/tone/app/volume/WirelessChargingVolumeRange 
.const [237] = Utf8 greyOutConnections 
.const [238] = Utf8 [I 
.const [239] = Utf8 de/audi/tone/app/volume/WirelessChargingVolumeRange 
.const [240] = Utf8 name 
.const [241] = Utf8 Ljava/lang/String; 
.const [242] = Utf8 de/audi/tone/app/volume/WirelessChargingVolumeRange 
.const [243] = Utf8 DEFAULT_TEXT 
.const [244] = Utf8 Ljava/lang/String; 
.const [245] = Utf8 de/audi/tone/app/volume/WirelessChargingVolumeRange 
.const [246] = Utf8 ddbModel 
.const [247] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [248] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [249] = Utf8 setChoiceListener 
.const [250] = Utf8 (Lde/audi/atip/hmi/model/ChoiceListener;)V 
.const [251] = Utf8 de/audi/tone/app/volume/WirelessChargingVolumeRange 
.const [252] = Utf8 greyOutHandler 
.const [253] = Utf8 Lde/audi/tone/app/IGreyOutAndPopupHandler; 
.const [254] = Utf8 de/audi/tone/app/volume/WirelessChargingVolumeRange 
.const [255] = Utf8 samplePlayer 
.const [256] = Utf8 Lde/audi/tone/app/volume/samples/TTSSamplePlayer; 
.const [257] = Utf8 de/audi/atip/storage/IStorageAccess 
.const [258] = Utf8 getInt 
.const [259] = Utf8 (III)I 
.const [260] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [261] = Utf8 setValue 
.const [262] = Utf8 (I)V 
.const [263] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [264] = Utf8 getID 
.const [265] = Utf8 ()I 
.const [266] = Utf8 de/audi/atip/storage/IStorageAccess 
.const [267] = Utf8 setInt 
.const [268] = Utf8 (III)V 
.const [269] = Utf8 de/audi/tone/app/volume/WirelessChargingVolumeRange 
.const [270] = Class [269] 
.const [271] = Utf8 de/audi/tone/app/volume/AbstractVolumeRange 
.const [272] = Class [271] 
.const [273] = Utf8 REMINDER_SIGNAL_OFF 
.const [274] = Utf8 I 
.const [275] = Utf8 REMINDER_SIGNAL_BEEP 
.const [276] = Utf8 I 
.const [277] = Utf8 REMINDER_SIGNAL_TEXT_MESSAGE 
.const [278] = Utf8 I 
.const [279] = Utf8 REMINDER_SIGNAL_OPTION_COUNT 
.const [280] = Utf8 I 
.const [281] = Utf8 BEEP 
.const [282] = Utf8 Ljava/lang/String; 
.const [283] = Utf8 CONNECTION 
.const [284] = Utf8 I 
.const [285] = Utf8 volumeConnections 
.const [286] = Utf8 [I 
.const [287] = Utf8 greyOutConnections 
.const [288] = Utf8 [I 
.const [289] = Utf8 name 
.const [290] = Utf8 Ljava/lang/String; 
.const [291] = Utf8 ddbModel 
.const [292] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [293] = Utf8 samplePlayer 
.const [294] = Utf8 Lde/audi/tone/app/volume/samples/TTSSamplePlayer; 
.const [295] = Utf8 DEFAULT_TEXT 
.const [296] = Utf8 Ljava/lang/String; 
.const [297] = Utf8 Code 
.const [298] = Utf8 <init> 
.const [299] = Utf8 (Lde/audi/tone/app/volume/VolumeRangeManager;)V 
.const [300] = Utf8 init 
.const [301] = Utf8 ()V 
.const [302] = Utf8 getText 
.const [303] = Utf8 (I)Ljava/lang/String; 
.const [304] = Utf8 itemSelected 
.const [305] = Utf8 (IIII)V 
.const [306] = Utf8 requestMenuConnection 
.const [307] = Utf8 ()V 
.const [308] = Utf8 releaseMenuConnection 
.const [309] = Utf8 ()V 
.const [310] = Utf8 registerService 
.const [311] = Utf8 (Ljava/lang/Object;)V 
.const [312] = Utf8 deregisterService 
.const [313] = Utf8 (Ljava/lang/Object;)V 
.const [314] = Utf8 getSamplePlayer 
.const [315] = Utf8 ()Lde/audi/tone/app/volume/samples/ISamplePlayer; 
.const [316] = Utf8 getVolumeConnections 
.const [317] = Utf8 ()[I 
.const [318] = Utf8 getName 
.const [319] = Utf8 ()Ljava/lang/String; 
.const [320] = Utf8 getID 
.const [321] = Utf8 ()I 
.end class 
