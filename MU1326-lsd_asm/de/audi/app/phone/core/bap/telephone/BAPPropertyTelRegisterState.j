.version 50 0 
.class public super [187] 
.super [189] 
.field private volatile [190] [191] 

.method public annotation [193] : [194] 
    .attribute [192] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [34] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [195] : [196] 
    .attribute [192] .code stack 5 locals 7 
L0:     aload_0 
L1:     invokevirtual [19] 
L4:     astore_1 
L5:     aload_0 
L6:     aload_1 
L7:     invokevirtual [20] 
L10:    invokestatic [2] 
L13:    istore_2 
L14:    aload_0 
L15:    aload_1 
L16:    invokevirtual [21] 
L19:    invokestatic [3] 
L22:    istore_3 
L23:    aload_0 
L24:    invokevirtual [22] 
L27:    ifnull L42 
L30:    aload_0 
L31:    invokevirtual [22] 
L34:    invokeinterface [36] 0 
L39:    goto L43 
L42:    aconst_null 
L43:    astore 4 
L45:    aload_0 
L46:    aload 4 
L48:    invokevirtual [21] 
L51:    istore 5 
L53:    iload 5 
L55:    invokestatic [4] 
L58:    istore 6 
L60:    new [37] 
L63:    dup 
L64:    iload_2 
L65:    iload_3 
L66:    iload 6 
L68:    invokespecial [35] 
L71:    astore 7 
L73:    aload 7 
L75:    aload_0 
L76:    getfield [23] 
L79:    invokevirtual [24] 
L82:    ifne L97 
L85:    aload_0 
L86:    aload 7 
L88:    invokevirtual [25] 
L91:    aload_0 
L92:    aload 7 
L94:    putfield [38] 
L97:    return 
L98:    nop 
L99:    nop 
L100:   
    .end code 
.end method 

.method protected [197] : [198] 
    .attribute [192] .code stack 1 locals 0 
L0:     aload_2 
L1:     ifnull L17 
L4:     aload_2 
L5:     invokeinterface [39] 0 
L10:    ifnull L17 
L13:    iconst_1 
L14:    goto L18 
L17:    iconst_0 
L18:    areturn 
L19:    nop 
L20:    
    .end code 
.end method 

.method protected [199] : [200] 
    .attribute [192] .code stack 1 locals 0 
L0:     aload_1 
L1:     ifnull L25 
L4:     aload_1 
L5:     invokeinterface [40] 0 
L10:    ifnull L25 
L13:    aload_1 
L14:    invokeinterface [40] 0 
L19:    invokevirtual [26] 
L22:    goto L26 
L25:    iconst_0 
L26:    areturn 
L27:    nop 
L28:    
    .end code 
.end method 

.method protected [201] : [202] 
    .attribute [192] .code stack 1 locals 0 
L0:     aload_1 
L1:     ifnull L13 
L4:     aload_1 
L5:     invokeinterface [41] 0 
L10:    goto L14 
L13:    iconst_0 
L14:    areturn 
L15:    nop 
L16:    
    .end code 
.end method 

.method protected [203] : [204] 
    .attribute [192] .code stack 4 locals 1 
L0:     aload_1 
L1:     ifnonnull L18 
L4:     aload_0 
L5:     getfield [27] 
L8:     sipush 10000 
L11:    ldc [6] 
L13:    invokevirtual [28] 
L16:    pop 
L17:    return 
L18:    aload_0 
L19:    invokevirtual [29] 
L22:    astore_2 
L23:    aload_2 
L24:    ifnull L61 
L27:    aload_0 
L28:    getfield [27] 
L31:    ldc [7] 
L33:    ldc [8] 
L35:    aload_1 
L36:    invokevirtual [30] 
L39:    pop 
L40:    aload_2 
L41:    aload_1 
L42:    invokevirtual [31] 
L45:    aload_1 
L46:    invokevirtual [32] 
L49:    aload_1 
L50:    invokevirtual [33] 
L53:    invokeinterface [42] 0 
L58:    goto L73 
L61:    aload_0 
L62:    getfield [27] 
L65:    ldc [9] 
L67:    ldc [10] 
L69:    invokevirtual [28] 
L72:    pop 
L73:    return 
L74:    nop 
L75:    nop 
L76:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [43] [44] 
.const [3] = Method [45] [46] 
.const [4] = Method [47] [48] 
.const [5] = Class [49] 
.const [6] = String [50] 
.const [7] = Int 1078071040 
.const [8] = String [51] 
.const [9] = Int -1601830656 
.const [10] = String [52] 
.const [11] = Class [53] 
.const [12] = Class [54] 
.const [13] = Class [55] 
.const [14] = Class [56] 
.const [15] = Class [57] 
.const [16] = Class [58] 
.const [17] = Class [59] 
.const [18] = Class [60] 
.const [19] = Method [61] [62] 
.const [20] = Method [63] [64] 
.const [21] = Method [65] [66] 
.const [22] = Method [67] [68] 
.const [23] = Field [69] [70] 
.const [24] = Method [71] [72] 
.const [25] = Method [73] [74] 
.const [26] = Method [75] [76] 
.const [27] = Field [77] [78] 
.const [28] = Method [79] [80] 
.const [29] = Method [81] [82] 
.const [30] = Method [83] [84] 
.const [31] = Method [85] [86] 
.const [32] = Method [87] [88] 
.const [33] = Method [89] [90] 
.const [34] = Method [91] [92] 
.const [35] = Method [93] [94] 
.const [36] = InterfaceMethod [95] [96] 
.const [37] = Class [97] 
.const [38] = Field [98] [99] 
.const [39] = InterfaceMethod [100] [101] 
.const [40] = InterfaceMethod [102] [103] 
.const [41] = InterfaceMethod [104] [105] 
.const [42] = InterfaceMethod [106] [107] 
.const [43] = Class [108] 
.const [44] = NameAndType [109] [110] 
.const [45] = Class [111] 
.const [46] = NameAndType [112] [113] 
.const [47] = Class [114] 
.const [48] = NameAndType [115] [116] 
.const [49] = Utf8 de/audi/app/phone/core/bap/TelBapRegisterStateStruct 
.const [50] = Utf8 'BAPPropertyTelRegisterState#updateRegisterState registerStateStruct is null' 
.const [51] = Utf8 '[BAPPropertyTelRegisterState#updateRegisterState] updating combi: %1' 
.const [52] = Utf8 '[BAPPropertyTelRegisterState#updateRegisterState] CombiBAPServicePhone is null --> NOP!' 
.const [53] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelRegisterState 
.const [54] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [55] = Utf8 de/audi/app/phone/core/bap/BAPPropertyRegisterStateUtil 
.const [56] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [57] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [58] = Utf8 org/dsi/ifc/telephoneng/RegisterStateStruct 
.const [59] = Utf8 de/audi/atip/log/LogChannel 
.const [60] = Utf8 de/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone 
.const [61] = Class [117] 
.const [62] = NameAndType [118] [119] 
.const [63] = Class [120] 
.const [64] = NameAndType [121] [122] 
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
.const [97] = Utf8 de/audi/app/phone/core/bap/TelBapRegisterStateStruct 
.const [98] = Class [171] 
.const [99] = NameAndType [172] [173] 
.const [100] = Class [174] 
.const [101] = NameAndType [175] [176] 
.const [102] = Class [177] 
.const [103] = NameAndType [178] [179] 
.const [104] = Class [180] 
.const [105] = NameAndType [181] [182] 
.const [106] = Class [183] 
.const [107] = NameAndType [184] [185] 
.const [108] = Utf8 de/audi/app/phone/core/bap/BAPPropertyRegisterStateUtil 
.const [109] = Utf8 getCombiRegisterState 
.const [110] = Utf8 (I)I 
.const [111] = Utf8 de/audi/app/phone/core/bap/BAPPropertyRegisterStateUtil 
.const [112] = Utf8 getCombiNetworkType 
.const [113] = Utf8 (I)I 
.const [114] = Utf8 de/audi/app/phone/core/bap/BAPPropertyRegisterStateUtil 
.const [115] = Utf8 getCombiDataNetworkType 
.const [116] = Utf8 (I)I 
.const [117] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelRegisterState 
.const [118] = Utf8 getCallLeadingDeviceState 
.const [119] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState; 
.const [120] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelRegisterState 
.const [121] = Utf8 getRegisterState 
.const [122] = Utf8 (Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState;)I 
.const [123] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelRegisterState 
.const [124] = Utf8 getNetworkType 
.const [125] = Utf8 (Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState;)I 
.const [126] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelRegisterState 
.const [127] = Utf8 getTelephoneState 
.const [128] = Utf8 ()Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [129] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelRegisterState 
.const [130] = Utf8 registerStateStruct 
.const [131] = Utf8 Lde/audi/app/phone/core/bap/TelBapRegisterStateStruct; 
.const [132] = Utf8 de/audi/app/phone/core/bap/TelBapRegisterStateStruct 
.const [133] = Utf8 equals 
.const [134] = Utf8 (Ljava/lang/Object;)Z 
.const [135] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelRegisterState 
.const [136] = Utf8 updateRegisterState 
.const [137] = Utf8 (Lde/audi/app/phone/core/bap/TelBapRegisterStateStruct;)V 
.const [138] = Utf8 org/dsi/ifc/telephoneng/RegisterStateStruct 
.const [139] = Utf8 getTelRegisterState 
.const [140] = Utf8 ()I 
.const [141] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelRegisterState 
.const [142] = Utf8 log 
.const [143] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [144] = Utf8 de/audi/atip/log/LogChannel 
.const [145] = Utf8 log 
.const [146] = Utf8 (ILjava/lang/String;)Z 
.const [147] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelRegisterState 
.const [148] = Utf8 getCombiService 
.const [149] = Utf8 ()Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone; 
.const [150] = Utf8 de/audi/atip/log/LogChannel 
.const [151] = Utf8 log 
.const [152] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [153] = Utf8 de/audi/app/phone/core/bap/TelBapRegisterStateStruct 
.const [154] = Utf8 getRegisterState 
.const [155] = Utf8 ()I 
.const [156] = Utf8 de/audi/app/phone/core/bap/TelBapRegisterStateStruct 
.const [157] = Utf8 getNetworkType 
.const [158] = Utf8 ()I 
.const [159] = Utf8 de/audi/app/phone/core/bap/TelBapRegisterStateStruct 
.const [160] = Utf8 getPacketDataNetworkType 
.const [161] = Utf8 ()I 
.const [162] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [163] = Utf8 <init> 
.const [164] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [165] = Utf8 de/audi/app/phone/core/bap/TelBapRegisterStateStruct 
.const [166] = Utf8 <init> 
.const [167] = Utf8 (III)V 
.const [168] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [169] = Utf8 getNadInstanceState 
.const [170] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState; 
.const [171] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelRegisterState 
.const [172] = Utf8 registerStateStruct 
.const [173] = Utf8 Lde/audi/app/phone/core/bap/TelBapRegisterStateStruct; 
.const [174] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [175] = Utf8 getCallLeadingDevice 
.const [176] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState; 
.const [177] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [178] = Utf8 getRegisterState 
.const [179] = Utf8 ()Lorg/dsi/ifc/telephoneng/RegisterStateStruct; 
.const [180] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [181] = Utf8 getNetworkType 
.const [182] = Utf8 ()I 
.const [183] = Utf8 de/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone 
.const [184] = Utf8 updateRegisterState 
.const [185] = Utf8 (III)V 
.const [186] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelRegisterState 
.const [187] = Class [186] 
.const [188] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [189] = Class [188] 
.const [190] = Utf8 registerStateStruct 
.const [191] = Utf8 Lde/audi/app/phone/core/bap/TelBapRegisterStateStruct; 
.const [192] = Utf8 Code 
.const [193] = Utf8 <init> 
.const [194] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [195] = Utf8 updateAsync 
.const [196] = Utf8 ()V 
.const [197] = Utf8 doProcessGlobalTelephoneStateUpdate 
.const [198] = Utf8 (ILde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)Z 
.const [199] = Utf8 getRegisterState 
.const [200] = Utf8 (Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState;)I 
.const [201] = Utf8 getNetworkType 
.const [202] = Utf8 (Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState;)I 
.const [203] = Utf8 updateRegisterState 
.const [204] = Utf8 (Lde/audi/app/phone/core/bap/TelBapRegisterStateStruct;)V 
.end class 
