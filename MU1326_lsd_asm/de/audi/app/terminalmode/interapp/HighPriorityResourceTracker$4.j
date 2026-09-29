.version 50 0 
.class super [98] 
.super [100] 
.implements [102] 
.field private final synthetic [103] [104] 

.method [106] : [107] 
    .attribute [105] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [25] 
L5:     aload_0 
L6:     invokespecial [22] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [108] : [109] 
    .attribute [105] .code stack 4 locals 2 
L0:     aload_1 
L1:     invokevirtual [17] 
L4:     ifne L21 
L7:     aload_2 
L8:     invokevirtual [17] 
L11:    ifne L21 
L14:    aload_3 
L15:    invokevirtual [17] 
L18:    ifeq L25 
L21:    iconst_1 
L22:    goto L26 
L25:    iconst_0 
L26:    istore 4 
L28:    iload 4 
L30:    ifne L38 
L33:    ldc [2] 
L35:    goto L99 
L38:    new [26] 
L41:    dup 
L42:    invokespecial [23] 
L45:    aload_1 
L46:    invokevirtual [17] 
L49:    ifeq L57 
L52:    ldc [4] 
L54:    goto L59 
L57:    ldc [5] 
L59:    invokevirtual [18] 
L62:    aload_2 
L63:    invokevirtual [17] 
L66:    ifeq L74 
L69:    ldc [6] 
L71:    goto L76 
L74:    ldc [5] 
L76:    invokevirtual [18] 
L79:    aload_3 
L80:    invokevirtual [17] 
L83:    ifeq L91 
L86:    ldc [7] 
L88:    goto L93 
L91:    ldc [5] 
L93:    invokevirtual [18] 
L96:    invokevirtual [19] 
L99:    astore 5 
L101:   aload_0 
L102:   getfield [16] 
L105:   invokestatic [8] 
L108:   ldc [9] 
L110:   ldc [10] 
L112:   aload 5 
L114:   invokevirtual [20] 
L117:   pop 
L118:   new [27] 
L121:   dup 
L122:   iload 4 
L124:   invokespecial [24] 
L127:   areturn 
L128:   
    .end code 
.end method 

.method public synthetic [110] : [111] 
    .attribute [105] .code stack 4 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     checkcast [11] 
L5:     aload_2 
L6:     checkcast [11] 
L9:     aload_3 
L10:    checkcast [11] 
L13:    invokevirtual [21] 
L16:    areturn 
L17:    nop 
L18:    nop 
L19:    nop 
L20:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = String [28] 
.const [3] = Class [29] 
.const [4] = String [30] 
.const [5] = String [31] 
.const [6] = String [32] 
.const [7] = String [33] 
.const [8] = Method [34] [35] 
.const [9] = Int 1078071040 
.const [10] = String [36] 
.const [11] = Class [37] 
.const [12] = Class [38] 
.const [13] = Class [39] 
.const [14] = Class [40] 
.const [15] = Class [41] 
.const [16] = Field [42] [43] 
.const [17] = Method [44] [45] 
.const [18] = Method [46] [47] 
.const [19] = Method [48] [49] 
.const [20] = Method [50] [51] 
.const [21] = Method [52] [53] 
.const [22] = Method [54] [55] 
.const [23] = Method [56] [57] 
.const [24] = Method [58] [59] 
.const [25] = Field [60] [61] 
.const [26] = Class [62] 
.const [27] = Class [63] 
.const [28] = Utf8 'not blocked' 
.const [29] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [30] = Utf8 eCallActive 
.const [31] = Utf8 '' 
.const [32] = Utf8 clampSOff 
.const [33] = Utf8 rvcActive 
.const [34] = Class [64] 
.const [35] = NameAndType [65] [66] 
.const [36] = Utf8 '[HighPriorityResourceTracker.combine] %1 ' 
.const [37] = Utf8 java/lang/Boolean 
.const [38] = Utf8 de/audi/app/terminalmode/interapp/HighPriorityResourceTracker$4 
.const [39] = Utf8 java/lang/Object 
.const [40] = Utf8 de/audi/app/terminalmode/interapp/HighPriorityResourceTracker 
.const [41] = Utf8 de/audi/atip/log/LogChannel 
.const [42] = Class [67] 
.const [43] = NameAndType [68] [69] 
.const [44] = Class [70] 
.const [45] = NameAndType [71] [72] 
.const [46] = Class [73] 
.const [47] = NameAndType [74] [75] 
.const [48] = Class [76] 
.const [49] = NameAndType [77] [78] 
.const [50] = Class [79] 
.const [51] = NameAndType [80] [81] 
.const [52] = Class [82] 
.const [53] = NameAndType [83] [84] 
.const [54] = Class [85] 
.const [55] = NameAndType [86] [87] 
.const [56] = Class [88] 
.const [57] = NameAndType [89] [90] 
.const [58] = Class [91] 
.const [59] = NameAndType [92] [93] 
.const [60] = Class [94] 
.const [61] = NameAndType [95] [96] 
.const [62] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [63] = Utf8 java/lang/Boolean 
.const [64] = Utf8 de/audi/app/terminalmode/interapp/HighPriorityResourceTracker 
.const [65] = Utf8 access$100 
.const [66] = Utf8 (Lde/audi/app/terminalmode/interapp/HighPriorityResourceTracker;)Lde/audi/atip/log/LogChannel; 
.const [67] = Utf8 de/audi/app/terminalmode/interapp/HighPriorityResourceTracker$4 
.const [68] = Utf8 this$0 
.const [69] = Utf8 Lde/audi/app/terminalmode/interapp/HighPriorityResourceTracker; 
.const [70] = Utf8 java/lang/Boolean 
.const [71] = Utf8 booleanValue 
.const [72] = Utf8 ()Z 
.const [73] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [74] = Utf8 append 
.const [75] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [76] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [77] = Utf8 toString 
.const [78] = Utf8 ()Ljava/lang/String; 
.const [79] = Utf8 de/audi/atip/log/LogChannel 
.const [80] = Utf8 log 
.const [81] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [82] = Utf8 de/audi/app/terminalmode/interapp/HighPriorityResourceTracker$4 
.const [83] = Utf8 combine 
.const [84] = Utf8 (Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Ljava/lang/Boolean; 
.const [85] = Utf8 java/lang/Object 
.const [86] = Utf8 <init> 
.const [87] = Utf8 ()V 
.const [88] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [89] = Utf8 <init> 
.const [90] = Utf8 ()V 
.const [91] = Utf8 java/lang/Boolean 
.const [92] = Utf8 <init> 
.const [93] = Utf8 (Z)V 
.const [94] = Utf8 de/audi/app/terminalmode/interapp/HighPriorityResourceTracker$4 
.const [95] = Utf8 this$0 
.const [96] = Utf8 Lde/audi/app/terminalmode/interapp/HighPriorityResourceTracker; 
.const [97] = Utf8 de/audi/app/terminalmode/interapp/HighPriorityResourceTracker$4 
.const [98] = Class [97] 
.const [99] = Utf8 java/lang/Object 
.const [100] = Class [99] 
.const [101] = Utf8 de/audi/atip/utils/reactive/observables/Observables$Combinator3 
.const [102] = Class [101] 
.const [103] = Utf8 this$0 
.const [104] = Utf8 Lde/audi/app/terminalmode/interapp/HighPriorityResourceTracker; 
.const [105] = Utf8 Code 
.const [106] = Utf8 <init> 
.const [107] = Utf8 (Lde/audi/app/terminalmode/interapp/HighPriorityResourceTracker;)V 
.const [108] = Utf8 combine 
.const [109] = Utf8 (Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Ljava/lang/Boolean; 
.const [110] = Utf8 combine 
.const [111] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 
.end class 
