Green Appointment
==

Building tools:

JavaFX, FXML, CSS and JavaFX Scene Builder


IDE:

IntelliJ


[Download application: GreenAppointment.jar](http://junjunguo.com/data/greenAppointment/GreenAppointment.jar)


Screenshot
--

green theme design.

![Green Appointment](GreenAppointment.png)

fade in and out animate validation messages!
- attract attentions for the invalid inputs.

![Green Appointment](GreenAppointment1.png)

validate messages shows at the wrong input place!
- easy to find out and edit the input error.
- show input format if the format is not right

![Green Appointment](GreenAppointment2.png)

drop-down calendar
- avoid input errors.

![Green Appointment](GreenAppointment3.png)

Simple repeat method

![Green Appointment](GreenAppointment4.png)

consistent menu, color, font color, font size and font family design

![Green Appointment](GreenAppointment5.png)

Simple event overview

![Green Appointment](GreenAppointment6.png)

consistent hover over design

![Green Appointment](GreenAppointment7.png)

design Prototype
--
![Green Appointment](designprototype.png)


Other Information
--
use [Paletton Color Scheme Designer](http://paletton.com/#uid=12D0u0kllll6mNydQtLsQcVHZ4v)

- to design colors.

![Green Appointment](colordesign.png)


Class Diagram:

![](classdiagram.png)


File Handling
--

Use Json to read and write:
- easier to handling file than use java 'ObjectInputStream' and 'ObjectOutputStream';
- human readable text to transmit data objects (alternative to XML)
- light weight format for data interchanging
- easy to transfer data to other programming languages
- advantages to transmit data between server and web applications.

```Json

  {
    "formal": "Edit worked !",
    "rom": "aaa-aaa aa1",
    "dato": {
      "year": 2015,
      "month": "FEBRUARY",
      "monthValue": 2,
      "dayOfMonth": 1,
      "dayOfWeek": "SUNDAY",
      "era": "CE",
      "dayOfYear": 32,
      "leapYear": false,
      "chronology": {
        "id": "ISO",
        "calendarType": "iso8601"
      }
    },
    "fra": {
      "hour": 12,
      "minute": 34,
      "second": 0,
      "nano": 0
    },
    "til": {
      "hour": 23,
      "minute": 45,
      "second": 0,
      "nano": 0
    },
    "repetisjon": 2,
    "slutt": {
      "year": 2015,
      "month": "FEBRUARY",
      "monthValue": 2,
      "dayOfMonth": 3,
      "dayOfWeek": "TUESDAY",
      "era": "CE",
      "dayOfYear": 34,
      "leapYear": false,
      "chronology": {
        "id": "ISO",
        "calendarType": "iso8601"
      }
    }
  }

```
