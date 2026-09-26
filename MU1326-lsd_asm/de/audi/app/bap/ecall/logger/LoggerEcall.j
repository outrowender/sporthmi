.version 50 0 
.class public final super [77] 
.super [79] 
.field private static final [80] [81] 
.field private static final [82] [83] 
.field private static final [84] [85] 
.field private final [86] [87] 
.field private final [88] [89] 

.method public [91] : [92] 
    .attribute [90] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [15] 
L4:     aload_1 
L5:     ldc [2] 
L7:     invokestatic [3] 
L10:    aload_0 
L11:    aload_1 
L12:    ldc [4] 
L14:    invokestatic [5] 
L17:    invokeinterface [16] 0 
L22:    putfield [17] 
L25:    aload_0 
L26:    aload_1 
L27:    ldc [6] 
L29:    invokestatic [5] 
L32:    invokeinterface [16] 0 
L37:    putfield [18] 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [93] : [94] 
    .attribute [90] .code stack 1 locals 1 
L0:     iload_1 
L1:     lookupswitch 
            51 : L20 
            default : L28 

L20:    aload_0 
L21:    getfield [13] 
L24:    astore_2 
L25:    goto L32 
L28:    getstatic [7] 
L31:    astore_2 
L32:    aload_2 
L33:    ifnonnull L40 
L36:    invokestatic [8] 
L39:    areturn 
L40:    aload_2 
L41:    areturn 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 

.method public [95] : [96] 
    .attribute [90] .code stack 1 locals 1 
L0:     iload_1 
L1:     lookupswitch 
            51 : L20 
            default : L28 

L20:    aload_0 
L21:    getfield [14] 
L24:    astore_2 
L25:    goto L32 
L28:    getstatic [7] 
L31:    astore_2 
L32:    aload_2 
L33:    ifnonnull L40 
L36:    invokestatic [8] 
L39:    areturn 
L40:    aload_2 
L41:    areturn 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [19] 
.const [3] = Method [20] [21] 
.const [4] = String [22] 
.const [5] = Method [23] [24] 
.const [6] = String [25] 
.const [7] = Field [26] [27] 
.const [8] = Method [28] [29] 
.const [9] = Class [30] 
.const [10] = Class [31] 
.const [11] = Class [32] 
.const [12] = Class [33] 
.const [13] = Field [34] [35] 
.const [14] = Field [36] [37] 
.const [15] = Method [38] [39] 
.const [16] = InterfaceMethod [40] [41] 
.const [17] = Field [42] [43] 
.const [18] = Field [44] [45] 
.const [19] = Utf8 'App.BAPEcall' 
.const [20] = Class [46] 
.const [21] = NameAndType [47] [48] 
.const [22] = Utf8 Ecall 
.const [23] = Class [49] 
.const [24] = NameAndType [50] [51] 
.const [25] = Utf8 'Ecall.BAPData' 
.const [26] = Class [52] 
.const [27] = NameAndType [53] [54] 
.const [28] = Class [55] 
.const [29] = NameAndType [56] [57] 
.const [30] = Utf8 de/audi/app/bap/ecall/logger/LoggerEcall 
.const [31] = Utf8 de/audi/app/bap/utils/AbstractBAPLogger 
.const [32] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [33] = Utf8 de/audi/atip/log/NullLogChannel 
.const [34] = Class [58] 
.const [35] = NameAndType [59] [60] 
.const [36] = Class [61] 
.const [37] = NameAndType [62] [63] 
.const [38] = Class [64] 
.const [39] = NameAndType [65] [66] 
.const [40] = Class [67] 
.const [41] = NameAndType [68] [69] 
.const [42] = Class [70] 
.const [43] = NameAndType [71] [72] 
.const [44] = Class [73] 
.const [45] = NameAndType [74] [75] 
.const [46] = Utf8 de/audi/app/bap/utils/AbstractBAPLogger 
.const [47] = Utf8 init 
.const [48] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;Ljava/lang/String;)V 
.const [49] = Utf8 de/audi/app/bap/ecall/logger/LoggerEcall 
.const [50] = Utf8 createLogChannelName 
.const [51] = Utf8 (Ljava/lang/String;)Ljava/lang/String; 
.const [52] = Utf8 de/audi/app/bap/ecall/logger/LoggerEcall 
.const [53] = Utf8 logMain 
.const [54] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [55] = Utf8 de/audi/atip/log/NullLogChannel 
.const [56] = Utf8 getInstance 
.const [57] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [58] = Utf8 de/audi/app/bap/ecall/logger/LoggerEcall 
.const [59] = Utf8 logEcall 
.const [60] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [61] = Utf8 de/audi/app/bap/ecall/logger/LoggerEcall 
.const [62] = Utf8 logEcallBAPData 
.const [63] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [64] = Utf8 de/audi/app/bap/utils/AbstractBAPLogger 
.const [65] = Utf8 <init> 
.const [66] = Utf8 ()V 
.const [67] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [68] = Utf8 getLogChannel 
.const [69] = Utf8 (Ljava/lang/String;)Lde/audi/atip/log/LogChannel; 
.const [70] = Utf8 de/audi/app/bap/ecall/logger/LoggerEcall 
.const [71] = Utf8 logEcall 
.const [72] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [73] = Utf8 de/audi/app/bap/ecall/logger/LoggerEcall 
.const [74] = Utf8 logEcallBAPData 
.const [75] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [76] = Utf8 de/audi/app/bap/ecall/logger/LoggerEcall 
.const [77] = Class [76] 
.const [78] = Utf8 de/audi/app/bap/utils/AbstractBAPLogger 
.const [79] = Class [78] 
.const [80] = Utf8 LOG_CH_PREFIX 
.const [81] = Utf8 Ljava/lang/String; 
.const [82] = Utf8 LOG_CH_ECALL 
.const [83] = Utf8 Ljava/lang/String; 
.const [84] = Utf8 LOG_CH_ECALL_BAPDATA 
.const [85] = Utf8 Ljava/lang/String; 
.const [86] = Utf8 logEcall 
.const [87] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [88] = Utf8 logEcallBAPData 
.const [89] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [90] = Utf8 Code 
.const [91] = Utf8 <init> 
.const [92] = Utf8 (Lde/audi/atip/base/IFrameworkAccess;)V 
.const [93] = Utf8 getLog 
.const [94] = Utf8 (I)Lde/audi/atip/log/LogChannel; 
.const [95] = Utf8 getLogBAPData 
.const [96] = Utf8 (I)Lde/audi/atip/log/LogChannel; 
.end class 
