.version 50 0 
.class public super [80] 
.super [82] 
.implements [84] 
.field private static [85] [86] 
.field private final [87] [88] 
.field private [89] [90] 
.field private [91] [92] 

.method public [94] : [95] 
    .attribute [93] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [13] 
L4:     aload_0 
L5:     iconst_1 
L6:     putfield [15] 
L9:     aload_0 
L10:    sipush 400 
L13:    putfield [16] 
L16:    aload_0 
L17:    aload_1 
L18:    putfield [17] 
L21:    aload_0 
L22:    iload_2 
L23:    putfield [16] 
L26:    return 
L27:    nop 
L28:    
    .end code 
.end method 

.method public static [96] : [97] 
    .attribute [93] .code stack 1 locals 0 
L0:     iconst_1 
L1:     putstatic [14] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [98] : [99] 
    .attribute [93] .code stack 2 locals 1 
        .catch [4] from L0 to L6 using L9 
L0:     ldc_w [1] 
L3:     invokestatic [3] 
L6:     goto L14 
L9:     astore_1 
L10:    invokestatic [5] 
L13:    pop 
        .catch [4] from L14 to L22 using L25 
L14:    aload_0 
L15:    getfield [10] 
L18:    i2l 
L19:    invokestatic [3] 
L22:    goto L30 
L25:    astore_1 
L26:    invokestatic [5] 
L29:    pop 
L30:    getstatic [2] 
L33:    ifeq L14 
L36:    aload_0 
L37:    getfield [11] 
L40:    invokevirtual [12] 
L43:    goto L14 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 

.method static [100] : [101] 
    .attribute [93] .code stack 1 locals 0 
L0:     iconst_0 
L1:     putstatic [14] 
L4:     return 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [19] [20] 
.const [3] = Method [21] [22] 
.const [4] = Class [23] 
.const [5] = Method [24] [25] 
.const [6] = Class [26] 
.const [7] = Class [27] 
.const [8] = Class [28] 
.const [9] = Class [29] 
.const [10] = Field [30] [31] 
.const [11] = Field [32] [33] 
.const [12] = Method [34] [35] 
.const [13] = Method [36] [37] 
.const [14] = Field [38] [39] 
.const [15] = Field [40] [41] 
.const [16] = Field [42] [43] 
.const [17] = Field [44] [45] 
.const [18] = Int -1207238656 
.const [19] = Class [46] 
.const [20] = NameAndType [47] [48] 
.const [21] = Class [49] 
.const [22] = NameAndType [50] [51] 
.const [23] = Utf8 java/lang/InterruptedException 
.const [24] = Class [52] 
.const [25] = NameAndType [53] [54] 
.const [26] = Utf8 de/audi/atip/hmi/AbstractWindow$NativeWindowUpdater 
.const [27] = Utf8 java/lang/Object 
.const [28] = Utf8 java/lang/Thread 
.const [29] = Utf8 de/audi/atip/hmi/AbstractWindow 
.const [30] = Class [55] 
.const [31] = NameAndType [56] [57] 
.const [32] = Class [58] 
.const [33] = NameAndType [59] [60] 
.const [34] = Class [61] 
.const [35] = NameAndType [62] [63] 
.const [36] = Class [64] 
.const [37] = NameAndType [65] [66] 
.const [38] = Class [67] 
.const [39] = NameAndType [68] [69] 
.const [40] = Class [70] 
.const [41] = NameAndType [71] [72] 
.const [42] = Class [73] 
.const [43] = NameAndType [74] [75] 
.const [44] = Class [76] 
.const [45] = NameAndType [77] [78] 
.const [46] = Utf8 de/audi/atip/hmi/AbstractWindow$NativeWindowUpdater 
.const [47] = Utf8 doUpdate 
.const [48] = Utf8 Z 
.const [49] = Utf8 java/lang/Thread 
.const [50] = Utf8 sleep 
.const [51] = Utf8 (J)V 
.const [52] = Utf8 java/lang/Thread 
.const [53] = Utf8 interrupted 
.const [54] = Utf8 ()Z 
.const [55] = Utf8 de/audi/atip/hmi/AbstractWindow$NativeWindowUpdater 
.const [56] = Utf8 timerIntervall 
.const [57] = Utf8 I 
.const [58] = Utf8 de/audi/atip/hmi/AbstractWindow$NativeWindowUpdater 
.const [59] = Utf8 window 
.const [60] = Utf8 Lde/audi/atip/hmi/AbstractWindow; 
.const [61] = Utf8 de/audi/atip/hmi/AbstractWindow 
.const [62] = Utf8 postRepaintEvent 
.const [63] = Utf8 ()V 
.const [64] = Utf8 java/lang/Object 
.const [65] = Utf8 <init> 
.const [66] = Utf8 ()V 
.const [67] = Utf8 de/audi/atip/hmi/AbstractWindow$NativeWindowUpdater 
.const [68] = Utf8 doUpdate 
.const [69] = Utf8 Z 
.const [70] = Utf8 de/audi/atip/hmi/AbstractWindow$NativeWindowUpdater 
.const [71] = Utf8 working 
.const [72] = Utf8 Z 
.const [73] = Utf8 de/audi/atip/hmi/AbstractWindow$NativeWindowUpdater 
.const [74] = Utf8 timerIntervall 
.const [75] = Utf8 I 
.const [76] = Utf8 de/audi/atip/hmi/AbstractWindow$NativeWindowUpdater 
.const [77] = Utf8 window 
.const [78] = Utf8 Lde/audi/atip/hmi/AbstractWindow; 
.const [79] = Utf8 de/audi/atip/hmi/AbstractWindow$NativeWindowUpdater 
.const [80] = Class [79] 
.const [81] = Utf8 java/lang/Object 
.const [82] = Class [81] 
.const [83] = Utf8 java/lang/Runnable 
.const [84] = Class [83] 
.const [85] = Utf8 doUpdate 
.const [86] = Utf8 Z 
.const [87] = Utf8 working 
.const [88] = Utf8 Z 
.const [89] = Utf8 window 
.const [90] = Utf8 Lde/audi/atip/hmi/AbstractWindow; 
.const [91] = Utf8 timerIntervall 
.const [92] = Utf8 I 
.const [93] = Utf8 Code 
.const [94] = Utf8 <init> 
.const [95] = Utf8 (Lde/audi/atip/hmi/AbstractWindow;I)V 
.const [96] = Utf8 startUpdating 
.const [97] = Utf8 ()V 
.const [98] = Utf8 run 
.const [99] = Utf8 ()V 
.const [100] = Utf8 <clinit> 
.const [101] = Utf8 ()V 
.end class 
