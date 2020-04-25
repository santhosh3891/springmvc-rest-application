# springmvc-rest-application
   * This rest application is used to expose two end points (i.e.) `/api/getproductdetails` and `/api/getconfigdetails`. 
   * This project is built using,
        * 5.0.0.RELEASE of Spring MVC, Spring Core and Spring security,
        * 2.9.4 version of jackson library,
        * Java 12
        * Maven 3.8.0
   * pom.xml of this application will create a WAR file. Use `mvn clean install` command to create WAR file from source directory. Copy the war from `springmvc-rest-application/target` folder and place the war file in `webapps` folder of tomcat server before starting it. 

Please see to pom.xml for more details about dependencies.

# Demo
Upon successful server start-up, use "domain name + end point" path to hit the service. For example,
   * Domain name - http://localhost:8080/springmvc-rest-application
   * End points - /api/getproductdetails or /api/getconfigdetails

So the URL to access the end points are `http://localhost:8080/springmvc-rest-application/api/getproductdetails` and `http://localhost:8080/springmvc-rest-application/api/getconfigdetails`.

Basic authentication is enabled for the endpoints. Along with the URL, need to send crendentials as a basic authentication. I have hardcoded two user credentials for the two endpoints separately. 
   * To access `http://localhost:8080/springmvc-rest-application/api/getproductdetails`, use `bill/abc123`.
   * To access `http://localhost:8080/springmvc-rest-application/api/getconfigdetails`, use `tom/abc123`
   
 Response will be returned in JSON format. Static output for `/api/getproductdetails` is,
 
 {
  "products": [
    {
      "productId": 5,
      "productName": "Dell",
      "productDescription": "Dell Portable Computer",
      "productAmount": 80000
    },
    {
      "productId": 7,
      "productName": "HP",
      "productDescription": "HP Portable Computer",
      "productAmount": 76000
    }
  ]
}
 
 Static output for `/api/getconfigdetails` is,
 
 {
  "configurations": [
    {
      "configId": 6,
      "configName": "System Config",
      "configDescription": "Configuration for system"
    },
    {
      "configId": 8,
      "configName": "Laptop Config",
      "configDescription": "Configuration for Laptop"
    }
  ]
}
