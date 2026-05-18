package com.example.myapplication

data class Emergency(
    val title: String,
    val titleKn: String,
    val steps: List<String>,
    val stepsKn: List<String>,
    val dos: List<String>,
    val dosKn: List<String>,
    val donts: List<String>,
    val dontsKn: List<String>
)

val emergencyList = listOf(
    Emergency(
        title = "Snake Bite",
        titleKn = "ಹಾವಿನ ಕಡಿತ",
        steps = listOf(
            "Keep the victim calm",
            "Do not move the affected area",git --version
            "Remove tight clothing",
            "Take patient to hospital immediately",
            "Cover the bite gently",
            "Stay calm dont panic"
        ),
        stepsKn = listOf(
            "ಗಾಯಾಳುವನ್ನು ಶಾಂತವಾಗಿರಿಸಿ",
            "ಕಚ್ಚಿದ ಭಾಗವನ್ನು ಅಲುಗಾಡಿಸಬೇಡಿ",
            "ಬಿಗಿಯಾದ ಬಟ್ಟೆಗಳನ್ನು ಸಡಿಲಗೊಳಿಸಿ",
            "ತಕ್ಷಣ ಆಸ್ಪತ್ರೆಗೆ ಕರೆದೊಯ್ಯಿರಿ",
            "ಗಾಯವನ್ನು ಮೃದುವಾಗಿ ಮುಚ್ಚಿ",
            "ಗಾಬರಿಯಾಗಬೇಡಿ"
        ),
        dos = listOf(
            "Call emergency services",
            "Keep victim still",
            "immobilize the bitten area",
            "Remove tight items"
        ),
        dosKn = listOf(
            "ತುರ್ತು ಸೇವೆಗೆ ಕರೆ ಮಾಡಿ",
            "ಗಾಯಾಳುವನ್ನು ಅಲುಗಾಡದಂತೆ ನೋಡಿ",
            "ಕಚ್ಚಿದ ಭಾಗವನ್ನು ಸ್ಥಿರವಾಗಿರಿಸಿ",
            "ಬಿಗಿಯಾದ ವಸ್ತುಗಳನ್ನು ತೆಗೆಯಿರಿ"
        ),
        donts = listOf(
            "Do not suck venom",
            "Do not cut the wound",
            "Do not apply ice",
            "Do not give alcohol or food"
        ),
        dontsKn = listOf(
            "ವಿಷವನ್ನು ಹೀರುವ ಪ್ರಯತ್ನ ಮಾಡಬೇಡಿ",
            "ಗಾಯವನ್ನು ಕುಯ್ಯಬೇಡಿ",
            "ಐಸ್ ಹಚ್ಚಬೇಡಿ",
            "ಮದ್ಯ ಅಥವಾ ಆಹಾರ ನೀಡಬೇಡಿ"
        )
    ),
    Emergency(
        title = "Burn",
        titleKn = "ಸುಟ್ಟ ಗಾಯ",
        steps = listOf(
            "Cool under running water",
            "Cover with clean cloth",
            "Seek medical help if severe",
            "Remove tight items"
        ),
        stepsKn = listOf(
            "ತಣ್ಣನೆಯ ನೀರಿನಲ್ಲಿ ಗಾಯವನ್ನು ತೊಳೆಯಿರಿ",
            "ಸ್ವಚ್ಛವಾದ ಬಟ್ಟೆಯಿಂದ ಮುಚ್ಚಿ",
            "ಗಂಭೀರವಾಗಿದ್ದರೆ ವೈದ್ಯರ ನೆರವು ಪಡೆಯಿರಿ",
            "ಬಿಗಿಯಾದ ವಸ್ತುಗಳನ್ನು ತೆಗೆಯಿರಿ"
        ),
        dos = listOf(
            "Use cool water",
            "Keep burn clean"
        ),
        dosKn = listOf(
            "ತಣ್ಣೀರು ಬಳಸಿ",
            "ಗಾಯವನ್ನು ಸ್ವಚ್ಛವಾಗಿಡಿ"
        ),
        donts = listOf(
            "Do not apply toothpaste",
            "Do not burst blisters",
            "Do not apply ice directly"
        ),
        dontsKn = listOf(
            "ಟೂತ್ ಪೇಸ್ಟ್ ಹಚ್ಚಬೇಡಿ",
            "ಗುಳ್ಳೆಗಳನ್ನು ಒಡೆಯಬೇಡಿ",
            "ಐಸ್ ನೇರವಾಗಿ ಹಚ್ಚಬೇಡಿ"
        )
    ),
    Emergency(
        title = "Accident",
        titleKn = "ಅಪಘಾತ",
        steps = listOf(
            "Check breathing",
            "Call ambulance",
            "Control bleeding"
        ),
        stepsKn = listOf(
            "ಉಸಿರಾಟವನ್ನು ಪರಿಶೀಲಿಸಿ",
            "ಅಂಬ್ಯುಲೆನ್ಸ್ ಕರೆ ಮಾಡಿ",
            "ರಕ್ತಸ್ರಾವವನ್ನು ನಿಯಂತ್ರಿಸಿ"
        ),
        dos = listOf("Stay calm", "Keep victim safe"),
        dosKn = listOf("ಶಾಂತವಾಗಿರಿ", "ಗಾಯಾಳುವನ್ನು ಸುರಕ್ಷಿತವಾಗಿರಿಸಿ"),
        donts = listOf("Do not panic", "Do not move victim unnecessarily"),
        dontsKn = listOf("ಗಾಬರಿಯಾಗಬೇಡಿ", "ಅಗತ್ಯವಿಲ್ಲದೆ ಗಾಯಾಳುವನ್ನು ಅಲುಗಾಡಿಸಬೇಡಿ")
    ),
    Emergency(
        title = "Fracture",
        titleKn = "ಮೂಳೆ ಮುರಿತ",
        steps = listOf(
            "Keep injured area still",
            "Apply support",
            "Use ice pack"
        ),
        stepsKn = listOf(
            "ಪೆಟ್ಟಾದ ಜಾಗವನ್ನು ಅಲುಗಾಡಿಸಬೇಡಿ",
            "ಆಧಾರ ನೀಡಿ",
            "ಐಸ್ ಪ್ಯಾಕ್ ಬಳಸಿ"
        ),
        dos = listOf("Support injured limb"),
        dosKn = listOf("ಪೆಟ್ಟಾದ ಭಾಗಕ್ಕೆ ಆಧಾರ ನೀಡಿ"),
        donts = listOf("Do not massage injury", "Do not try to straighten bone"),
        dontsKn = listOf("ಮಸಾಜ್ ಮಾಡಬೇಡಿ", "ಮೂಳೆಯನ್ನು ನೇರಗೊಳಿಸಲು ಪ್ರಯತ್ನಿಸಬೇಡಿ")
    ),
    Emergency(
        title = "Heart Attack",
        titleKn = "ಹೃದಯಾಘಾತ",
        steps = listOf(
            "Call emergency services",
            "Help person sit",
            "Loosen tight clothes"
        ),
        stepsKn = listOf(
            "ತುರ್ತು ಸೇವೆಗೆ ಕರೆ ಮಾಡಿ",
            "ಗಾಯಾಳುವನ್ನು ಕುಳಿತುಕೊಳ್ಳಲು ಸಹಾಯ ಮಾಡಿ",
            "ಬಟ್ಟೆಯನ್ನು ಸಡಿಲಗೊಳಿಸಿ"
        ),
        dos = listOf("Keep them calm", "Monitor breathing"),
        dosKn = listOf("ಶಾಂತವಾಗಿರುವಂತೆ ನೋಡಿ", "ಉಸಿರಾಟ ಗಮನಿಸಿ"),
        donts = listOf("Do not ignore chest pain", "Do not let person exert"),
        dontsKn = listOf("ಎದೆನೋವನ್ನು ನಿರ್ಲಕ್ಷಿಸಬೇಡಿ", "ಗಾಯಾಳು ಶ್ರಮಪಡುವಂತೆ ಮಾಡಬೇಡಿ")
    ),
    Emergency(
        title = "Choking",
        titleKn = "ಗಂಟಲಲ್ಲಿ ಸಿಲುಕಿಕೊಳ್ಳುವುದು",
        steps = listOf(
            "Encourage coughing",
            "Give back blows",
            "Perform Heimlich maneuver"
        ),
        stepsKn = listOf(
            "ಕೆಮ್ಮಲು ಹೇಳಿ",
            "ಬೆನ್ನಿನ ಮೇಲೆ ತಟ್ಟಿ",
            "ಹೈಮ್ಲಿಕ್ ತಂತ್ರ ಅನುಸರಿಸಿ"
        ),
        dos = listOf("Act quickly"),
        dosKn = listOf("ತಕ್ಷಣ ಕಾರ್ಯಪ್ರವೃತ್ತರಾಗಿ"),
        donts = listOf("Do not give water immediately"),
        dontsKn = listOf("ತಕ್ಷಣ ನೀರು ನೀಡಬೇಡಿ")
    ),
    Emergency(
        title = "Electric Shock",
        titleKn = "ವಿದ್ಯುತ್ ಆಘಾತ",
        steps = listOf(
            "Turn off power source",
            "Use dry object",
            "Call emergency help"
        ),
        stepsKn = listOf(
            "ವಿದ್ಯುತ್ ಮೂಲವನ್ನು ಆಫ್ ಮಾಡಿ",
            "ಒಣಗಿದ ವಸ್ತುವಿನಿಂದ ಬೇರ್ಪಡಿಸಿ",
            "ತುರ್ತು ಸಹಾಯ ಪಡೆಯಿರಿ"
        ),
        dos = listOf("Check breathing"),
        dosKn = listOf("ಉಸಿರಾಟ ಪರೀಕ್ಷಿಸಿ"),
        donts = listOf("Do not touch directly", "Do not use water"),
        dontsKn = listOf("ನೇರವಾಗಿ ಮುಟ್ಟಬೇಡಿ", "ನೀರನ್ನು ಬಳಸಬೇಡಿ")
    ),
    Emergency(
        title = "Asthma Attack",
        titleKn = "ಆಸ್ತಮಾ ದಾಳಿ",
        steps = listOf(
            "Sit the person upright",
            "Help them use their inhaler",
            "Keep them calm and comfortable",
            "Seek medical help if breathing doesn't improve"
        ),
        stepsKn = listOf(
            "ಗಾಯಾಳುವನ್ನು ನೇರವಾಗಿ ಕುಳಿತುಕೊಳ್ಳಲು ಹೇಳಿ",
            "ಇನ್ಹೇಲರ್ ಬಳಸಲು ಸಹಾಯ ಮಾಡಿ",
            "ಶಾಂತವಾಗಿರುವಂತೆ ನೋಡಿಕೊಳ್ಳಿ",
            "ಉಸಿರಾಟ ಸುಧಾರಿಸದಿದ್ದರೆ ವೈದ್ಯಕೀಯ ಸಹಾಯ ಪಡೆಯಿರಿ"
        ),
        dos = listOf("Help them use inhaler", "Loosen tight clothing"),
        dosKn = listOf("ಇನ್ಹೇಲರ್ ಬಳಸಲು ಸಹಾಯ ಮಾಡಿ", "ಬಿಗಿಯಾದ ಬಟ್ಟೆಯನ್ನು ಸಡಿಲಗೊಳಿಸಿ"),
        donts = listOf("Do not let them lie down", "Do not panic"),
        dontsKn = listOf("ಮಲಗಲು ಬಿಡಬೇಡಿ", "ಗಾಬರಿಯಾಗಬೇಡಿ")
    ),
    Emergency(
        title = "Diabetic Emergency",
        titleKn = "ಮಧುಮೇಹ ತುರ್ತುಸ್ಥಿತಿ",
        steps = listOf(
            "Check if the person is conscious",
            "Give sugar or glucose if they are conscious",
            "Wait for 10-15 minutes",
            "Seek medical help if they don't improve or are unconscious"
        ),
        stepsKn = listOf(
            "ಗಾಯಾಳು ಪ್ರಜ್ಞಾವಸ್ಥೆಯಲ್ಲಿದ್ದಾರೆಯೇ ಎಂದು ಪರೀಕ್ಷಿಸಿ",
            "ಪ್ರಜ್ಞೆ ಇದ್ದರೆ ಸಕ್ಕರೆ ಅಥವಾ ಗ್ಲೂಕೋಸ್ ನೀಡಿ",
            "10-15 ನಿಮಿಷಗಳ ಕಾಲ ಕಾಯಿರಿ",
            "ಸುಧಾರಿಸದಿದ್ದರೆ ಅಥವಾ ಪ್ರಜ್ಞೆ ಇಲ್ಲದಿದ್ದರೆ ವೈದ್ಯಕೀಯ ಸಹಾಯ ಪಡೆಯಿರಿ"
        ),
        dos = listOf("Give something sweet", "Monitor awareness"),
        dosKn = listOf("ಸಿಹಿ ಪದಾರ್ಥ ನೀಡಿ", "ಪ್ರಜ್ಞೆಯನ್ನು ಗಮನಿಸಿ"),
        donts = listOf("Do not give insulin", "Do not give food if unconscious"),
        dontsKn = listOf("ಇನ್ಸುಲಿನ್ ನೀಡಬೇಡಿ", "ಪ್ರಜ್ಞೆ ಇಲ್ಲದಿದ್ದರೆ ಏನನ್ನೂ ನೀಡಬೇಡಿ")
    ),
    Emergency(
        title = "Eye Injury",
        titleKn = "ಕಣ್ಣಿನ ಗಾಯ",
        steps = listOf(
            "Do not rub the affected eye",
            "Flush with clean water gently",
            "Cover loosely with a clean pad",
            "Seek immediate medical attention"
        ),
        stepsKn = listOf(
            "ಕಣ್ಣನ್ನು ಉಜ್ಜಬೇಡಿ",
            "ಸ್ವಚ್ಛವಾದ ನೀರಿನಿಂದ ನಿಧಾನವಾಗಿ ತೊಳೆಯಿರಿ",
            "ಸ್ವಚ್ಛವಾದ ಬಟ್ಟೆಯಿಂದ ಸಡಿಲವಾಗಿ ಮುಚ್ಚಿ",
            "ಕೂಡಲೇ ವೈದ್ಯರ ಬಳಿ ಕರೆದೊಯ್ಯಿರಿ"
        ),
        dos = listOf("Use clean water", "Keep eye closed"),
        dosKn = listOf("ಸ್ವಚ್ಛವಾದ ನೀರು ಬಳಸಿ", "ಕಣ್ಣನ್ನು ಮುಚ್ಚಿಡಿ"),
        donts = listOf("Do not remove stuck objects", "Do not apply pressure"),
        dontsKn = listOf("ಸಿಕ್ಕಿಕೊಂಡ ವಸ್ತುವನ್ನು ತೆಗೆಯಬೇಡಿ", "ಒತ್ತಡ ಹಾಕಬೇಡಿ")
    ),
    Emergency(
        title = "Nosebleed",
        titleKn = "ಮೂಗಿನಿಂದ ರಕ್ತಸ್ರಾವ",
        steps = listOf(
            "Sit upright and lean forward slightly",
            "Pinch the soft part of the nose for 10 minutes",
            "Breathe through the mouth",
            "Apply a cold pack to the bridge of the nose"
        ),
        stepsKn = listOf(
            "ನೇರವಾಗಿ ಕುಳಿತು ಸ್ವಲ್ಪ ಮುಂದಕ್ಕೆ ಬಾಗಿ",
            "ಮೂಗಿನ ಮೆದುವಾದ ಭಾಗವನ್ನು 10 ನಿಮಿಷಗಳ ಕಾಲ ಒತ್ತಿ ಹಿಡಿಯಿರಿ",
            "ಬಾಯಿಯ ಮೂಲಕ ಉಸಿರಾಡಿ",
            "ಮೂಗಿನ ಮೇಲೆ ಐಸ್ ಪ್ಯಾಕ್ ಇರಿಸಿ"
        ),
        dos = listOf("Lean forward", "Apply ice pack"),
        dosKn = listOf("ಮುಂದಕ್ಕೆ ಬಾಗಿ", "ಐಸ್ ಪ್ಯಾಕ್ ಬಳಸಿ"),
        donts = listOf("Do not tilt head back", "Do not blow the nose"),
        dontsKn = listOf("ತಲೆಯನ್ನು ಹಿಂದಕ್ಕೆ ಬಗ್ಗಿಸಬೇಡಿ", "ಮೂಗನ್ನು ಉದಬೇಡಿ")
    ),
    Emergency(
        title = "Stroke",
        titleKn = "ಪಾರ್ಶ್ವವಾಯು",
        steps = listOf(
            "Think F.A.S.T (Face, Arms, Speech, Time)",
            "Call for an ambulance immediately",
            "Keep the person stable and calm",
            "Note the time symptoms started"
        ),
        stepsKn = listOf(
            "F.A.S.T ತಂತ್ರ ನೆನಪಿಡಿ (ಮುಖ, ಕೈಗಳು, ಮಾತು, ಸಮಯ)",
            "ಕೂಡಲೇ ಅಂಬ್ಯುಲೆನ್ಸ್ ಕರೆ ಮಾಡಿ",
            "ಗಾಯಾಳುವನ್ನು ಸ್ಥಿರವಾಗಿ ಮತ್ತು ಶಾಂತವಾಗಿರಿಸಿ",
            "ಲಕ್ಷಣಗಳು ಪ್ರಾರಂಭವಾದ ಸಮಯವನ್ನು ಗಮನಿಸಿ"
        ),
        dos = listOf("Note symptom start time", "Keep them calm"),
        dosKn = listOf("ಸಮಯವನ್ನು ಗಮನಿಸಿ", "ಶಾಂತವಾಗಿರಿಸಿ"),
        donts = listOf("Do not give food or water", "Do not wait for it to pass"),
        dontsKn = listOf("ಆಹಾರ ಅಥವಾ ನೀರು ನೀಡಬೇಡಿ", "ತಾನಾಗಿಯೇ ವಾಸಿಯಾಗುತ್ತದೆ ಎಂದು ಕಾಯಬೇಡಿ")
    )
)
