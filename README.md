JalSanchayTracker

JalSanchayTracker is an Android application designed to help households monitor and manage rainwater harvesting efficiently. The app calculates water savings based on rainfall and roof area, helping users understand their contribution toward water conservation.


---

Problem Statement

Many households have rainwater harvesting systems but lack a proper way to measure their effectiveness. Without data and tracking, water conservation becomes difficult to visualize and maintain consistently.


---

Solution

JalSanchayTracker transforms rainwater harvesting into a measurable and interactive experience by allowing users to:

Track rainfall data

Calculate water collected

Monitor tank levels

View total water savings

Learn water conservation practices


The app promotes sustainable living and responsible water usage.


---

Features

Rainfall Data Entry

Water Savings Calculator

Animated Water Tank Visualization

Monthly Water Saving Reports

Historical Data Tracking

Water Conservation Tips

Offline Data Storage

Kannada & English Support

Smooth and Modern UI



---

Tech Stack

Kotlin

Android Studio

Room Database

RecyclerView

MPAndroidChart

Material Design

MVVM Architecture



---

App Modules

Splash Screen

Displays app logo and transitions to the dashboard.

Setup Screen

Users enter:

Roof Area

Tank Capacity

Runoff Coefficient


Dashboard

Shows:

Liters Saved Today

Total Water Saved

Tank Fill Percentage

Household Water Days


Rainfall Entry

Users can manually enter rainfall data and instantly calculate water savings.

History Screen

Displays historical rainfall and water collection records.

Reports Screen

Generates monthly charts and water-saving statistics.

Tips Section

Provides water conservation and rainwater harvesting tips.


---

Formula Used

Water Saved Calculation:

Water Saved = Area × Rainfall × 0.0929 × Runoff Coefficient


---

Database Structure

RainfallHistory

id

rainfallMM

litersSaved

date


UserSetup

roofArea

tankCapacity

runoffCoefficient



---

Installation & Setup

Prerequisites

Install:

Android Studio

JDK 17 or latest

Android SDK



---

Clone Repository

git clone https://github.com/dapavan71/JalSanchayTracker.git


---

Open Project

1. Open Android Studio


2. Click Open


3. Select project folder


4. Wait for Gradle Sync




---

Run Application

Connect:

Android Emulator OR

Physical Android device


Click:

Run ▶

Shortcut:

Shift + F10


---

Dependencies Used

Room Database

RecyclerView

MPAndroidChart

Material Components

ViewBinding



---

Future Enhancements

AI-based Water Usage Prediction

Live Weather API Integration

Smart Notifications

Voice Assistant Support

Cloud Backup



---

Impact Goals

Water Conservation Awareness

Sustainable Resource Management

Household Water Monitoring

Environmental Responsibility



---

Developed Using

Android Studio + Kotlin + Room Database


---

Author

Developed as part of Android App Development using GenAI Internship Project.
