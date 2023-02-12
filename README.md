# Guru99-Bank-Project
Selenium automation live project

## Day 1: Project Kickoff

Hi Fellow Tester, 
You are the Selenium automation engineer assigned to test the esteemed "Guru99 Bank" project.
Here is a link to the AUT - [Guru99 Bank Home Page](http://www.demo.guru99.com/V4/)
The following test case needs to be automated -

![test_scenario_v1](https://github.com/tsokomalusi/Bank-Project/blob/master/resources/images/test_scenario_v1.png)

The client has requested you to use WebDriver (Firefox Driver) for the project. Go ahead and record the script in Webdriver.

## Day 2: Enhancements in Script

Hey there,

There is a major flaw in the test case we created. There is no verification step.The script is no-good if it cannot produce Pass & Fail Status. 
Go ahead and modify the script

![test_scenario_v2](https://github.com/tsokomalusi/Bank-Project/blob/master/resources/images/test_scenario_v2.png)

## Day 3: Parameterizing the Script

Hi Fellow Geek,
 
The client has enhanced the test scenario to include more test cases

![test_scenario_v3](https://github.com/tsokomalusi/Bank-Project/blob/master/resources/images/test_scenario_v3.png)

One approach to automate this is to record separate script for all the above test cases. But this defeats the very purpose of automation.
 
The best technique to automate the above test suite  is to parametrize the script.
The most famous tool store data for parametrization is MS Excel.
 
Go ahead and create a script to read test-data from an Excel and execute Webdriver test cases.
 
Regards
Team Guru99

## Day 4: Introducing TestNG

Hi,
 
The client is happy with the work you have been doing so far, but he is not happy with the Test Results generated. The test results are not user friendly.
He wants you to use TestNg which has better Test reporting format. 
Go ahead and create the same script using TestNg.  
Happy Testing
Team Guru99

## Day 5: Getting started with dynamic text

Hey QA Ninja,

By now you must have realized that using Selenium is not easy. but , hey its free J
The client now wants you to make 2 changes
1.	 Instead of Excel he wants you to use Data Provider annotation of Testing
2.	Post login , a message "Welcome <manager id> " is shown. The client wants you to validate this

![test_scenario_v4](https://github.com/tsokomalusi/Bank-Project/blob/master/resources/images/test_scenario_v4.png)

But the text "Welcome <manager id> " is dynamic and will change from a userid to another. Time to do some pondering J Go ahead and code this

Happy coding
Team Guru99



