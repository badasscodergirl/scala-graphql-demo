name := """scala-graphql-demo"""
organization := "com.badasscodergirl"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.8"
val playVersion = "2.7.0"

libraryDependencies ++= Seq(
  guice,
  "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.1" % Test withSources(),

  "org.postgresql" % "postgresql" % "42.2.5",

  "com.typesafe.slick" %% "slick" % "3.2.3" withSources(),
  "com.typesafe.play" %% "play-slick" % "3.0.0" withSources() withJavadoc(),

  "com.typesafe.play" %% "play-json" % playVersion withSources()

  //"org.sangria-graphql" %% "sangria" % "1.4.2" withSources()
)


scalacOptions ++= Seq(
  //"-Xfatal-warnings",
  //"-deprecation",
  //"-unchecked",
  //"-feature",
  "-Xlint"
)
