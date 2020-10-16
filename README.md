# firebase-token-mcve

MCVE to reproduce 401/UNAUTHENTICATED error on Firebase API

This code will work with valid `deviceToken`, `projectUrl` and `serviceAccountKey.json`.
When token is a 'bad' token, it will result in the following error:
```
com.google.firebase.messaging.FirebaseMessagingException: Unexpected HTTP response with status: 401
null
     at com.google.firebase.messaging.FirebaseMessagingException.withMessagingErrorCode(FirebaseMessagingException.java:47)
...
```

This was [rejected as being an error in the Firebase Admin SDK](https://github.com/firebase/firebase-admin-java/issues/486)

# How to run
* Replace `<device-token>` and `<project-url>`
* Add `src/main/resources/serviceAccountKey.json`
* Execute `sbt run`