name := "scala-multi-project-template"


import Dependencies.Versions


lazy val commonSettings = Seq(
  organization := "io.github.Jacobbishopxy",
  scalaVersion := "2.13.1",
  Dependencies.commons
)

lazy val rootSetting = Seq(
  version := "0.1"
)

lazy val coreSetting = Seq(
  version := "0.1"
)

lazy val utilSetting = Seq(
  version := "0.1"
)

lazy val commonsSetting = Seq(
  version := "0.1"
)


lazy val root = Project(id = "mpt", base = file("."))
  .settings(commonSettings, rootSetting)
  .aggregate(core, util, commons)

lazy val core = Project(id = "mpt-core", base = file("mpt-core"))
  .settings(commonSettings, coreSetting, Dependencies.core)
  .dependsOn(commons, util)

lazy val util = Project(id = "mpt-util", base = file("mpt-util"))
  .settings(commonSettings, utilSetting, Dependencies.util)
  .dependsOn(commons)


lazy val commons = Project(id = "mpt-common", base = file("mpt-common"))
  .settings(commonSettings, commonsSetting, Dependencies.common)


javacOptions ++= Seq("-encoding", "UTF-8")
javaOptions in run += "-Xmx1G"

