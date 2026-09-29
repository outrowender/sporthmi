.version 50 0 
.class public super abstract [221] 
.super [223] 
.implements [225] 
.field protected [226] [227] 
.field private [228] [229] 
.field private [230] [231] 
.field private [232] [233] 

.method public [235] : [236] 
    .attribute [234] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [39] 
L4:     aload_0 
L5:     new [44] 
L8:     dup 
L9:     invokespecial [40] 
L12:    putfield [45] 
L15:    aload_0 
L16:    aload_1 
L17:    putfield [46] 
L20:    return 
L21:    nop 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [237] : [238] 
    .attribute [234] .code stack 3 locals 3 
L0:     aload_0 
L1:     aload_0 
L2:     getfield [22] 
L5:     putfield [48] 
L8:     aload_0 
L9:     aload_2 
L10:    invokeinterface [49] 0 
L15:    invokestatic [3] 
L18:    putfield [47] 
L21:    aload_0 
L22:    getfield [22] 
L25:    ifeq L39 
L28:    aload_0 
L29:    getfield [23] 
L32:    ifne L39 
L35:    iconst_1 
L36:    goto L40 
L39:    iconst_0 
L40:    istore_3 
L41:    aload_0 
L42:    getfield [22] 
L45:    ifne L59 
L48:    aload_0 
L49:    getfield [23] 
L52:    ifeq L59 
L55:    iconst_1 
L56:    goto L60 
L59:    iconst_0 
L60:    istore 4 
L62:    iload_1 
L63:    ldc [4] 
L65:    if_icmpeq L74 
L68:    iload_1 
L69:    ldc [5] 
L71:    if_icmpne L139 
L74:    aload_0 
L75:    getfield [21] 
L78:    ldc [6] 
L80:    ldc [7] 
L82:    invokevirtual [24] 
L85:    pop 
L86:    aload_2 
L87:    invokeinterface [49] 0 
L92:    ifnull L130 
L95:    aload_2 
L96:    invokeinterface [49] 0 
L101:   invokeinterface [50] 0 
L106:   ifnull L126 
L109:   aload_2 
L110:   invokeinterface [49] 0 
L115:   invokeinterface [50] 0 
L120:   invokevirtual [25] 
L123:   goto L131 
L126:   aconst_null 
L127:   goto L131 
L130:   aconst_null 
L131:   astore 5 
L133:   aload_0 
L134:   aload 5 
L136:   invokevirtual [26] 
L139:   iload_3 
L140:   ifeq L211 
L143:   aload_0 
L144:   getfield [21] 
L147:   ldc [8] 
L149:   ldc [9] 
L151:   invokevirtual [24] 
L154:   pop 
L155:   aload_2 
L156:   invokeinterface [49] 0 
L161:   ifnull L199 
L164:   aload_2 
L165:   invokeinterface [49] 0 
L170:   invokeinterface [50] 0 
L175:   ifnull L195 
L178:   aload_2 
L179:   invokeinterface [49] 0 
L184:   invokeinterface [50] 0 
L189:   invokevirtual [25] 
L192:   goto L200 
L195:   aconst_null 
L196:   goto L200 
L199:   aconst_null 
L200:   astore 5 
L202:   aload_0 
L203:   aload 5 
L205:   invokevirtual [26] 
L208:   goto L239 
L211:   iload 4 
L213:   ifeq L239 
L216:   aload_0 
L217:   getfield [21] 
L220:   ldc [8] 
L222:   ldc [10] 
L224:   invokevirtual [24] 
L227:   pop 
L228:   aload_0 
L229:   getfield [20] 
L232:   invokevirtual [27] 
L235:   aload_0 
L236:   invokevirtual [28] 
L239:   return 
L240:   
    .end code 
.end method 

.method [239] : [240] 
    .attribute [234] .code stack 5 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     invokespecial [41] 
L5:     aload_0 
L6:     getfield [21] 
L9:     ldc [6] 
L11:    ldc [11] 
L13:    aload_0 
L14:    getfield [20] 
L17:    invokevirtual [29] 
L20:    i2l 
L21:    invokevirtual [30] 
L24:    pop 
L25:    aload_0 
L26:    invokespecial [42] 
L29:    ifeq L39 
L32:    aload_0 
L33:    invokevirtual [31] 
L36:    goto L43 
L39:    aload_0 
L40:    invokevirtual [28] 
L43:    return 
L44:    
    .end code 
.end method 

.method private [241] : [242] 
    .attribute [234] .code stack 3 locals 1 
L0:     aload_1 
L1:     ifnonnull L5 
L4:     return 
L5:     aload_1 
L6:     arraylength 
L7:     ifne L17 
L10:    aload_0 
L11:    getfield [20] 
L14:    invokevirtual [27] 
L17:    iconst_0 
L18:    istore_2 
L19:    iload_2 
L20:    aload_1 
L21:    arraylength 
L22:    if_icmpge L38 
L25:    aload_0 
L26:    aload_1 
L27:    iload_2 
L28:    aaload 
L29:    invokespecial [43] 
L32:    iinc 2 1 
L35:    goto L19 
L38:    return 
L39:    nop 
L40:    
    .end code 
.end method 

.method private [243] : [244] 
    .attribute [234] .code stack 2 locals 0 
L0:     aload_1 
L1:     ifnonnull L5 
L4:     return 
L5:     aload_0 
L6:     aload_1 
L7:     invokevirtual [32] 
L10:    ifeq L27 
L13:    aload_0 
L14:    getfield [20] 
L17:    aload_1 
L18:    getfield [33] 
L21:    invokevirtual [34] 
L24:    goto L38 
L27:    aload_0 
L28:    getfield [20] 
L31:    aload_1 
L32:    getfield [33] 
L35:    invokevirtual [35] 
L38:    return 
L39:    nop 
L40:    
    .end code 
.end method 

.method private [245] : [246] 
    .attribute [234] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     iconst_0 
L5:     invokevirtual [36] 
L8:     areturn 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method protected [247] : [248] 
    .attribute [234] .code stack 2 locals 0 
L0:     aload_1 
L1:     getfield [37] 
L4:     iconst_1 
L5:     if_icmpne L21 
L8:     aload_1 
L9:     getfield [38] 
L12:    iconst_1 
L13:    iand 
L14:    ifle L21 
L17:    iconst_1 
L18:    goto L22 
L21:    iconst_0 
L22:    areturn 
L23:    nop 
L24:    
    .end code 
.end method 

.method protected abstract [249] : [250] 
    .attribute [234] .code stack 0 locals 0 
L0:     
    .end code 
.end method 

.method protected abstract [251] : [252] 
    .attribute [234] .code stack 0 locals 0 
L0:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [51] 
.const [3] = Method [52] [53] 
.const [4] = Int 436207872 
.const [5] = Int 436208128 
.const [6] = Int -2137614336 
.const [7] = String [54] 
.const [8] = Int 1078071040 
.const [9] = String [55] 
.const [10] = String [56] 
.const [11] = String [57] 
.const [12] = Class [58] 
.const [13] = Class [59] 
.const [14] = Class [60] 
.const [15] = Class [61] 
.const [16] = Class [62] 
.const [17] = Class [63] 
.const [18] = Class [64] 
.const [19] = Class [65] 
.const [20] = Field [66] [67] 
.const [21] = Field [68] [69] 
.const [22] = Field [70] [71] 
.const [23] = Field [72] [73] 
.const [24] = Method [74] [75] 
.const [25] = Method [76] [77] 
.const [26] = Method [78] [79] 
.const [27] = Method [80] [81] 
.const [28] = Method [82] [83] 
.const [29] = Method [84] [85] 
.const [30] = Method [86] [87] 
.const [31] = Method [88] [89] 
.const [32] = Method [90] [91] 
.const [33] = Field [92] [93] 
.const [34] = Method [94] [95] 
.const [35] = Method [96] [97] 
.const [36] = Method [98] [99] 
.const [37] = Field [100] [101] 
.const [38] = Field [102] [103] 
.const [39] = Method [104] [105] 
.const [40] = Method [106] [107] 
.const [41] = Method [108] [109] 
.const [42] = Method [110] [111] 
.const [43] = Method [112] [113] 
.const [44] = Class [114] 
.const [45] = Field [115] [116] 
.const [46] = Field [117] [118] 
.const [47] = Field [119] [120] 
.const [48] = Field [121] [122] 
.const [49] = InterfaceMethod [123] [124] 
.const [50] = InterfaceMethod [125] [126] 
.const [51] = Utf8 de/audi/app/phone/core/util/BitFieldInt 
.const [52] = Class [127] 
.const [53] = NameAndType [128] [129] 
.const [54] = Utf8 'TelCallForwardingStatusIconHandler#updateGlobalTelephoneStateProperty() received call forwarding status' 
.const [55] = Utf8 'TelCallForwardingStatusIconHandler#updateGlobalTelephoneStateProperty() nad is ready now' 
.const [56] = Utf8 'TelCallForwardingStatusIconHandler#updateGlobalTelephoneStateProperty() nad is not ready anymore' 
.const [57] = Utf8 'TelCallForwardingStatusIconHandler#updateCallForwardingStatusIcon: callForwardingStatusBitField: %1' 
.const [58] = Utf8 de/audi/app/phone/core/suppservices/AbstractTelCallForwardingStatusIconHandler 
.const [59] = Utf8 java/lang/Object 
.const [60] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [61] = Utf8 de/audi/app/phone/core/util/PhoneUtils 
.const [62] = Utf8 de/audi/atip/log/LogChannel 
.const [63] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [64] = Utf8 org/dsi/ifc/telephoneng/SuppServiceResponseStruct 
.const [65] = Utf8 org/dsi/ifc/telephoneng/CFResponseData 
.const [66] = Class [130] 
.const [67] = NameAndType [131] [132] 
.const [68] = Class [133] 
.const [69] = NameAndType [134] [135] 
.const [70] = Class [136] 
.const [71] = NameAndType [137] [138] 
.const [72] = Class [139] 
.const [73] = NameAndType [140] [141] 
.const [74] = Class [142] 
.const [75] = NameAndType [143] [144] 
.const [76] = Class [145] 
.const [77] = NameAndType [146] [147] 
.const [78] = Class [148] 
.const [79] = NameAndType [149] [150] 
.const [80] = Class [151] 
.const [81] = NameAndType [152] [153] 
.const [82] = Class [154] 
.const [83] = NameAndType [155] [156] 
.const [84] = Class [157] 
.const [85] = NameAndType [158] [159] 
.const [86] = Class [160] 
.const [87] = NameAndType [161] [162] 
.const [88] = Class [163] 
.const [89] = NameAndType [164] [165] 
.const [90] = Class [166] 
.const [91] = NameAndType [167] [168] 
.const [92] = Class [169] 
.const [93] = NameAndType [170] [171] 
.const [94] = Class [172] 
.const [95] = NameAndType [173] [174] 
.const [96] = Class [175] 
.const [97] = NameAndType [176] [177] 
.const [98] = Class [178] 
.const [99] = NameAndType [179] [180] 
.const [100] = Class [181] 
.const [101] = NameAndType [182] [183] 
.const [102] = Class [184] 
.const [103] = NameAndType [185] [186] 
.const [104] = Class [187] 
.const [105] = NameAndType [188] [189] 
.const [106] = Class [190] 
.const [107] = NameAndType [191] [192] 
.const [108] = Class [193] 
.const [109] = NameAndType [194] [195] 
.const [110] = Class [196] 
.const [111] = NameAndType [197] [198] 
.const [112] = Class [199] 
.const [113] = NameAndType [200] [201] 
.const [114] = Utf8 de/audi/app/phone/core/util/BitFieldInt 
.const [115] = Class [202] 
.const [116] = NameAndType [203] [204] 
.const [117] = Class [205] 
.const [118] = NameAndType [206] [207] 
.const [119] = Class [208] 
.const [120] = NameAndType [209] [210] 
.const [121] = Class [211] 
.const [122] = NameAndType [212] [213] 
.const [123] = Class [214] 
.const [124] = NameAndType [215] [216] 
.const [125] = Class [217] 
.const [126] = NameAndType [218] [219] 
.const [127] = Utf8 de/audi/app/phone/core/util/PhoneUtils 
.const [128] = Utf8 isOnUnlockedRegistered 
.const [129] = Utf8 (Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState;)Z 
.const [130] = Utf8 de/audi/app/phone/core/suppservices/AbstractTelCallForwardingStatusIconHandler 
.const [131] = Utf8 callForwardingStatusBitField 
.const [132] = Utf8 Lde/audi/app/phone/core/util/BitFieldInt; 
.const [133] = Utf8 de/audi/app/phone/core/suppservices/AbstractTelCallForwardingStatusIconHandler 
.const [134] = Utf8 log 
.const [135] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [136] = Utf8 de/audi/app/phone/core/suppservices/AbstractTelCallForwardingStatusIconHandler 
.const [137] = Utf8 nadActiveUnlockedRegistered 
.const [138] = Utf8 Z 
.const [139] = Utf8 de/audi/app/phone/core/suppservices/AbstractTelCallForwardingStatusIconHandler 
.const [140] = Utf8 nadActiveUnlockedRegisteredOld 
.const [141] = Utf8 Z 
.const [142] = Utf8 de/audi/atip/log/LogChannel 
.const [143] = Utf8 log 
.const [144] = Utf8 (ILjava/lang/String;)Z 
.const [145] = Utf8 org/dsi/ifc/telephoneng/SuppServiceResponseStruct 
.const [146] = Utf8 getTelCFResponseData 
.const [147] = Utf8 ()[Lorg/dsi/ifc/telephoneng/CFResponseData; 
.const [148] = Utf8 de/audi/app/phone/core/suppservices/AbstractTelCallForwardingStatusIconHandler 
.const [149] = Utf8 updateCallForwardingStatusIcon 
.const [150] = Utf8 ([Lorg/dsi/ifc/telephoneng/CFResponseData;)V 
.const [151] = Utf8 de/audi/app/phone/core/util/BitFieldInt 
.const [152] = Utf8 clearAllBits 
.const [153] = Utf8 ()V 
.const [154] = Utf8 de/audi/app/phone/core/suppservices/AbstractTelCallForwardingStatusIconHandler 
.const [155] = Utf8 hideCallForwardingIcon 
.const [156] = Utf8 ()V 
.const [157] = Utf8 de/audi/app/phone/core/util/BitFieldInt 
.const [158] = Utf8 getAllBits 
.const [159] = Utf8 ()I 
.const [160] = Utf8 de/audi/atip/log/LogChannel 
.const [161] = Utf8 log 
.const [162] = Utf8 (ILjava/lang/String;J)Z 
.const [163] = Utf8 de/audi/app/phone/core/suppservices/AbstractTelCallForwardingStatusIconHandler 
.const [164] = Utf8 showCallForwardingIcon 
.const [165] = Utf8 ()V 
.const [166] = Utf8 de/audi/app/phone/core/suppservices/AbstractTelCallForwardingStatusIconHandler 
.const [167] = Utf8 isConsideredActive 
.const [168] = Utf8 (Lorg/dsi/ifc/telephoneng/CFResponseData;)Z 
.const [169] = Utf8 org/dsi/ifc/telephoneng/CFResponseData 
.const [170] = Utf8 telCFCondition 
.const [171] = Utf8 I 
.const [172] = Utf8 de/audi/app/phone/core/util/BitFieldInt 
.const [173] = Utf8 setBit 
.const [174] = Utf8 (I)V 
.const [175] = Utf8 de/audi/app/phone/core/util/BitFieldInt 
.const [176] = Utf8 clearBit 
.const [177] = Utf8 (I)V 
.const [178] = Utf8 de/audi/app/phone/core/util/BitFieldInt 
.const [179] = Utf8 isBitSet 
.const [180] = Utf8 (I)Z 
.const [181] = Utf8 org/dsi/ifc/telephoneng/CFResponseData 
.const [182] = Utf8 telCFStatus 
.const [183] = Utf8 I 
.const [184] = Utf8 org/dsi/ifc/telephoneng/CFResponseData 
.const [185] = Utf8 telClass 
.const [186] = Utf8 S 
.const [187] = Utf8 java/lang/Object 
.const [188] = Utf8 <init> 
.const [189] = Utf8 ()V 
.const [190] = Utf8 de/audi/app/phone/core/util/BitFieldInt 
.const [191] = Utf8 <init> 
.const [192] = Utf8 ()V 
.const [193] = Utf8 de/audi/app/phone/core/suppservices/AbstractTelCallForwardingStatusIconHandler 
.const [194] = Utf8 storeCallForwardingStatus 
.const [195] = Utf8 ([Lorg/dsi/ifc/telephoneng/CFResponseData;)V 
.const [196] = Utf8 de/audi/app/phone/core/suppservices/AbstractTelCallForwardingStatusIconHandler 
.const [197] = Utf8 isCallForwardingActive 
.const [198] = Utf8 ()Z 
.const [199] = Utf8 de/audi/app/phone/core/suppservices/AbstractTelCallForwardingStatusIconHandler 
.const [200] = Utf8 storeCallForwardingStatus 
.const [201] = Utf8 (Lorg/dsi/ifc/telephoneng/CFResponseData;)V 
.const [202] = Utf8 de/audi/app/phone/core/suppservices/AbstractTelCallForwardingStatusIconHandler 
.const [203] = Utf8 callForwardingStatusBitField 
.const [204] = Utf8 Lde/audi/app/phone/core/util/BitFieldInt; 
.const [205] = Utf8 de/audi/app/phone/core/suppservices/AbstractTelCallForwardingStatusIconHandler 
.const [206] = Utf8 log 
.const [207] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [208] = Utf8 de/audi/app/phone/core/suppservices/AbstractTelCallForwardingStatusIconHandler 
.const [209] = Utf8 nadActiveUnlockedRegistered 
.const [210] = Utf8 Z 
.const [211] = Utf8 de/audi/app/phone/core/suppservices/AbstractTelCallForwardingStatusIconHandler 
.const [212] = Utf8 nadActiveUnlockedRegisteredOld 
.const [213] = Utf8 Z 
.const [214] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [215] = Utf8 getNadInstanceState 
.const [216] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState; 
.const [217] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [218] = Utf8 getSuppServiceResponse 
.const [219] = Utf8 ()Lorg/dsi/ifc/telephoneng/SuppServiceResponseStruct; 
.const [220] = Utf8 de/audi/app/phone/core/suppservices/AbstractTelCallForwardingStatusIconHandler 
.const [221] = Class [220] 
.const [222] = Utf8 java/lang/Object 
.const [223] = Class [222] 
.const [224] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateListener 
.const [225] = Class [224] 
.const [226] = Utf8 log 
.const [227] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [228] = Utf8 callForwardingStatusBitField 
.const [229] = Utf8 Lde/audi/app/phone/core/util/BitFieldInt; 
.const [230] = Utf8 nadActiveUnlockedRegistered 
.const [231] = Utf8 Z 
.const [232] = Utf8 nadActiveUnlockedRegisteredOld 
.const [233] = Utf8 Z 
.const [234] = Utf8 Code 
.const [235] = Utf8 <init> 
.const [236] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [237] = Utf8 updateGlobalTelephoneStateProperty 
.const [238] = Utf8 (ILde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)V 
.const [239] = Utf8 updateCallForwardingStatusIcon 
.const [240] = Utf8 ([Lorg/dsi/ifc/telephoneng/CFResponseData;)V 
.const [241] = Utf8 storeCallForwardingStatus 
.const [242] = Utf8 ([Lorg/dsi/ifc/telephoneng/CFResponseData;)V 
.const [243] = Utf8 storeCallForwardingStatus 
.const [244] = Utf8 (Lorg/dsi/ifc/telephoneng/CFResponseData;)V 
.const [245] = Utf8 isCallForwardingActive 
.const [246] = Utf8 ()Z 
.const [247] = Utf8 isConsideredActive 
.const [248] = Utf8 (Lorg/dsi/ifc/telephoneng/CFResponseData;)Z 
.const [249] = Utf8 showCallForwardingIcon 
.const [250] = Utf8 ()V 
.const [251] = Utf8 hideCallForwardingIcon 
.const [252] = Utf8 ()V 
.end class 
