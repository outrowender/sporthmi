.version 50 0 
.class public super [102] 
.super [104] 
.implements [106] 
.field private final [107] [108] 
.field private final [109] [110] 
.field private final [111] [112] 

.method public [114] : [115] 
    .attribute [113] .code stack 2 locals 0 
L0:     aload_0 
L1:     invokespecial [19] 
L4:     aload_0 
L5:     aload_3 
L6:     putfield [20] 
L9:     aload_0 
L10:    aload_2 
L11:    putfield [21] 
L14:    aload_0 
L15:    aload_1 
L16:    putfield [22] 
L19:    return 
L20:    
    .end code 
.end method 

.method public [116] : [117] 
    .attribute [113] .code stack 2 locals 0 
L0:     aload_2 
L1:     instanceof [2] 
L4:     ifeq L26 
L7:     aload_0 
L8:     getfield [15] 
L11:    aconst_null 
L12:    invokevirtual [16] 
L15:    aload_0 
L16:    getfield [13] 
L19:    aload_1 
L20:    invokeinterface [23] 0 
L25:    pop 
L26:    return 
L27:    nop 
L28:    
    .end code 
.end method 

.method public enum [118] : [119] 
    .attribute [113] .code stack 0 locals 0 
L0:     return 
L1:     nop 
L2:     nop 
L3:     nop 
L4:     
    .end code 
.end method 

.method public [120] : [121] 
    .attribute [113] .code stack 5 locals 2 
L0:     aload_0 
L1:     getfield [13] 
L4:     aload_1 
L5:     invokeinterface [24] 0 
L10:    astore_2 
L11:    aload_1 
L12:    ldc [3] 
L14:    invokeinterface [25] 0 
L19:    astore_3 
L20:    aload_0 
L21:    getfield [14] 
L24:    ldc [4] 
L26:    ldc [5] 
L28:    aload_3 
L29:    aload_2 
L30:    invokevirtual [17] 
L33:    aload_2 
L34:    instanceof [2] 
L37:    ifeq L66 
L40:    aload_3 
L41:    ifnull L66 
L44:    aload_3 
L45:    ldc [6] 
L47:    invokevirtual [18] 
L50:    ifeq L66 
L53:    aload_0 
L54:    getfield [15] 
L57:    aload_2 
L58:    checkcast [2] 
L61:    invokevirtual [16] 
L64:    aload_2 
L65:    areturn 
L66:    aload_0 
L67:    getfield [13] 
L70:    aload_1 
L71:    invokeinterface [23] 0 
L76:    pop 
L77:    aconst_null 
L78:    areturn 
L79:    nop 
L80:    
    .end code 
.end method 
.const [1] = Int 0 
.const [2] = Class [26] 
.const [3] = String [27] 
.const [4] = Int -2137614336 
.const [5] = String [28] 
.const [6] = String [29] 
.const [7] = Class [30] 
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
.const [20] = Field [50] [51] 
.const [21] = Field [52] [53] 
.const [22] = Field [54] [55] 
.const [23] = InterfaceMethod [56] [57] 
.const [24] = InterfaceMethod [58] [59] 
.const [25] = InterfaceMethod [60] [61] 
.const [26] = Utf8 de/audi/atip/interapp/online/IOnlineService 
.const [27] = Utf8 ONLINE_APP_ID 
.const [28] = Utf8 'TrafficLightOnlineServiceTrackerCustomizer#addingService: got property %1 for service %2' 
.const [29] = Utf8 service_trafficlight 
.const [30] = Utf8 de/audi/app/online/evo/trafficlight/TrafficLightOnlineServiceTrackerCustomizer 
.const [31] = Utf8 java/lang/Object 
.const [32] = Utf8 de/audi/app/online/evo/trafficlight/TrafficLightOnlineHandler 
.const [33] = Utf8 org/osgi/framework/BundleContext 
.const [34] = Utf8 org/osgi/framework/ServiceReference 
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
.const [56] = Class [92] 
.const [57] = NameAndType [93] [94] 
.const [58] = Class [95] 
.const [59] = NameAndType [96] [97] 
.const [60] = Class [98] 
.const [61] = NameAndType [99] [100] 
.const [62] = Utf8 de/audi/app/online/evo/trafficlight/TrafficLightOnlineServiceTrackerCustomizer 
.const [63] = Utf8 context 
.const [64] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [65] = Utf8 de/audi/app/online/evo/trafficlight/TrafficLightOnlineServiceTrackerCustomizer 
.const [66] = Utf8 logChannel 
.const [67] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [68] = Utf8 de/audi/app/online/evo/trafficlight/TrafficLightOnlineServiceTrackerCustomizer 
.const [69] = Utf8 trafficLightOnlineHandler 
.const [70] = Utf8 Lde/audi/app/online/evo/trafficlight/TrafficLightOnlineHandler; 
.const [71] = Utf8 de/audi/app/online/evo/trafficlight/TrafficLightOnlineHandler 
.const [72] = Utf8 setOnlineService 
.const [73] = Utf8 (Lde/audi/atip/interapp/online/IOnlineService;)V 
.const [74] = Utf8 de/audi/atip/log/LogChannel 
.const [75] = Utf8 log 
.const [76] = Utf8 (ILjava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V 
.const [77] = Utf8 java/lang/Object 
.const [78] = Utf8 equals 
.const [79] = Utf8 (Ljava/lang/Object;)Z 
.const [80] = Utf8 java/lang/Object 
.const [81] = Utf8 <init> 
.const [82] = Utf8 ()V 
.const [83] = Utf8 de/audi/app/online/evo/trafficlight/TrafficLightOnlineServiceTrackerCustomizer 
.const [84] = Utf8 context 
.const [85] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [86] = Utf8 de/audi/app/online/evo/trafficlight/TrafficLightOnlineServiceTrackerCustomizer 
.const [87] = Utf8 logChannel 
.const [88] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [89] = Utf8 de/audi/app/online/evo/trafficlight/TrafficLightOnlineServiceTrackerCustomizer 
.const [90] = Utf8 trafficLightOnlineHandler 
.const [91] = Utf8 Lde/audi/app/online/evo/trafficlight/TrafficLightOnlineHandler; 
.const [92] = Utf8 org/osgi/framework/BundleContext 
.const [93] = Utf8 ungetService 
.const [94] = Utf8 (Lorg/osgi/framework/ServiceReference;)Z 
.const [95] = Utf8 org/osgi/framework/BundleContext 
.const [96] = Utf8 getService 
.const [97] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.const [98] = Utf8 org/osgi/framework/ServiceReference 
.const [99] = Utf8 getProperty 
.const [100] = Utf8 (Ljava/lang/String;)Ljava/lang/Object; 
.const [101] = Utf8 de/audi/app/online/evo/trafficlight/TrafficLightOnlineServiceTrackerCustomizer 
.const [102] = Class [101] 
.const [103] = Utf8 java/lang/Object 
.const [104] = Class [103] 
.const [105] = Utf8 org/osgi/util/tracker/ServiceTrackerCustomizer 
.const [106] = Class [105] 
.const [107] = Utf8 trafficLightOnlineHandler 
.const [108] = Utf8 Lde/audi/app/online/evo/trafficlight/TrafficLightOnlineHandler; 
.const [109] = Utf8 context 
.const [110] = Utf8 Lorg/osgi/framework/BundleContext; 
.const [111] = Utf8 logChannel 
.const [112] = Utf8 Lde/audi/atip/log/LogChannel; 
.const [113] = Utf8 Code 
.const [114] = Utf8 <init> 
.const [115] = Utf8 (Lde/audi/app/online/evo/trafficlight/TrafficLightOnlineHandler;Lde/audi/atip/log/LogChannel;Lorg/osgi/framework/BundleContext;)V 
.const [116] = Utf8 removedService 
.const [117] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [118] = Utf8 modifiedService 
.const [119] = Utf8 (Lorg/osgi/framework/ServiceReference;Ljava/lang/Object;)V 
.const [120] = Utf8 addingService 
.const [121] = Utf8 (Lorg/osgi/framework/ServiceReference;)Ljava/lang/Object; 
.end class 
