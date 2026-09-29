.version 50 0 
.class public super [171] 
.super [173] 
.implements [175] 
.field private final [176] [177] 
.field private final [178] [179] 
.field private final [180] [181] 
.field private final [182] [183] 
.field private final [184] [185] 
.field [186] [187] 

.method public [189] : [190] 
    .attribute [188] .code stack 3 locals 0 
L0:     aload_0 
L1:     iconst_0 
L2:     iconst_0 
L3:     invokespecial [23] 
L6:     return 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [191] : [192] 
    .attribute [188] .code stack 4 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     iload_2 
L3:     iconst_m1 
L4:     invokespecial [24] 
L7:     return 
L8:     
    .end code 
.end method 

.method public [193] : [194] 
    .attribute [188] .code stack 5 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     iload_2 
L3:     iload_3 
L4:     aconst_null 
L5:     invokespecial [25] 
L8:     return 
L9:     nop 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [195] : [196] 
    .attribute [188] .code stack 7 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     iload_2 
L3:     iconst_0 
L4:     iload_3 
L5:     invokestatic [2] 
L8:     aload 4 
L10:    invokespecial [26] 
L13:    return 
L14:    nop 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [197] : [198] 
    .attribute [188] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [27] 
L4:     aload_0 
L5:     iload_1 
L6:     putfield [29] 
L9:     aload_0 
L10:    iload_2 
L11:    putfield [30] 
L14:    aload_0 
L15:    iload_3 
L16:    putfield [31] 
L19:    aload_0 
L20:    iload 4 
L22:    putfield [32] 
L25:    aload_0 
L26:    aload 5 
L28:    putfield [33] 
L31:    aload_0 
L32:    aload 6 
L34:    putfield [34] 
L37:    return 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public interface [199] : [200] 
    .attribute [188] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [11] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [201] : [202] 
    .attribute [188] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [12] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [203] : [204] 
    .attribute [188] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [205] : [206] 
    .attribute [188] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [14] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [207] : [208] 
    .attribute [188] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [209] : [210] 
    .attribute [188] .code stack 1 locals 0 
L0:     iconst_0 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [211] : [212] 
    .attribute [188] .code stack 2 locals 0 
L0:     new [35] 
L3:     dup 
L4:     invokespecial [28] 
L7:     ldc [4] 
L9:     invokevirtual [17] 
L12:    aload_0 
L13:    getfield [12] 
L16:    invokevirtual [18] 
L19:    ldc [5] 
L21:    invokevirtual [17] 
L24:    aload_0 
L25:    getfield [11] 
L28:    invokevirtual [18] 
L31:    ldc [6] 
L33:    invokevirtual [17] 
L36:    aload_0 
L37:    getfield [14] 
L40:    invokevirtual [19] 
L43:    ldc [7] 
L45:    invokevirtual [17] 
L48:    invokevirtual [20] 
L51:    areturn 
L52:    
    .end code 
.end method 

.method public [213] : [214] 
    .attribute [188] .code stack 1 locals 0 
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

.method public [215] : [216] 
    .attribute [188] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     ifnull L21 
L7:     aload_0 
L8:     getfield [15] 
L11:    invokevirtual [22] 
L14:    ifeq L21 
L17:    iconst_1 
L18:    goto L22 
L21:    iconst_0 
L22:    areturn 
L23:    nop 
L24:    
    .end code 
.end method 

.method public interface [217] : [218] 
    .attribute [188] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [219] : [220] 
    .attribute [188] .code stack 1 locals 0 
L0:     aconst_null 
L1:     areturn 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [36] [37] 
.const [3] = Class [38] 
.const [4] = String [39] 
.const [5] = String [40] 
.const [6] = String [41] 
.const [7] = String [42] 
.const [8] = Class [43] 
.const [9] = Class [44] 
.const [10] = Class [45] 
.const [11] = Field [46] [47] 
.const [12] = Field [48] [49] 
.const [13] = Field [50] [51] 
.const [14] = Field [52] [53] 
.const [15] = Field [54] [55] 
.const [16] = Field [56] [57] 
.const [17] = Method [58] [59] 
.const [18] = Method [60] [61] 
.const [19] = Method [62] [63] 
.const [20] = Method [64] [65] 
.const [21] = Method [66] [67] 
.const [22] = Method [68] [69] 
.const [23] = Method [70] [71] 
.const [24] = Method [72] [73] 
.const [25] = Method [74] [75] 
.const [26] = Method [76] [77] 
.const [27] = Method [78] [79] 
.const [28] = Method [80] [81] 
.const [29] = Field [82] [83] 
.const [30] = Field [84] [85] 
.const [31] = Field [86] [87] 
.const [32] = Field [88] [89] 
.const [33] = Field [90] [91] 
.const [34] = Field [92] [93] 
.const [35] = Class [94] 
.const [36] = Class [95] 
.const [37] = NameAndType [96] [97] 
.const [38] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [39] = Utf8 'NullEcallState [isServiceActive=' 
.const [40] = Utf8 ', hasActiveCall=' 
.const [41] = Utf8 ', serviceKind=' 
.const [42] = Utf8 ']' 
.const [43] = Utf8 de/audi/app/phone/core/state/NullEcallState 
.const [44] = Utf8 java/lang/Object 
.const [45] = Utf8 de/audi/atip/interapp/bap/ecall/data/PhoneCall 
.const [46] = Class [98] 
.const [47] = NameAndType [99] [100] 
.const [48] = Class [101] 
.const [49] = NameAndType [102] [103] 
.const [50] = Class [104] 
.const [51] = NameAndType [105] [106] 
.const [52] = Class [107] 
.const [53] = NameAndType [108] [109] 
.const [54] = Class [110] 
.const [55] = NameAndType [111] [112] 
.const [56] = Class [113] 
.const [57] = NameAndType [114] [115] 
.const [58] = Class [116] 
.const [59] = NameAndType [117] [118] 
.const [60] = Class [119] 
.const [61] = NameAndType [120] [121] 
.const [62] = Class [122] 
.const [63] = NameAndType [123] [124] 
.const [64] = Class [125] 
.const [65] = NameAndType [126] [127] 
.const [66] = Class [128] 
.const [67] = NameAndType [129] [130] 
.const [68] = Class [131] 
.const [69] = NameAndType [132] [133] 
.const [70] = Class [134] 
.const [71] = NameAndType [135] [136] 
.const [72] = Class [137] 
.const [73] = NameAndType [138] [139] 
.const [74] = Class [140] 
.const [75] = NameAndType [141] [142] 
.const [76] = Class [143] 
.const [77] = NameAndType [144] [145] 
.const [78] = Class [146] 
.const [79] = NameAndType [147] [148] 
.const [80] = Class [149] 
.const [81] = NameAndType [150] [151] 
.const [82] = Class [152] 
.const [83] = NameAndType [153] [154] 
.const [84] = Class [155] 
.const [85] = NameAndType [156] [157] 
.const [86] = Class [158] 
.const [87] = NameAndType [159] [160] 
.const [88] = Class [161] 
.const [89] = NameAndType [162] [163] 
.const [90] = Class [164] 
.const [91] = NameAndType [165] [166] 
.const [92] = Class [167] 
.const [93] = NameAndType [168] [169] 
.const [94] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [95] = Utf8 de/audi/atip/interapp/bap/ecall/data/PhoneCall 
.const [96] = Utf8 getNullInstance 
.const [97] = Utf8 ()Lde/audi/atip/interapp/bap/ecall/data/PhoneCall; 
.const [98] = Utf8 de/audi/app/phone/core/state/NullEcallState 
.const [99] = Utf8 hasActiveCall 
.const [100] = Utf8 Z 
.const [101] = Utf8 de/audi/app/phone/core/state/NullEcallState 
.const [102] = Utf8 isServiceActive 
.const [103] = Utf8 Z 
.const [104] = Utf8 de/audi/app/phone/core/state/NullEcallState 
.const [105] = Utf8 isEmergencyCallType 
.const [106] = Utf8 Z 
.const [107] = Utf8 de/audi/app/phone/core/state/NullEcallState 
.const [108] = Utf8 serviceKind 
.const [109] = Utf8 I 
.const [110] = Utf8 de/audi/app/phone/core/state/NullEcallState 
.const [111] = Utf8 phoneCall 
.const [112] = Utf8 Lde/audi/atip/interapp/bap/ecall/data/PhoneCall; 
.const [113] = Utf8 de/audi/app/phone/core/state/NullEcallState 
.const [114] = Utf8 emergencyNumbers 
.const [115] = Utf8 [Lde/audi/atip/interapp/bap/ecall/data/EmergencyNumber; 
.const [116] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [117] = Utf8 append 
.const [118] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [119] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [120] = Utf8 append 
.const [121] = Utf8 (Z)Lde/esolutions/fw/util/commons/Buffer; 
.const [122] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [123] = Utf8 append 
.const [124] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [125] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [126] = Utf8 toString 
.const [127] = Utf8 ()Ljava/lang/String; 
.const [128] = Utf8 de/audi/app/phone/core/state/NullEcallState 
.const [129] = Utf8 isCustomerCallNotAllowed 
.const [130] = Utf8 ()Z 
.const [131] = Utf8 de/audi/atip/interapp/bap/ecall/data/PhoneCall 
.const [132] = Utf8 isLowPrioritySOSCall 
.const [133] = Utf8 ()Z 
.const [134] = Utf8 de/audi/app/phone/core/state/NullEcallState 
.const [135] = Utf8 <init> 
.const [136] = Utf8 (ZZ)V 
.const [137] = Utf8 de/audi/app/phone/core/state/NullEcallState 
.const [138] = Utf8 <init> 
.const [139] = Utf8 (ZZI)V 
.const [140] = Utf8 de/audi/app/phone/core/state/NullEcallState 
.const [141] = Utf8 <init> 
.const [142] = Utf8 (ZZI[Lde/audi/atip/interapp/bap/ecall/data/EmergencyNumber;)V 
.const [143] = Utf8 de/audi/app/phone/core/state/NullEcallState 
.const [144] = Utf8 <init> 
.const [145] = Utf8 (ZZZILde/audi/atip/interapp/bap/ecall/data/PhoneCall;[Lde/audi/atip/interapp/bap/ecall/data/EmergencyNumber;)V 
.const [146] = Utf8 java/lang/Object 
.const [147] = Utf8 <init> 
.const [148] = Utf8 ()V 
.const [149] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [150] = Utf8 <init> 
.const [151] = Utf8 ()V 
.const [152] = Utf8 de/audi/app/phone/core/state/NullEcallState 
.const [153] = Utf8 hasActiveCall 
.const [154] = Utf8 Z 
.const [155] = Utf8 de/audi/app/phone/core/state/NullEcallState 
.const [156] = Utf8 isServiceActive 
.const [157] = Utf8 Z 
.const [158] = Utf8 de/audi/app/phone/core/state/NullEcallState 
.const [159] = Utf8 isEmergencyCallType 
.const [160] = Utf8 Z 
.const [161] = Utf8 de/audi/app/phone/core/state/NullEcallState 
.const [162] = Utf8 serviceKind 
.const [163] = Utf8 I 
.const [164] = Utf8 de/audi/app/phone/core/state/NullEcallState 
.const [165] = Utf8 phoneCall 
.const [166] = Utf8 Lde/audi/atip/interapp/bap/ecall/data/PhoneCall; 
.const [167] = Utf8 de/audi/app/phone/core/state/NullEcallState 
.const [168] = Utf8 emergencyNumbers 
.const [169] = Utf8 [Lde/audi/atip/interapp/bap/ecall/data/EmergencyNumber; 
.const [170] = Utf8 de/audi/app/phone/core/state/NullEcallState 
.const [171] = Class [170] 
.const [172] = Utf8 java/lang/Object 
.const [173] = Class [172] 
.const [174] = Utf8 de/audi/atip/interapp/phone/IEcallState 
.const [175] = Class [174] 
.const [176] = Utf8 hasActiveCall 
.const [177] = Utf8 Z 
.const [178] = Utf8 isServiceActive 
.const [179] = Utf8 Z 
.const [180] = Utf8 isEmergencyCallType 
.const [181] = Utf8 Z 
.const [182] = Utf8 serviceKind 
.const [183] = Utf8 I 
.const [184] = Utf8 phoneCall 
.const [185] = Utf8 Lde/audi/atip/interapp/bap/ecall/data/PhoneCall; 
.const [186] = Utf8 emergencyNumbers 
.const [187] = Utf8 [Lde/audi/atip/interapp/bap/ecall/data/EmergencyNumber; 
.const [188] = Utf8 Code 
.const [189] = Utf8 <init> 
.const [190] = Utf8 ()V 
.const [191] = Utf8 <init> 
.const [192] = Utf8 (ZZ)V 
.const [193] = Utf8 <init> 
.const [194] = Utf8 (ZZI)V 
.const [195] = Utf8 <init> 
.const [196] = Utf8 (ZZI[Lde/audi/atip/interapp/bap/ecall/data/EmergencyNumber;)V 
.const [197] = Utf8 <init> 
.const [198] = Utf8 (ZZZILde/audi/atip/interapp/bap/ecall/data/PhoneCall;[Lde/audi/atip/interapp/bap/ecall/data/EmergencyNumber;)V 
.const [199] = Utf8 hasActiveCall 
.const [200] = Utf8 ()Z 
.const [201] = Utf8 isServiceActive 
.const [202] = Utf8 ()Z 
.const [203] = Utf8 getCall 
.const [204] = Utf8 ()Lde/audi/atip/interapp/bap/ecall/data/PhoneCall; 
.const [205] = Utf8 getServiceKind 
.const [206] = Utf8 ()I 
.const [207] = Utf8 isEmergencyCallType 
.const [208] = Utf8 ()Z 
.const [209] = Utf8 isCustomerCallNotAllowed 
.const [210] = Utf8 ()Z 
.const [211] = Utf8 toString 
.const [212] = Utf8 ()Ljava/lang/String; 
.const [213] = Utf8 isCustomerCallAllowed 
.const [214] = Utf8 ()Z 
.const [215] = Utf8 isLowPrioritySOSEmergencyCallType 
.const [216] = Utf8 ()Z 
.const [217] = Utf8 getAllowedEmergencyNumbers 
.const [218] = Utf8 ()[Lde/audi/atip/interapp/bap/ecall/data/EmergencyNumber; 
.const [219] = Utf8 getEmergencyNumberToBeDialed 
.const [220] = Utf8 ()Ljava/lang/String; 
.end class 
