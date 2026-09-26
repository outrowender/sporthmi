.version 50 0 
.class public super [101] 
.super [103] 
.field private volatile [104] [105] 
.field private volatile [106] [107] 

.method public annotation [109] : [110] 
    .attribute [108] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [20] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [111] : [112] 
    .attribute [108] .code stack 1 locals 0 
L0:     aload_2 
L1:     ifnull L17 
L4:     aload_2 
L5:     invokeinterface [21] 0 
L10:    ifnull L17 
L13:    iconst_1 
L14:    goto L18 
L17:    iconst_0 
L18:    areturn 
L19:    nop 
L20:    
    .end code 
.end method 

.method protected [113] : [114] 
    .attribute [108] .code stack 4 locals 3 
L0:     aload_0 
L1:     invokevirtual [13] 
L4:     astore_1 
L5:     aload_0 
L6:     invokevirtual [14] 
L9:     astore_2 
L10:    aload_1 
L11:    ifnull L96 
L14:    aload_2 
L15:    ifnull L81 
L18:    aload_2 
L19:    invokeinterface [22] 0 
L24:    ifne L31 
L27:    iconst_1 
L28:    goto L32 
L31:    iconst_0 
L32:    istore_3 
L33:    iload_3 
L34:    aload_0 
L35:    getfield [15] 
L38:    if_icmpne L48 
L41:    aload_0 
L42:    getfield [16] 
L45:    ifne L78 
L48:    aload_0 
L49:    iconst_1 
L50:    putfield [24] 
L53:    aload_0 
L54:    getfield [17] 
L57:    ldc [2] 
L59:    ldc [3] 
L61:    iload_3 
L62:    invokevirtual [18] 
L65:    pop 
L66:    aload_1 
L67:    iload_3 
L68:    invokeinterface [25] 0 
L73:    aload_0 
L74:    iload_3 
L75:    putfield [23] 
L78:    goto L108 
L81:    aload_0 
L82:    getfield [17] 
L85:    ldc [4] 
L87:    ldc [5] 
L89:    invokevirtual [19] 
L92:    pop 
L93:    goto L108 
L96:    aload_0 
L97:    getfield [17] 
L100:   ldc [4] 
L102:   ldc [6] 
L104:   invokevirtual [19] 
L107:   pop 
L108:   return 
L109:   nop 
L110:   nop 
L111:   nop 
L112:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int 1078071040 
.const [3] = String [26] 
.const [4] = Int -1601830656 
.const [5] = String [27] 
.const [6] = String [28] 
.const [7] = Class [29] 
.const [8] = Class [30] 
.const [9] = Class [31] 
.const [10] = Class [32] 
.const [11] = Class [33] 
.const [12] = Class [34] 
.const [13] = Method [35] [36] 
.const [14] = Method [37] [38] 
.const [15] = Field [39] [40] 
.const [16] = Field [41] [42] 
.const [17] = Field [43] [44] 
.const [18] = Method [45] [46] 
.const [19] = Method [47] [48] 
.const [20] = Method [49] [50] 
.const [21] = InterfaceMethod [51] [52] 
.const [22] = InterfaceMethod [53] [54] 
.const [23] = Field [55] [56] 
.const [24] = Field [57] [58] 
.const [25] = InterfaceMethod [59] [60] 
.const [26] = Utf8 '[BAPPropertyTelMicroMuteOnOff#update] micMuteState=%1' 
.const [27] = Utf8 '[BAPPropertyTelMicroMuteOnOff#update] state is null --> NOP!' 
.const [28] = Utf8 '[BAPPropertyTelMicroMuteOnOff#update] CombiBAPServicePhone is null --> NOP!' 
.const [29] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelMicroMuteOnOff 
.const [30] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [31] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [32] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [33] = Utf8 de/audi/atip/log/LogChannel 
.const [34] = Utf8 de/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone 
.const [35] = Class [61] 
.const [36] = NameAndType [62] [63] 
.const [37] = Class [64] 
.const [38] = NameAndType [65] [66] 
.const [39] = Class [67] 
.const [40] = NameAndType [68] [69] 
.const [41] = Class [70] 
.const [42] = NameAndType [71] [72] 
.const [43] = Class [73] 
.const [44] = NameAndType [74] [75] 
.const [45] = Class [76] 
.const [46] = NameAndType [77] [78] 
.const [47] = Class [79] 
.const [48] = NameAndType [80] [81] 
.const [49] = Class [82] 
.const [50] = NameAndType [83] [84] 
.const [51] = Class [85] 
.const [52] = NameAndType [86] [87] 
.const [53] = Class [88] 
.const [54] = NameAndType [89] [90] 
.const [55] = Class [91] 
.const [56] = NameAndType [92] [93] 
.const [57] = Class [94] 
.const [58] = NameAndType [95] [96] 
.const [59] = Class [97] 
.const [60] = NameAndType [98] [99] 
.const [61] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelMicroMuteOnOff 
.const [62] = Utf8 getCombiService 
.const [63] = Utf8 ()Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone; 
.const [64] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelMicroMuteOnOff 
.const [65] = Utf8 getCallLeadingDeviceState 
.const [66] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState; 
.const [67] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelMicroMuteOnOff 
.const [68] = Utf8 currentCombiMicMuteState 
.const [69] = Utf8 Z 
.const [70] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelMicroMuteOnOff 
.const [71] = Utf8 firstUpdateSent 
.const [72] = Utf8 Z 
.const [73] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelMicroMuteOnOff 
.const [74] = Utf8 log 
.const [75] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [76] = Utf8 de/audi/atip/log/LogChannel 
.const [77] = Utf8 log 
.const [78] = Utf8 (ILjava/lang/String;Z)Z 
.const [79] = Utf8 de/audi/atip/log/LogChannel 
.const [80] = Utf8 log 
.const [81] = Utf8 (ILjava/lang/String;)Z 
.const [82] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [83] = Utf8 <init> 
.const [84] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [85] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [86] = Utf8 getCallLeadingDevice 
.const [87] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState; 
.const [88] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [89] = Utf8 getmICMuteState 
.const [90] = Utf8 ()I 
.const [91] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelMicroMuteOnOff 
.const [92] = Utf8 currentCombiMicMuteState 
.const [93] = Utf8 Z 
.const [94] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelMicroMuteOnOff 
.const [95] = Utf8 firstUpdateSent 
.const [96] = Utf8 Z 
.const [97] = Utf8 de/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone 
.const [98] = Utf8 updateMicMuteState 
.const [99] = Utf8 (Z)V 
.const [100] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelMicroMuteOnOff 
.const [101] = Class [100] 
.const [102] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [103] = Class [102] 
.const [104] = Utf8 firstUpdateSent 
.const [105] = Utf8 Z 
.const [106] = Utf8 currentCombiMicMuteState 
.const [107] = Utf8 Z 
.const [108] = Utf8 Code 
.const [109] = Utf8 <init> 
.const [110] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [111] = Utf8 doProcessGlobalTelephoneStateUpdate 
.const [112] = Utf8 (ILde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)Z 
.const [113] = Utf8 updateAsync 
.const [114] = Utf8 ()V 
.end class 
