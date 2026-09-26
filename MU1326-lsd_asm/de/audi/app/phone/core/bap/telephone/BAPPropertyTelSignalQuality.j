.version 50 0 
.class public super [97] 
.super [99] 
.field private volatile [100] [101] 

.method public [103] : [104] 
    .attribute [102] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [21] 
L6:     aload_0 
L7:     iconst_m1 
L8:     putfield [22] 
L11:    return 
L12:    
    .end code 
.end method 

.method protected [105] : [106] 
    .attribute [102] .code stack 1 locals 0 
L0:     aload_2 
L1:     ifnull L17 
L4:     aload_2 
L5:     invokeinterface [23] 0 
L10:    ifnull L17 
L13:    iconst_1 
L14:    goto L18 
L17:    iconst_0 
L18:    areturn 
L19:    nop 
L20:    
    .end code 
.end method 

.method protected [107] : [108] 
    .attribute [102] .code stack 5 locals 3 
L0:     aload_0 
L1:     invokevirtual [16] 
L4:     astore_1 
L5:     aload_0 
L6:     invokevirtual [17] 
L9:     ifnull L24 
L12:    aload_0 
L13:    invokevirtual [17] 
L16:    invokeinterface [23] 0 
L21:    goto L25 
L24:    aconst_null 
L25:    astore_2 
L26:    aload_1 
L27:    ifnull L96 
L30:    aload_2 
L31:    ifnull L81 
L34:    aload_2 
L35:    invokeinterface [24] 0 
L40:    invokestatic [2] 
L43:    istore_3 
L44:    iload_3 
L45:    aload_0 
L46:    getfield [15] 
L49:    if_icmpeq L78 
L52:    aload_0 
L53:    getfield [18] 
L56:    ldc [3] 
L58:    ldc [4] 
L60:    iload_3 
L61:    i2l 
L62:    invokevirtual [19] 
L65:    pop 
L66:    aload_1 
L67:    iload_3 
L68:    invokeinterface [25] 0 
L73:    aload_0 
L74:    iload_3 
L75:    putfield [22] 
L78:    goto L108 
L81:    aload_0 
L82:    getfield [18] 
L85:    ldc [5] 
L87:    ldc [6] 
L89:    invokevirtual [20] 
L92:    pop 
L93:    goto L108 
L96:    aload_0 
L97:    getfield [18] 
L100:   ldc [5] 
L102:   ldc [7] 
L104:   invokevirtual [20] 
L107:   pop 
L108:   return 
L109:   nop 
L110:   nop 
L111:   nop 
L112:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [26] [27] 
.const [3] = Int 1078071040 
.const [4] = String [28] 
.const [5] = Int -1601830656 
.const [6] = String [29] 
.const [7] = String [30] 
.const [8] = Class [31] 
.const [9] = Class [32] 
.const [10] = Class [33] 
.const [11] = Class [34] 
.const [12] = Class [35] 
.const [13] = Class [36] 
.const [14] = Class [37] 
.const [15] = Field [38] [39] 
.const [16] = Method [40] [41] 
.const [17] = Method [42] [43] 
.const [18] = Field [44] [45] 
.const [19] = Method [46] [47] 
.const [20] = Method [48] [49] 
.const [21] = Method [50] [51] 
.const [22] = Field [52] [53] 
.const [23] = InterfaceMethod [54] [55] 
.const [24] = InterfaceMethod [56] [57] 
.const [25] = InterfaceMethod [58] [59] 
.const [26] = Class [60] 
.const [27] = NameAndType [61] [62] 
.const [28] = Utf8 '[BAPPropertyTelSignalQuality#update] combiSignalQuality=%1' 
.const [29] = Utf8 '[BAPPropertyTelSignalQuality#update] state is null --> NOP!' 
.const [30] = Utf8 '[BAPPropertyTelSignalQuality#update] CombiBAPServicePhone is null --> NOP!' 
.const [31] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelSignalQuality 
.const [32] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [33] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [34] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [35] = Utf8 de/audi/app/phone/core/bap/BapPropertyTelSignalQualityUtil 
.const [36] = Utf8 de/audi/atip/log/LogChannel 
.const [37] = Utf8 de/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone 
.const [38] = Class [63] 
.const [39] = NameAndType [64] [65] 
.const [40] = Class [66] 
.const [41] = NameAndType [67] [68] 
.const [42] = Class [69] 
.const [43] = NameAndType [70] [71] 
.const [44] = Class [72] 
.const [45] = NameAndType [73] [74] 
.const [46] = Class [75] 
.const [47] = NameAndType [76] [77] 
.const [48] = Class [78] 
.const [49] = NameAndType [79] [80] 
.const [50] = Class [81] 
.const [51] = NameAndType [82] [83] 
.const [52] = Class [84] 
.const [53] = NameAndType [85] [86] 
.const [54] = Class [87] 
.const [55] = NameAndType [88] [89] 
.const [56] = Class [90] 
.const [57] = NameAndType [91] [92] 
.const [58] = Class [93] 
.const [59] = NameAndType [94] [95] 
.const [60] = Utf8 de/audi/app/phone/core/bap/BapPropertyTelSignalQualityUtil 
.const [61] = Utf8 getCombiSignalQuality 
.const [62] = Utf8 (I)I 
.const [63] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelSignalQuality 
.const [64] = Utf8 currentCombiSignalQuality 
.const [65] = Utf8 I 
.const [66] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelSignalQuality 
.const [67] = Utf8 getCombiService 
.const [68] = Utf8 ()Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone; 
.const [69] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelSignalQuality 
.const [70] = Utf8 getTelephoneState 
.const [71] = Utf8 ()Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [72] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelSignalQuality 
.const [73] = Utf8 log 
.const [74] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [75] = Utf8 de/audi/atip/log/LogChannel 
.const [76] = Utf8 log 
.const [77] = Utf8 (ILjava/lang/String;J)Z 
.const [78] = Utf8 de/audi/atip/log/LogChannel 
.const [79] = Utf8 log 
.const [80] = Utf8 (ILjava/lang/String;)Z 
.const [81] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [82] = Utf8 <init> 
.const [83] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [84] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelSignalQuality 
.const [85] = Utf8 currentCombiSignalQuality 
.const [86] = Utf8 I 
.const [87] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [88] = Utf8 getCallLeadingDevice 
.const [89] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState; 
.const [90] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [91] = Utf8 getSignalQuality 
.const [92] = Utf8 ()I 
.const [93] = Utf8 de/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone 
.const [94] = Utf8 updateSignalQuality 
.const [95] = Utf8 (I)V 
.const [96] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelSignalQuality 
.const [97] = Class [96] 
.const [98] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [99] = Class [98] 
.const [100] = Utf8 currentCombiSignalQuality 
.const [101] = Utf8 I 
.const [102] = Utf8 Code 
.const [103] = Utf8 <init> 
.const [104] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [105] = Utf8 doProcessGlobalTelephoneStateUpdate 
.const [106] = Utf8 (ILde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)Z 
.const [107] = Utf8 updateAsync 
.const [108] = Utf8 ()V 
.end class 
