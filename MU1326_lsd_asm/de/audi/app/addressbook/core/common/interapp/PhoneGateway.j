.version 50 0 
.class public super [211] 
.super [213] 
.field private [214] [215] 
.field private volatile [216] [217] 
.field private volatile [218] [219] 
.field private volatile [220] [221] 
.field private [222] [223] 

.method public [225] : [226] 
    .attribute [224] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [39] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [40] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [41] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [227] : [228] 
    .attribute [224] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [29] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     aload_1 
L9:     invokevirtual [31] 
L12:    pop 
L13:    aload_0 
L14:    aload_1 
L15:    putfield [42] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [229] : [230] 
    .attribute [224] .code stack 2 locals 0 
L0:     aload_0 
L1:     aconst_null 
L2:     putfield [42] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [231] : [232] 
    .attribute [224] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [29] 
L4:     ldc [2] 
L6:     ldc [4] 
L8:     aload_1 
L9:     invokevirtual [31] 
L12:    pop 
L13:    aload_0 
L14:    aload_1 
L15:    putfield [43] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [233] : [234] 
    .attribute [224] .code stack 2 locals 0 
L0:     aload_0 
L1:     aconst_null 
L2:     putfield [43] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [235] : [236] 
    .attribute [224] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [29] 
L4:     ldc [2] 
L6:     ldc [5] 
L8:     aload_1 
L9:     invokevirtual [31] 
L12:    pop 
L13:    aload_0 
L14:    aload_1 
L15:    putfield [44] 
L18:    return 
L19:    nop 
L20:    
    .end code 
.end method 

.method public [237] : [238] 
    .attribute [224] .code stack 2 locals 0 
L0:     aload_0 
L1:     aconst_null 
L2:     putfield [44] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [239] : [240] 
    .attribute [224] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [30] 
L4:     invokeinterface [45] 0 
L9:     invokeinterface [46] 0 
L14:    sipush 186 
L17:    invokeinterface [47] 0 
L22:    invokeinterface [48] 0 
L27:    iconst_1 
L28:    if_icmpne L42 
L31:    aload_0 
L32:    getfield [32] 
L35:    ifnull L42 
L38:    iconst_1 
L39:    goto L43 
L42:    iconst_0 
L43:    areturn 
L44:    
    .end code 
.end method 

.method public [241] : [242] 
    .attribute [224] .code stack 12 locals 1 
L0:     aload_0 
L1:     getfield [32] 
L4:     astore 11 
L6:     aload 11 
L8:     ifnonnull L25 
L11:    aload_0 
L12:    getfield [29] 
L15:    sipush 10000 
L18:    ldc [6] 
L20:    invokevirtual [35] 
L23:    pop 
L24:    return 
L25:    aload_0 
L26:    getfield [29] 
L29:    ldc [7] 
L31:    ldc [8] 
L33:    aload_1 
L34:    aload_2 
L35:    lload 5 
L37:    invokevirtual [36] 
L40:    aload_0 
L41:    getfield [29] 
L44:    ldc [2] 
L46:    ldc [9] 
L48:    aload 7 
L50:    iload 8 
L52:    i2l 
L53:    invokevirtual [37] 
L56:    pop 
L57:    aload 11 
L59:    aload_1 
L60:    aload_2 
L61:    iload_3 
L62:    i2s 
L63:    iload 4 
L65:    i2s 
L66:    lload 5 
L68:    aload 7 
L70:    iload 8 
L72:    iload 9 
L74:    aconst_null 
L75:    iload 10 
L77:    invokeinterface [49] 0 
L82:    return 
L83:    nop 
L84:    
    .end code 
.end method 

.method public [243] : [244] 
    .attribute [224] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [32] 
L4:     astore_3 
L5:     aload_3 
L6:     ifnonnull L23 
L9:     aload_0 
L10:    getfield [29] 
L13:    sipush 10000 
L16:    ldc [6] 
L18:    invokevirtual [35] 
L21:    pop 
L22:    return 
L23:    aload_0 
L24:    getfield [29] 
L27:    ldc [7] 
L29:    ldc [10] 
L31:    aload_1 
L32:    invokevirtual [31] 
L35:    pop 
L36:    aload_3 
L37:    aload_1 
L38:    aconst_null 
L39:    iload_2 
L40:    invokeinterface [50] 0 
L45:    return 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [245] : [246] 
    .attribute [224] .code stack 11 locals 1 
L0:     aload_0 
L1:     getfield [32] 
L4:     astore 10 
L6:     aload 10 
L8:     ifnonnull L25 
L11:    aload_0 
L12:    getfield [29] 
L15:    sipush 10000 
L18:    ldc [11] 
L20:    invokevirtual [35] 
L23:    pop 
L24:    return 
L25:    aload_0 
L26:    getfield [29] 
L29:    ldc [7] 
L31:    ldc [12] 
L33:    aload_1 
L34:    aload_2 
L35:    lload 5 
L37:    invokevirtual [36] 
L40:    aload_0 
L41:    getfield [29] 
L44:    ldc [2] 
L46:    ldc [13] 
L48:    aload 7 
L50:    iload 8 
L52:    i2l 
L53:    invokevirtual [37] 
L56:    pop 
L57:    aload 10 
L59:    aload_1 
L60:    aload_2 
L61:    iload_3 
L62:    i2s 
L63:    iload 4 
L65:    i2s 
L66:    lload 5 
L68:    aload 7 
L70:    iload 8 
L72:    iload 9 
L74:    aconst_null 
L75:    invokeinterface [51] 0 
L80:    return 
L81:    nop 
L82:    nop 
L83:    nop 
L84:    
    .end code 
.end method 

.method public [247] : [248] 
    .attribute [224] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [32] 
L4:     astore_2 
L5:     aload_2 
L6:     ifnonnull L23 
L9:     aload_0 
L10:    getfield [29] 
L13:    sipush 10000 
L16:    ldc [11] 
L18:    invokevirtual [35] 
L21:    pop 
L22:    return 
L23:    aload_0 
L24:    getfield [29] 
L27:    ldc [7] 
L29:    ldc [14] 
L31:    aload_1 
L32:    invokevirtual [31] 
L35:    pop 
L36:    aload_2 
L37:    aload_1 
L38:    aconst_null 
L39:    invokeinterface [52] 0 
L44:    return 
L45:    nop 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method public [249] : [250] 
    .attribute [224] .code stack 4 locals 1 
L0:     aload_0 
L1:     getfield [33] 
L4:     astore_2 
L5:     aload_2 
L6:     ifnonnull L23 
L9:     aload_0 
L10:    getfield [29] 
L13:    sipush 10000 
L16:    ldc [15] 
L18:    invokevirtual [35] 
L21:    pop 
L22:    return 
L23:    aload_0 
L24:    getfield [29] 
L27:    ldc [7] 
L29:    ldc [16] 
L31:    aload_1 
L32:    invokevirtual [31] 
L35:    pop 
L36:    aload_2 
L37:    aload_1 
L38:    invokeinterface [53] 0 
L43:    return 
L44:    
    .end code 
.end method 

.method public [251] : [252] 
    .attribute [224] .code stack 5 locals 1 
L0:     aload_0 
L1:     getfield [34] 
L4:     astore 5 
L6:     aload 5 
L8:     ifnonnull L25 
L11:    aload_0 
L12:    getfield [29] 
L15:    sipush 10000 
L18:    ldc [17] 
L20:    invokevirtual [35] 
L23:    pop 
L24:    return 
L25:    aload_0 
L26:    getfield [29] 
L29:    ldc [7] 
L31:    ldc [18] 
L33:    aload_3 
L34:    aload_2 
L35:    invokevirtual [38] 
L38:    aload 5 
L40:    aload_1 
L41:    aload_2 
L42:    aload_3 
L43:    iload 4 
L45:    invokeinterface [54] 0 
L50:    return 
L51:    nop 
L52:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [55] 
.const [4] = String [56] 
.const [5] = String [57] 
.const [6] = String [58] 
.const [7] = Int 1078071040 
.const [8] = String [59] 
.const [9] = String [60] 
.const [10] = String [61] 
.const [11] = String [62] 
.const [12] = String [63] 
.const [13] = String [64] 
.const [14] = String [65] 
.const [15] = String [66] 
.const [16] = String [67] 
.const [17] = String [68] 
.const [18] = String [69] 
.const [19] = Class [70] 
.const [20] = Class [71] 
.const [21] = Class [72] 
.const [22] = Class [73] 
.const [23] = Class [74] 
.const [24] = Class [75] 
.const [25] = Class [76] 
.const [26] = Class [77] 
.const [27] = Class [78] 
.const [28] = Class [79] 
.const [29] = Field [80] [81] 
.const [30] = Field [82] [83] 
.const [31] = Method [84] [85] 
.const [32] = Field [86] [87] 
.const [33] = Field [88] [89] 
.const [34] = Field [90] [91] 
.const [35] = Method [92] [93] 
.const [36] = Method [94] [95] 
.const [37] = Method [96] [97] 
.const [38] = Method [98] [99] 
.const [39] = Method [100] [101] 
.const [40] = Field [102] [103] 
.const [41] = Field [104] [105] 
.const [42] = Field [106] [107] 
.const [43] = Field [108] [109] 
.const [44] = Field [110] [111] 
.const [45] = InterfaceMethod [112] [113] 
.const [46] = InterfaceMethod [114] [115] 
.const [47] = InterfaceMethod [116] [117] 
.const [48] = InterfaceMethod [118] [119] 
.const [49] = InterfaceMethod [120] [121] 
.const [50] = InterfaceMethod [122] [123] 
.const [51] = InterfaceMethod [124] [125] 
.const [52] = InterfaceMethod [126] [127] 
.const [53] = InterfaceMethod [128] [129] 
.const [54] = InterfaceMethod [130] [131] 
.const [55] = Utf8 'PhoneGateway#setPhoneService(): phone: %1' 
.const [56] = Utf8 'PhoneGateway#setPhoneAdbService(): phoneAdb: %1' 
.const [57] = Utf8 'PhoneGateway#setPhonePresetService(): phonePresetService: %1' 
.const [58] = Utf8 'PhoneGateway#dialNumber(): phone service not available!' 
.const [59] = Utf8 'PhoneGateway#dialNumber(): name: %1, number: %2, entryId: %3' 
.const [60] = Utf8 'PhoneGateway#dialNumber(): resourceLocator: %1, phoneNumberIndex: %2' 
.const [61] = Utf8 'PhoneGateway#dialNumber(): number: %1' 
.const [62] = Utf8 'PhoneGateway#prepareDialing(): phone service not available!' 
.const [63] = Utf8 'PhoneGateway#prepareDialing(): name: %1, number: %2, entryId: %3' 
.const [64] = Utf8 'PhoneGateway#prepareDialing(): resourceLocator: %1, phoneNumberIndex: %2' 
.const [65] = Utf8 'PhoneGateway#prepareDialing(): number: %1' 
.const [66] = Utf8 'PhoneGateway#addToFavorites(): phoneAdb service not available!' 
.const [67] = Utf8 'PhoneGateway#addToFavorites(): telFavorite=%1' 
.const [68] = Utf8 'PhoneGateway#definePreset(): telPresetService not available!' 
.const [69] = Utf8 'PhoneGateway#definePreset(): name: %1, number: %2' 
.const [70] = Utf8 de/audi/app/addressbook/core/common/interapp/PhoneGateway 
.const [71] = Utf8 java/lang/Object 
.const [72] = Utf8 de/audi/atip/log/LogChannel 
.const [73] = Utf8 de/audi/app/addressbook/core/common/ADBApplication 
.const [74] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [75] = Utf8 de/audi/atip/hmi/HMIService 
.const [76] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [77] = Utf8 de/audi/atip/phone/ITelService 
.const [78] = Utf8 de/audi/atip/interapp/phone/ITelServiceADB 
.const [79] = Utf8 de/audi/atip/interapp/phone/ITelPresetService 
.const [80] = Class [132] 
.const [81] = NameAndType [133] [134] 
.const [82] = Class [135] 
.const [83] = NameAndType [136] [137] 
.const [84] = Class [138] 
.const [85] = NameAndType [139] [140] 
.const [86] = Class [141] 
.const [87] = NameAndType [142] [143] 
.const [88] = Class [144] 
.const [89] = NameAndType [145] [146] 
.const [90] = Class [147] 
.const [91] = NameAndType [148] [149] 
.const [92] = Class [150] 
.const [93] = NameAndType [151] [152] 
.const [94] = Class [153] 
.const [95] = NameAndType [154] [155] 
.const [96] = Class [156] 
.const [97] = NameAndType [157] [158] 
.const [98] = Class [159] 
.const [99] = NameAndType [160] [161] 
.const [100] = Class [162] 
.const [101] = NameAndType [163] [164] 
.const [102] = Class [165] 
.const [103] = NameAndType [166] [167] 
.const [104] = Class [168] 
.const [105] = NameAndType [169] [170] 
.const [106] = Class [171] 
.const [107] = NameAndType [172] [173] 
.const [108] = Class [174] 
.const [109] = NameAndType [175] [176] 
.const [110] = Class [177] 
.const [111] = NameAndType [178] [179] 
.const [112] = Class [180] 
.const [113] = NameAndType [181] [182] 
.const [114] = Class [183] 
.const [115] = NameAndType [184] [185] 
.const [116] = Class [186] 
.const [117] = NameAndType [187] [188] 
.const [118] = Class [189] 
.const [119] = NameAndType [190] [191] 
.const [120] = Class [192] 
.const [121] = NameAndType [193] [194] 
.const [122] = Class [195] 
.const [123] = NameAndType [196] [197] 
.const [124] = Class [198] 
.const [125] = NameAndType [199] [200] 
.const [126] = Class [201] 
.const [127] = NameAndType [202] [203] 
.const [128] = Class [204] 
.const [129] = NameAndType [205] [206] 
.const [130] = Class [207] 
.const [131] = NameAndType [208] [209] 
.const [132] = Utf8 de/audi/app/addressbook/core/common/interapp/PhoneGateway 
.const [133] = Utf8 log 
.const [134] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [135] = Utf8 de/audi/app/addressbook/core/common/interapp/PhoneGateway 
.const [136] = Utf8 appAdr 
.const [137] = Utf8 Lde/audi/app/addressbook/core/common/ADBApplication; 
.const [138] = Utf8 de/audi/atip/log/LogChannel 
.const [139] = Utf8 log 
.const [140] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [141] = Utf8 de/audi/app/addressbook/core/common/interapp/PhoneGateway 
.const [142] = Utf8 phone 
.const [143] = Utf8 Lde/audi/atip/phone/ITelService; 
.const [144] = Utf8 de/audi/app/addressbook/core/common/interapp/PhoneGateway 
.const [145] = Utf8 phoneAdb 
.const [146] = Utf8 Lde/audi/atip/interapp/phone/ITelServiceADB; 
.const [147] = Utf8 de/audi/app/addressbook/core/common/interapp/PhoneGateway 
.const [148] = Utf8 phonePresetService 
.const [149] = Utf8 Lde/audi/atip/interapp/phone/ITelPresetService; 
.const [150] = Utf8 de/audi/atip/log/LogChannel 
.const [151] = Utf8 log 
.const [152] = Utf8 (ILjava/lang/String;)Z 
.const [153] = Utf8 de/audi/atip/log/LogChannel 
.const [154] = Utf8 log 
.const [155] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;J)V 
.const [156] = Utf8 de/audi/atip/log/LogChannel 
.const [157] = Utf8 log 
.const [158] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [159] = Utf8 de/audi/atip/log/LogChannel 
.const [160] = Utf8 log 
.const [161] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [162] = Utf8 java/lang/Object 
.const [163] = Utf8 <init> 
.const [164] = Utf8 ()V 
.const [165] = Utf8 de/audi/app/addressbook/core/common/interapp/PhoneGateway 
.const [166] = Utf8 log 
.const [167] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [168] = Utf8 de/audi/app/addressbook/core/common/interapp/PhoneGateway 
.const [169] = Utf8 appAdr 
.const [170] = Utf8 Lde/audi/app/addressbook/core/common/ADBApplication; 
.const [171] = Utf8 de/audi/app/addressbook/core/common/interapp/PhoneGateway 
.const [172] = Utf8 phone 
.const [173] = Utf8 Lde/audi/atip/phone/ITelService; 
.const [174] = Utf8 de/audi/app/addressbook/core/common/interapp/PhoneGateway 
.const [175] = Utf8 phoneAdb 
.const [176] = Utf8 Lde/audi/atip/interapp/phone/ITelServiceADB; 
.const [177] = Utf8 de/audi/app/addressbook/core/common/interapp/PhoneGateway 
.const [178] = Utf8 phonePresetService 
.const [179] = Utf8 Lde/audi/atip/interapp/phone/ITelPresetService; 
.const [180] = Utf8 de/audi/app/addressbook/core/common/ADBApplication 
.const [181] = Utf8 getFramework 
.const [182] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [183] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [184] = Utf8 getHMIService 
.const [185] = Utf8 ()Lde/audi/atip/hmi/HMIService; 
.const [186] = Utf8 de/audi/atip/hmi/HMIService 
.const [187] = Utf8 getChoiceModel 
.const [188] = Utf8 (I)Lde/audi/atip/hmi/modelaccess/ChoiceModelApp; 
.const [189] = Utf8 de/audi/atip/hmi/modelaccess/ChoiceModelApp 
.const [190] = Utf8 getValue 
.const [191] = Utf8 ()I 
.const [192] = Utf8 de/audi/atip/phone/ITelService 
.const [193] = Utf8 dialNumberFromADBEntry 
.const [194] = Utf8 (Ljava/lang/String;Ljava/lang/String;SSJLorg/dsi/ifc/global/ResourceLocator;IILde/audi/atip/phone/ITelServiceListener;Z)V 
.const [195] = Utf8 de/audi/atip/phone/ITelService 
.const [196] = Utf8 dialNumber 
.const [197] = Utf8 (Ljava/lang/String;Lde/audi/atip/phone/ITelServiceListener;Z)V 
.const [198] = Utf8 de/audi/atip/phone/ITelService 
.const [199] = Utf8 prepareDialing 
.const [200] = Utf8 (Ljava/lang/String;Ljava/lang/String;SSJLorg/dsi/ifc/global/ResourceLocator;IILde/audi/atip/phone/ITelServiceListener;)V 
.const [201] = Utf8 de/audi/atip/phone/ITelService 
.const [202] = Utf8 prepareDialing 
.const [203] = Utf8 (Ljava/lang/String;Lde/audi/atip/phone/ITelServiceListener;)V 
.const [204] = Utf8 de/audi/atip/interapp/phone/ITelServiceADB 
.const [205] = Utf8 addToFavorites 
.const [206] = Utf8 (Lde/audi/atip/interapp/phone/TelFavoriteStruct;)V 
.const [207] = Utf8 de/audi/atip/interapp/phone/ITelPresetService 
.const [208] = Utf8 definePreset 
.const [209] = Utf8 (Lde/audi/atip/preset/DefinitionRequest;Ljava/lang/String;Ljava/lang/String;I)V 
.const [210] = Utf8 de/audi/app/addressbook/core/common/interapp/PhoneGateway 
.const [211] = Class [210] 
.const [212] = Utf8 java/lang/Object 
.const [213] = Class [212] 
.const [214] = Utf8 log 
.const [215] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [216] = Utf8 phone 
.const [217] = Utf8 Lde/audi/atip/phone/ITelService; 
.const [218] = Utf8 phoneAdb 
.const [219] = Utf8 Lde/audi/atip/interapp/phone/ITelServiceADB; 
.const [220] = Utf8 phonePresetService 
.const [221] = Utf8 Lde/audi/atip/interapp/phone/ITelPresetService; 
.const [222] = Utf8 appAdr 
.const [223] = Utf8 Lde/audi/app/addressbook/core/common/ADBApplication; 
.const [224] = Utf8 Code 
.const [225] = Utf8 <init> 
.const [226] = Utf8 (Lde/audi/atip/log/LogChannel;Lde/audi/app/addressbook/core/common/ADBApplication;)V 
.const [227] = Utf8 setPhoneService 
.const [228] = Utf8 (Lde/audi/atip/phone/ITelService;)V 
.const [229] = Utf8 releasePhoneService 
.const [230] = Utf8 ()V 
.const [231] = Utf8 setPhoneAdbService 
.const [232] = Utf8 (Lde/audi/atip/interapp/phone/ITelServiceADB;)V 
.const [233] = Utf8 releasePhoneAdbService 
.const [234] = Utf8 ()V 
.const [235] = Utf8 setPhonePresetService 
.const [236] = Utf8 (Lde/audi/atip/interapp/phone/ITelPresetService;)V 
.const [237] = Utf8 releasePhonePresetService 
.const [238] = Utf8 ()V 
.const [239] = Utf8 isPhoneReady 
.const [240] = Utf8 ()Z 
.const [241] = Utf8 dialNumber 
.const [242] = Utf8 (Ljava/lang/String;Ljava/lang/String;IIJLorg/dsi/ifc/global/ResourceLocator;IIZ)V 
.const [243] = Utf8 dialNumber 
.const [244] = Utf8 (Ljava/lang/String;Z)V 
.const [245] = Utf8 prepareDialing 
.const [246] = Utf8 (Ljava/lang/String;Ljava/lang/String;IIJLorg/dsi/ifc/global/ResourceLocator;II)V 
.const [247] = Utf8 prepareDialing 
.const [248] = Utf8 (Ljava/lang/String;)V 
.const [249] = Utf8 addToFavorites 
.const [250] = Utf8 (Lde/audi/atip/interapp/phone/TelFavoriteStruct;)V 
.const [251] = Utf8 definePreset 
.const [252] = Utf8 (Lde/audi/atip/preset/DefinitionRequest;Ljava/lang/String;Ljava/lang/String;I)V 
.end class 
