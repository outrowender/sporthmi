.version 50 0 
.class public super [122] 
.super [124] 
.implements [126] 
.field private final [127] [128] 
.field private volatile [129] [130] 
.field private final [131] [132] 
.field private final [133] [134] 
.field private final [135] [136] 

.method public [138] : [139] 
    .attribute [137] .code stack 8 locals 0 
L0:     aload_0 
L1:     invokespecial [22] 
L4:     aload_0 
L5:     aload_1 
L6:     putfield [24] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [25] 
L14:    aload_0 
L15:    new [26] 
L18:    dup 
L19:    aload_1 
L20:    lload_3 
L21:    iconst_1 
L22:    aload_0 
L23:    invokespecial [23] 
L26:    putfield [27] 
L29:    aload_0 
L30:    aload 5 
L32:    putfield [28] 
L35:    return 
L36:    
    .end code 
.end method 

.method public synchronized [140] : [141] 
    .attribute [137] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     ldc [3] 
L6:     ldc [4] 
L8:     aload_0 
L9:     getfield [13] 
L12:    iload_1 
L13:    i2l 
L14:    invokevirtual [17] 
L17:    pop 
L18:    aload_0 
L19:    getfield [14] 
L22:    iload_1 
L23:    invokevirtual [18] 
L26:    aload_0 
L27:    getfield [15] 
L30:    invokevirtual [19] 
L33:    return 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public synchronized [142] : [143] 
    .attribute [137] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     ldc [3] 
L6:     ldc [5] 
L8:     aload_0 
L9:     getfield [13] 
L12:    iload_1 
L13:    i2l 
L14:    invokevirtual [17] 
L17:    pop 
L18:    aload_0 
L19:    iload_1 
L20:    putfield [29] 
L23:    aload_0 
L24:    getfield [15] 
L27:    invokevirtual [21] 
L30:    ifeq L57 
L33:    aload_0 
L34:    getfield [16] 
L37:    ldc [3] 
L39:    ldc [6] 
L41:    aload_0 
L42:    getfield [13] 
L45:    aload_0 
L46:    getfield [20] 
L49:    i2l 
L50:    invokevirtual [17] 
L53:    pop 
L54:    goto L89 
L57:    aload_0 
L58:    getfield [16] 
L61:    ldc [3] 
L63:    ldc [7] 
L65:    aload_0 
L66:    getfield [13] 
L69:    aload_0 
L70:    getfield [20] 
L73:    i2l 
L74:    invokevirtual [17] 
L77:    pop 
L78:    aload_0 
L79:    getfield [14] 
L82:    aload_0 
L83:    getfield [20] 
L86:    invokevirtual [18] 
L89:    return 
L90:    nop 
L91:    nop 
L92:    
    .end code 
.end method 

.method public synchronized [144] : [145] 
    .attribute [137] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [20] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public enum [146] : [147] 
    .attribute [137] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public synchronized [148] : [149] 
    .attribute [137] .code stack 6 locals 0 
L0:     aload_0 
L1:     getfield [16] 
L4:     ldc [3] 
L6:     ldc [8] 
L8:     aload_0 
L9:     getfield [13] 
L12:    aload_0 
L13:    getfield [20] 
L16:    i2l 
L17:    invokevirtual [17] 
L20:    pop 
L21:    aload_0 
L22:    getfield [14] 
L25:    aload_0 
L26:    getfield [20] 
L29:    invokevirtual [18] 
L32:    return 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [30] 
.const [3] = Int -2137614336 
.const [4] = String [31] 
.const [5] = String [32] 
.const [6] = String [33] 
.const [7] = String [34] 
.const [8] = String [35] 
.const [9] = Class [36] 
.const [10] = Class [37] 
.const [11] = Class [38] 
.const [12] = Class [39] 
.const [13] = Field [40] [41] 
.const [14] = Field [42] [43] 
.const [15] = Field [44] [45] 
.const [16] = Field [46] [47] 
.const [17] = Method [48] [49] 
.const [18] = Method [50] [51] 
.const [19] = Method [52] [53] 
.const [20] = Field [54] [55] 
.const [21] = Method [56] [57] 
.const [22] = Method [58] [59] 
.const [23] = Method [60] [61] 
.const [24] = Field [62] [63] 
.const [25] = Field [64] [65] 
.const [26] = Class [66] 
.const [27] = Field [67] [68] 
.const [28] = Field [69] [70] 
.const [29] = Field [71] [72] 
.const [30] = Utf8 de/audi/atip/timer/Timer 
.const [31] = Utf8 'BaseListModelWatcherTimer[%1]#start: setting model value to newTempValue=%2 and restarting timer.' 
.const [32] = Utf8 'BaseListModelWatcherTimer[%1]#updateWatchedRangeModel: newValidValue=%2' 
.const [33] = Utf8 'BaseListModelWatcherTimer[%1]#updateWatchedRangeModel: Timer is still running, not yet setting model value to %2' 
.const [34] = Utf8 'BaseListModelWatcherTimer[%1]#updateWatchedRangeModel: Timer is not running, setting model value to %2' 
.const [35] = Utf8 'BaseListModelWatcherTimer[%1]#fireTimer:  setting value to %2' 
.const [36] = Utf8 de/audi/app/car/core/light/BaseListModelWatcherTimer 
.const [37] = Utf8 java/lang/Object 
.const [38] = Utf8 de/audi/atip/log/LogChannel 
.const [39] = Utf8 de/audi/atip/hmi/model/list/BaseListModel 
.const [40] = Class [73] 
.const [41] = NameAndType [74] [75] 
.const [42] = Class [76] 
.const [43] = NameAndType [77] [78] 
.const [44] = Class [79] 
.const [45] = NameAndType [80] [81] 
.const [46] = Class [82] 
.const [47] = NameAndType [83] [84] 
.const [48] = Class [85] 
.const [49] = NameAndType [86] [87] 
.const [50] = Class [88] 
.const [51] = NameAndType [89] [90] 
.const [52] = Class [91] 
.const [53] = NameAndType [92] [93] 
.const [54] = Class [94] 
.const [55] = NameAndType [95] [96] 
.const [56] = Class [97] 
.const [57] = NameAndType [98] [99] 
.const [58] = Class [100] 
.const [59] = NameAndType [101] [102] 
.const [60] = Class [103] 
.const [61] = NameAndType [104] [105] 
.const [62] = Class [106] 
.const [63] = NameAndType [107] [108] 
.const [64] = Class [109] 
.const [65] = NameAndType [110] [111] 
.const [66] = Utf8 de/audi/atip/timer/Timer 
.const [67] = Class [112] 
.const [68] = NameAndType [113] [114] 
.const [69] = Class [115] 
.const [70] = NameAndType [116] [117] 
.const [71] = Class [118] 
.const [72] = NameAndType [119] [120] 
.const [73] = Utf8 de/audi/app/car/core/light/BaseListModelWatcherTimer 
.const [74] = Utf8 name 
.const [75] = Utf8 Ljava/lang/String; 
.const [76] = Utf8 de/audi/app/car/core/light/BaseListModelWatcherTimer 
.const [77] = Utf8 watchedModel 
.const [78] = Utf8 Lde/audi/atip/hmi/model/list/BaseListModel; 
.const [79] = Utf8 de/audi/app/car/core/light/BaseListModelWatcherTimer 
.const [80] = Utf8 timer 
.const [81] = Utf8 Lde/audi/atip/timer/Timer; 
.const [82] = Utf8 de/audi/app/car/core/light/BaseListModelWatcherTimer 
.const [83] = Utf8 logChannel 
.const [84] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [85] = Utf8 de/audi/atip/log/LogChannel 
.const [86] = Utf8 log 
.const [87] = Utf8 (ILjava/lang/String;Ljava/lang/Object;J)Z 
.const [88] = Utf8 de/audi/atip/hmi/model/list/BaseListModel 
.const [89] = Utf8 setSelectedIndex 
.const [90] = Utf8 (I)V 
.const [91] = Utf8 de/audi/atip/timer/Timer 
.const [92] = Utf8 restart 
.const [93] = Utf8 ()V 
.const [94] = Utf8 de/audi/app/car/core/light/BaseListModelWatcherTimer 
.const [95] = Utf8 lastValidValue 
.const [96] = Utf8 I 
.const [97] = Utf8 de/audi/atip/timer/Timer 
.const [98] = Utf8 isRunning 
.const [99] = Utf8 ()Z 
.const [100] = Utf8 java/lang/Object 
.const [101] = Utf8 <init> 
.const [102] = Utf8 ()V 
.const [103] = Utf8 de/audi/atip/timer/Timer 
.const [104] = Utf8 <init> 
.const [105] = Utf8 (Ljava/lang/String;JZLde/audi/atip/timer/TimerListener;)V 
.const [106] = Utf8 de/audi/app/car/core/light/BaseListModelWatcherTimer 
.const [107] = Utf8 name 
.const [108] = Utf8 Ljava/lang/String; 
.const [109] = Utf8 de/audi/app/car/core/light/BaseListModelWatcherTimer 
.const [110] = Utf8 watchedModel 
.const [111] = Utf8 Lde/audi/atip/hmi/model/list/BaseListModel; 
.const [112] = Utf8 de/audi/app/car/core/light/BaseListModelWatcherTimer 
.const [113] = Utf8 timer 
.const [114] = Utf8 Lde/audi/atip/timer/Timer; 
.const [115] = Utf8 de/audi/app/car/core/light/BaseListModelWatcherTimer 
.const [116] = Utf8 logChannel 
.const [117] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [118] = Utf8 de/audi/app/car/core/light/BaseListModelWatcherTimer 
.const [119] = Utf8 lastValidValue 
.const [120] = Utf8 I 
.const [121] = Utf8 de/audi/app/car/core/light/BaseListModelWatcherTimer 
.const [122] = Class [121] 
.const [123] = Utf8 java/lang/Object 
.const [124] = Class [123] 
.const [125] = Utf8 de/audi/atip/timer/TimerListener 
.const [126] = Class [125] 
.const [127] = Utf8 watchedModel 
.const [128] = Utf8 Lde/audi/atip/hmi/model/list/BaseListModel; 
.const [129] = Utf8 lastValidValue 
.const [130] = Utf8 I 
.const [131] = Utf8 timer 
.const [132] = Utf8 Lde/audi/atip/timer/Timer; 
.const [133] = Utf8 logChannel 
.const [134] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [135] = Utf8 name 
.const [136] = Utf8 Ljava/lang/String; 
.const [137] = Utf8 Code 
.const [138] = Utf8 <init> 
.const [139] = Utf8 (Ljava/lang/String;Lde/audi/atip/hmi/model/list/BaseListModel;JLde/audi/atip/log/LogChannel;)V 
.const [140] = Utf8 setTempValue 
.const [141] = Utf8 (I)V 
.const [142] = Utf8 setValidValue 
.const [143] = Utf8 (I)V 
.const [144] = Utf8 getValidValue 
.const [145] = Utf8 ()I 
.const [146] = Utf8 cancelTimer 
.const [147] = Utf8 (Lde/audi/atip/timer/Timer;)V 
.const [148] = Utf8 fireTimer 
.const [149] = Utf8 (Lde/audi/atip/timer/Timer;)V 
.end class 
