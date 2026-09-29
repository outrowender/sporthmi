.version 50 0 
.class public super [103] 
.super [105] 
.implements [107] 
.field private final [108] [109] 
.field private final [110] [111] 

.method public [113] : [114] 
    .attribute [112] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [21] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [22] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [23] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [115] : [116] 
    .attribute [112] .code stack 3 locals 1 
        .catch [2] from L0 to L9 using L12 
L0:     aload_0 
L1:     getfield [16] 
L4:     invokeinterface [24] 0 
L9:     goto L74 
L12:    astore_1 
L13:    aload_0 
L14:    getfield [15] 
L17:    ifnull L34 
L20:    aload_0 
L21:    getfield [15] 
L24:    aload_1 
L25:    aconst_null 
L26:    invokeinterface [25] 0 
L31:    goto L74 
L34:    getstatic [3] 
L37:    ldc [4] 
L39:    invokevirtual [17] 
L42:    getstatic [3] 
L45:    ldc [5] 
L47:    invokevirtual [18] 
L50:    getstatic [3] 
L53:    invokestatic [6] 
L56:    invokevirtual [19] 
L59:    invokevirtual [17] 
L62:    getstatic [3] 
L65:    ldc [7] 
L67:    invokevirtual [18] 
L70:    aload_1 
L71:    invokevirtual [20] 
L74:    return 
L75:    nop 
L76:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [26] 
.const [3] = Field [27] [28] 
.const [4] = String [29] 
.const [5] = String [30] 
.const [6] = Method [31] [32] 
.const [7] = String [33] 
.const [8] = Class [34] 
.const [9] = Class [35] 
.const [10] = Class [36] 
.const [11] = Class [37] 
.const [12] = Class [38] 
.const [13] = Class [39] 
.const [14] = Class [40] 
.const [15] = Field [41] [42] 
.const [16] = Field [43] [44] 
.const [17] = Method [45] [46] 
.const [18] = Method [47] [48] 
.const [19] = Method [49] [50] 
.const [20] = Method [51] [52] 
.const [21] = Method [53] [54] 
.const [22] = Field [55] [56] 
.const [23] = Field [57] [58] 
.const [24] = InterfaceMethod [59] [60] 
.const [25] = InterfaceMethod [61] [62] 
.const [26] = Utf8 java/lang/Throwable 
.const [27] = Class [63] 
.const [28] = NameAndType [64] [65] 
.const [29] = Utf8 '-----> JavaCOMM ERROR DEFAULT HANDLER <-----' 
.const [30] = Utf8 'thread: ' 
.const [31] = Class [66] 
.const [32] = NameAndType [67] [68] 
.const [33] = Utf8 'error: ' 
.const [34] = Utf8 de/esolutions/fw/util/commons/error/ErrorHandlingRunnable 
.const [35] = Utf8 java/lang/Object 
.const [36] = Utf8 java/lang/Runnable 
.const [37] = Utf8 de/esolutions/fw/util/commons/error/IFatalErrorHandler 
.const [38] = Utf8 java/lang/System 
.const [39] = Utf8 java/io/PrintStream 
.const [40] = Utf8 java/lang/Thread 
.const [41] = Class [69] 
.const [42] = NameAndType [70] [71] 
.const [43] = Class [72] 
.const [44] = NameAndType [73] [74] 
.const [45] = Class [75] 
.const [46] = NameAndType [76] [77] 
.const [47] = Class [78] 
.const [48] = NameAndType [79] [80] 
.const [49] = Class [81] 
.const [50] = NameAndType [82] [83] 
.const [51] = Class [84] 
.const [52] = NameAndType [85] [86] 
.const [53] = Class [87] 
.const [54] = NameAndType [88] [89] 
.const [55] = Class [90] 
.const [56] = NameAndType [91] [92] 
.const [57] = Class [93] 
.const [58] = NameAndType [94] [95] 
.const [59] = Class [96] 
.const [60] = NameAndType [97] [98] 
.const [61] = Class [99] 
.const [62] = NameAndType [100] [101] 
.const [63] = Utf8 java/lang/System 
.const [64] = Utf8 out 
.const [65] = Utf8 Ljava/io/PrintStream; 
.const [66] = Utf8 java/lang/Thread 
.const [67] = Utf8 currentThread 
.const [68] = Utf8 ()Ljava/lang/Thread; 
.const [69] = Utf8 de/esolutions/fw/util/commons/error/ErrorHandlingRunnable 
.const [70] = Utf8 errorHandler 
.const [71] = Utf8 Lde/esolutions/fw/util/commons/error/IFatalErrorHandler; 
.const [72] = Utf8 de/esolutions/fw/util/commons/error/ErrorHandlingRunnable 
.const [73] = Utf8 run 
.const [74] = Utf8 Ljava/lang/Runnable; 
.const [75] = Utf8 java/io/PrintStream 
.const [76] = Utf8 println 
.const [77] = Utf8 (Ljava/lang/String;)V 
.const [78] = Utf8 java/io/PrintStream 
.const [79] = Utf8 print 
.const [80] = Utf8 (Ljava/lang/String;)V 
.const [81] = Utf8 java/lang/Thread 
.const [82] = Utf8 getName 
.const [83] = Utf8 ()Ljava/lang/String; 
.const [84] = Utf8 java/lang/Throwable 
.const [85] = Utf8 printStackTrace 
.const [86] = Utf8 ()V 
.const [87] = Utf8 java/lang/Object 
.const [88] = Utf8 <init> 
.const [89] = Utf8 ()V 
.const [90] = Utf8 de/esolutions/fw/util/commons/error/ErrorHandlingRunnable 
.const [91] = Utf8 errorHandler 
.const [92] = Utf8 Lde/esolutions/fw/util/commons/error/IFatalErrorHandler; 
.const [93] = Utf8 de/esolutions/fw/util/commons/error/ErrorHandlingRunnable 
.const [94] = Utf8 run 
.const [95] = Utf8 Ljava/lang/Runnable; 
.const [96] = Utf8 java/lang/Runnable 
.const [97] = Utf8 run 
.const [98] = Utf8 ()V 
.const [99] = Utf8 de/esolutions/fw/util/commons/error/IFatalErrorHandler 
.const [100] = Utf8 handleFatalError 
.const [101] = Utf8 (Ljava/lang/Throwable;Ljava/lang/String;)V 
.const [102] = Utf8 de/esolutions/fw/util/commons/error/ErrorHandlingRunnable 
.const [103] = Class [102] 
.const [104] = Utf8 java/lang/Object 
.const [105] = Class [104] 
.const [106] = Utf8 java/lang/Runnable 
.const [107] = Class [106] 
.const [108] = Utf8 errorHandler 
.const [109] = Utf8 Lde/esolutions/fw/util/commons/error/IFatalErrorHandler; 
.const [110] = Utf8 run 
.const [111] = Utf8 Ljava/lang/Runnable; 
.const [112] = Utf8 Code 
.const [113] = Utf8 <init> 
.const [114] = Utf8 (Lde/esolutions/fw/util/commons/error/IFatalErrorHandler;Ljava/lang/Runnable;)V 
.const [115] = Utf8 run 
.const [116] = Utf8 ()V 
.end class 
