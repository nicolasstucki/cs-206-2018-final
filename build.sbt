val dottyVersion = "0.24.0-RC1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "dotty-simple",
    version := "0.1.0",

    scalaVersion := dottyVersion,

    scalacOptions ++= Seq("-language:implicitConversions"),

    // Contains Spark 3 snapshot built against 2.13: https://github.com/smarter/spark/tree/scala-2.13
    resolvers += Resolver.bintrayRepo("smarter", "maven"),

    libraryDependencies ++= Seq(
      "com.novocode" % "junit-interface" % "0.11" % Test,
      ("org.apache.spark" %% "spark-core" % "3.0.0-X1").withDottyCompat(scalaVersion.value),
    ),
    
    // Without forking, ctrl-c doesn't actually fully stop Spark
    fork in run := true,
    fork in Test := true
)
