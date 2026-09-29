.version 50 0 
.class public super [82] 
.super [84] 
.implements [86] 
.field private final [87] [88] 
.field private final [89] [90] 

.method public [92] : [93] 
    .attribute [91] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [15] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [18] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [19] 
L14:    aload_2 
L15:    ifnonnull L28 
L18:    new [20] 
L21:    dup 
L22:    ldc [3] 
L24:    invokespecial [16] 
L27:    athrow 
L28:    return 
L29:    nop 
L30:    nop 
L31:    nop 
L32:    
    .end code 
.end method 

.method public [94] : [95] 
    .attribute [91] .code stack 7 locals 2 
L0:     aload_0 
L1:     getfield [12] 
L4:     ldc [4] 
L6:     ldc [5] 
L8:     aload_0 
L9:     getfield [11] 
L12:    aload_1 
L13:    aload_1 
L14:    invokevirtual [13] 
L17:    l2i 
L18:    invokeinterface [21] 0 
        .catch [0] from L23 to L28 using L54 
L23:    aload_0 
L24:    aload_1 
L25:    invokespecial [17] 
L28:    aload_0 
L29:    getfield [12] 
L32:    ldc [4] 
L34:    ldc [6] 
L36:    aload_0 
L37:    getfield [11] 
L40:    aload_1 
L41:    aload_1 
L42:    invokevirtual [14] 
L45:    l2i 
L46:    invokeinterface [21] 0 
L51:    goto L80 
        .catch [0] from L54 to L55 using L54 
L54:    astore_2 
L55:    aload_0 
L56:    getfield [12] 
L59:    ldc [4] 
L61:    ldc [6] 
L63:    aload_0 
L64:    getfield [11] 
L67:    aload_1 
L68:    aload_1 
L69:    invokevirtual [14] 
L72:    l2i 
L73:    invokeinterface [21] 0 
L78:    aload_2 
L79:    athrow 
L80:    return 
L81:    nop 
L82:    nop 
L83:    nop 
L84:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [22] 
.const [3] = String [23] 
.const [4] = Int 1078071040 
.const [5] = String [24] 
.const [6] = String [25] 
.const [7] = Class [26] 
.const [8] = Class [27] 
.const [9] = Class [28] 
.const [10] = Class [29] 
.const [11] = Field [30] [31] 
.const [12] = Field [32] [33] 
.const [13] = Method [34] [35] 
.const [14] = Method [36] [37] 
.const [15] = Method [38] [39] 
.const [16] = Method [40] [41] 
.const [17] = Method [42] [43] 
.const [18] = Field [44] [45] 
.const [19] = Field [46] [47] 
.const [20] = Class [48] 
.const [21] = InterfaceMethod [49] [50] 
.const [22] = Utf8 java/lang/IllegalArgumentException 
.const [23] = Utf8 "LogInterceptor() parameter 'log' must not be null!" 
.const [24] = Utf8 '%1: dispatching %2, latency %3ms' 
.const [25] = Utf8 '%1: dispatching %2 done in %3ms' 
.const [26] = Utf8 de/esolutions/fw/util/commons/job/LogInterceptor 
.const [27] = Utf8 de/esolutions/fw/util/commons/job/BaseInterceptor 
.const [28] = Utf8 de/esolutions/fw/util/commons/job/Job 
.const [29] = Utf8 de/esolutions/fw/util/commons/job/IJobLogger 
.const [30] = Class [51] 
.const [31] = NameAndType [52] [53] 
.const [32] = Class [54] 
.const [33] = NameAndType [55] [56] 
.const [34] = Class [57] 
.const [35] = NameAndType [58] [59] 
.const [36] = Class [60] 
.const [37] = NameAndType [61] [62] 
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
.const [48] = Utf8 java/lang/IllegalArgumentException 
.const [49] = Class [78] 
.const [50] = NameAndType [79] [80] 
.const [51] = Utf8 de/esolutions/fw/util/commons/job/LogInterceptor 
.const [52] = Utf8 name 
.const [53] = Utf8 Ljava/lang/String; 
.const [54] = Utf8 de/esolutions/fw/util/commons/job/LogInterceptor 
.const [55] = Utf8 log 
.const [56] = Utf8 Lde/esolutions/fw/util/commons/job/IJobLogger; 
.const [57] = Utf8 de/esolutions/fw/util/commons/job/Job 
.const [58] = Utf8 getLatency 
.const [59] = Utf8 ()J 
.const [60] = Utf8 de/esolutions/fw/util/commons/job/Job 
.const [61] = Utf8 getNeeded 
.const [62] = Utf8 ()J 
.const [63] = Utf8 de/esolutions/fw/util/commons/job/BaseInterceptor 
.const [64] = Utf8 <init> 
.const [65] = Utf8 ()V 
.const [66] = Utf8 java/lang/IllegalArgumentException 
.const [67] = Utf8 <init> 
.const [68] = Utf8 (Ljava/lang/String;)V 
.const [69] = Utf8 de/esolutions/fw/util/commons/job/BaseInterceptor 
.const [70] = Utf8 execute 
.const [71] = Utf8 (Lde/esolutions/fw/util/commons/job/Job;)V 
.const [72] = Utf8 de/esolutions/fw/util/commons/job/LogInterceptor 
.const [73] = Utf8 name 
.const [74] = Utf8 Ljava/lang/String; 
.const [75] = Utf8 de/esolutions/fw/util/commons/job/LogInterceptor 
.const [76] = Utf8 log 
.const [77] = Utf8 Lde/esolutions/fw/util/commons/job/IJobLogger; 
.const [78] = Utf8 de/esolutions/fw/util/commons/job/IJobLogger 
.const [79] = Utf8 log 
.const [80] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;I)V 
.const [81] = Utf8 de/esolutions/fw/util/commons/job/LogInterceptor 
.const [82] = Class [81] 
.const [83] = Utf8 de/esolutions/fw/util/commons/job/BaseInterceptor 
.const [84] = Class [83] 
.const [85] = Utf8 de/esolutions/fw/util/commons/job/IInterceptor 
.const [86] = Class [85] 
.const [87] = Utf8 name 
.const [88] = Utf8 Ljava/lang/String; 
.const [89] = Utf8 log 
.const [90] = Utf8 Lde/esolutions/fw/util/commons/job/IJobLogger; 
.const [91] = Utf8 Code 
.const [92] = Utf8 <init> 
.const [93] = Utf8 (Ljava/lang/String;Lde/esolutions/fw/util/commons/job/IJobLogger;)V 
.const [94] = Utf8 execute 
.const [95] = Utf8 (Lde/esolutions/fw/util/commons/job/Job;)V 
.end class 
