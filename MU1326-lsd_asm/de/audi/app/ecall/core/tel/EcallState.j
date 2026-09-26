.version 50 0 
.class super [197] 
.super [199] 
.implements [201] 
.field private final [202] [203] 
.field private final [204] [205] 
.field private final [206] [207] 
.field private final [208] [209] 
.field private final [210] [211] 
.field private final [212] [213] 

.method public [215] : [216] 
    .attribute [214] .code stack 2 locals 1 
L0:     aload_0 
L1:     invokespecial [26] 
L4:     aload_0 
L5:     aload_1 
L6:     invokeinterface [28] 0 
L11:    putfield [29] 
L14:    aload_0 
L15:    aload_1 
L16:    invokeinterface [30] 0 
L21:    putfield [31] 
L24:    aload_0 
L25:    aload_1 
L26:    invokeinterface [32] 0 
L31:    putfield [33] 
L34:    aload_1 
L35:    invokeinterface [34] 0 
L40:    astore_2 
L41:    aload_0 
L42:    aload_2 
L43:    ifnonnull L52 
L46:    invokestatic [2] 
L49:    goto L53 
L52:    aload_2 
L53:    putfield [35] 
L56:    aload_0 
L57:    aload_1 
L58:    invokeinterface [36] 0 
L63:    putfield [37] 
L66:    aload_0 
L67:    aload_1 
L68:    invokeinterface [38] 0 
L73:    putfield [39] 
L76:    return 
L77:    nop 
L78:    nop 
L79:    nop 
L80:    
    .end code 
.end method 

.method public interface [217] : [218] 
    .attribute [214] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [219] : [220] 
    .attribute [214] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [221] : [222] 
    .attribute [214] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [223] : [224] 
    .attribute [214] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     iconst_5 
L5:     if_icmpeq L16 
L8:     aload_0 
L9:     getfield [14] 
L12:    iconst_4 
L13:    if_icmpne L20 
L16:    iconst_1 
L17:    goto L21 
L20:    iconst_0 
L21:    areturn 
L22:    nop 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [225] : [226] 
    .attribute [214] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     ifnull L21 
L7:     aload_0 
L8:     getfield [15] 
L11:    invokevirtual [18] 
L14:    ifeq L21 
L17:    iconst_1 
L18:    goto L22 
L21:    iconst_0 
L22:    areturn 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [227] : [228] 
    .attribute [214] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     ifeq L25 
L7:     aload_0 
L8:     invokevirtual [19] 
L11:    ifne L21 
L14:    aload_0 
L15:    invokevirtual [20] 
L18:    ifeq L25 
L21:    iconst_1 
L22:    goto L26 
L25:    iconst_0 
L26:    areturn 
L27:    nop 
L28:    
    .end code 
.end method 

.method public [229] : [230] 
    .attribute [214] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokevirtual [21] 
L4:     ifne L11 
L7:     iconst_1 
L8:     goto L12 
L11:    iconst_0 
L12:    areturn 
L13:    nop 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public interface [231] : [232] 
    .attribute [214] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [233] : [234] 
    .attribute [214] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [235] : [236] 
    .attribute [214] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [17] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [237] : [238] 
    .attribute [214] .code stack 2 locals 0 
L0:     new [40] 
L3:     dup 
L4:     invokespecial [27] 
L7:     ldc [4] 
L9:     invokevirtual [22] 
L12:    aload_0 
L13:    getfield [13] 
L16:    invokevirtual [23] 
L19:    ldc [5] 
L21:    invokevirtual [22] 
L24:    aload_0 
L25:    getfield [12] 
L28:    invokevirtual [23] 
L31:    ldc [6] 
L33:    invokevirtual [22] 
L36:    aload_0 
L37:    getfield [14] 
L40:    invokevirtual [24] 
L43:    ldc [7] 
L45:    invokevirtual [22] 
L48:    invokevirtual [25] 
L51:    areturn 
L52:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [41] [42] 
.const [3] = Class [43] 
.const [4] = String [44] 
.const [5] = String [45] 
.const [6] = String [46] 
.const [7] = String [47] 
.const [8] = Class [48] 
.const [9] = Class [49] 
.const [10] = Class [50] 
.const [11] = Class [51] 
.const [12] = Field [52] [53] 
.const [13] = Field [54] [55] 
.const [14] = Field [56] [57] 
.const [15] = Field [58] [59] 
.const [16] = Field [60] [61] 
.const [17] = Field [62] [63] 
.const [18] = Method [64] [65] 
.const [19] = Method [66] [67] 
.const [20] = Method [68] [69] 
.const [21] = Method [70] [71] 
.const [22] = Method [72] [73] 
.const [23] = Method [74] [75] 
.const [24] = Method [76] [77] 
.const [25] = Method [78] [79] 
.const [26] = Method [80] [81] 
.const [27] = Method [82] [83] 
.const [28] = InterfaceMethod [84] [85] 
.const [29] = Field [86] [87] 
.const [30] = InterfaceMethod [88] [89] 
.const [31] = Field [90] [91] 
.const [32] = InterfaceMethod [92] [93] 
.const [33] = Field [94] [95] 
.const [34] = InterfaceMethod [96] [97] 
.const [35] = Field [98] [99] 
.const [36] = InterfaceMethod [100] [101] 
.const [37] = Field [102] [103] 
.const [38] = InterfaceMethod [104] [105] 
.const [39] = Field [106] [107] 
.const [40] = Class [108] 
.const [41] = Class [109] 
.const [42] = NameAndType [110] [111] 
.const [43] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [44] = Utf8 'EcallState [isServiceActive=' 
.const [45] = Utf8 ', hasActiveCall=' 
.const [46] = Utf8 ', serviceKind=' 
.const [47] = Utf8 ']' 
.const [48] = Utf8 de/audi/app/ecall/core/tel/EcallState 
.const [49] = Utf8 java/lang/Object 
.const [50] = Utf8 de/audi/app/ecall/core/state/IEcallStateStruct 
.const [51] = Utf8 de/audi/atip/interapp/bap/ecall/data/PhoneCall 
.const [52] = Class [112] 
.const [53] = NameAndType [113] [114] 
.const [54] = Class [115] 
.const [55] = NameAndType [116] [117] 
.const [56] = Class [118] 
.const [57] = NameAndType [119] [120] 
.const [58] = Class [121] 
.const [59] = NameAndType [122] [123] 
.const [60] = Class [124] 
.const [61] = NameAndType [125] [126] 
.const [62] = Class [127] 
.const [63] = NameAndType [128] [129] 
.const [64] = Class [130] 
.const [65] = NameAndType [131] [132] 
.const [66] = Class [133] 
.const [67] = NameAndType [134] [135] 
.const [68] = Class [136] 
.const [69] = NameAndType [137] [138] 
.const [70] = Class [139] 
.const [71] = NameAndType [140] [141] 
.const [72] = Class [142] 
.const [73] = NameAndType [143] [144] 
.const [74] = Class [145] 
.const [75] = NameAndType [146] [147] 
.const [76] = Class [148] 
.const [77] = NameAndType [149] [150] 
.const [78] = Class [151] 
.const [79] = NameAndType [152] [153] 
.const [80] = Class [154] 
.const [81] = NameAndType [155] [156] 
.const [82] = Class [157] 
.const [83] = NameAndType [158] [159] 
.const [84] = Class [160] 
.const [85] = NameAndType [161] [162] 
.const [86] = Class [163] 
.const [87] = NameAndType [164] [165] 
.const [88] = Class [166] 
.const [89] = NameAndType [167] [168] 
.const [90] = Class [169] 
.const [91] = NameAndType [170] [171] 
.const [92] = Class [172] 
.const [93] = NameAndType [173] [174] 
.const [94] = Class [175] 
.const [95] = NameAndType [176] [177] 
.const [96] = Class [178] 
.const [97] = NameAndType [179] [180] 
.const [98] = Class [181] 
.const [99] = NameAndType [182] [183] 
.const [100] = Class [184] 
.const [101] = NameAndType [185] [186] 
.const [102] = Class [187] 
.const [103] = NameAndType [188] [189] 
.const [104] = Class [190] 
.const [105] = NameAndType [191] [192] 
.const [106] = Class [193] 
.const [107] = NameAndType [194] [195] 
.const [108] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [109] = Utf8 de/audi/atip/interapp/bap/ecall/data/PhoneCall 
.const [110] = Utf8 getNullInstance 
.const [111] = Utf8 ()Lde/audi/atip/interapp/bap/ecall/data/PhoneCall; 
.const [112] = Utf8 de/audi/app/ecall/core/tel/EcallState 
.const [113] = Utf8 hasActiveCall 
.const [114] = Utf8 Z 
.const [115] = Utf8 de/audi/app/ecall/core/tel/EcallState 
.const [116] = Utf8 isServiceActive 
.const [117] = Utf8 Z 
.const [118] = Utf8 de/audi/app/ecall/core/tel/EcallState 
.const [119] = Utf8 serviceKind 
.const [120] = Utf8 I 
.const [121] = Utf8 de/audi/app/ecall/core/tel/EcallState 
.const [122] = Utf8 phoneCall 
.const [123] = Utf8 Lde/audi/atip/interapp/bap/ecall/data/PhoneCall; 
.const [124] = Utf8 de/audi/app/ecall/core/tel/EcallState 
.const [125] = Utf8 emergencyNumberToBeDialed 
.const [126] = Utf8 Ljava/lang/String; 
.const [127] = Utf8 de/audi/app/ecall/core/tel/EcallState 
.const [128] = Utf8 allowedEmergencyNumbers 
.const [129] = Utf8 [Lde/audi/atip/interapp/bap/ecall/data/EmergencyNumber; 
.const [130] = Utf8 de/audi/atip/interapp/bap/ecall/data/PhoneCall 
.const [131] = Utf8 isLowPrioritySOSCall 
.const [132] = Utf8 ()Z 
.const [133] = Utf8 de/audi/app/ecall/core/tel/EcallState 
.const [134] = Utf8 isEmergencyCallType 
.const [135] = Utf8 ()Z 
.const [136] = Utf8 de/audi/app/ecall/core/tel/EcallState 
.const [137] = Utf8 isLowPrioritySOSEmergencyCallType 
.const [138] = Utf8 ()Z 
.const [139] = Utf8 de/audi/app/ecall/core/tel/EcallState 
.const [140] = Utf8 isCustomerCallNotAllowed 
.const [141] = Utf8 ()Z 
.const [142] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [143] = Utf8 append 
.const [144] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [145] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [146] = Utf8 append 
.const [147] = Utf8 (Z)Lde/esolutions/fw/util/commons/Buffer; 
.const [148] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [149] = Utf8 append 
.const [150] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [151] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [152] = Utf8 toString 
.const [153] = Utf8 ()Ljava/lang/String; 
.const [154] = Utf8 java/lang/Object 
.const [155] = Utf8 <init> 
.const [156] = Utf8 ()V 
.const [157] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [158] = Utf8 <init> 
.const [159] = Utf8 ()V 
.const [160] = Utf8 de/audi/app/ecall/core/state/IEcallStateStruct 
.const [161] = Utf8 isCallActive 
.const [162] = Utf8 ()Z 
.const [163] = Utf8 de/audi/app/ecall/core/tel/EcallState 
.const [164] = Utf8 hasActiveCall 
.const [165] = Utf8 Z 
.const [166] = Utf8 de/audi/app/ecall/core/state/IEcallStateStruct 
.const [167] = Utf8 isServiceActive 
.const [168] = Utf8 ()Z 
.const [169] = Utf8 de/audi/app/ecall/core/tel/EcallState 
.const [170] = Utf8 isServiceActive 
.const [171] = Utf8 Z 
.const [172] = Utf8 de/audi/app/ecall/core/state/IEcallStateStruct 
.const [173] = Utf8 getServiceCallKind 
.const [174] = Utf8 ()I 
.const [175] = Utf8 de/audi/app/ecall/core/tel/EcallState 
.const [176] = Utf8 serviceKind 
.const [177] = Utf8 I 
.const [178] = Utf8 de/audi/app/ecall/core/state/IEcallStateStruct 
.const [179] = Utf8 getCurrentPhoneCall 
.const [180] = Utf8 ()Lde/audi/atip/interapp/bap/ecall/data/PhoneCall; 
.const [181] = Utf8 de/audi/app/ecall/core/tel/EcallState 
.const [182] = Utf8 phoneCall 
.const [183] = Utf8 Lde/audi/atip/interapp/bap/ecall/data/PhoneCall; 
.const [184] = Utf8 de/audi/app/ecall/core/state/IEcallStateStruct 
.const [185] = Utf8 getEmergencyNumberToBeDialed 
.const [186] = Utf8 ()Ljava/lang/String; 
.const [187] = Utf8 de/audi/app/ecall/core/tel/EcallState 
.const [188] = Utf8 emergencyNumberToBeDialed 
.const [189] = Utf8 Ljava/lang/String; 
.const [190] = Utf8 de/audi/app/ecall/core/state/IEcallStateStruct 
.const [191] = Utf8 getAllowedEmergencyNumbersList 
.const [192] = Utf8 ()[Lde/audi/atip/interapp/bap/ecall/data/EmergencyNumber; 
.const [193] = Utf8 de/audi/app/ecall/core/tel/EcallState 
.const [194] = Utf8 allowedEmergencyNumbers 
.const [195] = Utf8 [Lde/audi/atip/interapp/bap/ecall/data/EmergencyNumber; 
.const [196] = Utf8 de/audi/app/ecall/core/tel/EcallState 
.const [197] = Class [196] 
.const [198] = Utf8 java/lang/Object 
.const [199] = Class [198] 
.const [200] = Utf8 de/audi/atip/interapp/phone/IEcallState 
.const [201] = Class [200] 
.const [202] = Utf8 hasActiveCall 
.const [203] = Utf8 Z 
.const [204] = Utf8 isServiceActive 
.const [205] = Utf8 Z 
.const [206] = Utf8 serviceKind 
.const [207] = Utf8 I 
.const [208] = Utf8 phoneCall 
.const [209] = Utf8 Lde/audi/atip/interapp/bap/ecall/data/PhoneCall; 
.const [210] = Utf8 emergencyNumberToBeDialed 
.const [211] = Utf8 Ljava/lang/String; 
.const [212] = Utf8 allowedEmergencyNumbers 
.const [213] = Utf8 [Lde/audi/atip/interapp/bap/ecall/data/EmergencyNumber; 
.const [214] = Utf8 Code 
.const [215] = Utf8 <init> 
.const [216] = Utf8 (Lde/audi/app/ecall/core/state/IEcallStateStruct;)V 
.const [217] = Utf8 hasActiveCall 
.const [218] = Utf8 ()Z 
.const [219] = Utf8 isServiceActive 
.const [220] = Utf8 ()Z 
.const [221] = Utf8 getCall 
.const [222] = Utf8 ()Lde/audi/atip/interapp/bap/ecall/data/PhoneCall; 
.const [223] = Utf8 isEmergencyCallType 
.const [224] = Utf8 ()Z 
.const [225] = Utf8 isLowPrioritySOSEmergencyCallType 
.const [226] = Utf8 ()Z 
.const [227] = Utf8 isCustomerCallNotAllowed 
.const [228] = Utf8 ()Z 
.const [229] = Utf8 isCustomerCallAllowed 
.const [230] = Utf8 ()Z 
.const [231] = Utf8 getServiceKind 
.const [232] = Utf8 ()I 
.const [233] = Utf8 getEmergencyNumberToBeDialed 
.const [234] = Utf8 ()Ljava/lang/String; 
.const [235] = Utf8 getAllowedEmergencyNumbers 
.const [236] = Utf8 ()[Lde/audi/atip/interapp/bap/ecall/data/EmergencyNumber; 
.const [237] = Utf8 toString 
.const [238] = Utf8 ()Ljava/lang/String; 
.end class 
