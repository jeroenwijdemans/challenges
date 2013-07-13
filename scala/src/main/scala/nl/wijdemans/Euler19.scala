package nl.wijdemans

/**
 *
You are given the following information, but you may prefer to do some research for yourself.

    1 Jan 1900 was a Monday.
    Thirty days has September,
    April, June and November.
    All the rest have thirty-one,
    Saving February alone,
    Which has twenty-eight, rain or shine.
    And on leap years, twenty-nine.
    A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.

How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 */
object Euler19 {
  def main(args: Array[String]) {

    assert(isSunday(0) == false)
    assert(isSunday(1) == false)
    assert(isSunday(2) == false)
    assert(isSunday(3) == false)
    assert(isSunday(4) == false)
    assert(isSunday(5) == false)
    assert(isSunday(6) == true)
    assert(isSunday(7) == false)

    assert(isSunday(13) == true)
    assert(isSunday(14) == false)

    assert(isSunday(19) == false)
    assert(isSunday(20) == true)
    assert(isSunday(21) == false)

    assert(isLeapYear(1900) == false)
    assert(isLeapYear(1901) == false)
    assert(isLeapYear(1904) == true)
    assert(isLeapYear(2000) == true)
    assert(isLeapYear(1999) == false)
    assert(isLeapYear(1996) == true)

    val m = Map(
      0 -> 31,
      1 -> 28,
      2 -> 31,
      3 -> 30,
      4 -> 31,
      5 -> 30,
      6 -> 31,
      7 -> 31,
      8 -> 30,
      9 -> 31,
      10 -> 30,
      11 -> 31
    )

    var dayCounter = 0

    var currentMonth: Int = 0
    var currentDay: Int = 0
    var currentYear: Int = 1900
    var anotherSunday = 0
    var anotherLeapYear = 0
    var leapYear = false
    do {

      if (currentDay == 0 && isSunday(dayCounter) && currentYear >=(1901)) {
        anotherSunday += 1
      }

      // go to next day
      dayCounter += 1
      currentDay += 1

      if (currentDay > 27) {
        if (m(currentMonth) == 31 && currentDay > 30) {
          currentDay = 0
          currentMonth += 1
        }
        else if (m(currentMonth) == 30 && currentDay > 29) {
          currentDay = 0
          currentMonth += 1
        }
        else if (m(currentMonth) == 28) {
          if (leapYear && currentDay > 27) {
            currentDay = 0
            currentMonth += 1
          }
          else if (!leapYear && currentDay > 26) {
            currentDay = 0
            currentMonth += 1
          }
        }
      }

      if (currentMonth > 11) {
        currentMonth = 0
        currentYear += 1
        leapYear = isLeapYear(currentYear)
        if (leapYear) anotherLeapYear += 1
        print(".")
      }

    } while (!(currentYear == 2000  && currentMonth == 11 && currentDay == 30))

    println("")
    println("Amount of leap years " + anotherLeapYear)
    println("Starting sunday's : " + anotherSunday + " of a total of '" + dayCounter + "' days.")
    assert(anotherSunday == 172)
  }

  def isLeapYear(year: Int): Boolean = {
    if (year % 4 == 0) {
      if (year % 100 == 0 && year % 400 != 0) {
        return false
      }
      return true
    }
    return false
  }

  def isSunday(dayCounter: Int): Boolean = {
    dayCounter % 7 == 6
  }
}