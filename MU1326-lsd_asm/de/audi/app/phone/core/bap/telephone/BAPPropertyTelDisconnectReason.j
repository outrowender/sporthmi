.version 50 0 
.class super [131] 
.super [133] 

.method annotation [135] : [136] 
    .attribute [134] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [30] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method private [137] : [138] 
    .attribute [134] .code stack 5 locals 2 
L0:     aload_1 
L1:     ifnull L187 
L4:     aload_1 
L5:     invokevirtual [20] 
L8:     istore_2 
L9:     iload_2 
L10:    tableswitch 0 
            L113 
            L108 
            L157 
            L118 
            L135 
            L140 
            L96 
            L84 
            L162 
            L90 
            L123 
            L129 
            L151 
            L102 
            L146 
            default : L168 

L84:    bipush 8 
L86:    istore_3 
L87:    goto L185 
L90:    bipush 10 
L92:    istore_3 
L93:    goto L185 
L96:    bipush 7 
L98:    istore_3 
L99:    goto L185 
L102:   bipush 14 
L104:   istore_3 
L105:   goto L185 
L108:   iconst_1 
L109:   istore_3 
L110:   goto L185 
L113:   iconst_0 
L114:   istore_3 
L115:   goto L185 
L118:   iconst_4 
L119:   istore_3 
L120:   goto L185 
L123:   bipush 11 
L125:   istore_3 
L126:   goto L185 
L129:   bipush 12 
L131:   istore_3 
L132:   goto L185 
L135:   iconst_5 
L136:   istore_3 
L137:   goto L185 
L140:   bipush 6 
L142:   istore_3 
L143:   goto L185 
L146:   iconst_0 
L147:   istore_3 
L148:   goto L185 
L151:   bipush 13 
L153:   istore_3 
L154:   goto L185 
L157:   iconst_3 
L158:   istore_3 
L159:   goto L185 
L162:   bipush 9 
L164:   istore_3 
L165:   goto L185 
L168:   aload_0 
L169:   getfield [21] 
L172:   ldc [2] 
L174:   ldc [3] 
L176:   iload_2 
L177:   i2l 
L178:   invokevirtual [22] 
L181:   pop 
L182:   bipush 14 
L184:   istore_3 
L185:   iload_3 
L186:   areturn 
L187:   bipush 14 
L189:   areturn 
L190:   nop 
L191:   nop 
L192:   
    .end code 
.end method 

.method protected [139] : [140] 
    .attribute [134] .code stack 2 locals 0 
L0:     iload_1 
L1:     ldc [4] 
L3:     if_icmpeq L18 
L6:     iload_1 
L7:     ldc [5] 
L9:     if_icmpeq L18 
L12:    iload_1 
L13:    ldc [6] 
L15:    if_icmpne L22 
L18:    iconst_1 
L19:    goto L23 
L22:    iconst_0 
L23:    areturn 
L24:    
    .end code 
.end method 

.method protected [141] : [142] 
    .attribute [134] .code stack 4 locals 5 
L0:     aload_0 
L1:     invokevirtual [23] 
L4:     astore_1 
L5:     aload_0 
L6:     invokevirtual [24] 
L9:     astore_2 
L10:    aload_2 
L11:    ifnull L23 
L14:    aload_2 
L15:    invokeinterface [33] 0 
L20:    goto L24 
L23:    aconst_null 
L24:    astore_3 
L25:    aload_3 
L26:    ifnull L33 
L29:    aload_1 
L30:    ifnonnull L46 
L33:    aload_0 
L34:    getfield [21] 
L37:    ldc [7] 
L39:    ldc [8] 
L41:    invokevirtual [25] 
L44:    pop 
L45:    return 
L46:    aload_0 
L47:    aload_3 
L48:    invokeinterface [34] 0 
L53:    invokespecial [31] 
L56:    istore 4 
L58:    aload_0 
L59:    getfield [21] 
L62:    invokevirtual [26] 
L65:    ifeq L107 
L68:    new [35] 
L71:    dup 
L72:    invokespecial [32] 
L75:    astore 5 
L77:    aload 5 
L79:    ldc [10] 
L81:    invokevirtual [27] 
L84:    pop 
L85:    aload 5 
L87:    iload 4 
L89:    invokevirtual [28] 
L92:    pop 
L93:    aload_0 
L94:    getfield [21] 
L97:    ldc [11] 
L99:    ldc [12] 
L101:   aload 5 
L103:   invokevirtual [29] 
L106:   pop 
L107:   aload_1 
L108:   iload 4 
L110:   invokeinterface [36] 0 
L115:   return 
L116:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -1601830656 
.const [3] = String [37] 
.const [4] = Int 184549632 
.const [5] = Int 184549888 
.const [6] = Int 184550144 
.const [7] = Int -2137614336 
.const [8] = String [38] 
.const [9] = Class [39] 
.const [10] = String [40] 
.const [11] = Int 1078071040 
.const [12] = String [41] 
.const [13] = Class [42] 
.const [14] = Class [43] 
.const [15] = Class [44] 
.const [16] = Class [45] 
.const [17] = Class [46] 
.const [18] = Class [47] 
.const [19] = Class [48] 
.const [20] = Method [49] [50] 
.const [21] = Field [51] [52] 
.const [22] = Method [53] [54] 
.const [23] = Method [55] [56] 
.const [24] = Method [57] [58] 
.const [25] = Method [59] [60] 
.const [26] = Method [61] [62] 
.const [27] = Method [63] [64] 
.const [28] = Method [65] [66] 
.const [29] = Method [67] [68] 
.const [30] = Method [69] [70] 
.const [31] = Method [71] [72] 
.const [32] = Method [73] [74] 
.const [33] = InterfaceMethod [75] [76] 
.const [34] = InterfaceMethod [77] [78] 
.const [35] = Class [79] 
.const [36] = InterfaceMethod [80] [81] 
.const [37] = Utf8 "PhoneBapPropertyHandlerDisconnectReason#getBAPDisconnectReason: Couldn't map DSI value %1. Reverting to BAP value REASON_UNKNOWN." 
.const [38] = Utf8 '[BAPPropertyTelDisconnectReason#update nothing to update: callLeadingDeviceState OR combiService is null]' 
.const [39] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [40] = Utf8 'disonnect reason = ' 
.const [41] = Utf8 '[BAPPropertyTelDisconnectReason#update] updating cluster: %1' 
.const [42] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelDisconnectReason 
.const [43] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [44] = Utf8 org/dsi/ifc/telephoneng/DisconnectReason 
.const [45] = Utf8 de/audi/atip/log/LogChannel 
.const [46] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [47] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [48] = Utf8 de/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone 
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
.const [61] = Class [100] 
.const [62] = NameAndType [101] [102] 
.const [63] = Class [103] 
.const [64] = NameAndType [104] [105] 
.const [65] = Class [106] 
.const [66] = NameAndType [107] [108] 
.const [67] = Class [109] 
.const [68] = NameAndType [110] [111] 
.const [69] = Class [112] 
.const [70] = NameAndType [113] [114] 
.const [71] = Class [115] 
.const [72] = NameAndType [116] [117] 
.const [73] = Class [118] 
.const [74] = NameAndType [119] [120] 
.const [75] = Class [121] 
.const [76] = NameAndType [122] [123] 
.const [77] = Class [124] 
.const [78] = NameAndType [125] [126] 
.const [79] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [80] = Class [127] 
.const [81] = NameAndType [128] [129] 
.const [82] = Utf8 org/dsi/ifc/telephoneng/DisconnectReason 
.const [83] = Utf8 getDisconnectReason 
.const [84] = Utf8 ()I 
.const [85] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelDisconnectReason 
.const [86] = Utf8 log 
.const [87] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [88] = Utf8 de/audi/atip/log/LogChannel 
.const [89] = Utf8 log 
.const [90] = Utf8 (ILjava/lang/String;J)Z 
.const [91] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelDisconnectReason 
.const [92] = Utf8 getCombiService 
.const [93] = Utf8 ()Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone; 
.const [94] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelDisconnectReason 
.const [95] = Utf8 getTelephoneState 
.const [96] = Utf8 ()Lde/audi/app/phone/core/state/IGlobalTelephoneStateStruct; 
.const [97] = Utf8 de/audi/atip/log/LogChannel 
.const [98] = Utf8 log 
.const [99] = Utf8 (ILjava/lang/String;)Z 
.const [100] = Utf8 de/audi/atip/log/LogChannel 
.const [101] = Utf8 isInfo 
.const [102] = Utf8 ()Z 
.const [103] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [104] = Utf8 append 
.const [105] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [106] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [107] = Utf8 append 
.const [108] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [109] = Utf8 de/audi/atip/log/LogChannel 
.const [110] = Utf8 log 
.const [111] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [112] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [113] = Utf8 <init> 
.const [114] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [115] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelDisconnectReason 
.const [116] = Utf8 getBAPDisconnectReason 
.const [117] = Utf8 (Lorg/dsi/ifc/telephoneng/DisconnectReason;)I 
.const [118] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [119] = Utf8 <init> 
.const [120] = Utf8 ()V 
.const [121] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [122] = Utf8 getCallLeadingDevice 
.const [123] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState; 
.const [124] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [125] = Utf8 getDisconnectReason 
.const [126] = Utf8 ()Lorg/dsi/ifc/telephoneng/DisconnectReason; 
.const [127] = Utf8 de/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone 
.const [128] = Utf8 updateDisconnectReason 
.const [129] = Utf8 (I)V 
.const [130] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelDisconnectReason 
.const [131] = Class [130] 
.const [132] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [133] = Class [132] 
.const [134] = Utf8 Code 
.const [135] = Utf8 <init> 
.const [136] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [137] = Utf8 getBAPDisconnectReason 
.const [138] = Utf8 (Lorg/dsi/ifc/telephoneng/DisconnectReason;)I 
.const [139] = Utf8 doProcessGlobalTelephoneStateUpdate 
.const [140] = Utf8 (ILde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)Z 
.const [141] = Utf8 updateAsync 
.const [142] = Utf8 ()V 
.end class 
