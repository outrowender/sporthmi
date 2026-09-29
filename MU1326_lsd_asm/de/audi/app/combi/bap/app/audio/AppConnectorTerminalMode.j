.version 50 0 
.class public super [235] 
.super [237] 
.implements [239] 

.method protected annotation [241] : [242] 
    .attribute [240] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [47] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [243] : [244] 
    .attribute [240] .code stack 1 locals 0 
L0:     iconst_3 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method protected [245] : [246] 
    .attribute [240] .code stack 1 locals 0 
L0:     ldc [2] 
L2:     areturn 
L3:     nop 
L4:     
    .end code 
.end method 

.method protected [247] : [248] 
    .attribute [240] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [23] 
L4:     checkcast [3] 
L7:     invokevirtual [24] 
L10:    invokevirtual [25] 
L13:    areturn 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [249] : [250] 
    .attribute [240] .code stack 3 locals 2 
L0:     new [51] 
L3:     dup 
L4:     invokespecial [48] 
L7:     astore 7 
L9:     aload 7 
L11:    iload_1 
L12:    invokevirtual [26] 
L15:    aload 7 
L17:    iload_2 
L18:    invokevirtual [27] 
L21:    aload 7 
L23:    iload_3 
L24:    invokevirtual [28] 
L27:    new [52] 
L30:    dup 
L31:    invokespecial [49] 
L34:    astore 8 
L36:    aload 8 
L38:    iload 4 
L40:    invokevirtual [29] 
L43:    aload 8 
L45:    iload 5 
L47:    invokevirtual [30] 
L50:    aload 8 
L52:    iload 6 
L54:    invokevirtual [31] 
L57:    aload_0 
L58:    aload 7 
L60:    aload 8 
L62:    invokevirtual [32] 
L65:    return 
L66:    nop 
L67:    nop 
L68:    
    .end code 
.end method 

.method public [251] : [252] 
    .attribute [240] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [33] 
L4:     ldc [6] 
L6:     ldc [7] 
L8:     invokevirtual [34] 
L11:    pop 
L12:    aload_0 
L13:    getfield [23] 
L16:    bipush 32 
L18:    invokevirtual [35] 
L21:    astore_3 
L22:    aload_3 
L23:    invokevirtual [36] 
L26:    checkcast [8] 
L29:    iconst_3 
L30:    aload_1 
L31:    aload_2 
L32:    invokevirtual [37] 
L35:    return 
L36:    
    .end code 
.end method 

.method public [253] : [254] 
    .attribute [240] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [33] 
L4:     ldc [9] 
L6:     ldc [10] 
L8:     aload_1 
L9:     invokevirtual [38] 
L12:    pop 
L13:    aload_0 
L14:    invokevirtual [39] 
L17:    ifeq L77 
L20:    new [53] 
L23:    dup 
L24:    invokespecial [50] 
L27:    astore_2 
L28:    aload_2 
L29:    aload_1 
L30:    invokevirtual [40] 
L33:    invokevirtual [41] 
L36:    putfield [54] 
L39:    aload_2 
L40:    aload_1 
L41:    invokevirtual [42] 
L44:    invokevirtual [41] 
L47:    putfield [55] 
L50:    aload_2 
L51:    getfield [43] 
L54:    aload_1 
L55:    invokevirtual [44] 
L58:    putfield [56] 
L61:    aload_0 
L62:    getfield [23] 
L65:    bipush 52 
L67:    invokevirtual [45] 
L70:    aload_2 
L71:    invokevirtual [46] 
L74:    goto L89 
L77:    aload_0 
L78:    getfield [33] 
L81:    ldc [9] 
L83:    ldc [12] 
L85:    invokevirtual [34] 
L88:    pop 
L89:    return 
L90:    nop 
L91:    nop 
L92:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [57] 
.const [3] = Class [58] 
.const [4] = Class [59] 
.const [5] = Class [60] 
.const [6] = Int 1078071040 
.const [7] = String [61] 
.const [8] = Class [62] 
.const [9] = Int -2137614336 
.const [10] = String [63] 
.const [11] = Class [64] 
.const [12] = String [65] 
.const [13] = Class [66] 
.const [14] = Class [67] 
.const [15] = Class [68] 
.const [16] = Class [69] 
.const [17] = Class [70] 
.const [18] = Class [71] 
.const [19] = Class [72] 
.const [20] = Class [73] 
.const [21] = Class [74] 
.const [22] = Class [75] 
.const [23] = Field [76] [77] 
.const [24] = Method [78] [79] 
.const [25] = Method [80] [81] 
.const [26] = Method [82] [83] 
.const [27] = Method [84] [85] 
.const [28] = Method [86] [87] 
.const [29] = Method [88] [89] 
.const [30] = Method [90] [91] 
.const [31] = Method [92] [93] 
.const [32] = Method [94] [95] 
.const [33] = Field [96] [97] 
.const [34] = Method [98] [99] 
.const [35] = Method [100] [101] 
.const [36] = Method [102] [103] 
.const [37] = Method [104] [105] 
.const [38] = Method [106] [107] 
.const [39] = Method [108] [109] 
.const [40] = Method [110] [111] 
.const [41] = Method [112] [113] 
.const [42] = Method [114] [115] 
.const [43] = Field [116] [117] 
.const [44] = Method [118] [119] 
.const [45] = Method [120] [121] 
.const [46] = Method [122] [123] 
.const [47] = Method [124] [125] 
.const [48] = Method [126] [127] 
.const [49] = Method [128] [129] 
.const [50] = Method [130] [131] 
.const [51] = Class [132] 
.const [52] = Class [133] 
.const [53] = Class [134] 
.const [54] = Field [135] [136] 
.const [55] = Field [137] [138] 
.const [56] = Field [139] [140] 
.const [57] = Utf8 TerminalMode 
.const [58] = Utf8 de/audi/app/combi/bap/app/audio/CombiModuleAudio 
.const [59] = Utf8 de/audi/atip/interapp/combi/bap/audio/data/CombiBAPAudioSource 
.const [60] = Utf8 de/audi/app/combi/bap/app/audio/CombiBAPAudioListStates 
.const [61] = Utf8 '[AppConnectorTerminalMode#updateSourceListTerminalMode] called (specified sourceTypes)' 
.const [62] = Utf8 de/audi/app/combi/bap/app/audio/list/SourceListHandler 
.const [63] = Utf8 '[AppConnectorTerminalMode#updatePlayPosition] %1' 
.const [64] = Utf8 de/vw/mib/bap/generated/audiosd/serializer/PlayPosition_Status 
.const [65] = Utf8 "[AppConnectorTerminalMode#updatePlayPosition] application not in focus; don't send playPosition" 
.const [66] = Utf8 de/audi/app/combi/bap/app/audio/AppConnectorTerminalMode 
.const [67] = Utf8 de/audi/app/combi/bap/app/audio/AbstractAppConnectorAudio 
.const [68] = Utf8 de/audi/app/combi/bap/app/audio/AudioApplicationInFocusHandler 
.const [69] = Utf8 de/audi/atip/log/LogChannel 
.const [70] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleFSG 
.const [71] = Utf8 de/audi/app/bap/fw/functiontypes/BAPFunctionArrayFSG 
.const [72] = Utf8 de/audi/atip/interapp/combi/bap/audio/data/PlayPosition 
.const [73] = Utf8 de/audi/atip/interapp/bap/data/TimeStamp 
.const [74] = Utf8 de/vw/mib/bap/generated/audiosd/serializer/PlayPosition_Status$Attributes 
.const [75] = Utf8 de/audi/app/bap/fw/functiontypes/BAPFunctionPropertyFSG 
.const [76] = Class [141] 
.const [77] = NameAndType [142] [143] 
.const [78] = Class [144] 
.const [79] = NameAndType [145] [146] 
.const [80] = Class [147] 
.const [81] = NameAndType [148] [149] 
.const [82] = Class [150] 
.const [83] = NameAndType [151] [152] 
.const [84] = Class [153] 
.const [85] = NameAndType [154] [155] 
.const [86] = Class [156] 
.const [87] = NameAndType [157] [158] 
.const [88] = Class [159] 
.const [89] = NameAndType [160] [161] 
.const [90] = Class [162] 
.const [91] = NameAndType [163] [164] 
.const [92] = Class [165] 
.const [93] = NameAndType [166] [167] 
.const [94] = Class [168] 
.const [95] = NameAndType [169] [170] 
.const [96] = Class [171] 
.const [97] = NameAndType [172] [173] 
.const [98] = Class [174] 
.const [99] = NameAndType [175] [176] 
.const [100] = Class [177] 
.const [101] = NameAndType [178] [179] 
.const [102] = Class [180] 
.const [103] = NameAndType [181] [182] 
.const [104] = Class [183] 
.const [105] = NameAndType [184] [185] 
.const [106] = Class [186] 
.const [107] = NameAndType [187] [188] 
.const [108] = Class [189] 
.const [109] = NameAndType [190] [191] 
.const [110] = Class [192] 
.const [111] = NameAndType [193] [194] 
.const [112] = Class [195] 
.const [113] = NameAndType [196] [197] 
.const [114] = Class [198] 
.const [115] = NameAndType [199] [200] 
.const [116] = Class [201] 
.const [117] = NameAndType [202] [203] 
.const [118] = Class [204] 
.const [119] = NameAndType [205] [206] 
.const [120] = Class [207] 
.const [121] = NameAndType [208] [209] 
.const [122] = Class [210] 
.const [123] = NameAndType [211] [212] 
.const [124] = Class [213] 
.const [125] = NameAndType [214] [215] 
.const [126] = Class [216] 
.const [127] = NameAndType [217] [218] 
.const [128] = Class [219] 
.const [129] = NameAndType [220] [221] 
.const [130] = Class [222] 
.const [131] = NameAndType [223] [224] 
.const [132] = Utf8 de/audi/atip/interapp/combi/bap/audio/data/CombiBAPAudioSource 
.const [133] = Utf8 de/audi/app/combi/bap/app/audio/CombiBAPAudioListStates 
.const [134] = Utf8 de/vw/mib/bap/generated/audiosd/serializer/PlayPosition_Status 
.const [135] = Class [225] 
.const [136] = NameAndType [226] [227] 
.const [137] = Class [228] 
.const [138] = NameAndType [229] [230] 
.const [139] = Class [231] 
.const [140] = NameAndType [232] [233] 
.const [141] = Utf8 de/audi/app/combi/bap/app/audio/AppConnectorTerminalMode 
.const [142] = Utf8 moduleFsg 
.const [143] = Utf8 Lde/audi/app/bap/fw/AbstractBAPModuleFSG; 
.const [144] = Utf8 de/audi/app/combi/bap/app/audio/CombiModuleAudio 
.const [145] = Utf8 getAudioApplicationFocusHandler 
.const [146] = Utf8 ()Lde/audi/app/combi/bap/app/audio/AudioApplicationInFocusHandler; 
.const [147] = Utf8 de/audi/app/combi/bap/app/audio/AudioApplicationInFocusHandler 
.const [148] = Utf8 isTerminalModeInFocus 
.const [149] = Utf8 ()Z 
.const [150] = Utf8 de/audi/atip/interapp/combi/bap/audio/data/CombiBAPAudioSource 
.const [151] = Utf8 setSourceType 
.const [152] = Utf8 (I)V 
.const [153] = Utf8 de/audi/atip/interapp/combi/bap/audio/data/CombiBAPAudioSource 
.const [154] = Utf8 setSlotNumber 
.const [155] = Utf8 (I)V 
.const [156] = Utf8 de/audi/atip/interapp/combi/bap/audio/data/CombiBAPAudioSource 
.const [157] = Utf8 setPartitionNumber 
.const [158] = Utf8 (I)V 
.const [159] = Utf8 de/audi/app/combi/bap/app/audio/CombiBAPAudioListStates 
.const [160] = Utf8 setMediaBrowserListAvailable 
.const [161] = Utf8 (Z)V 
.const [162] = Utf8 de/audi/app/combi/bap/app/audio/CombiBAPAudioListStates 
.const [163] = Utf8 setPresetListAvailable 
.const [164] = Utf8 (Z)V 
.const [165] = Utf8 de/audi/app/combi/bap/app/audio/CombiBAPAudioListStates 
.const [166] = Utf8 setListState 
.const [167] = Utf8 (I)V 
.const [168] = Utf8 de/audi/app/combi/bap/app/audio/AppConnectorTerminalMode 
.const [169] = Utf8 updateActiveSource 
.const [170] = Utf8 (Lde/audi/atip/interapp/combi/bap/audio/data/CombiBAPAudioSource;Lde/audi/app/combi/bap/app/audio/CombiBAPAudioListStates;)V 
.const [171] = Utf8 de/audi/app/combi/bap/app/audio/AppConnectorTerminalMode 
.const [172] = Utf8 logChannel 
.const [173] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [174] = Utf8 de/audi/atip/log/LogChannel 
.const [175] = Utf8 log 
.const [176] = Utf8 (ILjava/lang/String;)Z 
.const [177] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleFSG 
.const [178] = Utf8 getBAPFunctionArrayFSG 
.const [179] = Utf8 (I)Lde/audi/app/bap/fw/functiontypes/BAPFunctionArrayFSG; 
.const [180] = Utf8 de/audi/app/bap/fw/functiontypes/BAPFunctionArrayFSG 
.const [181] = Utf8 getArrayHandler 
.const [182] = Utf8 ()Lde/audi/app/bap/fw/arrays/ArrayHandler; 
.const [183] = Utf8 de/audi/app/combi/bap/app/audio/list/SourceListHandler 
.const [184] = Utf8 updateSources 
.const [185] = Utf8 (I[I[[Lde/audi/atip/interapp/combi/bap/audio/data/CombiBAPAudioSource;)V 
.const [186] = Utf8 de/audi/atip/log/LogChannel 
.const [187] = Utf8 log 
.const [188] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [189] = Utf8 de/audi/app/combi/bap/app/audio/AppConnectorTerminalMode 
.const [190] = Utf8 isAudioApplicationInFocus 
.const [191] = Utf8 ()Z 
.const [192] = Utf8 de/audi/atip/interapp/combi/bap/audio/data/PlayPosition 
.const [193] = Utf8 getTimePosition 
.const [194] = Utf8 ()Lde/audi/atip/interapp/bap/data/TimeStamp; 
.const [195] = Utf8 de/audi/atip/interapp/bap/data/TimeStamp 
.const [196] = Utf8 getTimeInSeconds 
.const [197] = Utf8 ()I 
.const [198] = Utf8 de/audi/atip/interapp/combi/bap/audio/data/PlayPosition 
.const [199] = Utf8 getTotalPlayTime 
.const [200] = Utf8 ()Lde/audi/atip/interapp/bap/data/TimeStamp; 
.const [201] = Utf8 de/vw/mib/bap/generated/audiosd/serializer/PlayPosition_Status 
.const [202] = Utf8 attributes 
.const [203] = Utf8 Lde/vw/mib/bap/generated/audiosd/serializer/PlayPosition_Status$Attributes; 
.const [204] = Utf8 de/audi/atip/interapp/combi/bap/audio/data/PlayPosition 
.const [205] = Utf8 isVariableBitRate 
.const [206] = Utf8 ()Z 
.const [207] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleFSG 
.const [208] = Utf8 getBAPFunctionPropertyFSG 
.const [209] = Utf8 (I)Lde/audi/app/bap/fw/functiontypes/BAPFunctionPropertyFSG; 
.const [210] = Utf8 de/audi/app/bap/fw/functiontypes/BAPFunctionPropertyFSG 
.const [211] = Utf8 sendStatusIfChanged 
.const [212] = Utf8 (Lde/vw/mib/bap/requests/StatusProperty;)V 
.const [213] = Utf8 de/audi/app/combi/bap/app/audio/AbstractAppConnectorAudio 
.const [214] = Utf8 <init> 
.const [215] = Utf8 (Lde/audi/app/combi/bap/app/audio/CombiModuleAudio;)V 
.const [216] = Utf8 de/audi/atip/interapp/combi/bap/audio/data/CombiBAPAudioSource 
.const [217] = Utf8 <init> 
.const [218] = Utf8 ()V 
.const [219] = Utf8 de/audi/app/combi/bap/app/audio/CombiBAPAudioListStates 
.const [220] = Utf8 <init> 
.const [221] = Utf8 ()V 
.const [222] = Utf8 de/vw/mib/bap/generated/audiosd/serializer/PlayPosition_Status 
.const [223] = Utf8 <init> 
.const [224] = Utf8 ()V 
.const [225] = Utf8 de/vw/mib/bap/generated/audiosd/serializer/PlayPosition_Status 
.const [226] = Utf8 timePosition 
.const [227] = Utf8 I 
.const [228] = Utf8 de/vw/mib/bap/generated/audiosd/serializer/PlayPosition_Status 
.const [229] = Utf8 totalPlayTime 
.const [230] = Utf8 I 
.const [231] = Utf8 de/vw/mib/bap/generated/audiosd/serializer/PlayPosition_Status$Attributes 
.const [232] = Utf8 variableBitRateActive 
.const [233] = Utf8 Z 
.const [234] = Utf8 de/audi/app/combi/bap/app/audio/AppConnectorTerminalMode 
.const [235] = Class [234] 
.const [236] = Utf8 de/audi/app/combi/bap/app/audio/AbstractAppConnectorAudio 
.const [237] = Class [236] 
.const [238] = Utf8 de/audi/atip/interapp/combi/bap/audio/CombiBAPServiceTerminalMode 
.const [239] = Class [238] 
.const [240] = Utf8 Code 
.const [241] = Utf8 <init> 
.const [242] = Utf8 (Lde/audi/app/combi/bap/app/audio/CombiModuleAudio;)V 
.const [243] = Utf8 getAudioApplication 
.const [244] = Utf8 ()I 
.const [245] = Utf8 getAudioApplicationName 
.const [246] = Utf8 ()Ljava/lang/String; 
.const [247] = Utf8 isAudioApplicationInFocus 
.const [248] = Utf8 ()Z 
.const [249] = Utf8 updateActiveSource 
.const [250] = Utf8 (IIIZZI)V 
.const [251] = Utf8 updateSourceListTerminalMode 
.const [252] = Utf8 ([I[[Lde/audi/atip/interapp/combi/bap/audio/data/CombiBAPAudioSource;)V 
.const [253] = Utf8 updatePlayPosition 
.const [254] = Utf8 (Lde/audi/atip/interapp/combi/bap/audio/data/PlayPosition;)V 
.end class 
