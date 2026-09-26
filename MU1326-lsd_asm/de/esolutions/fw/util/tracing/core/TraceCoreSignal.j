.version 50 0 
.class public super [89] 
.super [91] 
.field public static [92] [93] 
.field public static [94] [95] 
.field public static [96] [97] 
.field public static [98] [99] 
.field private [100] [101] 

.method public annotation [103] : [104] 
    .attribute [102] .code stack 1 locals 0 
L0:     aload_0 
L1:     invokespecial [9] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public synchronized [105] : [106] 
    .attribute [102] .code stack 2 locals 1 
L0:     aload_0 
L1:     getfield [8] 
L4:     ifne L14 
L7:     aload_0 
L8:     invokespecial [10] 
L11:    goto L0 
L14:    aload_0 
L15:    getfield [8] 
L18:    istore_1 
L19:    aload_0 
L20:    iconst_0 
L21:    putfield [17] 
L24:    iload_1 
L25:    areturn 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public synchronized [107] : [108] 
    .attribute [102] .code stack 4 locals 9 
L0:     invokestatic [2] 
L3:     astore_3 
L4:     aload_3 
L5:     invokeinterface [18] 0 
L10:    lstore 4 
L12:    lload_1 
L13:    lstore 6 
L15:    aload_0 
L16:    getfield [8] 
L19:    ifne L80 
L22:    aload_0 
L23:    lload 6 
L25:    invokespecial [11] 
L28:    lload_1 
L29:    lconst_0 
L30:    lcmp 
L31:    ifle L15 
L34:    aload_3 
L35:    invokeinterface [18] 0 
L40:    lstore 8 
L42:    lload 8 
L44:    lload 4 
L46:    lsub 
L47:    lstore 10 
L49:    lload 10 
L51:    lload_1 
L52:    lcmp 
L53:    iflt L71 
L56:    aload_0 
L57:    dup 
L58:    getfield [8] 
L61:    getstatic [3] 
L64:    ior 
L65:    putfield [17] 
L68:    goto L77 
L71:    lload_1 
L72:    lload 10 
L74:    lsub 
L75:    lstore 6 
L77:    goto L15 
L80:    aload_0 
L81:    getfield [8] 
L84:    istore 8 
L86:    aload_0 
L87:    iconst_0 
L88:    putfield [17] 
L91:    iload 8 
L93:    areturn 
L94:    nop 
L95:    nop 
L96:    
    .end code 
.end method 

.method public synchronized [109] : [110] 
    .attribute [102] .code stack 3 locals 0 
L0:     aload_0 
L1:     dup 
L2:     getfield [8] 
L5:     iload_1 
L6:     ior 
L7:     putfield [17] 
L10:    aload_0 
L11:    invokespecial [13] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method static [111] : [112] 
    .attribute [102] .code stack 1 locals 0 
L0:     iconst_1 
L1:     putstatic [14] 
L4:     iconst_2 
L5:     putstatic [15] 
L8:     iconst_4 
L9:     putstatic [16] 
L12:    bipush 8 
L14:    putstatic [12] 
L17:    return 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [19] [20] 
.const [3] = Field [21] [22] 
.const [4] = Class [23] 
.const [5] = Class [24] 
.const [6] = Class [25] 
.const [7] = Class [26] 
.const [8] = Field [27] [28] 
.const [9] = Method [29] [30] 
.const [10] = Method [31] [32] 
.const [11] = Method [33] [34] 
.const [12] = Field [35] [36] 
.const [13] = Method [37] [38] 
.const [14] = Field [39] [40] 
.const [15] = Field [41] [42] 
.const [16] = Field [43] [44] 
.const [17] = Field [45] [46] 
.const [18] = InterfaceMethod [47] [48] 
.const [19] = Class [49] 
.const [20] = NameAndType [50] [51] 
.const [21] = Class [52] 
.const [22] = NameAndType [53] [54] 
.const [23] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreSignal 
.const [24] = Utf8 java/lang/Object 
.const [25] = Utf8 de/esolutions/fw/util/commons/timeout/TimeSourceProvider 
.const [26] = Utf8 de/esolutions/fw/util/commons/timeout/ITimeSource 
.const [27] = Class [55] 
.const [28] = NameAndType [56] [57] 
.const [29] = Class [58] 
.const [30] = NameAndType [59] [60] 
.const [31] = Class [61] 
.const [32] = NameAndType [62] [63] 
.const [33] = Class [64] 
.const [34] = NameAndType [65] [66] 
.const [35] = Class [67] 
.const [36] = NameAndType [68] [69] 
.const [37] = Class [70] 
.const [38] = NameAndType [71] [72] 
.const [39] = Class [73] 
.const [40] = NameAndType [74] [75] 
.const [41] = Class [76] 
.const [42] = NameAndType [77] [78] 
.const [43] = Class [79] 
.const [44] = NameAndType [80] [81] 
.const [45] = Class [82] 
.const [46] = NameAndType [83] [84] 
.const [47] = Class [85] 
.const [48] = NameAndType [86] [87] 
.const [49] = Utf8 de/esolutions/fw/util/commons/timeout/TimeSourceProvider 
.const [50] = Utf8 getMonotonicTimeSource 
.const [51] = Utf8 ()Lde/esolutions/fw/util/commons/timeout/ITimeSource; 
.const [52] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreSignal 
.const [53] = Utf8 TIMEOUT 
.const [54] = Utf8 I 
.const [55] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreSignal 
.const [56] = Utf8 signalMask 
.const [57] = Utf8 I 
.const [58] = Utf8 java/lang/Object 
.const [59] = Utf8 <init> 
.const [60] = Utf8 ()V 
.const [61] = Utf8 java/lang/Object 
.const [62] = Utf8 wait 
.const [63] = Utf8 ()V 
.const [64] = Utf8 java/lang/Object 
.const [65] = Utf8 wait 
.const [66] = Utf8 (J)V 
.const [67] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreSignal 
.const [68] = Utf8 TIMEOUT 
.const [69] = Utf8 I 
.const [70] = Utf8 java/lang/Object 
.const [71] = Utf8 notify 
.const [72] = Utf8 ()V 
.const [73] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreSignal 
.const [74] = Utf8 COMMAND 
.const [75] = Utf8 I 
.const [76] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreSignal 
.const [77] = Utf8 MESSAGE 
.const [78] = Utf8 I 
.const [79] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreSignal 
.const [80] = Utf8 BREAK 
.const [81] = Utf8 I 
.const [82] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreSignal 
.const [83] = Utf8 signalMask 
.const [84] = Utf8 I 
.const [85] = Utf8 de/esolutions/fw/util/commons/timeout/ITimeSource 
.const [86] = Utf8 getCurrentTime 
.const [87] = Utf8 ()J 
.const [88] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreSignal 
.const [89] = Class [88] 
.const [90] = Utf8 java/lang/Object 
.const [91] = Class [90] 
.const [92] = Utf8 COMMAND 
.const [93] = Utf8 I 
.const [94] = Utf8 MESSAGE 
.const [95] = Utf8 I 
.const [96] = Utf8 BREAK 
.const [97] = Utf8 I 
.const [98] = Utf8 TIMEOUT 
.const [99] = Utf8 I 
.const [100] = Utf8 signalMask 
.const [101] = Utf8 I 
.const [102] = Utf8 Code 
.const [103] = Utf8 <init> 
.const [104] = Utf8 ()V 
.const [105] = Utf8 waitForSignal 
.const [106] = Utf8 ()I 
.const [107] = Utf8 waitForSignalWithTimeout 
.const [108] = Utf8 (J)I 
.const [109] = Utf8 triggerSignal 
.const [110] = Utf8 (I)V 
.const [111] = Utf8 <clinit> 
.const [112] = Utf8 ()V 
.end class 
