.version 50 0 
.class super [93] 
.super [95] 
.implements [97] 
.field private [98] [99] 
.field private final synthetic [100] [101] 

.method [103] : [104] 
    .attribute [102] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [17] 
L5:     aload_0 
L6:     invokespecial [16] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [105] : [106] 
    .attribute [102] .code stack 5 locals 4 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [10] 
L5:     invokestatic [2] 
L8:     invokevirtual [11] 
L11:    ifeq L104 
L14:    aload_0 
L15:    getfield [10] 
L18:    getfield [12] 
L21:    dup 
L22:    astore_2 
L23:    monitorenter 
        .catch [0] from L24 to L94 using L97 
L24:    aload_0 
L25:    dup 
L26:    getfield [13] 
L29:    ldc_w [1] 
L32:    ladd 
L33:    putfield [18] 
L36:    aload_0 
L37:    getfield [10] 
L40:    invokestatic [3] 
L43:    ifeq L69 
L46:    aload_0 
L47:    getfield [10] 
L50:    getfield [14] 
L53:    invokevirtual [15] 
L56:    ldc2_w [20] 
L59:    dadd 
L60:    dstore_3 
L61:    aload_0 
L62:    getfield [10] 
L65:    dload_3 
L66:    invokestatic [4] 
L69:    ldc_w [1] 
L72:    aload_0 
L73:    getfield [13] 
L76:    lcmp 
L77:    ifgt L92 
L80:    aload_0 
L81:    getfield [10] 
L84:    invokestatic [5] 
L87:    aload_0 
L88:    lconst_0 
L89:    putfield [18] 
L92:    aload_2 
L93:    monitorexit 
L94:    goto L104 
        .catch [0] from L97 to L101 using L97 
L97:    astore 5 
L99:    aload_2 
L100:   monitorexit 
L101:   aload 5 
L103:   athrow 
L104:   return 
L105:   nop 
L106:   nop 
L107:   nop 
L108:   
    .end code 
.end method 

.method public [107] : [108] 
    .attribute [102] .code stack 3 locals 2 
L0:     aload_1 
L1:     aload_0 
L2:     getfield [10] 
L5:     invokestatic [2] 
L8:     invokevirtual [11] 
L11:    ifeq L39 
L14:    aload_0 
L15:    getfield [10] 
L18:    getfield [12] 
L21:    dup 
L22:    astore_2 
L23:    monitorenter 
        .catch [0] from L24 to L31 using L34 
L24:    aload_0 
L25:    lconst_0 
L26:    putfield [18] 
L29:    aload_2 
L30:    monitorexit 
L31:    goto L39 
        .catch [0] from L34 to L37 using L34 
L34:    astore_3 
L35:    aload_2 
L36:    monitorexit 
L37:    aload_3 
L38:    athrow 
L39:    return 
L40:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [23] [24] 
.const [3] = Method [25] [26] 
.const [4] = Method [27] [28] 
.const [5] = Method [29] [30] 
.const [6] = Class [31] 
.const [7] = Class [32] 
.const [8] = Class [33] 
.const [9] = Class [34] 
.const [10] = Field [35] [36] 
.const [11] = Method [37] [38] 
.const [12] = Field [39] [40] 
.const [13] = Field [41] [42] 
.const [14] = Field [43] [44] 
.const [15] = Method [45] [46] 
.const [16] = Method [47] [48] 
.const [17] = Field [49] [50] 
.const [18] = Field [51] [52] 
.const [19] = Int -402456576 
.const [20] = Double +0x1F400000000000p-43 
.const [22] = Int -527236096 
.const [23] = Class [53] 
.const [24] = NameAndType [54] [55] 
.const [25] = Class [56] 
.const [26] = NameAndType [57] [58] 
.const [27] = Class [59] 
.const [28] = NameAndType [60] [61] 
.const [29] = Class [62] 
.const [30] = NameAndType [63] [64] 
.const [31] = Utf8 de/audi/app/car/core/hybrid/AbstractZeroEmissionStatisticsComponent$1 
.const [32] = Utf8 java/lang/Object 
.const [33] = Utf8 de/audi/app/car/core/hybrid/AbstractZeroEmissionStatisticsComponent 
.const [34] = Utf8 de/audi/app/car/core/hybrid/StatisticsZeroEmissionEntry 
.const [35] = Class [65] 
.const [36] = NameAndType [66] [67] 
.const [37] = Class [68] 
.const [38] = NameAndType [69] [70] 
.const [39] = Class [71] 
.const [40] = NameAndType [72] [73] 
.const [41] = Class [74] 
.const [42] = NameAndType [75] [76] 
.const [43] = Class [77] 
.const [44] = NameAndType [78] [79] 
.const [45] = Class [80] 
.const [46] = NameAndType [81] [82] 
.const [47] = Class [83] 
.const [48] = NameAndType [84] [85] 
.const [49] = Class [86] 
.const [50] = NameAndType [87] [88] 
.const [51] = Class [89] 
.const [52] = NameAndType [90] [91] 
.const [53] = Utf8 de/audi/app/car/core/hybrid/AbstractZeroEmissionStatisticsComponent 
.const [54] = Utf8 access$400 
.const [55] = Utf8 (Lde/audi/app/car/core/hybrid/AbstractZeroEmissionStatisticsComponent;)Lde/audi/atip/timer/Timer; 
.const [56] = Utf8 de/audi/app/car/core/hybrid/AbstractZeroEmissionStatisticsComponent 
.const [57] = Utf8 access$500 
.const [58] = Utf8 (Lde/audi/app/car/core/hybrid/AbstractZeroEmissionStatisticsComponent;)Z 
.const [59] = Utf8 de/audi/app/car/core/hybrid/AbstractZeroEmissionStatisticsComponent 
.const [60] = Utf8 access$600 
.const [61] = Utf8 (Lde/audi/app/car/core/hybrid/AbstractZeroEmissionStatisticsComponent;D)V 
.const [62] = Utf8 de/audi/app/car/core/hybrid/AbstractZeroEmissionStatisticsComponent 
.const [63] = Utf8 access$700 
.const [64] = Utf8 (Lde/audi/app/car/core/hybrid/AbstractZeroEmissionStatisticsComponent;)V 
.const [65] = Utf8 de/audi/app/car/core/hybrid/AbstractZeroEmissionStatisticsComponent$1 
.const [66] = Utf8 this$0 
.const [67] = Utf8 Lde/audi/app/car/core/hybrid/AbstractZeroEmissionStatisticsComponent; 
.const [68] = Utf8 java/lang/Object 
.const [69] = Utf8 equals 
.const [70] = Utf8 (Ljava/lang/Object;)Z 
.const [71] = Utf8 de/audi/app/car/core/hybrid/AbstractZeroEmissionStatisticsComponent 
.const [72] = Utf8 mutex 
.const [73] = Utf8 Ljava/lang/Object; 
.const [74] = Utf8 de/audi/app/car/core/hybrid/AbstractZeroEmissionStatisticsComponent$1 
.const [75] = Utf8 intervalTimeCounter 
.const [76] = Utf8 J 
.const [77] = Utf8 de/audi/app/car/core/hybrid/AbstractZeroEmissionStatisticsComponent 
.const [78] = Utf8 currentZeroEmissionInterval 
.const [79] = Utf8 Lde/audi/app/car/core/hybrid/StatisticsZeroEmissionEntry; 
.const [80] = Utf8 de/audi/app/car/core/hybrid/StatisticsZeroEmissionEntry 
.const [81] = Utf8 getZeroEmissionValue 
.const [82] = Utf8 ()D 
.const [83] = Utf8 java/lang/Object 
.const [84] = Utf8 <init> 
.const [85] = Utf8 ()V 
.const [86] = Utf8 de/audi/app/car/core/hybrid/AbstractZeroEmissionStatisticsComponent$1 
.const [87] = Utf8 this$0 
.const [88] = Utf8 Lde/audi/app/car/core/hybrid/AbstractZeroEmissionStatisticsComponent; 
.const [89] = Utf8 de/audi/app/car/core/hybrid/AbstractZeroEmissionStatisticsComponent$1 
.const [90] = Utf8 intervalTimeCounter 
.const [91] = Utf8 J 
.const [92] = Utf8 de/audi/app/car/core/hybrid/AbstractZeroEmissionStatisticsComponent$1 
.const [93] = Class [92] 
.const [94] = Utf8 java/lang/Object 
.const [95] = Class [94] 
.const [96] = Utf8 de/audi/atip/timer/TimerListener 
.const [97] = Class [96] 
.const [98] = Utf8 intervalTimeCounter 
.const [99] = Utf8 J 
.const [100] = Utf8 this$0 
.const [101] = Utf8 Lde/audi/app/car/core/hybrid/AbstractZeroEmissionStatisticsComponent; 
.const [102] = Utf8 Code 
.const [103] = Utf8 <init> 
.const [104] = Utf8 (Lde/audi/app/car/core/hybrid/AbstractZeroEmissionStatisticsComponent;)V 
.const [105] = Utf8 fireTimer 
.const [106] = Utf8 (Lde/audi/atip/timer/Timer;)V 
.const [107] = Utf8 cancelTimer 
.const [108] = Utf8 (Lde/audi/atip/timer/Timer;)V 
.end class 
