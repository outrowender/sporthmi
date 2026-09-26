.version 50 0 
.class public super [190] 
.super [192] 
.field private final [193] [194] 
.field private [195] [196] 
.field private [197] [198] 
.field private final [199] [200] 
.field private [201] [202] 
.field private [203] [204] 

.method protected [206] : [207] 
    .attribute [205] .code stack 3 locals 0 
L0:     aload_0 
L1:     invokespecial [37] 
L4:     aload_0 
L5:     iconst_0 
L6:     putfield [39] 
L9:     aload_0 
L10:    iconst_0 
L11:    putfield [40] 
L14:    aload_0 
L15:    invokestatic [2] 
L18:    putfield [41] 
L21:    aload_0 
L22:    aload_1 
L23:    putfield [42] 
L26:    aload_0 
L27:    aload_2 
L28:    putfield [43] 
L31:    return 
L32:    
    .end code 
.end method 

.method public [208] : [209] 
    .attribute [205] .code stack 3 locals 0 
L0:     aload_0 
L1:     dup 
L2:     getfield [22] 
L5:     aload_1 
L6:     arraylength 
L7:     iadd 
L8:     putfield [39] 
L11:    return 
L12:    
    .end code 
.end method 

.method public [210] : [211] 
    .attribute [205] .code stack 3 locals 0 
L0:     iload_1 
L1:     tableswitch 0 
            L32 
            L45 
            L58 
            L71 
            default : L84 

L32:    aload_0 
L33:    dup 
L34:    getfield [22] 
L37:    iconst_1 
L38:    iadd 
L39:    putfield [39] 
L42:    goto L84 
L45:    aload_0 
L46:    dup 
L47:    getfield [22] 
L50:    iconst_2 
L51:    iadd 
L52:    putfield [39] 
L55:    goto L84 
L58:    aload_0 
L59:    dup 
L60:    getfield [22] 
L63:    iconst_4 
L64:    iadd 
L65:    putfield [39] 
L68:    goto L84 
L71:    aload_0 
L72:    dup 
L73:    getfield [22] 
L76:    iconst_4 
L77:    iadd 
L78:    putfield [39] 
L81:    goto L84 
L84:    return 
L85:    nop 
L86:    nop 
L87:    nop 
L88:    
    .end code 
.end method 

.method public [212] : [213] 
    .attribute [205] .code stack 3 locals 0 
L0:     aload_0 
L1:     dup 
L2:     getfield [23] 
L5:     iconst_1 
L6:     iadd 
L7:     putfield [40] 
L10:    return 
L11:    nop 
L12:    
    .end code 
.end method 

.method public [214] : [215] 
    .attribute [205] .code stack 4 locals 0 
L0:     invokestatic [3] 
L3:     ldc [4] 
L5:     ldc [5] 
L7:     aload_0 
L8:     getfield [25] 
L11:    invokevirtual [27] 
L14:    pop 
L15:    aload_0 
L16:    iconst_0 
L17:    putfield [39] 
L20:    aload_0 
L21:    iconst_0 
L22:    putfield [40] 
L25:    aload_0 
L26:    invokestatic [2] 
L29:    putfield [41] 
L32:    return 
L33:    nop 
L34:    nop 
L35:    nop 
L36:    
    .end code 
.end method 

.method public interface [216] : [217] 
    .attribute [205] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [22] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public interface [218] : [219] 
    .attribute [205] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [23] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 

.method public [220] : [221] 
    .attribute [205] .code stack 4 locals 5 
L0:     invokestatic [2] 
L3:     lstore_1 
L4:     lload_1 
L5:     aload_0 
L6:     getfield [24] 
L9:     lsub 
L10:    ldc_w [1] 
L13:    ldiv 
L14:    lstore_3 
L15:    new [44] 
L18:    dup 
L19:    invokespecial [38] 
L22:    astore 5 
L24:    aload 5 
L26:    aload_0 
L27:    getfield [25] 
L30:    invokevirtual [28] 
L33:    pop 
L34:    aload 5 
L36:    ldc [7] 
L38:    invokevirtual [28] 
L41:    pop 
L42:    aload 5 
L44:    ldc [8] 
L46:    invokevirtual [28] 
L49:    lload_3 
L50:    invokevirtual [29] 
L53:    ldc [9] 
L55:    invokevirtual [28] 
L58:    pop 
L59:    aload 5 
L61:    aload_0 
L62:    getfield [22] 
L65:    invokevirtual [30] 
L68:    ldc [10] 
L70:    invokevirtual [28] 
L73:    pop 
L74:    aload 5 
L76:    aload_0 
L77:    getfield [22] 
L80:    i2f 
L81:    lload_3 
L82:    l2f 
L83:    fdiv 
L84:    invokevirtual [31] 
L87:    ldc [11] 
L89:    invokevirtual [28] 
L92:    pop 
L93:    aload 5 
L95:    aload_0 
L96:    getfield [23] 
L99:    invokevirtual [30] 
L102:   ldc [12] 
L104:   invokevirtual [28] 
L107:   pop 
L108:   aload 5 
L110:   aload_0 
L111:   getfield [23] 
L114:   i2f 
L115:   lload_3 
L116:   l2f 
L117:   fdiv 
L118:   invokevirtual [31] 
L121:   ldc [13] 
L123:   invokevirtual [28] 
L126:   pop 
L127:   aload 5 
L129:   invokevirtual [32] 
L132:   areturn 
L133:   nop 
L134:   nop 
L135:   nop 
L136:   
    .end code 
.end method 

.method public [222] : [223] 
    .attribute [205] .code stack 4 locals 0 
L0:     aload_0 
L1:     invokevirtual [33] 
L4:     aload_0 
L5:     getfield [26] 
L8:     ldc [14] 
L10:    ldc [15] 
L12:    aload_1 
L13:    invokevirtual [27] 
L16:    pop 
L17:    aload_0 
L18:    iconst_1 
L19:    putfield [45] 
L22:    return 
L23:    nop 
L24:    
    .end code 
.end method 

.method public [224] : [225] 
    .attribute [205] .code stack 5 locals 0 
L0:     aload_0 
L1:     getfield [26] 
L4:     ldc [14] 
L6:     ldc [16] 
L8:     aload_1 
L9:     aload_0 
L10:    invokevirtual [35] 
L13:    invokevirtual [36] 
L16:    aload_0 
L17:    invokevirtual [33] 
L20:    aload_0 
L21:    iconst_0 
L22:    putfield [45] 
L25:    return 
L26:    nop 
L27:    nop 
L28:    
    .end code 
.end method 

.method public interface [226] : [227] 
    .attribute [205] .code stack 1 locals 0 
L0:     aload_0 
L1:     getfield [34] 
L4:     areturn 
L5:     nop 
L6:     nop 
L7:     nop 
L8:     
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Method [47] [48] 
.const [3] = Method [49] [50] 
.const [4] = Int -2137614336 
.const [5] = String [51] 
.const [6] = Class [52] 
.const [7] = String [53] 
.const [8] = String [54] 
.const [9] = String [55] 
.const [10] = String [56] 
.const [11] = String [57] 
.const [12] = String [58] 
.const [13] = String [59] 
.const [14] = Int 1078071040 
.const [15] = String [60] 
.const [16] = String [61] 
.const [17] = Class [62] 
.const [18] = Class [63] 
.const [19] = Class [64] 
.const [20] = Class [65] 
.const [21] = Class [66] 
.const [22] = Field [67] [68] 
.const [23] = Field [69] [70] 
.const [24] = Field [71] [72] 
.const [25] = Field [73] [74] 
.const [26] = Field [75] [76] 
.const [27] = Method [77] [78] 
.const [28] = Method [79] [80] 
.const [29] = Method [81] [82] 
.const [30] = Method [83] [84] 
.const [31] = Method [85] [86] 
.const [32] = Method [87] [88] 
.const [33] = Method [89] [90] 
.const [34] = Field [91] [92] 
.const [35] = Method [93] [94] 
.const [36] = Method [95] [96] 
.const [37] = Method [97] [98] 
.const [38] = Method [99] [100] 
.const [39] = Field [101] [102] 
.const [40] = Field [103] [104] 
.const [41] = Field [105] [106] 
.const [42] = Field [107] [108] 
.const [43] = Field [109] [110] 
.const [44] = Class [111] 
.const [45] = Field [112] [113] 
.const [46] = Int -402456576 
.const [47] = Class [114] 
.const [48] = NameAndType [115] [116] 
.const [49] = Class [117] 
.const [50] = NameAndType [118] [119] 
.const [51] = Utf8 '[TrafficCounter#reset] reset traffic counter "%1"' 
.const [52] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [53] = Utf8 ' - current Statistics:\n' 
.const [54] = Utf8 'time of measurement (sec): ' 
.const [55] = Utf8 '\n' 
.const [56] = Utf8 ' bytes transmitted (' 
.const [57] = Utf8 ' bytes/sec)\n' 
.const [58] = Utf8 ' requests transmitted (' 
.const [59] = Utf8 ' requests/sec)\n' 
.const [60] = Utf8 '[TrafficCounter#startMeasurement] %1' 
.const [61] = Utf8 '[TrafficCounter#stopMeasurement] %1\n%2' 
.const [62] = Utf8 de/audi/app/combi/bap/utils/TrafficCounter 
.const [63] = Utf8 java/lang/Object 
.const [64] = Utf8 java/lang/System 
.const [65] = Utf8 de/audi/app/combi/bap/utils/TrafficStatistics 
.const [66] = Utf8 de/audi/atip/log/LogChannel 
.const [67] = Class [120] 
.const [68] = NameAndType [121] [122] 
.const [69] = Class [123] 
.const [70] = NameAndType [124] [125] 
.const [71] = Class [126] 
.const [72] = NameAndType [127] [128] 
.const [73] = Class [129] 
.const [74] = NameAndType [130] [131] 
.const [75] = Class [132] 
.const [76] = NameAndType [133] [134] 
.const [77] = Class [135] 
.const [78] = NameAndType [136] [137] 
.const [79] = Class [138] 
.const [80] = NameAndType [139] [140] 
.const [81] = Class [141] 
.const [82] = NameAndType [142] [143] 
.const [83] = Class [144] 
.const [84] = NameAndType [145] [146] 
.const [85] = Class [147] 
.const [86] = NameAndType [148] [149] 
.const [87] = Class [150] 
.const [88] = NameAndType [151] [152] 
.const [89] = Class [153] 
.const [90] = NameAndType [154] [155] 
.const [91] = Class [156] 
.const [92] = NameAndType [157] [158] 
.const [93] = Class [159] 
.const [94] = NameAndType [160] [161] 
.const [95] = Class [162] 
.const [96] = NameAndType [163] [164] 
.const [97] = Class [165] 
.const [98] = NameAndType [166] [167] 
.const [99] = Class [168] 
.const [100] = NameAndType [169] [170] 
.const [101] = Class [171] 
.const [102] = NameAndType [172] [173] 
.const [103] = Class [174] 
.const [104] = NameAndType [175] [176] 
.const [105] = Class [177] 
.const [106] = NameAndType [178] [179] 
.const [107] = Class [180] 
.const [108] = NameAndType [181] [182] 
.const [109] = Class [183] 
.const [110] = NameAndType [184] [185] 
.const [111] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [112] = Class [186] 
.const [113] = NameAndType [187] [188] 
.const [114] = Utf8 java/lang/System 
.const [115] = Utf8 currentTimeMillis 
.const [116] = Utf8 ()J 
.const [117] = Utf8 de/audi/app/combi/bap/utils/TrafficStatistics 
.const [118] = Utf8 getLogChannel 
.const [119] = Utf8 ()Lde/audi/atip/log/LogChannel; 
.const [120] = Utf8 de/audi/app/combi/bap/utils/TrafficCounter 
.const [121] = Utf8 countBytesTransmitted 
.const [122] = Utf8 I 
.const [123] = Utf8 de/audi/app/combi/bap/utils/TrafficCounter 
.const [124] = Utf8 countRequests 
.const [125] = Utf8 I 
.const [126] = Utf8 de/audi/app/combi/bap/utils/TrafficCounter 
.const [127] = Utf8 timestampLastReset 
.const [128] = Utf8 J 
.const [129] = Utf8 de/audi/app/combi/bap/utils/TrafficCounter 
.const [130] = Utf8 name 
.const [131] = Utf8 Ljava/lang/String; 
.const [132] = Utf8 de/audi/app/combi/bap/utils/TrafficCounter 
.const [133] = Utf8 logChannel 
.const [134] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [135] = Utf8 de/audi/atip/log/LogChannel 
.const [136] = Utf8 log 
.const [137] = Utf8 (ILjava/lang/String;Ljava/lang/Object;)Z 
.const [138] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [139] = Utf8 append 
.const [140] = Utf8 (Ljava/lang/String;)Lde/esolutions/fw/util/commons/Buffer; 
.const [141] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [142] = Utf8 append 
.const [143] = Utf8 (J)Lde/esolutions/fw/util/commons/Buffer; 
.const [144] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [145] = Utf8 append 
.const [146] = Utf8 (I)Lde/esolutions/fw/util/commons/Buffer; 
.const [147] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [148] = Utf8 append 
.const [149] = Utf8 (F)Lde/esolutions/fw/util/commons/Buffer; 
.const [150] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [151] = Utf8 toString 
.const [152] = Utf8 ()Ljava/lang/String; 
.const [153] = Utf8 de/audi/app/combi/bap/utils/TrafficCounter 
.const [154] = Utf8 reset 
.const [155] = Utf8 ()V 
.const [156] = Utf8 de/audi/app/combi/bap/utils/TrafficCounter 
.const [157] = Utf8 measurementActive 
.const [158] = Utf8 Z 
.const [159] = Utf8 de/audi/app/combi/bap/utils/TrafficCounter 
.const [160] = Utf8 getCurrentStatisticsLog 
.const [161] = Utf8 ()Ljava/lang/String; 
.const [162] = Utf8 de/audi/atip/log/LogChannel 
.const [163] = Utf8 log 
.const [164] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [165] = Utf8 java/lang/Object 
.const [166] = Utf8 <init> 
.const [167] = Utf8 ()V 
.const [168] = Utf8 de/esolutions/fw/util/commons/Buffer 
.const [169] = Utf8 <init> 
.const [170] = Utf8 ()V 
.const [171] = Utf8 de/audi/app/combi/bap/utils/TrafficCounter 
.const [172] = Utf8 countBytesTransmitted 
.const [173] = Utf8 I 
.const [174] = Utf8 de/audi/app/combi/bap/utils/TrafficCounter 
.const [175] = Utf8 countRequests 
.const [176] = Utf8 I 
.const [177] = Utf8 de/audi/app/combi/bap/utils/TrafficCounter 
.const [178] = Utf8 timestampLastReset 
.const [179] = Utf8 J 
.const [180] = Utf8 de/audi/app/combi/bap/utils/TrafficCounter 
.const [181] = Utf8 name 
.const [182] = Utf8 Ljava/lang/String; 
.const [183] = Utf8 de/audi/app/combi/bap/utils/TrafficCounter 
.const [184] = Utf8 logChannel 
.const [185] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [186] = Utf8 de/audi/app/combi/bap/utils/TrafficCounter 
.const [187] = Utf8 measurementActive 
.const [188] = Utf8 Z 
.const [189] = Utf8 de/audi/app/combi/bap/utils/TrafficCounter 
.const [190] = Class [189] 
.const [191] = Utf8 java/lang/Object 
.const [192] = Class [191] 
.const [193] = Utf8 logChannel 
.const [194] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [195] = Utf8 countBytesTransmitted 
.const [196] = Utf8 I 
.const [197] = Utf8 countRequests 
.const [198] = Utf8 I 
.const [199] = Utf8 name 
.const [200] = Utf8 Ljava/lang/String; 
.const [201] = Utf8 timestampLastReset 
.const [202] = Utf8 J 
.const [203] = Utf8 measurementActive 
.const [204] = Utf8 Z 
.const [205] = Utf8 Code 
.const [206] = Utf8 <init> 
.const [207] = Utf8 (Ljava/lang/String;Lde/audi/atip/log/LogChannel;)V 
.const [208] = Utf8 notifyDataSubmitted 
.const [209] = Utf8 ([B)V 
.const [210] = Utf8 notifyDataSubmitted 
.const [211] = Utf8 (I)V 
.const [212] = Utf8 notifyRequestSubmitted 
.const [213] = Utf8 ()V 
.const [214] = Utf8 reset 
.const [215] = Utf8 ()V 
.const [216] = Utf8 getTransmittedBytes 
.const [217] = Utf8 ()I 
.const [218] = Utf8 getRequestCount 
.const [219] = Utf8 ()I 
.const [220] = Utf8 getCurrentStatisticsLog 
.const [221] = Utf8 ()Ljava/lang/String; 
.const [222] = Utf8 startMeasurement 
.const [223] = Utf8 (Ljava/lang/String;)V 
.const [224] = Utf8 stopMeasurement 
.const [225] = Utf8 (Ljava/lang/String;)V 
.const [226] = Utf8 isMeasurementActive 
.const [227] = Utf8 ()Z 
.end class 
