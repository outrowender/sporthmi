.version 50 0 
.class super [59] 
.super [61] 
.implements [63] 
.field private final synthetic [64] [65] 

.method [67] : [68] 
    .attribute [66] .code stack 2 locals 0 
L0:     aload_0 
L1:     aload_1 
L2:     putfield [13] 
L5:     aload_0 
L6:     invokespecial [11] 
L9:     return 
L10:    nop 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [69] : [70] 
    .attribute [66] .code stack 6 locals 6 
L0:     aload_1 
L1:     checkcast [2] 
L4:     astore_3 
L5:     aload_2 
L6:     checkcast [2] 
L9:     astore 4 
L11:    aload_0 
L12:    aload_3 
L13:    invokespecial [12] 
L16:    lstore 5 
L18:    aload_0 
L19:    aload 4 
L21:    invokespecial [12] 
L24:    lstore 7 
L26:    aload_0 
L27:    getfield [6] 
L30:    getfield [7] 
L33:    lload 5 
L35:    lsub 
L36:    aload_0 
L37:    getfield [6] 
L40:    getfield [7] 
L43:    lload 7 
L45:    lsub 
L46:    lsub 
L47:    l2i 
L48:    areturn 
L49:    nop 
L50:    nop 
L51:    nop 
L52:    
    .end code 
.end method 

.method private [71] : [72] 
    .attribute [66] .code stack 2 locals 0 
L0:     aload_1 
L1:     invokevirtual [8] 
L4:     tableswitch -1 
            L45 
            L50 
            L40 
            L50 
            L40 
            default : L50 

L40:    aload_1 
L41:    invokevirtual [9] 
L44:    freturn 
L45:    aload_1 
L46:    invokevirtual [10] 
L49:    freturn 
L50:    aload_1 
L51:    invokevirtual [10] 
L54:    freturn 
L55:    nop 
L56:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [14] 
.const [3] = Class [15] 
.const [4] = Class [16] 
.const [5] = Class [17] 
.const [6] = Field [18] [19] 
.const [7] = Field [20] [21] 
.const [8] = Method [22] [23] 
.const [9] = Method [24] [25] 
.const [10] = Method [26] [27] 
.const [11] = Method [28] [29] 
.const [12] = Method [30] [31] 
.const [13] = Field [32] [33] 
.const [14] = Utf8 de/audi/tghu/info/app/tmc/readout/TMCReadOutMessageImpl 
.const [15] = Utf8 de/audi/tghu/info/app/tmc/readout/TMCReadOutOnRouteQueue$TMCComparator 
.const [16] = Utf8 java/lang/Object 
.const [17] = Utf8 de/audi/tghu/info/app/tmc/readout/TMCReadOutOnRouteQueue 
.const [18] = Class [34] 
.const [19] = NameAndType [35] [36] 
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
.const [34] = Utf8 de/audi/tghu/info/app/tmc/readout/TMCReadOutOnRouteQueue$TMCComparator 
.const [35] = Utf8 this$0 
.const [36] = Utf8 Lde/audi/tghu/info/app/tmc/readout/TMCReadOutOnRouteQueue; 
.const [37] = Utf8 de/audi/tghu/info/app/tmc/readout/TMCReadOutOnRouteQueue 
.const [38] = Utf8 distanceToTarget 
.const [39] = Utf8 J 
.const [40] = Utf8 de/audi/tghu/info/app/tmc/readout/TMCReadOutMessageImpl 
.const [41] = Utf8 getReadOutState 
.const [42] = Utf8 ()I 
.const [43] = Utf8 de/audi/tghu/info/app/tmc/readout/TMCReadOutMessageImpl 
.const [44] = Utf8 getDistanceToAttentionPoint2 
.const [45] = Utf8 ()J 
.const [46] = Utf8 de/audi/tghu/info/app/tmc/readout/TMCReadOutMessageImpl 
.const [47] = Utf8 getDistanceToAttentionPoint1 
.const [48] = Utf8 ()J 
.const [49] = Utf8 java/lang/Object 
.const [50] = Utf8 <init> 
.const [51] = Utf8 ()V 
.const [52] = Utf8 de/audi/tghu/info/app/tmc/readout/TMCReadOutOnRouteQueue$TMCComparator 
.const [53] = Utf8 getDistanceForCalculation 
.const [54] = Utf8 (Lde/audi/tghu/info/app/tmc/readout/TMCReadOutMessageImpl;)J 
.const [55] = Utf8 de/audi/tghu/info/app/tmc/readout/TMCReadOutOnRouteQueue$TMCComparator 
.const [56] = Utf8 this$0 
.const [57] = Utf8 Lde/audi/tghu/info/app/tmc/readout/TMCReadOutOnRouteQueue; 
.const [58] = Utf8 de/audi/tghu/info/app/tmc/readout/TMCReadOutOnRouteQueue$TMCComparator 
.const [59] = Class [58] 
.const [60] = Utf8 java/lang/Object 
.const [61] = Class [60] 
.const [62] = Utf8 java/util/Comparator 
.const [63] = Class [62] 
.const [64] = Utf8 this$0 
.const [65] = Utf8 Lde/audi/tghu/info/app/tmc/readout/TMCReadOutOnRouteQueue; 
.const [66] = Utf8 Code 
.const [67] = Utf8 <init> 
.const [68] = Utf8 (Lde/audi/tghu/info/app/tmc/readout/TMCReadOutOnRouteQueue;)V 
.const [69] = Utf8 compare 
.const [70] = Utf8 (Ljava/lang/Object;Ljava/lang/Object;)I 
.const [71] = Utf8 getDistanceForCalculation 
.const [72] = Utf8 (Lde/audi/tghu/info/app/tmc/readout/TMCReadOutMessageImpl;)J 
.end class 
