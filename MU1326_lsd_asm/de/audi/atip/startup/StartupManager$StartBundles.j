.version 50 0 
.class super [96] 
.super [98] 
.field private final [99] [100] 
.field private final synthetic [101] [102] 

.method [104] : [105] 
    .attribute [103] .code stack 7 locals 1 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [22] 
L5:     aload_0 
L6:     aload_1 
L7:     ldc [2] 
L9:     aload_2 
L10:    arraylength 
L11:    invokespecial [19] 
L14:    iconst_0 
L15:    istore 4 
L17:    iload 4 
L19:    aload_2 
L20:    arraylength 
L21:    if_icmpge L50 
L24:    aload_0 
L25:    getfield [14] 
L28:    iload 4 
L30:    new [23] 
L33:    dup 
L34:    aload_1 
L35:    aload_2 
L36:    iload 4 
L38:    aaload 
L39:    aload_3 
L40:    invokespecial [20] 
L43:    aastore 
L44:    iinc 4 1 
L47:    goto L17 
L50:    aload_0 
L51:    aload_3 
L52:    putfield [24] 
L55:    return 
L56:    
    .end code 
.end method 

.method public [106] : [107] 
    .attribute [103] .code stack 4 locals 0 
L0:     aload_0 
L1:     getfield [15] 
L4:     ifnull L61 
L7:     aload_0 
L8:     getfield [15] 
L11:    invokevirtual [16] 
L14:    ifeq L34 
L17:    aload_0 
L18:    getfield [13] 
L21:    invokestatic [4] 
L24:    ldc [5] 
L26:    ldc [6] 
L28:    aload_0 
L29:    invokevirtual [17] 
L32:    pop 
L33:    return 
L34:    aload_0 
L35:    getfield [15] 
L38:    invokevirtual [18] 
L41:    ifeq L61 
L44:    aload_0 
L45:    getfield [13] 
L48:    invokestatic [4] 
L51:    ldc [5] 
L53:    ldc [7] 
L55:    aload_0 
L56:    invokevirtual [17] 
L59:    pop 
L60:    return 
L61:    aload_0 
L62:    invokespecial [21] 
L65:    return 
L66:    nop 
L67:    nop 
L68:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [25] 
.const [3] = Class [26] 
.const [4] = Method [27] [28] 
.const [5] = Int 1078071040 
.const [6] = String [29] 
.const [7] = String [30] 
.const [8] = Class [31] 
.const [9] = Class [32] 
.const [10] = Class [33] 
.const [11] = Class [34] 
.const [12] = Class [35] 
.const [13] = Field [36] [37] 
.const [14] = Field [38] [39] 
.const [15] = Field [40] [41] 
.const [16] = Method [42] [43] 
.const [17] = Method [44] [45] 
.const [18] = Method [46] [47] 
.const [19] = Method [48] [49] 
.const [20] = Method [50] [51] 
.const [21] = Method [52] [53] 
.const [22] = Field [54] [55] 
.const [23] = Class [56] 
.const [24] = Field [57] [58] 
.const [25] = Utf8 'StartBundles: ' 
.const [26] = Utf8 de/audi/atip/startup/StartupManager$StartBundle 
.const [27] = Class [59] 
.const [28] = NameAndType [60] [61] 
.const [29] = Utf8 '%1 Do not start due to domain error!' 
.const [30] = Utf8 '%1 Do not start, startDomain call is still pending!' 
.const [31] = Utf8 de/audi/atip/startup/StartupManager$StartBundles 
.const [32] = Utf8 de/audi/atip/startup/StartupManager$BundlesJob 
.const [33] = Utf8 de/audi/atip/startup/StartupManager 
.const [34] = Utf8 de/audi/atip/startup/ComponentState 
.const [35] = Utf8 de/audi/atip/log/LogChannel 
.const [36] = Class [62] 
.const [37] = NameAndType [63] [64] 
.const [38] = Class [65] 
.const [39] = NameAndType [66] [67] 
.const [40] = Class [68] 
.const [41] = NameAndType [69] [70] 
.const [42] = Class [71] 
.const [43] = NameAndType [72] [73] 
.const [44] = Class [74] 
.const [45] = NameAndType [75] [76] 
.const [46] = Class [77] 
.const [47] = NameAndType [78] [79] 
.const [48] = Class [80] 
.const [49] = NameAndType [81] [82] 
.const [50] = Class [83] 
.const [51] = NameAndType [84] [85] 
.const [52] = Class [86] 
.const [53] = NameAndType [87] [88] 
.const [54] = Class [89] 
.const [55] = NameAndType [90] [91] 
.const [56] = Utf8 de/audi/atip/startup/StartupManager$StartBundle 
.const [57] = Class [92] 
.const [58] = NameAndType [93] [94] 
.const [59] = Utf8 de/audi/atip/startup/StartupManager 
.const [60] = Utf8 access$300 
.const [61] = Utf8 (Lde/audi/atip/startup/StartupManager;)Lde/audi/atip/log/LogChannel; 
.const [62] = Utf8 de/audi/atip/startup/StartupManager$StartBundles 
.const [63] = Utf8 this$0 
.const [64] = Utf8 Lde/audi/atip/startup/StartupManager; 
.const [65] = Utf8 de/audi/atip/startup/StartupManager$StartBundles 
.const [66] = Utf8 jobs 
.const [67] = Utf8 [Lde/audi/atip/startup/StartupManager$BundleJob; 
.const [68] = Utf8 de/audi/atip/startup/StartupManager$StartBundles 
.const [69] = Utf8 componentState 
.const [70] = Utf8 Lde/audi/atip/startup/ComponentState; 
.const [71] = Utf8 de/audi/atip/startup/ComponentState 
.const [72] = Utf8 isDomainFailed 
.const [73] = Utf8 ()Z 
.const [74] = Utf8 de/audi/atip/log/LogChannel 
.const [75] = Utf8 log 
.const [76] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [77] = Utf8 de/audi/atip/startup/ComponentState 
.const [78] = Utf8 isWaitingForDomainStart 
.const [79] = Utf8 ()Z 
.const [80] = Utf8 de/audi/atip/startup/StartupManager$BundlesJob 
.const [81] = Utf8 <init> 
.const [82] = Utf8 (Lde/audi/atip/startup/StartupManager;Ljava/lang/String;I)V 
.const [83] = Utf8 de/audi/atip/startup/StartupManager$StartBundle 
.const [84] = Utf8 <init> 
.const [85] = Utf8 (Lde/audi/atip/startup/StartupManager;Lorg/osgi/framework/Bundle;Lde/audi/atip/startup/ComponentState;)V 
.const [86] = Utf8 de/audi/atip/startup/StartupManager$BundlesJob 
.const [87] = Utf8 run 
.const [88] = Utf8 ()V 
.const [89] = Utf8 de/audi/atip/startup/StartupManager$StartBundles 
.const [90] = Utf8 this$0 
.const [91] = Utf8 Lde/audi/atip/startup/StartupManager; 
.const [92] = Utf8 de/audi/atip/startup/StartupManager$StartBundles 
.const [93] = Utf8 componentState 
.const [94] = Utf8 Lde/audi/atip/startup/ComponentState; 
.const [95] = Utf8 de/audi/atip/startup/StartupManager$StartBundles 
.const [96] = Class [95] 
.const [97] = Utf8 de/audi/atip/startup/StartupManager$BundlesJob 
.const [98] = Class [97] 
.const [99] = Utf8 componentState 
.const [100] = Utf8 Lde/audi/atip/startup/ComponentState; 
.const [101] = Utf8 this$0 
.const [102] = Utf8 Lde/audi/atip/startup/StartupManager; 
.const [103] = Utf8 Code 
.const [104] = Utf8 <init> 
.const [105] = Utf8 (Lde/audi/atip/startup/StartupManager;[Lorg/osgi/framework/Bundle;Lde/audi/atip/startup/ComponentState;)V 
.const [106] = Utf8 run 
.const [107] = Utf8 ()V 
.end class 
