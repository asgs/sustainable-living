# About

This is an attempt to simulate a sustainable home solution relating to usage of resources like Water, Gas, Electric Power, etc.,

# Goals

* Track Energy consumption of various sources and the time frame during which it's captured at.
* Allow users to set goals on the consumption
* Based on the set goals, provide projects on the possible usages that will result in, ahead of time.
* Provide suggestions on goals (from templates or historical data) that users could pick up from.
* Ranking - reward users who meet their goals with badges, etc.,

# Assumptions

* This is a going to be a Java-based application with no frontend.
* It may be a simple console-based app or a simple REST-backed webservice.
* There's no user authentication involved here. Inputs will probably be their userId, homeId, resourceIds, etc.,

# High-Level Design

The following are the main actors involved in this app.

* User - The end users who want to track their energy consumption and sustainability goals.
* Home - The house users own and which will have the Resources to maintain the sustainability with. 
* Resource (e.g., LPG, Power, Water, Fuel, etc.,) - Its common properties are type, Price, amountConsumed and any other additional attributes that may be required to track at a later time.
* SustainabilityGoal - Represents rules/conditions to achieve a goal with respect to resource consumption/saving. Its common properties are which resource it's targeted at, alternateResourceToUse and its amount, cutDownUsageByXAmount, timeToShiftUsage
* Saving - Based on the Resources available and Goals set (above), calculate the Savings that could be achieved for given time frames.
* SuggestedGoal - Goals that the app could suggest the users.
* Reward - Represents the Rewards the users will gain for meeting their goals. Some rewards are SustainabilityScore, BadgesAchieved, Incentives.

# Use Cases

* A new user could register their details, their home details with our database. No password protection involved.
* Existing users could track their home energy consumption based on the given time frame.
* Users can set goals and see where they stand; and whether they have earned any rewards.

