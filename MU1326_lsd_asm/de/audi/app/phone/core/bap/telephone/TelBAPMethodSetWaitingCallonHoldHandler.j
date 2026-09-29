.version 50 0 
.class super [135] 
.super [137] 

.method annotation [139] : [140] 
    .attribute [138] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [25] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method [141] : [142] 
    .attribute [138] .code stack 4 locals 5 
L0:     aload_0 
L1:     getfield [17] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     invokevirtual [18] 
L11:    pop 
L12:    aload_0 
L13:    invokevirtual [19] 
L16:    astore_1 
L17:    aload_0 
L18:    invokevirtual [20] 
L21:    astore_2 
L22:    aload_2 
L23:    ifnonnull L39 
L26:    aload_0 
L27:    getfield [17] 
L30:    ldc [4] 
L32:    ldc [5] 
L34:    invokevirtual [18] 
L37:    pop 
L38:    return 
L39:    aload_1 
L40:    ifnonnull L60 
L43:    aload_0 
L44:    getfield [17] 
L47:    ldc [4] 
L49:    ldc [6] 
L51:    invokevirtual [18] 
L54:    pop 
L55:    aload_0 
L56:    invokespecial [26] 
L59:    return 
L60:    aload_1 
L61:    invokeinterface [29] 0 
L66:    astore_3 
L67:    aload_3 
L68:    ifnull L171 
L71:    aload_3 
L72:    invokeinterface [30] 0 
L77:    ifnull L171 
L80:    aload_3 
L81:    invokeinterface [30] 0 
L86:    invokevirtual [21] 
L89:    ifne L171 
L92:    aload_3 
L93:    invokeinterface [31] 0 
L98:    ifeq L171 
L101:   aload_3 
L102:   invokeinterface [30] 0 
L107:   invokevirtual [22] 
L110:   istore 4 
L112:   aload_3 
L113:   invokeinterface [31] 0 
L118:   istore 5 
L120:   iload 4 
L122:   bipush 15 
L124:   if_icmpeq L134 
L127:   iload 4 
L129:   bipush 27 
L131:   if_icmpne L168 
L134:   iload 5 
L136:   ifeq L168 
L139:   aload_0 
L140:   getfield [17] 
L143:   ldc [2] 
L145:   ldc [7] 
L147:   invokevirtual [18] 
L150:   pop 
L151:   aload_0 
L152:   invokevirtual [23] 
L155:   invokeinterface [32] 0 
L160:   iconst_1 
L161:   iconst_1 
L162:   aload_0 
L163:   invokeinterface [33] 0 
L168:   goto L175 
L171:   aload_0 
L172:   invokespecial [26] 
L175:   return 
L176:   
    .end code 
.end method 

.method private [143] : [144] 
    .attribute [138] .code stack 2 locals 0 
L0:     aload_0 
L1:     iconst_1 
L2:     invokespecial [27] 
L5:     return 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [145] : [146] 
    .attribute [138] .code stack 2 locals 1 
L0:     iload_1 
L1:     ifne L8 
L4:     iconst_0 
L5:     goto L9 
L8:     iconst_1 
L9:     istore_3 
L10:    aload_0 
L11:    iload_3 
L12:    invokespecial [27] 
L15:    return 
L16:    
    .end code 
.end method 

.method private [147] : [148] 
    .attribute [138] .code stack 5 locals 0 
L0:     aload_0 
L1:     new [34] 
L4:     dup 
L5:     aload_0 
L6:     iload_1 
L7:     invokespecial [28] 
L10:    invokevirtual [24] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method static synthetic [149] : [150] 
    .attribute [138] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [17] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method static synthetic [151] : [152] 
    .attribute [138] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [17] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [35] 
.const [4] = Int -1601830656 
.const [5] = String [36] 
.const [6] = String [37] 
.const [7] = String [38] 
.const [8] = Class [39] 
.const [9] = Class [40] 
.const [10] = Class [41] 
.const [11] = Class [42] 
.const [12] = Class [43] 
.const [13] = Class [44] 
.const [14] = Class [45] 
.const [15] = Class [46] 
.const [16] = Class [47] 
.const [17] = Field [48] [49] 
.const [18] = Method [50] [51] 
.const [19] = Method [52] [53] 
.const [20] = Method [54] [55] 
.const [21] = Method [56] [57] 
.const [22] = Method [58] [59] 
.const [23] = Method [60] [61] 
.const [24] = Method [62] [63] 
.const [25] = Method [64] [65] 
.const [26] = Method [66] [67] 
.const [27] = Method [68] [69] 
.const [28] = Method [70] [71] 
.const [29] = InterfaceMethod [72] [73] 
.const [30] = InterfaceMethod [74] [75] 
.const [31] = InterfaceMethod [76] [77] 
.const [32] = InterfaceMethod [78] [79] 
.const [33] = InterfaceMethod [80] [81] 
.const [34] = Class [82] 
.const [35] = Utf8 '[TelBAPMethodSetWaitingCallonHoldHandler#setWaitingCallOnHold]' 
.const [36] = Utf8 '[TelBAPMethodSetWaitingCallonHoldHandler#setWaitingCallOnHold] combiService is null --> NOP!' 
.const [37] = Utf8 '[TelBAPMethodSetWaitingCallonHoldHandler#setWaitingCallOnHold] telState is null --> NOP!' 
.const [38] = Utf8 '[TelBAPMethodSetWaitingCallonHoldHandler#setWaitingCallOnHold] placing incoming call on hold on call leading device.' 
.const [39] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodSetWaitingCallonHoldHandler$1 
.const [40] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodSetWaitingCallonHoldHandler 
.const [41] = Utf8 de/audi/app/phone/core/bap/telephone/AbstractTel1BAPMethodHandler 
.const [42] = Utf8 de/audi/atip/log/LogChannel 
.const [43] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [44] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [45] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [46] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [47] = Utf8 de/audi/app/phone/core/dsi/ITelephoneDSIAccess 
.const [48] = Class [83] 
.const [49] = NameAndType [84] [85] 
.const [50] = Class [86] 
.const [51] = NameAndType [87] [88] 
.const [52] = Class [89] 
.const [53] = NameAndType [90] [91] 
.const [54] = Class [92] 
.const [55] = NameAndType [93] [94] 
.const [56] = Class [95] 
.const [57] = NameAndType [96] [97] 
.const [58] = Class [98] 
.const [59] = NameAndType [99] [100] 
.const [60] = Class [101] 
.const [61] = NameAndType [102] [103] 
.const [62] = Class [104] 
.const [63] = NameAndType [105] [106] 
.const [64] = Class [107] 
.const [65] = NameAndType [108] [109] 
.const [66] = Class [110] 
.const [67] = NameAndType [111] [112] 
.const [68] = Class [113] 
.const [69] = NameAndType [114] [115] 
.const [70] = Class [116] 
.const [71] = NameAndType [117] [118] 
.const [72] = Class [119] 
.const [73] = NameAndType [120] [121] 
.const [74] = Class [122] 
.const [75] = NameAndType [123] [124] 
.const [76] = Class [125] 
.const [77] = NameAndType [126] [127] 
.const [78] = Class [128] 
.const [79] = NameAndType [129] [130] 
.const [80] = Class [131] 
.const [81] = NameAndType [132] [133] 
.const [82] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodSetWaitingCallonHoldHandler$1 
.const [83] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodSetWaitingCallonHoldHandler 
.const [84] = Utf8 log 
.const [85] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [86] = Utf8 de/audi/atip/log/LogChannel 
.const [87] = Utf8 log 
.const [88] = Utf8 (ILjava/lang/String;)Z 
.const [89] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodSetWaitingCallonHoldHandler 
.const [90] = Utf8 getTelephoneState 
.const [91] = Utf8 ()Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [92] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodSetWaitingCallonHoldHandler 
.const [93] = Utf8 getCombiBapServicePhone 
.const [94] = Utf8 ()Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone; 
.const [95] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [96] = Utf8 isHasOnHoldCall 
.const [97] = Utf8 ()Z 
.const [98] = Utf8 de/audi/app/phone/core/state/CallStateStruct 
.const [99] = Utf8 getMpCallState 
.const [100] = Utf8 ()I 
.const [101] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodSetWaitingCallonHoldHandler 
.const [102] = Utf8 getApplication 
.const [103] = Utf8 ()Lde/audi/app/phone/core/ITelApplication; 
.const [104] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodSetWaitingCallonHoldHandler 
.const [105] = Utf8 enqueueResultNotification 
.const [106] = Utf8 (Ljava/lang/Runnable;)V 
.const [107] = Utf8 de/audi/app/phone/core/bap/telephone/AbstractTel1BAPMethodHandler 
.const [108] = Utf8 <init> 
.const [109] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [110] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodSetWaitingCallonHoldHandler 
.const [111] = Utf8 sendResultNotSuccessful 
.const [112] = Utf8 ()V 
.const [113] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodSetWaitingCallonHoldHandler 
.const [114] = Utf8 sendResult 
.const [115] = Utf8 (I)V 
.const [116] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodSetWaitingCallonHoldHandler$1 
.const [117] = Utf8 <init> 
.const [118] = Utf8 (Lde/audi/app/phone/core/bap/telephone/TelBAPMethodSetWaitingCallonHoldHandler;I)V 
.const [119] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [120] = Utf8 getCallLeadingDevice 
.const [121] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState; 
.const [122] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [123] = Utf8 getCallState 
.const [124] = Utf8 ()Lde/audi/app/phone/core/state/CallStateStruct; 
.const [125] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [126] = Utf8 isResponseAndHoldSupported 
.const [127] = Utf8 ()Z 
.const [128] = Utf8 de/audi/app/phone/core/ITelApplication 
.const [129] = Utf8 getTelephoneDSIAccess 
.const [130] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelephoneDSIAccess; 
.const [131] = Utf8 de/audi/app/phone/core/dsi/ITelephoneDSIAccess 
.const [132] = Utf8 placeIncomingCallOnHold 
.const [133] = Utf8 (IZLde/audi/app/phone/core/dsi/ITelDSIResponseListener;)V 
.const [134] = Utf8 de/audi/app/phone/core/bap/telephone/TelBAPMethodSetWaitingCallonHoldHandler 
.const [135] = Class [134] 
.const [136] = Utf8 de/audi/app/phone/core/bap/telephone/AbstractTel1BAPMethodHandler 
.const [137] = Class [136] 
.const [138] = Utf8 Code 
.const [139] = Utf8 <init> 
.const [140] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [141] = Utf8 setWaitingCallOnHold 
.const [142] = Utf8 ()V 
.const [143] = Utf8 sendResultNotSuccessful 
.const [144] = Utf8 ()V 
.const [145] = Utf8 responseAcceptCall 
.const [146] = Utf8 (II)V 
.const [147] = Utf8 sendResult 
.const [148] = Utf8 (I)V 
.const [149] = Utf8 access$000 
.const [150] = Utf8 (Lde/audi/app/phone/core/bap/telephone/TelBAPMethodSetWaitingCallonHoldHandler;)Lde/audi/atip/log/LogChannel; 
.const [151] = Utf8 access$100 
.const [152] = Utf8 (Lde/audi/app/phone/core/bap/telephone/TelBAPMethodSetWaitingCallonHoldHandler;)Lde/audi/atip/log/LogChannel; 
.end class 
