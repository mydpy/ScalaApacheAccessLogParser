lazy val root = (project in file(".")).
  settings(
    name := "ScalaApacheAccessLogParser",
    version := "1.0",
    scalaVersion := "2.11.0",
    resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
    scalacOptions += "-deprecation",
    mainClass in Compile := Some("com.alvinalexander.accesslogparser.AccessLogParser")        
  )

libraryDependencies ++= Seq(
  //"org.apache.spark" %% "spark-core" % "1.2.0" % "provided",
  //"org.apache.spark" %% "spark-streaming" % "1.2.0" % "provided",
  //"org.apache.spark" % "spark-streaming-twitter_2.10" % "1.2.0"
  "org.scalatest" % "scalatest_2.11" % "3.0.0" % "test"
)

// META-INF discarding
mergeStrategy in assembly <<= (mergeStrategy in assembly) { (old) =>
   {
    case PathList("META-INF", xs @ _*) => MergeStrategy.discard
    case x => MergeStrategy.first
   }
}

