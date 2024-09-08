# Mental Health Care App

## Overview
The **Mental Health Care App** is an Android application developed using **Kotlin** and **Java** for managing and improving users' mental well-being. The app monitors signs of depression and provides a holistic set of features designed to support mental health. Users are guided through personalized tasks, medical reports, yoga and exercise suggestions, as well as online resources like a music player and consultation with a doctor. Firebase serves as the backend database, offering real-time updates, storage, and authentication.

## Features
1. **Depression Monitoring**
   - Users' mood and mental health conditions are regularly monitored through self-assessment questionnaires and interactions.
   - Automatic depression scoring based on user input.
   - Mood history tracking to identify trends and progress over time.

2. **Task Suggestions**
   - Daily personalized tasks to boost mental well-being, such as mindfulness exercises, gratitude journaling, and self-care prompts.
   - Yoga and exercise routines tailored to reduce anxiety and promote calmness.

3. **Medical Reports**
   - Auto-generated mental health reports based on user data.
   - Detailed insight into mental health progression and suggestions for improvement.
   - Exportable reports for consultation with mental health professionals.

4. **Yoga & Exercise Suggestions**
   - A curated list of yoga poses and exercise routines designed to reduce stress and anxiety.
   - Tutorials and step-by-step guides for physical activities aimed at mental health improvement.

5. **Online Music Player**
   - A built-in music player offering a wide selection of calming and soothing tracks to enhance relaxation.
   - Predefined playlists based on different moods and needs (e.g., focus, relaxation, sleep).

6. **Doctor Consultation**
   - In-app scheduling for online consultations with certified mental health professionals.
   - Secure messaging feature for follow-up queries and assistance.

7. **Notifications**
   - Regular reminders every 15 days to prompt users to update their mood and self-assessment.
   - Encourages continuous monitoring and proactive care of mental well-being.

8. **Tourist Place Suggestions**
   - Recommendations of peaceful and rejuvenating tourist spots for mental refreshment and breaks from stressful environments.
   - Dynamic suggestions based on user preferences and location.

## Technology Stack
- **Frontend**: Kotlin (UI, Logic)
- **Backend**: Firebase Realtime Database for storing user data, tasks, and reports.
  - Firebase Authentication: Handles user sign-up/sign-in (email, Google, or phone number).
  - Firebase Storage: Stores files like medical reports, user profile images, and music files.
  - Firebase Cloud Messaging (FCM): Sends reminders and notifications every 15 days.
  
- **Third-Party Libraries**:
  - **Picasso**: For loading images.
  - **ExoPlayer**: For playing music tracks within the app.


## Future Aspects and Development Plans
- **AI-based Mental Health Insights**: Integrate AI to analyze user data more effectively and offer deeper insights into their mental health.
- **Mood Tracking Analytics**: Graphical analysis of mood data over weeks/months, helping users track mental health patterns.
- **Community Support**: Create forums or discussion boards where users can share experiences and support each other.
- **Teletherapy Sessions**: Allow users to book therapy sessions with licensed professionals.
- **Personalized Tourist Recommendations**: Use AI to provide more tailored suggestions for nearby calming tourist spots.
- **Wearable Integration**: Monitor vital signs (e.g., heart rate, sleep patterns) through wearable devices and correlate them with mental health data.

