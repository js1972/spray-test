spray-test
==========

Test web app using Scala + Spray

This app show the basics of how to create a Servlet 3 app in Scala using Spray (http://spray.io/). It is managed with SBT and can be run locally using:
container:start

Once started you can access it via:
http://localhost:8081/spray-test_2.10-1.0/
Where 8081 is your chosen port; spray-test_2.10-1.0 is the application name (defined in application.conf as the root url or the war filename); and note the required trailing slash (need to work out why?). 
Also = https://spraytestp1081110trial.hanatrial.ondemand.com/spray-test_2.10-1.0/json when deployed on neo! Json is just an alternative route.
