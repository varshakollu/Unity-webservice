<!DOCTYPE html>
<html lang="en">
<body>
<h1 align="center">REST based webservice</h1>
<p>In order to build the webservice, I used  Jersey RESTful Web Services framework. 
As I used Maven project, there is no need to download any additional libraries. Just adding the dependencies to pom.xml is enough to run the application.
</p>
<p>
The REST API's implemented in this project are:
<br>
1. <b>webapi/createProject</b> - This accepts POST request with the following parameters: 
</p>
<pre>
{  
    "id": 1,  
    "projectName": "test project number 1",  
    "creationDate": "05112017 00:00:00",  
    "expiryDate ": "05202017 00:00:00",  
    "enabled": true,   
    "targetCountries": ["USA", "CANADA", "MEXICO", "BRAZIL"],  
    "projectCost": 5.5,  
    "projectUrl": "http://www.unity3d.com",  
    "targetKeys": [{  
            "number": 25,  
            "keyword": "movie"  
        },  
        {  
            "number": 30,  
            "keyword": "sports"  
        }]  
} 
</pre>
<p>
2. <b>webapi/requestProject </b> - This accepts GET request with the following parameters (parameters are optional):
</p>
<pre>
* ProjectID(int)
* Country(String)
* Number(int)
* Keyword(String)
</pre>
<p>In order to test these API, I used TestNG and REST Assured framework. The test scripts are included in the application. </p>
</body>
</html>
