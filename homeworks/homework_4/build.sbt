name := "Homework_4"

version := "0.1"

scalaVersion := "2.12.1"

resolvers += "maven_ _main" at "https://repo.maven.apache.org/maven2"

testFrameworks += new TestFramework("utest.runner.Framework")

//libraryDependencies += "com.lihaoyi" % "utest_2.13" % "0.6.9" % "test"
libraryDependencies += "com.lihaoyi" % "utest_2.12" % "0.5.3" % "test"

