.version 50 0 
.class public super [284] 
.super [286] 
.implements [288] 

.method protected annotation [290] : [291] 
    .attribute [289] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [49] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [292] : [293] 
    .attribute [289] .code stack 6 locals 1 
L0:     aload_0 
L1:     getfield [28] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     iload_1 
L9:     iload_2 
L10:    iload_3 
L11:    invokevirtual [29] 
L14:    aload_0 
L15:    invokevirtual [30] 
L18:    astore 4 
L20:    aload 4 
L22:    getfield [31] 
L25:    iload_1 
L26:    ifeq L48 
L29:    aload_0 
L30:    getfield [32] 
L33:    invokevirtual [33] 
L36:    bipush 51 
L38:    invokevirtual [34] 
L41:    ifeq L48 
L44:    iconst_1 
L45:    goto L49 
L48:    iconst_0 
L49:    putfield [53] 
L52:    aload 4 
L54:    getfield [31] 
L57:    iload_2 
L58:    ifeq L80 
L61:    aload_0 
L62:    getfield [32] 
L65:    invokevirtual [33] 
L68:    bipush 52 
L70:    invokevirtual [34] 
L73:    ifeq L80 
L76:    iconst_1 
L77:    goto L81 
L80:    iconst_0 
L81:    putfield [54] 
L84:    aload 4 
L86:    getfield [31] 
L89:    iload_3 
L90:    ifeq L112 
L93:    aload_0 
L94:    getfield [32] 
L97:    invokevirtual [33] 
L100:   bipush 53 
L102:   invokevirtual [34] 
L105:   ifeq L112 
L108:   iconst_1 
L109:   goto L113 
L112:   iconst_0 
L113:   putfield [55] 
L116:   aload_0 
L117:   bipush 16 
L119:   aload 4 
L121:   invokevirtual [35] 
L124:   return 
L125:   nop 
L126:   nop 
L127:   nop 
L128:   
    .end code 
.end method 

.method public [294] : [295] 
    .attribute [289] .code stack 7 locals 1 
L0:     aload_0 
L1:     getfield [28] 
L4:     ldc [2] 
L6:     ldc [4] 
L8:     iload_1 
L9:     i2l 
L10:    iload_2 
L11:    i2l 
L12:    invokevirtual [36] 
L15:    pop 
L16:    new [56] 
L19:    dup 
L20:    invokespecial [50] 
L23:    astore_3 
L24:    aload_3 
L25:    iload_1 
L26:    putfield [57] 
L29:    aload_3 
L30:    iload_2 
L31:    putfield [58] 
L34:    aload_0 
L35:    getfield [32] 
L38:    bipush 51 
L40:    invokevirtual [37] 
L43:    aload_3 
L44:    invokevirtual [38] 
L47:    return 
L48:    
    .end code 
.end method 

.method public [296] : [297] 
    .attribute [289] .code stack 5 locals 1 
L0:     aload_0 
L1:     getfield [28] 
L4:     ldc [2] 
L6:     ldc [6] 
L8:     aload_2 
L9:     arraylength 
L10:    i2l 
L11:    invokevirtual [39] 
L14:    pop 
L15:    aload_0 
L16:    getfield [32] 
L19:    bipush 52 
L21:    invokevirtual [40] 
L24:    invokevirtual [41] 
L27:    astore_3 
L28:    aload_3 
L29:    iload_1 
L30:    aload_2 
L31:    invokeinterface [59] 0 
L36:    return 
L37:    nop 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [298] : [299] 
    .attribute [289] .code stack 5 locals 1 
L0:     aload_0 
L1:     getfield [28] 
L4:     ldc [2] 
L6:     ldc [7] 
L8:     lload_1 
L9:     invokevirtual [39] 
L12:    pop 
L13:    aload_0 
L14:    getfield [32] 
L17:    bipush 52 
L19:    invokevirtual [40] 
L22:    invokevirtual [41] 
L25:    astore 4 
L27:    aload 4 
L29:    checkcast [8] 
L32:    lload_1 
L33:    aload_3 
L34:    invokevirtual [42] 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [300] : [301] 
    .attribute [289] .code stack 5 locals 1 
L0:     aload_0 
L1:     getfield [28] 
L4:     ldc [2] 
L6:     ldc [9] 
L8:     iload_1 
L9:     i2l 
L10:    invokevirtual [39] 
L13:    pop 
L14:    aload_0 
L15:    getfield [32] 
L18:    bipush 52 
L20:    invokevirtual [40] 
L23:    invokevirtual [41] 
L26:    astore_2 
L27:    aload_2 
L28:    checkcast [8] 
L31:    iload_1 
L32:    invokevirtual [43] 
L35:    return 
L36:    
    .end code 
.end method 

.method public [302] : [303] 
    .attribute [289] .code stack 9 locals 2 
L0:     aload_0 
L1:     getfield [28] 
L4:     ldc [2] 
L6:     ldc [10] 
L8:     iload_1 
L9:     i2l 
L10:    iload_2 
L11:    i2l 
L12:    iload_3 
L13:    i2l 
L14:    invokevirtual [44] 
L17:    pop 
L18:    aload_0 
L19:    getfield [32] 
L22:    bipush 53 
L24:    invokevirtual [45] 
L27:    astore 4 
L29:    aload_0 
L30:    getfield [32] 
L33:    bipush 53 
L35:    invokevirtual [46] 
L38:    checkcast [11] 
L41:    astore 5 
L43:    aload 5 
L45:    iload_1 
L46:    putfield [60] 
L49:    aload 5 
L51:    iload_2 
L52:    putfield [61] 
L55:    aload 5 
L57:    aload_0 
L58:    iload_3 
L59:    invokespecial [51] 
L62:    putfield [62] 
L65:    aload 4 
L67:    aload 5 
L69:    invokevirtual [47] 
L72:    return 
L73:    nop 
L74:    nop 
L75:    nop 
L76:    
    .end code 
.end method 

.method private [304] : [305] 
    .attribute [289] .code stack 2 locals 0 
L0:     iload_1 
L1:     iconst_1 
L2:     iadd 
L3:     areturn 
L4:     
    .end code 
.end method 

.method public [306] : [307] 
    .attribute [289] .code stack 7 locals 1 
L0:     aload_0 
L1:     getfield [28] 
L4:     ldc [2] 
L6:     ldc [12] 
L8:     iload_1 
L9:     i2l 
L10:    iload_2 
L11:    i2l 
L12:    invokevirtual [36] 
L15:    pop 
L16:    aload_0 
L17:    getfield [28] 
L20:    ldc [2] 
L22:    ldc [13] 
L24:    iload_3 
L25:    i2l 
L26:    iload 4 
L28:    i2l 
L29:    invokevirtual [36] 
L32:    pop 
L33:    new [63] 
L36:    dup 
L37:    invokespecial [52] 
L40:    astore 5 
L42:    aload 5 
L44:    iload_1 
L45:    putfield [64] 
L48:    iload_2 
L49:    iconst_m1 
L50:    if_icmpne L91 
L53:    iload 4 
L55:    iflt L62 
L58:    iload_3 
L59:    ifgt L73 
L62:    aload 5 
L64:    sipush 255 
L67:    putfield [65] 
L70:    goto L97 
L73:    aload 5 
L75:    iload 4 
L77:    i2f 
L78:    iload_3 
L79:    i2f 
L80:    fdiv 
L81:    ldc [15] 
L83:    fmul 
L84:    f2i 
L85:    putfield [65] 
L88:    goto L97 
L91:    aload 5 
L93:    iload_2 
L94:    putfield [65] 
L97:    aload 5 
L99:    iload_3 
L100:   iconst_m1 
L101:   if_icmpne L109 
L104:   ldc [16] 
L106:   goto L110 
L109:   iload_3 
L110:   putfield [66] 
L113:   aload 5 
L115:   iload 4 
L117:   iconst_m1 
L118:   if_icmpne L126 
L121:   ldc [16] 
L123:   goto L128 
L126:   iload 4 
L128:   putfield [67] 
L131:   aload_0 
L132:   bipush 26 
L134:   aload 5 
L136:   invokevirtual [48] 
L139:   return 
L140:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1078071040 
.const [3] = String [68] 
.const [4] = String [69] 
.const [5] = Class [70] 
.const [6] = String [71] 
.const [7] = String [72] 
.const [8] = Class [73] 
.const [9] = String [74] 
.const [10] = String [75] 
.const [11] = Class [76] 
.const [12] = String [77] 
.const [13] = String [78] 
.const [14] = Class [79] 
.const [15] = Int 51266 
.const [16] = Int -65536 
.const [17] = Class [80] 
.const [18] = Class [81] 
.const [19] = Class [82] 
.const [20] = Class [83] 
.const [21] = Class [84] 
.const [22] = Class [85] 
.const [23] = Class [86] 
.const [24] = Class [87] 
.const [25] = Class [88] 
.const [26] = Class [89] 
.const [27] = Class [90] 
.const [28] = Field [91] [92] 
.const [29] = Method [93] [94] 
.const [30] = Method [95] [96] 
.const [31] = Field [97] [98] 
.const [32] = Field [99] [100] 
.const [33] = Method [101] [102] 
.const [34] = Method [103] [104] 
.const [35] = Method [105] [106] 
.const [36] = Method [107] [108] 
.const [37] = Method [109] [110] 
.const [38] = Method [111] [112] 
.const [39] = Method [113] [114] 
.const [40] = Method [115] [116] 
.const [41] = Method [117] [118] 
.const [42] = Method [119] [120] 
.const [43] = Method [121] [122] 
.const [44] = Method [123] [124] 
.const [45] = Method [125] [126] 
.const [46] = Method [127] [128] 
.const [47] = Method [129] [130] 
.const [48] = Method [131] [132] 
.const [49] = Method [133] [134] 
.const [50] = Method [135] [136] 
.const [51] = Method [137] [138] 
.const [52] = Method [139] [140] 
.const [53] = Field [141] [142] 
.const [54] = Field [143] [144] 
.const [55] = Field [145] [146] 
.const [56] = Class [147] 
.const [57] = Field [148] [149] 
.const [58] = Field [150] [151] 
.const [59] = InterfaceMethod [152] [153] 
.const [60] = Field [154] [155] 
.const [61] = Field [156] [157] 
.const [62] = Field [158] [159] 
.const [63] = Class [160] 
.const [64] = Field [161] [162] 
.const [65] = Field [163] [164] 
.const [66] = Field [165] [166] 
.const [67] = Field [167] [168] 
.const [68] = Utf8 '[AppConnectorAddressBook#updateMobileServiceSupport] pbStateSupported=%1, phonebookSupported=%2, pbSpellerSupported=%3' 
.const [69] = Utf8 '[AppConnectorAddressBook#updatePbState] called (downloadState=%1, numberOfEntries=%2)' 
.const [70] = Utf8 de/vw/mib/bap/generated/telephone/serializer/PbState_Status 
.const [71] = Utf8 '[AppConnectorAddressBook#responsePhonebookListElements] called (entries.length=%1)' 
.const [72] = Utf8 '[AppConnectorAddressBook#responsePhonebookEntryDetails] called (entryID=%1)' 
.const [73] = Utf8 de/audi/app/combi/bap/app/phone/list/PhonebookHandler 
.const [74] = Utf8 '[AppConnectorAddressBook#phonebookChanged] called (numberOfEntries=%1)' 
.const [75] = Utf8 '[AppConnectorAddressBook#pbSpellerResult] called (result=%1, matchingEntries=%2, matchingPos=%3' 
.const [76] = Utf8 de/vw/mib/bap/generated/telephone/serializer/PbSpeller_Result 
.const [77] = Utf8 '[AppConnectorAddressBook#updatePhonebookDownloadProgress] downloadState=%1, progressPhonebookDownload=%2, ...' 
.const [78] = Utf8 '[AppConnectorAddressBook#updatePhonebookDownloadProgress] ... totalPbEntries=%1, currentlyLoadedPbEntries=%2' 
.const [79] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/PhonebookDownloadProgress_Status 
.const [80] = Utf8 de/audi/app/combi/bap/app/phone/AppConnectorAddressBook 
.const [81] = Utf8 de/audi/app/combi/bap/app/phone/AbstractAppConnectorPhone 
.const [82] = Utf8 de/audi/atip/log/LogChannel 
.const [83] = Utf8 de/vw/mib/bap/generated/telephone/serializer/MobileServiceSupport_Status 
.const [84] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleFSG 
.const [85] = Utf8 de/audi/app/bap/fw/AbstractFunctionList 
.const [86] = Utf8 de/vw/mib/bap/generated/telephone/serializer/MobileServiceSupport_Status$FctList 
.const [87] = Utf8 de/audi/app/bap/fw/functiontypes/BAPFunctionPropertyFSG 
.const [88] = Utf8 de/audi/app/bap/fw/functiontypes/BAPFunctionArrayFSG 
.const [89] = Utf8 de/audi/app/bap/fw/arrays/ArrayHandler 
.const [90] = Utf8 de/audi/app/bap/fw/functiontypes/BAPFunctionMethodFSG 
.const [91] = Class [169] 
.const [92] = NameAndType [170] [171] 
.const [93] = Class [172] 
.const [94] = NameAndType [173] [174] 
.const [95] = Class [175] 
.const [96] = NameAndType [176] [177] 
.const [97] = Class [178] 
.const [98] = NameAndType [179] [180] 
.const [99] = Class [181] 
.const [100] = NameAndType [182] [183] 
.const [101] = Class [184] 
.const [102] = NameAndType [185] [186] 
.const [103] = Class [187] 
.const [104] = NameAndType [188] [189] 
.const [105] = Class [190] 
.const [106] = NameAndType [191] [192] 
.const [107] = Class [193] 
.const [108] = NameAndType [194] [195] 
.const [109] = Class [196] 
.const [110] = NameAndType [197] [198] 
.const [111] = Class [199] 
.const [112] = NameAndType [200] [201] 
.const [113] = Class [202] 
.const [114] = NameAndType [203] [204] 
.const [115] = Class [205] 
.const [116] = NameAndType [206] [207] 
.const [117] = Class [208] 
.const [118] = NameAndType [209] [210] 
.const [119] = Class [211] 
.const [120] = NameAndType [212] [213] 
.const [121] = Class [214] 
.const [122] = NameAndType [215] [216] 
.const [123] = Class [217] 
.const [124] = NameAndType [218] [219] 
.const [125] = Class [220] 
.const [126] = NameAndType [221] [222] 
.const [127] = Class [223] 
.const [128] = NameAndType [224] [225] 
.const [129] = Class [226] 
.const [130] = NameAndType [227] [228] 
.const [131] = Class [229] 
.const [132] = NameAndType [230] [231] 
.const [133] = Class [232] 
.const [134] = NameAndType [233] [234] 
.const [135] = Class [235] 
.const [136] = NameAndType [236] [237] 
.const [137] = Class [238] 
.const [138] = NameAndType [239] [240] 
.const [139] = Class [241] 
.const [140] = NameAndType [242] [243] 
.const [141] = Class [244] 
.const [142] = NameAndType [245] [246] 
.const [143] = Class [247] 
.const [144] = NameAndType [248] [249] 
.const [145] = Class [250] 
.const [146] = NameAndType [251] [252] 
.const [147] = Utf8 de/vw/mib/bap/generated/telephone/serializer/PbState_Status 
.const [148] = Class [253] 
.const [149] = NameAndType [254] [255] 
.const [150] = Class [256] 
.const [151] = NameAndType [257] [258] 
.const [152] = Class [259] 
.const [153] = NameAndType [260] [261] 
.const [154] = Class [262] 
.const [155] = NameAndType [263] [264] 
.const [156] = Class [265] 
.const [157] = NameAndType [266] [267] 
.const [158] = Class [268] 
.const [159] = NameAndType [269] [270] 
.const [160] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/PhonebookDownloadProgress_Status 
.const [161] = Class [271] 
.const [162] = NameAndType [272] [273] 
.const [163] = Class [274] 
.const [164] = NameAndType [275] [276] 
.const [165] = Class [277] 
.const [166] = NameAndType [278] [279] 
.const [167] = Class [280] 
.const [168] = NameAndType [281] [282] 
.const [169] = Utf8 de/audi/app/combi/bap/app/phone/AppConnectorAddressBook 
.const [170] = Utf8 logChannel 
.const [171] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [172] = Utf8 de/audi/atip/log/LogChannel 
.const [173] = Utf8 log 
.const [174] = Utf8 (ILjava/lang/String;ZZZ)V 
.const [175] = Utf8 de/audi/app/combi/bap/app/phone/AppConnectorAddressBook 
.const [176] = Utf8 getMobileServiceSupportStatusCopy 
.const [177] = Utf8 ()Lde/vw/mib/bap/generated/telephone/serializer/MobileServiceSupport_Status; 
.const [178] = Utf8 de/vw/mib/bap/generated/telephone/serializer/MobileServiceSupport_Status 
.const [179] = Utf8 fctList 
.const [180] = Utf8 Lde/vw/mib/bap/generated/telephone/serializer/MobileServiceSupport_Status$FctList; 
.const [181] = Utf8 de/audi/app/combi/bap/app/phone/AppConnectorAddressBook 
.const [182] = Utf8 moduleFsg 
.const [183] = Utf8 Lde/audi/app/bap/fw/AbstractBAPModuleFSG; 
.const [184] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleFSG 
.const [185] = Utf8 getFunctionList 
.const [186] = Utf8 ()Lde/audi/app/bap/fw/AbstractFunctionList; 
.const [187] = Utf8 de/audi/app/bap/fw/AbstractFunctionList 
.const [188] = Utf8 isFunctionSupported 
.const [189] = Utf8 (I)Z 
.const [190] = Utf8 de/audi/app/combi/bap/app/phone/AppConnectorAddressBook 
.const [191] = Utf8 sendPropertyStatus 
.const [192] = Utf8 (ILde/vw/mib/bap/requests/StatusProperty;)V 
.const [193] = Utf8 de/audi/atip/log/LogChannel 
.const [194] = Utf8 log 
.const [195] = Utf8 (ILjava/lang/String;JJ)Z 
.const [196] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleFSG 
.const [197] = Utf8 getBAPFunctionPropertyFSG 
.const [198] = Utf8 (I)Lde/audi/app/bap/fw/functiontypes/BAPFunctionPropertyFSG; 
.const [199] = Utf8 de/audi/app/bap/fw/functiontypes/BAPFunctionPropertyFSG 
.const [200] = Utf8 sendStatusIfChanged 
.const [201] = Utf8 (Lde/vw/mib/bap/requests/StatusProperty;)V 
.const [202] = Utf8 de/audi/atip/log/LogChannel 
.const [203] = Utf8 log 
.const [204] = Utf8 (ILjava/lang/String;J)Z 
.const [205] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleFSG 
.const [206] = Utf8 getBAPFunctionArrayFSG 
.const [207] = Utf8 (I)Lde/audi/app/bap/fw/functiontypes/BAPFunctionArrayFSG; 
.const [208] = Utf8 de/audi/app/bap/fw/functiontypes/BAPFunctionArrayFSG 
.const [209] = Utf8 getArrayHandler 
.const [210] = Utf8 ()Lde/audi/app/bap/fw/arrays/ArrayHandler; 
.const [211] = Utf8 de/audi/app/combi/bap/app/phone/list/PhonebookHandler 
.const [212] = Utf8 setEntryDetails 
.const [213] = Utf8 (J[Lde/audi/atip/interapp/combi/bap/phone/data/CombiBAPPhonebookEntryDetails;)V 
.const [214] = Utf8 de/audi/app/combi/bap/app/phone/list/PhonebookHandler 
.const [215] = Utf8 notifyPhonebookChanged 
.const [216] = Utf8 (I)V 
.const [217] = Utf8 de/audi/atip/log/LogChannel 
.const [218] = Utf8 log 
.const [219] = Utf8 (ILjava/lang/String;JJJ)Z 
.const [220] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleFSG 
.const [221] = Utf8 getBAPFunctionMethodFSG 
.const [222] = Utf8 (I)Lde/audi/app/bap/fw/functiontypes/BAPFunctionMethodFSG; 
.const [223] = Utf8 de/audi/app/bap/fw/AbstractBAPModuleFSG 
.const [224] = Utf8 createResultSerializer 
.const [225] = Utf8 (I)Lde/vw/mib/bap/requests/ResultMethod; 
.const [226] = Utf8 de/audi/app/bap/fw/functiontypes/BAPFunctionMethodFSG 
.const [227] = Utf8 resultREQ 
.const [228] = Utf8 (Lde/vw/mib/bap/requests/ResultMethod;)V 
.const [229] = Utf8 de/audi/app/combi/bap/app/phone/AppConnectorAddressBook 
.const [230] = Utf8 sendPhone2PropertyStatus 
.const [231] = Utf8 (ILde/vw/mib/bap/requests/StatusProperty;)V 
.const [232] = Utf8 de/audi/app/combi/bap/app/phone/AbstractAppConnectorPhone 
.const [233] = Utf8 <init> 
.const [234] = Utf8 (Lde/audi/app/combi/bap/app/phone/CombiModulePhone;)V 
.const [235] = Utf8 de/vw/mib/bap/generated/telephone/serializer/PbState_Status 
.const [236] = Utf8 <init> 
.const [237] = Utf8 ()V 
.const [238] = Utf8 de/audi/app/combi/bap/app/phone/AppConnectorAddressBook 
.const [239] = Utf8 convertAdbIndexToPosID 
.const [240] = Utf8 (I)I 
.const [241] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/PhonebookDownloadProgress_Status 
.const [242] = Utf8 <init> 
.const [243] = Utf8 ()V 
.const [244] = Utf8 de/vw/mib/bap/generated/telephone/serializer/MobileServiceSupport_Status$FctList 
.const [245] = Utf8 fctPbStateSupported 
.const [246] = Utf8 Z 
.const [247] = Utf8 de/vw/mib/bap/generated/telephone/serializer/MobileServiceSupport_Status$FctList 
.const [248] = Utf8 fctPhonebookSupported 
.const [249] = Utf8 Z 
.const [250] = Utf8 de/vw/mib/bap/generated/telephone/serializer/MobileServiceSupport_Status$FctList 
.const [251] = Utf8 fctPbSpellerSupported 
.const [252] = Utf8 Z 
.const [253] = Utf8 de/vw/mib/bap/generated/telephone/serializer/PbState_Status 
.const [254] = Utf8 downloadState 
.const [255] = Utf8 I 
.const [256] = Utf8 de/vw/mib/bap/generated/telephone/serializer/PbState_Status 
.const [257] = Utf8 pbEntriesUhv 
.const [258] = Utf8 I 
.const [259] = Utf8 de/audi/app/bap/fw/arrays/ArrayHandler 
.const [260] = Utf8 responseListElements 
.const [261] = Utf8 (I[Lde/audi/atip/interapp/combi/bap/data/CombiBAPArrayElement;)V 
.const [262] = Utf8 de/vw/mib/bap/generated/telephone/serializer/PbSpeller_Result 
.const [263] = Utf8 pbSpeller_Result 
.const [264] = Utf8 I 
.const [265] = Utf8 de/vw/mib/bap/generated/telephone/serializer/PbSpeller_Result 
.const [266] = Utf8 matchingEntries 
.const [267] = Utf8 I 
.const [268] = Utf8 de/vw/mib/bap/generated/telephone/serializer/PbSpeller_Result 
.const [269] = Utf8 pos 
.const [270] = Utf8 I 
.const [271] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/PhonebookDownloadProgress_Status 
.const [272] = Utf8 downloadState 
.const [273] = Utf8 I 
.const [274] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/PhonebookDownloadProgress_Status 
.const [275] = Utf8 progressPhonebookDownload 
.const [276] = Utf8 I 
.const [277] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/PhonebookDownloadProgress_Status 
.const [278] = Utf8 totalPbEntries 
.const [279] = Utf8 I 
.const [280] = Utf8 de/vw/mib/bap/generated/telephone2/serializer/PhonebookDownloadProgress_Status 
.const [281] = Utf8 currentlyLoadedPbEntries 
.const [282] = Utf8 I 
.const [283] = Utf8 de/audi/app/combi/bap/app/phone/AppConnectorAddressBook 
.const [284] = Class [283] 
.const [285] = Utf8 de/audi/app/combi/bap/app/phone/AbstractAppConnectorPhone 
.const [286] = Class [285] 
.const [287] = Utf8 de/audi/atip/interapp/combi/bap/phone/CombiBAPServiceAddressBook 
.const [288] = Class [287] 
.const [289] = Utf8 Code 
.const [290] = Utf8 <init> 
.const [291] = Utf8 (Lde/audi/app/combi/bap/app/phone/CombiModulePhone;)V 
.const [292] = Utf8 updateMobileServiceSupport 
.const [293] = Utf8 (ZZZ)V 
.const [294] = Utf8 updatePbState 
.const [295] = Utf8 (II)V 
.const [296] = Utf8 responsePhonebookListElements 
.const [297] = Utf8 (I[Lde/audi/atip/interapp/combi/bap/phone/data/CombiBAPPhonebookEntry;)V 
.const [298] = Utf8 responsePhonebookEntryDetails 
.const [299] = Utf8 (J[Lde/audi/atip/interapp/combi/bap/phone/data/CombiBAPPhonebookEntryDetails;)V 
.const [300] = Utf8 phonebookChanged 
.const [301] = Utf8 (I)V 
.const [302] = Utf8 pbSpellerResult 
.const [303] = Utf8 (III)V 
.const [304] = Utf8 convertAdbIndexToPosID 
.const [305] = Utf8 (I)I 
.const [306] = Utf8 updatePhonebookDownloadProgress 
.const [307] = Utf8 (IIII)V 
.end class 
