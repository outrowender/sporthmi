.version 50 0 
.class public super [309] 
.super [311] 
.field private volatile [312] [313] 
.field private volatile [314] [315] 
.field private volatile [316] [317] 

.method private static [319] : [320] 
    .attribute [318] .code stack 2 locals 0 
L0:     aload_0 
L1:     ifnull L18 
L4:     aload_0 
L5:     invokeinterface [55] 0 
L10:    iconst_4 
L11:    if_icmpne L18 
L14:    iconst_1 
L15:    goto L19 
L18:    iconst_0 
L19:    areturn 
L20:    
    .end code 
.end method 

.method private static [321] : [322] 
    .attribute [318] .code stack 2 locals 0 
L0:     aload_0 
L1:     ifnull L18 
L4:     aload_0 
L5:     invokeinterface [56] 0 
L10:    iconst_3 
L11:    if_icmpne L18 
L14:    iconst_1 
L15:    goto L19 
L18:    iconst_0 
L19:    areturn 
L20:    
    .end code 
.end method 

.method private static [323] : [324] 
    .attribute [318] .code stack 1 locals 0 
L0:     aload_0 
L1:     ifnull L25 
L4:     aload_0 
L5:     invokeinterface [57] 0 
L10:    ifnull L25 
L13:    aload_0 
L14:    invokeinterface [57] 0 
L19:    invokevirtual [34] 
L22:    goto L27 
L25:    ldc [2] 
L27:    areturn 
L28:    
    .end code 
.end method 

.method private static [325] : [326] 
    .attribute [318] .code stack 2 locals 0 
L0:     aload_0 
L1:     ifnull L72 
L4:     aload_0 
L5:     invokeinterface [58] 0 
L10:    ifnull L72 
L13:    aload_0 
L14:    invokeinterface [58] 0 
L19:    invokevirtual [35] 
L22:    ifne L68 
L25:    aload_0 
L26:    invokeinterface [58] 0 
L31:    invokevirtual [36] 
L34:    ifne L68 
L37:    aload_0 
L38:    invokeinterface [58] 0 
L43:    invokevirtual [37] 
L46:    iconst_3 
L47:    if_icmpeq L68 
L50:    aload_0 
L51:    invokeinterface [58] 0 
L56:    invokevirtual [37] 
L59:    bipush 32 
L61:    if_icmpeq L68 
L64:    iconst_1 
L65:    goto L73 
L68:    iconst_0 
L69:    goto L73 
L72:    iconst_0 
L73:    areturn 
L74:    nop 
L75:    nop 
L76:    
    .end code 
.end method 

.method public [327] : [328] 
    .attribute [318] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     ldc [3] 
L4:     invokespecial [48] 
L7:     aload_0 
L8:     new [59] 
L11:    dup 
L12:    aload_0 
L13:    aload_1 
L14:    invokespecial [49] 
L17:    invokevirtual [38] 
L20:    aload_0 
L21:    new [60] 
L24:    dup 
L25:    aload_0 
L26:    aload_1 
L27:    invokespecial [50] 
L30:    invokevirtual [38] 
L33:    return 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public [329] : [330] 
    .attribute [318] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [51] 
L4:     aload_0 
L5:     invokevirtual [39] 
L8:     invokeinterface [61] 0 
L13:    aload_0 
L14:    invokeinterface [62] 0 
L19:    return 
L20:    
    .end code 
.end method 

.method public [331] : [332] 
    .attribute [318] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [52] 
L4:     aload_0 
L5:     invokevirtual [39] 
L8:     invokeinterface [61] 0 
L13:    aload_0 
L14:    invokeinterface [63] 0 
L19:    return 
L20:    
    .end code 
.end method 

.method public [333] : [334] 
    .attribute [318] .code stack 2 locals 0 
L0:     iload_1 
L1:     ldc [6] 
L3:     if_icmpeq L24 
L6:     iload_1 
L7:     ldc [7] 
L9:     if_icmpeq L24 
L12:    iload_1 
L13:    ldc [8] 
L15:    if_icmpeq L24 
L18:    iload_1 
L19:    ldc [9] 
L21:    if_icmpne L29 
L24:    aload_0 
L25:    aload_2 
L26:    invokespecial [53] 
L29:    return 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method private [335] : [336] 
    .attribute [318] .code stack 4 locals 5 
L0:     aload_1 
L1:     ifnull L13 
L4:     aload_1 
L5:     invokeinterface [64] 0 
L10:    goto L14 
L13:    aconst_null 
L14:    astore_2 
L15:    aload_1 
L16:    ifnull L28 
L19:    aload_1 
L20:    invokeinterface [65] 0 
L25:    goto L29 
L28:    aconst_null 
L29:    astore_3 
L30:    aload_2 
L31:    invokestatic [10] 
L34:    astore 4 
L36:    aload_0 
L37:    getfield [40] 
L40:    ifnull L71 
L43:    ldc [2] 
L45:    aload_0 
L46:    getfield [40] 
L49:    invokevirtual [41] 
L52:    ifne L71 
L55:    aload_0 
L56:    getfield [40] 
L59:    aload 4 
L61:    invokevirtual [41] 
L64:    ifeq L71 
L67:    iconst_1 
L68:    goto L72 
L71:    iconst_0 
L72:    istore 5 
L74:    aload_0 
L75:    aload_3 
L76:    invokestatic [11] 
L79:    ifeq L103 
L82:    aload_3 
L83:    invokestatic [12] 
L86:    ifeq L103 
L89:    aload_3 
L90:    invokestatic [13] 
L93:    ifeq L103 
L96:    aload_3 
L97:    invokestatic [10] 
L100:   goto L105 
L103:   ldc [2] 
L105:   putfield [66] 
L108:   iload 5 
L110:   ifeq L175 
L113:   aload_2 
L114:   invokestatic [12] 
L117:   ifeq L175 
L120:   aload_2 
L121:   invokestatic [13] 
L124:   ifeq L175 
L127:   aload_0 
L128:   aload 4 
L130:   putfield [67] 
L133:   aload_1 
L134:   invokeinterface [68] 0 
L139:   ifne L163 
L142:   aload_0 
L143:   getfield [43] 
L146:   ldc [14] 
L148:   ldc [15] 
L150:   aload 4 
L152:   invokevirtual [44] 
L155:   pop 
L156:   aload_0 
L157:   invokespecial [54] 
L160:   goto L175 
L163:   aload_0 
L164:   getfield [43] 
L167:   ldc [14] 
L169:   ldc [16] 
L171:   invokevirtual [45] 
L174:   pop 
L175:   aload_0 
L176:   getfield [46] 
L179:   ifeq L288 
L182:   aload_2 
L183:   ifnull L207 
L186:   aload_2 
L187:   invokeinterface [58] 0 
L192:   ifnull L207 
L195:   aload_2 
L196:   invokeinterface [58] 0 
L201:   invokevirtual [37] 
L204:   goto L208 
L207:   iconst_0 
L208:   istore 6 
L210:   iload 6 
L212:   ifeq L221 
L215:   iload 6 
L217:   iconst_3 
L218:   if_icmpne L237 
L221:   aload_0 
L222:   getfield [43] 
L225:   ldc [14] 
L227:   ldc [17] 
L229:   invokevirtual [45] 
L232:   pop 
L233:   aload_0 
L234:   invokespecial [47] 
L237:   aload_0 
L238:   getfield [42] 
L241:   ifnull L288 
L244:   aload_0 
L245:   getfield [42] 
L248:   aload 4 
L250:   invokevirtual [41] 
L253:   ifeq L288 
L256:   aload_2 
L257:   invokestatic [11] 
L260:   ifeq L288 
L263:   aload_2 
L264:   invokestatic [13] 
L267:   ifne L288 
L270:   aload_0 
L271:   getfield [43] 
L274:   ldc [14] 
L276:   ldc [18] 
L278:   aload 4 
L280:   invokevirtual [44] 
L283:   pop 
L284:   aload_0 
L285:   invokespecial [47] 
L288:   return 
L289:   nop 
L290:   nop 
L291:   nop 
L292:   
    .end code 
.end method 

.method private [337] : [338] 
    .attribute [318] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [43] 
L4:     ldc [14] 
L6:     ldc [19] 
L8:     invokevirtual [45] 
L11:    pop 
L12:    aload_0 
L13:    invokevirtual [39] 
L16:    invokeinterface [70] 0 
L21:    invokeinterface [71] 0 
L26:    iconst_0 
L27:    ldc [20] 
L29:    invokeinterface [72] 0 
L34:    aload_0 
L35:    iconst_1 
L36:    putfield [69] 
L39:    return 
L40:    
    .end code 
.end method 

.method private [339] : [340] 
    .attribute [318] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [43] 
L4:     ldc [14] 
L6:     ldc [21] 
L8:     invokevirtual [45] 
L11:    pop 
L12:    aload_0 
L13:    invokevirtual [39] 
L16:    invokeinterface [70] 0 
L21:    invokeinterface [71] 0 
L26:    iconst_0 
L27:    ldc [20] 
L29:    invokeinterface [73] 0 
L34:    aload_0 
L35:    iconst_0 
L36:    putfield [69] 
L39:    return 
L40:    
    .end code 
.end method 

.method static synthetic [341] : [342] 
    .attribute [318] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [47] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [74] 
.const [3] = String [75] 
.const [4] = Class [76] 
.const [5] = Class [77] 
.const [6] = Int 134218240 
.const [7] = Int 134217984 
.const [8] = Int 234881280 
.const [9] = Int 234881536 
.const [10] = Method [78] [79] 
.const [11] = Method [80] [81] 
.const [12] = Method [82] [83] 
.const [13] = Method [84] [85] 
.const [14] = Int 1078071040 
.const [15] = String [86] 
.const [16] = String [87] 
.const [17] = String [88] 
.const [18] = String [89] 
.const [19] = String [90] 
.const [20] = Int 697631744 
.const [21] = String [91] 
.const [22] = Class [92] 
.const [23] = Class [93] 
.const [24] = Class [94] 
.const [25] = Class [95] 
.const [26] = Class [96] 
.const [27] = Class [97] 
.const [28] = Class [98] 
.const [29] = Class [99] 
.const [30] = Class [100] 
.const [31] = Class [101] 
.const [32] = Class [102] 
.const [33] = Class [103] 
.const [34] = Method [104] [105] 
.const [35] = Method [106] [107] 
.const [36] = Method [108] [109] 
.const [37] = Method [110] [111] 
.const [38] = Method [112] [113] 
.const [39] = Method [114] [115] 
.const [40] = Field [116] [117] 
.const [41] = Method [118] [119] 
.const [42] = Field [120] [121] 
.const [43] = Field [122] [123] 
.const [44] = Method [124] [125] 
.const [45] = Method [126] [127] 
.const [46] = Field [128] [129] 
.const [47] = Method [130] [131] 
.const [48] = Method [132] [133] 
.const [49] = Method [134] [135] 
.const [50] = Method [136] [137] 
.const [51] = Method [138] [139] 
.const [52] = Method [140] [141] 
.const [53] = Method [142] [143] 
.const [54] = Method [144] [145] 
.const [55] = InterfaceMethod [146] [147] 
.const [56] = InterfaceMethod [148] [149] 
.const [57] = InterfaceMethod [150] [151] 
.const [58] = InterfaceMethod [152] [153] 
.const [59] = Class [154] 
.const [60] = Class [155] 
.const [61] = InterfaceMethod [156] [157] 
.const [62] = InterfaceMethod [158] [159] 
.const [63] = InterfaceMethod [160] [161] 
.const [64] = InterfaceMethod [162] [163] 
.const [65] = InterfaceMethod [164] [165] 
.const [66] = Field [166] [167] 
.const [67] = Field [168] [169] 
.const [68] = InterfaceMethod [170] [171] 
.const [69] = Field [172] [173] 
.const [70] = InterfaceMethod [174] [175] 
.const [71] = InterfaceMethod [176] [177] 
.const [72] = InterfaceMethod [178] [179] 
.const [73] = InterfaceMethod [180] [181] 
.const [74] = Utf8 '' 
.const [75] = Utf8 'App.Phone.Main' 
.const [76] = Utf8 de/audi/app/phone/evo/audio/TelEvoAudioTransferPopupHandler$TransferAudioToMUButtonListener 
.const [77] = Utf8 de/audi/app/phone/evo/audio/TelEvoAudioTransferPopupHandler$KeepAudioOnMEButtonListener 
.const [78] = Class [182] 
.const [79] = NameAndType [183] [184] 
.const [80] = Class [185] 
.const [81] = NameAndType [186] [187] 
.const [82] = Class [188] 
.const [83] = NameAndType [189] [190] 
.const [84] = Class [191] 
.const [85] = NameAndType [192] [193] 
.const [86] = Utf8 '[TelEvoAudioTransferPopupHandler#checkShowPopup] showing TEL_POPUP_AUDIO for device %1' 
.const [87] = Utf8 '[TelEvoAudioTransferPopupHandler#checkShowPopup] accepting call on nonCallLeadingDevice is pending, not showing popup.' 
.const [88] = Utf8 '[TelEvoAudioTransferPopupHandler#checkShowPopup] call state is idle or disconnecting - removing popup!' 
.const [89] = Utf8 '[TelEvoAudioTransferPopupHandler#checkShowPopup] HandsfreeMode is no longer HANDSFREE_PRIVATE_HFP for device %1 - removing popup.' 
.const [90] = Utf8 '[TelEvoAudioTransferPopupHandler#showTelPopupAudio] showing TEL_POPUP_AUDIO' 
.const [91] = Utf8 '[TelEvoAudioTransferPopupHandler#removeTelPopupAudio] removing TEL_POPUP_AUDIO' 
.const [92] = Utf8 de/audi/app/phone/evo/audio/TelEvoAudioTransferPopupHandler 
.const [93] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [94] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [95] = Utf8 org/dsi/ifc/telephoneng/PhoneInformation 
.const [96] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [97] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [98] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneState 
.const [99] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [100] = Utf8 java/lang/String 
.const [101] = Utf8 de/audi/atip/log/LogChannel 
.const [102] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [103] = Utf8 de/audi/atip/hmi/HMIService 
.const [104] = Class [194] 
.const [105] = NameAndType [195] [196] 
.const [106] = Class [197] 
.const [107] = NameAndType [198] [199] 
.const [108] = Class [200] 
.const [109] = NameAndType [201] [202] 
.const [110] = Class [203] 
.const [111] = NameAndType [204] [205] 
.const [112] = Class [206] 
.const [113] = NameAndType [207] [208] 
.const [114] = Class [209] 
.const [115] = NameAndType [210] [211] 
.const [116] = Class [212] 
.const [117] = NameAndType [213] [214] 
.const [118] = Class [215] 
.const [119] = NameAndType [216] [217] 
.const [120] = Class [218] 
.const [121] = NameAndType [219] [220] 
.const [122] = Class [221] 
.const [123] = NameAndType [222] [223] 
.const [124] = Class [224] 
.const [125] = NameAndType [225] [226] 
.const [126] = Class [227] 
.const [127] = NameAndType [228] [229] 
.const [128] = Class [230] 
.const [129] = NameAndType [231] [232] 
.const [130] = Class [233] 
.const [131] = NameAndType [234] [235] 
.const [132] = Class [236] 
.const [133] = NameAndType [237] [238] 
.const [134] = Class [239] 
.const [135] = NameAndType [240] [241] 
.const [136] = Class [242] 
.const [137] = NameAndType [243] [244] 
.const [138] = Class [245] 
.const [139] = NameAndType [246] [247] 
.const [140] = Class [248] 
.const [141] = NameAndType [249] [250] 
.const [142] = Class [251] 
.const [143] = NameAndType [252] [253] 
.const [144] = Class [254] 
.const [145] = NameAndType [255] [256] 
.const [146] = Class [257] 
.const [147] = NameAndType [258] [259] 
.const [148] = Class [260] 
.const [149] = NameAndType [261] [262] 
.const [150] = Class [263] 
.const [151] = NameAndType [264] [265] 
.const [152] = Class [266] 
.const [153] = NameAndType [267] [268] 
.const [154] = Utf8 de/audi/app/phone/evo/audio/TelEvoAudioTransferPopupHandler$TransferAudioToMUButtonListener 
.const [155] = Utf8 de/audi/app/phone/evo/audio/TelEvoAudioTransferPopupHandler$KeepAudioOnMEButtonListener 
.const [156] = Class [269] 
.const [157] = NameAndType [270] [271] 
.const [158] = Class [272] 
.const [159] = NameAndType [273] [274] 
.const [160] = Class [275] 
.const [161] = NameAndType [276] [277] 
.const [162] = Class [278] 
.const [163] = NameAndType [279] [280] 
.const [164] = Class [281] 
.const [165] = NameAndType [282] [283] 
.const [166] = Class [284] 
.const [167] = NameAndType [285] [286] 
.const [168] = Class [287] 
.const [169] = NameAndType [288] [289] 
.const [170] = Class [290] 
.const [171] = NameAndType [291] [292] 
.const [172] = Class [293] 
.const [173] = NameAndType [294] [295] 
.const [174] = Class [296] 
.const [175] = NameAndType [297] [298] 
.const [176] = Class [299] 
.const [177] = NameAndType [300] [301] 
.const [178] = Class [302] 
.const [179] = NameAndType [303] [304] 
.const [180] = Class [305] 
.const [181] = NameAndType [306] [307] 
.const [182] = Utf8 de/audi/app/phone/evo/audio/TelEvoAudioTransferPopupHandler 
.const [183] = Utf8 getBtMacAddress 
.const [184] = Utf8 (Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState;)Ljava/lang/String; 
.const [185] = Utf8 de/audi/app/phone/evo/audio/TelEvoAudioTransferPopupHandler 
.const [186] = Utf8 isHFP 
.const [187] = Utf8 (Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState;)Z 
.const [188] = Utf8 de/audi/app/phone/evo/audio/TelEvoAudioTransferPopupHandler 
.const [189] = Utf8 isCallPresent 
.const [190] = Utf8 (Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState;)Z 
.const [191] = Utf8 de/audi/app/phone/evo/audio/TelEvoAudioTransferPopupHandler 
.const [192] = Utf8 isHandsfreeModePrivateHFP 
.const [193] = Utf8 (Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState;)Z 
.const [194] = Utf8 org/dsi/ifc/telephoneng/PhoneInformation 
.const [195] = Utf8 getMeBtAddress 
.const [196] = Utf8 ()Ljava/lang/String; 
.const [197] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [198] = Utf8 isHasIncomingCall 
.const [199] = Utf8 ()Z 
.const [200] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [201] = Utf8 isIdle 
.const [202] = Utf8 ()Z 
.const [203] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [204] = Utf8 getMpCallState 
.const [205] = Utf8 ()I 
.const [206] = Utf8 de/audi/app/phone/evo/audio/TelEvoAudioTransferPopupHandler 
.const [207] = Utf8 addSubPhoneComponent 
.const [208] = Utf8 (Lde/audi/app/phone/core/ITelComponent;)V 
.const [209] = Utf8 de/audi/app/phone/evo/audio/TelEvoAudioTransferPopupHandler 
.const [210] = Utf8 getApplication 
.const [211] = Utf8 ()Lde/audi/app/phone/core/ITelApplication; 
.const [212] = Utf8 de/audi/app/phone/evo/audio/TelEvoAudioTransferPopupHandler 
.const [213] = Utf8 nonCallLeadingDeviceBtAddress 
.const [214] = Utf8 Ljava/lang/String; 
.const [215] = Utf8 java/lang/String 
.const [216] = Utf8 equals 
.const [217] = Utf8 (Ljava/lang/Object;)Z 
.const [218] = Utf8 de/audi/app/phone/evo/audio/TelEvoAudioTransferPopupHandler 
.const [219] = Utf8 lastTransferedDeviceBTAddress 
.const [220] = Utf8 Ljava/lang/String; 
.const [221] = Utf8 de/audi/app/phone/evo/audio/TelEvoAudioTransferPopupHandler 
.const [222] = Utf8 log 
.const [223] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [224] = Utf8 de/audi/atip/log/LogChannel 
.const [225] = Utf8 log 
.const [226] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [227] = Utf8 de/audi/atip/log/LogChannel 
.const [228] = Utf8 log 
.const [229] = Utf8 (ILjava/lang/String;)Z 
.const [230] = Utf8 de/audi/app/phone/evo/audio/TelEvoAudioTransferPopupHandler 
.const [231] = Utf8 popupShown 
.const [232] = Utf8 Z 
.const [233] = Utf8 de/audi/app/phone/evo/audio/TelEvoAudioTransferPopupHandler 
.const [234] = Utf8 removeTelPopupAudio 
.const [235] = Utf8 ()V 
.const [236] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [237] = Utf8 <init> 
.const [238] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Ljava/lang/String;)V 
.const [239] = Utf8 de/audi/app/phone/evo/audio/TelEvoAudioTransferPopupHandler$TransferAudioToMUButtonListener 
.const [240] = Utf8 <init> 
.const [241] = Utf8 (Lde/audi/app/phone/evo/audio/TelEvoAudioTransferPopupHandler;Lde/audi/app/phone/core/ITelApplication;)V 
.const [242] = Utf8 de/audi/app/phone/evo/audio/TelEvoAudioTransferPopupHandler$KeepAudioOnMEButtonListener 
.const [243] = Utf8 <init> 
.const [244] = Utf8 (Lde/audi/app/phone/evo/audio/TelEvoAudioTransferPopupHandler;Lde/audi/app/phone/core/ITelApplication;)V 
.const [245] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [246] = Utf8 init 
.const [247] = Utf8 ()V 
.const [248] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [249] = Utf8 deinit 
.const [250] = Utf8 ()V 
.const [251] = Utf8 de/audi/app/phone/evo/audio/TelEvoAudioTransferPopupHandler 
.const [252] = Utf8 checkShowPopup 
.const [253] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)V 
.const [254] = Utf8 de/audi/app/phone/evo/audio/TelEvoAudioTransferPopupHandler 
.const [255] = Utf8 showTelPopupAudio 
.const [256] = Utf8 ()V 
.const [257] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [258] = Utf8 getHandsFreeMode 
.const [259] = Utf8 ()I 
.const [260] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [261] = Utf8 getTelMode 
.const [262] = Utf8 ()I 
.const [263] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [264] = Utf8 getPhoneInformation 
.const [265] = Utf8 ()Lorg/dsi/ifc/telephoneng/PhoneInformation; 
.const [266] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [267] = Utf8 getCallState 
.const [268] = Utf8 ()Lde/audi/app/phone/core/state/CallStateStruct; 
.const [269] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [270] = Utf8 getGlobalTelephoneStateManager 
.const [271] = Utf8 ()Lde/audi/app/phone/core/state/IGlobalTelephoneState; 
.const [272] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneState 
.const [273] = Utf8 registerListener 
.const [274] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateListener;)V 
.const [275] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneState 
.const [276] = Utf8 removeListener 
.const [277] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateListener;)V 
.const [278] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [279] = Utf8 getCallLeadingDevice 
.const [280] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState; 
.const [281] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [282] = Utf8 getNonCallLeadingDevice 
.const [283] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState; 
.const [284] = Utf8 de/audi/app/phone/evo/audio/TelEvoAudioTransferPopupHandler 
.const [285] = Utf8 nonCallLeadingDeviceBtAddress 
.const [286] = Utf8 Ljava/lang/String; 
.const [287] = Utf8 de/audi/app/phone/evo/audio/TelEvoAudioTransferPopupHandler 
.const [288] = Utf8 lastTransferedDeviceBTAddress 
.const [289] = Utf8 Ljava/lang/String; 
.const [290] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [291] = Utf8 isAcceptIncomingCallOnNonCallLeadingDevicePending 
.const [292] = Utf8 ()Z 
.const [293] = Utf8 de/audi/app/phone/evo/audio/TelEvoAudioTransferPopupHandler 
.const [294] = Utf8 popupShown 
.const [295] = Utf8 Z 
.const [296] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [297] = Utf8 getFrameworkAccess 
.const [298] = Utf8 ()Lde/audi/atip/base/IFrameworkAccess; 
.const [299] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [300] = Utf8 getHMIService 
.const [301] = Utf8 ()Lde/audi/atip/hmi/HMIService; 
.const [302] = Utf8 de/audi/atip/hmi/HMIService 
.const [303] = Utf8 showPartialPopup 
.const [304] = Utf8 (II)V 
.const [305] = Utf8 de/audi/atip/hmi/HMIService 
.const [306] = Utf8 removePartialPopup 
.const [307] = Utf8 (II)V 
.const [308] = Utf8 de/audi/app/phone/evo/audio/TelEvoAudioTransferPopupHandler 
.const [309] = Class [308] 
.const [310] = Utf8 de/audi/app/phone/core/AbstractPhoneComponent 
.const [311] = Class [310] 
.const [312] = Utf8 popupShown 
.const [313] = Utf8 Z 
.const [314] = Utf8 nonCallLeadingDeviceBtAddress 
.const [315] = Utf8 Ljava/lang/String; 
.const [316] = Utf8 lastTransferedDeviceBTAddress 
.const [317] = Utf8 Ljava/lang/String; 
.const [318] = Utf8 Code 
.const [319] = Utf8 isHandsfreeModePrivateHFP 
.const [320] = Utf8 (Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState;)Z 
.const [321] = Utf8 isHFP 
.const [322] = Utf8 (Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState;)Z 
.const [323] = Utf8 getBtMacAddress 
.const [324] = Utf8 (Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState;)Ljava/lang/String; 
.const [325] = Utf8 isCallPresent 
.const [326] = Utf8 (Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState;)Z 
.const [327] = Utf8 <init> 
.const [328] = Utf8 (Lde/audi/app/phone/core/ITelApplication;)V 
.const [329] = Utf8 init 
.const [330] = Utf8 ()V 
.const [331] = Utf8 deinit 
.const [332] = Utf8 ()V 
.const [333] = Utf8 updateGlobalTelephoneStateProperty 
.const [334] = Utf8 (ILde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)V 
.const [335] = Utf8 checkShowPopup 
.const [336] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)V 
.const [337] = Utf8 showTelPopupAudio 
.const [338] = Utf8 ()V 
.const [339] = Utf8 removeTelPopupAudio 
.const [340] = Utf8 ()V 
.const [341] = Utf8 access$000 
.const [342] = Utf8 (Lde/audi/app/phone/evo/audio/TelEvoAudioTransferPopupHandler;)V 
.end class 
