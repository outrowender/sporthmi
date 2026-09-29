.version 50 0 
.class super [104] 
.super [106] 

.method annotation [108] : [109] 
    .attribute [107] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [25] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method [110] : [111] 
    .attribute [107] .code stack 5 locals 5 
L0:     aload_0 
L1:     getfield [18] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     iload_1 
L9:     invokevirtual [19] 
L12:    pop 
L13:    aload_0 
L14:    invokevirtual [20] 
L17:    astore_2 
L18:    aload_0 
L19:    invokevirtual [21] 
L22:    astore_3 
L23:    aload_2 
L24:    ifnonnull L40 
L27:    aload_0 
L28:    getfield [18] 
L31:    ldc [4] 
L33:    ldc [5] 
L35:    invokevirtual [22] 
L38:    pop 
L39:    return 
L40:    aload_3 
L41:    ifnonnull L57 
L44:    aload_0 
L45:    getfield [18] 
L48:    ldc [4] 
L50:    ldc [6] 
L52:    invokevirtual [22] 
L55:    pop 
L56:    return 
L57:    aload_2 
L58:    invokeinterface [26] 0 
L63:    astore 4 
L65:    aload 4 
L67:    ifnull L147 
L70:    iload_1 
L71:    ifeq L78 
L74:    iconst_0 
L75:    goto L79 
L78:    iconst_1 
L79:    istore 5 
L81:    aload 4 
L83:    invokeinterface [27] 0 
L88:    istore 6 
L90:    iload 6 
L92:    iload 5 
L94:    if_icmpne L113 
L97:    aload_0 
L98:    getfield [18] 
L101:   ldc [2] 
L103:   ldc [7] 
L105:   iload 6 
L107:   i2l 
L108:   invokevirtual [23] 
L111:   pop 
L112:   return 
L113:   aload_0 
L114:   getfield [18] 
L117:   ldc [8] 
L119:   ldc [9] 
L121:   iload 5 
L123:   i2l 
L124:   invokevirtual [23] 
L127:   pop 
L128:   aload_0 
L129:   invokevirtual [24] 
L132:   invokeinterface [28] 0 
L137:   iload 5 
L139:   iconst_1 
L140:   iconst_1 
L141:   aload_0 
L142:   invokeinterface [29] 0 
L147:   return 
L148:   
    .end code 
.end method 

.method public [112] : [113] 
    .attribute [107] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [18] 
L4:     ldc [2] 
L6:     ldc [10] 
L8:     iload_1 
L9:     i2l 
L10:    invokevirtual [23] 
L13:    pop 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [30] 
.const [4] = Int -1601830656 
.const [5] = String [31] 
.const [6] = String [32] 
.const [7] = String [33] 
.const [8] = Int 1078071040 
.const [9] = String [34] 
.const [10] = String [35] 
.const [11] = Class [36] 
.const [12] = Class [37] 
.const [13] = Class [38] 
.const [14] = Class [39] 
.const [15] = Class [40] 
.const [16] = Class [41] 
.const [17] = Class [42] 
.const [18] = Field [43] [44] 
.const [19] = Method [45] [46] 
.const [20] = Method [47] [48] 
.const [21] = Method [49] [50] 
.const [22] = Method [51] [52] 
.const [23] = Method [53] [54] 
.const [24] = Method [55] [56] 
.const [25] = Method [57] [58] 
.const [26] = InterfaceMethod [59] [60] 
.const [27] = InterfaceMethod [61] [62] 
.const [28] = InterfaceMethod [63] [64] 
.const [29] = InterfaceMethod [65] [66] 
.const [30] = Utf8 '[TelBAPMethodMicMuteHandler#dialNumber] micMuteState=%1' 
.const [31] = Utf8 '[TelBAPMethodMicMuteHandler#dialNumber] telState is null --> NOP!' 
.const [32] = Utf8 '[TelBAPMethodMicMuteHandler#dialNumber] combiService is null --> NOP!' 
.const [33] = Utf8 '[TelBAPMethodMicMuteHandler#setMicMuteState] request to set mic state %1 aborted,  this is the current state' 
.const [34] = Utf8 '[TelBAPMethodMicMuteHandler#setMicMuteState] invoking mic mute, setting value %1' 
.const [35] = Utf8 '[TelBAPMethodMicMuteHandler#setMICMuteStateResponse] recieved result result %1 (no ivokokation on combi)' 
.const [36] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodMicMuteHandler 
.const [37] = Utf8 de/audi/app/phone/core/bap/telephone/AbstractTel1BAPMethodHandler 
.const [38] = Utf8 de/audi/atip/log/LogChannel 
.const [39] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [40] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [41] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [42] = Utf8 de/audi/app/phone/core/dsi/ITelephoneDSIAccess 
.const [43] = Class [67] 
.const [44] = NameAndType [68] [69] 
.const [45] = Class [70] 
.const [46] = NameAndType [71] [72] 
.const [47] = Class [73] 
.const [48] = NameAndType [74] [75] 
.const [49] = Class [76] 
.const [50] = NameAndType [77] [78] 
.const [51] = Class [79] 
.const [52] = NameAndType [80] [81] 
.const [53] = Class [82] 
.const [54] = NameAndType [83] [84] 
.const [55] = Class [85] 
.const [56] = NameAndType [86] [87] 
.const [57] = Class [88] 
.const [58] = NameAndType [89] [90] 
.const [59] = Class [91] 
.const [60] = NameAndType [92] [93] 
.const [61] = Class [94] 
.const [62] = NameAndType [95] [96] 
.const [63] = Class [97] 
.const [64] = NameAndType [98] [99] 
.const [65] = Class [100] 
.const [66] = NameAndType [101] [102] 
.const [67] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodMicMuteHandler 
.const [68] = Utf8 log 
.const [69] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [70] = Utf8 de/audi/atip/log/LogChannel 
.const [71] = Utf8 log 
.const [72] = Utf8 (ILjava/lang/String;Z)Z 
.const [73] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodMicMuteHandler 
.const [74] = Utf8 getTelephoneState 
.const [75] = Utf8 ()Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [76] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodMicMuteHandler 
.const [77] = Utf8 getCombiBapServicePhone 
.const [78] = Utf8 ()Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone; 
.const [79] = Utf8 de/audi/atip/log/LogChannel 
.const [80] = Utf8 log 
.const [81] = Utf8 (ILjava/lang/String;)Z 
.const [82] = Utf8 de/audi/atip/log/LogChannel 
.const [83] = Utf8 log 
.const [84] = Utf8 (ILjava/lang/String;J)Z 
.const [85] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodMicMuteHandler 
.const [86] = Utf8 getApplication 
.const [87] = Utf8 ()Lde/audi/app/phone/core/ITelApplication; 
.const [88] = Utf8 de/audi/app/phone/core/bap/telephone/AbstractTel1BAPMethodHandler 
.const [89] = Utf8 <init> 
.const [90] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [91] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [92] = Utf8 getCallLeadingDevice 
.const [93] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState; 
.const [94] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [95] = Utf8 getmICMuteState 
.const [96] = Utf8 ()I 
.const [97] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [98] = Utf8 getTelephoneDSIAccess 
.const [99] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelephoneDSIAccess; 
.const [100] = Utf8 de/audi/app/phone/core/dsi/ITelephoneDSIAccess 
.const [101] = Utf8 requestSetMICMuteState 
.const [102] = Utf8 (IIZLde/audi/app/phone/core/dsi/ITelDSIResponseListener;)V 
.const [103] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodMicMuteHandler 
.const [104] = Class [103] 
.const [105] = Utf8 de/audi/app/phone/core/bap/telephone/AbstractTel1BAPMethodHandler 
.const [106] = Class [105] 
.const [107] = Utf8 Code 
.const [108] = Utf8 <init> 
.const [109] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [110] = Utf8 setMicMuteState 
.const [111] = Utf8 (Z)V 
.const [112] = Utf8 responseSetMICMuteState 
.const [113] = Utf8 (II)V 
.end class 
