// see https://github.com/siasia/xsbt-web-plugin for more information on the
// jetty plugin

organization  := "au.com.jaylin"

name := "spray-test"

version := "1.0"

scalaVersion := "2.10.3"

resolvers ++= Seq(
  "spray repo" at "http://repo.spray.io/"
)

// import web settings
seq(webSettings :_*)

port in container.Configuration := 8081

//libraryDependencies ++= Seq(
  // libraries for Jetty Container:
  //"org.eclipse.jetty" % "jetty-webapp" % "9.1.0.v20131115" % "container",
  //"javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided"
  //
  // libraries for Tomcat container:
//  "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided",
//  "org.apache.tomcat.embed"% "tomcat-embed-core"% "7.0.40"% "container",
//  "org.apache.tomcat.embed"% "tomcat-embed-logging-juli"% "7.0.40"% "container",
//  "org.apache.tomcat.embed"% "tomcat-embed-jasper"% "7.0.40"% "container"
//)

libraryDependencies ++= {
  val akkaV = "2.2.3"
  val sprayV = "1.2-RC4"
  Seq(
    "io.spray"            		%   "spray-servlet" 			% sprayV,
    "io.spray"            		%   "spray-routing" 			% sprayV,
    "io.spray"            		%   "spray-testkit" 			% sprayV,
    "io.spray"                  %%  "spray-json"         		% "1.2.5",
    "javax.servlet" 			% 	"javax.servlet-api" 		% "3.1.0" 	% "provided",
    "org.apache.tomcat.embed" 	% 	"tomcat-embed-core"			% "7.0.40" 	% "container",
    "org.apache.tomcat.embed" 	% 	"tomcat-embed-logging-juli" % "7.0.40" 	% "container",
    "org.apache.tomcat.embed" 	% 	"tomcat-embed-jasper" 		% "7.0.40" 	% "container",
    "com.typesafe.akka"   		%%  "akka-actor"    			% akkaV,
    "com.typesafe.akka"   		%%  "akka-testkit"  			% akkaV,
    "org.specs2"          		%%  "specs2"        			% "2.2.3" 	% "test"
  )
}
