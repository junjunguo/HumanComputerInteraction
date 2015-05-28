Design Principles
==

###Hvorfor guidelines?

-  Vi sorterer, organiserer, ordner...
-  Når vi har funnet en god regel, ønsker vi at andre skal bruke den
-  Spesifikke guidelines– løse problemer ved grensesnitt
-  Generelle – analysere og sammenligne ulike programmer
-  Teorier – kommunikasjon, forståelse av fenomener

- Navigering
- Organisering av skjerm 
- Lede oppmerksomheten 
- Forenkle datainnput

###Sjekklister for brukbarhet

-  Jacob Nielsen’s 10 punkts liste
	-  Shneiderman’s eight golden rules –  8 ”regler”
	-  Finnes på https://www.cs.umd.edu/users/ben/goldenrules.html
-  Bruce Tognazzini’s ”First Principles”
	-  19”prinsipper”/punkter
	-  Finnes på http://www.asktog.com/basics/firstPrinciples.html
-  Don Norman’s prinsipper fra ”Design of Everyday Things”


##Jacob Nielsen’s 10 punkter (heuristikker)

1.  Visibility of system status
2.  Match between system and the real world
3.  User control and freedom
4.  Consistency and standards
5.  Error prevention
6.  Recognition rather than recall
7.  Flexibility and efficiency of use
8.  Aesthetic and minimalist design
9.  Help users recognize, diagnose, and recover from errors
10. Help and documentation

###1. Visibility of system status

-  The system should always keep users informed about what is going on, through appropriate feedback within reasonable time.

-  Systemet skal all tid vise brukeren hva som foregår i maskinen, gjennom relevant tilbakemelding innen rimelig tid.


###2. Match between system and the real world

-  The system should speak the users'language,with words, phrases and concepts familiar to the user, rather than system-oriented terms.
-  Follow real-world conventions, making information appear in a natural and logical order.

-  Snakk brukerensspråk!
-  Brukbegreper,ord og framstillingsmåte som brukeren forstår.
-  Metaforer er et viktig virkemiddel.


###3. User control and freedom

-  Users often choose system functions by mistake and will need a clearly marked "emergency exit" to leave the unwanted state without having to go through an extended dialogue.
-  Support undo and redo.

-  La brukeren ha kontroll.
-  Implementer Angre på alle nivåer.

###4. Consistency and standards

-  Users should not have to wonder whether different words, situations, or actions mean the same thing.
-  Follow platform conventions. 

-  Konsistens i grensesnittet
-  Følg retningslinjene for den plattformen du bruker (WINDOWS, Web, Linux,...).

###5. Error prevention

-  Even better than good error messages is a careful design which prevents a problem from occurring in the first place.

-  Lag systemet slikat minst mulig feil er mulig.
-  Stikkord:Fleksibilitet

###6. Recognition rather than recall

-  Makeobjects,actions,andoptionsvisible.
-  The user should not have to remember information from one part of the dialogue to another.
-  Instructions for use of the system should be visible or easily retrievable whenever appropriate.

-  Kunnskapiverden,ikke i hodet!

###7. Flexibility and efficiency of use

-  Accelerators–unseen by the novice user–may often speed up the interaction for the expert user such that the system can cater to both inexperienced and experienced users.
-  Allow users to tailor frequent actions.
-  Gi avanserte brukere shortcuts og lignende.
-  Eksempler:
	- cmd + c (kopier i OS X)
	- ctrl + c (kopier i Windows)
	- Snarveier i f.eks. bilderedigeringsprogram

###8. Aesthetic and minimalist design

-  Dialog ues should not contain information which is irrelevant or rarely needed.
-  Every extra unit of information in a dialogue competes with the relevant units of information and diminishes their relative visibility.
-  Alt som ikke tjener en hensikt skal vekk!


###9. Error recovery

-  Help users recognize,diagnose,and recover from errors.
-  Error messages should be expressed in plain language (no codes), precisely indicate the problem, and constructively suggest a solution.
-  Hjelp brukeren i tilfelle feil.

###10. Help and documentation

-  Even though it is better if the system can be used without documentation, it may be necessary to provide help and documentation.
-  Any such information should be easy to search, focused on the user's task, list concrete steps to be carried out, and not be too large.
-  Lag et godt hjelpesystem. 
	–  Hurtigreferanse
	–  Brukermanual
-  How to’s, Tooltips, etc


##Bruce Tognazzinis ”First Principles“

-  Aesthetics
-  Anticipation
-  Autonomy
-  Color
-  Consistency
-  Defaults
-  Discoverability
-  Efficiency of the User
-  Explorable Interfaces
-  FiDs's Law
-  Human-Interface Objects
-  Latency Reduction
-  Learnability
-  Metaphors
-  Protect Users' Work
-  Readability
-  Simplicity
-  State: Track it
-  Visible Interfaces


##Norman’s prinsipper fra ”Design of Everyday Things”

-  Visibility
	- Kan jeg se det?
-  Feedback
	-  Hva skjer nå?
-  Affordance
	-  Hvordan kan jeg bruke det?
-  Mapping
	-  Hvor er jeg og hvor kan jeg gå?
-  Constraints
	-  Hvor for kan jeg ikke gjøre slik?
-  Consistency
	-  Har jeg ikke sett dette før?


#Conceptual Models:
###Begin by Designing What to Design
- <￼JEFF JOHNSON AND AUSTIN HENDERSON - design >

**Good user interfaces start with clean, simple, task-oriented conceptual models.**

**The conceptual model is the bones of the design.**

####A conceptual model is a high-level description of how a system is organized and operates.

#####A conceptual model of an interactive system is:
- an **idealized view** of the how the system works—the model designers hope users will internalize;
- the **ontological structure** of the system: the objects, their relationships, and control structures;
- the **mechanism** by which users accomplish the tasks the system is intended to support.

#####Simple: 
- A conceptual model should be as simple as possible while providing the required functionality. 
- An important guideline for designing a conceptual model is: "Less is more."

#####What a Conceptual Model Is Not:
- The conceptual model of an interactive system is not the user interface.
- The conceptual model is not the users' mental model of the system.
- The conceptual models are not use cases (also known as task-level scenarios).

#####
- User-interface. 
	- A conceptual model gives the designer a clear target for what the inter- face has to deliver to the user


[HCI](HCI.md)
==

Psychology
==

###Gestalt psychology or gestaltism
- This principle maintains that when the human mind (perceptual system) forms a percept or gestalt, the whole has a reality of its own, independent of the parts. 
- 格式塔学派主张人脑的运作原理是整体的，“整体不同于其部件的总和”。例如，我们对一朵花的感知，并非纯粹单单从对花的形状、颜色、大小等感官资讯而来，还包括我们对花过去的经验和印象，加起来才是我们对一朵花的感知.

#
==
###System Usability Scale
In systems engineering, the system usability scale (SUS) is a simple, ten-item attitude Likert scale giving a global view of subjective assessments of usability. It was developed by John Brooke.

###Likert scale
is a psychometric scale commonly involved in research that employs questionnaires. It is the most widely used approach to scaling responses in survey research, such that the term is often used interchangeably with rating scale, or more accurately the Likert-type scale, even though the two are not synonymous. The scale is named after its inventor, psychologist Rensis Likert.

![example: Likert Scale](https://upload.wikimedia.org/wikipedia/commons/c/cc/Example_Likert_Scale.svg)

