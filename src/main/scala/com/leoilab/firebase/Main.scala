package com.leoilab.firebase

import java.io.{File, FileInputStream}

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.messaging.{FirebaseMessaging, FirebaseMessagingException, Message, Notification}
import com.google.firebase.{FirebaseApp, FirebaseOptions}

object Main extends App {
  val deviceToken = "<device-token>"
  val projectUrl  = "<project-url>"

  val configFile = new FileInputStream(new File("src/main/resources/serviceAccountKey.json"))

  val options = FirebaseOptions
    .builder()
    .setCredentials(GoogleCredentials.fromStream(configFile))
    .setDatabaseUrl(projectUrl)
    .build()

  FirebaseApp.initializeApp(options)

  val message = Message
    .builder()
    .setToken(deviceToken)
    .setNotification(Notification.builder().setBody("test").build())
    .build()

  try {
    FirebaseMessaging.getInstance().send(message)

  } catch {
    case fme: FirebaseMessagingException =>
      println(s"""
                 |Platform error code: ${fme.getErrorCode}
                 |Service error code: ${fme.getMessagingErrorCode}
                 |HttpResponseCode code: ${fme.getHttpResponse.getStatusCode}
                 |""".stripMargin)
      throw fme
  }
}
