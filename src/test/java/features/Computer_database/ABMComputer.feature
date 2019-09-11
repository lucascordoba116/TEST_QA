Feature: ABM Computer
  Scenario Outline: Add new computer correctly
    Given a user who is on the Computers database page
    When you press the Add a new computer button
    Then title and loading form is displayed
    When you enter "<computer_name>","<introducedDate>","<discontiuedDate>" and "<company>"
    And press button Create this computer
    Then a computer "<computer_name>" creation success message is displayed


    Examples:
    |computer_name|introducedDate|discontiuedDate|company|
    |    RV410V    |   2019-01-01    |  2019-09-5    |  RCA  |
    |    RV420V    |   2019-01-01    |               |  Sony |
    |    RV430V    |   2019-01-01    |               |  Nokia|

  Scenario: Modify a computer successfully
    Given a user who is on the home page computer
    When looking for RV420V computer
    Then it shows that only one result was found
    When you select the computer
    Then the computer edit page opens
    When you enter the discontinuation date and click Save
    Then the update exist message is displayed

  Scenario Outline: Delete a computer correctly
    Given a user who is on the home page
    When looking for "<name_computer>" computer
    Then it shows that one result was found
    When you select the computer "<name_computer>"
    Then the computer edit page open
    When you press the Delete button
    Then the message that the computer was deleted is displayed
    Examples:
      |name_computer|
      |   RV410V    |
      |   RV420V    |
      |   RV430V    |


