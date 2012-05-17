resolvers += Resolver.url("scalasbt releases", new URL("http://scalasbt.artifactoryonline.com/scalasbt/sbt-plugin-releases"))(Resolver.ivyStylePatterns)

resolvers += "jgit-repo" at "http://download.eclipse.org/jgit/maven"

libraryDependencies ++= Seq(
  "org.jacoco" % "org.jacoco.core" % "0.5.7.201204190339" artifacts(Artifact("org.jacoco.core", "jar", "jar")),
  "org.jacoco" % "org.jacoco.report" % "0.5.7.201204190339" artifacts(Artifact("org.jacoco.report", "jar", "jar"))
)

addSbtPlugin("com.jsuereth" % "sbt-ghpages-plugin" % "0.4.0")

addSbtPlugin("de.johoop" % "jacoco4sbt" % "1.2.3")

addSbtPlugin("org.scala-sbt" % "sbt-android-plugin" % "0.6.1")