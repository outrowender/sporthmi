.version 50 0 
.class super [278] 
.super [280] 
.field private final [281] [282] 
.field private final [283] [284] 
.field private final [285] [286] 
.field private final [287] [288] 
.field private final [289] [290] 
.field private static final [291] [292] 
.field private static final [293] [294] 
.field private [295] [296] 
.field private [297] [298] 
.field private [299] [300] 

.method public [302] : [303] 
    .attribute [301] .code stack 3 locals 1 
L0:     aload_0 
L1:     invokespecial [48] 
L4:     aload_1 
L5:     invokevirtual [22] 
L8:     astore_2 
L9:     aload_0 
L10:    aload_2 
L11:    ldc [2] 
L13:    invokevirtual [23] 
L16:    putfield [50] 
L19:    aload_0 
L20:    aload_2 
L21:    ldc [3] 
L23:    invokevirtual [23] 
L26:    putfield [51] 
L29:    aload_0 
L30:    aload_2 
L31:    ldc [4] 
L33:    invokevirtual [23] 
L36:    putfield [52] 
L39:    aload_0 
L40:    aload_2 
L41:    ldc [5] 
L43:    invokevirtual [23] 
L46:    putfield [53] 
L49:    aload_0 
L50:    aload_2 
L51:    ldc [6] 
L53:    invokevirtual [28] 
L56:    putfield [54] 
L59:    return 
L60:    
    .end code 
.end method 

.method public [304] : [305] 
    .attribute [301] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [24] 
L4:     aload_1 
L5:     invokeinterface [55] 0 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [306] : [307] 
    .attribute [301] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [56] 
L5:     aload_0 
L6:     iload_2 
L7:     putfield [57] 
L10:    aload_0 
L11:    aload_3 
L12:    putfield [58] 
L15:    aload_0 
L16:    aload_1 
L17:    invokevirtual [33] 
L20:    invokevirtual [34] 
L23:    aload_0 
L24:    getfield [25] 
L27:    aload_1 
L28:    invokevirtual [35] 
L31:    invokeinterface [55] 0 
L36:    aload_0 
L37:    getfield [26] 
L40:    aload_1 
L41:    invokevirtual [36] 
L44:    invokeinterface [55] 0 
L49:    aload_0 
L50:    getfield [27] 
L53:    ldc [7] 
L55:    invokeinterface [55] 0 
L60:    aload_0 
L61:    getfield [29] 
L64:    iconst_0 
L65:    invokeinterface [59] 0 
L70:    aload_0 
L71:    getfield [27] 
L74:    iconst_0 
L75:    invokeinterface [60] 0 
L80:    return 
L81:    nop 
L82:    nop 
L83:    nop 
L84:    
    .end code 
.end method 

.method public [308] : [309] 
    .attribute [301] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [30] 
L4:     ifnull L151 
L7:     aload_0 
L8:     getfield [30] 
L11:    invokevirtual [37] 
L14:    aload_1 
L15:    getfield [38] 
L18:    if_icmpne L151 
L21:    aload_0 
L22:    getfield [30] 
L25:    invokevirtual [39] 
L28:    aload_1 
L29:    getfield [40] 
L32:    if_icmpne L151 
L35:    new [61] 
L38:    dup 
L39:    aload_1 
L40:    getfield [41] 
L43:    invokevirtual [42] 
L46:    aload_1 
L47:    getfield [43] 
L50:    invokevirtual [42] 
L53:    iadd 
L54:    iconst_2 
L55:    iadd 
L56:    invokespecial [49] 
L59:    astore_2 
L60:    aload_1 
L61:    getfield [41] 
L64:    invokestatic [9] 
L67:    ifne L84 
L70:    aload_2 
L71:    aload_1 
L72:    getfield [41] 
L75:    invokevirtual [44] 
L78:    ldc [10] 
L80:    invokevirtual [44] 
L83:    pop 
L84:    aload_2 
L85:    aload_1 
L86:    getfield [43] 
L89:    invokevirtual [44] 
L92:    pop 
L93:    aload_0 
L94:    getfield [27] 
L97:    aload_2 
L98:    invokevirtual [45] 
L101:   invokeinterface [55] 0 
L106:   aload_0 
L107:   getfield [27] 
L110:   iconst_1 
L111:   invokeinterface [60] 0 
L116:   aload_0 
L117:   getfield [29] 
L120:   aload_0 
L121:   getfield [31] 
L124:   ifne L145 
L127:   aload_0 
L128:   getfield [32] 
L131:   invokevirtual [46] 
L134:   aload_1 
L135:   getfield [38] 
L138:   if_icmpne L145 
L141:   iconst_1 
L142:   goto L146 
L145:   iconst_0 
L146:   invokeinterface [59] 0 
L151:   return 
L152:   
    .end code 
.end method 

.method public [310] : [311] 
    .attribute [301] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [30] 
L4:     ifnull L31 
L7:     aload_0 
L8:     getfield [30] 
L11:    lload_1 
L12:    invokevirtual [47] 
L15:    aload_0 
L16:    getfield [25] 
L19:    aload_0 
L20:    getfield [30] 
L23:    invokevirtual [35] 
L26:    invokeinterface [55] 0 
L31:    return 
L32:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 92930304 
.const [3] = Int 1401487616 
.const [4] = Int 76153088 
.const [5] = Int 445251840 
.const [6] = Int -1635188480 
.const [7] = String [62] 
.const [8] = Class [63] 
.const [9] = Method [64] [65] 
.const [10] = String [66] 
.const [11] = Class [67] 
.const [12] = Class [68] 
.const [13] = Class [69] 
.const [14] = Class [70] 
.const [15] = Class [71] 
.const [16] = Class [72] 
.const [17] = Class [73] 
.const [18] = Class [74] 
.const [19] = Class [75] 
.const [20] = Class [76] 
.const [21] = Class [77] 
.const [22] = Method [78] [79] 
.const [23] = Method [80] [81] 
.const [24] = Field [82] [83] 
.const [25] = Field [84] [85] 
.const [26] = Field [86] [87] 
.const [27] = Field [88] [89] 
.const [28] = Method [90] [91] 
.const [29] = Field [92] [93] 
.const [30] = Field [94] [95] 
.const [31] = Field [96] [97] 
.const [32] = Field [98] [99] 
.const [33] = Method [100] [101] 
.const [34] = Method [102] [103] 
.const [35] = Method [104] [105] 
.const [36] = Method [106] [107] 
.const [37] = Method [108] [109] 
.const [38] = Field [110] [111] 
.const [39] = Method [112] [113] 
.const [40] = Field [114] [115] 
.const [41] = Field [116] [117] 
.const [42] = Method [118] [119] 
.const [43] = Field [120] [121] 
.const [44] = Method [122] [123] 
.const [45] = Method [124] [125] 
.const [46] = Method [126] [127] 
.const [47] = Method [128] [129] 
.const [48] = Method [130] [131] 
.const [49] = Method [132] [133] 
.const [50] = Field [134] [135] 
.const [51] = Field [136] [137] 
.const [52] = Field [138] [139] 
.const [53] = Field [140] [141] 
.const [54] = Field [142] [143] 
.const [55] = InterfaceMethod [144] [145] 
.const [56] = Field [146] [147] 
.const [57] = Field [148] [149] 
.const [58] = Field [150] [151] 
.const [59] = InterfaceMethod [152] [153] 
.const [60] = InterfaceMethod [154] [155] 
.const [61] = Class [156] 
.const [62] = Utf8 '' 
.const [63] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [64] = Class [157] 
.const [65] = NameAndType [158] [159] 
.const [66] = Utf8 '\n\n' 
.const [67] = Utf8 de/audi/tuner/app/epg/sdars/SDARSEPGHandler$DescriptionScreenHelper 
.const [68] = Utf8 java/lang/Object 
.const [69] = Utf8 de/audi/tuner/app/TunerBasics 
.const [70] = Utf8 de/audi/tuner/app/TunerModels 
.const [71] = Utf8 de/audi/atip/hmi/modelaccess/LabelModelApp 
.const [72] = Utf8 de/audi/tuner/app/epg/sdars/AbstractProgramSdarsEpgListRow 
.const [73] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [74] = Utf8 org/dsi/ifc/sdars/EPGDescription 
.const [75] = Utf8 java/lang/String 
.const [76] = Utf8 de/audi/tuner/app/Utilities 
.const [77] = Utf8 de/audi/tuner/app/sdars/StationInfoExt 
.const [78] = Class [160] 
.const [79] = NameAndType [161] [162] 
.const [80] = Class [163] 
.const [81] = NameAndType [164] [165] 
.const [82] = Class [166] 
.const [83] = NameAndType [167] [168] 
.const [84] = Class [169] 
.const [85] = NameAndType [170] [171] 
.const [86] = Class [172] 
.const [87] = NameAndType [173] [174] 
.const [88] = Class [175] 
.const [89] = NameAndType [176] [177] 
.const [90] = Class [178] 
.const [91] = NameAndType [179] [180] 
.const [92] = Class [181] 
.const [93] = NameAndType [182] [183] 
.const [94] = Class [184] 
.const [95] = NameAndType [185] [186] 
.const [96] = Class [187] 
.const [97] = NameAndType [188] [189] 
.const [98] = Class [190] 
.const [99] = NameAndType [191] [192] 
.const [100] = Class [193] 
.const [101] = NameAndType [194] [195] 
.const [102] = Class [196] 
.const [103] = NameAndType [197] [198] 
.const [104] = Class [199] 
.const [105] = NameAndType [200] [201] 
.const [106] = Class [202] 
.const [107] = NameAndType [203] [204] 
.const [108] = Class [205] 
.const [109] = NameAndType [206] [207] 
.const [110] = Class [208] 
.const [111] = NameAndType [209] [210] 
.const [112] = Class [211] 
.const [113] = NameAndType [212] [213] 
.const [114] = Class [214] 
.const [115] = NameAndType [215] [216] 
.const [116] = Class [217] 
.const [117] = NameAndType [218] [219] 
.const [118] = Class [220] 
.const [119] = NameAndType [221] [222] 
.const [120] = Class [223] 
.const [121] = NameAndType [224] [225] 
.const [122] = Class [226] 
.const [123] = NameAndType [227] [228] 
.const [124] = Class [229] 
.const [125] = NameAndType [230] [231] 
.const [126] = Class [232] 
.const [127] = NameAndType [233] [234] 
.const [128] = Class [235] 
.const [129] = NameAndType [236] [237] 
.const [130] = Class [238] 
.const [131] = NameAndType [239] [240] 
.const [132] = Class [241] 
.const [133] = NameAndType [242] [243] 
.const [134] = Class [244] 
.const [135] = NameAndType [245] [246] 
.const [136] = Class [247] 
.const [137] = NameAndType [248] [249] 
.const [138] = Class [250] 
.const [139] = NameAndType [251] [252] 
.const [140] = Class [253] 
.const [141] = NameAndType [254] [255] 
.const [142] = Class [256] 
.const [143] = NameAndType [257] [258] 
.const [144] = Class [259] 
.const [145] = NameAndType [260] [261] 
.const [146] = Class [262] 
.const [147] = NameAndType [263] [264] 
.const [148] = Class [265] 
.const [149] = NameAndType [266] [267] 
.const [150] = Class [268] 
.const [151] = NameAndType [269] [270] 
.const [152] = Class [271] 
.const [153] = NameAndType [272] [273] 
.const [154] = Class [274] 
.const [155] = NameAndType [275] [276] 
.const [156] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [157] = Utf8 de/audi/tuner/app/Utilities 
.const [158] = Utf8 isEmpty 
.const [159] = Utf8 (Ljava/lang/String;)Z 
.const [160] = Utf8 de/audi/tuner/app/TunerBasics 
.const [161] = Utf8 getModels 
.const [162] = Utf8 ()Lde/audi/tuner/app/TunerModels; 
.const [163] = Utf8 de/audi/tuner/app/TunerModels 
.const [164] = Utf8 getLabelModel 
.const [165] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/LabelModelApp; 
.const [166] = Utf8 de/audi/tuner/app/epg/sdars/SDARSEPGHandler$DescriptionScreenHelper 
.const [167] = Utf8 detailLabelStationName 
.const [168] = Utf8 Lde/audi/atip/hmi/modelaccess/LabelModelApp; 
.const [169] = Utf8 de/audi/tuner/app/epg/sdars/SDARSEPGHandler$DescriptionScreenHelper 
.const [170] = Utf8 detailLabelPeriod 
.const [171] = Utf8 Lde/audi/atip/hmi/modelaccess/LabelModelApp; 
.const [172] = Utf8 de/audi/tuner/app/epg/sdars/SDARSEPGHandler$DescriptionScreenHelper 
.const [173] = Utf8 detailLabelProgramName 
.const [174] = Utf8 Lde/audi/atip/hmi/modelaccess/LabelModelApp; 
.const [175] = Utf8 de/audi/tuner/app/epg/sdars/SDARSEPGHandler$DescriptionScreenHelper 
.const [176] = Utf8 detailLabelDescription 
.const [177] = Utf8 Lde/audi/atip/hmi/modelaccess/LabelModelApp; 
.const [178] = Utf8 de/audi/tuner/app/TunerModels 
.const [179] = Utf8 getChoiceModel 
.const [180] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [181] = Utf8 de/audi/tuner/app/epg/sdars/SDARSEPGHandler$DescriptionScreenHelper 
.const [182] = Utf8 detailChoiceActiveProgram 
.const [183] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [184] = Utf8 de/audi/tuner/app/epg/sdars/SDARSEPGHandler$DescriptionScreenHelper 
.const [185] = Utf8 programRowToShowDetailsFor 
.const [186] = Utf8 Lde/audi/tuner/app/epg/sdars/AbstractProgramSdarsEpgListRow; 
.const [187] = Utf8 de/audi/tuner/app/epg/sdars/SDARSEPGHandler$DescriptionScreenHelper 
.const [188] = Utf8 programRowIndexToShowDetailsFor 
.const [189] = Utf8 I 
.const [190] = Utf8 de/audi/tuner/app/epg/sdars/SDARSEPGHandler$DescriptionScreenHelper 
.const [191] = Utf8 currentSelectedStation 
.const [192] = Utf8 Lde/audi/tuner/app/sdars/StationInfoExt; 
.const [193] = Utf8 de/audi/tuner/app/epg/sdars/AbstractProgramSdarsEpgListRow 
.const [194] = Utf8 getChannelName 
.const [195] = Utf8 ()Ljava/lang/String; 
.const [196] = Utf8 de/audi/tuner/app/epg/sdars/SDARSEPGHandler$DescriptionScreenHelper 
.const [197] = Utf8 setChannelName 
.const [198] = Utf8 (Ljava/lang/String;)V 
.const [199] = Utf8 de/audi/tuner/app/epg/sdars/AbstractProgramSdarsEpgListRow 
.const [200] = Utf8 getFormatedPerid 
.const [201] = Utf8 ()Ljava/lang/String; 
.const [202] = Utf8 de/audi/tuner/app/epg/sdars/AbstractProgramSdarsEpgListRow 
.const [203] = Utf8 getLongProgramName 
.const [204] = Utf8 ()Ljava/lang/String; 
.const [205] = Utf8 de/audi/tuner/app/epg/sdars/AbstractProgramSdarsEpgListRow 
.const [206] = Utf8 getSID 
.const [207] = Utf8 ()I 
.const [208] = Utf8 org/dsi/ifc/sdars/EPGDescription 
.const [209] = Utf8 sID 
.const [210] = Utf8 I 
.const [211] = Utf8 de/audi/tuner/app/epg/sdars/AbstractProgramSdarsEpgListRow 
.const [212] = Utf8 getProgramID 
.const [213] = Utf8 ()I 
.const [214] = Utf8 org/dsi/ifc/sdars/EPGDescription 
.const [215] = Utf8 programID 
.const [216] = Utf8 I 
.const [217] = Utf8 org/dsi/ifc/sdars/EPGDescription 
.const [218] = Utf8 seriesDescription 
.const [219] = Utf8 Ljava/lang/String; 
.const [220] = Utf8 java/lang/String 
.const [221] = Utf8 length 
.const [222] = Utf8 ()I 
.const [223] = Utf8 org/dsi/ifc/sdars/EPGDescription 
.const [224] = Utf8 programDescription 
.const [225] = Utf8 Ljava/lang/String; 
.const [226] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [227] = Utf8 append 
.const [228] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [229] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [230] = Utf8 toString 
.const [231] = Utf8 ()Ljava/lang/String; 
.const [232] = Utf8 de/audi/tuner/app/sdars/StationInfoExt 
.const [233] = Utf8 getSID 
.const [234] = Utf8 ()I 
.const [235] = Utf8 de/audi/tuner/app/epg/sdars/AbstractProgramSdarsEpgListRow 
.const [236] = Utf8 updateTimesWithTimezoneOffset 
.const [237] = Utf8 (J)V 
.const [238] = Utf8 java/lang/Object 
.const [239] = Utf8 <init> 
.const [240] = Utf8 ()V 
.const [241] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [242] = Utf8 <init> 
.const [243] = Utf8 (I)V 
.const [244] = Utf8 de/audi/tuner/app/epg/sdars/SDARSEPGHandler$DescriptionScreenHelper 
.const [245] = Utf8 detailLabelStationName 
.const [246] = Utf8 Lde/audi/atip/hmi/modelaccess/LabelModelApp; 
.const [247] = Utf8 de/audi/tuner/app/epg/sdars/SDARSEPGHandler$DescriptionScreenHelper 
.const [248] = Utf8 detailLabelPeriod 
.const [249] = Utf8 Lde/audi/atip/hmi/modelaccess/LabelModelApp; 
.const [250] = Utf8 de/audi/tuner/app/epg/sdars/SDARSEPGHandler$DescriptionScreenHelper 
.const [251] = Utf8 detailLabelProgramName 
.const [252] = Utf8 Lde/audi/atip/hmi/modelaccess/LabelModelApp; 
.const [253] = Utf8 de/audi/tuner/app/epg/sdars/SDARSEPGHandler$DescriptionScreenHelper 
.const [254] = Utf8 detailLabelDescription 
.const [255] = Utf8 Lde/audi/atip/hmi/modelaccess/LabelModelApp; 
.const [256] = Utf8 de/audi/tuner/app/epg/sdars/SDARSEPGHandler$DescriptionScreenHelper 
.const [257] = Utf8 detailChoiceActiveProgram 
.const [258] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [259] = Utf8 de/audi/atip/hmi/modelaccess/LabelModelApp 
.const [260] = Utf8 setText 
.const [261] = Utf8 (Ljava/lang/String;)V 
.const [262] = Utf8 de/audi/tuner/app/epg/sdars/SDARSEPGHandler$DescriptionScreenHelper 
.const [263] = Utf8 programRowToShowDetailsFor 
.const [264] = Utf8 Lde/audi/tuner/app/epg/sdars/AbstractProgramSdarsEpgListRow; 
.const [265] = Utf8 de/audi/tuner/app/epg/sdars/SDARSEPGHandler$DescriptionScreenHelper 
.const [266] = Utf8 programRowIndexToShowDetailsFor 
.const [267] = Utf8 I 
.const [268] = Utf8 de/audi/tuner/app/epg/sdars/SDARSEPGHandler$DescriptionScreenHelper 
.const [269] = Utf8 currentSelectedStation 
.const [270] = Utf8 Lde/audi/tuner/app/sdars/StationInfoExt; 
.const [271] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [272] = Utf8 setValue 
.const [273] = Utf8 (I)V 
.const [274] = Utf8 de/audi/atip/hmi/modelaccess/LabelModelApp 
.const [275] = Utf8 setStatus 
.const [276] = Utf8 (I)V 
.const [277] = Utf8 de/audi/tuner/app/epg/sdars/SDARSEPGHandler$DescriptionScreenHelper 
.const [278] = Class [277] 
.const [279] = Utf8 java/lang/Object 
.const [280] = Class [279] 
.const [281] = Utf8 detailLabelStationName 
.const [282] = Utf8 Lde/audi/atip/hmi/modelaccess/LabelModelApp; 
.const [283] = Utf8 detailLabelPeriod 
.const [284] = Utf8 Lde/audi/atip/hmi/modelaccess/LabelModelApp; 
.const [285] = Utf8 detailLabelProgramName 
.const [286] = Utf8 Lde/audi/atip/hmi/modelaccess/LabelModelApp; 
.const [287] = Utf8 detailLabelDescription 
.const [288] = Utf8 Lde/audi/atip/hmi/modelaccess/LabelModelApp; 
.const [289] = Utf8 detailChoiceActiveProgram 
.const [290] = Utf8 Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [291] = Utf8 DETAIL_NOT_ACTIVE_PROGRAM 
.const [292] = Utf8 I 
.const [293] = Utf8 DETAIL_ACTIVE_PROGRAM 
.const [294] = Utf8 I 
.const [295] = Utf8 programRowToShowDetailsFor 
.const [296] = Utf8 Lde/audi/tuner/app/epg/sdars/AbstractProgramSdarsEpgListRow; 
.const [297] = Utf8 currentSelectedStation 
.const [298] = Utf8 Lde/audi/tuner/app/sdars/StationInfoExt; 
.const [299] = Utf8 programRowIndexToShowDetailsFor 
.const [300] = Utf8 I 
.const [301] = Utf8 Code 
.const [302] = Utf8 <init> 
.const [303] = Utf8 (Lde/audi/tuner/app/TunerBasics;)V 
.const [304] = Utf8 setChannelName 
.const [305] = Utf8 (Ljava/lang/String;)V 
.const [306] = Utf8 initFor 
.const [307] = Utf8 (Lde/audi/tuner/app/epg/sdars/AbstractProgramSdarsEpgListRow;ILde/audi/tuner/app/sdars/StationInfoExt;)V 
.const [308] = Utf8 updateEPGDescriptionIfMatches 
.const [309] = Utf8 (Lorg/dsi/ifc/sdars/EPGDescription;)V 
.const [310] = Utf8 updateTimeZoneOffset 
.const [311] = Utf8 (J)V 
.end class 
