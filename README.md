
# Introduction App

This is an Android application that introduces. It includes a photo, name, contact number, email address, and a simple text describing the person. The application has a clean and user-friendly design with the ability to scroll through the content.

## Features

- Circular profile image displayed at the top left corner
- Name, call button, and email button aligned next to the profile image
- Call button redirects to the Android contact page to initiate a call
- Email button opens the default email app on the device
- Introduction text section below the profile information
- Welcome toast message displayed on app launch

![Overview Picture](./READMEIMAGE.jpg)


## Prerequisites

- Android Studio installed

## Getting Started

2. Open the project in Android Studio.
3. Build and run the application on an Android device or emulator.

## Customization

- Profile Image: Replace the `profile_picture.jpg` file in the `res/drawable` folder with the desired circular profile image.
- Contact Information: Update the contact number and email address in the `callButton` and `emailButton` click listeners in `MainActivity.java`.
- Introduction Text: Modify the content of the `aboutme.txt` file located in the `assets` folder to change the introduction text.

## Dependencies

This application does not have any additional dependencies. It utilizes the standard Android framework components.


