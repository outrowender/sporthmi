.version 50 0 
.class public super [59] 
.super [61] 
.field private [62] [63] 

.method public [65] : [66] 
    .attribute [64] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [8] 
L4:     aload_0 
L5:     iconst_m1 
L6:     putfield [12] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public synchronized [67] : [68] 
    .attribute [64] .code stack 2 locals 0 
L0:     aload_0 
L1:     getfield [7] 
L4:     iload_1 
L5:     if_icmpge L15 
L8:     aload_0 
L9:     invokespecial [9] 
L12:    goto L0 
L15:    return 
L16:    
    .end code 
.end method 

.method public synchronized [69] : [70] 
    .attribute [64] .code stack 4 locals 9 
L0:     invokestatic [2] 
L3:     astore 4 
L5:     aload 4 
L7:     invokeinterface [13] 0 
L12:    lstore 5 
L14:    lload_2 
L15:    lstore 7 
L17:    aload_0 
L18:    getfield [7] 
L21:    iload_1 
L22:    if_icmpge L71 
L25:    aload_0 
L26:    lload 7 
L28:    invokespecial [10] 
L31:    lload_2 
L32:    lconst_0 
L33:    lcmp 
L34:    ifle L17 
L37:    aload 4 
L39:    invokeinterface [13] 0 
L44:    lstore 9 
L46:    lload 9 
L48:    lload 5 
L50:    lsub 
L51:    lstore 11 
L53:    lload 11 
L55:    lload_2 
L56:    lcmp 
L57:    iflt L62 
L60:    iconst_0 
L61:    areturn 
L62:    lload_2 
L63:    lload 11 
L65:    lsub 
L66:    lstore 7 
L68:    goto L17 
L71:    iconst_1 
L72:    areturn 
L73:    nop 
L74:    nop 
L75:    nop 
L76:    
    .end code 
.end method 

.method public synchronized [71] : [72] 
    .attribute [64] .code stack 2 locals 0 
L0:     aload_0 
L1:     iload_1 
L2:     putfield [12] 
L5:     aload_0 
L6:     invokespecial [11] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [14] [15] 
.const [3] = Class [16] 
.const [4] = Class [17] 
.const [5] = Class [18] 
.const [6] = Class [19] 
.const [7] = Field [20] [21] 
.const [8] = Method [22] [23] 
.const [9] = Method [24] [25] 
.const [10] = Method [26] [27] 
.const [11] = Method [28] [29] 
.const [12] = Field [30] [31] 
.const [13] = InterfaceMethod [32] [33] 
.const [14] = Class [34] 
.const [15] = NameAndType [35] [36] 
.const [16] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreReplySignal 
.const [17] = Utf8 java/lang/Object 
.const [18] = Utf8 de/esolutions/fw/util/commons/timeout/TimeSourceProvider 
.const [19] = Utf8 de/esolutions/fw/util/commons/timeout/ITimeSource 
.const [20] = Class [37] 
.const [21] = NameAndType [38] [39] 
.const [22] = Class [40] 
.const [23] = NameAndType [41] [42] 
.const [24] = Class [43] 
.const [25] = NameAndType [44] [45] 
.const [26] = Class [46] 
.const [27] = NameAndType [47] [48] 
.const [28] = Class [49] 
.const [29] = NameAndType [50] [51] 
.const [30] = Class [52] 
.const [31] = NameAndType [53] [54] 
.const [32] = Class [55] 
.const [33] = NameAndType [56] [57] 
.const [34] = Utf8 de/esolutions/fw/util/commons/timeout/TimeSourceProvider 
.const [35] = Utf8 getMonotonicTimeSource 
.const [36] = Utf8 ()Lde/esolutions/fw/util/commons/timeout/ITimeSource; 
.const [37] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreReplySignal 
.const [38] = Utf8 value 
.const [39] = Utf8 I 
.const [40] = Utf8 java/lang/Object 
.const [41] = Utf8 <init> 
.const [42] = Utf8 ()V 
.const [43] = Utf8 java/lang/Object 
.const [44] = Utf8 wait 
.const [45] = Utf8 ()V 
.const [46] = Utf8 java/lang/Object 
.const [47] = Utf8 wait 
.const [48] = Utf8 (J)V 
.const [49] = Utf8 java/lang/Object 
.const [50] = Utf8 notify 
.const [51] = Utf8 ()V 
.const [52] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreReplySignal 
.const [53] = Utf8 value 
.const [54] = Utf8 I 
.const [55] = Utf8 de/esolutions/fw/util/commons/timeout/ITimeSource 
.const [56] = Utf8 getCurrentTime 
.const [57] = Utf8 ()J 
.const [58] = Utf8 de/esolutions/fw/util/tracing/core/TraceCoreReplySignal 
.const [59] = Class [58] 
.const [60] = Utf8 java/lang/Object 
.const [61] = Class [60] 
.const [62] = Utf8 value 
.const [63] = Utf8 I 
.const [64] = Utf8 Code 
.const [65] = Utf8 <init> 
.const [66] = Utf8 ()V 
.const [67] = Utf8 waitForSignal 
.const [68] = Utf8 (I)V 
.const [69] = Utf8 waitForSignalWithTimeout 
.const [70] = Utf8 (IJ)Z 
.const [71] = Utf8 triggerSignal 
.const [72] = Utf8 (I)V 
.end class 
