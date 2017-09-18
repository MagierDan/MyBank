Feature: As a bank client, in order to save money, I want to make a deposit in my account

  Scenario Outline: Making a deposit of 200€ the 17/06/2017 on a bank account having a balance of 300€ since the 15/06/2017
    Given an account opened the <openingDate> with a deposit of <initialDeposit>€
    When the customer make a deposit of <depositAmount>€ the <depositDate>
    Then the customer's bank account balance is <accountBalance>€

  Examples:
    |openingDate  |initialDeposit |depositAmount|depositDate  |accountBalance |
    |"01/06/2017" |0              |100          |"03/06/2017" |100            |
    |"15/06/2017" |300            |200          |"18/06/2017" |500            |