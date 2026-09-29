.version 50 0 
.class super [91] 
.super [93] 
.implements [95] 
.field private [96] [97] 

.method public [99] : [100] 
    .attribute [98] .code stack 2 locals 0 
L0:     new [20] 
L3:     dup 
L4:     invokespecial [18] 
L7:     ldc [3] 
L9:     invokevirtual [13] 
L12:    aload_0 
L13:    getfield [14] 
L16:    invokevirtual [15] 
L19:    invokevirtual [13] 
L22:    ldc [4] 
L24:    invokevirtual [13] 
L27:    invokevirtual [16] 
L30:    areturn 
L31:    nop 
L32:    
    .end code 
.end method 

.method [101] : [102] 
    .attribute [98] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [19] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [21] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [103] : [104] 
    .attribute [98] .code stack 6 locals 1 
        .catch [5] from L0 to L9 using L12 
L0:     aload_0 
L1:     getfield [14] 
L4:     invokeinterface [22] 0 
L9:     goto L40 
L12:    astore_1 
L13:    getstatic [6] 
L16:    iconst_4 
L17:    ldc [7] 
L19:    aload_0 
L20:    getfield [14] 
L23:    invokeinterface [23] 0 
L28:    aload_0 
L29:    getfield [14] 
L32:    invokevirtual [15] 
L35:    aload_1 
L36:    invokevirtual [17] 
L39:    pop 
L40:    return 
L41:    nop 
L42:    nop 
L43:    nop 
L44:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [24] 
.const [3] = String [25] 
.const [4] = String [26] 
.const [5] = Class [27] 
.const [6] = Field [28] [29] 
.const [7] = String [30] 
.const [8] = Class [31] 
.const [9] = Class [32] 
.const [10] = Class [33] 
.const [11] = Class [34] 
.const [12] = Class [35] 
.const [13] = Method [36] [37] 
.const [14] = Field [38] [39] 
.const [15] = Method [40] [41] 
.const [16] = Method [42] [43] 
.const [17] = Method [44] [45] 
.const [18] = Method [46] [47] 
.const [19] = Method [48] [49] 
.const [20] = Class [50] 
.const [21] = Field [51] [52] 
.const [22] = InterfaceMethod [53] [54] 
.const [23] = InterfaceMethod [55] [56] 
.const [24] = Utf8 java/lang/StringBuffer 
.const [25] = Utf8 'ServiceJob [method=' 
.const [26] = Utf8 ']' 
.const [27] = Utf8 de/esolutions/fw/comm/core/method/MethodException 
.const [28] = Class [57] 
.const [29] = NameAndType [58] [59] 
.const [30] = Utf8 'Error during service method invocation: service=%1, method=%2, rootCause=%3' 
.const [31] = Utf8 de/esolutions/fw/dsi/comm/DSIServiceWorker$ServiceJob 
.const [32] = Utf8 java/lang/Object 
.const [33] = Utf8 de/esolutions/fw/comm/core/IMethod 
.const [34] = Utf8 de/esolutions/fw/dsi/tracing/Channels 
.const [35] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
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
.const [48] = Class [78] 
.const [49] = NameAndType [79] [80] 
.const [50] = Utf8 java/lang/StringBuffer 
.const [51] = Class [81] 
.const [52] = NameAndType [82] [83] 
.const [53] = Class [84] 
.const [54] = NameAndType [85] [86] 
.const [55] = Class [87] 
.const [56] = NameAndType [88] [89] 
.const [57] = Utf8 de/esolutions/fw/dsi/tracing/Channels 
.const [58] = Utf8 SERVICEWORKER 
.const [59] = Utf8 Lde/esolutions/fw/util/tracing/TraceChannel; 
.const [60] = Utf8 java/lang/StringBuffer 
.const [61] = Utf8 append 
.const [62] = Utf8 (Ljava/lang/String;)Ljava/lang/StringBuffer; 
.const [63] = Utf8 de/esolutions/fw/dsi/comm/DSIServiceWorker$ServiceJob 
.const [64] = Utf8 method 
.const [65] = Utf8 Lde/esolutions/fw/comm/core/IMethod; 
.const [66] = Utf8 java/lang/Object 
.const [67] = Utf8 toString 
.const [68] = Utf8 ()Ljava/lang/String; 
.const [69] = Utf8 java/lang/StringBuffer 
.const [70] = Utf8 toString 
.const [71] = Utf8 ()Ljava/lang/String; 
.const [72] = Utf8 de/esolutions/fw/util/tracing/TraceChannel 
.const [73] = Utf8 log 
.const [74] = Utf8 (SLjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z 
.const [75] = Utf8 java/lang/StringBuffer 
.const [76] = Utf8 <init> 
.const [77] = Utf8 ()V 
.const [78] = Utf8 java/lang/Object 
.const [79] = Utf8 <init> 
.const [80] = Utf8 ()V 
.const [81] = Utf8 de/esolutions/fw/dsi/comm/DSIServiceWorker$ServiceJob 
.const [82] = Utf8 method 
.const [83] = Utf8 Lde/esolutions/fw/comm/core/IMethod; 
.const [84] = Utf8 de/esolutions/fw/comm/core/IMethod 
.const [85] = Utf8 invoke 
.const [86] = Utf8 ()V 
.const [87] = Utf8 de/esolutions/fw/comm/core/IMethod 
.const [88] = Utf8 getService 
.const [89] = Utf8 ()Lde/esolutions/fw/comm/core/IService; 
.const [90] = Utf8 de/esolutions/fw/dsi/comm/DSIServiceWorker$ServiceJob 
.const [91] = Class [90] 
.const [92] = Utf8 java/lang/Object 
.const [93] = Class [92] 
.const [94] = Utf8 java/lang/Runnable 
.const [95] = Class [94] 
.const [96] = Utf8 method 
.const [97] = Utf8 Lde/esolutions/fw/comm/core/IMethod; 
.const [98] = Utf8 Code 
.const [99] = Utf8 toString 
.const [100] = Utf8 ()Ljava/lang/String; 
.const [101] = Utf8 <init> 
.const [102] = Utf8 (Lde/esolutions/fw/comm/core/IMethod;)V 
.const [103] = Utf8 run 
.const [104] = Utf8 ()V 
.end class 
