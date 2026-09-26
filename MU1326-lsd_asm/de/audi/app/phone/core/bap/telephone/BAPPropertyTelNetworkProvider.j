.version 50 0 
.class public super [151] 
.super [153] 
.field private volatile [154] [155] 

.method public annotation [157] : [158] 
    .attribute [156] .code stack 3 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     aload_2 
L3:     invokespecial [29] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method protected [159] : [160] 
    .attribute [156] .code stack 1 locals 0 
L0:     aload_2 
L1:     ifnull L17 
L4:     aload_2 
L5:     invokeinterface [31] 0 
L10:    ifnull L17 
L13:    iconst_1 
L14:    goto L18 
L17:    iconst_0 
L18:    areturn 
L19:    nop 
L20:    
    .end code 
.end method 

.method protected [161] : [162] 
    .attribute [156] .code stack 6 locals 7 
L0:     aload_0 
L1:     invokevirtual [16] 
L4:     astore_1 
L5:     aload_0 
L6:     invokevirtual [17] 
L9:     astore_2 
L10:    aload_1 
L11:    ifnull L179 
L14:    aload_2 
L15:    ifnull L164 
L18:    aload_2 
L19:    invokeinterface [32] 0 
L24:    ifnull L39 
L27:    aload_2 
L28:    invokeinterface [32] 0 
L33:    invokevirtual [18] 
L36:    goto L40 
L39:    aconst_null 
L40:    astore_3 
L41:    aload_3 
L42:    ifnull L56 
L45:    aload_3 
L46:    invokevirtual [19] 
L49:    ifle L56 
L52:    iconst_1 
L53:    goto L57 
L56:    iconst_0 
L57:    istore 4 
L59:    aload_2 
L60:    invokeinterface [33] 0 
L65:    astore 5 
L67:    aload 5 
L69:    ifnull L84 
L72:    aload 5 
L74:    invokevirtual [19] 
L77:    ifle L84 
L80:    iconst_1 
L81:    goto L85 
L84:    iconst_0 
L85:    istore 6 
L87:    new [34] 
L90:    dup 
L91:    iload 6 
L93:    aload 5 
L95:    iload 4 
L97:    aload_3 
L98:    invokespecial [30] 
L101:   astore 7 
L103:   aload 7 
L105:   aload_0 
L106:   getfield [20] 
L109:   invokevirtual [21] 
L112:   ifne L161 
L115:   aload_0 
L116:   getfield [22] 
L119:   ldc [3] 
L121:   ldc [4] 
L123:   aload 7 
L125:   invokevirtual [23] 
L128:   pop 
L129:   aload_1 
L130:   aload 7 
L132:   invokevirtual [24] 
L135:   aload 7 
L137:   invokevirtual [25] 
L140:   aload 7 
L142:   invokevirtual [26] 
L145:   aload 7 
L147:   invokevirtual [27] 
L150:   invokeinterface [36] 0 
L155:   aload_0 
L156:   aload 7 
L158:   putfield [35] 
L161:   goto L191 
L164:   aload_0 
L165:   getfield [22] 
L168:   ldc [5] 
L170:   ldc [6] 
L172:   invokevirtual [28] 
L175:   pop 
L176:   goto L191 
L179:   aload_0 
L180:   getfield [22] 
L183:   ldc [5] 
L185:   ldc [7] 
L187:   invokevirtual [28] 
L190:   pop 
L191:   return 
L192:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [37] 
.const [3] = Int 1078071040 
.const [4] = String [38] 
.const [5] = Int -1601830656 
.const [6] = String [39] 
.const [7] = String [40] 
.const [8] = Class [41] 
.const [9] = Class [42] 
.const [10] = Class [43] 
.const [11] = Class [44] 
.const [12] = Class [45] 
.const [13] = Class [46] 
.const [14] = Class [47] 
.const [15] = Class [48] 
.const [16] = Method [49] [50] 
.const [17] = Method [51] [52] 
.const [18] = Method [53] [54] 
.const [19] = Method [55] [56] 
.const [20] = Field [57] [58] 
.const [21] = Method [59] [60] 
.const [22] = Field [61] [62] 
.const [23] = Method [63] [64] 
.const [24] = Method [65] [66] 
.const [25] = Method [67] [68] 
.const [26] = Method [69] [70] 
.const [27] = Method [71] [72] 
.const [28] = Method [73] [74] 
.const [29] = Method [75] [76] 
.const [30] = Method [77] [78] 
.const [31] = InterfaceMethod [79] [80] 
.const [32] = InterfaceMethod [81] [82] 
.const [33] = InterfaceMethod [83] [84] 
.const [34] = Class [85] 
.const [35] = Field [86] [87] 
.const [36] = InterfaceMethod [88] [89] 
.const [37] = Utf8 de/audi/app/phone/core/bap/TelBapNetworkProviderStruct 
.const [38] = Utf8 '[BAPPropertyTelNetworkProvider#update] %1' 
.const [39] = Utf8 '[BAPPropertyTelNetworkProvider#update] state is null --> NOP!' 
.const [40] = Utf8 '[BAPPropertyTelNetworkProvider#update] CombiBAPServicePhone is null --> NOP!' 
.const [41] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelNetworkProvider 
.const [42] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [43] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [44] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [45] = Utf8 org/dsi/ifc/telephoneng/ServiceProvider 
.const [46] = Utf8 java/lang/String 
.const [47] = Utf8 de/audi/atip/log/LogChannel 
.const [48] = Utf8 de/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone 
.const [49] = Class [90] 
.const [50] = NameAndType [91] [92] 
.const [51] = Class [93] 
.const [52] = NameAndType [94] [95] 
.const [53] = Class [96] 
.const [54] = NameAndType [97] [98] 
.const [55] = Class [99] 
.const [56] = NameAndType [100] [101] 
.const [57] = Class [102] 
.const [58] = NameAndType [103] [104] 
.const [59] = Class [105] 
.const [60] = NameAndType [106] [107] 
.const [61] = Class [108] 
.const [62] = NameAndType [109] [110] 
.const [63] = Class [111] 
.const [64] = NameAndType [112] [113] 
.const [65] = Class [114] 
.const [66] = NameAndType [115] [116] 
.const [67] = Class [117] 
.const [68] = NameAndType [118] [119] 
.const [69] = Class [120] 
.const [70] = NameAndType [121] [122] 
.const [71] = Class [123] 
.const [72] = NameAndType [124] [125] 
.const [73] = Class [126] 
.const [74] = NameAndType [127] [128] 
.const [75] = Class [129] 
.const [76] = NameAndType [130] [131] 
.const [77] = Class [132] 
.const [78] = NameAndType [133] [134] 
.const [79] = Class [135] 
.const [80] = NameAndType [136] [137] 
.const [81] = Class [138] 
.const [82] = NameAndType [139] [140] 
.const [83] = Class [141] 
.const [84] = NameAndType [142] [143] 
.const [85] = Utf8 de/audi/app/phone/core/bap/TelBapNetworkProviderStruct 
.const [86] = Class [144] 
.const [87] = NameAndType [145] [146] 
.const [88] = Class [147] 
.const [89] = NameAndType [148] [149] 
.const [90] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelNetworkProvider 
.const [91] = Utf8 getCombiService 
.const [92] = Utf8 ()Lde/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone; 
.const [93] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelNetworkProvider 
.const [94] = Utf8 getCallLeadingDeviceState 
.const [95] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState; 
.const [96] = Utf8 org/dsi/ifc/telephoneng/ServiceProvider 
.const [97] = Utf8 getTelServiceProviderName 
.const [98] = Utf8 ()Ljava/lang/String; 
.const [99] = Utf8 java/lang/String 
.const [100] = Utf8 length 
.const [101] = Utf8 ()I 
.const [102] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelNetworkProvider 
.const [103] = Utf8 networkProviderStruct 
.const [104] = Utf8 Lde/audi/app/phone/core/bap/TelBapNetworkProviderStruct; 
.const [105] = Utf8 de/audi/app/phone/core/bap/TelBapNetworkProviderStruct 
.const [106] = Utf8 equals 
.const [107] = Utf8 (Ljava/lang/Object;)Z 
.const [108] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelNetworkProvider 
.const [109] = Utf8 log 
.const [110] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [111] = Utf8 de/audi/atip/log/LogChannel 
.const [112] = Utf8 log 
.const [113] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [114] = Utf8 de/audi/app/phone/core/bap/TelBapNetworkProviderStruct 
.const [115] = Utf8 getNetworkProviderState 
.const [116] = Utf8 ()I 
.const [117] = Utf8 de/audi/app/phone/core/bap/TelBapNetworkProviderStruct 
.const [118] = Utf8 getNetworkProviderName 
.const [119] = Utf8 ()Ljava/lang/String; 
.const [120] = Utf8 de/audi/app/phone/core/bap/TelBapNetworkProviderStruct 
.const [121] = Utf8 getServiceProviderState 
.const [122] = Utf8 ()I 
.const [123] = Utf8 de/audi/app/phone/core/bap/TelBapNetworkProviderStruct 
.const [124] = Utf8 getServiceProviderName 
.const [125] = Utf8 ()Ljava/lang/String; 
.const [126] = Utf8 de/audi/atip/log/LogChannel 
.const [127] = Utf8 log 
.const [128] = Utf8 (ILjava/lang/String;)Z 
.const [129] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [130] = Utf8 <init> 
.const [131] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [132] = Utf8 de/audi/app/phone/core/bap/TelBapNetworkProviderStruct 
.const [133] = Utf8 <init> 
.const [134] = Utf8 (ILjava/lang/String;ILjava/lang/String;)V 
.const [135] = Utf8 de/audi/app/phone/core/state/IGlobalTelephoneStateStruct 
.const [136] = Utf8 getCallLeadingDevice 
.const [137] = Utf8 ()Lde/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState; 
.const [138] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [139] = Utf8 getServiceProvider 
.const [140] = Utf8 ()Lorg/dsi/ifc/telephoneng/ServiceProvider; 
.const [141] = Utf8 de/audi/app/phone/core/dsi/ITelDSIMobileEquipmentDeviceState 
.const [142] = Utf8 getDisplayNetworkName 
.const [143] = Utf8 ()Ljava/lang/String; 
.const [144] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelNetworkProvider 
.const [145] = Utf8 networkProviderStruct 
.const [146] = Utf8 Lde/audi/app/phone/core/bap/TelBapNetworkProviderStruct; 
.const [147] = Utf8 de/audi/atip/interapp/combi/bap/phone/CombiBAPServicePhone 
.const [148] = Utf8 updateNetworkProvider 
.const [149] = Utf8 (ILjava/lang/String;ILjava/lang/String;)V 
.const [150] = Utf8 de/audi/app/phone/core/bap/telephone/BAPPropertyTelNetworkProvider 
.const [151] = Class [150] 
.const [152] = Utf8 de/audi/app/phone/core/bap/AbstractTel1EnqueuedBAPPropertyHandler 
.const [153] = Class [152] 
.const [154] = Utf8 networkProviderStruct 
.const [155] = Utf8 Lde/audi/app/phone/core/bap/TelBapNetworkProviderStruct; 
.const [156] = Utf8 Code 
.const [157] = Utf8 <init> 
.const [158] = Utf8 (Lde/audi/app/phone/core/ITelApplication;Lde/esolutions/fw/util/commons/job/DispatcherBase;)V 
.const [159] = Utf8 doProcessGlobalTelephoneStateUpdate 
.const [160] = Utf8 (ILde/audi/app/phone/core/state/IGlobalTelephoneStateStruct;)Z 
.const [161] = Utf8 updateAsync 
.const [162] = Utf8 ()V 
.end class 
