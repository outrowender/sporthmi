.version 50 0 
.class super [85] 
.super [87] 
.implements [89] 
.field private final synthetic [90] [91] 

.method [93] : [94] 
    .attribute [92] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [19] 
L5:     aload_0 
L6:     invokespecial [18] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [95] : [96] 
    .attribute [92] .code stack 4 locals 7 
L0:     aload_0 
L1:     getfield [15] 
L4:     dup 
L5:     astore_2 
L6:     monitorenter 
        .catch [0] from L7 to L77 using L80 
L7:     aload_0 
L8:     getfield [15] 
L11:    invokestatic [2] 
L14:    invokeinterface [20] 0 
L19:    lstore_3 
L20:    lload_3 
L21:    aload_0 
L22:    getfield [15] 
L25:    invokestatic [3] 
L28:    lsub 
L29:    lstore 5 
L31:    lload 5 
L33:    ldc_w [1] 
L36:    lmul 
L37:    aload_0 
L38:    getfield [15] 
L41:    invokestatic [4] 
L44:    ldiv 
L45:    l2i 
L46:    istore 7 
L48:    iload 7 
L50:    sipush 10000 
L53:    if_icmplt L66 
L56:    sipush 10000 
L59:    istore 7 
L61:    aload_1 
L62:    invokevirtual [16] 
L65:    pop 
L66:    aload_0 
L67:    getfield [15] 
L70:    iload 7 
L72:    invokestatic [5] 
L75:    aload_2 
L76:    monitorexit 
L77:    goto L87 
        .catch [0] from L80 to L84 using L80 
L80:    astore 8 
L82:    aload_2 
L83:    monitorexit 
L84:    aload 8 
L86:    athrow 
L87:    return 
L88:    
    .end code 
.end method 

.method public [97] : [98] 
    .attribute [92] .code stack 3 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     invokestatic [6] 
L7:     ldc [7] 
L9:     ldc [8] 
L11:    invokevirtual [17] 
L14:    pop 
L15:    return 
L16:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [22] [23] 
.const [3] = Method [24] [25] 
.const [4] = Method [26] [27] 
.const [5] = Method [28] [29] 
.const [6] = Method [30] [31] 
.const [7] = Int -2137614336 
.const [8] = String [32] 
.const [9] = Class [33] 
.const [10] = Class [34] 
.const [11] = Class [35] 
.const [12] = Class [36] 
.const [13] = Class [37] 
.const [14] = Class [38] 
.const [15] = Field [39] [40] 
.const [16] = Method [41] [42] 
.const [17] = Method [43] [44] 
.const [18] = Method [45] [46] 
.const [19] = Field [47] [48] 
.const [20] = InterfaceMethod [49] [50] 
.const [21] = Int 270991360 
.const [22] = Class [51] 
.const [23] = NameAndType [52] [53] 
.const [24] = Class [54] 
.const [25] = NameAndType [55] [56] 
.const [26] = Class [57] 
.const [27] = NameAndType [58] [59] 
.const [28] = Class [60] 
.const [29] = NameAndType [61] [62] 
.const [30] = Class [63] 
.const [31] = NameAndType [64] [65] 
.const [32] = Utf8 '[RecordingProgressBarController#TimerListener#cancelTimer]' 
.const [33] = Utf8 de/audi/app/sdsmanager/dictation/progressbar/RecordingProgressBarController$1 
.const [34] = Utf8 java/lang/Object 
.const [35] = Utf8 de/audi/app/sdsmanager/dictation/progressbar/RecordingProgressBarController 
.const [36] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [37] = Utf8 de/audi/atip/timer/Timer 
.const [38] = Utf8 de/audi/atip/log/LogChannel 
.const [39] = Class [66] 
.const [40] = NameAndType [67] [68] 
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
.const [51] = Utf8 de/audi/app/sdsmanager/dictation/progressbar/RecordingProgressBarController 
.const [52] = Utf8 access$000 
.const [53] = Utf8 (Lde/audi/app/sdsmanager/dictation/progressbar/RecordingProgressBarController;)Lde/audi/atip/base/IFrameworkAccess; 
.const [54] = Utf8 de/audi/app/sdsmanager/dictation/progressbar/RecordingProgressBarController 
.const [55] = Utf8 access$100 
.const [56] = Utf8 (Lde/audi/app/sdsmanager/dictation/progressbar/RecordingProgressBarController;)J 
.const [57] = Utf8 de/audi/app/sdsmanager/dictation/progressbar/RecordingProgressBarController 
.const [58] = Utf8 access$200 
.const [59] = Utf8 (Lde/audi/app/sdsmanager/dictation/progressbar/RecordingProgressBarController;)J 
.const [60] = Utf8 de/audi/app/sdsmanager/dictation/progressbar/RecordingProgressBarController 
.const [61] = Utf8 access$300 
.const [62] = Utf8 (Lde/audi/app/sdsmanager/dictation/progressbar/RecordingProgressBarController;I)V 
.const [63] = Utf8 de/audi/app/sdsmanager/dictation/progressbar/RecordingProgressBarController 
.const [64] = Utf8 access$400 
.const [65] = Utf8 (Lde/audi/app/sdsmanager/dictation/progressbar/RecordingProgressBarController;)Lde/audi/atip/log/LogChannel; 
.const [66] = Utf8 de/audi/app/sdsmanager/dictation/progressbar/RecordingProgressBarController$1 
.const [67] = Utf8 this$0 
.const [68] = Utf8 Lde/audi/app/sdsmanager/dictation/progressbar/RecordingProgressBarController; 
.const [69] = Utf8 de/audi/atip/timer/Timer 
.const [70] = Utf8 cancel 
.const [71] = Utf8 ()Z 
.const [72] = Utf8 de/audi/atip/log/LogChannel 
.const [73] = Utf8 log 
.const [74] = Utf8 (ILjava/lang/String;)Z 
.const [75] = Utf8 java/lang/Object 
.const [76] = Utf8 <init> 
.const [77] = Utf8 ()V 
.const [78] = Utf8 de/audi/app/sdsmanager/dictation/progressbar/RecordingProgressBarController$1 
.const [79] = Utf8 this$0 
.const [80] = Utf8 Lde/audi/app/sdsmanager/dictation/progressbar/RecordingProgressBarController; 
.const [81] = Utf8 de/audi/atip/base/IFrameworkAccess 
.const [82] = Utf8 getMonotonicTime 
.const [83] = Utf8 ()J 
.const [84] = Utf8 de/audi/app/sdsmanager/dictation/progressbar/RecordingProgressBarController$1 
.const [85] = Class [84] 
.const [86] = Utf8 java/lang/Object 
.const [87] = Class [86] 
.const [88] = Utf8 de/audi/atip/timer/TimerListener 
.const [89] = Class [88] 
.const [90] = Utf8 this$0 
.const [91] = Utf8 Lde/audi/app/sdsmanager/dictation/progressbar/RecordingProgressBarController; 
.const [92] = Utf8 Code 
.const [93] = Utf8 <init> 
.const [94] = Utf8 (Lde/audi/app/sdsmanager/dictation/progressbar/RecordingProgressBarController;)V 
.const [95] = Utf8 fireTimer 
.const [96] = Utf8 (Lde/audi/atip/timer/Timer;)V 
.const [97] = Utf8 cancelTimer 
.const [98] = Utf8 (Lde/audi/atip/timer/Timer;)V 
.end class 
