JavaFX
==

[JavaFX overview](http://docs.oracle.com/javase/8/javafx/get-started-tutorial/jfx-overview.htm#JFXST784)

kjøring oppstart av programmer
--
JavaFX har en egen programklasse kalt Application(i pakken javafx.application) som en må arve fra.
- Denne definerer en del metoder som kallers når programmet initialiseres (init), starter (start) opp og stopper (stop). 
- Av disse er det bare start-metoden som må defineres i din egen hovedprogamklasse.
- merk at det ikke er min egen kode som oppretter instansen av hovedprogramklassen og kaller disse oppstartsmetodene, det er det rammeverket selv som gjør.
- Og for at det skal skje må du i main-metoden kalle den statiske metoden launch i Application-klassen med navnet til din egen klasse som første argument og programargumentene til min main-metode som launch-metoden sitt andre argument.

