.version 50 0 
.class super [75] 
.super [77] 

.method annotation [79] : [80] 
    .attribute [78] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [18] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [81] : [82] 
    .attribute [78] .code stack 2 locals 0 
L0:     iload_1 
L1:     ldc [2] 
L3:     if_icmpeq L12 
L6:     iload_1 
L7:     ldc [3] 
L9:     if_icmpne L16 
L12:    iconst_1 
L13:    goto L17 
L16:    iconst_0 
L17:    areturn 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 

.method protected [83] : [84] 
    .attribute [78] .code stack 6 locals 5 
L0:     aload_0 
L1:     invokevirtual [13] 
L4:     astore_1 
L5:     aload_1 
L6:     ifnonnull L22 
L9:     aload_0 
L10:    getfield [14] 
L13:    ldc [4] 
L15:    ldc [5] 
L17:    invokevirtual [15] 
L20:    pop 
L21:    return 
L22:    aload_0 
L23:    invokevirtual [16] 
L26:    astore_2 
L27:    aload_1 
L28:    invokeinterface [19] 0 
L33:    istore_3 
L34:    aload_1 
L35:    invokeinterface [20] 0 
L40:    istore 4 
L42:    aload_2 
L43:    ifnull L90 
L46:    iload_3 
L47:    ifeq L54 
L50:    iconst_1 
L51:    goto L64 
L54:    iload 4 
L56:    ifeq L63 
L59:    iconst_1 
L60:    goto L64 
L63:    iconst_0 
L64:    istore 5 
L66:    aload_0 
L67:    getfield [14] 
L70:    ldc [6] 
L72:    ldc [7] 
L74:    iload_3 
L75:    iload 4 
L77:    iload 5 
L79:    invokevirtual [17] 
L82:    aload_2 
L83:    iload 5 
L85:    invokeinterface [21] 0 
L90:    return 
L91:    nop 
L92:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 100664320 
.const [3] = Int 83887104 
.const [4] = Int -2137614336 
.const [5] = String [22] 
.const [6] = Int 1078071040 
.const [7] = String [23] 
.const [8] = Class [24] 
.const [9] = Class [25] 
.const [10] = Class [26] 
.const [11] = Class [27] 
.const [12] = Class [28] 
.const [13] = Method [29] [30] 
.const [14] = Field [31] [32] 
.const [15] = Method [33] [34] 
.const [16] = Method [35] [36] 
.const [17] = Method [37] [38] 
.const [18] = Method [39] [40] 
.const [19] = InterfaceMethod [41] [42] 
.const [20] = InterfaceMethod [43] [44] 
.const [21] = InterfaceMethod [45] [46] 
.const [22] = Utf8 '[BAPPropertyTelRingtoneMute#updateAsync] telephoneState is null --> NOP!' 
.const [23] = Utf8 '[BAPPropertyTelRingtoneMute#update]  ringtoneMuteSettingActive=%1, ringtoneMuteActive=%2 --> ringToneMuted=%3' 
.const [24] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelRingtoneMute 
.const [25] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [26] = Utf8 de/audi/atip/log/LogChannel 
.const [27] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [28] = Utf8 de/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone 
.const [29] = Class [47] 
.const [30] = NameAndType [48] [49] 
.const [31] = Class [50] 
.const [32] = NameAndType [51] [52] 
.const [33] = Class [53] 
.const [34] = NameAndType [54] [55] 
.const [35] = Class [56] 
.const [36] = NameAndType [57] [58] 
.const [37] = Class [59] 
.const [38] = NameAndType [60] [61] 
.const [39] = Class [62] 
.const [40] = NameAndType [63] [64] 
.const [41] = Class [65] 
.const [42] = NameAndType [66] [67] 
.const [43] = Class [68] 
.const [44] = NameAndType [69] [70] 
.const [45] = Class [71] 
.const [46] = NameAndType [72] [73] 
.const [47] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelRingtoneMute 
.const [48] = Utf8 getTelephoneState 
.const [49] = Utf8 ()Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [50] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelRingtoneMute 
.const [51] = Utf8 log 
.const [52] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [53] = Utf8 de/audi/atip/log/LogChannel 
.const [54] = Utf8 log 
.const [55] = Utf8 (ILjava/lang/String;)Z 
.const [56] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelRingtoneMute 
.const [57] = Utf8 getCombiService 
.const [58] = Utf8 ()Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone; 
.const [59] = Utf8 de/audi/atip/log/LogChannel 
.const [60] = Utf8 log 
.const [61] = Utf8 (ILjava/lang/String;ZZZ)V 
.const [62] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [63] = Utf8 <init> 
.const [64] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [65] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [66] = Utf8 isRingtoneMuteSettingOn 
.const [67] = Utf8 ()Z 
.const [68] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [69] = Utf8 isRingtoneMuteActive 
.const [70] = Utf8 ()Z 
.const [71] = Utf8 de/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone 
.const [72] = Utf8 updateRingToneMuteState 
.const [73] = Utf8 (Z)V 
.const [74] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelRingtoneMute 
.const [75] = Class [74] 
.const [76] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [77] = Class [76] 
.const [78] = Utf8 Code 
.const [79] = Utf8 <init> 
.const [80] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [81] = Utf8 doProcessGlobalTelephoneStateUpdate 
.const [82] = Utf8 (ILde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)Z 
.const [83] = Utf8 updateAsync 
.const [84] = Utf8 ()V 
.end class 
