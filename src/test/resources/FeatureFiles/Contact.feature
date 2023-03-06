Feature: Contact Feature

  Scenario Outline: Contact with diffrent set of Data
    Given User is on Contact Page
    When User fills the details from given sheetname "<SheetName>" and rownumber <RowNumber>
    And User clicks on Submit button
    Then message will be displayed as "Thanks for contacting us! We will be in touch with you shortly."

  Examples: 
      | SheetName  | RowNumber | 
      | Contact    |     0     |
      | Contact    |     1     |
      | Contact    |     2     |
      | Contact    |     3     |
