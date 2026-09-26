.version 50 0 
.class super [108] 
.super [110] 
.implements [112] 
.field private final synthetic [113] [114] 
.field private final synthetic [115] [116] 

.method [118] : [119] 
    .attribute [117] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [22] 
L5:     aload_0 
L6:     aload_2 
L7:     putfield [23] 
L10:    aload_0 
L11:    invokespecial [21] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [120] : [121] 
    .attribute [117] .code stack 4 locals 2 
L0:     aload_0 
L1:     getfield [18] 
L4:     invokestatic [2] 
L7:     ldc [3] 
L9:     ldc [4] 
L11:    aload_0 
L12:    getfield [19] 
L15:    invokevirtual [20] 
L18:    pop 
L19:    aload_0 
L20:    getfield [18] 
L23:    dup 
L24:    astore_1 
L25:    monitorenter 
        .catch [0] from L26 to L45 using L48 
L26:    aload_0 
L27:    getfield [18] 
L30:    invokestatic [5] 
L33:    aload_0 
L34:    getfield [19] 
L37:    invokeinterface [24] 0 
L42:    pop 
L43:    aload_1 
L44:    monitorexit 
L45:    goto L53 
        .catch [0] from L48 to L51 using L48 
L48:    astore_2 
L49:    aload_1 
L50:    monitorexit 
L51:    aload_2 
L52:    athrow 
        .catch [8] from L53 to L85 using L88 
L53:    aload_0 
L54:    getfield [19] 
L57:    aload_0 
L58:    getfield [18] 
L61:    invokestatic [6] 
L64:    invokeinterface [25] 0 
L69:    aload_0 
L70:    getfield [19] 
L73:    aload_0 
L74:    getfield [18] 
L77:    invokestatic [7] 
L80:    invokeinterface [26] 0 
L85:    goto L102 
L88:    astore_1 
L89:    aload_0 
L90:    getfield [18] 
L93:    invokestatic [2] 
L96:    aload_1 
L97:    ldc [9] 
L99:    invokestatic [10] 
L102:   return 
L103:   nop 
L104:   
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [27] [28] 
.const [3] = Int -2137614336 
.const [4] = String [29] 
.const [5] = Method [30] [31] 
.const [6] = Method [32] [33] 
.const [7] = Method [34] [35] 
.const [8] = Class [36] 
.const [9] = String [37] 
.const [10] = Method [38] [39] 
.const [11] = Class [40] 
.const [12] = Class [41] 
.const [13] = Class [42] 
.const [14] = Class [43] 
.const [15] = Class [44] 
.const [16] = Class [45] 
.const [17] = Class [46] 
.const [18] = Field [47] [48] 
.const [19] = Field [49] [50] 
.const [20] = Method [51] [52] 
.const [21] = Method [53] [54] 
.const [22] = Field [55] [56] 
.const [23] = Field [57] [58] 
.const [24] = InterfaceMethod [59] [60] 
.const [25] = InterfaceMethod [61] [62] 
.const [26] = InterfaceMethod [63] [64] 
.const [27] = Class [65] 
.const [28] = NameAndType [66] [67] 
.const [29] = Utf8 '[DictationStateObserverProxy#addObserver] observer = %1' 
.const [30] = Class [68] 
.const [31] = NameAndType [69] [70] 
.const [32] = Class [71] 
.const [33] = NameAndType [72] [73] 
.const [34] = Class [74] 
.const [35] = NameAndType [75] [76] 
.const [36] = Utf8 java/lang/Exception 
.const [37] = Utf8 '[DictationStateObserverProxy#addObserver]' 
.const [38] = Class [77] 
.const [39] = NameAndType [78] [79] 
.const [40] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateObserverProxy$1 
.const [41] = Utf8 java/lang/Object 
.const [42] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateObserverProxy 
.const [43] = Utf8 de/audi/atip/log/LogChannel 
.const [44] = Utf8 java/util/Collection 
.const [45] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/IDictationStateObserver 
.const [46] = Utf8 de/audi/app/sdsmanager/dictation/util/DictationUtil 
.const [47] = Class [80] 
.const [48] = NameAndType [81] [82] 
.const [49] = Class [83] 
.const [50] = NameAndType [84] [85] 
.const [51] = Class [86] 
.const [52] = NameAndType [87] [88] 
.const [53] = Class [89] 
.const [54] = NameAndType [90] [91] 
.const [55] = Class [92] 
.const [56] = NameAndType [93] [94] 
.const [57] = Class [95] 
.const [58] = NameAndType [96] [97] 
.const [59] = Class [98] 
.const [60] = NameAndType [99] [100] 
.const [61] = Class [101] 
.const [62] = NameAndType [102] [103] 
.const [63] = Class [104] 
.const [64] = NameAndType [105] [106] 
.const [65] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateObserverProxy 
.const [66] = Utf8 access$000 
.const [67] = Utf8 (Lde/audi/app/sdsmanager/dictation/combinedstate/DictationStateObserverProxy;)Lde/audi/atip/log/LogChannel; 
.const [68] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateObserverProxy 
.const [69] = Utf8 access$100 
.const [70] = Utf8 (Lde/audi/app/sdsmanager/dictation/combinedstate/DictationStateObserverProxy;)Ljava/util/Collection; 
.const [71] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateObserverProxy 
.const [72] = Utf8 access$200 
.const [73] = Utf8 (Lde/audi/app/sdsmanager/dictation/combinedstate/DictationStateObserverProxy;)J 
.const [74] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateObserverProxy 
.const [75] = Utf8 access$300 
.const [76] = Utf8 (Lde/audi/app/sdsmanager/dictation/combinedstate/DictationStateObserverProxy;)I 
.const [77] = Utf8 de/audi/app/sdsmanager/dictation/util/DictationUtil 
.const [78] = Utf8 logException 
.const [79] = Utf8 (Lde/audi/atip/log/LogChannel;Ljava/lang/Throwable;Ljava/lang/String;)V 
.const [80] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateObserverProxy$1 
.const [81] = Utf8 this$0 
.const [82] = Utf8 Lde/audi/app/sdsmanager/dictation/combinedstate/DictationStateObserverProxy; 
.const [83] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateObserverProxy$1 
.const [84] = Utf8 val$observer 
.const [85] = Utf8 Lde/audi/app/sdsmanager/dictation/combinedstate/IDictationStateObserver; 
.const [86] = Utf8 de/audi/atip/log/LogChannel 
.const [87] = Utf8 log 
.const [88] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [89] = Utf8 java/lang/Object 
.const [90] = Utf8 <init> 
.const [91] = Utf8 ()V 
.const [92] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateObserverProxy$1 
.const [93] = Utf8 this$0 
.const [94] = Utf8 Lde/audi/app/sdsmanager/dictation/combinedstate/DictationStateObserverProxy; 
.const [95] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateObserverProxy$1 
.const [96] = Utf8 val$observer 
.const [97] = Utf8 Lde/audi/app/sdsmanager/dictation/combinedstate/IDictationStateObserver; 
.const [98] = Utf8 java/util/Collection 
.const [99] = Utf8 add 
.const [100] = Utf8 (Ljava/lang/Object;)Z 
.const [101] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/IDictationStateObserver 
.const [102] = Utf8 updateDictationMaxDuration 
.const [103] = Utf8 (J)V 
.const [104] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/IDictationStateObserver 
.const [105] = Utf8 updateDictationState 
.const [106] = Utf8 (I)V 
.const [107] = Utf8 de/audi/app/sdsmanager/dictation/combinedstate/DictationStateObserverProxy$1 
.const [108] = Class [107] 
.const [109] = Utf8 java/lang/Object 
.const [110] = Class [109] 
.const [111] = Utf8 java/lang/Runnable 
.const [112] = Class [111] 
.const [113] = Utf8 val$observer 
.const [114] = Utf8 Lde/audi/app/sdsmanager/dictation/combinedstate/IDictationStateObserver; 
.const [115] = Utf8 this$0 
.const [116] = Utf8 Lde/audi/app/sdsmanager/dictation/combinedstate/DictationStateObserverProxy; 
.const [117] = Utf8 Code 
.const [118] = Utf8 <init> 
.const [119] = Utf8 (Lde/audi/app/sdsmanager/dictation/combinedstate/DictationStateObserverProxy;Lde/audi/app/sdsmanager/dictation/combinedstate/IDictationStateObserver;)V 
.const [120] = Utf8 run 
.const [121] = Utf8 ()V 
.end class 
