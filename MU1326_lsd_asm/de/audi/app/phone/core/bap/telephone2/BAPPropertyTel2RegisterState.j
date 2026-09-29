.version 50 0 
.class super [193] 
.super [195] 
.field private [196] [197] 
.field private [198] [199] 
.field private [200] [201] 

.method [203] : [204] 
    .attribute [202] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [34] 
L6:     aload_0 
L7:     iconst_m1 
L8:     putfield [35] 
L11:    aload_0 
L12:    iconst_m1 
L13:    putfield [36] 
L16:    aload_0 
L17:    iconst_m1 
L18:    putfield [37] 
L21:    return 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method protected [205] : [206] 
    .attribute [202] .code stack 1 locals 0 
L0:     aload_2 
L1:     ifnull L8 
L4:     iconst_1 
L5:     goto L9 
L8:     iconst_0 
L9:     areturn 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method protected [207] : [208] 
    .attribute [202] .code stack 3 locals 0 
L0:     aload_1 
L1:     ifnull L46 
L4:     aload_1 
L5:     invokeinterface [38] 0 
L10:    ifnull L46 
L13:    aload_1 
L14:    invokeinterface [38] 0 
L19:    invokeinterface [39] 0 
L24:    ifnull L44 
L27:    aload_1 
L28:    invokeinterface [38] 0 
L33:    invokeinterface [39] 0 
L38:    invokevirtual [24] 
L41:    goto L45 
L44:    iconst_0 
L45:    areturn 
L46:    aload_0 
L47:    getfield [25] 
L50:    sipush 10000 
L53:    ldc [2] 
L55:    invokevirtual [26] 
L58:    pop 
L59:    iconst_0 
L60:    areturn 
L61:    nop 
L62:    nop 
L63:    nop 
L64:    
    .end code 
.end method 

.method protected [209] : [210] 
    .attribute [202] .code stack 3 locals 0 
L0:     aload_1 
L1:     ifnull L25 
L4:     aload_1 
L5:     invokeinterface [38] 0 
L10:    ifnull L25 
L13:    aload_1 
L14:    invokeinterface [38] 0 
L19:    invokeinterface [40] 0 
L24:    areturn 
L25:    aload_0 
L26:    getfield [25] 
L29:    sipush 10000 
L32:    ldc [3] 
L34:    invokevirtual [26] 
L37:    pop 
L38:    iconst_0 
L39:    areturn 
L40:    
    .end code 
.end method 

.method protected [211] : [212] 
    .attribute [202] .code stack 7 locals 1 
L0:     aload_0 
L1:     invokevirtual [27] 
L4:     astore 4 
L6:     aload 4 
L8:     ifnull L40 
L11:    aload_0 
L12:    getfield [25] 
L15:    ldc [4] 
L17:    ldc [5] 
L19:    iload_1 
L20:    i2l 
L21:    iload_2 
L22:    i2l 
L23:    invokevirtual [28] 
L26:    pop 
L27:    aload 4 
L29:    iload_1 
L30:    iload_2 
L31:    iload_3 
L32:    invokeinterface [41] 0 
L37:    goto L52 
L40:    aload_0 
L41:    getfield [25] 
L44:    ldc [6] 
L46:    ldc [7] 
L48:    invokevirtual [26] 
L51:    pop 
L52:    return 
L53:    nop 
L54:    nop 
L55:    nop 
L56:    
    .end code 
.end method 

.method protected [213] : [214] 
    .attribute [202] .code stack 1 locals 0 
L0:     aload_1 
L1:     ifnull L13 
L4:     aload_1 
L5:     invokeinterface [40] 0 
L10:    goto L14 
L13:    iconst_0 
L14:    areturn 
L15:    nop 
L16:    
    .end code 
.end method 

.method protected [215] : [216] 
    .attribute [202] .code stack 4 locals 6 
L0:     aload_0 
L1:     invokevirtual [29] 
L4:     astore_1 
L5:     aload_0 
L6:     aload_1 
L7:     invokevirtual [30] 
L10:    invokestatic [8] 
L13:    istore_2 
L14:    aload_0 
L15:    aload_1 
L16:    invokevirtual [31] 
L19:    invokestatic [9] 
L22:    istore_3 
L23:    aload_1 
L24:    ifnull L36 
L27:    aload_1 
L28:    invokeinterface [38] 0 
L33:    goto L37 
L36:    aconst_null 
L37:    astore 4 
L39:    aload_0 
L40:    aload 4 
L42:    invokevirtual [32] 
L45:    istore 5 
L47:    iload 5 
L49:    invokestatic [10] 
L52:    istore 6 
L54:    aload_0 
L55:    getfield [21] 
L58:    iload_2 
L59:    if_icmpne L79 
L62:    aload_0 
L63:    getfield [22] 
L66:    iload_3 
L67:    if_icmpne L79 
L70:    aload_0 
L71:    getfield [23] 
L74:    iload 6 
L76:    if_icmpeq L131 
L79:    aload 4 
L81:    ifnull L131 
L84:    aload 4 
L86:    invokeinterface [42] 0 
L91:    invokestatic [11] 
L94:    ifne L107 
L97:    aload 4 
L99:    invokeinterface [43] 0 
L104:   ifne L131 
L107:   aload_0 
L108:   iload_2 
L109:   iload_3 
L110:   iload 6 
L112:   invokevirtual [33] 
L115:   aload_0 
L116:   iload 6 
L118:   putfield [37] 
L121:   aload_0 
L122:   iload_2 
L123:   putfield [35] 
L126:   aload_0 
L127:   iload_3 
L128:   putfield [36] 
L131:   return 
L132:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [44] 
.const [3] = String [45] 
.const [4] = Int 1078071040 
.const [5] = String [46] 
.const [6] = Int -1601830656 
.const [7] = String [47] 
.const [8] = Method [48] [49] 
.const [9] = Method [50] [51] 
.const [10] = Method [52] [53] 
.const [11] = Method [54] [55] 
.const [12] = Class [56] 
.const [13] = Class [57] 
.const [14] = Class [58] 
.const [15] = Class [59] 
.const [16] = Class [60] 
.const [17] = Class [61] 
.const [18] = Class [62] 
.const [19] = Class [63] 
.const [20] = Class [64] 
.const [21] = Field [65] [66] 
.const [22] = Field [67] [68] 
.const [23] = Field [69] [70] 
.const [24] = Method [71] [72] 
.const [25] = Field [73] [74] 
.const [26] = Method [75] [76] 
.const [27] = Method [77] [78] 
.const [28] = Method [79] [80] 
.const [29] = Method [81] [82] 
.const [30] = Method [83] [84] 
.const [31] = Method [85] [86] 
.const [32] = Method [87] [88] 
.const [33] = Method [89] [90] 
.const [34] = Method [91] [92] 
.const [35] = Field [93] [94] 
.const [36] = Field [95] [96] 
.const [37] = Field [97] [98] 
.const [38] = InterfaceMethod [99] [100] 
.const [39] = InterfaceMethod [101] [102] 
.const [40] = InterfaceMethod [103] [104] 
.const [41] = InterfaceMethod [105] [106] 
.const [42] = InterfaceMethod [107] [108] 
.const [43] = InterfaceMethod [109] [110] 
.const [44] = Utf8 'BAPPropertyTel2RegisterState#getRegisterState stateStruct or NAD instance state is null' 
.const [45] = Utf8 'BAPPropertyTel2RegisterState#getNetworkType stateStruct or NAD instance state is null' 
.const [46] = Utf8 '[BAPPropertyTel2RegisterState#updateRegisterState] updating combi: combiRegisterState=%1, combiNetworkType=%2' 
.const [47] = Utf8 '[BAPPropertyTel2RegisterState#updateRegisterState] CombiBAPServicePhone2 is null --> NOP!' 
.const [48] = Class [111] 
.const [49] = NameAndType [112] [113] 
.const [50] = Class [114] 
.const [51] = NameAndType [115] [116] 
.const [52] = Class [117] 
.const [53] = NameAndType [118] [119] 
.const [54] = Class [120] 
.const [55] = NameAndType [121] [122] 
.const [56] = Utf8 de/audi/app/phone/core/bap/telephone2/BAPPropertyTel2RegisterState 
.const [57] = Utf8 de/audi/app/phone/core/bap/telephone2/AbstractTel2EnqueuedBAPPropertyHandler 
.const [58] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [59] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [60] = Utf8 org/dsi/ifc/telephoneng/RegisterStateStruct 
.const [61] = Utf8 de/audi/atip/log/LogChannel 
.const [62] = Utf8 de/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone2 
.const [63] = Utf8 de/audi/app/phone/core/bap/BAPPropertyRegisterStateUtil 
.const [64] = Utf8 de/audi/app/phone/core/bap/telephone2/TelBAPManagerTel2Utils 
.const [65] = Class [123] 
.const [66] = NameAndType [124] [125] 
.const [67] = Class [126] 
.const [68] = NameAndType [127] [128] 
.const [69] = Class [129] 
.const [70] = NameAndType [130] [131] 
.const [71] = Class [132] 
.const [72] = NameAndType [133] [134] 
.const [73] = Class [135] 
.const [74] = NameAndType [136] [137] 
.const [75] = Class [138] 
.const [76] = NameAndType [139] [140] 
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
.const [111] = Utf8 de/audi/app/phone/core/bap/BAPPropertyRegisterStateUtil 
.const [112] = Utf8 getCombiRegisterState 
.const [113] = Utf8 (I)I 
.const [114] = Utf8 de/audi/app/phone/core/bap/BAPPropertyRegisterStateUtil 
.const [115] = Utf8 getCombiNetworkType 
.const [116] = Utf8 (I)I 
.const [117] = Utf8 de/audi/app/phone/core/bap/BAPPropertyRegisterStateUtil 
.const [118] = Utf8 getCombiDataNetworkType 
.const [119] = Utf8 (I)I 
.const [120] = Utf8 de/audi/app/phone/core/bap/telephone2/TelBAPManagerTel2Utils 
.const [121] = Utf8 telModeSupportsData 
.const [122] = Utf8 (I)Z 
.const [123] = Utf8 de/audi/app/phone/core/bap/telephone2/BAPPropertyTel2RegisterState 
.const [124] = Utf8 registerState 
.const [125] = Utf8 I 
.const [126] = Utf8 de/audi/app/phone/core/bap/telephone2/BAPPropertyTel2RegisterState 
.const [127] = Utf8 networkType 
.const [128] = Utf8 I 
.const [129] = Utf8 de/audi/app/phone/core/bap/telephone2/BAPPropertyTel2RegisterState 
.const [130] = Utf8 packetDataNetworkType 
.const [131] = Utf8 I 
.const [132] = Utf8 org/dsi/ifc/telephoneng/RegisterStateStruct 
.const [133] = Utf8 getTelRegisterState 
.const [134] = Utf8 ()I 
.const [135] = Utf8 de/audi/app/phone/core/bap/telephone2/BAPPropertyTel2RegisterState 
.const [136] = Utf8 log 
.const [137] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [138] = Utf8 de/audi/atip/log/LogChannel 
.const [139] = Utf8 log 
.const [140] = Utf8 (ILjava/lang/String;)Z 
.const [141] = Utf8 de/audi/app/phone/core/bap/telephone2/BAPPropertyTel2RegisterState 
.const [142] = Utf8 getCombiService 
.const [143] = Utf8 ()Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone2; 
.const [144] = Utf8 de/audi/atip/log/LogChannel 
.const [145] = Utf8 log 
.const [146] = Utf8 (ILjava/lang/String;JJ)Z 
.const [147] = Utf8 de/audi/app/phone/core/bap/telephone2/BAPPropertyTel2RegisterState 
.const [148] = Utf8 getTelephoneState 
.const [149] = Utf8 ()Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [150] = Utf8 de/audi/app/phone/core/bap/telephone2/BAPPropertyTel2RegisterState 
.const [151] = Utf8 getRegisterState 
.const [152] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)I 
.const [153] = Utf8 de/audi/app/phone/core/bap/telephone2/BAPPropertyTel2RegisterState 
.const [154] = Utf8 getNetworkType 
.const [155] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)I 
.const [156] = Utf8 de/audi/app/phone/core/bap/telephone2/BAPPropertyTel2RegisterState 
.const [157] = Utf8 getNetworkType 
.const [158] = Utf8 (Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState;)I 
.const [159] = Utf8 de/audi/app/phone/core/bap/telephone2/BAPPropertyTel2RegisterState 
.const [160] = Utf8 updateRegisterState 
.const [161] = Utf8 (III)V 
.const [162] = Utf8 de/audi/app/phone/core/bap/telephone2/AbstractTel2EnqueuedBAPPropertyHandler 
.const [163] = Utf8 <init> 
.const [164] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [165] = Utf8 de/audi/app/phone/core/bap/telephone2/BAPPropertyTel2RegisterState 
.const [166] = Utf8 registerState 
.const [167] = Utf8 I 
.const [168] = Utf8 de/audi/app/phone/core/bap/telephone2/BAPPropertyTel2RegisterState 
.const [169] = Utf8 networkType 
.const [170] = Utf8 I 
.const [171] = Utf8 de/audi/app/phone/core/bap/telephone2/BAPPropertyTel2RegisterState 
.const [172] = Utf8 packetDataNetworkType 
.const [173] = Utf8 I 
.const [174] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [175] = Utf8 getNadInstanceState 
.const [176] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState; 
.const [177] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [178] = Utf8 getRegisterState 
.const [179] = Utf8 ()Lorg/dsi/ifc/telephoneng/RegisterStateStruct; 
.const [180] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [181] = Utf8 getNetworkType 
.const [182] = Utf8 ()I 
.const [183] = Utf8 de/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone2 
.const [184] = Utf8 updateRegisterState 
.const [185] = Utf8 (III)V 
.const [186] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [187] = Utf8 getTelMode 
.const [188] = Utf8 ()I 
.const [189] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [190] = Utf8 isPhoneReady 
.const [191] = Utf8 ()Z 
.const [192] = Utf8 de/audi/app/phone/core/bap/telephone2/BAPPropertyTel2RegisterState 
.const [193] = Class [192] 
.const [194] = Utf8 de/audi/app/phone/core/bap/telephone2/AbstractTel2EnqueuedBAPPropertyHandler 
.const [195] = Class [194] 
.const [196] = Utf8 registerState 
.const [197] = Utf8 I 
.const [198] = Utf8 networkType 
.const [199] = Utf8 I 
.const [200] = Utf8 packetDataNetworkType 
.const [201] = Utf8 I 
.const [202] = Utf8 Code 
.const [203] = Utf8 <init> 
.const [204] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [205] = Utf8 doProcessGlobalTelephoneStateUpdate 
.const [206] = Utf8 (ILde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)Z 
.const [207] = Utf8 getRegisterState 
.const [208] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)I 
.const [209] = Utf8 getNetworkType 
.const [210] = Utf8 (Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)I 
.const [211] = Utf8 updateRegisterState 
.const [212] = Utf8 (III)V 
.const [213] = Utf8 getNetworkType 
.const [214] = Utf8 (Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState;)I 
.const [215] = Utf8 updateAsync 
.const [216] = Utf8 ()V 
.end class 
