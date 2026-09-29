.version 50 0 
.class public super [70] 
.super [72] 
.field private [73] [74] 
.field private [75] [76] 

.method public [78] : [79] 
    .attribute [77] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [13] 
L4:     aload_0 
L5:     aconst_null 
L6:     putfield [16] 
L9:     aload_0 
L10:    aload_1 
L11:    putfield [17] 
L14:    return 
L15:    nop 
L16:    
    .end code 
.end method 

.method public [80] : [81] 
    .attribute [77] .code stack 4 locals 2 
L0:     aload_0 
L1:     getfield [11] 
L4:     ldc [2] 
L6:     ldc [3] 
L8:     aload_1 
L9:     invokevirtual [12] 
L12:    pop 
L13:    aload_0 
L14:    dup 
L15:    astore_2 
L16:    monitorenter 
        .catch [0] from L17 to L28 using L31 
L17:    aload_0 
L18:    aload_1 
L19:    putfield [16] 
L22:    aload_0 
L23:    invokespecial [14] 
L26:    aload_2 
L27:    monitorexit 
L28:    goto L36 
        .catch [0] from L31 to L34 using L31 
L31:    astore_3 
L32:    aload_2 
L33:    monitorexit 
L34:    aload_3 
L35:    athrow 
L36:    return 
L37:    nop 
L38:    nop 
L39:    nop 
L40:    
    .end code 
.end method 

.method public [82] : [83] 
    .attribute [77] .code stack 2 locals 3 
L0:     aload_0 
L1:     dup 
L2:     astore_1 
L3:     monitorenter 
L4:     aload_0 
L5:     getfield [10] 
L8:     ifnonnull L26 
        .catch [4] from L11 to L15 using L18 
        .catch [0] from L4 to L39 using L40 
L11:    aload_0 
L12:    invokespecial [15] 
L15:    goto L4 
L18:    astore_2 
L19:    invokestatic [5] 
L22:    pop 
L23:    goto L4 
L26:    aload_0 
L27:    getfield [10] 
L30:    astore_2 
L31:    aload_0 
L32:    aconst_null 
L33:    putfield [16] 
L36:    aload_2 
L37:    aload_1 
L38:    monitorexit 
L39:    areturn 
        .catch [0] from L40 to L43 using L40 
L40:    astore_3 
L41:    aload_1 
L42:    monitorexit 
L43:    aload_3 
L44:    athrow 
L45:    nop 
L46:    nop 
L47:    nop 
L48:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Int -2137614336 
.const [3] = String [18] 
.const [4] = Class [19] 
.const [5] = Method [20] [21] 
.const [6] = Class [22] 
.const [7] = Class [23] 
.const [8] = Class [24] 
.const [9] = Class [25] 
.const [10] = Field [26] [27] 
.const [11] = Field [28] [29] 
.const [12] = Method [30] [31] 
.const [13] = Method [32] [33] 
.const [14] = Method [34] [35] 
.const [15] = Method [36] [37] 
.const [16] = Field [38] [39] 
.const [17] = Field [40] [41] 
.const [18] = Utf8 'TrafficSignQueue#postTrafficSign( %1 )' 
.const [19] = Utf8 java/lang/InterruptedException 
.const [20] = Class [42] 
.const [21] = NameAndType [43] [44] 
.const [22] = Utf8 de/audi/tghu/navi/app/tr/TrafficSignQueue 
.const [23] = Utf8 java/lang/Object 
.const [24] = Utf8 de/audi/atip/log/LogChannel 
.const [25] = Utf8 java/lang/Thread 
.const [26] = Class [45] 
.const [27] = NameAndType [46] [47] 
.const [28] = Class [48] 
.const [29] = NameAndType [49] [50] 
.const [30] = Class [51] 
.const [31] = NameAndType [52] [53] 
.const [32] = Class [54] 
.const [33] = NameAndType [55] [56] 
.const [34] = Class [57] 
.const [35] = NameAndType [58] [59] 
.const [36] = Class [60] 
.const [37] = NameAndType [61] [62] 
.const [38] = Class [63] 
.const [39] = NameAndType [64] [65] 
.const [40] = Class [66] 
.const [41] = NameAndType [67] [68] 
.const [42] = Utf8 java/lang/Thread 
.const [43] = Utf8 interrupted 
.const [44] = Utf8 ()Z 
.const [45] = Utf8 de/audi/tghu/navi/app/tr/TrafficSignQueue 
.const [46] = Utf8 queuedTrafficSign 
.const [47] = Utf8 Lorg/dsi/ifc/trafficregulation/TrafficSignInformation; 
.const [48] = Utf8 de/audi/tghu/navi/app/tr/TrafficSignQueue 
.const [49] = Utf8 logChannel 
.const [50] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [51] = Utf8 de/audi/atip/log/LogChannel 
.const [52] = Utf8 log 
.const [53] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [54] = Utf8 java/lang/Object 
.const [55] = Utf8 <init> 
.const [56] = Utf8 ()V 
.const [57] = Utf8 java/lang/Object 
.const [58] = Utf8 notifyAll 
.const [59] = Utf8 ()V 
.const [60] = Utf8 java/lang/Object 
.const [61] = Utf8 wait 
.const [62] = Utf8 ()V 
.const [63] = Utf8 de/audi/tghu/navi/app/tr/TrafficSignQueue 
.const [64] = Utf8 queuedTrafficSign 
.const [65] = Utf8 Lorg/dsi/ifc/trafficregulation/TrafficSignInformation; 
.const [66] = Utf8 de/audi/tghu/navi/app/tr/TrafficSignQueue 
.const [67] = Utf8 logChannel 
.const [68] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [69] = Utf8 de/audi/tghu/navi/app/tr/TrafficSignQueue 
.const [70] = Class [69] 
.const [71] = Utf8 java/lang/Object 
.const [72] = Class [71] 
.const [73] = Utf8 logChannel 
.const [74] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [75] = Utf8 queuedTrafficSign 
.const [76] = Utf8 Lorg/dsi/ifc/trafficregulation/TrafficSignInformation; 
.const [77] = Utf8 Code 
.const [78] = Utf8 <init> 
.const [79] = Utf8 (Lde/audi/atip/log/LogChannel;)V 
.const [80] = Utf8 postTrafficSign 
.const [81] = Utf8 (Lorg/dsi/ifc/trafficregulation/TrafficSignInformation;)V 
.const [82] = Utf8 waitForNextTrafficSign 
.const [83] = Utf8 ()Lorg/dsi/ifc/trafficregulation/TrafficSignInformation; 
.end class 
