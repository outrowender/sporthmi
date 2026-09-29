.version 50 0 
.class super [78] 
.super [80] 
.implements [82] 
.field private [83] [84] 
.field private final synthetic [85] [86] 

.method public [88] : [89] 
    .attribute [87] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [19] 
L5:     aload_0 
L6:     invokespecial [17] 
L9:     aload_0 
L10:    iload_2 
L11:    putfield [18] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [90] : [91] 
    .attribute [87] .code stack 5 locals 0 
L0:     getstatic [2] 
L3:     ldc [3] 
L5:     ldc [4] 
L7:     aload_0 
L8:     getfield [13] 
L11:    i2l 
L12:    invokevirtual [15] 
L15:    pop 
L16:    aload_0 
L17:    getfield [13] 
L20:    iconst_2 
L21:    if_icmpne L38 
L24:    aload_0 
L25:    getfield [14] 
L28:    aload_0 
L29:    getfield [13] 
L32:    invokevirtual [16] 
L35:    goto L86 
L38:    aload_0 
L39:    getfield [13] 
L42:    iconst_1 
L43:    if_icmpne L70 
L46:    aload_0 
L47:    getfield [14] 
L50:    invokestatic [5] 
L53:    ifne L70 
L56:    aload_0 
L57:    getfield [14] 
L60:    aload_0 
L61:    getfield [13] 
L64:    invokevirtual [16] 
L67:    goto L86 
L70:    getstatic [2] 
L73:    ldc [3] 
L75:    ldc [6] 
L77:    aload_0 
L78:    getfield [13] 
L81:    i2l 
L82:    invokevirtual [15] 
L85:    pop 
L86:    aload_0 
L87:    getfield [14] 
L90:    aconst_null 
L91:    invokestatic [7] 
L94:    pop 
L95:    return 
L96:    
    .end code 
.end method 

.method static synthetic [92] : [93] 
    .attribute [87] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [13] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Field [20] [21] 
.const [3] = Int -2137614336 
.const [4] = String [22] 
.const [5] = Method [23] [24] 
.const [6] = String [25] 
.const [7] = Method [26] [27] 
.const [8] = Class [28] 
.const [9] = Class [29] 
.const [10] = Class [30] 
.const [11] = Class [31] 
.const [12] = Class [32] 
.const [13] = Field [33] [34] 
.const [14] = Field [35] [36] 
.const [15] = Method [37] [38] 
.const [16] = Method [39] [40] 
.const [17] = Method [41] [42] 
.const [18] = Field [43] [44] 
.const [19] = Field [45] [46] 
.const [20] = Class [47] 
.const [21] = NameAndType [48] [49] 
.const [22] = Utf8 'DelayedViewSizeChange#run Requesting stage %1' 
.const [23] = Class [50] 
.const [24] = NameAndType [51] [52] 
.const [25] = Utf8 'DelayedViewSizeChange#run Requesting stage %1, but new reasons appeared in the meantime.' 
.const [26] = Class [53] 
.const [27] = NameAndType [54] [55] 
.const [28] = Utf8 de/esolutions/hmi/widgets/audi/evo/ViewSizeManager$DelayedViewSizeChange 
.const [29] = Utf8 java/lang/Object 
.const [30] = Utf8 de/esolutions/hmi/widgets/audi/base/IWidgetLogChannel 
.const [31] = Utf8 de/audi/atip/log/LogChannel 
.const [32] = Utf8 de/esolutions/hmi/widgets/audi/evo/ViewSizeManager 
.const [33] = Class [56] 
.const [34] = NameAndType [57] [58] 
.const [35] = Class [59] 
.const [36] = NameAndType [60] [61] 
.const [37] = Class [62] 
.const [38] = NameAndType [63] [64] 
.const [39] = Class [65] 
.const [40] = NameAndType [66] [67] 
.const [41] = Class [68] 
.const [42] = NameAndType [69] [70] 
.const [43] = Class [71] 
.const [44] = NameAndType [72] [73] 
.const [45] = Class [74] 
.const [46] = NameAndType [75] [76] 
.const [47] = Utf8 de/esolutions/hmi/widgets/audi/base/IWidgetLogChannel 
.const [48] = Utf8 logViewSize 
.const [49] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [50] = Utf8 de/esolutions/hmi/widgets/audi/evo/ViewSizeManager 
.const [51] = Utf8 access$000 
.const [52] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/ViewSizeManager;)I 
.const [53] = Utf8 de/esolutions/hmi/widgets/audi/evo/ViewSizeManager 
.const [54] = Utf8 access$102 
.const [55] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/ViewSizeManager;Lde/esolutions/fw/util/commons/job/Job;)Lde/esolutions/fw/util/commons/job/Job; 
.const [56] = Utf8 de/esolutions/hmi/widgets/audi/evo/ViewSizeManager$DelayedViewSizeChange 
.const [57] = Utf8 desiredViewSize 
.const [58] = Utf8 I 
.const [59] = Utf8 de/esolutions/hmi/widgets/audi/evo/ViewSizeManager$DelayedViewSizeChange 
.const [60] = Utf8 this$0 
.const [61] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/ViewSizeManager; 
.const [62] = Utf8 de/audi/atip/log/LogChannel 
.const [63] = Utf8 log 
.const [64] = Utf8 (ILjava/lang/String;J)Z 
.const [65] = Utf8 de/esolutions/hmi/widgets/audi/evo/ViewSizeManager 
.const [66] = Utf8 requestViewSizeChange 
.const [67] = Utf8 (I)V 
.const [68] = Utf8 java/lang/Object 
.const [69] = Utf8 <init> 
.const [70] = Utf8 ()V 
.const [71] = Utf8 de/esolutions/hmi/widgets/audi/evo/ViewSizeManager$DelayedViewSizeChange 
.const [72] = Utf8 desiredViewSize 
.const [73] = Utf8 I 
.const [74] = Utf8 de/esolutions/hmi/widgets/audi/evo/ViewSizeManager$DelayedViewSizeChange 
.const [75] = Utf8 this$0 
.const [76] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/ViewSizeManager; 
.const [77] = Utf8 de/esolutions/hmi/widgets/audi/evo/ViewSizeManager$DelayedViewSizeChange 
.const [78] = Class [77] 
.const [79] = Utf8 java/lang/Object 
.const [80] = Class [79] 
.const [81] = Utf8 java/lang/Runnable 
.const [82] = Class [81] 
.const [83] = Utf8 desiredViewSize 
.const [84] = Utf8 I 
.const [85] = Utf8 this$0 
.const [86] = Utf8 Lde/esolutions/hmi/widgets/audi/evo/ViewSizeManager; 
.const [87] = Utf8 Code 
.const [88] = Utf8 <init> 
.const [89] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/ViewSizeManager;I)V 
.const [90] = Utf8 run 
.const [91] = Utf8 ()V 
.const [92] = Utf8 access$400 
.const [93] = Utf8 (Lde/esolutions/hmi/widgets/audi/evo/ViewSizeManager$DelayedViewSizeChange;)I 
.end class 
