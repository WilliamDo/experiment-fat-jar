ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.7"

lazy val root = (project in file("."))
  .settings(
    name := "fat-jar-sbt",
    idePackagePrefix := Some("com.ultimaspin.experiment.fatjarsbt")
  )

libraryDependencies += "com.amazonaws" % "aws-java-sdk-s3" % "1.12.136"
libraryDependencies += "com.amazonaws" % "aws-java-sdk-sqs" % "1.12.136"

ThisBuild / assemblyMergeStrategy := {
  case PathList(ps @ _*) if ps.last endsWith "module-info.class" => MergeStrategy.discard
  case x =>
    val oldStrategy = (ThisBuild / assemblyMergeStrategy).value
    oldStrategy(x)
}